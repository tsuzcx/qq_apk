package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class RecentItemActivateFriendsData
  extends AbsRecentUserBusinessBaseData
{
  private static final String TAG = "ActivateFriends.Recent";
  
  public RecentItemActivateFriendsData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.a(paramQQAppInterface, paramContext);
      QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localQQMessageFacade != null)
      {
        localObject1 = localObject2;
        if (localQQMessageFacade.a(AppConstants.ACTIVATE_FRIENDS_UIN, 9002).size() > 0) {
          localObject1 = localQQMessageFacade.getLastMessage(this.mUser.uin, this.mUser.getType());
        }
      }
      if (localObject1 != null)
      {
        this.mDisplayTime = ((Message)localObject1).time;
        paramQQAppInterface = paramQQAppInterface.getConversationFacade();
        if (paramQQAppInterface != null) {
          this.mUnreadNum = paramQQAppInterface.a(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
        } else {
          this.mUnreadNum = 0;
        }
        this.mShowTime = TimeManager.a().a(getRecentUserUin(), this.mDisplayTime);
        this.mLastMsg = ((Message)localObject1).getMessageText();
      }
      else
      {
        this.mUnreadNum = 0;
        this.mDisplayTime = 0L;
        if (QLog.isColorLevel()) {
          QLog.e("ActivateFriends.Recent", 2, "RecentActivateFriends update, last msg is null");
        }
        this.mShowTime = "";
        this.mLastMsg = "";
      }
      b();
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = paramContext.getString(2131689565);
      }
      if (AppSetting.d)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.mTitleName);
        paramQQAppInterface.append(",");
        if (this.mUnreadNum != 0) {
          if (this.mUnreadNum == 1)
          {
            paramQQAppInterface.append("有一条未读");
          }
          else if (this.mUnreadNum == 2)
          {
            paramQQAppInterface.append("有两条未读");
          }
          else if (this.mUnreadNum > 0)
          {
            paramQQAppInterface.append("有");
            paramQQAppInterface.append(this.mUnreadNum);
            paramQQAppInterface.append("条未读,");
          }
        }
        if (this.mMsgExtroInfo != null)
        {
          paramContext = new StringBuilder();
          paramContext.append(this.mMsgExtroInfo);
          paramContext.append(",");
          paramQQAppInterface.append(paramContext.toString());
        }
        paramQQAppInterface.append(this.mLastMsg);
        paramQQAppInterface.append(",");
        paramQQAppInterface.append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemActivateFriendsData
 * JD-Core Version:    0.7.0.1
 */