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
  public ArkPanelPagerAdapter a;
  private QQAppInterface b;
  private QQViewPager c;
  private EmoticonPagerRadioGroup d;
  private LinearLayout e;
  private LinearLayout f;
  private int g = 0;
  
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
        this.g = paramInt;
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(0);
        return;
      }
      this.g = paramInt;
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      return;
    }
    this.g = paramInt;
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
    this.f.setVisibility(8);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.b = paramBaseChatPie.i();
    this.c = ((QQViewPager)findViewById(2131435266));
    this.d = ((EmoticonPagerRadioGroup)findViewById(2131435243));
    this.d.setViewPager(this.c);
    this.a = new ArkPanelPagerAdapter(BaseApplicationImpl.getContext());
    this.a.a(this);
    this.c.setAdapter(this.a);
    setPagerChangedListener(this);
    this.e = ((LinearLayout)findViewById(2131437622));
    this.f = ((LinearLayout)findViewById(2131444548));
    this.f.setOnClickListener(this);
    a(0);
    paramBaseChatPie = getResources().getDrawable(2130852413);
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
    this.a.a(paramArrayList);
    a(1);
    if (this.a.getCount() > 1)
    {
      try
      {
        this.d.synButton(this.a.getCount());
      }
      catch (Exception paramArrayList)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception=");
        localStringBuilder.append(paramArrayList);
        QLog.d("ArkAppManagerPanel", 2, localStringBuilder.toString());
      }
      this.d.setVisibility(0);
    }
    else
    {
      this.d.setVisibility(4);
    }
    this.a.notifyDataSetChanged();
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
      localArkAppPanelData.a = true;
      localArkAppPanelData.c = null;
      localArkAppPanelData.d = getResources().getString(2131891157);
      paramArrayList.add(localArkAppPanelData);
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppManagerPanel.2(this, paramArrayList));
      return;
    }
    a(2);
  }
  
  public void onClick(View paramView)
  {
    int i = this.g;
    if (i == 1)
    {
      Object localObject1 = (ArkPanelPagerAdapter.ViewHolder)paramView.getTag();
      if (!TextUtils.isEmpty(((ArkPanelPagerAdapter.ViewHolder)localObject1).d))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mqqapi://lightapp/open?app=");
        ((StringBuilder)localObject2).append(((ArkPanelPagerAdapter.ViewHolder)localObject1).d);
        localObject2 = ((StringBuilder)localObject2).toString();
        JumpParser.a(this.b, getContext(), (String)localObject2).a();
        ArkAppDataReport.a(this.b, ((ArkPanelPagerAdapter.ViewHolder)localObject1).d, "ArkPanelAppIconClick", 1, 0, 0L, 0L, 0L, null, null);
      }
      else
      {
        localObject1 = new Intent(getContext(), QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", "https://ti.qq.com/ark/aioplus/index.html");
        getContext().startActivity((Intent)localObject1);
        ArkAppDataReport.a(this.b, "com.tencent.ark.panel.more", "ArkPanelMoreIconClick", 1, 0, 0L, 0L, 0L, null, null);
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
    this.d.setPagerChangedListener(paramOnPageChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppManagerPanel
 * JD-Core Version:    0.7.0.1
 */