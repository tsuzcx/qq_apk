import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.data.MessageForArkApp;
import java.util.ArrayList;
import java.util.List;

class anmf
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<annb> jdField_a_of_type_JavaUtilList;
  
  public anmf(anma paramanma, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public annb a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (annb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<annb> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
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
      paramViewGroup = new anmh(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844496);
      paramView = new ViewGroup.LayoutParams(MessageForArkApp.dp2px(50.0F), -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(MessageForArkApp.dp2px(28.0F), MessageForArkApp.dp2px(25.0F));
      paramView.addRule(13);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, paramView);
      paramView = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      annb localannb = a(paramInt);
      if ((localannb != null) && (!TextUtils.isEmpty(localannb.d))) {
        ArkAppCacheMgr.getAppIcon(localannb.a, new anmg(this, paramViewGroup));
      }
      return paramView;
      paramViewGroup = (anmh)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmf
 * JD-Core Version:    0.7.0.1
 */