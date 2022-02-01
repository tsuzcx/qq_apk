import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;

public abstract class ansq<T extends CustomEmotionBase>
  extends BusinessHandler
{
  protected ansq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public abstract void a();
  
  protected abstract void a(Object paramObject, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansq
 * JD-Core Version:    0.7.0.1
 */