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

public class QCircleHalfScreenStatusView
  extends QCircleStatusView
{
  private static aaaf a;
  
  static
  {
    jdField_a_of_type_Aaaf = new aaaf();
    jdField_a_of_type_Aaaf.a(new aaai("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_halfscreen_disconnect.png", uyk.a()));
    jdField_a_of_type_Aaaf.a();
  }
  
  public QCircleHalfScreenStatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleHalfScreenStatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    return 2131560739;
  }
  
  protected String a()
  {
    return "QCircleMessageListStatusView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369308));
    this.c = ((ImageView)paramView.findViewById(2131369310));
    this.d = ((ImageView)paramView.findViewById(2131369311));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369297));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370193));
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
      this.c.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.d.setVisibility(8);
      paramString = a("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_halfscreen_disconnect.png");
      if (!new File(paramString).exists()) {
        break label92;
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
      label92:
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label112:
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      a(this.jdField_b_of_type_AndroidWidgetImageView, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/1-img/img_emptystate_disconnect.png");
      a(this.c, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/1-fullscreen/text_fullscreen_12.png");
      a(this.d, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/3-action/link_halfscreen_noaction.png");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleHalfScreenStatusView
 * JD-Core Version:    0.7.0.1
 */