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
  public static final String[] a;
  protected int a;
  public long a;
  public FeedFeatureItem a;
  protected String a;
  protected ArrayList<StoryVideoItem> a;
  protected HashMap<String, StoryVideoItem> a;
  protected boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public int f;
  public int g;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = StoryApi.a(2130968664);
  }
  
  public MyStorys()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem = new FeedFeatureItem();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public StoryVideoItem a(String paramString)
  {
    return (StoryVideoItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public String a(int paramInt, TextPaint paramTextPaint)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = this.jdField_c_of_type_Int;
    int m = this.e;
    int n = this.jdField_d_of_type_Int;
    long l2 = this.jdField_a_of_type_Long;
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            int k = m;
            i = n;
            long l1 = l2;
            if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
            {
              localStringBuilder.append("最近");
              int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
              localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem;
              j = i1;
              k = m;
              i = n;
              l1 = l2;
              if (localObject != null)
              {
                k = ((FeedFeatureItem)localObject).jdField_b_of_type_Int;
                i = this.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_Int;
                l1 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_c_of_type_Int;
                j = i1;
              }
            }
            localStringBuilder.append(UIUtils.a(j));
            localStringBuilder.append("个小视频");
            Object localObject = localStringBuilder.toString();
            if (l1 > 0L)
            {
              localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[0]);
              localStringBuilder.append("浏览");
              localStringBuilder.append(l1);
            }
            if ((paramTextPaint != null) && (paramTextPaint.measureText(localStringBuilder.toString()) > paramInt)) {
              return localObject;
            }
            localObject = localStringBuilder.toString();
            if (i > 0)
            {
              localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[1]);
              localStringBuilder.append("赞");
              localStringBuilder.append(UIUtils.a(i));
            }
            if ((paramTextPaint != null) && (paramTextPaint.measureText(localStringBuilder.toString()) > paramInt)) {
              return localObject;
            }
            localObject = localStringBuilder.toString();
            if (k > 0)
            {
              localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[1]);
              localStringBuilder.append("评论");
              localStringBuilder.append(UIUtils.a(k));
            }
            if ((paramTextPaint != null) && (paramTextPaint.measureText(localStringBuilder.toString()) > paramInt)) {
              return localObject;
            }
          }
        }
        else if (this.jdField_a_of_type_Boolean)
        {
          localStringBuilder.append(UIUtils.a(j));
          localStringBuilder.append("个小视频");
          if (this.jdField_a_of_type_Long > 0L)
          {
            localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[0]);
            localStringBuilder.append("浏览");
            localStringBuilder.append(this.jdField_a_of_type_Long);
          }
          if (this.jdField_d_of_type_Int > 0)
          {
            localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[1]);
            localStringBuilder.append("赞");
            localStringBuilder.append(UIUtils.a(this.jdField_d_of_type_Int));
          }
          if (this.e > 0)
          {
            localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[1]);
            localStringBuilder.append("评论");
            localStringBuilder.append(UIUtils.a(this.e));
          }
        }
        else
        {
          localStringBuilder.append(UIUtils.a(this.f));
          localStringBuilder.append("个小视频发送失败");
        }
        return localStringBuilder.toString();
      }
      if (this.jdField_a_of_type_Boolean)
      {
        localStringBuilder.append(UIUtils.a(j));
        localStringBuilder.append("个小视频");
        return localStringBuilder.toString();
      }
      localStringBuilder.append(StoryApi.a(2131699932, new Object[] { Integer.valueOf(this.g) }));
      return localStringBuilder.toString();
    }
    if (j == 0) {
      return StoryApi.a(2131699918);
    }
    localStringBuilder.append(UIUtils.a(j));
    localStringBuilder.append("个小视频");
    if (j > 0)
    {
      localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[0]);
      localStringBuilder.append("浏览");
      localStringBuilder.append(this.jdField_a_of_type_Long);
    }
    return localStringBuilder.toString();
  }
  
  public ArrayList<StoryVideoItem> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    GetUserSelfInfoStep.a(this);
    this.jdField_a_of_type_Int = 0;
    this.f = 0;
    this.jdField_d_of_type_Boolean = false;
    this.g = 0;
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject).next();
        int i = StoryListUtils.a(localStoryVideoItem.mUploadStatus);
        if ((i == 1) || (i == 0))
        {
          this.jdField_a_of_type_Int = 1;
          this.g += 1;
        }
        if (localStoryVideoItem.isUploadFail()) {
          this.f += 1;
        }
        if (!TextUtils.isEmpty(localStoryVideoItem.mDoodleText)) {
          this.jdField_d_of_type_Boolean = true;
        }
      }
      if (this.jdField_a_of_type_Int == 1) {
        return;
      }
      if (this.f > 0)
      {
        this.jdField_a_of_type_Int = 2;
        return;
      }
      this.jdField_a_of_type_Int = 3;
      return;
    }
    if (this.jdField_c_of_type_Int <= 0) {
      return;
    }
    this.jdField_a_of_type_Int = 3;
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(0, paramStoryVideoItem);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
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
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).mVid.equals(paramString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, paramStoryVideoItem);
        return;
      }
      i += 1;
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
          this.jdField_a_of_type_JavaUtilArrayList.add(localStoryVideoItem);
          this.jdField_a_of_type_JavaUtilHashMap.put(localStoryVideoItem.mVid, localStoryVideoItem);
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
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).mVid.equals(paramStoryVideoItem.mVid))
      {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, paramStoryVideoItem);
        return;
      }
      i += 1;
    }
  }
  
  public void c(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramStoryVideoItem.mVid);
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int i;
        for (;;)
        {
          throw paramStoryVideoItem;
        }
        i += 1;
      }
    }
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (!((StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).mVid.equals(paramStoryVideoItem.mVid)) {
        break label160;
      }
      this.jdField_a_of_type_JavaUtilArrayList.remove(i);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem != null))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_c_of_type_Int = 0;
      paramStoryVideoItem = (StoryConfigManager)SuperManager.a(10);
      paramStoryVideoItem.b("qqstory_my_visiter_count", Integer.valueOf(0));
      paramStoryVideoItem.b("qqstory_my_newest_video_cover", "");
      paramStoryVideoItem.b("qqstory_my_newest_video_vid", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys
 * JD-Core Version:    0.7.0.1
 */