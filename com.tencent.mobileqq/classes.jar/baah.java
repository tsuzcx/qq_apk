import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import java.util.ArrayList;
import java.util.List;

public class baah
  extends BaseAdapter
{
  protected SearchReciteArticleFragment a;
  protected String a;
  protected List<baag> a;
  
  public baah(SearchReciteArticleFragment paramSearchReciteArticleFragment)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment = paramSearchReciteArticleFragment;
  }
  
  public baag a(int paramInt)
  {
    return (baag)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(baag parambaag)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambaag);
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
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560367, null, false);
      paramViewGroup = new baai(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378383));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131378112));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      baag localbaag = a(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(SearchReciteArticleFragment.a(this.jdField_a_of_type_JavaLangString, localbaag.jdField_a_of_type_JavaLangString, Color.parseColor("#00B6F9")));
      paramViewGroup.b.setText(localbaag.b);
      return paramView;
      paramViewGroup = (baai)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baah
 * JD-Core Version:    0.7.0.1
 */