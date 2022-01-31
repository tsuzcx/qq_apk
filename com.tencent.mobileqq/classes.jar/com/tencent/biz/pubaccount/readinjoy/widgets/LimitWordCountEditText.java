package com.tencent.biz.pubaccount.readinjoy.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import org.jetbrains.annotations.NotNull;
import sru;
import srv;
import srw;
import srx;

public class LimitWordCountEditText
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString = "";
  private srx jdField_a_of_type_Srx;
  private boolean jdField_a_of_type_Boolean = true;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  
  public LimitWordCountEditText(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    String str1 = "";
    String str2 = "";
    Object localObject2 = str1;
    Object localObject1 = str2;
    float f1 = f2;
    int i = j;
    TypedArray localTypedArray;
    if (paramAttributeSet != null)
    {
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LimitWordCountEditText);
      localObject2 = str1;
      localObject1 = str2;
      f1 = f2;
      i = j;
      if (localTypedArray != null)
      {
        if (!localTypedArray.getBoolean(3, true)) {
          break label275;
        }
        LayoutInflater.from(paramContext).inflate(2131562500, this);
      }
    }
    for (;;)
    {
      i = localTypedArray.getInt(1, 12);
      paramAttributeSet = localTypedArray.getString(2);
      paramContext = paramAttributeSet;
      if (paramAttributeSet == null) {
        paramContext = "";
      }
      localObject1 = localTypedArray.getString(4);
      paramAttributeSet = (AttributeSet)localObject1;
      if (localObject1 == null) {
        paramAttributeSet = "";
      }
      f1 = localTypedArray.getFloat(0, 0.0F);
      localTypedArray.recycle();
      localObject1 = paramAttributeSet;
      localObject2 = paramContext;
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365839));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377884));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378911));
      findViewById(2131375981).setOnClickListener(new sru(this));
      this.jdField_a_of_type_AndroidTextTextWatcher = new srv(this);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      setHint((String)localObject2);
      setTitle((String)localObject1);
      setCountLimit(i);
      setContentTextSize(f1);
      return;
      label275:
      LayoutInflater.from(paramContext).inflate(2131562499, this);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.length();
  }
  
  public EditText a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  public void setContent(@NotNull String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
  }
  
  public void setContentTextSize(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(1, paramFloat);
    }
  }
  
  public void setCountChangeListener(srx paramsrx)
  {
    this.jdField_a_of_type_Srx = paramsrx;
  }
  
  public void setCountLimit(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt - a().length()));
    }
  }
  
  public void setDisableManualEnter(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new srw(this, paramBoolean));
  }
  
  public void setHint(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramString);
  }
  
  public void setSelectionEnd()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.post(new LimitWordCountEditText.4(this));
  }
  
  public void setTitle(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (paramString.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setTitleTypeFace(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText
 * JD-Core Version:    0.7.0.1
 */