import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class apic
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private apid jdField_a_of_type_Apid;
  private List<aphw> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public apic(Context paramContext, List<aphw> paramList, apid paramapid)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Apid = paramapid;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838703);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localObject = paramImageView.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = ((ViewGroup.LayoutParams)localObject).height;
    localURLDrawableOptions.mRequestWidth = ((ViewGroup.LayoutParams)localObject).width;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(bfol.b(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height, ViewUtils.dip2px(2.0F)));
      paramString.setDecodeHandler(bfol.j);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Exception paramImageView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("C2CShortcutBarAdapter", 2, "updateIconView exception ", paramImageView);
    }
  }
  
  public aphw a(int paramInt)
  {
    return (aphw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<aphw> paramList)
  {
    if (paramList == null) {
      return;
    }
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
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new apie();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560920, paramViewGroup, false);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131377347));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377349));
      paramView.b = ((TextView)localView.findViewById(2131377348));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131381159);
      paramView.c = ((TextView)localView.findViewById(2131377345));
      localView.setTag(paramView);
      localObject = a(paramInt);
      boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      if (!bool) {
        break label275;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      label136:
      if (!bool) {
        break label291;
      }
      localView.setBackgroundDrawable(localView.getResources().getDrawable(2130838664));
      label156:
      if (TextUtils.isEmpty(((aphw)localObject).g)) {
        break label310;
      }
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramView.c.setVisibility(0);
      paramView.c.setText(((aphw)localObject).g);
    }
    for (;;)
    {
      a(paramView.jdField_a_of_type_ComTencentImageURLImageView, ((aphw)localObject).c);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((aphw)localObject).b);
      if (this.jdField_a_of_type_Apid != null) {
        this.jdField_a_of_type_Apid.a((aphw)localObject, paramInt);
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (apie)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label275:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#1C1D1E"));
      break label136;
      label291:
      localView.setBackgroundDrawable(localView.getResources().getDrawable(2130838663));
      break label156;
      label310:
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apic
 * JD-Core Version:    0.7.0.1
 */