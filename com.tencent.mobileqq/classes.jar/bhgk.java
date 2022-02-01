import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhgk
  extends BaseAdapter
{
  bhgk(bhgj parambhgj) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_ArrayOfJavaLangString != null) {
      return this.a.jdField_a_of_type_ArrayOfJavaLangString.length;
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
    if (this.a.jdField_a_of_type_AndroidViewLayoutInflater == null) {
      this.a.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)this.a.getContext().getSystemService("layout_inflater"));
    }
    bhgp localbhgp;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559031, null);
      localbhgp = new bhgp(this.a, null);
      localbhgp.a = ((TextView)paramView.findViewById(2131369180));
      paramView.setTag(localbhgp);
    }
    for (;;)
    {
      localbhgp = (bhgp)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localbhgp.a != null)
      {
        localbhgp.a.setText(this.a.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        localbhgp.a.setOnClickListener(new bhgo(this.a, paramInt));
        i = localbhgp.a.getPaddingTop();
        j = localbhgp.a.getPaddingLeft();
        k = localbhgp.a.getPaddingRight();
        m = localbhgp.a.getPaddingBottom();
        if (this.a.jdField_a_of_type_ArrayOfJavaLangString.length != 1) {
          break label232;
        }
        localbhgp.a.setBackgroundResource(2130839604);
      }
      for (;;)
      {
        localbhgp.a.setPadding(j, i, k, m);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label232:
        if (paramInt == 0) {
          localbhgp.a.setBackgroundResource(2130839605);
        } else if (paramInt == this.a.jdField_a_of_type_ArrayOfJavaLangString.length - 1) {
          localbhgp.a.setBackgroundResource(2130839603);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhgk
 * JD-Core Version:    0.7.0.1
 */