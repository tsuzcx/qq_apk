package com.tencent.mobileqq.activity.aio;

import acwh;
import afur;
import afwa;
import afwy;
import afzl;
import afzm;
import afzn;
import afzo;
import agwz;
import ahhy;
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
import anhk;
import bkps;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import lff;
import mqq.manager.Manager;
import mqq.util.WeakReference;

public class MediaPlayerManager
  extends BroadcastReceiver
  implements afwa, Manager
{
  public static float a;
  public static int a;
  public static float b;
  public static float c;
  private afzm jdField_a_of_type_Afzm;
  private afzn jdField_a_of_type_Afzn;
  private MediaPlayer.OnCompletionListener jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new afzl(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private bkps jdField_a_of_type_Bkps;
  private CommonAudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  private ChatMessage jdField_b_of_type_ComTencentMobileqqDataChatMessage;
  private boolean jdField_b_of_type_Boolean;
  private ChatMessage jdField_c_of_type_ComTencentMobileqqDataChatMessage;
  private boolean jdField_c_of_type_Boolean;
  private ChatMessage jdField_d_of_type_ComTencentMobileqqDataChatMessage;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  
  static
  {
    jdField_a_of_type_Float = 1.0F;
    jdField_b_of_type_Float = 1.5F;
    jdField_c_of_type_Float = 1.8F;
    jdField_a_of_type_Int = 1000;
  }
  
  public MediaPlayerManager(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer = new CommonAudioPlayer(localBaseApplication, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.l();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localBaseApplication.registerReceiver(this, localIntentFilter);
    a(paramQQAppInterface);
    AudioDeviceManager.a(paramQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer);
    if (Build.MODEL == "PCCM00") {
      jdField_a_of_type_Int = 0;
    }
  }
  
  public static int a(ChatMessage paramChatMessage, bkps parambkps)
  {
    int i;
    int j;
    if (acwh.a(paramChatMessage.istroop) == 1032)
    {
      i = 1;
      if (parambkps != null) {
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (j >= parambkps.getCount()) {
          break label150;
        }
        Object localObject = parambkps.getItem(j);
        if (localObject != null) {
          if ((localObject instanceof ChatMessage))
          {
            if (((ChatMessage)localObject).uniseq != paramChatMessage.uniseq) {}
          }
          else {
            do
            {
              return j;
              i = 0;
              break;
              if (!(localObject instanceof RecentBaseData)) {
                break label143;
              }
              localObject = (RecentBaseData)localObject;
            } while (((i != 0) && (((RecentBaseData)localObject).getRecentUserType() == 1032) && (((RecentBaseData)localObject).getRecentUserUin().equals(anhk.aM))) || ((paramChatMessage.frienduin.equals(((RecentBaseData)localObject).getRecentUserUin())) && (paramChatMessage.istroop == ((RecentBaseData)localObject).getRecentUserType())));
          }
        }
        label143:
        j += 1;
      }
    }
    label150:
    return -1;
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (!this.e)
    {
      j = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Bkps);
      a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_c_of_type_ComTencentMobileqqDataChatMessage);
      i = j;
      if (j >= 0)
      {
        localView = afur.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + j);
        a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, j, localView, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramBoolean2);
        i = j;
      }
    }
    while (this.jdField_a_of_type_Afzm == null)
    {
      int j;
      View localView;
      return i;
    }
    this.jdField_a_of_type_Afzm.a(null, 0, null, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramBoolean2);
    return 0;
  }
  
  private afzm a(ChatMessage paramChatMessage)
  {
    if ((this.jdField_a_of_type_Bkps instanceof afwy)) {
      return (afzm)((afwy)this.jdField_a_of_type_Bkps).a.a(paramChatMessage, this.jdField_a_of_type_Bkps);
    }
    return this.jdField_a_of_type_Afzm;
  }
  
  public static MediaPlayerManager a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      paramQQAppInterface = (MediaPlayerManager)paramQQAppInterface.getManager(24);
      return paramQQAppInterface;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private ChatMessage a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Bkps.getItem(paramInt);
    if ((localObject != null) && ((localObject instanceof ChatMessage))) {
      return (ChatMessage)localObject;
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaPlayerManager", 2, "$bindApp, app = " + paramQQAppInterface);
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() == paramQQAppInterface)) {
      return;
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
      a();
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static boolean a(float paramFloat)
  {
    return (paramFloat > 1.0F) && (Math.abs(paramFloat - 1.0F) > 0.0F);
  }
  
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 1.0E-006F;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.c();
      if ((this.e) || ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_Bkps != null))) {
        a(paramBoolean1, paramBoolean2);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
      bool2 = true;
    }
    label173:
    for (;;)
    {
      return bool2;
      if ((this.jdField_a_of_type_Bkps != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null))
      {
        if (!a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.c();
        a(paramBoolean1, paramBoolean2);
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
        break;
      }
      if ((this.jdField_a_of_type_Bkps != null) || (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)) {
        break;
      }
      if (this.jdField_a_of_type_Afzm != null) {}
      for (boolean bool1 = this.jdField_a_of_type_Afzm.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);; bool1 = false)
      {
        if (!bool1) {
          break label173;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.c();
        a(paramBoolean1, paramBoolean2);
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
        break;
      }
    }
  }
  
  private boolean c()
  {
    int j;
    int n;
    float f1;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_Bkps != null))
    {
      j = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Bkps);
      n = this.jdField_a_of_type_Bkps.getCount();
      if (j <= n)
      {
        f1 = jdField_a_of_type_Float;
        if (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPtt)) {
          break label427;
        }
        bool1 = a(((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).playSpeedPos);
        if (bool1) {
          f1 = ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).playSpeedPos;
        }
        ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).playSpeedPos = jdField_a_of_type_Float;
      }
    }
    for (;;)
    {
      Object localObject = afur.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + j);
      if (j >= 0) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, j, (View)localObject, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, true);
      }
      if (this.jdField_b_of_type_Boolean) {
        while (j < n - 1)
        {
          int m = j + 1;
          ChatMessage localChatMessage = a(m);
          j = m;
          if ((localChatMessage instanceof afzo))
          {
            int i;
            label199:
            View localView;
            if ((this.f) && (localObject != null))
            {
              i = 1;
              localView = afur.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + m);
            }
            try
            {
              localObject = a(localChatMessage);
              boolean bool2 = ((afzm)localObject).a(this.jdField_a_of_type_ComTencentWidgetXListView, m, localView, localChatMessage);
              if ((bool2) && (bool1) && ((localChatMessage instanceof MessageForPtt)))
              {
                ((MessageForPtt)localChatMessage).playSpeedPos = f1;
                a(f1);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(((MessageForPtt)localChatMessage).msgTime);
                }
              }
              if ((bool2) && (((afzm)localObject).a(this.jdField_a_of_type_ComTencentWidgetXListView, m, localView, localChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer, 0))) {}
              for (int k = 1;; k = 0)
              {
                j = m;
                localObject = localView;
                if (k == 0) {
                  break;
                }
                this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = localChatMessage;
                if (i != 0) {
                  this.jdField_a_of_type_ComTencentWidgetXListView.smoothScrollToPosition(this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + m);
                }
                return true;
                i = 0;
                break label199;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
            }
            catch (Exception localException)
            {
              j = m;
              localObject = localView;
            }
            QLog.e("MediaPlayerManager", 2, "playNext", localException);
            j = m;
            localObject = localView;
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
      return false;
      label427:
      bool1 = false;
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
      if (QLog.isColorLevel()) {
        QLog.d("MediaPlayerManager", 2, "$unBindApp");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MediaPlayerManager", 2, "", localException);
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.b(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bkps == null) || (this.jdField_a_of_type_ComTencentWidgetXListView == null)) {
      return;
    }
    int j = this.jdField_a_of_type_Bkps.getCount();
    int i = 0;
    label25:
    Object localObject;
    PttAudioWaveView localPttAudioWaveView;
    if (i < j) {
      if (paramInt != i)
      {
        localObject = a(i);
        if (!(localObject instanceof MessageForPtt)) {
          break label154;
        }
        ((MessageForPtt)localObject).playProgress = 0.0F;
        ((MessageForPtt)localObject).playSpeedPos = jdField_a_of_type_Float;
        localObject = afur.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + i);
        if (localObject != null)
        {
          localPttAudioWaveView = (PttAudioWaveView)((View)localObject).findViewById(2131374130);
          if (localPttAudioWaveView != null)
          {
            localPttAudioWaveView.setProgress(0.0F);
            localPttAudioWaveView.setCanSupportSlide(false);
          }
          localObject = (PttAudioPlayView)((View)localObject).findViewById(2131374129);
          if (localObject != null) {
            ((PttAudioPlayView)localObject).setPlayState(false);
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label25;
      break;
      label154:
      if ((localObject instanceof MessageForMarketFace))
      {
        localObject = (MessageForMarketFace)localObject;
        if (((MessageForMarketFace)localObject).isNewSoundType())
        {
          ((MessageForMarketFace)localObject).playProgress = 0.0F;
          localObject = afur.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + i);
          if (localObject != null)
          {
            localPttAudioWaveView = (PttAudioWaveView)((View)localObject).findViewById(2131371666);
            if (localPttAudioWaveView != null) {
              localPttAudioWaveView.setProgress(0.0F);
            }
            localObject = (PttAudioPlayView)((View)localObject).findViewById(2131371665);
            if (localObject != null) {
              ((PttAudioPlayView)localObject).setPlayState(false);
            }
          }
        }
      }
    }
  }
  
  public void a(afzn paramafzn, afzm paramafzm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "bindUI, listener = " + paramafzn + " ,callBack = " + paramafzm);
    }
    this.jdField_a_of_type_Afzn = paramafzn;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(paramafzn);
    }
    this.jdField_a_of_type_Afzm = paramafzm;
    this.e = true;
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
      if (this.jdField_a_of_type_Afzn != null) {
        this.jdField_a_of_type_Afzn.g(paramInt);
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.4(this, paramAudioPlayerBase, paramInt));
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    this.jdField_d_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
  }
  
  public void a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (((paramChatMessage1 instanceof MessageForPtt)) && ((paramChatMessage2 instanceof MessageForPtt)) && (!paramChatMessage1.equals(paramChatMessage2))) {
      ((MessageForPtt)paramChatMessage1).playSpeedPos = jdField_a_of_type_Float;
    }
  }
  
  public void a(XListView paramXListView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "unBindUI");
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentWidgetXListView == paramXListView))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_a_of_type_Bkps = null;
      this.jdField_a_of_type_Afzn = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(null);
      }
      this.jdField_a_of_type_Afzm = null;
      this.jdField_b_of_type_Boolean = false;
      this.f = false;
    }
  }
  
  public void a(XListView paramXListView, bkps parambkps, afzn paramafzn)
  {
    a(paramXListView, parambkps, paramafzn, null, true, true);
  }
  
  public void a(XListView paramXListView, bkps parambkps, afzn paramafzn, afzm paramafzm, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "bindUI, mListView = " + this.jdField_a_of_type_ComTencentWidgetXListView + " ,listView = " + paramXListView + " ,adapter = " + parambkps + ", listener = " + paramafzn);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Bkps = parambkps;
    this.jdField_a_of_type_Afzn = paramafzn;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(paramafzn);
    }
    this.jdField_a_of_type_Afzm = paramafzm;
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
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.1(this, paramBoolean));
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
    if ((this.jdField_b_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_b_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPtt))) {
      ((MessageForPtt)this.jdField_b_of_type_ComTencentMobileqqDataChatMessage).playProgress = 0.0F;
    }
    ahhy.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    a(this.jdField_d_of_type_ComTencentMobileqqDataChatMessage, paramChatMessage);
    this.jdField_c_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    if ((this.jdField_a_of_type_Bkps != null) && (paramChatMessage != null) && (this.jdField_a_of_type_MqqUtilWeakReference != null)) {
      if (a(false, false))
      {
        boolean bool2;
        boolean bool3;
        int i;
        boolean bool1;
        if (((paramChatMessage instanceof MessageForLightVideo)) || (afur.b()))
        {
          this.jdField_c_of_type_Boolean = true;
          bool2 = lff.a(BaseApplicationImpl.getContext());
          bool3 = AudioHelper.a(BaseApplicationImpl.getContext());
          i = a(paramChatMessage, this.jdField_a_of_type_Bkps);
          bool1 = false;
          if (!paramBoolean) {
            break label232;
          }
        }
        label232:
        View localView;
        for (paramBoolean = bool1;; paramBoolean = a(paramChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, i, localView, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer, paramInt))
        {
          if (!paramBoolean) {
            break label284;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          this.jdField_a_of_type_Boolean = false;
          this.jdField_c_of_type_ComTencentMobileqqDataChatMessage = null;
          this.jdField_d_of_type_ComTencentMobileqqDataChatMessage = null;
          if (this.jdField_a_of_type_Afzn != null)
          {
            this.jdField_a_of_type_Afzn.ac();
            this.jdField_a_of_type_Afzn.a(bool2, bool3, this.jdField_c_of_type_Boolean, false);
          }
          this.jdField_d_of_type_Boolean = false;
          return true;
          if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
            break;
          }
          this.jdField_c_of_type_Boolean = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).z();
          break;
          this.f = true;
          localView = afur.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + i);
        }
        label284:
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerManager", 2, "builder play failed.");
        }
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_ComTencentMobileqqDataChatMessage = null;
      this.jdField_d_of_type_ComTencentMobileqqDataChatMessage = null;
      return false;
      if (QLog.isColorLevel())
      {
        QLog.d("MediaPlayerManager", 2, "doStop failed.");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerManager", 2, "request play failed, mAdapter = " + this.jdField_a_of_type_Bkps + ", msg = " + paramChatMessage + ", app = " + this.jdField_a_of_type_MqqUtilWeakReference);
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "unBindUI");
    }
    this.jdField_a_of_type_Afzn = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(null);
    }
    this.jdField_a_of_type_Afzm = null;
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    if (this.jdField_a_of_type_Afzn != null) {
      this.jdField_a_of_type_Afzn.h(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (a())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.f = paramBoolean;
      return;
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLightVideo));
  }
  
  public boolean b(ChatMessage paramChatMessage, int paramInt)
  {
    boolean bool1 = false;
    ahhy.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    if ((paramChatMessage != null) && (this.jdField_a_of_type_MqqUtilWeakReference != null)) {
      if (a(false, false)) {
        if (afur.b())
        {
          this.jdField_c_of_type_Boolean = true;
          bool2 = lff.a(BaseApplicationImpl.getContext());
          bool3 = AudioHelper.a(BaseApplicationImpl.getContext());
          if (!this.jdField_a_of_type_Afzm.a(this.jdField_a_of_type_ComTencentWidgetXListView, 0, null, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer, paramInt)) {
            break label170;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          this.jdField_a_of_type_Boolean = false;
          if (this.jdField_a_of_type_Afzn != null)
          {
            this.jdField_a_of_type_Afzn.ac();
            this.jdField_a_of_type_Afzn.a(bool2, bool3, this.jdField_c_of_type_Boolean, false);
          }
          this.jdField_d_of_type_Boolean = false;
          bool1 = true;
        }
      }
    }
    label170:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          for (;;)
          {
            boolean bool2;
            boolean bool3;
            return bool1;
            if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
              this.jdField_c_of_type_Boolean = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).z();
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("MediaPlayerManager", 2, "builder play failed.");
        return false;
      } while (!QLog.isColorLevel());
      QLog.d("MediaPlayerManager", 2, "doStop failed.");
      return false;
    }
    QLog.d("MediaPlayerManager", 2, "request play failed, mAdapter = " + this.jdField_a_of_type_Bkps + ", msg = " + paramChatMessage + ", app = " + this.jdField_a_of_type_MqqUtilWeakReference);
    return false;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {}
    for (boolean bool = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).z();; bool = true)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(1, bool);
      if ((bool != this.jdField_c_of_type_Boolean) && (a()) && (QLog.isColorLevel())) {
        QLog.d("MediaPlayerManager", 2, "$updateSpeakPhone| speakerOn=" + bool);
      }
      this.jdField_c_of_type_Boolean = bool;
      return;
    }
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
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.7(this, paramBoolean));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
      this.jdField_b_of_type_ComTencentMobileqqDataChatMessage = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    }
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a())) {
      this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.6(this, paramInt));
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaPlayerManager", 2, "$onStop");
    }
    if (this.jdField_a_of_type_Afzn != null) {
      this.jdField_a_of_type_Afzn.ad();
    }
  }
  
  public void f()
  {
    if (!AudioPlayer.jdField_a_of_type_Boolean) {}
    AudioManager localAudioManager;
    do
    {
      return;
      localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    } while ((!AudioPlayer.jdField_c_of_type_Boolean) || (localAudioManager == null) || (!localAudioManager.isBluetoothScoOn()));
    if (QLog.isColorLevel()) {
      QLog.d("MediaPlayerManager", 2, "stop sco");
    }
    localAudioManager.stopBluetoothSco();
    localAudioManager.setBluetoothScoOn(false);
    AudioPlayer.jdField_c_of_type_Boolean = false;
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
      bool1 = paramIntent.getBooleanExtra("updateTime", false);
      bool2 = paramIntent.getBooleanExtra("showTime", false);
      if (QLog.isColorLevel()) {
        QLog.d("MediaPlayerManager", 2, "receive action_recv_video_request. update:" + bool1 + ", show:" + bool2);
      }
      if ((bool1) && (bool2)) {
        ChatActivityUtils.a();
      }
      a(true);
    }
    while (!"android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      boolean bool1;
      boolean bool2;
      return;
    }
    a(false);
    ahhy.a(this.jdField_a_of_type_ComTencentWidgetXListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */