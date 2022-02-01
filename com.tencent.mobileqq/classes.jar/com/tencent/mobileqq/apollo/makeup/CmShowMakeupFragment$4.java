package com.tencent.mobileqq.apollo.makeup;

import com.tencent.crossengine.CEJSEventListener;
import com.tencent.mobileqq.cmshow.crossengine.CEScriptService;
import com.tencent.mobileqq.cmshow.crossengine.util.CEChannelUtil;

class CmShowMakeupFragment$4
  implements CEJSEventListener
{
  CmShowMakeupFragment$4(CmShowMakeupFragment paramCmShowMakeupFragment) {}
  
  public String onScriptEvent(String paramString1, String paramString2)
  {
    return CEChannelUtil.a.a(CmShowMakeupFragment.g(this.a).a(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment.4
 * JD-Core Version:    0.7.0.1
 */