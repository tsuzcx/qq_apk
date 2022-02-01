package com.tencent.luggage.game.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.IntRange;
import com.tencent.luggage.wxa.pp.aa;
import com.tencent.luggage.wxa.pr.a;
import com.tencent.luggage.wxa.qt.c;

@SuppressLint({"AppCompatCustomView"})
public class WAGamePanelInputEditText
  extends EditText
{
  private final aa a = new aa(this);
  private final InputFilter b = new WAGamePanelInputEditText.2(this);
  private int c = 2147483647;
  private final Spannable.Factory d = new WAGamePanelInputEditText.3(this);
  
  public WAGamePanelInputEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WAGamePanelInputEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131034813);
  }
  
  public WAGamePanelInputEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setEditableFactory(new WAGamePanelInputEditText.1(this));
  }
  
  private <T extends Spannable> T a(T paramT)
  {
    c localc = new c();
    localc.a = this.c;
    return a.a().a(getContext(), paramT, Math.round(getTextSize()), localc, this.d);
  }
  
  public int getMaxLength()
  {
    return this.c;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    paramEditorInfo.imeOptions |= 0x10000000;
    return localInputConnection;
  }
  
  public void setComposingDismissedListener(com.tencent.luggage.wxa.pt.b paramb)
  {
    this.a.a(paramb);
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    InputFilter[] arrayOfInputFilter = paramArrayOfInputFilter;
    if (this.b != null)
    {
      int i = 0;
      arrayOfInputFilter = paramArrayOfInputFilter;
      if (paramArrayOfInputFilter == null) {
        arrayOfInputFilter = new InputFilter[0];
      }
      paramArrayOfInputFilter = new InputFilter[arrayOfInputFilter.length + 1];
      while (i < arrayOfInputFilter.length)
      {
        paramArrayOfInputFilter[i] = arrayOfInputFilter[i];
        i += 1;
      }
      paramArrayOfInputFilter[i] = this.b;
      arrayOfInputFilter = paramArrayOfInputFilter;
    }
    super.setFilters(arrayOfInputFilter);
  }
  
  public void setMaxLength(@IntRange(from=1L, to=2147483647L) int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.WAGamePanelInputEditText
 * JD-Core Version:    0.7.0.1
 */