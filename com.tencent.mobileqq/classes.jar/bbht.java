import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.ThemeURLImageView;
import java.util.ArrayList;
import java.util.List;

public class bbht
  extends bbhi
{
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<bbhu> a;
  public LinearLayout b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public bbht(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131366122));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368344));
    if ((this.jdField_a_of_type_ComTencentImageURLImageView instanceof ThemeURLImageView)) {
      ((ThemeURLImageView)this.jdField_a_of_type_ComTencentImageURLImageView).setSupportMaskView(false);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378707));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377933));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377933));
    this.d = ((TextView)localView.findViewById(2131365445));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131376441));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368739);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131377925));
  }
  
  public void a(bazn parambazn)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#004080"));
    }
    if ((parambazn.a == null) || (parambazn.a.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    Context localContext = this.jdField_b_of_type_AndroidWidgetLinearLayout.getContext();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    int i = 0;
    label116:
    bazy localbazy;
    bbhu localbbhu;
    if ((i < parambazn.a.size()) && (i < 6))
    {
      localbazy = (bazy)parambazn.a.get(i);
      localbbhu = new bbhu(this, localContext);
      if (TextUtils.isEmpty(parambazn.m)) {
        break label410;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.dip2px(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.dip2px(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "subItemLeftIconUrl";
      localObject = URLDrawable.getDrawable(parambazn.m, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(bfol.a);
      localbbhu.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      localbbhu.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label279:
      localbbhu.jdField_a_of_type_AndroidViewView.setTag(2131380831, parambazn);
      if (TextUtils.isEmpty(localbazy.a)) {
        break label423;
      }
      localbbhu.jdField_a_of_type_AndroidWidgetTextView.setText(localbazy.a);
      localbbhu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbbhu.jdField_a_of_type_AndroidViewView.setTag(2131378208, localbazy.a);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localbazy.b))
      {
        localbbhu.jdField_a_of_type_AndroidViewView.setTag(2131378207, localbazy.b);
        localbbhu.jdField_a_of_type_AndroidViewView.setTag(2131378177, Integer.valueOf(parambazn.jdField_c_of_type_Int));
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localbbhu.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localbbhu);
      i += 1;
      break label116;
      break;
      label410:
      localbbhu.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label279;
      label423:
      localbbhu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbht
 * JD-Core Version:    0.7.0.1
 */