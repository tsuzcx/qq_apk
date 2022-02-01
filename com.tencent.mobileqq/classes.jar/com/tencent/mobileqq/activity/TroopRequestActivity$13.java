package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopRequestActivity$13
  extends TroopBusinessObserver
{
  TroopRequestActivity$13(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (this.a.jdField_a_of_type_JavaLangString == null) {}
    do
    {
      for (;;)
      {
        return;
        this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_JavaLangString.trim();
        try
        {
          long l = Long.parseLong(this.a.jdField_a_of_type_JavaLangString);
          if (paramLong != l) {}
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.e("Q.systemmsg.TroopRequestActivity", 2, "onOIDB0X88D_1_Ret=>NumberFormatException");
              continue;
              QQToast.a(this.a.app.getApplication(), 2131720199, 0).b(this.a.getTitleBarHeight());
            }
          }
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        }
      }
      this.a.h();
      if (!paramBoolean) {
        break label215;
      }
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.a.p = paramTroopInfo.joinTroopQuestion;
        this.a.q = paramTroopInfo.joinTroopAnswer;
      }
      this.a.jdField_a_of_type_Short = paramTroopInfo.cGroupOption;
      if (this.a.jdField_a_of_type_Short == 3) {
        break;
      }
      TroopRequestActivity.a(this.a);
    } while (!QLog.isColorLevel());
    QLog.i("Q.systemmsg.TroopRequestActivity", 2, "troop.cGroupOption = " + paramTroopInfo.cGroupOption);
    return;
    label215:
  }
  
  public void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 4) || (paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 7)) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    if (paramInt1 == 8) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 4) || (paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 7))
    {
      if (paramInt2 != 0) {
        break label68;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      this.a.finish();
    }
    for (;;)
    {
      if (paramInt1 == 8)
      {
        if (paramInt2 != 0) {
          break;
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
      return;
      label68:
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.13
 * JD-Core Version:    0.7.0.1
 */