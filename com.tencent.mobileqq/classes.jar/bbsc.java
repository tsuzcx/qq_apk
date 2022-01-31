import android.os.Handler;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class bbsc
  implements Observer
{
  bbsc(bbsb parambbsb) {}
  
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
      bbsb.a(this.a, paramObservable);
      if (bbsb.a(this.a).plainText != null)
      {
        paramObject = awei.a().b;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)bbsb.a(this.a).plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(bbsb.a(this.a).topics);
        }
      }
      if (paramObservable != null) {
        bbsb.b(this.a).copyFrom(paramObservable);
      }
      bbsb.a(this.a).a().sendEmptyMessage(10003);
      awei.a().deleteObserver(bbsb.a(this.a));
      return;
    }
    bbsb.a(this.a).a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbsc
 * JD-Core Version:    0.7.0.1
 */