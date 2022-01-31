import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.1;
import com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.3;
import com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aoye
  extends aoym
{
  private MessageForFile jdField_a_of_type_ComTencentMobileqqDataMessageForFile;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private boolean b = true;
  private boolean c;
  
  public aoye(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private List<Integer> a()
  {
    FileManagerEntity localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    long l;
    int j;
    int i;
    if ((16 != localFileManagerEntity.status) && (localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)))
    {
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        localArrayList.add(Integer.valueOf(9));
      }
      if (this.b)
      {
        this.c = anbl.a().c();
        this.b = false;
      }
      localObject = ancb.a().c();
      l = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
      if ((this.c) && (localFileManagerEntity != null) && (ayfv.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, (String)localObject)))
      {
        j = 0;
        if (localFileManagerEntity.status == 16) {
          break label477;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) && (localFileManagerEntity.fileSize <= l))
      {
        localArrayList.add(Integer.valueOf(21));
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
      }
      if (actn.a(5) == 1) {
        localArrayList.add(Integer.valueOf(17));
      }
      localArrayList.add(Integer.valueOf(23));
      localArrayList.add(Integer.valueOf(10));
      if (QLog.isColorLevel()) {
        QLog.i("msgrevoke", 2, "FileMenuitem entity.status:" + localFileManagerEntity.status);
      }
      if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && (localFileManagerEntity.nOpType == 1))) {
        localArrayList.add(Integer.valueOf(14));
      }
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
        localArrayList.add(Integer.valueOf(19));
      }
      if ((localFileManagerEntity.getCloudType() != 1) || (localFileManagerEntity.status != 2)) {
        localArrayList.add(Integer.valueOf(15));
      }
      localArrayList.add(Integer.valueOf(16));
      if (16 != localFileManagerEntity.status) {
        localArrayList.add(Integer.valueOf(11));
      }
      localArrayList.add(Integer.valueOf(18));
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
        localArrayList.add(Integer.valueOf(20));
      }
      return localArrayList;
      label477:
      i = j;
      if (!TextUtils.isEmpty(localFileManagerEntity.strFilePath))
      {
        localObject = new VFSFile(localFileManagerEntity.strFilePath);
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((VFSFile)localObject).exists()) {
            i = 1;
          }
        }
      }
    }
  }
  
  private void a(View paramView)
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!apue.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
        if (localFileManagerEntity == null)
        {
          QLog.e("OfflineFileBubbleModel", 1, "get Entity by Msg faild!");
          return;
        }
      } while (localFileManagerEntity.status == 16);
      if (apvk.a(localFileManagerEntity)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    if ((localFileManagerEntity.sendCloudUnsuccessful()) && (!apvb.b(localFileManagerEntity.getFilePath())))
    {
      aptv.a(ajyc.a(2131704577));
      return;
    }
    apud localapud = new apud();
    localapud.b = "file_viewer_in";
    localapud.jdField_a_of_type_Int = 9;
    localapud.c = apvb.a(localFileManagerEntity.fileName);
    localapud.d = apue.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
    apuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localapud);
    apuc.a("0X8004AE3");
    QLog.i("OfflineFileBubbleModel", 1, "handle item click: file peerType[" + localFileManagerEntity.peerType + "]");
    if (localFileManagerEntity.peerType == 0) {}
    for (;;)
    {
      paramView = xpx.a(paramView);
      apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, paramView, i, 10004, localFileManagerEntity, false, false);
      return;
      if (localFileManagerEntity.peerType == 3000) {
        i = 5;
      }
    }
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFileManagerEntity != null) {
      if (paramFileManagerEntity.nOpType != 24)
      {
        bool1 = bool2;
        if (paramFileManagerEntity.nOpType != 25) {}
      }
      else if (paramFileManagerEntity.status != 2)
      {
        bool1 = bool2;
        if (paramFileManagerEntity.status != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private List<Integer> b()
  {
    FileManagerEntity localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSendFromLocal()) && (localFileManagerEntity.status == 2)) {
      localArrayList.add(Integer.valueOf(6));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(18));
      return localArrayList;
      if (!apuw.a(localFileManagerEntity))
      {
        localArrayList.add(Integer.valueOf(10));
        if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)))
        {
          if (!localFileManagerEntity.sendCloudUnsuccessful()) {
            localArrayList.add(Integer.valueOf(9));
          }
          localArrayList.add(Integer.valueOf(17));
        }
        localArrayList.add(Integer.valueOf(11));
      }
      if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && (localFileManagerEntity.nOpType == 1))) {
        localArrayList.add(Integer.valueOf(14));
      }
      localArrayList.add(Integer.valueOf(16));
      if ((localFileManagerEntity.getCloudType() != 1) || (localFileManagerEntity.status != 2)) {
        localArrayList.add(Integer.valueOf(15));
      }
    }
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!apue.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    } while ((localFileManagerEntity.status == 16) && (!apue.e(localFileManagerEntity)));
    paramView = xpx.a(paramView);
    apvk.a(this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, false);
  }
  
  private List<Integer> c()
  {
    FileManagerEntity localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    ArrayList localArrayList = new ArrayList();
    if (localFileManagerEntity.status != 16) {
      localArrayList.add(Integer.valueOf(12));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSendFromLocal()) && (localFileManagerEntity.status == 2)) {
      localArrayList.add(Integer.valueOf(6));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(18));
      return localArrayList;
      if (localFileManagerEntity.status != 16)
      {
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          localArrayList.add(Integer.valueOf(9));
        }
        localArrayList.add(Integer.valueOf(10));
        if (apue.c(localFileManagerEntity)) {
          localArrayList.add(Integer.valueOf(17));
        }
        if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && ((localFileManagerEntity.nOpType == 1) || (localFileManagerEntity.nOpType == 8)))) {
          localArrayList.add(Integer.valueOf(14));
        }
      }
      localArrayList.add(Integer.valueOf(16));
      if (localFileManagerEntity.status != 16) {
        localArrayList.add(Integer.valueOf(11));
      }
      if ((localFileManagerEntity.getCloudType() != 1) || (localFileManagerEntity.status != 2)) {
        localArrayList.add(Integer.valueOf(15));
      }
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!apue.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      if (apvk.a((FileManagerEntity)localObject2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    Object localObject1 = new apud();
    ((apud)localObject1).b = "file_viewer_in";
    ((apud)localObject1).jdField_a_of_type_Int = 9;
    ((apud)localObject1).c = apvb.a(((FileManagerEntity)localObject2).fileName);
    ((apud)localObject1).d = apue.a(((FileManagerEntity)localObject2).getCloudType(), ((FileManagerEntity)localObject2).peerType);
    apuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apud)localObject1);
    apuc.a("0X8004AE3");
    if (bgta.a().a((FileManagerEntity)localObject2))
    {
      bgta.a().a(this.jdField_a_of_type_AndroidContentContext, ((FileManagerEntity)localObject2).strFilePath, true);
      return;
    }
    if ((((FileManagerEntity)localObject2).TroopUin != 0L) && (!TextUtils.isEmpty(((FileManagerEntity)localObject2).strTroopFileID)) && (!TextUtils.isEmpty(((FileManagerEntity)localObject2).strTroopFilePath)))
    {
      localObject1 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject1).b(((FileManagerEntity)localObject2).nSessionId);
      ((ForwardFileInfo)localObject1).d(4);
      ((ForwardFileInfo)localObject1).b(10006);
      ((ForwardFileInfo)localObject1).a(((FileManagerEntity)localObject2).getFilePath());
      ((ForwardFileInfo)localObject1).d(((FileManagerEntity)localObject2).fileName);
      ((ForwardFileInfo)localObject1).d(((FileManagerEntity)localObject2).fileSize);
      ((ForwardFileInfo)localObject1).a(((FileManagerEntity)localObject2).TroopUin);
      localObject2 = (Activity)this.jdField_a_of_type_AndroidContentContext;
      Intent localIntent = new Intent((Context)localObject2, TroopFileDetailBrowserActivity.class);
      localIntent.putExtra("fileinfo", (Parcelable)localObject1);
      localIntent.putExtra("removemementity", true);
      localIntent.putExtra("forward_from_troop_file", true);
      localIntent.putExtra("not_forward", true);
      ((Activity)localObject2).startActivityForResult(localIntent, 102);
      return;
    }
    int i = 0;
    if (((FileManagerEntity)localObject2).peerType == 0) {
      i = 1;
    }
    for (;;)
    {
      localObject1 = new apoe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject2, 10004);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("file_browser_extra_params_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((apoe)localObject1).a((Bundle)localObject2);
      localObject1 = new apog(this.jdField_a_of_type_AndroidContentContext, (apoj)localObject1);
      ((apog)localObject1).a(i);
      ((apog)localObject1).a();
      return;
      if (((FileManagerEntity)localObject2).peerType == 3000) {
        i = 5;
      }
    }
  }
  
  private void g()
  {
    FileManagerEntity localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchVideoFileThumb. can not find a FileManagerEntity");
      return;
    }
    if ((apvb.b(localFileManagerEntity.strFilePath)) && (apue.b(localFileManagerEntity)))
    {
      ThreadManager.executeOnSubThread(new OfflineFileBubbleModel.3(this, localFileManagerEntity));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
  }
  
  private void h()
  {
    FileManagerEntity localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchImageFileThumb. can not find a FileManagerEntity");
      return;
    }
    if (apvb.b(localFileManagerEntity.strFilePath))
    {
      ThreadManager.executeOnSubThread(new OfflineFileBubbleModel.4(this, localFileManagerEntity));
      return;
    }
    if (apuw.b(localFileManagerEntity))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 5);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0;
    }
    return apuw.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity).jdField_a_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  public aoub a()
  {
    return new aotx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public aoue a()
  {
    return new aotz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
  }
  
  public List<Integer> a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) {
      return new ArrayList();
    }
    if (paramInt == 1) {
      return a();
    }
    if (paramInt == 2) {
      return b();
    }
    if (paramInt == 3) {
      return c();
    }
    return new ArrayList();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      e();
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileBubbleModel", 1, "fetchFileThumb.");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
        break label41;
      }
    }
    label41:
    int i;
    do
    {
      return;
      i = apue.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      if (i == 2)
      {
        g();
        return;
      }
    } while (i != 0);
    h();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)) {}
    for (;;)
    {
      return;
      Object localObject1 = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      Object localObject2;
      switch (paramInt)
      {
      default: 
        return;
      case 2131364340: 
        ApolloUtil.f(((FileManagerEntity)localObject1).strFilePath);
        return;
      case 2131370494: 
        long l1 = awzw.a();
        long l2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.time;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.msgtype == -2005) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop == 3000) && (l1 - l2 > 604800L))
        {
          aptv.a(ajyc.a(2131704513));
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
          return;
        }
        apuc.a("0X8005E4B");
        return;
      case 2131364985: 
        aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject1);
        if (apue.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) == 0)
        {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
          return;
        }
        break;
      case 2131375571: 
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
        if (apsz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile).a(false))
        {
          if (bcvm.a((Activity)this.jdField_a_of_type_AndroidContentContext, 5, new aoyg(this))) {
            aptr.a(this.jdField_a_of_type_AndroidContentContext, 2131692672, 2131692675, new aoyh(this));
          }
        }
        else
        {
          apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_AndroidContentContext);
          return;
        }
        break;
      case 2131366632: 
        localObject2 = new apud();
        ((apud)localObject2).b = "file_forward";
        ((apud)localObject2).jdField_a_of_type_Int = 9;
        ((apud)localObject2).jdField_a_of_type_Long = ((FileManagerEntity)localObject1).fileSize;
        ((apud)localObject2).c = apvb.a(((FileManagerEntity)localObject1).fileName);
        ((apud)localObject2).d = apue.a(((FileManagerEntity)localObject1).getCloudType(), ((FileManagerEntity)localObject1).peerType);
        apuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apud)localObject2);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("forward_type", 0);
        ((Bundle)localObject2).putBoolean("not_forward", true);
        ((Bundle)localObject2).putParcelable("fileinfo", aqce.a((FileManagerEntity)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile));
        ((Bundle)localObject2).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        Intent localIntent = new Intent();
        localIntent.putExtras((Bundle)localObject2);
        localIntent.putExtra("forward_text", ajyc.a(2131704511) + apue.d(((FileManagerEntity)localObject1).fileName) + ajyc.a(2131704512) + apvb.a(((FileManagerEntity)localObject1).fileSize) + "。");
        localIntent.putExtra("direct_send_if_dataline_forward", true);
        localIntent.putExtra("forward _key_nojump", true);
        localIntent.putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (!bbev.d(BaseApplication.getContext())) {
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131694672, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        }
        for (;;)
        {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
          if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) {
            break;
          }
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
          return;
          aqbc.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
        }
      case 2131366659: 
        axqw.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
        if (!bbev.d(BaseApplication.getContext()))
        {
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131694672, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          return;
        }
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_AndroidContentContext);
        return;
      case 2131365348: 
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644D", "0X800644D", 0, 0, "6", "", "", "");
        apuc.a("0X8005080");
        apsz.a((FileManagerEntity)localObject1).a(false, this.jdField_a_of_type_AndroidContentContext, new aoyi(this, (FileManagerEntity)localObject1));
        return;
      case 2131371297: 
        apuc.a("0X8005081");
        if (((FileManagerEntity)localObject1).getCloudType() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject1).nSessionId);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject1).nSessionId);
        return;
      case 2131375196: 
        apuc.a("0X8005082");
        boolean bool = ((FileManagerEntity)localObject1).isSend();
        apsz.a((FileManagerEntity)localObject1).a(bool, this.jdField_a_of_type_AndroidContentContext, new aoyj(this, (FileManagerEntity)localObject1));
        return;
      case 2131365928: 
        new bgpd(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, false);
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg)
        {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
          return;
        }
        break;
      case 2131376910: 
        ayec.a((FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg)
        {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
          return;
        }
        break;
      case 2131370598: 
        localObject1 = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
        axqw.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
        paramInt = 0;
        if (((FileManagerEntity)localObject1).peerType == 0) {
          paramInt = 1;
        }
        for (;;)
        {
          apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, null, paramInt, 10004, (FileManagerEntity)localObject1, true, false);
          return;
          if (((FileManagerEntity)localObject1).peerType == 3000) {
            paramInt = 5;
          } else {
            QLog.w("OfflineFileBubbleModel", 1, "entranceType is unknow ,peerType:" + ((FileManagerEntity)localObject1).peerType);
          }
        }
      case 2131375854: 
        try
        {
          localObject1 = axwi.a(axwi.a(((FileManagerEntity)localObject1).strFilePath));
          if (localObject1 != null)
          {
            localObject2 = new SessionInfo();
            ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin;
            ((SessionInfo)localObject2).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop;
            aaod.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject2, (AbsStructMsg)localObject1);
            return;
          }
        }
        catch (Exception localException)
        {
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, ajyc.a(2131704509), 1).a();
          return;
        }
      }
    }
    ApolloUtil.a(localException.fileName, localException.strFilePath, new aoyk(this, localException));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)) {}
  }
  
  public void a(int paramInt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "get Entity by Msg faild!");
      return;
    }
    int i = 11;
    switch (apue.a(localFileManagerEntity.fileName))
    {
    }
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", i, 0, "4", "", "", "");
      if (paramInt != 1) {
        break;
      }
      f();
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
      continue;
      i = 9;
      continue;
      i = 10;
    }
    if (paramInt == 2)
    {
      b(paramView);
      return;
    }
    if (paramInt == 3)
    {
      a(paramView);
      return;
    }
    f();
  }
  
  protected void a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForFile)) {
      QLog.e("OfflineFileBubbleModel", 1, "setBubbleModelData. is not a MessageForFile");
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile = ((MessageForFile)paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null);
    QLog.e("OfflineFileBubbleModel", 1, "setBubbleModelData. can not find a FileManagerEntity");
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSend();
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0;
    }
    return apuw.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity).b;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {}
    long l;
    do
    {
      do
      {
        do
        {
          return 0L;
        } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16) {
          return -1L;
        }
      } while (bbdj.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath));
      l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime;
      l = (awzw.a() * 1000L - l) / 1000L;
    } while (l <= 0L);
    if (l > 604800L) {
      return -1L;
    }
    return 604800L - l;
  }
  
  public String b()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) {
      localObject = "";
    }
    FileManagerEntity localFileManagerEntity;
    int i;
    do
    {
      String str;
      do
      {
        do
        {
          return localObject;
          localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
          if (localFileManagerEntity == null) {
            return "";
          }
          localObject = localFileManagerEntity.strMiddleThumPath;
          i = apue.a(localFileManagerEntity.fileName);
          if (i != 0) {
            break;
          }
          str = localFileManagerEntity.strMiddleThumPath;
          localObject = str;
        } while (apvb.b(str));
        localObject = str;
      } while (!apvb.b(localFileManagerEntity.strLargeThumPath));
      if (apuw.b(localFileManagerEntity))
      {
        ThreadManagerV2.executeOnSubThread(new OfflineFileBubbleModel.1(this, localFileManagerEntity));
        return str;
      }
      return localFileManagerEntity.strLargeThumPath;
    } while (i != 2);
    return localFileManagerEntity.strLargeThumPath;
  }
  
  public List<Integer> b(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) {
      localObject = new ArrayList();
    }
    ArrayList localArrayList;
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return localObject;
        localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
        localArrayList = new ArrayList();
        localObject = localArrayList;
      } while (16 == localFileManagerEntity.status);
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity))) {
        localArrayList.add(Integer.valueOf(9));
      }
      localObject = localArrayList;
    } while (actn.a(5) != 1);
    localArrayList.add(Integer.valueOf(17));
    return localArrayList;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str));
    axqw.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
  }
  
  public boolean b()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (apue.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) != 2) {
                break;
              }
            } while ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isSend()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 0));
            return true;
            switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
            {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 9: 
            case 12: 
            case 13: 
            case 15: 
            default: 
              return false;
            }
          } while ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 0) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isSend() != true) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess));
          return true;
        } while (13 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType);
        return false;
        if (10 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      } while (13 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType);
      return false;
    } while ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isSend()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess));
    return true;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0;
    }
    long l1 = 604800L;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000) {
      l1 = 1296000L;
    }
    long l2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime;
    l2 = (awzw.a() * 1000L - l2) / 1000L;
    if ((l2 > 0L) && (l2 > l1)) {}
    for (int j = 1;; j = 0)
    {
      int i;
      switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
      {
      case 1: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 13: 
      default: 
        i = 0;
        label162:
        if (j != 0) {
          i = 6;
        }
        break;
      }
      for (;;)
      {
        return i;
        if (j != 0)
        {
          i = 6;
          break label162;
        }
        i = 1;
        break label162;
        i = 1;
        break label162;
        i = 3;
        break label162;
        if (9 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType) {
          break;
        }
        i = 3;
        break label162;
        i = 2;
        break label162;
        i = 4;
        break label162;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692446);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692445);
    bfol localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbfol.c(str1);
    localbfol.d(this.jdField_a_of_type_AndroidContentContext.getString(2131690596));
    localbfol.a(str2);
    localbfol.a(new aoyf(this, localbfol));
    localbfol.show();
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return -1;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSend();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) {
      bool = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
    {
    default: 
    case 1: 
    case 2: 
    case 14: 
    case 15: 
      do
      {
        do
        {
          do
          {
            return 0;
            if (!bool) {
              break;
            }
          } while (!bbdj.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath));
          return 2;
        } while (!bbdj.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath));
        return 5;
        if (bool) {
          return 1;
        }
        return 4;
      } while (9 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType);
      return 1;
    }
    if (bool)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess) {
        return 6;
      }
      return 3;
    }
    return 6;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F);
  }
  
  public int f()
  {
    int j = 1;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (apvk.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize));
      i = j;
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode == 1);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode == 2) {
      return 2;
    }
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoye
 * JD-Core Version:    0.7.0.1
 */