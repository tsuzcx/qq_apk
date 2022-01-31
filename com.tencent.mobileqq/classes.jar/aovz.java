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

public class aovz
  extends aous
{
  private ajey jdField_a_of_type_Ajey;
  private azig jdField_a_of_type_Azig;
  private wma jdField_a_of_type_Wma;
  private int c;
  private String f;
  private String g = "";
  
  public aovz(Activity paramActivity, List<aotf> paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 1, "FileBrowserModel init: type = troop");
    }
    a(paramList, paramInt);
  }
  
  private void a(ayqd paramayqd)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new TroopFileModel.7(this, paramayqd));
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
      if (apck.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf))
      {
        i = j;
        if (apck.a(this.jdField_a_of_type_AndroidAppActivity, b(), c()))
        {
          i = 5;
          continue;
          i = 8;
        }
      }
    }
  }
  
  public alsd a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if (localayqd == null)
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file info is null.");
      return new aoto();
    }
    long l = localFileManagerEntity.TroopUin;
    if ((localayqd.b == 3) || (localayqd.b == 2) || (localayqd.b == 1))
    {
      if ((TextUtils.isEmpty(localayqd.e)) && (bace.b(localayqd.a)))
      {
        QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload.");
        return new aotp(localayqd.a);
      }
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload, but local file is not exist.");
      return new aoto();
    }
    return new aotr(l, localayqd);
  }
  
  public aots a()
  {
    if (this.jdField_a_of_type_Aots == null) {
      this.jdField_a_of_type_Aots = new aowm(this);
    }
    return this.jdField_a_of_type_Aots;
  }
  
  public aott a()
  {
    return new aowj(this);
  }
  
  public aotu a()
  {
    if (this.jdField_a_of_type_Aotu == null) {
      this.jdField_a_of_type_Aotu = new aowl(this);
    }
    return this.jdField_a_of_type_Aotu;
  }
  
  public aoue a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    return new aoue(azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
  }
  
  public ArrayList<bahx> a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    String str = c();
    boolean bool = apdh.b(str);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626891), aorb.c(this.jdField_a_of_type_Aotc, localFileManagerEntity)));
    localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626896), new aowc(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626897), aorb.d(this.jdField_a_of_type_Aotc, localFileManagerEntity)));
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
        localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626895), new aowd(this)));
        localArrayList.add(apdq.a(0, this.jdField_a_of_type_AndroidAppActivity.getString(2131626893), new aowe(this)));
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
        localArrayList.add(new aoty((aotf)localIterator.next()));
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
      localObject = this.jdField_a_of_type_Aotf.a();
      if (localObject != null)
      {
        str = String.valueOf(((FileManagerEntity)localObject).TroopUin);
        if (localObject == null) {
          break label79;
        }
        localObject = apck.b(((FileManagerEntity)localObject).nFileType);
        label45:
        awqx.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str, "", (String)localObject, "1");
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
          awqx.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
          return;
        }
      }
    } while (paramInt != 8);
    awqx.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
  }
  
  public void a(aovm paramaovm)
  {
    if (this.jdField_a_of_type_Wma == null) {
      this.jdField_a_of_type_Wma = new aowg(this, paramaovm);
    }
    ThreadManager.post(new TroopFileModel.15(this, this.jdField_a_of_type_Aotf.a(), paramaovm), 8, null, true);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    awqx.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public boolean a(aovm paramaovm)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
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
        if (paramaovm != null) {
          paramaovm.aD_();
        }
        awqx.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return true;
      }
      if (paramaovm != null) {
        paramaovm.aE_();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
      for (paramaovm = "0";; paramaovm = "-1")
      {
        awqx.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramaovm, "-1", "-1");
        break;
      }
    }
    aosn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, new aowf(this, paramaovm, localTroopInfo, localTroopManager));
    return true;
  }
  
  public ArrayList<bahx>[] a()
  {
    int i = d();
    if ((i == 5) || (i == 4))
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
      if ((localFileManagerEntity == null) || (localFileManagerEntity.isZipInnerFile)) {
        return null;
      }
      if (localFileManagerEntity.status == 16) {
        return null;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(apdq.a(2130839591, this.jdField_a_of_type_AndroidAppActivity.getString(2131626892), aorb.c(this.jdField_a_of_type_Aotc, localFileManagerEntity)));
      localArrayList1.add(apdq.a(2130843401, this.jdField_a_of_type_AndroidAppActivity.getString(2131626896), new aown(this, localFileManagerEntity)));
      localArrayList1.add(apdq.a(2130839600, this.jdField_a_of_type_AndroidAppActivity.getString(2131626897), aorb.d(this.jdField_a_of_type_Aotc, localFileManagerEntity)));
      if (apck.c(localFileManagerEntity)) {
        localArrayList1.add(apdq.a(2130839590, this.jdField_a_of_type_AndroidAppActivity.getString(2131626890), aorb.b(this.jdField_a_of_type_Aotc, localFileManagerEntity)));
      }
      int j = j();
      Object localObject;
      if ((j != 0) && (this.jdField_a_of_type_Aotc != null) && (this.jdField_a_of_type_Aotc.e()))
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131626923);
        i = 2130841707;
        if (j != 1) {
          break label529;
        }
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131626923);
        i = 2130841707;
      }
      for (;;)
      {
        localArrayList2.add(apdq.a(i, (String)localObject, new aowo(this, j)));
        boolean bool = amlh.a().d();
        long l = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
        String str = amlu.a().c();
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = axfs.a;
        }
        if ((bool) && (axfs.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, (String)localObject)) && (localFileManagerEntity.fileSize <= l))
        {
          localObject = apdq.a(2130837561, this.jdField_a_of_type_AndroidAppActivity.getString(2131626889), aorb.a(localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
          localArrayList2.add(localObject);
        }
        localObject = c();
        if (aozn.a(localFileManagerEntity, apdh.b((String)localObject)))
        {
          localArrayList2.add(apdq.a(2130843334, this.jdField_a_of_type_AndroidAppActivity.getString(2131626929), aorb.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, (String)localObject)));
          localArrayList2.add(apdq.a(2130839598, this.jdField_a_of_type_AndroidAppActivity.getString(2131626930), aorb.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, (String)localObject)));
        }
        return new ArrayList[] { localArrayList1, localArrayList2 };
        label529:
        if (j == 2)
        {
          localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131626924);
          i = 2130841709;
        }
      }
    }
    return super.a();
  }
  
  public int b()
  {
    int j = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    int k = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity).b;
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
    if (this.jdField_a_of_type_Aotf != null) {
      return this.jdField_a_of_type_Aotf.a().TroopUin;
    }
    return super.b();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ajey != null) {}
    QQAppInterface localQQAppInterface;
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Ajey = new aowk(this);
        if (QLog.isDevelopLevel()) {
          QLog.i("fobserver<FileAssistant>", 1, "add troopObserver");
        }
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localQQAppInterface.addObserver(this.jdField_a_of_type_Ajey);
      } while (this.jdField_a_of_type_Azig != null);
      localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    } while (localFileManagerEntity == null);
    this.jdField_a_of_type_Azig = new azig(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    azic.a(localQQAppInterface, this.jdField_a_of_type_Azig);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Ajey != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del troopObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Ajey);
    }
    if (this.jdField_a_of_type_Azig != null) {
      azic.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azig);
    }
    this.jdField_a_of_type_Ajey = null;
    this.jdField_a_of_type_Azig = null;
    this.jdField_a_of_type_Wma = null;
  }
  
  public String d()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    StringBuilder localStringBuilder = new StringBuilder(apdh.a(c()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131626862));
      localStringBuilder.append(azjg.a(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  public String g()
  {
    Object localObject = this.jdField_a_of_type_Aotf.a();
    localObject = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if (localObject != null) {
      return ((ayqd)localObject).j;
    }
    return null;
  }
  
  public void g()
  {
    wln.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf.a().TroopUin, this.jdField_a_of_type_Aotf.a().strTroopFilePath, this.jdField_a_of_type_Aotf.a().busId, new aowa(this));
    wln.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aotf.a().TroopUin, this.jdField_a_of_type_Aotf.a().busId, this.jdField_a_of_type_Aotf.a().strTroopFilePath, new aowi(this));
  }
  
  public int h()
  {
    int i = 2;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    int j = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity).b;
    if ((j == 3) || (j == 2) || (j == 1)) {
      i = 1;
    }
    return i;
  }
  
  public String i()
  {
    if (a() == 2)
    {
      Object localObject = this.jdField_a_of_type_Aotf.a();
      localObject = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
      if (TextUtils.isEmpty(this.g))
      {
        this.g = (((ayqd)localObject).e + "_" + System.currentTimeMillis());
        QLog.i("TroopFileModel<FileAssistant>", 1, "getContextId: troop video file random contextId: " + this.g);
      }
      return this.g;
    }
    return super.i();
  }
  
  public void i()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aotf.a();
    super.i();
    if (d() == 4)
    {
      ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new aypt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localayqd));
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
          localObject = this.jdField_a_of_type_Aotf.a();
          localObject = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
        } while (localObject == null);
        if (((((ayqd)localObject).b == 3) || (((ayqd)localObject).b == 2) || (((ayqd)localObject).b == 1)) && (TextUtils.isEmpty(((ayqd)localObject).e)))
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "getColorLabelShowType: troop file is upload, can not add color note.");
          return 0;
        }
      } while ((TextUtils.isEmpty(((ayqd)localObject).e)) && (!bace.b(c())));
      if ((this.jdField_a_of_type_Aotc != null) && (this.jdField_a_of_type_Aotc.d())) {
        return 2;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aovz
 * JD-Core Version:    0.7.0.1
 */