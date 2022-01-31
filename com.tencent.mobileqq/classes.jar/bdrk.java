import android.os.Handler;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class bdrk
  implements Observer
{
  bdrk(bdrj parambdrj) {}
  
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
      bdrj.a(this.a, paramObservable);
      if (bdrj.a(this.a).plainText != null)
      {
        paramObject = axzn.a().b;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)bdrj.a(this.a).plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(bdrj.a(this.a).topics);
        }
      }
      if (paramObservable != null) {
        bdrj.b(this.a).copyFrom(paramObservable);
      }
      bdrj.a(this.a).a().sendEmptyMessage(10003);
      axzn.a().deleteObserver(bdrj.a(this.a));
      return;
    }
    bdrj.a(this.a).a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrk
 * JD-Core Version:    0.7.0.1
 */