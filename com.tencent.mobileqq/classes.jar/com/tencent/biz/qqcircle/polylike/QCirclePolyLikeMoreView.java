package com.tencent.biz.qqcircle.polylike;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import vrn;
import vsa;

public class QCirclePolyLikeMoreView
  extends QCirclePolyBaseLikeView
{
  public vrn a;
  
  public QCirclePolyLikeMoreView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public int a()
  {
    return 2131560780;
  }
  
  public String a()
  {
    return "QCircleMorePolyLikeView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    super.a(paramContext, paramView);
    if (paramView != null) {
      paramView.setOnClickListener(new vsa(this));
    }
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeMoreView
 * JD-Core Version:    0.7.0.1
 */