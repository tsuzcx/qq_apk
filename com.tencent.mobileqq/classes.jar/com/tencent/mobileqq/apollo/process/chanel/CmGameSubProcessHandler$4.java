package com.tencent.mobileqq.apollo.process.chanel;

import akww;
import ampj;
import amqt;
import amrk;
import amro;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class CmGameSubProcessHandler$4
  extends ResultReceiver
{
  public CmGameSubProcessHandler$4(amqt paramamqt, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject = ampj.a(amqt.a(this.jdField_a_of_type_Amqt));
    if (localObject != null)
    {
      localObject = ((amrk)localObject).a();
      if (localObject != null)
      {
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[handleUpdateGameScore] rst:" + paramBundle.toString());
          }
          ((amro)localObject).f = paramBundle.getString("state", "-1");
          ((amro)localObject).jdField_d_of_type_JavaLangString = paramBundle.getString("amount", "0");
        }
        amqt.a(this.jdField_a_of_type_Amqt, this.jdField_a_of_type_Long, 0, (amro)localObject);
        if (!"0".equals(((amro)localObject).f)) {
          break label182;
        }
      }
    }
    label182:
    for (boolean bool = true;; bool = false)
    {
      akww.a(((amro)localObject).b, ((amro)localObject).jdField_a_of_type_Long, ((amro)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((amro)localObject).jdField_d_of_type_JavaLangString), bool, false, amqt.a(this.jdField_a_of_type_Amqt));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.4
 * JD-Core Version:    0.7.0.1
 */