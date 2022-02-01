package com.tencent.biz.qqcircle.fragments.content;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;

class QCircleContentVideo$5
  implements Runnable
{
  QCircleContentVideo$5(QCircleContentVideo paramQCircleContentVideo) {}
  
  public void run()
  {
    if (QCircleContentVideo.a(this.this$0) != null)
    {
      if (QCircleContentVideo.a(this.this$0).o != null) {
        QCircleContentVideo.a(this.this$0).o.setVisibility(8);
      }
      if (QCircleContentVideo.a(this.this$0).f != null) {
        QCircleContentVideo.a(this.this$0).f.setVisibility(0);
      }
      if ((QCircleContentVideo.a(this.this$0).u != null) && (QCircleContentVideo.a(this.this$0).v != null) && (!TextUtils.isEmpty(QCircleContentVideo.a(this.this$0).v.getText()))) {
        QCircleContentVideo.a(this.this$0).u.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo.5
 * JD-Core Version:    0.7.0.1
 */