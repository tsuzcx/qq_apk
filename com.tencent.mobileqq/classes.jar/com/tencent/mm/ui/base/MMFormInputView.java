package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;
import com.tencent.mm.ui.f;

public class MMFormInputView
  extends LinearLayout
{
  private Context a = null;
  private TextView b;
  private EditText c;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private int[] g;
  private View.OnFocusChangeListener h = null;
  
  public MMFormInputView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItemView, paramInt, 0);
    this.e = paramAttributeSet.getResourceId(R.styleable.FormItemView_form_hint, -1);
    this.d = paramAttributeSet.getResourceId(R.styleable.FormItemView_form_title, -1);
    this.f = paramAttributeSet.getResourceId(R.styleable.FormItemView_form_layout, this.f);
    paramAttributeSet.recycle();
    inflate(paramContext, this.f, this);
    a(paramContext);
  }
  
  private void a()
  {
    this.b = ((TextView)findViewById(2131447463));
    this.c = ((EditText)findViewById(2131432368));
    Object localObject = this.b;
    if ((localObject != null) && (this.c != null))
    {
      int i = this.d;
      if (i != -1) {
        ((TextView)localObject).setText(i);
      }
      i = this.e;
      if (i != -1) {
        this.c.setHint(i);
      }
    }
    else
    {
      f.d("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", new Object[] { this.b, this.c });
    }
    if (this.c != null)
    {
      localObject = new MMFormInputView.1(this);
      this.c.setOnFocusChangeListener((View.OnFocusChangeListener)localObject);
    }
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void b()
  {
    this.g = new int[] { getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() };
  }
  
  private void c()
  {
    int[] arrayOfInt = this.g;
    if (arrayOfInt != null) {
      setPadding(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
    }
  }
  
  public void a(TextWatcher paramTextWatcher)
  {
    if (paramTextWatcher != null)
    {
      EditText localEditText = this.c;
      if (localEditText != null)
      {
        localEditText.addTextChangedListener(paramTextWatcher);
        return;
      }
    }
    f.d("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.c });
  }
  
  public EditText getContentEditText()
  {
    return this.c;
  }
  
  public Editable getText()
  {
    EditText localEditText = this.c;
    if (localEditText != null) {
      return localEditText.getText();
    }
    f.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.b;
  }
  
  public void onFinishInflate()
  {
    a();
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.h = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    EditText localEditText = this.c;
    if (localEditText != null)
    {
      localEditText.setHint(paramInt);
      return;
    }
    f.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
  }
  
  public void setHint(String paramString)
  {
    EditText localEditText = this.c;
    if (localEditText != null)
    {
      localEditText.setHint(paramString);
      return;
    }
    f.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
  }
  
  public void setImeOption(int paramInt)
  {
    EditText localEditText = this.c;
    if (localEditText != null)
    {
      localEditText.setImeOptions(paramInt);
      return;
    }
    f.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
  }
  
  public void setInputType(int paramInt)
  {
    EditText localEditText = this.c;
    if (localEditText != null)
    {
      localEditText.setInputType(paramInt);
      return;
    }
    f.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
  }
  
  public void setText(String paramString)
  {
    EditText localEditText = this.c;
    if (localEditText != null)
    {
      localEditText.setText(paramString);
      return;
    }
    f.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
  }
  
  public void setTitle(int paramInt)
  {
    TextView localTextView = this.b;
    if (localTextView != null)
    {
      localTextView.setText(paramInt);
      return;
    }
    f.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
  }
  
  public void setTitle(String paramString)
  {
    TextView localTextView = this.b;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      return;
    }
    f.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormInputView
 * JD-Core Version:    0.7.0.1
 */