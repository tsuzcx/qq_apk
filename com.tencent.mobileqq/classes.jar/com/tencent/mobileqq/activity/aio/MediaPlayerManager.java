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
  private MediaPlayer.OnCompletionListener jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new MediaPlayerManager.3(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private MediaPlayerManager.Callback jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Callback;
  private MediaPlayerManager.Listener jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private CommonAudioPlayer jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer;
  private XBaseAdapter jdField_a_of_type_ComTencentWidgetXBaseAdapter;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  private ChatMessage jdField_b_of_type_ComTencentMobileqqDataChatMessage;
  private boolean jdField_b_of_type_Boolean;
  private ChatMessage jdField_c_of_type_ComTencentMobileqqDataChatMessage;
  private boolean jdField_c_of_type_Boolean;
  private ChatMessage jdField_d_of_type_ComTencentMobileqqDataChatMessage;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = false;
  private boolean f;
  
  public MediaPlayerManager(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer = new CommonAudioPlayer(localBaseApplication, this);
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.l();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localBaseApplication.registerReceiver(this, localIntentFilter);
    a(paramQQAppInterface);
    ((IAudioDeviceService)paramQQAppInterface.getRuntimeService(IAudioDeviceService.class)).registerAudioDeviceListener(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer);
    if (Build.MODEL == "PCCM00") {
      AudioPlayerHelper.a = 0;
    }
  }
  
  public static int a(ChatMessage paramChatMessage, XBaseAdapter paramXBaseAdapter)
  {
    int i = UinTypeUtil.a(paramChatMessage.istroop);
    int j = 0;
    if (i == 1032) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramXBaseAdapter != null) {
      while (j < paramXBaseAdapter.getCount())
      {
        Object localObject = paramXBaseAdapter.getItem(j);
        if (localObject != null) {
          if ((localObject instanceof ChatMessage))
          {
            if (((ChatMessage)localObject).uniseq == paramChatMessage.uniseq) {
              return j;
            }
          }
          else if ((localObject instanceof RecentBaseData))
          {
            localObject = (RecentBaseData)localObject;
            if ((i != 0) && (((RecentBaseData)localObject).getRecentUserType() == 1032) && (((RecentBaseData)localObject).getRecentUserUin().equals(AppConstants.CONFESS_UIN))) {
              return j;
            }
            if ((paramChatMessage.frienduin.equals(((RecentBaseData)localObject).getRecentUserUin())) && (paramChatMessage.istroop == ((RecentBaseData)localObject).getRecentUserType())) {
              return j;
            }
          }
        }
        j += 1;
      }
    }
    return -1;
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.e)
    {
      int i = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentWidgetXBaseAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_c_of_type_ComTencentMobileqqDataChatMessage);
      if (i >= 0)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
        localObject = AIOUtils.a((ListView)localObject, ((XListView)localObject).getHeaderViewsCount() + i);
        a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, i, (View)localObject, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramBoolean2);
      }
      return i;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Callback;
    if (localObject != null) {
      ((MediaPlayerManager.Callback)localObject).a(null, 0, null, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramBoolean2);
    }
    return 0;
  }
  
  private MediaPlayerManager.Callback a(ChatMessage paramChatMessage)
  {
    XBaseAdapter localXBaseAdapter = this.jdField_a_of_type_ComTencentWidgetXBaseAdapter;
    if ((localXBaseAdapter instanceof ChatAdapter1)) {
      return (MediaPlayerManager.Callback)((ChatAdapter1)localXBaseAdapter).a.a(paramChatMessage, this.jdField_a_of_type_ComTencentWidgetXBaseAdapter);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Callback;
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
  
  private ChatMessage a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXBaseAdapter.getItem(paramInt);
    if ((localObject != null) && ((localObject instanceof ChatMessage))) {
      return (ChatMessage)localObject;
    }
    return null;
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
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() == paramQQAppInterface)) {
      return;
    }
    localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      a();
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
    AudioPlayerHelper.a(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCAccountNames.qq_audio_play_fix.name(), null));
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.c();
      if ((this.e) || ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentWidgetXBaseAdapter != null))) {
        a(paramBoolean1, paramBoolean2);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
    }
    else
    {
      ChatMessage localChatMessage;
      if (this.jdField_a_of_type_ComTencentWidgetXBaseAdapter != null)
      {
        localChatMessage = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (localChatMessage != null)
        {
          if (a(localChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
          {
            this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.c();
            a(paramBoolean1, paramBoolean2);
            this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
            break label179;
          }
          return false;
        }
      }
      if (this.jdField_a_of_type_ComTencentWidgetXBaseAdapter == null)
      {
        localChatMessage = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (localChatMessage != null)
        {
          MediaPlayerManager.Callback localCallback = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Callback;
          boolean bool;
          if (localCallback != null) {
            bool = localCallback.b(localChatMessage);
          } else {
            bool = false;
          }
          if (bool)
          {
            this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.c();
            a(paramBoolean1, paramBoolean2);
            this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
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
  
  private boolean c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject3;
    int i;
    float f1;
    boolean bool1;
    int k;
    ChatMessage localChatMessage;
    if (localObject1 != null)
    {
      localObject3 = this.jdField_a_of_type_ComTencentWidgetXBaseAdapter;
      if (localObject3 != null)
      {
        i = a((ChatMessage)localObject1, (XBaseAdapter)localObject3);
        int m = this.jdField_a_of_type_ComTencentWidgetXBaseAdapter.getCount();
        if (i <= m)
        {
          f1 = SonicHelper.a;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if ((localObject1 instanceof MessageForPtt))
          {
            bool1 = SonicHelper.a(((MessageForPtt)localObject1).playSpeedPos);
            if (bool1) {
              f1 = ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).playSpeedPos;
            }
            ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).playSpeedPos = SonicHelper.a;
          }
          else
          {
            bool1 = false;
          }
          localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView;
          localObject1 = AIOUtils.a((ListView)localObject1, ((XListView)localObject1).getHeaderViewsCount() + i);
          if (i >= 0) {
            a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, i, (View)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, true);
          }
          if (this.jdField_b_of_type_Boolean) {
            if (i < m - 1)
            {
              k = i + 1;
              localChatMessage = a(k);
              localObject3 = localObject1;
              if ((localChatMessage instanceof Media))
              {
                if ((this.f) && (localObject1 != null)) {
                  i = 1;
                } else {
                  i = 0;
                }
                localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView;
                localObject3 = AIOUtils.a((ListView)localObject1, ((XListView)localObject1).getHeaderViewsCount() + k);
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
        localObject1 = a(localChatMessage);
        boolean bool2 = ((MediaPlayerManager.Callback)localObject1).a(this.jdField_a_of_type_ComTencentWidgetXListView, k, (View)localObject3, localChatMessage);
        if ((bool2) && (bool1) && ((localChatMessage instanceof MessageForPtt)))
        {
          ((MessageForPtt)localChatMessage).playSpeedPos = f1;
          a(f1);
          if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer != null) {
            this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.a(((MessageForPtt)localChatMessage).msgTime);
          }
        }
        if ((!bool2) || (!((MediaPlayerManager.Callback)localObject1).a(this.jdField_a_of_type_ComTencentWidgetXListView, k, (View)localObject3, localChatMessage, this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer, 0))) {
          break label425;
        }
        j = 1;
        if (j != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = localChatMessage;
          if (i != 0) {
            this.jdField_a_of_type_ComTencentWidgetXListView.smoothScrollToPosition(this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + k);
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
      i = k;
      Object localObject2 = localObject3;
      break;
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
      return false;
      label425:
      int j = 0;
    }
  }
  
  public ChatMessage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  }
  
  public void a()
  {
    try
    {
      a(true);
      a(this.jdField_a_of_type_ComTencentWidgetXListView);
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
        ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getApp().unregisterReceiver(this);
      }
      this.jdField_a_of_type_MqqUtilWeakReference = null;
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
    CommonAudioPlayer localCommonAudioPlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer;
    if (localCommonAudioPlayer != null) {
      localCommonAudioPlayer.a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXBaseAdapter;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
        return;
      }
      int j = ((XBaseAdapter)localObject).getCount();
      int i = 0;
      while (i < j)
      {
        if (paramInt != i)
        {
          localObject = a(i);
          PttAudioWaveView localPttAudioWaveView;
          if ((localObject instanceof MessageForPtt))
          {
            localObject = (MessageForPtt)localObject;
            ((MessageForPtt)localObject).playProgress = 0.0F;
            ((MessageForPtt)localObject).playSpeedPos = SonicHelper.a;
            localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
            localObject = AIOUtils.a((ListView)localObject, ((XListView)localObject).getHeaderViewsCount() + i);
            if (localObject != null)
            {
              localPttAudioWaveView = (PttAudioWaveView)((View)localObject).findViewById(2131374101);
              if (localPttAudioWaveView != null)
              {
                localPttAudioWaveView.setProgress(0.0F);
                localPttAudioWaveView.setCanSupportSlide(false);
              }
              localObject = (PttAudioPlayView)((View)localObject).findViewById(2131374100);
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
              localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
              localObject = AIOUtils.a((ListView)localObject, ((XListView)localObject).getHeaderViewsCount() + i);
              if (localObject != null)
              {
                localPttAudioWaveView = (PttAudioWaveView)((View)localObject).findViewById(2131371827);
                if (localPttAudioWaveView != null) {
                  localPttAudioWaveView.setProgress(0.0F);
                }
                localObject = (PttAudioPlayView)((View)localObject).findViewById(2131371826);
                if (localObject != null) {
                  ((PttAudioPlayView)localObject).setPlayState(false);
                }
              }
            }
          }
        }
        i += 1;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener = paramListener;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer;
    if (localObject != null) {
      ((CommonAudioPlayer)localObject).a(paramListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Callback = paramCallback;
    this.e = true;
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    this.jdField_d_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
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
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
        a(true, true);
      }
      paramAudioPlayerBase = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener;
      if (paramAudioPlayerBase != null) {
        paramAudioPlayerBase.a(paramInt);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.4(this, paramAudioPlayerBase, paramInt));
    }
  }
  
  public void a(XListView paramXListView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "unBindUI");
    }
    XListView localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
    if ((localXListView != null) && (localXListView == paramXListView))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_a_of_type_ComTencentWidgetXBaseAdapter = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener = null;
      paramXListView = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer;
      if (paramXListView != null) {
        paramXListView.a(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Callback = null;
      this.jdField_b_of_type_Boolean = false;
      this.f = false;
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
      localStringBuilder.append(this.jdField_a_of_type_ComTencentWidgetXListView);
      localStringBuilder.append(" ,listView = ");
      localStringBuilder.append(paramXListView);
      localStringBuilder.append(" ,adapter = ");
      localStringBuilder.append(paramXBaseAdapter);
      localStringBuilder.append(", listener = ");
      localStringBuilder.append(paramListener);
      QLog.i("MediaPlayerManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentWidgetXBaseAdapter = paramXBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener = paramListener;
    paramXListView = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer;
    if (paramXListView != null) {
      paramXListView.a(paramListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Callback = paramCallback;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.f = paramBoolean2;
    this.e = false;
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
      this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.1(this, paramBoolean));
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null;
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
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqDataChatMessage;
    if ((localObject != null) && ((localObject instanceof MessageForPtt))) {
      ((MessageForPtt)localObject).playProgress = 0.0F;
    }
    ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    a(this.jdField_d_of_type_ComTencentMobileqqDataChatMessage, paramChatMessage);
    this.jdField_c_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    if ((this.jdField_a_of_type_ComTencentWidgetXBaseAdapter != null) && (paramChatMessage != null) && (this.jdField_a_of_type_MqqUtilWeakReference != null))
    {
      if (a(false, false))
      {
        if (DeviceInfoUtil.j())
        {
          this.jdField_c_of_type_Boolean = true;
        }
        else
        {
          localObject = this.jdField_a_of_type_MqqUtilWeakReference;
          if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
            this.jdField_c_of_type_Boolean = AudioDeviceHelper.a((AppRuntime)this.jdField_a_of_type_MqqUtilWeakReference.get());
          }
        }
        boolean bool1 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
        boolean bool2 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
        int i = a(paramChatMessage, this.jdField_a_of_type_ComTencentWidgetXBaseAdapter);
        if (paramBoolean)
        {
          paramBoolean = false;
        }
        else
        {
          this.f = true;
          localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
          localObject = AIOUtils.a((ListView)localObject, ((XListView)localObject).getHeaderViewsCount() + i);
          paramBoolean = a(paramChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, i, (View)localObject, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer, paramInt);
        }
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          this.jdField_a_of_type_Boolean = false;
          this.jdField_c_of_type_ComTencentMobileqqDataChatMessage = null;
          this.jdField_d_of_type_ComTencentMobileqqDataChatMessage = null;
          paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener;
          if (paramChatMessage != null)
          {
            paramChatMessage.d();
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(bool1, bool2, this.jdField_c_of_type_Boolean, false);
          }
          this.jdField_d_of_type_Boolean = false;
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXBaseAdapter);
      ((StringBuilder)localObject).append(", msg = ");
      ((StringBuilder)localObject).append(paramChatMessage);
      ((StringBuilder)localObject).append(", app = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_MqqUtilWeakReference);
      QLog.d("MediaPlayerManager", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_c_of_type_ComTencentMobileqqDataChatMessage = null;
    this.jdField_d_of_type_ComTencentMobileqqDataChatMessage = null;
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "unBindUI");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener = null;
    CommonAudioPlayer localCommonAudioPlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer;
    if (localCommonAudioPlayer != null) {
      localCommonAudioPlayer.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Callback = null;
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    paramAudioPlayerBase = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener;
    if (paramAudioPlayerBase != null) {
      paramAudioPlayerBase.b(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (a())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.f = paramBoolean;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(ChatMessage paramChatMessage, int paramInt)
  {
    ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    Object localObject;
    if ((paramChatMessage != null) && (this.jdField_a_of_type_MqqUtilWeakReference != null))
    {
      if (a(false, false))
      {
        if (DeviceInfoUtil.j())
        {
          this.jdField_c_of_type_Boolean = true;
        }
        else
        {
          localObject = this.jdField_a_of_type_MqqUtilWeakReference;
          if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
            this.jdField_c_of_type_Boolean = AudioDeviceHelper.a((AppRuntime)this.jdField_a_of_type_MqqUtilWeakReference.get());
          }
        }
        boolean bool1 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
        boolean bool2 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Callback.a(this.jdField_a_of_type_ComTencentWidgetXListView, 0, null, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer, paramInt))
        {
          this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          this.jdField_a_of_type_Boolean = false;
          paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener;
          if (paramChatMessage != null)
          {
            paramChatMessage.d();
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(bool1, bool2, this.jdField_c_of_type_Boolean, false);
          }
          this.jdField_d_of_type_Boolean = false;
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXBaseAdapter);
      ((StringBuilder)localObject).append(", msg = ");
      ((StringBuilder)localObject).append(paramChatMessage);
      ((StringBuilder)localObject).append(", app = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_MqqUtilWeakReference);
      QLog.d("MediaPlayerManager", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    boolean bool;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      bool = AudioDeviceHelper.a((AppRuntime)this.jdField_a_of_type_MqqUtilWeakReference.get());
    } else {
      bool = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.a(1, bool);
    if ((bool != this.jdField_c_of_type_Boolean) && (a()) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("$updateSpeakPhone| speakerOn=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("MediaPlayerManager", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_c_of_type_Boolean = bool;
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.5(this, paramInt));
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
      this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.7(this, paramBoolean));
    }
  }
  
  public void d()
  {
    ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localChatMessage != null) {
      this.jdField_b_of_type_ComTencentMobileqqDataChatMessage = localChatMessage;
    }
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      paramAudioPlayerBase = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer;
      if ((paramAudioPlayerBase != null) && (paramAudioPlayerBase.a())) {
        this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.6(this, paramInt));
      }
    }
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaPlayerManager", 2, "$onStop");
    }
    MediaPlayerManager.Listener localListener = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener;
    if (localListener != null) {
      localListener.e();
    }
  }
  
  public void f()
  {
    if (!AudioDeviceHelper.jdField_a_of_type_Boolean) {
      return;
    }
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    if ((AudioPlayer.jdField_a_of_type_Boolean) && (localAudioManager != null) && (localAudioManager.isBluetoothScoOn()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaPlayerManager", 2, "stop sco");
      }
      localAudioManager.stopBluetoothSco();
      localAudioManager.setBluetoothScoOn(false);
      AudioPlayer.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onDestroy()
  {
    f();
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
      ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */