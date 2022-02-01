package com.tencent.biz.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ShareAioResultDialog
  extends ReportDialog
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  private TextView c;
  
  public ShareAioResultDialog(Context paramContext)
  {
    super(paramContext, 2131755842);
    super.setContentView(2131560576);
    super.getWindow().setWindowAnimations(2131755132);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365796));
    this.b = ((TextView)super.findViewById(2131365802));
    this.c = ((TextView)super.findViewById(2131379441));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131379442));
    this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-7745469, PorterDuff.Mode.MULTIPLY);
  }
  
  public void a(DialogInterface.OnClickListener paramOnClickListener)
  {
    if (ChatActivityConstants.a)
    {
      Resources localResources = getContext().getResources();
      this.b.setContentDescription(localResources.getString(2131690777, new Object[] { localResources.getString(2131719149) }));
    }
    this.b.setOnClickListener(new ShareAioResultDialog.2(this, paramOnClickListener));
  }
  
  public void a(String paramString)
  {
    if (this.c != null) {
      this.c.setText(paramString);
    }
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if (ChatActivityConstants.a)
    {
      Resources localResources = getContext().getResources();
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localTextView.setContentDescription(localResources.getString(2131690777, new Object[] { str }));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ShareAioResultDialog.1(this, paramOnClickListener));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.biz.widgets.ShareAioResultDialog
 * JD-Core Version:    0.7.0.1
 */