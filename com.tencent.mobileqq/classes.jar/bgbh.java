import android.os.Binder;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;
import java.lang.ref.WeakReference;

public class bgbh
  extends bgbj
{
  private static bgbh jdField_a_of_type_Bgbh;
  private static String jdField_a_of_type_JavaLangString = "QZoneRemotePluginHandler";
  private bfzg jdField_a_of_type_Bfzg;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static bgbh a()
  {
    if (jdField_a_of_type_Bgbh == null) {}
    try
    {
      if (jdField_a_of_type_Bgbh == null) {
        jdField_a_of_type_Bgbh = new bgbh();
      }
      return jdField_a_of_type_Bgbh;
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
        this.jdField_a_of_type_Bfzg = ((bfzg)localQQAppInterface.getManager(175));
        localObject = localQQAppInterface;
      }
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "appInterface:" + localObject + ",pluginManger=" + this.jdField_a_of_type_Bfzg);
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
    if (this.jdField_a_of_type_Bfzg == null) {
      return null;
    }
    return this.jdField_a_of_type_Bfzg.a(paramString);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "triggerQQDownloadPtuFilter");
    }
    b();
    if (this.jdField_a_of_type_Bfzg == null) {
      return;
    }
    this.jdField_a_of_type_Bfzg.a();
  }
  
  public void a(bfzn parambfzn, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "installPituSo");
    }
    b();
    if (this.jdField_a_of_type_Bfzg == null) {
      return;
    }
    this.jdField_a_of_type_Bfzg.a(parambfzn, paramInt);
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
    if (this.jdField_a_of_type_Bfzg == null) {
      return false;
    }
    return this.jdField_a_of_type_Bfzg.a();
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isPluginInstalled:" + paramString);
    }
    b();
    if (this.jdField_a_of_type_Bfzg != null) {
      return this.jdField_a_of_type_Bfzg.a(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, bfzq parambfzq, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "installPlugin:" + paramString);
    }
    b();
    if (this.jdField_a_of_type_Bfzg == null) {
      return false;
    }
    return this.jdField_a_of_type_Bfzg.a(paramString, parambfzq, paramInt);
  }
  
  public boolean b(String paramString)
  {
    b();
    if (this.jdField_a_of_type_Bfzg == null) {
      return false;
    }
    return this.jdField_a_of_type_Bfzg.b(paramString);
  }
  
  public boolean c(String paramString)
  {
    b();
    if (this.jdField_a_of_type_Bfzg == null) {
      return false;
    }
    return this.jdField_a_of_type_Bfzg.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgbh
 * JD-Core Version:    0.7.0.1
 */