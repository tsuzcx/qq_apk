package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.StoryTagUtil;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.tag.TagAdapter;
import com.tencent.biz.qqstory.storyHome.tag.TagAdapter.OnItemClickListener;
import com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.VideoSourceTagInfoHelper;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;
import com.tencent.biz.qqstory.view.segment.SegmentView;

public class DetailTagListSegment
  extends SegmentView<DetailFeedItem>
  implements TagAdapter.OnItemClickListener
{
  public static final String KEY = "DetailTagListSegment";
  private DetailFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
  private BaseViewHolder jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  private TagAdapter jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter;
  private boolean b = true;
  
  public DetailTagListSegment(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter = new TagAdapter(paramContext);
  }
  
  public void O_()
  {
    StoryTagUtil.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    StoryReportor.a("home_page", "clk_tag", 0, 0, new String[] { "2", "3", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
  }
  
  public void R_()
  {
    if (((StoryDetailListView)a()).a())
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.d())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    TagFlowLayout localTagFlowLayout = (TagFlowLayout)paramBaseViewHolder.a(2131378904);
    String str = null;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a instanceof VideoListFeedItem)) {
      str = ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a).mQimSyncWording;
    }
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
    if (paramViewGroup != null) {}
    for (boolean bool2 = paramViewGroup.getOwner().isVipButNoFriend();; bool2 = false)
    {
      paramViewGroup = "";
      boolean bool1;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedSourceTagType == 1)
      {
        paramViewGroup = VideoSourceTagInfoHelper.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedSourceTagType);
        if ((TextUtils.isEmpty(paramViewGroup)) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedSourceTagType == 1))
        {
          paramViewGroup = "来自微视APP";
          bool1 = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.b(), str, this.b, bool1, paramViewGroup);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter.a(this);
        if (bool2) {
          StoryReportor.a("weishi_share", "tag_exp", 0, 0, new String[] { "2", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
        }
        localTagFlowLayout.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter);
        return paramBaseViewHolder.a();
        bool1 = true;
        continue;
        bool1 = false;
      }
    }
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561785, paramViewGroup, false));
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  }
  
  public String a()
  {
    return "DetailTagListSegment";
  }
  
  public void a(DetailFeedItem paramDetailFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
  }
  
  public void a(TagItem.TagInfoBase paramTagInfoBase)
  {
    StoryTagUtil.a(this.jdField_a_of_type_AndroidContentContext, paramTagInfoBase);
    if (paramTagInfoBase.jdField_a_of_type_Int == 0) {}
    for (String str = "1";; str = "2")
    {
      StoryReportor.a("home_page", "clk_tag", 0, 0, new String[] { "2", str, String.valueOf(paramTagInfoBase.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
      return;
    }
  }
  
  public void f()
  {
    if (!this.b) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      StoryReportor.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
      return;
    }
  }
  
  public void h()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.type != 1) {
        break label149;
      }
      str = ((GeneralFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a).wsSchemaForMemories;
      WeShiGuideDialog.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().getUnionId(), "2", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, 1, str);
      if (!WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label169;
      }
    }
    label149:
    label169:
    for (int i = 2;; i = 1)
    {
      StoryReportor.a("weishi_share", "tag_clk", 0, i, new String[] { "2", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
      return;
      str = ((GeneralRecommendFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a).wsSchemaForMemories;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailTagListSegment
 * JD-Core Version:    0.7.0.1
 */