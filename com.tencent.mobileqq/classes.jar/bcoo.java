import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;
import java.util.List;

public class bcoo
  extends bcoa
{
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<bcop> a;
  public TextView b;
  
  public bcoo(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.c);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131363026));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368097));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131362727));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362730));
  }
  
  public void a(bcge parambcge)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((parambcge.jdField_a_of_type_JavaUtilList == null) || (parambcge.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    Context localContext = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    int j = 0;
    label60:
    Object localObject2;
    Object localObject1;
    Object localObject3;
    label224:
    label353:
    Object localObject4;
    label257:
    label290:
    label340:
    int i;
    label416:
    int k;
    int m;
    Object localObject5;
    if (j < parambcge.jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (bcdk)parambcge.jdField_a_of_type_JavaUtilList.get(j);
      localObject1 = new bcop(this, localContext);
      if (TextUtils.isEmpty(((bcdk)localObject2).jdField_a_of_type_JavaLangString)) {
        break label780;
      }
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = DisplayUtil.dip2px(localContext, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = DisplayUtil.dip2px(localContext, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "leftIcon";
      localObject3 = URLDrawable.getDrawable(((bcdk)localObject2).jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
      ((URLDrawable)localObject3).setDecodeHandler(bgxc.a);
      ((bcop)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((bcop)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
      if (TextUtils.isEmpty(((bcdk)localObject2).b)) {
        break label793;
      }
      ((bcop)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((bcdk)localObject2).b);
      ((bcop)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (TextUtils.isEmpty(((bcdk)localObject2).c)) {
        break label806;
      }
      ((bcop)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((bcdk)localObject2).c);
      ((bcop)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (TextUtils.isEmpty(((bcdk)localObject2).d)) {
        break label831;
      }
      ((bcop)localObject1).c.setVisibility(0);
      if ((((bcdk)localObject2).jdField_a_of_type_JavaUtilList == null) || (((bcdk)localObject2).jdField_a_of_type_JavaUtilList.size() == 0)) {
        break label819;
      }
      ((bcop)localObject1).c.setMaxLines(2);
      ((bcop)localObject1).c.setText(((bcdk)localObject2).d);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label844;
      }
      ((bcop)localObject1).c.setTextColor(Color.parseColor("#737373"));
      ((bcop)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((bcop)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((bcop)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130842399);
      if ((((bcdk)localObject2).jdField_a_of_type_JavaUtilList == null) || (((bcdk)localObject2).jdField_a_of_type_JavaUtilList.size() == 0)) {
        break label1311;
      }
      if (((bcdk)localObject2).jdField_a_of_type_JavaUtilList.size() != 1) {
        break label911;
      }
      ((bcop)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      ((bcop)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = ((bcop)localObject1).jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
      localObject4 = localContext.getResources();
      i = ((Resources)localObject4).getDisplayMetrics().widthPixels;
      float f1 = ((Resources)localObject4).getDimension(2131298385);
      float f2 = ((Resources)localObject4).getDimension(2131298385);
      k = DisplayUtil.dip2px(localContext, 2.0F);
      m = ((bcop)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = (int)(i - f1 - f2 - (m - 1) * k) / m;
      ((SquareImageView)localObject3).setLayoutParams(new FrameLayout.LayoutParams(i, i));
      localObject2 = (bcfl)((bcdk)localObject2).jdField_a_of_type_JavaUtilList.get(0);
      localObject4 = ((bcfl)localObject2).jdField_a_of_type_JavaLangString;
      localObject5 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject5).mPlayGifImage = true;
      localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject5);
      ((SquareImageView)localObject3).setImageDrawable((Drawable)localObject4);
      if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
        ((URLDrawable)localObject4).restartDownload();
      }
      if (((bcfl)localObject2).jdField_a_of_type_Int != 2) {
        break label898;
      }
      ((bcop)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((bcop)localObject1).jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      if (j != parambcge.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        localObject1 = new View(localContext);
        ((View)localObject1).setBackgroundResource(2130839458);
        ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, DisplayUtil.dip2px(localContext, 6.0F)));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      j += 1;
      break label60;
      break;
      label780:
      ((bcop)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
      break label224;
      label793:
      ((bcop)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label257;
      label806:
      ((bcop)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label290;
      label819:
      ((bcop)localObject1).c.setMaxLines(3);
      break label340;
      label831:
      ((bcop)localObject1).c.setVisibility(8);
      break label353;
      label844:
      ((bcop)localObject1).c.setTextColor(Color.parseColor("#262626"));
      ((bcop)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      ((bcop)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      ((bcop)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130842396);
      break label416;
      label898:
      ((bcop)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label911:
      ((bcop)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      ((bcop)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int n = ((bcop)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      k = i;
      if (i < ((bcdk)localObject2).jdField_a_of_type_JavaUtilList.size())
      {
        k = i;
        if (i < n)
        {
          localObject4 = ((bcop)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject4).setVisibility(0);
          localObject3 = (SquareImageView)((View)localObject4).findViewById(2131368597);
          localObject4 = (ImageView)((View)localObject4).findViewById(2131369778);
          localObject5 = (bcfl)((bcdk)localObject2).jdField_a_of_type_JavaUtilList.get(i);
          Object localObject6 = ((bcfl)localObject5).jdField_a_of_type_JavaLangString;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestHeight = 200;
          localURLDrawableOptions.mRequestWidth = 200;
          localURLDrawableOptions.mFailedDrawable = localColorDrawable;
          localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject6 = URLDrawable.getDrawable((String)localObject6, localURLDrawableOptions);
          ((SquareImageView)localObject3).setImageDrawable((Drawable)localObject6);
          if ((((URLDrawable)localObject6).getStatus() != 1) && (((URLDrawable)localObject6).getStatus() != 0)) {
            ((URLDrawable)localObject6).restartDownload();
          }
          ((SquareImageView)localObject3).setVisibility(0);
          if (((bcfl)localObject5).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject4).setVisibility(0);
            label1141:
            if ((i != n - 1) || (((bcdk)localObject2).jdField_a_of_type_Int <= n)) {
              break label1264;
            }
            ((ImageView)localObject4).setVisibility(8);
            ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
            m = ((bcdk)localObject2).jdField_a_of_type_Int - n;
            k = m;
            if (m > 99) {
              k = 99;
            }
            ((SquareImageView)localObject3).setFilterText("+" + k);
            ((SquareImageView)localObject3).setFilterTextSize(DisplayUtil.dip2px(((SquareImageView)localObject3).getContext(), 20.0F));
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject4).setVisibility(8);
            break label1141;
            label1264:
            ((SquareImageView)localObject3).setFilterColor(-1);
            ((SquareImageView)localObject3).setFilterText("");
          }
        }
      }
      while (k < n)
      {
        ((bcop)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k).setVisibility(4);
        k += 1;
      }
      continue;
      label1311:
      ((bcop)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      ((bcop)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcoo
 * JD-Core Version:    0.7.0.1
 */