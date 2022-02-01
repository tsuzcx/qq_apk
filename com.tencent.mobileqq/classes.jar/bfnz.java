import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class bfnz
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bfny jdField_a_of_type_Bfny;
  private List<bfoo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bfnz(bfny parambfny, int paramInt)
  {
    this.jdField_a_of_type_Bfny = parambfny;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_Bfny.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public bfoo a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (bfoo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<bfoo> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    bfoo localbfoo = a(paramInt);
    if (localbfoo != null) {
      return localbfoo.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject2;
    if (paramView == null) {
      if (i == 0)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559857, paramViewGroup, false);
        localObject1 = new bfoa();
        ((bfoa)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379180));
        ((bfoa)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379181));
        paramView.setTag(localObject1);
        localObject2 = paramView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = (this.jdField_a_of_type_Int - 6);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (!this.jdField_a_of_type_Bfny.c) {
          break label247;
        }
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setCornerRadius(16.0F);
        ((GradientDrawable)localObject2).setColor(-14934754);
        paramView.setBackgroundDrawable((Drawable)localObject2);
      }
    }
    for (;;)
    {
      localObject2 = a(paramInt);
      if (localObject2 != null) {
        break label290;
      }
      QLog.e("AppsGridViewBuilder", 2, "getItem() == null position:" + paramInt);
      for (localObject1 = paramView;; localObject1 = null)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
        if (i == 1)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559858, paramViewGroup, false);
          localObject1 = new bfoa();
          ((bfoa)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379180));
          paramView.setTag(localObject1);
          break;
        }
      }
      label247:
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(16.0F);
      ((GradientDrawable)localObject2).setColor(-1);
      paramView.setBackgroundDrawable((Drawable)localObject2);
      continue;
      localObject1 = (bfoa)paramView.getTag();
    }
    label290:
    ((bfoa)localObject1).jdField_a_of_type_Bfoo = ((bfoo)localObject2);
    if (i == 0)
    {
      ((bfoa)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((bfoo)localObject2).jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Bfny.c) {
        ((bfoa)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      }
    }
    if (this.jdField_a_of_type_Bfny.c)
    {
      ((bfoa)localObject1).jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      label361:
      if (((bfoo)localObject2).jdField_a_of_type_Int != 1) {
        break label459;
      }
      ((bfoa)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Bfny.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850725));
      bfqq.a(((bfoa)localObject1).jdField_a_of_type_AndroidWidgetImageView);
      if (AppSetting.c) {
        if (((bfoo)localObject2).jdField_a_of_type_JavaLangString == null) {
          break label526;
        }
      }
    }
    label526:
    for (Object localObject1 = ((bfoo)localObject2).jdField_a_of_type_JavaLangString;; localObject1 = "")
    {
      paramView.setContentDescription((CharSequence)localObject1);
      paramView.setClickable(true);
      paramView.setOnClickListener(this);
      localObject1 = paramView;
      break;
      ((bfoa)localObject1).jdField_a_of_type_AndroidWidgetImageView.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
      break label361;
      label459:
      ((bfoa)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      Context localContext = this.jdField_a_of_type_Bfny.jdField_a_of_type_AndroidContentContext;
      localObject1 = ((bfoa)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      String str = ((bfoo)localObject2).jdField_b_of_type_JavaLangString;
      if (((bfoo)localObject2).d == 1) {}
      for (boolean bool = true;; bool = false)
      {
        bfqq.a(localContext, (ImageView)localObject1, str, 24.0F, bool);
        break;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject == null) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((localObject instanceof bfoa))
        {
          localObject = (bfoa)localObject;
          if (((bfoa)localObject).jdField_a_of_type_Bfoo != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppsGridViewBuilder", 2, "onItemClick appInfo:" + ((bfoa)localObject).jdField_a_of_type_Bfoo.toString());
            }
            if (((bfoa)localObject).jdField_a_of_type_Bfoo.jdField_a_of_type_Int != 1) {
              break;
            }
            bfqq.a(1, this.jdField_a_of_type_Bfny.jdField_a_of_type_Long, this.jdField_a_of_type_Bfny.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfny.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfny.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          }
        }
      }
    } while (((bfoa)localObject).jdField_a_of_type_Bfoo.jdField_a_of_type_Int != 0);
    bfqq.a(this.jdField_a_of_type_Bfny.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfny.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfny.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Bfny.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((bfoa)localObject).jdField_a_of_type_Bfoo.jdField_b_of_type_Long, ((bfoa)localObject).jdField_a_of_type_Bfoo.c, 1, 0);
    long l1 = this.jdField_a_of_type_Bfny.jdField_a_of_type_Long;
    long l2 = this.jdField_a_of_type_Bfny.jdField_b_of_type_Long;
    long l3 = ((bfoa)localObject).jdField_a_of_type_Bfoo.jdField_b_of_type_Long;
    int i = this.jdField_a_of_type_Bfny.jdField_a_of_type_Int;
    if (((bfoa)localObject).jdField_a_of_type_Bfoo.jdField_a_of_type_Long == 0L) {}
    for (localObject = "1";; localObject = "2")
    {
      bcst.b(null, "dc00898", "", String.valueOf(l1), "0X800AD09", "0X800AD09", 0, 0, String.valueOf(l2), String.valueOf(l3), String.valueOf(i), (String)localObject);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnz
 * JD-Core Version:    0.7.0.1
 */