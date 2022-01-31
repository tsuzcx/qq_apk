package com.tencent.mobileqq.apollo.process.chanel;

import ajaf;
import akro;
import akta;
import aktr;
import aktv;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class CmGameSubProcessHandler$4
  extends ResultReceiver
{
  public CmGameSubProcessHandler$4(akta paramakta, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject = akro.a(akta.a(this.jdField_a_of_type_Akta));
    if (localObject != null)
    {
      localObject = ((aktr)localObject).a();
      if (localObject != null)
      {
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[handleUpdateGameScore] rst:" + paramBundle.toString());
          }
          ((aktv)localObject).f = paramBundle.getString("state", "-1");
          ((aktv)localObject).jdField_d_of_type_JavaLangString = paramBundle.getString("amount", "0");
        }
        akta.a(this.jdField_a_of_type_Akta, this.jdField_a_of_type_Long, 0, (aktv)localObject);
        if (!"0".equals(((aktv)localObject).f)) {
          break label182;
        }
      }
    }
    label182:
    for (boolean bool = true;; bool = false)
    {
      ajaf.a(((aktv)localObject).b, ((aktv)localObject).jdField_a_of_type_Long, ((aktv)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((aktv)localObject).jdField_d_of_type_JavaLangString), bool, false, akta.a(this.jdField_a_of_type_Akta));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.4
 * JD-Core Version:    0.7.0.1
 */