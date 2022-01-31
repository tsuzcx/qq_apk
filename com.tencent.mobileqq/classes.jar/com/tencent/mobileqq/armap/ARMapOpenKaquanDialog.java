package com.tencent.mobileqq.armap;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;

public class ARMapOpenKaquanDialog
  extends Dialog
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  TextView b;
  
  public ARMapOpenKaquanDialog(Context paramContext)
  {
    this(paramContext, true);
  }
  
  public ARMapOpenKaquanDialog(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, 2131624516);
    setContentView(2130970220);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363218));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369688));
    this.b = ((TextView)findViewById(2131369689));
    findViewById(2131363215).setOnClickListener(this);
    findViewById(2131369572).setOnClickListener(this);
    findViewById(2131369690).setOnClickListener(this);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = paramString4;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString2 = BitmapManager.a(paramString2);
      if (paramString2 != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a(paramString2, paramString2.getWidth(), paramString2.getHeight()));
      }
    }
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    }
    this.b.setText(paramString3);
    paramString1 = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    if (this.b.getLineCount() == 1) {}
    for (paramString1.topMargin = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131560194));; paramString1.topMargin = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131560195)))
    {
      this.b.setLayoutParams(paramString1);
      return;
    }
  }
  
  public void onBackPressed()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 2000L) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
        localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      } while (localActivity.isFinishing());
      dismiss();
    } while (!this.jdField_a_of_type_Boolean);
    localActivity.finish();
  }
  
  public void onClick(View paramView)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        onBackPressed();
        return;
        ReportController.b(null, "dc01440", "", "", "0X8007851", "0X8007851", 0, 0, "", "", "", "");
        paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
        paramView.putExtra("hide_left_button", false);
        paramView.putExtra("show_right_close_button", true);
        paramView.putExtra("finish_animation_up_down", true);
        paramView.putExtra("hide_operation_bar", true);
        paramView.addFlags(67108864);
        localActivity.startActivity(paramView);
      } while (localActivity.isFinishing());
      dismiss();
    } while (!this.jdField_a_of_type_Boolean);
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapOpenKaquanDialog
 * JD-Core Version:    0.7.0.1
 */