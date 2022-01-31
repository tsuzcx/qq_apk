import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public abstract class amra
  implements Runnable
{
  final WeakReference a;
  
  amra(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amra
 * JD-Core Version:    0.7.0.1
 */