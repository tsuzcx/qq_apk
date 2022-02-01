import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class atlt
  implements bmsy
{
  atlt(atll paramatll) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong, bmsj parambmsj, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_Auiw == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        if (parambmsj.jdField_a_of_type_Int == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted[" + this.a.c + "]");
          }
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 16, null, 0, null);
          return;
        }
        if (parambmsj.jdField_a_of_type_Int == 5)
        {
          if (parambmsj.jdField_b_of_type_Int == 1810002)
          {
            if (QLog.isColorLevel()) {
              QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is canceled[" + this.a.c + "],set trafficData size[" + this.a.jdField_a_of_type_Long + "]");
            }
            if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1)
            {
              paramString = new String[3];
              paramString[0] = "param_WIFIFileFlow";
              paramString[1] = "param_WIFIFlow";
              paramString[2] = "param_Flow";
            }
            for (;;)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString, this.a.jdField_a_of_type_Long);
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 3, null, 0, null);
              return;
              paramString = new String[3];
              paramString[0] = "param_XGFileFlow";
              paramString[1] = "param_XGFlow";
              paramString[2] = "param_Flow";
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onFailed[" + this.a.c + "],set trafficData size[" + this.a.jdField_a_of_type_Long + "]");
          }
          if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1)
          {
            paramString = new String[3];
            paramString[0] = "param_WIFIFileFlow";
            paramString[1] = "param_WIFIFlow";
            paramString[2] = "param_Flow";
          }
          for (;;)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString, this.a.jdField_a_of_type_Long);
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 36, null, parambmsj.jdField_b_of_type_Int, parambmsj.jdField_a_of_type_JavaLangString);
            return;
            paramString = new String[3];
            paramString[0] = "param_XGFileFlow";
            paramString[1] = "param_XGFlow";
            paramString[2] = "param_Flow";
          }
        }
      } while (parambmsj.jdField_a_of_type_Int != 4);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed[" + this.a.c + "],set trafficData size[" + this.a.jdField_a_of_type_Long + "]");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(parambmsj.jdField_b_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = auea.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
      this.a.h = System.currentTimeMillis();
      if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1)
      {
        paramString = new String[3];
        paramString[0] = "param_WIFIFileFlow";
        paramString[1] = "param_WIFIFlow";
        paramString[2] = "param_Flow";
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString, this.a.jdField_a_of_type_Long);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 35, null, 0, null);
        paramString = new audz();
        paramString.jdField_b_of_type_JavaLangString = "rece_file_suc";
        paramString.jdField_a_of_type_Int = 1;
        audy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString);
        return;
        paramString = new String[3];
        paramString[0] = "param_XGFileFlow";
        paramString[1] = "param_XGFlow";
        paramString[2] = "param_Flow";
      }
      paramLong = System.currentTimeMillis();
      this.a.jdField_a_of_type_Long = parambmsj.jdField_b_of_type_Long;
    } while (paramLong - this.a.f < 1000L);
    this.a.f = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.a.c + "]WeiYun download is onProgressChange mtransferedSize[" + this.a.jdField_a_of_type_Long + "/" + this.a.d + "]");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.a.jdField_a_of_type_Long / (float)this.a.d);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 16, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atlt
 * JD-Core Version:    0.7.0.1
 */