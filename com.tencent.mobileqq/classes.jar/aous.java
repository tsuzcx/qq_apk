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

public abstract class aous
  extends aovk
{
  public aotf a;
  public QQAppInterface a;
  private TeamWorkFileImportInfo a;
  protected String a;
  protected List<aotf> a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  
  public aous(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private aotf a()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      QLog.e("FileBrowserModelBase", 1, "index error, index[" + this.jdField_a_of_type_Int + "], size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      return (aotf)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return (aotf)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
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
    Object localObject = this.jdField_a_of_type_Aotf.a();
    if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aond(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf.e(), this.jdField_a_of_type_Aotf.a().WeiYunDirKey));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aoiy == null) {
        this.jdField_a_of_type_Aoiy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      }
      if (this.jdField_a_of_type_Anxs == null) {
        this.jdField_a_of_type_Anxs = new aout(this, j);
      }
      if (this.jdField_a_of_type_Aoiy != null)
      {
        this.jdField_a_of_type_Aoiy.a(this.jdField_a_of_type_Anxs);
        this.jdField_a_of_type_Aoiy.a();
      }
      return;
      if (i == 2)
      {
        if (this.jdField_a_of_type_Aotf.a() == null) {}
        for (localObject = "";; localObject = this.jdField_a_of_type_Aotf.a().jdField_b_of_type_JavaLangString)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aond(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf.e(), (String)localObject));
          break;
        }
      }
      if ((i == 1) || (i == 3))
      {
        if (j == 3000) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aohy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf.c(), this.jdField_a_of_type_Aotf.d()));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aojx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf.c()));
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "loadZipFilesForOthers error. can not handle zip file");
      }
    }
  }
  
  public float a()
  {
    if ((this.jdField_a_of_type_Aotf != null) && (this.jdField_a_of_type_Aotf.a() != null)) {
      return this.jdField_a_of_type_Aotf.a().fProgress;
    }
    return 0.0F;
  }
  
  public aott a()
  {
    if (this.jdField_a_of_type_Aott == null) {
      this.jdField_a_of_type_Aott = new aouw(this);
    }
    return this.jdField_a_of_type_Aott;
  }
  
  public TeamWorkFileImportInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.d();
    }
    return "";
  }
  
  public ArrayList<bahx> a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    String str = c();
    boolean bool = apdh.b(str);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626891), aorb.a(this.jdField_a_of_type_Aotc, localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626896), new aouz(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626897), aorb.a(this.jdField_a_of_type_Aotc, localFileManagerEntity)));
    }
    for (;;)
    {
      if (apck.c(this.jdField_a_of_type_Aotf.a())) {
        localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626890), aorb.b(this.jdField_a_of_type_Aotc, localFileManagerEntity)));
      }
      if (aozn.a(localFileManagerEntity, bool))
      {
        localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626929), aorb.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626930), aorb.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      if (bool)
      {
        localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626895), new aova(this)));
        localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626893), new aovb(this)));
      }
      return localArrayList;
      localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626897), aorb.a(this.jdField_a_of_type_Aotc, str)));
    }
  }
  
  public List<aovl> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new aotw((aotf)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, aovl paramaovl)
  {
    aotf localaotf = ((aotw)paramaovl).a();
    if (localaotf == null) {
      apcb.b(BaseApplicationImpl.getContext().getString(2131626869));
    }
    do
    {
      return;
      if ((apck.a(localaotf.a())) && (1 == localaotf.c())) {
        apcb.b(BaseApplicationImpl.getContext().getString(2131626869));
      }
    } while (localaotf.f() != null);
    localaotf.a(1);
    paramaovl.a(1);
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Aotf == null) || (this.jdField_a_of_type_Aotf.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "onVideoPlayerError : file entity is null");
      }
      return;
    }
    paramString = this.jdField_a_of_type_Aotf.a();
    paramString.status = 16;
    paramString.mContext = "showed";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString);
  }
  
  public void a(aovm paramaovm) {}
  
  public void a(aovo paramaovo)
  {
    this.jdField_a_of_type_Aovo = paramaovo;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, String paramString7, wlx paramwlx)
  {
    String str = "http://" + paramString1 + ":" + paramString2 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + befm.a(paramString4) + "&";
    if (apdq.a()) {}
    for (paramString7 = "http://" + paramString7 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + befm.a(paramString4) + "&";; paramString7 = str)
    {
      if (paramFileManagerEntity.getCloudType() == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramString1 = new azgm(paramString7, "GET", new aouv(this, new ArrayList(), paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramwlx), 1000, null);
        paramString2 = new Bundle();
        paramString2.putString("version", babp.c());
        paramString2.putString("Cookie", "FTN5K=" + paramString5);
        paramString3 = new HashMap();
        paramString3.put("BUNDLE", paramString2);
        paramString3.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
        paramString1.a(paramString3);
        return;
      }
    }
  }
  
  protected void a(List<aotf> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aotf = a();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aotf != null) && (this.jdField_a_of_type_Aotf.a() != null)) {
      this.jdField_a_of_type_Aotf.a().bCannotPlay = true;
    }
  }
  
  protected void a(boolean paramBoolean, apbf paramapbf, long paramLong, apca paramapca)
  {
    paramapbf.a(paramBoolean, this.jdField_a_of_type_AndroidAppActivity, paramapca);
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
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1;
    if (bool1)
    {
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    label926:
    for (;;)
    {
      int j;
      Object localObject2;
      try
      {
        localObject1 = apck.a(new FileInfo(str));
        localObject4 = apdq.a(2130839591, this.jdField_a_of_type_AndroidAppActivity.getString(2131626892), aorb.a(this.jdField_a_of_type_Aotc, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity));
        localObject3 = localObject1;
        localArrayList1.add(localObject4);
        localArrayList1.add(apdq.a(2130843401, this.jdField_a_of_type_AndroidAppActivity.getString(2131626896), new aoux(this, (FileManagerEntity)localObject3)));
        localObject1 = amkt.a();
        if ((localObject1 == null) || (localObject3 == null) || (!((amks)localObject1).a().contains(apdh.a(((FileManagerEntity)localObject3).fileName).replace(".", "").toLowerCase()))) {
          break label875;
        }
        i = 1;
        if (i != 0)
        {
          localArrayList1.add(apdq.a(2130839588, ((amks)localObject1).a(), aorb.a((FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity, true)));
          axhg.a(a(), "0X800A21C");
        }
        if ((localObject3 == null) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunFileId)) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunDirKey))) {
          break label880;
        }
        i = 1;
        if (i == 0)
        {
          if (!bool1) {
            break label885;
          }
          localArrayList1.add(apdq.a(2130839600, this.jdField_a_of_type_AndroidAppActivity.getString(2131626897), aorb.a(this.jdField_a_of_type_Aotc, str)));
        }
        if (apck.c((FileManagerEntity)localObject3)) {
          localArrayList1.add(apdq.a(2130839590, this.jdField_a_of_type_AndroidAppActivity.getString(2131626890), aorb.b(this.jdField_a_of_type_Aotc, (FileManagerEntity)localObject3)));
        }
        j = j();
        if ((j != 0) && (this.jdField_a_of_type_Aotc != null) && (this.jdField_a_of_type_Aotc.e()))
        {
          localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131626923);
          i = 2130841707;
          if (j != 1) {
            break label926;
          }
          localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131626923);
          i = 2130841707;
          localArrayList2.add(apdq.a(i, (String)localObject1, new aouy(this, j)));
        }
        localObject4 = amlu.a();
        localObject1 = amlh.a();
        if ((localObject3 != null) && (localObject4 != null) && (localObject1 != null))
        {
          localObject4 = ((amlt)localObject4).c();
          boolean bool2 = ((amlg)localObject1).d();
          localObject1 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            localObject1 = axfs.jdField_a_of_type_JavaLangString;
          }
          long l = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject3).fileName);
          if ((bool2) && (axfs.a(((FileManagerEntity)localObject3).strFilePath, ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
          {
            localObject1 = apdq.a(2130837561, this.jdField_a_of_type_AndroidAppActivity.getString(2131626889), aorb.a((FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
            localArrayList2.add(localObject1);
          }
        }
        if ((bool1) && (((ajgm)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8)).a.a(b()))) {
          localArrayList2.add(apdq.a(2130843341, this.jdField_a_of_type_AndroidAppActivity.getString(2131626894), aorb.b(this.jdField_a_of_type_Aotc, c())));
        }
        if (aozn.a((FileManagerEntity)localObject3, bool1))
        {
          localArrayList2.add(apdq.a(2130843334, this.jdField_a_of_type_AndroidAppActivity.getString(2131626929), aorb.a(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
          localArrayList2.add(apdq.a(2130839598, this.jdField_a_of_type_AndroidAppActivity.getString(2131626930), aorb.b(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject3, str)));
        }
        if (bool1) {
          localArrayList2.add(apdq.a(2130843340, this.jdField_a_of_type_AndroidAppActivity.getString(2131626893), aorb.a(this.jdField_a_of_type_AndroidAppActivity, str)));
        }
        return new ArrayList[] { localArrayList1, localArrayList2 };
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      Object localObject4 = apdq.a(2130839591, this.jdField_a_of_type_AndroidAppActivity.getString(2131626892), aorb.a(this.jdField_a_of_type_Aotc, (FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
      continue;
      label875:
      int i = 0;
      continue;
      label880:
      i = 0;
      continue;
      label885:
      if (d() == 1)
      {
        localArrayList1.add(apdq.a(2130839600, this.jdField_a_of_type_AndroidAppActivity.getString(2131626897), aorb.a(this.jdField_a_of_type_Aotc, (FileManagerEntity)localObject3)));
        continue;
        if (j == 2)
        {
          localObject2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131626924);
          i = 2130841709;
        }
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.d();
    }
    return -1;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.a();
    }
    return "";
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Aotf != null) {
      this.jdField_a_of_type_Aotf.a().status = paramInt;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.a();
    }
    return false;
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.b();
    }
    return 0L;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.g();
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
      this.jdField_a_of_type_Aotf = a();
      localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    } while ((localFileManagerEntity == null) || (!localFileManagerEntity.isZipInnerFile) || (!apdh.b(localFileManagerEntity.getFilePath())));
    localFileManagerEntity.status = 1;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Aotf == null;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.c();
    }
    return -1;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.a();
    }
    return 0L;
  }
  
  public String d()
  {
    return apdh.a(c());
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Aotf == null) {
      return;
    }
    if ((this.jdField_a_of_type_Aotc != null) && (this.jdField_a_of_type_Aotc.b())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = axfs.a(this.jdField_a_of_type_Aotf.a(), bool);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt;
      return;
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Aotf != null) && (this.jdField_a_of_type_Aotf.a() != null)) {
      return this.jdField_a_of_type_Aotf.a().isFromProcessingForward2c2cOrDiscItem();
    }
    return false;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.a();
    }
    return -1;
  }
  
  public String e()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.b();
    }
    return "";
  }
  
  protected void e()
  {
    Object localObject2 = null;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) {}
    for (aotc localaotc = (aotc)this.jdField_a_of_type_AndroidAppActivity;; localaotc = null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
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
        apci.a((String)localObject1);
        return;
        if ((localaotc != null) && (localaotc.b()))
        {
          localObject1 = "0X8004BB7";
        }
        else
        {
          localObject1 = "0X8004BCD";
          continue;
          if ((localaotc != null) && (localaotc.b()))
          {
            localObject1 = "0X8004BB8";
          }
          else
          {
            localObject1 = "0X8004BCE";
            continue;
            if ((localaotc != null) && (localaotc.b())) {
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
    if ((this.jdField_a_of_type_Aotf != null) && (this.jdField_a_of_type_Aotf.a() != null)) {
      return apck.a(this.jdField_a_of_type_Aotf.a());
    }
    return false;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.b();
    }
    return -1;
  }
  
  public String f()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.i();
    }
    return "";
  }
  
  public void f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    if (localFileManagerEntity != null)
    {
      aobf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    try
    {
      localFileManagerEntity = apck.a(new FileInfo(c()));
      aobf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public boolean f()
  {
    if ((this.jdField_a_of_type_Aotf != null) && (this.jdField_a_of_type_Aotf.a() != null)) {
      return this.jdField_a_of_type_Aotf.a().isZipInnerFile;
    }
    return false;
  }
  
  public void f_()
  {
    super.f_();
    if (this.jdField_a_of_type_Aoiy != null)
    {
      this.jdField_a_of_type_Aoiy.b();
      this.jdField_a_of_type_Aoiy = null;
    }
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.e();
    }
    return -1;
  }
  
  public void g()
  {
    String str;
    if (this.jdField_a_of_type_Aotf.a().bSend) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    for (;;)
    {
      Object localObject = new SimpleDateFormat("yyyy.MM.dd");
      localObject = " 于" + ((SimpleDateFormat)localObject).format(new Date(this.jdField_a_of_type_Aotf.a().srvTime)) + "上传";
      if (this.jdField_a_of_type_Aovp != null) {
        this.jdField_a_of_type_Aovp.b(str, (String)localObject);
      }
      if (badq.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break;
      }
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131626719), 1).b(l());
      return;
      if (this.jdField_a_of_type_Aotf.a().peerType == 3000) {
        str = babh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf.a().peerUin, this.jdField_a_of_type_Aotf.a().selfUin);
      } else {
        str = this.jdField_a_of_type_Aotf.a().peerNick;
      }
    }
    m();
  }
  
  public boolean g()
  {
    if ((this.jdField_a_of_type_Aotf != null) && (this.jdField_a_of_type_Aotf.a() != null)) {
      return this.jdField_a_of_type_Aotf.a().isSend();
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
      } while (apdh.b(c()));
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
    if (!badq.d(BaseApplicationImpl.getContext()))
    {
      apcb.a(BaseApplicationImpl.getContext().getString(2131627028));
      return;
    }
    k();
    i();
    if (axfs.b(c(), b(), c()))
    {
      axfs.a(a(), this.jdField_a_of_type_AndroidAppActivity, "FileBrowserModelBase", a());
      axfs.a(a(), null, "0X8009ECE");
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
    if ((apck.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf)) && (apck.a(this.jdField_a_of_type_AndroidAppActivity, b(), c()))) {}
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
    } while (apdh.b(str));
    return 0;
  }
  
  public String i()
  {
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.a() + "";
    }
    return super.i();
  }
  
  public void i()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    String str;
    if (d() == 2)
    {
      if (this.jdField_a_of_type_Aotf.a() != null) {
        break label88;
      }
      if (this.jdField_a_of_type_Aotf.a() != null) {
        break label72;
      }
      str = "";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aond(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.WeiYunFileId, str));
      return;
      label72:
      str = this.jdField_a_of_type_Aotf.a().jdField_b_of_type_JavaLangString;
      continue;
      label88:
      str = this.jdField_a_of_type_Aotf.a().WeiYunDirKey;
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
    } while (!badq.e(BaseApplicationImpl.getContext()));
    amhq localamhq = ((aofy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(azgh.a(b()));
    long l = this.jdField_a_of_type_Aotf.b();
    if (((badq.h(BaseApplicationImpl.getContext())) && (l <= localamhq.jdField_a_of_type_Int)) || (l <= localamhq.c)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Aoiy != null)
    {
      this.jdField_a_of_type_Aoiy.b();
      this.jdField_a_of_type_Aoiy = null;
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_Aotf == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return false;
      localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Boolean = false;
    } while ((a() == null) || (localFileManagerEntity == null) || (!axfs.c(c(), b(), c())) || (!badq.d(BaseApplicationImpl.getContext())) || ((TextUtils.isEmpty(localFileManagerEntity.Uuid)) && (TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath)) && (TextUtils.isEmpty(localFileManagerEntity.strFilePath))));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = localFileManagerEntity.fileName;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Long = localFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c = localFileManagerEntity.strFilePath;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Int = localFileManagerEntity.nFileType;
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "file size:" + localFileManagerEntity.fileSize + " isTroopFile:" + TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath) + " isOfflineFile:" + TextUtils.isEmpty(localFileManagerEntity.Uuid) + "isLocalFile: " + TextUtils.isEmpty(localFileManagerEntity.strFilePath));
    }
    if (this.jdField_a_of_type_Aotc != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Boolean = this.jdField_a_of_type_Aotc.b();
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
    if (this.jdField_a_of_type_Aotf != null)
    {
      this.jdField_a_of_type_Aotf.a(true);
      this.jdField_a_of_type_Aotf.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aous
 * JD-Core Version:    0.7.0.1
 */