package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import java.util.LinkedList;

public class PasterEditText
  extends EditText
{
  private Context a;
  private boolean b = false;
  private int c = 0;
  private int d = 0;
  private CharSequence e = "";
  private CharSequence f = "";
  private int g = 0;
  private LinkedList<TextWatcher> h = new LinkedList();
  private LinkedList<PasterEditText.TextPasteListener> i = new LinkedList();
  
  public PasterEditText(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    super.addTextChangedListener(new PasterEditText.1(this));
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    this.h.add(paramTextWatcher);
  }
  
  public void addTextPasteListener(PasterEditText.TextPasteListener paramTextPasteListener)
  {
    this.i.add(paramTextPasteListener);
  }
  
  public CharSequence getPasterContent()
  {
    return this.f;
  }
  
  public int getPasterLen()
  {
    return this.g;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if (paramInt == 16908322)
    {
      this.b = true;
      return super.onTextContextMenuItem(paramInt);
    }
    if (paramInt == 16908321) {
      return super.onTextContextMenuItem(paramInt);
    }
    return super.onTextContextMenuItem(paramInt);
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    this.h.remove(paramTextWatcher);
  }
  
  public void removeTextPasteListener(PasterEditText.TextPasteListener paramTextPasteListener)
  {
    this.i.remove(paramTextPasteListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.PasterEditText
 * JD-Core Version:    0.7.0.1
 */