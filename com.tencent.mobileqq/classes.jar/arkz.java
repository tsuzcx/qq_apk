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

public class arkz
  extends arjq
{
  private alpa jdField_a_of_type_Alpa;
  private bcmt jdField_a_of_type_Bcmt;
  private yui jdField_a_of_type_Yui;
  private int c;
  private String g;
  private String h = "";
  
  public arkz(Activity paramActivity, List<arhz> paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 1, "FileBrowserModel init: type = troop");
    }
    a(paramList, paramInt);
  }
  
  private void a(bbtn parambbtn)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new TroopFileModel.7(this, parambbtn));
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
      if (arrr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz))
      {
        i = j;
        if (arrr.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
  }
  
  public aocf a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if (localbbtn == null)
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file info is null.");
      return new arij();
    }
    long l = localFileManagerEntity.TroopUin;
    if ((localbbtn.b == 3) || (localbbtn.b == 2) || (localbbtn.b == 1))
    {
      if ((TextUtils.isEmpty(localbbtn.e)) && (bdhb.b(localbbtn.jdField_a_of_type_JavaLangString)))
      {
        QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload.");
        return new aril(localbbtn.jdField_a_of_type_JavaLangString);
      }
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload, but local file is not exist.");
      return new arij();
    }
    return new ario(l, localbbtn);
  }
  
  public arip a()
  {
    if (this.jdField_a_of_type_Arip == null) {
      this.jdField_a_of_type_Arip = new arlm(this);
    }
    return this.jdField_a_of_type_Arip;
  }
  
  public arir a()
  {
    return new arlj(this);
  }
  
  public aris a()
  {
    if (this.jdField_a_of_type_Aris == null) {
      this.jdField_a_of_type_Aris = new arll(this);
    }
    return this.jdField_a_of_type_Aris;
  }
  
  public arjc a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    return new arjc(bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
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
        localArrayList.add(new ariw((arhz)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Alpa != null) {}
    QQAppInterface localQQAppInterface;
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Alpa = new arlk(this);
        if (QLog.isDevelopLevel()) {
          QLog.i("fobserver<FileAssistant>", 1, "add troopObserver");
        }
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localQQAppInterface.addObserver(this.jdField_a_of_type_Alpa);
      } while (this.jdField_a_of_type_Bcmt != null);
      localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    } while (localFileManagerEntity == null);
    this.jdField_a_of_type_Bcmt = new bcmt(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bcmp.a(localQQAppInterface, this.jdField_a_of_type_Bcmt);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject;
    String str;
    if (paramInt == 6)
    {
      localObject = this.jdField_a_of_type_Arhz.a();
      if (localObject != null)
      {
        str = String.valueOf(((FileManagerEntity)localObject).TroopUin);
        if (localObject == null) {
          break label79;
        }
        localObject = arrr.b(((FileManagerEntity)localObject).nFileType);
        label45:
        azqs.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str, "", (String)localObject, "1");
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
          azqs.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
          return;
        }
      }
    } while (paramInt != 8);
    azqs.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
  }
  
  public void a(arkm paramarkm)
  {
    if (this.jdField_a_of_type_Yui == null) {
      this.jdField_a_of_type_Yui = new arlg(this, paramarkm);
    }
    ThreadManager.post(new TroopFileModel.15(this, this.jdField_a_of_type_Arhz.a(), paramarkm), 8, null, true);
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int j = 1;
    if (paramActionSheetItem == null) {}
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_Arhz.a();
      Object localObject2 = d();
      if ((localObject1 != null) || (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        int k = paramActionSheetItem.action;
        int i;
        if (k == 73)
        {
          arfu.d(this.jdField_a_of_type_Arhw, (FileManagerEntity)localObject1).onClick(null);
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
              arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, m);
              i = j;
            }
          }
          else if (k == 52)
          {
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
            i = j;
            if (bdhb.b(paramActionSheetItem))
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
    azqs.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public boolean a(arkm paramarkm)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
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
        if (paramarkm != null) {
          paramarkm.aE_();
        }
        azqs.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return true;
      }
      if (paramarkm != null) {
        paramarkm.aF_();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
      for (paramarkm = "0";; paramarkm = "-1")
      {
        azqs.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramarkm, "-1", "-1");
        break;
      }
    }
    arhh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, new arlf(this, paramarkm, localTroopInfo, localTroopManager));
    return true;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    int i = d();
    if ((i == 5) || (i == 4))
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
      if ((localFileManagerEntity == null) || (localFileManagerEntity.isZipInnerFile)) {
        return null;
      }
      if (localFileManagerEntity.status == 16) {
        return null;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(arsx.a(2, arfu.d(this.jdField_a_of_type_Arhw, localFileManagerEntity)));
      localArrayList1.add(arsx.a(26, new arln(this, localFileManagerEntity)));
      localArrayList1.add(arsx.a(27, arfu.e(this.jdField_a_of_type_Arhw, localFileManagerEntity)));
      int j = j();
      if ((j != 0) && (this.jdField_a_of_type_Arhw != null) && (this.jdField_a_of_type_Arhw.e()))
      {
        i = 70;
        if (j != 1) {
          break label528;
        }
        i = 70;
      }
      for (;;)
      {
        localArrayList2.add(arsx.a(i, new arlo(this, j)));
        String str2 = d();
        boolean bool1 = arso.b(str2);
        if ((arrr.a(localFileManagerEntity.fileName) == 0) && (bool1)) {
          localArrayList2.add(arsx.a(39, null));
        }
        if (arrr.c(localFileManagerEntity)) {
          localArrayList2.add(arsx.a(6, arfu.b(this.jdField_a_of_type_Arhw, localFileManagerEntity)));
        }
        boolean bool2 = aoxg.a().d();
        long l = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
        String str1 = aoxw.a().c();
        Object localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = baic.jdField_a_of_type_JavaLangString;
        }
        if ((bool2) && (baic.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, (String)localObject)) && (localFileManagerEntity.fileSize <= l))
        {
          localObject = arsx.a(119, arfu.a(localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
          localArrayList2.add(localObject);
        }
        if (arow.a(localFileManagerEntity, bool1))
        {
          localArrayList2.add(arsx.a(122, arfu.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str2)));
          localArrayList2.add(arsx.a(123, arfu.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str2)));
        }
        localObject = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
        if ((localObject != null) && (((bbtn)localObject).jdField_a_of_type_JavaUtilUUID != null) && (e() == 0) && ((bdhb.b(((bbtn)localObject).c)) || (bdhb.b(str2)))) {
          localArrayList2.add(arsx.a(52, new arlc(this)));
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    int k = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity).b;
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
    if (this.jdField_a_of_type_Arhz != null) {
      return this.jdField_a_of_type_Arhz.a().TroopUin;
    }
    return super.b();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Alpa != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del troopObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Alpa);
    }
    if (this.jdField_a_of_type_Bcmt != null) {
      bcmp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcmt);
    }
    this.jdField_a_of_type_Alpa = null;
    this.jdField_a_of_type_Bcmt = null;
    this.jdField_a_of_type_Yui = null;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    String str = d();
    boolean bool = arso.b(str);
    localArrayList1.add(arsx.a(2, arfu.d(this.jdField_a_of_type_Arhw, localFileManagerEntity)));
    localArrayList1.add(arsx.a(26, new arld(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList1.add(arsx.a(27, arfu.e(this.jdField_a_of_type_Arhw, localFileManagerEntity)));
    }
    for (;;)
    {
      if (bool) {
        localArrayList1.add(arsx.a(64, new arle(this)));
      }
      if (bool) {
        localArrayList2.add(arsx.a(39, null));
      }
      if (arrr.c(this.jdField_a_of_type_Arhz.a())) {
        localArrayList1.add(arsx.a(6, arfu.b(this.jdField_a_of_type_Arhw, localFileManagerEntity)));
      }
      if (arow.a(localFileManagerEntity, bool))
      {
        localArrayList2.add(arsx.a(122, arfu.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList2.add(arsx.a(123, arfu.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      b(localArrayList2);
      return new ArrayList[] { localArrayList1, localArrayList2 };
      localArrayList1.add(arsx.a(27, arfu.a(this.jdField_a_of_type_Arhw, str)));
    }
  }
  
  public String f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    StringBuilder localStringBuilder = new StringBuilder(arso.a(c()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131692553));
      localStringBuilder.append(bcnt.a(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  public void f()
  {
    ytu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz.a().TroopUin, this.jdField_a_of_type_Arhz.a().strTroopFilePath, this.jdField_a_of_type_Arhz.a().busId, new arla(this));
    ytu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arhz.a().TroopUin, this.jdField_a_of_type_Arhz.a().busId, this.jdField_a_of_type_Arhz.a().strTroopFilePath, new arli(this));
  }
  
  public int h()
  {
    int i = 2;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    int j = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity).b;
    if ((j == 3) || (j == 2) || (j == 1)) {
      i = 1;
    }
    return i;
  }
  
  public void h()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    super.h();
    if (d() == 4)
    {
      bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new bbtd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localbbtn));
    }
  }
  
  public String i()
  {
    Object localObject = this.jdField_a_of_type_Arhz.a();
    localObject = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if (localObject != null) {
      return ((bbtn)localObject).j;
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
          localObject = this.jdField_a_of_type_Arhz.a();
          localObject = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
        } while (localObject == null);
        if (((((bbtn)localObject).b == 3) || (((bbtn)localObject).b == 2) || (((bbtn)localObject).b == 1)) && (TextUtils.isEmpty(((bbtn)localObject).e)))
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "getColorLabelShowType: troop file is upload, can not add color note.");
          return 0;
        }
      } while ((TextUtils.isEmpty(((bbtn)localObject).e)) && (!bdhb.b(d())));
      if ((this.jdField_a_of_type_Arhw != null) && (this.jdField_a_of_type_Arhw.d())) {
        return 2;
      }
      return 1;
    }
  }
  
  public String k()
  {
    if (a() == 2)
    {
      Object localObject = this.jdField_a_of_type_Arhz.a();
      localObject = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
      if (TextUtils.isEmpty(this.h))
      {
        this.h = (((bbtn)localObject).e + "_" + System.currentTimeMillis());
        QLog.i("TroopFileModel<FileAssistant>", 1, "getContextId: troop video file random contextId: " + this.h);
      }
      return this.h;
    }
    return super.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arkz
 * JD-Core Version:    0.7.0.1
 */