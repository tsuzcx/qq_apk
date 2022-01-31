import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qqreader.js.JsCallParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bguk
{
  private static long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new bgum(this, Looper.getMainLooper());
  private bgtg jdField_a_of_type_Bgtg = new bgul(this);
  private bguh jdField_a_of_type_Bguh;
  private List<bgun> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  bguk(bguh parambguh)
  {
    this.jdField_a_of_type_Bguh = parambguh;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return (("JSbookshelf".equals(paramString1)) && ("kvStorageGet".equals(paramString2)) && (!this.jdField_a_of_type_Bguh.a())) || (("JSbookshelf".equals(paramString1)) && ("reportParams".equals(paramString2)));
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100001);
    d();
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bgun localbgun = (bgun)localIterator.next();
      if (!localbgun.a()) {
        this.jdField_a_of_type_Bguh.a(localbgun.a.a(), localbgun.a.b(), localbgun.a.c(), localbgun.a.a());
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bgun localbgun = (bgun)localIterator.next();
      if (localbgun.a())
      {
        if (!a(localbgun.a.b(), localbgun.a.c())) {
          f();
        }
        localIterator.remove();
      }
    }
  }
  
  private void f()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long > 5000L)
    {
      jdField_a_of_type_Long = l;
      bcpw.a(BaseApplicationImpl.getApplication(), "插件正在加载中，请稍候...", 0).a();
    }
  }
  
  private void g()
  {
    if (!bgtf.a().a()) {
      bgtf.a().a(this.jdField_a_of_type_Bgtg);
    }
  }
  
  void a() {}
  
  void a(String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramString1 = new bgun(paramString1, paramString2, paramString3, 3000L, paramVarArgs);
    paramString2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (bgun)paramString2.next();
      if (paramString3.a(paramString1)) {
        paramString3.a();
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilList.add(paramString1);
      }
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(100001)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100001, 3000L);
      }
      g();
      return;
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguk
 * JD-Core Version:    0.7.0.1
 */