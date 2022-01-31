import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class aplw
  extends apmi
{
  private aoun a;
  
  public aplw(Activity paramActivity, List<apkt> paramList, int paramInt)
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
    if ((apug.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkt)) && (apug.a(this.jdField_a_of_type_AndroidAppActivity, b(), c()))) {
      return 5;
    }
    return 7;
    return 6;
    return 1;
  }
  
  public amgv a()
  {
    Object localObject3 = this.jdField_a_of_type_Apkt.a();
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject1 = apug.a(new FileInfo(c()));
      if (localObject1 == null) {
        return new aplc();
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
        localObject3 = c();
        if ((i == 4) && (bbdx.b((String)localObject3))) {
          return new apld(localObject2.strFilePath);
        }
      }
      localObject3 = c();
      if ((TextUtils.isEmpty(localObject2.Uuid)) && (bbdx.b((String)localObject3))) {
        return new aple(localObject2.strFilePath);
      }
      if (!TextUtils.isEmpty(localObject2.Uuid)) {
        return new aplf(this.jdField_a_of_type_Apkt.a());
      }
      if (!TextUtils.isEmpty(localObject2.WeiYunFileId)) {
        return new apla(localObject2);
      }
    }
    return new aplc();
  }
  
  public apli a()
  {
    if (this.jdField_a_of_type_Apli == null) {
      this.jdField_a_of_type_Apli = new aply(this);
    }
    return this.jdField_a_of_type_Apli;
  }
  
  public aplk a()
  {
    if (this.jdField_a_of_type_Aplk == null) {
      this.jdField_a_of_type_Aplk = new apma(this);
    }
    return this.jdField_a_of_type_Aplk;
  }
  
  public apll a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    if (localFileManagerEntity.peerType == 0) {
      return new aplp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    }
    if (localFileManagerEntity.peerType == 3000) {
      return new apls(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    }
    QLog.w("C2CFileModel<FileAssistant>", 1, "unsuporrt peer type:" + localFileManagerEntity.peerType);
    return null;
  }
  
  public ArrayList<bbjs>[] a()
  {
    if (d() == 0) {
      return null;
    }
    return super.a();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Aoun != null) {
      return;
    }
    this.jdField_a_of_type_Aoun = new aplx(this);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "add fmObserver");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().addObserver(this.jdField_a_of_type_Aoun);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Aoun != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del fmObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().deleteObserver(this.jdField_a_of_type_Aoun);
      this.jdField_a_of_type_Aoun = null;
    }
    if (this.jdField_a_of_type_Apkt.a() == null) {}
  }
  
  public void f_()
  {
    super.f_();
    if ((apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkt)) && (apug.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkt))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
    }
  }
  
  public String g()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return localFileManagerEntity.mExcitingSpeed;
  }
  
  public void g()
  {
    if ((apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkt)) && (apug.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkt)))
    {
      long l = d();
      if (d() == 2) {
        l = apug.a(c());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, this.jdField_a_of_type_Apkt.a().WeiYunFileId);
    }
    super.g();
  }
  
  public int i()
  {
    int i = super.i();
    if (g() == 10) {
      i = 6;
    }
    return i;
  }
  
  public void i()
  {
    super.i();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    if (d() == 1)
    {
      if (f() == 3000) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aoyw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new apav(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid));
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
      String str = c();
      boolean bool = apvd.b(str);
      Object localObject = this.jdField_a_of_type_Apkt.a();
      if ((bool) && (localObject == null)) {}
      for (;;)
      {
        try
        {
          FileManagerEntity localFileManagerEntity = apug.a(new FileInfo(str));
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
          if ((TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)) && (TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId)) && (!bbdx.b(str))) {
            break;
          }
          if ((this.jdField_a_of_type_Apkq == null) || (!this.jdField_a_of_type_Apkq.d())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplw
 * JD-Core Version:    0.7.0.1
 */