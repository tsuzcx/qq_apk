import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.widget.QQToast;

class bmdq
  implements AdapterView.OnItemClickListener
{
  bmdq(bmdi parambmdi) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (bmdi.a(this.a) != null) {
      bftn.a(bmdi.a(this.a).hashCode());
    }
    paramAdapterView = bmdi.a(this.a).a(paramInt);
    if (bmdi.a(this.a).a() == paramInt) {
      if (paramAdapterView.c) {
        bmdi.a(this.a, true);
      }
    }
    for (;;)
    {
      wta.a("textEdit_patten", "clk_patten", bmdi.b(this.a), 0, new String[] { "", paramAdapterView.a });
      return;
      if (paramAdapterView.d)
      {
        if (bdee.d(paramView.getContext()))
        {
          QQToast.a(bmdi.a(this.a).getContext(), alpo.a(2131714798), 0).a();
          bmdi.a(this.a, paramAdapterView);
        }
        else
        {
          bmdi.b(this.a);
        }
      }
      else
      {
        QQToast.a(bmdi.a(this.a).getContext(), alpo.a(2131714796), 0).a();
        continue;
        bmdi.a(this.a).a(paramInt);
        bmdi.a(this.a, paramAdapterView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdq
 * JD-Core Version:    0.7.0.1
 */