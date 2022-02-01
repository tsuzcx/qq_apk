import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public abstract class atoe
  extends atoo
{
  public atmn a;
  public QQAppInterface a;
  private TeamWorkFileImportInfo a;
  protected String a;
  protected List<atmn> a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  private String g = "";
  
  public atoe(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private atmn a()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      QLog.e("FileBrowserModelBase", 1, "index error, index[" + this.jdField_a_of_type_Int + "], size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      return (atmn)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return (atmn)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    int i = 70;
    int j = j();
    if ((j != 0) && (this.jdField_a_of_type_Atmk != null) && (this.jdField_a_of_type_Atmk.f())) {
      if (j != 1) {
        break label59;
      }
    }
    for (;;)
    {
      paramArrayList.add(atwt.a(i, new aton(this, j)));
      return;
      label59:
      if (j == 2) {
        i = 82;
      }
    }
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    Object localObject2 = araw.a();
    Object localObject1 = arag.a();
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = ((arav)localObject2).c();
      boolean bool = ((araf)localObject1).d();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = bdjg.jdField_a_of_type_JavaLangString;
      }
      long l = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.fileName);
      if ((bool) && (bdjg.a(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject1)) && (paramFileManagerEntity.fileSize <= l))
      {
        paramFileManagerEntity = atwt.a(119, atky.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
        paramArrayList.add(paramFileManagerEntity);
      }
    }
  }
  
  private void o()
  {
    int i = d();
    int j = f();
    Object localObject = this.jdField_a_of_type_Atmn.a();
    if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new auai(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atmn.e(), this.jdField_a_of_type_Atmn.a().WeiYunDirKey));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Atdl == null) {
        this.jdField_a_of_type_Atdl = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      }
      if (this.jdField_a_of_type_Asrx == null) {
        this.jdField_a_of_type_Asrx = new atof(this, j);
      }
      if (this.jdField_a_of_type_Atdl != null)
      {
        this.jdField_a_of_type_Atdl.a(this.jdField_a_of_type_Asrx);
        this.jdField_a_of_type_Atdl.a();
      }
      return;
      if (i == 2)
      {
        if (this.jdField_a_of_type_Atmn.a() == null) {}
        for (localObject = "";; localObject = this.jdField_a_of_type_Atmn.a().jdField_b_of_type_JavaLangString)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new auai(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atmn.e(), (String)localObject));
          break;
        }
      }
      if ((i == 1) || (i == 3))
      {
        if (j == 3000) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new atzh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atmn.c(), this.jdField_a_of_type_Atmn.d()));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new ater(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atmn.c(), this.jdField_a_of_type_Atmn.e()));
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "loadZipFilesForOthers error. can not handle zip file");
      }
    }
  }
  
  public float a()
  {
    if ((this.jdField_a_of_type_Atmn != null) && (this.jdField_a_of_type_Atmn.a() != null)) {
      return this.jdField_a_of_type_Atmn.a().fProgress;
    }
    return 0.0F;
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity);
  }
  
  public atnf a()
  {
    if (this.jdField_a_of_type_Atnf == null) {
      this.jdField_a_of_type_Atnf = new atoi(this);
    }
    return this.jdField_a_of_type_Atnf;
  }
  
  public TeamWorkFileImportInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> a(FileManagerEntity paramFileManagerEntity)
  {
    int j = 0;
    String str = d();
    boolean bool = atwl.b(str);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(atwt.a(2, atky.a(this.jdField_a_of_type_Atmk, paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList.add(atwt.a(26, new atoj(this, paramFileManagerEntity)));
    aqzt localaqzt = aqzu.a();
    int i;
    if ((localaqzt != null) && (paramFileManagerEntity != null) && (localaqzt.a().contains(atwl.a(paramFileManagerEntity.fileName).replace(".", "").toLowerCase())))
    {
      i = 1;
      if (i != 0)
      {
        localArrayList.add(atwt.a(120, atky.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity, true)));
        bdkv.a(a(), "0X800A21C");
      }
      if (blni.a().b(paramFileManagerEntity)) {
        localArrayList.add(atwt.a(118, null));
      }
      i = j;
      if (paramFileManagerEntity != null)
      {
        i = j;
        if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId))
        {
          i = j;
          if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunDirKey)) {
            i = 1;
          }
        }
      }
      if (i == 0)
      {
        if (!bool) {
          break label306;
        }
        localArrayList.add(atwt.a(27, atky.a(this.jdField_a_of_type_Atmk, str)));
      }
    }
    for (;;)
    {
      paramFileManagerEntity = WXShareHelper.a();
      if ((bool) && (paramFileManagerEntity.a()) && (paramFileManagerEntity.d())) {
        localArrayList.add(atwt.a(9, atky.b(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      if (bool) {
        localArrayList.add(atwt.a(64, atky.a(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      return localArrayList;
      i = 0;
      break;
      label306:
      if (d() == 1) {
        localArrayList.add(atwt.a(27, atky.a(this.jdField_a_of_type_Atmk, paramFileManagerEntity)));
      }
    }
  }
  
  public List<atoq> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new atni((atmn)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, atoq paramatoq)
  {
    atmn localatmn = ((atni)paramatoq).a();
    if (localatmn == null) {
      atvf.b(BaseApplicationImpl.getContext().getString(2131692146));
    }
    do
    {
      return;
      if ((atvo.a(localatmn.a())) && (1 == localatmn.c())) {
        atvf.b(BaseApplicationImpl.getContext().getString(2131692146));
      }
    } while (localatmn.f() != null);
    localatmn.a(1);
    paramatoq.a(1);
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Atmn == null) || (this.jdField_a_of_type_Atmn.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "onVideoPlayerError : file entity is null");
      }
      return;
    }
    paramString = this.jdField_a_of_type_Atmn.a();
    paramString.status = 16;
    paramString.mContext = "showed";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString);
  }
  
  public void a(atos paramatos) {}
  
  public void a(atou paramatou)
  {
    this.jdField_a_of_type_Atou = paramatou;
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    int i;
    do
    {
      Object localObject1;
      do
      {
        do
        {
          do
          {
            Object localObject2;
            do
            {
              do
              {
                return;
                localObject1 = this.jdField_a_of_type_Atmn.a();
                localObject2 = d();
              } while ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2)));
              i = paramActionSheetItem.action;
              f(i);
              if (i == 73)
              {
                atky.a(this.jdField_a_of_type_Atmk, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity).onClick(null);
                return;
              }
              if (i != 72) {
                break;
              }
              i = paramActionSheetItem.uinType;
              paramActionSheetItem = paramActionSheetItem.uin;
            } while (TextUtils.isEmpty(paramActionSheetItem));
            atwt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, i);
            return;
            if (i == 39)
            {
              if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_AndroidAppActivity))
              {
                CheckPermission.requestSDCardPermission((AppActivity)this.jdField_a_of_type_AndroidAppActivity, new atom(this));
                return;
              }
              atvo.a(this.jdField_a_of_type_AndroidAppActivity, d());
              return;
            }
            if (i != 52) {
              break;
            }
            localObject1 = d();
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
            if (!bgmg.b((String)localObject1))
            {
              localObject2 = this.jdField_a_of_type_Atmn.a();
              paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
              if (localObject2 != null) {
                paramActionSheetItem = ((FileManagerEntity)localObject2).strLargeThumPath;
              }
            }
          } while (!bgmg.b(paramActionSheetItem));
          OCRPerformFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramActionSheetItem, 1, -1004, null);
          return;
          if (i != 55) {
            break;
          }
          localObject1 = e();
        } while (!bgmg.b((String)localObject1));
        atwt.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 1);
        bcst.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", atmr.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
        return;
        if (i != 56) {
          break;
        }
        localObject1 = e();
      } while (!bgmg.b((String)localObject1));
      atwt.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 2);
      bcst.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", atmr.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
      return;
      if (i == 118)
      {
        atky.c(this.jdField_a_of_type_Atmk, (FileManagerEntity)localObject1).onClick(null);
        return;
      }
    } while (i != 132);
    QbSdk.clearDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, d());
    atvo.a(this.jdField_a_of_type_AndroidAppActivity, d());
    bcst.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, String paramString7, aaqv paramaaqv)
  {
    String str1;
    String str2;
    if (paramBoolean)
    {
      str1 = "https://";
      str2 = str1 + paramString1 + ":" + paramShort + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + bkgj.a(paramString4) + "&";
      if ((!atwt.a()) || (TextUtils.isEmpty(paramString7))) {
        break label359;
      }
    }
    label359:
    for (paramString7 = str1 + paramString7 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + bkgj.a(paramString4) + "&";; paramString7 = str2)
    {
      if (paramFileManagerEntity.getCloudType() == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramString1 = new bfpp(paramString7, "GET", new atoh(this, new ArrayList(), paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramaaqv), 1000, null);
        paramString2 = new Bundle();
        paramString2.putString("version", bgln.c());
        paramString2.putString("Cookie", "FTN5K=" + paramString5);
        if (paramBoolean) {
          paramString2.putString("Referer", "https://" + paramString6);
        }
        paramString3 = new HashMap();
        paramString3.put("BUNDLE", paramString2);
        paramString3.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
        paramString1.a(paramString3);
        return;
        str1 = "http://";
        break;
      }
    }
  }
  
  protected void a(List<atmn> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Atmn = a();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Atmn != null) && (this.jdField_a_of_type_Atmn.a() != null)) {
      this.jdField_a_of_type_Atmn.a().bCannotPlay = true;
    }
  }
  
  protected void a(boolean paramBoolean, atul paramatul, long paramLong, atve paramatve)
  {
    paramatul.a(paramBoolean, this.jdField_a_of_type_AndroidAppActivity, paramatve);
  }
  
  protected boolean a(String paramString)
  {
    return QbSdk.isInDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, paramString);
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    Object localObject1 = this.jdField_a_of_type_Atmn.a();
    Object localObject2 = d();
    boolean bool = atwl.b((String)localObject2);
    if ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2))) {}
    while ((b() == 16) || ((!bool) && (localObject1 != null) && (((FileManagerEntity)localObject1).isZipInnerFile))) {
      return null;
    }
    if ((localObject1 == null) && (bool)) {}
    for (;;)
    {
      try
      {
        localObject2 = atvo.a(new FileInfo((String)localObject2));
        localObject1 = localObject2;
        if (localObject1 == null) {
          break;
        }
        localObject2 = a((FileManagerEntity)localObject1);
        localObject1 = b((FileManagerEntity)localObject1);
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
          localArrayList1.addAll((Collection)localObject2);
        }
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
          localArrayList2.addAll((Collection)localObject1);
        }
        return new ArrayList[] { localArrayList1, localArrayList2 };
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.d();
    }
    return -1;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.d();
    }
    return "";
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> b(FileManagerEntity paramFileManagerEntity)
  {
    String str = d();
    boolean bool = atwl.b(str);
    ArrayList localArrayList = new ArrayList();
    a(paramFileManagerEntity, localArrayList);
    if ((atvo.a(paramFileManagerEntity.fileName) == 0) && (bool)) {
      localArrayList.add(atwt.a(39, null));
    }
    if (atvo.c(paramFileManagerEntity)) {
      localArrayList.add(atwt.a(6, atky.b(this.jdField_a_of_type_Atmk, paramFileManagerEntity)));
    }
    b(paramFileManagerEntity, localArrayList);
    if (aubv.a(paramFileManagerEntity, bool))
    {
      localArrayList.add(atwt.a(122, atky.a(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
      localArrayList.add(atwt.a(123, atky.b(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
    }
    if ((ayfa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1)) && (e() == 0) && ((bgmg.b(paramFileManagerEntity.strLargeThumPath)) || (bgmg.b(str)))) {
      localArrayList.add(atwt.a(52, null));
    }
    if (e() == 0) {
      a(localArrayList);
    }
    if (bool)
    {
      if (k()) {
        localArrayList.add(atwt.a(121, atky.b(this.jdField_a_of_type_Atmk, d())));
      }
      if (a(str))
      {
        localArrayList.add(atwt.a(132, null));
        bcst.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Atmn != null) {
      this.jdField_a_of_type_Atmn.a().status = paramInt;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.a();
    }
    return false;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    String str = d();
    boolean bool = atwl.b(str);
    localArrayList1.add(atwt.a(2, atky.a(this.jdField_a_of_type_Atmk, localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList1.add(atwt.a(26, new atok(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList1.add(atwt.a(27, atky.a(this.jdField_a_of_type_Atmk, localFileManagerEntity)));
    }
    for (;;)
    {
      WXShareHelper localWXShareHelper = WXShareHelper.a();
      if ((bool) && (localWXShareHelper.a()) && (localWXShareHelper.d())) {
        localArrayList1.add(atwt.a(9, atky.b(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      if (bool) {
        localArrayList1.add(atwt.a(64, new atol(this)));
      }
      if (bool) {
        localArrayList2.add(atwt.a(39, null));
      }
      if (atvo.c(this.jdField_a_of_type_Atmn.a())) {
        localArrayList2.add(atwt.a(6, atky.b(this.jdField_a_of_type_Atmk, localFileManagerEntity)));
      }
      if (aubv.a(localFileManagerEntity, bool))
      {
        localArrayList2.add(atwt.a(122, atky.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList2.add(atwt.a(123, atky.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      b(localArrayList2);
      if ((bool) && (a(str)))
      {
        localArrayList2.add(atwt.a(132, null));
        bcst.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
      return new ArrayList[] { localArrayList1, localArrayList2 };
      localArrayList1.add(atwt.a(27, atky.a(this.jdField_a_of_type_Atmk, str)));
    }
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.b();
    }
    return 0L;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.a();
    }
    return "";
  }
  
  public void c(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Atmn = a();
      localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    } while ((localFileManagerEntity == null) || (!localFileManagerEntity.isZipInnerFile) || (!atwl.b(localFileManagerEntity.getFilePath())));
    localFileManagerEntity.status = 1;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Atmn == null;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.c();
    }
    return -1;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.a();
    }
    return 0L;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.g();
    }
    return "";
  }
  
  protected void d()
  {
    Object localObject2 = null;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) {}
    for (atmk localatmk = (atmk)this.jdField_a_of_type_AndroidAppActivity;; localatmk = null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
      if (localFileManagerEntity == null) {
        return;
      }
      Object localObject1 = localObject2;
      switch (localFileManagerEntity.nOpType)
      {
      default: 
        localObject1 = localObject2;
      }
      while (localObject1 != null)
      {
        atvm.a((String)localObject1);
        return;
        if ((localatmk != null) && (localatmk.c()))
        {
          localObject1 = "0X8004BB7";
        }
        else
        {
          localObject1 = "0X8004BCD";
          continue;
          if ((localatmk != null) && (localatmk.c()))
          {
            localObject1 = "0X8004BB8";
          }
          else
          {
            localObject1 = "0X8004BCE";
            continue;
            if ((localatmk != null) && (localatmk.c())) {
              localObject1 = "0X8004BB9";
            } else {
              localObject1 = "0X8004BCF";
            }
          }
        }
      }
    }
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Atmn == null) {
      return;
    }
    if ((this.jdField_a_of_type_Atmk != null) && (this.jdField_a_of_type_Atmk.c())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = bdjg.a(this.jdField_a_of_type_Atmn.a(), bool);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt;
      return;
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Atmn != null) && (this.jdField_a_of_type_Atmn.a() != null)) {
      return this.jdField_a_of_type_Atmn.a().isFromProcessingForward2c2cOrDiscItem();
    }
    return false;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.a();
    }
    return -1;
  }
  
  public String e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    if (localFileManagerEntity == null) {
      return "";
    }
    int i = atvo.a(localFileManagerEntity.fileName);
    if (i == 0)
    {
      if (bgmg.b(d())) {
        return d();
      }
    }
    else if ((i == 2) && (bgmg.b(this.f))) {
      return this.f;
    }
    return super.e();
  }
  
  public void e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    if (localFileManagerEntity != null)
    {
      aswl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    try
    {
      localFileManagerEntity = atvo.a(new FileInfo(d()));
      aswl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public boolean e()
  {
    if ((this.jdField_a_of_type_Atmn != null) && (this.jdField_a_of_type_Atmn.a() != null)) {
      return atvo.a(this.jdField_a_of_type_Atmn.a());
    }
    return false;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.b();
    }
    return -1;
  }
  
  public String f()
  {
    return atwl.a(c());
  }
  
  public void f()
  {
    String str;
    if (this.jdField_a_of_type_Atmn.a().bSend) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    for (;;)
    {
      Object localObject = new SimpleDateFormat("yyyy.MM.dd");
      localObject = " 于" + ((SimpleDateFormat)localObject).format(new Date(this.jdField_a_of_type_Atmn.a().srvTime)) + "上传";
      if (this.jdField_a_of_type_Atov != null) {
        this.jdField_a_of_type_Atov.b(str, (String)localObject);
      }
      if (bgnt.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131691985), 1).b(m());
      return;
      if (this.jdField_a_of_type_Atmn.a().peerType == 3000) {
        str = bglf.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atmn.a().peerUin, this.jdField_a_of_type_Atmn.a().selfUin);
      } else {
        str = this.jdField_a_of_type_Atmn.a().peerNick;
      }
    }
    o();
  }
  
  public boolean f()
  {
    if ((this.jdField_a_of_type_Atmn != null) && (this.jdField_a_of_type_Atmn.a() != null)) {
      return this.jdField_a_of_type_Atmn.a().isZipInnerFile;
    }
    return false;
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.e();
    }
    return -1;
  }
  
  public String g()
  {
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.b();
    }
    return "";
  }
  
  public void g()
  {
    if (!bgnt.d(BaseApplicationImpl.getContext()))
    {
      atvf.a(BaseApplicationImpl.getContext().getString(2131692314));
      return;
    }
    k();
    h();
    if (bdjg.c(d(), c(), c()))
    {
      bdjg.a(a(), this.jdField_a_of_type_AndroidAppActivity, "FileBrowserModelBase", a());
      bdjg.a(a(), null, "0X8009ECE");
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, FilePreviewActivity.class);
    localIntent.putExtra("offline_file_type", 0);
    localIntent.putExtra("offline_file_name", c());
    localIntent.putExtra("offline_file_size", c());
    if (j())
    {
      localIntent.putExtra("offline_file_show_team_work_menu", true);
      localIntent.putExtra("key_team_work_file_import_info", this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772225, 2130772226);
  }
  
  public boolean g()
  {
    if ((this.jdField_a_of_type_Atmn != null) && (this.jdField_a_of_type_Atmn.a() != null)) {
      return this.jdField_a_of_type_Atmn.a().isSend();
    }
    return false;
  }
  
  public int h()
  {
    int j = 2;
    int k = 1;
    int m = g();
    int i;
    if ((d() == 0) && (m != 10)) {
      i = 4;
    }
    do
    {
      return i;
      i = k;
      switch (m)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.w("FileBrowserModelBase<FileAssistant>", 2, "error. a unknow transfer type");
        }
        i = 2;
      }
      do
      {
        return i;
        i = k;
      } while (atwl.b(d()));
      i = j;
    } while (!QLog.isColorLevel());
    QLog.i("FileBrowserModelBase<FileAssistant>", 1, "file is send,but not has localfile,return download status!");
    return 2;
  }
  
  public String h()
  {
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.i();
    }
    return "";
  }
  
  public void h()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    String str;
    if (d() == 2)
    {
      if (this.jdField_a_of_type_Atmn.a() != null) {
        break label88;
      }
      if (this.jdField_a_of_type_Atmn.a() != null) {
        break label72;
      }
      str = "";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new auai(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.WeiYunFileId, str));
      return;
      label72:
      str = this.jdField_a_of_type_Atmn.a().jdField_b_of_type_JavaLangString;
      continue;
      label88:
      str = this.jdField_a_of_type_Atmn.a().WeiYunDirKey;
    }
  }
  
  public boolean h()
  {
    boolean bool = true;
    if ((i() != 2) && (h() == 1)) {
      return false;
    }
    if ((atvo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atmn, true)) && (atvo.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int i()
  {
    int i = 2;
    int j = b();
    String str = d();
    if ((j == 2) || (j == 14)) {
      i = 4;
    }
    do
    {
      return i;
      if (j == 16) {
        return 5;
      }
      if ((j == 0) || (j == 3)) {
        return 6;
      }
    } while (atwl.b(str));
    return 0;
  }
  
  public void i()
  {
    super.i();
    a();
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      int i;
      do
      {
        return false;
        i = i();
        if ((i != 5) && (i != 2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileBrowserModelBase", 2, "can not auto download file : [fileStatus] = " + i);
      return false;
    } while (!bgnt.e(BaseApplicationImpl.getContext()));
    aqvx localaqvx = ((atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(bfpj.a(c()));
    long l = this.jdField_a_of_type_Atmn.b();
    if (((bgnt.h(BaseApplicationImpl.getContext())) && (l <= localaqvx.jdField_a_of_type_Int)) || (l <= localaqvx.c)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Atdl != null)
    {
      this.jdField_a_of_type_Atdl.a();
      this.jdField_a_of_type_Atdl = null;
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_Atmn == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return false;
      localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Boolean = false;
    } while ((a() == null) || (localFileManagerEntity == null) || (!bdjg.d(d(), c(), c())) || (!bgnt.d(BaseApplicationImpl.getContext())) || ((TextUtils.isEmpty(localFileManagerEntity.Uuid)) && (TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath)) && (TextUtils.isEmpty(localFileManagerEntity.getFilePath()))));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = localFileManagerEntity.fileName;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Long = localFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c = localFileManagerEntity.getFilePath();
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Int = localFileManagerEntity.nFileType;
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "file size:" + localFileManagerEntity.fileSize + " isTroopFile:" + TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath) + " isOfflineFile:" + TextUtils.isEmpty(localFileManagerEntity.Uuid) + "isLocalFile: " + TextUtils.isEmpty(localFileManagerEntity.getFilePath()));
    }
    if (this.jdField_a_of_type_Atmk != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Boolean = this.jdField_a_of_type_Atmk.c();
    }
    if (!TextUtils.isEmpty(localFileManagerEntity.peerUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int = localFileManagerEntity.peerType;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = localFileManagerEntity.peerUin;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = String.valueOf(localFileManagerEntity.TroopUin);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Int = localFileManagerEntity.busId;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = localFileManagerEntity.strTroopFilePath;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Long = localFileManagerEntity.uniseq;
      if (localFileManagerEntity.status != 16) {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
      }
    }
    return true;
  }
  
  public void j_()
  {
    super.j_();
    if (this.jdField_a_of_type_Atdl != null)
    {
      this.jdField_a_of_type_Atdl.a();
      this.jdField_a_of_type_Atdl = null;
    }
  }
  
  public int k()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeLevel;
    }
    return 0;
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Atmn != null)
    {
      this.jdField_a_of_type_Atmn.a(true);
      this.jdField_a_of_type_Atmn.b(false);
    }
  }
  
  protected boolean k()
  {
    anjx localanjx = (anjx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    String str = c();
    return localanjx.a.a(str);
  }
  
  public String m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
    return super.m();
  }
  
  public String n()
  {
    if (a() == 2)
    {
      if ((TextUtils.isEmpty(this.g)) && (this.jdField_a_of_type_Atmn != null))
      {
        this.g = (this.jdField_a_of_type_Atmn.a() + "_" + System.currentTimeMillis());
        QLog.i("FileBrowserModelBase", 1, "getContextId: default video file random contextId: " + this.g);
      }
      if (!TextUtils.isEmpty(this.g)) {
        return this.g;
      }
    }
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.a() + "";
    }
    return super.n();
  }
  
  public String o()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeMsg;
    }
    return "";
  }
  
  public String p()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeDetailUrl;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atoe
 * JD-Core Version:    0.7.0.1
 */