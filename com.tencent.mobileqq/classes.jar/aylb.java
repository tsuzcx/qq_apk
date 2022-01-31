import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class aylb
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected aylj a;
  protected ArrayList<aylj> a;
  
  public aylb(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(aylj paramaylj)
  {
    this.jdField_a_of_type_Aylj = paramaylj;
    this.jdField_a_of_type_JavaUtilArrayList = paramaylj.jdField_a_of_type_JavaUtilArrayList;
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
    aylj localaylj = (aylj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    aylc localaylc = new aylc();
    if (paramView != null)
    {
      localaylc = (aylc)paramView.getTag();
      paramViewGroup = paramView;
    }
    for (paramView = localaylc;; paramView = localaylc)
    {
      paramView.a.setText(localaylj.b);
      paramView.a.setTag(localaylj);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        paramView.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      return paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131494746, null);
      localaylc.a = ((TextView)paramViewGroup.findViewById(2131311220));
      paramViewGroup.setTag(localaylc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aylb
 * JD-Core Version:    0.7.0.1
 */