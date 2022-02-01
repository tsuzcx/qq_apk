package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$5
  implements OnColorNoteAnimFinishListener
{
  FastWebActivity$5(FastWebActivity paramFastWebActivity) {}
  
  public void onColorNoteAnimFinish()
  {
    FastWebActivity.a(this.a, true);
    FastWebActivity.b(this.a);
    if ((FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a).c())) {
      this.a.overridePendingTransition(0, 0);
    }
    QLog.d("FastWebActivity", 2, "mColorNoteController ：onColorNoteAnimFinish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.5
 * JD-Core Version:    0.7.0.1
 */