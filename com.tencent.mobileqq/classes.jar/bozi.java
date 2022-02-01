import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bozi
  implements AdapterView.OnItemClickListener
{
  bozi(boza paramboza) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (boza.a(this.a) != null) {
      bjfg.a(boza.a(this.a).hashCode());
    }
    woa localwoa = boza.a(this.a).a(paramInt);
    if (boza.a(this.a).a() == paramInt) {
      if (localwoa.c) {
        boza.a(this.a, true);
      }
    }
    for (;;)
    {
      yqu.a("textEdit_patten", "clk_patten", boza.b(this.a), 0, new String[] { "", localwoa.a });
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (localwoa.d)
      {
        if (bgnt.d(paramView.getContext()))
        {
          QQToast.a(boza.a(this.a).getContext(), anni.a(2131713111), 0).a();
          boza.a(this.a, localwoa);
        }
        else
        {
          boza.b(this.a);
        }
      }
      else
      {
        QQToast.a(boza.a(this.a).getContext(), anni.a(2131713109), 0).a();
        continue;
        boza.a(this.a).a(paramInt);
        boza.a(this.a, localwoa);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozi
 * JD-Core Version:    0.7.0.1
 */