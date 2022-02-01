package com.tencent.ad.tangram.canvas.views.form.textbox;

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
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormErrorListener;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemView;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

public final class b
  extends AdFormItemView
{
  private static final String TAG = "AdFormItemTextBoxView";
  private EditText editText;
  
  public b(Context paramContext, a parama, WeakReference<AdFormErrorListener> paramWeakReference)
  {
    super(paramContext, parama, paramWeakReference);
  }
  
  private TextView.OnEditorActionListener createEditorActionListener()
  {
    return new b.3(this);
  }
  
  private View.OnFocusChangeListener createFocusChangeListener()
  {
    return new b.2(this);
  }
  
  private TextWatcher createTextChangedListener()
  {
    return new b.1(this);
  }
  
  private static void hideSoftInput(TextView paramTextView)
  {
    if ((paramTextView == null) || (paramTextView.getContext() == null) || (paramTextView.getContext().getSystemService("input_method") == null) || (!(paramTextView.getContext().getSystemService("input_method") instanceof InputMethodManager)))
    {
      AdLog.e("AdFormItemTextBoxView", "hideSoftInput error");
      return;
    }
    try
    {
      ((InputMethodManager)InputMethodManager.class.cast(paramTextView.getContext().getSystemService("input_method"))).hideSoftInputFromWindow(paramTextView.getWindowToken(), 0);
      return;
    }
    catch (Throwable paramTextView)
    {
      AdLog.e("AdFormItemTextBoxView", "hideSoftInput", paramTextView);
    }
  }
  
  public View createContentView(Context paramContext)
  {
    if ((getData() == null) || (!getData().isValid()))
    {
      AdLog.e("AdFormItemTextBoxView", "createContentView error");
      return null;
    }
    this.editText = new EditText(paramContext);
    this.editText.setBackgroundColor(0);
    this.editText.setGravity(16);
    this.editText.setTextColor(getData().content.color);
    this.editText.setTextSize(0, getData().content.size);
    if (getData().placeholder != null)
    {
      this.editText.setHint(getData().placeholder.text);
      this.editText.setHintTextColor(getData().placeholder.color);
    }
    InputFilter.LengthFilter localLengthFilter;
    if (getData().content.lengthMax >= 0)
    {
      localLengthFilter = new InputFilter.LengthFilter(getData().content.lengthMax);
      if ((this.editText.getFilters() == null) || (this.editText.getFilters().length <= 0))
      {
        paramContext = new InputFilter[1];
        paramContext[0] = localLengthFilter;
        this.editText.setFilters(paramContext);
      }
    }
    else
    {
      paramContext = this.editText;
      if (getData().lines != 1) {
        break label338;
      }
    }
    label338:
    for (boolean bool = true;; bool = false)
    {
      paramContext.setSingleLine(bool);
      this.editText.setMinLines(getData().lines);
      this.editText.setMaxLines(getData().lines);
      this.editText.addTextChangedListener(createTextChangedListener());
      this.editText.setOnFocusChangeListener(createFocusChangeListener());
      this.editText.setOnEditorActionListener(createEditorActionListener());
      return this.editText;
      paramContext = new InputFilter[this.editText.getFilters().length + 1];
      System.arraycopy(this.editText.getFilters(), 0, paramContext, 0, this.editText.getFilters().length);
      paramContext[(paramContext.length - 1)] = localLengthFilter;
      break;
    }
  }
  
  protected a getData()
  {
    AdFormItemData localAdFormItemData = super.getData();
    if ((localAdFormItemData instanceof a)) {
      return (a)a.class.cast(localAdFormItemData);
    }
    return null;
  }
  
  public void reset()
  {
    if (this.editText == null)
    {
      AdLog.e("AdFormItemTextBoxView", "reset error");
      return;
    }
    this.editText.setText(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.textbox.b
 * JD-Core Version:    0.7.0.1
 */