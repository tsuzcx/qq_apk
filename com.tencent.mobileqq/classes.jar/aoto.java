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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class aoto
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<aouk> jdField_a_of_type_JavaUtilList;
  
  public aoto(aotj paramaotj, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public aouk a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (aouk)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<aouk> paramList)
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
    Object localObject1;
    if (paramView == null)
    {
      paramView = new aotq(this);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844784);
      localObject1 = new ViewGroup.LayoutParams(MessageForArkApp.dp2px(50.0F), -1);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localObject1 = new RelativeLayout.LayoutParams(MessageForArkApp.dp2px(28.0F), MessageForArkApp.dp2px(25.0F));
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = paramView.jdField_a_of_type_AndroidWidgetRelativeLayout;
      ((View)localObject1).setTag(paramView);
    }
    for (;;)
    {
      Object localObject2 = a(paramInt);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((aouk)localObject2).d))) {
        ArkAppCacheMgr.getAppIcon(((aouk)localObject2).a, new aotp(this, paramView));
      }
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = (aotq)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoto
 * JD-Core Version:    0.7.0.1
 */