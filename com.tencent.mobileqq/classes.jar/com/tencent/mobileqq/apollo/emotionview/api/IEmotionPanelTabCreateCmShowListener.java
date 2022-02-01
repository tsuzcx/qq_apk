package com.tencent.mobileqq.apollo.emotionview.api;

import android.content.Context;
import com.tencent.mobileqq.emoticon.IEmotionTabCreateListener;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IEmotionPanelTabCreateCmShowListener
  extends QRouteApi
{
  public abstract IEmotionTabCreateListener build(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.IEmotionPanelTabCreateCmShowListener
 * JD-Core Version:    0.7.0.1
 */