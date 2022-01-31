package com.tencent.mobileqq;

import awbv;
import awdg;
import awdj;

public class DrawerPushItem
  extends awbv
{
  public static final int BUBBLE_PUSH_MSG_TYPE_AIO = 2;
  public static final int BUBBLE_PUSH_MSG_TYPE_AIO_GAME_PANEL = 9;
  public static final int BUBBLE_PUSH_MSG_TYPE_AIO_GAME_RED = 3;
  public static final int BUBBLE_PUSH_MSG_TYPE_AIO_GUIDE_3D = 10;
  public static final int BUBBLE_PUSH_MSG_TYPE_AIO_HOT_CHAT_GAME = 5;
  public static final int BUBBLE_PUSH_MSG_TYPE_AIO_PANEL_PUSH = 7;
  public static final int BUBBLE_PUSH_MSG_TYPE_AIO_PANEL_REDDOT = 4;
  public static final int BUBBLE_PUSH_MSG_TYPE_AIO_PANEL_SHOP = 6;
  public static final int BUBBLE_PUSH_MSG_TYPE_DRAWER = 1;
  public static final int BUBBLE_PUSH_MSG_TYPE_DRAWER_0 = 0;
  public static final int BUBBLE_PUSH_MSG_TYPE_DRAWER_GAME_BOX = 8;
  public static final int BUBBLE_ROLE_TYPE_2D = 2;
  public static final int BUBBLE_ROLE_TYPE_3D = 3;
  public static final int BUBBLE_ROLE_TYPE_DEFAULT = 0;
  public String act_id;
  public int action_id;
  public int bubble_res_id;
  public int color;
  public String content;
  public int end_ts;
  public String ext_url;
  public String icon_url;
  public int is_reddot;
  public int life_Time;
  @awdj
  public String msg_id;
  public int msg_type;
  public int priority;
  public int reddotGameId;
  public String reddotPath;
  @awdg
  public int reddotRedId;
  public String scheme;
  public int send_time;
  public int show_counts;
  public int show_sum;
  public int start_ts;
  public int sub_priority;
  public int target_model;
  public int tianshuAdId;
  public String tianshuTraceInfo;
  public String tips_str;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(300);
    localStringBuilder.append("msgType:").append(this.msg_type).append("id:").append(this.msg_id).append(",priority:").append(this.priority).append(",sub_priority:").append(this.sub_priority).append(",start_ts:").append(this.start_ts).append(",end_ts:").append(this.end_ts).append(",send_time:").append(this.send_time).append(",action_id:").append(this.action_id).append(",content:").append(this.content).append(",scheme:").append(this.scheme).append(",ext_url:").append(this.ext_url).append(",show_counts:").append(this.show_counts).append(",show_sum:").append(this.show_sum).append(",is_reddot:").append(this.is_reddot).append(",bubble_res_id:").append(this.bubble_res_id).append(",color:").append(this.color).append(",iconUrl:").append(this.icon_url).append(", lifeTime:").append(this.life_Time).append(",tips:").append(this.tips_str).append(",reddotGameId:").append(this.reddotGameId);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.DrawerPushItem
 * JD-Core Version:    0.7.0.1
 */