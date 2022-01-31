package com.tencent.mobileqq.activity.qwallet;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

class GoldMsgSettingActivity$MyResultRecevicer
  extends ResultReceiver
{
  final int jdField_a_of_type_Int;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  GoldMsgSettingActivity$MyResultRecevicer(GoldMsgSettingActivity paramGoldMsgSettingActivity, int paramInt, Handler paramHandler)
  {
    super(paramHandler);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramGoldMsgSettingActivity);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (GoldMsgSettingActivity.b) {}
    do
    {
      return;
      paramBundle = (GoldMsgSettingActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((paramBundle == null) || (paramBundle.isFinishing()));
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if (paramInt == 0) {}
      for (;;)
      {
        GoldMsgSettingActivity.a(paramBundle, bool1, false);
        return;
        bool1 = false;
      }
    }
    if (paramInt == 0)
    {
      paramInt = 1;
      if (paramInt != 0) {
        break label102;
      }
    }
    label102:
    for (bool1 = bool2;; bool1 = false)
    {
      GoldMsgSettingActivity.a(paramBundle, bool1, false);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.GoldMsgSettingActivity.MyResultRecevicer
 * JD-Core Version:    0.7.0.1
 */