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
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class atts
  extends attx
{
  private MessageForFile jdField_a_of_type_ComTencentMobileqqDataMessageForFile;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private boolean b = true;
  private boolean c;
  
  public atts(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private List<Integer> a()
  {
    FileManagerEntity localFileManagerEntity = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!aunj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        localFileManagerEntity = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
        if (localFileManagerEntity == null)
        {
          QLog.e("OfflineFileBubbleModel", 1, "get Entity by Msg faild!");
          return;
        }
      } while (localFileManagerEntity.status == 16);
      if (auoo.a(localFileManagerEntity)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    if ((localFileManagerEntity.sendCloudUnsuccessful()) && (!auog.b(localFileManagerEntity.getFilePath())))
    {
      auna.a(anzj.a(2131703475));
      return;
    }
    auni localauni = new auni();
    localauni.b = "file_viewer_in";
    localauni.jdField_a_of_type_Int = 9;
    localauni.c = auog.a(localFileManagerEntity.fileName);
    localauni.d = aunj.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
    aunh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localauni);
    aunh.a("0X8004AE3");
    QLog.i("OfflineFileBubbleModel", 1, "handle item click: file peerType[" + localFileManagerEntity.peerType + "]");
    if (localFileManagerEntity.peerType == 0) {}
    for (;;)
    {
      paramView = abke.a(paramView);
      auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, paramView, i, 10004, localFileManagerEntity, false, false);
      return;
      if (localFileManagerEntity.peerType == 3000) {
        i = 5;
      }
    }
  }
  
  private void a(FileManagerEntity paramFileManagerEntity)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
    if (aumg.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile).a(false))
    {
      if (bjhk.a((Activity)this.jdField_a_of_type_AndroidContentContext, 5, new attu(this))) {
        aumw.a(this.jdField_a_of_type_AndroidContentContext, 2131692326, 2131692329, new attv(this));
      }
      return;
    }
    aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if (16 == paramFileManagerEntity.status) {}
    while ((paramFileManagerEntity.getCloudType() == 0) || (a(paramFileManagerEntity)) || (agej.a(5) != 1)) {
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
    FileManagerEntity localFileManagerEntity = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSendFromLocal()) && (localFileManagerEntity.status == 2)) {
      localArrayList.add(Integer.valueOf(6));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(19));
      return localArrayList;
      if (!auob.a(localFileManagerEntity))
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
      if (!auob.a(localFileManagerEntity)) {
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!aunj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      localFileManagerEntity = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    } while ((localFileManagerEntity.status == 16) && (!aunj.e(localFileManagerEntity)));
    paramView = abke.a(paramView);
    auoo.a(this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, false);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    bdll.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    int i = 0;
    if (paramFileManagerEntity.peerType == 0) {
      i = 1;
    }
    for (;;)
    {
      auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, null, i, 10004, paramFileManagerEntity, true, false);
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
    FileManagerEntity localFileManagerEntity = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
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
        if (aunj.c(localFileManagerEntity)) {
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
    Object localObject = new auni();
    ((auni)localObject).b = "file_forward";
    ((auni)localObject).jdField_a_of_type_Int = 9;
    ((auni)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    ((auni)localObject).c = auog.a(paramFileManagerEntity.fileName);
    ((auni)localObject).d = aunj.a(paramFileManagerEntity.getCloudType(), paramFileManagerEntity.peerType);
    aunh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (auni)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("forward_type", 0);
    ((Bundle)localObject).putBoolean("not_forward", true);
    ((Bundle)localObject).putParcelable("fileinfo", ForwardFileOption.a(paramFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile));
    ((Bundle)localObject).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    Intent localIntent = new Intent();
    localIntent.putExtras((Bundle)localObject);
    localIntent.putExtra("forward_text", anzj.a(2131703410) + aunj.d(paramFileManagerEntity.fileName) + anzj.a(2131703411) + auog.a(paramFileManagerEntity.fileSize) + "。");
    localIntent.putExtra("direct_send_if_dataline_forward", true);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (!bhnv.d(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694008, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
      }
      return;
      auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
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
        this.c = arpx.a().c();
        this.b = false;
      }
      Object localObject = arqn.a().c();
      long l = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.fileName);
      if ((this.c) && (becb.a(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject)))
      {
        if (paramFileManagerEntity.status != 16) {}
        while ((i != 0) && (paramFileManagerEntity.fileSize <= l))
        {
          paramArrayList.add(Integer.valueOf(22));
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
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
      paramFileManagerEntity = bdqg.a(bdqg.a(paramFileManagerEntity.getFilePath()));
      if (paramFileManagerEntity != null)
      {
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin;
        localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop;
        aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramFileManagerEntity);
      }
      return;
    }
    catch (Exception paramFileManagerEntity)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, anzj.a(2131703408), 1).a();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!aunj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      if (auoo.a((FileManagerEntity)localObject2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    Object localObject1 = new auni();
    ((auni)localObject1).b = "file_viewer_in";
    ((auni)localObject1).jdField_a_of_type_Int = 9;
    ((auni)localObject1).c = auog.a(((FileManagerEntity)localObject2).fileName);
    ((auni)localObject1).d = aunj.a(((FileManagerEntity)localObject2).getCloudType(), ((FileManagerEntity)localObject2).peerType);
    aunh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (auni)localObject1);
    aunh.a("0X8004AE3");
    if (bmol.a().a((FileManagerEntity)localObject2))
    {
      bmol.a().a(this.jdField_a_of_type_AndroidContentContext, ((FileManagerEntity)localObject2).getFilePath(), true);
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
      localObject1 = new auhr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject2, 10004);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("file_browser_extra_params_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((auhr)localObject1).a((Bundle)localObject2);
      localObject1 = new auht(this.jdField_a_of_type_AndroidContentContext, (auhw)localObject1);
      ((auht)localObject1).a(i);
      ((auht)localObject1).a();
      return;
      if (((FileManagerEntity)localObject2).peerType == 3000) {
        i = 5;
      }
    }
  }
  
  private void g()
  {
    FileManagerEntity localFileManagerEntity = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchVideoFileThumb. can not find a FileManagerEntity");
      return;
    }
    if ((auog.b(localFileManagerEntity.getFilePath())) && (aunj.b(localFileManagerEntity)))
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
    FileManagerEntity localFileManagerEntity = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchImageFileThumb. can not find a FileManagerEntity");
      return;
    }
    if (auog.b(localFileManagerEntity.getFilePath()))
    {
      ThreadManager.executeOnSubThread(new OfflineFileBubbleModel.4(this, localFileManagerEntity));
      return;
    }
    if (auob.b(localFileManagerEntity))
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
    return auob.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity).jdField_a_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  public atos a()
  {
    return new atoo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public atov a()
  {
    return new atoq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
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
      i = aunj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
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
          localFileManagerEntity = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
          switch (paramInt)
          {
          default: 
            return;
          case 2131364665: 
            ApolloUtil.f(localFileManagerEntity.getFilePath());
            return;
          case 2131371487: 
            long l1 = bcrg.a();
            long l2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.time;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.msgtype == -2005) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop == 3000) && (l1 - l2 > 604800L))
            {
              auna.a(anzj.a(2131703412));
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
              return;
            }
            aunh.a("0X8005E4B");
            return;
          case 2131365352: 
            aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
          }
        } while (aunj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) != 0);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
        return;
        a(localFileManagerEntity);
        return;
        c(localFileManagerEntity);
        return;
        bdll.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
        if (!bhnv.d(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694008, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
          return;
        }
        aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_AndroidContentContext);
        return;
        new bmko(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, false);
      } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
      return;
      beaj.a(localFileManagerEntity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
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
    FileManagerEntity localFileManagerEntity = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "get Entity by Msg faild!");
      return;
    }
    int i = 11;
    switch (aunj.a(localFileManagerEntity.fileName))
    {
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", i, 0, "4", "", "", "");
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
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
    return auob.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity).b;
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
      } while (bhmi.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()));
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
          localFileManagerEntity = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
          if (localFileManagerEntity == null) {
            return "";
          }
          localObject = localFileManagerEntity.strMiddleThumPath;
          i = aunj.a(localFileManagerEntity.fileName);
          if (i != 0) {
            break;
          }
          str = localFileManagerEntity.strMiddleThumPath;
          localObject = str;
        } while (auog.b(str));
        localObject = str;
      } while (!auog.b(localFileManagerEntity.strLargeThumPath));
      if (auob.b(localFileManagerEntity))
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
        localFileManagerEntity = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
        localArrayList = new ArrayList();
        localObject = localArrayList;
      } while (16 == localFileManagerEntity.status);
      if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity))) {
        localArrayList.add(Integer.valueOf(9));
      }
      localObject = localArrayList;
    } while (agej.a(5) != 1);
    localArrayList.add(Integer.valueOf(18));
    return localArrayList;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str))
    {
      bdll.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
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
              if (aunj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) != 2) {
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
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692114);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692113);
    blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
    localblir.c(str1);
    localblir.d(this.jdField_a_of_type_AndroidContentContext.getString(2131690580));
    localblir.a(str2);
    localblir.a(new attt(this, localblir));
    localblir.show();
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return -1;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSend();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) {
      bool = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
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
          } while (!bhmi.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()));
          return 2;
        } while (!bhmi.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()));
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
      } while (auoo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize));
      i = j;
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode == 1);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode == 2) {
      return 2;
    }
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atts
 * JD-Core Version:    0.7.0.1
 */