import android.os.Handler;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class bibb
  implements Observer
{
  bibb(biba parambiba) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof ArrayList))
    {
      paramObservable = (ArrayList)paramObject;
      switch (((Integer)paramObservable.get(0)).intValue())
      {
      default: 
        return;
      }
      paramObservable = (RichStatus)paramObservable.get(1);
      biba.a(this.a, paramObservable);
      if (biba.a(this.a).plainText != null)
      {
        paramObject = bbux.a().b;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)biba.a(this.a).plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(biba.a(this.a).topics);
        }
      }
      if (paramObservable != null) {
        biba.b(this.a).copyFrom(paramObservable);
      }
      biba.a(this.a).a().sendEmptyMessage(10003);
      bbux.a().deleteObserver(biba.a(this.a));
      return;
    }
    biba.a(this.a).a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bibb
 * JD-Core Version:    0.7.0.1
 */