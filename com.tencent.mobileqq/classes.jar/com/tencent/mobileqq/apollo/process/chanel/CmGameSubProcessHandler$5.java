package com.tencent.mobileqq.apollo.process.chanel;

import akgd;
import alvx;
import alxh;
import alxy;
import alyc;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class CmGameSubProcessHandler$5
  extends ResultReceiver
{
  public CmGameSubProcessHandler$5(alxh paramalxh, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject = alvx.a(alxh.a(this.jdField_a_of_type_Alxh));
    if (localObject != null)
    {
      localObject = ((alxy)localObject).a();
      if (localObject != null)
      {
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[handleUpdateGameScore] rst:" + paramBundle.toString());
          }
          ((alyc)localObject).f = paramBundle.getString("state", "-1");
          ((alyc)localObject).jdField_d_of_type_JavaLangString = paramBundle.getString("amount", "0");
        }
        ((alyc)localObject).jdField_b_of_type_Int = 3;
        if ((localObject != null) && (((alyc)localObject).jdField_a_of_type_Boolean))
        {
          alxh.a(this.jdField_a_of_type_Alxh, this.jdField_a_of_type_Long, 0, (alyc)localObject);
          if (!((alyc)localObject).f.equals("0")) {
            break label210;
          }
        }
      }
    }
    for (;;)
    {
      akgd.a(((alyc)localObject).jdField_b_of_type_JavaLangString, ((alyc)localObject).jdField_a_of_type_Long, ((alyc)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((alyc)localObject).jdField_d_of_type_JavaLangString), bool, false, alxh.a(this.jdField_a_of_type_Alxh));
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