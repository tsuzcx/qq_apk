package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;

public class MultiMembersAudioUI
  extends LinearLayout
  implements MultiMembersUI
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new MultiMembersAudioUI.1(this);
  ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  MultiMembersAudioIndicator jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator;
  MultiMembersAudioUI.MemberPagerAdapter jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$MemberPagerAdapter;
  MultiVideoMembersClickListener jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = null;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  ArrayList<MultiMembersUI.MVMembersInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  final int[] jdField_a_of_type_ArrayOfInt = { 2131370736, 2131370737, 2131370738, 2131370739, 2131370740, 2131370741, 2131370742, 2131370743 };
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  
  @TargetApi(9)
  public MultiMembersAudioUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOrientation(1);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    paramContext = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get activity");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramContext.getAppRuntime());
    paramAttributeSet = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (paramAttributeSet == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get AppRuntime");
      }
      paramContext.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = paramAttributeSet.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get videoControl");
      }
      paramContext.finish();
      return;
    }
    int i = (int)UITools.a(getContext(), 170.0F);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = new ViewPager(super.getContext());
    paramContext = new LinearLayout.LayoutParams(-1, i);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setLayoutParams(paramContext);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setFocusable(false);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setFocusableInTouchMode(false);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$MemberPagerAdapter = new MultiMembersAudioUI.MemberPagerAdapter(this);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setAdapter(this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$MemberPagerAdapter);
    super.addView(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator = new MultiMembersAudioIndicator(super.getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator.setLayoutParams(paramContext);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator.setViewPager(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager);
    super.addView(this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator);
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    if (paramImageView != null) {
      paramImageView.setVisibility(paramInt);
    }
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt < 8) && ((this.jdField_a_of_type_JavaUtilArrayList.size() != 8) || (paramInt != 7))) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[random room owner] member is null index=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",uin=");
      QLog.e("MultiMembersAudioUI", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1 - 1) {
      return -1;
    }
    switch (paramInt1)
    {
    default: 
      return -1;
    case 7: 
    case 8: 
      return this.jdField_a_of_type_ArrayOfInt[paramInt2];
    case 6: 
      if (paramInt2 < 3) {
        return this.jdField_a_of_type_ArrayOfInt[paramInt2];
      }
      return this.jdField_a_of_type_ArrayOfInt[(paramInt2 + 1)];
    case 5: 
      if (paramInt2 < 3) {
        return this.jdField_a_of_type_ArrayOfInt[paramInt2];
      }
      return this.jdField_a_of_type_ArrayOfInt[(paramInt2 + 1)];
    case 4: 
      if (paramInt2 < 2) {
        return this.jdField_a_of_type_ArrayOfInt[paramInt2];
      }
      return this.jdField_a_of_type_ArrayOfInt[(paramInt2 + 2)];
    case 3: 
      return this.jdField_a_of_type_ArrayOfInt[paramInt2];
    case 2: 
      return this.jdField_a_of_type_ArrayOfInt[paramInt2];
    }
    return this.jdField_a_of_type_ArrayOfInt[0];
  }
  
  int a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return -1;
    }
    int i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      if (((MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  View a(int paramInt)
  {
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    Object localObject1 = null;
    Object localObject3 = null;
    if (localObject2 == null) {
      return null;
    }
    if (a(paramInt)) {
      return null;
    }
    if (paramInt < 0) {
      return null;
    }
    if (paramInt >= this.jdField_b_of_type_Int) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$MemberPagerAdapter == null) {
      return null;
    }
    int i = paramInt + 1;
    int j = i / 8;
    if (i % 8 == 0) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    j = j + paramInt - 1;
    if (j == this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$MemberPagerAdapter.getCount() - 1) {
      paramInt = this.jdField_b_of_type_Int - j * 8;
    } else {
      paramInt = 8;
    }
    try
    {
      localObject2 = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MemberPagerAdapter_");
      localStringBuilder.append(j);
      localObject2 = ((ViewPager)localObject2).findViewWithTag(localStringBuilder.toString());
      if (localObject2 != null)
      {
        localObject1 = ((View)localObject2).findViewById(a(paramInt, i - j * 8 - 1));
        try
        {
          localObject2 = (MultiMembersUI.Holder)((View)localObject1).getTag();
          if (localObject2 != null)
          {
            boolean bool = ((MultiMembersUI.Holder)localObject2).jdField_c_of_type_Boolean;
            if (!bool) {
              break label310;
            }
          }
          return null;
        }
        catch (Exception localException1) {}
      }
      else
      {
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          break label306;
        }
        QLog.e("MultiMembersAudioUI", 2, "[random room owner] page is null");
        localObject2 = localObject1;
      }
    }
    catch (Exception localException2)
    {
      localObject1 = localObject3;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[random room owner] ");
        ((StringBuilder)localObject2).append(localException2.getMessage());
        QLog.e("MultiMembersAudioUI", 2, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
      }
    }
    label306:
    localObject1 = localObject2;
    label310:
    return localObject1;
  }
  
  MultiMembersUI.Holder a(View paramView)
  {
    MultiMembersUI.Holder localHolder = new MultiMembersUI.Holder();
    localHolder.d = ((ImageView)paramView.findViewById(2131373409));
    localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373425));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().E == 7) {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (bool) {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      } else {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#445a6c"));
      }
      if (bool)
      {
        localHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373428));
        int i = AIOUtils.b(15.0F, getResources());
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(1);
        localGradientDrawable.setColor(Color.parseColor("#4C000000"));
        localGradientDrawable.setSize(i, i);
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(localGradientDrawable);
      }
    }
    localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373427));
    localHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373415));
    localHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373411));
    localHolder.e = ((ImageView)paramView.findViewById(2131373424));
    localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131373563));
    localHolder.f = ((ImageView)paramView.findViewById(2131373410));
    return localHolder;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_b_of_type_Int) {
        break;
      }
      if (!((MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_d_of_type_Boolean)
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if (j != 0) {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$MemberPagerAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("refreshMemMicState. uin = ");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append(", accType = ");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(", pstnStatus = ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(", isMicOff = ");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.d("MultiMembersAudioUI", 2, ((StringBuilder)localObject1).toString());
    paramInt1 = a(paramLong);
    if (paramInt1 == -1)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyDataSetChanged-->this member not in infoList.uin=");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(",isMicOff=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.e("MultiMembersAudioUI", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    localObject1 = (MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
    if (((MultiMembersUI.MVMembersInfo)localObject1).e == paramBoolean) {
      return;
    }
    ((MultiMembersUI.MVMembersInfo)localObject1).e = paramBoolean;
    Object localObject2 = a(paramInt1);
    if (localObject2 == null) {
      return;
    }
    if (((View)localObject2).getTag() == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyDataSetChanged-->can not get tag from uin-->index=");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(",uin=");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(",isMicOff=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.e("MultiMembersAudioUI", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    localObject2 = (MultiMembersUI.Holder)((View)localObject2).getTag();
    if (localObject2 == null) {
      return;
    }
    if (paramBoolean)
    {
      if (((MultiMembersUI.Holder)localObject2).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        ((MultiMembersUI.Holder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        a(((MultiMembersUI.Holder)localObject2).jdField_b_of_type_AndroidWidgetImageView, 8);
      }
      if (((MultiMembersUI.Holder)localObject2).e.getVisibility() != 0) {
        ((MultiMembersUI.Holder)localObject2).e.setVisibility(0);
      }
    }
    else
    {
      if (((MultiMembersUI.Holder)localObject2).e.getVisibility() == 0) {
        ((MultiMembersUI.Holder)localObject2).e.setVisibility(8);
      }
      if (((MultiMembersUI.MVMembersInfo)localObject1).jdField_a_of_type_Boolean)
      {
        ((MultiMembersUI.Holder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(((MultiMembersUI.Holder)localObject2).jdField_b_of_type_AndroidWidgetImageView, 0);
        return;
      }
      ((MultiMembersUI.Holder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      a(((MultiMembersUI.Holder)localObject2).jdField_b_of_type_AndroidWidgetImageView, 8);
    }
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initMVMLayout relationUin: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", relationType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", bEnterPage: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MultiMembersAudioUI", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i = a(paramLong);
    if (i == -1)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyDataSetChanged-->this member not in infoList.uin=");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(",bSpeak=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.e("MultiMembersAudioUI", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject1 = (MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    if (((MultiMembersUI.MVMembersInfo)localObject1).jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    ((MultiMembersUI.MVMembersInfo)localObject1).jdField_a_of_type_Boolean = paramBoolean;
    Object localObject2 = a(i);
    if (localObject2 == null) {
      return;
    }
    if (((View)localObject2).getTag() == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyDataSetChanged-->can not get tag from uin-->index=");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(",uin=");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(",isSpeak=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.e("MultiMembersAudioUI", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    localObject2 = (MultiMembersUI.Holder)((View)localObject2).getTag();
    if (localObject2 == null) {
      return;
    }
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().E != 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().j != 10))
    {
      bool = paramBoolean;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().E != 2) {}
    }
    else if (((MultiMembersUI.MVMembersInfo)localObject1).e)
    {
      if (((MultiMembersUI.Holder)localObject2).e.getVisibility() != 0) {
        ((MultiMembersUI.Holder)localObject2).e.setVisibility(0);
      }
      if (((MultiMembersUI.Holder)localObject2).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        ((MultiMembersUI.Holder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        a(((MultiMembersUI.Holder)localObject2).jdField_b_of_type_AndroidWidgetImageView, 8);
      }
      ((MultiMembersUI.MVMembersInfo)localObject1).jdField_a_of_type_Boolean = false;
      bool = false;
    }
    else
    {
      bool = paramBoolean;
      if (((MultiMembersUI.Holder)localObject2).e.getVisibility() == 0)
      {
        ((MultiMembersUI.Holder)localObject2).e.setVisibility(8);
        bool = paramBoolean;
      }
    }
    if ((bool) && (((MultiMembersUI.Holder)localObject2).jdField_b_of_type_Boolean))
    {
      if (((MultiMembersUI.Holder)localObject2).jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)
      {
        ((MultiMembersUI.Holder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(((MultiMembersUI.Holder)localObject2).jdField_b_of_type_AndroidWidgetImageView, 0);
      }
    }
    else if (((MultiMembersUI.Holder)localObject2).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      ((MultiMembersUI.Holder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      a(((MultiMembersUI.Holder)localObject2).jdField_b_of_type_AndroidWidgetImageView, 8);
    }
    if (this.jdField_a_of_type_Int == 7)
    {
      ((MultiMembersUI.Holder)localObject2).jdField_b_of_type_Int = ((MultiMembersUI.MVMembersInfo)localObject1).jdField_d_of_type_Int;
      i = ((MultiMembersUI.Holder)localObject2).jdField_b_of_type_Int;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 4) {
            ((MultiMembersUI.Holder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841980);
          }
        }
        else {
          ((MultiMembersUI.Holder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841978);
        }
      }
      else {
        ((MultiMembersUI.Holder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841982);
      }
      if (((MultiMembersUI.Holder)localObject2).jdField_b_of_type_Int != 0) {
        ((MultiMembersUI.Holder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    View localView1 = paramView.findViewById(2131364868);
    View localView2 = paramView.findViewById(2131364869);
    View localView3 = paramView.findViewById(2131370736);
    View localView4 = paramView.findViewById(2131370737);
    View localView5 = paramView.findViewById(2131370738);
    View localView6 = paramView.findViewById(2131370739);
    View localView7 = paramView.findViewById(2131370740);
    View localView8 = paramView.findViewById(2131370741);
    View localView9 = paramView.findViewById(2131370742);
    paramView = paramView.findViewById(2131370743);
    if ((localView1 != null) && (localView2 != null) && (localView3 != null) && (localView4 != null) && (localView5 != null) && (localView6 != null) && (localView7 != null) && (localView8 != null) && (localView9 != null))
    {
      if (paramView == null) {
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
      switch (paramInt)
      {
      default: 
        localView1.setVisibility(8);
        localView2.setVisibility(8);
        return;
      case 8: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(0);
        localView6.setVisibility(0);
        localLayoutParams.addRule(15, 0);
        localLayoutParams.addRule(10);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(0);
        localView7.setVisibility(0);
        localView8.setVisibility(0);
        localView9.setVisibility(0);
        paramView.setVisibility(0);
        return;
      case 7: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(0);
        localView6.setVisibility(0);
        localLayoutParams.addRule(15, 0);
        localLayoutParams.addRule(10);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(0);
        localView7.setVisibility(0);
        localView8.setVisibility(0);
        localView9.setVisibility(0);
        paramView.setVisibility(8);
        return;
      case 6: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(0);
        localView6.setVisibility(8);
        localLayoutParams.addRule(15, 0);
        localLayoutParams.addRule(10);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(0);
        localView7.setVisibility(0);
        localView8.setVisibility(0);
        localView9.setVisibility(0);
        paramView.setVisibility(8);
        return;
      case 5: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(0);
        localView6.setVisibility(8);
        localLayoutParams.addRule(15, 0);
        localLayoutParams.addRule(10);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(0);
        localView7.setVisibility(0);
        localView8.setVisibility(0);
        localView9.setVisibility(8);
        paramView.setVisibility(8);
        return;
      case 4: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(8);
        localView6.setVisibility(8);
        localLayoutParams.addRule(15, 0);
        localLayoutParams.addRule(10);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(0);
        localView7.setVisibility(0);
        localView8.setVisibility(0);
        localView9.setVisibility(8);
        paramView.setVisibility(8);
        return;
      case 3: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(0);
        localView6.setVisibility(8);
        localLayoutParams.addRule(15);
        localLayoutParams.addRule(10, 0);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(8);
        return;
      case 2: 
        localView1.setVisibility(0);
        localView3.setVisibility(0);
        localView4.setVisibility(0);
        localView5.setVisibility(8);
        localView6.setVisibility(8);
        localLayoutParams.addRule(15);
        localLayoutParams.addRule(10, 0);
        localView1.setLayoutParams(localLayoutParams);
        localView2.setVisibility(8);
        return;
      }
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(8);
      localView5.setVisibility(8);
      localView6.setVisibility(8);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(8);
    }
  }
  
  public void a(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    b(paramArrayList);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator.a();
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$MemberPagerAdapter.notifyDataSetChanged();
  }
  
  void b(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshDataSource, friends[");
      if (paramArrayList != null) {
        i = paramArrayList.size();
      } else {
        i = -1;
      }
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], mInfoList[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      ((StringBuilder)localObject).append("]");
      QLog.w("MultiMembersAudioUI", 1, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramArrayList != null)
    {
      i = 0;
      while (i < paramArrayList.size())
      {
        localObject = (VideoController.GAudioFriends)paramArrayList.get(i);
        MultiMembersUI.MVMembersInfo localMVMembersInfo = new MultiMembersUI.MVMembersInfo();
        localMVMembersInfo.jdField_a_of_type_Long = ((VideoController.GAudioFriends)localObject).jdField_a_of_type_Long;
        localMVMembersInfo.jdField_a_of_type_Int = ((VideoController.GAudioFriends)localObject).jdField_b_of_type_Int;
        localMVMembersInfo.jdField_b_of_type_Boolean = ((VideoController.GAudioFriends)localObject).jdField_b_of_type_Boolean;
        localMVMembersInfo.jdField_a_of_type_Boolean = ((VideoController.GAudioFriends)localObject).jdField_a_of_type_Boolean;
        localMVMembersInfo.jdField_c_of_type_Boolean = ((VideoController.GAudioFriends)localObject).jdField_c_of_type_Boolean;
        localMVMembersInfo.jdField_b_of_type_Int = ((VideoController.GAudioFriends)localObject).jdField_d_of_type_Int;
        localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        localMVMembersInfo.e = ((VideoController.GAudioFriends)localObject).e;
        localMVMembersInfo.jdField_d_of_type_Int = ((VideoController.GAudioFriends)localObject).f;
        localMVMembersInfo.f = ((VideoController.GAudioFriends)localObject).h;
        this.jdField_a_of_type_JavaUtilArrayList.add(localMVMembersInfo);
        i += 1;
      }
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = this.jdField_a_of_type_Int;
    if (((i == 1) || (i == 2)) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 8)) {
      this.jdField_b_of_type_Int = 8;
    }
  }
  
  public void setIsEnterpage(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setOnItemClickListener(MultiVideoMembersClickListener paramMultiVideoMembersClickListener)
  {
    this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = paramMultiVideoMembersClickListener;
  }
  
  public void setRandomMultiIsMask(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRandomMultiIsMask isMask: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MultiMembersAudioUI", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersAudioUI
 * JD-Core Version:    0.7.0.1
 */