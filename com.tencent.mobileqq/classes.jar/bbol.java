import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class bbol
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected bbot a;
  protected ArrayList<bbot> a;
  
  public bbol(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(bbot parambbot)
  {
    this.jdField_a_of_type_Bbot = parambbot;
    this.jdField_a_of_type_JavaUtilArrayList = parambbot.jdField_a_of_type_JavaUtilArrayList;
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
    bbot localbbot = (bbot)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    bbom localbbom = new bbom();
    if (paramView != null)
    {
      localbbom = (bbom)paramView.getTag();
      paramViewGroup = paramView;
    }
    for (paramView = localbbom;; paramView = localbbom)
    {
      paramView.a.setText(localbbot.b);
      paramView.a.setTag(localbbot);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        paramView.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      return paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560425, null);
      localbbom.a = ((TextView)paramViewGroup.findViewById(2131377606));
      paramViewGroup.setTag(localbbom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbol
 * JD-Core Version:    0.7.0.1
 */