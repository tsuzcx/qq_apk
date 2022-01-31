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

public class avxo
  extends avxd
{
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<avxp> a;
  public LinearLayout b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public avxo(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131300118));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131302158));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131311534));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131310823));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131310823));
    this.d = ((TextView)localView.findViewById(2131299475));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131309529));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131302556);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131310820));
  }
  
  public void a(avph paramavph)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#004080"));
    }
    if ((paramavph.a == null) || (paramavph.a.size() == 0))
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
    avps localavps;
    avxp localavxp;
    if ((i < paramavph.a.size()) && (i < 6))
    {
      localavps = (avps)paramavph.a.get(i);
      localavxp = new avxp(this, localContext);
      if (TextUtils.isEmpty(paramavph.m)) {
        break label410;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = azvv.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = azvv.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "subItemLeftIconUrl";
      localObject = URLDrawable.getDrawable(paramavph.m, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(azue.a);
      localavxp.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      localavxp.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label279:
      localavxp.jdField_a_of_type_AndroidViewView.setTag(2131313373, paramavph);
      if (TextUtils.isEmpty(localavps.a)) {
        break label423;
      }
      localavxp.jdField_a_of_type_AndroidWidgetTextView.setText(localavps.a);
      localavxp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localavxp.jdField_a_of_type_AndroidViewView.setTag(2131311071, localavps.a);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localavps.b))
      {
        localavxp.jdField_a_of_type_AndroidViewView.setTag(2131311070, localavps.b);
        localavxp.jdField_a_of_type_AndroidViewView.setTag(2131311045, Integer.valueOf(paramavph.jdField_c_of_type_Int));
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localavxp.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localavxp);
      i += 1;
      break label116;
      break;
      label410:
      localavxp.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label279;
      label423:
      localavxp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxo
 * JD-Core Version:    0.7.0.1
 */