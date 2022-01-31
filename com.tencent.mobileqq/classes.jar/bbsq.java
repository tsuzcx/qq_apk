import android.os.Handler;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class bbsq
  implements Observer
{
  bbsq(bbsp parambbsp) {}
  
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
      bbsp.a(this.a, paramObservable);
      if (bbsp.a(this.a).plainText != null)
      {
        paramObject = awek.a().b;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)bbsp.a(this.a).plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(bbsp.a(this.a).topics);
        }
      }
      if (paramObservable != null) {
        bbsp.b(this.a).copyFrom(paramObservable);
      }
      bbsp.a(this.a).a().sendEmptyMessage(10003);
      awek.a().deleteObserver(bbsp.a(this.a));
      return;
    }
    bbsp.a(this.a).a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbsq
 * JD-Core Version:    0.7.0.1
 */