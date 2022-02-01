package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qrscan.QRCodeEncodeCallback;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.TicketManager;

class QRDisplayActivity$6
  implements Runnable
{
  QRDisplayActivity$6(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    int j = (int)(QRDisplayActivity.a(this.this$0) * 20.0F);
    int i = this.this$0.jdField_c_of_type_AndroidViewView.getWidth();
    j *= 2;
    int k = i - j;
    int m = this.this$0.jdField_c_of_type_AndroidViewView.getHeight() - j;
    i = this.this$0.jdField_c_of_type_Int;
    if ((i != 1) && (i != 2))
    {
      i = 540;
      j = 740;
    }
    else
    {
      i = 550;
      j = 844;
    }
    if ((k >= i) && (m >= j))
    {
      localObject1 = this.this$0;
      ((QRDisplayActivity)localObject1).jdField_d_of_type_Int = i;
      ((QRDisplayActivity)localObject1).jdField_e_of_type_Int = j;
    }
    else
    {
      double d1;
      double d2;
      if (k * i < m * i)
      {
        localObject1 = this.this$0;
        ((QRDisplayActivity)localObject1).jdField_d_of_type_Int = k;
        d1 = k;
        d2 = i;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = j;
        Double.isNaN(d2);
        ((QRDisplayActivity)localObject1).jdField_e_of_type_Int = ((int)(d1 * d2));
      }
      else
      {
        localObject1 = this.this$0;
        d1 = m;
        d2 = j;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = i;
        Double.isNaN(d2);
        ((QRDisplayActivity)localObject1).jdField_d_of_type_Int = ((int)(d1 * d2));
        ((QRDisplayActivity)localObject1).jdField_e_of_type_Int = m;
      }
      localObject1 = this.this$0.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = this.this$0.jdField_d_of_type_Int;
      ((ViewGroup.LayoutParams)localObject1).height = this.this$0.jdField_e_of_type_Int;
      this.this$0.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.this$0.jdField_d_of_type_AndroidViewView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = this.this$0.jdField_d_of_type_Int;
      ((ViewGroup.LayoutParams)localObject1).height = this.this$0.jdField_e_of_type_Int;
      this.this$0.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    Object localObject1 = this.this$0.jdField_a_of_type_AndroidGraphicsBitmap;
    i = 0;
    if (localObject1 == null) {
      ThreadManager.post(new QRDisplayActivity.6.1(this), 8, null, false);
    }
    if ((this.this$0.jdField_c_of_type_Int == 2) && (this.this$0.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      localObject1 = this.this$0;
      ((QRDisplayActivity)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(((QRDisplayActivity)localObject1).jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);
    }
    if (this.this$0.jdField_a_of_type_AndroidOsBundle == null)
    {
      this.this$0.jdField_a_of_type_AndroidOsBundle = new Bundle();
      this.this$0.jdField_a_of_type_AndroidOsBundle.putInt("bkgRes", 0);
      this.this$0.jdField_a_of_type_AndroidOsBundle.putInt("nameClr", -16777216);
      this.this$0.jdField_a_of_type_AndroidOsBundle.putInt("tipsClr", -8947849);
      this.this$0.jdField_a_of_type_AndroidOsBundle.putInt("B", -16777216);
      this.this$0.jdField_a_of_type_AndroidOsBundle.putInt("W", 16777215);
      this.this$0.jdField_a_of_type_AndroidOsBundle.putParcelable("qrloc", new Rect(45, 76, 495, 526));
      this.this$0.jdField_a_of_type_AndroidOsBundle.putInt("head", 1);
    }
    Object localObject2;
    Object localObject3;
    if (this.this$0.jdField_c_of_type_Int != 5)
    {
      if (this.this$0.jdField_c_of_type_Int == 11)
      {
        localObject1 = this.this$0.getIntent().getStringExtra("url");
        localObject2 = this.this$0;
        ((QRDisplayActivity)localObject2).a(((QRDisplayActivity)localObject2).jdField_c_of_type_JavaLangString, this.this$0.jdField_c_of_type_Int, (String)localObject1);
      }
      if (this.this$0.jdField_a_of_type_ComGoogleZxingCommonBitMatrix == null)
      {
        localObject1 = this.this$0;
        ((QRDisplayActivity)localObject1).jdField_a_of_type_ComGoogleZxingCommonBitMatrix = ((QRDisplayActivity)localObject1).a(((QRDisplayActivity)localObject1).jdField_c_of_type_JavaLangString, this.this$0.jdField_c_of_type_Int, -1);
      }
      if ((this.this$0.jdField_a_of_type_ComGoogleZxingCommonBitMatrix != null) && (this.this$0.jdField_c_of_type_Int != 2))
      {
        this.this$0.h();
      }
      else
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
        }
        localObject2 = this.this$0.getIntent();
        if (this.this$0.jdField_c_of_type_Boolean)
        {
          localObject1 = ((Intent)localObject2).getStringExtra("groupOwner");
          ((QidianHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).b(this.this$0.jdField_c_of_type_JavaLangString, (String)localObject1);
          return;
        }
        localObject3 = (TicketManager)this.this$0.app.getManager(2);
        localObject1 = this.this$0.app.getAccount();
        localObject3 = ((TicketManager)localObject3).getSkey((String)localObject1);
        String str = ((Intent)localObject2).getStringExtra("uin");
        i = ((Intent)localObject2).getIntExtra("type", 1);
        localObject2 = new QRDisplayActivity.QRCodeEncodeCallbackImp(null);
        ((QRDisplayActivity.QRCodeEncodeCallbackImp)localObject2).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.this$0);
        ((QRDisplayActivity.QRCodeEncodeCallbackImp)localObject2).jdField_a_of_type_Int = i;
        ((QRDisplayActivity.QRCodeEncodeCallbackImp)localObject2).jdField_a_of_type_JavaLangString = str;
        QRUtils.a(this.this$0.app, this.this$0, str, i, (String)localObject1, (String)localObject3, 0, (QRCodeEncodeCallback)localObject2);
      }
    }
    else
    {
      localObject1 = this.this$0.getSharedPreferences("qrcode", 0);
      localObject2 = this.this$0;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("discussionvalidtime");
      ((StringBuilder)localObject3).append(this.this$0.jdField_c_of_type_JavaLangString);
      ((QRDisplayActivity)localObject2).jdField_b_of_type_Long = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject3).toString(), 0L);
      localObject2 = this.this$0;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("discussion");
      ((StringBuilder)localObject3).append(this.this$0.jdField_c_of_type_JavaLangString);
      ((QRDisplayActivity)localObject2).jdField_d_of_type_JavaLangString = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject3).toString(), null);
      localObject2 = this.this$0;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("discussionfullSig");
      ((StringBuilder)localObject3).append(this.this$0.jdField_c_of_type_JavaLangString);
      ((QRDisplayActivity)localObject2).jdField_e_of_type_JavaLangString = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject3).toString(), null);
      if (this.this$0.jdField_b_of_type_Long - System.currentTimeMillis() / 1000L > 0L) {
        i = 1;
      }
      this.this$0.findViewById(2131374680).setOnClickListener(this.this$0);
      if ((this.this$0.jdField_d_of_type_JavaLangString == null) || (this.this$0.jdField_e_of_type_JavaLangString == null) || (i == 0)) {
        break label1202;
      }
      ((TextView)this.this$0.findViewById(2131373750)).setText(this.this$0.jdField_d_of_type_JavaLangString);
      localObject1 = this.this$0;
      ((QRDisplayActivity)localObject1).jdField_a_of_type_ComGoogleZxingCommonBitMatrix = QRUtils.a(((QRDisplayActivity)localObject1).jdField_d_of_type_JavaLangString, -1);
      this.this$0.h();
    }
    this.this$0.jdField_b_of_type_AndroidViewView.post(this.this$0.jdField_b_of_type_JavaLangRunnable);
    return;
    label1202:
    if (QLog.isDevelopLevel()) {
      QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.this$0.jdField_c_of_type_JavaLangString), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.6
 * JD-Core Version:    0.7.0.1
 */