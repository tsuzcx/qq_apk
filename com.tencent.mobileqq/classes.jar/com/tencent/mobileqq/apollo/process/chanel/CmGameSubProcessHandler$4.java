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

public class CmGameSubProcessHandler$4
  extends ResultReceiver
{
  public CmGameSubProcessHandler$4(alxh paramalxh, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
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
        alxh.a(this.jdField_a_of_type_Alxh, this.jdField_a_of_type_Long, 0, (alyc)localObject);
        if (!"0".equals(((alyc)localObject).f)) {
          break label182;
        }
      }
    }
    label182:
    for (boolean bool = true;; bool = false)
    {
      akgd.a(((alyc)localObject).b, ((alyc)localObject).jdField_a_of_type_Long, ((alyc)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((alyc)localObject).jdField_d_of_type_JavaLangString), bool, false, alxh.a(this.jdField_a_of_type_Alxh));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.4
 * JD-Core Version:    0.7.0.1
 */