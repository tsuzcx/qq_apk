package com.tencent.luggage.wxa.pd;

import android.os.Message;

final class e$a
  extends com.tencent.luggage.wxa.ou.e
{
  private e$a(e parame) {}
  
  public boolean a(Message paramMessage)
  {
    if (2 == paramMessage.what)
    {
      paramMessage = this.a;
      e.a(paramMessage, e.a(paramMessage));
      return true;
    }
    return super.a(paramMessage);
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e.b(this.a));
    localStringBuilder.append("|StateExecuting");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.e.a
 * JD-Core Version:    0.7.0.1
 */