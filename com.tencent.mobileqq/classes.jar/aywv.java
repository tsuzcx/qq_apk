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

public class aywv
  extends aywk
{
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<ayww> a;
  public LinearLayout b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public aywv(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131365800));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131367921));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377938));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377197));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377197));
    this.d = ((TextView)localView.findViewById(2131365129));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131375812));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368333);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131377194));
  }
  
  public void a(ayoo paramayoo)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#004080"));
    }
    if ((paramayoo.a == null) || (paramayoo.a.size() == 0))
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
    ayoz localayoz;
    ayww localayww;
    if ((i < paramayoo.a.size()) && (i < 6))
    {
      localayoz = (ayoz)paramayoo.a.get(i);
      localayww = new ayww(this, localContext);
      if (TextUtils.isEmpty(paramayoo.m)) {
        break label410;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bdaq.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bdaq.a(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "subItemLeftIconUrl";
      localObject = URLDrawable.getDrawable(paramayoo.m, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(bcyz.a);
      localayww.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      localayww.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label279:
      localayww.jdField_a_of_type_AndroidViewView.setTag(2131379971, paramayoo);
      if (TextUtils.isEmpty(localayoz.a)) {
        break label423;
      }
      localayww.jdField_a_of_type_AndroidWidgetTextView.setText(localayoz.a);
      localayww.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localayww.jdField_a_of_type_AndroidViewView.setTag(2131377451, localayoz.a);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localayoz.b))
      {
        localayww.jdField_a_of_type_AndroidViewView.setTag(2131377450, localayoz.b);
        localayww.jdField_a_of_type_AndroidViewView.setTag(2131377424, Integer.valueOf(paramayoo.jdField_c_of_type_Int));
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localayww.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localayww);
      i += 1;
      break label116;
      break;
      label410:
      localayww.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label279;
      label423:
      localayww.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywv
 * JD-Core Version:    0.7.0.1
 */