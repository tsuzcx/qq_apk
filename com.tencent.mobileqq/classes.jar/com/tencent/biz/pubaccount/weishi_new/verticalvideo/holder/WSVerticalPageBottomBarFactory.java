package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.util.HashMap;
import java.util.Map;

public class WSVerticalPageBottomBarFactory
{
  private static final Map<String, WSVerticalPageBottomBarFactory.OnCreateTopBarControllerListener> a = new HashMap();
  
  static
  {
    a.put("vertical_layer_collection", new WSVerticalPageBottomBarFactory.1());
    a.put("vertical_layer_collection_of_card", new WSVerticalPageBottomBarFactory.2());
    a.put("drama_preview", new WSVerticalPageBottomBarFactory.3());
    a.put("drama_history", new WSVerticalPageBottomBarFactory.4());
    a.put("drama_collection", new WSVerticalPageBottomBarFactory.5());
  }
  
  public static AbsWsUIGroup<WSVerticalItemData> a(WSVerticalPageFragment paramWSVerticalPageFragment, String paramString, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    paramString = (WSVerticalPageBottomBarFactory.OnCreateTopBarControllerListener)a.get(paramString);
    if (paramString != null) {
      return paramString.a(paramWSVerticalPageFragment, paramWSVerticalVideoHolder);
    }
    return new WSVerticalItemBottomCollectionController(paramWSVerticalPageFragment.getActivity(), paramWSVerticalVideoHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalPageBottomBarFactory
 * JD-Core Version:    0.7.0.1
 */