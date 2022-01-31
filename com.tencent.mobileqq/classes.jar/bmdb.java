import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class bmdb
  extends QQUIEventReceiver<bmcy, bmda>
{
  public bmdb(@NonNull bmcy parambmcy)
  {
    super(parambmcy);
  }
  
  public void a(@NonNull bmcy parambmcy, @NonNull bmda parambmda)
  {
    if (bmda.a(parambmda))
    {
      switch (parambmda.a())
      {
      }
      for (;;)
      {
        bmcy.a(parambmcy);
        return;
        bmcy.a(parambmcy, true);
        wsv.b("QGEnvironment", "surface created");
        continue;
        wsv.b("QGEnvironment", "qg so loaded");
        continue;
        wsv.b("QGEnvironment", "filter manager inited");
      }
    }
    wsv.e("QGEnvironment", "QG environment init error :  event type = " + parambmda.a());
  }
  
  public Class acceptEventClass()
  {
    return bmda.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdb
 * JD-Core Version:    0.7.0.1
 */