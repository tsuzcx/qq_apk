package com.tencent.mobileqq.apollo.api.model;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class CmGamePushItem
  extends Entity
  implements Serializable
{
  public static final int CMGAME_PUSH_FRAMEWORK_PROMOTION = 1;
  private static final long serialVersionUID = 1L;
  public String act_id;
  public String content;
  public int end_ts;
  public boolean isShow = false;
  public int is_show_red;
  @unique
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.CmGamePushItem
 * JD-Core Version:    0.7.0.1
 */