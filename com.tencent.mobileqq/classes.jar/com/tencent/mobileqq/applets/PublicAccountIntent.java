package com.tencent.mobileqq.applets;

import ajfe;
import android.content.Context;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class PublicAccountIntent
  extends NewIntent
{
  private ajfe a;
  
  public PublicAccountIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  public ajfe a()
  {
    return this.a;
  }
  
  public void a(ajfe paramajfe)
  {
    this.a = paramajfe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountIntent
 * JD-Core Version:    0.7.0.1
 */