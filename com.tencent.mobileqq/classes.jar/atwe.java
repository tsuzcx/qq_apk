import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class atwe
  extends atwq
{
  private atfq a;
  
  public atwe(QQAppInterface paramQQAppInterface, Activity paramActivity, List<atuz> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("C2CFileModel<FileAssistant>", 1, "FileBrowserModel init: type = c2c");
    }
    a(paramList, paramInt);
  }
  
  public int a()
  {
    int i = 2;
    int j = d();
    if (j == 0) {
      i = 9;
    }
    do
    {
      return i;
      int k = super.a();
      if (k != 0) {
        return k;
      }
      switch (e())
      {
      case 3: 
      default: 
        return 7;
      }
    } while ((j != 2) && (!f()));
    return 1;
    if ((auea.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atuz, false)) && (auea.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))) {
      return 5;
    }
    return 7;
    return 6;
    return 1;
    return 11;
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity);
  }
  
  public aqoa a()
  {
    Object localObject3 = this.jdField_a_of_type_Atuz.a();
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject1 = auea.a(new FileInfo(d()));
      if (localObject1 == null) {
        return new atvj();
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject2;
      for (;;)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
      }
      if ((this.b == 14) && (this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("file_color_note_subType")))
      {
        int i = this.jdField_a_of_type_AndroidOsBundle.getInt("file_color_note_subType", -1);
        localObject3 = d();
        if ((i == 4) && (FileUtils.fileExistsAndNotEmpty((String)localObject3))) {
          return new atvk(localObject2.getFilePath());
        }
      }
      localObject3 = d();
      if ((TextUtils.isEmpty(localObject2.Uuid)) && (FileUtils.fileExistsAndNotEmpty((String)localObject3))) {
        return new atvl(localObject2.getFilePath());
      }
      if (!TextUtils.isEmpty(localObject2.Uuid)) {
        return new atvm(this.jdField_a_of_type_Atuz.a());
      }
      if (!TextUtils.isEmpty(localObject2.WeiYunFileId)) {
        return new atvh(localObject2);
      }
    }
    return new atvj();
  }
  
  public atvp a()
  {
    if (this.jdField_a_of_type_Atvp == null) {
      this.jdField_a_of_type_Atvp = new atwf(this);
    }
    return this.jdField_a_of_type_Atvp;
  }
  
  public atvs a()
  {
    if (this.jdField_a_of_type_Atvs == null) {
      this.jdField_a_of_type_Atvs = new atwh(this);
    }
    return this.jdField_a_of_type_Atvs;
  }
  
  public atvt a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    if (localFileManagerEntity.peerType == 0) {
      return new atvx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    }
    if (localFileManagerEntity.peerType == 3000) {
      return new atwa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    }
    QLog.w("C2CFileModel<FileAssistant>", 1, "unsuporrt peer type:" + localFileManagerEntity.peerType);
    return null;
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Atfq != null) {
      return;
    }
    this.jdField_a_of_type_Atfq = new atwj(this, null);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "add fmObserver");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_Atfq);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidOsBundle.getBoolean("file_location_pos_entrance_multiseq", false));
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("FromChatHistoryTab", 0);
      } while (i == 106);
      i = aufd.c(this.b, i);
    } while (i == 0);
    Bundle localBundle = new Bundle();
    localBundle.putInt("file_location_pos_entrance_type", i);
    paramArrayList.add(aufd.a(54, atti.a(this.jdField_a_of_type_AndroidAppActivity, localBundle, paramFileManagerEntity)));
    bdla.b(null, "dc00898", "", "", "0X800B450", "0X800B450", i, 0, "", "", "", "");
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    label155:
    for (;;)
    {
      return;
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
      if (localFileManagerEntity != null)
      {
        int j = paramActionSheetItem.action;
        int i;
        if (j == 52)
        {
          i = localFileManagerEntity.getCloudType();
          if (i == 2)
          {
            i = -1006;
            Object localObject = localFileManagerEntity.strFileMd5;
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              paramActionSheetItem = localFileManagerEntity.str10Md5;
            }
            String str = d();
            localObject = str;
            if (!FileUtils.fileExistsAndNotEmpty(str)) {
              localObject = localFileManagerEntity.strLargeThumPath;
            }
            if (FileUtils.fileExistsAndNotEmpty((String)localObject)) {
              OCRPerformFragment.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, 1, i, paramActionSheetItem);
            }
            i = 1;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label155;
          }
          f(j);
          return;
          if (i == 1)
          {
            i = -1001;
            break;
          }
          i = -1004;
          break;
          i = 0;
          super.a(paramActionSheetItem);
        }
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if (d() == 0) {
      return null;
    }
    return super.a();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Atfq != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del fmObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_Atfq);
      this.jdField_a_of_type_Atfq = null;
    }
    if (this.jdField_a_of_type_Atuz.a() == null) {}
  }
  
  public void f()
  {
    if ((auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atuz, true)) && (auea.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atuz, true)))
    {
      long l = d();
      if (d() == 2) {
        l = auea.a(c());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(l, this.jdField_a_of_type_Atuz.a().WeiYunFileId);
    }
    super.f();
  }
  
  public void h()
  {
    super.h();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    if (d() == 1)
    {
      if (f() == 3000) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new auhr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new atnb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.fileIdCrc));
  }
  
  public int i()
  {
    int i = super.i();
    if (g() == 10) {
      i = 6;
    }
    return i;
  }
  
  public String i()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return localFileManagerEntity.mExcitingSpeed;
  }
  
  public boolean i()
  {
    int i = g();
    if ((d() == 0) && ((i == 11) || (i == 12) || (i == 13))) {
      return false;
    }
    return super.i();
  }
  
  public int j()
  {
    int i = e();
    if ((i != 0) && (i != 2) && (i != 13)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        return 0;
      }
      String str = d();
      boolean bool = FileUtil.fileExistsAndNotEmpty(str);
      Object localObject = this.jdField_a_of_type_Atuz.a();
      if ((bool) && (localObject == null)) {}
      for (;;)
      {
        try
        {
          FileManagerEntity localFileManagerEntity = auea.a(new FileInfo(str));
          localObject = localFileManagerEntity;
          if ((localObject == null) || (((FileManagerEntity)localObject).status == 16)) {
            break;
          }
          if (g() == 0)
          {
            i = b();
            if ((i == 0) || (i == 3) || (i == 2)) {
              break;
            }
          }
          if ((TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)) && (TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId)) && (!FileUtils.fileExistsAndNotEmpty(str))) {
            break;
          }
          if ((this.jdField_a_of_type_Atuw == null) || (!this.jdField_a_of_type_Atuw.e())) {
            break label173;
          }
          return 2;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
        }
      }
      label173:
      return 1;
    }
  }
  
  public String j()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkPackageName;
    }
    return "";
  }
  
  public String k()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkName;
    }
    return "";
  }
  
  public String l()
  {
    if (e() == 5)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
      if (localFileManagerEntity != null) {
        return localFileManagerEntity.yybApkIconUrl;
      }
    }
    return "";
  }
  
  public void l_()
  {
    super.l_();
    if ((auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atuz, true)) && (auea.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atuz, true))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwe
 * JD-Core Version:    0.7.0.1
 */