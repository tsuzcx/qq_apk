package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.app.Activity;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import java.util.ArrayList;

class MemoriesVideoListSegment$2$1
  implements Runnable
{
  MemoriesVideoListSegment$2$1(MemoriesVideoListSegment.2 param2, ArrayList paramArrayList1, int paramInt, ArrayList paramArrayList2, QQUserUIItem paramQQUserUIItem) {}
  
  public void run()
  {
    Object localObject = new OpenPlayerBuilder(new MemoriesFeedPlayInfo(MemoriesVideoListSegment.a(this.e.e).a, (String)this.a.get(this.b), this.e.b, String.valueOf(MemoriesVideoListSegment.a(this.e.e).hashCode()), this.c, MemoriesVideoListSegment.a(this.e.e).f, 0), StoryMemoriesFragment.a(this.e.e.a));
    ((OpenPlayerBuilder)localObject).a(MemoriesVideoListSegment.b(this.e.e));
    ((OpenPlayerBuilder)localObject).c();
    StoryPlayerLauncher.a((Activity)MemoriesVideoListSegment.c(this.e.e), ((OpenPlayerBuilder)localObject).f(), this.e.d);
    if (this.d == null)
    {
      SLog.d("Q.qqstory.memories.MemoriesVideoListSegment", "userManager returns null with id %s", new Object[] { MemoriesVideoListSegment.a(this.e.e).a });
      return;
    }
    int i = StoryMemoriesFragment.a(this.e.e.a);
    if (this.d.isMe()) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    StoryReportor.a("memory", "clk_video", i, 0, new String[] { localObject, "", "", this.e.b });
    SLog.b("Q.qqstory.memories.MemoriesVideoListSegment", "go to player , collection key = %s, feedIds = %s , vid = %s , keyIndex = %s , video pos = %d , keyList = %s", new Object[] { this.e.a, this.a, this.e.b, Integer.valueOf(this.b), Integer.valueOf(this.e.c), this.c });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.2.1
 * JD-Core Version:    0.7.0.1
 */