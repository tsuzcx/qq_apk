import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class bbgv
  extends BaseAdapter
{
  bbgv(bbgu parambbgu) {}
  
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
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.inflater.inflate(this.a.getDialogListItemLayout(), null);
      paramView = new bbhh(this.a, null);
      paramView.a = ((TextView)paramViewGroup.findViewById(2131368381));
      paramViewGroup.setTag(paramView);
    }
    paramView = (bbhh)paramViewGroup.getTag();
    int i;
    int j;
    int k;
    int m;
    if (paramView.a != null)
    {
      paramView.a.setText(this.a.items[paramInt]);
      paramView.a.setOnClickListener(new bbhg(this.a, paramInt));
      i = paramView.a.getPaddingTop();
      j = paramView.a.getPaddingLeft();
      k = paramView.a.getPaddingRight();
      m = paramView.a.getPaddingBottom();
      if (this.a.items.length != 1) {
        break label212;
      }
      paramView.a.setBackgroundResource(2130839270);
    }
    for (;;)
    {
      paramView.a.setPadding(j, i, k, m);
      return paramViewGroup;
      label212:
      if (paramInt == 0) {
        paramView.a.setBackgroundResource(2130839271);
      } else if (paramInt == this.a.items.length - 1) {
        paramView.a.setBackgroundResource(2130839269);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbgv
 * JD-Core Version:    0.7.0.1
 */