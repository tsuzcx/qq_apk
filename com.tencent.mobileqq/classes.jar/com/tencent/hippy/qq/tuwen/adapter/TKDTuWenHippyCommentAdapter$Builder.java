package com.tencent.hippy.qq.tuwen.adapter;

import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.widget.ListView;

public class TKDTuWenHippyCommentAdapter$Builder
{
  private final TKDTuWenHippyCommentAdapter adapter;
  
  public TKDTuWenHippyCommentAdapter$Builder(QBaseActivity paramQBaseActivity)
  {
    this.adapter = new TKDTuWenHippyCommentAdapter(paramQBaseActivity);
  }
  
  public Builder anchorData(@NonNull AnchorData paramAnchorData)
  {
    this.adapter.anchorData = paramAnchorData;
    return this;
  }
  
  public Builder articleInfo(ArticleInfo paramArticleInfo)
  {
    this.adapter.mArticleInfo = paramArticleInfo;
    return this;
  }
  
  public TKDTuWenHippyCommentAdapter build()
  {
    return this.adapter;
  }
  
  public Builder contentSrc(int paramInt)
  {
    this.adapter.contentSrc = paramInt;
    return this;
  }
  
  public Builder listView(ListView paramListView)
  {
    this.adapter.vList = paramListView;
    return this;
  }
  
  public Builder openCommentEditor(boolean paramBoolean)
  {
    this.adapter.openCommentEditor = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.adapter.TKDTuWenHippyCommentAdapter.Builder
 * JD-Core Version:    0.7.0.1
 */