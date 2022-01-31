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

public class apnq
  extends apmi
{
  private ajsy jdField_a_of_type_Ajsy;
  private bajx jdField_a_of_type_Bajx;
  private xba jdField_a_of_type_Xba;
  private int c;
  private String f;
  private String g = "";
  
  public apnq(Activity paramActivity, List<apkt> paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 1, "FileBrowserModel init: type = troop");
    }
    a(paramList, paramInt);
  }
  
  private void a(azqv paramazqv)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new TroopFileModel.7(this, paramazqv));
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
      if (apug.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkt))
      {
        i = j;
        if (apug.a(this.jdField_a_of_type_AndroidAppActivity, b(), c()))
        {
          i = 5;
          continue;
          i = 8;
        }
      }
    }
  }
  
  public amgv a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    azqv localazqv = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if (localazqv == null)
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file info is null.");
      return new aplc();
    }
    long l = localFileManagerEntity.TroopUin;
    if ((localazqv.b == 3) || (localazqv.b == 2) || (localazqv.b == 1))
    {
      if ((TextUtils.isEmpty(localazqv.e)) && (bbdx.b(localazqv.a)))
      {
        QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload.");
        return new aple(localazqv.a);
      }
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload, but local file is not exist.");
      return new aplc();
    }
    return new aplh(l, localazqv);
  }
  
  public apli a()
  {
    if (this.jdField_a_of_type_Apli == null) {
      this.jdField_a_of_type_Apli = new apoe(this);
    }
    return this.jdField_a_of_type_Apli;
  }
  
  public aplj a()
  {
    return new apob(this);
  }
  
  public aplk a()
  {
    if (this.jdField_a_of_type_Aplk == null) {
      this.jdField_a_of_type_Aplk = new apod(this);
    }
    return this.jdField_a_of_type_Aplk;
  }
  
  public aplu a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    return new aplu(bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
  }
  
  public ArrayList<bbjs> a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    String str = c();
    boolean bool = apvd.b(str);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(apvm.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692506), apio.d(this.jdField_a_of_type_Apkq, localFileManagerEntity)));
    localArrayList.add(apvm.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692512), new apnt(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList.add(apvm.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692513), apio.e(this.jdField_a_of_type_Apkq, localFileManagerEntity)));
    }
    for (;;)
    {
      if (apug.c(this.jdField_a_of_type_Apkt.a())) {
        localArrayList.add(apvm.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692505), apio.b(this.jdField_a_of_type_Apkq, localFileManagerEntity)));
      }
      if (aprl.a(localFileManagerEntity, bool))
      {
        localArrayList.add(apvm.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692548), apio.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList.add(apvm.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692549), apio.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      if (bool)
      {
        localArrayList.add(apvm.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692511), new apnu(this)));
        localArrayList.add(apvm.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692508), new apnw(this)));
      }
      return localArrayList;
      localArrayList.add(apvm.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692513), apio.a(this.jdField_a_of_type_Apkq, str)));
    }
  }
  
  public List<apnc> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new aplo((apkt)localIterator.next()));
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
      localObject = this.jdField_a_of_type_Apkt.a();
      if (localObject != null)
      {
        str = String.valueOf(((FileManagerEntity)localObject).TroopUin);
        if (localObject == null) {
          break label79;
        }
        localObject = apug.b(((FileManagerEntity)localObject).nFileType);
        label45:
        axqy.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str, "", (String)localObject, "1");
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
          axqy.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
          return;
        }
      }
    } while (paramInt != 8);
    axqy.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
  }
  
  public void a(apnd paramapnd)
  {
    if (this.jdField_a_of_type_Xba == null) {
      this.jdField_a_of_type_Xba = new apny(this, paramapnd);
    }
    ThreadManager.post(new TroopFileModel.15(this, this.jdField_a_of_type_Apkt.a(), paramapnd), 8, null, true);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    axqy.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public boolean a(apnd paramapnd)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
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
        if (paramapnd != null) {
          paramapnd.aA_();
        }
        axqy.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return true;
      }
      if (paramapnd != null) {
        paramapnd.aB_();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
      for (paramapnd = "0";; paramapnd = "-1")
      {
        axqy.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramapnd, "-1", "-1");
        break;
      }
    }
    apkb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, new apnx(this, paramapnd, localTroopInfo, localTroopManager));
    return true;
  }
  
  public ArrayList<bbjs>[] a()
  {
    int i = d();
    if ((i == 5) || (i == 4))
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
      if ((localFileManagerEntity == null) || (localFileManagerEntity.isZipInnerFile)) {
        return null;
      }
      if (localFileManagerEntity.status == 16) {
        return null;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(apvm.a(2130839638, this.jdField_a_of_type_AndroidAppActivity.getString(2131692507), apio.d(this.jdField_a_of_type_Apkq, localFileManagerEntity)));
      localArrayList1.add(apvm.a(2130843486, this.jdField_a_of_type_AndroidAppActivity.getString(2131692512), new apof(this, localFileManagerEntity)));
      localArrayList1.add(apvm.a(2130839648, this.jdField_a_of_type_AndroidAppActivity.getString(2131692513), apio.e(this.jdField_a_of_type_Apkq, localFileManagerEntity)));
      if (apug.c(localFileManagerEntity)) {
        localArrayList1.add(apvm.a(2130839637, this.jdField_a_of_type_AndroidAppActivity.getString(2131692505), apio.b(this.jdField_a_of_type_Apkq, localFileManagerEntity)));
      }
      int j = j();
      Object localObject;
      if ((j != 0) && (this.jdField_a_of_type_Apkq != null) && (this.jdField_a_of_type_Apkq.e()))
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692542);
        i = 2130841802;
        if (j != 1) {
          break label529;
        }
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692542);
        i = 2130841802;
      }
      for (;;)
      {
        localArrayList2.add(apvm.a(i, (String)localObject, new apog(this, j)));
        boolean bool = anbq.a().d();
        long l = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
        String str = ancg.a().c();
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = ayfx.a;
        }
        if ((bool) && (ayfx.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, (String)localObject)) && (localFileManagerEntity.fileSize <= l))
        {
          localObject = apvm.a(2130837566, this.jdField_a_of_type_AndroidAppActivity.getString(2131692504), apio.a(localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
          localArrayList2.add(localObject);
        }
        localObject = c();
        if (aprl.a(localFileManagerEntity, apvd.b((String)localObject)))
        {
          localArrayList2.add(apvm.a(2130843417, this.jdField_a_of_type_AndroidAppActivity.getString(2131692548), apio.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, (String)localObject)));
          localArrayList2.add(apvm.a(2130839646, this.jdField_a_of_type_AndroidAppActivity.getString(2131692549), apio.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, (String)localObject)));
        }
        return new ArrayList[] { localArrayList1, localArrayList2 };
        label529:
        if (j == 2)
        {
          localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692543);
          i = 2130841803;
        }
      }
    }
    return super.a();
  }
  
  public int b()
  {
    int j = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    int k = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity).b;
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
    if (this.jdField_a_of_type_Apkt != null) {
      return this.jdField_a_of_type_Apkt.a().TroopUin;
    }
    return super.b();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ajsy != null) {}
    QQAppInterface localQQAppInterface;
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Ajsy = new apoc(this);
        if (QLog.isDevelopLevel()) {
          QLog.i("fobserver<FileAssistant>", 1, "add troopObserver");
        }
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localQQAppInterface.addObserver(this.jdField_a_of_type_Ajsy);
      } while (this.jdField_a_of_type_Bajx != null);
      localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    } while (localFileManagerEntity == null);
    this.jdField_a_of_type_Bajx = new bajx(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bajt.a(localQQAppInterface, this.jdField_a_of_type_Bajx);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Ajsy != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del troopObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Ajsy);
    }
    if (this.jdField_a_of_type_Bajx != null) {
      bajt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bajx);
    }
    this.jdField_a_of_type_Ajsy = null;
    this.jdField_a_of_type_Bajx = null;
    this.jdField_a_of_type_Xba = null;
  }
  
  public String d()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    StringBuilder localStringBuilder = new StringBuilder(apvd.a(c()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131692476));
      localStringBuilder.append(bakx.a(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  public String g()
  {
    Object localObject = this.jdField_a_of_type_Apkt.a();
    localObject = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if (localObject != null) {
      return ((azqv)localObject).j;
    }
    return null;
  }
  
  public void g()
  {
    xam.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkt.a().TroopUin, this.jdField_a_of_type_Apkt.a().strTroopFilePath, this.jdField_a_of_type_Apkt.a().busId, new apnr(this));
    xam.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apkt.a().TroopUin, this.jdField_a_of_type_Apkt.a().busId, this.jdField_a_of_type_Apkt.a().strTroopFilePath, new apoa(this));
  }
  
  public int h()
  {
    int i = 2;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    int j = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity).b;
    if ((j == 3) || (j == 2) || (j == 1)) {
      i = 1;
    }
    return i;
  }
  
  public String i()
  {
    if (a() == 2)
    {
      Object localObject = this.jdField_a_of_type_Apkt.a();
      localObject = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
      if (TextUtils.isEmpty(this.g))
      {
        this.g = (((azqv)localObject).e + "_" + System.currentTimeMillis());
        QLog.i("TroopFileModel<FileAssistant>", 1, "getContextId: troop video file random contextId: " + this.g);
      }
      return this.g;
    }
    return super.i();
  }
  
  public void i()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    super.i();
    if (d() == 4)
    {
      azqv localazqv = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new azql(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localazqv));
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
          localObject = this.jdField_a_of_type_Apkt.a();
          localObject = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
        } while (localObject == null);
        if (((((azqv)localObject).b == 3) || (((azqv)localObject).b == 2) || (((azqv)localObject).b == 1)) && (TextUtils.isEmpty(((azqv)localObject).e)))
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "getColorLabelShowType: troop file is upload, can not add color note.");
          return 0;
        }
      } while ((TextUtils.isEmpty(((azqv)localObject).e)) && (!bbdx.b(c())));
      if ((this.jdField_a_of_type_Apkq != null) && (this.jdField_a_of_type_Apkq.d())) {
        return 2;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apnq
 * JD-Core Version:    0.7.0.1
 */