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

public class awxh
  extends awww
{
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<awxi> a;
  public LinearLayout b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public awxh(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131365715));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131367776));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377350));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376631));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376631));
    this.d = ((TextView)localView.findViewById(2131365043));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131375277));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368176);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131376628));
  }
  
  public void a(awpa paramawpa)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#004080"));
    }
    if ((paramawpa.a == null) || (paramawpa.a.size() == 0))
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
    awpl localawpl;
    awxi localawxi;
    if ((i < paramawpa.a.size()) && (i < 6))
    {
      localawpl = (awpl)paramawpa.a.get(i);
      localawxi = new awxi(this, localContext);
      if (TextUtils.isEmpty(paramawpa.m)) {
        break label410;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bawz.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bawz.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "subItemLeftIconUrl";
      localObject = URLDrawable.getDrawable(paramawpa.m, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(bavi.a);
      localawxi.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      localawxi.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label279:
      localawxi.jdField_a_of_type_AndroidViewView.setTag(2131379208, paramawpa);
      if (TextUtils.isEmpty(localawpl.a)) {
        break label423;
      }
      localawxi.jdField_a_of_type_AndroidWidgetTextView.setText(localawpl.a);
      localawxi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localawxi.jdField_a_of_type_AndroidViewView.setTag(2131376881, localawpl.a);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localawpl.b))
      {
        localawxi.jdField_a_of_type_AndroidViewView.setTag(2131376880, localawpl.b);
        localawxi.jdField_a_of_type_AndroidViewView.setTag(2131376854, Integer.valueOf(paramawpa.jdField_c_of_type_Int));
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localawxi.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localawxi);
      i += 1;
      break label116;
      break;
      label410:
      localawxi.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label279;
      label423:
      localawxi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxh
 * JD-Core Version:    0.7.0.1
 */