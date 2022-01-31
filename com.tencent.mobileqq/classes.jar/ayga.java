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
import java.util.ArrayList;
import java.util.List;

public class ayga
  extends BaseAdapter
{
  private List<AssociateSearchWordsFragment.AssociateItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ayga(List<AssociateSearchWordsFragment.AssociateItem> paramList)
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.getActivity();
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    paramViewGroup = paramView;
    Object localObject2;
    if (paramView == null)
    {
      localObject2 = new aygc(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment);
      paramViewGroup = new LinearLayout((Context)localObject1);
      paramViewGroup.setPadding(bcwh.a((Context)localObject1, 12.0F), 0, bcwh.a((Context)localObject1, 12.0F), 0);
      paramViewGroup.setOrientation(1);
    }
    switch (getItemViewType(paramInt))
    {
    default: 
      paramView.setTag(localObject2);
      paramView.setBackgroundResource(2130841971);
      paramViewGroup = paramView;
      paramView = (aygc)paramViewGroup.getTag();
      switch (getItemViewType(paramInt))
      {
      default: 
        label192:
        if (bool) {
          paramViewGroup.setBackgroundResource(2130839208);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramViewGroup.setTag(2131379914, Integer.valueOf(paramInt));
      paramViewGroup.setTag(2131379913, localAssociateItem);
      return paramViewGroup;
      paramView = new TextView((Context)localObject1);
      paramView.setBackgroundColor(Color.parseColor("#F7F7F9"));
      paramView.setHeight(bcwh.a((Context)localObject1, 10.0F));
      Object localObject3 = new LinearLayout.LayoutParams(-1, -2);
      ((aygc)localObject2).c = paramView;
      paramViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject3);
      paramView = new TextView((Context)localObject1);
      paramView.setTextColor(((Context)localObject1).getResources().getColor(2131166975));
      paramView.setTextSize(1, 15.0F);
      paramView.setGravity(16);
      paramView.setIncludeFontPadding(false);
      paramView.setHeight(((Context)localObject1).getResources().getDimensionPixelSize(2131298301));
      paramView.setPadding(bcwh.a((Context)localObject1, 12.0F), 0, bcwh.a((Context)localObject1, 12.0F), 0);
      paramViewGroup.addView(paramView, new LinearLayout.LayoutParams(-1, -2));
      paramViewGroup.setClickable(false);
      paramViewGroup.setFocusable(false);
      paramViewGroup.setPadding(0, 0, 0, 0);
      ((aygc)localObject2).a = paramView;
      paramView = paramViewGroup;
      break;
      paramView = new TextView((Context)localObject1);
      paramView.setGravity(19);
      paramView.setTextColor(((Context)localObject1).getResources().getColor(2131166901));
      label444:
      Object localObject4;
      if (getItemViewType(paramInt) == 5)
      {
        paramView.setTextSize(1, 16.0F);
        paramView.setSingleLine();
        paramView.setEllipsize(TextUtils.TruncateAt.END);
        paramView.setIncludeFontPadding(false);
        if (getItemViewType(paramInt) != 5) {
          break label748;
        }
        localObject3 = new LinearLayout((Context)localObject1);
        ((LinearLayout)localObject3).setOrientation(0);
        paramViewGroup.addView((View)localObject3, new LinearLayout.LayoutParams(-1, bcwh.a((Context)localObject1, 52.0F)));
        if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, "")) {
          break label717;
        }
        localObject4 = ((Context)localObject1).getResources().getDrawable(2130849668);
        ((Drawable)localObject4).setColorFilter(BaseApplicationImpl.sApplication.getResources().getColor(2131166828), PorterDuff.Mode.SRC_ATOP);
        paramView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject4, null, null, null);
        label562:
        paramView.setCompoundDrawablePadding(bcwh.a((Context)localObject1, 8.0F));
        localObject4 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        ((LinearLayout)localObject3).addView(paramView, (ViewGroup.LayoutParams)localObject4);
        localObject4 = new ImageView((Context)localObject1);
        if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, "")) {
          break label737;
        }
        ((ImageView)localObject4).setImageResource(2130849673);
        ((ImageView)localObject4).setColorFilter(BaseApplicationImpl.sApplication.getResources().getColor(2131166828));
        label648:
        ((LinearLayout)localObject3).addView((View)localObject4, new LinearLayout.LayoutParams(-2, -1));
        ((ImageView)localObject4).setOnClickListener(new aygb(this, localAssociateItem.jdField_a_of_type_JavaLangString, paramInt));
      }
      for (;;)
      {
        ((aygc)localObject2).a = paramView;
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView = paramViewGroup;
        break;
        paramView.setTextSize(1, 18.0F);
        break label444;
        label717:
        paramView.setCompoundDrawablesWithIntrinsicBounds(((Context)localObject1).getResources().getDrawable(2130849668), null, null, null);
        break label562;
        label737:
        ((ImageView)localObject4).setImageResource(2130849673);
        break label648;
        label748:
        paramView.setCompoundDrawablesWithIntrinsicBounds(((Context)localObject1).getResources().getDrawable(2130849667), null, null, null);
        paramView.setCompoundDrawablePadding(bcwh.a((Context)localObject1, 4.0F));
        localObject3 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, bcwh.a((Context)localObject1, 16.0F), 0, bcwh.a((Context)localObject1, 16.0F));
        paramViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject3);
      }
      paramView = new TextView((Context)localObject1);
      paramView.setTextColor(((Context)localObject1).getResources().getColor(2131166901));
      paramView.setTextSize(1, 18.0F);
      paramView.setIncludeFontPadding(false);
      paramViewGroup.addView(paramView);
      ((aygc)localObject2).a = paramView;
      paramView = new TextView((Context)localObject1);
      paramView.setTextColor(((Context)localObject1).getResources().getColor(2131166975));
      paramView.setTextSize(1, 14.0F);
      paramView.setIncludeFontPadding(false);
      paramViewGroup.addView(paramView);
      ((aygc)localObject2).b = paramView;
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView = paramViewGroup;
      break;
      paramView = new TextView((Context)localObject1);
      paramView.setHeight(1);
      paramViewGroup.addView(paramView);
      paramViewGroup.setPadding(bcwh.a((Context)localObject1, 12.0F), 0, 0, 0);
      ((aygc)localObject2).c = paramView;
      paramViewGroup.setClickable(false);
      paramViewGroup.setFocusable(false);
      paramView = paramViewGroup;
      break;
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.AssociateSearchWordsFragment", 2, "SearchAssociatedWordAdapter.getView() itemType not support. value=" + getItemViewType(paramInt));
      }
      return null;
      if (paramInt == 0) {
        paramView.c.setVisibility(8);
      }
      for (;;)
      {
        paramView.a.setText(localAssociateItem.jdField_a_of_type_JavaLangString);
        break;
        paramView.c.setVisibility(0);
        if (bool) {
          paramView.c.setBackgroundColor(((Context)localObject1).getResources().getColor(2131166841));
        } else {
          paramView.c.setBackgroundColor(((Context)localObject1).getResources().getColor(2131166840));
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.b)
      {
        if (getItemViewType(paramInt) == 2)
        {
          localObject1 = ayrd.a(paramView.a, 2.147484E+009F, 1, localAssociateItem.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.jdField_a_of_type_JavaLangString, false, false, true);
          paramView.a.setText((CharSequence)localObject1);
          break label192;
        }
        localObject1 = ayrd.a(localAssociateItem.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.jdField_a_of_type_JavaLangString, false);
        paramView.a.setText((CharSequence)localObject1);
        break label192;
      }
      paramView.a.setText(localAssociateItem.jdField_a_of_type_JavaLangString);
      break label192;
      paramView.a.setText(localAssociateItem.jdField_a_of_type_JavaLangString);
      paramView.b.setText(localAssociateItem.e);
      if (TextUtils.isEmpty(localAssociateItem.jdField_a_of_type_JavaLangString))
      {
        paramView.a.setVisibility(8);
        ((LinearLayout.LayoutParams)paramView.b.getLayoutParams()).setMargins(0, bcwh.a((Context)localObject1, 16.0F), 0, bcwh.a((Context)localObject1, 16.0F));
        break label192;
      }
      paramView.a.setVisibility(0);
      localObject2 = (LinearLayout.LayoutParams)paramView.a.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).setMargins(0, bcwh.a((Context)localObject1, 12.0F), 0, 0);
      paramView.a.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (LinearLayout.LayoutParams)paramView.b.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).setMargins(0, bcwh.a((Context)localObject1, 5.0F), 0, bcwh.a((Context)localObject1, 12.0F));
      paramView.b.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label192;
      if (bool)
      {
        paramView.c.setBackgroundColor(((Context)localObject1).getResources().getColor(2131166841));
        break label192;
      }
      paramView.c.setBackgroundColor(((Context)localObject1).getResources().getColor(2131166840));
      break label192;
      paramViewGroup.setBackgroundResource(2130839207);
    }
  }
  
  public int getViewTypeCount()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayga
 * JD-Core Version:    0.7.0.1
 */