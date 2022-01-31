import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class azlr
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected azlz a;
  protected ArrayList<azlz> a;
  
  public azlr(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(azlz paramazlz)
  {
    this.jdField_a_of_type_Azlz = paramazlz;
    this.jdField_a_of_type_JavaUtilArrayList = paramazlz.jdField_a_of_type_JavaUtilArrayList;
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
    azlz localazlz = (azlz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    azls localazls = new azls();
    if (paramView != null)
    {
      localazls = (azls)paramView.getTag();
      paramViewGroup = paramView;
    }
    for (paramView = localazls;; paramView = localazls)
    {
      paramView.a.setText(localazlz.b);
      paramView.a.setTag(localazlz);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        paramView.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      return paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560318, null);
      localazls.a = ((TextView)paramViewGroup.findViewById(2131377030));
      paramViewGroup.setTag(localazls);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azlr
 * JD-Core Version:    0.7.0.1
 */