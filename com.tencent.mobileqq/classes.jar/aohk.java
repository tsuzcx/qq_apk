import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
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
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class aohk
  extends aohs
{
  private MessageForFile jdField_a_of_type_ComTencentMobileqqDataMessageForFile;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public aohk(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private List<Integer> a()
  {
    FileManagerEntity localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
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
      if (this.jdField_a_of_type_Boolean)
      {
        this.b = amlh.a().c();
        this.jdField_a_of_type_Boolean = false;
      }
      localObject = amlu.a().c();
      l = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.fileName);
      if ((this.b) && (localFileManagerEntity != null) && (axfs.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName, (String)localObject)))
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
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
      }
      if (aciy.a(5) == 1) {
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
        localObject = new File(localFileManagerEntity.strFilePath);
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((File)localObject).exists()) {
            i = 1;
          }
        }
      }
    }
  }
  
  private void a(View paramView)
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!apck.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
        if (localFileManagerEntity == null)
        {
          QLog.e("OfflineFileBubbleModel", 1, "get Entity by Msg faild!");
          return;
        }
      } while (localFileManagerEntity.status == 16);
      if (apdq.a(localFileManagerEntity)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    if ((localFileManagerEntity.sendCloudUnsuccessful()) && (!apdh.b(localFileManagerEntity.getFilePath())))
    {
      apcb.a(ajjy.a(2131638792));
      return;
    }
    apcj localapcj = new apcj();
    localapcj.b = "file_viewer_in";
    localapcj.jdField_a_of_type_Int = 9;
    localapcj.c = apdh.a(localFileManagerEntity.fileName);
    localapcj.d = apck.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
    apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localapcj);
    apci.a("0X8004AE3");
    QLog.i("OfflineFileBubbleModel", 1, "handle item click: file peerType[" + localFileManagerEntity.peerType + "]");
    if (localFileManagerEntity.peerType == 0) {}
    for (;;)
    {
      paramView = xgx.a(paramView);
      apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, paramView, i, 10004, localFileManagerEntity, false, false);
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
    FileManagerEntity localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSendFromLocal()) && (localFileManagerEntity.status == 2)) {
      localArrayList.add(Integer.valueOf(6));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(18));
      return localArrayList;
      if (!apdc.a(localFileManagerEntity))
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!apck.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    } while ((localFileManagerEntity.status == 16) && (!apck.e(localFileManagerEntity)));
    paramView = xgx.a(paramView);
    apdq.a(this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, false);
  }
  
  private List<Integer> c()
  {
    FileManagerEntity localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
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
        if (apck.c(localFileManagerEntity)) {
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
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!apck.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      if (apdq.a((FileManagerEntity)localObject2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    Object localObject1 = new apcj();
    ((apcj)localObject1).b = "file_viewer_in";
    ((apcj)localObject1).jdField_a_of_type_Int = 9;
    ((apcj)localObject1).c = apdh.a(((FileManagerEntity)localObject2).fileName);
    ((apcj)localObject1).d = apck.a(((FileManagerEntity)localObject2).getCloudType(), ((FileManagerEntity)localObject2).peerType);
    apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apcj)localObject1);
    apci.a("0X8004AE3");
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
      localObject1 = new aowq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject2, 10004);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("file_browser_extra_params_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((aowq)localObject1).a((Bundle)localObject2);
      localObject1 = new aows(this.jdField_a_of_type_AndroidContentContext, (aowv)localObject1);
      ((aows)localObject1).a(i);
      ((aows)localObject1).a();
      return;
      if (((FileManagerEntity)localObject2).peerType == 3000) {
        i = 5;
      }
    }
  }
  
  private void f()
  {
    FileManagerEntity localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchVideoFileThumb. can not find a FileManagerEntity");
      return;
    }
    if ((apdh.b(localFileManagerEntity.strFilePath)) && (apck.b(localFileManagerEntity)))
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
  
  private void g()
  {
    FileManagerEntity localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchImageFileThumb. can not find a FileManagerEntity");
      return;
    }
    if (apdh.b(localFileManagerEntity.strFilePath))
    {
      ThreadManager.executeOnSubThread(new OfflineFileBubbleModel.4(this, localFileManagerEntity));
      return;
    }
    if (apdc.b(localFileManagerEntity))
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
    return apdc.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity).jdField_a_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  public aodh a()
  {
    return new aodd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public aodk a()
  {
    return new aodf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)) {}
    int i;
    do
    {
      return;
      i = apck.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      if (i == 2)
      {
        f();
        return;
      }
    } while (i != 0);
    g();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)) {}
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
            switch (paramInt)
            {
            default: 
              return;
            case 2131298783: 
              ApolloUtil.e(((FileManagerEntity)localObject1).strFilePath);
              return;
            case 2131304829: 
              long l1 = awao.a();
              long l2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.time;
              if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.msgtype == -2005) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop == 3000) && (l1 - l2 > 604800L))
              {
                apcb.a(ajjy.a(2131638728));
                awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
                return;
              }
              apci.a("0X8005E4B");
              return;
            case 2131299417: 
              aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject1);
            }
          } while (apck.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) != 0);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
          return;
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
          if (!apbf.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile).a(false)) {
            break;
          }
        } while (!bbrm.a((Activity)this.jdField_a_of_type_AndroidContentContext, 5, new aohm(this)));
        apbx.a(this.jdField_a_of_type_AndroidContentContext, 2131627035, 2131627038, new aohn(this));
        return;
        apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_AndroidContentContext);
        return;
        localObject2 = new apcj();
        ((apcj)localObject2).b = "file_forward";
        ((apcj)localObject2).jdField_a_of_type_Int = 9;
        ((apcj)localObject2).jdField_a_of_type_Long = ((FileManagerEntity)localObject1).fileSize;
        ((apcj)localObject2).c = apdh.a(((FileManagerEntity)localObject1).fileName);
        ((apcj)localObject2).d = apck.a(((FileManagerEntity)localObject1).getCloudType(), ((FileManagerEntity)localObject1).peerType);
        apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apcj)localObject2);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("forward_type", 0);
        ((Bundle)localObject2).putBoolean("not_forward", true);
        ((Bundle)localObject2).putParcelable("fileinfo", apir.a((FileManagerEntity)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile));
        ((Bundle)localObject2).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        Intent localIntent = new Intent();
        localIntent.putExtras((Bundle)localObject2);
        localIntent.putExtra("forward_text", ajjy.a(2131638726) + apck.d(((FileManagerEntity)localObject1).fileName) + ajjy.a(2131638727) + apdh.a(((FileManagerEntity)localObject1).fileSize) + "。");
        localIntent.putExtra("direct_send_if_dataline_forward", true);
        localIntent.putExtra("forward _key_nojump", true);
        localIntent.putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (!badq.d(BaseApplication.getContext())) {
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131629008, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        }
        for (;;)
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
          if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) {
            break;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
          return;
          aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
        }
        awqx.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
        if (!badq.d(BaseApplication.getContext()))
        {
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131629008, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
          return;
        }
        apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_AndroidContentContext);
        return;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644D", "0X800644D", 0, 0, "6", "", "", "");
        apci.a("0X8005080");
        apbf.a((FileManagerEntity)localObject1).a(false, this.jdField_a_of_type_AndroidContentContext, new aoho(this, (FileManagerEntity)localObject1));
        return;
        apci.a("0X8005081");
        if (((FileManagerEntity)localObject1).getCloudType() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject1).nSessionId);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject1).nSessionId);
        return;
        apci.a("0X8005082");
        boolean bool = ((FileManagerEntity)localObject1).isSend();
        apbf.a((FileManagerEntity)localObject1).a(bool, this.jdField_a_of_type_AndroidContentContext, new aohp(this, (FileManagerEntity)localObject1));
        return;
        new bfhl(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, false);
      } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
      return;
      axea.a((FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
    return;
    Object localObject2 = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    awqx.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    paramInt = 0;
    if (((FileManagerEntity)localObject2).peerType == 0) {
      paramInt = 1;
    }
    for (;;)
    {
      for (;;)
      {
        apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, null, paramInt, 10004, (FileManagerEntity)localObject2, true, false);
        try
        {
          localObject1 = awwg.a(awwg.a(((FileManagerEntity)localObject1).strFilePath));
          if (localObject1 == null) {
            break;
          }
          localObject2 = new SessionInfo();
          ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin;
          ((SessionInfo)localObject2).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop;
          aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject2, (AbsStructMsg)localObject1);
          return;
        }
        catch (Exception localException)
        {
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, ajjy.a(2131638724), 1).a();
          return;
        }
      }
      if (((FileManagerEntity)localObject2).peerType == 3000) {
        paramInt = 5;
      } else {
        QLog.w("OfflineFileBubbleModel", 1, "entranceType is unknow ,peerType:" + ((FileManagerEntity)localObject2).peerType);
      }
    }
    ApolloUtil.a(localException.fileName, localException.strFilePath, new aohq(this, localException));
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
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", 0, 0, "4", "", "", "");
    if (paramInt == 1)
    {
      e();
      return;
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
    e();
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
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
    return apdc.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity).b;
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
      } while (bace.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath));
      l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime;
      l = (awao.a() * 1000L - l) / 1000L;
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
          do
          {
            return localObject;
            localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
            if (localFileManagerEntity == null) {
              return "";
            }
            localObject = localFileManagerEntity.strMiddleThumPath;
            i = apck.a(localFileManagerEntity.fileName);
            if (i != 0) {
              break;
            }
            str = localFileManagerEntity.strMiddleThumPath;
            localObject = str;
          } while (apdh.b(str));
          localObject = str;
        } while (!apdh.b(localFileManagerEntity.strLargeThumPath));
        localObject = str;
      } while (!apdc.b(localFileManagerEntity));
      ThreadManagerV2.executeOnSubThread(new OfflineFileBubbleModel.1(this, localFileManagerEntity));
      return str;
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
        localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
        localArrayList = new ArrayList();
        localObject = localArrayList;
      } while (16 == localFileManagerEntity.status);
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity))) {
        localArrayList.add(Integer.valueOf(9));
      }
      localObject = localArrayList;
    } while (aciy.a(5) != 1);
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
    awqx.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
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
              if (apck.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) != 2) {
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
    int k = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0;
    }
    long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime;
    l = (awao.a() * 1000L - l) / 1000L;
    if ((l > 0L) && (l > 604800L)) {}
    for (int j = 1;; j = 0)
    {
      int i = k;
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
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
        label146:
        if (j != 0) {
          i = 6;
        }
        break;
      }
      for (;;)
      {
        return i;
        i = k;
        if (j == 0) {
          break label146;
        }
        i = 6;
        break label146;
        i = 3;
        break label146;
        if (9 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType) {
          break;
        }
        i = 3;
        break label146;
        i = 2;
        break label146;
        i = 4;
        break label146;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131626845);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131626844);
    begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbegr.c(str1);
    localbegr.d(this.jdField_a_of_type_AndroidContentContext.getString(2131625035));
    localbegr.a(str2);
    localbegr.a(new aohl(this, localbegr));
    localbegr.show();
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return -1;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSend();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) {
      bool = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
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
          } while (!bace.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath));
          return 2;
        } while (!bace.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aohk
 * JD-Core Version:    0.7.0.1
 */