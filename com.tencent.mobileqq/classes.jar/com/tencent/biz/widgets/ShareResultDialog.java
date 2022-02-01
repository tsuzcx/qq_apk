package com.tencent.biz.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ShareResultDialog
  extends ReportDialog
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ShareResultDialog.IShareResultCallback jdField_a_of_type_ComTencentBizWidgetsShareResultDialog$IShareResultCallback = null;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public ShareResultDialog(Context paramContext)
  {
    super(paramContext, 2131756189);
    super.setContentView(2131559105);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131378795);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131378790);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365633));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365639));
    this.c = ((TextView)super.findViewById(2131378793));
    ((ImageView)super.findViewById(2131378794)).setColorFilter(-7745469, PorterDuff.Mode.MULTIPLY);
    this.d = ((TextView)super.findViewById(2131378788));
    ((ImageView)super.findViewById(2131378789)).setColorFilter(-909794, PorterDuff.Mode.MULTIPLY);
    this.e = ((TextView)super.findViewById(2131378018));
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("width:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().width);
    QLog.i("ShareToQZone", 2, ((StringBuilder)localObject).toString());
    int j = 0;
    if (paramBoolean) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    } else {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    localObject = this.jdField_b_of_type_AndroidViewView;
    if (this.jdField_a_of_type_Boolean) {
      i = 8;
    } else {
      i = 0;
    }
    ((View)localObject).setVisibility(i);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (this.jdField_a_of_type_Boolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    localObject = this.e;
    int i = j;
    if (this.jdField_a_of_type_Boolean) {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
  }
  
  public void a(int paramInt)
  {
    TextView localTextView = this.d;
    if (localTextView != null) {
      localTextView.setText(paramInt);
    }
  }
  
  public void a(ShareResultDialog.IShareResultCallback paramIShareResultCallback)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog$IShareResultCallback = paramIShareResultCallback;
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ShareResultDialog.1(this, paramOnClickListener));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    TextView localTextView = this.e;
    if (localTextView != null)
    {
      if (paramInt != 0)
      {
        localTextView.setText(paramInt);
        return;
      }
      localTextView.setText("");
    }
  }
  
  public void b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      b(false);
      return;
    }
    b(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ShareResultDialog.2(this, paramOnClickListener));
  }
  
  public void c(int paramInt)
  {
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setText(paramInt);
    }
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onBackPressed()
  {
    QLog.i("ShareResultDialog", 2, "onBackPressed");
    super.onBackPressed();
    ShareResultDialog.IShareResultCallback localIShareResultCallback = this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog$IShareResultCallback;
    if (localIShareResultCallback != null)
    {
      boolean bool;
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localIShareResultCallback.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.ShareResultDialog
 * JD-Core Version:    0.7.0.1
 */