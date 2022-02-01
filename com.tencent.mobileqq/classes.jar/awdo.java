import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;

public abstract class awdo
{
  private awdp jdField_a_of_type_Awdp = new awdp();
  private final HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private final Map<Long, awdr> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  
  public awdo()
  {
    arbj localarbj = (arbj)aqxe.a().a(598);
    if (localarbj != null) {
      if (localarbj.jdField_a_of_type_Boolean) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(long paramLong, RedTouch paramRedTouch)
  {
    int i = awds.a(paramRedTouch);
    if (i != 0) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), new awdr(i, awds.b(paramRedTouch)));
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramLong))) && (paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramLong));
      ((bbbq)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a((int)paramLong, 30);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Awdp != null) {
      return this.jdField_a_of_type_Awdp.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public abstract BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString);
  
  public Map<Long, awdr> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.isEmpty()) {}
    try
    {
      ajzy.jdField_a_of_type_Int |= 0x2;
      QLog.i("Q.lebatab.LebaRedTouchBase", 1, "onPause update" + ajzy.jdField_a_of_type_Int);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((aocj)((QQAppInterface)localAppRuntime).getBusinessHandler(BusinessHandlerFactory.REDPOINT_HANDER)).notifyUI(4, true, null);
      }
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaRedTouchBase", 1, "onPause", localException);
      }
    }
  }
  
  public void a(ajzv paramajzv)
  {
    QQAppInterface localQQAppInterface = paramajzv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = paramajzv.jdField_a_of_type_AndroidContentContext;
    RedTouch localRedTouch = paramajzv.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
    long l = paramajzv.jdField_a_of_type_Long;
    String str = paramajzv.jdField_a_of_type_JavaLangString;
    int i = paramajzv.jdField_a_of_type_Int;
    paramajzv = a(localQQAppInterface, String.valueOf(l));
    a(localQQAppInterface, l, paramajzv);
    if (this.jdField_a_of_type_Boolean) {}
    for (boolean bool = this.jdField_a_of_type_Awdp.a(localQQAppInterface, localContext, l, localRedTouch, str, this.jdField_a_of_type_JavaUtilMap, i);; bool = false)
    {
      QLog.d("Q.lebatab.LebaRedTouchBase", 1, new Object[] { "updateRedTouch,resID=", Long.valueOf(l), ",resPkgName=", str, ",isHandledRedTouch=", Boolean.valueOf(bool), ",leba_red_touch_spcific_enable->mSpecificEnable=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      if (!bool)
      {
        a(localRedTouch, paramajzv);
        a(l, localRedTouch);
        this.jdField_a_of_type_Awdp.a(localQQAppInterface, str, paramajzv);
      }
      return;
    }
  }
  
  public abstract void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdo
 * JD-Core Version:    0.7.0.1
 */