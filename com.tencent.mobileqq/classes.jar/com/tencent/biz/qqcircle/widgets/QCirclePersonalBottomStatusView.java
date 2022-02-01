package com.tencent.biz.qqcircle.widgets;

import aabf;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.launchbean.QCircleFolderBean;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;
import uyx;
import uzg;
import vtq;
import vvw;

public class QCirclePersonalBottomStatusView
  extends QCircleHalfScreenStatusView
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
    return 2131560764;
  }
  
  protected String a()
  {
    return "QCirclePersonalBottomStatusView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369308));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369310));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370119));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379671));
    this.d = ((ImageView)paramView.findViewById(2131369311));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369297));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370193));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    a(this.jdField_b_of_type_AndroidWidgetImageView, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/1-img/img_emptystate_feed.png");
    if (uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser))
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
        vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 17, 1, b());
      }
      setVisibility(0);
      return;
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 1) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 3)))
      {
        a(this.jdField_c_of_type_AndroidWidgetImageView, "https://downv6.qq.com/video_story/qcircle/pic/empty_state/text_halfscreen_05.png");
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697284);
      }
      else
      {
        a(this.jdField_c_of_type_AndroidWidgetImageView, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/2-halfscreen/text_halfscreen_01.png");
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697283);
      }
    }
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
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
        if (getContext().getString(2131697285).equals(((CharSequence)localObject).toString()))
        {
          if (!vvw.a())
          {
            vvw.a(getContext(), 1);
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment != null) {
              this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment.a().a("publish_on_click", null);
            }
            if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) {
              vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 17, 2, b());
            }
          }
        }
        else if (getContext().getString(2131697283).equals(((CharSequence)localObject).toString()))
        {
          localObject = new QCircleFolderBean();
          ((QCircleFolderBean)localObject).setAssignShowTabType(6);
          ((QCircleFolderBean)localObject).setFromReportBean(a().clone());
          uyx.a(getContext(), (QCircleFolderBean)localObject);
          if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) {
            vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 17, 3, b());
          }
        }
        else if (getContext().getString(2131697284).equals(((CharSequence)localObject).toString()))
        {
          uyx.e(paramView.getContext(), new QCircleInitBean());
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