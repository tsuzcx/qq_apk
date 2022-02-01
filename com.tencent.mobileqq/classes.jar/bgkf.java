import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.2;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class bgkf
  implements Manager
{
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  aofu jdField_a_of_type_Aofu = new bgkg(this);
  public QQAppInterface a;
  Queue<Integer> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  
  public bgkf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("troop_gag_seqlist", 32768);
    paramQQAppInterface = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("seqs", null);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.split(";");
      int j = paramQQAppInterface.length;
      int i = 0;
      while (i < j)
      {
        String str = paramQQAppInterface[i];
        try
        {
          this.jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(str));
          i += 1;
        }
        finally {}
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean, long paramLong)
  {
    ((anrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).d(new bgki(paramString, new bgkk(paramBoolean, paramLong)));
  }
  
  private void b(String paramString)
  {
    ((anrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).d(new bgki(paramString, a(paramString)));
  }
  
  private void b(String paramString, boolean paramBoolean, long paramLong)
  {
    anrb localanrb = (anrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
    paramString = new bgki(paramString, new bgkj(paramBoolean, paramLong));
    paramString.b = 3;
    localanrb.d(paramString);
  }
  
  public bgkl a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagMgr", 2, String.format("fightgag.getSelfGagInfo240:sUin=%s,", new Object[] { paramString }));
    }
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null) {
      return new bgkl(this, paramString, false, "", 0L);
    }
    localObject = ((TroopManager)localObject).c(paramString);
    if (localObject == null) {
      return new bgkl(this, paramString, false, "", 0L);
    }
    long l = NetConnInfoCenter.getServerTime();
    boolean bool = a(paramString);
    if ((((TroopInfo)localObject).dwGagTimeStamp != 0L) && (!bool))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("getTroopGagInfo:sUin=%s, Troop Gag", new Object[] { paramString }));
      }
      return new bgkl(this, paramString, true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131696959), 60L);
    }
    if ((((TroopInfo)localObject).dwGagTimeStamp_me != 0L) && (l < ((TroopInfo)localObject).dwGagTimeStamp_me + 3L))
    {
      QLog.d("TroopGagMgr", 1, "fightgag.getSelfGagInfo:sUin= " + paramString + ",dwGagTimeStamp_me = " + ((TroopInfo)localObject).dwGagTimeStamp_me + ",lCutTimeStamp  = " + l);
      Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
      String str = localContext.getString(2131697488);
      l = ((TroopInfo)localObject).dwGagTimeStamp_me + 3L;
      if (paramBoolean) {
        l = ((TroopInfo)localObject).dwGagTimeStamp_me - 30L;
      }
      return new bgkl(this, paramString, true, String.format(str, new Object[] { b(localContext, l) }), 60L);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("getTroopGagInfo:sUin=%s, not Gag", new Object[] { paramString }));
    }
    return new bgkl(this, paramString, false, "", 0L);
  }
  
  public bgkm a(String paramString)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null) {
      return new bgkm(this, paramString, 0L);
    }
    localObject = ((TroopManager)localObject).c(paramString);
    if (localObject == null) {
      return new bgkm(this, paramString, 0L);
    }
    return new bgkm(this, paramString, ((TroopInfo)localObject).dwGagTimeStamp);
  }
  
  public String a(Context paramContext, long paramLong)
  {
    return String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131697343), new Object[] { b(paramContext, paramLong) });
  }
  
  public String a(Context paramContext, long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    paramContext = ((Context)localObject).getString(2131697145);
    String str1 = ((Context)localObject).getString(2131697144);
    localObject = ((Context)localObject).getString(2131697143);
    String str2 = anvx.a(2131714752);
    if (paramLong1 < 60L) {
      return String.format(str2, new Object[] { Integer.valueOf(1), paramContext });
    }
    if (paramLong1 <= 3540L) {
      return String.format(str2, new Object[] { Long.valueOf((57L + paramLong1) / 60L), paramContext });
    }
    if (paramLong1 <= 84600L) {
      return String.format(str2, new Object[] { Long.valueOf(Math.round((float)paramLong1 * 1.0F / 3600.0F)), str1 });
    }
    return String.format(str2, new Object[] { Long.valueOf(Math.round((float)paramLong1 * 1.0F / 86400.0F)), localObject });
  }
  
  public String a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager == null) {
      return "";
    }
    paramString = localTroopManager.b(paramString);
    if (paramString == null) {
      return "";
    }
    if (paramString.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return "1";
    }
    return "2";
  }
  
  public ArrayList<aofq> a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null) {
      localObject = null;
    }
    ArrayList localArrayList;
    do
    {
      return localObject;
      localArrayList = ((TroopManager)localObject).c(paramString);
      localObject = localArrayList;
    } while (!paramBoolean);
    b(paramString, null);
    return localArrayList;
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = this.jdField_a_of_type_JavaUtilQueue.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          if (paramInt1 != ((Integer)((Iterator)localObject1).next()).intValue()) {
            continue;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("TroopGagMgr", 4, String.format("Discard message", new Object[0]));
          }
          return;
        }
        if (this.jdField_a_of_type_JavaUtilQueue.size() > 30) {
          this.jdField_a_of_type_JavaUtilQueue.poll();
        }
        this.jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt1));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
        localObject1 = String.valueOf(paramLong1);
        if (!TextUtils.isEmpty(paramString)) {
          break label244;
        }
        if (paramLong3 == 0L)
        {
          paramString = ((Context)localObject2).getResources().getString(2131695793);
          localObject2 = (MessageForGrayTips)bcsa.a(-2030);
          ((MessageForGrayTips)localObject2).frienduin = ((String)localObject1);
          ((MessageForGrayTips)localObject2).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject1, (String)localObject1, paramString, paramLong2, -2030, 1, paramInt1);
          ((MessageForGrayTips)localObject2).isread = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage((MessageRecord)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          return;
        }
      }
      finally {}
      paramString = ((Context)localObject2).getResources().getString(2131695783);
      continue;
      label244:
      if (paramLong3 == 0L) {
        paramString = ((Context)localObject2).getResources().getString(2131695785, new Object[] { paramString });
      } else {
        paramString = ((Context)localObject2).getResources().getString(2131695786, new Object[] { paramString, c((Context)localObject2, paramLong3) });
      }
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, ArrayList<aoor> paramArrayList)
  {
    int i = 0;
    label530:
    label566:
    for (;;)
    {
      String str1;
      String str2;
      TroopManager localTroopManager;
      String str3;
      boolean bool;
      aoor localaoor;
      String str4;
      try
      {
        Object localObject = this.jdField_a_of_type_JavaUtilQueue.iterator();
        if (((Iterator)localObject).hasNext())
        {
          if (paramInt != ((Integer)((Iterator)localObject).next()).intValue()) {
            continue;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("TroopGagMgr", 4, String.format("Discard message", new Object[0]));
          }
          return;
        }
        if (this.jdField_a_of_type_JavaUtilQueue.size() > 30) {
          this.jdField_a_of_type_JavaUtilQueue.poll();
        }
        this.jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt));
        str1 = String.valueOf(paramLong1);
        str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        localObject = localTroopManager.b(String.valueOf(paramLong1));
        if (localObject != null) {
          break label566;
        }
        localObject = new TroopInfo();
        ((TroopInfo)localObject).troopuin = String.valueOf(paramLong1);
        if (TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)) {
          ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(((TroopInfo)localObject).troopuin, false);
        }
        str3 = String.valueOf(paramLong2);
        bool = str3.equalsIgnoreCase(((TroopInfo)localObject).troopowneruin);
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break label530;
        }
        localaoor = (aoor)paramArrayList.next();
        str4 = localaoor.jdField_a_of_type_JavaLangString;
        if ((localaoor.jdField_a_of_type_Long == 0L) || (localaoor.jdField_a_of_type_Long == 4294967295L))
        {
          paramLong2 = localaoor.jdField_a_of_type_Long;
          if (str4.equals(str2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopGagMgr", 2, " fightgag.onPushGagMsg ltroopUin = " + str1 + ",lGagTimeStamp = " + paramLong2);
            }
            ((TroopInfo)localObject).dwGagTimeStamp_me = paramLong2;
            localTroopManager.b((TroopInfo)localObject);
            a(str1, true);
            a(str1, str3, paramLong3, localaoor.jdField_a_of_type_Long, paramInt, false, bool);
            i = 1;
          }
          if (!str4.equals("0")) {
            break label469;
          }
          ((TroopInfo)localObject).dwGagTimeStamp = paramLong2;
          localTroopManager.b((TroopInfo)localObject);
          b(str1);
          a(str1, true);
          a(str1, str3, paramLong3, localaoor.jdField_a_of_type_Long, paramInt, true, bool);
          i = 1;
          continue;
        }
        paramLong2 = localaoor.jdField_a_of_type_Long + paramLong3;
      }
      finally {}
      continue;
      label469:
      if (!str4.equals(str2)) {
        a(str1, paramLong3, localaoor.jdField_a_of_type_Long, paramInt, str3, str4, bool);
      }
      localTroopManager.c(paramLong1 + "", str4, paramLong2);
      continue;
      if (i == 0) {
        break;
      }
      paramArrayList = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      try
      {
        paramArrayList.h(str1);
        return;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        return;
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(paramInt), paramBoolean);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((!a(paramToServiceMsg, paramFromServiceMsg, paramObject)) && (!b(paramToServiceMsg, paramFromServiceMsg, paramObject))) {}
    for (int i = 0;; i = 1)
    {
      if ((i == 0) && (QLog.isDevelopLevel())) {
        QLog.i("TroopGagMgr", 4, "bad subcmd" + paramFromServiceMsg.getServiceCmd());
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    paramString = localTroopManager.c(paramString);
    TroopInfo localTroopInfo = localTroopManager.b(paramString);
    if (localTroopInfo != null)
    {
      localTroopInfo.dwGagTimeStamp = 0L;
      localTroopInfo.dwGagTimeStamp_me = 0L;
      localTroopManager.b(localTroopInfo);
      if (localTroopManager.b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) != null) {
        localTroopManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, -100, null, null, -100, -100, -100, -100L, 0L);
      }
    }
    ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).h(paramString);
  }
  
  public final void a(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("doGagTroop : sUin = %s", new Object[] { paramString }));
    }
    Object localObject1 = new oidb_0x89a.ReqBody();
    ((oidb_0x89a.ReqBody)localObject1).uint64_group_code.set(Long.valueOf(paramString).longValue());
    Object localObject2 = new oidb_0x89a.groupinfo();
    ((oidb_0x89a.groupinfo)localObject2).uint32_shutup_time.set((int)paramLong);
    ((oidb_0x89a.ReqBody)localObject1).st_group_info.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2202);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89a.ReqBody)localObject1).toByteArray()));
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("troopUin", paramString);
    ((Bundle)localObject1).putLong("timpStamp", paramLong);
    ((Bundle)localObject1).putInt("key_subcmd", 2);
    ((anrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).a("OidbSvc.0x89a_0", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray(), (Bundle)localObject1);
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagMgr", 2, "----------addTroopGagTipsMr friendUin: " + paramString1);
    }
    boolean bool = a(paramString1);
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    int i;
    Object localObject1;
    label87:
    Object localObject3;
    String str1;
    String str2;
    int j;
    Object localObject2;
    if ((paramBoolean) && (bool))
    {
      i = 2131697504;
      localObject1 = localContext.getString(i);
      if (paramLong2 == 0L) {
        break label545;
      }
      i = 2131697132;
      localObject3 = localContext.getString(i);
      str1 = ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      str2 = ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString3);
      j = 0;
      i = 0;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (((String)localObject2).equalsIgnoreCase(paramString2))
      {
        localObject1 = anvx.a(2131714747);
        str1 = "";
        i = 1;
      }
      if (!((String)localObject2).equalsIgnoreCase(paramString3)) {
        break label622;
      }
      localObject1 = anvx.a(2131714748) + (String)localObject1;
      str2 = "";
      j = 1;
    }
    label545:
    label602:
    label622:
    for (;;)
    {
      localObject2 = localObject1;
      if (j == 0) {
        localObject2 = " " + (String)localObject1;
      }
      if ((!bool) || (i != 0))
      {
        str1 = "";
        localObject1 = localObject2;
      }
      for (localObject2 = localObject3;; localObject2 = " " + (String)localObject3)
      {
        localObject3 = str2 + (String)localObject1 + str1 + (String)localObject2;
        localObject2 = localObject3;
        if (paramLong2 != 0L) {
          localObject2 = (String)localObject3 + c(localContext, paramLong2);
        }
        localObject3 = (MessageForGrayTips)bcsa.a(-2030);
        ((MessageForGrayTips)localObject3).frienduin = paramString1;
        ((MessageForGrayTips)localObject3).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, (String)localObject2, paramLong1, -2030, 1, paramInt);
        if (!StringUtil.isEmpty(str2))
        {
          paramString1 = new Bundle();
          paramString1.putInt("key_action", 5);
          paramString1.putString("troop_mem_uin", paramString3);
          paramString1.putBoolean("need_update_nick", true);
          ((MessageForGrayTips)localObject3).addHightlightItem(0, str2.length(), paramString1);
        }
        paramString1 = str2 + (String)localObject1;
        if (!StringUtil.isEmpty(str1))
        {
          paramString3 = new Bundle();
          paramString3.putInt("key_action", 5);
          paramString3.putString("troop_mem_uin", paramString2);
          paramString3.putBoolean("need_update_nick", true);
          paramInt = paramString1.length();
          i = paramString1.length();
          ((MessageForGrayTips)localObject3).addHightlightItem(paramInt, str1.length() + i, paramString3);
        }
        ((MessageForGrayTips)localObject3).isread = true;
        if (!anyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3, false)) {
          break label602;
        }
        return;
        i = 2131697503;
        break;
        i = 2131697047;
        break label87;
        localObject1 = (String)localObject2 + " ";
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagMgr", 2, "----------addTroopGagTipsMr friendUin: " + paramString1);
    }
    boolean bool = a(paramString1);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    Object localObject1;
    String str;
    label126:
    Object localObject2;
    if (!paramBoolean1)
    {
      localObject1 = ((Context)localObject3).getString(2131697141);
      if ((paramBoolean2) && (bool))
      {
        str = (String)localObject1 + ((Context)localObject3).getString(2131697504);
        if (!paramBoolean1) {
          break label422;
        }
        if (paramLong2 == 0L) {
          break label409;
        }
        localObject1 = ((Context)localObject3).getString(2131697135);
        localObject2 = ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equalsIgnoreCase(paramString2)) {
          break label570;
        }
        str = anvx.a(2131714750);
      }
    }
    label409:
    label422:
    label550:
    label570:
    for (int i = 1;; i = 0)
    {
      if ((!bool) || (i != 0))
      {
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = str + (String)localObject1 + (String)localObject2;
        localObject2 = (MessageForGrayTips)bcsa.a(-2030);
        ((MessageForGrayTips)localObject2).frienduin = paramString1;
        ((MessageForGrayTips)localObject2).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, (String)localObject3, paramLong1, -2030, 1, paramInt);
        if (!StringUtil.isEmpty((String)localObject1))
        {
          paramString1 = new Bundle();
          paramString1.putInt("key_action", 5);
          paramString1.putString("troop_mem_uin", paramString2);
          paramString1.putBoolean("need_update_nick", true);
          paramInt = str.length();
          i = str.length();
          ((MessageForGrayTips)localObject2).addHightlightItem(paramInt, ((String)localObject1).length() + i, paramString1);
        }
        ((MessageForGrayTips)localObject2).isread = true;
        if (!anyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2, false)) {
          break label550;
        }
        return;
        str = (String)localObject1 + ((Context)localObject3).getString(2131697503);
        break;
        if ((paramBoolean2) && (bool))
        {
          str = ((Context)localObject3).getString(2131697140);
          break;
        }
        str = ((Context)localObject3).getString(2131697133);
        break;
        localObject1 = ((Context)localObject3).getString(2131697048);
        break label126;
        if (paramLong2 != 0L) {}
        for (i = 2131697132;; i = 2131697047)
        {
          localObject2 = ((Context)localObject3).getString(i);
          localObject1 = localObject2;
          if (paramLong2 == 0L) {
            break;
          }
          localObject1 = (String)localObject2 + c((Context)localObject3, paramLong2);
          break;
        }
        str = str + " ";
        localObject3 = " " + (String)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage((MessageRecord)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    }
  }
  
  public final void a(String paramString, ArrayList<bgkh> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopGagMgr", 4, String.format("doGagTroopMember:sUin=%s, empty arList error", new Object[] { paramString }));
      }
      return;
    }
    int i = 0;
    String str = "";
    while (i < paramArrayList.size())
    {
      localObject = (bgkh)paramArrayList.get(i);
      str = str + ((bgkh)localObject).jdField_a_of_type_JavaLangString + ((bgkh)localObject).jdField_a_of_type_Long + "|";
      i += 1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("doGagTroopMember:sUin=%s sMemberUins=%s", new Object[] { paramString, str }));
    }
    Object localObject = ByteBuffer.allocate(paramArrayList.size() * 8 + 7);
    ((ByteBuffer)localObject).putInt((int)Long.valueOf(paramString).longValue());
    ((ByteBuffer)localObject).put((byte)32);
    ((ByteBuffer)localObject).putShort((short)paramArrayList.size());
    long l = 0L;
    i = 0;
    str = null;
    while (i < paramArrayList.size())
    {
      bgkh localbgkh = (bgkh)paramArrayList.get(i);
      ((ByteBuffer)localObject).putInt((int)Long.valueOf(localbgkh.jdField_a_of_type_JavaLangString).longValue());
      ((ByteBuffer)localObject).putInt((int)localbgkh.jdField_a_of_type_Long);
      str = localbgkh.jdField_a_of_type_JavaLangString;
      l = localbgkh.jdField_a_of_type_Long;
      i += 1;
    }
    localObject = ((ByteBuffer)localObject).array();
    paramArrayList = new oidb_sso.OIDBSSOPkg();
    paramArrayList.uint32_command.set(1392);
    paramArrayList.uint32_result.set(0);
    paramArrayList.uint32_service_type.set(8);
    paramArrayList.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
    localObject = new Bundle();
    ((Bundle)localObject).putString("troopUin", paramString);
    ((Bundle)localObject).putString("memberUin", str);
    ((Bundle)localObject).putLong("timpStamp", l);
    ((Bundle)localObject).putInt("key_subcmd", 2);
    ((anrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).a("OidbSvc.0x570_8", paramArrayList.toByteArray(), (Bundle)localObject);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ((anrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).d(new bgki(paramString, a(paramString, paramBoolean)));
  }
  
  public final boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 2131697049;
    if (!"OidbSvc.0x89a_0".equals(paramFromServiceMsg.getServiceCmd())) {
      return false;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    long l = paramToServiceMsg.extraData.getLong("timpStamp");
    paramToServiceMsg = (anrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(str, false, l);
      if (l == 0L) {}
      for (i = 2131697049;; i = 2131697136)
      {
        a(i, false);
        if (QLog.isDevelopLevel()) {
          QLog.e("TroopGagMgr", 4, String.format("onRspGagTroop : sUin = %s, failed", new Object[] { str }));
        }
        return true;
      }
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(str, false, l);
        return true;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(str, false, l);
      if (l == 0L) {}
      for (;;)
      {
        a(i, false);
        return true;
        i = 2131697136;
      }
      if (paramToServiceMsg.uint32_result.get() != 0)
      {
        if (l == 0L) {}
        for (;;)
        {
          a(i, false);
          a(str, false, l);
          return true;
          i = 2131697136;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("onRspGagTroop : sUin = %s, succeeded", new Object[] { str }));
      }
      a(str, true, l);
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null) {}
    do
    {
      return false;
      localObject = ((TroopManager)localObject).b(paramString);
    } while (localObject == null);
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    boolean bool;
    if ((!TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)) && (paramString.equals(((TroopInfo)localObject).troopowneruin))) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (!TextUtils.isEmpty(((TroopInfo)localObject).Administrator))
      {
        localObject = ((TroopInfo)localObject).Administrator.split("\\|");
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label136;
            }
            if (localObject[i].equalsIgnoreCase(paramString))
            {
              bool = true;
              break;
            }
            i += 1;
          }
        }
      }
      label136:
      bool = false;
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("gagTroop: sUin=%s", new Object[] { paramString }));
    }
    a(paramString, paramLong);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager == null) {
      return false;
    }
    paramString1 = localTroopManager.a(paramString1, paramString2);
    NetConnInfoCenter.getServerTime();
    if ((paramString1.jdField_a_of_type_Long != 0L) && (paramString1.jdField_a_of_type_Long > NetConnInfoCenter.getServerTime())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong)
  {
    int i = 2131697050;
    if ((TextUtils.isEmpty(paramString1)) || (paramString1.equals("0")))
    {
      if (paramLong == 0L) {}
      for (;;)
      {
        a(i, false);
        return false;
        i = 2131697138;
      }
    }
    if ((TextUtils.isEmpty(paramString2)) || (paramString2.equals("0")))
    {
      if (paramLong == 0L) {}
      for (;;)
      {
        a(i, false);
        return false;
        i = 2131697138;
      }
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bgkh(paramString2, paramLong));
    a(paramString1, localArrayList);
    return true;
  }
  
  public boolean a(String paramString, ArrayList<bgkh> paramArrayList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("gagTroopMember:sUin=%s ", new Object[] { paramString }));
    }
    a(paramString, paramArrayList);
    return true;
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = PkgTools.getLongData(paramArrayOfByte, 0);
    int i = paramArrayOfByte[4];
    long l2;
    long l3;
    if (i == 12)
    {
      i = paramArrayOfByte[5];
      l2 = PkgTools.getLongData(paramArrayOfByte, 6);
      PkgTools.getLongData(paramArrayOfByte, 10);
      l3 = NetConnInfoCenter.getServerTime();
      int k = PkgTools.getShortData(paramArrayOfByte, 14);
      int j = 16;
      ArrayList localArrayList = new ArrayList();
      i = 0;
      while (i < k)
      {
        long l4 = PkgTools.getLongData(paramArrayOfByte, j);
        j += 4;
        long l5 = PkgTools.getLongData(paramArrayOfByte, j);
        j += 4;
        localArrayList.add(new aoor(String.valueOf(l4), l5));
        i += 1;
      }
      a(paramInt, l1, l2, l3, localArrayList);
      return true;
    }
    if (i == 14)
    {
      i = paramArrayOfByte[5];
      PkgTools.getLongData(paramArrayOfByte, 6);
      l2 = NetConnInfoCenter.getServerTime();
      l3 = PkgTools.getLongData(paramArrayOfByte, 10);
      i = paramArrayOfByte[14];
      a(paramInt, l1, l2, l3, PkgTools.getUTFString(paramArrayOfByte, 15, i), paramArrayOfByte[(i + 15)]);
    }
    return false;
  }
  
  public String b(Context paramContext, long paramLong)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (paramLong <= l)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("error: gagTimeToStringCountDown gagTime <= currentTimeMs", new Object[0]));
      }
      return "";
    }
    return a(paramContext, paramLong - l, paramLong);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    int i = localContext.getResources().getDimensionPixelSize(2131299080);
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopGagMgr.2(this, paramBoolean, localContext, paramString, i));
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(localContext, 2, paramString, 0).b(i);
      return;
    }
    QQToast.a(localContext, 2130839653, paramString, 0).b(i);
  }
  
  public final boolean b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OidbSvc.0x570_8".equals(paramFromServiceMsg.getServiceCmd())) {
      return false;
    }
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    String str2 = paramToServiceMsg.extraData.getString("memberUin");
    long l = paramToServiceMsg.extraData.getLong("timpStamp");
    paramToServiceMsg = (anrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopGagMgr", 4, String.format("onRspTroopMember:sUin %s sMemberUin=%s, failed", new Object[] { str1, str2 }));
      }
      if (paramFromServiceMsg.getResultCode() == 10)
      {
        if (l == 0L) {}
        for (i = 2131697050;; i = 2131697137)
        {
          a(i, false);
          b(str1, false, l);
          return true;
        }
      }
      if (l == 0L) {}
      for (i = 2131697050;; i = 2131697138)
      {
        a(i, false);
        break;
      }
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        b(str1, false, l);
        return true;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      b(str1, false, l);
      if (l == 0L) {}
      for (i = 2131697050;; i = 2131697138)
      {
        a(i, false);
        return true;
      }
      if (paramToServiceMsg.uint32_result.get() != 0)
      {
        if (paramToServiceMsg.uint32_result.get() == 10)
        {
          if (l == 0L) {}
          for (i = 2131697050;; i = 2131697137)
          {
            a(i, false);
            b(str1, false, l);
            return true;
          }
        }
        if (l == 0L) {}
        for (i = 2131697050;; i = 2131697138)
        {
          a(i, false);
          break;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("onRspTroopMember:sUin=%s sMemberUin=%s, succeeded", new Object[] { str1, str2 }));
      }
      b(str1, true, l);
      if (l != 0L) {}
    }
    for (int i = 2131697051;; i = 2131697139)
    {
      a(i, true);
      return true;
    }
  }
  
  public boolean b(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager == null) {
      return false;
    }
    paramString = localTroopManager.b(paramString);
    if (paramString == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString.troopowneruin);
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("fetchGagTroopList:sUin=%s", new Object[] { paramString1 }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
    }
    aoep localaoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localaoep != null)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          localaoep.a(Long.parseLong(paramString1), 0L, 6, null, 0, 0);
        }
        else
        {
          long l1 = Long.parseLong(paramString1);
          long l2 = Long.parseLong(paramString2);
          paramString1 = new ArrayList();
          paramString1.add(Long.valueOf(l2));
          localaoep.a(l1, 0L, 3, paramString1, 0, 0);
        }
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopGagMgr", 2, paramString1.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label199;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    }
    label199:
    return true;
  }
  
  public String c(Context paramContext, long paramLong)
  {
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    String str1 = paramContext.getString(2131697145);
    String str2 = paramContext.getString(2131697144);
    Object localObject = paramContext.getString(2131697143);
    if (paramLong < 60L) {
      paramContext = 1 + str1;
    }
    long l2;
    do
    {
      return paramContext;
      l2 = 59L + paramLong;
      paramLong = l2 / 86400L;
      long l1 = (l2 - 86400L * paramLong) / 3600L;
      l2 = (l2 - 86400L * paramLong - 3600L * l1) / 60L;
      paramContext = "";
      if (paramLong > 0L) {
        paramContext = "" + paramLong + (String)localObject;
      }
      localObject = paramContext;
      if (l1 > 0L) {
        localObject = paramContext + l1 + str2;
      }
      paramContext = (Context)localObject;
    } while (l2 <= 0L);
    return (String)localObject + l2 + str1;
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilQueue.size() != 0)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        while (this.jdField_a_of_type_JavaUtilQueue.size() != 0)
        {
          localStringBuffer.append(((Integer)this.jdField_a_of_type_JavaUtilQueue.poll()).intValue());
          if (this.jdField_a_of_type_JavaUtilQueue.size() != 0) {
            localStringBuffer.append(";");
          }
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("seqs", localObject.toString()).commit();
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkf
 * JD-Core Version:    0.7.0.1
 */