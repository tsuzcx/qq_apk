package com.tencent.mobileqq.apollo.process.chanel;

import ajeu;
import akwd;
import akxp;
import akyg;
import akyk;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class CmGameSubProcessHandler$5
  extends ResultReceiver
{
  public CmGameSubProcessHandler$5(akxp paramakxp, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject = akwd.a(akxp.a(this.jdField_a_of_type_Akxp));
    if (localObject != null)
    {
      localObject = ((akyg)localObject).a();
      if (localObject != null)
      {
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[handleUpdateGameScore] rst:" + paramBundle.toString());
          }
          ((akyk)localObject).f = paramBundle.getString("state", "-1");
          ((akyk)localObject).jdField_d_of_type_JavaLangString = paramBundle.getString("amount", "0");
        }
        ((akyk)localObject).jdField_b_of_type_Int = 3;
        if ((localObject != null) && (((akyk)localObject).jdField_a_of_type_Boolean))
        {
          akxp.a(this.jdField_a_of_type_Akxp, this.jdField_a_of_type_Long, 0, (akyk)localObject);
          if (!((akyk)localObject).f.equals("0")) {
            break label210;
          }
        }
      }
    }
    for (;;)
    {
      ajeu.a(((akyk)localObject).jdField_b_of_type_JavaLangString, ((akyk)localObject).jdField_a_of_type_Long, ((akyk)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((akyk)localObject).jdField_d_of_type_JavaLangString), bool, false, akxp.a(this.jdField_a_of_type_Akxp));
      return;
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[handleUpdateGameScore] launch is null");
      return;
      label210:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.5
 * JD-Core Version:    0.7.0.1
 */