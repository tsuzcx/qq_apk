package com.tencent.biz.qqcircle.fragments;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart;

class QCirclePolymerizationFragment$1
  implements Observer<String>
{
  QCirclePolymerizationFragment$1(QCirclePolymerizationFragment paramQCirclePolymerizationFragment) {}
  
  public void a(@Nullable String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (QCirclePolymerizationFragment.a(this.a) != null)) {
      QCirclePolymerizationFragment.a(this.a).a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment.1
 * JD-Core Version:    0.7.0.1
 */