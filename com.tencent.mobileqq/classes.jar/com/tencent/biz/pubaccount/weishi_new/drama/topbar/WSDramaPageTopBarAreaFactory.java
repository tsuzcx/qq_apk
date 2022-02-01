package com.tencent.biz.pubaccount.weishi_new.drama.topbar;

import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import java.util.HashMap;
import java.util.Map;

public class WSDramaPageTopBarAreaFactory
{
  private static final Map<String, WSDramaPageTopBarAreaFactory.OnCreateTopBarControllerListener> a = new HashMap();
  
  static
  {
    a.put("grid_drama_card", new WSDramaPageTopBarAreaFactory.1());
  }
  
  public static AbsWsUIGroup<Object> a(WSDramaPageFragment paramWSDramaPageFragment, String paramString)
  {
    paramString = (WSDramaPageTopBarAreaFactory.OnCreateTopBarControllerListener)a.get(paramString);
    if (paramString != null) {
      return paramString.a(paramWSDramaPageFragment);
    }
    return new WSDramaCommonTopAreaController(paramWSDramaPageFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.topbar.WSDramaPageTopBarAreaFactory
 * JD-Core Version:    0.7.0.1
 */