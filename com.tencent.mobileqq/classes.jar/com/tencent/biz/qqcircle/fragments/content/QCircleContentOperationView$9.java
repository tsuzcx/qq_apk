package com.tencent.biz.qqcircle.fragments.content;

import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.OnExpandStateChangeListener;

class QCircleContentOperationView$9
  implements QCircleExpandableTextView.OnExpandStateChangeListener
{
  QCircleContentOperationView$9(QCircleContentOperationView paramQCircleContentOperationView, View.OnClickListener paramOnClickListener) {}
  
  public void a()
  {
    QCircleContentOperationView localQCircleContentOperationView = this.b;
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = localQCircleContentOperationView.getExtraTypeInfo();
    String str;
    if (QCircleContentOperationView.a(this.b)) {
      str = "1";
    } else {
      str = "2";
    }
    QCircleContentOperationView.a(localQCircleContentOperationView, 82, 1, localQCircleExtraTypeInfo, str);
  }
  
  public void a(boolean paramBoolean)
  {
    QCircleContentOperationView localQCircleContentOperationView = this.b;
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 3;
    }
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = this.b.getExtraTypeInfo();
    String str;
    if (QCircleContentOperationView.a(this.b)) {
      str = "1";
    } else {
      str = "2";
    }
    QCircleContentOperationView.a(localQCircleContentOperationView, 82, i, localQCircleExtraTypeInfo, str);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.b;
    int i;
    if (paramBoolean) {
      i = 2130845192;
    } else {
      i = 0;
    }
    ((QCircleContentOperationView)localObject).setBackgroundResource(i);
    QCircleContentOperationView localQCircleContentOperationView = this.b;
    if (paramBoolean) {
      localObject = this.a;
    } else {
      localObject = null;
    }
    localQCircleContentOperationView.setOnClickListener((View.OnClickListener)localObject);
    this.b.setClickable(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView.9
 * JD-Core Version:    0.7.0.1
 */