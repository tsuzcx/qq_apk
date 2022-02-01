import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqlf
  implements AdapterView.OnItemClickListener
{
  aqlf(aqlc paramaqlc) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = aqlp.a(aqlc.f(this.a).app).a(paramInt, aqlc.a(this.a).getCount());
    if (aqlc.a(this.a) == null) {
      aqlc.a(this.a, new aqlm());
    }
    aqlc.a(this.a).a(aqlc.g(this.a), aqlc.a(this.a).a(paramInt), bool);
    QQAppInterface localQQAppInterface = aqlc.h(this.a).app;
    int i = aqlp.a(aqlc.i(this.a).app).a(String.valueOf(aqlc.a(this.a)));
    if (bool) {}
    for (String str = "1";; str = aqlc.a(this.a).a(paramInt).a)
    {
      bdla.b(localQQAppInterface, "dc00898", "", "", "0X800B32A", "0X800B32A", i, 0, str, paramInt + "", "", "");
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlf
 * JD-Core Version:    0.7.0.1
 */