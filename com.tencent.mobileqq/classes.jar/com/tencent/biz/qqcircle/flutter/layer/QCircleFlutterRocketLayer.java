package com.tencent.biz.qqcircle.flutter.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.widgets.QCircleRocketView;
import com.tencent.qphone.base.util.QLog;

class QCircleFlutterRocketLayer
  extends FrameLayout
{
  private QCircleRocketView a;
  
  public QCircleFlutterRocketLayer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QCircleFlutterRocketLayer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    QLog.d("QCircleFlutterRocketLayer", 2, "[initializeView] current view init...");
    LayoutInflater.from(getContext()).inflate(2131626812, this);
    this.a = ((QCircleRocketView)findViewById(2131440956));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.layer.QCircleFlutterRocketLayer
 * JD-Core Version:    0.7.0.1
 */