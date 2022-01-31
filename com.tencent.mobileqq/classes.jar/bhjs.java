import android.os.Binder;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;
import java.lang.ref.WeakReference;

public class bhjs
  extends bhju
{
  private static bhjs jdField_a_of_type_Bhjs;
  private static String jdField_a_of_type_JavaLangString = "QZoneRemotePluginHandler";
  private bhhr jdField_a_of_type_Bhhr;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static bhjs a()
  {
    if (jdField_a_of_type_Bhjs == null) {}
    try
    {
      if (jdField_a_of_type_Bhjs == null) {
        jdField_a_of_type_Bhjs = new bhjs();
      }
      return jdField_a_of_type_Bhjs;
    }
    finally {}
  }
  
  private void b()
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      localObject = localQQAppInterface;
      if (localQQAppInterface != null)
      {
        this.jdField_a_of_type_Bhhr = ((bhhr)localQQAppInterface.getManager(175));
        localObject = localQQAppInterface;
      }
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "appInterface:" + localObject + ",pluginManger=" + this.jdField_a_of_type_Bhhr);
  }
  
  public Binder a()
  {
    return this;
  }
  
  @Nullable
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public PluginRecord a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "queryPlugin:" + paramString);
    }
    b();
    if (this.jdField_a_of_type_Bhhr == null) {
      return null;
    }
    return this.jdField_a_of_type_Bhhr.a(paramString);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "triggerQQDownloadPtuFilter");
    }
    b();
    if (this.jdField_a_of_type_Bhhr == null) {
      return;
    }
    this.jdField_a_of_type_Bhhr.a();
  }
  
  public void a(bhhy parambhhy, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "installPituSo");
    }
    b();
    if (this.jdField_a_of_type_Bhhr == null) {
      return;
    }
    this.jdField_a_of_type_Bhhr.a(parambhhy, paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isReady");
    }
    b();
    if (this.jdField_a_of_type_Bhhr == null) {
      return false;
    }
    return this.jdField_a_of_type_Bhhr.a();
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isPluginInstalled:" + paramString);
    }
    b();
    if (this.jdField_a_of_type_Bhhr != null) {
      return this.jdField_a_of_type_Bhhr.a(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, bhib parambhib, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "installPlugin:" + paramString);
    }
    b();
    if (this.jdField_a_of_type_Bhhr == null) {
      return false;
    }
    return this.jdField_a_of_type_Bhhr.a(paramString, parambhib, paramInt);
  }
  
  public boolean b(String paramString)
  {
    b();
    if (this.jdField_a_of_type_Bhhr == null) {
      return false;
    }
    return this.jdField_a_of_type_Bhhr.b(paramString);
  }
  
  public boolean c(String paramString)
  {
    b();
    if (this.jdField_a_of_type_Bhhr == null) {
      return false;
    }
    return this.jdField_a_of_type_Bhhr.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhjs
 * JD-Core Version:    0.7.0.1
 */