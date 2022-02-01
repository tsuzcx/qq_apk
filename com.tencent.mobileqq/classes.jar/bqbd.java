import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bqbd
  implements AdapterView.OnItemClickListener
{
  bqbd(bqav parambqav) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (bqav.a(this.a) != null) {
      bkgg.a(bqav.a(this.a).hashCode());
    }
    wrv localwrv = bqav.a(this.a).a(paramInt);
    if (bqav.a(this.a).a() == paramInt) {
      if (localwrv.c) {
        bqav.a(this.a, true);
      }
    }
    for (;;)
    {
      yup.a("textEdit_patten", "clk_patten", bqav.b(this.a), 0, new String[] { "", localwrv.a });
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (localwrv.d)
      {
        if (bhnv.d(paramView.getContext()))
        {
          QQToast.a(bqav.a(this.a).getContext(), anzj.a(2131713220), 0).a();
          bqav.a(this.a, localwrv);
        }
        else
        {
          bqav.b(this.a);
        }
      }
      else
      {
        QQToast.a(bqav.a(this.a).getContext(), anzj.a(2131713218), 0).a();
        continue;
        bqav.a(this.a).a(paramInt);
        bqav.a(this.a, localwrv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqbd
 * JD-Core Version:    0.7.0.1
 */