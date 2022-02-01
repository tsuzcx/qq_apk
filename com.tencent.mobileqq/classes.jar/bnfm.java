import android.os.Binder;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;
import java.lang.ref.WeakReference;

public class bnfm
  extends bnfo
{
  private static bnfm jdField_a_of_type_Bnfm;
  private static String jdField_a_of_type_JavaLangString = "QZoneRemotePluginHandler";
  private bndl jdField_a_of_type_Bndl;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static bnfm a()
  {
    if (jdField_a_of_type_Bnfm == null) {}
    try
    {
      if (jdField_a_of_type_Bnfm == null) {
        jdField_a_of_type_Bnfm = new bnfm();
      }
      return jdField_a_of_type_Bnfm;
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
        this.jdField_a_of_type_Bndl = ((bndl)localQQAppInterface.getManager(175));
        localObject = localQQAppInterface;
      }
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "appInterface:" + localObject + ",pluginManger=" + this.jdField_a_of_type_Bndl);
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
    if (this.jdField_a_of_type_Bndl == null) {
      return null;
    }
    return this.jdField_a_of_type_Bndl.a(paramString);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "triggerQQDownloadPtuFilter");
    }
    b();
    if (this.jdField_a_of_type_Bndl == null) {
      return;
    }
    this.jdField_a_of_type_Bndl.a();
  }
  
  public void a(bnds parambnds, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "installPituSo");
    }
    b();
    if (this.jdField_a_of_type_Bndl == null) {
      return;
    }
    this.jdField_a_of_type_Bndl.a(parambnds, paramInt);
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
    if (this.jdField_a_of_type_Bndl == null) {
      return false;
    }
    return this.jdField_a_of_type_Bndl.a();
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isPluginInstalled:" + paramString);
    }
    b();
    if (this.jdField_a_of_type_Bndl != null) {
      return this.jdField_a_of_type_Bndl.a(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, bndv parambndv, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "installPlugin:" + paramString);
    }
    b();
    if (this.jdField_a_of_type_Bndl == null) {
      return false;
    }
    return this.jdField_a_of_type_Bndl.a(paramString, parambndv, paramInt);
  }
  
  public boolean b(String paramString)
  {
    b();
    if (this.jdField_a_of_type_Bndl == null) {
      return false;
    }
    return this.jdField_a_of_type_Bndl.b(paramString);
  }
  
  public boolean c(String paramString)
  {
    b();
    if (this.jdField_a_of_type_Bndl == null) {
      return false;
    }
    return this.jdField_a_of_type_Bndl.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfm
 * JD-Core Version:    0.7.0.1
 */