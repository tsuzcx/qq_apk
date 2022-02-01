package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import anni;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import uwz;
import uxb;
import vyr;
import zwe;
import zwj;
import zxl;

public class QCircleStatusView
  extends StatusView
  implements zxl<QCircleReportBean>
{
  protected ImageView a;
  protected LinearLayout a;
  private QCircleReportBean a;
  protected ImageView b;
  protected LinearLayout b;
  protected ImageView c;
  protected ImageView d;
  
  public QCircleStatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleStatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (getVisibility() == 0)) {
      setVisibility(8);
    }
    if ((paramBoolean) && (getVisibility() == 8)) {
      setVisibility(0);
    }
  }
  
  private void f()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
    }
    for (;;)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
      localMarginLayoutParams.topMargin = (-ImmersiveUtils.a(30.0F));
      setLayoutParams(localMarginLayoutParams);
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackground(null);
    }
  }
  
  public int a()
  {
    return 2131560692;
  }
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  protected String a()
  {
    return "QCircleStatusView";
  }
  
  protected String a(String paramString)
  {
    return zwj.a(uwz.a()).a(paramString);
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376706));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369206));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369217));
    this.c = ((ImageView)paramView.findViewById(2131369219));
    this.d = ((ImageView)paramView.findViewById(2131369220));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370096));
  }
  
  protected void a(ImageView paramImageView, String paramString)
  {
    String str = a(paramString);
    if (zwj.a(uwz.a()).b(paramString)) {
      return;
    }
    if (new File(str).exists())
    {
      b(paramImageView, str);
      return;
    }
    zwj.a(uwz.a()).a(paramString, new vyr(this, paramImageView));
  }
  
  public void a(Object paramObject) {}
  
  public void a(String paramString)
  {
    setHintImageFilePath(uxb.i + "qcircle_feed_empty.png");
    c(paramString);
  }
  
  protected int b()
  {
    return QCircleReportBean.getPageId(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  protected void b(ImageView paramImageView, String paramString)
  {
    if (paramImageView != null)
    {
      paramImageView.setVisibility(0);
      post(new QCircleStatusView.2(this, paramImageView, paramString));
    }
  }
  
  public void b(String paramString)
  {
    int i;
    if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext()))
    {
      i = 1;
      if (i == 0) {
        break label112;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      paramString = a("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_fullscreen_disconnect.png");
      if (!new File(paramString).exists()) {
        break label92;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      b(this.jdField_a_of_type_AndroidWidgetImageView, paramString);
    }
    for (;;)
    {
      a(true);
      return;
      i = 0;
      break;
      label92:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      continue;
      label112:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      a(this.jdField_b_of_type_AndroidWidgetImageView, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/1-img/img_emptystate_disconnect.png");
      a(this.c, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/1-fullscreen/text_fullscreen_12.png");
      a(this.d, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/3-action/link_fullscreen_noaction.png");
    }
  }
  
  public void c()
  {
    setHintImageFilePath(uxb.i + "qcircle_feed_empty.png");
    c(anni.a(2131697142));
    f();
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleStatusView
 * JD-Core Version:    0.7.0.1
 */