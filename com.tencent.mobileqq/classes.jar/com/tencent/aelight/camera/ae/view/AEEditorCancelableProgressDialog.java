package com.tencent.aelight.camera.ae.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.widget.ProgressPieDrawable;

public class AEEditorCancelableProgressDialog
  extends Dialog
{
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  private final TextView b;
  
  public AEEditorCancelableProgressDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131756189);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    setContentView(2064318581);
    this.b = ((TextView)findViewById(2064122757));
    paramContext = (ImageView)findViewById(2064122324);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a();
    paramContext.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2064121988));
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(getContext());
    localProgressPieDrawable.a(UIUtils.a(getContext(), 94.0F));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.g(-1711276033);
    localProgressPieDrawable.h(18);
    localProgressPieDrawable.b(true);
    localProgressPieDrawable.d(false);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.d(-16722948);
    localProgressPieDrawable.e(872415231);
    localProgressPieDrawable.i(6);
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    return localProgressPieDrawable;
  }
  
  public void a(int paramInt)
  {
    ProgressPieDrawable localProgressPieDrawable = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
    if (localProgressPieDrawable == null) {
      return;
    }
    localProgressPieDrawable.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
    localProgressPieDrawable = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%");
    localProgressPieDrawable.a(localStringBuilder.toString());
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void a(String paramString)
  {
    this.b.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AEEditorCancelableProgressDialog
 * JD-Core Version:    0.7.0.1
 */