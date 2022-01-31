package com.tencent.mobileqq.binhai;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class BinHaiMsgDialog
  extends Dialog
  implements View.OnClickListener
{
  public int a;
  private long jdField_a_of_type_Long;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BinHaiMsgDialog.Listener jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener;
  public boolean a;
  
  public BinHaiMsgDialog(Context paramContext)
  {
    super(paramContext, a());
    setContentView(2130970194);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363632));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131366788));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    findViewById(2131369493).setOnClickListener(this);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      findViewById(2131369491).setPadding(0, ImmersiveUtils.a(paramContext), 0, 0);
    }
    if (a())
    {
      findViewById(2131362840).setBackgroundColor(0);
      findViewById(2131369491).setVisibility(8);
    }
  }
  
  public static int a()
  {
    int i = 2131624714;
    if (a()) {
      i = 2131624516;
    }
    return i;
  }
  
  public static boolean a()
  {
    return Build.MODEL.equalsIgnoreCase("GT-N7102");
  }
  
  public void a(BinHaiMsgDialog.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener = paramListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setText(paramString);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    ((ImageView)findViewById(2131362745)).setImageBitmap(paramBitmap);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onBackPressed()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 2000L) {}
    while (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener.b(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369493) {
      if (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener != null) {
        this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener.c(this);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener.a(this);
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.binhai.BinHaiMsgDialog
 * JD-Core Version:    0.7.0.1
 */