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

public class aqlg
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private aqlh jdField_a_of_type_Aqlh;
  private List<aqla> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aqlg(Context paramContext, List<aqla> paramList, aqlh paramaqlh)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aqlh = paramaqlh;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838719);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localObject = paramImageView.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = ((ViewGroup.LayoutParams)localObject).height;
    localURLDrawableOptions.mRequestWidth = ((ViewGroup.LayoutParams)localObject).width;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(bgxc.b(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height, ViewUtils.dip2px(2.0F)));
      paramString.setDecodeHandler(bgxc.j);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Exception paramImageView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("C2CShortcutBarAdapter", 2, "updateIconView exception ", paramImageView);
    }
  }
  
  public aqla a(int paramInt)
  {
    return (aqla)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<aqla> paramList)
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
      paramView = new aqli();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560981, paramViewGroup, false);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131377620));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377622));
      paramView.b = ((TextView)localView.findViewById(2131377621));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131381520);
      paramView.c = ((TextView)localView.findViewById(2131377618));
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
      localView.setBackgroundDrawable(localView.getResources().getDrawable(2130838680));
      label156:
      if (TextUtils.isEmpty(((aqla)localObject).g)) {
        break label310;
      }
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramView.c.setVisibility(0);
      paramView.c.setText(((aqla)localObject).g);
    }
    for (;;)
    {
      a(paramView.jdField_a_of_type_ComTencentImageURLImageView, ((aqla)localObject).c);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((aqla)localObject).b);
      if (this.jdField_a_of_type_Aqlh != null) {
        this.jdField_a_of_type_Aqlh.a((aqla)localObject, paramInt);
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (aqli)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label275:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#1C1D1E"));
      break label136;
      label291:
      localView.setBackgroundDrawable(localView.getResources().getDrawable(2130838679));
      break label156;
      label310:
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlg
 * JD-Core Version:    0.7.0.1
 */