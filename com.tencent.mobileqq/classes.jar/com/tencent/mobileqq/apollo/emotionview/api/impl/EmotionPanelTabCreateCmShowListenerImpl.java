package com.tencent.mobileqq.apollo.emotionview.api.impl;

import android.content.Context;
import com.tencent.mobileqq.apollo.emotionview.EmoticonTabCmshowListener;
import com.tencent.mobileqq.apollo.emotionview.api.IEmotionPanelTabCreateCmShowListener;
import com.tencent.mobileqq.emoticon.IEmotionTabCreateListener;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;

public class EmotionPanelTabCreateCmShowListenerImpl
  implements IEmotionPanelTabCreateCmShowListener
{
  public IEmotionTabCreateListener build(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext)
  {
    return new EmoticonTabCmshowListener(paramIEmoticonMainPanelApp, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.EmotionPanelTabCreateCmShowListenerImpl
 * JD-Core Version:    0.7.0.1
 */