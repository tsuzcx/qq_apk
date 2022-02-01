package com.tencent.mobileqq.activity.aio.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.PokeEmoPanelAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.statistics.ReportController;
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
  private PokeEmoPanelAdapter jdField_a_of_type_ComTencentMobileqqActivityAioPokeEmoPanelAdapter;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PEPanel.ZuiAnimListenner jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel$ZuiAnimListenner;
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
      k = PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), 4);
      m = PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), 1);
      if ((k != 1) || (m <= 0)) {
        break label227;
      }
      i = j;
    }
    for (;;)
    {
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "dc00898", "", "", "0X8009221", "0X8009221", i, 0, "", "", "", "");
        return;
        try
        {
          localObject = new PEPanel.2(this, (DiniFlyAnimationView)localObject);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    paramBaseChatPie = new DiniFlyAnimationView(getContext());
    paramSessionInfo = new FrameLayout.LayoutParams(-1, XPanelContainer.a - AIOUtils.a(40.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = paramBaseChatPie;
    addView(paramBaseChatPie, paramSessionInfo);
    this.jdField_a_of_type_ComTencentWidgetListView = new StickerBubbleListView(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    paramBaseChatPie = new FrameLayout.LayoutParams(-1, -1);
    paramBaseChatPie.topMargin = AIOUtils.a(30.0F, getResources());
    this.jdField_a_of_type_ComTencentWidgetListView.setLayoutParams(paramBaseChatPie);
    this.jdField_a_of_type_ComTencentWidgetListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetListView.setScrollbarFadingEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetListView.setVerticalFadingEdgeEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetListView.setSelector(new ColorDrawable(0));
    addView(this.jdField_a_of_type_ComTencentWidgetListView, paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel$ZuiAnimListenner = new PEPanel.ZuiAnimListenner(this);
    this.jdField_a_of_type_JavaLangString = (PEPanelHelper.c + "aio_panel_pe_ani.json");
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.myLooper(), new PEPanel.1(this));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmo.PEPanel", 2, String.format(" reload..reload = %s", new Object[] { paramString }));
    }
    paramString = PEPanelHelper.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPokeEmoPanelAdapter = new PokeEmoPanelAdapter(BaseApplication.getContext());
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPokeEmoPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPokeEmoPanelAdapter.a(paramString);
    this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void setListViewVisibile(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PEPanel
 * JD-Core Version:    0.7.0.1
 */