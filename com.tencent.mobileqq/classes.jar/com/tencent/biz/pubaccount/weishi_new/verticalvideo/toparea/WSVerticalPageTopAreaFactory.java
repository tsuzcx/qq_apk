package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import java.util.HashMap;
import java.util.Map;

public class WSVerticalPageTopAreaFactory
{
  private static final Map<String, WSVerticalPageTopAreaFactory.OnCreateTopBarControllerListener> a = new HashMap();
  
  static
  {
    a.put("aio_home_page", new WSVerticalPageTopAreaFactory.1());
    a.put("vertical_layer_collection_of_card", new WSVerticalPageTopAreaFactory.2());
    a.put("vertical_layer_collection", new WSVerticalPageTopAreaFactory.3());
    a.put("qqchat", new WSVerticalPageTopAreaFactory.4());
    a.put("trends", new WSVerticalPageTopAreaFactory.5());
    a.put("share", new WSVerticalPageTopAreaFactory.6());
    a.put("qq_scheme_open_player", new WSVerticalPageTopAreaFactory.7());
    a.put("drama_preview", new WSVerticalPageTopAreaFactory.8());
    a.put("drama_history", new WSVerticalPageTopAreaFactory.9());
    a.put("drama_collection", new WSVerticalPageTopAreaFactory.10());
  }
  
  public static AbsWsUIGroup<Object> a(WSVerticalPageFragment paramWSVerticalPageFragment, String paramString)
  {
    paramString = (WSVerticalPageTopAreaFactory.OnCreateTopBarControllerListener)a.get(paramString);
    if (paramString != null) {
      return paramString.a(paramWSVerticalPageFragment);
    }
    return new WSVerticalPageCommonTopAreaController(paramWSVerticalPageFragment.getActivity(), paramWSVerticalPageFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageTopAreaFactory
 * JD-Core Version:    0.7.0.1
 */