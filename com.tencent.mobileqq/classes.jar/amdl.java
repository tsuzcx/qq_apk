import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.adapter.MayKnowAdapter.5;
import com.tencent.mobileqq.adapter.MayKnowAdapter.7;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import mqq.app.AppRuntime;

public class amdl
  extends BaseAdapter
  implements View.OnClickListener, aobv, bklc
{
  private int jdField_a_of_type_Int;
  amdt jdField_a_of_type_Amdt;
  Activity jdField_a_of_type_AndroidAppActivity;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new amdm(this);
  anmu jdField_a_of_type_Anmu = new amds(this);
  anmw jdField_a_of_type_Anmw;
  anpk jdField_a_of_type_Anpk;
  protected aobu a;
  private bkle jdField_a_of_type_Bkle = new amdq(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  protected Runnable a;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  View.OnTouchListener jdField_b_of_type_AndroidViewView$OnTouchListener = new amdn(this);
  private Runnable jdField_b_of_type_JavaLangRunnable = new MayKnowAdapter.7(this);
  private int c;
  private int d;
  
  public amdl(Activity paramActivity, QQAppInterface paramQQAppInterface, HorizontalListView paramHorizontalListView, amdt paramamdt, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangRunnable = new MayKnowAdapter.5(this);
    paramHorizontalListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_Amdt = paramamdt;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Anmw = ((anmw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Anpk = ((anpk)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_Aobu = new aobu(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_Aobu.a(this);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = afur.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemScollEventListener(this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anmu);
    g();
    this.d = anpk.jdField_a_of_type_Int;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      switch (this.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(this.jdField_a_of_type_Bkle);
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "MayKnowAdapter ,mFriendObserver = " + this.jdField_a_of_type_Anmu);
      }
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
      return;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674D", "0X800674D", 0, 0, "", "", "", "");
      continue;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673E", "0X800673E", 0, 0, "", "", "", "");
      continue;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673F", "0X800673F", 0, 0, "", "", "", "");
      continue;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006773", "0X8006773", 0, 0, "", "", "", "");
    }
  }
  
  private View a()
  {
    int i = 0;
    View localView;
    if (i < this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount())
    {
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i);
      if ((localView != null) && ((localView.getTag() instanceof amdr)))
      {
        amdr localamdr = (amdr)localView.getTag();
        if ((localamdr == null) || (localamdr.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend == null) || (localamdr.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.friendStatus == 0)) {}
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "findTargetChangeStatusView view:" + localView);
      }
      return localView;
      i += 1;
      break;
      localView = null;
    }
  }
  
  private View a(String paramString)
  {
    int i = 0;
    View localView;
    if (i < this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount())
    {
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i);
      if ((localView != null) && ((localView.getTag() instanceof amdr)))
      {
        amdr localamdr = (amdr)localView.getTag();
        if ((localamdr == null) || (localamdr.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend == null) || (!TextUtils.equals(localamdr.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin, paramString))) {}
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "findTargetDeleteView view:" + localView + "   uin:" + paramString);
      }
      return localView;
      i += 1;
      break;
      localView = null;
    }
  }
  
  private void a(View paramView)
  {
    a(paramView, new amdo(this, paramView));
  }
  
  private void a(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    amdp localamdp = new amdp(this, paramView, paramView.getMeasuredWidth());
    if (paramAnimationListener != null) {
      localamdp.setAnimationListener(paramAnimationListener);
    }
    localamdp.setDuration(240L);
    paramView.startAnimation(localamdp);
  }
  
  private void f()
  {
    c();
    if (this.jdField_a_of_type_Anpk != null) {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Anpk.c();
    }
    notifyDataSetChanged();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      if (this.jdField_a_of_type_Amdt != null) {
        this.jdField_a_of_type_Amdt.a();
      }
    }
    while (this.jdField_a_of_type_Amdt == null) {
      return;
    }
    this.jdField_a_of_type_Amdt.b();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Anpk != null) {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Anpk.c();
    }
    notifyDataSetChanged();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      if (this.jdField_a_of_type_Amdt != null) {
        this.jdField_a_of_type_Amdt.a();
      }
    }
    while (this.jdField_a_of_type_Amdt == null) {
      return;
    }
    this.jdField_a_of_type_Amdt.b();
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Aobu.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Aobu.a()) {
      this.jdField_a_of_type_Aobu.a(paramString, paramInt, true, (byte)0);
    }
    return bgmo.a();
  }
  
  public MayKnowRecommend a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "getItem Illegal Adapter with overflowed data,position =  " + paramInt);
    }
    return new MayKnowRecommend();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "startVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition());
    }
    int i;
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown()) && (this.jdField_a_of_type_Anpk != null)) {
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    }
    for (;;)
    {
      if ((i > this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition()) || (i < 0)) {
        return;
      }
      this.jdField_a_of_type_Anpk.a(a(i), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
      i += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onItemScrollNonVisible " + paramInt + " fromLeft=" + paramBoolean);
    }
    if (this.jdField_a_of_type_Anpk != null) {
      this.jdField_a_of_type_Anpk.b(a(paramInt), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
    }
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "stopVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition());
    }
    int i;
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown()) && (this.jdField_a_of_type_Anpk != null)) {
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    }
    for (;;)
    {
      if ((i > this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition()) || (i < 0)) {
        return;
      }
      this.jdField_a_of_type_Anpk.b(a(i), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
      i += 1;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "destroy");
    }
    if (this.jdField_a_of_type_Aobu != null) {
      this.jdField_a_of_type_Aobu.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anmu);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
      {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(null);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      this.jdField_a_of_type_Anmw = null;
      this.jdField_a_of_type_Anpk = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      return;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((QQAppInterface)localAppRuntime).removeObserver(this.jdField_a_of_type_Anmu);
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown()) && (this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int i = j;
      while (i <= k)
      {
        if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.get(i) != null))
        {
          localArrayList1.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).uin);
          localArrayList2.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).recommendReason);
          localArrayList3.add(Integer.valueOf(i));
          localArrayList4.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).algBuffer);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "reportRecommendFrdExpose firstVisibleItem: " + j + " lastVisibleItem: " + k + " exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      if ((!localArrayList1.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 1, null);
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > this.d) {
      return this.d;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "getView position: " + paramInt);
    }
    amdr localamdr = null;
    if (paramView != null) {
      localamdr = (amdr)paramView.getTag();
    }
    if ((paramView == null) || (localamdr == null) || (localamdr.jdField_a_of_type_Boolean) || (!TextUtils.equals(localamdr.jdField_b_of_type_JavaLangString, ThemeUtil.curThemeId)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558470, paramViewGroup, false);
      localamdr = new amdr();
      localamdr.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367857));
      localamdr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371719));
      localamdr.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      localamdr.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367235));
      localamdr.c = ((TextView)paramView.findViewById(2131361944));
      localamdr.d = ((TextView)paramView.findViewById(2131362136));
      localamdr.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364539);
      localamdr.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      localamdr.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      localamdr.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localamdr.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
      if ((localamdr.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localamdr.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
      }
      localamdr.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      localamdr.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramView.setTag(localamdr);
      if (this.jdField_a_of_type_Int != 25)
      {
        localamdr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166986));
        localamdr.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167074));
      }
      localamdr.jdField_b_of_type_JavaLangString = ThemeUtil.curThemeId;
    }
    for (;;)
    {
      MayKnowRecommend localMayKnowRecommend = a(paramInt);
      if (this.jdField_a_of_type_Anpk != null) {
        this.jdField_a_of_type_Anpk.a(localMayKnowRecommend, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localamdr.jdField_a_of_type_JavaLangString = localMayKnowRecommend.uin;
      localamdr.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
      localamdr.jdField_a_of_type_AndroidViewView.setTag(localMayKnowRecommend);
      localamdr.jdField_a_of_type_AndroidWidgetImageView.setTag(localamdr);
      localamdr.jdField_a_of_type_AndroidWidgetTextView.setTag(localamdr);
      localamdr.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, localamdr.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_Anpk != null) {}
      for (boolean bool = this.jdField_a_of_type_Anpk.a();; bool = false)
      {
        String str = localMayKnowRecommend.getDisplayName(bool);
        localamdr.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        if ((AppSetting.c) && (!TextUtils.isEmpty(str))) {
          localStringBuilder.append(str);
        }
        if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason))
        {
          localamdr.jdField_b_of_type_AndroidWidgetTextView.setText(localMayKnowRecommend.recommendReason);
          if (AppSetting.c) {
            localStringBuilder.append(",你们有").append(localMayKnowRecommend.recommendReason);
          }
          if (localMayKnowRecommend.friendStatus != 0) {
            break label701;
          }
          localamdr.c.setVisibility(0);
          localamdr.c.setTag(localMayKnowRecommend);
          localamdr.d.setVisibility(8);
          localamdr.c.setOnClickListener(this);
          if (AppSetting.c)
          {
            localamdr.c.setContentDescription(anni.a(2131689550));
            localStringBuilder.append(",添加他为好友");
          }
          label636:
          if (paramInt != getCount() - 1) {
            break label848;
          }
          paramView.setPadding(0, 0, this.c, 0);
        }
        for (;;)
        {
          if (AppSetting.c) {
            paramView.setContentDescription(localStringBuilder.toString());
          }
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localamdr.jdField_b_of_type_AndroidWidgetTextView.setText("");
          break;
          label701:
          if (localMayKnowRecommend.friendStatus == 1)
          {
            localamdr.c.setVisibility(8);
            localamdr.d.setVisibility(0);
            localamdr.d.setText(2131717330);
            if (!AppSetting.c) {
              break label636;
            }
            localamdr.d.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717330));
            localStringBuilder.append(",等待验证");
            break label636;
          }
          localamdr.c.setVisibility(8);
          localamdr.d.setVisibility(0);
          localamdr.d.setText(2131689975);
          if (!AppSetting.c) {
            break label636;
          }
          localamdr.d.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689975));
          localStringBuilder.append(",已添加");
          break label636;
          label848:
          paramView.setPadding(0, 0, 0, 0);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject1;
    boolean bool;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            localObject1 = (MayKnowRecommend)paramView.getTag();
          } while (localObject1 == null);
          if ((this.jdField_a_of_type_Anmw != null) && (!this.jdField_a_of_type_Anmw.b(((MayKnowRecommend)localObject1).uin)) && (!this.jdField_a_of_type_Anmw.d(((MayKnowRecommend)localObject1).uin)))
          {
            bool = false;
            if (this.jdField_a_of_type_Anpk != null) {
              bool = this.jdField_a_of_type_Anpk.a();
            }
            localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
            localObject2 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidAppActivity, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, this.jdField_a_of_type_Int, (String)localObject2, null, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131689550), null);
            ((Intent)localObject2).putExtra("key_param_age_area", bghy.a(this.jdField_a_of_type_AndroidAppActivity, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
            this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
              switch (this.jdField_b_of_type_Int)
              {
              }
            }
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Anpk != null) {
              this.jdField_a_of_type_Anpk.a((MayKnowRecommend)localObject1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 3);
            }
            if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
              break;
            }
            ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_add", this.jdField_a_of_type_Int, 1, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 1);
            break;
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006750", "0X8006750", 0, 0, "", "", "", "");
            continue;
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006744", "0X8006744", 0, 0, "", "", "", "");
            continue;
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006745", "0X8006745", 0, 0, "", "", "", "");
            continue;
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006771", "0X8006771", 0, 0, "", "", "", "");
            continue;
            if ((this.jdField_a_of_type_Anmw != null) && (this.jdField_a_of_type_Anmw.b(((MayKnowRecommend)localObject1).uin)))
            {
              ((MayKnowRecommend)localObject1).friendStatus = 2;
              notifyDataSetChanged();
            }
            else
            {
              ((MayKnowRecommend)localObject1).friendStatus = 1;
              notifyDataSetChanged();
            }
          }
          localObject1 = (MayKnowRecommend)paramView.getTag();
        } while ((localObject1 == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f(((MayKnowRecommend)localObject1).uin);
        switch (this.jdField_b_of_type_Int)
        {
        }
        while ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_dlt", this.jdField_a_of_type_Int, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 1);
          break;
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674F", "0X800674F", 0, 0, "", "", "", "");
          continue;
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006742", "0X8006742", 0, 0, "", "", "", "");
          continue;
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006743", "0X8006743", 0, 0, "", "", "", "");
          continue;
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006772", "0X8006772", 0, 0, "", "", "", "");
        }
        localObject1 = (amdr)paramView.getTag();
      } while (localObject1 == null);
      localObject1 = ((amdr)localObject1).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
    } while (localObject1 == null);
    int i = 84;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      label872:
      int j = i;
      if (this.jdField_a_of_type_Anmw != null)
      {
        j = i;
        if (this.jdField_a_of_type_Anmw.b(((MayKnowRecommend)localObject1).uin)) {
          j = 1;
        }
      }
      localObject2 = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject1).uin, j);
      bool = false;
      if (this.jdField_a_of_type_Anpk != null) {
        bool = this.jdField_a_of_type_Anpk.a();
      }
      Object localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(bool);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((ProfileActivity.AllInOne)localObject2).l = ((String)localObject3);
      }
      if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((MayKnowRecommend)localObject1).nick;
      }
      ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 88;
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
      if (this.jdField_a_of_type_JavaUtilList != null) {
        ((Bundle)localObject3).putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(localObject1));
      }
      ((Bundle)localObject3).putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
      ((Bundle)localObject3).putInt("key_display_type", 1);
      ProfileActivity.a(this.jdField_a_of_type_AndroidAppActivity, (ProfileActivity.AllInOne)localObject2, (Bundle)localObject3);
      if (this.jdField_a_of_type_Anpk != null) {
        this.jdField_a_of_type_Anpk.a((MayKnowRecommend)localObject1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        switch (this.jdField_b_of_type_Int)
        {
        }
      }
      break;
    }
    while ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", this.jdField_a_of_type_Int, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 1);
      break;
      i = 82;
      break label872;
      i = 81;
      break label872;
      i = 83;
      break label872;
      i = 102;
      break label872;
      i = 107;
      break label872;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674E", "0X800674E", 0, 0, "", "", "", "");
      continue;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006740", "0X8006740", 0, 0, "", "", "", "");
      continue;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006741", "0X8006741", 0, 0, "", "", "", "");
      continue;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678A", "0X800678A", 0, 0, "", "", "", "");
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof amdr)))
        {
          paramString = (amdr)paramString;
          if ((paramString != null) && (paramString.jdField_a_of_type_JavaLangString != null) && (paramString.jdField_a_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_a_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdl
 * JD-Core Version:    0.7.0.1
 */