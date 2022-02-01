import android.os.Handler;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class bhav
  implements Observer
{
  bhav(bhau parambhau) {}
  
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
      bhau.a(this.a, paramObservable);
      if (bhau.a(this.a).plainText != null)
      {
        paramObject = bbce.a().b;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)bhau.a(this.a).plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(bhau.a(this.a).topics);
        }
      }
      if (paramObservable != null) {
        bhau.b(this.a).copyFrom(paramObservable);
      }
      bhau.a(this.a).a().sendEmptyMessage(10003);
      bbce.a().deleteObserver(bhau.a(this.a));
      return;
    }
    bhau.a(this.a).a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhav
 * JD-Core Version:    0.7.0.1
 */