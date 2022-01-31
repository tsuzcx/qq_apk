package com.tencent.gdtad.views.form.textbox;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.gdtad.views.form.framework.GdtFormItemData;
import com.tencent.gdtad.views.form.framework.GdtFormItemView;
import com.tencent.gdtad.views.xijing.GdtTextData;
import java.lang.ref.WeakReference;
import yxs;
import zan;
import zax;
import zay;
import zaz;

public class GdtFormItemTextBoxView
  extends GdtFormItemView
{
  private EditText a;
  
  public GdtFormItemTextBoxView(Context paramContext, GdtFormItemTextBoxData paramGdtFormItemTextBoxData, WeakReference<zan> paramWeakReference)
  {
    super(paramContext, paramGdtFormItemTextBoxData, paramWeakReference);
  }
  
  private TextWatcher a()
  {
    return new zax(this);
  }
  
  private View.OnFocusChangeListener a()
  {
    return new zay(this);
  }
  
  private TextView.OnEditorActionListener a()
  {
    return new zaz(this);
  }
  
  private static void b(TextView paramTextView)
  {
    if ((paramTextView == null) || (paramTextView.getContext() == null) || (paramTextView.getContext().getSystemService("input_method") == null) || (!(paramTextView.getContext().getSystemService("input_method") instanceof InputMethodManager)))
    {
      yxs.d("GdtFormItemTextBoxView", "hideSoftInput error");
      return;
    }
    try
    {
      ((InputMethodManager)InputMethodManager.class.cast(paramTextView.getContext().getSystemService("input_method"))).hideSoftInputFromWindow(paramTextView.getWindowToken(), 0);
      return;
    }
    catch (Throwable paramTextView)
    {
      yxs.d("GdtFormItemTextBoxView", "hideSoftInput", paramTextView);
    }
  }
  
  public View a(Context paramContext)
  {
    if ((a() == null) || (!a().isValid()))
    {
      yxs.d("GdtFormItemTextBoxView", "createContentView error");
      return null;
    }
    this.a = new EditText(paramContext);
    this.a.setBackgroundColor(0);
    this.a.setGravity(16);
    this.a.setTextColor(a().content.color);
    this.a.setTextSize(0, a().content.size);
    if (a().placeholder != null)
    {
      this.a.setHint(a().placeholder.text);
      this.a.setHintTextColor(a().placeholder.color);
    }
    InputFilter.LengthFilter localLengthFilter;
    if (a().content.lengthMax >= 0)
    {
      localLengthFilter = new InputFilter.LengthFilter(a().content.lengthMax);
      if ((this.a.getFilters() == null) || (this.a.getFilters().length <= 0))
      {
        paramContext = new InputFilter[1];
        paramContext[0] = localLengthFilter;
        this.a.setFilters(paramContext);
      }
    }
    else
    {
      paramContext = this.a;
      if (a().lines != 1) {
        break label338;
      }
    }
    label338:
    for (boolean bool = true;; bool = false)
    {
      paramContext.setSingleLine(bool);
      this.a.setMinLines(a().lines);
      this.a.setMaxLines(a().lines);
      this.a.addTextChangedListener(a());
      this.a.setOnFocusChangeListener(a());
      this.a.setOnEditorActionListener(a());
      return this.a;
      paramContext = new InputFilter[this.a.getFilters().length + 1];
      System.arraycopy(this.a.getFilters(), 0, paramContext, 0, this.a.getFilters().length);
      paramContext[(paramContext.length - 1)] = localLengthFilter;
      break;
    }
  }
  
  public GdtFormItemTextBoxData a()
  {
    GdtFormItemData localGdtFormItemData = super.a();
    if ((localGdtFormItemData instanceof GdtFormItemTextBoxData)) {
      return (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localGdtFormItemData);
    }
    return null;
  }
  
  public void a()
  {
    if (this.a == null)
    {
      yxs.d("GdtFormItemTextBoxView", "reset error");
      return;
    }
    this.a.setText(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxView
 * JD-Core Version:    0.7.0.1
 */