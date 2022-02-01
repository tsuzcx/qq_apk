package com.tencent.mobileqq.activity.aio.qwallet.elem;

import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;

public class ThemeRedPkgElem
  extends BaseRedPkgElem
{
  public AnimationView.AnimationInfo a;
  public String b;
  
  public ThemeRedPkgElem(String paramString)
  {
    super(paramString);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.b = paramRedPacketInfo.background;
      this.a = paramRedPacketInfo.animInfo;
    }
  }
  
  public boolean a()
  {
    return (this.b != null) || (this.a != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.elem.ThemeRedPkgElem
 * JD-Core Version:    0.7.0.1
 */