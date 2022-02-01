import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ammo
{
  private ammq a;
  
  private boolean a(ammq paramammq)
  {
    if (this.a == null) {}
    while (paramammq.a <= this.a.a) {
      return true;
    }
    return false;
  }
  
  public int a(amux paramamux, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if (this.a != null) {
      return this.a.a(paramamux, paramInt, paramAppInterface, paramContext);
    }
    return -1;
  }
  
  public ammq a()
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
  
  public void a(ammq paramammq)
  {
    if ((paramammq != null) && (a(paramammq)) && (paramammq.a()))
    {
      this.a = paramammq;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDrawerContext", 2, "set status success class=" + paramammq.getClass().getSimpleName());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloDrawerContext", 2, "set status fail class=" + paramammq.getClass().getSimpleName());
  }
  
  public void a(amux paramamux, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.a(paramamux, paramContext, paramQQAppInterface);
    }
  }
  
  public void a(amux paramamux, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramamux, paramContext, paramQQAppInterface, paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, amux paramamux)
  {
    if (this.a != null)
    {
      this.a.a(paramQQAppInterface, paramamux);
      this.a.a = 9999;
    }
  }
  
  public void b(amux paramamux, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.b(paramamux, paramContext, paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammo
 * JD-Core Version:    0.7.0.1
 */