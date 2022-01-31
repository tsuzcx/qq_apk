package com.tencent.mobileqq.apollo.process.chanel;

import agwj;
import aing;
import aios;
import aipj;
import aipn;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class CmGameSubProcessHandler$5
  extends ResultReceiver
{
  public CmGameSubProcessHandler$5(aios paramaios, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject = aing.a(aios.a(this.jdField_a_of_type_Aios));
    if (localObject != null)
    {
      localObject = ((aipj)localObject).a();
      if (localObject != null)
      {
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[handleUpdateGameScore] rst:" + paramBundle.toString());
          }
          ((aipn)localObject).f = paramBundle.getString("state", "-1");
          ((aipn)localObject).jdField_d_of_type_JavaLangString = paramBundle.getString("amount", "0");
        }
        ((aipn)localObject).jdField_b_of_type_Int = 3;
        if ((localObject != null) && (((aipn)localObject).jdField_a_of_type_Boolean))
        {
          aios.a(this.jdField_a_of_type_Aios, this.jdField_a_of_type_Long, 0, (aipn)localObject);
          if (!((aipn)localObject).f.equals("0")) {
            break label210;
          }
        }
      }
    }
    for (;;)
    {
      agwj.a(((aipn)localObject).jdField_b_of_type_JavaLangString, ((aipn)localObject).jdField_a_of_type_Long, ((aipn)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((aipn)localObject).jdField_d_of_type_JavaLangString), bool, false, aios.a(this.jdField_a_of_type_Aios));
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