import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class bjrf
  implements BusinessObserver
{
  private static bjrf jdField_a_of_type_Bjrf;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private long b;
  
  public bjrf()
  {
    azax localazax = new azax();
    localazax.a();
    this.b = (localazax.d * 1000);
    this.jdField_a_of_type_Int = localazax.c;
    this.jdField_a_of_type_JavaLangString = localazax.jdField_a_of_type_JavaLangString;
  }
  
  public static bjrf a()
  {
    if (jdField_a_of_type_Bjrf == null) {}
    try
    {
      if (jdField_a_of_type_Bjrf == null) {
        jdField_a_of_type_Bjrf = new bjrf();
      }
      return jdField_a_of_type_Bjrf;
    }
    finally {}
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Int)) {}
    while (System.currentTimeMillis() - this.jdField_a_of_type_Long > this.b) {
      return true;
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Object localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      ??? = new bjrg(this.jdField_a_of_type_JavaLangString, (ArrayList)localObject2, null);
      localObject2 = new QzoneCommonIntent(BaseApplicationImpl.getContext(), apfo.class);
      ((QzoneCommonIntent)localObject2).setRequest((bjdo)???);
      ((QzoneCommonIntent)localObject2).setObserver(this);
      BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject2);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("WMDReportManager", 1, "action is null");
    }
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        QLog.e("WMDReportManager", 1, "reportId is null");
        return;
      }
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        if (!a()) {
          continue;
        }
        a();
        return;
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("key_response_code");
      String str = paramBundle.getString("key_response_msg");
      if (QLog.isColorLevel()) {
        QLog.i("WMDReportManager", 2, String.format("type :%d, success:%b, code:%d, msg:%s, bundle:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(i), str, paramBundle.toString() }));
      }
      return;
    }
    QLog.e("WMDReportManager", 1, "onReceive bundle is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjrf
 * JD-Core Version:    0.7.0.1
 */