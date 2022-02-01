import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bdxq
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected bdxy a;
  protected ArrayList<bdxy> a;
  
  public bdxq(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(bdxy parambdxy)
  {
    this.jdField_a_of_type_Bdxy = parambdxy;
    this.jdField_a_of_type_JavaUtilArrayList = parambdxy.jdField_a_of_type_JavaUtilArrayList;
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
    bdxy localbdxy = (bdxy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1 = new bdxr();
    Object localObject2;
    if (paramView != null)
    {
      localObject2 = (bdxr)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    for (;;)
    {
      paramView.a.setText(localbdxy.b);
      paramView.a.setTag(localbdxy);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        paramView.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560605, null);
      ((bdxr)localObject1).a = ((TextView)((View)localObject2).findViewById(2131378367));
      ((View)localObject2).setTag(localObject1);
      paramView = (View)localObject1;
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxq
 * JD-Core Version:    0.7.0.1
 */