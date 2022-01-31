import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import java.util.ArrayList;

public class ayjo
  extends BaseAdapter
{
  public static final String a;
  public static final String b = ajjy.a(2131635671);
  protected Context a;
  protected LayoutInflater a;
  protected QQAppInterface a;
  protected NewTroopCateView a;
  protected ArrayList<aylj> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajjy.a(2131635670);
  }
  
  public ayjo(NewTroopCateView paramNewTroopCateView, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramNewTroopCateView.a;
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView = paramNewTroopCateView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(ArrayList<aylj> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
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
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131494744, null);
      paramView = new ayjr(this, localView);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a((aylj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      return localView;
      paramViewGroup = (ayjr)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayjo
 * JD-Core Version:    0.7.0.1
 */