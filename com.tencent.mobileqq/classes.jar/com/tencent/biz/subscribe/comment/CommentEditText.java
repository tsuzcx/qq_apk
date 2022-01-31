package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import vzp;
import vzq;

public class CommentEditText
  extends EditText
{
  private int jdField_a_of_type_Int = 140;
  private vzq jdField_a_of_type_Vzq;
  
  public CommentEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommentEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    addTextChangedListener(new vzp(this));
  }
  
  public CommentEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    if (getContext() != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager == null) {
        return super.dispatchKeyEventPreIme(paramKeyEvent);
      }
      if ((localInputMethodManager.isActive()) && (paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1)) {
        getHandler().postDelayed(new CommentEditText.2(this), 50L);
      }
    }
    return super.dispatchKeyEventPreIme(paramKeyEvent);
  }
  
  public void setMaxLength(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setOnInputBackListener(vzq paramvzq)
  {
    this.jdField_a_of_type_Vzq = paramvzq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentEditText
 * JD-Core Version:    0.7.0.1
 */