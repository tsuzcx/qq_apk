import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView;
import java.util.List;

public class auwm
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private auwp jdField_a_of_type_Auwp;
  private List<InterestTagInfo> jdField_a_of_type_JavaUtilList;
  
  public auwm(Context paramContext, int paramInt, List<InterestTagInfo> paramList, auwp paramauwp)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Auwp = paramauwp;
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
    if (paramView == null)
    {
      paramView = new InterestTagItemView(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(this.jdField_a_of_type_Int);
      paramView.setCallback(this.jdField_a_of_type_Auwp);
    }
    for (;;)
    {
      paramView.a(a(paramInt));
      return paramView;
      paramView = (InterestTagItemView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auwm
 * JD-Core Version:    0.7.0.1
 */