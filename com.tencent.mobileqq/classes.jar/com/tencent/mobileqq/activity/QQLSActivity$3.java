package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class QQLSActivity$3
  implements AdapterView.OnItemClickListener
{
  QQLSActivity$3(QQLSActivity paramQQLSActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (RecentBaseData)QQLSActivity.a(this.a).getItem(paramInt);
    paramLong = paramAdapterView.getAdapter().getItemId(paramInt);
    if ((paramLong == QQLSActivity.b(this.a)) && (Math.abs(QQLSActivity.c(this.a) - System.currentTimeMillis()) < 300L))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "mRecentList is double click");
      }
      QQLSActivity.a(this.a, -1L);
      QQLSActivity.b(this.a, 0L);
      QQLSActivity.a(this.a, paramView);
      QQLSActivity.a(this.a, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQLSActivity", 2, "mRecentList  click once");
    }
    QQLSActivity.a(this.a, paramLong);
    QQLSActivity.b(this.a, System.currentTimeMillis());
    if (QQLSActivity.d(this.a)) {
      QQLSActivity.e(this.a).setText(2131896995);
    } else {
      QQLSActivity.e(this.a).setText(2131896994);
    }
    paramAdapterView = QQLSActivity.f(this.a).obtainMessage(6);
    QQLSActivity.f(this.a).sendMessageDelayed(paramAdapterView, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.3
 * JD-Core Version:    0.7.0.1
 */