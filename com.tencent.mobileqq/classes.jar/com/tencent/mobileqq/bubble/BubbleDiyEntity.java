package com.tencent.mobileqq.bubble;

import android.text.TextUtils;
import awge;
import awhs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class BubbleDiyEntity
  extends awge
{
  public String bottomLeftId;
  public String bottomRightId;
  public String diyText = "";
  public String topLeftId;
  public String topRightId;
  @awhs
  public String uinAndDiyId;
  
  public static void parsePasterMap(BubbleDiyEntity paramBubbleDiyEntity, HashMap<String, String> paramHashMap)
  {
    if ((paramBubbleDiyEntity == null) || (paramHashMap == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ("TL".equalsIgnoreCase(str)) {
          paramBubbleDiyEntity.topLeftId = ((String)paramHashMap.get(str));
        } else if ("TR".equalsIgnoreCase(str)) {
          paramBubbleDiyEntity.topRightId = ((String)paramHashMap.get(str));
        } else if ("BL".equalsIgnoreCase(str)) {
          paramBubbleDiyEntity.bottomLeftId = ((String)paramHashMap.get(str));
        } else if ("BR".equalsIgnoreCase(str)) {
          paramBubbleDiyEntity.bottomRightId = ((String)paramHashMap.get(str));
        }
      }
    }
  }
  
  public HashMap<String, String> convertToPasterMap()
  {
    HashMap localHashMap = new HashMap(4);
    if (!TextUtils.isEmpty(this.topLeftId)) {
      localHashMap.put("TL", this.topLeftId);
    }
    if (!TextUtils.isEmpty(this.topRightId)) {
      localHashMap.put("TR", this.topRightId);
    }
    if (!TextUtils.isEmpty(this.bottomLeftId)) {
      localHashMap.put("BL", this.bottomLeftId);
    }
    if (!TextUtils.isEmpty(this.bottomRightId)) {
      localHashMap.put("BR", this.bottomRightId);
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyEntity
 * JD-Core Version:    0.7.0.1
 */