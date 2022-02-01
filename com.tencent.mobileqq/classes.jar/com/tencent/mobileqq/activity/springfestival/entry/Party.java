package com.tencent.mobileqq.activity.springfestival.entry;

public class Party
{
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "STATUS_BEFORE_CONFIG_READY";
    case 1: 
      return "STATUS_BEFORE_PARTY";
    case 2: 
      return "STATUS_IN_PARTY";
    case 3: 
      return "STATUS_AFTER_PARTY";
    }
    return "STATUS_BEYOND_PARTY";
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1001: 
      return "TASK_TYPE_ACTIVITY_START";
    case 1002: 
      return "TASK_TYPE_ACTIVITY_REAL_START";
    case 1003: 
      return "TASK_TYPE_ACTIVITY_ABOUT_TO_OVER";
    case 1004: 
      return "TASK_TYPE_ACTIVITY_OVER";
    case 2001: 
      return "TASK_TYPE_PENDANT_SHOW";
    case 2002: 
      return "TASK_TYPE_PENDANT_HIDE";
    case 3001: 
      return "TASK_TYPE_BREATHLIGHT_SHOW";
    case 3002: 
      return "TASK_TYPE_BREATHLIGHT_HIDE";
    case 4001: 
      return "TASK_TYPE_POPBANNER_SHOW";
    case 4002: 
      return "TASK_TYPE_POPBANNER_HIDE";
    case 5001: 
      return "TASK_TYPE_MSGTABBANNER_SHOW";
    }
    return "TASK_TYPE_MSGTABBANNER_HIDE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.Party
 * JD-Core Version:    0.7.0.1
 */