package com.tencent.mobileqq.apollo.api.ui;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface ICmShowEmotionAdapterBuilder
  extends QRouteApi
{
  public abstract BaseEmotionAdapter build(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.ui.ICmShowEmotionAdapterBuilder
 * JD-Core Version:    0.7.0.1
 */