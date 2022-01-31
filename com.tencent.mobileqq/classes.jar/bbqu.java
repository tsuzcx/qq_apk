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
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Timer;
import mqq.manager.Manager;

public class bbqu
  implements Manager
{
  int jdField_a_of_type_Int = 0;
  protected alpa a;
  ameq jdField_a_of_type_Ameq = new bbqx(this);
  Dialog jdField_a_of_type_AndroidAppDialog;
  bbrd jdField_a_of_type_Bbrd;
  public bbre a;
  public QQAppInterface a;
  TroopSearchLogic jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic;
  public String a;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  public ArrayList<bcgz> a;
  Timer jdField_a_of_type_JavaUtilTimer;
  public int b;
  
  public bbqu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "DEFAULT";
    this.jdField_a_of_type_Bbre = new bbre();
    this.jdField_a_of_type_Alpa = new bbqy(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
    Collections.sort(paramArrayList, new bbra());
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
  
  private boolean a(ArrayList<ResultRecord> paramArrayList)
  {
    Object localObject = paramArrayList.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (!((ResultRecord)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label107;
      }
      i = 1;
    }
    label107:
    for (;;)
    {
      break;
      if (i == 0)
      {
        localObject = new ResultRecord();
        ((ResultRecord)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        ((ResultRecord)localObject).jdField_a_of_type_Int = 0;
        ((ResultRecord)localObject).jdField_b_of_type_JavaLangString = bdgc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ResultRecord)localObject).jdField_a_of_type_JavaLangString, ((ResultRecord)localObject).jdField_a_of_type_Int);
        paramArrayList.add(localObject);
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
      localObject = new bety((Context)localObject, localBaseActivity.getTitleBarHeight());
      ((bety)localObject).a(paramString);
      ((bety)localObject).setCancelable(false);
      ((bety)localObject).setOnDismissListener(new bbqz(this));
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
  
  public final bbre a()
  {
    return this.jdField_a_of_type_Bbre;
  }
  
  public String a(ResultRecord paramResultRecord, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramResultRecord.jdField_a_of_type_JavaLangString, paramString, 1, 0);
      if (!TextUtils.equals(paramString, paramResultRecord.jdField_a_of_type_JavaLangString)) {
        return paramString;
      }
    }
    if (((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramResultRecord.jdField_a_of_type_JavaLangString)) {
      return bdgc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramResultRecord.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramResultRecord.jdField_a_of_type_JavaLangString)) {
      return paramResultRecord.jdField_b_of_type_JavaLangString;
    }
    if (paramResultRecord.jdField_a_of_type_Int == 1)
    {
      paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramResultRecord.c, paramResultRecord.jdField_a_of_type_JavaLangString);
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.friendnick))) {
        return paramString.friendnick;
      }
    }
    else if (paramResultRecord.jdField_a_of_type_Int == 2)
    {
      paramString = ((alrk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(paramResultRecord.c, paramResultRecord.jdField_a_of_type_JavaLangString);
      if (paramString != null)
      {
        if (!TextUtils.isEmpty(paramString.memberName)) {
          return paramString.memberName;
        }
        return paramString.inteRemark;
      }
    }
    return paramResultRecord.jdField_a_of_type_JavaLangString + "";
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alpa);
    }
    b();
    this.jdField_a_of_type_Bbrd = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Bbre != null) {
      this.jdField_a_of_type_Bbre.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "terminateLogic");
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    Intent localIntent = aepi.a(new Intent(paramContext, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", this.jdField_a_of_type_Bbre.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("isBack2Root", true);
    if ((paramContext instanceof Application)) {
      localIntent.setFlags(268435456);
    }
    localIntent.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
    paramContext.startActivity(localIntent);
  }
  
  public void a(bbrd parambbrd)
  {
    if (this.jdField_a_of_type_Bbrd == parambbrd) {
      this.jdField_a_of_type_Bbrd = null;
    }
  }
  
  public void a(bbrd parambbrd, BaseActivity paramBaseActivity, ArrayList<ResultRecord> paramArrayList)
  {
    if (!bdin.g(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131694768, 0).a();
      a();
      return;
    }
    if ((this.jdField_a_of_type_Bbre == null) || (this.jdField_a_of_type_Bbre.jdField_a_of_type_Bbqt == null))
    {
      a();
      return;
    }
    if (paramBaseActivity != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    }
    Object localObject;
    if (paramArrayList != null)
    {
      a(paramArrayList);
      if (paramArrayList.size() > 0)
      {
        this.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
        paramBaseActivity = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject = a((ResultRecord)paramArrayList.next(), null);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramBaseActivity.add(localObject);
          }
        }
        this.jdField_a_of_type_Bbre.jdField_b_of_type_JavaLangString = a(paramBaseActivity);
      }
    }
    int i;
    long l1;
    long l2;
    try
    {
      l3 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayList = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
      localObject = this.jdField_a_of_type_Bbre.e.split("\\|");
      i = 0;
      l1 = 0L;
      l2 = 0L;
      paramBaseActivity = "";
      if (localObject.length != 4) {
        break label424;
      }
    }
    catch (NumberFormatException parambbrd)
    {
      long l3;
      float f;
      label269:
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
      break label269;
    }
    try
    {
      f = Float.valueOf(localObject[1]).floatValue();
      l1 = (f * 1000000.0F);
    }
    catch (NumberFormatException paramBaseActivity)
    {
      l1 = 0L;
      break label269;
    }
    try
    {
      f = Float.valueOf(localObject[2]).floatValue();
      l2 = (f * 1000000.0F);
    }
    catch (NumberFormatException paramBaseActivity)
    {
      break label269;
    }
    paramBaseActivity = localObject[3];
    for (;;)
    {
      int k = this.jdField_a_of_type_Bbre.jdField_c_of_type_Int;
      int j = k;
      if (k == 2) {
        j = k + 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alpa);
      localObject = this.jdField_a_of_type_Bbre.jdField_a_of_type_Bbqt;
      this.jdField_a_of_type_Bbrd = parambbrd;
      paramArrayList.a(((bbqt)localObject).jdField_b_of_type_Long, ((bbqt)localObject).jdField_b_of_type_Int, l3, this.jdField_a_of_type_Bbre.jdField_b_of_type_Int, this.jdField_a_of_type_Bbre.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bbre.d, this.jdField_a_of_type_Bbre.jdField_a_of_type_Int, j, l1, l2, i, paramBaseActivity, ((bbqt)localObject).a, this.jdField_b_of_type_Int);
      b(alud.a(2131715676));
      return;
      label424:
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
      bbmr.a(paramBaseActivity, this.jdField_b_of_type_Int);
      return;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
      }
      bbmr.a(paramBaseActivity);
      return;
    }
    if (("1".equals(this.jdField_a_of_type_JavaLangString)) || ("0".equals(this.jdField_a_of_type_JavaLangString)) || ("2".equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering create troop session, From type: %s, Troop type: %s...", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), this.jdField_a_of_type_JavaLangString }));
      }
      bbmr.a(paramBaseActivity, this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramBaseActivity.finish();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
      }
      bbmr.a(paramBaseActivity);
    }
  }
  
  public void a(BaseActivity paramBaseActivity, bbrd parambbrd)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
      this.jdField_a_of_type_Bbrd = parambbrd;
    }
    paramBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramBaseActivity == null)
    {
      a();
      return;
    }
    if ((this.jdField_a_of_type_Bbre == null) || (this.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Bbrd == null))
    {
      a();
      return;
    }
    a(this.jdField_a_of_type_Bbrd, paramBaseActivity, this.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((this.jdField_a_of_type_Bbre != null) && (paramString.equals(this.jdField_a_of_type_Bbre.f))) {}
    MessageForGrayTips localMessageForGrayTips;
    do
    {
      return;
      localMessageForGrayTips = (MessageForGrayTips)azaf.a(2024);
      localMessageForGrayTips.frienduin = paramString;
      Object localObject = BaseApplicationImpl.getApplication().getResources();
      String str1 = ((Resources)localObject).getString(2131697733);
      String str2 = ((Resources)localObject).getString(2131697731);
      localObject = ((Resources)localObject).getString(2131697732);
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
    } while (alww.a(paramQQAppInterface, localMessageForGrayTips, false));
    paramQQAppInterface.a().a(localMessageForGrayTips, paramQQAppInterface.getCurrentAccountUin());
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bbrd != null) {
      this.jdField_a_of_type_Bbrd.c(paramString);
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Bbre.b();
    this.jdField_a_of_type_Bbre.a(paramString);
    this.jdField_a_of_type_Bbre.a();
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      break label8;
    }
    label8:
    label146:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Bbre != null) && (paramString1.equals(this.jdField_a_of_type_Bbre.f)) && (this.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList != null))
      {
        Iterator localIterator = this.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList.iterator();
        ResultRecord localResultRecord;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localResultRecord = (ResultRecord)localIterator.next();
        } while (!paramString2.equals(localResultRecord.jdField_a_of_type_JavaLangString));
        for (;;)
        {
          if (localResultRecord == null) {
            break label146;
          }
          this.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList.remove(localResultRecord);
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
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)azaf.a(2024);
    localMessageForGrayTips.frienduin = paramString1;
    if ((paramBoolean) && ((this.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList.size() == 0))) {}
    do
    {
      return;
      l2 = 0L;
      if ((this.jdField_a_of_type_Bbre == null) || (!paramString1.equals(this.jdField_a_of_type_Bbre.f))) {
        break;
      }
    } while (this.jdField_a_of_type_Bbre.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_Bbre.jdField_c_of_type_Boolean = true;
    long l2 = this.jdField_a_of_type_Bbre.jdField_a_of_type_Long;
    long l1 = l2;
    if (QLog.isColorLevel()) {
      QLog.d("TroopCreatGrayTip", 2, "addCreateNewTroopGrayTips troopMaxMsgseq:" + l2);
    }
    String str;
    StringBuffer localStringBuffer;
    for (;;)
    {
      str = alud.a(2131715674);
      if (!paramBoolean) {
        break label434;
      }
      paramString2 = alud.a(2131715672);
      localStringBuffer = new StringBuffer();
      Iterator localIterator = this.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ResultRecord)localIterator.next();
        if (!((ResultRecord)localObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
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
      if (alww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForGrayTips, false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForGrayTips, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
      label434:
      if (!TextUtils.isEmpty(paramString2)) {
        paramString2 = String.format(alud.a(2131715671), new Object[] { paramString2 });
      } else {
        paramString2 = alud.a(2131715673);
      }
    }
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, bbrc parambbrc)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      a(paramArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic = new TroopSearchLogic();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic.a(paramArrayList, new bbqw(this, parambbrc));
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    if ((this.jdField_a_of_type_Bbre != null) && (paramString1.equals(this.jdField_a_of_type_Bbre.f)) && (this.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList != null))
    {
      paramString1 = this.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        if (paramString2.equals(((ResultRecord)paramString1.next()).jdField_a_of_type_JavaLangString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void b(bbrd parambbrd)
  {
    a(parambbrd, null, null);
  }
  
  public void b(bbrd parambbrd, BaseActivity paramBaseActivity, ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (!localResultRecord.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
        {
          bbrb localbbrb = new bbrb(this);
          localbbrb.jdField_a_of_type_JavaLangString = localResultRecord.jdField_b_of_type_JavaLangString;
          localbbrb.jdField_b_of_type_JavaLangString = ChnToSpell.a(localResultRecord.jdField_b_of_type_JavaLangString, 2);
          localArrayList.add(localbbrb);
        }
      }
      Collections.sort(localArrayList);
      a(paramArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic = new TroopSearchLogic();
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
      this.jdField_a_of_type_Bbrd = parambbrd;
      this.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      b(alud.a(2131715677));
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic.a(paramArrayList, new bbqv(this, localArrayList, paramBaseActivity, parambbrd, paramArrayList));
    }
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqu
 * JD-Core Version:    0.7.0.1
 */