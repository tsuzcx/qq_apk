import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public abstract class apme
  extends apmx
{
  public apkp a;
  public QQAppInterface a;
  private TeamWorkFileImportInfo a;
  protected String a;
  protected List<apkp> a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  
  public apme(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private apkp a()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      QLog.e("FileBrowserModelBase", 1, "index error, index[" + this.jdField_a_of_type_Int + "], size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      return (apkp)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return (apkp)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void m()
  {
    int i = d();
    int j = f();
    Object localObject = this.jdField_a_of_type_Apkp.a();
    if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new apdy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkp.e(), this.jdField_a_of_type_Apkp.a().WeiYunDirKey));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aozs == null) {
        this.jdField_a_of_type_Aozs = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      }
      if (this.jdField_a_of_type_Aool == null) {
        this.jdField_a_of_type_Aool = new apmf(this, j);
      }
      if (this.jdField_a_of_type_Aozs != null)
      {
        this.jdField_a_of_type_Aozs.a(this.jdField_a_of_type_Aool);
        this.jdField_a_of_type_Aozs.a();
      }
      return;
      if (i == 2)
      {
        if (this.jdField_a_of_type_Apkp.a() == null) {}
        for (localObject = "";; localObject = this.jdField_a_of_type_Apkp.a().jdField_b_of_type_JavaLangString)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new apdy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkp.e(), (String)localObject));
          break;
        }
      }
      if ((i == 1) || (i == 3))
      {
        if (j == 3000) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aoys(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkp.c(), this.jdField_a_of_type_Apkp.d()));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new apar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkp.c()));
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "loadZipFilesForOthers error. can not handle zip file");
      }
    }
  }
  
  public float a()
  {
    if ((this.jdField_a_of_type_Apkp != null) && (this.jdField_a_of_type_Apkp.a() != null)) {
      return this.jdField_a_of_type_Apkp.a().fProgress;
    }
    return 0.0F;
  }
  
  public aplf a()
  {
    if (this.jdField_a_of_type_Aplf == null) {
      this.jdField_a_of_type_Aplf = new apmi(this);
    }
    return this.jdField_a_of_type_Aplf;
  }
  
  public TeamWorkFileImportInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.d();
    }
    return "";
  }
  
  public ArrayList<bbje> a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    String str = c();
    boolean bool = apvb.b(str);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692505), apik.a(this.jdField_a_of_type_Apkm, localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692511), new apml(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692512), apik.a(this.jdField_a_of_type_Apkm, localFileManagerEntity)));
    }
    for (;;)
    {
      if (apue.c(this.jdField_a_of_type_Apkp.a())) {
        localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692504), apik.b(this.jdField_a_of_type_Apkm, localFileManagerEntity)));
      }
      if (aprh.a(localFileManagerEntity, bool))
      {
        localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692547), apik.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692548), apik.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      if (bool)
      {
        localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692510), new apmm(this)));
        localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692507), new apmo(this)));
      }
      return localArrayList;
      localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692512), apik.a(this.jdField_a_of_type_Apkm, str)));
    }
  }
  
  public List<apmy> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new apli((apkp)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, apmy paramapmy)
  {
    apkp localapkp = ((apli)paramapmy).a();
    if (localapkp == null) {
      aptv.b(BaseApplicationImpl.getContext().getString(2131692482));
    }
    do
    {
      return;
      if ((apue.a(localapkp.a())) && (1 == localapkp.c())) {
        aptv.b(BaseApplicationImpl.getContext().getString(2131692482));
      }
    } while (localapkp.f() != null);
    localapkp.a(1);
    paramapmy.a(1);
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Apkp == null) || (this.jdField_a_of_type_Apkp.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "onVideoPlayerError : file entity is null");
      }
      return;
    }
    paramString = this.jdField_a_of_type_Apkp.a();
    paramString.status = 16;
    paramString.mContext = "showed";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString);
  }
  
  public void a(apmz paramapmz) {}
  
  public void a(apnb paramapnb)
  {
    this.jdField_a_of_type_Apnb = paramapnb;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, String paramString7, xba paramxba)
  {
    String str = "http://" + paramString1 + ":" + paramString2 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + bfng.a(paramString4) + "&";
    if (apvk.a()) {}
    for (paramString7 = "http://" + paramString7 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + bfng.a(paramString4) + "&";; paramString7 = str)
    {
      if (paramFileManagerEntity.getCloudType() == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramString1 = new bahp(paramString7, "GET", new apmh(this, new ArrayList(), paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramxba), 1000, null);
        paramString2 = new Bundle();
        paramString2.putString("version", bbct.c());
        paramString2.putString("Cookie", "FTN5K=" + paramString5);
        paramString3 = new HashMap();
        paramString3.put("BUNDLE", paramString2);
        paramString3.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
        paramString1.a(paramString3);
        return;
      }
    }
  }
  
  protected void a(List<apkp> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Apkp = a();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Apkp != null) && (this.jdField_a_of_type_Apkp.a() != null)) {
      this.jdField_a_of_type_Apkp.a().bCannotPlay = true;
    }
  }
  
  protected void a(boolean paramBoolean, apsz paramapsz, long paramLong, aptu paramaptu)
  {
    paramapsz.a(paramBoolean, this.jdField_a_of_type_AndroidAppActivity, paramaptu);
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
      int j;
      Object localObject2;
      try
      {
        localObject1 = apue.a(new FileInfo(str));
        localObject4 = apvk.a(2130839638, this.jdField_a_of_type_AndroidAppActivity.getString(2131692506), apik.a(this.jdField_a_of_type_Apkm, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity));
        localObject3 = localObject1;
        localArrayList1.add(localObject4);
        localArrayList1.add(apvk.a(2130843485, this.jdField_a_of_type_AndroidAppActivity.getString(2131692511), new apmj(this, (FileManagerEntity)localObject3)));
        localObject1 = anax.a();
        if ((localObject1 == null) || (localObject3 == null) || (!((anaw)localObject1).a().contains(apvb.a(((FileManagerEntity)localObject3).fileName).replace(".", "").toLowerCase()))) {
          break label917;
        }
        i = 1;
        if (i != 0)
        {
          localArrayList1.add(apvk.a(2130839635, ((anaw)localObject1).a(), apik.a((FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity, true)));
          ayhk.a(a(), "0X800A21C");
        }
        if ((localObject3 == null) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunFileId)) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunDirKey))) {
          break label922;
        }
        i = 1;
        if (i == 0)
        {
          if (!bool1) {
            break label927;
          }
          localArrayList1.add(apvk.a(2130839648, this.jdField_a_of_type_AndroidAppActivity.getString(2131692512), apik.a(this.jdField_a_of_type_Apkm, str)));
        }
        if (apue.c((FileManagerEntity)localObject3)) {
          localArrayList1.add(apvk.a(2130839637, this.jdField_a_of_type_AndroidAppActivity.getString(2131692504), apik.b(this.jdField_a_of_type_Apkm, (FileManagerEntity)localObject3)));
        }
        if (bgta.a().b((FileManagerEntity)localObject3)) {
          localArrayList1.add(apvk.a(2130839644, this.jdField_a_of_type_AndroidAppActivity.getString(2131692509), apik.c(this.jdField_a_of_type_Apkm, (FileManagerEntity)localObject3)));
        }
        j = j();
        if ((j != 0) && (this.jdField_a_of_type_Apkm != null) && (this.jdField_a_of_type_Apkm.e()))
        {
          localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131692541);
          i = 2130841802;
          if (j != 1) {
            break label968;
          }
          localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131692541);
          i = 2130841802;
          localArrayList2.add(apvk.a(i, (String)localObject1, new apmk(this, j)));
        }
        localObject4 = ancb.a();
        localObject1 = anbl.a();
        if ((localObject3 != null) && (localObject4 != null) && (localObject1 != null))
        {
          localObject4 = ((anca)localObject4).c();
          boolean bool2 = ((anbk)localObject1).d();
          localObject1 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            localObject1 = ayfv.jdField_a_of_type_JavaLangString;
          }
          long l = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject3).fileName);
          if ((bool2) && (ayfv.a(((FileManagerEntity)localObject3).strFilePath, ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
          {
            localObject1 = apvk.a(2130837566, this.jdField_a_of_type_AndroidAppActivity.getString(2131692503), apik.a((FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
            localArrayList2.add(localObject1);
          }
        }
        if ((bool1) && (((ajuo)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8)).a.a(b()))) {
          localArrayList2.add(apvk.a(2130843423, this.jdField_a_of_type_AndroidAppActivity.getString(2131692508), apik.b(this.jdField_a_of_type_Apkm, c())));
        }
        if (aprh.a((FileManagerEntity)localObject3, bool1))
        {
          localArrayList2.add(apvk.a(2130843416, this.jdField_a_of_type_AndroidAppActivity.getString(2131692547), apik.a(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
          localArrayList2.add(apvk.a(2130839646, this.jdField_a_of_type_AndroidAppActivity.getString(2131692548), apik.b(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
        }
        if (bool1) {
          localArrayList2.add(apvk.a(2130843422, this.jdField_a_of_type_AndroidAppActivity.getString(2131692507), apik.a(this.jdField_a_of_type_AndroidAppActivity, str)));
        }
        return new ArrayList[] { localArrayList1, localArrayList2 };
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      Object localObject4 = apvk.a(2130839638, this.jdField_a_of_type_AndroidAppActivity.getString(2131692506), apik.a(this.jdField_a_of_type_Apkm, (FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
      continue;
      label917:
      int i = 0;
      continue;
      label922:
      i = 0;
      continue;
      label927:
      if (d() == 1)
      {
        localArrayList1.add(apvk.a(2130839648, this.jdField_a_of_type_AndroidAppActivity.getString(2131692512), apik.a(this.jdField_a_of_type_Apkm, (FileManagerEntity)localObject3)));
        continue;
        label968:
        if (j == 2)
        {
          localObject2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131692542);
          i = 2130841803;
        }
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.d();
    }
    return -1;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.a();
    }
    return "";
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Apkp != null) {
      this.jdField_a_of_type_Apkp.a().status = paramInt;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.a();
    }
    return false;
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.b();
    }
    return 0L;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.g();
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
      this.jdField_a_of_type_Apkp = a();
      localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    } while ((localFileManagerEntity == null) || (!localFileManagerEntity.isZipInnerFile) || (!apvb.b(localFileManagerEntity.getFilePath())));
    localFileManagerEntity.status = 1;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Apkp == null;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.c();
    }
    return -1;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.a();
    }
    return 0L;
  }
  
  public String d()
  {
    return apvb.a(c());
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Apkp == null) {
      return;
    }
    if ((this.jdField_a_of_type_Apkm != null) && (this.jdField_a_of_type_Apkm.b())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = ayfv.a(this.jdField_a_of_type_Apkp.a(), bool);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt;
      return;
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Apkp != null) && (this.jdField_a_of_type_Apkp.a() != null)) {
      return this.jdField_a_of_type_Apkp.a().isFromProcessingForward2c2cOrDiscItem();
    }
    return false;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.a();
    }
    return -1;
  }
  
  public String e()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.b();
    }
    return "";
  }
  
  protected void e()
  {
    Object localObject2 = null;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) {}
    for (apkm localapkm = (apkm)this.jdField_a_of_type_AndroidAppActivity;; localapkm = null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
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
        apuc.a((String)localObject1);
        return;
        if ((localapkm != null) && (localapkm.b()))
        {
          localObject1 = "0X8004BB7";
        }
        else
        {
          localObject1 = "0X8004BCD";
          continue;
          if ((localapkm != null) && (localapkm.b()))
          {
            localObject1 = "0X8004BB8";
          }
          else
          {
            localObject1 = "0X8004BCE";
            continue;
            if ((localapkm != null) && (localapkm.b())) {
              localObject1 = "0X8004BB9";
            } else {
              localObject1 = "0X8004BCF";
            }
          }
        }
      }
    }
  }
  
  public boolean e()
  {
    if ((this.jdField_a_of_type_Apkp != null) && (this.jdField_a_of_type_Apkp.a() != null)) {
      return apue.a(this.jdField_a_of_type_Apkp.a());
    }
    return false;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.b();
    }
    return -1;
  }
  
  public String f()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.i();
    }
    return "";
  }
  
  public void f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    if (localFileManagerEntity != null)
    {
      aorz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    try
    {
      localFileManagerEntity = apue.a(new FileInfo(c()));
      aorz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public boolean f()
  {
    if ((this.jdField_a_of_type_Apkp != null) && (this.jdField_a_of_type_Apkp.a() != null)) {
      return this.jdField_a_of_type_Apkp.a().isZipInnerFile;
    }
    return false;
  }
  
  public void f_()
  {
    super.f_();
    if (this.jdField_a_of_type_Aozs != null)
    {
      this.jdField_a_of_type_Aozs.b();
      this.jdField_a_of_type_Aozs = null;
    }
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.e();
    }
    return -1;
  }
  
  public void g()
  {
    String str;
    if (this.jdField_a_of_type_Apkp.a().bSend) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    for (;;)
    {
      Object localObject = new SimpleDateFormat("yyyy.MM.dd");
      localObject = " 于" + ((SimpleDateFormat)localObject).format(new Date(this.jdField_a_of_type_Apkp.a().srvTime)) + "上传";
      if (this.jdField_a_of_type_Apnc != null) {
        this.jdField_a_of_type_Apnc.b(str, (String)localObject);
      }
      if (bbev.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break;
      }
      bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131692321), 1).b(l());
      return;
      if (this.jdField_a_of_type_Apkp.a().peerType == 3000) {
        str = bbcl.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkp.a().peerUin, this.jdField_a_of_type_Apkp.a().selfUin);
      } else {
        str = this.jdField_a_of_type_Apkp.a().peerNick;
      }
    }
    m();
  }
  
  public boolean g()
  {
    if ((this.jdField_a_of_type_Apkp != null) && (this.jdField_a_of_type_Apkp.a() != null)) {
      return this.jdField_a_of_type_Apkp.a().isSend();
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
      } while (apvb.b(c()));
      i = j;
    } while (!QLog.isColorLevel());
    QLog.i("FileBrowserModelBase<FileAssistant>", 1, "file is send,but not has localfile,return download status!");
    return 2;
  }
  
  public String h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
    return super.h();
  }
  
  public void h()
  {
    if (!bbev.d(BaseApplicationImpl.getContext()))
    {
      aptv.a(BaseApplicationImpl.getContext().getString(2131692665));
      return;
    }
    k();
    i();
    if (ayfv.c(c(), b(), c()))
    {
      ayfv.a(a(), this.jdField_a_of_type_AndroidAppActivity, "FileBrowserModelBase", a());
      ayfv.a(a(), null, "0X8009ECE");
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, FilePreviewActivity.class);
    localIntent.putExtra("offline_file_type", 0);
    localIntent.putExtra("offline_file_name", b());
    localIntent.putExtra("offline_file_size", c());
    if (j())
    {
      localIntent.putExtra("offline_file_show_team_work_menu", true);
      localIntent.putExtra("key_team_work_file_import_info", this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772200, 2130772201);
  }
  
  public boolean h()
  {
    boolean bool = true;
    if ((i() != 2) && (h() == 1)) {
      return false;
    }
    if ((apue.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkp)) && (apue.a(this.jdField_a_of_type_AndroidAppActivity, b(), c()))) {}
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
    String str = c();
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
    } while (apvb.b(str));
    return 0;
  }
  
  public String i()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.a() + "";
    }
    return super.i();
  }
  
  public void i()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    String str;
    if (d() == 2)
    {
      if (this.jdField_a_of_type_Apkp.a() != null) {
        break label88;
      }
      if (this.jdField_a_of_type_Apkp.a() != null) {
        break label72;
      }
      str = "";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new apdy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.WeiYunFileId, str));
      return;
      label72:
      str = this.jdField_a_of_type_Apkp.a().jdField_b_of_type_JavaLangString;
      continue;
      label88:
      str = this.jdField_a_of_type_Apkp.a().WeiYunDirKey;
    }
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
    } while (!bbev.e(BaseApplicationImpl.getContext()));
    amxu localamxu = ((aows)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(bahk.a(b()));
    long l = this.jdField_a_of_type_Apkp.b();
    if (((bbev.h(BaseApplicationImpl.getContext())) && (l <= localamxu.jdField_a_of_type_Int)) || (l <= localamxu.c)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Aozs != null)
    {
      this.jdField_a_of_type_Aozs.b();
      this.jdField_a_of_type_Aozs = null;
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_Apkp == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return false;
      localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Boolean = false;
    } while ((a() == null) || (localFileManagerEntity == null) || (!ayfv.d(c(), b(), c())) || (!bbev.d(BaseApplicationImpl.getContext())) || ((TextUtils.isEmpty(localFileManagerEntity.Uuid)) && (TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath)) && (TextUtils.isEmpty(localFileManagerEntity.strFilePath))));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = localFileManagerEntity.fileName;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Long = localFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c = localFileManagerEntity.strFilePath;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Int = localFileManagerEntity.nFileType;
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "file size:" + localFileManagerEntity.fileSize + " isTroopFile:" + TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath) + " isOfflineFile:" + TextUtils.isEmpty(localFileManagerEntity.Uuid) + "isLocalFile: " + TextUtils.isEmpty(localFileManagerEntity.strFilePath));
    }
    if (this.jdField_a_of_type_Apkm != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Boolean = this.jdField_a_of_type_Apkm.b();
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
  
  public void k()
  {
    if (this.jdField_a_of_type_Apkp != null)
    {
      this.jdField_a_of_type_Apkp.a(true);
      this.jdField_a_of_type_Apkp.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apme
 * JD-Core Version:    0.7.0.1
 */