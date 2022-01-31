import android.os.Handler;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class bdvt
  implements Observer
{
  bdvt(bdvs parambdvs) {}
  
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
      bdvs.a(this.a, paramObservable);
      if (bdvs.a(this.a).plainText != null)
      {
        paramObject = aydw.a().b;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)bdvs.a(this.a).plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(bdvs.a(this.a).topics);
        }
      }
      if (paramObservable != null) {
        bdvs.b(this.a).copyFrom(paramObservable);
      }
      bdvs.a(this.a).a().sendEmptyMessage(10003);
      aydw.a().deleteObserver(bdvs.a(this.a));
      return;
    }
    bdvs.a(this.a).a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvt
 * JD-Core Version:    0.7.0.1
 */