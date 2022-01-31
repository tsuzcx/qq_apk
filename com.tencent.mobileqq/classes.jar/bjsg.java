import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class bjsg
  implements AdapterView.OnItemClickListener
{
  bjsg(bjry parambjry) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (bjry.a(this.a) != null) {
      bdts.a(bjry.a(this.a).hashCode());
    }
    paramAdapterView = bjry.a(this.a).a(paramInt);
    if (bjry.a(this.a).a() == paramInt) {
      if (paramAdapterView.c) {
        bjry.a(this.a, true);
      }
    }
    for (;;)
    {
      vei.a("textEdit_patten", "clk_patten", bjry.b(this.a), 0, new String[] { "", paramAdapterView.a });
      return;
      if (paramAdapterView.d)
      {
        if (bbfj.d(paramView.getContext()))
        {
          bcql.a(bjry.a(this.a).getContext(), ajya.a(2131714426), 0).a();
          bjry.a(this.a, paramAdapterView);
        }
        else
        {
          bjry.b(this.a);
        }
      }
      else
      {
        bcql.a(bjry.a(this.a).getContext(), ajya.a(2131714424), 0).a();
        continue;
        bjry.a(this.a).a(paramInt);
        bjry.a(this.a, paramAdapterView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsg
 * JD-Core Version:    0.7.0.1
 */