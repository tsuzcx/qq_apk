package com.qq.im.poi;

import ams;
import amt;
import amu;
import amv;
import amw;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.HorizontalListView.OnScrollLinstener;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import com.tencent.widget.LbsPackHorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class LbsPackListActivity
  extends LbsPackActivity
  implements LbsPackListAdapter.LbsPackItemCallback
{
  public static int a;
  public static int b;
  private float jdField_a_of_type_Float = 0.9F;
  private long jdField_a_of_type_Long;
  public Handler a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LbsPackListAdapter jdField_a_of_type_ComQqImPoiLbsPackListAdapter;
  private LbsPackManager jdField_a_of_type_ComQqImPoiLbsPackManager;
  public LbsPackObserver a;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public HorizontalListView.OnScrollLinstener a;
  public HorizontalListView.OnScrollStateChangedListener a;
  private LbsPackHorizontalListView jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 0.5F;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  public int c;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  public int d;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  public int e;
  private long e;
  public int f;
  private int g = -1;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public LbsPackListActivity()
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener = new amt(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollLinstener = new amu(this);
    this.jdField_a_of_type_AndroidOsHandler = new amv(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComQqImPoiLbsPackObserver = new amw(this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView = ((LbsPackHorizontalListView)findViewById(2131362855));
    this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.setOnScrollStateChangedListener(this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener);
    this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollLinstener);
    this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.setStayDisplayOffsetZero(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362856));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ams(this));
    int m = getResources().getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = ((int)(m * 0.025F));
    this.jdField_d_of_type_Int = ((int)(m * 0.8F));
    this.jdField_e_of_type_Int = (this.jdField_d_of_type_Int - this.jdField_c_of_type_Int - this.jdField_c_of_type_Int);
    this.f = ((int)(m * 0.1F));
    this.j = (this.jdField_d_of_type_Int + this.f);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getApplicationContext());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(this.f, -1));
    ProgressBar localProgressBar = new ProgressBar(getApplicationContext());
    localProgressBar.setIndeterminate(true);
    localProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130838602));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(18.0F, getResources()), AIOUtils.a(18.0F, getResources()));
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = ((this.f + this.jdField_c_of_type_Int - AIOUtils.a(18.0F, getResources())) / 2 - this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter = new LbsPackListAdapter(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface, getBaseContext(), this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.f, this);
    this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.setAdapter(this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter);
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.jdField_b_of_type_Long = localIntent.getLongExtra("task_id", 0L);
      this.jdField_a_of_type_Long = localIntent.getLongExtra("poi_id", 0L);
      this.h = localIntent.getIntExtra("task_type", 0);
      this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("business_name");
      this.i = localIntent.getIntExtra("distance", 0);
      this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("resPath");
      this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("logoPath");
      this.jdField_c_of_type_Long = localIntent.getLongExtra("adcode", 0L);
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("pid");
    }
    if (QLog.isColorLevel()) {
      QLog.i("LbsPack", 2, "mTaskId: " + this.jdField_b_of_type_Long + ", mPoiId: " + this.jdField_a_of_type_Long + ", mTaskType: " + this.h + ", mBusinessName: " + this.jdField_b_of_type_JavaLangString + ", mResPath: " + this.jdField_c_of_type_JavaLangString + ", logoPath: " + this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface != null)
    {
      this.jdField_a_of_type_ComQqImPoiLbsPackManager = ((LbsPackManager)this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getManager(214));
      this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.registObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "LbsPackListActivity sendLbsPackPageRequest true");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface != null) {
        LbsPackMapPoiPackServlet.a(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, true, this.jdField_c_of_type_Long);
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup2 = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup2.getChildAt(0);
      ViewGroup localViewGroup1 = localViewGroup2;
      if (localView != null)
      {
        localViewGroup1 = localViewGroup2;
        if ((localView instanceof ViewGroup)) {
          localViewGroup1 = (ViewGroup)localView;
        }
      }
      if ((localViewGroup1 instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localViewGroup1);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView == null) {}
    do
    {
      return;
      this.l = this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.a();
    } while (this.l <= 0);
    if (this.l - this.f >= 0)
    {
      this.k = ((this.l - this.f) / this.jdField_d_of_type_Int);
      return;
    }
    this.k = 0;
  }
  
  public void a()
  {
    e();
    if ((QLog.isColorLevel()) && (this.k != this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.getFirstVisiblePosition())) {
      QLog.w("LbsPack", 2, "LbsPackListActivity OnScrollStateChangedListener mCurrentItemPos wrong! offset=" + this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.a() + " mCurrentItemPos=" + this.k);
    }
    View localView = this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.b(this.k);
    if (localView != null) {
      a(localView);
    }
    localView = this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.b(this.k + 1);
    if (localView != null) {
      a(localView);
    }
    localView = this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.b(this.k + 2);
    if (localView != null) {
      a(localView);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramInt);
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "LbsPackListActivity onItemDeleteComplete get next page");
      }
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      LbsPackMapPoiPackServlet.a(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface, this.jdField_a_of_type_Long, false, this.jdField_c_of_type_Long);
    }
    if (this.jdField_a_of_type_JavaUtilList.size() <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "LbsPackListActivity onItemDeleteComplete  mPackInfoCache size=" + this.jdField_a_of_type_JavaUtilList.size() + " finish");
      }
      finish();
      overridePendingTransition(0, 2131034143);
    }
    if (this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "LbsPackListActivity onItemDeleteComplete  mPackInfoCache size=" + this.jdField_a_of_type_JavaUtilList.size() + " removeIndex=" + paramInt);
      }
      this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComQqImPoiLbsPackManager);
    }
  }
  
  @TargetApi(11)
  public void a(View paramView)
  {
    int m = paramView.getRight() - this.j;
    if (m > 0)
    {
      f1 = (float)Math.max((this.j - m) * 1.0D / this.j, 0.0001D);
      paramView.setScaleY((1.0F - this.jdField_a_of_type_Float) * f1 + this.jdField_a_of_type_Float);
      paramView.setAlpha(f1 * (1.0F - this.jdField_b_of_type_Float) + this.jdField_b_of_type_Float);
      return;
    }
    float f1 = (float)Math.max(Math.abs(m) * 1.0D / this.j, 0.0001D);
    paramView.setScaleY((this.jdField_a_of_type_Float - 1.0F) * f1 + 1.0F);
    paramView.setAlpha(f1 * (this.jdField_b_of_type_Float - 1.0F) + 1.0F);
  }
  
  public void a(LbsPackInfo paramLbsPackInfo, int paramInt)
  {
    if (System.currentTimeMillis() - this.jdField_d_of_type_Long < 500L)
    {
      QLog.d("LbsPack", 1, "onBtnClicked click too quick");
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      return;
    }
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("LbsPack", 2, "onBtnClicked  position: " + paramInt + " packInfo=" + paramLbsPackInfo);
    }
    ReportController.b(null, "dc01440", "", "", "0X8007A51", "0X8007A51", 0, 0, String.valueOf(paramLbsPackInfo.jdField_a_of_type_Long), "", "", "");
    if (paramLbsPackInfo.jdField_a_of_type_Int != 0)
    {
      ((LbsPackManager)this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getManager(214)).a(this, 2, paramLbsPackInfo, 0);
      return;
    }
    Intent localIntent = new Intent(this, LbsCaiShenActivity.class);
    localIntent.putExtra("k_pack_info", paramLbsPackInfo);
    localIntent.putExtra("resPath", this.jdField_c_of_type_JavaLangString);
    startActivityForResult(localIntent, 1);
  }
  
  public void b(LbsPackInfo paramLbsPackInfo, int paramInt)
  {
    new LbsPackShareOption(this, paramLbsPackInfo.jdField_b_of_type_JavaLangString, paramLbsPackInfo.jdField_b_of_type_Long, paramLbsPackInfo.jdField_d_of_type_JavaLangString).a(this);
    this.jdField_e_of_type_Long = paramLbsPackInfo.jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "onShareBtnClicked pack=" + paramLbsPackInfo);
    }
  }
  
  public void c(LbsPackInfo paramLbsPackInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LbsPack", 2, "onContenViewClicked  position: " + paramInt + " packInfo=" + paramLbsPackInfo);
    }
    if (this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter == null) {}
    while ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.getCount()) || (this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.b(paramInt, -this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.jdField_c_of_type_Int, 400);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    View localView = null;
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "doOnActivityResult" + paramIntent);
    }
    Object localObject;
    if (paramInt1 == 1)
    {
      setResult(paramInt2, paramIntent);
      if (paramInt2 == 1)
      {
        localObject = paramIntent.getStringExtra("k_pack_info");
        paramIntent.getIntExtra("k_lbs_key_state", -1);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      }
      else
      {
        return;
      }
      paramInt1 = 0;
      label81:
      if (paramInt1 >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label423;
      }
      paramIntent = (LbsPackInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
      if (TextUtils.equals(paramIntent.jdField_b_of_type_JavaLangString, (CharSequence)localObject)) {
        if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getAccount(), String.valueOf(paramIntent.jdField_a_of_type_Long))) {
          paramIntent.jdField_a_of_type_Int = 2;
        }
      }
    }
    label418:
    label423:
    for (paramInt1 = -1;; paramInt1 = -1)
    {
      if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_JavaUtilList.size()))
      {
        if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.getCount() - 1)) {
          break;
        }
        if (paramInt1 <= 0) {
          break label418;
        }
      }
      for (paramIntent = this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.b(paramInt1 - 1);; paramIntent = null)
      {
        if (paramInt1 < this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.getCount() - 2) {
          localView = this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.b(paramInt1 + 1);
        }
        localObject = this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView.b(paramInt1);
        this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.a(paramIntent, (View)localObject, localView, paramInt1);
        return;
        paramInt1 += 1;
        break label81;
        if (this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "LbsPackListActivity doOnActivityResult  mPackInfoCache size=" + this.jdField_a_of_type_JavaUtilList.size() + " removeIndex=" + paramInt1);
        }
        this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComQqImPoiLbsPackManager);
        return;
        if (((paramInt1 != 1000) && (paramInt1 != 1001)) || (paramInt2 != -1)) {
          break;
        }
        if (paramInt1 == 1000) {}
        for (paramInt1 = 2;; paramInt1 = 3)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LbsPack", 2, "onActivityResult sharedPoiId=" + this.jdField_e_of_type_Long);
          }
          if (this.jdField_e_of_type_Long == 0L) {
            break;
          }
          LbsPackShareOption.a(paramInt1, this.jdField_e_of_type_Long);
          this.jdField_e_of_type_Long = 0L;
          return;
        }
      }
    }
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    finish();
    overridePendingTransition(0, 2131034143);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2130968607);
    b();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.unRegistObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackListActivity
 * JD-Core Version:    0.7.0.1
 */