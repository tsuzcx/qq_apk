import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.15;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.7;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apnm
  extends apme
{
  private ajta jdField_a_of_type_Ajta;
  private bajj jdField_a_of_type_Bajj;
  private xbd jdField_a_of_type_Xbd;
  private int c;
  private String f;
  private String g = "";
  
  public apnm(Activity paramActivity, List<apkp> paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 1, "FileBrowserModel init: type = troop");
    }
    a(paramList, paramInt);
  }
  
  private void a(azqt paramazqt)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new TroopFileModel.7(this, paramazqt));
  }
  
  public int a()
  {
    int j = 7;
    int k = e();
    int i = super.a();
    if ((this.b == 3) && (k == 2)) {
      return 8;
    }
    if (i != 0) {
      return i;
    }
    i = j;
    switch (k)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      return i;
      i = 6;
      continue;
      i = j;
      if (apue.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkp))
      {
        i = j;
        if (apue.a(this.jdField_a_of_type_AndroidAppActivity, b(), c()))
        {
          i = 5;
          continue;
          i = 8;
        }
      }
    }
  }
  
  public amgw a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    azqt localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if (localazqt == null)
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file info is null.");
      return new apky();
    }
    long l = localFileManagerEntity.TroopUin;
    if ((localazqt.b == 3) || (localazqt.b == 2) || (localazqt.b == 1))
    {
      if ((TextUtils.isEmpty(localazqt.e)) && (bbdj.b(localazqt.a)))
      {
        QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload.");
        return new apla(localazqt.a);
      }
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload, but local file is not exist.");
      return new apky();
    }
    return new apld(l, localazqt);
  }
  
  public aple a()
  {
    if (this.jdField_a_of_type_Aple == null) {
      this.jdField_a_of_type_Aple = new apoa(this);
    }
    return this.jdField_a_of_type_Aple;
  }
  
  public aplf a()
  {
    return new apnx(this);
  }
  
  public aplg a()
  {
    if (this.jdField_a_of_type_Aplg == null) {
      this.jdField_a_of_type_Aplg = new apnz(this);
    }
    return this.jdField_a_of_type_Aplg;
  }
  
  public aplq a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    return new aplq(bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
  }
  
  public ArrayList<bbje> a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    String str = c();
    boolean bool = apvb.b(str);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692505), apik.d(this.jdField_a_of_type_Apkm, localFileManagerEntity)));
    localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692511), new apnp(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692512), apik.e(this.jdField_a_of_type_Apkm, localFileManagerEntity)));
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
        localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692510), new apnq(this)));
        localArrayList.add(apvk.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692507), new apns(this)));
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
        localArrayList.add(new aplk((apkp)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject;
    String str;
    if (paramInt == 6)
    {
      localObject = this.jdField_a_of_type_Apkp.a();
      if (localObject != null)
      {
        str = String.valueOf(((FileManagerEntity)localObject).TroopUin);
        if (localObject == null) {
          break label79;
        }
        localObject = apue.b(((FileManagerEntity)localObject).nFileType);
        label45:
        axqw.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str, "", (String)localObject, "1");
      }
    }
    label79:
    do
    {
      return;
      str = "";
      break;
      localObject = "unknow";
      break label45;
      if (paramInt == 4)
      {
        if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
        for (str = "0";; str = "-1")
        {
          axqw.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
          return;
        }
      }
    } while (paramInt != 8);
    axqw.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
  }
  
  public void a(apmz paramapmz)
  {
    if (this.jdField_a_of_type_Xbd == null) {
      this.jdField_a_of_type_Xbd = new apnu(this, paramapmz);
    }
    ThreadManager.post(new TroopFileModel.15(this, this.jdField_a_of_type_Apkp.a(), paramapmz), 8, null, true);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    axqw.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public boolean a(apmz paramapmz)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localTroopManager == null) {}
    TroopInfo localTroopInfo;
    do
    {
      return false;
      localTroopInfo = localTroopManager.b(String.valueOf(localFileManagerEntity.TroopUin));
    } while (localTroopInfo == null);
    if (NetConnInfoCenter.getServerTimeMillis() <= localTroopInfo.mTroopFileVideoReqInterval)
    {
      if (localTroopInfo.mTroopFileVideoIsWhite != 0)
      {
        if (paramapmz != null) {
          paramapmz.aA_();
        }
        axqw.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return true;
      }
      if (paramapmz != null) {
        paramapmz.aB_();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
      for (paramapmz = "0";; paramapmz = "-1")
      {
        axqw.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramapmz, "-1", "-1");
        break;
      }
    }
    apjx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, new apnt(this, paramapmz, localTroopInfo, localTroopManager));
    return true;
  }
  
  public ArrayList<bbje>[] a()
  {
    int i = d();
    if ((i == 5) || (i == 4))
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
      if ((localFileManagerEntity == null) || (localFileManagerEntity.isZipInnerFile)) {
        return null;
      }
      if (localFileManagerEntity.status == 16) {
        return null;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(apvk.a(2130839638, this.jdField_a_of_type_AndroidAppActivity.getString(2131692506), apik.d(this.jdField_a_of_type_Apkm, localFileManagerEntity)));
      localArrayList1.add(apvk.a(2130843485, this.jdField_a_of_type_AndroidAppActivity.getString(2131692511), new apob(this, localFileManagerEntity)));
      localArrayList1.add(apvk.a(2130839648, this.jdField_a_of_type_AndroidAppActivity.getString(2131692512), apik.e(this.jdField_a_of_type_Apkm, localFileManagerEntity)));
      if (apue.c(localFileManagerEntity)) {
        localArrayList1.add(apvk.a(2130839637, this.jdField_a_of_type_AndroidAppActivity.getString(2131692504), apik.b(this.jdField_a_of_type_Apkm, localFileManagerEntity)));
      }
      int j = j();
      Object localObject;
      if ((j != 0) && (this.jdField_a_of_type_Apkm != null) && (this.jdField_a_of_type_Apkm.e()))
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692541);
        i = 2130841802;
        if (j != 1) {
          break label529;
        }
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692541);
        i = 2130841802;
      }
      for (;;)
      {
        localArrayList2.add(apvk.a(i, (String)localObject, new apoc(this, j)));
        boolean bool = anbl.a().d();
        long l = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
        String str = ancb.a().c();
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = ayfv.a;
        }
        if ((bool) && (ayfv.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, (String)localObject)) && (localFileManagerEntity.fileSize <= l))
        {
          localObject = apvk.a(2130837566, this.jdField_a_of_type_AndroidAppActivity.getString(2131692503), apik.a(localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
          localArrayList2.add(localObject);
        }
        localObject = c();
        if (aprh.a(localFileManagerEntity, apvb.b((String)localObject)))
        {
          localArrayList2.add(apvk.a(2130843416, this.jdField_a_of_type_AndroidAppActivity.getString(2131692547), apik.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, (String)localObject)));
          localArrayList2.add(apvk.a(2130839646, this.jdField_a_of_type_AndroidAppActivity.getString(2131692548), apik.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, (String)localObject)));
        }
        return new ArrayList[] { localArrayList1, localArrayList2 };
        label529:
        if (j == 2)
        {
          localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692542);
          i = 2130841803;
        }
      }
    }
    return super.a();
  }
  
  public int b()
  {
    int j = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    int k = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity).b;
    int i;
    if ((k == 3) || (k == 2) || (k == 10) || (k == 9)) {
      i = 3;
    }
    do
    {
      do
      {
        return i;
        if ((k == 8) || (k == 1) || (k == 4)) {
          return 2;
        }
        i = j;
      } while (k == 6);
      i = j;
    } while (k == 11);
    if (k == 12) {
      return 16;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel getFileStatus : troopFileStatus[" + k + "] can not change troop file status to FMConstants status");
    }
    return super.b();
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_Apkp != null) {
      return this.jdField_a_of_type_Apkp.a().TroopUin;
    }
    return super.b();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ajta != null) {}
    QQAppInterface localQQAppInterface;
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Ajta = new apny(this);
        if (QLog.isDevelopLevel()) {
          QLog.i("fobserver<FileAssistant>", 1, "add troopObserver");
        }
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localQQAppInterface.addObserver(this.jdField_a_of_type_Ajta);
      } while (this.jdField_a_of_type_Bajj != null);
      localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    } while (localFileManagerEntity == null);
    this.jdField_a_of_type_Bajj = new bajj(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bajf.a(localQQAppInterface, this.jdField_a_of_type_Bajj);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Ajta != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del troopObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Ajta);
    }
    if (this.jdField_a_of_type_Bajj != null) {
      bajf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bajj);
    }
    this.jdField_a_of_type_Ajta = null;
    this.jdField_a_of_type_Bajj = null;
    this.jdField_a_of_type_Xbd = null;
  }
  
  public String d()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    StringBuilder localStringBuilder = new StringBuilder(apvb.a(c()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131692475));
      localStringBuilder.append(bakj.a(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  public String g()
  {
    Object localObject = this.jdField_a_of_type_Apkp.a();
    localObject = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if (localObject != null) {
      return ((azqt)localObject).j;
    }
    return null;
  }
  
  public void g()
  {
    xap.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkp.a().TroopUin, this.jdField_a_of_type_Apkp.a().strTroopFilePath, this.jdField_a_of_type_Apkp.a().busId, new apnn(this));
    xap.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkp.a().TroopUin, this.jdField_a_of_type_Apkp.a().busId, this.jdField_a_of_type_Apkp.a().strTroopFilePath, new apnw(this));
  }
  
  public int h()
  {
    int i = 2;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    int j = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity).b;
    if ((j == 3) || (j == 2) || (j == 1)) {
      i = 1;
    }
    return i;
  }
  
  public String i()
  {
    if (a() == 2)
    {
      Object localObject = this.jdField_a_of_type_Apkp.a();
      localObject = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
      if (TextUtils.isEmpty(this.g))
      {
        this.g = (((azqt)localObject).e + "_" + System.currentTimeMillis());
        QLog.i("TroopFileModel<FileAssistant>", 1, "getContextId: troop video file random contextId: " + this.g);
      }
      return this.g;
    }
    return super.i();
  }
  
  public void i()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkp.a();
    super.i();
    if (d() == 4)
    {
      azqt localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new azqj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localazqt));
    }
  }
  
  public int j()
  {
    int i = e();
    if ((i != 0) && (i != 2) && (i != 13)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {}
      Object localObject;
      do
      {
        do
        {
          return 0;
          localObject = this.jdField_a_of_type_Apkp.a();
          localObject = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
        } while (localObject == null);
        if (((((azqt)localObject).b == 3) || (((azqt)localObject).b == 2) || (((azqt)localObject).b == 1)) && (TextUtils.isEmpty(((azqt)localObject).e)))
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "getColorLabelShowType: troop file is upload, can not add color note.");
          return 0;
        }
      } while ((TextUtils.isEmpty(((azqt)localObject).e)) && (!bbdj.b(c())));
      if ((this.jdField_a_of_type_Apkm != null) && (this.jdField_a_of_type_Apkm.d())) {
        return 2;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apnm
 * JD-Core Version:    0.7.0.1
 */