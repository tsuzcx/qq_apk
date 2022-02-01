package com.tencent.av.ui;

import android.text.TextUtils;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.download.DownloadParams;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ConferenceFlyTicketActivity$MyDiscussionObserver
  extends DiscussionObserver
{
  ConferenceFlyTicketActivity$MyDiscussionObserver(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    Object localObject = this.a.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetFlyTicket, isSuccess[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], errorCode[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], validTime[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("], sigUrl[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], shortUrl[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], discussionUin[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], mDiscID[");
    localStringBuilder.append(this.a.h);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(this.a.h))
      {
        paramString1 = this.a;
        paramString1.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$OnAfterCreateDiscussionAsyncTask = new ConferenceFlyTicketActivity.OnAfterCreateDiscussionAsyncTask(paramString1);
        paramString1 = new ArrayList();
        localObject = new DownloadParams();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/createConfCallback?feedkey=");
        localStringBuilder.append(this.a.b);
        ((DownloadParams)localObject).jdField_a_of_type_JavaLangString = localStringBuilder.toString();
        this.a.d = paramString2.substring(15, paramString2.length() - 10);
        paramString2 = this.a.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetFlyTicket, mTicket[");
        localStringBuilder.append(this.a.d);
        localStringBuilder.append("]");
        QLog.w(paramString2, 1, localStringBuilder.toString());
        paramString2 = new StringBuilder();
        paramString2.append(((DownloadParams)localObject).jdField_a_of_type_JavaLangString);
        paramString2.append("&ret=0&ticket=");
        paramString2.append(this.a.d);
        ((DownloadParams)localObject).jdField_a_of_type_JavaLangString = paramString2.toString();
        paramString1.add(localObject);
        this.a.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$OnAfterCreateDiscussionAsyncTask.execute(new ArrayList[] { paramString1 });
      }
    }
    else
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.c(paramLong2);
      this.a.a(1, paramInt);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    String str = this.a.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onJoinDiscussionByFlyTicket, isSuccess[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], discussUin[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], errorCode[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mDiscID[");
    localStringBuilder.append(this.a.h);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.a.h = String.valueOf(paramLong);
      if (!TextUtils.isEmpty(this.a.h)) {
        ((DiscussionHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(paramLong);
      }
    }
    else
    {
      this.a.a(1, paramInt);
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject = this.a.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DiscussObserver.onUpdate, type[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], isSuccess[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mDiscID[");
    localStringBuilder.append(this.a.h);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (paramInt == 1001)
    {
      AudioHelper.b("获取讨论组资料_rsp");
      if ((paramObject instanceof ArrayList))
      {
        localObject = (ArrayList)paramObject;
        paramObject = new Object[2];
        paramObject[0] = String.valueOf(((ArrayList)localObject).get(0));
        paramObject[1] = ((ArrayList)localObject).get(1);
      }
      else
      {
        paramObject = (Object[])paramObject;
      }
      localObject = (String)paramObject[0];
      ((Boolean)paramObject[1]).booleanValue();
      if ((this.a.h.equals(localObject)) && (paramBoolean))
      {
        this.a.c();
        paramObject = this.a;
        paramObject.a(paramObject.h, this.a.c);
      }
      this.a.finish();
      return;
    }
    if (1014 == paramInt)
    {
      AudioHelper.b("通过签名加入讨论组_rsp");
      paramObject = (Long[])paramObject;
      long l = paramObject[1].longValue();
      paramInt = paramObject[0].intValue();
      paramObject = this.a.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NOTIFY_TYPE_JOIN_DISCUSSION_BY_FLYY_TICKET, discussUin[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("], errCode[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], mDiscID[");
      ((StringBuilder)localObject).append(this.a.h);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramObject, 1, ((StringBuilder)localObject).toString());
      if (paramInt == 0)
      {
        if (TextUtils.equals(String.valueOf(l), this.a.h))
        {
          this.a.c();
          AudioHelper.b(HardCodeUtil.a(2131702566));
          ((DiscussionHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(l);
          return;
        }
        this.a.finish();
        return;
      }
      this.a.finish();
      this.a.a(1, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ConferenceFlyTicketActivity.MyDiscussionObserver
 * JD-Core Version:    0.7.0.1
 */