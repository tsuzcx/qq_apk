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

public class CmGameSubProcessHandler$4
  extends ResultReceiver
{
  public CmGameSubProcessHandler$4(amxx paramamxx, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
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
        amxx.a(this.jdField_a_of_type_Amxx, this.jdField_a_of_type_Long, 0, (amys)localObject);
        if (!"0".equals(((amys)localObject).f)) {
          break label182;
        }
      }
    }
    label182:
    for (boolean bool = true;; bool = false)
    {
      albw.a(((amys)localObject).b, ((amys)localObject).jdField_a_of_type_Long, ((amys)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((amys)localObject).jdField_d_of_type_JavaLangString), bool, false, amxx.a(this.jdField_a_of_type_Amxx));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.4
 * JD-Core Version:    0.7.0.1
 */