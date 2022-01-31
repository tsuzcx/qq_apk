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

public class CmGameSubProcessHandler$5
  extends ResultReceiver
{
  public CmGameSubProcessHandler$5(ajbq paramajbq, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
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
        ((ajcl)localObject).jdField_b_of_type_Int = 3;
        if ((localObject != null) && (((ajcl)localObject).jdField_a_of_type_Boolean))
        {
          ajbq.a(this.jdField_a_of_type_Ajbq, this.jdField_a_of_type_Long, 0, (ajcl)localObject);
          if (!((ajcl)localObject).f.equals("0")) {
            break label210;
          }
        }
      }
    }
    for (;;)
    {
      ahiy.a(((ajcl)localObject).jdField_b_of_type_JavaLangString, ((ajcl)localObject).jdField_a_of_type_Long, ((ajcl)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((ajcl)localObject).jdField_d_of_type_JavaLangString), bool, false, ajbq.a(this.jdField_a_of_type_Ajbq));
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