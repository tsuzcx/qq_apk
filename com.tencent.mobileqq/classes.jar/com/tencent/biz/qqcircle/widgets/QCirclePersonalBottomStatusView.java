package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;
import java.io.File;
import uxk;
import uxo;
import uxx;
import vrf;
import zxk;

public class QCirclePersonalBottomStatusView
  extends QCircleStatusView
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BasePartFragment jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private LinearLayout c;
  
  public QCirclePersonalBottomStatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePersonalBottomStatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
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
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369217));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369219));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370019));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379502));
    this.d = ((ImageView)paramView.findViewById(2131369220));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369206));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370096));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    a(this.jdField_b_of_type_AndroidWidgetImageView, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/1-img/img_emptystate_feed.png");
    if (uxx.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        a(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) {
        vrf.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 17, 1, b());
      }
      setVisibility(0);
      return;
      a(this.jdField_c_of_type_AndroidWidgetImageView, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/2-halfscreen/text_halfscreen_01.png");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697215);
    }
  }
  
  public void b(String paramString)
  {
    int i;
    if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext()))
    {
      i = 1;
      if (i == 0) {
        break label121;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.d.setVisibility(8);
      paramString = a("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_halfscreen_disconnect.png");
      if (!new File(paramString).exists()) {
        break label101;
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
      label101:
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label121:
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      a(this.jdField_b_of_type_AndroidWidgetImageView, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/1-img/img_emptystate_disconnect.png");
      a(this.jdField_c_of_type_AndroidWidgetImageView, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/1-fullscreen/text_fullscreen_12.png");
      a(this.d, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/3-action/link_halfscreen_noaction.png");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText();
      if (localObject != null) {
        if (getContext().getString(2131697216).equals(((CharSequence)localObject).toString()))
        {
          if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment != null) {
            this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment.a().a("publish_on_click", null);
          }
          if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) {
            vrf.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 17, 2, b());
          }
        }
        else if (getContext().getString(2131697215).equals(((CharSequence)localObject).toString()))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_first_show_tab", "6");
          ((Intent)localObject).putExtra("key_bundle_common_init_bean", new uxk().a(a().clone()).a());
          uxo.a(getContext(), (Intent)localObject);
          if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) {
            vrf.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 17, 3, b());
          }
        }
      }
    }
  }
  
  public void setHostParentFragment(BasePartFragment paramBasePartFragment)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment = paramBasePartFragment;
  }
  
  public void setOwnerPicAndText(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public void setUser(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = paramStUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomStatusView
 * JD-Core Version:    0.7.0.1
 */