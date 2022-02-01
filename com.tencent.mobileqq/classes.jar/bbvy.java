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
import com.tencent.widget.ThemeURLImageView;
import java.util.ArrayList;
import java.util.List;

public class bbvy
  extends bbvn
{
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<bbvz> a;
  public LinearLayout b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public bbvy(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131366047));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368246));
    if ((this.jdField_a_of_type_ComTencentImageURLImageView instanceof ThemeURLImageView)) {
      ((ThemeURLImageView)this.jdField_a_of_type_ComTencentImageURLImageView).setSupportMaskView(false);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378776));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378008));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378008));
    this.d = ((TextView)localView.findViewById(2131365369));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131376543));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368641);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131377999));
  }
  
  public void a(bbns parambbns)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#004080"));
    }
    if ((parambbns.a == null) || (parambbns.a.size() == 0))
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
    bbod localbbod;
    bbvz localbbvz;
    if ((i < parambbns.a.size()) && (i < 6))
    {
      localbbod = (bbod)parambbns.a.get(i);
      localbbvz = new bbvz(this, localContext);
      if (TextUtils.isEmpty(parambbns.m)) {
        break label410;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bggq.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bggq.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "subItemLeftIconUrl";
      localObject = URLDrawable.getDrawable(parambbns.m, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(bgey.a);
      localbbvz.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      localbbvz.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label279:
      localbbvz.jdField_a_of_type_AndroidViewView.setTag(2131380929, parambbns);
      if (TextUtils.isEmpty(localbbod.a)) {
        break label423;
      }
      localbbvz.jdField_a_of_type_AndroidWidgetTextView.setText(localbbod.a);
      localbbvz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbbvz.jdField_a_of_type_AndroidViewView.setTag(2131378284, localbbod.a);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localbbod.b))
      {
        localbbvz.jdField_a_of_type_AndroidViewView.setTag(2131378283, localbbod.b);
        localbbvz.jdField_a_of_type_AndroidViewView.setTag(2131378253, Integer.valueOf(parambbns.jdField_c_of_type_Int));
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localbbvz.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localbbvz);
      i += 1;
      break label116;
      break;
      label410:
      localbbvz.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label279;
      label423:
      localbbvz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvy
 * JD-Core Version:    0.7.0.1
 */