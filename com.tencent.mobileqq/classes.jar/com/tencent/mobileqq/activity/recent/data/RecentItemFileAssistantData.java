package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemFileAssistantData
  extends RecentItemChatMsgData
{
  private boolean isShowMsgDesciiption = false;
  private String mMsgDescription;
  
  public RecentItemFileAssistantData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    DataLineHandler localDataLineHandler = (DataLineHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    boolean bool3 = localDataLineHandler.a(0);
    boolean bool4 = localDataLineHandler.a(1);
    boolean bool1 = localDataLineHandler.b(0);
    boolean bool2 = localDataLineHandler.b(1);
    if ((bool3) || (bool4))
    {
      bool3 = localDataLineHandler.a();
      bool4 = localDataLineHandler.b();
      if ((!bool3) && (!bool4))
      {
        super.a(paramQQAppInterface, paramContext);
        return;
      }
      if ((bool1) && (bool2))
      {
        this.mMsgExtroInfo = "";
        this.mLastMsg = "你已在电脑\\PAD登录，大文件将局域网高速发送。";
        this.mDisplayTime = a().lastmsgtime;
        return;
      }
      if (bool1)
      {
        this.mMsgExtroInfo = "";
        this.mLastMsg = "你已在电脑登录，大文件将局域网高速发送。";
        this.mDisplayTime = a().lastmsgtime;
        return;
      }
      if (bool2)
      {
        this.mMsgExtroInfo = "";
        this.mLastMsg = "你已在PAD登录，大文件将局域网高速发送。";
        this.mDisplayTime = a().lastmsgtime;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemFileAssistantData
 * JD-Core Version:    0.7.0.1
 */