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

public abstract class atgx
{
  private atgy jdField_a_of_type_Atgy = new atgy();
  private final HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private final Map<Long, atha> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  
  public atgx()
  {
    aojs localaojs = (aojs)aogj.a().a(598);
    if (localaojs != null) {
      if (localaojs.jdField_a_of_type_Boolean) {
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
    int i = athb.a(paramRedTouch);
    if (i != 0) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), new atha(i, athb.b(paramRedTouch)));
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramLong))) && (paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramLong));
      ((axho)paramQQAppInterface.getManager(36)).a((int)paramLong, 30);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Atgy != null) {
      return this.jdField_a_of_type_Atgy.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public abstract BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString);
  
  public Map<Long, atha> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.isEmpty()) {}
    try
    {
      aiab.jdField_a_of_type_Int |= 0x2;
      QLog.i("Q.lebatab.LebaRedTouchBase", 1, "onPause update" + aiab.jdField_a_of_type_Int);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((alwx)((QQAppInterface)localAppRuntime).a(87)).notifyUI(4, true, null);
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
  
  public void a(atgo paramatgo)
  {
    QQAppInterface localQQAppInterface = paramatgo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = paramatgo.jdField_a_of_type_AndroidContentContext;
    RedTouch localRedTouch = paramatgo.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
    long l = paramatgo.jdField_a_of_type_Long;
    String str = paramatgo.jdField_a_of_type_JavaLangString;
    int i = paramatgo.jdField_a_of_type_Int;
    paramatgo = a(localQQAppInterface, String.valueOf(l));
    a(localQQAppInterface, l, paramatgo);
    if (this.jdField_a_of_type_Boolean) {}
    for (boolean bool = this.jdField_a_of_type_Atgy.a(localQQAppInterface, localContext, l, localRedTouch, str, this.jdField_a_of_type_JavaUtilMap, i);; bool = false)
    {
      QLog.d("Q.lebatab.LebaRedTouchBase", 1, new Object[] { "updateRedTouch,resID=", Long.valueOf(l), ",resPkgName=", str, ",isHandledRedTouch=", Boolean.valueOf(bool), ",leba_red_touch_spcific_enable->mSpecificEnable=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      if (!bool)
      {
        a(localRedTouch, paramatgo);
        a(l, localRedTouch);
        this.jdField_a_of_type_Atgy.a(localQQAppInterface, str, paramatgo);
      }
      return;
    }
  }
  
  public abstract void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgx
 * JD-Core Version:    0.7.0.1
 */