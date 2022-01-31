import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.open.agent.AuthorityControlAppDetailsFragment;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdef
  extends BaseAdapter
  implements View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final IphoneTitleBarFragment jdField_a_of_type_ComTencentMobileqqFragmentIphoneTitleBarFragment;
  @NonNull
  private List<AppInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List<Integer> b;
  
  public bdef(IphoneTitleBarFragment paramIphoneTitleBarFragment, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqFragmentIphoneTitleBarFragment = paramIphoneTitleBarFragment;
    this.jdField_a_of_type_AndroidAppActivity = paramIphoneTitleBarFragment.getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = new ArrayList();
  }
  
  private void a(int paramInt, View paramView, bdeh parambdeh)
  {
    parambdeh.jdField_a_of_type_Int = paramInt;
    parambdeh.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    AppInfo localAppInfo = (AppInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    String str = localAppInfo.b();
    paramView = str;
    if (str == null) {
      paramView = "";
    }
    parambdeh.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.trim());
    parambdeh.jdField_b_of_type_AndroidWidgetTextView.setText(localAppInfo.a());
    parambdeh.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    a(parambdeh, localAppInfo);
  }
  
  private void a(View paramView)
  {
    bdeh localbdeh = (bdeh)paramView.getTag();
    if (this.jdField_a_of_type_Boolean)
    {
      paramView = (CheckBox)paramView.findViewById(2131370537);
      boolean bool;
      if (!paramView.isChecked())
      {
        bool = true;
        paramView.setChecked(bool);
        if (!paramView.isChecked()) {
          break label155;
        }
        this.b.add(Integer.valueOf(localbdeh.jdField_a_of_type_Int));
        label65:
        if (this.b.size() <= 0) {
          break label178;
        }
        this.jdField_a_of_type_ComTencentMobileqqFragmentIphoneTitleBarFragment.rightViewText.setEnabled(true);
      }
      for (;;)
      {
        paramView = (AppInfo)this.jdField_a_of_type_JavaUtilList.get(localbdeh.jdField_a_of_type_Int);
        if (paramView != null) {
          paramView.a(bool);
        }
        if (QLog.isColorLevel()) {
          QLog.i("AuthorityControlAdapter", 2, "onLayoutAppItemClick: invoked.  mCheckedPositions: " + this.b);
        }
        return;
        bool = false;
        break;
        label155:
        int i = localbdeh.jdField_a_of_type_Int;
        this.b.remove(Integer.valueOf(i));
        break label65;
        label178:
        this.jdField_a_of_type_ComTencentMobileqqFragmentIphoneTitleBarFragment.rightViewText.setEnabled(false);
      }
    }
    paramView = (AppInfo)this.jdField_a_of_type_JavaUtilList.get(localbdeh.jdField_a_of_type_Int);
    AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramView);
  }
  
  private void a(bdeh parambdeh)
  {
    parambdeh.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    parambdeh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void a(bdeh parambdeh, View paramView)
  {
    parambdeh.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368915);
    parambdeh.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131370537));
    parambdeh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367525));
    parambdeh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362680));
    parambdeh.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362686));
    parambdeh.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362670));
    parambdeh.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369806);
  }
  
  private void a(bdeh parambdeh, AppInfo paramAppInfo)
  {
    Object localObject1 = paramAppInfo.c();
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130838492);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      parambdeh.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
      localObject2 = parambdeh.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localURLDrawableOptions.mRequestHeight = ((ViewGroup.LayoutParams)localObject2).height;
      localURLDrawableOptions.mRequestWidth = ((ViewGroup.LayoutParams)localObject2).width;
      try
      {
        localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
        ((URLDrawable)localObject1).setTag(bavw.b(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height, vzl.a(this.jdField_a_of_type_AndroidAppActivity, 6.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(bavw.i);
        parambdeh.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        label135:
        parambdeh.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramAppInfo.a());
        return;
        parambdeh.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      catch (Throwable localThrowable)
      {
        break label135;
      }
    }
  }
  
  private void b(bdeh parambdeh)
  {
    parambdeh.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    parambdeh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  @NonNull
  public List<AppInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if ((i < this.jdField_a_of_type_JavaUtilList.size()) && (i >= 0)) {
        localArrayList.add((AppInfo)this.jdField_a_of_type_JavaUtilList.get(i));
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.b.clear();
    notifyDataSetChanged();
  }
  
  public void a(@NonNull List<AppInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((AppInfo)localIterator.next()).a(false);
    }
    notifyDataSetChanged();
  }
  
  public void b(List<AppInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    label124:
    for (;;)
    {
      AppInfo localAppInfo1;
      if (localIterator1.hasNext())
      {
        localAppInfo1 = (AppInfo)localIterator1.next();
        Iterator localIterator2 = paramList.iterator();
        AppInfo localAppInfo2;
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
          localAppInfo2 = (AppInfo)localIterator2.next();
        } while (localAppInfo1.a() != localAppInfo2.a());
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label124;
        }
        localArrayList.add(localAppInfo1);
        break;
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        return;
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new bdeh(null);
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558636, null);
      a(paramViewGroup, paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      a(paramInt, paramView, paramViewGroup);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      b(paramViewGroup);
      return paramView;
      paramViewGroup = (bdeh)paramView.getTag();
    }
    a(paramViewGroup);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdef
 * JD-Core Version:    0.7.0.1
 */