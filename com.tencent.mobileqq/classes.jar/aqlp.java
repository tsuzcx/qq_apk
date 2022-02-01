import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class aqlp
  implements Manager
{
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<Long, List<aqla>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap<Long, Long> b;
  private ConcurrentHashMap<String, List<aqla>> c;
  private ConcurrentHashMap<String, Integer> d;
  
  public aqlp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  public static aqlp a(QQAppInterface paramQQAppInterface)
  {
    return (aqlp)paramQQAppInterface.getManager(QQManagerFactory.C2C_SHORTCUT_BAR_MANAGER);
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
    this.c = new ConcurrentHashMap(16);
    this.d = new ConcurrentHashMap(16);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(String paramString)
  {
    if (this.d.containsKey(paramString)) {
      return ((Integer)this.d.get(paramString)).intValue();
    }
    return 0;
  }
  
  public aqll a()
  {
    return (aqll)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.C2C_SHORTCUT_BAR_HANDLER);
  }
  
  public Long a(Long paramLong)
  {
    paramLong = (Long)this.b.get(paramLong);
    if (paramLong != null) {}
    for (long l = paramLong.longValue();; l = 0L) {
      return Long.valueOf(l);
    }
  }
  
  public List<aqla> a(Long paramLong)
  {
    Object localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
    int i = a();
    paramLong = new ArrayList();
    if (localObject == null) {
      return paramLong;
    }
    if (((List)localObject).size() > i)
    {
      paramLong.addAll(((List)localObject).subList(0, i));
      localObject = new aqla();
      ((aqla)localObject).b = BaseApplicationImpl.getContext().getResources().getString(2131690683);
      ((aqla)localObject).c = "https://qzonestyle.gtimg.cn/aoi/sola/20191009150544_g1DgkNhLui.png";
      paramLong.add(localObject);
    }
    for (;;)
    {
      return paramLong;
      paramLong.addAll((Collection)localObject);
    }
  }
  
  public List<aqla> a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarSwitcher", 2, "getC2CShortcutBarStoreInfo() data = " + this.c.get(paramString));
    }
    return (List)this.c.get(paramString);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarSwitcher", 2, "setShortcutBarMaxAppNum " + paramInt);
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(Long paramLong1, Long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarSwitcher", 2, "updateShortcutAppInfoReqTimeStamp friendUin = " + paramLong1 + ",nextReqTimeStamp = " + paramLong2);
    }
    this.b.put(paramLong1, paramLong2);
  }
  
  public void a(Long paramLong, List<aqla> paramList)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, paramList);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.d.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString, List<aqla> paramList)
  {
    this.c.put(paramString, paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    a().a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    a().a(paramString, paramBoolean);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarSwitcher", 2, new Object[] { "isClickManager() position =", Integer.valueOf(paramInt1), " appListSize = ", Integer.valueOf(paramInt2), " shortcutBarMaxAppNum =", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    return (paramInt1 == paramInt2 - 1) && (paramInt2 > this.jdField_a_of_type_Int);
  }
  
  public boolean a(Long paramLong)
  {
    paramLong = a(paramLong);
    return System.currentTimeMillis() / 1000L > paramLong.longValue();
  }
  
  public void onDestroy()
  {
    this.c.clear();
    this.c = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.d.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlp
 * JD-Core Version:    0.7.0.1
 */