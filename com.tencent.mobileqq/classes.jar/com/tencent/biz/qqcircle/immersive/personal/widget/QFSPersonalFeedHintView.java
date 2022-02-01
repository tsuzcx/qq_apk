package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView;
import com.tencent.biz.qqcircle.utils.QCircleDrawableCacheUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;

public class QFSPersonalFeedHintView
  extends QFSFaultHintView
{
  public QFSPersonalFeedHintView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QFSPersonalFeedHintView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    super.a();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.gravity = 49;
    localLayoutParams.topMargin = ViewUtils.dpToPx(76.0F);
    localLayoutParams.bottomMargin = ViewUtils.dpToPx(76.0F);
    this.b.setLayoutParams(localLayoutParams);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, QCircleConfigHelper.be(), QCircleDrawableCacheUtils.a(2130845785));
  }
  
  public void b()
  {
    a(QCircleConfigHelper.aV(), QCircleConfigHelper.aW(), QCircleConfigHelper.bf(), QCircleDrawableCacheUtils.a(2130845787));
  }
  
  public void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, QCircleConfigHelper.bd(), QCircleDrawableCacheUtils.a(2130845786));
  }
  
  protected String getLogTag()
  {
    return "QFSPersonalFeedHintView";
  }
  
  protected String getNoNetHintImgUrl()
  {
    return QCircleConfigHelper.bd();
  }
  
  protected String getNoNetHintMsg()
  {
    return QCircleConfigHelper.bc();
  }
  
  protected String getNoNetHintTitle()
  {
    return QCircleConfigHelper.bb();
  }
  
  public void setReportBean(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalFeedHintView
 * JD-Core Version:    0.7.0.1
 */