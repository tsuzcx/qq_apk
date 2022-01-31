package com.tencent.biz.pubaccount.readinjoy.view.appinpush;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import mlk;
import mll;
import mlm;

public class DialogAppInPushNotification
  extends AppInPushNotification
{
  private Dialog a;
  
  DialogAppInPushNotification(AppInPushNotification.Builder paramBuilder)
  {
    super(paramBuilder);
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131624716);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130969600);
    ImageView localImageView1 = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366940);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366938);
    ReadInJoyHeadImageView localReadInJoyHeadImageView = (ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366935);
    ReadInJoyNickNameTextView localReadInJoyNickNameTextView = (ReadInJoyNickNameTextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366936);
    Button localButton = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367083);
    ImageView localImageView2 = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367084);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localImageView1.setVisibility(8);
    }
    for (;;)
    {
      localTextView.setText(this.b);
      localReadInJoyHeadImageView.setHeadImgByUin(this.f);
      localReadInJoyNickNameTextView.setText(this.e);
      localButton.setOnClickListener(new mlk(this));
      localImageView2.setOnClickListener(new mll(this));
      localImageView2.setOnTouchListener(new mlm(this, localImageView2));
      return;
      localImageView1.setVisibility(0);
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = new ColorDrawable(-1513241);
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = new ColorDrawable(-1513241);
      localImageView1.setImageDrawable(URLDrawable.getDrawable(ReadInJoyUtils.a(this.jdField_a_of_type_JavaLangString, 640, 356), this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions));
    }
  }
  
  protected void a(boolean paramBoolean, Runnable paramRunnable)
  {
    if (!paramBoolean) {
      paramRunnable.run();
    }
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_AndroidAppDialog.isShowing();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.appinpush.DialogAppInPushNotification
 * JD-Core Version:    0.7.0.1
 */