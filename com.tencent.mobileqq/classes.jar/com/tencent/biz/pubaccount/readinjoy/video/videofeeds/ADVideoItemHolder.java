package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.image.URLImageView;

public class ADVideoItemHolder
  extends VideoItemHolder
{
  public View a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public CircleCountdownView a;
  public ReadInJoyHeadImageView a;
  public RIJDownloadView a;
  public URLImageView a;
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
      this.jdField_j_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368371));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131368349));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131368345));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362098));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362099));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362097));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362083));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362090));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362047));
    }
    while ((paramInt != 5) && (paramInt != 7))
    {
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131362114);
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131362115);
      this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362116);
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362109));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369139));
      return;
    }
    this.jdField_j_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368371));
    this.jdField_k_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131362104));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131362107));
    if (ReadInJoyAdSwitchUtil.a()) {}
    for (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131368345));; this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131362105)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362110));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362083));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362090));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362111));
      this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131368165);
      this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131368149);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368157));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368166));
      this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131368168);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368170));
      this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131368154);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368156));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView = ((CircleCountdownView)paramView.findViewById(2131368167));
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363423));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366034));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366036));
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366037));
      this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366032));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366031));
      this.jdField_h_of_type_AndroidViewView = paramView.findViewById(2131362095);
      this.jdField_i_of_type_AndroidViewView = paramView.findViewById(2131362092);
      this.jdField_j_of_type_AndroidViewView = paramView.findViewById(2131362093);
      this.jdField_k_of_type_AndroidViewView = paramView.findViewById(2131362094);
      this.jdField_l_of_type_AndroidViewView = paramView.findViewById(2131368141);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368142));
      this.jdField_m_of_type_AndroidViewView = paramView.findViewById(2131368140);
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368143));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368144));
      this.jdField_n_of_type_AndroidViewView = paramView.findViewById(2131368147);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372353));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366033));
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366038));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366035));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366040));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366039));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131381354));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368347));
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362142));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView = ((RIJDownloadView)paramView.findViewById(2131362078));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView = ((RIJDownloadView)paramView.findViewById(2131362080));
      break;
    }
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a(VideoFeedsAdapter paramVideoFeedsAdapter, LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean)
  {
    int i1 = 1;
    super.a(paramVideoFeedsAdapter, paramLinearLayoutManager, paramBoolean);
    if (paramLinearLayoutManager.getOrientation() == 1)
    {
      if (i1 == 0) {
        break label132;
      }
      i1 = paramLinearLayoutManager.getDecoratedMeasuredHeight(this.itemView);
    }
    for (float f1 = Math.abs(paramLinearLayoutManager.getDecoratedTop(this.itemView) - (paramLinearLayoutManager.getHeight() / 2 - i1 / 2)) / i1;; f1 = Math.abs(paramLinearLayoutManager.getDecoratedLeft(this.itemView) - (paramLinearLayoutManager.getWidth() / 2 - i1 / 2)) / i1)
    {
      float f2 = Math.round(f1 * 100.0F) / 100.0F;
      f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      if ((paramBoolean) && (f1 <= 0.5D)) {
        paramVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.c();
      }
      ExposureSupplementUtil.a(paramVideoFeedsAdapter.jdField_a_of_type_AndroidAppActivity, f1, this, paramBoolean);
      return;
      i1 = 0;
      break;
      label132:
      i1 = paramLinearLayoutManager.getDecoratedMeasuredWidth(this.itemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder
 * JD-Core Version:    0.7.0.1
 */