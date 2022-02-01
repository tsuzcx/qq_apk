package com.tencent.biz.qqstory.newshare.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.HashMap;
import java.util.Map;

public class ShareData
{
  public final String b;
  public int c;
  public Map<String, String> d;
  public StoryVideoItem e;
  
  public ShareData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.qqstory.share.");
    localStringBuilder.append(getClass().getSimpleName());
    this.b = localStringBuilder.toString();
    this.d = new HashMap();
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.d.put(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.model.ShareData
 * JD-Core Version:    0.7.0.1
 */