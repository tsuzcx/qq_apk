package com.tencent.mobileqq.app;

import android.content.Context;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;

public class QPSafeCheckHandler
  extends BusinessHandler
{
  private Context a = BaseApplication.getContext();
  
  QPSafeCheckHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QPSafeCheckHandler
 * JD-Core Version:    0.7.0.1
 */