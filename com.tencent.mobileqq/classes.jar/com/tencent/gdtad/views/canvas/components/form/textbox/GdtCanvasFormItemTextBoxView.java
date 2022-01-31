package com.tencent.gdtad.views.canvas.components.form.textbox;

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
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormItemData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormItemView;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasTextData;
import java.lang.ref.WeakReference;
import qlx;
import qly;
import qlz;

public class GdtCanvasFormItemTextBoxView
  extends GdtCanvasFormItemView
{
  private EditText a;
  
  public GdtCanvasFormItemTextBoxView(Context paramContext, GdtCanvasFormItemTextBoxData paramGdtCanvasFormItemTextBoxData, WeakReference paramWeakReference)
  {
    super(paramContext, paramGdtCanvasFormItemTextBoxData, paramWeakReference);
  }
  
  private TextWatcher a()
  {
    return new qlx(this);
  }
  
  private View.OnFocusChangeListener a()
  {
    return new qly(this);
  }
  
  private TextView.OnEditorActionListener a()
  {
    return new qlz(this);
  }
  
  private static void b(TextView paramTextView)
  {
    if ((paramTextView == null) || (paramTextView.getContext() == null) || (paramTextView.getContext().getSystemService("input_method") == null) || (!(paramTextView.getContext().getSystemService("input_method") instanceof InputMethodManager)))
    {
      GdtLog.d("GdtCanvasFormItemTextBoxView", "hideSoftInput error");
      return;
    }
    try
    {
      ((InputMethodManager)InputMethodManager.class.cast(paramTextView.getContext().getSystemService("input_method"))).hideSoftInputFromWindow(paramTextView.getWindowToken(), 0);
      return;
    }
    catch (Throwable paramTextView)
    {
      GdtLog.d("GdtCanvasFormItemTextBoxView", "hideSoftInput", paramTextView);
    }
  }
  
  protected View a(Context paramContext)
  {
    if ((a() == null) || (!a().isValid()))
    {
      GdtLog.d("GdtCanvasFormItemTextBoxView", "createContentView error");
      return null;
    }
    this.a = new EditText(paramContext);
    this.a.setBackgroundColor(0);
    this.a.setGravity(16);
    this.a.setTextColor(a().content.color);
    this.a.setTextSize(0, a().content.size);
    this.a.setHint(a().placeholder.text);
    this.a.setHintTextColor(a().placeholder.color);
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
        break label328;
      }
    }
    label328:
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
  
  public GdtCanvasFormItemTextBoxData a()
  {
    GdtCanvasFormItemData localGdtCanvasFormItemData = super.a();
    if ((localGdtCanvasFormItemData instanceof GdtCanvasFormItemTextBoxData)) {
      return (GdtCanvasFormItemTextBoxData)GdtCanvasFormItemTextBoxData.class.cast(localGdtCanvasFormItemData);
    }
    return null;
  }
  
  protected void a()
  {
    if (this.a == null)
    {
      GdtLog.d("GdtCanvasFormItemTextBoxView", "reset error");
      return;
    }
    this.a.setText(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.form.textbox.GdtCanvasFormItemTextBoxView
 * JD-Core Version:    0.7.0.1
 */