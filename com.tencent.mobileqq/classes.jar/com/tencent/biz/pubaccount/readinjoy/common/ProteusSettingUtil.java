package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import cooperation.readinjoy.ReadInJoyHelper;

public class ProteusSettingUtil
{
  public static boolean a = true;
  
  static
  {
    if (!ReadInJoyHelper.k()) {}
    for (a = false;; a = true)
    {
      a();
      return;
    }
  }
  
  public static void a()
  {
    StringCommon.a("cmd_dislike_click", 1001);
    StringCommon.a("cmd_like_click", 1002);
    StringCommon.a("cmd_comment_click", 1003);
    StringCommon.a("cmd_biu_click", 1004);
    StringCommon.a("cmd_topic_recommend_header_click", 1005);
    StringCommon.a("cmd_follow_click", 1006);
    StringCommon.a("cmd_summary_click", 1007);
    StringCommon.a("cmd_article_wrapper_click", 1008);
    StringCommon.a("setArticleModel:", 1009);
    StringCommon.a("cmd_jump_wrapper_click", 1010);
    ImageCommon.a("mengceng.png", 2130839750);
    ImageCommon.a("pa_video_play.png", 2130840883);
    ImageCommon.a("qq_readinjoy_gallery_count", 2130843044);
    ImageCommon.a("public_account_video_profile", 2130839765);
    ImageCommon.a("public_account_small_video_mengceng", 2130839733);
    ImageCommon.a("like_normal", 2130843272);
    ImageCommon.a("like_active", 2130843269);
    ImageCommon.a("comment", 2130843267);
    ImageCommon.a("comment_active", 2130843268);
    ImageCommon.a("biu_icon", 2130840683);
    ImageCommon.a("biu_icon_active", 2130840684);
    ImageCommon.a("green_v.png", 2130840754);
    ImageCommon.a("feeds_dislike", 2130840810);
    ImageCommon.a("topic_pre_image", 2130840771);
    ImageCommon.a("topic_arrow_image", 2130840800);
    ImageCommon.a("small_video_play_icon", 2130840843);
  }
  
  public static boolean a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ProteusSettingUtil
 * JD-Core Version:    0.7.0.1
 */