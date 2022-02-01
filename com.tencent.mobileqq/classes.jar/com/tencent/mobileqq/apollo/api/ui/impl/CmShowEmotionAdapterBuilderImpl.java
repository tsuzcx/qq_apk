package com.tencent.mobileqq.apollo.api.ui.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.ui.ICmShowEmotionAdapterBuilder;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;

public class CmShowEmotionAdapterBuilderImpl
  implements ICmShowEmotionAdapterBuilder
{
  public BaseEmotionAdapter build(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie)
  {
    return new CmShowEmotionAdapter(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback, paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.ui.impl.CmShowEmotionAdapterBuilderImpl
 * JD-Core Version:    0.7.0.1
 */