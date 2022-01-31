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

public class apmy
  extends apmi
  implements Handler.Callback
{
  public long a;
  private ayej jdField_a_of_type_Ayej;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public long b;
  private int c = 1000;
  private int d = 60000;
  
  public apmy(Activity paramActivity, List<apkt> paramList, int paramInt)
  {
    super(paramActivity);
    a(paramList, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((localQQAppInterface != null) && (paramString2 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
      axqy.b(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 2, "", "", ayek.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType), paramString2);
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = ajya.a(2131703404);
    }
    bcql.a(this.jdField_a_of_type_AndroidAppActivity, 1, paramString2, 0).a();
    f_();
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public int a()
  {
    return 10;
  }
  
  public apli a()
  {
    if (this.jdField_a_of_type_Apli == null) {
      this.jdField_a_of_type_Apli = new apna(this);
    }
    return this.jdField_a_of_type_Apli;
  }
  
  public aplk a()
  {
    return null;
  }
  
  public ArrayList<bbjs>[] a()
  {
    Object localObject3 = this.jdField_a_of_type_Apkt.a();
    String str = c();
    boolean bool1 = apvd.b(str);
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
        localObject1 = apug.a(new FileInfo(str));
        Object localObject4 = apvm.a(2130843422, ajya.a(2131703409), apio.a(this.jdField_a_of_type_Apkq, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity));
        localObject3 = localObject1;
        localObject1 = localObject4;
        ((bbjs)localObject1).c = 2;
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
          localObject1 = apvm.a(2130843426, ajya.a(2131703405), apio.a(this.jdField_a_of_type_Apkq, str));
          ((bbjs)localObject1).c = 27;
          localArrayList.add(localObject1);
        }
        boolean bool2 = anbq.a().d();
        long l = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        localObject4 = ancg.a().c();
        localObject1 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject1 = ayfx.a;
        }
        if ((bool2) && (localObject3 != null) && (ayfx.a(((FileManagerEntity)localObject3).strFilePath, ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
        {
          localObject1 = apvm.a(2130837566, ajya.a(2131703412), apio.a((FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
          localArrayList.add(localObject1);
        }
        if (apug.c((FileManagerEntity)localObject3))
        {
          localObject1 = apvm.a(2130843388, ajya.a(2131703402), apio.b(this.jdField_a_of_type_Apkq, (FileManagerEntity)localObject3));
          ((bbjs)localObject1).c = 6;
          localArrayList.add(localObject1);
        }
        if ((bool1) && (((ajum)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8)).a.a(b()))) {
          localArrayList.add(apvm.a(2130843424, ajya.a(2131703410), apio.b(this.jdField_a_of_type_Apkq, c())));
        }
        if (aprl.a((FileManagerEntity)localObject3, bool1))
        {
          localArrayList.add(apvm.a(2130843417, this.jdField_a_of_type_AndroidAppActivity.getString(2131692548), apio.a(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
          localArrayList.add(apvm.a(2130839646, this.jdField_a_of_type_AndroidAppActivity.getString(2131692549), apio.b(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
        }
        if (bool1) {
          localArrayList.add(apvm.a(2130843423, ajya.a(2131703403), apio.a(this.jdField_a_of_type_AndroidAppActivity, str)));
        }
        return new ArrayList[] { localArrayList };
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      Object localObject2 = apvm.a(2130843422, ajya.a(2131703411), apio.a(this.jdField_a_of_type_Apkq, (FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
      continue;
      label632:
      int i = 0;
      continue;
      label637:
      if (d() == 1) {
        localObject2 = apvm.a(2130843426, ajya.a(2131703408), apio.a(this.jdField_a_of_type_Apkq, (FileManagerEntity)localObject3));
      }
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ayej != null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      this.jdField_a_of_type_Ayej = new apmz(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    } while ((localQQAppInterface == null) || (this.jdField_a_of_type_Ayej == null));
    localQQAppInterface.addObserver(this.jdField_a_of_type_Ayej);
  }
  
  protected void c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((this.jdField_a_of_type_Ayej != null) && (localQQAppInterface != null)) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Ayej);
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
        if (this.jdField_a_of_type_Apnf != null)
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
          paramMessage.fProgress += 5.0F;
          this.jdField_a_of_type_Apnf.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8001, this.c);
      }
      else
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8001);
        continue;
        a(ajya.a(2131703407), "");
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
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmy
 * JD-Core Version:    0.7.0.1
 */