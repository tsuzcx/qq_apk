package com.tencent.av.ui.beauty;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import lwa;
import mms;
import mmt;
import mrl;

public class QavBeautyMenuPanel
  extends QavMenuBaseView
{
  static final int[] jdField_a_of_type_ArrayOfInt = { 2131373540, 2131373541 };
  long jdField_a_of_type_Long = 0L;
  final View jdField_a_of_type_AndroidViewView;
  final PanelViewPage jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage;
  final SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  final mmt jdField_a_of_type_Mmt;
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
    this.jdField_a_of_type_JavaLangString = ("QavBeautyMenuPanel" + AudioHelper.b());
    inflate(paramContext, 2131559747, this);
    Object localObject = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378363);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.jdField_a_of_type_AndroidViewView.findViewById(2131377801));
    paramAttributeSet = ((Resources)localObject).getDisplayMetrics();
    int k = Math.min(paramAttributeSet.widthPixels, paramAttributeSet.heightPixels);
    int j = ((Resources)localObject).getDimensionPixelSize(2131297547);
    int i = ((Resources)localObject).getDimensionPixelSize(2131297544);
    if (k - i - j * 2 > 20) {}
    for (paramInt = (k - i - j * 2) / 2;; paramInt = (k - i - j * 2) / 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(j, i, 0, paramInt);
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, String.format("QavBeautyMenuPanel, init[%s, %s, %s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt) }));
      }
      paramAttributeSet = ((Resources)localObject).getString(2131694796);
      localObject = ((Resources)localObject).getString(2131694797);
      SimpleSlidingIndicator localSimpleSlidingIndicator = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      localSimpleSlidingIndicator.setTabData(new String[] { paramAttributeSet, localObject }, arrayOfInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(0, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(new mms(this));
      this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage = ((PanelViewPage)findViewById(2131372253));
      paramAttributeSet = new ArrayList(2);
      paramAttributeSet.add(new BeautyView(paramContext));
      paramAttributeSet.add(new MakeupView(paramContext));
      this.jdField_a_of_type_Mmt = new mmt(this, paramAttributeSet);
      this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setAdapter(this.jdField_a_of_type_Mmt);
      this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setIsPagingEnabled(false);
      this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setCurrentItem(0, false);
      setBackgroundResource(2130842154);
      return;
      float f = j * 2 + i;
      f = (k - 20) / f;
      i = (int)(i * f);
      j = (int)(f * j);
    }
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
      mrl.a("0X800AA61", 0);
    }
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    int j = this.jdField_a_of_type_Mmt.getCount();
    int i = 0;
    while (i < j)
    {
      paramQavPanel = this.jdField_a_of_type_Mmt.a(i);
      if (paramQavPanel != null) {
        paramQavPanel.setAppInterface(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      i += 1;
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    super.c(paramLong, paramBoolean);
    Object localObject;
    if (paramBoolean)
    {
      int j = this.jdField_a_of_type_Mmt.getCount();
      int i = 0;
      while (i < j)
      {
        localObject = this.jdField_a_of_type_Mmt.a(i);
        if (localObject != null) {
          ((BeautyBaseView)localObject).a(paramLong, paramBoolean);
        }
        i += 1;
      }
      localObject = lwa.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 8);
      if (!lwa.a((BusinessInfoCheckUpdate.AppInfo)localObject)) {
        break label148;
      }
      RedDotTextView localRedDotTextView = a(1);
      if (localRedDotTextView == null) {
        break label131;
      }
      localRedDotTextView.a(true);
      localObject = lwa.a(8);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e((String)localObject);
    }
    label131:
    label148:
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a());
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(jdField_a_of_type_ArrayOfInt[1], (BusinessInfoCheckUpdate.AppInfo)localObject);
      break;
    }
  }
  
  public void d(long paramLong, boolean paramBoolean)
  {
    super.d(paramLong, paramBoolean);
    int j = this.jdField_a_of_type_Mmt.getCount();
    int i = 0;
    while (i < j)
    {
      BeautyBaseView localBeautyBaseView = this.jdField_a_of_type_Mmt.a(i);
      if (localBeautyBaseView != null) {
        localBeautyBaseView.b(paramLong, paramBoolean);
      }
      i += 1;
    }
    this.b = false;
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
  
  public void f()
  {
    super.f();
    int i = this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getCurrentItem();
    BeautyBaseView localBeautyBaseView = this.jdField_a_of_type_Mmt.a(i);
    if (localBeautyBaseView != null) {
      localBeautyBaseView.a();
    }
  }
  
  public void setCurSelTab(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 1)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, "setCurSelTab, [(" + this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getCurrentItem() + "," + this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a() + ") ---> " + paramInt1 + "], anim[" + paramBoolean + "], width[" + this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getMeasuredWidth() + "], width[" + this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getWidth() + "], from[" + paramInt2 + "]");
      }
      if ((paramInt2 != 1) && (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(paramInt1, paramBoolean);
      }
      if ((paramInt2 != 2) && (paramInt1 != this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getCurrentItem())) {
        this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setCurrentItem(paramInt1, paramBoolean);
      }
    } while ((!paramBoolean) || (paramInt1 != 1) || (!this.jdField_a_of_type_Boolean));
    Object localObject = a(1);
    if (localObject != null) {
      ((RedDotTextView)localObject).a(false);
    }
    for (;;)
    {
      localObject = lwa.a(8);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d((String)localObject);
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(jdField_a_of_type_ArrayOfInt[paramInt1]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.beauty.QavBeautyMenuPanel
 * JD-Core Version:    0.7.0.1
 */