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

public class bgfb
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bgfa jdField_a_of_type_Bgfa;
  private List<bgfp> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bgfb(bgfa parambgfa, int paramInt)
  {
    this.jdField_a_of_type_Bgfa = parambgfa;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_Bgfa.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public bgfp a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (bgfp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<bgfp> paramList)
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
    bgfp localbgfp = a(paramInt);
    if (localbgfp != null) {
      return localbgfp.jdField_a_of_type_Int;
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
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559909, paramViewGroup, false);
        localObject1 = new bgfc();
        ((bgfc)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379409));
        ((bgfc)localObject1).b = ((ImageView)paramView.findViewById(2131379410));
        ((bgfc)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379411));
        paramView.setTag(localObject1);
        localObject2 = paramView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = (this.jdField_a_of_type_Int - 6);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (!this.jdField_a_of_type_Bgfa.c) {
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
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559910, paramViewGroup, false);
          localObject1 = new bgfc();
          ((bgfc)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379409));
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
      localObject1 = (bgfc)paramView.getTag();
    }
    label304:
    ((bgfc)localObject1).jdField_a_of_type_Bgfp = ((bgfp)localObject2);
    if (i == 0)
    {
      ((bgfc)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((bgfp)localObject2).jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Bgfa.c) {
        ((bgfc)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      }
    }
    if (this.jdField_a_of_type_Bgfa.c)
    {
      ((bgfc)localObject1).jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      label375:
      if (((bgfp)localObject2).jdField_a_of_type_Int != 1) {
        break label483;
      }
      ((bgfc)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Bgfa.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850808));
      bgil.a(((bgfc)localObject1).jdField_a_of_type_AndroidWidgetImageView);
      ((bgfc)localObject1).b.setVisibility(8);
      label425:
      if (AppSetting.c) {
        if (((bgfp)localObject2).jdField_a_of_type_JavaLangString == null) {
          break label580;
        }
      }
    }
    label567:
    label580:
    for (Object localObject1 = ((bgfp)localObject2).jdField_a_of_type_JavaLangString;; localObject1 = "")
    {
      paramView.setContentDescription((CharSequence)localObject1);
      paramView.setClickable(true);
      paramView.setOnClickListener(this);
      localObject1 = paramView;
      break;
      ((bgfc)localObject1).jdField_a_of_type_AndroidWidgetImageView.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
      break label375;
      label483:
      ((bgfc)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      Context localContext = this.jdField_a_of_type_Bgfa.jdField_a_of_type_AndroidContentContext;
      ImageView localImageView = ((bgfc)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      String str = ((bgfp)localObject2).jdField_b_of_type_JavaLangString;
      if (((bgfp)localObject2).e == 1) {}
      for (boolean bool = true;; bool = false)
      {
        bgil.a(localContext, localImageView, str, 24.0F, bool);
        if (((bgfp)localObject2).d == 0) {
          break label567;
        }
        ((bgfc)localObject1).b.setVisibility(0);
        break;
      }
      ((bgfc)localObject1).b.setVisibility(8);
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
        if ((localObject instanceof bgfc))
        {
          localObject = (bgfc)localObject;
          if (((bgfc)localObject).jdField_a_of_type_Bgfp != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppsGridViewBuilder", 2, "onItemClick appInfo:" + ((bgfc)localObject).jdField_a_of_type_Bgfp.toString());
            }
            if (((bgfc)localObject).jdField_a_of_type_Bgfp.jdField_a_of_type_Int != 1) {
              break;
            }
            bgil.a(1, this.jdField_a_of_type_Bgfa.jdField_a_of_type_Long, this.jdField_a_of_type_Bgfa.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgfa.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bgfa.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          }
        }
      }
    } while (((bgfc)localObject).jdField_a_of_type_Bgfp.jdField_a_of_type_Int != 0);
    bgil.a(this.jdField_a_of_type_Bgfa.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgfa.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bgfa.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Bgfa.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((bgfc)localObject).jdField_a_of_type_Bgfp.jdField_b_of_type_Long, ((bgfc)localObject).jdField_a_of_type_Bgfp.c, 1, ((bgfc)localObject).jdField_a_of_type_Bgfp.d);
    long l1 = this.jdField_a_of_type_Bgfa.jdField_a_of_type_Long;
    long l2 = this.jdField_a_of_type_Bgfa.jdField_b_of_type_Long;
    long l3 = ((bgfc)localObject).jdField_a_of_type_Bgfp.jdField_b_of_type_Long;
    int i = this.jdField_a_of_type_Bgfa.jdField_a_of_type_Int;
    if (((bgfc)localObject).jdField_a_of_type_Bgfp.jdField_a_of_type_Long == 0L) {}
    for (localObject = "1";; localObject = "2")
    {
      bdla.b(null, "dc00898", "", String.valueOf(l1), "0X800AD09", "0X800AD09", 0, 0, String.valueOf(l2), String.valueOf(l3), String.valueOf(i), (String)localObject);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfb
 * JD-Core Version:    0.7.0.1
 */