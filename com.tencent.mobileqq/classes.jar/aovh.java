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

public class aovh
  extends aous
  implements Handler.Callback
{
  public long a;
  private axef jdField_a_of_type_Axef;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public long b;
  private int c = 1000;
  private int d = 60000;
  
  public aovh(Activity paramActivity, List<aotf> paramList, int paramInt)
  {
    super(paramActivity);
    a(paramList, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((localQQAppInterface != null) && (paramString2 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
      awqx.b(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 2, "", "", axeg.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType), paramString2);
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = ajjy.a(2131637608);
    }
    bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 1, paramString2, 0).a();
    f_();
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public int a()
  {
    return 10;
  }
  
  public aots a()
  {
    if (this.jdField_a_of_type_Aots == null) {
      this.jdField_a_of_type_Aots = new aovj(this);
    }
    return this.jdField_a_of_type_Aots;
  }
  
  public aotu a()
  {
    return null;
  }
  
  public ArrayList<bahx>[] a()
  {
    Object localObject3 = this.jdField_a_of_type_Aotf.a();
    String str = c();
    boolean bool1 = apdh.b(str);
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
        localObject1 = apck.a(new FileInfo(str));
        Object localObject4 = apdq.a(2130843339, ajjy.a(2131637613), aorb.a(this.jdField_a_of_type_Aotc, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity));
        localObject3 = localObject1;
        localObject1 = localObject4;
        ((bahx)localObject1).c = 2;
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
          localObject1 = apdq.a(2130843343, ajjy.a(2131637609), aorb.a(this.jdField_a_of_type_Aotc, str));
          ((bahx)localObject1).c = 27;
          localArrayList.add(localObject1);
        }
        boolean bool2 = amlh.a().d();
        long l = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        localObject4 = amlu.a().c();
        localObject1 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject1 = axfs.a;
        }
        if ((bool2) && (localObject3 != null) && (axfs.a(((FileManagerEntity)localObject3).strFilePath, ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
        {
          localObject1 = apdq.a(2130837561, ajjy.a(2131637616), aorb.a((FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
          localArrayList.add(localObject1);
        }
        if (apck.c((FileManagerEntity)localObject3))
        {
          localObject1 = apdq.a(2130843306, ajjy.a(2131637606), aorb.b(this.jdField_a_of_type_Aotc, (FileManagerEntity)localObject3));
          ((bahx)localObject1).c = 6;
          localArrayList.add(localObject1);
        }
        if ((bool1) && (((ajgm)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8)).a.a(b()))) {
          localArrayList.add(apdq.a(2130843341, ajjy.a(2131637614), aorb.b(this.jdField_a_of_type_Aotc, c())));
        }
        if (aozn.a((FileManagerEntity)localObject3, bool1))
        {
          localArrayList.add(apdq.a(2130843334, this.jdField_a_of_type_AndroidAppActivity.getString(2131626929), aorb.a(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
          localArrayList.add(apdq.a(2130839598, this.jdField_a_of_type_AndroidAppActivity.getString(2131626930), aorb.b(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
        }
        if (bool1) {
          localArrayList.add(apdq.a(2130843340, ajjy.a(2131637607), aorb.a(this.jdField_a_of_type_AndroidAppActivity, str)));
        }
        return new ArrayList[] { localArrayList };
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      Object localObject2 = apdq.a(2130843339, ajjy.a(2131637615), aorb.a(this.jdField_a_of_type_Aotc, (FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
      continue;
      label632:
      int i = 0;
      continue;
      label637:
      if (d() == 1) {
        localObject2 = apdq.a(2130843343, ajjy.a(2131637612), aorb.a(this.jdField_a_of_type_Aotc, (FileManagerEntity)localObject3));
      }
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Axef != null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      this.jdField_a_of_type_Axef = new aovi(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    } while ((localQQAppInterface == null) || (this.jdField_a_of_type_Axef == null));
    localQQAppInterface.addObserver(this.jdField_a_of_type_Axef);
  }
  
  protected void c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((this.jdField_a_of_type_Axef != null) && (localQQAppInterface != null)) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Axef);
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
        if (this.jdField_a_of_type_Aovo != null)
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
          paramMessage.fProgress += 5.0F;
          this.jdField_a_of_type_Aovo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8001, this.c);
      }
      else
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8001);
        continue;
        a(ajjy.a(2131637611), "");
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
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aovh
 * JD-Core Version:    0.7.0.1
 */