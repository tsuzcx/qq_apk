import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bbzi
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  public bbzk a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  
  public bbzi(ArrayList<String> paramArrayList, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramContext;
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface;
    Object localObject;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = localObject;
  }
  
  public void a(bbzk parambbzk)
  {
    this.jdField_a_of_type_Bbzk = parambbzk;
  }
  
  public void a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    paramView = new bbzj(this);
    paramView.jdField_a_of_type_Int = paramInt;
    paramView.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    View localView1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561526, paramViewGroup, false);
    if (blqj.a()) {
      localView1.setAlpha(0.4F);
    }
    TextView localTextView = (TextView)localView1.findViewById(2131368059);
    localTextView.setText((CharSequence)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    View localView2 = localView1.findViewById(2131365373);
    if (this.jdField_a_of_type_Boolean)
    {
      localTextView.setClickable(false);
      localView2.setVisibility(0);
      localView2.setOnClickListener(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView1, paramViewGroup, getItemId(paramInt));
      return localView1;
      localTextView.setClickable(true);
      localView2.setVisibility(8);
      localTextView.setOnClickListener(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzi
 * JD-Core Version:    0.7.0.1
 */