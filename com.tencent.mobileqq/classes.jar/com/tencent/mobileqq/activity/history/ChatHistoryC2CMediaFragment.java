package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

public class ChatHistoryC2CMediaFragment
  extends ChatHistoryMediaBaseFragment
{
  private FMObserver a;
  
  public ChatHistoryC2CMediaFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new ChatHistoryC2CMediaFragment.1(this);
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent);
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 2, 0, "", "", "", "");
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  protected void q()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.i();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 1, 0, "", "", "", "");
    }
  }
  
  void r()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B5", "0X800A0B5", 1, 0, "", "", "", "");
  }
  
  void s()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B3", "0X800A0B3", 1, 0, "", "", "", "");
  }
  
  void t()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 1, 0, "", "", "", "");
  }
  
  void u()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B4", "0X800A0B4", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CMediaFragment
 * JD-Core Version:    0.7.0.1
 */