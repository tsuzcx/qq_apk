import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel.2;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.smtt.sdk.QbSdk;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class aubq
  extends atoe
  implements Handler.Callback
{
  public long a;
  private bdht jdField_a_of_type_Bdht;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public long b;
  private int c = 1000;
  private int d = 60000;
  
  public aubq(QQAppInterface paramQQAppInterface, Activity paramActivity, List<atmn> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    a(paramList, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((localQQAppInterface != null) && (paramString2 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
      bcst.b(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 2, "", "", bdhu.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType), paramString2);
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = anni.a(2131702185);
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, paramString2, 0).a();
    j_();
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b = System.currentTimeMillis();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8001);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8002);
    this.jdField_a_of_type_MqqOsMqqHandler.post(new DocsExportFileModel.2(this));
    ((bdhv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(142)).a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public int a()
  {
    return 10;
  }
  
  public Intent a()
  {
    return null;
  }
  
  public atnd a()
  {
    if (this.jdField_a_of_type_Atnd == null) {
      this.jdField_a_of_type_Atnd = new aubs(this);
    }
    return this.jdField_a_of_type_Atnd;
  }
  
  public atng a()
  {
    return null;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Bdht != null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      this.jdField_a_of_type_Bdht = new aubr(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    } while ((localQQAppInterface == null) || (this.jdField_a_of_type_Bdht == null));
    localQQAppInterface.addObserver(this.jdField_a_of_type_Bdht);
  }
  
  public void a(atou paramatou)
  {
    super.a(paramatou);
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("isSuccess")))
    {
      boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isSuccess");
      paramatou = this.jdField_a_of_type_AndroidOsBundle.getString("docUrl");
      if (!bool) {
        break label90;
      }
      a(this.jdField_a_of_type_AndroidOsBundle.getString("url"), this.jdField_a_of_type_AndroidOsBundle.getString("fileName"), paramatou, this.jdField_a_of_type_AndroidOsBundle.getString("cookie"));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.remove("isSuccess");
      return;
      label90:
      a(anni.a(2131713469), paramatou);
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
        localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
        str = d();
        bool = atwl.b(str);
      } while (((localFileManagerEntity == null) && (TextUtils.isEmpty(str))) || (b() == 16) || ((!bool) && (localFileManagerEntity != null) && (localFileManagerEntity.isZipInnerFile)));
      i = paramActionSheetItem.action;
      if (i == 2)
      {
        atky.a(this.jdField_a_of_type_Atmk, localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity).onClick(null);
        bcst.b(null, "dc00898", "", "", "0X800A3B8", "0X800A3B8", 0, 0, "", "", "", "");
        return;
      }
      if (i == 27)
      {
        atky.a(this.jdField_a_of_type_Atmk, str).onClick(null);
        bcst.b(null, "dc00898", "", "", "0X800A3B9", "0X800A3B9", 0, 0, "", "", "", "");
        return;
      }
      if (i == 6)
      {
        atky.b(this.jdField_a_of_type_Atmk, localFileManagerEntity).onClick(null);
        bcst.b(null, "dc00898", "", "", "0X800A3BA", "0X800A3BA", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 132);
    QbSdk.clearDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, d());
    atvo.a(this.jdField_a_of_type_AndroidAppActivity, d());
    bcst.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    Object localObject3 = this.jdField_a_of_type_Atmn.a();
    String str = d();
    boolean bool1 = atwl.b(str);
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
        localObject1 = atvo.a(new FileInfo(str));
        Object localObject4 = atwt.a(2, null);
        localObject3 = localObject1;
        localObject1 = localObject4;
        localArrayList1.add(localObject1);
        if ((localObject3 == null) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunFileId)) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunDirKey))) {
          break label616;
        }
        i = 1;
        if (i == 0)
        {
          if (!bool1) {
            break label621;
          }
          localObject1 = atwt.a(27, null);
          localArrayList1.add(localObject1);
        }
        localObject1 = WXShareHelper.a();
        if ((bool1) && (((WXShareHelper)localObject1).a()) && (((WXShareHelper)localObject1).d())) {
          localArrayList1.add(atwt.a(9, atky.b(this.jdField_a_of_type_AndroidAppActivity, str)));
        }
        if (bool1) {
          localArrayList1.add(atwt.a(64, atky.a(this.jdField_a_of_type_AndroidAppActivity, str)));
        }
        if (atvo.c((FileManagerEntity)localObject3)) {
          localArrayList2.add(atwt.a(6, null));
        }
        boolean bool2 = arag.a().d();
        long l = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        localObject4 = araw.a().c();
        localObject1 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject1 = bdjg.a;
        }
        if ((bool2) && (localObject3 != null) && (bdjg.a(((FileManagerEntity)localObject3).getFilePath(), ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
        {
          localObject1 = atwt.a(119, atky.a((FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
          localArrayList2.add(localObject1);
        }
        if (aubv.a((FileManagerEntity)localObject3, bool1))
        {
          localArrayList2.add(atwt.a(122, atky.a(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
          localArrayList2.add(atwt.a(123, atky.b(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
        }
        if (bool1)
        {
          if (((anjx)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8)).a.a(c())) {
            localArrayList2.add(atwt.a(121, atky.b(this.jdField_a_of_type_Atmk, d())));
          }
          if (QbSdk.isInDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, str))
          {
            localArrayList2.add(atwt.a(132, null));
            bcst.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
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
      Object localObject2 = atwt.a(2, null);
      continue;
      label616:
      int i = 0;
      continue;
      label621:
      if (d() == 1) {
        localObject2 = atwt.a(27, null);
      }
    }
  }
  
  protected void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((this.jdField_a_of_type_Bdht != null) && (localQQAppInterface != null)) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Bdht);
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    if (d() == 1)
    {
      if (f() == 3000) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new atzh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new ater(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.fileIdCrc));
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
        if (this.jdField_a_of_type_Atou != null)
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
          paramMessage.fProgress += 5.0F;
          this.jdField_a_of_type_Atou.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8001, this.c);
      }
      else
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8001);
        continue;
        a(anni.a(2131702188), "");
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
  
  public void j_()
  {
    super.j_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubq
 * JD-Core Version:    0.7.0.1
 */