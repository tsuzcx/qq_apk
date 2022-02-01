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
    boolean bool3 = localDataLineHandler.f(0);
    boolean bool4 = localDataLineHandler.f(1);
    boolean bool1 = localDataLineHandler.g(0);
    boolean bool2 = localDataLineHandler.g(1);
    if ((bool3) || (bool4))
    {
      bool3 = localDataLineHandler.i();
      bool4 = localDataLineHandler.j();
      if ((!bool3) && (!bool4))
      {
        super.a(paramQQAppInterface, paramContext);
        return;
      }
      if ((bool1) && (bool2))
      {
        this.mMsgExtroInfo = "";
        this.mLastMsg = "你已在电脑\\PAD登录，大文件将局域网高速发送。";
        this.mDisplayTime = e().lastmsgtime;
        return;
      }
      if (bool1)
      {
        this.mMsgExtroInfo = "";
        this.mLastMsg = "你已在电脑登录，大文件将局域网高速发送。";
        this.mDisplayTime = e().lastmsgtime;
        return;
      }
      if (bool2)
      {
        this.mMsgExtroInfo = "";
        this.mLastMsg = "你已在PAD登录，大文件将局域网高速发送。";
        this.mDisplayTime = e().lastmsgtime;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemFileAssistantData
 * JD-Core Version:    0.7.0.1
 */