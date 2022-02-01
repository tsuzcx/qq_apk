import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.16;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.7;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.8;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.9;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsVideo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class auha
  extends aufz
{
  private aavh jdField_a_of_type_Aavh;
  private aavn jdField_a_of_type_Aavn;
  private anua jdField_a_of_type_Anua;
  private augn jdField_a_of_type_Augn;
  private bgrm jdField_a_of_type_Bgrm;
  private int c;
  private String g;
  private String h = "";
  
  public auha(QQAppInterface paramQQAppInterface, Activity paramActivity, List<auei> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 1, "FileBrowserModel init: type = troop");
    }
    a(paramList, paramInt);
  }
  
  private void a(bftf parambftf)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new TroopFileModel.7(this, parambftf));
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, bftf parambftf)
  {
    long l = paramFileManagerEntity.lastTime;
    Object localObject = paramFileManagerEntity.selfUin;
    boolean bool1 = paramFileManagerEntity.bSend;
    boolean bool2 = paramFileManagerEntity.isZipInnerFile;
    FileManagerEntity localFileManagerEntity = aunj.a(parambftf);
    paramFileManagerEntity.copyFrom(localFileManagerEntity);
    paramFileManagerEntity.lastTime = l;
    paramFileManagerEntity.selfUin = ((String)localObject);
    paramFileManagerEntity.bSend = bool1;
    paramFileManagerEntity.isZipInnerFile = bool2;
    if ((this.b == 3) && (e() == 2))
    {
      localObject = new SessionInfo();
      ((SessionInfo)localObject).a = 1;
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("troopfile_shmsgseq");
      bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_multi_aio_msg", false);
      MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramFileManagerEntity.TroopUin), 1, l, -2017);
      Rect localRect = (Rect)this.jdField_a_of_type_AndroidOsBundle.getParcelable("file_browser_params_thumb_bound");
      if ((this.jdField_a_of_type_Auef != null) && (localMessageRecord != null) && (!bool1))
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.8(this, localMessageRecord, (SessionInfo)localObject, paramFileManagerEntity, parambftf, localFileManagerEntity, localRect), 100L);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.9(this, localMessageRecord), 300L);
      }
    }
    if (d() == 3) {
      if (this.jdField_a_of_type_Augp != null) {
        this.jdField_a_of_type_Augp.f();
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TroopFileModel<FileAssistant>", 2, "file download finished, but file not exist.");
  }
  
  private boolean a(int paramInt, augn paramaugn)
  {
    if ((paramInt == -133) || (paramInt == -132) || (paramInt == -134))
    {
      paramaugn.c();
      if (QLog.isDevelopLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 4, "file invalidate retCode = " + paramInt);
      }
    }
    do
    {
      return true;
      if ((paramInt != -103) && (paramInt != -301)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("TroopFileModel<FileAssistant>", 4, "file invalidate retCode = " + paramInt);
    return true;
    return false;
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Aavh == null) {
      this.jdField_a_of_type_Aavh = new auhj(this);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Aavn == null) {
      this.jdField_a_of_type_Aavn = new auhk(this);
    }
  }
  
  public int a()
  {
    int j = 7;
    int m = e();
    int k = super.a();
    if ((this.b == 3) && (m == 2) && (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_multi_aio_msg", false))) {
      return 8;
    }
    if (k != 0) {
      return k;
    }
    int i = j;
    switch (m)
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
      if (aunj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auei, false))
      {
        i = j;
        if (aunj.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))
        {
          i = 5;
          continue;
          i = 8;
          continue;
          if (!bhmi.b(d())) {
            i = 11;
          } else {
            i = k;
          }
        }
      }
    }
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
  }
  
  public aqrn a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    bftf localbftf = a(localFileManagerEntity);
    if (localbftf == null)
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file info is null.");
      return new aues();
    }
    long l = localFileManagerEntity.TroopUin;
    if ((localbftf.b == 3) || (localbftf.b == 2) || (localbftf.b == 1))
    {
      if ((TextUtils.isEmpty(localbftf.e)) && (bhmi.b(localbftf.jdField_a_of_type_JavaLangString)))
      {
        QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload.");
        return new aueu(localbftf.jdField_a_of_type_JavaLangString);
      }
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload, but local file is not exist.");
      return new aues();
    }
    return new auex(l, localbftf);
  }
  
  public auey a()
  {
    if (this.jdField_a_of_type_Auey == null) {
      this.jdField_a_of_type_Auey = new auhp(this);
    }
    return this.jdField_a_of_type_Auey;
  }
  
  public aufa a()
  {
    return new auhm(this);
  }
  
  public aufb a()
  {
    if (this.jdField_a_of_type_Aufb == null) {
      this.jdField_a_of_type_Aufb = new auho(this);
    }
    return this.jdField_a_of_type_Aufb;
  }
  
  public aufl a()
  {
    bftf localbftf = a(this.jdField_a_of_type_Auei.a());
    return new aufl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbftf);
  }
  
  protected bftf a(FileManagerEntity paramFileManagerEntity)
  {
    return bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  public List<augl> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new auff((auei)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Anua != null) {}
    QQAppInterface localQQAppInterface;
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Anua = new auhn(this);
        if (QLog.isDevelopLevel()) {
          QLog.i("fobserver<FileAssistant>", 1, "add troopObserver");
        }
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localQQAppInterface.addObserver(this.jdField_a_of_type_Anua);
      } while (this.jdField_a_of_type_Bgrm != null);
      localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    } while (localFileManagerEntity == null);
    this.jdField_a_of_type_Bgrm = new bgrm(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bgri.a(localQQAppInterface, this.jdField_a_of_type_Bgrm);
  }
  
  public void a(augn paramaugn)
  {
    this.jdField_a_of_type_Augn = paramaugn;
    p();
    o();
    ThreadManager.post(new TroopFileModel.16(this, paramaugn), 8, null, true);
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_Auei.a();
      Object localObject2 = d();
      if ((localObject1 != null) || (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        int j = paramActionSheetItem.action;
        int i;
        if (j == 73)
        {
          aucs.d(this.jdField_a_of_type_Auef, (FileManagerEntity)localObject1).onClick(null);
          i = 1;
        }
        while (i != 0)
        {
          f(j);
          return;
          if (j == 72)
          {
            i = paramActionSheetItem.uinType;
            paramActionSheetItem = paramActionSheetItem.uin;
            if (!TextUtils.isEmpty(paramActionSheetItem)) {
              auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, i);
            }
            i = 1;
          }
          else if (j == 52)
          {
            localObject1 = d();
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
            if (!bhmi.b((String)localObject1))
            {
              localObject2 = this.jdField_a_of_type_Auei.a();
              paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
              if (localObject2 != null) {
                paramActionSheetItem = ((FileManagerEntity)localObject2).strLargeThumPath;
              }
            }
            if (bhmi.b(paramActionSheetItem)) {
              OCRPerformFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramActionSheetItem, 1, -1002, null);
            }
            i = 1;
          }
          else if (j == 132)
          {
            QbSdk.clearDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, d());
            aunj.a(this.jdField_a_of_type_AndroidAppActivity, d());
            bdll.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
            i = 1;
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
    bdll.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(augn paramaugn)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
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
        if (paramaugn != null) {
          paramaugn.aC_();
        }
        bdll.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return true;
      }
      if (paramaugn != null) {
        paramaugn.aD_();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
      for (paramaugn = "0";; paramaugn = "-1")
      {
        bdll.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramaugn, "-1", "-1");
        break;
      }
    }
    audq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, new auhi(this, paramaugn, localTroopInfo, localTroopManager));
    return true;
  }
  
  protected boolean a(FileManagerEntity paramFileManagerEntity)
  {
    long l = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.fileName);
    Object localObject1 = arqn.a();
    Object localObject2 = arpx.a();
    boolean bool;
    if (localObject2 == null)
    {
      bool = false;
      if (localObject1 != null) {
        break label98;
      }
    }
    label98:
    for (localObject1 = "";; localObject1 = ((arqm)localObject1).c())
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = becb.jdField_a_of_type_JavaLangString;
      }
      if ((!bool) || (!becb.a(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject2)) || (paramFileManagerEntity.fileSize > l)) {
        break label108;
      }
      return true;
      bool = ((arpw)localObject2).d();
      break;
    }
    label108:
    return false;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList1 = null;
    int i = d();
    if ((i != 5) && (i != 4)) {
      localObject1 = super.a();
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject2 = this.jdField_a_of_type_Auei.a();
          localObject1 = localArrayList1;
        } while (localObject2 == null);
        localObject1 = localArrayList1;
      } while (((FileManagerEntity)localObject2).isZipInnerFile);
      localObject1 = localArrayList1;
    } while (((FileManagerEntity)localObject2).status == 16);
    Object localObject1 = c((FileManagerEntity)localObject2);
    localArrayList1 = d((FileManagerEntity)localObject2);
    Object localObject2 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
      ((ArrayList)localObject2).addAll((Collection)localObject1);
    }
    if ((localArrayList1 != null) && (!localArrayList1.isEmpty())) {
      localArrayList2.addAll(localArrayList1);
    }
    return new ArrayList[] { localObject2, localArrayList2 };
  }
  
  public int b()
  {
    int j = 1;
    int k = a(this.jdField_a_of_type_Auei.a()).b;
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
    if (this.jdField_a_of_type_Auei != null) {
      return this.jdField_a_of_type_Auei.a().TroopUin;
    }
    return super.b();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Anua != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del troopObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Anua);
    }
    if (this.jdField_a_of_type_Bgrm != null) {
      bgri.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgrm);
    }
    this.jdField_a_of_type_Anua = null;
    this.jdField_a_of_type_Bgrm = null;
    this.jdField_a_of_type_Aavn = null;
    this.jdField_a_of_type_Aavh = null;
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    Object localObject;
    String str;
    if (paramInt == 6)
    {
      localObject = this.jdField_a_of_type_Auei.a();
      if (localObject != null)
      {
        str = String.valueOf(((FileManagerEntity)localObject).TroopUin);
        if (localObject == null) {
          break label79;
        }
        localObject = aunj.b(((FileManagerEntity)localObject).nFileType);
        label45:
        bdll.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str, "", (String)localObject, "1");
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
          bdll.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
          return;
        }
      }
    } while (paramInt != 8);
    bdll.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    String str = d();
    boolean bool = auog.b(str);
    localArrayList1.add(auoo.a(2, aucs.d(this.jdField_a_of_type_Auef, localFileManagerEntity)));
    localArrayList1.add(auoo.a(26, new auhg(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList1.add(auoo.a(27, aucs.e(this.jdField_a_of_type_Auef, localFileManagerEntity)));
    }
    for (;;)
    {
      WXShareHelper localWXShareHelper = WXShareHelper.a();
      if ((bool) && (localWXShareHelper.a()) && (localWXShareHelper.d())) {
        localArrayList1.add(auoo.a(9, aucs.b(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      if (bool) {
        localArrayList1.add(auoo.a(64, new auhh(this)));
      }
      if (bool) {
        localArrayList2.add(auoo.a(39, null));
      }
      if (aunj.c(this.jdField_a_of_type_Auei.a())) {
        localArrayList1.add(auoo.a(6, aucs.b(this.jdField_a_of_type_Auef, localFileManagerEntity)));
      }
      if (autq.a(localFileManagerEntity, bool))
      {
        localArrayList2.add(auoo.a(122, aucs.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList2.add(auoo.a(123, aucs.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      b(localArrayList2);
      if ((bool) && (a(str)))
      {
        localArrayList2.add(auoo.a(132, null));
        bdll.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
      return new ArrayList[] { localArrayList1, localArrayList2 };
      localArrayList1.add(auoo.a(27, aucs.a(this.jdField_a_of_type_Auef, str)));
    }
  }
  
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> c(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(auoo.a(2, aucs.d(this.jdField_a_of_type_Auef, paramFileManagerEntity)));
    localArrayList.add(auoo.a(26, new auhd(this, paramFileManagerEntity)));
    localArrayList.add(auoo.a(27, aucs.e(this.jdField_a_of_type_Auef, paramFileManagerEntity)));
    return localArrayList;
  }
  
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> d(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    int j = j();
    int i;
    if ((j != 0) && (this.jdField_a_of_type_Auef != null) && (this.jdField_a_of_type_Auef.f()))
    {
      i = 70;
      if (j != 1) {
        break label360;
      }
      i = 70;
    }
    for (;;)
    {
      localArrayList.add(auoo.a(i, new auhe(this, j)));
      String str = d();
      boolean bool = auog.b(str);
      if ((aunj.a(paramFileManagerEntity.fileName) == 0) && (bool)) {
        localArrayList.add(auoo.a(39, null));
      }
      if (aunj.c(paramFileManagerEntity)) {
        localArrayList.add(auoo.a(6, aucs.b(this.jdField_a_of_type_Auef, paramFileManagerEntity)));
      }
      if (a(paramFileManagerEntity))
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = auoo.a(119, aucs.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
        localArrayList.add(localActionSheetItem);
      }
      if (autq.a(paramFileManagerEntity, bool))
      {
        localArrayList.add(auoo.a(122, aucs.a(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
        localArrayList.add(auoo.a(123, aucs.b(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
      }
      paramFileManagerEntity = a(paramFileManagerEntity);
      if ((paramFileManagerEntity != null) && (paramFileManagerEntity.jdField_a_of_type_JavaUtilUUID != null) && (e() == 0) && ((bhmi.b(paramFileManagerEntity.c)) || (bool))) {
        localArrayList.add(auoo.a(52, new auhf(this)));
      }
      if ((bool) && (a(str)))
      {
        localArrayList.add(auoo.a(132, null));
        bdll.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
      return localArrayList;
      label360:
      if (j == 2) {
        i = 82;
      }
    }
  }
  
  public String f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    StringBuilder localStringBuilder = new StringBuilder(auog.a(c()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131692144));
      localStringBuilder.append(bgsk.a(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  public void f()
  {
    aauw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auei.a().TroopUin, this.jdField_a_of_type_Auei.a().strTroopFilePath, this.jdField_a_of_type_Auei.a().busId, new auhb(this));
    aauw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auei.a().TroopUin, this.jdField_a_of_type_Auei.a().busId, this.jdField_a_of_type_Auei.a().strTroopFilePath, new auhl(this));
  }
  
  public int h()
  {
    int i = 2;
    int j = a(this.jdField_a_of_type_Auei.a()).b;
    if ((j == 3) || (j == 2) || (j == 1)) {
      i = 1;
    }
    return i;
  }
  
  public void h()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    super.h();
    if (d() == 4)
    {
      bftf localbftf = a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new bfsv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localbftf));
    }
  }
  
  public String i()
  {
    bftf localbftf = a(this.jdField_a_of_type_Auei.a());
    if (localbftf != null) {
      return localbftf.j;
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
      bftf localbftf;
      do
      {
        do
        {
          return 0;
          localbftf = a(this.jdField_a_of_type_Auei.a());
        } while (localbftf == null);
        if (((localbftf.b == 3) || (localbftf.b == 2) || (localbftf.b == 1)) && (TextUtils.isEmpty(localbftf.e)))
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "getColorLabelShowType: troop file is upload, can not add color note.");
          return 0;
        }
      } while ((TextUtils.isEmpty(localbftf.e)) && (!bhmi.b(d())));
      if ((this.jdField_a_of_type_Auef != null) && (this.jdField_a_of_type_Auef.e())) {
        return 2;
      }
      return 1;
    }
  }
  
  public String j()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkPackageName;
    }
    return "";
  }
  
  public String k()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkName;
    }
    return "";
  }
  
  public String l()
  {
    if (e() == 5)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Auei.a();
      if (localFileManagerEntity != null) {
        return localFileManagerEntity.yybApkIconUrl;
      }
    }
    return "";
  }
  
  public String n()
  {
    if (a() == 2)
    {
      bftf localbftf = a(this.jdField_a_of_type_Auei.a());
      if (TextUtils.isEmpty(this.h))
      {
        this.h = (localbftf.e + "_" + System.currentTimeMillis());
        QLog.i("TroopFileModel<FileAssistant>", 1, "getContextId: troop video file random contextId: " + this.h);
      }
      return this.h;
    }
    return super.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auha
 * JD-Core Version:    0.7.0.1
 */