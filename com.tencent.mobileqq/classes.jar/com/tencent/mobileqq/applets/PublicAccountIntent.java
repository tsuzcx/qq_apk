package com.tencent.mobileqq.applets;

import android.content.Context;
import com.tencent.mobileqq.app.BusinessObserver;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class PublicAccountIntent
  extends NewIntent
{
  private BusinessObserver a;
  
  public PublicAccountIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  public BusinessObserver a()
  {
    return this.a;
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    this.a = paramBusinessObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountIntent
 * JD-Core Version:    0.7.0.1
 */