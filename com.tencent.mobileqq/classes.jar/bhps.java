import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhps
  extends BaseAdapter
{
  bhps(bhpr parambhpr) {}
  
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
    bhpx localbhpx;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558996, null);
      localbhpx = new bhpx(this.a, null);
      localbhpx.a = ((TextView)paramView.findViewById(2131368991));
      paramView.setTag(localbhpx);
    }
    for (;;)
    {
      localbhpx = (bhpx)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localbhpx.a != null)
      {
        localbhpx.a.setText(this.a.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        localbhpx.a.setOnClickListener(new bhpw(this.a, paramInt));
        i = localbhpx.a.getPaddingTop();
        j = localbhpx.a.getPaddingLeft();
        k = localbhpx.a.getPaddingRight();
        m = localbhpx.a.getPaddingBottom();
        if (this.a.jdField_a_of_type_ArrayOfJavaLangString.length != 1) {
          break label232;
        }
        localbhpx.a.setBackgroundResource(2130839548);
      }
      for (;;)
      {
        localbhpx.a.setPadding(j, i, k, m);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label232:
        if (paramInt == 0) {
          localbhpx.a.setBackgroundResource(2130839549);
        } else if (paramInt == this.a.jdField_a_of_type_ArrayOfJavaLangString.length - 1) {
          localbhpx.a.setBackgroundResource(2130839547);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhps
 * JD-Core Version:    0.7.0.1
 */