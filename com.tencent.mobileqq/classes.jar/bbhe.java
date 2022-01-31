import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class bbhe
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<bbhh> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public bbhe(Context paramContext, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public bbhh a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (bbhh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<bbhh> paramList)
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
    bbhh localbbhh = a(paramInt);
    if (localbbhh != null) {
      return localbbhh.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject1;
    if (paramView == null) {
      if (i == 0)
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559718, paramViewGroup, false);
        paramView = new bbhg();
        paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131378328));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378329));
        paramViewGroup.setTag(paramView);
        localObject1 = paramViewGroup.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = this.jdField_a_of_type_Int;
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (!this.jdField_a_of_type_Boolean) {
          break label212;
        }
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setCornerRadius(12.0F);
        ((GradientDrawable)localObject1).setColor(-14934754);
        paramViewGroup.setBackgroundDrawable((Drawable)localObject1);
      }
    }
    for (;;)
    {
      localObject1 = a(paramInt);
      if (localObject1 != null) {
        break label260;
      }
      QLog.e("TroopAppShortcutContainer", 2, "getItem() == null position:" + paramInt);
      return paramViewGroup;
      if (i == 1)
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559719, paramViewGroup, false);
        paramView = new bbhg();
        paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131378328));
        paramViewGroup.setTag(paramView);
        break;
      }
      return null;
      label212:
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(12.0F);
      ((GradientDrawable)localObject1).setColor(-1);
      paramViewGroup.setBackgroundDrawable((Drawable)localObject1);
      continue;
      localObject1 = (bbhg)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    label260:
    paramView.jdField_a_of_type_Bbhh = ((bbhh)localObject1);
    if (i == 0)
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((bbhh)localObject1).jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Boolean) {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      }
    }
    if (((bbhh)localObject1).jdField_a_of_type_Int == 1)
    {
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850131));
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(new bbhf(this));
      label345:
      if (!AppSetting.c) {
        break label489;
      }
      if (((bbhh)localObject1).jdField_a_of_type_JavaLangString == null) {
        break label491;
      }
    }
    label469:
    label489:
    label491:
    for (paramView = ((bbhh)localObject1).jdField_a_of_type_JavaLangString;; paramView = "")
    {
      for (;;)
      {
        paramViewGroup.setContentDescription(paramView);
        return paramViewGroup;
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(null);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843303);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = bayu.a;
        if (((bbhh)localObject1).b == null) {
          break label469;
        }
        try
        {
          localObject2 = URLDrawable.getDrawable(((bbhh)localObject1).b, (URLDrawable.URLDrawableOptions)localObject2);
          if (((URLDrawable)localObject2).getStatus() == 2) {
            ((URLDrawable)localObject2).restartDownload();
          }
          paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
        }
        catch (Exception paramView)
        {
          QLog.e("TroopAppShortcutContainer", 1, "fetchDrawable: failed. ", paramView);
        }
      }
      break label345;
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843303));
      break label345;
      break;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhe
 * JD-Core Version:    0.7.0.1
 */