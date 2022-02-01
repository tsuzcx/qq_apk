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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class aqot
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private aqou jdField_a_of_type_Aqou;
  private List<aqon> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aqot(Context paramContext, List<aqon> paramList, aqou paramaqou)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aqou = paramaqou;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838677);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localObject = paramImageView.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = ((ViewGroup.LayoutParams)localObject).height;
    localURLDrawableOptions.mRequestWidth = ((ViewGroup.LayoutParams)localObject).width;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(bhez.b(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height, bhtq.a(2.0F)));
      paramString.setDecodeHandler(bhez.j);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Exception paramImageView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("C2CShortcutBarAdapter", 2, "updateIconView exception ", paramImageView);
    }
  }
  
  public aqon a(int paramInt)
  {
    return (aqon)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<aqon> paramList)
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
      paramView = new aqov();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561050, paramViewGroup, false);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131377579));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377581));
      paramView.b = ((TextView)localView.findViewById(2131377580));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131381441);
      paramView.c = ((TextView)localView.findViewById(2131377577));
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
      localView.setBackgroundDrawable(localView.getResources().getDrawable(2130838639));
      label156:
      if (TextUtils.isEmpty(((aqon)localObject).g)) {
        break label310;
      }
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramView.c.setVisibility(0);
      paramView.c.setText(((aqon)localObject).g);
    }
    for (;;)
    {
      a(paramView.jdField_a_of_type_ComTencentImageURLImageView, ((aqon)localObject).c);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((aqon)localObject).b);
      if (this.jdField_a_of_type_Aqou != null) {
        this.jdField_a_of_type_Aqou.a((aqon)localObject, paramInt);
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (aqov)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label275:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#1C1D1E"));
      break label136;
      label291:
      localView.setBackgroundDrawable(localView.getResources().getDrawable(2130838638));
      break label156;
      label310:
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqot
 * JD-Core Version:    0.7.0.1
 */