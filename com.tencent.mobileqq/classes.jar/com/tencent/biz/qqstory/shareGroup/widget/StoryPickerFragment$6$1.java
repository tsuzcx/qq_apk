package com.tencent.biz.qqstory.shareGroup.widget;

import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;

class StoryPickerFragment$6$1
  implements Runnable
{
  StoryPickerFragment$6$1(StoryPickerFragment.6 param6, String paramString, ArrayList paramArrayList1, int paramInt, ArrayList paramArrayList2, boolean paramBoolean) {}
  
  public void run()
  {
    StoryPlayerLauncher.a(this.f.e.getBaseActivity(), this.a, this.f.b.a, this.b, this.c, this.f.c, this.d, new ArrayList(this.f.e.f), this.f.d, this.e, 86, String.valueOf(this.f.e.e.hashCode()));
    SLog.b("StoryPickerFragment", "go to player , collection key = %s, feedIds = %s , vid = %s , keyIndex = %s , video pos = %d , keyList = %s", new Object[] { this.f.a, this.d, this.f.b.a, Integer.valueOf(this.c), Integer.valueOf(this.f.c), this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment.6.1
 * JD-Core Version:    0.7.0.1
 */