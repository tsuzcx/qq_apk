import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amyi
{
  private amyk a;
  
  private boolean a(amyk paramamyk)
  {
    if (this.a == null) {}
    while (paramamyk.a <= this.a.a) {
      return true;
    }
    return false;
  }
  
  public int a(angr paramangr, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if (this.a != null) {
      return this.a.a(paramangr, paramInt, paramAppInterface, paramContext);
    }
    return -1;
  }
  
  public amyk a()
  {
    return this.a;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      this.a.a();
      this.a.a = 9999;
    }
  }
  
  public void a(amyk paramamyk)
  {
    if ((paramamyk != null) && (a(paramamyk)) && (paramamyk.a()))
    {
      this.a = paramamyk;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDrawerContext", 2, "set status success class=" + paramamyk.getClass().getSimpleName());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloDrawerContext", 2, "set status fail class=" + paramamyk.getClass().getSimpleName());
  }
  
  public void a(angr paramangr, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.a(paramangr, paramContext, paramQQAppInterface);
    }
  }
  
  public void a(angr paramangr, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramangr, paramContext, paramQQAppInterface, paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, angr paramangr)
  {
    if (this.a != null)
    {
      this.a.a(paramQQAppInterface, paramangr);
      this.a.a = 9999;
    }
  }
  
  public void b(angr paramangr, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.b(paramangr, paramContext, paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyi
 * JD-Core Version:    0.7.0.1
 */