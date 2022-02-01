package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.theme.ISkinIgnoreTypeface;

public class CommentEditText
  extends EditText
  implements ISkinIgnoreTypeface
{
  private CommentEditText.OnInputBackListener a;
  private int b = 140;
  
  public CommentEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommentEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    addTextChangedListener(new CommentEditText.1(this));
  }
  
  public CommentEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    if (getContext() != null)
    {
      Object localObject = (InputMethodManager)getContext().getSystemService("input_method");
      if (localObject == null) {
        return super.dispatchKeyEventPreIme(paramKeyEvent);
      }
      if ((((InputMethodManager)localObject).isActive()) && (paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
      {
        localObject = getHandler();
        if (localObject != null) {
          ((Handler)localObject).postDelayed(new CommentEditText.2(this), 50L);
        }
      }
    }
    return super.dispatchKeyEventPreIme(paramKeyEvent);
  }
  
  public void setMaxLength(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setOnInputBackListener(CommentEditText.OnInputBackListener paramOnInputBackListener)
  {
    this.a = paramOnInputBackListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentEditText
 * JD-Core Version:    0.7.0.1
 */