import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class atki
  extends atkn
{
  private MessageForFile jdField_a_of_type_ComTencentMobileqqDataMessageForFile;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private boolean b = true;
  private boolean c;
  
  public atki(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private List<Integer> a()
  {
    FileManagerEntity localFileManagerEntity = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    ArrayList localArrayList = new ArrayList();
    if (localFileManagerEntity == null) {
      return localArrayList;
    }
    a(localFileManagerEntity, localArrayList);
    b(localFileManagerEntity, localArrayList);
    c(localFileManagerEntity, localArrayList);
    localArrayList.add(Integer.valueOf(10));
    if (QLog.isColorLevel()) {
      QLog.i("msgrevoke", 2, "FileMenuitem entity.status:" + localFileManagerEntity.status);
    }
    if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && (localFileManagerEntity.nOpType == 1))) {
      localArrayList.add(Integer.valueOf(15));
    }
    if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
      localArrayList.add(Integer.valueOf(20));
    }
    if ((localFileManagerEntity.getCloudType() != 1) || (localFileManagerEntity.status != 2)) {
      localArrayList.add(Integer.valueOf(16));
    }
    localArrayList.add(Integer.valueOf(17));
    if (16 != localFileManagerEntity.status) {
      localArrayList.add(Integer.valueOf(12));
    }
    localArrayList.add(Integer.valueOf(19));
    if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
      localArrayList.add(Integer.valueOf(21));
    }
    d(localFileManagerEntity, localArrayList);
    return localArrayList;
  }
  
  private void a(View paramView)
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!auea.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        localFileManagerEntity = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
        if (localFileManagerEntity == null)
        {
          QLog.e("OfflineFileBubbleModel", 1, "get Entity by Msg faild!");
          return;
        }
      } while (localFileManagerEntity.status == 16);
      if (aufd.a(localFileManagerEntity)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    if ((localFileManagerEntity.sendCloudUnsuccessful()) && (!FileUtil.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())))
    {
      audr.a(anvx.a(2131704056));
      return;
    }
    audz localaudz = new audz();
    localaudz.b = "file_viewer_in";
    localaudz.jdField_a_of_type_Int = 9;
    localaudz.c = FileUtil.getExtension(localFileManagerEntity.fileName);
    localaudz.d = auea.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
    audy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localaudz);
    audy.a("0X8004AE3");
    QLog.i("OfflineFileBubbleModel", 1, "handle item click: file peerType[" + localFileManagerEntity.peerType + "]");
    if (localFileManagerEntity.peerType == 0) {}
    for (;;)
    {
      paramView = aavz.a(paramView);
      aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, paramView, i, 10004, localFileManagerEntity, false, false);
      return;
      if (localFileManagerEntity.peerType == 3000) {
        i = 5;
      }
    }
  }
  
  private void a(FileManagerEntity paramFileManagerEntity)
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
    if (aucx.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile).a(false))
    {
      if (bixr.a((Activity)this.jdField_a_of_type_AndroidContentContext, 5, new atkk(this))) {
        audn.a(this.jdField_a_of_type_AndroidContentContext, 2131692476, 2131692479, new atkl(this));
      }
      return;
    }
    auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if (16 == paramFileManagerEntity.status) {}
    while ((paramFileManagerEntity.getCloudType() == 0) || (a(paramFileManagerEntity)) || (AIOUtils.getAIOMsgMenuDpcConfig(5) != 1)) {
      return;
    }
    paramArrayList.add(Integer.valueOf(18));
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
    FileManagerEntity localFileManagerEntity = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSendFromLocal()) && (localFileManagerEntity.status == 2)) {
      localArrayList.add(Integer.valueOf(6));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(19));
      return localArrayList;
      if (!aues.a(localFileManagerEntity))
      {
        localArrayList.add(Integer.valueOf(10));
        if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)))
        {
          if (!localFileManagerEntity.sendCloudUnsuccessful()) {
            localArrayList.add(Integer.valueOf(9));
          }
          localArrayList.add(Integer.valueOf(18));
        }
      }
      if (!aues.a(localFileManagerEntity)) {
        localArrayList.add(Integer.valueOf(12));
      }
      if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && (localFileManagerEntity.nOpType == 1))) {
        localArrayList.add(Integer.valueOf(15));
      }
      localArrayList.add(Integer.valueOf(17));
      if ((localFileManagerEntity.getCloudType() != 1) || (localFileManagerEntity.status != 2)) {
        localArrayList.add(Integer.valueOf(16));
      }
    }
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!auea.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      localFileManagerEntity = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    } while ((localFileManagerEntity.status == 16) && (!auea.e(localFileManagerEntity)));
    paramView = aavz.a(paramView);
    aufd.a(this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, false);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    bdla.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    int i = 0;
    if (paramFileManagerEntity.peerType == 0) {
      i = 1;
    }
    for (;;)
    {
      aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, null, i, 10004, paramFileManagerEntity, true, false);
      return;
      if (paramFileManagerEntity.peerType == 3000) {
        i = 5;
      } else {
        QLog.w("OfflineFileBubbleModel", 1, "entranceType is unknow ,peerType:" + paramFileManagerEntity.peerType);
      }
    }
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if (16 == paramFileManagerEntity.status) {}
    while ((paramFileManagerEntity.getCloudType() == 0) || (a(paramFileManagerEntity)) || (paramFileManagerEntity.sendCloudUnsuccessful())) {
      return;
    }
    paramArrayList.add(Integer.valueOf(9));
  }
  
  private List<Integer> c()
  {
    FileManagerEntity localFileManagerEntity = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    ArrayList localArrayList = new ArrayList();
    if (localFileManagerEntity.status != 16) {
      localArrayList.add(Integer.valueOf(13));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSendFromLocal()) && (localFileManagerEntity.status == 2)) {
      localArrayList.add(Integer.valueOf(6));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(19));
      return localArrayList;
      if (localFileManagerEntity.status != 16)
      {
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          localArrayList.add(Integer.valueOf(9));
        }
        localArrayList.add(Integer.valueOf(10));
        if (auea.c(localFileManagerEntity)) {
          localArrayList.add(Integer.valueOf(18));
        }
        if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && ((localFileManagerEntity.nOpType == 1) || (localFileManagerEntity.nOpType == 8)))) {
          localArrayList.add(Integer.valueOf(15));
        }
      }
      localArrayList.add(Integer.valueOf(17));
      if (localFileManagerEntity.status != 16) {
        localArrayList.add(Integer.valueOf(12));
      }
      if ((localFileManagerEntity.getCloudType() != 1) || (localFileManagerEntity.status != 2)) {
        localArrayList.add(Integer.valueOf(16));
      }
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = new audz();
    ((audz)localObject).b = "file_forward";
    ((audz)localObject).jdField_a_of_type_Int = 9;
    ((audz)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    ((audz)localObject).c = FileUtil.getExtension(paramFileManagerEntity.fileName);
    ((audz)localObject).d = auea.a(paramFileManagerEntity.getCloudType(), paramFileManagerEntity.peerType);
    audy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (audz)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("forward_type", 0);
    ((Bundle)localObject).putBoolean("not_forward", true);
    ((Bundle)localObject).putParcelable("fileinfo", ForwardFileOption.a(paramFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile));
    ((Bundle)localObject).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    Intent localIntent = new Intent();
    localIntent.putExtras((Bundle)localObject);
    localIntent.putExtra("forward_text", anvx.a(2131703991) + auea.d(paramFileManagerEntity.fileName) + anvx.a(2131703992) + FileUtil.filesizeToString(paramFileManagerEntity.fileSize) + "。");
    localIntent.putExtra("direct_send_if_dataline_forward", true);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694305, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
      }
      return;
      aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    int i = 1;
    if (16 == paramFileManagerEntity.status) {}
    for (;;)
    {
      return;
      if (this.b)
      {
        this.c = arng.a().c();
        this.b = false;
      }
      Object localObject = arnw.a().c();
      long l = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.fileName);
      if ((this.c) && (becr.a(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject)))
      {
        if (paramFileManagerEntity.status != 16) {}
        while ((i != 0) && (paramFileManagerEntity.fileSize <= l))
        {
          paramArrayList.add(Integer.valueOf(22));
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
          return;
          if (!TextUtils.isEmpty(paramFileManagerEntity.getFilePath()))
          {
            localObject = new VFSFile(paramFileManagerEntity.getFilePath());
            if ((localObject != null) && (((VFSFile)localObject).exists())) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
  }
  
  private void d(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      paramFileManagerEntity = bdpp.a(bdpp.a(paramFileManagerEntity.getFilePath()));
      if (paramFileManagerEntity != null)
      {
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.curFriendUin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin;
        localSessionInfo.curType = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop;
        admh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramFileManagerEntity);
      }
      return;
    }
    catch (Exception paramFileManagerEntity)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, anvx.a(2131703989), 1).a();
    }
  }
  
  private void d(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if ((16 != paramFileManagerEntity.status) && (paramFileManagerEntity.getCloudType() != 0) && (!a(paramFileManagerEntity))) {
      paramArrayList.add(Integer.valueOf(24));
    }
  }
  
  private void e(FileManagerEntity paramFileManagerEntity) {}
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!auea.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      if (aufd.a((FileManagerEntity)localObject2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    Object localObject1 = new audz();
    ((audz)localObject1).b = "file_viewer_in";
    ((audz)localObject1).jdField_a_of_type_Int = 9;
    ((audz)localObject1).c = FileUtil.getExtension(((FileManagerEntity)localObject2).fileName);
    ((audz)localObject1).d = auea.a(((FileManagerEntity)localObject2).getCloudType(), ((FileManagerEntity)localObject2).peerType);
    audy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (audz)localObject1);
    audy.a("0X8004AE3");
    if (bmeb.a().a((FileManagerEntity)localObject2))
    {
      bmeb.a().a(this.jdField_a_of_type_AndroidContentContext, ((FileManagerEntity)localObject2).getFilePath(), true);
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
      localObject1 = new atyi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject2, 10004);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("file_browser_extra_params_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      int j = aufd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg, (Bundle)localObject2, i);
      ((atyi)localObject1).a((Bundle)localObject2);
      localObject1 = new atyk(this.jdField_a_of_type_AndroidContentContext, (atyn)localObject1);
      ((atyk)localObject1).a(i);
      aufd.a(i, j, (atyk)localObject1);
      return;
      if (((FileManagerEntity)localObject2).peerType == 3000) {
        i = 5;
      }
    }
  }
  
  private void g()
  {
    FileManagerEntity localFileManagerEntity = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchVideoFileThumb. can not find a FileManagerEntity");
      return;
    }
    if ((FileUtil.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) && (auea.b(localFileManagerEntity)))
    {
      ThreadManager.executeOnSubThread(new OfflineFileBubbleModel.3(this, localFileManagerEntity));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b(localFileManagerEntity);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity);
  }
  
  private void h()
  {
    FileManagerEntity localFileManagerEntity = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchImageFileThumb. can not find a FileManagerEntity");
      return;
    }
    if (FileUtil.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath()))
    {
      ThreadManager.executeOnSubThread(new OfflineFileBubbleModel.4(this, localFileManagerEntity));
      return;
    }
    if (aues.b(localFileManagerEntity))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 5);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0;
    }
    return aues.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity).jdField_a_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  public atfh a()
  {
    return new atfd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public atfk a()
  {
    return new atff(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
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
      i = auea.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
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
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        do
        {
          return;
          localFileManagerEntity = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
          switch (paramInt)
          {
          default: 
            return;
          case 2131364781: 
            ApolloUtil.f(localFileManagerEntity.getFilePath());
            return;
          case 2131371641: 
            long l1 = bcrg.a();
            long l2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.time;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.msgtype == -2005) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop == 3000) && (l1 - l2 > 604800L))
            {
              audr.a(anvx.a(2131703993));
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
              return;
            }
            audy.a("0X8005E4B");
            return;
          case 2131365475: 
            admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
          }
        } while (auea.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) != 0);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
        return;
        a(localFileManagerEntity);
        return;
        c(localFileManagerEntity);
        return;
        bdla.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694305, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
          return;
        }
        auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_AndroidContentContext);
        return;
        new bmad(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, false);
      } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
      return;
      beaz.a(localFileManagerEntity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
    return;
    b(localFileManagerEntity);
    return;
    d(localFileManagerEntity);
    return;
    e(localFileManagerEntity);
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
    FileManagerEntity localFileManagerEntity = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "get Entity by Msg faild!");
      return;
    }
    int i = 11;
    switch (auea.a(localFileManagerEntity.fileName))
    {
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", i, 0, "4", "", "", "");
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
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
  
  public boolean a(int paramInt, long paramLong)
  {
    long l = 604800L;
    if (paramInt == 3000) {
      l = 1296000L;
    }
    paramLong = (bcrg.a() * 1000L - paramLong) / 1000L;
    return (paramLong > 0L) && (paramLong > l);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0;
    }
    return aues.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity).b;
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
      } while (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()));
      l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime;
      l = (bcrg.a() * 1000L - l) / 1000L;
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
          localFileManagerEntity = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
          if (localFileManagerEntity == null) {
            return "";
          }
          localObject = localFileManagerEntity.strMiddleThumPath;
          i = auea.a(localFileManagerEntity.fileName);
          if (i != 0) {
            break;
          }
          str = localFileManagerEntity.strMiddleThumPath;
          localObject = str;
        } while (FileUtil.fileExistsAndNotEmpty(str));
        localObject = str;
      } while (!FileUtil.fileExistsAndNotEmpty(localFileManagerEntity.strLargeThumPath));
      if (aues.b(localFileManagerEntity))
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
        localFileManagerEntity = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
        localArrayList = new ArrayList();
        localObject = localArrayList;
      } while (16 == localFileManagerEntity.status);
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity))) {
        localArrayList.add(Integer.valueOf(9));
      }
      localObject = localArrayList;
    } while (AIOUtils.getAIOMsgMenuDpcConfig(5) != 1);
    localArrayList.add(Integer.valueOf(18));
    return localArrayList;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(str))
    {
      bdla.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(str);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a();
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
              if (auea.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) != 2) {
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
    int j = 6;
    int k = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      j = 0;
      return j;
    }
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime);
    int i = k;
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
    {
    default: 
      i = k;
    }
    while (!bool)
    {
      return i;
      if (bool)
      {
        i = 6;
      }
      else
      {
        i = 1;
        continue;
        i = 1;
        continue;
        i = 3;
        continue;
        i = k;
        if (9 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType)
        {
          i = 3;
          continue;
          i = 2;
          continue;
          i = 4;
        }
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692252);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692251);
    bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbkzi.c(str1);
    localbkzi.d(this.jdField_a_of_type_AndroidContentContext.getString(2131690697));
    localbkzi.a(str2);
    localbkzi.a(new atkj(this, localbkzi));
    localbkzi.show();
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return -1;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSend();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) {
      bool = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
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
          } while (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()));
          return 2;
        } while (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()));
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
      } while (aufd.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize));
      i = j;
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode == 1);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode == 2) {
      return 2;
    }
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atki
 * JD-Core Version:    0.7.0.1
 */