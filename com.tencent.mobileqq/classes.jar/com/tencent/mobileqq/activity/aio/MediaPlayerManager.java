package com.tencent.mobileqq.activity.aio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Media;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceHelper;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerHelper;
import com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService;
import com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XBaseAdapter;
import com.tencent.widget.XListView;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.util.WeakReference;

public class MediaPlayerManager
  extends BroadcastReceiver
  implements AudioPlayerBase.AudioPlayerListener, Manager
{
  boolean a = false;
  private Handler b = new Handler(Looper.getMainLooper());
  private WeakReference<QQAppInterface> c;
  private ChatMessage d;
  private boolean e;
  private XListView f;
  private MediaPlayerManager.Listener g;
  private XBaseAdapter h;
  private MediaPlayerManager.Callback i;
  private ChatMessage j;
  private ChatMessage k;
  private ChatMessage l;
  private CommonAudioPlayer m;
  private boolean n;
  private boolean o;
  private boolean p = false;
  private MediaPlayer.OnCompletionListener q = new MediaPlayerManager.3(this);
  private boolean r;
  
  public MediaPlayerManager(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    this.m = new CommonAudioPlayer(localBaseApplication, this);
    this.m.s();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localBaseApplication.registerReceiver(this, localIntentFilter);
    a(paramQQAppInterface);
    ((IAudioDeviceService)paramQQAppInterface.getRuntimeService(IAudioDeviceService.class)).registerAudioDeviceListener(this.m);
    if (Build.MODEL == "PCCM00") {
      AudioPlayerHelper.a = 0;
    }
  }
  
  public static int a(ChatMessage paramChatMessage, XBaseAdapter paramXBaseAdapter)
  {
    int i1 = UinTypeUtil.e(paramChatMessage.istroop);
    int i2 = 0;
    if (i1 == 1032) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (paramXBaseAdapter != null) {
      while (i2 < paramXBaseAdapter.getCount())
      {
        Object localObject = paramXBaseAdapter.getItem(i2);
        if (localObject != null) {
          if ((localObject instanceof ChatMessage))
          {
            if (((ChatMessage)localObject).uniseq == paramChatMessage.uniseq) {
              return i2;
            }
          }
          else if ((localObject instanceof RecentBaseData))
          {
            localObject = (RecentBaseData)localObject;
            if ((i1 != 0) && (((RecentBaseData)localObject).getRecentUserType() == 1032) && (((RecentBaseData)localObject).getRecentUserUin().equals(AppConstants.CONFESS_UIN))) {
              return i2;
            }
            if ((paramChatMessage.frienduin.equals(((RecentBaseData)localObject).getRecentUserUin())) && (paramChatMessage.istroop == ((RecentBaseData)localObject).getRecentUserType())) {
              return i2;
            }
          }
        }
        i2 += 1;
      }
    }
    return -1;
  }
  
  public static MediaPlayerManager a(AppRuntime paramAppRuntime)
  {
    try
    {
      paramAppRuntime = (MediaPlayerManager)paramAppRuntime.getManager(QQManagerFactory.MGR_MEDIA_PLAYER);
      return paramAppRuntime;
    }
    finally
    {
      paramAppRuntime = finally;
      throw paramAppRuntime;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("$bindApp, app = ");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      QLog.d("MediaPlayerManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if ((localObject != null) && (((WeakReference)localObject).get() == paramQQAppInterface)) {
      return;
    }
    localObject = this.c;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      a();
    }
    this.c = new WeakReference(paramQQAppInterface);
    AudioPlayerHelper.a(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCAccountNames.qq_audio_play_fix.name(), null));
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.m.d();
      if ((this.p) || ((this.d != null) && (this.h != null))) {
        b(paramBoolean1, paramBoolean2);
      }
      this.d = null;
    }
    else
    {
      ChatMessage localChatMessage;
      if (this.h != null)
      {
        localChatMessage = this.d;
        if (localChatMessage != null)
        {
          if (c(localChatMessage).b(this.d))
          {
            this.m.d();
            b(paramBoolean1, paramBoolean2);
            this.d = null;
            break label179;
          }
          return false;
        }
      }
      if (this.h == null)
      {
        localChatMessage = this.d;
        if (localChatMessage != null)
        {
          MediaPlayerManager.Callback localCallback = this.i;
          boolean bool;
          if (localCallback != null) {
            bool = localCallback.b(localChatMessage);
          } else {
            bool = false;
          }
          if (bool)
          {
            this.m.d();
            b(paramBoolean1, paramBoolean2);
            this.d = null;
          }
          else
          {
            return false;
          }
        }
      }
    }
    label179:
    return true;
  }
  
  private int b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.p)
    {
      int i1 = a(this.d, this.h);
      b(this.d);
      a(this.d, this.k);
      if (i1 >= 0)
      {
        localObject = this.f;
        localObject = AIOUtils.a((ListView)localObject, ((XListView)localObject).getHeaderViewsCount() + i1);
        c(this.d).a(this.f, i1, (View)localObject, this.d, paramBoolean2);
      }
      return i1;
    }
    Object localObject = this.i;
    if (localObject != null) {
      ((MediaPlayerManager.Callback)localObject).a(null, 0, null, this.d, paramBoolean2);
    }
    return 0;
  }
  
  private ChatMessage b(int paramInt)
  {
    Object localObject = this.h.getItem(paramInt);
    if ((localObject != null) && ((localObject instanceof ChatMessage))) {
      return (ChatMessage)localObject;
    }
    return null;
  }
  
  private MediaPlayerManager.Callback c(ChatMessage paramChatMessage)
  {
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeAdapterIsGuildPieAdapter(this.h)) {
      return (MediaPlayerManager.Callback)((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildPieAdapterCallback(paramChatMessage, this.h);
    }
    XBaseAdapter localXBaseAdapter = this.h;
    if ((localXBaseAdapter instanceof ChatAdapter1)) {
      return (MediaPlayerManager.Callback)((ChatAdapter1)localXBaseAdapter).c.a(paramChatMessage, this.h);
    }
    return this.i;
  }
  
  private boolean j()
  {
    Object localObject1 = this.d;
    Object localObject3;
    int i1;
    float f1;
    boolean bool1;
    int i3;
    ChatMessage localChatMessage;
    if (localObject1 != null)
    {
      localObject3 = this.h;
      if (localObject3 != null)
      {
        i1 = a((ChatMessage)localObject1, (XBaseAdapter)localObject3);
        int i4 = this.h.getCount();
        if (i1 <= i4)
        {
          f1 = SonicHelper.a;
          localObject1 = this.d;
          if ((localObject1 instanceof MessageForPtt))
          {
            bool1 = SonicHelper.a(((MessageForPtt)localObject1).playSpeedPos);
            if (bool1) {
              f1 = ((MessageForPtt)this.d).playSpeedPos;
            }
            ((MessageForPtt)this.d).playSpeedPos = SonicHelper.a;
          }
          else
          {
            bool1 = false;
          }
          localObject1 = this.f;
          localObject1 = AIOUtils.a((ListView)localObject1, ((XListView)localObject1).getHeaderViewsCount() + i1);
          if (i1 >= 0) {
            c(this.d).a(this.f, i1, (View)localObject1, this.d, true);
          }
          if (this.e) {
            if (i1 < i4 - 1)
            {
              i3 = i1 + 1;
              localChatMessage = b(i3);
              localObject3 = localObject1;
              if ((localChatMessage instanceof Media))
              {
                if ((this.r) && (localObject1 != null)) {
                  i1 = 1;
                } else {
                  i1 = 0;
                }
                localObject1 = this.f;
                localObject3 = AIOUtils.a((ListView)localObject1, ((XListView)localObject1).getHeaderViewsCount() + i3);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = c(localChatMessage);
        boolean bool2 = ((MediaPlayerManager.Callback)localObject1).a(this.f, i3, (View)localObject3, localChatMessage);
        if ((bool2) && (bool1) && ((localChatMessage instanceof MessageForPtt)))
        {
          ((MessageForPtt)localChatMessage).playSpeedPos = f1;
          a(f1);
          if (this.m != null) {
            this.m.a(((MessageForPtt)localChatMessage).msgTime);
          }
        }
        if ((!bool2) || (!((MediaPlayerManager.Callback)localObject1).a(this.f, i3, (View)localObject3, localChatMessage, this.m, 0))) {
          break label425;
        }
        i2 = 1;
        if (i2 != 0)
        {
          this.d = localChatMessage;
          if (i1 != 0) {
            this.f.smoothScrollToPosition(this.f.getHeaderViewsCount() + i3);
          }
          return true;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MediaPlayerManager", 2, "playNext", localException);
        }
      }
      i1 = i3;
      Object localObject2 = localObject3;
      break;
      this.d = null;
      return false;
      label425:
      int i2 = 0;
    }
  }
  
  public void a()
  {
    try
    {
      a(true);
      a(this.f);
      if ((this.c != null) && (this.c.get() != null)) {
        ((QQAppInterface)this.c.get()).getApp().unregisterReceiver(this);
      }
      this.c = null;
      if (QLog.isColorLevel())
      {
        QLog.d("MediaPlayerManager", 2, "$unBindApp");
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MediaPlayerManager", 2, "", localException);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    CommonAudioPlayer localCommonAudioPlayer = this.m;
    if (localCommonAudioPlayer != null) {
      localCommonAudioPlayer.a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      if (this.f == null) {
        return;
      }
      int i2 = ((XBaseAdapter)localObject).getCount();
      int i1 = 0;
      while (i1 < i2)
      {
        if (paramInt != i1)
        {
          localObject = b(i1);
          PttAudioWaveView localPttAudioWaveView;
          if ((localObject instanceof MessageForPtt))
          {
            localObject = (MessageForPtt)localObject;
            ((MessageForPtt)localObject).playProgress = 0.0F;
            ((MessageForPtt)localObject).playSpeedPos = SonicHelper.a;
            localObject = this.f;
            localObject = AIOUtils.a((ListView)localObject, ((XListView)localObject).getHeaderViewsCount() + i1);
            if (localObject != null)
            {
              localPttAudioWaveView = (PttAudioWaveView)((View)localObject).findViewById(2131442196);
              if (localPttAudioWaveView != null)
              {
                localPttAudioWaveView.setProgress(0.0F);
                localPttAudioWaveView.setCanSupportSlide(false);
              }
              localObject = (PttAudioPlayView)((View)localObject).findViewById(2131442195);
              if (localObject != null) {
                ((PttAudioPlayView)localObject).setPlayState(false);
              }
            }
          }
          else if ((localObject instanceof MessageForMarketFace))
          {
            localObject = (MessageForMarketFace)localObject;
            if (((MessageForMarketFace)localObject).isNewSoundType())
            {
              ((MessageForMarketFace)localObject).playProgress = 0.0F;
              localObject = this.f;
              localObject = AIOUtils.a((ListView)localObject, ((XListView)localObject).getHeaderViewsCount() + i1);
              if (localObject != null)
              {
                localPttAudioWaveView = (PttAudioWaveView)((View)localObject).findViewById(2131439265);
                if (localPttAudioWaveView != null) {
                  localPttAudioWaveView.setProgress(0.0F);
                }
                localObject = (PttAudioPlayView)((View)localObject).findViewById(2131439264);
                if (localObject != null) {
                  ((PttAudioPlayView)localObject).setPlayState(false);
                }
              }
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  public void a(MediaPlayerManager.Listener paramListener, MediaPlayerManager.Callback paramCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindUI, listener = ");
      ((StringBuilder)localObject).append(paramListener);
      ((StringBuilder)localObject).append(" ,callBack = ");
      ((StringBuilder)localObject).append(paramCallback);
      QLog.i("MediaPlayerManager", 2, ((StringBuilder)localObject).toString());
    }
    this.g = paramListener;
    Object localObject = this.m;
    if (localObject != null) {
      ((CommonAudioPlayer)localObject).a(paramListener);
    }
    this.i = paramCallback;
    this.p = true;
  }
  
  public void a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (((paramChatMessage1 instanceof MessageForPtt)) && ((paramChatMessage2 instanceof MessageForPtt)) && (!paramChatMessage1.equals(paramChatMessage2))) {
      ((MessageForPtt)paramChatMessage1).playSpeedPos = SonicHelper.a;
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    ThreadManager.excute(new MediaPlayerManager.2(this), 16, null, false);
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (this.d != null) {
        b(true, true);
      }
      paramAudioPlayerBase = this.g;
      if (paramAudioPlayerBase != null) {
        paramAudioPlayerBase.a(paramInt);
      }
    }
    else
    {
      this.b.post(new MediaPlayerManager.4(this, paramAudioPlayerBase, paramInt));
    }
  }
  
  public void a(XListView paramXListView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "unBindUI");
    }
    XListView localXListView = this.f;
    if ((localXListView != null) && (localXListView == paramXListView))
    {
      this.f = null;
      this.h = null;
      this.g = null;
      paramXListView = this.m;
      if (paramXListView != null) {
        paramXListView.a(null);
      }
      this.i = null;
      this.e = false;
      this.r = false;
    }
  }
  
  public void a(XListView paramXListView, XBaseAdapter paramXBaseAdapter, MediaPlayerManager.Listener paramListener)
  {
    a(paramXListView, paramXBaseAdapter, paramListener, null, true, true);
  }
  
  public void a(XListView paramXListView, XBaseAdapter paramXBaseAdapter, MediaPlayerManager.Listener paramListener, MediaPlayerManager.Callback paramCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bindUI, mListView = ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" ,listView = ");
      localStringBuilder.append(paramXListView);
      localStringBuilder.append(" ,adapter = ");
      localStringBuilder.append(paramXBaseAdapter);
      localStringBuilder.append(", listener = ");
      localStringBuilder.append(paramListener);
      QLog.i("MediaPlayerManager", 2, localStringBuilder.toString());
    }
    this.f = paramXListView;
    this.h = paramXBaseAdapter;
    this.g = paramListener;
    paramXListView = this.m;
    if (paramXListView != null) {
      paramXListView.a(paramListener);
    }
    this.i = paramCallback;
    this.e = paramBoolean1;
    this.r = paramBoolean2;
    this.p = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (a(paramBoolean, false)) {
        e();
      }
    }
    else {
      this.b.post(new MediaPlayerManager.1(this, paramBoolean));
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return a(paramChatMessage, false);
  }
  
  public boolean a(ChatMessage paramChatMessage, int paramInt)
  {
    return a(paramChatMessage, false, paramInt);
  }
  
  public boolean a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    return a(paramChatMessage, paramBoolean, 0);
  }
  
  public boolean a(ChatMessage paramChatMessage, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.j;
    if ((localObject != null) && ((localObject instanceof MessageForPtt))) {
      ((MessageForPtt)localObject).playProgress = 0.0F;
    }
    ShortVideoPTVItemBuilder.a(this.f);
    a(this.l, paramChatMessage);
    this.k = paramChatMessage;
    if ((this.h != null) && (paramChatMessage != null) && (this.c != null))
    {
      if (a(false, false))
      {
        if (DeviceInfoUtil.W())
        {
          this.n = true;
        }
        else
        {
          localObject = this.c;
          if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
            this.n = AudioDeviceHelper.a((AppRuntime)this.c.get());
          }
        }
        boolean bool1 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
        boolean bool2 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
        int i1 = a(paramChatMessage, this.h);
        if (paramBoolean)
        {
          paramBoolean = false;
        }
        else
        {
          this.r = true;
          localObject = this.f;
          localObject = AIOUtils.a((ListView)localObject, ((XListView)localObject).getHeaderViewsCount() + i1);
          paramBoolean = c(paramChatMessage).a(this.f, i1, (View)localObject, paramChatMessage, this.m, paramInt);
        }
        if (paramBoolean)
        {
          this.d = paramChatMessage;
          this.a = false;
          this.k = null;
          this.l = null;
          paramChatMessage = this.g;
          if (paramChatMessage != null)
          {
            paramChatMessage.e();
            this.g.a(bool1, bool2, this.n, false);
          }
          this.o = false;
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerManager", 2, "builder play failed.");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MediaPlayerManager", 2, "doStop failed.");
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("request play failed, mAdapter = ");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append(", msg = ");
      ((StringBuilder)localObject).append(paramChatMessage);
      ((StringBuilder)localObject).append(", app = ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("MediaPlayerManager", 2, ((StringBuilder)localObject).toString());
    }
    this.k = null;
    this.l = null;
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "unBindUI");
    }
    this.g = null;
    CommonAudioPlayer localCommonAudioPlayer = this.m;
    if (localCommonAudioPlayer != null) {
      localCommonAudioPlayer.a(null);
    }
    this.i = null;
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    this.l = paramChatMessage;
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    paramAudioPlayerBase = this.g;
    if (paramAudioPlayerBase != null) {
      paramAudioPlayerBase.b(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (g())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.r = paramBoolean;
  }
  
  public boolean b(ChatMessage paramChatMessage, int paramInt)
  {
    ShortVideoPTVItemBuilder.a(this.f);
    Object localObject;
    if ((paramChatMessage != null) && (this.c != null))
    {
      if (a(false, false))
      {
        if (DeviceInfoUtil.W())
        {
          this.n = true;
        }
        else
        {
          localObject = this.c;
          if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
            this.n = AudioDeviceHelper.a((AppRuntime)this.c.get());
          }
        }
        boolean bool1 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
        boolean bool2 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
        if (this.i.a(this.f, 0, null, paramChatMessage, this.m, paramInt))
        {
          this.d = paramChatMessage;
          this.a = false;
          paramChatMessage = this.g;
          if (paramChatMessage != null)
          {
            paramChatMessage.e();
            this.g.a(bool1, bool2, this.n, false);
          }
          this.o = false;
          return true;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("MediaPlayerManager", 2, "builder play failed.");
          return false;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MediaPlayerManager", 2, "doStop failed.");
        return false;
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("request play failed, mAdapter = ");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append(", msg = ");
      ((StringBuilder)localObject).append(paramChatMessage);
      ((StringBuilder)localObject).append(", app = ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("MediaPlayerManager", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public void c()
  {
    Object localObject = this.c;
    boolean bool;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      bool = AudioDeviceHelper.a((AppRuntime)this.c.get());
    } else {
      bool = true;
    }
    this.m.a(1, bool);
    if ((bool != this.n) && (g()) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("$updateSpeakPhone| speakerOn=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("MediaPlayerManager", 2, ((StringBuilder)localObject).toString());
    }
    this.n = bool;
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    this.b.post(new MediaPlayerManager.5(this, paramInt));
  }
  
  public void c(boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (a(paramBoolean, true)) {
        e();
      }
    }
    else {
      this.b.post(new MediaPlayerManager.7(this, paramBoolean));
    }
  }
  
  public void d()
  {
    ChatMessage localChatMessage = this.d;
    if (localChatMessage != null) {
      this.j = localChatMessage;
    }
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    if (this.b != null)
    {
      paramAudioPlayerBase = this.m;
      if ((paramAudioPlayerBase != null) && (paramAudioPlayerBase.m())) {
        this.b.post(new MediaPlayerManager.6(this, paramInt));
      }
    }
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaPlayerManager", 2, "$onStop");
    }
    MediaPlayerManager.Listener localListener = this.g;
    if (localListener != null) {
      localListener.f();
    }
  }
  
  public ChatMessage f()
  {
    return this.d;
  }
  
  public boolean g()
  {
    return this.d != null;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public void i()
  {
    if (!AudioDeviceHelper.b) {
      return;
    }
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    if ((AudioPlayer.c) && (localAudioManager != null) && (localAudioManager.isBluetoothScoOn()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaPlayerManager", 2, "stop sco");
      }
      localAudioManager.stopBluetoothSco();
      localAudioManager.setBluetoothScoOn(false);
      AudioPlayer.c = false;
    }
  }
  
  public void onDestroy()
  {
    i();
    a();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("tencent.av.v2q.StartVideoChat")))
    {
      boolean bool1 = paramIntent.getBooleanExtra("updateTime", false);
      boolean bool2 = paramIntent.getBooleanExtra("showTime", false);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("receive action_recv_video_request. update:");
        paramContext.append(bool1);
        paramContext.append(", show:");
        paramContext.append(bool2);
        QLog.d("MediaPlayerManager", 2, paramContext.toString());
      }
      if ((bool1) && (bool2)) {
        ChatActivityUtils.a();
      }
      a(true);
      return;
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      a(false);
      ShortVideoPTVItemBuilder.a(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */