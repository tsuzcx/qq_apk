import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.widget.QQToast;

class bmic
  implements AdapterView.OnItemClickListener
{
  bmic(bmhu parambmhu) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (bmhu.a(this.a) != null) {
      bfxu.a(bmhu.a(this.a).hashCode());
    }
    paramAdapterView = bmhu.a(this.a).a(paramInt);
    if (bmhu.a(this.a).a() == paramInt) {
      if (paramAdapterView.c) {
        bmhu.a(this.a, true);
      }
    }
    for (;;)
    {
      wxj.a("textEdit_patten", "clk_patten", bmhu.b(this.a), 0, new String[] { "", paramAdapterView.a });
      return;
      if (paramAdapterView.d)
      {
        if (bdin.d(paramView.getContext()))
        {
          QQToast.a(bmhu.a(this.a).getContext(), alud.a(2131714810), 0).a();
          bmhu.a(this.a, paramAdapterView);
        }
        else
        {
          bmhu.b(this.a);
        }
      }
      else
      {
        QQToast.a(bmhu.a(this.a).getContext(), alud.a(2131714808), 0).a();
        continue;
        bmhu.a(this.a).a(paramInt);
        bmhu.a(this.a, paramAdapterView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmic
 * JD-Core Version:    0.7.0.1
 */