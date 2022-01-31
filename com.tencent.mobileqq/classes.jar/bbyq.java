import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import java.util.ArrayList;
import java.util.List;

public class bbyq
  extends BaseAdapter
{
  protected SearchReciteArticleFragment a;
  protected String a;
  protected List<bbyp> a;
  
  public bbyq(SearchReciteArticleFragment paramSearchReciteArticleFragment)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment = paramSearchReciteArticleFragment;
  }
  
  public bbyp a(int paramInt)
  {
    return (bbyp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(bbyp parambbyp)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambbyp);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
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
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560475, null, false);
      paramViewGroup = new bbyr(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378985));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131378668));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      bbyp localbbyp = a(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(SearchReciteArticleFragment.a(this.jdField_a_of_type_JavaLangString, localbbyp.jdField_a_of_type_JavaLangString, Color.parseColor("#00B6F9")));
      paramViewGroup.b.setText(localbbyp.b);
      return paramView;
      paramViewGroup = (bbyr)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyq
 * JD-Core Version:    0.7.0.1
 */