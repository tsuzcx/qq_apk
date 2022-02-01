import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.utils.NumberWheelView;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.VerticalGallery.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class anxc
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 36;
  private Context jdField_a_of_type_AndroidContentContext;
  public List<Integer> a;
  
  public anxc(NumberWheelView paramNumberWheelView, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)TypedValue.applyDimension(1, paramInt1, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
    a(paramInt2, paramInt3);
  }
  
  public View a(int paramInt)
  {
    return getView(paramInt, null, null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    while (paramInt1 <= paramInt2)
    {
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt1));
      paramInt1 += 1;
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new WheelTextView(this.jdField_a_of_type_AndroidContentContext);
      ((View)localObject1).setLayoutParams(new VerticalGallery.LayoutParams(-1, this.jdField_a_of_type_Int));
    }
    for (paramView = (WheelTextView)localObject1;; paramView = (View)localObject2)
    {
      localObject2 = paramView;
      if (paramView == null) {
        localObject2 = (WheelTextView)localObject1;
      }
      paramView = String.format("%d", new Object[] { this.jdField_a_of_type_JavaUtilList.get(paramInt) });
      ((WheelTextView)localObject2).setTextSize(18.0F);
      ((WheelTextView)localObject2).setTextColor(-7829368);
      ((WheelTextView)localObject2).setGravity(5);
      ((WheelTextView)localObject2).setVisibility(0);
      ((WheelTextView)localObject2).setText(paramView);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxc
 * JD-Core Version:    0.7.0.1
 */