package com.tencent.hippy.qq.view.tkd.text;

import android.content.Context;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.mtt.hippy.views.text.HippyTextView;
import com.tencent.mtt.hippy.views.text.HippyTextViewController;

@HippyController(name="Text")
public class HippyTKDTextViewController
  extends HippyTextViewController
{
  public static final String EMOJI_MODE = "emojiMode";
  
  protected StyleNode createNode(boolean paramBoolean)
  {
    return new TextNode(paramBoolean);
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyTKDTextView(paramContext);
  }
  
  @HippyControllerProps(name="colors")
  public void setColors(HippyTextView paramHippyTextView, HippyArray paramHippyArray)
  {
    if ((paramHippyTextView instanceof HippyTKDTextView)) {
      ((HippyTKDTextView)paramHippyTextView).setColors(paramHippyArray);
    }
  }
  
  @HippyControllerProps(name="customProp")
  public void setCustomProp(HippyTextView paramHippyTextView, String paramString, Object paramObject)
  {
    if ((paramHippyTextView instanceof HippyTKDCommonBorderHandler.HippyQBCommonBorder)) {
      HippyTKDCommonBorderHandler.handleCommonBorderColor((HippyTKDCommonBorderHandler.HippyQBCommonBorder)paramHippyTextView, paramString, paramObject);
    }
  }
  
  @HippyControllerProps(name="emojiMode")
  public void setEmojiMode(HippyTextView paramHippyTextView, HippyMap paramHippyMap)
  {
    if ((paramHippyTextView instanceof HippyTKDTextView))
    {
      if ((paramHippyMap != null) && ((paramHippyMap.get("enable") instanceof Boolean)))
      {
        ((HippyTKDTextView)paramHippyTextView).setEmojiEnable(paramHippyMap.getBoolean("enable"));
        return;
      }
      ((HippyTKDTextView)paramHippyTextView).setEmojiEnable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.text.HippyTKDTextViewController
 * JD-Core Version:    0.7.0.1
 */