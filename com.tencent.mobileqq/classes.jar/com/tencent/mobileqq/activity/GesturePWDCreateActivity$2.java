package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.gesturelock.LockPatternView.Cell;
import com.tencent.mobileqq.gesturelock.LockPatternView.OnPatternListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GesturePWDCreateActivity$2
  implements LockPatternView.OnPatternListener
{
  GesturePWDCreateActivity$2(GesturePWDCreateActivity paramGesturePWDCreateActivity) {}
  
  public void onPatternCellAdded(List<LockPatternView.Cell> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.creat", 2, "celladd.");
    }
  }
  
  public void onPatternCleared() {}
  
  public void onPatternDetected(List<LockPatternView.Cell> paramList)
  {
    if (paramList != null)
    {
      int i = this.a.e;
      if (i != 0)
      {
        if (i != 1) {
          return;
        }
        paramList = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.a.app.getCurrentAccountUin());
        if ((this.a.f != null) && (paramList != null) && (this.a.f.equals(paramList)))
        {
          paramList = this.a;
          GesturePWDUtils.setGesturePWD(paramList, paramList.app.getCurrentAccountUin(), this.a.f);
          paramList = this.a;
          GesturePWDUtils.setGesturePWDState(paramList, paramList.app.getCurrentAccountUin(), 2);
          ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Gesture_password", 0, 1, "", "", "", "");
          paramList = this.a;
          QQToast.makeText(paramList, 2, paramList.getString(2131889997), 0).show(this.a.getTitleBarHeight());
          this.a.c.postDelayed(new GesturePWDCreateActivity.2.3(this), 300L);
          if (QLog.isColorLevel()) {
            QLog.d("Q.gesturelock.creat", 2, "gesture lock create success...");
          }
        }
        else
        {
          this.a.b.setDisplayMode(2);
          this.a.c.postDelayed(new GesturePWDCreateActivity.2.4(this), 500L);
          paramList = this.a;
          QQToast.makeText(paramList, 1, paramList.getString(2131889996), 0).show(this.a.getTitleBarHeight());
        }
      }
      else
      {
        if ((paramList != null) && (paramList.size() >= 3))
        {
          this.a.a(paramList);
          this.a.f = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.a.app.getCurrentAccountUin());
          this.a.a.setText(2131889995);
          this.a.c.postDelayed(new GesturePWDCreateActivity.2.1(this), 500L);
          this.a.e = 1;
          return;
        }
        this.a.b.setDisplayMode(2);
        paramList = this.a;
        QQToast.makeText(paramList, 1, paramList.getString(2131890015), 0).show(this.a.getTitleBarHeight());
        this.a.c.postDelayed(new GesturePWDCreateActivity.2.2(this), 500L);
      }
    }
  }
  
  public void onPatternStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDCreateActivity.2
 * JD-Core Version:    0.7.0.1
 */