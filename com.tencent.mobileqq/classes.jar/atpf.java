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

public class atpf
  extends atoe
{
  private aare jdField_a_of_type_Aare;
  private aark jdField_a_of_type_Aark;
  private anif jdField_a_of_type_Anif;
  private atos jdField_a_of_type_Atos;
  private bfrl jdField_a_of_type_Bfrl;
  private int c;
  private String g;
  private String h = "";
  
  public atpf(QQAppInterface paramQQAppInterface, Activity paramActivity, List<atmn> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 1, "FileBrowserModel init: type = troop");
    }
    a(paramList, paramInt);
  }
  
  private void a(bety parambety)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new TroopFileModel.7(this, parambety));
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, bety parambety)
  {
    long l = paramFileManagerEntity.lastTime;
    Object localObject = paramFileManagerEntity.selfUin;
    boolean bool1 = paramFileManagerEntity.bSend;
    boolean bool2 = paramFileManagerEntity.isZipInnerFile;
    FileManagerEntity localFileManagerEntity = atvo.a(parambety);
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
      if ((this.jdField_a_of_type_Atmk != null) && (localMessageRecord != null) && (!bool1))
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.8(this, localMessageRecord, (SessionInfo)localObject, paramFileManagerEntity, parambety, localFileManagerEntity, localRect), 100L);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.9(this, localMessageRecord), 300L);
      }
    }
    if (d() == 3) {
      if (this.jdField_a_of_type_Atou != null) {
        this.jdField_a_of_type_Atou.f();
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TroopFileModel<FileAssistant>", 2, "file download finished, but file not exist.");
  }
  
  private boolean a(int paramInt, atos paramatos)
  {
    if ((paramInt == -133) || (paramInt == -132) || (paramInt == -134))
    {
      paramatos.c();
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
    if (this.jdField_a_of_type_Aare == null) {
      this.jdField_a_of_type_Aare = new atpo(this);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Aark == null) {
      this.jdField_a_of_type_Aark = new atpp(this);
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
      if (atvo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atmn, false))
      {
        i = j;
        if (atvo.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))
        {
          i = 5;
          continue;
          i = 8;
          continue;
          if (!bgmg.b(d())) {
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
  }
  
  public aqck a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    bety localbety = a(localFileManagerEntity);
    if (localbety == null)
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file info is null.");
      return new atmx();
    }
    long l = localFileManagerEntity.TroopUin;
    if ((localbety.b == 3) || (localbety.b == 2) || (localbety.b == 1))
    {
      if ((TextUtils.isEmpty(localbety.e)) && (bgmg.b(localbety.jdField_a_of_type_JavaLangString)))
      {
        QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload.");
        return new atmz(localbety.jdField_a_of_type_JavaLangString);
      }
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload, but local file is not exist.");
      return new atmx();
    }
    return new atnc(l, localbety);
  }
  
  public atnd a()
  {
    if (this.jdField_a_of_type_Atnd == null) {
      this.jdField_a_of_type_Atnd = new atpu(this);
    }
    return this.jdField_a_of_type_Atnd;
  }
  
  public atnf a()
  {
    return new atpr(this);
  }
  
  public atng a()
  {
    if (this.jdField_a_of_type_Atng == null) {
      this.jdField_a_of_type_Atng = new atpt(this);
    }
    return this.jdField_a_of_type_Atng;
  }
  
  public atnq a()
  {
    bety localbety = a(this.jdField_a_of_type_Atmn.a());
    return new atnq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbety);
  }
  
  protected bety a(FileManagerEntity paramFileManagerEntity)
  {
    return bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  public List<atoq> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new atnk((atmn)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Anif != null) {}
    QQAppInterface localQQAppInterface;
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Anif = new atps(this);
        if (QLog.isDevelopLevel()) {
          QLog.i("fobserver<FileAssistant>", 1, "add troopObserver");
        }
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localQQAppInterface.addObserver(this.jdField_a_of_type_Anif);
      } while (this.jdField_a_of_type_Bfrl != null);
      localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    } while (localFileManagerEntity == null);
    this.jdField_a_of_type_Bfrl = new bfrl(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bfrh.a(localQQAppInterface, this.jdField_a_of_type_Bfrl);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject;
    String str;
    if (paramInt == 6)
    {
      localObject = this.jdField_a_of_type_Atmn.a();
      if (localObject != null)
      {
        str = String.valueOf(((FileManagerEntity)localObject).TroopUin);
        if (localObject == null) {
          break label79;
        }
        localObject = atvo.b(((FileManagerEntity)localObject).nFileType);
        label45:
        bcst.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str, "", (String)localObject, "1");
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
          bcst.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
          return;
        }
      }
    } while (paramInt != 8);
    bcst.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
  }
  
  public void a(atos paramatos)
  {
    this.jdField_a_of_type_Atos = paramatos;
    p();
    o();
    ThreadManager.post(new TroopFileModel.16(this, paramatos), 8, null, true);
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_Atmn.a();
      Object localObject2 = d();
      if ((localObject1 != null) || (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        int j = paramActionSheetItem.action;
        int i;
        if (j == 73)
        {
          atky.d(this.jdField_a_of_type_Atmk, (FileManagerEntity)localObject1).onClick(null);
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
              atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, i);
            }
            i = 1;
          }
          else if (j == 52)
          {
            localObject1 = d();
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
            if (!bgmg.b((String)localObject1))
            {
              localObject2 = this.jdField_a_of_type_Atmn.a();
              paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
              if (localObject2 != null) {
                paramActionSheetItem = ((FileManagerEntity)localObject2).strLargeThumPath;
              }
            }
            if (bgmg.b(paramActionSheetItem)) {
              OCRPerformFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramActionSheetItem, 1, -1002, null);
            }
            i = 1;
          }
          else if (j == 132)
          {
            QbSdk.clearDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, d());
            atvo.a(this.jdField_a_of_type_AndroidAppActivity, d());
            bcst.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
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
    bcst.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(atos paramatos)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
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
        if (paramatos != null) {
          paramatos.aC_();
        }
        bcst.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return true;
      }
      if (paramatos != null) {
        paramatos.aD_();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
      for (paramatos = "0";; paramatos = "-1")
      {
        bcst.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramatos, "-1", "-1");
        break;
      }
    }
    atlv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, new atpn(this, paramatos, localTroopInfo, localTroopManager));
    return true;
  }
  
  protected boolean a(FileManagerEntity paramFileManagerEntity)
  {
    long l = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.fileName);
    Object localObject1 = araw.a();
    Object localObject2 = arag.a();
    boolean bool;
    if (localObject2 == null)
    {
      bool = false;
      if (localObject1 != null) {
        break label98;
      }
    }
    label98:
    for (localObject1 = "";; localObject1 = ((arav)localObject1).c())
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = bdjg.jdField_a_of_type_JavaLangString;
      }
      if ((!bool) || (!bdjg.a(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject2)) || (paramFileManagerEntity.fileSize > l)) {
        break label108;
      }
      return true;
      bool = ((araf)localObject2).d();
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
          localObject2 = this.jdField_a_of_type_Atmn.a();
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
    int k = a(this.jdField_a_of_type_Atmn.a()).b;
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
    if (this.jdField_a_of_type_Atmn != null) {
      return this.jdField_a_of_type_Atmn.a().TroopUin;
    }
    return super.b();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Anif != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del troopObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Anif);
    }
    if (this.jdField_a_of_type_Bfrl != null) {
      bfrh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfrl);
    }
    this.jdField_a_of_type_Anif = null;
    this.jdField_a_of_type_Bfrl = null;
    this.jdField_a_of_type_Aark = null;
    this.jdField_a_of_type_Aare = null;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    String str = d();
    boolean bool = atwl.b(str);
    localArrayList1.add(atwt.a(2, atky.d(this.jdField_a_of_type_Atmk, localFileManagerEntity)));
    localArrayList1.add(atwt.a(26, new atpl(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList1.add(atwt.a(27, atky.e(this.jdField_a_of_type_Atmk, localFileManagerEntity)));
    }
    for (;;)
    {
      WXShareHelper localWXShareHelper = WXShareHelper.a();
      if ((bool) && (localWXShareHelper.a()) && (localWXShareHelper.d())) {
        localArrayList1.add(atwt.a(9, atky.b(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      if (bool) {
        localArrayList1.add(atwt.a(64, new atpm(this)));
      }
      if (bool) {
        localArrayList2.add(atwt.a(39, null));
      }
      if (atvo.c(this.jdField_a_of_type_Atmn.a())) {
        localArrayList1.add(atwt.a(6, atky.b(this.jdField_a_of_type_Atmk, localFileManagerEntity)));
      }
      if (aubv.a(localFileManagerEntity, bool))
      {
        localArrayList2.add(atwt.a(122, atky.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList2.add(atwt.a(123, atky.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      b(localArrayList2);
      if ((bool) && (a(str)))
      {
        localArrayList2.add(atwt.a(132, null));
        bcst.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
      return new ArrayList[] { localArrayList1, localArrayList2 };
      localArrayList1.add(atwt.a(27, atky.a(this.jdField_a_of_type_Atmk, str)));
    }
  }
  
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> c(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(atwt.a(2, atky.d(this.jdField_a_of_type_Atmk, paramFileManagerEntity)));
    localArrayList.add(atwt.a(26, new atpi(this, paramFileManagerEntity)));
    localArrayList.add(atwt.a(27, atky.e(this.jdField_a_of_type_Atmk, paramFileManagerEntity)));
    return localArrayList;
  }
  
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> d(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    int j = j();
    int i;
    if ((j != 0) && (this.jdField_a_of_type_Atmk != null) && (this.jdField_a_of_type_Atmk.f()))
    {
      i = 70;
      if (j != 1) {
        break label360;
      }
      i = 70;
    }
    for (;;)
    {
      localArrayList.add(atwt.a(i, new atpj(this, j)));
      String str = d();
      boolean bool = atwl.b(str);
      if ((atvo.a(paramFileManagerEntity.fileName) == 0) && (bool)) {
        localArrayList.add(atwt.a(39, null));
      }
      if (atvo.c(paramFileManagerEntity)) {
        localArrayList.add(atwt.a(6, atky.b(this.jdField_a_of_type_Atmk, paramFileManagerEntity)));
      }
      if (a(paramFileManagerEntity))
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = atwt.a(119, atky.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
        localArrayList.add(localActionSheetItem);
      }
      if (aubv.a(paramFileManagerEntity, bool))
      {
        localArrayList.add(atwt.a(122, atky.a(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
        localArrayList.add(atwt.a(123, atky.b(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
      }
      paramFileManagerEntity = a(paramFileManagerEntity);
      if ((paramFileManagerEntity != null) && (paramFileManagerEntity.jdField_a_of_type_JavaUtilUUID != null) && (e() == 0) && ((bgmg.b(paramFileManagerEntity.c)) || (bool))) {
        localArrayList.add(atwt.a(52, new atpk(this)));
      }
      if ((bool) && (a(str)))
      {
        localArrayList.add(atwt.a(132, null));
        bcst.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    StringBuilder localStringBuilder = new StringBuilder(atwl.a(c()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131692139));
      localStringBuilder.append(bfsj.a(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  public void f()
  {
    aaqt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atmn.a().TroopUin, this.jdField_a_of_type_Atmn.a().strTroopFilePath, this.jdField_a_of_type_Atmn.a().busId, new atpg(this));
    aaqt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atmn.a().TroopUin, this.jdField_a_of_type_Atmn.a().busId, this.jdField_a_of_type_Atmn.a().strTroopFilePath, new atpq(this));
  }
  
  public int h()
  {
    int i = 2;
    int j = a(this.jdField_a_of_type_Atmn.a()).b;
    if ((j == 3) || (j == 2) || (j == 1)) {
      i = 1;
    }
    return i;
  }
  
  public void h()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    super.h();
    if (d() == 4)
    {
      bety localbety = a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new beto(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localbety));
    }
  }
  
  public String i()
  {
    bety localbety = a(this.jdField_a_of_type_Atmn.a());
    if (localbety != null) {
      return localbety.j;
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
      bety localbety;
      do
      {
        do
        {
          return 0;
          localbety = a(this.jdField_a_of_type_Atmn.a());
        } while (localbety == null);
        if (((localbety.b == 3) || (localbety.b == 2) || (localbety.b == 1)) && (TextUtils.isEmpty(localbety.e)))
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "getColorLabelShowType: troop file is upload, can not add color note.");
          return 0;
        }
      } while ((TextUtils.isEmpty(localbety.e)) && (!bgmg.b(d())));
      if ((this.jdField_a_of_type_Atmk != null) && (this.jdField_a_of_type_Atmk.e())) {
        return 2;
      }
      return 1;
    }
  }
  
  public String j()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkPackageName;
    }
    return "";
  }
  
  public String k()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkName;
    }
    return "";
  }
  
  public String l()
  {
    if (e() == 5)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atmn.a();
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
      bety localbety = a(this.jdField_a_of_type_Atmn.a());
      if (TextUtils.isEmpty(this.h))
      {
        this.h = (localbety.e + "_" + System.currentTimeMillis());
        QLog.i("TroopFileModel<FileAssistant>", 1, "getContextId: troop video file random contextId: " + this.h);
      }
      return this.h;
    }
    return super.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpf
 * JD-Core Version:    0.7.0.1
 */