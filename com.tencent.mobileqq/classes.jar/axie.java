import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class axie
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private axih jdField_a_of_type_Axih;
  private List<InterestTagInfo> jdField_a_of_type_JavaUtilList;
  
  public axie(Context paramContext, int paramInt, List<InterestTagInfo> paramList, axih paramaxih)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Axih = paramaxih;
  }
  
  public InterestTagInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= paramInt)) {
      return null;
    }
    return (InterestTagInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<InterestTagInfo> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramBoolean) {
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    InterestTagItemView localInterestTagItemView;
    if (paramView == null)
    {
      localInterestTagItemView = new InterestTagItemView(this.jdField_a_of_type_AndroidContentContext);
      localInterestTagItemView.a(this.jdField_a_of_type_Int);
      localInterestTagItemView.setCallback(this.jdField_a_of_type_Axih);
    }
    for (;;)
    {
      localInterestTagItemView.a(a(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localInterestTagItemView;
      localInterestTagItemView = (InterestTagItemView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axie
 * JD-Core Version:    0.7.0.1
 */