package com.tencent.mobileqq.apollo.process.chanel;

import ahiw;
import ajac;
import ajbo;
import ajcf;
import ajcj;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class CmGameSubProcessHandler$4
  extends ResultReceiver
{
  public CmGameSubProcessHandler$4(ajbo paramajbo, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject = ajac.a(ajbo.a(this.jdField_a_of_type_Ajbo));
    if (localObject != null)
    {
      localObject = ((ajcf)localObject).a();
      if (localObject != null)
      {
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[handleUpdateGameScore] rst:" + paramBundle.toString());
          }
          ((ajcj)localObject).f = paramBundle.getString("state", "-1");
          ((ajcj)localObject).jdField_d_of_type_JavaLangString = paramBundle.getString("amount", "0");
        }
        ajbo.a(this.jdField_a_of_type_Ajbo, this.jdField_a_of_type_Long, 0, (ajcj)localObject);
        if (!"0".equals(((ajcj)localObject).f)) {
          break label182;
        }
      }
    }
    label182:
    for (boolean bool = true;; bool = false)
    {
      ahiw.a(((ajcj)localObject).b, ((ajcj)localObject).jdField_a_of_type_Long, ((ajcj)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((ajcj)localObject).jdField_d_of_type_JavaLangString), bool, false, ajbo.a(this.jdField_a_of_type_Ajbo));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.4
 * JD-Core Version:    0.7.0.1
 */