package com.tencent.mobileqq.activity.history;

import adxg;
import aflr;
import android.content.Intent;
import aodp;
import aoii;
import awqx;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class ChatHistoryC2CMediaFragment
  extends ChatHistoryMediaBaseFragment
{
  private aodp a;
  
  public ChatHistoryC2CMediaFragment()
  {
    this.jdField_a_of_type_Aodp = new aflr(this);
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      adxg.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent);
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Aodp != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aodp);
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 2, 0, "", "", "", "");
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Aodp != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aodp);
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Aodp != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aodp);
    }
  }
  
  protected void p()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.h();
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 1, 0, "", "", "", "");
    }
  }
  
  void q()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B5", "0X800A0B5", 1, 0, "", "", "", "");
  }
  
  void r()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B3", "0X800A0B3", 1, 0, "", "", "", "");
  }
  
  void s()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 1, 0, "", "", "", "");
  }
  
  void t()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B4", "0X800A0B4", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CMediaFragment
 * JD-Core Version:    0.7.0.1
 */