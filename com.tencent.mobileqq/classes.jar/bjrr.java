import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class bjrr
  extends QQUIEventReceiver<bjro, bjrq>
{
  public bjrr(@NonNull bjro parambjro)
  {
    super(parambjro);
  }
  
  public void a(@NonNull bjro parambjro, @NonNull bjrq parambjrq)
  {
    if (bjrq.a(parambjrq))
    {
      switch (parambjrq.a())
      {
      }
      for (;;)
      {
        bjro.a(parambjro);
        return;
        bjro.a(parambjro, true);
        ved.b("QGEnvironment", "surface created");
        continue;
        ved.b("QGEnvironment", "qg so loaded");
        continue;
        ved.b("QGEnvironment", "filter manager inited");
      }
    }
    ved.e("QGEnvironment", "QG environment init error :  event type = " + parambjrq.a());
  }
  
  public Class acceptEventClass()
  {
    return bjrq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjrr
 * JD-Core Version:    0.7.0.1
 */