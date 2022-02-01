import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

public class atnl
  implements atnh
{
  protected QQAppInterface a;
  protected FileManagerEntity a;
  
  public atnl(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
  }
  
  private String a(String paramString, int paramInt, List<String> paramList, boolean paramBoolean)
  {
    if (!atcq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1)) {}
    for (;;)
    {
      return "";
      int i;
      if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
      {
        QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download mediaplatform. is config enable IPv6. domain[" + paramString + "]");
        paramString = atcq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramList);
        if ((paramString != null) && (paramString.size() > 0))
        {
          i = paramString.size();
          paramInt = 0;
          if (paramInt >= i) {
            break label192;
          }
          paramList = (String)paramString.get(paramInt);
          if (!TextUtils.isEmpty(paramList))
          {
            paramString = "[" + paramList + "]";
            QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download mediaplatform. use IPv6. hostlist:" + paramString);
          }
        }
        for (;;)
        {
          return paramString;
          paramInt += 1;
          break;
          QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download mediaplatform. use IPv4");
          label192:
          paramString = "";
        }
      }
      if (!TextUtils.isEmpty(paramString))
      {
        QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download. is config enable IPv6. domain[" + paramString + "]");
        paramString = new atcr(paramString, paramInt);
        paramString = atcq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
        if ((paramString == null) || (paramString.a())) {
          break;
        }
        i = paramString.a.size();
        paramInt = 0;
        while (paramInt < i)
        {
          paramList = (atcs)paramString.a.get(paramInt);
          if ((paramList != null) && (!TextUtils.isEmpty(paramList.a)))
          {
            paramString = paramList.a;
            QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download. use IPv6. hostlist:" + paramString);
            return paramString;
          }
          paramInt += 1;
        }
      }
    }
    QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download. use IPv4");
    return "";
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "";
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)paramLong / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  public void a(atds paramatds)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid))
    {
      a(true);
      paramatds.a(-6101, BaseApplication.getContext().getResources().getString(2131692499));
      QLog.e("VideoForC2C<QFile>XOXO", 2, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],[getOnlinePlay]  uuid is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, false, new atnm(this, paramatds));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(paramString);
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.localModifyTime = localFile.lastModified();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOLfileSessionId = 0L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    atvo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 11, new Object[] { paramString, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath }, 0, null);
    atdq.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 12, null, 2, null);
    atdq.a(this);
  }
  
  public String b()
  {
    return atut.a().c() + bkdr.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atnl
 * JD-Core Version:    0.7.0.1
 */