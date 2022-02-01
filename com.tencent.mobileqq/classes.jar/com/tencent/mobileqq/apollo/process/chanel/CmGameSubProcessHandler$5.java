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

public class CmGameSubProcessHandler$5
  extends ResultReceiver
{
  public CmGameSubProcessHandler$5(amqt paramamqt, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
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
        ((amro)localObject).jdField_b_of_type_Int = 3;
        if ((localObject != null) && (((amro)localObject).jdField_a_of_type_Boolean))
        {
          amqt.a(this.jdField_a_of_type_Amqt, this.jdField_a_of_type_Long, 0, (amro)localObject);
          if (!((amro)localObject).f.equals("0")) {
            break label210;
          }
        }
      }
    }
    for (;;)
    {
      akww.a(((amro)localObject).jdField_b_of_type_JavaLangString, ((amro)localObject).jdField_a_of_type_Long, ((amro)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((amro)localObject).jdField_d_of_type_JavaLangString), bool, false, amqt.a(this.jdField_a_of_type_Amqt));
      return;
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[handleUpdateGameScore] launch is null");
      return;
      label210:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.5
 * JD-Core Version:    0.7.0.1
 */