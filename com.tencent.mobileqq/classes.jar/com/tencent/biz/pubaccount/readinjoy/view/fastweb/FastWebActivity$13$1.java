package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.database.DataSetObserver;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$13$1
  extends DataSetObserver
{
  FastWebActivity$13$1(FastWebActivity.13 param13) {}
  
  public void onChanged()
  {
    QLog.d("FastWebActivity", 2, "DataSetObserver ");
    FastWebActivity.a(this.a.a, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.13.1
 * JD-Core Version:    0.7.0.1
 */