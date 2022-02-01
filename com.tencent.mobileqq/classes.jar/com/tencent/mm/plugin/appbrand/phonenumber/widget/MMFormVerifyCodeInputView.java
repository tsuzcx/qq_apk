package com.tencent.mm.plugin.appbrand.phonenumber.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;

public class MMFormVerifyCodeInputView
  extends LinearLayout
{
  private Context a = null;
  private TextView b;
  private EditText c;
  private TextView d;
  private Button e;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j = 60;
  private int k = this.j;
  private v l;
  private int[] m;
  private View.OnFocusChangeListener n = null;
  private View.OnClickListener o = null;
  
  public MMFormVerifyCodeInputView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  @TargetApi(11)
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItemView, paramInt, 0);
    this.g = paramAttributeSet.getResourceId(R.styleable.FormItemView_form_hint, -1);
    this.f = paramAttributeSet.getResourceId(R.styleable.FormItemView_form_title, -1);
    this.h = paramAttributeSet.getResourceId(R.styleable.FormItemView_form_btn_title, -1);
    this.i = paramAttributeSet.getResourceId(R.styleable.FormItemView_form_layout, this.i);
    paramAttributeSet.recycle();
    inflate(paramContext, this.i, this);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void c()
  {
    this.b = ((TextView)findViewById(2131447463));
    this.c = ((EditText)findViewById(2131432368));
    this.d = ((TextView)findViewById(2131447400));
    this.e = ((Button)findViewById(2131445619));
    Object localObject = this.b;
    if ((localObject != null) && (this.c != null) && (this.d != null) && (this.e != null))
    {
      int i1 = this.f;
      if (i1 != -1) {
        ((TextView)localObject).setText(i1);
      }
      i1 = this.g;
      if (i1 != -1) {
        this.c.setHint(i1);
      }
      i1 = this.h;
      if (i1 != -1) {
        this.e.setText(i1);
      }
    }
    else
    {
      o.c("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[] { this.b, this.c, this.d, this.e });
    }
    if (this.c != null)
    {
      localObject = new MMFormVerifyCodeInputView.1(this);
      this.c.setOnFocusChangeListener((View.OnFocusChangeListener)localObject);
    }
    localObject = this.e;
    if (localObject != null) {
      ((Button)localObject).setOnClickListener(new MMFormVerifyCodeInputView.2(this));
    }
  }
  
  private void d()
  {
    this.m = new int[] { getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() };
  }
  
  private void e()
  {
    int[] arrayOfInt = this.m;
    if (arrayOfInt != null) {
      setPadding(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
    }
  }
  
  public void a()
  {
    this.e.setVisibility(8);
    this.d.setVisibility(0);
    this.d.setText(getContext().getString(2131886952, new Object[] { Integer.valueOf(this.j) }));
    v localv = this.l;
    if (localv != null)
    {
      localv.c();
      this.l.a(1000L);
      return;
    }
    if (getContext() != null)
    {
      this.l = new v(getContext().getMainLooper(), new MMFormVerifyCodeInputView.3(this), true);
      this.l.a(1000L);
      return;
    }
    localv = this.l;
    if (localv != null) {
      localv.c();
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
    o.c("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.c });
  }
  
  public void b()
  {
    v localv = this.l;
    if (localv != null) {
      localv.c();
    }
    this.c.setText("");
    this.d.setVisibility(8);
    this.k = this.j;
    this.e.setVisibility(0);
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
    o.b("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.b;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    c();
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.n = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    EditText localEditText = this.c;
    if (localEditText != null)
    {
      localEditText.setHint(paramInt);
      return;
    }
    o.b("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
  }
  
  public void setHint(String paramString)
  {
    EditText localEditText = this.c;
    if (localEditText != null)
    {
      localEditText.setHint(paramString);
      return;
    }
    o.b("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
  }
  
  public void setImeOption(int paramInt)
  {
    EditText localEditText = this.c;
    if (localEditText != null)
    {
      localEditText.setImeOptions(paramInt);
      return;
    }
    o.b("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
  }
  
  public void setInputType(int paramInt)
  {
    EditText localEditText = this.c;
    if (localEditText != null)
    {
      localEditText.setInputType(paramInt);
      return;
    }
    o.b("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
  }
  
  public void setSendSmsBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.o = paramOnClickListener;
  }
  
  public void setSmsBtnText(int paramInt)
  {
    Button localButton = this.e;
    if (localButton != null)
    {
      localButton.setText(paramInt);
      return;
    }
    o.b("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
  }
  
  public void setSmsBtnText(String paramString)
  {
    Button localButton = this.e;
    if (localButton != null)
    {
      localButton.setText(paramString);
      return;
    }
    o.b("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
  }
  
  public void setText(String paramString)
  {
    EditText localEditText = this.c;
    if (localEditText != null)
    {
      localEditText.setText(paramString);
      return;
    }
    o.b("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
  }
  
  public void setTitle(int paramInt)
  {
    TextView localTextView = this.b;
    if (localTextView != null)
    {
      localTextView.setText(paramInt);
      return;
    }
    o.b("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
  }
  
  public void setTitle(String paramString)
  {
    TextView localTextView = this.b;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      return;
    }
    o.b("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView
 * JD-Core Version:    0.7.0.1
 */