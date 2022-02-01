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

public class bcor
  extends bcog
{
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<bcos> a;
  public LinearLayout b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public bcor(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131366093));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368320));
    if ((this.jdField_a_of_type_ComTencentImageURLImageView instanceof ThemeURLImageView)) {
      ((ThemeURLImageView)this.jdField_a_of_type_ComTencentImageURLImageView).setSupportMaskView(false);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378936));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378163));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378163));
    this.d = ((TextView)localView.findViewById(2131365413));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131376675));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368715);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131378154));
  }
  
  public void a(bcgl parambcgl)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#004080"));
    }
    if ((parambcgl.a == null) || (parambcgl.a.size() == 0))
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
    bcgw localbcgw;
    bcos localbcos;
    if ((i < parambcgl.a.size()) && (i < 6))
    {
      localbcgw = (bcgw)parambcgl.a.get(i);
      localbcos = new bcos(this, localContext);
      if (TextUtils.isEmpty(parambcgl.m)) {
        break label410;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bhgr.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bhgr.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "subItemLeftIconUrl";
      localObject = URLDrawable.getDrawable(parambcgl.m, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(bhez.a);
      localbcos.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      localbcos.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label279:
      localbcos.jdField_a_of_type_AndroidViewView.setTag(2131381109, parambcgl);
      if (TextUtils.isEmpty(localbcgw.a)) {
        break label423;
      }
      localbcos.jdField_a_of_type_AndroidWidgetTextView.setText(localbcgw.a);
      localbcos.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbcos.jdField_a_of_type_AndroidViewView.setTag(2131378441, localbcgw.a);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localbcgw.b))
      {
        localbcos.jdField_a_of_type_AndroidViewView.setTag(2131378440, localbcgw.b);
        localbcos.jdField_a_of_type_AndroidViewView.setTag(2131378410, Integer.valueOf(parambcgl.jdField_c_of_type_Int));
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localbcos.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localbcos);
      i += 1;
      break label116;
      break;
      label410:
      localbcos.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label279;
      label423:
      localbcos.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcor
 * JD-Core Version:    0.7.0.1
 */