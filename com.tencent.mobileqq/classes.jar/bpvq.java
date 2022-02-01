import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class bpvq
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<zhp> jdField_a_of_type_JavaUtilList = new ArrayList();
  @Nullable
  private zhp jdField_a_of_type_Zhp;
  
  public bpvq(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @Nullable
  public zhp a()
  {
    return this.jdField_a_of_type_Zhp;
  }
  
  public void a(List<zhp> paramList)
  {
    if (paramList == null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nullable zhp paramzhp)
  {
    this.jdField_a_of_type_Zhp = paramzhp;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561822, null);
      localObject = new bpvr(paramView);
      paramView.setTag(localObject);
    }
    for (;;)
    {
      ((bpvr)localObject).a((zhp)this.jdField_a_of_type_JavaUtilList.get(paramInt), this.jdField_a_of_type_Zhp);
      localObject = ((bpvr)localObject).a;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = (bpvr)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpvq
 * JD-Core Version:    0.7.0.1
 */