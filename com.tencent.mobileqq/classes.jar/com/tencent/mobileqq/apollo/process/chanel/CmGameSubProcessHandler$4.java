package com.tencent.mobileqq.apollo.process.chanel;

import alil;
import anbd;
import ancn;
import ande;
import andi;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class CmGameSubProcessHandler$4
  extends ResultReceiver
{
  public CmGameSubProcessHandler$4(ancn paramancn, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject = anbd.a(ancn.a(this.jdField_a_of_type_Ancn));
    if (localObject != null)
    {
      localObject = ((ande)localObject).a();
      if (localObject != null)
      {
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[handleUpdateGameScore] rst:" + paramBundle.toString());
          }
          ((andi)localObject).f = paramBundle.getString("state", "-1");
          ((andi)localObject).jdField_d_of_type_JavaLangString = paramBundle.getString("amount", "0");
        }
        ancn.a(this.jdField_a_of_type_Ancn, this.jdField_a_of_type_Long, 0, (andi)localObject);
        if (!"0".equals(((andi)localObject).f)) {
          break label182;
        }
      }
    }
    label182:
    for (boolean bool = true;; bool = false)
    {
      alil.a(((andi)localObject).b, ((andi)localObject).jdField_a_of_type_Long, ((andi)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((andi)localObject).jdField_d_of_type_JavaLangString), bool, false, ancn.a(this.jdField_a_of_type_Ancn));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.4
 * JD-Core Version:    0.7.0.1
 */