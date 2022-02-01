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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.16;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.7;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.8;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.9;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.utils.FileUtils;
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

public class atxr
  extends atwq
{
  private aahg jdField_a_of_type_Aahg;
  private aahm jdField_a_of_type_Aahm;
  private anrc jdField_a_of_type_Anrc;
  private atxe jdField_a_of_type_Atxe;
  private bgjg jdField_a_of_type_Bgjg;
  private int c;
  private String g;
  private String h = "";
  
  public atxr(QQAppInterface paramQQAppInterface, Activity paramActivity, List<atuz> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 1, "FileBrowserModel init: type = troop");
    }
    a(paramList, paramInt);
  }
  
  private void a(bfjs parambfjs)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new TroopFileModel.7(this, parambfjs));
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, bfjs parambfjs)
  {
    long l = paramFileManagerEntity.lastTime;
    Object localObject = paramFileManagerEntity.selfUin;
    boolean bool1 = paramFileManagerEntity.bSend;
    boolean bool2 = paramFileManagerEntity.isZipInnerFile;
    FileManagerEntity localFileManagerEntity = auea.a(parambfjs);
    paramFileManagerEntity.copyFrom(localFileManagerEntity);
    paramFileManagerEntity.lastTime = l;
    paramFileManagerEntity.selfUin = ((String)localObject);
    paramFileManagerEntity.bSend = bool1;
    paramFileManagerEntity.isZipInnerFile = bool2;
    if ((this.b == 3) && (e() == 2))
    {
      localObject = new SessionInfo();
      ((SessionInfo)localObject).curType = 1;
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("troopfile_shmsgseq");
      bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_multi_aio_msg", false);
      MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMessageRecord(String.valueOf(paramFileManagerEntity.TroopUin), 1, l, -2017);
      Rect localRect = (Rect)this.jdField_a_of_type_AndroidOsBundle.getParcelable("file_browser_params_thumb_bound");
      if ((this.jdField_a_of_type_Atuw != null) && (localMessageRecord != null) && (!bool1))
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.8(this, localMessageRecord, (SessionInfo)localObject, paramFileManagerEntity, parambfjs, localFileManagerEntity, localRect), 100L);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.9(this, localMessageRecord), 300L);
      }
    }
    if (d() == 3) {
      if (this.jdField_a_of_type_Atxg != null) {
        this.jdField_a_of_type_Atxg.f();
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TroopFileModel<FileAssistant>", 2, "file download finished, but file not exist.");
  }
  
  private boolean a(int paramInt, atxe paramatxe)
  {
    if ((paramInt == -133) || (paramInt == -132) || (paramInt == -134))
    {
      paramatxe.c();
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
    if (this.jdField_a_of_type_Aahg == null) {
      this.jdField_a_of_type_Aahg = new atya(this);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Aahm == null) {
      this.jdField_a_of_type_Aahm = new atyb(this);
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
      if (auea.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atuz, false))
      {
        i = j;
        if (auea.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))
        {
          i = 5;
          continue;
          i = 8;
          continue;
          if (!FileUtils.fileExistsAndNotEmpty(d())) {
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
  }
  
  public aqoa a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    bfjs localbfjs = a(localFileManagerEntity);
    if (localbfjs == null)
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file info is null.");
      return new atvj();
    }
    long l = localFileManagerEntity.TroopUin;
    if ((localbfjs.b == 3) || (localbfjs.b == 2) || (localbfjs.b == 1))
    {
      if ((TextUtils.isEmpty(localbfjs.e)) && (FileUtils.fileExistsAndNotEmpty(localbfjs.jdField_a_of_type_JavaLangString)))
      {
        QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload.");
        return new atvl(localbfjs.jdField_a_of_type_JavaLangString);
      }
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload, but local file is not exist.");
      return new atvj();
    }
    return new atvo(l, localbfjs);
  }
  
  public atvp a()
  {
    if (this.jdField_a_of_type_Atvp == null) {
      this.jdField_a_of_type_Atvp = new atyg(this);
    }
    return this.jdField_a_of_type_Atvp;
  }
  
  public atvr a()
  {
    return new atyd(this);
  }
  
  public atvs a()
  {
    if (this.jdField_a_of_type_Atvs == null) {
      this.jdField_a_of_type_Atvs = new atyf(this);
    }
    return this.jdField_a_of_type_Atvs;
  }
  
  public atwc a()
  {
    bfjs localbfjs = a(this.jdField_a_of_type_Atuz.a());
    return new atwc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbfjs);
  }
  
  protected bfjs a(FileManagerEntity paramFileManagerEntity)
  {
    return bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  public List<atxc> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new atvw((atuz)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Anrc != null) {}
    QQAppInterface localQQAppInterface;
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Anrc = new atye(this);
        if (QLog.isDevelopLevel()) {
          QLog.i("fobserver<FileAssistant>", 1, "add troopObserver");
        }
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localQQAppInterface.addObserver(this.jdField_a_of_type_Anrc);
      } while (this.jdField_a_of_type_Bgjg != null);
      localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    } while (localFileManagerEntity == null);
    this.jdField_a_of_type_Bgjg = new bgjg(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bgjc.a(localQQAppInterface, this.jdField_a_of_type_Bgjg);
  }
  
  public void a(atxe paramatxe)
  {
    this.jdField_a_of_type_Atxe = paramatxe;
    p();
    o();
    ThreadManager.post(new TroopFileModel.16(this, paramatxe), 8, null, true);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidOsBundle.getBoolean("file_location_pos_entrance_multiseq", false));
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("FromChatHistoryTab", 0);
      } while (i == 106);
      i = aufd.c(this.b, i);
    } while (i == 0);
    Bundle localBundle = new Bundle();
    localBundle.putInt("file_location_pos_entrance_type", i);
    paramArrayList.add(aufd.a(54, atti.a(this.jdField_a_of_type_AndroidAppActivity, localBundle, paramFileManagerEntity)));
    bdla.b(null, "dc00898", "", "", "0X800B450", "0X800B450", i, 0, "", "", "", "");
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_Atuz.a();
      Object localObject2 = d();
      if ((localObject1 != null) || (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        int j = paramActionSheetItem.action;
        int i;
        if (j == 73)
        {
          atti.d(this.jdField_a_of_type_Atuw, (FileManagerEntity)localObject1).onClick(null);
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
              aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, i);
            }
            i = 1;
          }
          else if (j == 52)
          {
            localObject1 = d();
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
            if (!FileUtils.fileExistsAndNotEmpty((String)localObject1))
            {
              localObject2 = this.jdField_a_of_type_Atuz.a();
              paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
              if (localObject2 != null) {
                paramActionSheetItem = ((FileManagerEntity)localObject2).strLargeThumPath;
              }
            }
            if (FileUtils.fileExistsAndNotEmpty(paramActionSheetItem)) {
              OCRPerformFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramActionSheetItem, 1, -1002, null);
            }
            i = 1;
          }
          else if (j == 132)
          {
            QbSdk.clearDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, d());
            auea.a(this.jdField_a_of_type_AndroidAppActivity, d());
            bdla.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
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
    bdla.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(atxe paramatxe)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
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
        if (paramatxe != null) {
          paramatxe.at_();
        }
        bdla.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return true;
      }
      if (paramatxe != null) {
        paramatxe.au_();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
      for (paramatxe = "0";; paramatxe = "-1")
      {
        bdla.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramatxe, "-1", "-1");
        break;
      }
    }
    atuh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, new atxz(this, paramatxe, localTroopInfo, localTroopManager));
    return true;
  }
  
  protected boolean a(FileManagerEntity paramFileManagerEntity)
  {
    long l = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.fileName);
    Object localObject1 = arnw.a();
    Object localObject2 = arng.a();
    boolean bool;
    if (localObject2 == null)
    {
      bool = false;
      if (localObject1 != null) {
        break label98;
      }
    }
    label98:
    for (localObject1 = "";; localObject1 = ((arnv)localObject1).c())
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = becr.jdField_a_of_type_JavaLangString;
      }
      if ((!bool) || (!becr.a(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject2)) || (paramFileManagerEntity.fileSize > l)) {
        break label108;
      }
      return true;
      bool = ((arnf)localObject2).d();
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
          localObject2 = this.jdField_a_of_type_Atuz.a();
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
    int k = a(this.jdField_a_of_type_Atuz.a()).b;
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
    if (this.jdField_a_of_type_Atuz != null) {
      return this.jdField_a_of_type_Atuz.a().TroopUin;
    }
    return super.b();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Anrc != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del troopObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Anrc);
    }
    if (this.jdField_a_of_type_Bgjg != null) {
      bgjc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgjg);
    }
    this.jdField_a_of_type_Anrc = null;
    this.jdField_a_of_type_Bgjg = null;
    this.jdField_a_of_type_Aahm = null;
    this.jdField_a_of_type_Aahg = null;
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    Object localObject;
    String str;
    if (paramInt == 6)
    {
      localObject = this.jdField_a_of_type_Atuz.a();
      if (localObject != null)
      {
        str = String.valueOf(((FileManagerEntity)localObject).TroopUin);
        if (localObject == null) {
          break label79;
        }
        localObject = auea.b(((FileManagerEntity)localObject).nFileType);
        label45:
        bdla.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str, "", (String)localObject, "1");
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
          bdla.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
          return;
        }
      }
    } while (paramInt != 8);
    bdla.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    String str = d();
    boolean bool = FileUtil.fileExistsAndNotEmpty(str);
    localArrayList1.add(aufd.a(2, atti.d(this.jdField_a_of_type_Atuw, localFileManagerEntity)));
    localArrayList1.add(aufd.a(26, new atxx(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList1.add(aufd.a(27, atti.e(this.jdField_a_of_type_Atuw, localFileManagerEntity)));
    }
    for (;;)
    {
      WXShareHelper localWXShareHelper = WXShareHelper.a();
      if ((bool) && (localWXShareHelper.a()) && (localWXShareHelper.d())) {
        localArrayList1.add(aufd.a(9, atti.b(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      if (bool) {
        localArrayList1.add(aufd.a(64, new atxy(this)));
      }
      if (bool) {
        localArrayList2.add(aufd.a(39, null));
      }
      if (auea.c(this.jdField_a_of_type_Atuz.a())) {
        localArrayList1.add(aufd.a(6, atti.b(this.jdField_a_of_type_Atuw, localFileManagerEntity)));
      }
      if (aukf.a(localFileManagerEntity, bool))
      {
        localArrayList2.add(aufd.a(122, atti.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList2.add(aufd.a(123, atti.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      b(localArrayList2);
      if ((bool) && (a(str)))
      {
        localArrayList2.add(aufd.a(132, null));
        bdla.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
      return new ArrayList[] { localArrayList1, localArrayList2 };
      localArrayList1.add(aufd.a(27, atti.a(this.jdField_a_of_type_Atuw, str)));
    }
  }
  
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> c(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(aufd.a(2, atti.d(this.jdField_a_of_type_Atuw, paramFileManagerEntity)));
    localArrayList.add(aufd.a(26, new atxu(this, paramFileManagerEntity)));
    localArrayList.add(aufd.a(27, atti.e(this.jdField_a_of_type_Atuw, paramFileManagerEntity)));
    return localArrayList;
  }
  
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> d(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    int j = j();
    int i;
    if ((j != 0) && (this.jdField_a_of_type_Atuw != null) && (this.jdField_a_of_type_Atuw.f()))
    {
      i = 70;
      if (j != 1) {
        break label367;
      }
      i = 70;
    }
    for (;;)
    {
      localArrayList.add(aufd.a(i, new atxv(this, j)));
      String str = d();
      boolean bool = FileUtil.fileExistsAndNotEmpty(str);
      if ((auea.a(paramFileManagerEntity.fileName) == 0) && (bool)) {
        localArrayList.add(aufd.a(39, null));
      }
      if (auea.c(paramFileManagerEntity)) {
        localArrayList.add(aufd.a(6, atti.b(this.jdField_a_of_type_Atuw, paramFileManagerEntity)));
      }
      a(paramFileManagerEntity, localArrayList);
      if (a(paramFileManagerEntity))
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = aufd.a(119, atti.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
        localArrayList.add(localActionSheetItem);
      }
      if (aukf.a(paramFileManagerEntity, bool))
      {
        localArrayList.add(aufd.a(122, atti.a(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
        localArrayList.add(aufd.a(123, atti.b(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
      }
      paramFileManagerEntity = a(paramFileManagerEntity);
      if ((paramFileManagerEntity != null) && (paramFileManagerEntity.jdField_a_of_type_JavaUtilUUID != null) && (e() == 0) && ((FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.c)) || (bool))) {
        localArrayList.add(aufd.a(52, new atxw(this)));
      }
      if ((bool) && (a(str)))
      {
        localArrayList.add(aufd.a(132, null));
        bdla.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
      return localArrayList;
      label367:
      if (j == 2) {
        i = 82;
      }
    }
  }
  
  public String f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    StringBuilder localStringBuilder = new StringBuilder(FileUtil.filesizeToString(c()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131692282));
      localStringBuilder.append(bgke.a(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  public void f()
  {
    aagu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atuz.a().TroopUin, this.jdField_a_of_type_Atuz.a().strTroopFilePath, this.jdField_a_of_type_Atuz.a().busId, new atxs(this));
    aagu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atuz.a().TroopUin, this.jdField_a_of_type_Atuz.a().busId, this.jdField_a_of_type_Atuz.a().strTroopFilePath, new atyc(this));
  }
  
  public int h()
  {
    int i = 2;
    int j = a(this.jdField_a_of_type_Atuz.a()).b;
    if ((j == 3) || (j == 2) || (j == 1)) {
      i = 1;
    }
    return i;
  }
  
  public void h()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    super.h();
    if (d() == 4)
    {
      bfjs localbfjs = a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new bfji(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localbfjs));
    }
  }
  
  public String i()
  {
    bfjs localbfjs = a(this.jdField_a_of_type_Atuz.a());
    if (localbfjs != null) {
      return localbfjs.j;
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
      bfjs localbfjs;
      do
      {
        do
        {
          return 0;
          localbfjs = a(this.jdField_a_of_type_Atuz.a());
        } while (localbfjs == null);
        if (((localbfjs.b == 3) || (localbfjs.b == 2) || (localbfjs.b == 1)) && (TextUtils.isEmpty(localbfjs.e)))
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "getColorLabelShowType: troop file is upload, can not add color note.");
          return 0;
        }
      } while ((TextUtils.isEmpty(localbfjs.e)) && (!FileUtils.fileExistsAndNotEmpty(d())));
      if ((this.jdField_a_of_type_Atuw != null) && (this.jdField_a_of_type_Atuw.e())) {
        return 2;
      }
      return 1;
    }
  }
  
  public String j()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkPackageName;
    }
    return "";
  }
  
  public String k()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkName;
    }
    return "";
  }
  
  public String l()
  {
    if (e() == 5)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
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
      bfjs localbfjs = a(this.jdField_a_of_type_Atuz.a());
      if (TextUtils.isEmpty(this.h))
      {
        this.h = (localbfjs.e + "_" + System.currentTimeMillis());
        QLog.i("TroopFileModel<FileAssistant>", 1, "getContextId: troop video file random contextId: " + this.h);
      }
      return this.h;
    }
    return super.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxr
 * JD-Core Version:    0.7.0.1
 */