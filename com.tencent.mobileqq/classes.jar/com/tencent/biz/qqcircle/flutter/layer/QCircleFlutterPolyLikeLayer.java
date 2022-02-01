package com.tencent.biz.qqcircle.flutter.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.flutter.utils.QCircleFlutterNativePolyLikePopUtils;
import com.tencent.biz.qqcircle.flutter.utils.QCircleFlutterNativePolyLikePopUtils.ShowPolyLikePopWindowParam;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;

public class QCircleFlutterPolyLikeLayer
  extends FrameLayout
{
  private View a;
  private QCirclePolyLikeAniView b;
  
  public QCircleFlutterPolyLikeLayer(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QCircleFlutterPolyLikeLayer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QCircleFlutterPolyLikeLayer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    QLog.d("QCircleFlutterPolyLikeLayer", 2, "[initializationView] init view layout");
    LayoutInflater.from(getContext()).inflate(2131626824, this);
    this.b = ((QCirclePolyLikeAniView)findViewById(2131441659));
    this.a = findViewById(2131441661);
  }
  
  public void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo, QCircleReportBean paramQCircleReportBean)
  {
    QCircleFlutterNativePolyLikePopUtils.ShowPolyLikePopWindowParam localShowPolyLikePopWindowParam = QCircleFlutterNativePolyLikePopUtils.ShowPolyLikePopWindowParam.e();
    localShowPolyLikePopWindowParam.a(paramQCircleExtraTypeInfo);
    localShowPolyLikePopWindowParam.a(paramQCircleReportBean);
    localShowPolyLikePopWindowParam.a(this.a);
    localShowPolyLikePopWindowParam.a(this.b);
    QCircleFlutterNativePolyLikePopUtils.a(localShowPolyLikePopWindowParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.layer.QCircleFlutterPolyLikeLayer
 * JD-Core Version:    0.7.0.1
 */