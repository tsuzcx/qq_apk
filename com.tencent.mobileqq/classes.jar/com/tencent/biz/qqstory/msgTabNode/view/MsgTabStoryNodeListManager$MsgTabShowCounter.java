package com.tencent.biz.qqstory.msgTabNode.view;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.DateUtils;

public class MsgTabStoryNodeListManager$MsgTabShowCounter
{
  public int a;
  public String a;
  public int b = 0;
  
  public MsgTabStoryNodeListManager$MsgTabShowCounter()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    String str = DateUtils.a();
    this.jdField_a_of_type_JavaLangString = ((String)localStoryConfigManager.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Int = ((Integer)localStoryConfigManager.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int))).intValue();
    this.b = ((Integer)localStoryConfigManager.b("key_story_msg_tab_autoshow_quota", Integer.valueOf(this.b))).intValue();
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, str))
    {
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Int = 0;
      localStoryConfigManager.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString);
      localStoryConfigManager.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    }
    SLog.a(MsgTabStoryNodeListManager.b(), "MsgTabShowCounter(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_Int += 1;
    ((StoryConfigManager)SuperManager.a(10)).b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    SLog.a(MsgTabStoryNodeListManager.b(), "addAutoShowCount(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    b();
    SLog.a(MsgTabStoryNodeListManager.b(), "shouldAutoShow(): %d/%d @ %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString);
    return this.jdField_a_of_type_Int < this.b;
  }
  
  public void b()
  {
    String str = DateUtils.a();
    if (!TextUtils.equals(str, this.jdField_a_of_type_JavaLangString))
    {
      StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Int = 0;
      localStoryConfigManager.b("key_story_msg_tab_autoshow_date", this.jdField_a_of_type_JavaLangString);
      localStoryConfigManager.b("key_story_msg_tab_autoshow_count", Integer.valueOf(this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.MsgTabShowCounter
 * JD-Core Version:    0.7.0.1
 */