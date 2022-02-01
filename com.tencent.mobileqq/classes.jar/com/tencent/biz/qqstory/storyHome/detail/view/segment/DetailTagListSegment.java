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
  private DetailFeedItem a;
  private BaseViewHolder b;
  private TagAdapter c;
  private boolean d = true;
  
  public DetailTagListSegment(Context paramContext)
  {
    super(paramContext);
    this.c = new TagAdapter(paramContext);
  }
  
  public int a()
  {
    if (this.m)
    {
      DetailFeedItem localDetailFeedItem = this.a;
      if ((localDetailFeedItem != null) && (localDetailFeedItem.g())) {
        return 1;
      }
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    TagFlowLayout localTagFlowLayout = (TagFlowLayout)paramBaseViewHolder.a(2131446812);
    String str1;
    if ((this.a.a instanceof VideoListFeedItem)) {
      str1 = ((VideoListFeedItem)this.a.a).mQimSyncWording;
    } else {
      str1 = null;
    }
    paramViewGroup = this.a.h();
    boolean bool1;
    if (paramViewGroup != null) {
      bool1 = paramViewGroup.getOwner().isVipButNoFriend();
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (this.a.a.feedSourceTagType == 1)
    {
      String str2 = VideoSourceTagInfoHelper.b(this.a.a.feedSourceTagType);
      paramViewGroup = str2;
      if (TextUtils.isEmpty(str2))
      {
        paramViewGroup = str2;
        if (this.a.a.feedSourceTagType == 1) {
          paramViewGroup = "来自微视APP";
        }
      }
      bool2 = true;
    }
    else
    {
      paramViewGroup = "";
      bool2 = false;
    }
    this.c.a(this.a.d(), str1, this.d, bool2, paramViewGroup);
    this.c.a(this);
    if (bool1) {
      StoryReportor.a("weishi_share", "tag_exp", 0, 0, new String[] { "2", this.a.a.getOwner().getUnionId(), "weishi", this.a.a.feedId });
    }
    localTagFlowLayout.setAdapter(this.c);
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.b = new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628026, paramViewGroup, false));
    return this.b;
  }
  
  public void a(DetailFeedItem paramDetailFeedItem)
  {
    this.a = paramDetailFeedItem;
  }
  
  public void a(TagItem.TagInfoBase paramTagInfoBase)
  {
    StoryTagUtil.a(this.l, paramTagInfoBase);
    String str = "2";
    if (paramTagInfoBase.d == 0) {
      str = "1";
    }
    StoryReportor.a("home_page", "clk_tag", 0, 0, new String[] { "2", str, String.valueOf(paramTagInfoBase.a), this.a.a.feedId });
  }
  
  public String b()
  {
    return "DetailTagListSegment";
  }
  
  public void br_()
  {
    if (((StoryDetailListView)w()).b())
    {
      this.m = true;
      return;
    }
    this.m = false;
  }
  
  public void bu_()
  {
    this.d ^= true;
    StoryReportor.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.a.a.feedId });
  }
  
  public void bv_()
  {
    StoryTagUtil.a(this.l, "com.tencent.qim");
    StoryReportor.a("home_page", "clk_tag", 0, 0, new String[] { "2", "3", "", this.a.a.feedId });
  }
  
  public void bw_()
  {
    if (this.a.a.feedSourceTagType == 1)
    {
      String str;
      if (this.a.a.type == 1) {
        str = ((GeneralFeedItem)this.a.a).wsSchemaForMemories;
      } else {
        str = ((GeneralRecommendFeedItem)this.a.a).wsSchemaForMemories;
      }
      WeShiGuideDialog.a(this.l, this.a.a.getOwner().getUnionId(), "2", this.a.a.feedId, 1, str);
      int i;
      if (WeishiGuideUtils.a(this.l)) {
        i = 2;
      } else {
        i = 1;
      }
      StoryReportor.a("weishi_share", "tag_clk", 0, i, new String[] { "2", this.a.a.getOwner().getUnionId(), "weishi", this.a.a.feedId });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailTagListSegment
 * JD-Core Version:    0.7.0.1
 */