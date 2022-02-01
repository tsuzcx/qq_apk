package com.tencent.biz.qqcircle.widgets;

import aaaf;
import aaai;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import uyk;

public class QCircleLayerStatusView
  extends QCircleStatusView
{
  private static aaaf a;
  
  static
  {
    jdField_a_of_type_Aaaf = new aaaf();
    jdField_a_of_type_Aaaf.a(new aaai("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_detailpage_disconnect.png", uyk.a()));
    jdField_a_of_type_Aaaf.a();
  }
  
  public QCircleLayerStatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleLayerStatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    return 2131560741;
  }
  
  protected String a()
  {
    return "QCirclePersonalBottomStatusView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369308));
    this.c = ((ImageView)paramView.findViewById(2131369310));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369297));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370193));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    a(this.jdField_b_of_type_AndroidWidgetImageView, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/1-img/img_emptystate_detailpage_feed.png");
    if (paramBoolean) {
      a(this.c, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/3-detailpage/text_detailpage_1.png");
    }
    for (;;)
    {
      setVisibility(0);
      return;
      a(this.c, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/3-detailpage/text_detailpage_2.png");
    }
  }
  
  public void b(String paramString)
  {
    int i;
    if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext()))
    {
      i = 1;
      if (i == 0) {
        break label103;
      }
      this.c.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramString = a("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_detailpage_disconnect.png");
      if (!new File(paramString).exists()) {
        break label83;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      b(this.jdField_a_of_type_AndroidWidgetImageView, paramString);
    }
    for (;;)
    {
      setVisibility(0);
      return;
      i = 0;
      break;
      label83:
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label103:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      a(this.jdField_b_of_type_AndroidWidgetImageView, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/1-img/img_emptystate_detailpage_feed.png");
      a(this.c, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/3-detailpage/text_detailpage_3.png");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLayerStatusView
 * JD-Core Version:    0.7.0.1
 */