package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorFilter;

class TroopChatPie$TroopFileErrorFilterForChatActivity
  implements TroopFileError.TroopFileErrorFilter
{
  public String a;
  
  public TroopChatPie$TroopFileErrorFilterForChatActivity(String paramString)
  {
    this.a = paramString;
  }
  
  public long a()
  {
    try
    {
      long l = Long.parseLong(this.a);
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.TroopFileErrorFilterForChatActivity
 * JD-Core Version:    0.7.0.1
 */