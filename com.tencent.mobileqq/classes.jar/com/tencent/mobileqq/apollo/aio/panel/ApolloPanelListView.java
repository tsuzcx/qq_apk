package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;

public class ApolloPanelListView
  extends EmotionPanelListView
{
  public ApolloPanelListView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ApolloPanelListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ApolloPanelListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setEnableExtendPanle(CmShowWnsUtils.i());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListView
 * JD-Core Version:    0.7.0.1
 */