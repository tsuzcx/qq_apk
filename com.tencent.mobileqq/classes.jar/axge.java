import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multicard.MultiCardCustomLayout;
import com.tencent.mobileqq.multicard.MultiCardItemFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axge
  implements View.OnLongClickListener
{
  private int jdField_a_of_type_Int = -1;
  public Context a;
  public Bundle a;
  public FragmentActivity a;
  public ViewGroup a;
  public axfy a;
  private axgg jdField_a_of_type_Axgg;
  public QQAppInterface a;
  private MultiCardCustomLayout jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout;
  public WeakReference<MultiCardItemFragment> a;
  public List<View> a;
  private boolean jdField_a_of_type_Boolean;
  
  public axge()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public axge(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      return false;
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      i = arrayOfInt[0];
      j = arrayOfInt[1];
      k = paramView.getMeasuredWidth();
      m = paramView.getMeasuredHeight();
    } while ((paramFloat2 < j) || (paramFloat2 > m + j) || (paramFloat1 < i) || (paramFloat1 > k + i));
    return true;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public View a()
  {
    return MultiCardItemFragment.a();
  }
  
  public axfy a()
  {
    return this.jdField_a_of_type_Axfy;
  }
  
  public MultiCardCustomLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      return this.jdField_a_of_type_AndroidOsBundle.getString("troopuin");
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "unInit");
    }
    this.jdField_a_of_type_Int = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.a(false);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setDispatchTouchEventOnLongClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Axfy = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidOsBundle = null;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "onCardModeChanged：" + paramInt);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout = ((MultiCardCustomLayout)paramView);
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout != null)) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setDispatchTouchEventOnLongClickListener(new axgf(this));
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(ViewGroup paramViewGroup, View paramView)
  {
    MultiCardItemFragment.a(paramViewGroup, paramView);
  }
  
  public void a(axfy paramaxfy)
  {
    this.jdField_a_of_type_Axfy = paramaxfy;
  }
  
  public void a(axgg paramaxgg)
  {
    this.jdField_a_of_type_Axgg = paramaxgg;
  }
  
  public void a(MultiCardItemFragment paramMultiCardItemFragment)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMultiCardItemFragment);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Axgg != null) {
      this.jdField_a_of_type_Axgg.a(this);
    }
    return true;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (a((View)localIterator.next(), paramFloat1, paramFloat2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "doOnCreate() called");
    }
    return true;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a(this.jdField_a_of_type_Int);
    }
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (paramView.getParent() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardCustomViewDelegete", 2, "infoview has parent. error!!");
        }
        if ((paramView.getParent() instanceof ViewGroup))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiCardCustomViewDelegete", 2, "infoview has parent. remove infoview");
          }
          ((ViewGroup)paramView.getParent()).removeView(paramView);
        }
      }
    } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "doOnResume() called");
    }
  }
  
  public void c(View paramView)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramView)) {
      this.jdField_a_of_type_JavaUtilList.add(paramView);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "doOnPause() called");
    }
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "doOnDestroy");
    }
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_Axfy = null;
  }
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Axgg != null) {
      this.jdField_a_of_type_Axgg.a(this);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axge
 * JD-Core Version:    0.7.0.1
 */