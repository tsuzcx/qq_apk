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
import java.util.ArrayList;
import java.util.List;

public class aysm
  extends aysb
{
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<aysn> a;
  public LinearLayout b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public aysm(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131365798));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131367910));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377884));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377143));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377143));
    this.d = ((TextView)localView.findViewById(2131365127));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131375761));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368322);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131377140));
  }
  
  public void a(aykf paramaykf)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#004080"));
    }
    if ((paramaykf.a == null) || (paramaykf.a.size() == 0))
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
    aykq localaykq;
    aysn localaysn;
    if ((i < paramaykf.a.size()) && (i < 6))
    {
      localaykq = (aykq)paramaykf.a.get(i);
      localaysn = new aysn(this, localContext);
      if (TextUtils.isEmpty(paramaykf.m)) {
        break label410;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bcwh.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bcwh.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "subItemLeftIconUrl";
      localObject = URLDrawable.getDrawable(paramaykf.m, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(bcuq.a);
      localaysn.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      localaysn.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label279:
      localaysn.jdField_a_of_type_AndroidViewView.setTag(2131379913, paramaykf);
      if (TextUtils.isEmpty(localaykq.a)) {
        break label423;
      }
      localaysn.jdField_a_of_type_AndroidWidgetTextView.setText(localaykq.a);
      localaysn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localaysn.jdField_a_of_type_AndroidViewView.setTag(2131377397, localaykq.a);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localaykq.b))
      {
        localaysn.jdField_a_of_type_AndroidViewView.setTag(2131377396, localaykq.b);
        localaysn.jdField_a_of_type_AndroidViewView.setTag(2131377370, Integer.valueOf(paramaykf.jdField_c_of_type_Int));
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localaysn.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localaysn);
      i += 1;
      break label116;
      break;
      label410:
      localaysn.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label279;
      label423:
      localaysn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysm
 * JD-Core Version:    0.7.0.1
 */