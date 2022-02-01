package com.tencent.mobileqq.apollo.view.pannel;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
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
    setEnableExtendPanle(CmShowWnsUtils.g());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListView
 * JD-Core Version:    0.7.0.1
 */