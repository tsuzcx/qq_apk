package com.tencent.mobileqq.apollo.data;

import aukm;
import auma;
import java.io.Serializable;

public class CmGamePushItem
  extends aukm
  implements Serializable
{
  public static final int CMGAME_PUSH_FRAMEWORK_PROMOTION = 1;
  private static final long serialVersionUID = 1L;
  public String act_id;
  public String content;
  public int end_ts;
  public boolean isShow;
  public int is_show_red;
  @auma
  public String msg_id;
  public int msg_type;
  public int send_time;
  public int start_ts;
  public String url;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(300);
    localStringBuilder.append("msg_id:").append(this.msg_id).append(",start_ts:").append(this.start_ts).append(",end_ts:").append(this.end_ts).append(",content:").append(this.content).append(",is_show_red:").append(this.is_show_red).append(",isShow:").append(this.isShow).append(",msg_type:").append(this.msg_type).append(",url:").append(this.url);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.data.CmGamePushItem
 * JD-Core Version:    0.7.0.1
 */