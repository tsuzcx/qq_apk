import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView;
import java.util.List;

public class atfn
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private atfq jdField_a_of_type_Atfq;
  private List<InterestTagInfo> jdField_a_of_type_JavaUtilList;
  
  public atfn(Context paramContext, int paramInt, List<InterestTagInfo> paramList, atfq paramatfq)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Atfq = paramatfq;
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
      paramView.setCallback(this.jdField_a_of_type_Atfq);
    }
    for (;;)
    {
      paramView.a(a(paramInt));
      return paramView;
      paramView = (InterestTagItemView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atfn
 * JD-Core Version:    0.7.0.1
 */