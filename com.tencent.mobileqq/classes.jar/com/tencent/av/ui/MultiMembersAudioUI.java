package com.tencent.av.ui;

import actj;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import ldr;
import lga;
import meu;
import mev;
import mey;
import mez;
import mfa;
import mqq.app.BaseActivity;
import mru;
import muc;

public class MultiMembersAudioUI
  extends LinearLayout
  implements mey
{
  public int a;
  public long a;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public View.OnClickListener a;
  public VideoController a;
  public VideoAppInterface a;
  MultiMembersAudioIndicator jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  public ArrayList<mfa> a;
  mev jdField_a_of_type_Mev;
  public mru a;
  public boolean a;
  final int[] jdField_a_of_type_ArrayOfInt = { 2131369852, 2131369853, 2131369854, 2131369855, 2131369856, 2131369857, 2131369858, 2131369859 };
  public int b;
  public boolean b;
  
  @TargetApi(9)
  public MultiMembersAudioUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Mru = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new meu(this);
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
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get AppRuntime");
      }
      paramContext.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get videoControl");
      }
      paramContext.finish();
      return;
    }
    int i = (int)muc.a(getContext(), 170.0F);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = new ViewPager(super.getContext());
    paramContext = new LinearLayout.LayoutParams(-1, i);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setLayoutParams(paramContext);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setFocusable(false);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setFocusableInTouchMode(false);
    this.jdField_a_of_type_Mev = new mev(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_Mev);
    super.addView(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator = new MultiMembersAudioIndicator(super.getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator.setLayoutParams(paramContext);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
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
    if ((paramInt >= 8) || ((this.jdField_a_of_type_JavaUtilArrayList.size() == 8) && (paramInt == 7)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "[random room owner] member is null index=" + paramInt + ",uin=");
      }
      return true;
    }
    return false;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1 - 1) {
      return -1;
    }
    switch (paramInt1)
    {
    default: 
      return -1;
    case 1: 
      return this.jdField_a_of_type_ArrayOfInt[0];
    case 2: 
      return this.jdField_a_of_type_ArrayOfInt[paramInt2];
    case 3: 
      return this.jdField_a_of_type_ArrayOfInt[paramInt2];
    case 4: 
      if (paramInt2 < 2) {
        return this.jdField_a_of_type_ArrayOfInt[paramInt2];
      }
      return this.jdField_a_of_type_ArrayOfInt[(paramInt2 + 2)];
    case 5: 
      if (paramInt2 < 3) {
        return this.jdField_a_of_type_ArrayOfInt[paramInt2];
      }
      return this.jdField_a_of_type_ArrayOfInt[(paramInt2 + 1)];
    case 6: 
      if (paramInt2 < 3) {
        return this.jdField_a_of_type_ArrayOfInt[paramInt2];
      }
      return this.jdField_a_of_type_ArrayOfInt[(paramInt2 + 1)];
    }
    return this.jdField_a_of_type_ArrayOfInt[paramInt2];
  }
  
  public int a(long paramLong)
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_b_of_type_Int) {
        break label52;
      }
      j = i;
      if (((mfa)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long == paramLong) {
        break;
      }
      i += 1;
    }
    label52:
    return -1;
  }
  
  View a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    while ((a(paramInt)) || (paramInt < 0) || (paramInt >= this.jdField_b_of_type_Int) || (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) || (this.jdField_a_of_type_Mev == null)) {
      return null;
    }
    int j = (paramInt + 1) / 8;
    int i;
    if ((paramInt + 1) % 8 == 0)
    {
      i = 0;
      label61:
      j = i + j - 1;
      i = 8;
      if (j == this.jdField_a_of_type_Mev.getCount() - 1) {
        i = this.jdField_b_of_type_Int - j * 8;
      }
    }
    for (;;)
    {
      for (;;)
      {
        View localView;
        Object localObject;
        try
        {
          localView = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.findViewWithTag("MemberPagerAdapter_" + j);
          if (localView != null) {
            localView = localView.findViewById(a(i, paramInt + 1 - j * 8 - 1));
          }
        }
        catch (Exception localException1)
        {
          boolean bool;
          localView = null;
        }
        try
        {
          localObject = (mez)localView.getTag();
          if (localObject == null) {
            break;
          }
          bool = ((mez)localObject).jdField_c_of_type_Boolean;
          if (bool) {
            break;
          }
          localObject = localView;
          return localObject;
        }
        catch (Exception localException2)
        {
          label212:
          break label212;
        }
      }
      i = 1;
      break label61;
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "[random room owner] page is null");
      }
      localObject = null;
      continue;
      localObject = localView;
      if (QLog.isColorLevel())
      {
        QLog.e("MultiMembersAudioUI", 2, "[random room owner] " + localException1.getMessage());
        localObject = localView;
      }
    }
  }
  
  public mez a(View paramView)
  {
    mez localmez = new mez();
    localmez.d = ((ImageView)paramView.findViewById(2131372274));
    localmez.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372290));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().E == 7) {
      localmez.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    boolean bool;
    if (this.jdField_b_of_type_Boolean)
    {
      bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (!bool) {
        break label261;
      }
      localmez.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
    }
    for (;;)
    {
      if (bool)
      {
        localmez.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372293));
        int i = actj.a(15.0F, getResources());
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(1);
        localGradientDrawable.setColor(Color.parseColor("#4C000000"));
        localGradientDrawable.setSize(i, i);
        localmez.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(localGradientDrawable);
      }
      localmez.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372292));
      localmez.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372280));
      localmez.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372276));
      localmez.e = ((ImageView)paramView.findViewById(2131372289));
      localmez.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372427));
      localmez.f = ((ImageView)paramView.findViewById(2131372275));
      return localmez;
      label261:
      localmez.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#445a6c"));
    }
  }
  
  public void a()
  {
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_b_of_type_Int)
      {
        if (!((mfa)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_d_of_type_Boolean) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        this.jdField_a_of_type_Mev.notifyDataSetChanged();
        return;
      }
      i += 1;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt1 = a(paramLong);
    if (paramInt1 == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",isMicOff=" + paramBoolean);
      }
    }
    mfa localmfa;
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localmfa = (mfa)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
            } while (localmfa.e == paramBoolean);
            localmfa.e = paramBoolean;
            localObject = a(paramInt1);
          } while (localObject == null);
          if (((View)localObject).getTag() != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("MultiMembersAudioUI", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + paramInt1 + ",uin=" + paramLong + ",isMicOff=" + paramBoolean);
        return;
        localObject = (mez)((View)localObject).getTag();
      } while (localObject == null);
      if (!paramBoolean) {
        break;
      }
      if (((mez)localObject).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        ((mez)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        a(((mez)localObject).jdField_b_of_type_AndroidWidgetImageView, 8);
      }
    } while (((mez)localObject).e.getVisibility() == 0);
    ((mez)localObject).e.setVisibility(0);
    return;
    if (((mez)localObject).e.getVisibility() == 0) {
      ((mez)localObject).e.setVisibility(8);
    }
    if (localmfa.jdField_a_of_type_Boolean)
    {
      ((mez)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      a(((mez)localObject).jdField_b_of_type_AndroidWidgetImageView, 0);
      return;
    }
    ((mez)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    a(((mez)localObject).jdField_b_of_type_AndroidWidgetImageView, 8);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMembersAudioUI", 2, "initMVMLayout relationUin: " + paramLong + ", relationType: " + paramInt + ", bEnterPage: " + paramBoolean);
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i = a(paramLong);
    if (i == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",bSpeak=" + paramBoolean);
      }
    }
    label332:
    label511:
    for (;;)
    {
      return;
      mfa localmfa = (mfa)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localmfa.jdField_a_of_type_Boolean != paramBoolean)
      {
        localmfa.jdField_a_of_type_Boolean = paramBoolean;
        Object localObject = a(i);
        if (localObject != null) {
          if (((View)localObject).getTag() == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MultiMembersAudioUI", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + i + ",uin=" + paramLong + ",isSpeak=" + paramBoolean);
            }
          }
          else
          {
            localObject = (mez)((View)localObject).getTag();
            if (localObject != null)
            {
              boolean bool;
              if ((this.jdField_a_of_type_ComTencentAvVideoController.a().E != 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().C != 10))
              {
                bool = paramBoolean;
                if (this.jdField_a_of_type_ComTencentAvVideoController.a().E != 2) {}
              }
              else
              {
                if (!localmfa.e) {
                  break label406;
                }
                if (((mez)localObject).e.getVisibility() != 0) {
                  ((mez)localObject).e.setVisibility(0);
                }
                if (((mez)localObject).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
                {
                  ((mez)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
                  a(((mez)localObject).jdField_b_of_type_AndroidWidgetImageView, 8);
                }
                localmfa.jdField_a_of_type_Boolean = false;
                bool = false;
              }
              if ((bool) && (((mez)localObject).jdField_b_of_type_Boolean))
              {
                if (((mez)localObject).jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)
                {
                  ((mez)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
                  a(((mez)localObject).jdField_b_of_type_AndroidWidgetImageView, 0);
                }
                if (this.jdField_a_of_type_Int != 7) {
                  continue;
                }
                ((mez)localObject).jdField_b_of_type_Int = localmfa.jdField_d_of_type_Int;
                switch (((mez)localObject).jdField_b_of_type_Int)
                {
                }
              }
              for (;;)
              {
                if (((mez)localObject).jdField_b_of_type_Int == 0) {
                  break label511;
                }
                ((mez)localObject).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                return;
                bool = paramBoolean;
                if (((mez)localObject).e.getVisibility() != 0) {
                  break;
                }
                ((mez)localObject).e.setVisibility(8);
                bool = paramBoolean;
                break;
                if (((mez)localObject).jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
                  break label332;
                }
                ((mez)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
                a(((mez)localObject).jdField_b_of_type_AndroidWidgetImageView, 8);
                break label332;
                ((mez)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841407);
                continue;
                ((mez)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841411);
                continue;
                ((mez)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841409);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    View localView1;
    View localView2;
    View localView3;
    View localView4;
    View localView5;
    View localView6;
    View localView7;
    View localView8;
    View localView9;
    do
    {
      return;
      localView1 = paramView.findViewById(2131364414);
      localView2 = paramView.findViewById(2131364415);
      localView3 = paramView.findViewById(2131369852);
      localView4 = paramView.findViewById(2131369853);
      localView5 = paramView.findViewById(2131369854);
      localView6 = paramView.findViewById(2131369855);
      localView7 = paramView.findViewById(2131369856);
      localView8 = paramView.findViewById(2131369857);
      localView9 = paramView.findViewById(2131369858);
      paramView = paramView.findViewById(2131369859);
    } while ((localView1 == null) || (localView2 == null) || (localView3 == null) || (localView4 == null) || (localView5 == null) || (localView6 == null) || (localView7 == null) || (localView8 == null) || (localView9 == null) || (paramView == null));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
    switch (paramInt)
    {
    default: 
      localView1.setVisibility(8);
      localView2.setVisibility(8);
      return;
    case 1: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(8);
      localView5.setVisibility(8);
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
    }
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
  }
  
  public void a(ArrayList<ldr> paramArrayList)
  {
    b(paramArrayList);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator.a();
    this.jdField_a_of_type_Mev.notifyDataSetChanged();
  }
  
  void b(ArrayList<ldr> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("refreshDataSource, friends[");
      if (paramArrayList == null) {
        break label211;
      }
    }
    label211:
    for (int i = paramArrayList.size();; i = -1)
    {
      QLog.w("MultiMembersAudioUI", 1, i + "], mInfoList[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "]");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (paramArrayList == null) {
        break;
      }
      i = 0;
      while (i < paramArrayList.size())
      {
        localObject = (ldr)paramArrayList.get(i);
        mfa localmfa = new mfa();
        localmfa.jdField_a_of_type_Long = ((ldr)localObject).jdField_a_of_type_Long;
        localmfa.jdField_a_of_type_Int = ((ldr)localObject).jdField_a_of_type_Int;
        localmfa.jdField_b_of_type_Boolean = ((ldr)localObject).jdField_b_of_type_Boolean;
        localmfa.jdField_a_of_type_Boolean = ((ldr)localObject).jdField_a_of_type_Boolean;
        localmfa.jdField_c_of_type_Boolean = ((ldr)localObject).jdField_c_of_type_Boolean;
        localmfa.jdField_b_of_type_Int = ((ldr)localObject).jdField_c_of_type_Int;
        localmfa.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((ldr)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        localmfa.e = ((ldr)localObject).e;
        localmfa.jdField_d_of_type_Int = ((ldr)localObject).f;
        localmfa.f = ((ldr)localObject).h;
        this.jdField_a_of_type_JavaUtilArrayList.add(localmfa);
        i += 1;
      }
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 8)) {
      this.jdField_b_of_type_Int = 8;
    }
  }
  
  public void setIsEnterpage(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setOnItemClickListener(mru parammru)
  {
    this.jdField_a_of_type_Mru = parammru;
  }
  
  public void setRandomMultiIsMask(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMembersAudioUI", 2, "setRandomMultiIsMask isMask: " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersAudioUI
 * JD-Core Version:    0.7.0.1
 */