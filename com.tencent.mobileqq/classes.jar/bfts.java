import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class bfts
  extends BaseAdapter
{
  protected SearchReciteArticleFragment a;
  protected String a;
  protected List<bftr> a;
  
  public bfts(SearchReciteArticleFragment paramSearchReciteArticleFragment)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment = paramSearchReciteArticleFragment;
  }
  
  public bftr a(int paramInt)
  {
    return (bftr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(bftr parambftr)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambftr);
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
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560707, null, false);
      paramView = new bftt(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380210));
      paramView.b = ((TextView)localView.findViewById(2131379855));
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_Int = paramInt;
      Object localObject = a(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(SearchReciteArticleFragment.a(this.jdField_a_of_type_JavaLangString, ((bftr)localObject).jdField_a_of_type_JavaLangString, Color.parseColor("#00B6F9")));
      paramView.b.setText(((bftr)localObject).b);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (bftt)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfts
 * JD-Core Version:    0.7.0.1
 */