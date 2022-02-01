import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bfmt
  extends BaseAdapter
{
  public static final String a;
  public static final String b = anzj.a(2131700378);
  protected Context a;
  protected LayoutInflater a;
  protected QQAppInterface a;
  protected NewTroopCateView a;
  protected ArrayList<bfoo> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = anzj.a(2131700377);
  }
  
  public bfmt(NewTroopCateView paramNewTroopCateView, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramNewTroopCateView.a;
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView = paramNewTroopCateView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(ArrayList<bfoo> paramArrayList)
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
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560593, null);
      paramView = new bfmw(this, localView);
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.a((bfoo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      bfmw localbfmw = (bfmw)paramView.getTag();
      localView = paramView;
      paramView = localbfmw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmt
 * JD-Core Version:    0.7.0.1
 */