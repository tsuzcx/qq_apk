package com.tencent.biz.qqstory.storyHome.qqstorylist;

import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MyStorys
{
  public static final String[] a = StoryApi.c(2130968666);
  protected boolean b = false;
  protected int c = 0;
  protected String d = "";
  protected ArrayList<StoryVideoItem> e = new ArrayList();
  protected HashMap<String, StoryVideoItem> f = new HashMap();
  public boolean g = false;
  public boolean h = false;
  public int i = 0;
  public int j;
  public long k;
  public String l;
  public String m;
  public String n = "";
  public int o;
  public int p;
  public int q;
  public int r;
  public boolean s;
  public FeedFeatureItem t = new FeedFeatureItem();
  
  public int a()
  {
    if (this.b) {
      return this.e.size();
    }
    return 0;
  }
  
  public StoryVideoItem a(String paramString)
  {
    return (StoryVideoItem)this.f.get(paramString);
  }
  
  public String a(int paramInt, TextPaint paramTextPaint)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = this.j;
    int i4 = this.p;
    int i5 = this.o;
    long l2 = this.k;
    int i1 = this.c;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3)
          {
            int i3 = i4;
            i1 = i5;
            long l1 = l2;
            if (this.e.size() > 0)
            {
              localStringBuilder.append("最近");
              int i6 = this.e.size();
              localObject = this.t;
              i2 = i6;
              i3 = i4;
              i1 = i5;
              l1 = l2;
              if (localObject != null)
              {
                i3 = ((FeedFeatureItem)localObject).c;
                i1 = this.t.b;
                l1 = this.t.d;
                i2 = i6;
              }
            }
            localStringBuilder.append(UIUtils.a(i2));
            localStringBuilder.append("个小视频");
            Object localObject = localStringBuilder.toString();
            if (l1 > 0L)
            {
              localStringBuilder.append(a[0]);
              localStringBuilder.append("浏览");
              localStringBuilder.append(l1);
            }
            if ((paramTextPaint != null) && (paramTextPaint.measureText(localStringBuilder.toString()) > paramInt)) {
              return localObject;
            }
            localObject = localStringBuilder.toString();
            if (i1 > 0)
            {
              localStringBuilder.append(a[1]);
              localStringBuilder.append("赞");
              localStringBuilder.append(UIUtils.a(i1));
            }
            if ((paramTextPaint != null) && (paramTextPaint.measureText(localStringBuilder.toString()) > paramInt)) {
              return localObject;
            }
            localObject = localStringBuilder.toString();
            if (i3 > 0)
            {
              localStringBuilder.append(a[1]);
              localStringBuilder.append("评论");
              localStringBuilder.append(UIUtils.a(i3));
            }
            if ((paramTextPaint != null) && (paramTextPaint.measureText(localStringBuilder.toString()) > paramInt)) {
              return localObject;
            }
          }
        }
        else if (this.b)
        {
          localStringBuilder.append(UIUtils.a(i2));
          localStringBuilder.append("个小视频");
          if (this.k > 0L)
          {
            localStringBuilder.append(a[0]);
            localStringBuilder.append("浏览");
            localStringBuilder.append(this.k);
          }
          if (this.o > 0)
          {
            localStringBuilder.append(a[1]);
            localStringBuilder.append("赞");
            localStringBuilder.append(UIUtils.a(this.o));
          }
          if (this.p > 0)
          {
            localStringBuilder.append(a[1]);
            localStringBuilder.append("评论");
            localStringBuilder.append(UIUtils.a(this.p));
          }
        }
        else
        {
          localStringBuilder.append(UIUtils.a(this.q));
          localStringBuilder.append("个小视频发送失败");
        }
        return localStringBuilder.toString();
      }
      if (this.b)
      {
        localStringBuilder.append(UIUtils.a(i2));
        localStringBuilder.append("个小视频");
        return localStringBuilder.toString();
      }
      localStringBuilder.append(StoryApi.a(2131897985, new Object[] { Integer.valueOf(this.r) }));
      return localStringBuilder.toString();
    }
    if (i2 == 0) {
      return StoryApi.b(2131897971);
    }
    localStringBuilder.append(UIUtils.a(i2));
    localStringBuilder.append("个小视频");
    if (i2 > 0)
    {
      localStringBuilder.append(a[0]);
      localStringBuilder.append("浏览");
      localStringBuilder.append(this.k);
    }
    return localStringBuilder.toString();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    try
    {
      this.e.add(0, paramStoryVideoItem);
      this.f.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
      return;
    }
    finally
    {
      paramStoryVideoItem = finally;
      throw paramStoryVideoItem;
    }
  }
  
  public void a(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    this.f.remove(paramString);
    this.f.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
    int i1 = 0;
    while (i1 < this.e.size())
    {
      if (((StoryVideoItem)this.e.get(i1)).mVid.equals(paramString))
      {
        this.e.set(i1, paramStoryVideoItem);
        return;
      }
      i1 += 1;
    }
  }
  
  public void a(List<StoryVideoItem> paramList)
  {
    try
    {
      paramList = new ArrayList(paramList).iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (localStoryVideoItem != null)
        {
          this.e.add(localStoryVideoItem);
          this.f.put(localStoryVideoItem.mVid, localStoryVideoItem);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public ArrayList<StoryVideoItem> b()
  {
    return this.e;
  }
  
  public void b(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    this.f.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
    int i1 = 0;
    while (i1 < this.e.size())
    {
      if (((StoryVideoItem)this.e.get(i1)).mVid.equals(paramStoryVideoItem.mVid))
      {
        this.e.set(i1, paramStoryVideoItem);
        return;
      }
      i1 += 1;
    }
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    try
    {
      this.f.remove(paramStoryVideoItem.mVid);
      i1 = 0;
    }
    finally
    {
      for (;;)
      {
        int i1;
        for (;;)
        {
          throw paramStoryVideoItem;
        }
        i1 += 1;
      }
    }
    if (i1 < this.e.size())
    {
      if (!((StoryVideoItem)this.e.get(i1)).mVid.equals(paramStoryVideoItem.mVid)) {
        break label160;
      }
      this.e.remove(i1);
    }
    if ((this.e.size() == 0) && (this.t != null))
    {
      this.t.c = 0;
      this.t.b = 0;
      this.t.d = 0;
      paramStoryVideoItem = (StoryConfigManager)SuperManager.a(10);
      paramStoryVideoItem.d("qqstory_my_visiter_count", Integer.valueOf(0));
      paramStoryVideoItem.d("qqstory_my_newest_video_cover", "");
      paramStoryVideoItem.d("qqstory_my_newest_video_vid", "");
    }
  }
  
  public void d()
  {
    GetUserSelfInfoStep.a(this);
    this.c = 0;
    this.q = 0;
    this.s = false;
    this.r = 0;
    Object localObject = this.e;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject).next();
        int i1 = StoryListUtils.a(localStoryVideoItem.mUploadStatus);
        if ((i1 == 1) || (i1 == 0))
        {
          this.c = 1;
          this.r += 1;
        }
        if (localStoryVideoItem.isUploadFail()) {
          this.q += 1;
        }
        if (!TextUtils.isEmpty(localStoryVideoItem.mDoodleText)) {
          this.s = true;
        }
      }
      if (this.c == 1) {
        return;
      }
      if (this.q > 0)
      {
        this.c = 2;
        return;
      }
      this.c = 3;
      return;
    }
    if (this.j <= 0) {
      return;
    }
    this.c = 3;
  }
  
  public void e()
  {
    try
    {
      this.e.clear();
      this.f.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys
 * JD-Core Version:    0.7.0.1
 */