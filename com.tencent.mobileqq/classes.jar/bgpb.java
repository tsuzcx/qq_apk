import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgpb
  extends BaseAdapter
{
  bgpb(bgpa parambgpa) {}
  
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
    bgpn localbgpn;
    if (paramView == null)
    {
      paramView = this.a.inflater.inflate(this.a.getDialogListItemLayout(), null);
      localbgpn = new bgpn(this.a, null);
      localbgpn.a = ((TextView)paramView.findViewById(2131368898));
      paramView.setTag(localbgpn);
    }
    for (;;)
    {
      localbgpn = (bgpn)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localbgpn.a != null)
      {
        localbgpn.a.setText(this.a.items[paramInt]);
        localbgpn.a.setOnClickListener(new bgpm(this.a, paramInt));
        i = localbgpn.a.getPaddingTop();
        j = localbgpn.a.getPaddingLeft();
        k = localbgpn.a.getPaddingRight();
        m = localbgpn.a.getPaddingBottom();
        if (this.a.items.length != 1) {
          break label237;
        }
        localbgpn.a.setBackgroundResource(2130839539);
      }
      for (;;)
      {
        localbgpn.a.setPadding(j, i, k, m);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label237:
        if (paramInt == 0) {
          localbgpn.a.setBackgroundResource(2130839540);
        } else if (paramInt == this.a.items.length - 1) {
          localbgpn.a.setBackgroundResource(2130839538);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgpb
 * JD-Core Version:    0.7.0.1
 */