package com.tencent.mobileqq.apollo.emotionview.api.impl;

import com.tencent.mobileqq.apollo.emotionview.EmoticonPanelCmShowHelper;
import com.tencent.mobileqq.apollo.emotionview.api.IEmoticonPanelCmShowHelperBuilder;
import com.tencent.mobileqq.emoticonview.AbsEmoticonPanelLifecycleObserver;

public class EmoticonPanelCmShowHelperBuilderImpl
  implements IEmoticonPanelCmShowHelperBuilder
{
  public AbsEmoticonPanelLifecycleObserver build(int paramInt)
  {
    return new EmoticonPanelCmShowHelper(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.EmoticonPanelCmShowHelperBuilderImpl
 * JD-Core Version:    0.7.0.1
 */