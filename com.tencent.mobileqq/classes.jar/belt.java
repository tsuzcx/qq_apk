import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class belt
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 1;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private int b;
  
  public belt(BaseAdapter paramBaseAdapter, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    if (paramInt > 0) {}
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.registerDataSetObserver(new belu(this));
      }
      return;
      paramInt = 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter;
  }
  
  public void a(int paramInt)
  {
    int i = b();
    if (paramInt < 0)
    {
      this.b = 0;
      return;
    }
    if (paramInt >= i)
    {
      this.b = (i - 1);
      return;
    }
    this.b = paramInt;
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount();
    int j = i / this.jdField_a_of_type_Int;
    if (i % this.jdField_a_of_type_Int != 0) {}
    for (i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount();
    if ((this.b + 1) * this.jdField_a_of_type_Int > i) {
      return i % this.jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItem(this.b * this.jdField_a_of_type_Int + paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItemId(this.b * this.jdField_a_of_type_Int + paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getView(this.b * this.jdField_a_of_type_Int + paramInt, paramView, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     belt
 * JD-Core Version:    0.7.0.1
 */