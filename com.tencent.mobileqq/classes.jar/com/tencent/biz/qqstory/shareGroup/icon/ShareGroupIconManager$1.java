package com.tencent.biz.qqstory.shareGroup.icon;

import android.util.LruCache;

class ShareGroupIconManager$1
  extends LruCache<String, ShareGroupDrawableState>
{
  ShareGroupIconManager$1(ShareGroupIconManager paramShareGroupIconManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, ShareGroupDrawableState paramShareGroupDrawableState1, ShareGroupDrawableState paramShareGroupDrawableState2)
  {
    super.entryRemoved(paramBoolean, paramString, paramShareGroupDrawableState1, paramShareGroupDrawableState2);
    paramShareGroupDrawableState2 = new StringBuilder();
    paramShareGroupDrawableState2.append("entryRemoved key = %s");
    paramShareGroupDrawableState2.append(paramString);
    IconLog.a("story.icon.ShareGroupIconManager", paramShareGroupDrawableState2.toString());
    paramShareGroupDrawableState1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager.1
 * JD-Core Version:    0.7.0.1
 */