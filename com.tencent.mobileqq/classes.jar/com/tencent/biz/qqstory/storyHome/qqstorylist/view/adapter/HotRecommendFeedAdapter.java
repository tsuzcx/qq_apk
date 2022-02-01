package com.tencent.biz.qqstory.storyHome.qqstorylist.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.FeedItemThumbAdapter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class HotRecommendFeedAdapter
  extends FeedItemThumbAdapter
{
  private UserManager jdField_a_of_type_ComTencentBizQqstoryModelUserManager = (UserManager)SuperManager.a(2);
  private ChildViewClickListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener = new HotRecommendFeedAdapter.1(this);
  private HotRecommendFeedAdapter.OnSubscribeClickListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewAdapterHotRecommendFeedAdapter$OnSubscribeClickListener;
  
  public HotRecommendFeedAdapter(Context paramContext, Activity paramActivity, int paramInt)
  {
    super(paramContext, paramActivity, paramInt);
  }
  
  protected View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramBaseViewHolder.b = paramInt;
    paramBaseViewHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      Object localObject1 = paramBaseViewHolder.a(2131365298);
      ((View)localObject1).setVisibility(8);
      TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131379896);
      localTextView1.setVisibility(4);
      localTextView1.setOnClickListener(null);
      TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131379839);
      localTextView2.setVisibility(4);
      StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramBaseViewHolder.a(2131380921);
      localStoryUserBadgeView.setVisibility(8);
      TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131379778);
      localTextView3.setVisibility(8);
      Object localObject2 = (QQStoryAutoPlayView)paramBaseViewHolder.a(2131374520);
      paramViewGroup = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramViewGroup != null)
      {
        ((QQStoryAutoPlayView)localObject2).setItemData(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, paramViewGroup, paramInt);
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager != null) {
          ((QQStoryAutoPlayView)localObject2).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$StoryCoverClickListener != null) {
          ((QQStoryAutoPlayView)localObject2).setStoryCoverClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$StoryCoverClickListener);
        }
        FeedSegment.a(paramViewGroup, (QQStoryAutoPlayView)localObject2, "QQStory_feed_min", UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
        if (!TextUtils.isEmpty(paramViewGroup.mOwnerUid))
        {
          localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.b(paramViewGroup.mOwnerUid);
          if (localObject2 != null)
          {
            localTextView3.setVisibility(0);
            if (TextUtils.isEmpty(((QQUserUIItem)localObject2).remark)) {
              localTextView3.setText(((QQUserUIItem)localObject2).nickName);
            } else {
              localTextView3.setText(((QQUserUIItem)localObject2).remark);
            }
            if (!TextUtils.isEmpty(((QQUserUIItem)localObject2).getUnionId()))
            {
              localStoryUserBadgeView.setVisibility(0);
              localStoryUserBadgeView.setUnionID(((QQUserUIItem)localObject2).getUnionId(), 1);
            }
            if (!TextUtils.isEmpty(paramViewGroup.mRecommendWording))
            {
              localTextView2.setVisibility(0);
              localTextView2.setText(paramViewGroup.mRecommendWording);
            }
            if ((((QQUserUIItem)localObject2).isVip()) && (!((QQUserUIItem)localObject2).isMe()) && (!((QQUserUIItem)localObject2).isFriend()))
            {
              localTextView1.setVisibility(0);
              if (((QQUserUIItem)localObject2).isSubscribe())
              {
                localTextView1.setText(HardCodeUtil.a(2131705704));
                localTextView1.setTextColor(Color.parseColor("#80FFFFFF"));
                localTextView1.setBackgroundDrawable(null);
                localTextView1.setOnClickListener(null);
                localTextView1.setClickable(false);
                ((View)localObject1).setVisibility(0);
              }
              else
              {
                localTextView1.setText(HardCodeUtil.a(2131705703));
                localTextView1.setTextColor(Color.parseColor("#FFFFFF"));
                localTextView1.setBackgroundResource(2130847134);
                localTextView1.setOnClickListener(paramBaseViewHolder);
              }
            }
            else if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("这个里显示不出关注按钮了，打个log \n");
              ((StringBuilder)localObject1).append(localObject2);
              QLog.w("HotRecommendFeedAdapter", 2, ((StringBuilder)localObject1).toString());
            }
          }
          StoryReportor.a("home_page", "multi_card_exp", 0, 0, new String[] { paramViewGroup.mOwnerUid, paramViewGroup.mVid });
        }
      }
      return paramBaseViewHolder.a();
    }
    SLog.e("HotRecommendFeedAdapter", "bind view failed because of invalidate data.");
    return paramBaseViewHolder.a();
  }
  
  protected BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561686, paramViewGroup, false));
  }
  
  public void a(HotRecommendFeedAdapter.OnSubscribeClickListener paramOnSubscribeClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewAdapterHotRecommendFeedAdapter$OnSubscribeClickListener = paramOnSubscribeClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.adapter.HotRecommendFeedAdapter
 * JD-Core Version:    0.7.0.1
 */