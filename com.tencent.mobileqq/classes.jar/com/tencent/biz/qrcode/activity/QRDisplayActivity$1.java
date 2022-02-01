package com.tencent.biz.qrcode.activity;

import android.view.View;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class QRDisplayActivity$1
  extends QRDisplayActivity.GetNicknameObserver
{
  QRDisplayActivity$1(QRDisplayActivity paramQRDisplayActivity)
  {
    super(paramQRDisplayActivity);
  }
  
  protected void a(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetNicknameList: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("QRDisplayActivity", 4, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramList1 != null) && (paramList2 != null))
    {
      int j = paramList2.size();
      if ((j > 0) && (paramList1.size() == j))
      {
        if (this.a.jdField_b_of_type_JavaUtilList == null) {
          this.a.jdField_b_of_type_JavaUtilList = new ArrayList();
        }
        this.a.jdField_b_of_type_JavaUtilList.addAll(paramList1);
        int i = 0;
        while (i < j)
        {
          if (this.a.a((String)paramList2.get(i)) == null) {
            this.a.a((String)paramList2.get(i), (String)paramList1.get(i));
          }
          i += 1;
        }
        Collections.sort(this.a.jdField_b_of_type_JavaUtilList, new QRDisplayActivity.DiscussionMemberComparator(this.a));
      }
    }
    paramList1 = this.a;
    paramList1.jdField_a_of_type_JavaLangString = paramList1.a(paramList1.jdField_b_of_type_JavaUtilList);
    if (this.a.jdField_a_of_type_JavaLangString != null)
    {
      paramList1 = this.a.jdField_a_of_type_AndroidWidgetImageView;
      paramList2 = new StringBuilder();
      paramList2.append(this.a.jdField_a_of_type_JavaLangString);
      paramList2.append(",");
      paramList2.append(this.a.jdField_b_of_type_JavaLangString);
      paramList1.setContentDescription(paramList2.toString());
      this.a.c.post(this.a.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.1
 * JD-Core Version:    0.7.0.1
 */