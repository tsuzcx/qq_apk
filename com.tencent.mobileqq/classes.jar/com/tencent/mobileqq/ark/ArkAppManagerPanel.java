package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;

public class ArkAppManagerPanel
  extends RelativeLayout
  implements View.OnClickListener, ViewPager.OnPageChangeListener, ArkMessageServerLogic.IRequestArkAppListHandler
{
  private int jdField_a_of_type_Int = 0;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArkPanelPagerAdapter a;
  private EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private LinearLayout b;
  
  public ArkAppManagerPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ArkAppManagerPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        this.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.b.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.b.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131368386));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131368364));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter = new ArkPanelPagerAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter);
    setPagerChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370360));
    this.b = ((LinearLayout)findViewById(2131376335));
    this.b.setOnClickListener(this);
    a(0);
    paramBaseChatPie = getResources().getDrawable(2130850615);
    if ((paramBaseChatPie instanceof BitmapDrawable)) {
      paramBaseChatPie = ((BitmapDrawable)paramBaseChatPie).getBitmap();
    } else if ((paramBaseChatPie instanceof SkinnableBitmapDrawable)) {
      paramBaseChatPie = ((SkinnableBitmapDrawable)paramBaseChatPie).getBitmap();
    } else {
      paramBaseChatPie = null;
    }
    paramBaseChatPie = new BitmapDrawable(paramBaseChatPie);
    paramBaseChatPie.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    paramBaseChatPie.setDither(true);
    setBackgroundDrawable(paramBaseChatPie);
    ArkMessageServerLogic.a(this);
  }
  
  public void a(ArrayList<ArkAppPanelData> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.a(paramArrayList);
    a(1);
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.getCount() > 1)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.synButton(this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.getCount());
      }
      catch (Exception paramArrayList)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception=");
        localStringBuilder.append(paramArrayList);
        QLog.d("ArkAppManagerPanel", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.notifyDataSetChanged();
    post(new ArkAppManagerPanel.1(this));
  }
  
  public void b(ArrayList<ArkAppPanelData> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int j = paramArrayList.size() - 7;
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          paramArrayList.remove(paramArrayList.size() - 1);
          i += 1;
        }
      }
      ArkAppPanelData localArkAppPanelData = new ArkAppPanelData();
      localArkAppPanelData.jdField_a_of_type_Boolean = true;
      localArkAppPanelData.jdField_a_of_type_JavaLangString = null;
      localArkAppPanelData.b = getResources().getString(2131693592);
      paramArrayList.add(localArkAppPanelData);
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppManagerPanel.2(this, paramArrayList));
      return;
    }
    a(2);
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      Object localObject1 = (ArkPanelPagerAdapter.ViewHolder)paramView.getTag();
      if (!TextUtils.isEmpty(((ArkPanelPagerAdapter.ViewHolder)localObject1).jdField_a_of_type_JavaLangString))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mqqapi://lightapp/open?app=");
        ((StringBuilder)localObject2).append(((ArkPanelPagerAdapter.ViewHolder)localObject1).jdField_a_of_type_JavaLangString);
        localObject2 = ((StringBuilder)localObject2).toString();
        JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), (String)localObject2).a();
        ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ArkPanelPagerAdapter.ViewHolder)localObject1).jdField_a_of_type_JavaLangString, "ArkPanelAppIconClick", 1, 0, 0L, 0L, 0L, null, null);
      }
      else
      {
        localObject1 = new Intent(getContext(), QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", "https://ti.qq.com/ark/aioplus/index.html");
        getContext().startActivity((Intent)localObject1);
        ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.tencent.ark.panel.more", "ArkPanelMoreIconClick", 1, 0, 0L, 0L, 0L, null, null);
      }
    }
    else if (i == 2)
    {
      a(0);
      ArkMessageServerLogic.a(this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
  
  public void setPagerChangedListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setPagerChangedListener(paramOnPageChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppManagerPanel
 * JD-Core Version:    0.7.0.1
 */