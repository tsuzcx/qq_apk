import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import java.util.ArrayList;
import java.util.List;

public class ayzb
  extends BaseAdapter
{
  protected SearchReciteArticleFragment a;
  protected String a;
  protected List<ayza> a;
  
  public ayzb(SearchReciteArticleFragment paramSearchReciteArticleFragment)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment = paramSearchReciteArticleFragment;
  }
  
  public ayza a(int paramInt)
  {
    return (ayza)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(ayza paramayza)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramayza);
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
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494795, null, false);
      paramViewGroup = new ayzc(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312553));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131312289));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      ayza localayza = a(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(SearchReciteArticleFragment.a(this.jdField_a_of_type_JavaLangString, localayza.jdField_a_of_type_JavaLangString, Color.parseColor("#00B6F9")));
      paramViewGroup.b.setText(localayza.b);
      return paramView;
      paramViewGroup = (ayzc)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayzb
 * JD-Core Version:    0.7.0.1
 */