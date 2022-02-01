import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel.2;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.smtt.sdk.QbSdk;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class auka
  extends atwq
  implements Handler.Callback
{
  public long a;
  private bebe jdField_a_of_type_Bebe;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public long b;
  private int c = 1000;
  private int d = 60000;
  
  public auka(QQAppInterface paramQQAppInterface, Activity paramActivity, List<atuz> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    a(paramList, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((localQQAppInterface != null) && (paramString2 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
      bdla.b(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 2, "", "", bebf.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType), paramString2);
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = anvx.a(2131702878);
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, paramString2, 0).a();
    l_();
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b = System.currentTimeMillis();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8001);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8002);
    this.jdField_a_of_type_MqqOsMqqHandler.post(new DocsExportFileModel.2(this));
    ((bebg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_EXPORT_HANDLER)).a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public int a()
  {
    return 10;
  }
  
  public Intent a()
  {
    return null;
  }
  
  public atvp a()
  {
    if (this.jdField_a_of_type_Atvp == null) {
      this.jdField_a_of_type_Atvp = new aukc(this);
    }
    return this.jdField_a_of_type_Atvp;
  }
  
  public atvs a()
  {
    return null;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Bebe != null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      this.jdField_a_of_type_Bebe = new aukb(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    } while ((localQQAppInterface == null) || (this.jdField_a_of_type_Bebe == null));
    localQQAppInterface.addObserver(this.jdField_a_of_type_Bebe);
  }
  
  public void a(atxg paramatxg)
  {
    super.a(paramatxg);
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("isSuccess")))
    {
      boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isSuccess");
      paramatxg = this.jdField_a_of_type_AndroidOsBundle.getString("docUrl");
      if (!bool) {
        break label90;
      }
      a(this.jdField_a_of_type_AndroidOsBundle.getString("url"), this.jdField_a_of_type_AndroidOsBundle.getString("fileName"), paramatxg, this.jdField_a_of_type_AndroidOsBundle.getString("cookie"));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.remove("isSuccess");
      return;
      label90:
      a(anvx.a(2131714157), paramatxg);
    }
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    int i;
    do
    {
      FileManagerEntity localFileManagerEntity;
      String str;
      boolean bool;
      do
      {
        return;
        localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
        str = d();
        bool = FileUtil.fileExistsAndNotEmpty(str);
      } while (((localFileManagerEntity == null) && (TextUtils.isEmpty(str))) || (b() == 16) || ((!bool) && (localFileManagerEntity != null) && (localFileManagerEntity.isZipInnerFile)));
      i = paramActionSheetItem.action;
      if (i == 2)
      {
        atti.a(this.jdField_a_of_type_Atuw, localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity).onClick(null);
        bdla.b(null, "dc00898", "", "", "0X800A3B8", "0X800A3B8", 0, 0, "", "", "", "");
        return;
      }
      if (i == 27)
      {
        atti.a(this.jdField_a_of_type_Atuw, str).onClick(null);
        bdla.b(null, "dc00898", "", "", "0X800A3B9", "0X800A3B9", 0, 0, "", "", "", "");
        return;
      }
      if (i == 6)
      {
        atti.b(this.jdField_a_of_type_Atuw, localFileManagerEntity).onClick(null);
        bdla.b(null, "dc00898", "", "", "0X800A3BA", "0X800A3BA", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 132);
    QbSdk.clearDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, d());
    auea.a(this.jdField_a_of_type_AndroidAppActivity, d());
    bdla.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    Object localObject3 = this.jdField_a_of_type_Atuz.a();
    String str = d();
    boolean bool1 = FileUtil.fileExistsAndNotEmpty(str);
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
        localObject1 = auea.a(new FileInfo(str));
        Object localObject4 = aufd.a(2, null);
        localObject3 = localObject1;
        localObject1 = localObject4;
        localArrayList1.add(localObject1);
        if ((localObject3 == null) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunFileId)) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunDirKey))) {
          break label617;
        }
        i = 1;
        if (i == 0)
        {
          if (!bool1) {
            break label622;
          }
          localObject1 = aufd.a(27, null);
          localArrayList1.add(localObject1);
        }
        localObject1 = WXShareHelper.a();
        if ((bool1) && (((WXShareHelper)localObject1).a()) && (((WXShareHelper)localObject1).d())) {
          localArrayList1.add(aufd.a(9, atti.b(this.jdField_a_of_type_AndroidAppActivity, str)));
        }
        if (bool1) {
          localArrayList1.add(aufd.a(64, atti.a(this.jdField_a_of_type_AndroidAppActivity, str)));
        }
        if (auea.c((FileManagerEntity)localObject3)) {
          localArrayList2.add(aufd.a(6, null));
        }
        boolean bool2 = arng.a().d();
        long l = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        localObject4 = arnw.a().c();
        localObject1 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject1 = becr.a;
        }
        if ((bool2) && (localObject3 != null) && (becr.a(((FileManagerEntity)localObject3).getFilePath(), ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
        {
          localObject1 = aufd.a(119, atti.a((FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
          localArrayList2.add(localObject1);
        }
        if (aukf.a((FileManagerEntity)localObject3, bool1))
        {
          localArrayList2.add(aufd.a(122, atti.a(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
          localArrayList2.add(aufd.a(123, atti.b(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
        }
        if (bool1)
        {
          if (((ansr)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a.a(c())) {
            localArrayList2.add(aufd.a(121, atti.b(this.jdField_a_of_type_Atuw, d())));
          }
          if (QbSdk.isInDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, str))
          {
            localArrayList2.add(aufd.a(132, null));
            bdla.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
          }
        }
        return new ArrayList[] { localArrayList1, localArrayList2 };
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      Object localObject2 = aufd.a(2, null);
      continue;
      label617:
      int i = 0;
      continue;
      label622:
      if (d() == 1) {
        localObject2 = aufd.a(27, null);
      }
    }
  }
  
  protected void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((this.jdField_a_of_type_Bebe != null) && (localQQAppInterface != null)) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Bebe);
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8001);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8002);
    }
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
        if (this.jdField_a_of_type_Atxg != null)
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
          paramMessage.fProgress += 5.0F;
          this.jdField_a_of_type_Atxg.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8001, this.c);
      }
      else
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8001);
        continue;
        a(anvx.a(2131702881), "");
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
  
  public void l_()
  {
    super.l_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auka
 * JD-Core Version:    0.7.0.1
 */