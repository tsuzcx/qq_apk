package com.tencent.av.ui.beauty;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QavBeautyMenuPanel
  extends QavMenuBaseView
{
  static final int[] jdField_a_of_type_ArrayOfInt = { 2131373555, 2131373556 };
  long jdField_a_of_type_Long = 0L;
  final View jdField_a_of_type_AndroidViewView;
  final PanelViewPage jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage;
  final QavBeautyMenuPanel.MyPagerAdapter jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$MyPagerAdapter;
  final SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public QavBeautyMenuPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QavBeautyMenuPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QavBeautyMenuPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new StringBuilder();
    paramAttributeSet.append("QavBeautyMenuPanel");
    paramAttributeSet.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.toString();
    inflate(paramContext, 2131559737, this);
    Object localObject = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378236);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.jdField_a_of_type_AndroidViewView.findViewById(2131377670));
    paramAttributeSet = ((Resources)localObject).getDisplayMetrics();
    int k = Math.min(paramAttributeSet.widthPixels, paramAttributeSet.heightPixels);
    paramInt = ((Resources)localObject).getDimensionPixelSize(2131297661);
    int i = ((Resources)localObject).getDimensionPixelSize(2131297658);
    int j = paramInt * 2;
    int m = k - i - j;
    if (m > 20)
    {
      j = m / 2;
    }
    else
    {
      float f = j + i;
      f = (k - 20) / f;
      i = (int)(i * f);
      paramInt = (int)(paramInt * f);
      j = (k - i - paramInt * 2) / 2;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(paramInt, i, 0, j);
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, String.format("QavBeautyMenuPanel, init[%s, %s, %s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j) }));
    }
    paramAttributeSet = ((Resources)localObject).getString(2131695403);
    localObject = ((Resources)localObject).getString(2131695404);
    SimpleSlidingIndicator localSimpleSlidingIndicator = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    localSimpleSlidingIndicator.setTabData(new String[] { paramAttributeSet, localObject }, arrayOfInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(0, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(new QavBeautyMenuPanel.1(this));
    this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage = ((PanelViewPage)findViewById(2131372297));
    paramAttributeSet = new ArrayList(2);
    paramAttributeSet.add(new BeautyView(paramContext));
    paramAttributeSet.add(new MakeupView(paramContext));
    this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$MyPagerAdapter = new QavBeautyMenuPanel.MyPagerAdapter(this, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setAdapter(this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$MyPagerAdapter);
    this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setIsPagingEnabled(false);
    this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setCurrentItem(0, false);
    setBackgroundResource(2130842251);
  }
  
  private RedDotTextView a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.findViewById(jdField_a_of_type_ArrayOfInt[paramInt]);
    if ((localObject instanceof RedTouch))
    {
      localObject = (RedTouch)localObject;
      paramInt = 0;
      while (paramInt < ((RedTouch)localObject).getChildCount())
      {
        if ((((RedTouch)localObject).getChildAt(paramInt) instanceof RedDotTextView)) {
          return (RedDotTextView)((RedTouch)localObject).getChildAt(paramInt);
        }
        paramInt += 1;
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((!this.b) && (paramInt == 1))
    {
      this.b = true;
      AVUtil.a("0X800AA61", 0);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    super.a(paramLong, paramBoolean);
    if (paramBoolean)
    {
      int j = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$MyPagerAdapter.getCount();
      int i = 0;
      while (i < j)
      {
        localObject = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$MyPagerAdapter.a(i);
        if (localObject != null) {
          ((BeautyBaseView)localObject).a(paramLong, paramBoolean);
        }
        i += 1;
      }
      Object localObject = AVRedTouchUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 8);
      if (AVRedTouchUtil.a((BusinessInfoCheckUpdate.AppInfo)localObject))
      {
        RedDotTextView localRedDotTextView = a(1);
        if (localRedDotTextView != null) {
          localRedDotTextView.a(true);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(jdField_a_of_type_ArrayOfInt[1], (BusinessInfoCheckUpdate.AppInfo)localObject);
        }
        localObject = AVRedTouchUtil.a(8);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e((String)localObject);
        this.jdField_a_of_type_Boolean = true;
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a());
    }
    d();
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    int j = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$MyPagerAdapter.getCount();
    int i = 0;
    while (i < j)
    {
      paramQavPanel = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$MyPagerAdapter.a(i);
      if (paramQavPanel != null) {
        paramQavPanel.setAppInterface(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      i += 1;
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    super.c(paramLong, paramBoolean);
    int j = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$MyPagerAdapter.getCount();
    int i = 0;
    while (i < j)
    {
      BeautyBaseView localBeautyBaseView = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$MyPagerAdapter.a(i);
      if (localBeautyBaseView != null) {
        localBeautyBaseView.b(paramLong, paramBoolean);
      }
      i += 1;
    }
    this.b = false;
  }
  
  public void d()
  {
    super.d();
    int i = this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getCurrentItem();
    BeautyBaseView localBeautyBaseView = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$MyPagerAdapter.a(i);
    if (localBeautyBaseView != null) {
      localBeautyBaseView.a();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    long l = SystemClock.elapsedRealtime();
    if (((i & 0xFF) != 2) || (Math.abs(l - this.jdField_a_of_type_Long) > 200L))
    {
      this.jdField_a_of_type_Long = l;
      EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, -1043L);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setCurSelTab(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt1 > 1) {
        return;
      }
      Object localObject;
      if (QLog.isDevelopLevel())
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCurSelTab, [(");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getCurrentItem());
        localStringBuilder.append(",");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a());
        localStringBuilder.append(") ---> ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("], anim[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], width[");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getMeasuredWidth());
        localStringBuilder.append("], width[");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getWidth());
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("]");
        QLog.i((String)localObject, 4, localStringBuilder.toString());
      }
      if ((paramInt2 != 1) && (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(paramInt1, paramBoolean);
      }
      if ((paramInt2 != 2) && (paramInt1 != this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getCurrentItem())) {
        this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setCurrentItem(paramInt1, paramBoolean);
      }
      if ((paramBoolean) && (paramInt1 == 1) && (this.jdField_a_of_type_Boolean))
      {
        localObject = a(1);
        if (localObject != null) {
          ((RedDotTextView)localObject).a(false);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(jdField_a_of_type_ArrayOfInt[paramInt1]);
        }
        localObject = AVRedTouchUtil.a(8);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d((String)localObject);
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.beauty.QavBeautyMenuPanel
 * JD-Core Version:    0.7.0.1
 */