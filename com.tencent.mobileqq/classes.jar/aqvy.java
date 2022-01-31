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

public class aqvy
  extends aqvx
{
  private MessageForTroopFile a;
  private boolean b;
  private boolean c;
  
  public aqvy(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new aqvz(this, paramLong, paramUUID, paramActivity);
    bdgm.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697717), this.jdField_a_of_type_AndroidContentContext.getString(2131697739), 2131697715, 2131697726, paramUUID, paramUUID).show();
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new aqwa(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    bdgm.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697721), this.jdField_a_of_type_AndroidContentContext.getString(2131697740), 2131697719, 2131697728, paramUUID, paramUUID).show();
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!arrr.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbbtn == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    switch (localbbtn.jdField_b_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_picBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      afwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
      return;
    }
    paramView = new Intent();
    paramView.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private boolean a(bbtn parambbtn, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = aoxg.a().c();
      this.jdField_b_of_type_Boolean = false;
    }
    long l1 = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambbtn.g);
    String str2 = aoxw.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = baic.jdField_a_of_type_JavaLangString;
    }
    long l2 = arrr.a(parambbtn.jdField_e_of_type_JavaLangString);
    boolean bool1 = bool2;
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      bool1 = bool2;
      if (baic.a(parambbtn.jdField_e_of_type_JavaLangString, parambbtn.g, str1))
      {
        bool1 = bool2;
        if (l2 <= l1)
        {
          if (!paramBoolean) {
            break label187;
          }
          if (TextUtils.isEmpty(parambbtn.jdField_e_of_type_JavaLangString)) {
            break label182;
          }
          if (bdhb.b(parambbtn.jdField_e_of_type_JavaLangString)) {
            break label187;
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
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
        bool1 = true;
      }
      return bool1;
      label182:
      i = 0;
      continue;
      label187:
      i = 1;
    }
  }
  
  private boolean a(MessageForTroopFile paramMessageForTroopFile)
  {
    boolean bool2 = false;
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (localbbtn == null) {}
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
    } while (localbbtn.jdField_b_of_type_Int == 12);
    return bool1;
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!arrr.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    bbtn localbbtn;
    long l;
    do
    {
      bbsn localbbsn;
      do
      {
        return;
        localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
        if (localbbtn == null)
        {
          QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
          return;
        }
        localbbsn = new bbsn(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
        l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin).longValue();
        paramView = zjc.a(paramView);
      } while ((localbbtn.jdField_b_of_type_Int == 4) || (localbbtn.jdField_b_of_type_Int == 5) || (localbbtn.jdField_b_of_type_Int == 12) || (localbbtn.jdField_b_of_type_Int == 13));
      if (((localbbtn.jdField_b_of_type_Int == 3) || (localbbtn.jdField_b_of_type_Int == 2)) && (!arrr.a()))
      {
        localbbsn.a(localbbtn.jdField_a_of_type_JavaUtilUUID);
        return;
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_videoBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    } while (a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile));
    arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, localbbtn, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, paramView, false, false);
  }
  
  private void f()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    Object localObject = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (((bbtn)localObject).jdField_b_of_type_Int == 12)
    {
      localObject = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697758), new Object[] { bcnt.a(((bbtn)localObject).g) });
      bcmp.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, 1);
      return;
    }
    Intent localIntent = new Intent();
    if (biyx.a().a(((bbtn)localObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize))
    {
      biyx.a().a(this.jdField_a_of_type_AndroidContentContext, ((bbtn)localObject).jdField_a_of_type_JavaLangString, true);
      return;
    }
    switch (((bbtn)localObject).jdField_b_of_type_Int)
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
    arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, (bbtn)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, false, false);
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
    bbtn localbbtn;
    do
    {
      return 0L;
      localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    } while (localbbtn == null);
    return localbbtn.jdField_c_of_type_Long;
  }
  
  public aqrm a()
  {
    return new aqrr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public aqrp a()
  {
    return new aqrs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return "";
    }
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbbtn == null) {
      return "";
    }
    return localbbtn.g;
  }
  
  public List<Integer> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return localArrayList;
    }
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbbtn == null) {
      return localArrayList;
    }
    if (((arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (arso.b(localbbtn.jdField_a_of_type_JavaLangString))) && (localbbtn.jdField_b_of_type_Int != 12) && (arrr.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2)) {
      localArrayList.add(Integer.valueOf(12));
    }
    long l = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbbtn.g);
    Boolean localBoolean2 = Boolean.valueOf(false);
    Boolean localBoolean1 = localBoolean2;
    switch (localbbtn.jdField_b_of_type_Int)
    {
    default: 
      localBoolean1 = localBoolean2;
    case 4: 
      if (localBoolean1.booleanValue()) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
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
      localArrayList.add(Integer.valueOf(8));
      localArrayList.add(Integer.valueOf(6));
      localBoolean1 = Boolean.valueOf(true);
      break;
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(10));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile))) {
        localArrayList.add(Integer.valueOf(14));
      }
      localArrayList.add(Integer.valueOf(20));
      localArrayList.add(Integer.valueOf(15));
      localBoolean1 = localBoolean2;
      if (aepi.a(5) != 1) {
        break;
      }
      localArrayList.add(Integer.valueOf(17));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(3));
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(10));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile))) {
        localArrayList.add(Integer.valueOf(14));
      }
      localArrayList.add(Integer.valueOf(20));
      localArrayList.add(Integer.valueOf(15));
      localBoolean1 = localBoolean2;
      if (aepi.a(5) != 1) {
        break;
      }
      localArrayList.add(Integer.valueOf(17));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(3));
      localArrayList.add(Integer.valueOf(10));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile))) {
        localArrayList.add(Integer.valueOf(14));
      }
      localArrayList.add(Integer.valueOf(15));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(9));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localbbtn, false))) {
        localArrayList.add(Integer.valueOf(21));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile))) {
        localArrayList.add(Integer.valueOf(14));
      }
      localArrayList.add(Integer.valueOf(20));
      localArrayList.add(Integer.valueOf(10));
      localArrayList.add(Integer.valueOf(11));
      if (paramInt == 1) {
        localArrayList.add(Integer.valueOf(19));
      }
      localArrayList.add(Integer.valueOf(15));
      if (aepi.a(5) == 1) {
        localArrayList.add(Integer.valueOf(17));
      }
      localBoolean1 = Boolean.valueOf(true);
      break;
      if (!arso.a(localbbtn.jdField_a_of_type_JavaLangString))
      {
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
        localBoolean1 = localBoolean2;
        break;
      }
      if ((!TextUtils.isEmpty(localbbtn.jdField_a_of_type_JavaLangString)) && (bdhb.e(localbbtn.jdField_a_of_type_JavaLangString))) {
        localArrayList.add(Integer.valueOf(13));
      }
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(10));
      localArrayList.add(Integer.valueOf(11));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localbbtn, false))) {
        localArrayList.add(Integer.valueOf(21));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile))) {
        localArrayList.add(Integer.valueOf(14));
      }
      localArrayList.add(Integer.valueOf(20));
      if (paramInt == 1) {
        localArrayList.add(Integer.valueOf(19));
      }
      localArrayList.add(Integer.valueOf(15));
      localBoolean1 = localBoolean2;
      if (aepi.a(5) != 1) {
        break;
      }
      localArrayList.add(Integer.valueOf(17));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(10));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localbbtn, false))) {
        localArrayList.add(Integer.valueOf(21));
      }
      localArrayList.add(Integer.valueOf(20));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile))) {
        localArrayList.add(Integer.valueOf(14));
      }
      if (paramInt == 1) {
        localArrayList.add(Integer.valueOf(19));
      }
      localArrayList.add(Integer.valueOf(15));
      if (aepi.a(5) == 1) {
        localArrayList.add(Integer.valueOf(17));
      }
      localArrayList.add(Integer.valueOf(11));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(15));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(15));
      localBoolean1 = localBoolean2;
      break;
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      e();
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubbleModel", 1, "fetchFileThumb.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) {
        break label34;
      }
    }
    label34:
    TroopFileTransferManager localTroopFileTransferManager;
    bbtn localbbtn;
    int i;
    do
    {
      do
      {
        return;
        localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
        localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
      } while (localbbtn == null);
      int j = 383;
      i = j;
      if (arsj.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height))
      {
        i = j;
        if (!arso.b(localbbtn.jdField_c_of_type_JavaLangString)) {
          i = 640;
        }
      }
    } while (localbbtn.jdField_b_of_type_Int == 12);
    if (localbbtn.jdField_a_of_type_JavaUtilUUID != null)
    {
      localTroopFileTransferManager.a(localbbtn.jdField_a_of_type_JavaUtilUUID, i);
      return;
    }
    localTroopFileTransferManager.a(localbbtn.jdField_e_of_type_JavaLangString, localbbtn.g, localbbtn.h, i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    Object localObject1;
    label1426:
    do
    {
      do
      {
        do
        {
          do
          {
            int i;
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
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            localObject2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
                          } while (localObject2 == null);
                          localObject1 = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
                        } while (localObject1 == null);
                        i = bdin.a(this.jdField_a_of_type_AndroidContentContext);
                        localObject3 = new bbsn(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
                        switch (paramInt)
                        {
                        default: 
                          return;
                        }
                      } while ((((bbtn)localObject1).jdField_b_of_type_Int != 8) && (((bbtn)localObject1).jdField_b_of_type_Int != 9) && (((bbtn)localObject1).jdField_b_of_type_Int != 10));
                      ((TroopFileTransferManager)localObject2).d(((bbtn)localObject1).jdField_a_of_type_JavaUtilUUID);
                      a(((bbtn)localObject1).jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, ((bbtn)localObject1).jdField_a_of_type_JavaUtilUUID);
                      return;
                      if (i == 0)
                      {
                        bcmp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131698042));
                        return;
                      }
                      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_pause_download", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
                    } while (((bbtn)localObject1).jdField_b_of_type_Int != 8);
                    ((TroopFileTransferManager)localObject2).d(((bbtn)localObject1).jdField_a_of_type_JavaUtilUUID);
                    return;
                    if (i == 0)
                    {
                      bcmp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131698042));
                      return;
                    }
                    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
                  } while ((((bbtn)localObject1).jdField_b_of_type_Int != 0) && (((bbtn)localObject1).jdField_b_of_type_Int != 1));
                  ((TroopFileTransferManager)localObject2).a(((bbtn)localObject1).jdField_a_of_type_JavaUtilUUID);
                  return;
                } while ((((bbtn)localObject1).jdField_b_of_type_Int != 9) && (((bbtn)localObject1).jdField_b_of_type_Int != 10));
                ((bbsn)localObject3).b(((bbtn)localObject1).jdField_a_of_type_JavaUtilUUID);
                return;
              } while ((((bbtn)localObject1).jdField_b_of_type_Int != 2) && (((bbtn)localObject1).jdField_b_of_type_Int != 3));
              ((bbsn)localObject3).a(((bbtn)localObject1).jdField_a_of_type_JavaUtilUUID);
              return;
              if (i == 0)
              {
                bcmp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131698042));
                return;
              }
            } while ((((bbtn)localObject1).jdField_b_of_type_Int != 1) && (((bbtn)localObject1).jdField_b_of_type_Int != 0) && (((bbtn)localObject1).jdField_b_of_type_Int != 2) && (((bbtn)localObject1).jdField_b_of_type_Int != 3));
            ((TroopFileTransferManager)localObject2).a(((bbtn)localObject1).jdField_a_of_type_JavaUtilUUID);
            a(((bbtn)localObject1).jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, ((bbtn)localObject1).jdField_a_of_type_JavaUtilUUID, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
            return;
            if (i == 0)
            {
              bcmp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131698042));
              return;
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("forward_type", 0);
            localObject3 = arrr.a((bbtn)localObject1);
            ((FileManagerEntity)localObject3).status = 2;
            ((FileManagerEntity)localObject3).nOpType = 24;
            ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
            localForwardFileInfo.b(((FileManagerEntity)localObject3).nSessionId);
            localForwardFileInfo.b(10006);
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject3).getFilePath())) {
              localForwardFileInfo.a(((bbtn)localObject1).jdField_a_of_type_JavaLangString);
            }
            localForwardFileInfo.d(((bbtn)localObject1).g);
            localForwardFileInfo.d(((bbtn)localObject1).jdField_c_of_type_Long);
            localForwardFileInfo.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
            if (((bbtn)localObject1).jdField_a_of_type_JavaUtilUUID != null) {
              localForwardFileInfo.e(((bbtn)localObject1).jdField_a_of_type_JavaUtilUUID.toString());
            }
            if (!TextUtils.isEmpty(((bbtn)localObject1).jdField_c_of_type_JavaLangString)) {
              localForwardFileInfo.f(((bbtn)localObject1).jdField_c_of_type_JavaLangString);
            }
            for (;;)
            {
              localForwardFileInfo.d(1);
              localForwardFileInfo.a(1);
              ((Bundle)localObject2).putParcelable("fileinfo", localForwardFileInfo);
              ((Bundle)localObject2).putBoolean("not_forward", true);
              localObject3 = new Intent();
              ((Intent)localObject3).putExtras((Bundle)localObject2);
              ((Intent)localObject3).putExtra("forward_text", ((bbtn)localObject1).g);
              ((Intent)localObject3).putExtra("forward_from_troop_file", true);
              ((Bundle)localObject2).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              ((Intent)localObject3).putExtra("direct_send_if_dataline_forward", true);
              ((Intent)localObject3).putExtra("forward _key_nojump", true);
              ((Intent)localObject3).putExtra("sender_uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin);
              ((Intent)localObject3).putExtra("last_time", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime);
              aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject3, 21);
              if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
                azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
              }
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
              return;
              if (!TextUtils.isEmpty(((bbtn)localObject1).jdField_d_of_type_JavaLangString)) {
                localForwardFileInfo.f(((bbtn)localObject1).jdField_d_of_type_JavaLangString);
              }
            }
            bcnt.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
            return;
            arrr.a((Activity)this.jdField_a_of_type_AndroidContentContext, ((bbtn)localObject1).jdField_a_of_type_JavaLangString);
            return;
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down__start_download", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
          } while ((localObject1 != null) && (((bbtn)localObject1).jdField_b_of_type_Int != 7));
          ((bbsn)localObject3).a(((bbtn)localObject1).jdField_e_of_type_JavaLangString, ((bbtn)localObject1).g, ((bbtn)localObject1).jdField_c_of_type_Long, ((bbtn)localObject1).h);
          return;
          azqs.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
          bcnt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
          return;
          localObject2 = arrr.a((bbtn)localObject1);
          localObject1 = bcmu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((bbtn)localObject1).jdField_b_of_type_Long).a(((FileManagerEntity)localObject2).strTroopFilePath);
          if (localObject1 != null)
          {
            ((FileManagerEntity)localObject2).lastTime = ((bbsa)localObject1).c;
            ((FileManagerEntity)localObject2).selfUin = String.valueOf(((bbsa)localObject1).jdField_b_of_type_Long);
          }
          new biva(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, false);
        } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
        return;
        Object localObject3 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localObject2 = "2";
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          if ((((TroopInfo)localObject3).troopowneruin != null) && (((TroopInfo)localObject3).troopowneruin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
            localObject1 = "1";
          }
        }
        else
        {
          if (arrr.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) != 0) {
            break label1426;
          }
          localObject2 = "1";
        }
        for (;;)
        {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", (String)localObject1, (String)localObject2);
          return;
          localObject1 = localObject2;
          if (((TroopInfo)localObject3).Administrator == null) {
            break;
          }
          localObject1 = localObject2;
          if (!((TroopInfo)localObject3).Administrator.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            break;
          }
          localObject1 = "2";
          break;
          if (arrr.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2) {
            localObject2 = "2";
          } else {
            localObject2 = "3";
          }
        }
      } while (localObject1 == null);
      Object localObject2 = new TeamWorkFileImportInfo();
      ((TeamWorkFileImportInfo)localObject2).jdField_c_of_type_JavaLangString = ((bbtn)localObject1).jdField_a_of_type_JavaLangString;
      ((TeamWorkFileImportInfo)localObject2).jdField_b_of_type_JavaLangString = ((bbtn)localObject1).g;
      ((TeamWorkFileImportInfo)localObject2).j = arrr.a(((bbtn)localObject1).g);
      ((TeamWorkFileImportInfo)localObject2).jdField_b_of_type_Boolean = true;
      ((TeamWorkFileImportInfo)localObject2).jdField_d_of_type_Int = 1;
      ((TeamWorkFileImportInfo)localObject2).jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize;
      ((TeamWorkFileImportInfo)localObject2).jdField_d_of_type_JavaLangString = ((bbtn)localObject1).jdField_e_of_type_JavaLangString;
      ((TeamWorkFileImportInfo)localObject2).jdField_b_of_type_Int = ((bbtn)localObject1).h;
      ((TeamWorkFileImportInfo)localObject2).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
      ((TeamWorkFileImportInfo)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (((bbtn)localObject1).jdField_b_of_type_Int != 12) {
        ((TeamWorkFileImportInfo)localObject2).jdField_a_of_type_Boolean = true;
      }
      ((TeamWorkFileImportInfo)localObject2).jdField_a_of_type_Int = 1;
      bagk.a((TeamWorkFileImportInfo)localObject2, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TeamWorkFileImportInfo)localObject2).jdField_d_of_type_Int);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
    return;
    azqs.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, ((bbtn)localObject1).jdField_b_of_type_Long, (bbtn)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, true, false);
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
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbbtn == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    int i = 11;
    switch (arrr.a(localbbtn.g))
    {
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68A", "0X800A68A", i, 0, "4", "", "", "");
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
      if (bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile).jdField_b_of_type_Int == 12) {
        return -1L;
      }
      l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime;
    } while (l == 0L);
    l -= ayzl.a();
    if (l > 0L) {
      return l;
    }
    return -1L;
  }
  
  public String b()
  {
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbbtn == null) {
      return "";
    }
    if (!TextUtils.isEmpty(localbbtn.jdField_d_of_type_JavaLangString)) {
      return localbbtn.jdField_d_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(localbbtn.jdField_c_of_type_JavaLangString)) {
      return localbbtn.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
  
  public List<Integer> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      bbtn localbbtn;
      long l;
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
                return localArrayList;
                localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
              } while (localbbtn == null);
              if (((arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (arso.b(localbbtn.jdField_a_of_type_JavaLangString))) && (localbbtn != null) && (localbbtn.jdField_b_of_type_Int != 12) && (arrr.a(localbbtn.g) == 2)) {
                localArrayList.add(Integer.valueOf(12));
              }
              l = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbbtn.g);
              switch (localbbtn.jdField_b_of_type_Int)
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
                localArrayList.add(Integer.valueOf(9));
                if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localbbtn, false))) {
                  localArrayList.add(Integer.valueOf(21));
                }
                break;
              }
            } while (aepi.a(5) != 1);
            localArrayList.add(Integer.valueOf(17));
            return localArrayList;
            localArrayList.add(Integer.valueOf(9));
          } while (aepi.a(5) != 1);
          localArrayList.add(Integer.valueOf(17));
          return localArrayList;
          localArrayList.add(Integer.valueOf(9));
        } while (aepi.a(5) != 1);
        localArrayList.add(Integer.valueOf(17));
        return localArrayList;
        if (!arso.a(localbbtn.jdField_a_of_type_JavaLangString))
        {
          TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
          return localArrayList;
        }
        localArrayList.add(Integer.valueOf(9));
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localbbtn, false))) {
          localArrayList.add(Integer.valueOf(21));
        }
      } while (aepi.a(5) != 1);
      localArrayList.add(Integer.valueOf(17));
      return localArrayList;
      localArrayList.add(Integer.valueOf(9));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localbbtn, false))) {
        localArrayList.add(Integer.valueOf(21));
      }
    } while (aepi.a(5) != 1);
    localArrayList.add(Integer.valueOf(17));
    return localArrayList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.url;
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str));
    azqs.b(null, "dc00898", "", "", "0X800A685", "0X800A685", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    while (bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile).jdField_b_of_type_Int != 3) {
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
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime != 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime())) {
      return 6;
    }
    if (localbbtn.jdField_b_of_type_Int == 12) {
      return 1;
    }
    switch (localbbtn.jdField_b_of_type_Int)
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
    return this.jdField_a_of_type_AndroidContentContext.getString(2131697656);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      return;
      localObject = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    } while ((localObject == null) || (((bbtn)localObject).jdField_b_of_type_Int != 3));
    Object localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)localObject, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    bbtn localbbtn;
    do
    {
      return false;
      localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    } while ((localbbtn == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg));
    int i = arrr.a(localbbtn.g);
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
      bool = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    }
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    switch (localbbtn.jdField_b_of_type_Int)
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
          } while (!bdhb.b(localbbtn.jdField_a_of_type_JavaLangString));
          return 2;
          return 4;
          if (!bool) {
            break;
          }
        } while (!bdhb.b(localbbtn.jdField_a_of_type_JavaLangString));
        return 2;
      } while (!bdhb.b(localbbtn.jdField_a_of_type_JavaLangString));
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
    bbtn localbbtn;
    do
    {
      return 0;
      localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    } while (localbbtn == null);
    return bcnt.a(localbbtn.jdField_d_of_type_Long, localbbtn.jdField_c_of_type_Long);
  }
  
  public int f()
  {
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbbtn == null) {}
    while (localbbtn.jdField_c_of_type_Boolean) {
      return 0;
    }
    if (arsx.a(localbbtn.jdField_e_of_type_Int, localbbtn.f, localbbtn.jdField_c_of_type_Long)) {
      return 1;
    }
    if (localbbtn.i == 1) {
      return 1;
    }
    if (localbbtn.i == 2) {
      return 2;
    }
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvy
 * JD-Core Version:    0.7.0.1
 */