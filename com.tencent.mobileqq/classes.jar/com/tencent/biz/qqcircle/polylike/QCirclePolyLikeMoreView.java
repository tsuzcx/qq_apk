package com.tencent.biz.qqcircle.polylike;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;

public class QCirclePolyLikeMoreView
  extends QCirclePolyBaseLikeView
{
  QCirclePolyLikeAllDialog l;
  
  public QCirclePolyLikeMoreView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void bindData(Object paramObject, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131626916;
  }
  
  protected String getLogTag()
  {
    return "QCircleMorePolyLikeView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    super.onInitView(paramContext, paramView);
    if (paramView != null) {
      paramView.setOnClickListener(new QCirclePolyLikeMoreView.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeMoreView
 * JD-Core Version:    0.7.0.1
 */