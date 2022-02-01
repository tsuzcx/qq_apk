package com.tencent.common.wormhole.node;

import com.tencent.common.wormhole.WormholeManager;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.StyleNode;

public class TKDWormholeNode
  extends StyleNode
{
  private final boolean a;
  private String b;
  private int c;
  
  public TKDWormholeNode(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a = paramBoolean;
    this.b = paramString;
    this.c = paramInt;
  }
  
  public boolean isVirtual()
  {
    return this.a;
  }
  
  public void setProps(HippyMap paramHippyMap)
  {
    super.setProps(paramHippyMap);
    paramHippyMap.pushInt("rootTag", this.c);
    paramHippyMap = paramHippyMap.getMap("params");
    if (paramHippyMap != null)
    {
      paramHippyMap.pushString("wormholeId", this.b);
      WormholeManager.a().a(paramHippyMap, this.b, Integer.valueOf(getId()), this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.node.TKDWormholeNode
 * JD-Core Version:    0.7.0.1
 */