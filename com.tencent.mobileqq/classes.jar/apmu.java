import android.app.Activity;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class apmu
  extends apme
  implements Handler.Callback
{
  public long a;
  private ayeh jdField_a_of_type_Ayeh;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public long b;
  private int c = 1000;
  private int d = 60000;
  
  public apmu(Activity paramActivity, List<apkp> paramList, int paramInt)
  {
    super(paramActivity);
    a(paramList, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((localQQAppInterface != null) && (paramString2 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
      axqw.b(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 2, "", "", ayei.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType), paramString2);
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = ajyc.a(2131703393);
    }
    bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 1, paramString2, 0).a();
    f_();
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public int a()
  {
    return 10;
  }
  
  public aple a()
  {
    if (this.jdField_a_of_type_Aple == null) {
      this.jdField_a_of_type_Aple = new apmw(this);
    }
    return this.jdField_a_of_type_Aple;
  }
  
  public aplg a()
  {
    return null;
  }
  
  public ArrayList<bbje>[] a()
  {
    Object localObject3 = this.jdField_a_of_type_Apkp.a();
    String str = c();
    boolean bool1 = apvb.b(str);
    if ((localObject3 == null) && (TextUtils.isEmpty(str))) {
      return null;
    }
    if (b() == 16) {
      return null;
    }
    if ((!bool1) && (localObject3 != null) && (((FileManagerEntity)localObject3).isZipInnerFile)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (bool1)
    {
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = apue.a(new FileInfo(str));
        Object localObject4 = apvk.a(2130843421, ajyc.a(2131703398), apik.a(this.jdField_a_of_type_Apkm, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity));
        localObject3 = localObject1;
        localObject1 = localObject4;
        ((bbje)localObject1).c = 2;
        localArrayList.add(localObject1);
        if ((localObject3 == null) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunFileId)) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunDirKey))) {
          break label632;
        }
        i = 1;
        if (i == 0)
        {
          if (!bool1) {
            break label637;
          }
          localObject1 = apvk.a(2130843425, ajyc.a(2131703394), apik.a(this.jdField_a_of_type_Apkm, str));
          ((bbje)localObject1).c = 27;
          localArrayList.add(localObject1);
        }
        boolean bool2 = anbl.a().d();
        long l = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        localObject4 = ancb.a().c();
        localObject1 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject1 = ayfv.a;
        }
        if ((bool2) && (localObject3 != null) && (ayfv.a(((FileManagerEntity)localObject3).strFilePath, ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
        {
          localObject1 = apvk.a(2130837566, ajyc.a(2131703401), apik.a((FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
          localArrayList.add(localObject1);
        }
        if (apue.c((FileManagerEntity)localObject3))
        {
          localObject1 = apvk.a(2130843387, ajyc.a(2131703391), apik.b(this.jdField_a_of_type_Apkm, (FileManagerEntity)localObject3));
          ((bbje)localObject1).c = 6;
          localArrayList.add(localObject1);
        }
        if ((bool1) && (((ajuo)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8)).a.a(b()))) {
          localArrayList.add(apvk.a(2130843423, ajyc.a(2131703399), apik.b(this.jdField_a_of_type_Apkm, c())));
        }
        if (aprh.a((FileManagerEntity)localObject3, bool1))
        {
          localArrayList.add(apvk.a(2130843416, this.jdField_a_of_type_AndroidAppActivity.getString(2131692547), apik.a(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
          localArrayList.add(apvk.a(2130839646, this.jdField_a_of_type_AndroidAppActivity.getString(2131692548), apik.b(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
        }
        if (bool1) {
          localArrayList.add(apvk.a(2130843422, ajyc.a(2131703392), apik.a(this.jdField_a_of_type_AndroidAppActivity, str)));
        }
        return new ArrayList[] { localArrayList };
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      Object localObject2 = apvk.a(2130843421, ajyc.a(2131703400), apik.a(this.jdField_a_of_type_Apkm, (FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
      continue;
      label632:
      int i = 0;
      continue;
      label637:
      if (d() == 1) {
        localObject2 = apvk.a(2130843425, ajyc.a(2131703397), apik.a(this.jdField_a_of_type_Apkm, (FileManagerEntity)localObject3));
      }
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ayeh != null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      this.jdField_a_of_type_Ayeh = new apmv(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    } while ((localQQAppInterface == null) || (this.jdField_a_of_type_Ayeh == null));
    localQQAppInterface.addObserver(this.jdField_a_of_type_Ayeh);
  }
  
  protected void c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((this.jdField_a_of_type_Ayeh != null) && (localQQAppInterface != null)) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Ayeh);
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8001);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8002);
    }
  }
  
  public void f_()
  {
    super.f_();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress <= 45.0F))
      {
        if (this.jdField_a_of_type_Apnb != null)
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
          paramMessage.fProgress += 5.0F;
          this.jdField_a_of_type_Apnb.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8001, this.c);
      }
      else
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8001);
        continue;
        a(ajyc.a(2131703396), "");
      }
    }
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    if (d() == 1)
    {
      if (f() == 3000) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aoys(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new apar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid));
  }
  
  public boolean i()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmu
 * JD-Core Version:    0.7.0.1
 */