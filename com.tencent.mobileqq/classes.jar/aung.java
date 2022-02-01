import com.tencent.common.app.BaseApplicationImpl;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class aung
  extends aunh
{
  aung(aunf paramaunf) {}
  
  protected void a(String paramString, MethodChannel.Result paramResult)
  {
    Integer localInteger = Integer.valueOf(aunf.a.incrementAndGet());
    aunf.a(this.a).put(localInteger, paramResult);
    aunp.a().a(localInteger.intValue(), paramString, true);
  }
  
  protected void a(ArrayList<String> paramArrayList, MethodChannel.Result paramResult)
  {
    try
    {
      paramResult.success(aunp.a().a(paramArrayList));
      return;
    }
    catch (Throwable paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  protected void b(String paramString, MethodChannel.Result paramResult)
  {
    Integer localInteger = Integer.valueOf(aunf.a.incrementAndGet());
    aunf.a(this.a).put(localInteger, paramResult);
    aunp.a().a(localInteger.intValue(), paramString, false);
  }
  
  protected void c(String paramString, MethodChannel.Result paramResult)
  {
    azwj.a(BaseApplicationImpl.getContext(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aung
 * JD-Core Version:    0.7.0.1
 */