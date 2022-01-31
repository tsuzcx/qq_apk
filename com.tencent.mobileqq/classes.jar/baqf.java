import android.os.Handler;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class baqf
  implements Observer
{
  baqf(baqe parambaqe) {}
  
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
      baqe.a(this.a, paramObservable);
      if (baqe.a(this.a).plainText != null)
      {
        paramObject = avep.a().b;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)baqe.a(this.a).plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(baqe.a(this.a).topics);
        }
      }
      if (paramObservable != null) {
        baqe.b(this.a).copyFrom(paramObservable);
      }
      baqe.a(this.a).a().sendEmptyMessage(10003);
      avep.a().deleteObserver(baqe.a(this.a));
      return;
    }
    baqe.a(this.a).a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     baqf
 * JD-Core Version:    0.7.0.1
 */