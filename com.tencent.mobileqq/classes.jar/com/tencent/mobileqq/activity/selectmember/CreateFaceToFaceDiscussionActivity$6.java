package com.tencent.mobileqq.activity.selectmember;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TableLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class CreateFaceToFaceDiscussionActivity$6
  extends Handler
{
  CreateFaceToFaceDiscussionActivity$6(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      CreateFaceToFaceDiscussionActivity.access$000(this.a, 3);
      paramMessage = this.a.mHandler.obtainMessage(0);
      this.a.mHandler.sendMessageDelayed(paramMessage, this.a.mInterval);
      return;
    }
    if (1 == paramMessage.what)
    {
      if (!this.a.isEnteredHall)
      {
        this.a.digits.delete(0, this.a.digits.length());
        this.a.mNumberViewLayout.setContentDescription(this.a.getDescription());
        this.a.mDigitViewOne.setImageResource(2130846684);
        this.a.mDigitViewTwo.setImageResource(2130846684);
        this.a.mDigitViewThree.setImageResource(2130846684);
        this.a.mDigitViewFour.setImageResource(2130846684);
        this.a.mDigitOne.setEnabled(true);
        this.a.mDigitTwo.setEnabled(true);
        this.a.mDigitThree.setEnabled(true);
        this.a.mDigitFour.setEnabled(true);
        this.a.mDigitFive.setEnabled(true);
        this.a.mDigitSix.setEnabled(true);
        this.a.mDigitSeven.setEnabled(true);
        this.a.mDigitEight.setEnabled(true);
        this.a.mDigitNine.setEnabled(true);
        this.a.mDigitZero.setEnabled(true);
        this.a.mDelete.setEnabled(true);
      }
    }
    else if (2 == paramMessage.what) {
      QQToast.makeText(BaseApplicationImpl.getContext(), paramMessage.arg1, paramMessage.arg2, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.6
 * JD-Core Version:    0.7.0.1
 */