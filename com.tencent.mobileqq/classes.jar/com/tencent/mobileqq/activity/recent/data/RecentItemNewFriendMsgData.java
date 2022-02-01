package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.qphone.base.util.QLog;

public class RecentItemNewFriendMsgData
  extends AbsRecentUserBusinessBaseData
{
  private static final String TAG = "RecentItemNewFriendMsgData";
  private boolean isFirstShow = true;
  int mTilteId = 0;
  
  public RecentItemNewFriendMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemNewFriendMsgData", 2, "RecentItemNewFriendMsgData update");
    }
    super.a(paramQQAppInterface, paramContext);
    INewFriendService localINewFriendService = (INewFriendService)paramQQAppInterface.getRuntimeService(INewFriendService.class);
    NewFriendMessage localNewFriendMessage = localINewFriendService.getLastUnreadNewFriendMessage();
    this.mTitleName = paramContext.getString(this.mTilteId);
    if (localNewFriendMessage == null)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("isFirstShow = ");
        paramQQAppInterface.append(this.isFirstShow);
        QLog.d("RecentItemNewFriendMsgData", 2, paramQQAppInterface.toString());
      }
      this.mLastMsg = "";
      this.mUnreadNum = 0;
      this.mMsgExtroInfo = "";
      this.mDisplayTime = 0L;
      this.mShowTime = "";
    }
    else
    {
      this.mMsgExtroInfo = "";
      if (localNewFriendMessage.b(paramQQAppInterface) != null) {
        paramQQAppInterface = localNewFriendMessage.b(paramQQAppInterface);
      } else {
        paramQQAppInterface = this.mLastMsg;
      }
      this.mLastMsg = paramQQAppInterface;
      this.mUnreadNum = localINewFriendService.getAllUnreadMessageCount();
      if (this.mDisplayTime < localNewFriendMessage.d) {
        this.mDisplayTime = localNewFriendMessage.d;
      }
      this.mShowTime = TimeManager.a().a(getRecentUserUin(), this.mDisplayTime);
    }
    if (AppSetting.e)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData
 * JD-Core Version:    0.7.0.1
 */