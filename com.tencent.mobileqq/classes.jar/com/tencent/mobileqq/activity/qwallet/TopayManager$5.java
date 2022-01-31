package com.tencent.mobileqq.activity.qwallet;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class TopayManager$5
  extends ResultReceiver
{
  public TopayManager$5(Handler paramHandler, WeakReference paramWeakReference, ResultReceiver paramResultReceiver, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 99999) {}
    SelectMemberActivity localSelectMemberActivity;
    do
    {
      return;
      localSelectMemberActivity = (SelectMemberActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localSelectMemberActivity == null) || (localSelectMemberActivity.isFinishing()));
    localSelectMemberActivity.runOnUiThread(new TopayManager.5.1(this, paramInt, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TopayManager.5
 * JD-Core Version:    0.7.0.1
 */