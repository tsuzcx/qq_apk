package com.tencent.mobileqq;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;

public class DrawerPushItem
  extends Entity
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
  public boolean fromTianshu;
  public String icon_url;
  public int is_reddot;
  public int life_Time;
  @unique
  public String msg_id;
  public int msg_type;
  public int priority;
  public int reddotGameId;
  public String reddotPath;
  @notColumn
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
  
  public boolean isValid()
  {
    long l = System.currentTimeMillis() / 1000L;
    return (this.start_ts < l) && (this.end_ts > l) && (this.show_sum < this.show_counts);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("DrawerPushItem{");
    localStringBuffer.append("msg_id='");
    localStringBuffer.append(this.msg_id);
    localStringBuffer.append('\'');
    localStringBuffer.append(", priority=");
    localStringBuffer.append(this.priority);
    localStringBuffer.append(", sub_priority=");
    localStringBuffer.append(this.sub_priority);
    localStringBuffer.append(", start_ts=");
    localStringBuffer.append(this.start_ts);
    localStringBuffer.append(", end_ts=");
    localStringBuffer.append(this.end_ts);
    localStringBuffer.append(", send_time=");
    localStringBuffer.append(this.send_time);
    localStringBuffer.append(", action_id=");
    localStringBuffer.append(this.action_id);
    localStringBuffer.append(", content='");
    localStringBuffer.append(this.content);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scheme='");
    localStringBuffer.append(this.scheme);
    localStringBuffer.append('\'');
    localStringBuffer.append(", ext_url='");
    localStringBuffer.append(this.ext_url);
    localStringBuffer.append('\'');
    localStringBuffer.append(", color=");
    localStringBuffer.append(this.color);
    localStringBuffer.append(", show_counts=");
    localStringBuffer.append(this.show_counts);
    localStringBuffer.append(", show_sum=");
    localStringBuffer.append(this.show_sum);
    localStringBuffer.append(", life_Time=");
    localStringBuffer.append(this.life_Time);
    localStringBuffer.append(", is_reddot=");
    localStringBuffer.append(this.is_reddot);
    localStringBuffer.append(", bubble_res_id=");
    localStringBuffer.append(this.bubble_res_id);
    localStringBuffer.append(", icon_url='");
    localStringBuffer.append(this.icon_url);
    localStringBuffer.append('\'');
    localStringBuffer.append(", msg_type=");
    localStringBuffer.append(this.msg_type);
    localStringBuffer.append(", act_id='");
    localStringBuffer.append(this.act_id);
    localStringBuffer.append('\'');
    localStringBuffer.append(", tips_str='");
    localStringBuffer.append(this.tips_str);
    localStringBuffer.append('\'');
    localStringBuffer.append(", target_model=");
    localStringBuffer.append(this.target_model);
    localStringBuffer.append(", fromTianshu=");
    localStringBuffer.append(this.fromTianshu);
    localStringBuffer.append(", tianshuAdId=");
    localStringBuffer.append(this.tianshuAdId);
    localStringBuffer.append(", tianshuTraceInfo='");
    localStringBuffer.append(this.tianshuTraceInfo);
    localStringBuffer.append('\'');
    localStringBuffer.append(", reddotPath='");
    localStringBuffer.append(this.reddotPath);
    localStringBuffer.append('\'');
    localStringBuffer.append(", reddotGameId=");
    localStringBuffer.append(this.reddotGameId);
    localStringBuffer.append(", reddotRedId=");
    localStringBuffer.append(this.reddotRedId);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.DrawerPushItem
 * JD-Core Version:    0.7.0.1
 */