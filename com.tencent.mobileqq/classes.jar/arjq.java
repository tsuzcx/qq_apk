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

public abstract class arjq
  extends arki
{
  public arhz a;
  public QQAppInterface a;
  private TeamWorkFileImportInfo a;
  protected String a;
  protected List<arhz> a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  private String g = "";
  
  public arjq(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private arhz a()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      QLog.e("FileBrowserModelBase", 1, "index error, index[" + this.jdField_a_of_type_Int + "], size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      return (arhz)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return (arhz)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
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
    Object localObject = this.jdField_a_of_type_Arhz.a();
    if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new arbj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz.e(), this.jdField_a_of_type_Arhz.a().WeiYunDirKey));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aqxd == null) {
        this.jdField_a_of_type_Aqxd = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      }
      if (this.jdField_a_of_type_Aqlx == null) {
        this.jdField_a_of_type_Aqlx = new arjr(this, j);
      }
      if (this.jdField_a_of_type_Aqxd != null)
      {
        this.jdField_a_of_type_Aqxd.a(this.jdField_a_of_type_Aqlx);
        this.jdField_a_of_type_Aqxd.a();
      }
      return;
      if (i == 2)
      {
        if (this.jdField_a_of_type_Arhz.a() == null) {}
        for (localObject = "";; localObject = this.jdField_a_of_type_Arhz.a().jdField_b_of_type_JavaLangString)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new arbj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz.e(), (String)localObject));
          break;
        }
      }
      if ((i == 1) || (i == 3))
      {
        if (j == 3000) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aqwd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz.c(), this.jdField_a_of_type_Arhz.d()));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aqyc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz.c()));
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "loadZipFilesForOthers error. can not handle zip file");
      }
    }
  }
  
  public float a()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.a() != null)) {
      return this.jdField_a_of_type_Arhz.a().fProgress;
    }
    return 0.0F;
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity);
  }
  
  public arir a()
  {
    if (this.jdField_a_of_type_Arir == null) {
      this.jdField_a_of_type_Arir = new arju(this);
    }
    return this.jdField_a_of_type_Arir;
  }
  
  public TeamWorkFileImportInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  public List<arkl> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new ariu((arhz)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, arkl paramarkl)
  {
    arhz localarhz = ((ariu)paramarkl).a();
    if (localarhz == null) {
      arri.b(BaseApplicationImpl.getContext().getString(2131692560));
    }
    do
    {
      return;
      if ((arrr.a(localarhz.a())) && (1 == localarhz.c())) {
        arri.b(BaseApplicationImpl.getContext().getString(2131692560));
      }
    } while (localarhz.f() != null);
    localarhz.a(1);
    paramarkl.a(1);
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Arhz == null) || (this.jdField_a_of_type_Arhz.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "onVideoPlayerError : file entity is null");
      }
      return;
    }
    paramString = this.jdField_a_of_type_Arhz.a();
    paramString.status = 16;
    paramString.mContext = "showed";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString);
  }
  
  public void a(arkm paramarkm) {}
  
  public void a(arko paramarko)
  {
    this.jdField_a_of_type_Arko = paramarko;
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
                localObject1 = this.jdField_a_of_type_Arhz.a();
                localObject2 = d();
              } while ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2)));
              i = paramActionSheetItem.action;
              f(i);
              if (i == 73)
              {
                arfu.a(this.jdField_a_of_type_Arhw, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity).onClick(null);
                return;
              }
              if (i != 72) {
                break;
              }
              i = paramActionSheetItem.uinType;
              paramActionSheetItem = paramActionSheetItem.uin;
            } while (TextUtils.isEmpty(paramActionSheetItem));
            arsx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, i);
            return;
            if (i == 39)
            {
              if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_AndroidAppActivity))
              {
                CheckPermission.requestSDCardPermission((AppActivity)this.jdField_a_of_type_AndroidAppActivity, new arjz(this));
                return;
              }
              arrr.a(this.jdField_a_of_type_AndroidAppActivity, d());
              return;
            }
            if (i != 52) {
              break;
            }
            localObject1 = d();
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
            if (!bdhb.b((String)localObject1))
            {
              localObject2 = this.jdField_a_of_type_Arhz.a();
              paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
              if (localObject2 != null) {
                paramActionSheetItem = ((FileManagerEntity)localObject2).strLargeThumPath;
              }
            }
          } while (!bdhb.b(paramActionSheetItem));
          OCRPerformFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramActionSheetItem, 1, -1004, null);
          return;
          if (i != 55) {
            break;
          }
          localObject1 = e();
        } while (!bdhb.b((String)localObject1));
        arsx.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 1);
        azqs.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", arid.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
        return;
        if (i != 56) {
          break;
        }
        localObject1 = e();
      } while (!bdhb.b((String)localObject1));
      arsx.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 2);
      azqs.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", arid.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
      return;
    } while (i != 118);
    arfu.c(this.jdField_a_of_type_Arhw, (FileManagerEntity)localObject1).onClick(null);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, String paramString7, yuf paramyuf)
  {
    String str = "http://" + paramString1 + ":" + paramString2 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + bhsz.a(paramString4) + "&";
    if (arsx.a()) {}
    for (paramString7 = "http://" + paramString7 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + bhsz.a(paramString4) + "&";; paramString7 = str)
    {
      if (paramFileManagerEntity.getCloudType() == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramString1 = new bcky(paramString7, "GET", new arjt(this, new ArrayList(), paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramyuf), 1000, null);
        paramString2 = new Bundle();
        paramString2.putString("version", bdgk.c());
        paramString2.putString("Cookie", "FTN5K=" + paramString5);
        paramString3 = new HashMap();
        paramString3.put("BUNDLE", paramString2);
        paramString3.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
        paramString1.a(paramString3);
        return;
      }
    }
  }
  
  protected void a(List<arhz> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Arhz = a();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.a() != null)) {
      this.jdField_a_of_type_Arhz.a().bCannotPlay = true;
    }
  }
  
  protected void a(boolean paramBoolean, arqo paramarqo, long paramLong, arrh paramarrh)
  {
    paramarqo.a(paramBoolean, this.jdField_a_of_type_AndroidAppActivity, paramarrh);
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    Object localObject3 = this.jdField_a_of_type_Arhz.a();
    String str = d();
    boolean bool1 = arso.b(str);
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
        localObject1 = arrr.a(new FileInfo(str));
        localObject3 = arsx.a(2, arfu.a(this.jdField_a_of_type_Arhw, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity));
        localArrayList1.add(localObject3);
        localArrayList1.add(arsx.a(26, new arjv(this, (FileManagerEntity)localObject1)));
        localObject3 = aowu.a();
        if ((localObject3 == null) || (localObject1 == null) || (!((aowt)localObject3).a().contains(arso.a(((FileManagerEntity)localObject1).fileName).replace(".", "").toLowerCase()))) {
          break label853;
        }
        i = 1;
        if (i != 0)
        {
          localArrayList1.add(arsx.a(120, arfu.a((FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity, true)));
          bajr.a(a(), "0X800A21C");
        }
        if (biyx.a().b((FileManagerEntity)localObject1)) {
          localArrayList1.add(arsx.a(118, null));
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
          localArrayList1.add(arsx.a(27, arfu.a(this.jdField_a_of_type_Arhw, str)));
        }
        if (bool1) {
          localArrayList1.add(arsx.a(64, arfu.a(this.jdField_a_of_type_AndroidAppActivity, str)));
        }
        j = j();
        if ((j != 0) && (this.jdField_a_of_type_Arhw != null) && (this.jdField_a_of_type_Arhw.e()))
        {
          i = 70;
          if (j != 1) {
            break label894;
          }
          i = 70;
          localArrayList2.add(arsx.a(i, new arjw(this, j)));
        }
        if ((arrr.a(((FileManagerEntity)localObject1).fileName) == 0) && (bool1)) {
          localArrayList2.add(arsx.a(39, null));
        }
        if (arrr.c((FileManagerEntity)localObject1)) {
          localArrayList2.add(arsx.a(6, arfu.b(this.jdField_a_of_type_Arhw, (FileManagerEntity)localObject1)));
        }
        localObject4 = aoxw.a();
        localObject3 = aoxg.a();
        if ((localObject1 != null) && (localObject4 != null) && (localObject3 != null))
        {
          localObject4 = ((aoxv)localObject4).c();
          boolean bool2 = ((aoxf)localObject3).d();
          localObject3 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            localObject3 = baic.jdField_a_of_type_JavaLangString;
          }
          long l = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject1).fileName);
          if ((bool2) && (baic.a(((FileManagerEntity)localObject1).strFilePath, ((FileManagerEntity)localObject1).fileName, (String)localObject3)) && (((FileManagerEntity)localObject1).fileSize <= l))
          {
            localObject3 = arsx.a(119, arfu.a((FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity));
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
            localArrayList2.add(localObject3);
          }
        }
        if (arow.a((FileManagerEntity)localObject1, bool1))
        {
          localArrayList2.add(arsx.a(122, arfu.a(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, str)));
          localArrayList2.add(arsx.a(123, arfu.b(this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, str)));
        }
        if ((avvi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1)) && (e() == 0) && ((bdhb.b(((FileManagerEntity)localObject1).strLargeThumPath)) || (bdhb.b(str)))) {
          localArrayList2.add(arsx.a(52, null));
        }
        if (e() == 0) {
          a(localArrayList2);
        }
        if ((bool1) && (((alqo)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8)).a.a(c()))) {
          localArrayList2.add(arsx.a(121, arfu.b(this.jdField_a_of_type_Arhw, d())));
        }
        return new ArrayList[] { localArrayList1, localArrayList2 };
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      Object localObject4 = arsx.a(2, arfu.a(this.jdField_a_of_type_Arhw, (FileManagerEntity)localObject3, this.jdField_a_of_type_AndroidAppActivity));
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
        localArrayList1.add(arsx.a(27, arfu.a(this.jdField_a_of_type_Arhw, localObject2)));
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
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.d();
    }
    return -1;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.d();
    }
    return "";
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Arhz != null) {
      this.jdField_a_of_type_Arhz.a().status = paramInt;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.a();
    }
    return false;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    String str = d();
    boolean bool = arso.b(str);
    localArrayList1.add(arsx.a(2, arfu.a(this.jdField_a_of_type_Arhw, localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList1.add(arsx.a(26, new arjx(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList1.add(arsx.a(27, arfu.a(this.jdField_a_of_type_Arhw, localFileManagerEntity)));
    }
    for (;;)
    {
      if (bool) {
        localArrayList1.add(arsx.a(64, new arjy(this)));
      }
      if (bool) {
        localArrayList2.add(arsx.a(39, null));
      }
      if (arrr.c(this.jdField_a_of_type_Arhz.a())) {
        localArrayList2.add(arsx.a(6, arfu.b(this.jdField_a_of_type_Arhw, localFileManagerEntity)));
      }
      if (arow.a(localFileManagerEntity, bool))
      {
        localArrayList2.add(arsx.a(122, arfu.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList2.add(arsx.a(123, arfu.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      b(localArrayList2);
      return new ArrayList[] { localArrayList1, localArrayList2 };
      localArrayList1.add(arsx.a(27, arfu.a(this.jdField_a_of_type_Arhw, localFileManagerEntity)));
    }
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.b();
    }
    return 0L;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.a();
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
      this.jdField_a_of_type_Arhz = a();
      localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    } while ((localFileManagerEntity == null) || (!localFileManagerEntity.isZipInnerFile) || (!arso.b(localFileManagerEntity.getFilePath())));
    localFileManagerEntity.status = 1;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Arhz == null;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.c();
    }
    return -1;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.a();
    }
    return 0L;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.g();
    }
    return "";
  }
  
  protected void d()
  {
    Object localObject2 = null;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) {}
    for (arhw localarhw = (arhw)this.jdField_a_of_type_AndroidAppActivity;; localarhw = null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
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
        arrp.a((String)localObject1);
        return;
        if ((localarhw != null) && (localarhw.b()))
        {
          localObject1 = "0X8004BB7";
        }
        else
        {
          localObject1 = "0X8004BCD";
          continue;
          if ((localarhw != null) && (localarhw.b()))
          {
            localObject1 = "0X8004BB8";
          }
          else
          {
            localObject1 = "0X8004BCE";
            continue;
            if ((localarhw != null) && (localarhw.b())) {
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
    if (this.jdField_a_of_type_Arhz == null) {
      return;
    }
    if ((this.jdField_a_of_type_Arhw != null) && (this.jdField_a_of_type_Arhw.b())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = baic.a(this.jdField_a_of_type_Arhz.a(), bool);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt;
      return;
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.a() != null)) {
      return this.jdField_a_of_type_Arhz.a().isFromProcessingForward2c2cOrDiscItem();
    }
    return false;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.a();
    }
    return -1;
  }
  
  public String e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    if (localFileManagerEntity == null) {
      return "";
    }
    int i = arrr.a(localFileManagerEntity.fileName);
    if (i == 0)
    {
      if (bdhb.b(d())) {
        return d();
      }
    }
    else if ((i == 2) && (bdhb.b(this.f))) {
      return this.f;
    }
    return super.e();
  }
  
  public void e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    if (localFileManagerEntity != null)
    {
      aqpk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    try
    {
      localFileManagerEntity = arrr.a(new FileInfo(d()));
      aqpk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public boolean e()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.a() != null)) {
      return arrr.a(this.jdField_a_of_type_Arhz.a());
    }
    return false;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.b();
    }
    return -1;
  }
  
  public String f()
  {
    return arso.a(c());
  }
  
  public void f()
  {
    String str;
    if (this.jdField_a_of_type_Arhz.a().bSend) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    for (;;)
    {
      Object localObject = new SimpleDateFormat("yyyy.MM.dd");
      localObject = " 于" + ((SimpleDateFormat)localObject).format(new Date(this.jdField_a_of_type_Arhz.a().srvTime)) + "上传";
      if (this.jdField_a_of_type_Arkp != null) {
        this.jdField_a_of_type_Arkp.b(str, (String)localObject);
      }
      if (bdin.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131692398), 1).b(l());
      return;
      if (this.jdField_a_of_type_Arhz.a().peerType == 3000) {
        str = bdgc.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz.a().peerUin, this.jdField_a_of_type_Arhz.a().selfUin);
      } else {
        str = this.jdField_a_of_type_Arhz.a().peerNick;
      }
    }
    o();
  }
  
  public boolean f()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.a() != null)) {
      return this.jdField_a_of_type_Arhz.a().isZipInnerFile;
    }
    return false;
  }
  
  public void f_()
  {
    super.f_();
    if (this.jdField_a_of_type_Aqxd != null)
    {
      this.jdField_a_of_type_Aqxd.b();
      this.jdField_a_of_type_Aqxd = null;
    }
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.e();
    }
    return -1;
  }
  
  public String g()
  {
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.b();
    }
    return "";
  }
  
  public void g()
  {
    if (!bdin.d(BaseApplicationImpl.getContext()))
    {
      arri.a(BaseApplicationImpl.getContext().getString(2131692747));
      return;
    }
    k();
    h();
    if (baic.c(d(), c(), c()))
    {
      baic.a(a(), this.jdField_a_of_type_AndroidAppActivity, "FileBrowserModelBase", a());
      baic.a(a(), null, "0X8009ECE");
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
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772216, 2130772217);
  }
  
  public boolean g()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.a() != null)) {
      return this.jdField_a_of_type_Arhz.a().isSend();
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
      } while (arso.b(d()));
      i = j;
    } while (!QLog.isColorLevel());
    QLog.i("FileBrowserModelBase<FileAssistant>", 1, "file is send,but not has localfile,return download status!");
    return 2;
  }
  
  public String h()
  {
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.i();
    }
    return "";
  }
  
  public void h()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    String str;
    if (d() == 2)
    {
      if (this.jdField_a_of_type_Arhz.a() != null) {
        break label88;
      }
      if (this.jdField_a_of_type_Arhz.a() != null) {
        break label72;
      }
      str = "";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new arbj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.WeiYunFileId, str));
      return;
      label72:
      str = this.jdField_a_of_type_Arhz.a().jdField_b_of_type_JavaLangString;
      continue;
      label88:
      str = this.jdField_a_of_type_Arhz.a().WeiYunDirKey;
    }
  }
  
  public boolean h()
  {
    boolean bool = true;
    if ((i() != 2) && (h() == 1)) {
      return false;
    }
    if ((arrr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz)) && (arrr.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))) {}
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
    } while (arso.b(str));
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
    } while (!bdin.e(BaseApplicationImpl.getContext()));
    aotl localaotl = ((aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(bckt.a(c()));
    long l = this.jdField_a_of_type_Arhz.b();
    if (((bdin.h(BaseApplicationImpl.getContext())) && (l <= localaotl.jdField_a_of_type_Int)) || (l <= localaotl.c)) {}
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
    if (this.jdField_a_of_type_Aqxd != null)
    {
      this.jdField_a_of_type_Aqxd.b();
      this.jdField_a_of_type_Aqxd = null;
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_Arhz == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return false;
      localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Boolean = false;
    } while ((a() == null) || (localFileManagerEntity == null) || (!baic.d(d(), c(), c())) || (!bdin.d(BaseApplicationImpl.getContext())) || ((TextUtils.isEmpty(localFileManagerEntity.Uuid)) && (TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath)) && (TextUtils.isEmpty(localFileManagerEntity.strFilePath))));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = localFileManagerEntity.fileName;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Long = localFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c = localFileManagerEntity.strFilePath;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Int = localFileManagerEntity.nFileType;
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "file size:" + localFileManagerEntity.fileSize + " isTroopFile:" + TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath) + " isOfflineFile:" + TextUtils.isEmpty(localFileManagerEntity.Uuid) + "isLocalFile: " + TextUtils.isEmpty(localFileManagerEntity.strFilePath));
    }
    if (this.jdField_a_of_type_Arhw != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Boolean = this.jdField_a_of_type_Arhw.b();
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
      if ((TextUtils.isEmpty(this.g)) && (this.jdField_a_of_type_Arhz != null))
      {
        this.g = (this.jdField_a_of_type_Arhz.a() + "_" + System.currentTimeMillis());
        QLog.i("FileBrowserModelBase", 1, "getContextId: default video file random contextId: " + this.g);
      }
      if (!TextUtils.isEmpty(this.g)) {
        return this.g;
      }
    }
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.a() + "";
    }
    return super.k();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Arhz != null)
    {
      this.jdField_a_of_type_Arhz.a(true);
      this.jdField_a_of_type_Arhz.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjq
 * JD-Core Version:    0.7.0.1
 */