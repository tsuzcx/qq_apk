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

public class aoht
  extends aohs
{
  private MessageForTroopFile jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public aoht(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new aohu(this, paramLong, paramUUID, paramActivity);
    babr.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131631827), this.jdField_a_of_type_AndroidContentContext.getString(2131631847), 2131631825, 2131631836, paramUUID, paramUUID).show();
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new aohv(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    babr.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131631831), this.jdField_a_of_type_AndroidContentContext.getString(2131631848), 2131631829, 2131631838, paramUUID, paramUUID).show();
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!apck.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localayqd == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    switch (localayqd.jdField_b_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_picBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      adkt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
      return;
    }
    paramView = new Intent();
    paramView.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private boolean a(ayqd paramayqd, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = amlh.a().c();
      this.jdField_a_of_type_Boolean = false;
    }
    long l1 = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramayqd.g);
    String str2 = amlu.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = axfs.jdField_a_of_type_JavaLangString;
    }
    long l2 = apck.a(paramayqd.e);
    boolean bool1 = bool2;
    int i;
    if (this.jdField_b_of_type_Boolean)
    {
      bool1 = bool2;
      if (axfs.a(paramayqd.e, paramayqd.g, str1))
      {
        bool1 = bool2;
        if (l2 <= l1)
        {
          if (!paramBoolean) {
            break label187;
          }
          if (TextUtils.isEmpty(paramayqd.e)) {
            break label182;
          }
          if (bace.b(paramayqd.e)) {
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
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
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
    ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (localayqd == null) {}
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
    } while (localayqd.jdField_b_of_type_Int == 12);
    return bool1;
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!apck.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    ayqd localayqd;
    long l;
    do
    {
      aypd localaypd;
      do
      {
        return;
        localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
        if (localayqd == null)
        {
          QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
          return;
        }
        localaypd = new aypd(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
        l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin).longValue();
        paramView = xgx.a(paramView);
      } while ((localayqd.jdField_b_of_type_Int == 4) || (localayqd.jdField_b_of_type_Int == 5) || (localayqd.jdField_b_of_type_Int == 12) || (localayqd.jdField_b_of_type_Int == 13));
      if (((localayqd.jdField_b_of_type_Int == 3) || (localayqd.jdField_b_of_type_Int == 2)) && (!apck.a()))
      {
        localaypd.a(localayqd.jdField_a_of_type_JavaUtilUUID);
        return;
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_videoBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    } while (a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile));
    apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, localayqd, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, paramView, false, false);
  }
  
  private void e()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    Object localObject = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (((ayqd)localObject).jdField_b_of_type_Int == 12)
    {
      localObject = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131631866), new Object[] { azjg.a(((ayqd)localObject).g) });
      azic.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, 1);
      return;
    }
    Intent localIntent = new Intent();
    switch (((ayqd)localObject).jdField_b_of_type_Int)
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
    apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, (ayqd)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, false, false);
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
    ayqd localayqd;
    do
    {
      return 0L;
      localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    } while (localayqd == null);
    return localayqd.jdField_c_of_type_Long;
  }
  
  public aodh a()
  {
    return new aodm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public aodk a()
  {
    return new aodn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return "";
    }
    ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localayqd == null) {
      return "";
    }
    return localayqd.g;
  }
  
  public List<Integer> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return localArrayList;
    }
    ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localayqd == null) {
      return localArrayList;
    }
    if (((apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (apdh.b(localayqd.jdField_a_of_type_JavaLangString))) && (localayqd.jdField_b_of_type_Int != 12) && (apck.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2)) {
      localArrayList.add(Integer.valueOf(12));
    }
    long l = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayqd.g);
    Boolean localBoolean2 = Boolean.valueOf(false);
    Boolean localBoolean1 = localBoolean2;
    switch (localayqd.jdField_b_of_type_Int)
    {
    default: 
      localBoolean1 = localBoolean2;
    case 4: 
      if (localBoolean1.booleanValue()) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
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
      if (aciy.a(5) != 1) {
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
      if (aciy.a(5) != 1) {
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
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localayqd, false))) {
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
      if (aciy.a(5) == 1) {
        localArrayList.add(Integer.valueOf(17));
      }
      localBoolean1 = Boolean.valueOf(true);
      break;
      if (!apdh.a(localayqd.jdField_a_of_type_JavaLangString))
      {
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
        localBoolean1 = localBoolean2;
        break;
      }
      if ((!TextUtils.isEmpty(localayqd.jdField_a_of_type_JavaLangString)) && (bace.e(localayqd.jdField_a_of_type_JavaLangString))) {
        localArrayList.add(Integer.valueOf(13));
      }
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(10));
      localArrayList.add(Integer.valueOf(11));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localayqd, false))) {
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
      if (aciy.a(5) != 1) {
        break;
      }
      localArrayList.add(Integer.valueOf(17));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(10));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localayqd, false))) {
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
      if (aciy.a(5) == 1) {
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    TroopFileTransferManager localTroopFileTransferManager;
    ayqd localayqd;
    int i;
    do
    {
      do
      {
        return;
        localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
        localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
      } while (localayqd == null);
      int j = 383;
      i = j;
      if (apdc.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height))
      {
        i = j;
        if (!apdh.b(localayqd.jdField_c_of_type_JavaLangString)) {
          i = 640;
        }
      }
    } while (localayqd.jdField_b_of_type_Int == 12);
    if (localayqd.jdField_a_of_type_JavaUtilUUID != null)
    {
      localTroopFileTransferManager.a(localayqd.jdField_a_of_type_JavaUtilUUID, i);
      return;
    }
    localTroopFileTransferManager.a(localayqd.e, localayqd.g, localayqd.h, i);
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
                          localObject1 = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
                        } while (localObject1 == null);
                        i = badq.a(this.jdField_a_of_type_AndroidContentContext);
                        localObject3 = new aypd(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
                        switch (paramInt)
                        {
                        default: 
                          return;
                        }
                      } while ((((ayqd)localObject1).jdField_b_of_type_Int != 8) && (((ayqd)localObject1).jdField_b_of_type_Int != 9) && (((ayqd)localObject1).jdField_b_of_type_Int != 10));
                      ((TroopFileTransferManager)localObject2).d(((ayqd)localObject1).jdField_a_of_type_JavaUtilUUID);
                      a(((ayqd)localObject1).jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, ((ayqd)localObject1).jdField_a_of_type_JavaUtilUUID);
                      return;
                      if (i == 0)
                      {
                        azic.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131632133));
                        return;
                      }
                      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_pause_download", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
                    } while (((ayqd)localObject1).jdField_b_of_type_Int != 8);
                    ((TroopFileTransferManager)localObject2).d(((ayqd)localObject1).jdField_a_of_type_JavaUtilUUID);
                    return;
                    if (i == 0)
                    {
                      azic.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131632133));
                      return;
                    }
                    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
                  } while ((((ayqd)localObject1).jdField_b_of_type_Int != 0) && (((ayqd)localObject1).jdField_b_of_type_Int != 1));
                  ((TroopFileTransferManager)localObject2).a(((ayqd)localObject1).jdField_a_of_type_JavaUtilUUID);
                  return;
                } while ((((ayqd)localObject1).jdField_b_of_type_Int != 9) && (((ayqd)localObject1).jdField_b_of_type_Int != 10));
                ((aypd)localObject3).b(((ayqd)localObject1).jdField_a_of_type_JavaUtilUUID);
                return;
              } while ((((ayqd)localObject1).jdField_b_of_type_Int != 2) && (((ayqd)localObject1).jdField_b_of_type_Int != 3));
              ((aypd)localObject3).a(((ayqd)localObject1).jdField_a_of_type_JavaUtilUUID);
              return;
              if (i == 0)
              {
                azic.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131632133));
                return;
              }
            } while ((((ayqd)localObject1).jdField_b_of_type_Int != 1) && (((ayqd)localObject1).jdField_b_of_type_Int != 0) && (((ayqd)localObject1).jdField_b_of_type_Int != 2) && (((ayqd)localObject1).jdField_b_of_type_Int != 3));
            ((TroopFileTransferManager)localObject2).a(((ayqd)localObject1).jdField_a_of_type_JavaUtilUUID);
            a(((ayqd)localObject1).jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, ((ayqd)localObject1).jdField_a_of_type_JavaUtilUUID, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
            return;
            if (i == 0)
            {
              azic.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131632133));
              return;
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("forward_type", 0);
            localObject3 = apck.a((ayqd)localObject1);
            ((FileManagerEntity)localObject3).status = 2;
            ((FileManagerEntity)localObject3).nOpType = 24;
            ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
            localForwardFileInfo.b(((FileManagerEntity)localObject3).nSessionId);
            localForwardFileInfo.b(10006);
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject3).getFilePath())) {
              localForwardFileInfo.a(((ayqd)localObject1).jdField_a_of_type_JavaLangString);
            }
            localForwardFileInfo.d(((ayqd)localObject1).g);
            localForwardFileInfo.d(((ayqd)localObject1).jdField_c_of_type_Long);
            localForwardFileInfo.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
            if (((ayqd)localObject1).jdField_a_of_type_JavaUtilUUID != null) {
              localForwardFileInfo.e(((ayqd)localObject1).jdField_a_of_type_JavaUtilUUID.toString());
            }
            if (!TextUtils.isEmpty(((ayqd)localObject1).jdField_c_of_type_JavaLangString)) {
              localForwardFileInfo.f(((ayqd)localObject1).jdField_c_of_type_JavaLangString);
            }
            for (;;)
            {
              localForwardFileInfo.d(1);
              localForwardFileInfo.a(1);
              ((Bundle)localObject2).putParcelable("fileinfo", localForwardFileInfo);
              ((Bundle)localObject2).putBoolean("not_forward", true);
              localObject3 = new Intent();
              ((Intent)localObject3).putExtras((Bundle)localObject2);
              ((Intent)localObject3).putExtra("forward_text", ((ayqd)localObject1).g);
              ((Intent)localObject3).putExtra("forward_from_troop_file", true);
              ((Bundle)localObject2).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              ((Intent)localObject3).putExtra("direct_send_if_dataline_forward", true);
              ((Intent)localObject3).putExtra("forward _key_nojump", true);
              ((Intent)localObject3).putExtra("sender_uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin);
              ((Intent)localObject3).putExtra("last_time", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime);
              aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject3, 21);
              if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
                awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
              }
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
              return;
              if (!TextUtils.isEmpty(((ayqd)localObject1).jdField_d_of_type_JavaLangString)) {
                localForwardFileInfo.f(((ayqd)localObject1).jdField_d_of_type_JavaLangString);
              }
            }
            azjg.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
            return;
            apck.a((Activity)this.jdField_a_of_type_AndroidContentContext, ((ayqd)localObject1).jdField_a_of_type_JavaLangString);
            return;
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down__start_download", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
          } while ((localObject1 != null) && (((ayqd)localObject1).jdField_b_of_type_Int != 7));
          ((aypd)localObject3).a(((ayqd)localObject1).e, ((ayqd)localObject1).g, ((ayqd)localObject1).jdField_c_of_type_Long, ((ayqd)localObject1).h);
          return;
          awqx.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
          azjg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
          return;
          localObject2 = apck.a((ayqd)localObject1);
          localObject1 = azih.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ayqd)localObject1).jdField_b_of_type_Long).a(((FileManagerEntity)localObject2).strTroopFilePath);
          if (localObject1 != null)
          {
            ((FileManagerEntity)localObject2).lastTime = ((ayoq)localObject1).c;
            ((FileManagerEntity)localObject2).selfUin = String.valueOf(((ayoq)localObject1).jdField_b_of_type_Long);
          }
          new bfhl(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, false);
        } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
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
          if (apck.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) != 0) {
            break label1426;
          }
          localObject2 = "1";
        }
        for (;;)
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", (String)localObject1, (String)localObject2);
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
          if (apck.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2) {
            localObject2 = "2";
          } else {
            localObject2 = "3";
          }
        }
      } while (localObject1 == null);
      Object localObject2 = new TeamWorkFileImportInfo();
      ((TeamWorkFileImportInfo)localObject2).jdField_c_of_type_JavaLangString = ((ayqd)localObject1).jdField_a_of_type_JavaLangString;
      ((TeamWorkFileImportInfo)localObject2).jdField_b_of_type_JavaLangString = ((ayqd)localObject1).g;
      ((TeamWorkFileImportInfo)localObject2).j = apck.a(((ayqd)localObject1).g);
      ((TeamWorkFileImportInfo)localObject2).jdField_b_of_type_Boolean = true;
      ((TeamWorkFileImportInfo)localObject2).jdField_d_of_type_Int = 1;
      ((TeamWorkFileImportInfo)localObject2).jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize;
      ((TeamWorkFileImportInfo)localObject2).jdField_d_of_type_JavaLangString = ((ayqd)localObject1).e;
      ((TeamWorkFileImportInfo)localObject2).jdField_b_of_type_Int = ((ayqd)localObject1).h;
      ((TeamWorkFileImportInfo)localObject2).e = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
      ((TeamWorkFileImportInfo)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (((ayqd)localObject1).jdField_b_of_type_Int != 12) {
        ((TeamWorkFileImportInfo)localObject2).jdField_a_of_type_Boolean = true;
      }
      ((TeamWorkFileImportInfo)localObject2).jdField_a_of_type_Int = 1;
      axea.a((TeamWorkFileImportInfo)localObject2, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TeamWorkFileImportInfo)localObject2).jdField_d_of_type_Int);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
    return;
    awqx.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, ((ayqd)localObject1).jdField_b_of_type_Long, (ayqd)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, true, false);
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
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68A", "0X800A68A", 0, 0, "4", "", "", "");
    if (paramInt == 1)
    {
      e();
      return;
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
    e();
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
      if (azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile).jdField_b_of_type_Int == 12) {
        return -1L;
      }
      l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime;
    } while (l == 0L);
    l -= awao.a();
    if (l > 0L) {
      return l;
    }
    return -1L;
  }
  
  public String b()
  {
    ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localayqd == null) {
      return "";
    }
    if (!TextUtils.isEmpty(localayqd.jdField_d_of_type_JavaLangString)) {
      return localayqd.jdField_d_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(localayqd.jdField_c_of_type_JavaLangString)) {
      return localayqd.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
  
  public List<Integer> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      ayqd localayqd;
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
                localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
              } while (localayqd == null);
              if (((apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (apdh.b(localayqd.jdField_a_of_type_JavaLangString))) && (localayqd != null) && (localayqd.jdField_b_of_type_Int != 12) && (apck.a(localayqd.g) == 2)) {
                localArrayList.add(Integer.valueOf(12));
              }
              l = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayqd.g);
              switch (localayqd.jdField_b_of_type_Int)
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
                if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localayqd, false))) {
                  localArrayList.add(Integer.valueOf(21));
                }
                break;
              }
            } while (aciy.a(5) != 1);
            localArrayList.add(Integer.valueOf(17));
            return localArrayList;
            localArrayList.add(Integer.valueOf(9));
          } while (aciy.a(5) != 1);
          localArrayList.add(Integer.valueOf(17));
          return localArrayList;
          localArrayList.add(Integer.valueOf(9));
        } while (aciy.a(5) != 1);
        localArrayList.add(Integer.valueOf(17));
        return localArrayList;
        if (!apdh.a(localayqd.jdField_a_of_type_JavaLangString))
        {
          TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
          return localArrayList;
        }
        localArrayList.add(Integer.valueOf(9));
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localayqd, false))) {
          localArrayList.add(Integer.valueOf(21));
        }
      } while (aciy.a(5) != 1);
      localArrayList.add(Integer.valueOf(17));
      return localArrayList;
      localArrayList.add(Integer.valueOf(9));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localayqd, false))) {
        localArrayList.add(Integer.valueOf(21));
      }
    } while (aciy.a(5) != 1);
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
    awqx.b(null, "dc00898", "", "", "0X800A685", "0X800A685", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    while (azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile).jdField_b_of_type_Int != 3) {
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
    ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime != 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime())) {
      return 6;
    }
    if (localayqd.jdField_b_of_type_Int == 12) {
      return 1;
    }
    switch (localayqd.jdField_b_of_type_Int)
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
    return this.jdField_a_of_type_AndroidContentContext.getString(2131631766);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      return;
      localObject = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    } while ((localObject == null) || (((ayqd)localObject).jdField_b_of_type_Int != 3));
    Object localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)localObject, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    ayqd localayqd;
    do
    {
      return false;
      localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    } while ((localayqd == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg));
    int i = apck.a(localayqd.g);
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
      bool = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    }
    ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    switch (localayqd.jdField_b_of_type_Int)
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
          } while (!bace.b(localayqd.jdField_a_of_type_JavaLangString));
          return 2;
          return 4;
          if (!bool) {
            break;
          }
        } while (!bace.b(localayqd.jdField_a_of_type_JavaLangString));
        return 2;
      } while (!bace.b(localayqd.jdField_a_of_type_JavaLangString));
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
    ayqd localayqd;
    do
    {
      return 0;
      localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    } while (localayqd == null);
    return azjg.a(localayqd.jdField_d_of_type_Long, localayqd.jdField_c_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoht
 * JD-Core Version:    0.7.0.1
 */