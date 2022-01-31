package com.tencent.mobileqq.armap;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;

public class ARMapOpenPOIDialog
  extends Dialog
  implements View.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ItemInfo jdField_a_of_type_ComTencentMobileqqArmapItemInfo;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  TextView d;
  
  public ARMapOpenPOIDialog(Context paramContext)
  {
    super(paramContext, 2131624516);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setContentView(2130970238);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363062);
    this.c = ((TextView)findViewById(2131362956));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369712));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369717));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369713));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363834));
    this.d = ((TextView)findViewById(2131369716));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  private void b(ItemInfo paramItemInfo)
  {
    if (paramItemInfo == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.c.setVisibility(8);
      Object localObject;
      int i;
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      if (!TextUtils.isEmpty(paramItemInfo.jdField_b_of_type_JavaLangString))
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493213));
        ((GradientDrawable)localObject).setShape(1);
        i = AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((GradientDrawable)localObject).setSize(i, i);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestHeight = i;
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      }
      try
      {
        localObject = URLDrawable.getDrawable(NearbyImgDownloader.a(paramItemInfo.jdField_b_of_type_JavaLangString), localURLDrawableOptions);
        ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(i, i));
        ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if (!TextUtils.isEmpty(paramItemInfo.h)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramItemInfo.h);
        }
        switch (paramItemInfo.jdField_b_of_type_Int)
        {
        default: 
          localObject = "未知";
          if (TextUtils.isEmpty(paramItemInfo.a)) {
            continue;
          }
          localObject = new SpannableString(paramItemInfo.a + (String)localObject);
          ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(15, true), paramItemInfo.a.length(), ((SpannableString)localObject).length(), 17);
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            localException.printStackTrace();
            continue;
            String str = "金币";
            continue;
            str = "现金";
            continue;
            str = "装扮";
            continue;
            str = "卡券";
            continue;
            str = "道具";
            continue;
            str = "订单";
          }
        }
      }
    }
  }
  
  public void a(ItemInfo paramItemInfo)
  {
    if (paramItemInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapItemInfo = paramItemInfo;
      b(paramItemInfo);
    }
  }
  
  public void onBackPressed()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    if (!localActivity.isFinishing())
    {
      dismiss();
      localActivity.finish();
    }
  }
  
  public void onClick(View paramView)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    if (paramView.getId() == 2131369717) {
      if (!localActivity.isFinishing())
      {
        dismiss();
        localActivity.finish();
      }
    }
    while (paramView.getId() != 2131369716) {
      return;
    }
    Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
    if (this.jdField_a_of_type_ComTencentMobileqqArmapItemInfo == null) {}
    for (paramView = "";; paramView = this.jdField_a_of_type_ComTencentMobileqqArmapItemInfo.c)
    {
      localIntent.putExtra("url", paramView);
      localActivity.startActivity(localIntent);
      localActivity.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapOpenPOIDialog
 * JD-Core Version:    0.7.0.1
 */