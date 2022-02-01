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

public class bcol
  extends bcoa
{
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<bcom> a;
  public LinearLayout b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public bcol(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131366223));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368501));
    if ((this.jdField_a_of_type_ComTencentImageURLImageView instanceof ThemeURLImageView)) {
      ((ThemeURLImageView)this.jdField_a_of_type_ComTencentImageURLImageView).setSupportMaskView(false);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379001));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378221));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378221));
    this.d = ((TextView)localView.findViewById(2131365538));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131376696));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368898);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131378212));
  }
  
  public void a(bcgd parambcgd)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#004080"));
    }
    if ((parambcgd.a == null) || (parambcgd.a.size() == 0))
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
    bcgo localbcgo;
    bcom localbcom;
    if ((i < parambcgd.a.size()) && (i < 6))
    {
      localbcgo = (bcgo)parambcgd.a.get(i);
      localbcom = new bcom(this, localContext);
      if (TextUtils.isEmpty(parambcgd.m)) {
        break label410;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.dip2px(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.dip2px(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "subItemLeftIconUrl";
      localObject = URLDrawable.getDrawable(parambcgd.m, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(bgxc.a);
      localbcom.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      localbcom.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label279:
      localbcom.jdField_a_of_type_AndroidViewView.setTag(2131381183, parambcgd);
      if (TextUtils.isEmpty(localbcgo.a)) {
        break label423;
      }
      localbcom.jdField_a_of_type_AndroidWidgetTextView.setText(localbcgo.a);
      localbcom.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbcom.jdField_a_of_type_AndroidViewView.setTag(2131378496, localbcgo.a);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localbcgo.b))
      {
        localbcom.jdField_a_of_type_AndroidViewView.setTag(2131378495, localbcgo.b);
        localbcom.jdField_a_of_type_AndroidViewView.setTag(2131378465, Integer.valueOf(parambcgd.jdField_c_of_type_Int));
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localbcom.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localbcom);
      i += 1;
      break label116;
      break;
      label410:
      localbcom.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label279;
      label423:
      localbcom.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcol
 * JD-Core Version:    0.7.0.1
 */