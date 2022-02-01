package com.tencent.biz.qqcircle.immersive.feed;

import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.OnExpandStateChangeListener;

class QFSFeedChildBottomInfoPresenter$3
  implements QCircleExpandableTextView.OnExpandStateChangeListener
{
  QFSFeedChildBottomInfoPresenter$3(QFSFeedChildBottomInfoPresenter paramQFSFeedChildBottomInfoPresenter) {}
  
  public void a()
  {
    if (this.a.b())
    {
      QFSFeedChildBottomInfoPresenter localQFSFeedChildBottomInfoPresenter = this.a;
      QCircleExtraTypeInfo localQCircleExtraTypeInfo = localQFSFeedChildBottomInfoPresenter.e();
      String str;
      if (QFSFeedChildBottomInfoPresenter.a(this.a)) {
        str = "1";
      } else {
        str = "2";
      }
      QFSFeedChildBottomInfoPresenter.a(localQFSFeedChildBottomInfoPresenter, 82, 1, localQCircleExtraTypeInfo, str);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QFSFeedChildBottomInfoPresenter localQFSFeedChildBottomInfoPresenter = this.a;
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 3;
    }
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = this.a.e();
    String str;
    if (QFSFeedChildBottomInfoPresenter.a(this.a)) {
      str = "1";
    } else {
      str = "2";
    }
    QFSFeedChildBottomInfoPresenter.a(localQFSFeedChildBottomInfoPresenter, 82, i, localQCircleExtraTypeInfo, str);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBottomInfoPresenter.3
 * JD-Core Version:    0.7.0.1
 */