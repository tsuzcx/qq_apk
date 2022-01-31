package com.tencent.mobileqq.apollo.process.chanel;

import ahiw;
import ajac;
import ajbo;
import ajcf;
import ajcj;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class CmGameSubProcessHandler$5
  extends ResultReceiver
{
  public CmGameSubProcessHandler$5(ajbo paramajbo, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject = ajac.a(ajbo.a(this.jdField_a_of_type_Ajbo));
    if (localObject != null)
    {
      localObject = ((ajcf)localObject).a();
      if (localObject != null)
      {
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[handleUpdateGameScore] rst:" + paramBundle.toString());
          }
          ((ajcj)localObject).f = paramBundle.getString("state", "-1");
          ((ajcj)localObject).jdField_d_of_type_JavaLangString = paramBundle.getString("amount", "0");
        }
        ((ajcj)localObject).jdField_b_of_type_Int = 3;
        if ((localObject != null) && (((ajcj)localObject).jdField_a_of_type_Boolean))
        {
          ajbo.a(this.jdField_a_of_type_Ajbo, this.jdField_a_of_type_Long, 0, (ajcj)localObject);
          if (!((ajcj)localObject).f.equals("0")) {
            break label210;
          }
        }
      }
    }
    for (;;)
    {
      ahiw.a(((ajcj)localObject).jdField_b_of_type_JavaLangString, ((ajcj)localObject).jdField_a_of_type_Long, ((ajcj)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((ajcj)localObject).jdField_d_of_type_JavaLangString), bool, false, ajbo.a(this.jdField_a_of_type_Ajbo));
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