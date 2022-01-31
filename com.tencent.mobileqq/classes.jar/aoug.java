import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class aoug
  extends aous
{
  private aodp a;
  
  public aoug(Activity paramActivity, List<aotf> paramList, int paramInt)
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
    if ((apck.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf)) && (apck.a(this.jdField_a_of_type_AndroidAppActivity, b(), c()))) {
      return 5;
    }
    return 7;
    return 6;
    return 1;
  }
  
  public alsd a()
  {
    Object localObject3 = this.jdField_a_of_type_Aotf.a();
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject1 = apck.a(new FileInfo(c()));
      if (localObject1 == null) {
        return new aoto();
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
      localObject3 = c();
      if ((TextUtils.isEmpty(localObject2.Uuid)) && (bace.b((String)localObject3))) {
        return new aotp(localObject2.strFilePath);
      }
      if (!TextUtils.isEmpty(localObject2.Uuid)) {
        return new aotq(this.jdField_a_of_type_Aotf.a());
      }
      if (!TextUtils.isEmpty(localObject2.WeiYunFileId)) {
        return new aotm(localObject2);
      }
    }
    return new aoto();
  }
  
  public aots a()
  {
    if (this.jdField_a_of_type_Aots == null) {
      this.jdField_a_of_type_Aots = new aoui(this);
    }
    return this.jdField_a_of_type_Aots;
  }
  
  public aotu a()
  {
    if (this.jdField_a_of_type_Aotu == null) {
      this.jdField_a_of_type_Aotu = new aouk(this);
    }
    return this.jdField_a_of_type_Aotu;
  }
  
  public aotv a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    if (localFileManagerEntity.peerType == 0) {
      return new aotz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    }
    if (localFileManagerEntity.peerType == 3000) {
      return new aouc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    }
    QLog.w("C2CFileModel<FileAssistant>", 1, "unsuporrt peer type:" + localFileManagerEntity.peerType);
    return null;
  }
  
  public ArrayList<bahx>[] a()
  {
    if (d() == 0) {
      return null;
    }
    return super.a();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Aodp != null) {
      return;
    }
    this.jdField_a_of_type_Aodp = new aouh(this);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "add fmObserver");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().addObserver(this.jdField_a_of_type_Aodp);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Aodp != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del fmObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().deleteObserver(this.jdField_a_of_type_Aodp);
      this.jdField_a_of_type_Aodp = null;
    }
    if (this.jdField_a_of_type_Aotf.a() == null) {}
  }
  
  public void f_()
  {
    super.f_();
    if ((apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf)) && (apck.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
    }
  }
  
  public String g()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return localFileManagerEntity.mExcitingSpeed;
  }
  
  public void g()
  {
    if ((apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf)) && (apck.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf)))
    {
      long l = d();
      if (d() == 2) {
        l = apck.a(c());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, this.jdField_a_of_type_Aotf.a().WeiYunFileId);
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    if (d() == 1)
    {
      if (f() == 3000) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aohy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aojx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid));
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
      boolean bool = apdh.b(str);
      Object localObject = this.jdField_a_of_type_Aotf.a();
      if ((bool) && (localObject == null)) {}
      for (;;)
      {
        try
        {
          FileManagerEntity localFileManagerEntity = apck.a(new FileInfo(str));
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
          if ((TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)) && (TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId)) && (!bace.b(str))) {
            break;
          }
          if ((this.jdField_a_of_type_Aotc == null) || (!this.jdField_a_of_type_Aotc.d())) {
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
 * Qualified Name:     aoug
 * JD-Core Version:    0.7.0.1
 */