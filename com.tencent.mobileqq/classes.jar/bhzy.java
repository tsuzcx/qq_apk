import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class bhzy
  implements AdapterView.OnItemClickListener
{
  bhzy(bhzq parambhzq) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (bhzq.a(this.a) != null) {
      bcpa.a(bhzq.a(this.a).hashCode());
    }
    paramAdapterView = bhzq.a(this.a).a(paramInt);
    if (bhzq.a(this.a).a() == paramInt) {
      if (paramAdapterView.c) {
        bhzq.a(this.a, true);
      }
    }
    for (;;)
    {
      urp.a("textEdit_patten", "clk_patten", bhzq.b(this.a), 0, new String[] { "", paramAdapterView.a });
      return;
      if (paramAdapterView.d)
      {
        if (badq.d(paramView.getContext()))
        {
          bbmy.a(bhzq.a(this.a).getContext(), ajjy.a(2131648626), 0).a();
          bhzq.a(this.a, paramAdapterView);
        }
        else
        {
          bhzq.b(this.a);
        }
      }
      else
      {
        bbmy.a(bhzq.a(this.a).getContext(), ajjy.a(2131648624), 0).a();
        continue;
        bhzq.a(this.a).a(paramInt);
        bhzq.a(this.a, paramAdapterView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhzy
 * JD-Core Version:    0.7.0.1
 */