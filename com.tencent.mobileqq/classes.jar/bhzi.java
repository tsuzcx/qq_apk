import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class bhzi
  extends QQUIEventReceiver<bhzf, bhzh>
{
  public bhzi(@NonNull bhzf parambhzf)
  {
    super(parambhzf);
  }
  
  public void a(@NonNull bhzf parambhzf, @NonNull bhzh parambhzh)
  {
    if (bhzh.a(parambhzh))
    {
      switch (parambhzh.a())
      {
      }
      for (;;)
      {
        bhzf.a(parambhzf);
        return;
        bhzf.a(parambhzf, true);
        urk.b("QGEnvironment", "surface created");
        continue;
        urk.b("QGEnvironment", "qg so loaded");
        continue;
        urk.b("QGEnvironment", "filter manager inited");
      }
    }
    urk.e("QGEnvironment", "QG environment init error :  event type = " + parambhzh.a());
  }
  
  public Class acceptEventClass()
  {
    return bhzh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhzi
 * JD-Core Version:    0.7.0.1
 */