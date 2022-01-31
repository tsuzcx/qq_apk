import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class arqb
{
  private arqc jdField_a_of_type_Arqc = new arqc();
  private final HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private final Map<Long, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  
  public arqb()
  {
    amsr localamsr = (amsr)ampm.a().a(598);
    if (localamsr != null) {
      if (localamsr.jdField_a_of_type_Boolean) {
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
    int i = arqe.a(paramRedTouch);
    if (i != 0) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), Integer.valueOf(i));
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramLong))) && (paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramLong));
      ((avpq)paramQQAppInterface.getManager(36)).a((int)paramLong, 30);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Arqc != null) {
      return this.jdField_a_of_type_Arqc.a;
    }
    return -1;
  }
  
  public abstract BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString);
  
  public Map<Long, Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(arps paramarps)
  {
    QQAppInterface localQQAppInterface = paramarps.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = paramarps.jdField_a_of_type_AndroidContentContext;
    RedTouch localRedTouch = paramarps.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
    long l = paramarps.jdField_a_of_type_Long;
    paramarps = paramarps.jdField_a_of_type_JavaLangString;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(localQQAppInterface, String.valueOf(l));
    a(localQQAppInterface, l, localAppInfo);
    if (this.jdField_a_of_type_Boolean) {}
    for (boolean bool = this.jdField_a_of_type_Arqc.a(localQQAppInterface, localContext, l, localRedTouch, paramarps, this.jdField_a_of_type_JavaUtilMap);; bool = false)
    {
      QLog.d("Q.lebatab.LebaRedTouchBase", 1, new Object[] { "updateRedTouch,resID=", Long.valueOf(l), ",resPkgName=", paramarps, ",isHandledRedTouch=", Boolean.valueOf(bool), ",leba_red_touch_spcific_enable->mSpecificEnable=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      if (!bool)
      {
        a(localRedTouch, localAppInfo);
        a(l, localRedTouch);
        this.jdField_a_of_type_Arqc.a(localQQAppInterface, paramarps, localAppInfo);
      }
      return;
    }
  }
  
  public abstract void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arqb
 * JD-Core Version:    0.7.0.1
 */