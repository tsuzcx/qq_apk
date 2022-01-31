import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class bjrp
  implements AdapterView.OnItemClickListener
{
  bjrp(bjrh parambjrh) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (bjrh.a(this.a) != null) {
      bdtb.a(bjrh.a(this.a).hashCode());
    }
    paramAdapterView = bjrh.a(this.a).a(paramInt);
    if (bjrh.a(this.a).a() == paramInt) {
      if (paramAdapterView.c) {
        bjrh.a(this.a, true);
      }
    }
    for (;;)
    {
      vel.a("textEdit_patten", "clk_patten", bjrh.b(this.a), 0, new String[] { "", paramAdapterView.a });
      return;
      if (paramAdapterView.d)
      {
        if (bbev.d(paramView.getContext()))
        {
          bcpw.a(bjrh.a(this.a).getContext(), ajyc.a(2131714415), 0).a();
          bjrh.a(this.a, paramAdapterView);
        }
        else
        {
          bjrh.b(this.a);
        }
      }
      else
      {
        bcpw.a(bjrh.a(this.a).getContext(), ajyc.a(2131714413), 0).a();
        continue;
        bjrh.a(this.a).a(paramInt);
        bjrh.a(this.a, paramAdapterView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjrp
 * JD-Core Version:    0.7.0.1
 */