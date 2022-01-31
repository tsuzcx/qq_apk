import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.ColorSelectView;

public class bbop
  extends BaseAdapter
{
  public static final int[] a;
  public int a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0, -16777216, -51904, -41579, -2992688, -15808515, -16268201, -12464 };
  }
  
  public bbop()
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
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561483, paramViewGroup, false);
    }
    paramView = (ColorSelectView)localView.findViewById(2131364386);
    paramViewGroup = (ImageView)localView.findViewById(2131364384);
    if (paramInt == 0)
    {
      paramView.setVisibility(8);
      paramViewGroup.setVisibility(0);
      if (this.jdField_a_of_type_Int == paramInt) {}
      for (paramInt = 2130846165;; paramInt = 2130846164)
      {
        paramViewGroup.setImageResource(paramInt);
        return localView;
      }
    }
    paramView.setVisibility(0);
    paramViewGroup.setVisibility(8);
    paramView.setColor(jdField_a_of_type_ArrayOfInt[paramInt]);
    if (this.jdField_a_of_type_Int == paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setSelect(bool);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbop
 * JD-Core Version:    0.7.0.1
 */