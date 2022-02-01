import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhqx
  extends BaseAdapter
{
  bhqx(bhqw parambhqw) {}
  
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
    bhrc localbhrc;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558996, null);
      localbhrc = new bhrc(this.a, null);
      localbhrc.a = ((TextView)paramView.findViewById(2131368991));
      paramView.setTag(localbhrc);
    }
    for (;;)
    {
      localbhrc = (bhrc)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localbhrc.a != null)
      {
        localbhrc.a.setText(this.a.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        localbhrc.a.setOnClickListener(new bhrb(this.a, paramInt));
        i = localbhrc.a.getPaddingTop();
        j = localbhrc.a.getPaddingLeft();
        k = localbhrc.a.getPaddingRight();
        m = localbhrc.a.getPaddingBottom();
        if (this.a.jdField_a_of_type_ArrayOfJavaLangString.length != 1) {
          break label232;
        }
        localbhrc.a.setBackgroundResource(2130839548);
      }
      for (;;)
      {
        localbhrc.a.setPadding(j, i, k, m);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label232:
        if (paramInt == 0) {
          localbhrc.a.setBackgroundResource(2130839549);
        } else if (paramInt == this.a.jdField_a_of_type_ArrayOfJavaLangString.length - 1) {
          localbhrc.a.setBackgroundResource(2130839547);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhqx
 * JD-Core Version:    0.7.0.1
 */