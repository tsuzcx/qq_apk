import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.15;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.7;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class argq
  extends arfh
{
  private alkl jdField_a_of_type_Alkl;
  private bcik jdField_a_of_type_Bcik;
  private ypt jdField_a_of_type_Ypt;
  private int c;
  private String g;
  private String h = "";
  
  public argq(Activity paramActivity, List<ardq> paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 1, "FileBrowserModel init: type = troop");
    }
    a(paramList, paramInt);
  }
  
  private void a(bbpe parambbpe)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new TroopFileModel.7(this, parambbpe));
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
      if (arni.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ardq))
      {
        i = j;
        if (arni.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))
        {
          i = 5;
          continue;
          i = 8;
        }
      }
    }
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return aroo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
  }
  
  public anxw a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    bbpe localbbpe = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if (localbbpe == null)
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file info is null.");
      return new area();
    }
    long l = localFileManagerEntity.TroopUin;
    if ((localbbpe.b == 3) || (localbbpe.b == 2) || (localbbpe.b == 1))
    {
      if ((TextUtils.isEmpty(localbbpe.e)) && (bdcs.b(localbbpe.jdField_a_of_type_JavaLangString)))
      {
        QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload.");
        return new arec(localbbpe.jdField_a_of_type_JavaLangString);
      }
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload, but local file is not exist.");
      return new area();
    }
    return new aref(l, localbbpe);
  }
  
  public areg a()
  {
    if (this.jdField_a_of_type_Areg == null) {
      this.jdField_a_of_type_Areg = new arhd(this);
    }
    return this.jdField_a_of_type_Areg;
  }
  
  public arei a()
  {
    return new arha(this);
  }
  
  public arej a()
  {
    if (this.jdField_a_of_type_Arej == null) {
      this.jdField_a_of_type_Arej = new arhc(this);
    }
    return this.jdField_a_of_type_Arej;
  }
  
  public aret a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    return new aret(bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
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
        localArrayList.add(new aren((ardq)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Alkl != null) {}
    QQAppInterface localQQAppInterface;
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Alkl = new arhb(this);
        if (QLog.isDevelopLevel()) {
          QLog.i("fobserver<FileAssistant>", 1, "add troopObserver");
        }
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localQQAppInterface.addObserver(this.jdField_a_of_type_Alkl);
      } while (this.jdField_a_of_type_Bcik != null);
      localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    } while (localFileManagerEntity == null);
    this.jdField_a_of_type_Bcik = new bcik(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bcig.a(localQQAppInterface, this.jdField_a_of_type_Bcik);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject;
    String str;
    if (paramInt == 6)
    {
      localObject = this.jdField_a_of_type_Ardq.a();
      if (localObject != null)
      {
        str = String.valueOf(((FileManagerEntity)localObject).TroopUin);
        if (localObject == null) {
          break label79;
        }
        localObject = arni.b(((FileManagerEntity)localObject).nFileType);
        label45:
        azmj.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str, "", (String)localObject, "1");
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
          azmj.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
          return;
        }
      }
    } while (paramInt != 8);
    azmj.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
  }
  
  public void a(argd paramargd)
  {
    if (this.jdField_a_of_type_Ypt == null) {
      this.jdField_a_of_type_Ypt = new argx(this, paramargd);
    }
    ThreadManager.post(new TroopFileModel.15(this, this.jdField_a_of_type_Ardq.a(), paramargd), 8, null, true);
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int j = 1;
    if (paramActionSheetItem == null) {}
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_Ardq.a();
      Object localObject2 = d();
      if ((localObject1 != null) || (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        int k = paramActionSheetItem.action;
        int i;
        if (k == 73)
        {
          arbl.d(this.jdField_a_of_type_Ardn, (FileManagerEntity)localObject1).onClick(null);
          i = j;
        }
        while (i != 0)
        {
          f(k);
          return;
          if (k == 72)
          {
            int m = paramActionSheetItem.uinType;
            paramActionSheetItem = paramActionSheetItem.uin;
            i = j;
            if (!TextUtils.isEmpty(paramActionSheetItem))
            {
              aroo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, m);
              i = j;
            }
          }
          else if (k == 52)
          {
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
            i = j;
            if (bdcs.b(paramActionSheetItem))
            {
              OCRPerformFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramActionSheetItem, 1, -1002, null);
              i = j;
            }
          }
          else
          {
            i = 0;
            super.a(paramActionSheetItem);
          }
        }
      }
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    azmj.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public boolean a(argd paramargd)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
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
        if (paramargd != null) {
          paramargd.aH_();
        }
        azmj.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return true;
      }
      if (paramargd != null) {
        paramargd.aI_();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
      for (paramargd = "0";; paramargd = "-1")
      {
        azmj.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramargd, "-1", "-1");
        break;
      }
    }
    arcy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, new argw(this, paramargd, localTroopInfo, localTroopManager));
    return true;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    int i = d();
    if ((i == 5) || (i == 4))
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
      if ((localFileManagerEntity == null) || (localFileManagerEntity.isZipInnerFile)) {
        return null;
      }
      if (localFileManagerEntity.status == 16) {
        return null;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(aroo.a(2, arbl.d(this.jdField_a_of_type_Ardn, localFileManagerEntity)));
      localArrayList1.add(aroo.a(26, new arhe(this, localFileManagerEntity)));
      localArrayList1.add(aroo.a(27, arbl.e(this.jdField_a_of_type_Ardn, localFileManagerEntity)));
      int j = j();
      if ((j != 0) && (this.jdField_a_of_type_Ardn != null) && (this.jdField_a_of_type_Ardn.e()))
      {
        i = 70;
        if (j != 1) {
          break label528;
        }
        i = 70;
      }
      for (;;)
      {
        localArrayList2.add(aroo.a(i, new arhf(this, j)));
        String str2 = d();
        boolean bool1 = arof.b(str2);
        if ((arni.a(localFileManagerEntity.fileName) == 0) && (bool1)) {
          localArrayList2.add(aroo.a(39, null));
        }
        if (arni.c(localFileManagerEntity)) {
          localArrayList2.add(aroo.a(6, arbl.b(this.jdField_a_of_type_Ardn, localFileManagerEntity)));
        }
        boolean bool2 = aosx.a().d();
        long l = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
        String str1 = aotn.a().c();
        Object localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = badt.jdField_a_of_type_JavaLangString;
        }
        if ((bool2) && (badt.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, (String)localObject)) && (localFileManagerEntity.fileSize <= l))
        {
          localObject = aroo.a(119, arbl.a(localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
          localArrayList2.add(localObject);
        }
        if (arkn.a(localFileManagerEntity, bool1))
        {
          localArrayList2.add(aroo.a(122, arbl.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str2)));
          localArrayList2.add(aroo.a(123, arbl.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str2)));
        }
        localObject = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
        if ((localObject != null) && (((bbpe)localObject).jdField_a_of_type_JavaUtilUUID != null) && (e() == 0) && ((bdcs.b(((bbpe)localObject).c)) || (bdcs.b(str2)))) {
          localArrayList2.add(aroo.a(52, new argt(this)));
        }
        return new ArrayList[] { localArrayList1, localArrayList2 };
        label528:
        if (j == 2) {
          i = 82;
        }
      }
    }
    return super.a();
  }
  
  public int b()
  {
    int j = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    int k = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity).b;
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
    if (this.jdField_a_of_type_Ardq != null) {
      return this.jdField_a_of_type_Ardq.a().TroopUin;
    }
    return super.b();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Alkl != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del troopObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Alkl);
    }
    if (this.jdField_a_of_type_Bcik != null) {
      bcig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcik);
    }
    this.jdField_a_of_type_Alkl = null;
    this.jdField_a_of_type_Bcik = null;
    this.jdField_a_of_type_Ypt = null;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    String str = d();
    boolean bool = arof.b(str);
    localArrayList1.add(aroo.a(2, arbl.d(this.jdField_a_of_type_Ardn, localFileManagerEntity)));
    localArrayList1.add(aroo.a(26, new argu(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList1.add(aroo.a(27, arbl.e(this.jdField_a_of_type_Ardn, localFileManagerEntity)));
    }
    for (;;)
    {
      if (bool) {
        localArrayList1.add(aroo.a(64, new argv(this)));
      }
      if (bool) {
        localArrayList2.add(aroo.a(39, null));
      }
      if (arni.c(this.jdField_a_of_type_Ardq.a())) {
        localArrayList1.add(aroo.a(6, arbl.b(this.jdField_a_of_type_Ardn, localFileManagerEntity)));
      }
      if (arkn.a(localFileManagerEntity, bool))
      {
        localArrayList2.add(aroo.a(122, arbl.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList2.add(aroo.a(123, arbl.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      b(localArrayList2);
      return new ArrayList[] { localArrayList1, localArrayList2 };
      localArrayList1.add(aroo.a(27, arbl.a(this.jdField_a_of_type_Ardn, str)));
    }
  }
  
  public String f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    StringBuilder localStringBuilder = new StringBuilder(arof.a(c()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131692552));
      localStringBuilder.append(bcjk.a(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  public void f()
  {
    ypf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ardq.a().TroopUin, this.jdField_a_of_type_Ardq.a().strTroopFilePath, this.jdField_a_of_type_Ardq.a().busId, new argr(this));
    ypf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ardq.a().TroopUin, this.jdField_a_of_type_Ardq.a().busId, this.jdField_a_of_type_Ardq.a().strTroopFilePath, new argz(this));
  }
  
  public int h()
  {
    int i = 2;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    int j = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity).b;
    if ((j == 3) || (j == 2) || (j == 1)) {
      i = 1;
    }
    return i;
  }
  
  public void h()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
    super.h();
    if (d() == 4)
    {
      bbpe localbbpe = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new bbou(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localbbpe));
    }
  }
  
  public String i()
  {
    Object localObject = this.jdField_a_of_type_Ardq.a();
    localObject = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if (localObject != null) {
      return ((bbpe)localObject).j;
    }
    return null;
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
          localObject = this.jdField_a_of_type_Ardq.a();
          localObject = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
        } while (localObject == null);
        if (((((bbpe)localObject).b == 3) || (((bbpe)localObject).b == 2) || (((bbpe)localObject).b == 1)) && (TextUtils.isEmpty(((bbpe)localObject).e)))
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "getColorLabelShowType: troop file is upload, can not add color note.");
          return 0;
        }
      } while ((TextUtils.isEmpty(((bbpe)localObject).e)) && (!bdcs.b(d())));
      if ((this.jdField_a_of_type_Ardn != null) && (this.jdField_a_of_type_Ardn.d())) {
        return 2;
      }
      return 1;
    }
  }
  
  public String k()
  {
    if (a() == 2)
    {
      Object localObject = this.jdField_a_of_type_Ardq.a();
      localObject = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
      if (TextUtils.isEmpty(this.h))
      {
        this.h = (((bbpe)localObject).e + "_" + System.currentTimeMillis());
        QLog.i("TroopFileModel<FileAssistant>", 1, "getContextId: troop video file random contextId: " + this.h);
      }
      return this.h;
    }
    return super.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     argq
 * JD-Core Version:    0.7.0.1
 */