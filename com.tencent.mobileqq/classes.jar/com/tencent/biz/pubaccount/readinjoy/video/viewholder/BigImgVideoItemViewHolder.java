package com.tencent.biz.pubaccount.readinjoy.video.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.PlayableItem;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FamilyCommentInfo;
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

public class BigImgVideoItemViewHolder
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
  public KandianUrlImageView c;
  public View d;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  
  public BigImgVideoItemViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560496, paramViewGroup, false);
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
    this.f = ((TextView)paramViewGroup.findViewById(2131366905));
    this.g = ((TextView)paramViewGroup.findViewById(2131366890));
    this.h = ((TextView)paramViewGroup.findViewById(2131365061));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380915));
    this.i = ((TextView)paramViewGroup.findViewById(2131366903));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366906));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131369654));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setTag(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setTag(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
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
    int j;
    float f1;
    do
    {
      do
      {
        return false;
        j = VideoFeedsHelper.f();
      } while (j == 0);
      f1 = ReadInJoyDisplayUtils.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f1);
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = a(paramView);
      if (localObject1 != null)
      {
        if ((VideoFeedsHelper.g() == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().a() != null))
        {
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().a();
          if ((localObject2 != null) && (((VideoPlayManager)localObject2).a() != null))
          {
            ((VideoPlayManager)localObject2).a().c(paramView);
            continue;
          }
        }
        Object localObject2 = a(paramView);
        if (localObject2 != null) {
          if (RIJTransMergeKanDianReport.a(paramView.getContext(), (BaseArticleInfo)localObject1))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(((VideoHandler.PlayableItem)localObject2).a(), (BaseArticleInfo)localObject1);
            RIJJumpUtils.a(paramView.getContext(), (BaseArticleInfo)localObject1, RIJJumpUtils.b(((BaseArticleInfo)localObject1).getInnerUniqueID()));
          }
          else if (VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(), (BaseArticleInfo)localObject1).intValue() != -1)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(((VideoHandler.PlayableItem)localObject2).a(), (BaseArticleInfo)localObject1);
          }
          else if (localObject2 != null)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().a(((VideoHandler.PlayableItem)localObject2).a(), (BaseArticleInfo)localObject1, false, true);
            continue;
            localObject1 = a(paramView);
            if (localObject1 != null)
            {
              localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().b(this.jdField_a_of_type_Int);
              if (RIJTransMergeKanDianReport.a(paramView.getContext(), (BaseArticleInfo)localObject2))
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(((VideoHandler.PlayableItem)localObject1).a(), (BaseArticleInfo)localObject2);
                RIJJumpUtils.a(paramView.getContext(), (BaseArticleInfo)localObject2, RIJJumpUtils.b(((BaseArticleInfo)localObject2).getInnerUniqueID()));
              }
              else if (VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(), (BaseArticleInfo)localObject2).intValue() != -1)
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(((VideoHandler.PlayableItem)localObject1).a(), (BaseArticleInfo)localObject2);
              }
              else if (localObject1 != null)
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().a(((VideoHandler.PlayableItem)localObject1).a(), (BaseArticleInfo)localObject2, false, true);
                continue;
                localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().b(this.jdField_a_of_type_Int);
                if ((localObject1 != null) && (((BaseArticleInfo)localObject1).familyCommentInfo != null))
                {
                  RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, (BaseArticleInfo)localObject1, ((BaseArticleInfo)localObject1).familyCommentInfo.b);
                  QLog.d("ReadInJoyBaseAdapter", 2, "familyJumpUrl " + ((BaseArticleInfo)localObject1).familyCommentInfo.b);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.viewholder.BigImgVideoItemViewHolder
 * JD-Core Version:    0.7.0.1
 */