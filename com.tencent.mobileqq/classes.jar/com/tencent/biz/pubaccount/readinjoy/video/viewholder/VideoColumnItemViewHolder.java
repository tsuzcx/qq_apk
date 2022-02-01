package com.tencent.biz.pubaccount.readinjoy.video.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.PlayableItem;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VideoColumnItemViewHolder
  extends ViewHolder
  implements View.OnClickListener, VideoHandler.PlayableItem
{
  public View a;
  public ViewGroup a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public VideoPlayManager.VideoPlayParam a;
  public KanDianUrlRoundCornerImageView a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public View b;
  public ViewGroup b;
  public ImageView b;
  public TextView b;
  public KandianUrlImageView b;
  public TextView c;
  public KandianUrlImageView c;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  
  public VideoColumnItemViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  private void a(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = a(paramView);
    if (localBaseArticleInfo == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int != 3))
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      if (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
        break label125;
      }
    }
    label125:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 1, paramView);
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
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler != null) && (localBaseArticleInfo.mVideoColumnInfo != null))
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      VideoFeedsHelper.a(RIJQQAppInterfaceUtil.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int, true, localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_JavaLangString);
      localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Boolean = true;
      VideoColumnInfo localVideoColumnInfo = localBaseArticleInfo.mVideoColumnInfo;
      localVideoColumnInfo.jdField_c_of_type_Int += 1;
      ReadInJoyLogicEngine.a().b((ArticleInfo)localBaseArticleInfo);
      paramView.setVisibility(8);
      if (localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
        break label128;
      }
    }
    label128:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 2, paramView);
      return;
    }
  }
  
  private void c(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = a(paramView);
    if (localBaseArticleInfo == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.b != null) && (localBaseArticleInfo.mVideoColumnInfo.b.jdField_a_of_type_Int != 3))
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(), localBaseArticleInfo.mVideoColumnInfo.b);
      if (localBaseArticleInfo.mVideoColumnInfo.b != null) {
        break label125;
      }
    }
    label125:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.b.e)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 3, paramView);
      return;
      paramView = a(paramView);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().a(paramView.a(), localBaseArticleInfo, false, false);
      break;
    }
  }
  
  private void d(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = a(paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler != null) && (localBaseArticleInfo.mVideoColumnInfo != null))
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(), localBaseArticleInfo.mVideoColumnInfo.d);
      if (localBaseArticleInfo.mVideoColumnInfo.d != null) {
        break label68;
      }
    }
    label68:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.d.e)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 4, paramView);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560498, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131368353));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368354));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131364993));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364996));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364994));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378675));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131365303));
    this.d = ((TextView)paramViewGroup.findViewById(2131379432));
    this.e = ((TextView)paramViewGroup.findViewById(2131373250));
    this.f = ((TextView)paramViewGroup.findViewById(2131366079));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368729));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131381401));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372581));
    this.g = ((TextView)paramViewGroup.findViewById(2131372582));
    this.h = ((TextView)paramViewGroup.findViewById(2131370003));
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131379487);
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131379517);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131362876));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramViewGroup.findViewById(2131364989));
    this.i = ((TextView)paramViewGroup.findViewById(2131364990));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380915));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setOnClickListener(this);
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
    int j;
    float f1;
    do
    {
      do
      {
        return false;
        j = VideoFeedsHelper.d();
      } while (j == 0);
      f1 = ReadInJoyDisplayUtils.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoColumnItemViewHolder() canAutoPlay percent:" + f1);
      }
      if (j == 1)
      {
        if ((VideoAutoPlayController.a().e()) && (f1 >= 70.0F)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (j != 2);
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
    default: 
      a(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(paramView);
      continue;
      a(paramView);
      continue;
      c(paramView);
      continue;
      d(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoColumnItemViewHolder
 * JD-Core Version:    0.7.0.1
 */