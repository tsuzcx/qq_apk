import android.os.Handler;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class bhqg
  implements Observer
{
  bhqg(bhqf parambhqf) {}
  
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
      bhqf.a(this.a, paramObservable);
      if (bhqf.a(this.a).plainText != null)
      {
        paramObject = bbvh.a().b;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)bhqf.a(this.a).plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(bhqf.a(this.a).topics);
        }
      }
      if (paramObservable != null) {
        bhqf.b(this.a).copyFrom(paramObservable);
      }
      bhqf.a(this.a).a().sendEmptyMessage(10003);
      bbvh.a().deleteObserver(bhqf.a(this.a));
      return;
    }
    bhqf.a(this.a).a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhqg
 * JD-Core Version:    0.7.0.1
 */