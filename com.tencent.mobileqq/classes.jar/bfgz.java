import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager.BadTokenException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import mqq.manager.Manager;

public class bfgz
  implements Manager
{
  int jdField_a_of_type_Int = 0;
  Dialog jdField_a_of_type_AndroidAppDialog;
  protected anrc a;
  aofu jdField_a_of_type_Aofu = new bfhc(this);
  bfhi jdField_a_of_type_Bfhi;
  public bfhj a;
  public QQAppInterface a;
  TroopSearchLogic jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic;
  public String a;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  public ArrayList<bfxy> a;
  Timer jdField_a_of_type_JavaUtilTimer;
  public int b;
  
  public bfgz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "DEFAULT";
    this.jdField_a_of_type_Bfhj = new bfhj();
    this.jdField_a_of_type_Anrc = new bfhd(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
    Collections.sort(paramArrayList, new bfhf());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      paramArrayList = (String)localIterator.next();
      if (i <= 2) {
        break label91;
      }
    }
    label91:
    int k;
    int j;
    for (;;)
    {
      if (localStringBuffer.toString().endsWith("、")) {
        localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
      }
      return localStringBuffer.toString();
      if ((paramArrayList == null) || ("".equals(paramArrayList))) {
        break label324;
      }
      try
      {
        k = localStringBuffer.toString().getBytes("utf-8").length;
        j = paramArrayList.getBytes("utf-8").length;
        k = 30 - k;
        if (k > 0) {
          if (i == 0) {
            if (j > 20)
            {
              while (j >= 14)
              {
                paramArrayList = paramArrayList.substring(0, paramArrayList.length() - 1);
                j = paramArrayList.getBytes("utf-8").length;
              }
              localStringBuffer.append(paramArrayList).append("…").append("、");
            }
            else
            {
              localStringBuffer.append(paramArrayList).append("、");
            }
          }
        }
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
    }
    label222:
    Object localObject2;
    if (k < 3)
    {
      k = 3;
      if (k >= j) {
        break label334;
      }
      Object localObject1 = paramArrayList;
      int n = 0;
      int m = j;
      for (j = n;; j = 1)
      {
        localObject2 = localObject1;
        if (k >= m + 3) {
          break;
        }
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        m = ((String)localObject1).getBytes("utf-8").length;
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        localStringBuffer.append((String)localObject2).append("…").append("、");
      }
      else
      {
        localStringBuffer.append(paramArrayList).append("、");
        break label327;
        break label222;
        label324:
        break label331;
      }
      label327:
      i += 1;
      label331:
      break;
      label334:
      j = 0;
      localObject2 = paramArrayList;
    }
  }
  
  private boolean a(List<ResultRecord> paramList)
  {
    Object localObject = paramList.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (!((ResultRecord)((Iterator)localObject).next()).uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label111;
      }
      i = 1;
    }
    label111:
    for (;;)
    {
      break;
      if (i == 0)
      {
        localObject = new ResultRecord();
        ((ResultRecord)localObject).uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
        ((ResultRecord)localObject).type = 0;
        ((ResultRecord)localObject).name = ContactUtils.getNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ResultRecord)localObject).uin, ((ResultRecord)localObject).type);
        paramList.add(localObject);
      }
      return i == 0;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  private void b(String paramString)
  {
    Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!(localObject instanceof BaseActivity)) {}
    do
    {
      BaseActivity localBaseActivity;
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()));
        localBaseActivity = (BaseActivity)localObject;
      } while (localBaseActivity.isFinishing());
      localObject = new bisl((Context)localObject, localBaseActivity.getTitleBarHeight());
      ((bisl)localObject).a(paramString);
      ((bisl)localObject).setCancelable(false);
      ((bisl)localObject).setOnDismissListener(new bfhe(this));
      this.jdField_a_of_type_AndroidAppDialog = ((Dialog)localObject);
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (WindowManager.BadTokenException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.i("TroopCreateLogic", 2, paramString.getMessage());
  }
  
  public final bfhj a()
  {
    return this.jdField_a_of_type_Bfhj;
  }
  
  public String a(ResultRecord paramResultRecord, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramResultRecord.uin, paramString, 1, 0);
      if (!TextUtils.equals(paramString, paramResultRecord.uin)) {
        return paramString;
      }
    }
    if (((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramResultRecord.uin)) {
      return ContactUtils.getFriendName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramResultRecord.uin);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramResultRecord.uin)) {
      return paramResultRecord.name;
    }
    if (paramResultRecord.type == 1)
    {
      paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramResultRecord.groupUin, paramResultRecord.uin);
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.friendnick))) {
        return paramString.friendnick;
      }
    }
    else if (paramResultRecord.type == 2)
    {
      paramString = ((antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramResultRecord.groupUin, paramResultRecord.uin);
      if (paramString != null)
      {
        if (!TextUtils.isEmpty(paramString.memberName)) {
          return paramString.memberName;
        }
        return paramString.inteRemark;
      }
    }
    return paramResultRecord.uin + "";
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anrc);
    }
    b();
    this.jdField_a_of_type_Bfhi = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Bfhj != null) {
      this.jdField_a_of_type_Bfhj.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "terminateLogic");
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(paramContext, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", this.jdField_a_of_type_Bfhj.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("isBack2Root", true);
    if ((paramContext instanceof Application)) {
      localIntent.setFlags(268435456);
    }
    localIntent.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
    paramContext.startActivity(localIntent);
  }
  
  public void a(bfhi parambfhi)
  {
    if (this.jdField_a_of_type_Bfhi == parambfhi) {
      this.jdField_a_of_type_Bfhi = null;
    }
  }
  
  public void a(bfhi parambfhi, BaseActivity paramBaseActivity, ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (!localResultRecord.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
        {
          bfhg localbfhg = new bfhg(this);
          localbfhg.jdField_a_of_type_JavaLangString = localResultRecord.name;
          localbfhg.jdField_b_of_type_JavaLangString = ChnToSpell.a(localResultRecord.name, 2);
          localArrayList.add(localbfhg);
        }
      }
      Collections.sort(localArrayList);
      a(paramArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic = new TroopSearchLogic();
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
      this.jdField_a_of_type_Bfhi = parambfhi;
      this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(paramArrayList);
      b(anvx.a(2131714646));
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic.a(paramArrayList, new bfha(this, localArrayList, paramBaseActivity, parambfhi, paramArrayList));
    }
  }
  
  public void a(bfhi parambfhi, BaseActivity paramBaseActivity, List<ResultRecord> paramList)
  {
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131694255, 0).a();
      a();
      return;
    }
    if ((this.jdField_a_of_type_Bfhj == null) || (this.jdField_a_of_type_Bfhj.jdField_a_of_type_Bfgy == null))
    {
      a();
      return;
    }
    if (paramBaseActivity != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    }
    Object localObject;
    if (paramList != null)
    {
      a(paramList);
      if (paramList.size() > 0)
      {
        if (this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList != paramList) {
          this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(paramList);
        }
        paramBaseActivity = new ArrayList();
        paramList = this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          localObject = a((ResultRecord)paramList.next(), null);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramBaseActivity.add(localObject);
          }
        }
        this.jdField_a_of_type_Bfhj.jdField_b_of_type_JavaLangString = a(paramBaseActivity);
      }
    }
    int i;
    long l1;
    long l2;
    try
    {
      l3 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramList = (anrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      localObject = this.jdField_a_of_type_Bfhj.e.split("\\|");
      i = 0;
      l1 = 0L;
      l2 = 0L;
      paramBaseActivity = "";
      if (localObject.length != 4) {
        break label449;
      }
    }
    catch (NumberFormatException parambfhi)
    {
      long l3;
      float f;
      label294:
      a();
      return;
    }
    try
    {
      i = Integer.parseInt(localObject[0]);
    }
    catch (NumberFormatException paramBaseActivity)
    {
      l1 = 0L;
      i = 0;
      break label294;
    }
    try
    {
      f = Float.valueOf(localObject[1]).floatValue();
      l1 = (f * 1000000.0F);
    }
    catch (NumberFormatException paramBaseActivity)
    {
      l1 = 0L;
      break label294;
    }
    try
    {
      f = Float.valueOf(localObject[2]).floatValue();
      l2 = (f * 1000000.0F);
    }
    catch (NumberFormatException paramBaseActivity)
    {
      break label294;
    }
    paramBaseActivity = localObject[3];
    for (;;)
    {
      int k = this.jdField_a_of_type_Bfhj.jdField_c_of_type_Int;
      int j = k;
      if (k == 2) {
        j = k + 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anrc);
      localObject = this.jdField_a_of_type_Bfhj.jdField_a_of_type_Bfgy;
      this.jdField_a_of_type_Bfhi = parambfhi;
      paramList.a(((bfgy)localObject).jdField_b_of_type_Long, ((bfgy)localObject).jdField_b_of_type_Int, l3, this.jdField_a_of_type_Bfhj.jdField_b_of_type_Int, this.jdField_a_of_type_Bfhj.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bfhj.d, this.jdField_a_of_type_Bfhj.jdField_a_of_type_Int, j, l1, l2, i, paramBaseActivity, ((bfgy)localObject).a, this.jdField_b_of_type_Int);
      b(anvx.a(2131714645));
      return;
      label449:
      l2 = 0L;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt)
  {
    a(paramBaseActivity, paramInt, "DEFAULT");
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "startCreateTroopSession: from=" + paramInt + ", type=" + paramString);
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    a();
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
      }
      bfcz.a(paramBaseActivity, this.jdField_b_of_type_Int);
      return;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
      }
      bfcz.a(paramBaseActivity);
      return;
    }
    if (("1".equals(this.jdField_a_of_type_JavaLangString)) || ("0".equals(this.jdField_a_of_type_JavaLangString)) || ("2".equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering create troop session, From type: %s, Troop type: %s...", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), this.jdField_a_of_type_JavaLangString }));
      }
      bfcz.a(paramBaseActivity, this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramBaseActivity.finish();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
      }
      bfcz.a(paramBaseActivity);
    }
  }
  
  public void a(BaseActivity paramBaseActivity, bfhi parambfhi)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
      this.jdField_a_of_type_Bfhi = parambfhi;
    }
    paramBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramBaseActivity == null)
    {
      a();
      return;
    }
    if ((this.jdField_a_of_type_Bfhj == null) || (this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Bfhi == null))
    {
      a();
      return;
    }
    a(this.jdField_a_of_type_Bfhi, paramBaseActivity, this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((this.jdField_a_of_type_Bfhj != null) && (paramString.equals(this.jdField_a_of_type_Bfhj.f))) {}
    MessageForGrayTips localMessageForGrayTips;
    do
    {
      return;
      localMessageForGrayTips = (MessageForGrayTips)bcsa.a(2024);
      localMessageForGrayTips.frienduin = paramString;
      Object localObject = BaseApplicationImpl.getApplication().getResources();
      String str1 = ((Resources)localObject).getString(2131697032);
      String str2 = ((Resources)localObject).getString(2131697030);
      localObject = ((Resources)localObject).getString(2131697031);
      localMessageForGrayTips.init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, str1, NetConnInfoCenter.getServerTime(), -1047, 1, 0L);
      localMessageForGrayTips.setTextGravity(17);
      paramString = new Bundle();
      paramString.putInt("key_action", 7);
      int i = str1.indexOf(str2);
      localMessageForGrayTips.addHightlightItem(i, str2.length() + i, paramString);
      paramString = new Bundle();
      paramString.putInt("key_action", 6);
      i = str1.indexOf((String)localObject);
      localMessageForGrayTips.addHightlightItem(i, ((String)localObject).length() + i, paramString);
    } while (anyv.a(paramQQAppInterface, localMessageForGrayTips, false));
    paramQQAppInterface.getMessageFacade().addMessage(localMessageForGrayTips, paramQQAppInterface.getCurrentAccountUin());
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bfhi != null) {
      this.jdField_a_of_type_Bfhi.onReusedTroop(paramString);
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Bfhj.b();
    this.jdField_a_of_type_Bfhj.a(paramString);
    this.jdField_a_of_type_Bfhj.a();
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      break label8;
    }
    label8:
    label150:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Bfhj != null) && (paramString1.equals(this.jdField_a_of_type_Bfhj.f)) && (this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList != null))
      {
        Iterator localIterator = this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList.iterator();
        ResultRecord localResultRecord;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localResultRecord = (ResultRecord)localIterator.next();
        } while (!paramString2.equals(localResultRecord.uin));
        for (;;)
        {
          if (localResultRecord == null) {
            break label150;
          }
          this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList.remove(localResultRecord);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopCreateLogic", 2, "deleteInInviteList troopUin:" + paramString1 + "  memberUin:" + paramString2);
          return;
          localResultRecord = null;
        }
      }
    }
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)bcsa.a(2024);
    localMessageForGrayTips.frienduin = paramString1;
    if ((paramBoolean) && ((this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList.size() == 0))) {}
    do
    {
      return;
      l2 = 0L;
      if ((this.jdField_a_of_type_Bfhj == null) || (!paramString1.equals(this.jdField_a_of_type_Bfhj.f))) {
        break;
      }
    } while (this.jdField_a_of_type_Bfhj.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_Bfhj.jdField_c_of_type_Boolean = true;
    long l2 = this.jdField_a_of_type_Bfhj.jdField_a_of_type_Long;
    long l1 = l2;
    if (QLog.isColorLevel()) {
      QLog.d("TroopCreatGrayTip", 2, "addCreateNewTroopGrayTips troopMaxMsgseq:" + l2);
    }
    String str;
    StringBuffer localStringBuffer;
    for (;;)
    {
      str = anvx.a(2131714643);
      if (!paramBoolean) {
        break label438;
      }
      paramString2 = anvx.a(2131714641);
      localStringBuffer = new StringBuffer();
      Iterator localIterator = this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ResultRecord)localIterator.next();
        if (!((ResultRecord)localObject).uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
        {
          localObject = a((ResultRecord)localObject, paramString1);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localStringBuffer.append((String)localObject).append("、");
          }
        }
      }
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopCreatGrayTip", 2, "addCreateNewTroopGrayTips createInfo is null. troopUin = " + paramString1);
        l1 = l2;
      }
      l2 = l1;
    }
    localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
    paramString2 = String.format(paramString2, new Object[] { localStringBuffer.toString() });
    for (;;)
    {
      localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramString2, NetConnInfoCenter.getServerTime(), -1047, 1, 0L);
      localMessageForGrayTips.shmsgseq = l2;
      paramString1 = new Bundle();
      paramString1.putInt("key_action", 25);
      int i = paramString2.indexOf(str);
      localMessageForGrayTips.addHightlightItem(i, str.length() + i, paramString1);
      if (anyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForGrayTips, false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(localMessageForGrayTips, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
      label438:
      if (!TextUtils.isEmpty(paramString2)) {
        paramString2 = String.format(anvx.a(2131714640), new Object[] { paramString2 });
      } else {
        paramString2 = anvx.a(2131714642);
      }
    }
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, bfhh parambfhh)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      a(paramArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic = new TroopSearchLogic();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic.a(paramArrayList, new bfhb(this, parambfhh));
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    if ((this.jdField_a_of_type_Bfhj != null) && (paramString1.equals(this.jdField_a_of_type_Bfhj.f)) && (this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList != null))
    {
      paramString1 = this.jdField_a_of_type_Bfhj.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString1.hasNext()) {
        if (paramString2.equals(((ResultRecord)paramString1.next()).uin)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void b(bfhi parambfhi)
  {
    a(parambfhi, null, null);
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgz
 * JD-Core Version:    0.7.0.1
 */