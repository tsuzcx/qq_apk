import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;

public abstract class auxp
{
  private auxq jdField_a_of_type_Auxq = new auxq();
  private final HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private final Map<Long, auxs> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  
  public auxp()
  {
    apyg localapyg = (apyg)apub.a().a(598);
    if (localapyg != null) {
      if (localapyg.jdField_a_of_type_Boolean) {
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
    int i = auxt.a(paramRedTouch);
    if (i != 0) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), new auxs(i, auxt.b(paramRedTouch)));
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramLong))) && (paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramLong));
      ((azvi)paramQQAppInterface.getManager(36)).a((int)paramLong, 30);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Auxq != null) {
      return this.jdField_a_of_type_Auxq.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public abstract BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString);
  
  public Map<Long, auxs> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.isEmpty()) {}
    try
    {
      ajek.jdField_a_of_type_Int |= 0x2;
      QLog.i("Q.lebatab.LebaRedTouchBase", 1, "onPause update" + ajek.jdField_a_of_type_Int);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((amzu)((QQAppInterface)localAppRuntime).getBusinessHandler(87)).notifyUI(4, true, null);
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
  
  public void a(ajeh paramajeh)
  {
    QQAppInterface localQQAppInterface = paramajeh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = paramajeh.jdField_a_of_type_AndroidContentContext;
    RedTouch localRedTouch = paramajeh.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
    long l = paramajeh.jdField_a_of_type_Long;
    String str = paramajeh.jdField_a_of_type_JavaLangString;
    int i = paramajeh.jdField_a_of_type_Int;
    paramajeh = a(localQQAppInterface, String.valueOf(l));
    a(localQQAppInterface, l, paramajeh);
    if (this.jdField_a_of_type_Boolean) {}
    for (boolean bool = this.jdField_a_of_type_Auxq.a(localQQAppInterface, localContext, l, localRedTouch, str, this.jdField_a_of_type_JavaUtilMap, i);; bool = false)
    {
      QLog.d("Q.lebatab.LebaRedTouchBase", 1, new Object[] { "updateRedTouch,resID=", Long.valueOf(l), ",resPkgName=", str, ",isHandledRedTouch=", Boolean.valueOf(bool), ",leba_red_touch_spcific_enable->mSpecificEnable=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      if (!bool)
      {
        a(localRedTouch, paramajeh);
        a(l, localRedTouch);
        this.jdField_a_of_type_Auxq.a(localQQAppInterface, str, paramajeh);
      }
      return;
    }
  }
  
  public abstract void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxp
 * JD-Core Version:    0.7.0.1
 */