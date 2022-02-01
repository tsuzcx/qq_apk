import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public class atko
  extends atkn
{
  private MessageForTroopFile a;
  private boolean b;
  private boolean c;
  
  public atko(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(int paramInt, bfjs parambfjs, ArrayList<Integer> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    long l = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambfjs.g);
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambfjs, false))) {
      paramArrayList.add(Integer.valueOf(22));
    }
    paramArrayList.add(Integer.valueOf(21));
    if (e()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    if (paramInt == 1) {
      paramArrayList.add(Integer.valueOf(20));
    }
    paramArrayList.add(Integer.valueOf(16));
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
    paramArrayList.add(Integer.valueOf(11));
    paramArrayList.add(Integer.valueOf(12));
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new atkp(this, paramLong, paramUUID, paramActivity);
    bhdj.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697010), this.jdField_a_of_type_AndroidContentContext.getString(2131697038), 2131697008, 2131697025, paramUUID, paramUUID).show();
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new atkq(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    bhdj.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697014), this.jdField_a_of_type_AndroidContentContext.getString(2131697039), 2131697012, 2131697027, paramUUID, paramUUID).show();
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!auea.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    bfjs localbfjs = a();
    if (localbfjs == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    switch (localbfjs.jdField_b_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_picBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      ahcj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
      return;
    }
    paramView = new Intent();
    paramView.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void a(bfjs parambfjs)
  {
    FileManagerEntity localFileManagerEntity = auea.a(parambfjs);
    parambfjs = bgjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambfjs.jdField_b_of_type_Long).a(localFileManagerEntity.strTroopFilePath);
    if (parambfjs != null)
    {
      localFileManagerEntity.lastTime = parambfjs.c;
      localFileManagerEntity.selfUin = String.valueOf(parambfjs.jdField_b_of_type_Long);
    }
    new bmad(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, false);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
    }
  }
  
  private void a(bfjs parambfjs, int paramInt)
  {
    if (paramInt == 0)
    {
      bgjc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697356));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    Object localObject = auea.a(parambfjs);
    ((FileManagerEntity)localObject).status = 2;
    ((FileManagerEntity)localObject).nOpType = 24;
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.b(10006);
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
      localForwardFileInfo.a(parambfjs.jdField_a_of_type_JavaLangString);
    }
    localForwardFileInfo.d(parambfjs.g);
    localForwardFileInfo.d(parambfjs.jdField_c_of_type_Long);
    localForwardFileInfo.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
    if (parambfjs.jdField_a_of_type_JavaUtilUUID != null) {
      localForwardFileInfo.e(parambfjs.jdField_a_of_type_JavaUtilUUID.toString());
    }
    if (!TextUtils.isEmpty(parambfjs.jdField_c_of_type_JavaLangString)) {
      localForwardFileInfo.f(parambfjs.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      localForwardFileInfo.d(1);
      localForwardFileInfo.a(1);
      localBundle.putParcelable("fileinfo", localForwardFileInfo);
      localBundle.putBoolean("not_forward", true);
      localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).putExtra("forward_text", parambfjs.g);
      ((Intent)localObject).putExtra("forward_from_troop_file", true);
      localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
      ((Intent)localObject).putExtra("forward _key_nojump", true);
      ((Intent)localObject).putExtra("sender_uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin);
      ((Intent)localObject).putExtra("last_time", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime);
      aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
      if (!TextUtils.isEmpty(parambfjs.jdField_d_of_type_JavaLangString)) {
        localForwardFileInfo.f(parambfjs.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  private void a(TroopFileTransferManager paramTroopFileTransferManager, bfjs parambfjs, int paramInt)
  {
    if (paramInt == 0) {
      bgjc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697356));
    }
    while ((parambfjs.jdField_b_of_type_Int != 1) && (parambfjs.jdField_b_of_type_Int != 0) && (parambfjs.jdField_b_of_type_Int != 2) && (parambfjs.jdField_b_of_type_Int != 3)) {
      return;
    }
    paramTroopFileTransferManager.a(parambfjs.jdField_a_of_type_JavaUtilUUID);
    a(parambfjs.jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, parambfjs.jdField_a_of_type_JavaUtilUUID, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
  }
  
  private void a(ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(3));
    paramArrayList.add(Integer.valueOf(10));
    if (e()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    paramArrayList.add(Integer.valueOf(16));
  }
  
  private boolean a(bfjs parambfjs, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = arng.a().c();
      this.jdField_b_of_type_Boolean = false;
    }
    long l1 = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambfjs.g);
    String str2 = arnw.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = becr.jdField_a_of_type_JavaLangString;
    }
    long l2 = auea.a(parambfjs.jdField_e_of_type_JavaLangString);
    boolean bool1 = bool2;
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      bool1 = bool2;
      if (becr.a(parambfjs.jdField_e_of_type_JavaLangString, parambfjs.g, str1))
      {
        bool1 = bool2;
        if (l2 <= l1)
        {
          if (!paramBoolean) {
            break label189;
          }
          if (TextUtils.isEmpty(parambfjs.jdField_e_of_type_JavaLangString)) {
            break label184;
          }
          if (FileUtils.fileExistsAndNotEmpty(parambfjs.jdField_e_of_type_JavaLangString)) {
            break label189;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i != 0)
      {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
        bool1 = true;
      }
      return bool1;
      label184:
      i = 0;
      continue;
      label189:
      i = 1;
    }
  }
  
  private boolean a(MessageForTroopFile paramMessageForTroopFile)
  {
    boolean bool2 = false;
    bfjs localbfjs = bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (localbfjs == null) {}
    boolean bool1;
    do
    {
      return true;
      bool1 = bool2;
      if (paramMessageForTroopFile.lastTime != 0L)
      {
        bool1 = bool2;
        if (paramMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime()) {
          bool1 = true;
        }
      }
    } while (localbfjs.jdField_b_of_type_Int == 12);
    return bool1;
  }
  
  private void b(int paramInt, bfjs parambfjs, ArrayList<Integer> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      return;
      long l = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambfjs.g);
      paramArrayList.add(Integer.valueOf(9));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambfjs, false))) {
        paramArrayList.add(Integer.valueOf(22));
      }
      if (e()) {
        paramArrayList.add(Integer.valueOf(15));
      }
      paramArrayList.add(Integer.valueOf(21));
      paramArrayList.add(Integer.valueOf(10));
      paramArrayList.add(Integer.valueOf(11));
      paramArrayList.add(Integer.valueOf(12));
      if (paramInt == 1) {
        paramArrayList.add(Integer.valueOf(20));
      }
      paramArrayList.add(Integer.valueOf(16));
    } while (!d());
    paramArrayList.add(Integer.valueOf(18));
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!auea.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    bfjs localbfjs;
    bfis localbfis;
    long l;
    do
    {
      return;
      localbfjs = a();
      if (localbfjs == null)
      {
        QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
        return;
      }
      localbfis = new bfis(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
      l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin).longValue();
      paramView = aavz.a(paramView);
      if (localbfjs.jdField_b_of_type_Int == 12)
      {
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697057), new Object[] { bgke.a(localbfjs.g) });
        bgjc.a(this.jdField_a_of_type_AndroidContentContext, paramView, 1);
        return;
      }
    } while ((localbfjs.jdField_b_of_type_Int == 4) || (localbfjs.jdField_b_of_type_Int == 5) || (localbfjs.jdField_b_of_type_Int == 13));
    if (((localbfjs.jdField_b_of_type_Int == 3) || (localbfjs.jdField_b_of_type_Int == 2)) && (!auea.a()))
    {
      localbfis.a(localbfjs.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_videoBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    if (a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile))
    {
      paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697057), new Object[] { bgke.a(localbfjs.g) });
      bgjc.a(this.jdField_a_of_type_AndroidContentContext, paramView, 1);
      return;
    }
    aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, localbfjs, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, paramView, false, false);
  }
  
  private void b(bfjs parambfjs)
  {
    if (parambfjs == null) {}
    do
    {
      return;
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString = parambfjs.jdField_a_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = parambfjs.g;
      localTeamWorkFileImportInfo.j = auea.a(parambfjs.g);
      localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = true;
      localTeamWorkFileImportInfo.jdField_d_of_type_Int = 1;
      localTeamWorkFileImportInfo.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize;
      localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = parambfjs.jdField_e_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_b_of_type_Int = parambfjs.h;
      localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin;
      localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      if (parambfjs.jdField_b_of_type_Int != 12) {
        localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
      }
      localTeamWorkFileImportInfo.jdField_a_of_type_Int = 1;
      beaz.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTeamWorkFileImportInfo.jdField_d_of_type_Int);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
  }
  
  private void b(ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(3));
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if (e()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    paramArrayList.add(Integer.valueOf(21));
    paramArrayList.add(Integer.valueOf(16));
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private void c(int paramInt, bfjs parambfjs, ArrayList<Integer> paramArrayList)
  {
    long l = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambfjs.g);
    if (!FileUtil.isFileExists(parambfjs.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(parambfjs.jdField_a_of_type_JavaLangString)) && (FileUtils.isPicFile(parambfjs.jdField_a_of_type_JavaLangString))) {
        paramArrayList.add(Integer.valueOf(14));
      }
      paramArrayList.add(Integer.valueOf(9));
      paramArrayList.add(Integer.valueOf(10));
      paramArrayList.add(Integer.valueOf(11));
      paramArrayList.add(Integer.valueOf(12));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambfjs, false))) {
        paramArrayList.add(Integer.valueOf(22));
      }
      if (e()) {
        paramArrayList.add(Integer.valueOf(15));
      }
      paramArrayList.add(Integer.valueOf(21));
      if (paramInt == 1) {
        paramArrayList.add(Integer.valueOf(20));
      }
      paramArrayList.add(Integer.valueOf(16));
    } while (!d());
    paramArrayList.add(Integer.valueOf(18));
  }
  
  private void c(ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if (e()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    paramArrayList.add(Integer.valueOf(21));
    paramArrayList.add(Integer.valueOf(16));
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private void d(int paramInt, bfjs parambfjs, ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(9));
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private boolean d()
  {
    return AIOUtils.getAIOMsgMenuDpcConfig(5) == 1;
  }
  
  private void e(int paramInt, bfjs parambfjs, ArrayList<Integer> paramArrayList)
  {
    long l = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambfjs.g);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambfjs, false))) {
      paramArrayList.add(Integer.valueOf(22));
    }
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile));
  }
  
  private void f()
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    Object localObject = a();
    if (((bfjs)localObject).jdField_b_of_type_Int == 12)
    {
      localObject = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697057), new Object[] { bgke.a(((bfjs)localObject).g) });
      bgjc.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, 1);
      return;
    }
    Intent localIntent = new Intent();
    if (bmeb.a().a(((bfjs)localObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize))
    {
      bmeb.a().a(this.jdField_a_of_type_AndroidContentContext, ((bfjs)localObject).jdField_a_of_type_JavaLangString, true);
      return;
    }
    switch (((bfjs)localObject).jdField_b_of_type_Int)
    {
    case 0: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      return;
    case 1: 
    case 2: 
      localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
      TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    }
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin).longValue();
    aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, (bfjs)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, false, false);
  }
  
  private void f(int paramInt, bfjs parambfjs, ArrayList<Integer> paramArrayList)
  {
    long l = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambfjs.g);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambfjs, false))) {
      paramArrayList.add(Integer.valueOf(22));
    }
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private void g()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    String str2 = "2";
    String str1 = str2;
    if (localTroopInfo != null)
    {
      if ((localTroopInfo.troopowneruin != null) && (localTroopInfo.troopowneruin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        str1 = "1";
      }
    }
    else
    {
      if (auea.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) != 0) {
        break label147;
      }
      str2 = "1";
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", str1, str2);
      return;
      str1 = str2;
      if (localTroopInfo.Administrator == null) {
        break;
      }
      str1 = str2;
      if (!localTroopInfo.Administrator.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break;
      }
      str1 = "2";
      break;
      label147:
      if (auea.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2) {
        str2 = "2";
      } else {
        str2 = "3";
      }
    }
  }
  
  private void g(int paramInt, bfjs parambfjs, ArrayList<Integer> paramArrayList)
  {
    long l = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambfjs.g);
    if (!FileUtil.isFileExists(parambfjs.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
    }
    do
    {
      return;
      paramArrayList.add(Integer.valueOf(9));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambfjs, false))) {
        paramArrayList.add(Integer.valueOf(22));
      }
    } while (!d());
    paramArrayList.add(Integer.valueOf(18));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    bfjs localbfjs;
    do
    {
      return 0L;
      localbfjs = a();
    } while (localbfjs == null);
    return localbfjs.jdField_c_of_type_Long;
  }
  
  public atfh a()
  {
    return new atfm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public atfk a()
  {
    return new atfn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  @Nullable
  public bfjs a()
  {
    return bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return "";
    }
    bfjs localbfjs = a();
    if (localbfjs == null) {
      return "";
    }
    return localbfjs.g;
  }
  
  public List<Integer> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return localArrayList;
    }
    bfjs localbfjs = a();
    if (localbfjs == null) {
      return localArrayList;
    }
    if (((aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (FileUtil.fileExistsAndNotEmpty(localbfjs.jdField_a_of_type_JavaLangString))) && (localbfjs.jdField_b_of_type_Int != 12) && (auea.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2)) {
      localArrayList.add(Integer.valueOf(13));
    }
    auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbfjs.g);
    Boolean localBoolean2 = Boolean.valueOf(false);
    Boolean localBoolean1 = localBoolean2;
    switch (localbfjs.jdField_b_of_type_Int)
    {
    default: 
      localBoolean1 = localBoolean2;
    case 4: 
      if (localBoolean1.booleanValue()) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
      }
      break;
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(19));
      return localArrayList;
      localArrayList.add(Integer.valueOf(7));
      localArrayList.add(Integer.valueOf(6));
      localBoolean1 = Boolean.valueOf(true);
      break;
      localArrayList.add(Integer.valueOf(8));
      localArrayList.add(Integer.valueOf(6));
      localBoolean1 = Boolean.valueOf(true);
      break;
      c(localArrayList);
      localBoolean1 = localBoolean2;
      break;
      b(localArrayList);
      localBoolean1 = localBoolean2;
      break;
      a(localArrayList);
      localBoolean1 = localBoolean2;
      break;
      b(paramInt, localbfjs, localArrayList);
      localBoolean1 = Boolean.valueOf(true);
      break;
      c(paramInt, localbfjs, localArrayList);
      localBoolean1 = localBoolean2;
      break;
      a(paramInt, localbfjs, localArrayList);
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(16));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(16));
      localBoolean1 = localBoolean2;
      break;
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
    }
  }
  
  public void a()
  {
    int j = 383;
    if (this.jdField_a_of_type_Boolean)
    {
      e();
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubbleModel", 1, "fetchFileThumb.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) {
        break label38;
      }
    }
    label38:
    TroopFileTransferManager localTroopFileTransferManager;
    bfjs localbfjs;
    int i;
    for (;;)
    {
      return;
      localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
      localbfjs = a();
      if (localbfjs != null)
      {
        if (FileUtil.fileExistsAndNotEmpty(localbfjs.jdField_a_of_type_JavaLangString)) {
          i = j;
        }
        while (localbfjs.jdField_b_of_type_Int != 12)
        {
          if (localbfjs.jdField_a_of_type_JavaUtilUUID == null) {
            break label152;
          }
          localTroopFileTransferManager.a(localbfjs.jdField_a_of_type_JavaUtilUUID, i);
          return;
          i = j;
          if (aues.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height))
          {
            i = j;
            if (!FileUtil.fileExistsAndNotEmpty(localbfjs.jdField_c_of_type_JavaLangString)) {
              i = 640;
            }
          }
        }
      }
    }
    label152:
    localTroopFileTransferManager.a(localbfjs.jdField_e_of_type_JavaLangString, localbfjs.g, localbfjs.h, i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    TroopFileTransferManager localTroopFileTransferManager;
    bfjs localbfjs;
    int i;
    bfis localbfis;
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
              return;
              localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
            } while (localTroopFileTransferManager == null);
            localbfjs = a();
          } while (localbfjs == null);
          i = NetworkUtil.getSystemNetwork(this.jdField_a_of_type_AndroidContentContext);
          localbfis = new bfis(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
          switch (paramInt)
          {
          default: 
            return;
          }
        } while ((localbfjs.jdField_b_of_type_Int != 8) && (localbfjs.jdField_b_of_type_Int != 9) && (localbfjs.jdField_b_of_type_Int != 10));
        localTroopFileTransferManager.d(localbfjs.jdField_a_of_type_JavaUtilUUID);
        a(localbfjs.jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, localbfjs.jdField_a_of_type_JavaUtilUUID);
        return;
        if (i == 0)
        {
          bgjc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697356));
          return;
        }
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
      } while ((localbfjs.jdField_b_of_type_Int != 0) && (localbfjs.jdField_b_of_type_Int != 1));
      localTroopFileTransferManager.a(localbfjs.jdField_a_of_type_JavaUtilUUID);
      return;
    } while ((localbfjs.jdField_b_of_type_Int != 2) && (localbfjs.jdField_b_of_type_Int != 3));
    localbfis.a(localbfjs.jdField_a_of_type_JavaUtilUUID);
    return;
    a(localTroopFileTransferManager, localbfjs, i);
    return;
    a(localbfjs, i);
    return;
    bgke.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return;
    auea.a((Activity)this.jdField_a_of_type_AndroidContentContext, localbfjs.jdField_a_of_type_JavaLangString);
    return;
    bdla.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
    bgke.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return;
    a(localbfjs);
    return;
    g();
    return;
    b(localbfjs);
    return;
    bdla.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, localbfjs.jdField_b_of_type_Long, localbfjs, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, true, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileBubbleModel", 1, "fixMediaWidthAndHeight " + paramInt1 + ":" + paramInt2);
    }
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height = paramInt2;
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    bfjs localbfjs = a();
    if (localbfjs == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    int i = 11;
    switch (auea.a(localbfjs.g))
    {
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68A", "0X800A68A", i, 0, "4", "", "", "");
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
      a(paramView);
      return;
    }
    if (paramInt == 3)
    {
      b(paramView);
      return;
    }
    f();
  }
  
  protected void a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForTroopFile))
    {
      QLog.e("TroopFileBubbleModel", 1, "setBubbleModelData. is not a MessageForTroopFile");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile = ((MessageForTroopFile)paramChatMessage);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isSend();
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    long l;
    do
    {
      return 0L;
      if (a().jdField_b_of_type_Int == 12) {
        return -1L;
      }
      l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime;
    } while (l == 0L);
    l -= bcrg.a();
    if (l > 0L) {
      return l;
    }
    return -1L;
  }
  
  public String b()
  {
    bfjs localbfjs = a();
    if (localbfjs == null) {
      return "";
    }
    if (FileUtils.fileExistsAndNotEmpty(localbfjs.jdField_d_of_type_JavaLangString)) {
      return localbfjs.jdField_d_of_type_JavaLangString;
    }
    if (FileUtils.fileExistsAndNotEmpty(localbfjs.jdField_c_of_type_JavaLangString)) {
      return localbfjs.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
  
  public List<Integer> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    bfjs localbfjs;
    do
    {
      do
      {
        return localArrayList;
        localbfjs = a();
      } while (localbfjs == null);
      if (((aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (FileUtil.fileExistsAndNotEmpty(localbfjs.jdField_a_of_type_JavaLangString))) && (localbfjs != null) && (localbfjs.jdField_b_of_type_Int != 12) && (auea.a(localbfjs.g) == 2)) {
        localArrayList.add(Integer.valueOf(13));
      }
      auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbfjs.g);
      switch (localbfjs.jdField_b_of_type_Int)
      {
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 10: 
      case 12: 
      default: 
        return localArrayList;
      case 6: 
        e(paramInt, localbfjs, localArrayList);
        return localArrayList;
      case 8: 
        localArrayList.add(Integer.valueOf(9));
      }
    } while (!d());
    localArrayList.add(Integer.valueOf(18));
    return localArrayList;
    d(paramInt, localbfjs, localArrayList);
    return localArrayList;
    g(paramInt, localbfjs, localArrayList);
    return localArrayList;
    f(paramInt, localbfjs, localArrayList);
    return localArrayList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.url;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(str))
    {
      bdla.b(null, "dc00898", "", "", "0X800A685", "0X800A685", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(str);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a();
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    while (a().jdField_b_of_type_Int != 3) {
      return false;
    }
    return true;
  }
  
  public int c()
  {
    int i = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return 0;
    }
    bfjs localbfjs = a();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime != 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime())) {
      return 6;
    }
    if (localbfjs.jdField_b_of_type_Int == 12) {
      return 1;
    }
    switch (localbfjs.jdField_b_of_type_Int)
    {
    case 4: 
    default: 
      i = 0;
    }
    for (;;)
    {
      return i;
      i = 0;
      continue;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 2;
      continue;
      i = 2;
    }
  }
  
  public String c()
  {
    return this.jdField_a_of_type_AndroidContentContext.getString(2131696949);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      return;
      localObject = a();
    } while ((localObject == null) || (((bfjs)localObject).jdField_b_of_type_Int != 3));
    Object localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)localObject, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    bfjs localbfjs;
    do
    {
      return false;
      localbfjs = a();
    } while ((localbfjs == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg));
    int i = auea.a(localbfjs.g);
    if ((i == 2) || (i == 0))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isSend()) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return true;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return -1;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isSend();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
      bool = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    }
    bfjs localbfjs = a();
    switch (localbfjs.jdField_b_of_type_Int)
    {
    case 2: 
    case 4: 
    case 5: 
    case 7: 
    case 9: 
    default: 
    case 0: 
    case 1: 
    case 6: 
    case 8: 
    case 11: 
      do
      {
        do
        {
          do
          {
            return 0;
            return 1;
          } while (!FileUtils.fileExistsAndNotEmpty(localbfjs.jdField_a_of_type_JavaLangString));
          return 2;
          return 4;
          if (!bool) {
            break;
          }
        } while (!FileUtils.fileExistsAndNotEmpty(localbfjs.jdField_a_of_type_JavaLangString));
        return 2;
      } while (!FileUtils.fileExistsAndNotEmpty(localbfjs.jdField_a_of_type_JavaLangString));
      return 5;
    case 3: 
      return 3;
    }
    return 6;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.a(localActivity, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    bfjs localbfjs;
    do
    {
      return 0;
      localbfjs = a();
    } while (localbfjs == null);
    return bgke.a(localbfjs.jdField_d_of_type_Long, localbfjs.jdField_c_of_type_Long);
  }
  
  public int f()
  {
    bfjs localbfjs = a();
    if (localbfjs == null) {}
    while (localbfjs.jdField_c_of_type_Boolean) {
      return 0;
    }
    if (aufd.a(localbfjs.jdField_e_of_type_Int, localbfjs.f, localbfjs.jdField_c_of_type_Long)) {
      return 1;
    }
    if (localbfjs.j == 1) {
      return 1;
    }
    if (localbfjs.j == 2) {
      return 2;
    }
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atko
 * JD-Core Version:    0.7.0.1
 */