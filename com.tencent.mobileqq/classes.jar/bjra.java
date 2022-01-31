import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class bjra
  extends QQUIEventReceiver<bjqx, bjqz>
{
  public bjra(@NonNull bjqx parambjqx)
  {
    super(parambjqx);
  }
  
  public void a(@NonNull bjqx parambjqx, @NonNull bjqz parambjqz)
  {
    if (bjqz.a(parambjqz))
    {
      switch (parambjqz.a())
      {
      }
      for (;;)
      {
        bjqx.a(parambjqx);
        return;
        bjqx.a(parambjqx, true);
        veg.b("QGEnvironment", "surface created");
        continue;
        veg.b("QGEnvironment", "qg so loaded");
        continue;
        veg.b("QGEnvironment", "filter manager inited");
      }
    }
    veg.e("QGEnvironment", "QG environment init error :  event type = " + parambjqz.a());
  }
  
  public Class acceptEventClass()
  {
    return bjqz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjra
 * JD-Core Version:    0.7.0.1
 */