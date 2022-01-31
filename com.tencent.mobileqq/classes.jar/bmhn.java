import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class bmhn
  extends QQUIEventReceiver<bmhk, bmhm>
{
  public bmhn(@NonNull bmhk parambmhk)
  {
    super(parambmhk);
  }
  
  public void a(@NonNull bmhk parambmhk, @NonNull bmhm parambmhm)
  {
    if (bmhm.a(parambmhm))
    {
      switch (parambmhm.a())
      {
      }
      for (;;)
      {
        bmhk.a(parambmhk);
        return;
        bmhk.a(parambmhk, true);
        wxe.b("QGEnvironment", "surface created");
        continue;
        wxe.b("QGEnvironment", "qg so loaded");
        continue;
        wxe.b("QGEnvironment", "filter manager inited");
      }
    }
    wxe.e("QGEnvironment", "QG environment init error :  event type = " + parambmhm.a());
  }
  
  public Class acceptEventClass()
  {
    return bmhm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhn
 * JD-Core Version:    0.7.0.1
 */