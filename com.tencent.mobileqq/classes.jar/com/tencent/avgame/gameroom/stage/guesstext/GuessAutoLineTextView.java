package com.tencent.avgame.gameroom.stage.guesstext;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class GuessAutoLineTextView
  extends TextView
{
  public GuessAutoLineTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GuessAutoLineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GuessAutoLineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (super.getLineCount() <= 1)
    {
      setGravity(17);
      return;
    }
    setGravity(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.GuessAutoLineTextView
 * JD-Core Version:    0.7.0.1
 */