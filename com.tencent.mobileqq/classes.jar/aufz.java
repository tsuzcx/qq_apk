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

public abstract class aufz
  extends augj
{
  public auei a;
  public QQAppInterface a;
  private TeamWorkFileImportInfo a;
  protected String a;
  protected List<auei> a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  private String g = "";
  
  public aufz(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private auei a()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      QLog.e("FileBrowserModelBase", 1, "index error, index[" + this.jdField_a_of_type_Int + "], size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      return (auei)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return (auei)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
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
    if ((j != 0) && (this.jdField_a_of_type_Auef != null) && (this.jdField_a_of_type_Auef.f())) {
      if (j != 1) {
        break label59;
      }
    }
    for (;;)
    {
      paramArrayList.add(auoo.a(i, new augi(this, j)));
      return;
      label59:
      if (j == 2) {
        i = 82;
      }
    }
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    Object localObject2 = arqn.a();
    Object localObject1 = arpx.a();
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = ((arqm)localObject2).c();
      boolean bool = ((arpw)localObject1).d();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = becb.jdField_a_of_type_JavaLangString;
      }
      long l = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.fileName);
      if ((bool) && (becb.a(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject1)) && (paramFileManagerEntity.fileSize <= l))
      {
        paramFileManagerEntity = auoo.a(119, aucs.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
        paramArrayList.add(paramFileManagerEntity);
      }
    }
  }
  
  private void o()
  {
    int i = d();
    int j = f();
    Object localObject = this.jdField_a_of_type_Auei.a();
    if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new ausd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auei.e(), this.jdField_a_of_type_Auei.a().WeiYunDirKey));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Atvf == null) {
        this.jdField_a_of_type_Atvf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      }
      if (this.jdField_a_of_type_Atib == null) {
        this.jdField_a_of_type_Atib = new auga(this, j);
      }
      if (this.jdField_a_of_type_Atvf != null)
      {
        this.jdField_a_of_type_Atvf.a(this.jdField_a_of_type_Atib);
        this.jdField_a_of_type_Atvf.a();
      }
      return;
      if (i == 2)
      {
        if (this.jdField_a_of_type_Auei.a() == null) {}
        for (localObject = "";; localObject = this.jdField_a_of_type_Auei.a().jdField_b_of_type_JavaLangString)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new ausd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auei.e(), (String)localObject));
          break;
        }
      }
      if ((i == 1) || (i == 3))
      {
        if (j == 3000) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aurc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auei.c(), this.jdField_a_of_type_Auei.d()));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new atwl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auei.c(), this.jdField_a_of_type_Auei.e()));
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "loadZipFilesForOthers error. can not handle zip file");
      }
    }
  }
  
  public float a()
  {
    if ((this.jdField_a_of_type_Auei != null) && (this.jdField_a_of_type_Auei.a() != null)) {
      return this.jdField_a_of_type_Auei.a().fProgress;
    }
    return 0.0F;
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity);
  }
  
  public aufa a()
  {
    if (this.jdField_a_of_type_Aufa == null) {
      this.jdField_a_of_type_Aufa = new augd(this);
    }
    return this.jdField_a_of_type_Aufa;
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
    boolean bool = auog.b(str);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(auoo.a(2, aucs.a(this.jdField_a_of_type_Auef, paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList.add(auoo.a(26, new auge(this, paramFileManagerEntity)));
    arpk localarpk = arpl.a();
    int i;
    if ((localarpk != null) && (paramFileManagerEntity != null) && (localarpk.a().contains(auog.a(paramFileManagerEntity.fileName).replace(".", "").toLowerCase())))
    {
      i = 1;
      if (i != 0)
      {
        localArrayList.add(auoo.a(120, aucs.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity, true)));
        bedq.a(a(), "0X800A21C");
      }
      if (bmol.a().b(paramFileManagerEntity)) {
        localArrayList.add(auoo.a(118, null));
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
        localArrayList.add(auoo.a(27, aucs.a(this.jdField_a_of_type_Auef, str)));
      }
    }
    for (;;)
    {
      paramFileManagerEntity = WXShareHelper.a();
      if ((bool) && (paramFileManagerEntity.a()) && (paramFileManagerEntity.d())) {
        localArrayList.add(auoo.a(9, aucs.b(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      if (bool) {
        localArrayList.add(auoo.a(64, aucs.a(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      return localArrayList;
      i = 0;
      break;
      label306:
      if (d() == 1) {
        localArrayList.add(auoo.a(27, aucs.a(this.jdField_a_of_type_Auef, paramFileManagerEntity)));
      }
    }
  }
  
  public List<augl> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new aufd((auei)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Auei != null) {
      this.jdField_a_of_type_Auei.a().status = paramInt;
    }
  }
  
  public void a(int paramInt, augl paramaugl)
  {
    auei localauei = ((aufd)paramaugl).a();
    if (localauei == null) {
      auna.b(BaseApplicationImpl.getContext().getString(2131692151));
    }
    do
    {
      return;
      if ((aunj.a(localauei.a())) && (1 == localauei.c())) {
        auna.b(BaseApplicationImpl.getContext().getString(2131692151));
      }
    } while (localauei.f() != null);
    localauei.a(1);
    paramaugl.a(1);
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Auei == null) || (this.jdField_a_of_type_Auei.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "onVideoPlayerError : file entity is null");
      }
      return;
    }
    paramString = this.jdField_a_of_type_Auei.a();
    paramString.status = 16;
    paramString.mContext = "showed";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString);
  }
  
  public void a(augn paramaugn) {}
  
  public void a(augp paramaugp)
  {
    this.jdField_a_of_type_Augp = paramaugp;
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
                localObject1 = this.jdField_a_of_type_Auei.a();
                localObject2 = d();
              } while ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2)));
              i = paramActionSheetItem.action;
              f(i);
              if (i == 73)
              {
                aucs.a(this.jdField_a_of_type_Auef, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity).onClick(null);
                return;
              }
              if (i != 72) {
                break;
              }
              i = paramActionSheetItem.uinType;
              paramActionSheetItem = paramActionSheetItem.uin;
            } while (TextUtils.isEmpty(paramActionSheetItem));
            auoo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, i);
            return;
            if (i == 39)
            {
              if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_AndroidAppActivity))
              {
                CheckPermission.requestSDCardPermission((AppActivity)this.jdField_a_of_type_AndroidAppActivity, new augh(this));
                return;
              }
              aunj.a(this.jdField_a_of_type_AndroidAppActivity, d());
              return;
            }
            if (i != 52) {
              break;
            }
            localObject1 = d();
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
            if (!bhmi.b((String)localObject1))
            {
              localObject2 = this.jdField_a_of_type_Auei.a();
              paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
              if (localObject2 != null) {
                paramActionSheetItem = ((FileManagerEntity)localObject2).strLargeThumPath;
              }
            }
          } while (!bhmi.b(paramActionSheetItem));
          OCRPerformFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramActionSheetItem, 1, -1004, null);
          return;
          if (i != 55) {
            break;
          }
          localObject1 = e();
        } while (!bhmi.b((String)localObject1));
        auoo.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 1);
        bdll.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", auem.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
        return;
        if (i != 56) {
          break;
        }
        localObject1 = e();
      } while (!bhmi.b((String)localObject1));
      auoo.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 2);
      bdll.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", auem.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
      return;
      if (i == 118)
      {
        aucs.c(this.jdField_a_of_type_Auef, (FileManagerEntity)localObject1).onClick(null);
        return;
      }
    } while (i != 132);
    QbSdk.clearDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, d());
    aunj.a(this.jdField_a_of_type_AndroidAppActivity, d());
    bdll.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, String paramString7, aauy paramaauy)
  {
    String str1;
    String str2;
    if (paramBoolean)
    {
      str1 = "https://";
      str2 = str1 + paramString1 + ":" + paramShort + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + blhn.a(paramString4) + "&";
      if ((!auoo.a()) || (TextUtils.isEmpty(paramString7))) {
        break label359;
      }
    }
    label359:
    for (paramString7 = str1 + paramString7 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + blhn.a(paramString4) + "&";; paramString7 = str2)
    {
      if (paramFileManagerEntity.getCloudType() == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramString1 = new bgpq(paramString7, "GET", new augc(this, new ArrayList(), paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramaauy), 1000, null);
        paramString2 = new Bundle();
        paramString2.putString("version", bhlo.c());
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
  
  protected void a(List<auei> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Auei = a();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Auei != null) && (this.jdField_a_of_type_Auei.a() != null)) {
      this.jdField_a_of_type_Auei.a().bCannotPlay = true;
    }
  }
  
  protected void a(boolean paramBoolean, aumg paramaumg, long paramLong, aumz paramaumz)
  {
    paramaumg.a(paramBoolean, this.jdField_a_of_type_AndroidAppActivity, paramaumz);
  }
  
  protected boolean a(String paramString)
  {
    return QbSdk.isInDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, paramString);
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    Object localObject1 = this.jdField_a_of_type_Auei.a();
    Object localObject2 = d();
    boolean bool = auog.b((String)localObject2);
    if ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2))) {}
    while ((b() == 16) || ((!bool) && (localObject1 != null) && (((FileManagerEntity)localObject1).isZipInnerFile))) {
      return null;
    }
    if ((localObject1 == null) && (bool)) {}
    for (;;)
    {
      try
      {
        localObject2 = aunj.a(new FileInfo((String)localObject2));
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
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.d();
    }
    return -1;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.d();
    }
    return "";
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> b(FileManagerEntity paramFileManagerEntity)
  {
    String str = d();
    boolean bool = auog.b(str);
    ArrayList localArrayList = new ArrayList();
    a(paramFileManagerEntity, localArrayList);
    if ((aunj.a(paramFileManagerEntity.fileName) == 0) && (bool)) {
      localArrayList.add(auoo.a(39, null));
    }
    if (aunj.c(paramFileManagerEntity)) {
      localArrayList.add(auoo.a(6, aucs.b(this.jdField_a_of_type_Auef, paramFileManagerEntity)));
    }
    b(paramFileManagerEntity, localArrayList);
    if (autq.a(paramFileManagerEntity, bool))
    {
      localArrayList.add(auoo.a(122, aucs.a(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
      localArrayList.add(auoo.a(123, aucs.b(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
    }
    if ((ayxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1)) && (e() == 0) && ((bhmi.b(paramFileManagerEntity.strLargeThumPath)) || (bhmi.b(str)))) {
      localArrayList.add(auoo.a(52, null));
    }
    if (e() == 0) {
      a(localArrayList);
    }
    if (bool)
    {
      if (k()) {
        localArrayList.add(auoo.a(121, aucs.b(this.jdField_a_of_type_Auef, d())));
      }
      if (a(str))
      {
        localArrayList.add(auoo.a(132, null));
        bdll.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
    }
    return localArrayList;
  }
  
  public void b(int paramInt) {}
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.a();
    }
    return false;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    String str = d();
    boolean bool = auog.b(str);
    localArrayList1.add(auoo.a(2, aucs.a(this.jdField_a_of_type_Auef, localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList1.add(auoo.a(26, new augf(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList1.add(auoo.a(27, aucs.a(this.jdField_a_of_type_Auef, localFileManagerEntity)));
    }
    for (;;)
    {
      WXShareHelper localWXShareHelper = WXShareHelper.a();
      if ((bool) && (localWXShareHelper.a()) && (localWXShareHelper.d())) {
        localArrayList1.add(auoo.a(9, aucs.b(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      if (bool) {
        localArrayList1.add(auoo.a(64, new augg(this)));
      }
      if (bool) {
        localArrayList2.add(auoo.a(39, null));
      }
      if (aunj.c(this.jdField_a_of_type_Auei.a())) {
        localArrayList2.add(auoo.a(6, aucs.b(this.jdField_a_of_type_Auef, localFileManagerEntity)));
      }
      if (autq.a(localFileManagerEntity, bool))
      {
        localArrayList2.add(auoo.a(122, aucs.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList2.add(auoo.a(123, aucs.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      b(localArrayList2);
      if ((bool) && (a(str)))
      {
        localArrayList2.add(auoo.a(132, null));
        bdll.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
      return new ArrayList[] { localArrayList1, localArrayList2 };
      localArrayList1.add(auoo.a(27, aucs.a(this.jdField_a_of_type_Auef, str)));
    }
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.b();
    }
    return 0L;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.a();
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
      this.jdField_a_of_type_Auei = a();
      localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    } while ((localFileManagerEntity == null) || (!localFileManagerEntity.isZipInnerFile) || (!auog.b(localFileManagerEntity.getFilePath())));
    localFileManagerEntity.status = 1;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Auei == null;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.c();
    }
    return -1;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.a();
    }
    return 0L;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.g();
    }
    return "";
  }
  
  protected void d()
  {
    Object localObject2 = null;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) {}
    for (auef localauef = (auef)this.jdField_a_of_type_AndroidAppActivity;; localauef = null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
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
        aunh.a((String)localObject1);
        return;
        if ((localauef != null) && (localauef.c()))
        {
          localObject1 = "0X8004BB7";
        }
        else
        {
          localObject1 = "0X8004BCD";
          continue;
          if ((localauef != null) && (localauef.c()))
          {
            localObject1 = "0X8004BB8";
          }
          else
          {
            localObject1 = "0X8004BCE";
            continue;
            if ((localauef != null) && (localauef.c())) {
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
    if (this.jdField_a_of_type_Auei == null) {
      return;
    }
    if ((this.jdField_a_of_type_Auef != null) && (this.jdField_a_of_type_Auef.c())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = becb.a(this.jdField_a_of_type_Auei.a(), bool);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt;
      return;
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Auei != null) && (this.jdField_a_of_type_Auei.a() != null)) {
      return this.jdField_a_of_type_Auei.a().isFromProcessingForward2c2cOrDiscItem();
    }
    return false;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.a();
    }
    return -1;
  }
  
  public String e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    if (localFileManagerEntity == null) {
      return "";
    }
    int i = aunj.a(localFileManagerEntity.fileName);
    if (i == 0)
    {
      if (bhmi.b(d())) {
        return d();
      }
    }
    else if ((i == 2) && (bhmi.b(this.f))) {
      return this.f;
    }
    return super.e();
  }
  
  public void e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    if (localFileManagerEntity != null)
    {
      atmp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    try
    {
      localFileManagerEntity = aunj.a(new FileInfo(d()));
      atmp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public boolean e()
  {
    if ((this.jdField_a_of_type_Auei != null) && (this.jdField_a_of_type_Auei.a() != null)) {
      return aunj.a(this.jdField_a_of_type_Auei.a());
    }
    return false;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.b();
    }
    return -1;
  }
  
  public String f()
  {
    return auog.a(c());
  }
  
  public void f()
  {
    String str;
    if (this.jdField_a_of_type_Auei.a().bSend) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    for (;;)
    {
      Object localObject = new SimpleDateFormat("yyyy.MM.dd");
      localObject = " 于" + ((SimpleDateFormat)localObject).format(new Date(this.jdField_a_of_type_Auei.a().srvTime)) + "上传";
      if (this.jdField_a_of_type_Augq != null) {
        this.jdField_a_of_type_Augq.b(str, (String)localObject);
      }
      if (bhnv.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131691989), 1).b(m());
      return;
      if (this.jdField_a_of_type_Auei.a().peerType == 3000) {
        str = bhlg.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auei.a().peerUin, this.jdField_a_of_type_Auei.a().selfUin);
      } else {
        str = this.jdField_a_of_type_Auei.a().peerNick;
      }
    }
    o();
  }
  
  public boolean f()
  {
    if ((this.jdField_a_of_type_Auei != null) && (this.jdField_a_of_type_Auei.a() != null)) {
      return this.jdField_a_of_type_Auei.a().isZipInnerFile;
    }
    return false;
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.e();
    }
    return -1;
  }
  
  public String g()
  {
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.b();
    }
    return "";
  }
  
  public void g()
  {
    if (!bhnv.d(BaseApplicationImpl.getContext()))
    {
      auna.a(BaseApplicationImpl.getContext().getString(2131692319));
      return;
    }
    k();
    h();
    if (becb.c(d(), c(), c()))
    {
      becb.a(a(), this.jdField_a_of_type_AndroidAppActivity, "FileBrowserModelBase", a());
      becb.a(a(), null, "0X8009ECE");
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
    if ((this.jdField_a_of_type_Auei != null) && (this.jdField_a_of_type_Auei.a() != null)) {
      return this.jdField_a_of_type_Auei.a().isSend();
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
      } while (auog.b(d()));
      i = j;
    } while (!QLog.isColorLevel());
    QLog.i("FileBrowserModelBase<FileAssistant>", 1, "file is send,but not has localfile,return download status!");
    return 2;
  }
  
  public String h()
  {
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.i();
    }
    return "";
  }
  
  public void h()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    String str;
    if (d() == 2)
    {
      if (this.jdField_a_of_type_Auei.a() != null) {
        break label88;
      }
      if (this.jdField_a_of_type_Auei.a() != null) {
        break label72;
      }
      str = "";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new ausd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.WeiYunFileId, str));
      return;
      label72:
      str = this.jdField_a_of_type_Auei.a().jdField_b_of_type_JavaLangString;
      continue;
      label88:
      str = this.jdField_a_of_type_Auei.a().WeiYunDirKey;
    }
  }
  
  public boolean h()
  {
    boolean bool = true;
    if ((i() != 2) && (h() == 1)) {
      return false;
    }
    if ((aunj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auei, true)) && (aunj.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))) {}
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
    } while (auog.b(str));
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
    } while (!bhnv.e(BaseApplicationImpl.getContext()));
    arll localarll = ((atsh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(bgpk.a(c()));
    long l = this.jdField_a_of_type_Auei.b();
    if (((bhnv.h(BaseApplicationImpl.getContext())) && (l <= localarll.jdField_a_of_type_Int)) || (l <= localarll.c)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Atvf != null)
    {
      this.jdField_a_of_type_Atvf.a();
      this.jdField_a_of_type_Atvf = null;
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_Auei == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return false;
      localFileManagerEntity = this.jdField_a_of_type_Auei.a();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Boolean = false;
    } while ((a() == null) || (localFileManagerEntity == null) || (!becb.d(d(), c(), c())) || (!bhnv.d(BaseApplicationImpl.getContext())) || ((TextUtils.isEmpty(localFileManagerEntity.Uuid)) && (TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath)) && (TextUtils.isEmpty(localFileManagerEntity.getFilePath()))));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = localFileManagerEntity.fileName;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Long = localFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c = localFileManagerEntity.getFilePath();
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Int = localFileManagerEntity.nFileType;
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "file size:" + localFileManagerEntity.fileSize + " isTroopFile:" + TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath) + " isOfflineFile:" + TextUtils.isEmpty(localFileManagerEntity.Uuid) + "isLocalFile: " + TextUtils.isEmpty(localFileManagerEntity.getFilePath()));
    }
    if (this.jdField_a_of_type_Auef != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Boolean = this.jdField_a_of_type_Auef.c();
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
    if (this.jdField_a_of_type_Atvf != null)
    {
      this.jdField_a_of_type_Atvf.a();
      this.jdField_a_of_type_Atvf = null;
    }
  }
  
  public int k()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeLevel;
    }
    return 0;
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Auei != null)
    {
      this.jdField_a_of_type_Auei.a(true);
      this.jdField_a_of_type_Auei.b(false);
    }
  }
  
  protected boolean k()
  {
    anvu localanvu = (anvu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    String str = c();
    return localanvu.a.a(str);
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
      if ((TextUtils.isEmpty(this.g)) && (this.jdField_a_of_type_Auei != null))
      {
        this.g = (this.jdField_a_of_type_Auei.a() + "_" + System.currentTimeMillis());
        QLog.i("FileBrowserModelBase", 1, "getContextId: default video file random contextId: " + this.g);
      }
      if (!TextUtils.isEmpty(this.g)) {
        return this.g;
      }
    }
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.a() + "";
    }
    return super.n();
  }
  
  public String o()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeMsg;
    }
    return "";
  }
  
  public String p()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeDetailUrl;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aufz
 * JD-Core Version:    0.7.0.1
 */