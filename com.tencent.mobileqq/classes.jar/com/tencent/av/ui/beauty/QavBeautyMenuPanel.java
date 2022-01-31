package com.tencent.av.ui.beauty;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import lyc;
import mee;
import mos;
import mot;
import mti;

public class QavBeautyMenuPanel
  extends RelativeLayout
  implements mee
{
  static final int[] jdField_a_of_type_ArrayOfInt = { 2131372774, 2131372775 };
  long jdField_a_of_type_Long = 0L;
  final View jdField_a_of_type_AndroidViewView;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  final PanelViewPage jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage;
  final SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator;
  final mot jdField_a_of_type_Mot;
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
    inflate(paramContext, 2131559604, this);
    Object localObject = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377327);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.jdField_a_of_type_AndroidViewView.findViewById(2131376786));
    paramAttributeSet = ((Resources)localObject).getDisplayMetrics();
    int k = Math.min(paramAttributeSet.widthPixels, paramAttributeSet.heightPixels);
    int j = ((Resources)localObject).getDimensionPixelSize(2131297456);
    int i = ((Resources)localObject).getDimensionPixelSize(2131297453);
    if (k - i - j * 2 > 20) {}
    for (paramInt = (k - i - j * 2) / 2;; paramInt = (k - i - j * 2) / 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.a(j, i, 0, paramInt);
      if (QLog.isDevelopLevel()) {
        QLog.i("QavBeautyMenuPanel", 4, String.format("QavBeautyMenuPanel, init[%s, %s, %s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt) }));
      }
      paramAttributeSet = ((Resources)localObject).getString(2131695874);
      localObject = ((Resources)localObject).getString(2131695875);
      SimpleSlidingIndicator localSimpleSlidingIndicator = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator;
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      localSimpleSlidingIndicator.setTabData(new String[] { paramAttributeSet, localObject }, arrayOfInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(0, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setOnTabListener(new mos(this));
      this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage = ((PanelViewPage)findViewById(2131371549));
      paramAttributeSet = new ArrayList(2);
      paramAttributeSet.add(new BeautyView(paramContext));
      paramAttributeSet.add(new MakeupView(paramContext));
      this.jdField_a_of_type_Mot = new mot(this, paramAttributeSet);
      this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setAdapter(this.jdField_a_of_type_Mot);
      this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setIsPagingEnabled(false);
      this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setCurrentItem(0, false);
      setBackgroundResource(2130841822);
      return;
      float f = j * 2 + i;
      f = (k - 20) / f;
      i = (int)(i * f);
      j = (int)(f * j);
    }
  }
  
  private RedDotTextView a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.findViewById(jdField_a_of_type_ArrayOfInt[paramInt]);
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
      mti.a("0X800AA61", 0);
    }
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getCurrentItem();
    BeautyBaseView localBeautyBaseView = this.jdField_a_of_type_Mot.a(i);
    if (localBeautyBaseView != null) {
      localBeautyBaseView.a();
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int j = this.jdField_a_of_type_Mot.getCount();
    int i = 0;
    while (i < j)
    {
      localObject = this.jdField_a_of_type_Mot.a(i);
      if (localObject != null) {
        ((BeautyBaseView)localObject).a(paramLong, paramBoolean);
      }
      i += 1;
    }
    Object localObject = lyc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 8);
    if (lyc.a((BusinessInfoCheckUpdate.AppInfo)localObject))
    {
      RedDotTextView localRedDotTextView = a(1);
      if (localRedDotTextView != null)
      {
        localRedDotTextView.a(true);
        localObject = lyc.a(8);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e((String)localObject);
      }
    }
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.a());
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.a(jdField_a_of_type_ArrayOfInt[1], (BusinessInfoCheckUpdate.AppInfo)localObject);
      break;
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    int j = this.jdField_a_of_type_Mot.getCount();
    int i = 0;
    while (i < j)
    {
      BeautyBaseView localBeautyBaseView = this.jdField_a_of_type_Mot.a(i);
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
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != paramVideoAppInterface) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    }
    int j = this.jdField_a_of_type_Mot.getCount();
    int i = 0;
    while (i < j)
    {
      BeautyBaseView localBeautyBaseView = this.jdField_a_of_type_Mot.a(i);
      if (localBeautyBaseView != null) {
        localBeautyBaseView.setAppInterface(paramVideoAppInterface);
      }
      i += 1;
    }
  }
  
  public void setCurSelTab(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 1)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i("QavBeautyMenuPanel", 4, "setCurSelTab, [(" + this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getCurrentItem() + "," + this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.a() + ") ---> " + paramInt1 + "], anim[" + paramBoolean + "], width[" + this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getMeasuredWidth() + "], width[" + this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getWidth() + "], from[" + paramInt2 + "]");
      }
      if ((paramInt2 != 1) && (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.a())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(paramInt1, paramBoolean);
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
      localObject = lyc.a(8);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d((String)localObject);
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.a(jdField_a_of_type_ArrayOfInt[paramInt1]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.beauty.QavBeautyMenuPanel
 * JD-Core Version:    0.7.0.1
 */