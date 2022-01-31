import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.mobileqq.multicard.MultiCardRecommendFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class asrn
  implements View.OnClickListener, assj, assk, assl
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Context a;
  public FragmentActivity a;
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  assi jdField_a_of_type_Assi;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator;
  public QQAppInterface a;
  MultiCardFragment jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment;
  MultiCardRecommendFragment jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment;
  private Long jdField_a_of_type_JavaLangLong;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public asrn(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContainer", 2, "MultiCardContainer, groopuin :" + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    try
    {
      this.jdField_a_of_type_Long = Long.valueOf(paramString).longValue();
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131562563, null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375512));
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramFragmentActivity.getResources().getDrawable(2130840146));
      }
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377444);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362988));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378269));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.jdField_a_of_type_AndroidViewView.findViewById(2131376283));
      a(paramQQAppInterface, paramContext, String.valueOf(this.jdField_a_of_type_Long));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new asro(this));
      if (AppSetting.d) {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajya.a(2131707005));
      }
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramFragmentActivity = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        int j = ImmersiveUtils.getStatusBarHeight(paramContext);
        int i = j;
        if (b()) {
          i = j - actj.a(10.0F, this.jdField_b_of_type_AndroidViewView.getResources());
        }
        paramFragmentActivity.setMargins(0, i, 0, 0);
        this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramFragmentActivity);
      }
      this.jdField_a_of_type_Assi = ((assi)paramQQAppInterface.getManager(329));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Long = 0L;
        QLog.d("MultiCardContainer", 2, "MultiCardContainer troopuinerror:" + paramString);
      }
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment == null)) {
      return;
    }
    FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().beginTransaction();
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if ((!this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.isAdded()) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag(this.jdField_a_of_type_Int + "") == null))
      {
        localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment).add(2131366323, this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment, this.jdField_a_of_type_Int + "").commit();
        return;
      }
      break;
    case 1: 
      if ((!this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.isAdded()) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag(this.jdField_a_of_type_Int + "") == null)) {
        localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment).add(2131366323, this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment, this.jdField_a_of_type_Int + "").commit();
      }
      for (;;)
      {
        astl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
        localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment).show(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment).commit();
      }
    }
    localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment).show(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment).commit();
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Boolean = asto.a(paramQQAppInterface).a(paramString);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setTabData(new String[] { paramContext.getResources().getString(2131720542), paramContext.getResources().getString(2131720543) }, new int[] { 0, 1 });
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setOnTabListener(new asrp(this));
  }
  
  private void b(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378152);
      if (localView != null) {
        if (!paramBoolean) {
          break label34;
        }
      }
    }
    label34:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private boolean b()
  {
    return (Build.VERSION.SDK_INT == 28) && ("samsung".equals(Build.MANUFACTURER)) && ("SM-G9750".equals(Build.MODEL));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContainer", 2, "initCardFragment");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardContainer", 2, "initCardFragment, mainfragment is not null");
      }
      return;
    }
    axqy.b(null, "dc00898", "", "", "0X800A212", "0X800A212", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment = new MultiCardFragment();
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_Long), this);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment = new MultiCardRecommendFragment();
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_Long));
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Int != 0) {
          continue;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment;
        if ((!((PublicBaseFragment)localObject).isAdded()) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag(this.jdField_a_of_type_Int + "") == null))
        {
          FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().beginTransaction();
          localFragmentTransaction.add(2131366323, (Fragment)localObject, this.jdField_a_of_type_Int + "");
          localFragmentTransaction.commitAllowingStateLoss();
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e("MultiCardContainer", 2, "initCardFragment exception:" + localException.toString());
        continue;
        int i = 0;
        continue;
      }
      if (this.jdField_a_of_type_Assi != null) {
        this.jdField_a_of_type_Assi.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, this);
      }
      i = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).getInt(aefs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0);
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardContainer", 2, " guideCount = " + i);
      }
      if (i >= 3) {
        continue;
      }
      i = 1;
      if (i != 0) {
        this.jdField_a_of_type_Int = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(this.jdField_a_of_type_Int, false);
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
      astl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment;
    }
  }
  
  public void a(long paramLong, ArrayList<Long> paramArrayList)
  {
    if (this.jdField_a_of_type_Long != paramLong) {}
    do
    {
      return;
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        b(true);
        a(null);
        return;
      }
      b(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment == null);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.a(paramArrayList, null, null);
  }
  
  public void a(long paramLong, HashMap<Long, String> paramHashMap)
  {
    if ((this.jdField_a_of_type_Long != paramLong) || (paramHashMap == null)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.a(null, null, paramHashMap);
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetTextView != null)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(null);
    }
  }
  
  public void a(ArrayList<Long> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayList == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onPreLoadData : ");
          localStringBuilder.append(paramArrayList.size());
          localStringBuilder.append("  ");
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext())
          {
            localStringBuilder.append((Long)localIterator.next());
            localStringBuilder.append(" ");
          }
          QLog.d("MultiCardContainer", 2, "onPreLoadData : " + localStringBuilder.toString());
        }
      } while (this.jdField_a_of_type_Assi == null);
      if (paramBoolean1) {
        this.jdField_a_of_type_Assi.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, paramArrayList, this);
      }
    } while (!paramBoolean2);
    this.jdField_a_of_type_Assi.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, paramArrayList, this);
  }
  
  public void a(HashMap<Long, IntimateInfo> paramHashMap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.a(null, paramHashMap, null);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment != null) && (!this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.onBackEvent())) {
      a(true);
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContainer", 2, "initData");
    }
    if (this.jdField_a_of_type_Assi != null) {
      this.jdField_a_of_type_Assi.a(this.jdField_a_of_type_Long);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContainer", 2, "unInitCardFragment");
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {}
    try
    {
      FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().beginTransaction();
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment != null) {
        localFragmentTransaction.remove(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment != null) {
        localFragmentTransaction.remove(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment);
      }
      localFragmentTransaction.commitAllowingStateLoss();
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardContainer", 2, "unInitCardFragment succ");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardContainer", 2, "unInitCardFragment excption:" + localException);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment = null;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContainer", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setOnTabListener(null);
    c();
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment = null;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment = null;
    if (this.jdField_a_of_type_Assi != null)
    {
      this.jdField_a_of_type_Assi.b(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Assi = null;
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void e()
  {
    a(false);
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_JavaLangLong != null) && (l - this.jdField_a_of_type_JavaLangLong.longValue() < 500L)) {
      return;
    }
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(l);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asrn
 * JD-Core Version:    0.7.0.1
 */