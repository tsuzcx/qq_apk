import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class asgi
  extends asgh
{
  private MessageForTroopFile a;
  private boolean b;
  private boolean c;
  
  public asgi(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(int paramInt, becp parambecp, ArrayList<Integer> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    long l = aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambecp.g);
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambecp, false))) {
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
    paramUUID = new asgj(this, paramLong, paramUUID, paramActivity);
    bfur.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131696743), this.jdField_a_of_type_AndroidContentContext.getString(2131696771), 2131696741, 2131696758, paramUUID, paramUUID).show();
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new asgk(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    bfur.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131696747), this.jdField_a_of_type_AndroidContentContext.getString(2131696772), 2131696745, 2131696760, paramUUID, paramUUID).show();
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!aszt.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    becp localbecp = a();
    if (localbecp == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    switch (localbecp.jdField_b_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_picBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      agjt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
      return;
    }
    paramView = new Intent();
    paramView.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void a(becp parambecp)
  {
    FileManagerEntity localFileManagerEntity = aszt.a(parambecp);
    parambecp = bfbb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambecp.jdField_b_of_type_Long).a(localFileManagerEntity.strTroopFilePath);
    if (parambecp != null)
    {
      localFileManagerEntity.lastTime = parambecp.c;
      localFileManagerEntity.selfUin = String.valueOf(parambecp.jdField_b_of_type_Long);
    }
    new bkov(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, false);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
    }
  }
  
  private void a(becp parambecp, int paramInt)
  {
    if (paramInt == 0)
    {
      bfaw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697079));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    Object localObject = aszt.a(parambecp);
    ((FileManagerEntity)localObject).status = 2;
    ((FileManagerEntity)localObject).nOpType = 24;
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.b(10006);
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
      localForwardFileInfo.a(parambecp.jdField_a_of_type_JavaLangString);
    }
    localForwardFileInfo.d(parambecp.g);
    localForwardFileInfo.d(parambecp.jdField_c_of_type_Long);
    localForwardFileInfo.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
    if (parambecp.jdField_a_of_type_JavaUtilUUID != null) {
      localForwardFileInfo.e(parambecp.jdField_a_of_type_JavaUtilUUID.toString());
    }
    if (!TextUtils.isEmpty(parambecp.jdField_c_of_type_JavaLangString)) {
      localForwardFileInfo.f(parambecp.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      localForwardFileInfo.d(1);
      localForwardFileInfo.a(1);
      localBundle.putParcelable("fileinfo", localForwardFileInfo);
      localBundle.putBoolean("not_forward", true);
      localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).putExtra("forward_text", parambecp.g);
      ((Intent)localObject).putExtra("forward_from_troop_file", true);
      localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
      ((Intent)localObject).putExtra("forward _key_nojump", true);
      ((Intent)localObject).putExtra("sender_uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin);
      ((Intent)localObject).putExtra("last_time", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime);
      atky.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
      if (!TextUtils.isEmpty(parambecp.jdField_d_of_type_JavaLangString)) {
        localForwardFileInfo.f(parambecp.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  private void a(TroopFileTransferManager paramTroopFileTransferManager, becp parambecp, int paramInt)
  {
    if (paramInt == 0) {
      bfaw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697079));
    }
    while ((parambecp.jdField_b_of_type_Int != 1) && (parambecp.jdField_b_of_type_Int != 0) && (parambecp.jdField_b_of_type_Int != 2) && (parambecp.jdField_b_of_type_Int != 3)) {
      return;
    }
    paramTroopFileTransferManager.a(parambecp.jdField_a_of_type_JavaUtilUUID);
    a(parambecp.jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, parambecp.jdField_a_of_type_JavaUtilUUID, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
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
  
  private boolean a(becp parambecp, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = aqjv.a().c();
      this.jdField_b_of_type_Boolean = false;
    }
    long l1 = aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambecp.g);
    String str2 = aqkl.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = bcvs.jdField_a_of_type_JavaLangString;
    }
    long l2 = aszt.a(parambecp.jdField_e_of_type_JavaLangString);
    boolean bool1 = bool2;
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      bool1 = bool2;
      if (bcvs.a(parambecp.jdField_e_of_type_JavaLangString, parambecp.g, str1))
      {
        bool1 = bool2;
        if (l2 <= l1)
        {
          if (!paramBoolean) {
            break label189;
          }
          if (TextUtils.isEmpty(parambecp.jdField_e_of_type_JavaLangString)) {
            break label184;
          }
          if (FileUtils.fileExistsAndNotEmpty(parambecp.jdField_e_of_type_JavaLangString)) {
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
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
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
    becp localbecp = bfby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (localbecp == null) {}
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
    } while (localbecp.jdField_b_of_type_Int == 12);
    return bool1;
  }
  
  private void b(int paramInt, becp parambecp, ArrayList<Integer> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      return;
      long l = aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambecp.g);
      paramArrayList.add(Integer.valueOf(9));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambecp, false))) {
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!aszt.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    becp localbecp;
    bebp localbebp;
    long l;
    do
    {
      return;
      localbecp = a();
      if (localbecp == null)
      {
        QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
        return;
      }
      localbebp = new bebp(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
      l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin).longValue();
      paramView = aagn.a(paramView);
      if (localbecp.jdField_b_of_type_Int == 12)
      {
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696790), new Object[] { bfby.a(localbecp.g) });
        bfaw.a(this.jdField_a_of_type_AndroidContentContext, paramView, 1);
        return;
      }
    } while ((localbecp.jdField_b_of_type_Int == 4) || (localbecp.jdField_b_of_type_Int == 5) || (localbecp.jdField_b_of_type_Int == 13));
    if (((localbecp.jdField_b_of_type_Int == 3) || (localbecp.jdField_b_of_type_Int == 2)) && (!aszt.a()))
    {
      localbebp.a(localbecp.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_videoBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    if (a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile))
    {
      paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696790), new Object[] { bfby.a(localbecp.g) });
      bfaw.a(this.jdField_a_of_type_AndroidContentContext, paramView, 1);
      return;
    }
    ataw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, localbecp, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, paramView, false, false);
  }
  
  private void b(becp parambecp)
  {
    if (parambecp == null) {}
    do
    {
      return;
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString = parambecp.jdField_a_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = parambecp.g;
      localTeamWorkFileImportInfo.j = aszt.a(parambecp.g);
      localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = true;
      localTeamWorkFileImportInfo.jdField_d_of_type_Int = 1;
      localTeamWorkFileImportInfo.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize;
      localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = parambecp.jdField_e_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_b_of_type_Int = parambecp.h;
      localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin;
      localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      if (parambecp.jdField_b_of_type_Int != 12) {
        localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
      }
      localTeamWorkFileImportInfo.jdField_a_of_type_Int = 1;
      bcua.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTeamWorkFileImportInfo.jdField_d_of_type_Int);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
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
  
  private void c(int paramInt, becp parambecp, ArrayList<Integer> paramArrayList)
  {
    long l = aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambecp.g);
    if (!FileUtil.isFileExists(parambecp.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(parambecp.jdField_a_of_type_JavaLangString)) && (FileUtils.isPicFile(parambecp.jdField_a_of_type_JavaLangString))) {
        paramArrayList.add(Integer.valueOf(14));
      }
      paramArrayList.add(Integer.valueOf(9));
      paramArrayList.add(Integer.valueOf(10));
      paramArrayList.add(Integer.valueOf(11));
      paramArrayList.add(Integer.valueOf(12));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambecp, false))) {
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
  
  private void d(int paramInt, becp parambecp, ArrayList<Integer> paramArrayList)
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
  
  private void e(int paramInt, becp parambecp, ArrayList<Integer> paramArrayList)
  {
    long l = aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambecp.g);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambecp, false))) {
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
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    Object localObject = a();
    if (((becp)localObject).jdField_b_of_type_Int == 12)
    {
      localObject = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696790), new Object[] { bfby.a(((becp)localObject).g) });
      bfaw.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, 1);
      return;
    }
    Intent localIntent = new Intent();
    if (bkss.a().a(((becp)localObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize))
    {
      bkss.a().a(this.jdField_a_of_type_AndroidContentContext, ((becp)localObject).jdField_a_of_type_JavaLangString, true);
      return;
    }
    switch (((becp)localObject).jdField_b_of_type_Int)
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
    ataw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, (becp)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, false, false);
  }
  
  private void f(int paramInt, becp parambecp, ArrayList<Integer> paramArrayList)
  {
    long l = aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambecp.g);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambecp, false))) {
      paramArrayList.add(Integer.valueOf(22));
    }
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private void g()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
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
      if (aszt.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) != 0) {
        break label146;
      }
      str2 = "1";
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", str1, str2);
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
      label146:
      if (aszt.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2) {
        str2 = "2";
      } else {
        str2 = "3";
      }
    }
  }
  
  private void g(int paramInt, becp parambecp, ArrayList<Integer> paramArrayList)
  {
    long l = aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambecp.g);
    if (!FileUtil.isFileExists(parambecp.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
    }
    do
    {
      return;
      paramArrayList.add(Integer.valueOf(9));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambecp, false))) {
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
    becp localbecp;
    do
    {
      return 0L;
      localbecp = a();
    } while (localbecp == null);
    return localbecp.jdField_c_of_type_Long;
  }
  
  public asbb a()
  {
    return new asbg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public asbe a()
  {
    return new asbh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  @Nullable
  public becp a()
  {
    return bfby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return "";
    }
    becp localbecp = a();
    if (localbecp == null) {
      return "";
    }
    return localbecp.g;
  }
  
  public List<Integer> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return localArrayList;
    }
    becp localbecp = a();
    if (localbecp == null) {
      return localArrayList;
    }
    if (((ataw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (FileUtil.fileExistsAndNotEmpty(localbecp.jdField_a_of_type_JavaLangString))) && (localbecp.jdField_b_of_type_Int != 12) && (aszt.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2)) {
      localArrayList.add(Integer.valueOf(13));
    }
    aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbecp.g);
    Boolean localBoolean2 = Boolean.valueOf(false);
    Boolean localBoolean1 = localBoolean2;
    switch (localbecp.jdField_b_of_type_Int)
    {
    default: 
      localBoolean1 = localBoolean2;
    case 4: 
      if (localBoolean1.booleanValue()) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
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
      b(paramInt, localbecp, localArrayList);
      localBoolean1 = Boolean.valueOf(true);
      break;
      c(paramInt, localbecp, localArrayList);
      localBoolean1 = localBoolean2;
      break;
      a(paramInt, localbecp, localArrayList);
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(16));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(16));
      localBoolean1 = localBoolean2;
      break;
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
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
    becp localbecp;
    int i;
    for (;;)
    {
      return;
      localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
      localbecp = a();
      if (localbecp != null)
      {
        if (FileUtil.fileExistsAndNotEmpty(localbecp.jdField_a_of_type_JavaLangString)) {
          i = j;
        }
        while (localbecp.jdField_b_of_type_Int != 12)
        {
          if (localbecp.jdField_a_of_type_JavaUtilUUID == null) {
            break label152;
          }
          localTroopFileTransferManager.a(localbecp.jdField_a_of_type_JavaUtilUUID, i);
          return;
          i = j;
          if (atal.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height))
          {
            i = j;
            if (!FileUtil.fileExistsAndNotEmpty(localbecp.jdField_c_of_type_JavaLangString)) {
              i = 640;
            }
          }
        }
      }
    }
    label152:
    localTroopFileTransferManager.a(localbecp.jdField_e_of_type_JavaLangString, localbecp.g, localbecp.h, i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    TroopFileTransferManager localTroopFileTransferManager;
    becp localbecp;
    int i;
    bebp localbebp;
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
            localbecp = a();
          } while (localbecp == null);
          i = NetworkUtil.getSystemNetwork(this.jdField_a_of_type_AndroidContentContext);
          localbebp = new bebp(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
          switch (paramInt)
          {
          default: 
            return;
          }
        } while ((localbecp.jdField_b_of_type_Int != 8) && (localbecp.jdField_b_of_type_Int != 9) && (localbecp.jdField_b_of_type_Int != 10));
        localTroopFileTransferManager.d(localbecp.jdField_a_of_type_JavaUtilUUID);
        a(localbecp.jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, localbecp.jdField_a_of_type_JavaUtilUUID);
        return;
        if (i == 0)
        {
          bfaw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697079));
          return;
        }
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
      } while ((localbecp.jdField_b_of_type_Int != 0) && (localbecp.jdField_b_of_type_Int != 1));
      localTroopFileTransferManager.a(localbecp.jdField_a_of_type_JavaUtilUUID);
      return;
    } while ((localbecp.jdField_b_of_type_Int != 2) && (localbecp.jdField_b_of_type_Int != 3));
    localbebp.a(localbecp.jdField_a_of_type_JavaUtilUUID);
    return;
    a(localTroopFileTransferManager, localbecp, i);
    return;
    a(localbecp, i);
    return;
    bfby.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return;
    aszt.a((Activity)this.jdField_a_of_type_AndroidContentContext, localbecp.jdField_a_of_type_JavaLangString);
    return;
    bcef.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
    bfby.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return;
    a(localbecp);
    return;
    g();
    return;
    b(localbecp);
    return;
    bcef.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    ataw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, localbecp.jdField_b_of_type_Long, localbecp, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, true, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    becp localbecp = a();
    if (localbecp == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    int i = 11;
    switch (aszt.a(localbecp.g))
    {
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68A", "0X800A68A", i, 0, "4", "", "", "");
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
    l -= bbko.a();
    if (l > 0L) {
      return l;
    }
    return -1L;
  }
  
  public String b()
  {
    becp localbecp = a();
    if (localbecp == null) {
      return "";
    }
    if (FileUtils.fileExistsAndNotEmpty(localbecp.jdField_d_of_type_JavaLangString)) {
      return localbecp.jdField_d_of_type_JavaLangString;
    }
    if (FileUtils.fileExistsAndNotEmpty(localbecp.jdField_c_of_type_JavaLangString)) {
      return localbecp.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
  
  public List<Integer> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    becp localbecp;
    do
    {
      do
      {
        return localArrayList;
        localbecp = a();
      } while (localbecp == null);
      if (((ataw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (FileUtil.fileExistsAndNotEmpty(localbecp.jdField_a_of_type_JavaLangString))) && (localbecp != null) && (localbecp.jdField_b_of_type_Int != 12) && (aszt.a(localbecp.g) == 2)) {
        localArrayList.add(Integer.valueOf(13));
      }
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbecp.g);
      switch (localbecp.jdField_b_of_type_Int)
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
        e(paramInt, localbecp, localArrayList);
        return localArrayList;
      case 8: 
        localArrayList.add(Integer.valueOf(9));
      }
    } while (!d());
    localArrayList.add(Integer.valueOf(18));
    return localArrayList;
    d(paramInt, localbecp, localArrayList);
    return localArrayList;
    g(paramInt, localbecp, localArrayList);
    return localArrayList;
    f(paramInt, localbecp, localArrayList);
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
      bcef.b(null, "dc00898", "", "", "0X800A685", "0X800A685", 0, 0, "", "", "", "");
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
    becp localbecp = a();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime != 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime())) {
      return 6;
    }
    if (localbecp.jdField_b_of_type_Int == 12) {
      return 1;
    }
    switch (localbecp.jdField_b_of_type_Int)
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
    return this.jdField_a_of_type_AndroidContentContext.getString(2131696682);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      return;
      localObject = a();
    } while ((localObject == null) || (((becp)localObject).jdField_b_of_type_Int != 3));
    Object localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)localObject, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    becp localbecp;
    do
    {
      return false;
      localbecp = a();
    } while ((localbecp == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg));
    int i = aszt.a(localbecp.g);
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
      bool = aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    }
    becp localbecp = a();
    switch (localbecp.jdField_b_of_type_Int)
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
          } while (!FileUtils.fileExistsAndNotEmpty(localbecp.jdField_a_of_type_JavaLangString));
          return 2;
          return 4;
          if (!bool) {
            break;
          }
        } while (!FileUtils.fileExistsAndNotEmpty(localbecp.jdField_a_of_type_JavaLangString));
        return 2;
      } while (!FileUtils.fileExistsAndNotEmpty(localbecp.jdField_a_of_type_JavaLangString));
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
    becp localbecp;
    do
    {
      return 0;
      localbecp = a();
    } while (localbecp == null);
    return bfby.a(localbecp.jdField_d_of_type_Long, localbecp.jdField_c_of_type_Long);
  }
  
  public int f()
  {
    becp localbecp = a();
    if (localbecp == null) {}
    while (localbecp.jdField_c_of_type_Boolean) {
      return 0;
    }
    if (ataw.a(localbecp.jdField_e_of_type_Int, localbecp.f, localbecp.jdField_c_of_type_Long)) {
      return 1;
    }
    if (localbecp.j == 1) {
      return 1;
    }
    if (localbecp.j == 2) {
      return 2;
    }
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgi
 * JD-Core Version:    0.7.0.1
 */