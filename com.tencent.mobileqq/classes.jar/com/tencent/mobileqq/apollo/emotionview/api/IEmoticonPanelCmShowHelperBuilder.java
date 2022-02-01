package com.tencent.mobileqq.apollo.emotionview.api;

import com.tencent.mobileqq.emoticonview.AbsEmoticonPanelLifecycleObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IEmoticonPanelCmShowHelperBuilder
  extends QRouteApi
{
  public abstract AbsEmoticonPanelLifecycleObserver build(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.IEmoticonPanelCmShowHelperBuilder
 * JD-Core Version:    0.7.0.1
 */