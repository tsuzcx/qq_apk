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

public class aoyn
  extends aoym
{
  private MessageForTroopFile a;
  private boolean b;
  private boolean c;
  
  public aoyn(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new aoyo(this, paramLong, paramUUID, paramActivity);
    bbcv.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697539), this.jdField_a_of_type_AndroidContentContext.getString(2131697561), 2131697537, 2131697548, paramUUID, paramUUID).show();
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new aoyp(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    bbcv.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697543), this.jdField_a_of_type_AndroidContentContext.getString(2131697562), 2131697541, 2131697550, paramUUID, paramUUID).show();
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!apue.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    azqt localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localazqt == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    switch (localazqt.jdField_b_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_picBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      advu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
      return;
    }
    paramView = new Intent();
    paramView.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private boolean a(azqt paramazqt, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = anbl.a().c();
      this.jdField_b_of_type_Boolean = false;
    }
    long l1 = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazqt.g);
    String str2 = ancb.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ayfv.jdField_a_of_type_JavaLangString;
    }
    long l2 = apue.a(paramazqt.jdField_e_of_type_JavaLangString);
    boolean bool1 = bool2;
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      bool1 = bool2;
      if (ayfv.a(paramazqt.jdField_e_of_type_JavaLangString, paramazqt.g, str1))
      {
        bool1 = bool2;
        if (l2 <= l1)
        {
          if (!paramBoolean) {
            break label187;
          }
          if (TextUtils.isEmpty(paramazqt.jdField_e_of_type_JavaLangString)) {
            break label182;
          }
          if (bbdj.b(paramazqt.jdField_e_of_type_JavaLangString)) {
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
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
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
    azqt localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (localazqt == null) {}
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
    } while (localazqt.jdField_b_of_type_Int == 12);
    return bool1;
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!apue.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    azqt localazqt;
    long l;
    do
    {
      azpt localazpt;
      do
      {
        return;
        localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
        if (localazqt == null)
        {
          QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
          return;
        }
        localazpt = new azpt(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
        l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin).longValue();
        paramView = xpx.a(paramView);
      } while ((localazqt.jdField_b_of_type_Int == 4) || (localazqt.jdField_b_of_type_Int == 5) || (localazqt.jdField_b_of_type_Int == 12) || (localazqt.jdField_b_of_type_Int == 13));
      if (((localazqt.jdField_b_of_type_Int == 3) || (localazqt.jdField_b_of_type_Int == 2)) && (!apue.a()))
      {
        localazpt.a(localazqt.jdField_a_of_type_JavaUtilUUID);
        return;
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_videoBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    } while (a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile));
    apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, localazqt, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, paramView, false, false);
  }
  
  private void f()
  {
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    Object localObject = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (((azqt)localObject).jdField_b_of_type_Int == 12)
    {
      localObject = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697580), new Object[] { bakj.a(((azqt)localObject).g) });
      bajf.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, 1);
      return;
    }
    Intent localIntent = new Intent();
    switch (((azqt)localObject).jdField_b_of_type_Int)
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
    apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, (azqt)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, false, false);
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
    azqt localazqt;
    do
    {
      return 0L;
      localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    } while (localazqt == null);
    return localazqt.jdField_c_of_type_Long;
  }
  
  public aoub a()
  {
    return new aoug(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public aoue a()
  {
    return new aouh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return "";
    }
    azqt localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localazqt == null) {
      return "";
    }
    return localazqt.g;
  }
  
  public List<Integer> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return localArrayList;
    }
    azqt localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localazqt == null) {
      return localArrayList;
    }
    if (((apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (apvb.b(localazqt.jdField_a_of_type_JavaLangString))) && (localazqt.jdField_b_of_type_Int != 12) && (apue.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2)) {
      localArrayList.add(Integer.valueOf(12));
    }
    long l = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localazqt.g);
    Boolean localBoolean2 = Boolean.valueOf(false);
    Boolean localBoolean1 = localBoolean2;
    switch (localazqt.jdField_b_of_type_Int)
    {
    default: 
      localBoolean1 = localBoolean2;
    case 4: 
      if (localBoolean1.booleanValue()) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
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
      if (actn.a(5) != 1) {
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
      if (actn.a(5) != 1) {
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
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localazqt, false))) {
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
      if (actn.a(5) == 1) {
        localArrayList.add(Integer.valueOf(17));
      }
      localBoolean1 = Boolean.valueOf(true);
      break;
      if (!apvb.a(localazqt.jdField_a_of_type_JavaLangString))
      {
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
        localBoolean1 = localBoolean2;
        break;
      }
      if ((!TextUtils.isEmpty(localazqt.jdField_a_of_type_JavaLangString)) && (bbdj.f(localazqt.jdField_a_of_type_JavaLangString))) {
        localArrayList.add(Integer.valueOf(13));
      }
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(10));
      localArrayList.add(Integer.valueOf(11));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localazqt, false))) {
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
      if (actn.a(5) != 1) {
        break;
      }
      localArrayList.add(Integer.valueOf(17));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(10));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localazqt, false))) {
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
      if (actn.a(5) == 1) {
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
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
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
    azqt localazqt;
    int i;
    do
    {
      do
      {
        return;
        localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
        localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
      } while (localazqt == null);
      int j = 383;
      i = j;
      if (apuw.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height))
      {
        i = j;
        if (!apvb.b(localazqt.jdField_c_of_type_JavaLangString)) {
          i = 640;
        }
      }
    } while (localazqt.jdField_b_of_type_Int == 12);
    if (localazqt.jdField_a_of_type_JavaUtilUUID != null)
    {
      localTroopFileTransferManager.a(localazqt.jdField_a_of_type_JavaUtilUUID, i);
      return;
    }
    localTroopFileTransferManager.a(localazqt.jdField_e_of_type_JavaLangString, localazqt.g, localazqt.h, i);
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
                          localObject1 = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
                        } while (localObject1 == null);
                        i = bbev.a(this.jdField_a_of_type_AndroidContentContext);
                        localObject3 = new azpt(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
                        switch (paramInt)
                        {
                        default: 
                          return;
                        }
                      } while ((((azqt)localObject1).jdField_b_of_type_Int != 8) && (((azqt)localObject1).jdField_b_of_type_Int != 9) && (((azqt)localObject1).jdField_b_of_type_Int != 10));
                      ((TroopFileTransferManager)localObject2).d(((azqt)localObject1).jdField_a_of_type_JavaUtilUUID);
                      a(((azqt)localObject1).jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, ((azqt)localObject1).jdField_a_of_type_JavaUtilUUID);
                      return;
                      if (i == 0)
                      {
                        bajf.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697853));
                        return;
                      }
                      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_pause_download", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
                    } while (((azqt)localObject1).jdField_b_of_type_Int != 8);
                    ((TroopFileTransferManager)localObject2).d(((azqt)localObject1).jdField_a_of_type_JavaUtilUUID);
                    return;
                    if (i == 0)
                    {
                      bajf.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697853));
                      return;
                    }
                    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
                  } while ((((azqt)localObject1).jdField_b_of_type_Int != 0) && (((azqt)localObject1).jdField_b_of_type_Int != 1));
                  ((TroopFileTransferManager)localObject2).a(((azqt)localObject1).jdField_a_of_type_JavaUtilUUID);
                  return;
                } while ((((azqt)localObject1).jdField_b_of_type_Int != 9) && (((azqt)localObject1).jdField_b_of_type_Int != 10));
                ((azpt)localObject3).b(((azqt)localObject1).jdField_a_of_type_JavaUtilUUID);
                return;
              } while ((((azqt)localObject1).jdField_b_of_type_Int != 2) && (((azqt)localObject1).jdField_b_of_type_Int != 3));
              ((azpt)localObject3).a(((azqt)localObject1).jdField_a_of_type_JavaUtilUUID);
              return;
              if (i == 0)
              {
                bajf.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697853));
                return;
              }
            } while ((((azqt)localObject1).jdField_b_of_type_Int != 1) && (((azqt)localObject1).jdField_b_of_type_Int != 0) && (((azqt)localObject1).jdField_b_of_type_Int != 2) && (((azqt)localObject1).jdField_b_of_type_Int != 3));
            ((TroopFileTransferManager)localObject2).a(((azqt)localObject1).jdField_a_of_type_JavaUtilUUID);
            a(((azqt)localObject1).jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, ((azqt)localObject1).jdField_a_of_type_JavaUtilUUID, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
            return;
            if (i == 0)
            {
              bajf.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697853));
              return;
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("forward_type", 0);
            localObject3 = apue.a((azqt)localObject1);
            ((FileManagerEntity)localObject3).status = 2;
            ((FileManagerEntity)localObject3).nOpType = 24;
            ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
            localForwardFileInfo.b(((FileManagerEntity)localObject3).nSessionId);
            localForwardFileInfo.b(10006);
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject3).getFilePath())) {
              localForwardFileInfo.a(((azqt)localObject1).jdField_a_of_type_JavaLangString);
            }
            localForwardFileInfo.d(((azqt)localObject1).g);
            localForwardFileInfo.d(((azqt)localObject1).jdField_c_of_type_Long);
            localForwardFileInfo.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
            if (((azqt)localObject1).jdField_a_of_type_JavaUtilUUID != null) {
              localForwardFileInfo.e(((azqt)localObject1).jdField_a_of_type_JavaUtilUUID.toString());
            }
            if (!TextUtils.isEmpty(((azqt)localObject1).jdField_c_of_type_JavaLangString)) {
              localForwardFileInfo.f(((azqt)localObject1).jdField_c_of_type_JavaLangString);
            }
            for (;;)
            {
              localForwardFileInfo.d(1);
              localForwardFileInfo.a(1);
              ((Bundle)localObject2).putParcelable("fileinfo", localForwardFileInfo);
              ((Bundle)localObject2).putBoolean("not_forward", true);
              localObject3 = new Intent();
              ((Intent)localObject3).putExtras((Bundle)localObject2);
              ((Intent)localObject3).putExtra("forward_text", ((azqt)localObject1).g);
              ((Intent)localObject3).putExtra("forward_from_troop_file", true);
              ((Bundle)localObject2).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              ((Intent)localObject3).putExtra("direct_send_if_dataline_forward", true);
              ((Intent)localObject3).putExtra("forward _key_nojump", true);
              ((Intent)localObject3).putExtra("sender_uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin);
              ((Intent)localObject3).putExtra("last_time", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime);
              aqbc.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject3, 21);
              if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
              }
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
              return;
              if (!TextUtils.isEmpty(((azqt)localObject1).jdField_d_of_type_JavaLangString)) {
                localForwardFileInfo.f(((azqt)localObject1).jdField_d_of_type_JavaLangString);
              }
            }
            bakj.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
            return;
            apue.a((Activity)this.jdField_a_of_type_AndroidContentContext, ((azqt)localObject1).jdField_a_of_type_JavaLangString);
            return;
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down__start_download", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
          } while ((localObject1 != null) && (((azqt)localObject1).jdField_b_of_type_Int != 7));
          ((azpt)localObject3).a(((azqt)localObject1).jdField_e_of_type_JavaLangString, ((azqt)localObject1).g, ((azqt)localObject1).jdField_c_of_type_Long, ((azqt)localObject1).h);
          return;
          axqw.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
          bakj.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
          return;
          localObject2 = apue.a((azqt)localObject1);
          localObject1 = bajk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((azqt)localObject1).jdField_b_of_type_Long).a(((FileManagerEntity)localObject2).strTroopFilePath);
          if (localObject1 != null)
          {
            ((FileManagerEntity)localObject2).lastTime = ((azpg)localObject1).c;
            ((FileManagerEntity)localObject2).selfUin = String.valueOf(((azpg)localObject1).jdField_b_of_type_Long);
          }
          new bgpd(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, false);
        } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
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
          if (apue.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) != 0) {
            break label1426;
          }
          localObject2 = "1";
        }
        for (;;)
        {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", (String)localObject1, (String)localObject2);
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
          if (apue.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2) {
            localObject2 = "2";
          } else {
            localObject2 = "3";
          }
        }
      } while (localObject1 == null);
      Object localObject2 = new TeamWorkFileImportInfo();
      ((TeamWorkFileImportInfo)localObject2).jdField_c_of_type_JavaLangString = ((azqt)localObject1).jdField_a_of_type_JavaLangString;
      ((TeamWorkFileImportInfo)localObject2).jdField_b_of_type_JavaLangString = ((azqt)localObject1).g;
      ((TeamWorkFileImportInfo)localObject2).j = apue.a(((azqt)localObject1).g);
      ((TeamWorkFileImportInfo)localObject2).jdField_b_of_type_Boolean = true;
      ((TeamWorkFileImportInfo)localObject2).jdField_d_of_type_Int = 1;
      ((TeamWorkFileImportInfo)localObject2).jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize;
      ((TeamWorkFileImportInfo)localObject2).jdField_d_of_type_JavaLangString = ((azqt)localObject1).jdField_e_of_type_JavaLangString;
      ((TeamWorkFileImportInfo)localObject2).jdField_b_of_type_Int = ((azqt)localObject1).h;
      ((TeamWorkFileImportInfo)localObject2).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
      ((TeamWorkFileImportInfo)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (((azqt)localObject1).jdField_b_of_type_Int != 12) {
        ((TeamWorkFileImportInfo)localObject2).jdField_a_of_type_Boolean = true;
      }
      ((TeamWorkFileImportInfo)localObject2).jdField_a_of_type_Int = 1;
      ayec.a((TeamWorkFileImportInfo)localObject2, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TeamWorkFileImportInfo)localObject2).jdField_d_of_type_Int);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
    return;
    axqw.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, ((azqt)localObject1).jdField_b_of_type_Long, (azqt)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, true, false);
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
    azqt localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localazqt == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    int i = 11;
    switch (apue.a(localazqt.g))
    {
    }
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68A", "0X800A68A", i, 0, "4", "", "", "");
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
      if (bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile).jdField_b_of_type_Int == 12) {
        return -1L;
      }
      l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime;
    } while (l == 0L);
    l -= awzw.a();
    if (l > 0L) {
      return l;
    }
    return -1L;
  }
  
  public String b()
  {
    azqt localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localazqt == null) {
      return "";
    }
    if (!TextUtils.isEmpty(localazqt.jdField_d_of_type_JavaLangString)) {
      return localazqt.jdField_d_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(localazqt.jdField_c_of_type_JavaLangString)) {
      return localazqt.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
  
  public List<Integer> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      azqt localazqt;
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
                localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
              } while (localazqt == null);
              if (((apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (apvb.b(localazqt.jdField_a_of_type_JavaLangString))) && (localazqt != null) && (localazqt.jdField_b_of_type_Int != 12) && (apue.a(localazqt.g) == 2)) {
                localArrayList.add(Integer.valueOf(12));
              }
              l = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localazqt.g);
              switch (localazqt.jdField_b_of_type_Int)
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
                if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localazqt, false))) {
                  localArrayList.add(Integer.valueOf(21));
                }
                break;
              }
            } while (actn.a(5) != 1);
            localArrayList.add(Integer.valueOf(17));
            return localArrayList;
            localArrayList.add(Integer.valueOf(9));
          } while (actn.a(5) != 1);
          localArrayList.add(Integer.valueOf(17));
          return localArrayList;
          localArrayList.add(Integer.valueOf(9));
        } while (actn.a(5) != 1);
        localArrayList.add(Integer.valueOf(17));
        return localArrayList;
        if (!apvb.a(localazqt.jdField_a_of_type_JavaLangString))
        {
          TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
          return localArrayList;
        }
        localArrayList.add(Integer.valueOf(9));
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localazqt, false))) {
          localArrayList.add(Integer.valueOf(21));
        }
      } while (actn.a(5) != 1);
      localArrayList.add(Integer.valueOf(17));
      return localArrayList;
      localArrayList.add(Integer.valueOf(9));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(localazqt, false))) {
        localArrayList.add(Integer.valueOf(21));
      }
    } while (actn.a(5) != 1);
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
    axqw.b(null, "dc00898", "", "", "0X800A685", "0X800A685", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    while (bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile).jdField_b_of_type_Int != 3) {
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
    azqt localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime != 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime())) {
      return 6;
    }
    if (localazqt.jdField_b_of_type_Int == 12) {
      return 1;
    }
    switch (localazqt.jdField_b_of_type_Int)
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
    return this.jdField_a_of_type_AndroidContentContext.getString(2131697478);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      return;
      localObject = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    } while ((localObject == null) || (((azqt)localObject).jdField_b_of_type_Int != 3));
    Object localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)localObject, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    azqt localazqt;
    do
    {
      return false;
      localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    } while ((localazqt == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg));
    int i = apue.a(localazqt.g);
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
      bool = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    }
    azqt localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    switch (localazqt.jdField_b_of_type_Int)
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
          } while (!bbdj.b(localazqt.jdField_a_of_type_JavaLangString));
          return 2;
          return 4;
          if (!bool) {
            break;
          }
        } while (!bbdj.b(localazqt.jdField_a_of_type_JavaLangString));
        return 2;
      } while (!bbdj.b(localazqt.jdField_a_of_type_JavaLangString));
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
    azqt localazqt;
    do
    {
      return 0;
      localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    } while (localazqt == null);
    return bakj.a(localazqt.jdField_d_of_type_Long, localazqt.jdField_c_of_type_Long);
  }
  
  public int f()
  {
    azqt localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localazqt == null) {}
    while (localazqt.jdField_c_of_type_Boolean) {
      return 0;
    }
    if (apvk.a(localazqt.jdField_e_of_type_Int, localazqt.f, localazqt.jdField_c_of_type_Long)) {
      return 1;
    }
    if (localazqt.i == 1) {
      return 1;
    }
    if (localazqt.i == 2) {
      return 2;
    }
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoyn
 * JD-Core Version:    0.7.0.1
 */