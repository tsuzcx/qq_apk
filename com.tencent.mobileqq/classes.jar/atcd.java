import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public class atcd
  extends atcc
{
  private MessageForTroopFile a;
  private boolean b;
  private boolean c;
  
  public atcd(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(int paramInt, bety parambety, ArrayList<Integer> paramArrayList)
  {
    long l = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambety.g);
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambety, false))) {
      paramArrayList.add(Integer.valueOf(21));
    }
    paramArrayList.add(Integer.valueOf(20));
    if (e()) {
      paramArrayList.add(Integer.valueOf(14));
    }
    if (paramInt == 1) {
      paramArrayList.add(Integer.valueOf(19));
    }
    paramArrayList.add(Integer.valueOf(15));
    if (d()) {
      paramArrayList.add(Integer.valueOf(17));
    }
    paramArrayList.add(Integer.valueOf(11));
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new atce(this, paramLong, paramUUID, paramActivity);
    bglp.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131696559), this.jdField_a_of_type_AndroidContentContext.getString(2131696581), 2131696557, 2131696568, paramUUID, paramUUID).show();
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new atcf(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    bglp.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131696563), this.jdField_a_of_type_AndroidContentContext.getString(2131696582), 2131696561, 2131696570, paramUUID, paramUUID).show();
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!atvo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    bety localbety = a();
    if (localbety == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    switch (localbety.jdField_b_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_picBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      ahdu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
      return;
    }
    paramView = new Intent();
    paramView.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void a(bety parambety)
  {
    FileManagerEntity localFileManagerEntity = atvo.a(parambety);
    parambety = bfrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambety.jdField_b_of_type_Long).a(localFileManagerEntity.strTroopFilePath);
    if (parambety != null)
    {
      localFileManagerEntity.lastTime = parambety.c;
      localFileManagerEntity.selfUin = String.valueOf(parambety.jdField_b_of_type_Long);
    }
    new bljl(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, false);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
    }
  }
  
  private void a(bety parambety, int paramInt)
  {
    if (paramInt == 0)
    {
      bfrh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131696888));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    Object localObject = atvo.a(parambety);
    ((FileManagerEntity)localObject).status = 2;
    ((FileManagerEntity)localObject).nOpType = 24;
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.b(10006);
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
      localForwardFileInfo.a(parambety.jdField_a_of_type_JavaLangString);
    }
    localForwardFileInfo.d(parambety.g);
    localForwardFileInfo.d(parambety.jdField_c_of_type_Long);
    localForwardFileInfo.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
    if (parambety.jdField_a_of_type_JavaUtilUUID != null) {
      localForwardFileInfo.e(parambety.jdField_a_of_type_JavaUtilUUID.toString());
    }
    if (!TextUtils.isEmpty(parambety.jdField_c_of_type_JavaLangString)) {
      localForwardFileInfo.f(parambety.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      localForwardFileInfo.d(1);
      localForwardFileInfo.a(1);
      localBundle.putParcelable("fileinfo", localForwardFileInfo);
      localBundle.putBoolean("not_forward", true);
      localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).putExtra("forward_text", parambety.g);
      ((Intent)localObject).putExtra("forward_from_troop_file", true);
      localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
      ((Intent)localObject).putExtra("forward _key_nojump", true);
      ((Intent)localObject).putExtra("sender_uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin);
      ((Intent)localObject).putExtra("last_time", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime);
      aufz.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
      if (!TextUtils.isEmpty(parambety.jdField_d_of_type_JavaLangString)) {
        localForwardFileInfo.f(parambety.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  private void a(TroopFileTransferManager paramTroopFileTransferManager, bety parambety, int paramInt)
  {
    if (paramInt == 0) {
      bfrh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131696888));
    }
    while ((parambety.jdField_b_of_type_Int != 1) && (parambety.jdField_b_of_type_Int != 0) && (parambety.jdField_b_of_type_Int != 2) && (parambety.jdField_b_of_type_Int != 3)) {
      return;
    }
    paramTroopFileTransferManager.a(parambety.jdField_a_of_type_JavaUtilUUID);
    a(parambety.jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, parambety.jdField_a_of_type_JavaUtilUUID, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
  }
  
  private void a(ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(3));
    paramArrayList.add(Integer.valueOf(10));
    if (e()) {
      paramArrayList.add(Integer.valueOf(14));
    }
    paramArrayList.add(Integer.valueOf(15));
  }
  
  private boolean a(bety parambety, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = arag.a().c();
      this.jdField_b_of_type_Boolean = false;
    }
    long l1 = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambety.g);
    String str2 = araw.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = bdjg.jdField_a_of_type_JavaLangString;
    }
    long l2 = atvo.a(parambety.jdField_e_of_type_JavaLangString);
    boolean bool1 = bool2;
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      bool1 = bool2;
      if (bdjg.a(parambety.jdField_e_of_type_JavaLangString, parambety.g, str1))
      {
        bool1 = bool2;
        if (l2 <= l1)
        {
          if (!paramBoolean) {
            break label189;
          }
          if (TextUtils.isEmpty(parambety.jdField_e_of_type_JavaLangString)) {
            break label184;
          }
          if (bgmg.b(parambety.jdField_e_of_type_JavaLangString)) {
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
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
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
    bety localbety = bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (localbety == null) {}
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
    } while (localbety.jdField_b_of_type_Int == 12);
    return bool1;
  }
  
  private void b(int paramInt, bety parambety, ArrayList<Integer> paramArrayList)
  {
    long l = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambety.g);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambety, false))) {
      paramArrayList.add(Integer.valueOf(21));
    }
    if (e()) {
      paramArrayList.add(Integer.valueOf(14));
    }
    paramArrayList.add(Integer.valueOf(20));
    paramArrayList.add(Integer.valueOf(10));
    paramArrayList.add(Integer.valueOf(11));
    if (paramInt == 1) {
      paramArrayList.add(Integer.valueOf(19));
    }
    paramArrayList.add(Integer.valueOf(15));
    if (d()) {
      paramArrayList.add(Integer.valueOf(17));
    }
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!atvo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    bety localbety;
    besy localbesy;
    long l;
    do
    {
      return;
      localbety = a();
      if (localbety == null)
      {
        QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
        return;
      }
      localbesy = new besy(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
      l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin).longValue();
      paramView = abga.a(paramView);
      if (localbety.jdField_b_of_type_Int == 12)
      {
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696600), new Object[] { bfsj.a(localbety.g) });
        bfrh.a(this.jdField_a_of_type_AndroidContentContext, paramView, 1);
        return;
      }
    } while ((localbety.jdField_b_of_type_Int == 4) || (localbety.jdField_b_of_type_Int == 5) || (localbety.jdField_b_of_type_Int == 13));
    if (((localbety.jdField_b_of_type_Int == 3) || (localbety.jdField_b_of_type_Int == 2)) && (!atvo.a()))
    {
      localbesy.a(localbety.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_videoBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    if (a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile))
    {
      paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696600), new Object[] { bfsj.a(localbety.g) });
      bfrh.a(this.jdField_a_of_type_AndroidContentContext, paramView, 1);
      return;
    }
    atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, localbety, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, paramView, false, false);
  }
  
  private void b(bety parambety)
  {
    if (parambety == null) {}
    do
    {
      return;
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString = parambety.jdField_a_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = parambety.g;
      localTeamWorkFileImportInfo.j = atvo.a(parambety.g);
      localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = true;
      localTeamWorkFileImportInfo.jdField_d_of_type_Int = 1;
      localTeamWorkFileImportInfo.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize;
      localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = parambety.jdField_e_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_b_of_type_Int = parambety.h;
      localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (parambety.jdField_b_of_type_Int != 12) {
        localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
      }
      localTeamWorkFileImportInfo.jdField_a_of_type_Int = 1;
      bdho.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTeamWorkFileImportInfo.jdField_d_of_type_Int);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
  }
  
  private void b(ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(3));
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if (e()) {
      paramArrayList.add(Integer.valueOf(14));
    }
    paramArrayList.add(Integer.valueOf(20));
    paramArrayList.add(Integer.valueOf(15));
    if (d()) {
      paramArrayList.add(Integer.valueOf(17));
    }
  }
  
  private void c(int paramInt, bety parambety, ArrayList<Integer> paramArrayList)
  {
    long l = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambety.g);
    if (!atwl.a(parambety.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(parambety.jdField_a_of_type_JavaLangString)) && (bgmg.e(parambety.jdField_a_of_type_JavaLangString))) {
        paramArrayList.add(Integer.valueOf(13));
      }
      paramArrayList.add(Integer.valueOf(9));
      paramArrayList.add(Integer.valueOf(10));
      paramArrayList.add(Integer.valueOf(11));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambety, false))) {
        paramArrayList.add(Integer.valueOf(21));
      }
      if (e()) {
        paramArrayList.add(Integer.valueOf(14));
      }
      paramArrayList.add(Integer.valueOf(20));
      if (paramInt == 1) {
        paramArrayList.add(Integer.valueOf(19));
      }
      paramArrayList.add(Integer.valueOf(15));
    } while (!d());
    paramArrayList.add(Integer.valueOf(17));
  }
  
  private void c(ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if (e()) {
      paramArrayList.add(Integer.valueOf(14));
    }
    paramArrayList.add(Integer.valueOf(20));
    paramArrayList.add(Integer.valueOf(15));
    if (d()) {
      paramArrayList.add(Integer.valueOf(17));
    }
  }
  
  private void d(int paramInt, bety parambety, ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(9));
    if (d()) {
      paramArrayList.add(Integer.valueOf(17));
    }
  }
  
  private boolean d()
  {
    return afur.a(5) == 1;
  }
  
  private void e(int paramInt, bety parambety, ArrayList<Integer> paramArrayList)
  {
    long l = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambety.g);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambety, false))) {
      paramArrayList.add(Integer.valueOf(21));
    }
    if (d()) {
      paramArrayList.add(Integer.valueOf(17));
    }
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile));
  }
  
  private void f()
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    Object localObject = a();
    if (((bety)localObject).jdField_b_of_type_Int == 12)
    {
      localObject = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696600), new Object[] { bfsj.a(((bety)localObject).g) });
      bfrh.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, 1);
      return;
    }
    Intent localIntent = new Intent();
    if (blni.a().a(((bety)localObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize))
    {
      blni.a().a(this.jdField_a_of_type_AndroidContentContext, ((bety)localObject).jdField_a_of_type_JavaLangString, true);
      return;
    }
    switch (((bety)localObject).jdField_b_of_type_Int)
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
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
    atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, (bety)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, false, false);
  }
  
  private void f(int paramInt, bety parambety, ArrayList<Integer> paramArrayList)
  {
    long l = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambety.g);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambety, false))) {
      paramArrayList.add(Integer.valueOf(21));
    }
    if (d()) {
      paramArrayList.add(Integer.valueOf(17));
    }
  }
  
  private void g()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
      if (atvo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) != 0) {
        break label146;
      }
      str2 = "1";
    }
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", str1, str2);
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
      if (atvo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2) {
        str2 = "2";
      } else {
        str2 = "3";
      }
    }
  }
  
  private void g(int paramInt, bety parambety, ArrayList<Integer> paramArrayList)
  {
    long l = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambety.g);
    if (!atwl.a(parambety.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
    }
    do
    {
      return;
      paramArrayList.add(Integer.valueOf(9));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambety, false))) {
        paramArrayList.add(Integer.valueOf(21));
      }
    } while (!d());
    paramArrayList.add(Integer.valueOf(17));
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
    bety localbety;
    do
    {
      return 0L;
      localbety = a();
    } while (localbety == null);
    return localbety.jdField_c_of_type_Long;
  }
  
  public asyo a()
  {
    return new asyt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public asyr a()
  {
    return new asyu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  @Nullable
  public bety a()
  {
    return bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return "";
    }
    bety localbety = a();
    if (localbety == null) {
      return "";
    }
    return localbety.g;
  }
  
  public List<Integer> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return localArrayList;
    }
    bety localbety = a();
    if (localbety == null) {
      return localArrayList;
    }
    if (((atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (atwl.b(localbety.jdField_a_of_type_JavaLangString))) && (localbety.jdField_b_of_type_Int != 12) && (atvo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2)) {
      localArrayList.add(Integer.valueOf(12));
    }
    atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbety.g);
    Boolean localBoolean2 = Boolean.valueOf(false);
    Boolean localBoolean1 = localBoolean2;
    switch (localbety.jdField_b_of_type_Int)
    {
    default: 
      localBoolean1 = localBoolean2;
    case 4: 
      if (localBoolean1.booleanValue()) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
      }
      break;
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(18));
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
      b(paramInt, localbety, localArrayList);
      localBoolean1 = Boolean.valueOf(true);
      break;
      c(paramInt, localbety, localArrayList);
      localBoolean1 = localBoolean2;
      break;
      a(paramInt, localbety, localArrayList);
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(15));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(15));
      localBoolean1 = localBoolean2;
      break;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
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
    bety localbety;
    int i;
    for (;;)
    {
      return;
      localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
      localbety = a();
      if (localbety != null)
      {
        if (atwl.b(localbety.jdField_a_of_type_JavaLangString)) {
          i = j;
        }
        while (localbety.jdField_b_of_type_Int != 12)
        {
          if (localbety.jdField_a_of_type_JavaUtilUUID == null) {
            break label152;
          }
          localTroopFileTransferManager.a(localbety.jdField_a_of_type_JavaUtilUUID, i);
          return;
          i = j;
          if (atwg.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height))
          {
            i = j;
            if (!atwl.b(localbety.jdField_c_of_type_JavaLangString)) {
              i = 640;
            }
          }
        }
      }
    }
    label152:
    localTroopFileTransferManager.a(localbety.jdField_e_of_type_JavaLangString, localbety.g, localbety.h, i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    TroopFileTransferManager localTroopFileTransferManager;
    bety localbety;
    int i;
    besy localbesy;
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
            localbety = a();
          } while (localbety == null);
          i = bgnt.a(this.jdField_a_of_type_AndroidContentContext);
          localbesy = new besy(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
          switch (paramInt)
          {
          default: 
            return;
          }
        } while ((localbety.jdField_b_of_type_Int != 8) && (localbety.jdField_b_of_type_Int != 9) && (localbety.jdField_b_of_type_Int != 10));
        localTroopFileTransferManager.d(localbety.jdField_a_of_type_JavaUtilUUID);
        a(localbety.jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, localbety.jdField_a_of_type_JavaUtilUUID);
        return;
        if (i == 0)
        {
          bfrh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131696888));
          return;
        }
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
      } while ((localbety.jdField_b_of_type_Int != 0) && (localbety.jdField_b_of_type_Int != 1));
      localTroopFileTransferManager.a(localbety.jdField_a_of_type_JavaUtilUUID);
      return;
    } while ((localbety.jdField_b_of_type_Int != 2) && (localbety.jdField_b_of_type_Int != 3));
    localbesy.a(localbety.jdField_a_of_type_JavaUtilUUID);
    return;
    a(localTroopFileTransferManager, localbety, i);
    return;
    a(localbety, i);
    return;
    bfsj.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return;
    atvo.a((Activity)this.jdField_a_of_type_AndroidContentContext, localbety.jdField_a_of_type_JavaLangString);
    return;
    bcst.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
    bfsj.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return;
    a(localbety);
    return;
    g();
    return;
    b(localbety);
    return;
    bcst.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, localbety.jdField_b_of_type_Long, localbety, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, true, false);
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
    bety localbety = a();
    if (localbety == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    int i = 11;
    switch (atvo.a(localbety.g))
    {
    }
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68A", "0X800A68A", i, 0, "4", "", "", "");
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
    l -= bbyp.a();
    if (l > 0L) {
      return l;
    }
    return -1L;
  }
  
  public String b()
  {
    bety localbety = a();
    if (localbety == null) {
      return "";
    }
    if (bgmg.b(localbety.jdField_d_of_type_JavaLangString)) {
      return localbety.jdField_d_of_type_JavaLangString;
    }
    if (bgmg.b(localbety.jdField_c_of_type_JavaLangString)) {
      return localbety.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
  
  public List<Integer> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    bety localbety;
    do
    {
      do
      {
        return localArrayList;
        localbety = a();
      } while (localbety == null);
      if (((atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (atwl.b(localbety.jdField_a_of_type_JavaLangString))) && (localbety != null) && (localbety.jdField_b_of_type_Int != 12) && (atvo.a(localbety.g) == 2)) {
        localArrayList.add(Integer.valueOf(12));
      }
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbety.g);
      switch (localbety.jdField_b_of_type_Int)
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
        e(paramInt, localbety, localArrayList);
        return localArrayList;
      case 8: 
        localArrayList.add(Integer.valueOf(9));
      }
    } while (!d());
    localArrayList.add(Integer.valueOf(17));
    return localArrayList;
    d(paramInt, localbety, localArrayList);
    return localArrayList;
    g(paramInt, localbety, localArrayList);
    return localArrayList;
    f(paramInt, localbety, localArrayList);
    return localArrayList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.url;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str))
    {
      bcst.b(null, "dc00898", "", "", "0X800A685", "0X800A685", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
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
    bety localbety = a();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime != 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime())) {
      return 6;
    }
    if (localbety.jdField_b_of_type_Int == 12) {
      return 1;
    }
    switch (localbety.jdField_b_of_type_Int)
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
    return this.jdField_a_of_type_AndroidContentContext.getString(2131696498);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      return;
      localObject = a();
    } while ((localObject == null) || (((bety)localObject).jdField_b_of_type_Int != 3));
    Object localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)localObject, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    bety localbety;
    do
    {
      return false;
      localbety = a();
    } while ((localbety == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg));
    int i = atvo.a(localbety.g);
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
      bool = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    }
    bety localbety = a();
    switch (localbety.jdField_b_of_type_Int)
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
          } while (!bgmg.b(localbety.jdField_a_of_type_JavaLangString));
          return 2;
          return 4;
          if (!bool) {
            break;
          }
        } while (!bgmg.b(localbety.jdField_a_of_type_JavaLangString));
        return 2;
      } while (!bgmg.b(localbety.jdField_a_of_type_JavaLangString));
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
    bety localbety;
    do
    {
      return 0;
      localbety = a();
    } while (localbety == null);
    return bfsj.a(localbety.jdField_d_of_type_Long, localbety.jdField_c_of_type_Long);
  }
  
  public int f()
  {
    bety localbety = a();
    if (localbety == null) {}
    while (localbety.jdField_c_of_type_Boolean) {
      return 0;
    }
    if (atwt.a(localbety.jdField_e_of_type_Int, localbety.f, localbety.jdField_c_of_type_Long)) {
      return 1;
    }
    if (localbety.j == 1) {
      return 1;
    }
    if (localbety.j == 2) {
      return 2;
    }
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atcd
 * JD-Core Version:    0.7.0.1
 */