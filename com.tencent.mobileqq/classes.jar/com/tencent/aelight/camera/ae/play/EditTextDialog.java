package com.tencent.aelight.camera.ae.play;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditTextDialog
  extends Dialog
{
  private float autoTextSize;
  private TextView mCancelView;
  private ImageView mCleanTextView;
  private Button mConfirmView;
  private EditText mEditText;
  private TextView mEditTip;
  private int mMaxLength = 12;
  private EditTextDialog.OnConfirmClickLister mOnConfirmClickLister;
  private int mTextColor;
  private transient TextPaint mTextPaint;
  
  public EditTextDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2064580714);
    initView(paramContext);
    paramContext = getWindow();
    if (paramContext != null) {
      paramContext.setSoftInputMode(21);
    }
    setCanceledOnTouchOutside(true);
  }
  
  private void initTextPaint()
  {
    this.mTextPaint = new TextPaint(1);
    this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
    this.mTextPaint.setAntiAlias(true);
  }
  
  private void initView(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2064318503, null);
    this.mEditText = ((EditText)paramContext.findViewById(2064122131));
    this.mEditTip = ((TextView)paramContext.findViewById(2064122132));
    this.mCancelView = ((TextView)paramContext.findViewById(2064122021));
    this.mConfirmView = ((Button)paramContext.findViewById(2064122054));
    this.mCleanTextView = ((ImageView)paramContext.findViewById(2064122000));
    this.mEditText.addTextChangedListener(new EditTextDialog.1(this));
    this.mConfirmView.setOnClickListener(new EditTextDialog.2(this));
    this.mCancelView.setOnClickListener(new EditTextDialog.3(this));
    this.mCleanTextView.setOnClickListener(new EditTextDialog.4(this));
    setContentView(paramContext);
  }
  
  public void setEditMaxLength(int paramInt)
  {
    this.mMaxLength = paramInt;
  }
  
  public void setOnConfirmClickListener(EditTextDialog.OnConfirmClickLister paramOnConfirmClickLister)
  {
    this.mOnConfirmClickLister = paramOnConfirmClickLister;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.EditTextDialog
 * JD-Core Version:    0.7.0.1
 */