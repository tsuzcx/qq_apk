import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public abstract class amjo
  implements Runnable
{
  final WeakReference a;
  
  amjo(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjo
 * JD-Core Version:    0.7.0.1
 */