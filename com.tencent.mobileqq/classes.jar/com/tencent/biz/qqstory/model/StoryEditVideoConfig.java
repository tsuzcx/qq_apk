package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.utils.JsonORM.Column;

public class StoryEditVideoConfig
{
  @JsonORM.Column(a="disable_revert")
  public StoryEditVideoConfig.Device[] a;
  @JsonORM.Column(a="disable_fast")
  public StoryEditVideoConfig.Device[] b;
  @JsonORM.Column(a="disable_slow")
  public StoryEditVideoConfig.Device[] c;
  @JsonORM.Column(a="disable_hw_encode")
  public StoryEditVideoConfig.Device[] d;
  @JsonORM.Column(a="disable_flow_decode")
  public StoryEditVideoConfig.Device[] e;
  @JsonORM.Column(a="use_flow_decode_first")
  public StoryEditVideoConfig.Device[] f;
  @JsonORM.Column(a="story_global_log_level")
  public String g;
  @JsonORM.Column(a="story_auto_play_report_control")
  public String h;
  @JsonORM.Column(a="story_home_preload_count")
  public int i;
  @JsonORM.Column(a="story_video_preload_duration")
  public int j;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryEditVideoConfig
 * JD-Core Version:    0.7.0.1
 */