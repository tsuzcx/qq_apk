import android.app.Activity;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class arfw
  extends arfh
  implements Handler.Callback
{
  public long a;
  private bacg jdField_a_of_type_Bacg;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public long b;
  private int c = 1000;
  private int d = 60000;
  
  public arfw(Activity paramActivity, List<ardq> paramList, int paramInt)
  {
    super(paramActivity);
    a(paramList, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((localQQAppInterface != null) && (paramString2 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
      azmj.b(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 2, "", "", bach.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType), paramString2);
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = alpo.a(2131703776);
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, paramString2, 0).a();
    f_();
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public int a()
  {
    return 10;
  }
  
  public areg a()
  {
    if (this.jdField_a_of_type_Areg == null) {
      this.jdField_a_of_type_Areg = new arfy(this);
    }
    return this.jdField_a_of_type_Areg;
  }
  
  public arej a()
  {
    return null;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Bacg != null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      this.jdField_a_of_type_Bacg = new arfx(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    } while ((localQQAppInterface == null) || (this.jdField_a_of_type_Bacg == null));
    localQQAppInterface.addObserver(this.jdField_a_of_type_Bacg);
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    FileManagerEntity localFileManagerEntity;
    int i;
    do
    {
      String str;
      boolean bool;
      do
      {
        return;
        localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
        str = d();
        bool = arof.b(str);
      } while (((localFileManagerEntity == null) && (TextUtils.isEmpty(str))) || (b() == 16) || ((!bool) && (localFileManagerEntity != null) && (localFileManagerEntity.isZipInnerFile)));
      i = paramActionSheetItem.action;
      if (i == 2)
      {
        arbl.a(this.jdField_a_of_type_Ardn, localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity);
        azmj.b(null, "dc00898", "", "", "0X800A3B8", "0X800A3B8", 0, 0, "", "", "", "");
        return;
      }
      if (i == 27)
      {
        arbl.a(this.jdField_a_of_type_Ardn, str);
        azmj.b(null, "dc00898", "", "", "0X800A3B9", "0X800A3B9", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 6);
    arbl.b(this.jdField_a_of_type_Ardn, localFileManagerEntity);
    azmj.b(null, "dc00898", "", "", "0X800A3BA", "0X800A3BA", 0, 0, "", "", "", "");
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    Object localObject3 = this.jdField_a_of_type_Ardq.a();
    String str = d();
    boolean bool1 = arof.b(str);
    if ((localObject3 == null) && (TextUtils.isEmpty(str))) {
      return null;
    }
    if (b() == 16) {
      return null;
    }
    if ((!bool1) && (localObject3 != null) && (((FileManagerEntity)localObject3).isZipInnerFile)) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
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
        localObject1 = arni.a(new FileInfo(str));
        Object localObject4 = aroo.a(2, null);
        localObject3 = localObject1;
        localObject1 = localObject4;
        localArrayList1.add(localObject1);
        if ((localObject3 == null) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunFileId)) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunDirKey))) {
          break label520;
        }
        i = 1;
        if (i == 0)
        {
          if (!bool1) {
            break label525;
          }
          localObject1 = aroo.a(27, null);
          localArrayList1.add(localObject1);
        }
        if (bool1) {
          localArrayList1.add(aroo.a(64, arbl.a(this.jdField_a_of_type_AndroidAppActivity, str)));
        }
        if (arni.c((FileManagerEntity)localObject3)) {
          localArrayList2.add(aroo.a(6, null));
        }
        boolean bool2 = aosx.a().d();
        long l = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        localObject4 = aotn.a().c();
        localObject1 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject1 = badt.a;
        }
        if ((bool2) && (localObject3 != null) && (badt.a(((FileManagerEntity)localObject3).strFilePath, ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
        {
          localObject1 = aroo.a(119, arbl.a((FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
          localArrayList2.add(localObject1);
        }
        if (arkn.a((FileManagerEntity)localObject3, bool1))
        {
          localArrayList2.add(aroo.a(122, arbl.a(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
          localArrayList2.add(aroo.a(123, arbl.b(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
        }
        if ((bool1) && (((allz)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8)).a.a(c()))) {
          localArrayList2.add(aroo.a(121, arbl.b(this.jdField_a_of_type_Ardn, d())));
        }
        return new ArrayList[] { localArrayList1, localArrayList2 };
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      Object localObject2 = aroo.a(2, null);
      continue;
      label520:
      int i = 0;
      continue;
      label525:
      if (d() == 1) {
        localObject2 = aroo.a(27, null);
      }
    }
  }
  
  protected void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((this.jdField_a_of_type_Bacg != null) && (localQQAppInterface != null)) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Bacg);
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
  
  public void h()
  {
    super.h();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    if (d() == 1)
    {
      if (f() == 3000) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aqru(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aqtt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid));
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
        if (this.jdField_a_of_type_Argf != null)
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
          paramMessage.fProgress += 5.0F;
          this.jdField_a_of_type_Argf.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8001, this.c);
      }
      else
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8001);
        continue;
        a(alpo.a(2131703779), "");
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
  
  public boolean i()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfw
 * JD-Core Version:    0.7.0.1
 */