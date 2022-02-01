package com.tencent.mobileqq.apollo.process.chanel;

import albw;
import amwn;
import amxx;
import amyo;
import amys;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class CmGameSubProcessHandler$5
  extends ResultReceiver
{
  public CmGameSubProcessHandler$5(amxx paramamxx, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject = amwn.a(amxx.a(this.jdField_a_of_type_Amxx));
    if (localObject != null)
    {
      localObject = ((amyo)localObject).a();
      if (localObject != null)
      {
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[handleUpdateGameScore] rst:" + paramBundle.toString());
          }
          ((amys)localObject).f = paramBundle.getString("state", "-1");
          ((amys)localObject).jdField_d_of_type_JavaLangString = paramBundle.getString("amount", "0");
        }
        ((amys)localObject).jdField_b_of_type_Int = 3;
        if ((localObject != null) && (((amys)localObject).jdField_a_of_type_Boolean))
        {
          amxx.a(this.jdField_a_of_type_Amxx, this.jdField_a_of_type_Long, 0, (amys)localObject);
          if (!((amys)localObject).f.equals("0")) {
            break label210;
          }
        }
      }
    }
    for (;;)
    {
      albw.a(((amys)localObject).jdField_b_of_type_JavaLangString, ((amys)localObject).jdField_a_of_type_Long, ((amys)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((amys)localObject).jdField_d_of_type_JavaLangString), bool, false, amxx.a(this.jdField_a_of_type_Amxx));
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