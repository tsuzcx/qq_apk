import android.os.Binder;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;
import java.lang.ref.WeakReference;

public class bjqb
  extends bjqd
{
  private static bjqb jdField_a_of_type_Bjqb;
  private static String jdField_a_of_type_JavaLangString = "QZoneRemotePluginHandler";
  private bjoa jdField_a_of_type_Bjoa;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static bjqb a()
  {
    if (jdField_a_of_type_Bjqb == null) {}
    try
    {
      if (jdField_a_of_type_Bjqb == null) {
        jdField_a_of_type_Bjqb = new bjqb();
      }
      return jdField_a_of_type_Bjqb;
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
        this.jdField_a_of_type_Bjoa = ((bjoa)localQQAppInterface.getManager(175));
        localObject = localQQAppInterface;
      }
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "appInterface:" + localObject + ",pluginManger=" + this.jdField_a_of_type_Bjoa);
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
    if (this.jdField_a_of_type_Bjoa == null) {
      return null;
    }
    return this.jdField_a_of_type_Bjoa.a(paramString);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "triggerQQDownloadPtuFilter");
    }
    b();
    if (this.jdField_a_of_type_Bjoa == null) {
      return;
    }
    this.jdField_a_of_type_Bjoa.a();
  }
  
  public void a(bjoh parambjoh, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "installPituSo");
    }
    b();
    if (this.jdField_a_of_type_Bjoa == null) {
      return;
    }
    this.jdField_a_of_type_Bjoa.a(parambjoh, paramInt);
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
    if (this.jdField_a_of_type_Bjoa == null) {
      return false;
    }
    return this.jdField_a_of_type_Bjoa.a();
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isPluginInstalled:" + paramString);
    }
    b();
    if (this.jdField_a_of_type_Bjoa != null) {
      return this.jdField_a_of_type_Bjoa.a(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, bjok parambjok, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "installPlugin:" + paramString);
    }
    b();
    if (this.jdField_a_of_type_Bjoa == null) {
      return false;
    }
    return this.jdField_a_of_type_Bjoa.a(paramString, parambjok, paramInt);
  }
  
  public boolean b(String paramString)
  {
    b();
    if (this.jdField_a_of_type_Bjoa == null) {
      return false;
    }
    return this.jdField_a_of_type_Bjoa.b(paramString);
  }
  
  public boolean c(String paramString)
  {
    b();
    if (this.jdField_a_of_type_Bjoa == null) {
      return false;
    }
    return this.jdField_a_of_type_Bjoa.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjqb
 * JD-Core Version:    0.7.0.1
 */