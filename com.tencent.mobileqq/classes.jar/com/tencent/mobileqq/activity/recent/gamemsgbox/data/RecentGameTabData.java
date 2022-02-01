package com.tencent.mobileqq.activity.recent.gamemsgbox.data;

import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import java.util.HashMap;

public class RecentGameTabData
  implements Comparable<RecentGameTabData>
{
  private static final HashMap<String, Integer> c = new HashMap();
  public GameDetailInfo a;
  public GameSwitchConfig b;
  
  static
  {
    c.put("1104466820", Integer.valueOf(1));
    c.put("1106467070", Integer.valueOf(2));
    c.put("1106838536", Integer.valueOf(3));
    c.put("1105371489", Integer.valueOf(4));
    c.put("1109807272", Integer.valueOf(5));
  }
  
  public int a(RecentGameTabData paramRecentGameTabData)
  {
    if (!c.containsKey(this.a.c)) {
      return 1;
    }
    if (!c.containsKey(paramRecentGameTabData.a.c)) {
      return -1;
    }
    return ((Integer)c.get(this.a.c)).intValue() - ((Integer)c.get(paramRecentGameTabData.a.c)).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentGameTabData
 * JD-Core Version:    0.7.0.1
 */