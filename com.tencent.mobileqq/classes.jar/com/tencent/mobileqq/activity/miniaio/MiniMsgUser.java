package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class MiniMsgUser
  implements Handler.Callback, View.OnClickListener
{
  public static final int MSG_HIDE_ENTRY = 4;
  public static final int MSG_HIDE_UNREAD = 3;
  public static final int MSG_SHOW_ENTRY = 0;
  public static final int MSG_UPDATE_UNREAD_GET = 2;
  public static final int MSG_UPDATE_UNREAD_SYNC = 1;
  public static final String TAG = "mini_msg_User";
  private Activity mActivity;
  private boolean mIsAttach;
  private AtomicBoolean mIsDetroy = new AtomicBoolean();
  private MiniMsgUserParam mMiniMsgUserParam;
  private MqqHandler mUIHandler;
  
  public MiniMsgUser(Activity paramActivity, MiniMsgUserParam paramMiniMsgUserParam)
  {
    this.mActivity = paramActivity;
    this.mMiniMsgUserParam = paramMiniMsgUserParam;
    if (this.mMiniMsgUserParam.accessType == 0)
    {
      int k = paramMiniMsgUserParam.filterMsgType;
      int i = paramMiniMsgUserParam.positionX;
      int j = paramMiniMsgUserParam.positionY;
      int m = paramMiniMsgUserParam.colorType;
      int n = paramMiniMsgUserParam.entryType;
      int i2 = paramMiniMsgUserParam.businessName;
      int i1 = paramMiniMsgUserParam.contentIconResId;
      if (this.mMiniMsgUserParam.entryType == 0)
      {
        paramMiniMsgUserParam = MiniMsgIPCClient.getInstance().getBusinessInfo(i2);
        if ((paramMiniMsgUserParam != null) && (paramMiniMsgUserParam.jdField_b_of_type_Boolean) && (paramMiniMsgUserParam.c > 0))
        {
          i = paramMiniMsgUserParam.c;
          j = paramMiniMsgUserParam.d;
        }
      }
      this.mMiniMsgUserParam.unreadCallback = new MiniEntryViewManager(paramActivity, k, n, m, i1, i, j, this);
    }
    else if (this.mMiniMsgUserParam.accessType == 1)
    {
      if (this.mMiniMsgUserParam.entryView != null) {
        this.mMiniMsgUserParam.entryView.setOnClickListener(this);
      }
      if (this.mMiniMsgUserParam.unreadCallback == null)
      {
        paramActivity = this.mMiniMsgUserParam;
        paramActivity.unreadCallback = new MiniCustomViewUnreadCallback(paramActivity.entryView, this.mMiniMsgUserParam.unreadView);
      }
    }
    this.mUIHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  public static void clear() {}
  
  public void destroy()
  {
    this.mIsDetroy.set(true);
    this.mMiniMsgUserParam.unreadCallback.destroy();
    this.mUIHandler.removeCallbacksAndMessages(null);
    this.mActivity = null;
  }
  
  public MiniMsgUser.IMiniMsgActionCallback getActionCallback()
  {
    MiniMsgUserParam localMiniMsgUserParam = this.mMiniMsgUserParam;
    if (localMiniMsgUserParam != null) {
      return localMiniMsgUserParam.actionCallback;
    }
    return null;
  }
  
  public MiniMsgUserParam getParam()
  {
    return this.mMiniMsgUserParam;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = this.mIsDetroy.get();
    int j = 0;
    if (bool) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msg_what = ");
      ((StringBuilder)localObject).append(paramMessage.what);
      QLog.d("mini_msg_User", 2, ((StringBuilder)localObject).toString());
    }
    int k = paramMessage.arg1;
    Object localObject = MiniMsgIPCClient.getInstance().getBusinessInfo(this.mMiniMsgUserParam.businessName);
    if (localObject == null) {
      return false;
    }
    IMiniMsgUnreadCallback localIMiniMsgUnreadCallback = this.mMiniMsgUserParam.unreadCallback;
    if (localIMiniMsgUnreadCallback == null) {
      return false;
    }
    if ((this.mMiniMsgUserParam.accessType == 0) && ((this.mMiniMsgUserParam.entryType == 0) || (this.mMiniMsgUserParam.entryType == 1))) {
      i = 1;
    } else {
      i = 0;
    }
    int m = paramMessage.what;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 4) {
              return true;
            }
            ((MiniMsgBusinessInfo)localObject).jdField_b_of_type_Boolean = false;
            ((MiniMsgBusinessInfo)localObject).a = false;
            this.mIsAttach = false;
            ((MiniMsgBusinessInfo)localObject).jdField_b_of_type_Int = 0;
            localIMiniMsgUnreadCallback.hide();
            return true;
          }
          localIMiniMsgUnreadCallback.hideUnread();
          ((MiniMsgBusinessInfo)localObject).a = false;
          return true;
        }
        bool = ((MiniMsgBusinessInfo)localObject).a ^ true;
        if (i == 0) {
          if (k <= 0)
          {
            bool = false;
          }
          else
          {
            ((MiniMsgBusinessInfo)localObject).jdField_b_of_type_Int = k;
            return true;
          }
        }
        localIMiniMsgUnreadCallback.updateUnreadCount(k, bool);
        ((MiniMsgBusinessInfo)localObject).jdField_b_of_type_Int = k;
        return true;
      }
      if ((i != 0) && (!((MiniMsgBusinessInfo)localObject).jdField_b_of_type_Boolean))
      {
        this.mIsAttach = localIMiniMsgUnreadCallback.show(k);
        ((MiniMsgBusinessInfo)localObject).jdField_b_of_type_Boolean = this.mIsAttach;
      }
      else
      {
        localIMiniMsgUnreadCallback.updateUnreadCount(k, false);
      }
      ((MiniMsgBusinessInfo)localObject).a = true;
      ((MiniMsgBusinessInfo)localObject).jdField_b_of_type_Int = k;
      return true;
    }
    int i = j;
    if (((MiniMsgBusinessInfo)localObject).jdField_b_of_type_Boolean)
    {
      i = j;
      if (((MiniMsgBusinessInfo)localObject).a) {
        i = ((MiniMsgBusinessInfo)localObject).jdField_b_of_type_Int;
      }
    }
    this.mIsAttach = localIMiniMsgUnreadCallback.show(i);
    ((MiniMsgBusinessInfo)localObject).jdField_b_of_type_Boolean = this.mIsAttach;
    return true;
  }
  
  public void hideEntry()
  {
    if (this.mIsDetroy.get()) {
      return;
    }
    this.mUIHandler.obtainMessage(4).sendToTarget();
  }
  
  public void hideUnread()
  {
    this.mUIHandler.obtainMessage(3).sendToTarget();
  }
  
  public void notifyFromMiniAIOToAIO()
  {
    MiniMsgUserParam localMiniMsgUserParam = this.mMiniMsgUserParam;
    if ((localMiniMsgUserParam != null) && (localMiniMsgUserParam.actionCallback != null)) {
      this.mMiniMsgUserParam.actionCallback.onFromMiniAIOToAIO();
    }
  }
  
  public void notifyGoToConversation()
  {
    MiniMsgUserParam localMiniMsgUserParam = this.mMiniMsgUserParam;
    if ((localMiniMsgUserParam != null) && (localMiniMsgUserParam.actionCallback != null)) {
      this.mMiniMsgUserParam.actionCallback.onGoToConversation();
    }
  }
  
  public void onBackground()
  {
    Object localObject = this.mMiniMsgUserParam;
    if (localObject != null)
    {
      if ((((MiniMsgUserParam)localObject).accessType == 0) && (this.mMiniMsgUserParam.entryType == 0))
      {
        localObject = MiniMsgIPCClient.getInstance().getBusinessInfo(this.mMiniMsgUserParam.businessName);
        if (localObject != null)
        {
          int[] arrayOfInt = ((MiniEntryViewManager)this.mMiniMsgUserParam.unreadCallback).a();
          if (arrayOfInt != null)
          {
            ((MiniMsgBusinessInfo)localObject).c = arrayOfInt[0];
            ((MiniMsgBusinessInfo)localObject).d = arrayOfInt[1];
          }
        }
      }
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.onProcessBackground(this.mMiniMsgUserParam.businessName);
      MiniMsgIPCClient.getInstance().removetMiniUser(this);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.mMiniMsgUserParam;
    if (localObject != null)
    {
      if (((MiniMsgUserParam)localObject).actionCallback != null) {
        this.mMiniMsgUserParam.actionCallback.onOpenMiniAIOCallback();
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_mini_need_update_unread", true);
      ((Intent)localObject).putExtra("key_mini_msgtab_businame", this.mMiniMsgUserParam.businessName);
      ((Intent)localObject).putExtra("key_mini_msgtab_type", this.mMiniMsgUserParam.filterMsgType);
      ((Intent)localObject).putExtra("key_mini_msgtab_need_full_screen", this.mMiniMsgUserParam.isNeedFullScreen);
      ((Intent)localObject).putExtra("key_mini_msgtab_isneed_back_conversation", this.mMiniMsgUserParam.isNeedBackConversation);
      if (this.mMiniMsgUserParam.isNeedBackConversation) {
        ((Intent)localObject).putExtra("key_mini_msgtab_back_pending_intent", this.mMiniMsgUserParam.backConversationIntent);
      }
      MiniChatActivity.a(this.mActivity, (Intent)localObject, this.mMiniMsgUserParam.requestCode);
      hideUnread();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onForeground()
  {
    if (this.mMiniMsgUserParam != null)
    {
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.register(this.mMiniMsgUserParam.businessName, BaseApplicationImpl.getApplication().getQQProcessName());
      MiniMsgIPCClient.getInstance().setMiniUser(this);
      MiniMsgIPCClient.getInstance().syncGetUnread();
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.onProcessForeGround(this.mMiniMsgUserParam.businessName);
    }
  }
  
  public void showEntry()
  {
    if (this.mIsDetroy.get()) {
      return;
    }
    this.mUIHandler.obtainMessage(0).sendToTarget();
  }
  
  public void showOnFirst()
  {
    Object localObject = this.mMiniMsgUserParam;
    if ((localObject != null) && (((MiniMsgUserParam)localObject).accessType == 0))
    {
      localObject = MiniMsgIPCClient.getInstance().getBusinessInfo(this.mMiniMsgUserParam.businessName);
      if ((localObject != null) && (((MiniMsgBusinessInfo)localObject).jdField_b_of_type_Boolean) && (!this.mIsAttach))
      {
        this.mUIHandler.obtainMessage(0).sendToTarget();
        MiniMsgIPCClient.getInstance().syncGetUnread();
      }
    }
  }
  
  public void updateUnreadCountGet(int paramInt)
  {
    if (this.mIsDetroy.get()) {
      return;
    }
    int j = 2;
    int i = j;
    if (paramInt == 0)
    {
      i = j;
      if (this.mMiniMsgUserParam.accessType == 0) {
        if (this.mMiniMsgUserParam.entryType == 0)
        {
          i = 4;
        }
        else
        {
          i = j;
          if (this.mMiniMsgUserParam.entryType == 1) {
            i = 3;
          }
        }
      }
    }
    Message localMessage = this.mUIHandler.obtainMessage(i);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public void updateUnreadCountSync(int paramInt)
  {
    if (this.mIsDetroy.get()) {
      return;
    }
    int j = 1;
    int i = j;
    if (paramInt == 0)
    {
      i = j;
      if (this.mMiniMsgUserParam.accessType == 0) {
        if (this.mMiniMsgUserParam.entryType == 0)
        {
          i = 4;
        }
        else
        {
          i = j;
          if (this.mMiniMsgUserParam.entryType == 1) {
            i = 3;
          }
        }
      }
    }
    Message localMessage = this.mUIHandler.obtainMessage(i);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public void updateWhenBackFromMiniChat(int paramInt)
  {
    if ((paramInt == 0) && (this.mMiniMsgUserParam.accessType == 0) && (this.mMiniMsgUserParam.entryType == 0)) {
      this.mUIHandler.obtainMessage(4).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgUser
 * JD-Core Version:    0.7.0.1
 */