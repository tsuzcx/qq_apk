import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgpq
  extends BaseAdapter
{
  bgpq(bgpp parambgpp) {}
  
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
    bgpv localbgpv;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558997, null);
      localbgpv = new bgpv(this.a, null);
      localbgpv.a = ((TextView)paramView.findViewById(2131368898));
      paramView.setTag(localbgpv);
    }
    for (;;)
    {
      localbgpv = (bgpv)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localbgpv.a != null)
      {
        localbgpv.a.setText(this.a.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        localbgpv.a.setOnClickListener(new bgpu(this.a, paramInt));
        i = localbgpv.a.getPaddingTop();
        j = localbgpv.a.getPaddingLeft();
        k = localbgpv.a.getPaddingRight();
        m = localbgpv.a.getPaddingBottom();
        if (this.a.jdField_a_of_type_ArrayOfJavaLangString.length != 1) {
          break label232;
        }
        localbgpv.a.setBackgroundResource(2130839539);
      }
      for (;;)
      {
        localbgpv.a.setPadding(j, i, k, m);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label232:
        if (paramInt == 0) {
          localbgpv.a.setBackgroundResource(2130839540);
        } else if (paramInt == this.a.jdField_a_of_type_ArrayOfJavaLangString.length - 1) {
          localbgpv.a.setBackgroundResource(2130839538);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgpq
 * JD-Core Version:    0.7.0.1
 */