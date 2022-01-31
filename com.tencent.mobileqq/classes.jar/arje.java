import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class arje
  extends arjq
{
  private aqru a;
  
  public arje(Activity paramActivity, List<arhz> paramList, int paramInt)
  {
    super(paramActivity);
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
    if ((arrr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz)) && (arrr.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))) {
      return 5;
    }
    return 7;
    return 6;
    return 1;
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity);
  }
  
  public aocf a()
  {
    Object localObject3 = this.jdField_a_of_type_Arhz.a();
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject1 = arrr.a(new FileInfo(d()));
      if (localObject1 == null) {
        return new arij();
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
        if ((i == 4) && (bdhb.b((String)localObject3))) {
          return new arik(localObject2.strFilePath);
        }
      }
      localObject3 = d();
      if ((TextUtils.isEmpty(localObject2.Uuid)) && (bdhb.b((String)localObject3))) {
        return new aril(localObject2.strFilePath);
      }
      if (!TextUtils.isEmpty(localObject2.Uuid)) {
        return new arim(this.jdField_a_of_type_Arhz.a());
      }
      if (!TextUtils.isEmpty(localObject2.WeiYunFileId)) {
        return new arih(localObject2);
      }
    }
    return new arij();
  }
  
  public arip a()
  {
    if (this.jdField_a_of_type_Arip == null) {
      this.jdField_a_of_type_Arip = new arjg(this);
    }
    return this.jdField_a_of_type_Arip;
  }
  
  public aris a()
  {
    if (this.jdField_a_of_type_Aris == null) {
      this.jdField_a_of_type_Aris = new arji(this);
    }
    return this.jdField_a_of_type_Aris;
  }
  
  public arit a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    if (localFileManagerEntity.peerType == 0) {
      return new arix(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    }
    if (localFileManagerEntity.peerType == 3000) {
      return new arja(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
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
    if (this.jdField_a_of_type_Aqru != null) {
      return;
    }
    this.jdField_a_of_type_Aqru = new arjf(this);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "add fmObserver");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().addObserver(this.jdField_a_of_type_Aqru);
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    label155:
    for (;;)
    {
      return;
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
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
            if (!bdhb.b(str)) {
              localObject = localFileManagerEntity.strLargeThumPath;
            }
            if (bdhb.b((String)localObject)) {
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
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if (d() == 0) {
      return null;
    }
    return super.a();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Aqru != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del fmObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().deleteObserver(this.jdField_a_of_type_Aqru);
      this.jdField_a_of_type_Aqru = null;
    }
    if (this.jdField_a_of_type_Arhz.a() == null) {}
  }
  
  public void f()
  {
    if ((arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz)) && (arrr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz)))
    {
      long l = d();
      if (d() == 2) {
        l = arrr.a(c());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, this.jdField_a_of_type_Arhz.a().WeiYunFileId);
    }
    super.f();
  }
  
  public void f_()
  {
    super.f_();
    if ((arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz)) && (arrr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
    }
  }
  
  public void h()
  {
    super.h();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    if (d() == 1)
    {
      if (f() == 3000) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aqwd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aqyc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid));
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
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
      boolean bool = arso.b(str);
      Object localObject = this.jdField_a_of_type_Arhz.a();
      if ((bool) && (localObject == null)) {}
      for (;;)
      {
        try
        {
          FileManagerEntity localFileManagerEntity = arrr.a(new FileInfo(str));
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
          if ((TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)) && (TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId)) && (!bdhb.b(str))) {
            break;
          }
          if ((this.jdField_a_of_type_Arhw == null) || (!this.jdField_a_of_type_Arhw.d())) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arje
 * JD-Core Version:    0.7.0.1
 */