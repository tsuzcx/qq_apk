import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqos
  implements AdapterView.OnItemClickListener
{
  aqos(aqop paramaqop) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = aqpc.a(aqop.f(this.a).a).a(paramInt, aqop.a(this.a).getCount());
    if (aqop.a(this.a) == null) {
      aqop.a(this.a, new aqoz());
    }
    aqop.a(this.a).a(aqop.g(this.a), aqop.a(this.a).a(paramInt), bool);
    QQAppInterface localQQAppInterface = aqop.h(this.a).a;
    int i = aqpc.a(aqop.i(this.a).a).a(String.valueOf(aqop.a(this.a)));
    if (bool) {}
    for (String str = "1";; str = aqop.a(this.a).a(paramInt).a)
    {
      bdll.b(localQQAppInterface, "dc00898", "", "", "0X800B32A", "0X800B32A", i, 0, str, paramInt + "", "", "");
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqos
 * JD-Core Version:    0.7.0.1
 */