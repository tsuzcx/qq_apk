import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.open.agent.BindGroupAdapter.1;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class beyr
  extends aked
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<TroopInfo> jdField_a_of_type_JavaUtilList;
  
  public beyr(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(beys parambeys, TroopInfo paramTroopInfo)
  {
    parambeys.jdField_a_of_type_JavaLangString = paramTroopInfo.troopuin;
    parambeys.jdField_c_of_type_Int = 4;
    parambeys.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    parambeys.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopInfo.getTroopName());
    if (paramTroopInfo.isThirdAppBind())
    {
      parambeys.b.setVisibility(0);
      parambeys.b.setText(alpo.a(2131701496));
    }
    for (;;)
    {
      parambeys.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramTroopInfo.troopuin));
      return;
      parambeys.b.setVisibility(8);
    }
  }
  
  public TroopInfo a(int paramInt)
  {
    return (TroopInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<TroopInfo> paramList)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (paramList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        notifyDataSetChanged();
      }
      return;
    }
    ThreadManager.getUIHandler().post(new BindGroupAdapter.1(this, paramList));
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
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559813, null);
      paramView = new beys();
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368169));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379140));
      paramView.b = ((TextView)localView.findViewById(2131379149));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup, a(paramInt));
      return localView;
      paramViewGroup = (beys)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyr
 * JD-Core Version:    0.7.0.1
 */