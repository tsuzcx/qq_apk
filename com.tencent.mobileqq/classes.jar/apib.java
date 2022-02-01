import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class apib
  implements AdapterView.OnItemClickListener
{
  apib(aphy paramaphy) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = apil.a(aphy.f(this.a).app).a(paramInt, aphy.a(this.a).getCount());
    if (aphy.a(this.a) == null) {
      aphy.a(this.a, new apii());
    }
    aphy.a(this.a).a(aphy.g(this.a), aphy.a(this.a).a(paramInt), bool);
    QQAppInterface localQQAppInterface = aphy.h(this.a).app;
    int i = apil.a(aphy.i(this.a).app).a(String.valueOf(aphy.a(this.a)));
    if (bool) {}
    for (String str = "1";; str = aphy.a(this.a).a(paramInt).a)
    {
      bcef.b(localQQAppInterface, "dc00898", "", "", "0X800B32A", "0X800B32A", i, 0, str, paramInt + "", "", "");
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apib
 * JD-Core Version:    0.7.0.1
 */