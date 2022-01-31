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

public class bczp
  extends aims
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<TroopInfo> jdField_a_of_type_JavaUtilList;
  
  public bczp(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(bczq parambczq, TroopInfo paramTroopInfo)
  {
    parambczq.jdField_a_of_type_JavaLangString = paramTroopInfo.troopuin;
    parambczq.jdField_c_of_type_Int = 4;
    parambczq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    parambczq.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopInfo.getTroopName());
    if (paramTroopInfo.isThirdAppBind())
    {
      parambczq.b.setVisibility(0);
      parambczq.b.setText(ajya.a(2131701127));
    }
    for (;;)
    {
      parambczq.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramTroopInfo.troopuin));
      return;
      parambczq.b.setVisibility(8);
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
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559752, null);
      paramView = new bczq();
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368031));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378528));
      paramView.b = ((TextView)localView.findViewById(2131378537));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup, a(paramInt));
      return localView;
      paramViewGroup = (bczq)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bczp
 * JD-Core Version:    0.7.0.1
 */