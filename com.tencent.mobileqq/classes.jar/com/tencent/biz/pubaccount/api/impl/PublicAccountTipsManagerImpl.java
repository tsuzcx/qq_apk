package com.tencent.biz.pubaccount.api.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountTipsManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import java.net.MalformedURLException;
import java.net.URL;

public class PublicAccountTipsManagerImpl
  implements View.OnClickListener, IPublicAccountTipsManager
{
  public static final String TAG = "PubAccountTipsManager";
  long lastClkTime;
  private View[] mBars = { this.mTipsView, this.mPendantView };
  private Context mContext;
  private View mPendantView;
  private View mTipsView;
  
  public View createEcshopDistanceTipsBar(String paramString, View.OnClickListener paramOnClickListener)
  {
    if ((this.mContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (this.mTipsView == null)
      {
        this.mTipsView = new TextView(this.mContext);
        ((TextView)this.mTipsView).setTextColor(this.mContext.getResources().getColor(2131168464));
        this.mTipsView.setBackgroundResource(2130848984);
        ((TextView)this.mTipsView).setGravity(16);
        this.mTipsView.setTag("tag_on_nearby_tips_click");
        ((TextView)this.mTipsView).setTextSize(this.mContext.getResources().getInteger(2131492884));
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = DisplayUtil.a(this.mContext, 18.0F);
      localLayoutParams.addRule(3, 2131442214);
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = DisplayUtil.b(this.mContext, 20.0F);
      ((TextView)this.mTipsView).setText(paramString);
      this.mTipsView.setLayoutParams(localLayoutParams);
      this.mTipsView.setOnClickListener(paramOnClickListener);
      return this.mTipsView;
    }
    return null;
  }
  
  public void hidePendant()
  {
    Object localObject = this.mPendantView;
    if (localObject != null)
    {
      localObject = (ViewGroup)((View)localObject).getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.mPendantView);
      }
    }
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.lastClkTime < 1000L) {
      return;
    }
    this.lastClkTime = System.currentTimeMillis();
    if ((paramView.getId() == 2131428158) && (this.mContext != null))
    {
      String str1 = (String)paramView.getTag(2131428161);
      String str2 = (String)paramView.getTag(2131428159);
      String str3 = (String)paramView.getTag(2131428160);
      if (((Integer)paramView.getTag(2131428162)).intValue() == 1)
      {
        paramView = new Intent(this.mContext, QQBrowserActivity.class);
        paramView.putExtra("url", str1);
        paramView.putExtra("fromAio", true);
        this.mContext.startActivity(paramView);
      }
      else
      {
        paramView = new Intent(this.mContext, JumpActivity.class);
        paramView.setData(Uri.parse(str1));
        this.mContext.startActivity(paramView);
      }
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "1", "0X80075A1", "0X80075A1", 0, 0, "", "", str2, str3);
    }
  }
  
  public void showPendant(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1;
    if ((this.mContext != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      localObject1 = null;
    }
    try
    {
      localObject2 = (ViewGroup)((BaseActivity)this.mContext).getChatFragment().k().aZ.findViewById(2131430542);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label55:
      int i;
      break label55;
    }
    if (localObject1 == null) {
      return;
    }
    if (this.mPendantView == null)
    {
      this.mPendantView = new URLImageView(this.mContext);
      this.mPendantView.setId(2131428158);
      i = DisplayUtil.a(this.mContext, 62.0F);
      localObject2 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.a(this.mContext, 15.0F);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = DisplayUtil.a(this.mContext, 15.0F);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131442214);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      this.mPendantView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    this.mPendantView.setTag(2131428161, paramString2);
    this.mPendantView.setTag(2131428159, String.valueOf(paramInt1));
    this.mPendantView.setTag(2131428160, String.valueOf(paramInt2));
    this.mPendantView.setTag(2131428162, Integer.valueOf(paramInt3));
    this.mPendantView.setOnClickListener(this);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mPlayGifImage = true;
    try
    {
      paramString1 = URLDrawable.getDrawable(new URL(paramString1), paramString2);
      ((URLImageView)this.mPendantView).setImageDrawable(paramString1);
      if (paramString1.getStatus() == 2)
      {
        paramString1.restartDownload();
        this.mPendantView.setVisibility(8);
      }
      ((URLImageView)this.mPendantView).setURLDrawableDownListener(new PublicAccountTipsManagerImpl.1(this));
    }
    catch (MalformedURLException paramString1)
    {
      label302:
      break label302;
    }
    showTipsBar(localObject1, this.mPendantView);
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", "1", "0X80075A0", "0X80075A0", 0, 0, "", "", String.valueOf(paramInt1), String.valueOf(paramInt2));
  }
  
  public void showTipsBar(ViewGroup paramViewGroup, View paramView)
  {
    if (paramViewGroup != null)
    {
      if (paramView == null) {
        return;
      }
      int i = 0;
      for (;;)
      {
        View[] arrayOfView = this.mBars;
        if (i >= arrayOfView.length) {
          break;
        }
        if ((arrayOfView[i] != null) && (arrayOfView[i] != paramView) && (paramViewGroup.indexOfChild(arrayOfView[i]) != -1)) {
          paramViewGroup.removeView(this.mBars[i]);
        }
        i += 1;
      }
      if (paramViewGroup.indexOfChild(paramView) == -1) {
        paramViewGroup.addView(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountTipsManagerImpl
 * JD-Core Version:    0.7.0.1
 */