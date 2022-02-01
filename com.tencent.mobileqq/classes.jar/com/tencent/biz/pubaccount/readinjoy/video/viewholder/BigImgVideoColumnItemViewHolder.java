package com.tencent.biz.pubaccount.readinjoy.video.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.PlayableItem;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BigImgVideoColumnItemViewHolder
  extends ViewHolder
  implements View.OnClickListener, VideoHandler.PlayableItem
{
  View a;
  public ImageView a;
  public TextView a;
  public VideoPlayManager.VideoPlayParam a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public View b;
  public ImageView b;
  public TextView b;
  public KandianUrlImageView b;
  public View c;
  public TextView c;
  public View d;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  
  public BigImgVideoColumnItemViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  private void a(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler == null)) {}
    BaseArticleInfo localBaseArticleInfo;
    do
    {
      return;
      localBaseArticleInfo = a(paramView);
    } while (localBaseArticleInfo == null);
    if ((VideoFeedsHelper.i() == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().a() != null))
    {
      VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().a();
      if ((localVideoPlayManager != null) && (localVideoPlayManager.a() != null))
      {
        localVideoPlayManager.a().c(paramView);
        return;
      }
    }
    if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.b != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.b.jdField_a_of_type_Int != 3))
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(), localBaseArticleInfo.mSimpleVideoColumnInfo.b);
      if (localBaseArticleInfo.mSimpleVideoColumnInfo.b != null) {
        break label184;
      }
    }
    label184:
    for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.b.e)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 1, paramView);
      return;
      paramView = a(paramView);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().a(paramView.a(), localBaseArticleInfo, false, false);
      break;
    }
  }
  
  private void b(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = a(paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null))
    {
      if ((localBaseArticleInfo.mSimpleVideoColumnInfo.a == null) || (localBaseArticleInfo.mSimpleVideoColumnInfo.a.jdField_a_of_type_Int == 3)) {
        break label92;
      }
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(), localBaseArticleInfo.mSimpleVideoColumnInfo.a);
      if (localBaseArticleInfo.mSimpleVideoColumnInfo.a != null) {
        break label124;
      }
    }
    label92:
    label124:
    for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.a.e)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 2, paramView);
      return;
      paramView = a(paramView);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().a(paramView.a(), localBaseArticleInfo, false, false);
      break;
    }
  }
  
  private void c(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = a(paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.d != null))
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(), localBaseArticleInfo.mSimpleVideoColumnInfo.d);
      if (localBaseArticleInfo.mSimpleVideoColumnInfo.d != null) {
        break label78;
      }
    }
    label78:
    for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.d.e)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 3, paramView);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560497, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131377356);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379432));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373250));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366079));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368729));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131381401));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372581));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372582));
    this.e = ((TextView)paramViewGroup.findViewById(2131370003));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131379487);
    this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131379517);
    this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131363784);
    this.f = ((TextView)paramViewGroup.findViewById(2131366892));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366893));
    this.g = ((TextView)paramViewGroup.findViewById(2131366894));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380915));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setTag(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setTag(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    this.g.setTag(this);
    this.g.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setTag(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
  
  public VideoPlayManager.VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (!VideoFeedsHelper.a(a(paramView))) {}
    int i;
    float f1;
    do
    {
      do
      {
        return false;
        i = VideoFeedsHelper.h();
      } while (i == 0);
      f1 = ReadInJoyDisplayUtils.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f1);
      }
      if (i == 1)
      {
        if ((VideoAutoPlayController.a().e()) && (f1 >= 70.0F)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (i != 2);
    if (f1 >= 70.0F) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public void onClick(View paramView)
  {
    VideoHandler.a(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
      continue;
      b(paramView);
      continue;
      c(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.viewholder.BigImgVideoColumnItemViewHolder
 * JD-Core Version:    0.7.0.1
 */