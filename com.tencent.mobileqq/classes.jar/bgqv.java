import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgqv
  extends BaseAdapter
{
  bgqv(bgqu parambgqu) {}
  
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
    bgra localbgra;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558997, null);
      localbgra = new bgra(this.a, null);
      localbgra.a = ((TextView)paramView.findViewById(2131368898));
      paramView.setTag(localbgra);
    }
    for (;;)
    {
      localbgra = (bgra)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localbgra.a != null)
      {
        localbgra.a.setText(this.a.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        localbgra.a.setOnClickListener(new bgqz(this.a, paramInt));
        i = localbgra.a.getPaddingTop();
        j = localbgra.a.getPaddingLeft();
        k = localbgra.a.getPaddingRight();
        m = localbgra.a.getPaddingBottom();
        if (this.a.jdField_a_of_type_ArrayOfJavaLangString.length != 1) {
          break label232;
        }
        localbgra.a.setBackgroundResource(2130839539);
      }
      for (;;)
      {
        localbgra.a.setPadding(j, i, k, m);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label232:
        if (paramInt == 0) {
          localbgra.a.setBackgroundResource(2130839540);
        } else if (paramInt == this.a.jdField_a_of_type_ArrayOfJavaLangString.length - 1) {
          localbgra.a.setBackgroundResource(2130839538);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgqv
 * JD-Core Version:    0.7.0.1
 */