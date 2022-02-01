import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhpd
  extends BaseAdapter
{
  bhpd(bhpc parambhpc) {}
  
  public int getCount()
  {
    if (this.a.items != null) {
      return this.a.items.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a.inflater == null) {
      this.a.inflater = ((LayoutInflater)this.a.getContext().getSystemService("layout_inflater"));
    }
    bhpp localbhpp;
    if (paramView == null)
    {
      paramView = this.a.inflater.inflate(this.a.getDialogListItemLayout(), null);
      localbhpp = new bhpp(this.a, null);
      localbhpp.a = ((TextView)paramView.findViewById(2131368991));
      paramView.setTag(localbhpp);
    }
    for (;;)
    {
      localbhpp = (bhpp)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localbhpp.a != null)
      {
        localbhpp.a.setText(this.a.items[paramInt]);
        localbhpp.a.setOnClickListener(new bhpo(this.a, paramInt));
        i = localbhpp.a.getPaddingTop();
        j = localbhpp.a.getPaddingLeft();
        k = localbhpp.a.getPaddingRight();
        m = localbhpp.a.getPaddingBottom();
        if (this.a.items.length != 1) {
          break label237;
        }
        localbhpp.a.setBackgroundResource(2130839548);
      }
      for (;;)
      {
        localbhpp.a.setPadding(j, i, k, m);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label237:
        if (paramInt == 0) {
          localbhpp.a.setBackgroundResource(2130839549);
        } else if (paramInt == this.a.items.length - 1) {
          localbhpp.a.setBackgroundResource(2130839547);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhpd
 * JD-Core Version:    0.7.0.1
 */