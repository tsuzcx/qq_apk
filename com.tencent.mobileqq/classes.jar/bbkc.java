import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class bbkc
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected bbkk a;
  protected ArrayList<bbkk> a;
  
  public bbkc(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(bbkk parambbkk)
  {
    this.jdField_a_of_type_Bbkk = parambbkk;
    this.jdField_a_of_type_JavaUtilArrayList = parambbkk.jdField_a_of_type_JavaUtilArrayList;
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
    bbkk localbbkk = (bbkk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    bbkd localbbkd = new bbkd();
    if (paramView != null)
    {
      localbbkd = (bbkd)paramView.getTag();
      paramViewGroup = paramView;
    }
    for (paramView = localbbkd;; paramView = localbbkd)
    {
      paramView.a.setText(localbbkk.b);
      paramView.a.setTag(localbbkk);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        paramView.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      return paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560426, null);
      localbbkd.a = ((TextView)paramViewGroup.findViewById(2131377552));
      paramViewGroup.setTag(localbbkd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkc
 * JD-Core Version:    0.7.0.1
 */