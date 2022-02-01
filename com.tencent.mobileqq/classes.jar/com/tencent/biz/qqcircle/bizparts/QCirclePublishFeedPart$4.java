package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;
import com.tencent.biz.richframework.part.BasePartFragment;

class QCirclePublishFeedPart$4
  implements ActionSheet.OnButtonClickListener
{
  QCirclePublishFeedPart$4(QCirclePublishFeedPart paramQCirclePublishFeedPart) {}
  
  public void a(View paramView, int paramInt)
  {
    if (this.a.j().getActivity() != null)
    {
      if (this.a.a == null) {
        return;
      }
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          QCirclePublishFeedPart.a(this.a, true);
        }
      }
      else {
        QCirclePublishFeedPart.a(this.a, false);
      }
      QCirclePublishFeedPart.b(this.a);
      this.a.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart.4
 * JD-Core Version:    0.7.0.1
 */