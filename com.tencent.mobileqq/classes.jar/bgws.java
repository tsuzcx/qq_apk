import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.ColorSelectView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bgws
  extends BaseAdapter
{
  public static final int[] a;
  public int a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0, -16777216, -51904, -41579, -2992688, -15808515, -16268201, -12464 };
  }
  
  public bgws()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return jdField_a_of_type_ArrayOfInt.length;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(jdField_a_of_type_ArrayOfInt[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561928, paramViewGroup, false);
    }
    for (;;)
    {
      ColorSelectView localColorSelectView = (ColorSelectView)paramView.findViewById(2131364665);
      ImageView localImageView = (ImageView)paramView.findViewById(2131364663);
      if (paramInt == 0)
      {
        localColorSelectView.setVisibility(8);
        localImageView.setVisibility(0);
        if (this.jdField_a_of_type_Int == paramInt) {}
        for (int i = 2130847059;; i = 2130847058)
        {
          localImageView.setImageResource(i);
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
        }
      }
      localColorSelectView.setVisibility(0);
      localImageView.setVisibility(8);
      localColorSelectView.setColor(jdField_a_of_type_ArrayOfInt[paramInt]);
      if (this.jdField_a_of_type_Int == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localColorSelectView.setSelect(bool);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgws
 * JD-Core Version:    0.7.0.1
 */