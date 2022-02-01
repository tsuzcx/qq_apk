package com.tencent.mobileqq.activity.aio.intimate;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;

class StrangerIntimateView$4
  implements DecodeTaskCompletionListener
{
  StrangerIntimateView$4(StrangerIntimateView paramStrangerIntimateView) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBitmap == null) {
        return;
      }
      if (paramString.equals(this.a.jdField_a_of_type_JavaLangString)) {
        StrangerIntimateView.b(this.a).setImageBitmap(paramBitmap);
      } else if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        StrangerIntimateView.a(this.a).setImageBitmap(paramBitmap);
      }
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("onDecodeTaskCompleted, uin: ");
        paramBitmap.append(paramString);
        paramBitmap.append(", type: ");
        paramBitmap.append(paramInt2);
        QLog.d("intimate_relationship", 2, paramBitmap.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView.4
 * JD-Core Version:    0.7.0.1
 */