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

public class bexp
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bexo jdField_a_of_type_Bexo;
  private List<beyd> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bexp(bexo parambexo, int paramInt)
  {
    this.jdField_a_of_type_Bexo = parambexo;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_Bexo.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public beyd a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (beyd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<beyd> paramList)
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
    beyd localbeyd = a(paramInt);
    if (localbeyd != null) {
      return localbeyd.jdField_a_of_type_Int;
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
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559865, paramViewGroup, false);
        localObject1 = new bexq();
        ((bexq)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379114));
        ((bexq)localObject1).b = ((ImageView)paramView.findViewById(2131379115));
        ((bexq)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379116));
        paramView.setTag(localObject1);
        localObject2 = paramView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = (this.jdField_a_of_type_Int - 6);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (!this.jdField_a_of_type_Bexo.c) {
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
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559866, paramViewGroup, false);
          localObject1 = new bexq();
          ((bexq)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379114));
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
      localObject1 = (bexq)paramView.getTag();
    }
    label304:
    ((bexq)localObject1).jdField_a_of_type_Beyd = ((beyd)localObject2);
    if (i == 0)
    {
      ((bexq)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((beyd)localObject2).jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Bexo.c) {
        ((bexq)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      }
    }
    if (this.jdField_a_of_type_Bexo.c)
    {
      ((bexq)localObject1).jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      label375:
      if (((beyd)localObject2).jdField_a_of_type_Int != 1) {
        break label483;
      }
      ((bexq)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Bexo.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850672));
      bfaf.a(((bexq)localObject1).jdField_a_of_type_AndroidWidgetImageView);
      ((bexq)localObject1).b.setVisibility(8);
      label425:
      if (AppSetting.c) {
        if (((beyd)localObject2).jdField_a_of_type_JavaLangString == null) {
          break label580;
        }
      }
    }
    label567:
    label580:
    for (Object localObject1 = ((beyd)localObject2).jdField_a_of_type_JavaLangString;; localObject1 = "")
    {
      paramView.setContentDescription((CharSequence)localObject1);
      paramView.setClickable(true);
      paramView.setOnClickListener(this);
      localObject1 = paramView;
      break;
      ((bexq)localObject1).jdField_a_of_type_AndroidWidgetImageView.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
      break label375;
      label483:
      ((bexq)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      Context localContext = this.jdField_a_of_type_Bexo.jdField_a_of_type_AndroidContentContext;
      ImageView localImageView = ((bexq)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      String str = ((beyd)localObject2).jdField_b_of_type_JavaLangString;
      if (((beyd)localObject2).e == 1) {}
      for (boolean bool = true;; bool = false)
      {
        bfaf.a(localContext, localImageView, str, 24.0F, bool);
        if (((beyd)localObject2).d == 0) {
          break label567;
        }
        ((bexq)localObject1).b.setVisibility(0);
        break;
      }
      ((bexq)localObject1).b.setVisibility(8);
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
        if ((localObject instanceof bexq))
        {
          localObject = (bexq)localObject;
          if (((bexq)localObject).jdField_a_of_type_Beyd != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppsGridViewBuilder", 2, "onItemClick appInfo:" + ((bexq)localObject).jdField_a_of_type_Beyd.toString());
            }
            if (((bexq)localObject).jdField_a_of_type_Beyd.jdField_a_of_type_Int != 1) {
              break;
            }
            bfaf.a(1, this.jdField_a_of_type_Bexo.jdField_a_of_type_Long, this.jdField_a_of_type_Bexo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bexo.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bexo.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          }
        }
      }
    } while (((bexq)localObject).jdField_a_of_type_Beyd.jdField_a_of_type_Int != 0);
    bfaf.a(this.jdField_a_of_type_Bexo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bexo.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bexo.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Bexo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((bexq)localObject).jdField_a_of_type_Beyd.jdField_b_of_type_Long, ((bexq)localObject).jdField_a_of_type_Beyd.c, 1, ((bexq)localObject).jdField_a_of_type_Beyd.d);
    long l1 = this.jdField_a_of_type_Bexo.jdField_a_of_type_Long;
    long l2 = this.jdField_a_of_type_Bexo.jdField_b_of_type_Long;
    long l3 = ((bexq)localObject).jdField_a_of_type_Beyd.jdField_b_of_type_Long;
    int i = this.jdField_a_of_type_Bexo.jdField_a_of_type_Int;
    if (((bexq)localObject).jdField_a_of_type_Beyd.jdField_a_of_type_Long == 0L) {}
    for (localObject = "1";; localObject = "2")
    {
      bcef.b(null, "dc00898", "", String.valueOf(l1), "0X800AD09", "0X800AD09", 0, 0, String.valueOf(l2), String.valueOf(l3), String.valueOf(i), (String)localObject);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexp
 * JD-Core Version:    0.7.0.1
 */