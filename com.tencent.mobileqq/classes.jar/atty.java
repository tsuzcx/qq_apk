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

public class atty
  extends attx
{
  private MessageForTroopFile a;
  private boolean b;
  private boolean c;
  
  public atty(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(int paramInt, bftf parambftf, ArrayList<Integer> paramArrayList)
  {
    long l = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambftf.g);
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambftf, false))) {
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
    paramUUID = new attz(this, paramLong, paramUUID, paramActivity);
    bhlq.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131696602), this.jdField_a_of_type_AndroidContentContext.getString(2131696630), 2131696600, 2131696617, paramUUID, paramUUID).show();
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new atua(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    bhlq.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131696606), this.jdField_a_of_type_AndroidContentContext.getString(2131696631), 2131696604, 2131696619, paramUUID, paramUUID).show();
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!aunj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    bftf localbftf = a();
    if (localbftf == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    switch (localbftf.jdField_b_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_picBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      ahng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
      return;
    }
    paramView = new Intent();
    paramView.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void a(bftf parambftf)
  {
    FileManagerEntity localFileManagerEntity = aunj.a(parambftf);
    parambftf = bgrn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambftf.jdField_b_of_type_Long).a(localFileManagerEntity.strTroopFilePath);
    if (parambftf != null)
    {
      localFileManagerEntity.lastTime = parambftf.c;
      localFileManagerEntity.selfUin = String.valueOf(parambftf.jdField_b_of_type_Long);
    }
    new bmko(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, false);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
    }
  }
  
  private void a(bftf parambftf, int paramInt)
  {
    if (paramInt == 0)
    {
      bgri.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131696937));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    Object localObject = aunj.a(parambftf);
    ((FileManagerEntity)localObject).status = 2;
    ((FileManagerEntity)localObject).nOpType = 24;
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.b(10006);
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
      localForwardFileInfo.a(parambftf.jdField_a_of_type_JavaLangString);
    }
    localForwardFileInfo.d(parambftf.g);
    localForwardFileInfo.d(parambftf.jdField_c_of_type_Long);
    localForwardFileInfo.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
    if (parambftf.jdField_a_of_type_JavaUtilUUID != null) {
      localForwardFileInfo.e(parambftf.jdField_a_of_type_JavaUtilUUID.toString());
    }
    if (!TextUtils.isEmpty(parambftf.jdField_c_of_type_JavaLangString)) {
      localForwardFileInfo.f(parambftf.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      localForwardFileInfo.d(1);
      localForwardFileInfo.a(1);
      localBundle.putParcelable("fileinfo", localForwardFileInfo);
      localBundle.putBoolean("not_forward", true);
      localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).putExtra("forward_text", parambftf.g);
      ((Intent)localObject).putExtra("forward_from_troop_file", true);
      localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
      ((Intent)localObject).putExtra("forward _key_nojump", true);
      ((Intent)localObject).putExtra("sender_uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin);
      ((Intent)localObject).putExtra("last_time", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime);
      auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
      if (!TextUtils.isEmpty(parambftf.jdField_d_of_type_JavaLangString)) {
        localForwardFileInfo.f(parambftf.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  private void a(TroopFileTransferManager paramTroopFileTransferManager, bftf parambftf, int paramInt)
  {
    if (paramInt == 0) {
      bgri.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131696937));
    }
    while ((parambftf.jdField_b_of_type_Int != 1) && (parambftf.jdField_b_of_type_Int != 0) && (parambftf.jdField_b_of_type_Int != 2) && (parambftf.jdField_b_of_type_Int != 3)) {
      return;
    }
    paramTroopFileTransferManager.a(parambftf.jdField_a_of_type_JavaUtilUUID);
    a(parambftf.jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, parambftf.jdField_a_of_type_JavaUtilUUID, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
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
  
  private boolean a(bftf parambftf, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = arpx.a().c();
      this.jdField_b_of_type_Boolean = false;
    }
    long l1 = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambftf.g);
    String str2 = arqn.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = becb.jdField_a_of_type_JavaLangString;
    }
    long l2 = aunj.a(parambftf.jdField_e_of_type_JavaLangString);
    boolean bool1 = bool2;
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      bool1 = bool2;
      if (becb.a(parambftf.jdField_e_of_type_JavaLangString, parambftf.g, str1))
      {
        bool1 = bool2;
        if (l2 <= l1)
        {
          if (!paramBoolean) {
            break label189;
          }
          if (TextUtils.isEmpty(parambftf.jdField_e_of_type_JavaLangString)) {
            break label184;
          }
          if (bhmi.b(parambftf.jdField_e_of_type_JavaLangString)) {
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
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
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
    bftf localbftf = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (localbftf == null) {}
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
    } while (localbftf.jdField_b_of_type_Int == 12);
    return bool1;
  }
  
  private void b(int paramInt, bftf parambftf, ArrayList<Integer> paramArrayList)
  {
    long l = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambftf.g);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambftf, false))) {
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
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!aunj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    bftf localbftf;
    bfsf localbfsf;
    long l;
    do
    {
      return;
      localbftf = a();
      if (localbftf == null)
      {
        QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
        return;
      }
      localbfsf = new bfsf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
      l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin).longValue();
      paramView = abke.a(paramView);
      if (localbftf.jdField_b_of_type_Int == 12)
      {
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696649), new Object[] { bgsk.a(localbftf.g) });
        bgri.a(this.jdField_a_of_type_AndroidContentContext, paramView, 1);
        return;
      }
    } while ((localbftf.jdField_b_of_type_Int == 4) || (localbftf.jdField_b_of_type_Int == 5) || (localbftf.jdField_b_of_type_Int == 13));
    if (((localbftf.jdField_b_of_type_Int == 3) || (localbftf.jdField_b_of_type_Int == 2)) && (!aunj.a()))
    {
      localbfsf.a(localbftf.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_videoBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    if (a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile))
    {
      paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696649), new Object[] { bgsk.a(localbftf.g) });
      bgri.a(this.jdField_a_of_type_AndroidContentContext, paramView, 1);
      return;
    }
    auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, localbftf, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, paramView, false, false);
  }
  
  private void b(bftf parambftf)
  {
    if (parambftf == null) {}
    do
    {
      return;
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString = parambftf.jdField_a_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = parambftf.g;
      localTeamWorkFileImportInfo.j = aunj.a(parambftf.g);
      localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = true;
      localTeamWorkFileImportInfo.jdField_d_of_type_Int = 1;
      localTeamWorkFileImportInfo.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize;
      localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = parambftf.jdField_e_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_b_of_type_Int = parambftf.h;
      localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (parambftf.jdField_b_of_type_Int != 12) {
        localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
      }
      localTeamWorkFileImportInfo.jdField_a_of_type_Int = 1;
      beaj.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTeamWorkFileImportInfo.jdField_d_of_type_Int);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
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
  
  private void c(int paramInt, bftf parambftf, ArrayList<Integer> paramArrayList)
  {
    long l = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambftf.g);
    if (!auog.a(parambftf.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(parambftf.jdField_a_of_type_JavaLangString)) && (bhmi.e(parambftf.jdField_a_of_type_JavaLangString))) {
        paramArrayList.add(Integer.valueOf(14));
      }
      paramArrayList.add(Integer.valueOf(9));
      paramArrayList.add(Integer.valueOf(10));
      paramArrayList.add(Integer.valueOf(11));
      paramArrayList.add(Integer.valueOf(12));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambftf, false))) {
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
  
  private void d(int paramInt, bftf parambftf, ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(9));
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private boolean d()
  {
    return agej.a(5) == 1;
  }
  
  private void e(int paramInt, bftf parambftf, ArrayList<Integer> paramArrayList)
  {
    long l = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambftf.g);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambftf, false))) {
      paramArrayList.add(Integer.valueOf(22));
    }
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile));
  }
  
  private void f()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    Object localObject = a();
    if (((bftf)localObject).jdField_b_of_type_Int == 12)
    {
      localObject = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696649), new Object[] { bgsk.a(((bftf)localObject).g) });
      bgri.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, 1);
      return;
    }
    Intent localIntent = new Intent();
    if (bmol.a().a(((bftf)localObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize))
    {
      bmol.a().a(this.jdField_a_of_type_AndroidContentContext, ((bftf)localObject).jdField_a_of_type_JavaLangString, true);
      return;
    }
    switch (((bftf)localObject).jdField_b_of_type_Int)
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
    auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, (bftf)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, false, false);
  }
  
  private void f(int paramInt, bftf parambftf, ArrayList<Integer> paramArrayList)
  {
    long l = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambftf.g);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambftf, false))) {
      paramArrayList.add(Integer.valueOf(22));
    }
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
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
      if (aunj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) != 0) {
        break label146;
      }
      str2 = "1";
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", str1, str2);
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
      if (aunj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2) {
        str2 = "2";
      } else {
        str2 = "3";
      }
    }
  }
  
  private void g(int paramInt, bftf parambftf, ArrayList<Integer> paramArrayList)
  {
    long l = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambftf.g);
    if (!auog.a(parambftf.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
    }
    do
    {
      return;
      paramArrayList.add(Integer.valueOf(9));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(parambftf, false))) {
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
    bftf localbftf;
    do
    {
      return 0L;
      localbftf = a();
    } while (localbftf == null);
    return localbftf.jdField_c_of_type_Long;
  }
  
  public atos a()
  {
    return new atox(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public atov a()
  {
    return new atoy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  @Nullable
  public bftf a()
  {
    return bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return "";
    }
    bftf localbftf = a();
    if (localbftf == null) {
      return "";
    }
    return localbftf.g;
  }
  
  public List<Integer> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return localArrayList;
    }
    bftf localbftf = a();
    if (localbftf == null) {
      return localArrayList;
    }
    if (((auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (auog.b(localbftf.jdField_a_of_type_JavaLangString))) && (localbftf.jdField_b_of_type_Int != 12) && (aunj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2)) {
      localArrayList.add(Integer.valueOf(13));
    }
    aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbftf.g);
    Boolean localBoolean2 = Boolean.valueOf(false);
    Boolean localBoolean1 = localBoolean2;
    switch (localbftf.jdField_b_of_type_Int)
    {
    default: 
      localBoolean1 = localBoolean2;
    case 4: 
      if (localBoolean1.booleanValue()) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
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
      b(paramInt, localbftf, localArrayList);
      localBoolean1 = Boolean.valueOf(true);
      break;
      c(paramInt, localbftf, localArrayList);
      localBoolean1 = localBoolean2;
      break;
      a(paramInt, localbftf, localArrayList);
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(16));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(16));
      localBoolean1 = localBoolean2;
      break;
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
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
    bftf localbftf;
    int i;
    for (;;)
    {
      return;
      localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
      localbftf = a();
      if (localbftf != null)
      {
        if (auog.b(localbftf.jdField_a_of_type_JavaLangString)) {
          i = j;
        }
        while (localbftf.jdField_b_of_type_Int != 12)
        {
          if (localbftf.jdField_a_of_type_JavaUtilUUID == null) {
            break label152;
          }
          localTroopFileTransferManager.a(localbftf.jdField_a_of_type_JavaUtilUUID, i);
          return;
          i = j;
          if (auob.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height))
          {
            i = j;
            if (!auog.b(localbftf.jdField_c_of_type_JavaLangString)) {
              i = 640;
            }
          }
        }
      }
    }
    label152:
    localTroopFileTransferManager.a(localbftf.jdField_e_of_type_JavaLangString, localbftf.g, localbftf.h, i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    TroopFileTransferManager localTroopFileTransferManager;
    bftf localbftf;
    int i;
    bfsf localbfsf;
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
            localbftf = a();
          } while (localbftf == null);
          i = bhnv.a(this.jdField_a_of_type_AndroidContentContext);
          localbfsf = new bfsf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
          switch (paramInt)
          {
          default: 
            return;
          }
        } while ((localbftf.jdField_b_of_type_Int != 8) && (localbftf.jdField_b_of_type_Int != 9) && (localbftf.jdField_b_of_type_Int != 10));
        localTroopFileTransferManager.d(localbftf.jdField_a_of_type_JavaUtilUUID);
        a(localbftf.jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, localbftf.jdField_a_of_type_JavaUtilUUID);
        return;
        if (i == 0)
        {
          bgri.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131696937));
          return;
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
      } while ((localbftf.jdField_b_of_type_Int != 0) && (localbftf.jdField_b_of_type_Int != 1));
      localTroopFileTransferManager.a(localbftf.jdField_a_of_type_JavaUtilUUID);
      return;
    } while ((localbftf.jdField_b_of_type_Int != 2) && (localbftf.jdField_b_of_type_Int != 3));
    localbfsf.a(localbftf.jdField_a_of_type_JavaUtilUUID);
    return;
    a(localTroopFileTransferManager, localbftf, i);
    return;
    a(localbftf, i);
    return;
    bgsk.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return;
    aunj.a((Activity)this.jdField_a_of_type_AndroidContentContext, localbftf.jdField_a_of_type_JavaLangString);
    return;
    bdll.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
    bgsk.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return;
    a(localbftf);
    return;
    g();
    return;
    b(localbftf);
    return;
    bdll.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, localbftf.jdField_b_of_type_Long, localbftf, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, true, false);
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
    bftf localbftf = a();
    if (localbftf == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    int i = 11;
    switch (aunj.a(localbftf.g))
    {
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68A", "0X800A68A", i, 0, "4", "", "", "");
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
    bftf localbftf = a();
    if (localbftf == null) {
      return "";
    }
    if (bhmi.b(localbftf.jdField_d_of_type_JavaLangString)) {
      return localbftf.jdField_d_of_type_JavaLangString;
    }
    if (bhmi.b(localbftf.jdField_c_of_type_JavaLangString)) {
      return localbftf.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
  
  public List<Integer> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    bftf localbftf;
    do
    {
      do
      {
        return localArrayList;
        localbftf = a();
      } while (localbftf == null);
      if (((auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (auog.b(localbftf.jdField_a_of_type_JavaLangString))) && (localbftf != null) && (localbftf.jdField_b_of_type_Int != 12) && (aunj.a(localbftf.g) == 2)) {
        localArrayList.add(Integer.valueOf(13));
      }
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbftf.g);
      switch (localbftf.jdField_b_of_type_Int)
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
        e(paramInt, localbftf, localArrayList);
        return localArrayList;
      case 8: 
        localArrayList.add(Integer.valueOf(9));
      }
    } while (!d());
    localArrayList.add(Integer.valueOf(18));
    return localArrayList;
    d(paramInt, localbftf, localArrayList);
    return localArrayList;
    g(paramInt, localbftf, localArrayList);
    return localArrayList;
    f(paramInt, localbftf, localArrayList);
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
      bdll.b(null, "dc00898", "", "", "0X800A685", "0X800A685", 0, 0, "", "", "", "");
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
    bftf localbftf = a();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime != 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime())) {
      return 6;
    }
    if (localbftf.jdField_b_of_type_Int == 12) {
      return 1;
    }
    switch (localbftf.jdField_b_of_type_Int)
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
    return this.jdField_a_of_type_AndroidContentContext.getString(2131696541);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      return;
      localObject = a();
    } while ((localObject == null) || (((bftf)localObject).jdField_b_of_type_Int != 3));
    Object localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)localObject, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    bftf localbftf;
    do
    {
      return false;
      localbftf = a();
    } while ((localbftf == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg));
    int i = aunj.a(localbftf.g);
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
      bool = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    }
    bftf localbftf = a();
    switch (localbftf.jdField_b_of_type_Int)
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
          } while (!bhmi.b(localbftf.jdField_a_of_type_JavaLangString));
          return 2;
          return 4;
          if (!bool) {
            break;
          }
        } while (!bhmi.b(localbftf.jdField_a_of_type_JavaLangString));
        return 2;
      } while (!bhmi.b(localbftf.jdField_a_of_type_JavaLangString));
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
    bftf localbftf;
    do
    {
      return 0;
      localbftf = a();
    } while (localbftf == null);
    return bgsk.a(localbftf.jdField_d_of_type_Long, localbftf.jdField_c_of_type_Long);
  }
  
  public int f()
  {
    bftf localbftf = a();
    if (localbftf == null) {}
    while (localbftf.jdField_c_of_type_Boolean) {
      return 0;
    }
    if (auoo.a(localbftf.jdField_e_of_type_Int, localbftf.f, localbftf.jdField_c_of_type_Long)) {
      return 1;
    }
    if (localbftf.j == 1) {
      return 1;
    }
    if (localbftf.j == 2) {
      return 2;
    }
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atty
 * JD-Core Version:    0.7.0.1
 */