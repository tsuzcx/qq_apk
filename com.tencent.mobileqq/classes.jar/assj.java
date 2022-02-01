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
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
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

public abstract class assj
  extends asst
{
  public asqs a;
  public QQAppInterface a;
  private TeamWorkFileImportInfo a;
  protected String a;
  protected List<asqs> a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  private String g = "";
  
  public assj(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private asqs a()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      QLog.e("FileBrowserModelBase", 1, "index error, index[" + this.jdField_a_of_type_Int + "], size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      return (asqs)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return (asqs)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
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
    if ((j != 0) && (this.jdField_a_of_type_Asqp != null) && (this.jdField_a_of_type_Asqp.f())) {
      if (j != 1) {
        break label59;
      }
    }
    for (;;)
    {
      paramArrayList.add(ataw.a(i, new asss(this, j)));
      return;
      label59:
      if (j == 2) {
        i = 82;
      }
    }
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    Object localObject2 = aqkl.a();
    Object localObject1 = aqjv.a();
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = ((aqkk)localObject2).c();
      boolean bool = ((aqju)localObject1).d();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = bcvs.jdField_a_of_type_JavaLangString;
      }
      long l = aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.fileName);
      if ((bool) && (bcvs.a(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject1)) && (paramFileManagerEntity.fileSize <= l))
      {
        paramFileManagerEntity = ataw.a(119, aspc.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
        paramArrayList.add(paramFileManagerEntity);
      }
    }
  }
  
  private void o()
  {
    int i = d();
    int j = f();
    Object localObject = this.jdField_a_of_type_Asqs.a();
    if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new atel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Asqs.e(), this.jdField_a_of_type_Asqs.a().WeiYunDirKey));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ashp == null) {
        this.jdField_a_of_type_Ashp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      }
      if (this.jdField_a_of_type_Aruk == null) {
        this.jdField_a_of_type_Aruk = new assk(this, j);
      }
      if (this.jdField_a_of_type_Ashp != null)
      {
        this.jdField_a_of_type_Ashp.a(this.jdField_a_of_type_Aruk);
        this.jdField_a_of_type_Ashp.a();
      }
      return;
      if (i == 2)
      {
        if (this.jdField_a_of_type_Asqs.a() == null) {}
        for (localObject = "";; localObject = this.jdField_a_of_type_Asqs.a().jdField_b_of_type_JavaLangString)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new atel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Asqs.e(), (String)localObject));
          break;
        }
      }
      if ((i == 1) || (i == 3))
      {
        if (j == 3000) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new atdk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Asqs.c(), this.jdField_a_of_type_Asqs.d()));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new asiv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Asqs.c(), this.jdField_a_of_type_Asqs.e()));
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "loadZipFilesForOthers error. can not handle zip file");
      }
    }
  }
  
  public float a()
  {
    if ((this.jdField_a_of_type_Asqs != null) && (this.jdField_a_of_type_Asqs.a() != null)) {
      return this.jdField_a_of_type_Asqs.a().fProgress;
    }
    return 0.0F;
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asqs.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return ataw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity);
  }
  
  public asrk a()
  {
    if (this.jdField_a_of_type_Asrk == null) {
      this.jdField_a_of_type_Asrk = new assn(this);
    }
    return this.jdField_a_of_type_Asrk;
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
    boolean bool = FileUtil.fileExistsAndNotEmpty(str);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ataw.a(2, aspc.a(this.jdField_a_of_type_Asqp, paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList.add(ataw.a(26, new asso(this, paramFileManagerEntity)));
    aqji localaqji = aqjj.a();
    int i;
    if ((localaqji != null) && (paramFileManagerEntity != null) && (localaqji.a().contains(FileUtil.getExtension(paramFileManagerEntity.fileName).replace(".", "").toLowerCase())))
    {
      i = 1;
      if (i != 0)
      {
        localArrayList.add(ataw.a(120, aspc.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity, true)));
        bcxh.a(a(), "0X800A21C");
      }
      if (bkss.a().b(paramFileManagerEntity)) {
        localArrayList.add(ataw.a(118, null));
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
        localArrayList.add(ataw.a(27, aspc.a(this.jdField_a_of_type_Asqp, str)));
      }
    }
    for (;;)
    {
      paramFileManagerEntity = WXShareHelper.getInstance();
      if ((bool) && (paramFileManagerEntity.isWXinstalled()) && (paramFileManagerEntity.isSupportShareFile())) {
        localArrayList.add(ataw.a(9, aspc.b(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      if (bool) {
        localArrayList.add(ataw.a(64, aspc.a(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      return localArrayList;
      i = 0;
      break;
      label306:
      if (d() == 1) {
        localArrayList.add(ataw.a(27, aspc.a(this.jdField_a_of_type_Asqp, paramFileManagerEntity)));
      }
    }
  }
  
  public List<assv> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new asrn((asqs)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Asqs != null) {
      this.jdField_a_of_type_Asqs.a().status = paramInt;
    }
  }
  
  public void a(int paramInt, assv paramassv)
  {
    asqs localasqs = ((asrn)paramassv).a();
    if (localasqs == null) {
      aszk.b(BaseApplicationImpl.getContext().getString(2131692199));
    }
    do
    {
      return;
      if ((aszt.a(localasqs.a())) && (1 == localasqs.c())) {
        aszk.b(BaseApplicationImpl.getContext().getString(2131692199));
      }
    } while (localasqs.f() != null);
    localasqs.a(1);
    paramassv.a(1);
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Asqs == null) || (this.jdField_a_of_type_Asqs.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "onVideoPlayerError : file entity is null");
      }
      return;
    }
    paramString = this.jdField_a_of_type_Asqs.a();
    paramString.status = 16;
    paramString.mContext = "showed";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramString);
  }
  
  public void a(assx paramassx) {}
  
  public void a(assz paramassz)
  {
    this.jdField_a_of_type_Assz = paramassz;
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
                localObject1 = this.jdField_a_of_type_Asqs.a();
                localObject2 = d();
              } while ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2)));
              i = paramActionSheetItem.action;
              f(i);
              if (i == 73)
              {
                aspc.a(this.jdField_a_of_type_Asqp, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity).onClick(null);
                return;
              }
              if (i != 72) {
                break;
              }
              i = paramActionSheetItem.uinType;
              paramActionSheetItem = paramActionSheetItem.uin;
            } while (TextUtils.isEmpty(paramActionSheetItem));
            ataw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, i);
            return;
            if (i == 39)
            {
              if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_AndroidAppActivity))
              {
                CheckPermission.requestSDCardPermission((AppActivity)this.jdField_a_of_type_AndroidAppActivity, new assr(this));
                return;
              }
              aszt.a(this.jdField_a_of_type_AndroidAppActivity, d());
              return;
            }
            if (i != 52) {
              break;
            }
            localObject1 = d();
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
            if (!FileUtils.fileExistsAndNotEmpty((String)localObject1))
            {
              localObject2 = this.jdField_a_of_type_Asqs.a();
              paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
              if (localObject2 != null) {
                paramActionSheetItem = ((FileManagerEntity)localObject2).strLargeThumPath;
              }
            }
          } while (!FileUtils.fileExistsAndNotEmpty(paramActionSheetItem));
          OCRPerformFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramActionSheetItem, 1, -1004, null);
          return;
          if (i != 55) {
            break;
          }
          localObject1 = e();
        } while (!FileUtils.fileExistsAndNotEmpty((String)localObject1));
        ataw.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 1);
        bcef.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", asqw.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
        return;
        if (i != 56) {
          break;
        }
        localObject1 = e();
      } while (!FileUtils.fileExistsAndNotEmpty((String)localObject1));
      ataw.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 2);
      bcef.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", asqw.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
      return;
      if (i == 118)
      {
        aspc.c(this.jdField_a_of_type_Asqp, (FileManagerEntity)localObject1).onClick(null);
        return;
      }
    } while (i != 132);
    QbSdk.clearDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, d());
    aszt.a(this.jdField_a_of_type_AndroidAppActivity, d());
    bcef.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, String paramString7, zrl paramzrl)
  {
    String str1;
    String str2;
    if (paramBoolean)
    {
      str1 = "https://";
      str2 = str1 + paramString1 + ":" + paramShort + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + bjnd.a(paramString4) + "&";
      if ((!ataw.a()) || (TextUtils.isEmpty(paramString7))) {
        break label359;
      }
    }
    label359:
    for (paramString7 = str1 + paramString7 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + bjnd.a(paramString4) + "&";; paramString7 = str2)
    {
      if (paramFileManagerEntity.getCloudType() == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramString1 = new beze(paramString7, "GET", new assm(this, new ArrayList(), paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramzrl), 1000, null);
        paramString2 = new Bundle();
        paramString2.putString("version", DeviceInfoUtil.getQQVersion());
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
  
  protected void a(List<asqs> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Asqs = a();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Asqs != null) && (this.jdField_a_of_type_Asqs.a() != null)) {
      this.jdField_a_of_type_Asqs.a().bCannotPlay = true;
    }
  }
  
  protected void a(boolean paramBoolean, asyq paramasyq, long paramLong, aszj paramaszj)
  {
    paramasyq.a(paramBoolean, this.jdField_a_of_type_AndroidAppActivity, paramaszj);
  }
  
  protected boolean a(String paramString)
  {
    return QbSdk.isInDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, paramString);
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    Object localObject1 = this.jdField_a_of_type_Asqs.a();
    Object localObject2 = d();
    boolean bool = FileUtil.fileExistsAndNotEmpty((String)localObject2);
    if ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2))) {}
    while ((b() == 16) || ((!bool) && (localObject1 != null) && (((FileManagerEntity)localObject1).isZipInnerFile))) {
      return null;
    }
    if ((localObject1 == null) && (bool)) {}
    for (;;)
    {
      try
      {
        localObject2 = aszt.a(new FileInfo((String)localObject2));
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
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.d();
    }
    return -1;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.d();
    }
    return "";
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> b(FileManagerEntity paramFileManagerEntity)
  {
    String str = d();
    boolean bool = FileUtil.fileExistsAndNotEmpty(str);
    ArrayList localArrayList = new ArrayList();
    a(paramFileManagerEntity, localArrayList);
    if ((aszt.a(paramFileManagerEntity.fileName) == 0) && (bool)) {
      localArrayList.add(ataw.a(39, null));
    }
    if (aszt.c(paramFileManagerEntity)) {
      localArrayList.add(ataw.a(6, aspc.b(this.jdField_a_of_type_Asqp, paramFileManagerEntity)));
    }
    b(paramFileManagerEntity, localArrayList);
    if (atfy.a(paramFileManagerEntity, bool))
    {
      localArrayList.add(ataw.a(122, aspc.a(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
      localArrayList.add(ataw.a(123, aspc.b(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
    }
    if ((axlb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1)) && (e() == 0) && ((FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) || (FileUtils.fileExistsAndNotEmpty(str)))) {
      localArrayList.add(ataw.a(52, null));
    }
    if (e() == 0) {
      a(localArrayList);
    }
    if (bool)
    {
      if (k()) {
        localArrayList.add(ataw.a(121, aspc.b(this.jdField_a_of_type_Asqp, d())));
      }
      if (a(str))
      {
        localArrayList.add(ataw.a(132, null));
        bcef.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
    }
    return localArrayList;
  }
  
  public void b(int paramInt) {}
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.a();
    }
    return false;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asqs.a();
    String str = d();
    boolean bool = FileUtil.fileExistsAndNotEmpty(str);
    localArrayList1.add(ataw.a(2, aspc.a(this.jdField_a_of_type_Asqp, localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList1.add(ataw.a(26, new assp(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList1.add(ataw.a(27, aspc.a(this.jdField_a_of_type_Asqp, localFileManagerEntity)));
    }
    for (;;)
    {
      WXShareHelper localWXShareHelper = WXShareHelper.getInstance();
      if ((bool) && (localWXShareHelper.isWXinstalled()) && (localWXShareHelper.isSupportShareFile())) {
        localArrayList1.add(ataw.a(9, aspc.b(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      if (bool) {
        localArrayList1.add(ataw.a(64, new assq(this)));
      }
      if (bool) {
        localArrayList2.add(ataw.a(39, null));
      }
      if (aszt.c(this.jdField_a_of_type_Asqs.a())) {
        localArrayList2.add(ataw.a(6, aspc.b(this.jdField_a_of_type_Asqp, localFileManagerEntity)));
      }
      if (atfy.a(localFileManagerEntity, bool))
      {
        localArrayList2.add(ataw.a(122, aspc.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList2.add(ataw.a(123, aspc.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      b(localArrayList2);
      if ((bool) && (a(str)))
      {
        localArrayList2.add(ataw.a(132, null));
        bcef.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
      return new ArrayList[] { localArrayList1, localArrayList2 };
      localArrayList1.add(ataw.a(27, aspc.a(this.jdField_a_of_type_Asqp, str)));
    }
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.b();
    }
    return 0L;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.a();
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
      this.jdField_a_of_type_Asqs = a();
      localFileManagerEntity = this.jdField_a_of_type_Asqs.a();
    } while ((localFileManagerEntity == null) || (!localFileManagerEntity.isZipInnerFile) || (!FileUtil.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())));
    localFileManagerEntity.status = 1;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Asqs == null;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.c();
    }
    return -1;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.a();
    }
    return 0L;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.g();
    }
    return "";
  }
  
  protected void d()
  {
    Object localObject2 = null;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) {}
    for (asqp localasqp = (asqp)this.jdField_a_of_type_AndroidAppActivity;; localasqp = null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asqs.a();
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
        aszr.a((String)localObject1);
        return;
        if ((localasqp != null) && (localasqp.c()))
        {
          localObject1 = "0X8004BB7";
        }
        else
        {
          localObject1 = "0X8004BCD";
          continue;
          if ((localasqp != null) && (localasqp.c()))
          {
            localObject1 = "0X8004BB8";
          }
          else
          {
            localObject1 = "0X8004BCE";
            continue;
            if ((localasqp != null) && (localasqp.c())) {
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
    if (this.jdField_a_of_type_Asqs == null) {
      return;
    }
    if ((this.jdField_a_of_type_Asqp != null) && (this.jdField_a_of_type_Asqp.c())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = bcvs.a(this.jdField_a_of_type_Asqs.a(), bool);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt;
      return;
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Asqs != null) && (this.jdField_a_of_type_Asqs.a() != null)) {
      return this.jdField_a_of_type_Asqs.a().isFromProcessingForward2c2cOrDiscItem();
    }
    return false;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.a();
    }
    return -1;
  }
  
  public String e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asqs.a();
    if (localFileManagerEntity == null) {
      return "";
    }
    int i = aszt.a(localFileManagerEntity.fileName);
    if (i == 0)
    {
      if (FileUtils.fileExistsAndNotEmpty(d())) {
        return d();
      }
    }
    else if ((i == 2) && (FileUtils.fileExistsAndNotEmpty(this.f))) {
      return this.f;
    }
    return super.e();
  }
  
  public void e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asqs.a();
    if (localFileManagerEntity != null)
    {
      aryy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    try
    {
      localFileManagerEntity = aszt.a(new FileInfo(d()));
      aryy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public boolean e()
  {
    if ((this.jdField_a_of_type_Asqs != null) && (this.jdField_a_of_type_Asqs.a() != null)) {
      return aszt.a(this.jdField_a_of_type_Asqs.a());
    }
    return false;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.b();
    }
    return -1;
  }
  
  public String f()
  {
    return FileUtil.filesizeToString(c());
  }
  
  public void f()
  {
    String str;
    if (this.jdField_a_of_type_Asqs.a().bSend) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    for (;;)
    {
      Object localObject = new SimpleDateFormat("yyyy.MM.dd");
      localObject = " 于" + ((SimpleDateFormat)localObject).format(new Date(this.jdField_a_of_type_Asqs.a().srvTime)) + "上传";
      if (this.jdField_a_of_type_Asta != null) {
        this.jdField_a_of_type_Asta.b(str, (String)localObject);
      }
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131692035), 1).b(m());
      return;
      if (this.jdField_a_of_type_Asqs.a().peerType == 3000) {
        str = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Asqs.a().peerUin, this.jdField_a_of_type_Asqs.a().selfUin);
      } else {
        str = this.jdField_a_of_type_Asqs.a().peerNick;
      }
    }
    o();
  }
  
  public boolean f()
  {
    if ((this.jdField_a_of_type_Asqs != null) && (this.jdField_a_of_type_Asqs.a() != null)) {
      return this.jdField_a_of_type_Asqs.a().isZipInnerFile;
    }
    return false;
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.e();
    }
    return -1;
  }
  
  public String g()
  {
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.b();
    }
    return "";
  }
  
  public void g()
  {
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      aszk.a(BaseApplicationImpl.getContext().getString(2131692367));
      return;
    }
    k();
    h();
    if (bcvs.c(d(), c(), c()))
    {
      bcvs.a(a(), this.jdField_a_of_type_AndroidAppActivity, "FileBrowserModelBase", a());
      bcvs.a(a(), null, "0X8009ECE");
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
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772223, 2130772224);
  }
  
  public boolean g()
  {
    if ((this.jdField_a_of_type_Asqs != null) && (this.jdField_a_of_type_Asqs.a() != null)) {
      return this.jdField_a_of_type_Asqs.a().isSend();
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
      } while (FileUtil.fileExistsAndNotEmpty(d()));
      i = j;
    } while (!QLog.isColorLevel());
    QLog.i("FileBrowserModelBase<FileAssistant>", 1, "file is send,but not has localfile,return download status!");
    return 2;
  }
  
  public String h()
  {
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.i();
    }
    return "";
  }
  
  public void h()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asqs.a();
    String str;
    if (d() == 2)
    {
      if (this.jdField_a_of_type_Asqs.a() != null) {
        break label88;
      }
      if (this.jdField_a_of_type_Asqs.a() != null) {
        break label72;
      }
      str = "";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new atel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.WeiYunFileId, str));
      return;
      label72:
      str = this.jdField_a_of_type_Asqs.a().jdField_b_of_type_JavaLangString;
      continue;
      label88:
      str = this.jdField_a_of_type_Asqs.a().WeiYunDirKey;
    }
  }
  
  public boolean h()
  {
    boolean bool = true;
    if ((i() != 2) && (h() == 1)) {
      return false;
    }
    if ((aszt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Asqs, true)) && (aszt.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))) {}
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
    } while (FileUtil.fileExistsAndNotEmpty(str));
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
    } while (!NetworkUtil.isNetSupportHw(BaseApplicationImpl.getContext()));
    aqfi localaqfi = ((aser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(beyy.a(c()));
    long l = this.jdField_a_of_type_Asqs.b();
    if (((NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())) && (l <= localaqfi.jdField_a_of_type_Int)) || (l <= localaqfi.c)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Ashp != null)
    {
      this.jdField_a_of_type_Ashp.a();
      this.jdField_a_of_type_Ashp = null;
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_Asqs == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return false;
      localFileManagerEntity = this.jdField_a_of_type_Asqs.a();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Boolean = false;
    } while ((a() == null) || (localFileManagerEntity == null) || (!bcvs.d(d(), c(), c())) || (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) || ((TextUtils.isEmpty(localFileManagerEntity.Uuid)) && (TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath)) && (TextUtils.isEmpty(localFileManagerEntity.getFilePath()))));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = localFileManagerEntity.fileName;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Long = localFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c = localFileManagerEntity.getFilePath();
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Int = localFileManagerEntity.nFileType;
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "file size:" + localFileManagerEntity.fileSize + " isTroopFile:" + TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath) + " isOfflineFile:" + TextUtils.isEmpty(localFileManagerEntity.Uuid) + "isLocalFile: " + TextUtils.isEmpty(localFileManagerEntity.getFilePath()));
    }
    if (this.jdField_a_of_type_Asqp != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Boolean = this.jdField_a_of_type_Asqp.c();
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
    if (this.jdField_a_of_type_Ashp != null)
    {
      this.jdField_a_of_type_Ashp.a();
      this.jdField_a_of_type_Ashp = null;
    }
  }
  
  public int k()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asqs.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeLevel;
    }
    return 0;
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Asqs != null)
    {
      this.jdField_a_of_type_Asqs.a(true);
      this.jdField_a_of_type_Asqs.b(false);
    }
  }
  
  protected boolean k()
  {
    amqd localamqd = (amqd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(8);
    String str = c();
    return localamqd.a.a(str);
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
      if ((TextUtils.isEmpty(this.g)) && (this.jdField_a_of_type_Asqs != null))
      {
        this.g = (this.jdField_a_of_type_Asqs.a() + "_" + System.currentTimeMillis());
        QLog.i("FileBrowserModelBase", 1, "getContextId: default video file random contextId: " + this.g);
      }
      if (!TextUtils.isEmpty(this.g)) {
        return this.g;
      }
    }
    if (this.jdField_a_of_type_Asqs != null) {
      return this.jdField_a_of_type_Asqs.a() + "";
    }
    return super.n();
  }
  
  public String o()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asqs.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeMsg;
    }
    return "";
  }
  
  public String p()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asqs.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeDetailUrl;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assj
 * JD-Core Version:    0.7.0.1
 */