package com.tencent.biz.pubaccount.readinjoy.view.appinpush;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.image.URLDrawable;
import mjz;
import mka;
import mkb;

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
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131624715);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130969593);
    Object localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366898);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366896);
    ImageView localImageView1 = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366893);
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366894);
    Button localButton = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367036);
    ImageView localImageView2 = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367037);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      ((ImageView)localObject).setVisibility(8);
      localTextView2.setText(this.b);
      if (TextUtils.isEmpty(this.d)) {
        break label269;
      }
    }
    label269:
    for (localObject = URLDrawable.getDrawable(this.d);; localObject = PublicAccountConfigUtil.a(this.jdField_a_of_type_AndroidContentContext, 3))
    {
      localImageView1.setImageDrawable((Drawable)localObject);
      localTextView1.setText(this.e);
      localButton.setOnClickListener(new mjz(this));
      localImageView2.setOnClickListener(new mka(this));
      localImageView2.setOnTouchListener(new mkb(this, localImageView2));
      return;
      ((ImageView)localObject).setVisibility(0);
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = new ColorDrawable(-1513241);
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = new ColorDrawable(-1513241);
      ((ImageView)localObject).setImageDrawable(URLDrawable.getDrawable(ReadInJoyUtils.a(this.jdField_a_of_type_JavaLangString, 640, 356), this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions));
      break;
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