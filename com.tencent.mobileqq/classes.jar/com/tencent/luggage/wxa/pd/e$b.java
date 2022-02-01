package com.tencent.luggage.wxa.pd;

import android.os.Message;

final class e$b
  extends com.tencent.luggage.wxa.ou.e
{
  private e$b(e parame) {}
  
  public void a()
  {
    super.a();
    e.c(this.a);
  }
  
  public boolean a(Message paramMessage)
  {
    if ((1 != paramMessage.what) && (2 != paramMessage.what)) {
      return super.a(paramMessage);
    }
    e.c(this.a);
    return true;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e.b(this.a));
    localStringBuilder.append("|StateIdle");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.e.b
 * JD-Core Version:    0.7.0.1
 */