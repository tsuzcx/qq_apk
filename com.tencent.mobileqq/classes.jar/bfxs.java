import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfxs
  extends BaseAdapter
{
  bfxs(bfxr parambfxr) {}
  
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
    bfxx localbfxx;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559004, null);
      localbfxx = new bfxx(this.a, null);
      localbfxx.a = ((TextView)paramView.findViewById(2131369017));
      paramView.setTag(localbfxx);
    }
    for (;;)
    {
      localbfxx = (bfxx)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localbfxx.a != null)
      {
        localbfxx.a.setText(this.a.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        localbfxx.a.setOnClickListener(new bfxw(this.a, paramInt));
        i = localbfxx.a.getPaddingTop();
        j = localbfxx.a.getPaddingLeft();
        k = localbfxx.a.getPaddingRight();
        m = localbfxx.a.getPaddingBottom();
        if (this.a.jdField_a_of_type_ArrayOfJavaLangString.length != 1) {
          break label232;
        }
        localbfxx.a.setBackgroundResource(2130839583);
      }
      for (;;)
      {
        localbfxx.a.setPadding(j, i, k, m);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label232:
        if (paramInt == 0) {
          localbfxx.a.setBackgroundResource(2130839584);
        } else if (paramInt == this.a.jdField_a_of_type_ArrayOfJavaLangString.length - 1) {
          localbfxx.a.setBackgroundResource(2130839582);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxs
 * JD-Core Version:    0.7.0.1
 */