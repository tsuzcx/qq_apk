package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PokeAndEmoPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private PokePanel jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private PEPanel jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private View b;
  
  public PokeAndEmoPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PokeAndEmoPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PokeAndEmoPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ImageView a(int paramInt1, int paramInt2, String paramString)
  {
    ImageButton localImageButton = new ImageButton(getContext());
    localImageButton.setLayoutParams(new LinearLayout.LayoutParams(AIOUtils.a(50.0F, getResources()), -1));
    localImageButton.setId(paramInt1);
    localImageButton.setImageResource(paramInt2);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    ColorDrawable localColorDrawable1 = new ColorDrawable();
    localColorDrawable1.setColor(-1644826);
    ColorDrawable localColorDrawable2 = new ColorDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localColorDrawable1);
    localStateListDrawable.addState(new int[] { 16842913 }, localColorDrawable1);
    localStateListDrawable.addState(new int[0], localColorDrawable2);
    localImageButton.setBackgroundDrawable(localStateListDrawable);
    localImageButton.setContentDescription(paramString);
    return localImageButton;
  }
  
  public void a() {}
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131363014));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363013));
    this.b = a(2131362475, 2130837683, getContext().getString(2131438121));
    this.jdField_a_of_type_AndroidViewView = a(2131362476, 2130837684, getContext().getString(2131438120));
    if (AppSetting.b)
    {
      this.b.setContentDescription("表情泡泡按钮");
      this.jdField_a_of_type_AndroidViewView.setContentDescription("戳一戳按钮");
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel = ((PokePanel)View.inflate(getContext(), 2130968655, null));
    String str = PokeItemHelper.a(paramBaseChatPie.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel.a(paramBaseChatPie, paramSessionInfo, str);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel.a(str);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel = new PEPanel(getContext());
    str = PokeItemHelper.a(paramBaseChatPie.a(), 8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel.a(paramBaseChatPie, paramSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel.a(str);
    paramSessionInfo = new ArrayList();
    int i = PokeItemHelper.b(paramBaseChatPie.a(), 4);
    int j = PokeItemHelper.b(paramBaseChatPie.a(), 11);
    if (QLog.isColorLevel()) {
      QLog.d("PokeAndEmoPanel", 2, String.format(" init..entryType = %d,viewType = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    if ((i == 1) && (PokeItemHelper.b))
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.b);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
      paramSessionInfo.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel);
      paramSessionInfo.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel.a();
      this.b.setSelected(true);
      this.jdField_a_of_type_AndroidViewView.setSelected(false);
      this.b.setVisibility(0);
      if (j == 1)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramSessionInfo.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel);
      }
    }
    for (;;)
    {
      paramBaseChatPie = new PokeEmoPageAdapter(getContext(), paramSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(paramBaseChatPie);
      return;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.b);
      paramSessionInfo.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel);
      paramSessionInfo.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel);
      this.jdField_a_of_type_AndroidViewView.setSelected(true);
      this.b.setSelected(false);
      if ((j == 1) || (!PokeItemHelper.b))
      {
        this.b.setVisibility(8);
        paramSessionInfo.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel);
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel.d();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel.c();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362476: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.jdField_a_of_type_Int, true);
      paramView.setSelected(true);
      this.b.setSelected(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem((this.jdField_a_of_type_Int + 1) % 2, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel.a();
    paramView.setSelected(true);
    this.jdField_a_of_type_AndroidViewView.setSelected(false);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_AndroidViewView.setSelected(true);
      this.b.setSelected(false);
      return;
    }
    this.b.setSelected(true);
    this.jdField_a_of_type_AndroidViewView.setSelected(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel
 * JD-Core Version:    0.7.0.1
 */