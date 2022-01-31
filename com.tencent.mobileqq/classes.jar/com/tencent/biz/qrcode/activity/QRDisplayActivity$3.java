package com.tencent.biz.qrcode.activity;

import ajhf;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import bcqv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.TicketManager;
import vsp;
import vts;
import vvp;

class QRDisplayActivity$3
  implements Runnable
{
  QRDisplayActivity$3(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    int i = 0;
    int k = (int)(20.0F * QRDisplayActivity.a(this.this$0));
    int j = this.this$0.jdField_c_of_type_AndroidViewView.getWidth() - k * 2;
    k = this.this$0.jdField_c_of_type_AndroidViewView.getHeight() - k * 2;
    Object localObject1;
    if ((j >= 540) && (k >= 740))
    {
      this.this$0.jdField_d_of_type_Int = 540;
      this.this$0.jdField_e_of_type_Int = 740;
      if (this.this$0.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        ThreadManager.post(new QRDisplayActivity.3.1(this), 8, null, false);
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
      if (this.this$0.jdField_c_of_type_Int == 5) {
        break label732;
      }
      if (this.this$0.jdField_c_of_type_Int == 11)
      {
        localObject1 = this.this$0.getIntent().getStringExtra("url");
        this.this$0.a(this.this$0.jdField_c_of_type_JavaLangString, this.this$0.jdField_c_of_type_Int, (String)localObject1);
      }
      if (this.this$0.jdField_a_of_type_Gq == null) {
        this.this$0.jdField_a_of_type_Gq = this.this$0.a(this.this$0.jdField_c_of_type_JavaLangString, this.this$0.jdField_c_of_type_Int, -1);
      }
      if (this.this$0.jdField_a_of_type_Gq == null) {
        break label540;
      }
      this.this$0.f();
    }
    for (;;)
    {
      this.this$0.jdField_b_of_type_AndroidViewView.post(this.this$0.jdField_b_of_type_JavaLangRunnable);
      return;
      if (j * 740 < k * 540) {
        this.this$0.jdField_d_of_type_Int = j;
      }
      for (this.this$0.jdField_e_of_type_Int = ((int)(j / 540.0D * 740.0D));; this.this$0.jdField_e_of_type_Int = k)
      {
        localObject1 = this.this$0.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.this$0.jdField_d_of_type_Int;
        ((ViewGroup.LayoutParams)localObject1).height = this.this$0.jdField_e_of_type_Int;
        this.this$0.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = this.this$0.jdField_d_of_type_AndroidViewView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.this$0.jdField_d_of_type_Int;
        ((ViewGroup.LayoutParams)localObject1).height = this.this$0.jdField_e_of_type_Int;
        this.this$0.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
        this.this$0.jdField_d_of_type_Int = ((int)(k / 740.0D * 540.0D));
      }
      label540:
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
      }
      Object localObject2 = this.this$0.getIntent();
      if (this.this$0.jdField_c_of_type_Boolean)
      {
        localObject1 = ((Intent)localObject2).getStringExtra("groupOwner");
        ((bcqv)this.this$0.app.a(85)).b(this.this$0.jdField_c_of_type_JavaLangString, (String)localObject1);
        return;
      }
      Object localObject3 = (TicketManager)this.this$0.app.getManager(2);
      localObject1 = this.this$0.app.getAccount();
      localObject3 = ((TicketManager)localObject3).getSkey((String)localObject1);
      String str = ((Intent)localObject2).getStringExtra("uin");
      i = ((Intent)localObject2).getIntExtra("type", 1);
      localObject2 = new vts(null);
      ((vts)localObject2).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.this$0);
      ((vts)localObject2).jdField_a_of_type_Int = i;
      ((vts)localObject2).jdField_a_of_type_JavaLangString = str;
      vvp.a(this.this$0.app, this.this$0, str, i, (String)localObject1, (String)localObject3, (vsp)localObject2);
      continue;
      label732:
      localObject1 = this.this$0.getSharedPreferences("qrcode", 0);
      this.this$0.jdField_b_of_type_Long = ((SharedPreferences)localObject1).getLong("discussionvalidtime" + this.this$0.jdField_c_of_type_JavaLangString, 0L);
      this.this$0.jdField_d_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("discussion" + this.this$0.jdField_c_of_type_JavaLangString, null);
      this.this$0.jdField_e_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("discussionfullSig" + this.this$0.jdField_c_of_type_JavaLangString, null);
      if (this.this$0.jdField_b_of_type_Long - System.currentTimeMillis() / 1000L > 0L) {
        i = 1;
      }
      this.this$0.findViewById(2131307719).setOnClickListener(this.this$0);
      if ((this.this$0.jdField_d_of_type_JavaLangString == null) || (this.this$0.jdField_e_of_type_JavaLangString == null) || (i == 0)) {
        break label980;
      }
      ((TextView)this.this$0.findViewById(2131306901)).setText(this.this$0.jdField_d_of_type_JavaLangString);
      this.this$0.jdField_a_of_type_Gq = vvp.a(this.this$0.jdField_d_of_type_JavaLangString, -1);
      this.this$0.f();
    }
    label980:
    if (QLog.isDevelopLevel()) {
      QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
    }
    this.this$0.jdField_a_of_type_Ajhf.a(Long.parseLong(this.this$0.jdField_c_of_type_JavaLangString), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.3
 * JD-Core Version:    0.7.0.1
 */