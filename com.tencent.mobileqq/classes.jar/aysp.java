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
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;
import java.util.List;

public class aysp
  extends aysb
{
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<aysq> a;
  public TextView b;
  
  public aysp(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.c);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131362862));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367539));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131362587));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362589));
  }
  
  public void a(aykg paramaykg)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((paramaykg.jdField_a_of_type_JavaUtilList == null) || (paramaykg.jdField_a_of_type_JavaUtilList.size() == 0)) {
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
    if (j < paramaykg.jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (ayhm)paramaykg.jdField_a_of_type_JavaUtilList.get(j);
      localObject1 = new aysq(this, localContext);
      if (TextUtils.isEmpty(((ayhm)localObject2).jdField_a_of_type_JavaLangString)) {
        break label780;
      }
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = bcwh.a(localContext, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = bcwh.a(localContext, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "leftIcon";
      localObject3 = URLDrawable.getDrawable(((ayhm)localObject2).jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
      ((URLDrawable)localObject3).setDecodeHandler(bcuq.a);
      ((aysq)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((aysq)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
      if (TextUtils.isEmpty(((ayhm)localObject2).b)) {
        break label793;
      }
      ((aysq)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((ayhm)localObject2).b);
      ((aysq)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (TextUtils.isEmpty(((ayhm)localObject2).c)) {
        break label806;
      }
      ((aysq)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((ayhm)localObject2).c);
      ((aysq)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (TextUtils.isEmpty(((ayhm)localObject2).d)) {
        break label831;
      }
      ((aysq)localObject1).c.setVisibility(0);
      if ((((ayhm)localObject2).jdField_a_of_type_JavaUtilList == null) || (((ayhm)localObject2).jdField_a_of_type_JavaUtilList.size() == 0)) {
        break label819;
      }
      ((aysq)localObject1).c.setMaxLines(2);
      ((aysq)localObject1).c.setText(((ayhm)localObject2).d);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label844;
      }
      ((aysq)localObject1).c.setTextColor(Color.parseColor("#737373"));
      ((aysq)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((aysq)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((aysq)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130841993);
      if ((((ayhm)localObject2).jdField_a_of_type_JavaUtilList == null) || (((ayhm)localObject2).jdField_a_of_type_JavaUtilList.size() == 0)) {
        break label1311;
      }
      if (((ayhm)localObject2).jdField_a_of_type_JavaUtilList.size() != 1) {
        break label911;
      }
      ((aysq)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      ((aysq)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = ((aysq)localObject1).jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
      localObject4 = localContext.getResources();
      i = ((Resources)localObject4).getDisplayMetrics().widthPixels;
      float f1 = ((Resources)localObject4).getDimension(2131298222);
      float f2 = ((Resources)localObject4).getDimension(2131298222);
      k = bcwh.a(localContext, 2.0F);
      m = ((aysq)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = (int)(i - f1 - f2 - (m - 1) * k) / m;
      ((SquareImageView)localObject3).setLayoutParams(new FrameLayout.LayoutParams(i, i));
      localObject2 = (ayjn)((ayhm)localObject2).jdField_a_of_type_JavaUtilList.get(0);
      localObject4 = ((ayjn)localObject2).jdField_a_of_type_JavaLangString;
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
      if (((ayjn)localObject2).jdField_a_of_type_Int != 2) {
        break label898;
      }
      ((aysq)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((aysq)localObject1).jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      if (j != paramaykg.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        localObject1 = new View(localContext);
        ((View)localObject1).setBackgroundResource(2130839216);
        ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, bcwh.a(localContext, 6.0F)));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      j += 1;
      break label60;
      break;
      label780:
      ((aysq)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
      break label224;
      label793:
      ((aysq)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label257;
      label806:
      ((aysq)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label290;
      label819:
      ((aysq)localObject1).c.setMaxLines(3);
      break label340;
      label831:
      ((aysq)localObject1).c.setVisibility(8);
      break label353;
      label844:
      ((aysq)localObject1).c.setTextColor(Color.parseColor("#262626"));
      ((aysq)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      ((aysq)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      ((aysq)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130841990);
      break label416;
      label898:
      ((aysq)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label911:
      ((aysq)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      ((aysq)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int n = ((aysq)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      k = i;
      if (i < ((ayhm)localObject2).jdField_a_of_type_JavaUtilList.size())
      {
        k = i;
        if (i < n)
        {
          localObject4 = ((aysq)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject4).setVisibility(0);
          localObject3 = (SquareImageView)((View)localObject4).findViewById(2131368007);
          localObject4 = (ImageView)((View)localObject4).findViewById(2131369119);
          localObject5 = (ayjn)((ayhm)localObject2).jdField_a_of_type_JavaUtilList.get(i);
          Object localObject6 = ((ayjn)localObject5).jdField_a_of_type_JavaLangString;
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
          if (((ayjn)localObject5).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject4).setVisibility(0);
            label1141:
            if ((i != n - 1) || (((ayhm)localObject2).jdField_a_of_type_Int <= n)) {
              break label1264;
            }
            ((ImageView)localObject4).setVisibility(8);
            ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
            m = ((ayhm)localObject2).jdField_a_of_type_Int - n;
            k = m;
            if (m > 99) {
              k = 99;
            }
            ((SquareImageView)localObject3).setFilterText("+" + k);
            ((SquareImageView)localObject3).setFilterTextSize(bcwh.a(((SquareImageView)localObject3).getContext(), 20.0F));
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
        ((aysq)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k).setVisibility(4);
        k += 1;
      }
      continue;
      label1311:
      ((aysq)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      ((aysq)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysp
 * JD-Core Version:    0.7.0.1
 */