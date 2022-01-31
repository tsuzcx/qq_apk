import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import java.util.ArrayList;

public class azkg
  extends BaseAdapter
{
  public static final String a;
  public static final String b = ajya.a(2131701466);
  protected Context a;
  protected LayoutInflater a;
  protected QQAppInterface a;
  protected NewTroopCateView a;
  protected ArrayList<azmb> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131701465);
  }
  
  public azkg(NewTroopCateView paramNewTroopCateView, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramNewTroopCateView.a;
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView = paramNewTroopCateView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(ArrayList<azmb> paramArrayList)
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
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560316, null);
      paramView = new azkj(this, localView);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a((azmb)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      return localView;
      paramViewGroup = (azkj)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azkg
 * JD-Core Version:    0.7.0.1
 */