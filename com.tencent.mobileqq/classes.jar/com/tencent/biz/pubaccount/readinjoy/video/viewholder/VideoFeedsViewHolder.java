package com.tencent.biz.pubaccount.readinjoy.video.viewholder;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.PlayableItem;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;

public class VideoFeedsViewHolder
  extends ViewHolder
  implements VideoHandler.PlayableItem
{
  public Handler a;
  public View a;
  public ViewGroup a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public VideoPlayManager.VideoPlayParam a;
  public KandianUrlImageView a;
  public ReadInJoyHeadImageView a;
  public ReadInJoyNickNameTextView a;
  public ReadInJoyVideoInfoViewGroup a;
  public VideoViewGroup a;
  public RoundAngleFrameLayout a;
  public boolean a;
  public View b;
  public ViewGroup b;
  public ImageView b;
  public LinearLayout b;
  public TextView b;
  public KandianUrlImageView b;
  public View c;
  public ImageView c;
  public TextView c;
  public View d;
  public ImageView d;
  public TextView d;
  public View e;
  public ImageView e;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  
  public VideoFeedsViewHolder(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560488, paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131366888));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout = ((RoundAngleFrameLayout)paramViewGroup.findViewById(2131381485));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379432));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368729));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131381394));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131361878));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramViewGroup.findViewById(2131368603));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramViewGroup.findViewById(2131376552));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366079));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373650));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368859));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368858));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131381320));
    if (RIJAladdinUtils.b())
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131381405));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373250));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131381401));
      this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131376948);
      this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131381394);
      this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131376512);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramViewGroup.findViewById(2131370039));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372581));
      this.f = ((TextView)paramViewGroup.findViewById(2131372582));
      this.g = ((TextView)paramViewGroup.findViewById(2131370003));
      this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131379487);
      this.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131379517);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131370218));
      this.h = ((TextView)paramViewGroup.findViewById(2131362136));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131370068));
      this.i = ((TextView)paramViewGroup.findViewById(2131362057));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131362056));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366906));
      paramViewGroup.setTag(this);
      return paramViewGroup;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public VideoPlayManager.VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2) {}
  
  public boolean a(View paramView)
  {
    if (!VideoFeedsHelper.a(a(paramView))) {}
    while (ReadInJoyDisplayUtils.a(paramView) < 80.0F) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder
 * JD-Core Version:    0.7.0.1
 */