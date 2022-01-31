package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.BubbleImageView;

public class TroopGiftBubbleView
  extends BubbleImageView
{
  public TroopGiftBubbleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopGiftBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopGiftBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      this.a = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftBubbleView
 * JD-Core Version:    0.7.0.1
 */