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

public class bgoa
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bgnz jdField_a_of_type_Bgnz;
  private List<bgop> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bgoa(bgnz parambgnz, int paramInt)
  {
    this.jdField_a_of_type_Bgnz = parambgnz;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_Bgnz.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public bgop a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (bgop)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<bgop> paramList)
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
    bgop localbgop = a(paramInt);
    if (localbgop != null) {
      return localbgop.jdField_a_of_type_Int;
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
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559863, paramViewGroup, false);
        localObject1 = new bgob();
        ((bgob)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379344));
        ((bgob)localObject1).b = ((ImageView)paramView.findViewById(2131379345));
        ((bgob)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379346));
        paramView.setTag(localObject1);
        localObject2 = paramView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = (this.jdField_a_of_type_Int - 6);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (!this.jdField_a_of_type_Bgnz.c) {
          break label261;
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
        break label304;
      }
      QLog.e("AppsGridViewBuilder", 2, "getItem() == null position:" + paramInt);
      for (localObject1 = paramView;; localObject1 = null)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
        if (i == 1)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559864, paramViewGroup, false);
          localObject1 = new bgob();
          ((bgob)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379344));
          paramView.setTag(localObject1);
          break;
        }
      }
      label261:
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(16.0F);
      ((GradientDrawable)localObject2).setColor(-1);
      paramView.setBackgroundDrawable((Drawable)localObject2);
      continue;
      localObject1 = (bgob)paramView.getTag();
    }
    label304:
    ((bgob)localObject1).jdField_a_of_type_Bgop = ((bgop)localObject2);
    if (i == 0)
    {
      ((bgob)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((bgop)localObject2).jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Bgnz.c) {
        ((bgob)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      }
    }
    if (this.jdField_a_of_type_Bgnz.c)
    {
      ((bgob)localObject1).jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      label375:
      if (((bgop)localObject2).jdField_a_of_type_Int != 1) {
        break label483;
      }
      ((bgob)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Bgnz.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850744));
      bgqr.a(((bgob)localObject1).jdField_a_of_type_AndroidWidgetImageView);
      ((bgob)localObject1).b.setVisibility(8);
      label425:
      if (AppSetting.c) {
        if (((bgop)localObject2).jdField_a_of_type_JavaLangString == null) {
          break label580;
        }
      }
    }
    label567:
    label580:
    for (Object localObject1 = ((bgop)localObject2).jdField_a_of_type_JavaLangString;; localObject1 = "")
    {
      paramView.setContentDescription((CharSequence)localObject1);
      paramView.setClickable(true);
      paramView.setOnClickListener(this);
      localObject1 = paramView;
      break;
      ((bgob)localObject1).jdField_a_of_type_AndroidWidgetImageView.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
      break label375;
      label483:
      ((bgob)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      Context localContext = this.jdField_a_of_type_Bgnz.jdField_a_of_type_AndroidContentContext;
      ImageView localImageView = ((bgob)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      String str = ((bgop)localObject2).jdField_b_of_type_JavaLangString;
      if (((bgop)localObject2).e == 1) {}
      for (boolean bool = true;; bool = false)
      {
        bgqr.a(localContext, localImageView, str, 24.0F, bool);
        if (((bgop)localObject2).d == 0) {
          break label567;
        }
        ((bgob)localObject1).b.setVisibility(0);
        break;
      }
      ((bgob)localObject1).b.setVisibility(8);
      break label425;
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
        if ((localObject instanceof bgob))
        {
          localObject = (bgob)localObject;
          if (((bgob)localObject).jdField_a_of_type_Bgop != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppsGridViewBuilder", 2, "onItemClick appInfo:" + ((bgob)localObject).jdField_a_of_type_Bgop.toString());
            }
            if (((bgob)localObject).jdField_a_of_type_Bgop.jdField_a_of_type_Int != 1) {
              break;
            }
            bgqr.a(1, this.jdField_a_of_type_Bgnz.jdField_a_of_type_Long, this.jdField_a_of_type_Bgnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgnz.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bgnz.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          }
        }
      }
    } while (((bgob)localObject).jdField_a_of_type_Bgop.jdField_a_of_type_Int != 0);
    bgqr.a(this.jdField_a_of_type_Bgnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgnz.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bgnz.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Bgnz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((bgob)localObject).jdField_a_of_type_Bgop.jdField_b_of_type_Long, ((bgob)localObject).jdField_a_of_type_Bgop.c, 1, ((bgob)localObject).jdField_a_of_type_Bgop.d);
    long l1 = this.jdField_a_of_type_Bgnz.jdField_a_of_type_Long;
    long l2 = this.jdField_a_of_type_Bgnz.jdField_b_of_type_Long;
    long l3 = ((bgob)localObject).jdField_a_of_type_Bgop.jdField_b_of_type_Long;
    int i = this.jdField_a_of_type_Bgnz.jdField_a_of_type_Int;
    if (((bgob)localObject).jdField_a_of_type_Bgop.jdField_a_of_type_Long == 0L) {}
    for (localObject = "1";; localObject = "2")
    {
      bdll.b(null, "dc00898", "", String.valueOf(l1), "0X800AD09", "0X800AD09", 0, 0, String.valueOf(l2), String.valueOf(l3), String.valueOf(i), (String)localObject);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgoa
 * JD-Core Version:    0.7.0.1
 */