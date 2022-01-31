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
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public abstract class arfh
  extends arfz
{
  public ardq a;
  public QQAppInterface a;
  private TeamWorkFileImportInfo a;
  protected String a;
  protected List<ardq> a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  private String g = "";
  
  public arfh(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private ardq a()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      QLog.e("FileBrowserModelBase", 1, "index error, index[" + this.jdField_a_of_type_Int + "], size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      return (ardq)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return (ardq)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void o()
  {
    int i = d();
    int j = f();
    Object localObject = this.jdField_a_of_type_Ardq.a();
    if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aqxa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ardq.e(), this.jdField_a_of_type_Ardq.a().WeiYunDirKey));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aqsu == null) {
        this.jdField_a_of_type_Aqsu = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      }
      if (this.jdField_a_of_type_Aqho == null) {
        this.jdField_a_of_type_Aqho = new arfi(this, j);
      }
      if (this.jdField_a_of_type_Aqsu != null)
      {
        this.jdField_a_of_type_Aqsu.a(this.jdField_a_of_type_Aqho);
        this.jdField_a_of_type_Aqsu.a();
      }
      return;
      if (i == 2)
      {
        if (this.jdField_a_of_type_Ardq.a() == null) {}
        for (localObject = "";; localObject = this.jdField_a_of_type_Ardq.a().jdField_b_of_type_JavaLangString)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aqxa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ardq.e(), (String)localObject));
          break;
        }
      }
      if ((i == 1) || (i == 3))
      {
        if (j == 3000) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aqru(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ardq.c(), this.jdField_a_of_type_Ardq.d()));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aqtt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ardq.c()));
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "loadZipFilesForOthers error. can not handle zip file");
      }
    }
  }
  
  public float a()
  {
    if ((this.jdField_a_of_type_Ardq != null) && (this.jdField_a_of_type_Ardq.a() != null)) {
      return this.jdField_a_of_type_Ardq.a().fProgress;
    }
    return 0.0F;
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return aroo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity);
  }
  
  public arei a()
  {
    if (this.jdField_a_of_type_Arei == null) {
      this.jdField_a_of_type_Arei = new arfl(this);
    }
    return this.jdField_a_of_type_Arei;
  }
  
  public TeamWorkFileImportInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  public List<argc> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new arel((ardq)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, argc paramargc)
  {
    ardq localardq = ((arel)paramargc).a();
    if (localardq == null) {
      armz.b(BaseApplicationImpl.getContext().getString(2131692559));
    }
    do
    {
      return;
      if ((arni.a(localardq.a())) && (1 == localardq.c())) {
        armz.b(BaseApplicationImpl.getContext().getString(2131692559));
      }
    } while (localardq.f() != null);
    localardq.a(1);
    paramargc.a(1);
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Ardq == null) || (this.jdField_a_of_type_Ardq.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "onVideoPlayerError : file entity is null");
      }
      return;
    }
    paramString = this.jdField_a_of_type_Ardq.a();
    paramString.status = 16;
    paramString.mContext = "showed";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString);
  }
  
  public void a(argd paramargd) {}
  
  public void a(argf paramargf)
  {
    this.jdField_a_of_type_Argf = paramargf;
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    Object localObject1;
    int i;
    do
    {
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
                localObject1 = this.jdField_a_of_type_Ardq.a();
                localObject2 = d();
              } while ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2)));
              i = paramActionSheetItem.action;
              f(i);
              if (i == 73)
              {
                arbl.a(this.jdField_a_of_type_Ardn, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity).onClick(null);
                return;
              }
              if (i != 72) {
                break;
              }
              i = paramActionSheetItem.uinType;
              paramActionSheetItem = paramActionSheetItem.uin;
            } while (TextUtils.isEmpty(paramActionSheetItem));
            aroo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, i);
            return;
            if (i == 39)
            {
              if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_AndroidAppActivity))
              {
                CheckPermission.requestSDCardPermission((AppActivity)this.jdField_a_of_type_AndroidAppActivity, new arfq(this));
                return;
              }
              arni.a(this.jdField_a_of_type_AndroidAppActivity, d());
              return;
            }
            if (i != 52) {
              break;
            }
            localObject1 = d();
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
            if (!bdcs.b((String)localObject1))
            {
              localObject2 = this.jdField_a_of_type_Ardq.a();
              paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
              if (localObject2 != null) {
                paramActionSheetItem = ((FileManagerEntity)localObject2).strLargeThumPath;
              }
            }
          } while (!bdcs.b(paramActionSheetItem));
          OCRPerformFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramActionSheetItem, 1, -1004, null);
          return;
          if (i != 55) {
            break;
          }
          localObject1 = e();
        } while (!bdcs.b((String)localObject1));
        aroo.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 1);
        azmj.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", ardu.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
        return;
        if (i != 56) {
          break;
        }
        localObject1 = e();
      } while (!bdcs.b((String)localObject1));
      aroo.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 2);
      azmj.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", ardu.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
      return;
    } while (i != 118);
    arbl.c(this.jdField_a_of_type_Ardn, (FileManagerEntity)localObject1).onClick(null);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, String paramString7, ypq paramypq)
  {
    String str = "http://" + paramString1 + ":" + paramString2 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + bhos.a(paramString4) + "&";
    if (aroo.a()) {}
    for (paramString7 = "http://" + paramString7 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + bhos.a(paramString4) + "&";; paramString7 = str)
    {
      if (paramFileManagerEntity.getCloudType() == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramString1 = new bcgp(paramString7, "GET", new arfk(this, new ArrayList(), paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramypq), 1000, null);
        paramString2 = new Bundle();
        paramString2.putString("version", bdcb.c());
        paramString2.putString("Cookie", "FTN5K=" + paramString5);
        paramString3 = new HashMap();
        paramString3.put("BUNDLE", paramString2);
        paramString3.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
        paramString1.a(paramString3);
        return;
      }
    }
  }
  
  protected void a(List<ardq> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ardq = a();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ardq != null) && (this.jdField_a_of_type_Ardq.a() != null)) {
      this.jdField_a_of_type_Ardq.a().bCannotPlay = true;
    }
  }
  
  protected void a(boolean paramBoolean, armf paramarmf, long paramLong, army paramarmy)
  {
    paramarmf.a(paramBoolean, this.jdField_a_of_type_AndroidAppActivity, paramarmy);
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
      int j;
      try
      {
        localObject1 = arni.a(new FileInfo(str));
        localObject3 = aroo.a(2, arbl.a(this.jdField_a_of_type_Ardn, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity));
        localArrayList1.add(localObject3);
        localArrayList1.add(aroo.a(26, new arfm(this, (FileManagerEntity)localObject1)));
        localObject3 = aosl.a();
        if ((localObject3 == null) || (localObject1 == null) || (!((aosk)localObject3).a().contains(arof.a(((FileManagerEntity)localObject1).fileName).replace(".", "").toLowerCase()))) {
          break label853;
        }
        i = 1;
        if (i != 0)
        {
          localArrayList1.add(aroo.a(120, arbl.a((FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity, true)));
          bafi.a(a(), "0X800A21C");
        }
        if (biuq.a().b((FileManagerEntity)localObject1)) {
          localArrayList1.add(aroo.a(118, null));
        }
        if ((localObject1 == null) || (TextUtils.isEmpty(((FileManagerEntity)localObject1).WeiYunFileId)) || (TextUtils.isEmpty(((FileManagerEntity)localObject1).WeiYunDirKey))) {
          break label858;
        }
        i = 1;
        if (i == 0)
        {
          if (!bool1) {
            break label863;
          }
          localArrayList1.add(aroo.a(27, arbl.a(this.jdField_a_of_type_Ardn, str)));
        }
        if (bool1) {
          localArrayList1.add(aroo.a(64, arbl.a(this.jdField_a_of_type_AndroidAppActivity, str)));
        }
        j = j();
        if ((j != 0) && (this.jdField_a_of_type_Ardn != null) && (this.jdField_a_of_type_Ardn.e()))
        {
          i = 70;
          if (j != 1) {
            break label894;
          }
          i = 70;
          localArrayList2.add(aroo.a(i, new arfn(this, j)));
        }
        if ((arni.a(((FileManagerEntity)localObject1).fileName) == 0) && (bool1)) {
          localArrayList2.add(aroo.a(39, null));
        }
        if (arni.c((FileManagerEntity)localObject1)) {
          localArrayList2.add(aroo.a(6, arbl.b(this.jdField_a_of_type_Ardn, (FileManagerEntity)localObject1)));
        }
        localObject4 = aotn.a();
        localObject3 = aosx.a();
        if ((localObject1 != null) && (localObject4 != null) && (localObject3 != null))
        {
          localObject4 = ((aotm)localObject4).c();
          boolean bool2 = ((aosw)localObject3).d();
          localObject3 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            localObject3 = badt.jdField_a_of_type_JavaLangString;
          }
          long l = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject1).fileName);
          if ((bool2) && (badt.a(((FileManagerEntity)localObject1).strFilePath, ((FileManagerEntity)localObject1).fileName, (String)localObject3)) && (((FileManagerEntity)localObject1).fileSize <= l))
          {
            localObject3 = aroo.a(119, arbl.a((FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity));
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
            localArrayList2.add(localObject3);
          }
        }
        if (arkn.a((FileManagerEntity)localObject1, bool1))
        {
          localArrayList2.add(aroo.a(122, arbl.a(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, str)));
          localArrayList2.add(aroo.a(123, arbl.b(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, str)));
        }
        if ((avqz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1)) && (e() == 0) && ((bdcs.b(((FileManagerEntity)localObject1).strLargeThumPath)) || (bdcs.b(str)))) {
          localArrayList2.add(aroo.a(52, null));
        }
        if (e() == 0) {
          a(localArrayList2);
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
      Object localObject4 = aroo.a(2, arbl.a(this.jdField_a_of_type_Ardn, (FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
      Object localObject2 = localObject3;
      localObject3 = localObject4;
      continue;
      label853:
      int i = 0;
      continue;
      label858:
      i = 0;
      continue;
      label863:
      if (d() == 1)
      {
        localArrayList1.add(aroo.a(27, arbl.a(this.jdField_a_of_type_Ardn, localObject2)));
        continue;
        label894:
        if (j == 2) {
          i = 82;
        }
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.d();
    }
    return -1;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.d();
    }
    return "";
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Ardq != null) {
      this.jdField_a_of_type_Ardq.a().status = paramInt;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.a();
    }
    return false;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    String str = d();
    boolean bool = arof.b(str);
    localArrayList1.add(aroo.a(2, arbl.a(this.jdField_a_of_type_Ardn, localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList1.add(aroo.a(26, new arfo(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList1.add(aroo.a(27, arbl.a(this.jdField_a_of_type_Ardn, localFileManagerEntity)));
    }
    for (;;)
    {
      if (bool) {
        localArrayList1.add(aroo.a(64, new arfp(this)));
      }
      if (bool) {
        localArrayList2.add(aroo.a(39, null));
      }
      if (arni.c(this.jdField_a_of_type_Ardq.a())) {
        localArrayList2.add(aroo.a(6, arbl.b(this.jdField_a_of_type_Ardn, localFileManagerEntity)));
      }
      if (arkn.a(localFileManagerEntity, bool))
      {
        localArrayList2.add(aroo.a(122, arbl.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList2.add(aroo.a(123, arbl.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      b(localArrayList2);
      return new ArrayList[] { localArrayList1, localArrayList2 };
      localArrayList1.add(aroo.a(27, arbl.a(this.jdField_a_of_type_Ardn, localFileManagerEntity)));
    }
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.b();
    }
    return 0L;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.a();
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
      this.jdField_a_of_type_Ardq = a();
      localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    } while ((localFileManagerEntity == null) || (!localFileManagerEntity.isZipInnerFile) || (!arof.b(localFileManagerEntity.getFilePath())));
    localFileManagerEntity.status = 1;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Ardq == null;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.c();
    }
    return -1;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.a();
    }
    return 0L;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.g();
    }
    return "";
  }
  
  protected void d()
  {
    Object localObject2 = null;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) {}
    for (ardn localardn = (ardn)this.jdField_a_of_type_AndroidAppActivity;; localardn = null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
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
        arng.a((String)localObject1);
        return;
        if ((localardn != null) && (localardn.b()))
        {
          localObject1 = "0X8004BB7";
        }
        else
        {
          localObject1 = "0X8004BCD";
          continue;
          if ((localardn != null) && (localardn.b()))
          {
            localObject1 = "0X8004BB8";
          }
          else
          {
            localObject1 = "0X8004BCE";
            continue;
            if ((localardn != null) && (localardn.b())) {
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
    if (this.jdField_a_of_type_Ardq == null) {
      return;
    }
    if ((this.jdField_a_of_type_Ardn != null) && (this.jdField_a_of_type_Ardn.b())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = badt.a(this.jdField_a_of_type_Ardq.a(), bool);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt;
      return;
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Ardq != null) && (this.jdField_a_of_type_Ardq.a() != null)) {
      return this.jdField_a_of_type_Ardq.a().isFromProcessingForward2c2cOrDiscItem();
    }
    return false;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.a();
    }
    return -1;
  }
  
  public String e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    if (localFileManagerEntity == null) {
      return "";
    }
    int i = arni.a(localFileManagerEntity.fileName);
    if (i == 0)
    {
      if (bdcs.b(d())) {
        return d();
      }
    }
    else if ((i == 2) && (bdcs.b(this.f))) {
      return this.f;
    }
    return super.e();
  }
  
  public void e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    if (localFileManagerEntity != null)
    {
      aqlb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    try
    {
      localFileManagerEntity = arni.a(new FileInfo(d()));
      aqlb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public boolean e()
  {
    if ((this.jdField_a_of_type_Ardq != null) && (this.jdField_a_of_type_Ardq.a() != null)) {
      return arni.a(this.jdField_a_of_type_Ardq.a());
    }
    return false;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.b();
    }
    return -1;
  }
  
  public String f()
  {
    return arof.a(c());
  }
  
  public void f()
  {
    String str;
    if (this.jdField_a_of_type_Ardq.a().bSend) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    for (;;)
    {
      Object localObject = new SimpleDateFormat("yyyy.MM.dd");
      localObject = " 于" + ((SimpleDateFormat)localObject).format(new Date(this.jdField_a_of_type_Ardq.a().srvTime)) + "上传";
      if (this.jdField_a_of_type_Argg != null) {
        this.jdField_a_of_type_Argg.b(str, (String)localObject);
      }
      if (bdee.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131692397), 1).b(l());
      return;
      if (this.jdField_a_of_type_Ardq.a().peerType == 3000) {
        str = bdbt.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ardq.a().peerUin, this.jdField_a_of_type_Ardq.a().selfUin);
      } else {
        str = this.jdField_a_of_type_Ardq.a().peerNick;
      }
    }
    o();
  }
  
  public boolean f()
  {
    if ((this.jdField_a_of_type_Ardq != null) && (this.jdField_a_of_type_Ardq.a() != null)) {
      return this.jdField_a_of_type_Ardq.a().isZipInnerFile;
    }
    return false;
  }
  
  public void f_()
  {
    super.f_();
    if (this.jdField_a_of_type_Aqsu != null)
    {
      this.jdField_a_of_type_Aqsu.b();
      this.jdField_a_of_type_Aqsu = null;
    }
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.e();
    }
    return -1;
  }
  
  public String g()
  {
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.b();
    }
    return "";
  }
  
  public void g()
  {
    if (!bdee.d(BaseApplicationImpl.getContext()))
    {
      armz.a(BaseApplicationImpl.getContext().getString(2131692745));
      return;
    }
    k();
    h();
    if (badt.c(d(), c(), c()))
    {
      badt.a(a(), this.jdField_a_of_type_AndroidAppActivity, "FileBrowserModelBase", a());
      badt.a(a(), null, "0X8009ECE");
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
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772215, 2130772216);
  }
  
  public boolean g()
  {
    if ((this.jdField_a_of_type_Ardq != null) && (this.jdField_a_of_type_Ardq.a() != null)) {
      return this.jdField_a_of_type_Ardq.a().isSend();
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
      } while (arof.b(d()));
      i = j;
    } while (!QLog.isColorLevel());
    QLog.i("FileBrowserModelBase<FileAssistant>", 1, "file is send,but not has localfile,return download status!");
    return 2;
  }
  
  public String h()
  {
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.i();
    }
    return "";
  }
  
  public void h()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    String str;
    if (d() == 2)
    {
      if (this.jdField_a_of_type_Ardq.a() != null) {
        break label88;
      }
      if (this.jdField_a_of_type_Ardq.a() != null) {
        break label72;
      }
      str = "";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aqxa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.WeiYunFileId, str));
      return;
      label72:
      str = this.jdField_a_of_type_Ardq.a().jdField_b_of_type_JavaLangString;
      continue;
      label88:
      str = this.jdField_a_of_type_Ardq.a().WeiYunDirKey;
    }
  }
  
  public boolean h()
  {
    boolean bool = true;
    if ((i() != 2) && (h() == 1)) {
      return false;
    }
    if ((arni.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ardq)) && (arni.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))) {}
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
    } while (arof.b(str));
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
    } while (!bdee.e(BaseApplicationImpl.getContext()));
    aopc localaopc = ((aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(bcgk.a(c()));
    long l = this.jdField_a_of_type_Ardq.b();
    if (((bdee.h(BaseApplicationImpl.getContext())) && (l <= localaopc.jdField_a_of_type_Int)) || (l <= localaopc.c)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
    return super.j();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Aqsu != null)
    {
      this.jdField_a_of_type_Aqsu.b();
      this.jdField_a_of_type_Aqsu = null;
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_Ardq == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return false;
      localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Boolean = false;
    } while ((a() == null) || (localFileManagerEntity == null) || (!badt.d(d(), c(), c())) || (!bdee.d(BaseApplicationImpl.getContext())) || ((TextUtils.isEmpty(localFileManagerEntity.Uuid)) && (TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath)) && (TextUtils.isEmpty(localFileManagerEntity.strFilePath))));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = localFileManagerEntity.fileName;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Long = localFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c = localFileManagerEntity.strFilePath;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Int = localFileManagerEntity.nFileType;
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "file size:" + localFileManagerEntity.fileSize + " isTroopFile:" + TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath) + " isOfflineFile:" + TextUtils.isEmpty(localFileManagerEntity.Uuid) + "isLocalFile: " + TextUtils.isEmpty(localFileManagerEntity.strFilePath));
    }
    if (this.jdField_a_of_type_Ardn != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Boolean = this.jdField_a_of_type_Ardn.b();
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
  
  public String k()
  {
    if (a() == 2)
    {
      if ((TextUtils.isEmpty(this.g)) && (this.jdField_a_of_type_Ardq != null))
      {
        this.g = (this.jdField_a_of_type_Ardq.a() + "_" + System.currentTimeMillis());
        QLog.i("FileBrowserModelBase", 1, "getContextId: default video file random contextId: " + this.g);
      }
      if (!TextUtils.isEmpty(this.g)) {
        return this.g;
      }
    }
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.a() + "";
    }
    return super.k();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Ardq != null)
    {
      this.jdField_a_of_type_Ardq.a(true);
      this.jdField_a_of_type_Ardq.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfh
 * JD-Core Version:    0.7.0.1
 */