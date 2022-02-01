package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.base.view.widget.ICircleCountDownView;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.IReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;

public class ADVideoItemHolder
  extends VideoItemHolder
{
  public View a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public RIJDownloadView a;
  public URLImageView a;
  public ICircleCountDownView a;
  public ReadInJoyHeadImageView a;
  public boolean a;
  public View b;
  public ImageView b;
  public LinearLayout b;
  public RelativeLayout b;
  public TextView b;
  public RIJDownloadView b;
  public URLImageView b;
  public View c;
  public ImageView c;
  public LinearLayout c;
  public RelativeLayout c;
  public TextView c;
  public View d;
  public ImageView d;
  public RelativeLayout d;
  public TextView d;
  public View e;
  public ImageView e;
  public TextView e;
  public View f;
  public ImageView f;
  public TextView f;
  public View g;
  public TextView g;
  public View h;
  public TextView h;
  public View i;
  public TextView i;
  public View j;
  public TextView j;
  public View k;
  public TextView k;
  public View l;
  public TextView l;
  public View m;
  public TextView m;
  public View n;
  public TextView n;
  
  public ADVideoItemHolder(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    if (paramInt == 4)
    {
      this.jdField_j_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368122));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetAbsReadInJoyNickNameTextView = ((AbsReadInJoyNickNameTextView)paramView.findViewById(2131368100));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetIReadInJoyHeadImageView = ((IReadInJoyHeadImageView)paramView.findViewById(2131368096));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362126));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362127));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362125));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362111));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362118));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362062));
    }
    else if ((paramInt == 5) || (paramInt == 7))
    {
      this.jdField_j_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368122));
      this.jdField_k_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131362132));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetAbsReadInJoyNickNameTextView = ((AbsReadInJoyNickNameTextView)paramView.findViewById(2131362135));
      if (ReadInJoyAdSwitchUtil.a()) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetIReadInJoyHeadImageView = ((IReadInJoyHeadImageView)paramView.findViewById(2131368096));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetIReadInJoyHeadImageView = ((IReadInJoyHeadImageView)paramView.findViewById(2131362133));
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362138));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362111));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362118));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362139));
      this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131367918);
      this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131367902);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367910));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367919));
      this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131367921);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367923));
      this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131367907);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367909));
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetICircleCountDownView = ((ICircleCountDownView)paramView.findViewById(2131367920));
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363353));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131365864));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365866));
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365867));
      this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365862));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365861));
      this.jdField_h_of_type_AndroidViewView = paramView.findViewById(2131362123);
      this.jdField_i_of_type_AndroidViewView = paramView.findViewById(2131362120);
      this.jdField_j_of_type_AndroidViewView = paramView.findViewById(2131362121);
      this.jdField_k_of_type_AndroidViewView = paramView.findViewById(2131362122);
      this.jdField_l_of_type_AndroidViewView = paramView.findViewById(2131367894);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367895));
      this.jdField_m_of_type_AndroidViewView = paramView.findViewById(2131367893);
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367896));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367897));
      this.jdField_n_of_type_AndroidViewView = paramView.findViewById(2131367900);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131371938));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131365863));
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365868));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365865));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365870));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365869));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131380611));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368098));
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362171));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView = ((RIJDownloadView)paramView.findViewById(2131362106));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView = ((RIJDownloadView)paramView.findViewById(2131362108));
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131362142);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131362143);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362144);
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362137));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368872));
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a(IVideoFeedsAdapter paramIVideoFeedsAdapter, LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean)
  {
    super.a(paramIVideoFeedsAdapter, paramLinearLayoutManager, paramBoolean);
    int i2 = paramLinearLayoutManager.getOrientation();
    int i1 = 1;
    if (i2 != 1) {
      i1 = 0;
    }
    if (i1 != 0)
    {
      i1 = paramLinearLayoutManager.getDecoratedMeasuredHeight(this.itemView);
      i2 = Math.abs(paramLinearLayoutManager.getDecoratedTop(this.itemView) - (paramLinearLayoutManager.getHeight() / 2 - i1 / 2));
    }
    else
    {
      i1 = paramLinearLayoutManager.getDecoratedMeasuredWidth(this.itemView);
      i2 = Math.abs(paramLinearLayoutManager.getDecoratedLeft(this.itemView) - (paramLinearLayoutManager.getWidth() / 2 - i1 / 2));
    }
    float f2 = Math.round(i2 / i1 * 100.0F) / 100.0F;
    float f1 = f2;
    if (f2 > 1.0F) {
      f1 = 1.0F;
    }
    if ((paramBoolean) && (f1 <= 0.5D)) {
      ((VideoFeedsHardAdBarManager)paramIVideoFeedsAdapter.b()).c();
    }
    ExposureSupplementManager.a(paramIVideoFeedsAdapter.a(), f1, this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder
 * JD-Core Version:    0.7.0.1
 */