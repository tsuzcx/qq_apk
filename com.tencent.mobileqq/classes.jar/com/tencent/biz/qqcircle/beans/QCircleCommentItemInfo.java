package com.tencent.biz.qqcircle.beans;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import java.util.ArrayList;
import java.util.List;

public class QCircleCommentItemInfo
{
  public FeedCloudMeta.StComment a;
  public List<QCircleReplyItemInfo> b;
  
  public QCircleCommentItemInfo(FeedCloudMeta.StComment paramStComment)
  {
    this.a = paramStComment;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, null, paramInt2);
  }
  
  public void a(int paramInt, FeedCloudMeta.StReply paramStReply)
  {
    a(paramInt, paramStReply, 0);
  }
  
  public void a(int paramInt1, FeedCloudMeta.StReply paramStReply, int paramInt2)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    paramStReply = new QCircleReplyItemInfo(paramInt1, paramStReply, paramInt2);
    if ((paramInt1 == 1) && (this.b.size() > 0))
    {
      List localList = this.b;
      if (((QCircleReplyItemInfo)localList.get(localList.size() - 1)).a != 1)
      {
        localList = this.b;
        localList.add(localList.size() - 1, paramStReply);
        return;
      }
    }
    this.b.add(paramStReply);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.b == null) {
      return;
    }
    int k = 0;
    int j = 0;
    int i;
    for (;;)
    {
      i = k;
      if (j >= this.b.size()) {
        break;
      }
      if ((((QCircleReplyItemInfo)this.b.get(j)).b != null) && (paramString.equals(((QCircleReplyItemInfo)this.b.get(j)).b.id.get())))
      {
        this.b.remove(j);
        i = k;
        break;
      }
      j += 1;
    }
    while (i < this.b.size())
    {
      if ((((QCircleReplyItemInfo)this.b.get(i)).a == 2) && (i < paramInt) && (((QCircleReplyItemInfo)this.b.get(i)).c > 0))
      {
        this.b.add(i, new QCircleReplyItemInfo(1, (FeedCloudMeta.StReply)((FeedCloudMeta.StReply)this.a.vecReply.get(i)).get()));
        paramString = this.b;
        j = i + 1;
        if (((QCircleReplyItemInfo)paramString.get(j)).c - 1 == 0)
        {
          this.b.remove(j);
        }
        else
        {
          paramString = (QCircleReplyItemInfo)this.b.get(j);
          paramString.c -= 1;
        }
      }
      i += 1;
    }
  }
  
  public void a(String paramString, FeedCloudMeta.StReply paramStReply)
  {
    List localList = this.b;
    if (localList == null) {
      return;
    }
    int i = localList.size() - 1;
    while (i >= 0)
    {
      if ((((QCircleReplyItemInfo)this.b.get(i)).b != null) && (paramString.equals(((QCircleReplyItemInfo)this.b.get(i)).b.id.get())))
      {
        ((QCircleReplyItemInfo)this.b.get(i)).b = paramStReply;
        return;
      }
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.QCircleCommentItemInfo
 * JD-Core Version:    0.7.0.1
 */