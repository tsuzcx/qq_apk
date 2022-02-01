import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class bbjm
  extends BaseAdapter
{
  private List<AssociateSearchWordsFragment.AssociateItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bbjm(List<AssociateSearchWordsFragment.AssociateItem> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public void a(List<AssociateSearchWordsFragment.AssociateItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (AssociateSearchWordsFragment.AssociateItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    switch (((AssociateSearchWordsFragment.AssociateItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int)
    {
    default: 
      return 0;
    case 2: 
    case 4: 
    case 5: 
      return 3;
    case 3: 
      return 2;
    case 6: 
      return 5;
    case 0: 
      return 1;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AssociateSearchWordsFragment.AssociateItem localAssociateItem = (AssociateSearchWordsFragment.AssociateItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.getActivity();
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    Object localObject1 = paramView;
    Object localObject3;
    if (paramView == null)
    {
      localObject3 = new bbjo(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment);
      localObject1 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject1).setPadding(bggq.a((Context)localObject2, 12.0F), 0, bggq.a((Context)localObject2, 12.0F), 0);
      ((LinearLayout)localObject1).setOrientation(1);
    }
    switch (getItemViewType(paramInt))
    {
    default: 
      paramView.setTag(localObject3);
      paramView.setBackgroundResource(2130842293);
      localObject1 = paramView;
      paramView = (bbjo)((View)localObject1).getTag();
      switch (getItemViewType(paramInt))
      {
      default: 
        label200:
        if (bool) {
          ((View)localObject1).setBackgroundResource(2130839386);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      ((View)localObject1).setTag(2131380930, Integer.valueOf(paramInt));
      ((View)localObject1).setTag(2131380929, localAssociateItem);
      paramView = (View)localObject1;
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
        paramView = new TextView((Context)localObject2);
        paramView.setBackgroundColor(Color.parseColor("#F7F7F9"));
        paramView.setHeight(bggq.a((Context)localObject2, 10.0F));
        Object localObject4 = new LinearLayout.LayoutParams(-1, -2);
        ((bbjo)localObject3).c = paramView;
        ((LinearLayout)localObject1).addView(paramView, (ViewGroup.LayoutParams)localObject4);
        paramView = new TextView((Context)localObject2);
        paramView.setTextColor(((Context)localObject2).getResources().getColor(2131167060));
        paramView.setTextSize(1, 15.0F);
        paramView.setGravity(16);
        paramView.setIncludeFontPadding(false);
        paramView.setHeight(((Context)localObject2).getResources().getDimensionPixelSize(2131298383));
        paramView.setPadding(bggq.a((Context)localObject2, 12.0F), 0, bggq.a((Context)localObject2, 12.0F), 0);
        ((LinearLayout)localObject1).addView(paramView, new LinearLayout.LayoutParams(-1, -2));
        ((LinearLayout)localObject1).setClickable(false);
        ((LinearLayout)localObject1).setFocusable(false);
        ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
        ((bbjo)localObject3).a = paramView;
        paramView = (View)localObject1;
        break;
        paramView = new TextView((Context)localObject2);
        paramView.setGravity(19);
        paramView.setTextColor(((Context)localObject2).getResources().getColor(2131166986));
        label479:
        Object localObject5;
        if (getItemViewType(paramInt) == 5)
        {
          paramView.setTextSize(1, 16.0F);
          paramView.setSingleLine();
          paramView.setEllipsize(TextUtils.TruncateAt.END);
          paramView.setIncludeFontPadding(false);
          if (getItemViewType(paramInt) != 5) {
            break label787;
          }
          localObject4 = new LinearLayout((Context)localObject2);
          ((LinearLayout)localObject4).setOrientation(0);
          ((LinearLayout)localObject1).addView((View)localObject4, new LinearLayout.LayoutParams(-1, bggq.a((Context)localObject2, 52.0F)));
          if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, "")) {
            break label756;
          }
          localObject5 = ((Context)localObject2).getResources().getDrawable(2130850327);
          ((Drawable)localObject5).setColorFilter(BaseApplicationImpl.sApplication.getResources().getColor(2131166911), PorterDuff.Mode.SRC_ATOP);
          paramView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject5, null, null, null);
          label598:
          paramView.setCompoundDrawablePadding(bggq.a((Context)localObject2, 8.0F));
          localObject5 = new LinearLayout.LayoutParams(-1, -1);
          ((LinearLayout.LayoutParams)localObject5).weight = 1.0F;
          ((LinearLayout)localObject4).addView(paramView, (ViewGroup.LayoutParams)localObject5);
          localObject5 = new ImageView((Context)localObject2);
          if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, "")) {
            break label776;
          }
          ((ImageView)localObject5).setImageResource(2130850332);
          ((ImageView)localObject5).setColorFilter(BaseApplicationImpl.sApplication.getResources().getColor(2131166911));
          label685:
          ((LinearLayout)localObject4).addView((View)localObject5, new LinearLayout.LayoutParams(-2, -1));
          ((ImageView)localObject5).setOnClickListener(new bbjn(this, localAssociateItem.jdField_a_of_type_JavaLangString, paramInt));
        }
        for (;;)
        {
          ((bbjo)localObject3).a = paramView;
          ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView = (View)localObject1;
          break;
          paramView.setTextSize(1, 18.0F);
          break label479;
          label756:
          paramView.setCompoundDrawablesWithIntrinsicBounds(((Context)localObject2).getResources().getDrawable(2130850327), null, null, null);
          break label598;
          label776:
          ((ImageView)localObject5).setImageResource(2130850332);
          break label685;
          label787:
          paramView.setCompoundDrawablesWithIntrinsicBounds(((Context)localObject2).getResources().getDrawable(2130850326), null, null, null);
          paramView.setCompoundDrawablePadding(bggq.a((Context)localObject2, 4.0F));
          localObject4 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject4).setMargins(0, bggq.a((Context)localObject2, 16.0F), 0, bggq.a((Context)localObject2, 16.0F));
          ((LinearLayout)localObject1).addView(paramView, (ViewGroup.LayoutParams)localObject4);
        }
        paramView = new TextView((Context)localObject2);
        paramView.setTextColor(((Context)localObject2).getResources().getColor(2131166986));
        paramView.setTextSize(1, 18.0F);
        paramView.setIncludeFontPadding(false);
        ((LinearLayout)localObject1).addView(paramView);
        ((bbjo)localObject3).a = paramView;
        paramView = new TextView((Context)localObject2);
        paramView.setTextColor(((Context)localObject2).getResources().getColor(2131167060));
        paramView.setTextSize(1, 14.0F);
        paramView.setIncludeFontPadding(false);
        ((LinearLayout)localObject1).addView(paramView);
        ((bbjo)localObject3).b = paramView;
        ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView = (View)localObject1;
        break;
        paramView = new TextView((Context)localObject2);
        paramView.setHeight(1);
        ((LinearLayout)localObject1).addView(paramView);
        ((LinearLayout)localObject1).setPadding(bggq.a((Context)localObject2, 12.0F), 0, 0, 0);
        ((bbjo)localObject3).c = paramView;
        ((LinearLayout)localObject1).setClickable(false);
        ((LinearLayout)localObject1).setFocusable(false);
        paramView = (View)localObject1;
        break;
        if (QLog.isColorLevel()) {
          QLog.e("Q.uniteSearch.AssociateSearchWordsFragment", 2, "SearchAssociatedWordAdapter.getView() itemType not support. value=" + getItemViewType(paramInt));
        }
        localObject1 = null;
      }
      if (paramInt == 0) {
        paramView.c.setVisibility(8);
      }
      for (;;)
      {
        paramView.a.setText(localAssociateItem.jdField_a_of_type_JavaLangString);
        break;
        paramView.c.setVisibility(0);
        if (bool) {
          paramView.c.setBackgroundColor(((Context)localObject2).getResources().getColor(2131166924));
        } else {
          paramView.c.setBackgroundColor(((Context)localObject2).getResources().getColor(2131166923));
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.b)
      {
        if (getItemViewType(paramInt) == 2)
        {
          localObject2 = bbup.a(paramView.a, 2.147484E+009F, 1, localAssociateItem.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.jdField_a_of_type_JavaLangString, false, false, true);
          paramView.a.setText((CharSequence)localObject2);
          break label200;
        }
        localObject2 = bbup.a(localAssociateItem.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.jdField_a_of_type_JavaLangString, false);
        paramView.a.setText((CharSequence)localObject2);
        break label200;
      }
      paramView.a.setText(localAssociateItem.jdField_a_of_type_JavaLangString);
      break label200;
      paramView.a.setText(localAssociateItem.jdField_a_of_type_JavaLangString);
      paramView.b.setText(localAssociateItem.e);
      if (TextUtils.isEmpty(localAssociateItem.jdField_a_of_type_JavaLangString))
      {
        paramView.a.setVisibility(8);
        ((LinearLayout.LayoutParams)paramView.b.getLayoutParams()).setMargins(0, bggq.a((Context)localObject2, 16.0F), 0, bggq.a((Context)localObject2, 16.0F));
        break label200;
      }
      paramView.a.setVisibility(0);
      localObject3 = (LinearLayout.LayoutParams)paramView.a.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject3).setMargins(0, bggq.a((Context)localObject2, 12.0F), 0, 0);
      paramView.a.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = (LinearLayout.LayoutParams)paramView.b.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject3).setMargins(0, bggq.a((Context)localObject2, 5.0F), 0, bggq.a((Context)localObject2, 12.0F));
      paramView.b.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      break label200;
      if (bool)
      {
        paramView.c.setBackgroundColor(((Context)localObject2).getResources().getColor(2131166924));
        break label200;
      }
      paramView.c.setBackgroundColor(((Context)localObject2).getResources().getColor(2131166923));
      break label200;
      ((View)localObject1).setBackgroundResource(2130839385);
    }
  }
  
  public int getViewTypeCount()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjm
 * JD-Core Version:    0.7.0.1
 */