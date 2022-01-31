package com.tencent.mobileqq.apollo.process.chanel;

import ahiy;
import ajae;
import ajbq;
import ajch;
import ajcl;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class CmGameSubProcessHandler$4
  extends ResultReceiver
{
  public CmGameSubProcessHandler$4(ajbq paramajbq, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject = ajae.a(ajbq.a(this.jdField_a_of_type_Ajbq));
    if (localObject != null)
    {
      localObject = ((ajch)localObject).a();
      if (localObject != null)
      {
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[handleUpdateGameScore] rst:" + paramBundle.toString());
          }
          ((ajcl)localObject).f = paramBundle.getString("state", "-1");
          ((ajcl)localObject).jdField_d_of_type_JavaLangString = paramBundle.getString("amount", "0");
        }
        ajbq.a(this.jdField_a_of_type_Ajbq, this.jdField_a_of_type_Long, 0, (ajcl)localObject);
        if (!"0".equals(((ajcl)localObject).f)) {
          break label182;
        }
      }
    }
    label182:
    for (boolean bool = true;; bool = false)
    {
      ahiy.a(((ajcl)localObject).b, ((ajcl)localObject).jdField_a_of_type_Long, ((ajcl)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((ajcl)localObject).jdField_d_of_type_JavaLangString), bool, false, ajbq.a(this.jdField_a_of_type_Ajbq));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.4
 * JD-Core Version:    0.7.0.1
 */