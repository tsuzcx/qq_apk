import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qidian.controller.QidianPubAccountBigDataHandler.1;
import com.tencent.qidian.controller.QidianPubAccountBigDataHandler.2;
import com.tencent.qidian.controller.QidianPubAccountBigDataHandler.3;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.cs.cmd0x6ff.subcmd0x519.CRMMsgHead;
import tencent.im.cs.cmd0x6ff.subcmd0x519.GetNavigationMenuReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x519.GetNavigationMenuRspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x519.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x519.RetInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x519.RspBody;

public class bkid
  extends bkhw
{
  public static final AtomicBoolean a;
  public Map<Long, PubAccountNavigationMenu> a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public bkid(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    ThreadManager.post(new QidianPubAccountBigDataHandler.1(this), 8, null, true);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianPubAccountBigDataHandler", 4, "initial ...");
    }
    localEntityManager = this.app.a().createEntityManager();
    try
    {
      a(localEntityManager);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QidianPubAccountBigDataHandler", 2, "QidianManager get data from db error: " + localException.getMessage());
        }
        localEntityManager.close();
      }
    }
    finally
    {
      localEntityManager.close();
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  private void a(long paramLong1, PubAccountNavigationMenu paramPubAccountNavigationMenu, long paramLong2)
  {
    Object localObject1 = this.app.getCurrentAccountUin();
    try
    {
      paramLong2 = Long.parseLong((String)localObject1);
      localObject1 = new subcmd0x519.GetNavigationMenuReqBody();
      ((subcmd0x519.GetNavigationMenuReqBody)localObject1).uint64_puin.set(paramLong1);
      Object localObject2 = ((subcmd0x519.GetNavigationMenuReqBody)localObject1).uint32_ver_no;
      if (paramPubAccountNavigationMenu == null) {}
      for (int i = 0;; i = paramPubAccountNavigationMenu.version)
      {
        ((PBUInt32Field)localObject2).set(i);
        ((subcmd0x519.GetNavigationMenuReqBody)localObject1).uint64_uin.set(paramLong2);
        localObject2 = new subcmd0x519.ReqBody();
        ((subcmd0x519.ReqBody)localObject2).uint32_sub_cmd.set(36);
        ((subcmd0x519.ReqBody)localObject2).msg_get_navigation_menu_req.set((MessageMicro)localObject1);
        localObject1 = new subcmd0x519.CRMMsgHead();
        ((subcmd0x519.CRMMsgHead)localObject1).uint32_ver_no.set(bkin.a("8.4.5"));
        ((subcmd0x519.CRMMsgHead)localObject1).uint32_crm_sub_cmd.set(36);
        ((subcmd0x519.CRMMsgHead)localObject1).uint32_clienttype.set(2);
        ((subcmd0x519.CRMMsgHead)localObject1).uint64_kf_uin.set(paramLong1);
        ((subcmd0x519.CRMMsgHead)localObject1).uint64_puin.set(paramLong1);
        ((subcmd0x519.ReqBody)localObject2).msg_crm_common_head.set((MessageMicro)localObject1);
        a(3001, (MessageMicro)localObject2, 1305, paramPubAccountNavigationMenu);
        return;
      }
      return;
    }
    catch (Exception paramPubAccountNavigationMenu) {}
  }
  
  private void a(EntityManager paramEntityManager)
  {
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.query(PubAccountNavigationMenu.class);
      if (paramEntityManager != null)
      {
        paramEntityManager = paramEntityManager.iterator();
        while (paramEntityManager.hasNext())
        {
          PubAccountNavigationMenu localPubAccountNavigationMenu = (PubAccountNavigationMenu)paramEntityManager.next();
          if (QLog.isColorLevel()) {
            QLog.d("QidianPubAccountBigDataHandler", 4, "loadMenus query from db: " + localPubAccountNavigationMenu);
          }
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(localPubAccountNavigationMenu.puin))) {
            this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localPubAccountNavigationMenu.puin), localPubAccountNavigationMenu);
          }
        }
      }
    }
  }
  
  private void a(PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramPubAccountNavigationMenu.puin), paramPubAccountNavigationMenu);
    ThreadManager.post(new QidianPubAccountBigDataHandler.3(this, paramPubAccountNavigationMenu), 5, null, true);
  }
  
  private void a(boolean paramBoolean, byte[] paramArrayOfByte, Object paramObject)
  {
    if ((paramBoolean) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        Object localObject = new subcmd0x519.RspBody();
        ((subcmd0x519.RspBody)localObject).mergeFrom((byte[])paramArrayOfByte);
        localObject = ((subcmd0x519.RspBody)localObject).msg_get_navigation_menu_rsp;
        paramArrayOfByte = (subcmd0x519.RetInfo)((subcmd0x519.GetNavigationMenuRspBody)localObject).msg_ret.get();
        i = paramArrayOfByte.uint32_ret_code.get();
        if (i == 0)
        {
          if ((!((subcmd0x519.GetNavigationMenuRspBody)localObject).int32_is_show.has()) || (((subcmd0x519.GetNavigationMenuRspBody)localObject).int32_is_show.get() != 1)) {
            break label397;
          }
          paramBoolean = true;
          if (!((subcmd0x519.GetNavigationMenuRspBody)localObject).str_struct_msg.has()) {
            break label402;
          }
          paramArrayOfByte = ((subcmd0x519.GetNavigationMenuRspBody)localObject).str_struct_msg.get();
          if (!((subcmd0x519.GetNavigationMenuRspBody)localObject).uint32_ver_no.has()) {
            break label409;
          }
          i = ((subcmd0x519.GetNavigationMenuRspBody)localObject).uint32_ver_no.get();
          if (paramObject == null) {
            break label391;
          }
          paramObject = (PubAccountNavigationMenu)paramObject;
          if (QLog.isColorLevel()) {
            QLog.d("QidianPubAccountBigDataHandler", 2, "handleGetNatigationMenu isShow: " + paramBoolean + " version: " + i + " | xml: " + paramArrayOfByte);
          }
          localObject = paramObject;
          if (paramObject == null) {
            localObject = new PubAccountNavigationMenu();
          }
          if (paramArrayOfByte != null)
          {
            paramObject = paramArrayOfByte;
            if (paramArrayOfByte.length() != 0) {}
          }
          else
          {
            paramObject = ((PubAccountNavigationMenu)localObject).xml;
          }
          ((PubAccountNavigationMenu)localObject).xml = paramObject;
          ((PubAccountNavigationMenu)localObject).version = i;
          a((PubAccountNavigationMenu)localObject);
          if (paramBoolean)
          {
            notifyUI(3001, true, localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            break label396;
          }
          QLog.d("QidianPubAccountBigDataHandler", 2, "handleGetNatigationMenu no need show");
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        notifyUI(3001, false, null);
        paramArrayOfByte.printStackTrace();
        return;
      }
      notifyUI(3001, false, null);
      if (paramArrayOfByte.str_error_msg.has()) {
        paramArrayOfByte = paramArrayOfByte.str_error_msg.get();
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QidianPubAccountBigDataHandler", 2, "handleGetNatigationMenu error: " + i + " msg: " + paramArrayOfByte);
          return;
          notifyUI(3001, false, null);
          if (QLog.isColorLevel())
          {
            QLog.d("QidianPubAccountBigDataHandler", 2, "handleGetNatigationMenu fail");
            return;
            paramArrayOfByte = "Unknown error";
            continue;
            label391:
            paramObject = null;
            break;
          }
        }
      }
      label396:
      return;
      label397:
      paramBoolean = false;
      continue;
      label402:
      paramArrayOfByte = "";
      continue;
      label409:
      int i = 0;
    }
  }
  
  public PubAccountNavigationMenu a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      paramString = (PubAccountNavigationMenu)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l));
      if (paramString != null) {
        return paramString;
      }
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        return null;
      }
      a(l);
      paramString = (PubAccountNavigationMenu)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  protected void a(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt2, Object paramObject)
  {
    if (paramInt2 != 1305)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QidianPubAccountBigDataHandler", 2, "recevie but not 0x519");
      }
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QidianPubAccountBigDataHandler", 2, "recevie CMD_BIG_DATA_GET_NATIGATION_MENU,begin to handle...");
    }
    a(paramBoolean, paramArrayOfByte, paramObject);
  }
  
  public void a(long paramLong)
  {
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      Object localObject = this.app.a().createEntityManager();
      if (localObject != null)
      {
        localObject = (PubAccountNavigationMenu)((EntityManager)localObject).find(PubAccountNavigationMenu.class, new String[] { String.valueOf(paramLong) });
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(((PubAccountNavigationMenu)localObject).puin), localObject);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianPubAccountBigDataHandler", 2, "getNatigationMenu: BEGIN");
    }
    for (;;)
    {
      try
      {
        l = Long.parseLong(paramString);
        paramString = (PubAccountNavigationMenu)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l));
        if (paramString == null) {
          continue;
        }
        a(l, paramString, paramLong);
      }
      catch (Exception paramString)
      {
        long l;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QidianPubAccountBigDataHandler", 2, "getNatigationMenu error: " + paramString.getMessage());
        continue;
        ThreadManager.post(new QidianPubAccountBigDataHandler.2(this, l, paramLong), 8, null, true);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QidianPubAccountBigDataHandler", 2, "getNatigationMenu: END");
      }
      return;
      if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        continue;
      }
      paramString = new PubAccountNavigationMenu();
      paramString.version = 0;
      paramString.puin = l;
      paramString.xml = "";
      a(l, paramString, paramLong);
    }
  }
  
  protected Class<? extends anui> observerClass()
  {
    return bkia.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkid
 * JD-Core Version:    0.7.0.1
 */