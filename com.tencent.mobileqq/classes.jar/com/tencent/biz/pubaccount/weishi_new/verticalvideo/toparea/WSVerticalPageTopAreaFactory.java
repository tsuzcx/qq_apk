package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class WSVerticalPageTopAreaFactory
{
  public static AbsWsUIGroup<Object> a(WSVerticalPageFragment paramWSVerticalPageFragment, String paramString)
  {
    if ((TextUtils.equals(paramString, "vertical_layer_collection_of_card")) || (TextUtils.equals(paramString, "vertical_layer_collection"))) {
      return new WSVerticalPageCollectionTopAreaController(paramWSVerticalPageFragment.getActivity(), paramWSVerticalPageFragment);
    }
    if (TextUtils.equals(paramString, "qqchat")) {
      return new WSVerticalPageChatTopAreaController(paramWSVerticalPageFragment.getActivity(), paramWSVerticalPageFragment);
    }
    if (TextUtils.equals(paramString, "trends")) {
      return new WSVerticalPageTrendsTopAreaController(paramWSVerticalPageFragment.getActivity(), paramWSVerticalPageFragment);
    }
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return null;
    }
    return new WSVerticalPageCommonTopAreaController(paramWSVerticalPageFragment.getActivity(), paramWSVerticalPageFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageTopAreaFactory
 * JD-Core Version:    0.7.0.1
 */