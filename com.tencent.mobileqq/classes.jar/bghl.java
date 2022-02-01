import android.os.Handler;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class bghl
  implements Observer
{
  bghl(bghk parambghk) {}
  
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
      bghk.a(this.a, paramObservable);
      if (bghk.a(this.a).plainText != null)
      {
        paramObject = baos.a().b;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)bghk.a(this.a).plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(bghk.a(this.a).topics);
        }
      }
      if (paramObservable != null) {
        bghk.b(this.a).copyFrom(paramObservable);
      }
      bghk.a(this.a).a().sendEmptyMessage(10003);
      baos.a().deleteObserver(bghk.a(this.a));
      return;
    }
    bghk.a(this.a).a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghl
 * JD-Core Version:    0.7.0.1
 */