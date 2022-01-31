package com.tencent.mobileqq.activity.aio.qwallet.elem;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;

public class ResPathRedPkgElem
  extends BaseRedPkgElem
{
  public String b;
  
  public ResPathRedPkgElem(String paramString)
  {
    super(paramString);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null) {
      this.b = paramRedPacketInfo.resPath;
    }
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.elem.ResPathRedPkgElem
 * JD-Core Version:    0.7.0.1
 */