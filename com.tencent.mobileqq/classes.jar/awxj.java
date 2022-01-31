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

public class awxj
  extends awwy
{
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<awxk> a;
  public LinearLayout b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public awxj(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131365714));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131367776));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377350));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376633));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376633));
    this.d = ((TextView)localView.findViewById(2131365042));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131375279));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368176);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131376630));
  }
  
  public void a(awpc paramawpc)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#004080"));
    }
    if ((paramawpc.a == null) || (paramawpc.a.size() == 0))
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
    awpn localawpn;
    awxk localawxk;
    if ((i < paramawpc.a.size()) && (i < 6))
    {
      localawpn = (awpn)paramawpc.a.get(i);
      localawxk = new awxk(this, localContext);
      if (TextUtils.isEmpty(paramawpc.m)) {
        break label410;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = baxn.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = baxn.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "subItemLeftIconUrl";
      localObject = URLDrawable.getDrawable(paramawpc.m, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(bavw.a);
      localawxk.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      localawxk.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label279:
      localawxk.jdField_a_of_type_AndroidViewView.setTag(2131379213, paramawpc);
      if (TextUtils.isEmpty(localawpn.a)) {
        break label423;
      }
      localawxk.jdField_a_of_type_AndroidWidgetTextView.setText(localawpn.a);
      localawxk.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localawxk.jdField_a_of_type_AndroidViewView.setTag(2131376883, localawpn.a);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localawpn.b))
      {
        localawxk.jdField_a_of_type_AndroidViewView.setTag(2131376882, localawpn.b);
        localawxk.jdField_a_of_type_AndroidViewView.setTag(2131376856, Integer.valueOf(paramawpc.jdField_c_of_type_Int));
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localawxk.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localawxk);
      i += 1;
      break label116;
      break;
      label410:
      localawxk.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label279;
      label423:
      localawxk.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxj
 * JD-Core Version:    0.7.0.1
 */