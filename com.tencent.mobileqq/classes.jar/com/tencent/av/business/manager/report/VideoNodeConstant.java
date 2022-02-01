package com.tencent.av.business.manager.report;

public class VideoNodeConstant
{
  public static final String a(int paramInt)
  {
    if (paramInt != 0)
    {
      switch (paramInt)
      {
      default: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("");
        return localStringBuilder.toString();
      case 47: 
        return "is_mic_peer_open";
      case 46: 
        return "is_mic_self_open";
      case 45: 
        return "is_camera_peer_open";
      case 44: 
        return "is_camera_self_open";
      case 43: 
        return "is_effects";
      case 42: 
        return "memory_remain_percen";
      case 41: 
        return "memory_level";
      case 40: 
        return "report_version";
      case 39: 
        return "node_action_timeout";
      case 38: 
        return "node_action_reject";
      case 37: 
        return "node_action_accept";
      case 36: 
        return "node_sdk_recv";
      case 35: 
        return "node_msf_recv";
      case 34: 
        return "node_intent_recv";
      case 33: 
        return "node_session_close";
      case 32: 
        return "node_ui_small";
      case 31: 
        return "node_ui_talk";
      case 30: 
        return "node_sdk_connect";
      case 29: 
        return "node_ui_call";
      case 28: 
        return "node_sdk_req";
      case 27: 
        return "node_process_create";
      case 26: 
        return "node_ui_init";
      case 25: 
        return "node_entrance";
      case 24: 
        return "duration";
      case 23: 
        return "memory_usage";
      case 22: 
        return "memory_left";
      case 21: 
        return "memory_total";
      case 20: 
        return "is_foreground";
      case 19: 
        return "is_lock_screen";
      case 18: 
        return "battery";
      case 17: 
        return "current_node";
      case 16: 
        return "process_exit_reason";
      case 15: 
        return "session_type";
      case 14: 
        return "business_id";
      case 13: 
        return "business_type";
      case 12: 
        return "role";
      case 11: 
        return "peer_uin";
      case 10: 
        return "self_uin";
      }
      return "roomid";
    }
    return "report_status";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeConstant
 * JD-Core Version:    0.7.0.1
 */