import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.tmassistant.common.jce.StatItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class bjqx
  extends Handler
{
  bjqx(bjqw parambjqw, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    Object localObject2;
    if (paramMessage.what == 1)
    {
      localObject1 = bjqw.a(this.a).keySet();
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        paramMessage = new ArrayList();
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          i = ((Integer)((Iterator)localObject1).next()).intValue();
          localObject2 = new StatItem();
          ((StatItem)localObject2).type = i;
          ((StatItem)localObject2).records = ((ArrayList)bjqw.a(this.a).get(Integer.valueOf(i)));
          paramMessage.add(localObject2);
        }
        bjqw.a(this.a).clear();
        if (paramMessage.size() > 0)
        {
          i = bjqw.a(this.a).a(paramMessage);
          bjqw.a(this.a).put(i, paramMessage);
        }
      }
    }
    while (paramMessage.what != 2) {
      return;
    }
    Object localObject1 = bjqj.a().a();
    paramMessage = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      i = ((Integer)((Iterator)localObject1).next()).intValue();
      Object localObject3 = bjqj.a().a(String.valueOf(i));
      localObject2 = new ArrayList();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Serializable localSerializable = (Serializable)((Iterator)localObject3).next();
          try
          {
            ((ArrayList)localObject2).add((String)localSerializable);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      if (((ArrayList)localObject2).size() > 0) {
        paramMessage.add(new StatItem(i, (ArrayList)localObject2));
      }
    }
    if (paramMessage.size() > 0)
    {
      i = bjqw.a(this.a).a(paramMessage);
      bjqw.b(this.a).put(i, paramMessage);
    }
    bjqw.a(this.a).sendEmptyMessageDelayed(2, bjqw.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjqx
 * JD-Core Version:    0.7.0.1
 */