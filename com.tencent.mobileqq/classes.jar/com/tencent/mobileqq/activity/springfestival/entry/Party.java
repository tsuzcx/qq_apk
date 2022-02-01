package com.tencent.mobileqq.activity.springfestival.entry;

public class Party
{
  public static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return "";
            }
            return "STATUS_BEYOND_PARTY";
          }
          return "STATUS_AFTER_PARTY";
        }
        return "STATUS_IN_PARTY";
      }
      return "STATUS_BEFORE_PARTY";
    }
    return "STATUS_BEFORE_CONFIG_READY";
  }
  
  public static String b(int paramInt)
  {
    if (paramInt != 2001)
    {
      if (paramInt != 2002)
      {
        if (paramInt != 3001)
        {
          if (paramInt != 3002)
          {
            if (paramInt != 4001)
            {
              if (paramInt != 4002)
              {
                if (paramInt != 5001)
                {
                  if (paramInt != 5002)
                  {
                    switch (paramInt)
                    {
                    default: 
                      return "";
                    case 1004: 
                      return "TASK_TYPE_ACTIVITY_OVER";
                    case 1003: 
                      return "TASK_TYPE_ACTIVITY_ABOUT_TO_OVER";
                    case 1002: 
                      return "TASK_TYPE_ACTIVITY_REAL_START";
                    }
                    return "TASK_TYPE_ACTIVITY_START";
                  }
                  return "TASK_TYPE_MSGTABBANNER_HIDE";
                }
                return "TASK_TYPE_MSGTABBANNER_SHOW";
              }
              return "TASK_TYPE_POPBANNER_HIDE";
            }
            return "TASK_TYPE_POPBANNER_SHOW";
          }
          return "TASK_TYPE_BREATHLIGHT_HIDE";
        }
        return "TASK_TYPE_BREATHLIGHT_SHOW";
      }
      return "TASK_TYPE_PENDANT_HIDE";
    }
    return "TASK_TYPE_PENDANT_SHOW";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.Party
 * JD-Core Version:    0.7.0.1
 */