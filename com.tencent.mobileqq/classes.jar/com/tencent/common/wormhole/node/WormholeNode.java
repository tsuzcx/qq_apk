package com.tencent.common.wormhole.node;

import android.text.TextUtils;
import com.tencent.common.wormhole.WormholeManager;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.StyleNode;

public class WormholeNode
  extends StyleNode
{
  private final boolean a;
  private String b;
  
  public WormholeNode(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean isVirtual()
  {
    return this.a;
  }
  
  public void setProps(HippyMap paramHippyMap)
  {
    super.setProps(paramHippyMap);
    if (TextUtils.isEmpty(this.b)) {
      this.b = WormholeManager.a().a(paramHippyMap, Integer.valueOf(getId()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.node.WormholeNode
 * JD-Core Version:    0.7.0.1
 */