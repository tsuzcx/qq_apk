package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class QQLSActivity$12
  implements View.OnTouchListener
{
  QQLSActivity$12(QQLSActivity paramQQLSActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if ((QQLSActivity.a(this.a) != null) && (QQLSActivity.b(this.a) != null))
      {
        paramView = this.a;
        if (QQLSActivity.a(paramView, QQLSActivity.b(paramView), QQLSActivity.a(this.a), paramMotionEvent))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "singlelist  click doble");
          }
          if (QQLSActivity.a(this.a) == null) {
            break label178;
          }
          paramView = this.a;
          QQLSActivity.a(paramView, QQLSActivity.a(paramView));
          QQLSActivity.a(this.a, true);
          break label178;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "singlelist  click once");
      }
      if (QQLSActivity.a(this.a)) {
        QQLSActivity.b(this.a).setText(2131698991);
      } else {
        QQLSActivity.b(this.a).setText(2131698990);
      }
      paramView = QQLSActivity.a(this.a).obtainMessage(5);
      QQLSActivity.a(this.a).sendMessageDelayed(paramView, 500L);
      label178:
      QQLSActivity.a(this.a, MotionEvent.obtain(paramMotionEvent));
    }
    else if (paramMotionEvent.getAction() == 1)
    {
      QQLSActivity.b(this.a, MotionEvent.obtain(paramMotionEvent));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.12
 * JD-Core Version:    0.7.0.1
 */