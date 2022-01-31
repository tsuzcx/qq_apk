import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class azlt
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected azmb a;
  protected ArrayList<azmb> a;
  
  public azlt(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(azmb paramazmb)
  {
    this.jdField_a_of_type_Azmb = paramazmb;
    this.jdField_a_of_type_JavaUtilArrayList = paramazmb.jdField_a_of_type_JavaUtilArrayList;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    azmb localazmb = (azmb)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    azlu localazlu = new azlu();
    if (paramView != null)
    {
      localazlu = (azlu)paramView.getTag();
      paramViewGroup = paramView;
    }
    for (paramView = localazlu;; paramView = localazlu)
    {
      paramView.a.setText(localazmb.b);
      paramView.a.setTag(localazmb);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        paramView.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      return paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560318, null);
      localazlu.a = ((TextView)paramViewGroup.findViewById(2131377032));
      paramViewGroup.setTag(localazlu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azlt
 * JD-Core Version:    0.7.0.1
 */