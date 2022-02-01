package com.tencent.biz.qqstory.msgTabNode.view;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.DateUtils;

public class MsgTabStoryNodeListManager$MsgTabShowCounter
{
  public int a = 0;
  public String b = "";
  public int c = 0;
  
  public MsgTabStoryNodeListManager$MsgTabShowCounter()
  {
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    String str = DateUtils.a();
    this.b = ((String)localStoryConfigManager.c("key_story_msg_tab_autoshow_date", this.b));
    this.a = ((Integer)localStoryConfigManager.c("key_story_msg_tab_autoshow_count", Integer.valueOf(this.a))).intValue();
    this.c = ((Integer)localStoryConfigManager.c("key_story_msg_tab_autoshow_quota", Integer.valueOf(this.c))).intValue();
    if (!TextUtils.equals(this.b, str))
    {
      this.b = str;
      this.a = 0;
      localStoryConfigManager.d("key_story_msg_tab_autoshow_date", this.b);
      localStoryConfigManager.d("key_story_msg_tab_autoshow_count", Integer.valueOf(this.a));
    }
    SLog.a(MsgTabStoryNodeListManager.o(), "MsgTabShowCounter(): %d/%d @ %s", Integer.valueOf(this.a), Integer.valueOf(this.c), this.b);
  }
  
  public boolean a()
  {
    c();
    SLog.a(MsgTabStoryNodeListManager.o(), "shouldAutoShow(): %d/%d @ %s", Integer.valueOf(this.a), Integer.valueOf(this.c), this.b);
    return this.a < this.c;
  }
  
  public void b()
  {
    c();
    this.a += 1;
    ((StoryConfigManager)SuperManager.a(10)).d("key_story_msg_tab_autoshow_count", Integer.valueOf(this.a));
    SLog.a(MsgTabStoryNodeListManager.o(), "addAutoShowCount(): %d/%d @ %s", Integer.valueOf(this.a), Integer.valueOf(this.c), this.b);
  }
  
  public void c()
  {
    String str = DateUtils.a();
    if (!TextUtils.equals(str, this.b))
    {
      StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
      this.b = str;
      this.a = 0;
      localStoryConfigManager.d("key_story_msg_tab_autoshow_date", this.b);
      localStoryConfigManager.d("key_story_msg_tab_autoshow_count", Integer.valueOf(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.MsgTabShowCounter
 * JD-Core Version:    0.7.0.1
 */