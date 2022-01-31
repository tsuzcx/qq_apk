package com.tencent.mobileqq.applets;

import ajte;
import android.content.Context;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class PublicAccountIntent
  extends NewIntent
{
  private ajte a;
  
  public PublicAccountIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  public ajte a()
  {
    return this.a;
  }
  
  public void a(ajte paramajte)
  {
    this.a = paramajte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountIntent
 * JD-Core Version:    0.7.0.1
 */