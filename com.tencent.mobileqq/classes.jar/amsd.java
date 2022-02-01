import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amsd
{
  private amsf a;
  
  private boolean a(amsf paramamsf)
  {
    if (this.a == null) {}
    while (paramamsf.a <= this.a.a) {
      return true;
    }
    return false;
  }
  
  public int a(anct paramanct, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if (this.a != null) {
      return this.a.a(paramanct, paramInt, paramAppInterface, paramContext);
    }
    return -1;
  }
  
  public amsf a()
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
  
  public void a(amsf paramamsf)
  {
    if ((paramamsf != null) && (a(paramamsf)) && (paramamsf.a()))
    {
      this.a = paramamsf;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDrawerContext", 2, "set status success class=" + paramamsf.getClass().getSimpleName());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloDrawerContext", 2, "set status fail class=" + null);
  }
  
  public void a(anct paramanct, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.a(paramanct, paramContext, paramQQAppInterface);
    }
  }
  
  public void a(anct paramanct, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramanct, paramContext, paramQQAppInterface, paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, anct paramanct)
  {
    if (this.a != null)
    {
      this.a.a(paramQQAppInterface, paramanct);
      this.a.a = 9999;
    }
  }
  
  public void b(anct paramanct, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.b(paramanct, paramContext, paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsd
 * JD-Core Version:    0.7.0.1
 */