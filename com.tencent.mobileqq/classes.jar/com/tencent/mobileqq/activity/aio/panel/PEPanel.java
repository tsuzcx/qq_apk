package com.tencent.mobileqq.activity.aio.panel;

import agej;
import agkf;
import ahnt;
import aiai;
import aiaj;
import aiak;
import airq;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bdll;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;
import java.io.FileInputStream;
import mqq.os.MqqHandler;

public class PEPanel
  extends FrameLayout
{
  private long jdField_a_of_type_Long;
  private agkf jdField_a_of_type_Agkf;
  private aiak jdField_a_of_type_Aiak;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  public PEPanel(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public PEPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PEPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    int j = 1;
    String str = this.jdField_a_of_type_JavaLangString;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmo.PEPanel", 2, String.format(" playLottieAnim isAlreadyAnimating = %b,mIsLottieJsonLoaded = %b", new Object[] { Boolean.valueOf(((DiniFlyAnimationView)localObject).isAnimating()), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if (((DiniFlyAnimationView)localObject).isAnimating()) {
      return;
    }
    int k;
    int m;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      k = ahnt.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 4);
      m = ahnt.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 1);
      if ((k != 1) || (m <= 0)) {
        break label227;
      }
      i = j;
    }
    for (;;)
    {
      for (;;)
      {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "dc00898", "", "", "0X8009221", "0X8009221", i, 0, "", "", "", "");
        return;
        try
        {
          localObject = new aiaj(this, (DiniFlyAnimationView)localObject);
          LottieComposition.Factory.fromInputStream(getContext(), new FileInputStream(str), (OnCompositionLoadedListener)localObject);
          this.jdField_a_of_type_Boolean = true;
        }
        catch (Exception localException)
        {
          this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(0);
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PokeEmo.PEPanel", 2, "load lottie exception ,msg = " + localException.getMessage());
      break;
      label227:
      if ((k == 0) && (m > 0))
      {
        i = 2;
      }
      else if ((k == 1) && (m == 0))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (k == 0)
        {
          i = j;
          if (m == 0) {
            i = 4;
          }
        }
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    paramBaseChatPie = new DiniFlyAnimationView(getContext());
    paramSessionInfo = new FrameLayout.LayoutParams(-1, XPanelContainer.a - agej.a(40.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = paramBaseChatPie;
    addView(paramBaseChatPie, paramSessionInfo);
    this.jdField_a_of_type_ComTencentWidgetListView = new StickerBubbleListView(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    paramBaseChatPie = new FrameLayout.LayoutParams(-1, -1);
    paramBaseChatPie.topMargin = agej.a(30.0F, getResources());
    this.jdField_a_of_type_ComTencentWidgetListView.setLayoutParams(paramBaseChatPie);
    this.jdField_a_of_type_ComTencentWidgetListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetListView.setScrollbarFadingEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetListView.setVerticalFadingEdgeEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetListView.setSelector(new ColorDrawable(0));
    addView(this.jdField_a_of_type_ComTencentWidgetListView, paramBaseChatPie);
    this.jdField_a_of_type_Aiak = new aiak(this);
    this.jdField_a_of_type_JavaLangString = (airq.c + "aio_panel_pe_ani.json");
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.myLooper(), new aiai(this));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmo.PEPanel", 2, String.format(" reload..reload = %s", new Object[] { paramString }));
    }
    paramString = airq.a(paramString);
    this.jdField_a_of_type_Agkf = new agkf(BaseApplication.getContext());
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Agkf);
    this.jdField_a_of_type_Agkf.a(paramString);
    this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void setListViewVisibile(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PEPanel
 * JD-Core Version:    0.7.0.1
 */