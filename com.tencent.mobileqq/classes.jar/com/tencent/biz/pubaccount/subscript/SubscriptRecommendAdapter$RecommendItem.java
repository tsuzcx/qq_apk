package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;

public class SubscriptRecommendAdapter$RecommendItem
{
  public View a;
  public View b;
  public View c;
  public TextView d;
  public ImageView e;
  public ImageView f;
  public TextView g;
  public ImageView h;
  public TextView i;
  public Button j;
  public ImageView k;
  public SubscriptRecommendAccountInfo l;
  
  public SubscriptRecommendAdapter$RecommendItem(SubscriptRecommendAdapter paramSubscriptRecommendAdapter, View paramView, boolean paramBoolean)
  {
    this.a = paramView;
    this.b = this.a.findViewById(2131445352);
    this.c = this.a.findViewById(2131445353);
    this.d = ((TextView)this.a.findViewById(2131445355));
    this.e = ((ImageView)this.a.findViewById(2131445354));
    this.f = ((ImageView)this.a.findViewById(2131428809));
    this.g = ((TextView)this.a.findViewById(2131428812));
    this.h = ((ImageView)this.a.findViewById(2131446618));
    this.i = ((TextView)this.a.findViewById(2131446619));
    this.j = ((Button)this.a.findViewById(2131433506));
    this.k = ((ImageView)this.a.findViewById(2131433507));
    if (!paramBoolean)
    {
      this.g.setTextColor(paramSubscriptRecommendAdapter.a.getResources().getColor(2131166831));
      this.j.setBackgroundResource(2130844316);
    }
    else
    {
      this.g.setTextColor(paramSubscriptRecommendAdapter.a.getResources().getColor(2131166832));
      this.j.setBackgroundResource(2130844315);
    }
    this.j.setOnClickListener(new SubscriptRecommendAdapter.RecommendItem.1(this, paramSubscriptRecommendAdapter));
    this.a.setOnClickListener(new SubscriptRecommendAdapter.RecommendItem.2(this, paramSubscriptRecommendAdapter));
    this.c.setOnTouchListener(new SubscriptRecommendAdapter.RecommendItem.3(this, paramSubscriptRecommendAdapter, paramBoolean));
    this.c.setOnClickListener(new SubscriptRecommendAdapter.RecommendItem.4(this, paramSubscriptRecommendAdapter));
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.l.g))
    {
      Intent localIntent = new Intent(this.m.a, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", this.l.g);
      localIntent.putExtra("hide_operation_bar", true);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(localIntent, this.l.g);
      this.m.a.startActivity(localIntent);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.k.isShown()) && ((this.k.getDrawable() instanceof Animatable))) {
      ((Animatable)this.k.getDrawable()).stop();
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        this.j.setVisibility(8);
        this.k.setVisibility(0);
        if ((this.k.getDrawable() instanceof Animatable)) {
          ((Animatable)this.k.getDrawable()).start();
        }
      }
      else
      {
        if (!this.m.e) {
          this.j.setBackgroundResource(2130844313);
        } else {
          this.j.setBackgroundResource(2130844314);
        }
        this.j.setTextColor(this.m.a.getResources().getColor(2131166846));
        this.j.setText(HardCodeUtil.a(2131911978));
        this.j.setVisibility(0);
        this.k.setVisibility(8);
      }
    }
    else
    {
      if (!this.m.e) {
        this.j.setBackgroundResource(2130844316);
      } else {
        this.j.setBackgroundResource(2130844315);
      }
      this.j.setTextColor(this.m.a.getResources().getColor(2131166845));
      this.j.setText(HardCodeUtil.a(2131899712));
      this.j.setVisibility(0);
      this.k.setVisibility(8);
    }
  }
  
  public void a(SubscriptRecommendAccountInfo paramSubscriptRecommendAccountInfo, int paramInt)
  {
    if (paramSubscriptRecommendAccountInfo == null) {
      return;
    }
    this.l = paramSubscriptRecommendAccountInfo;
    if (paramSubscriptRecommendAccountInfo.a == -1L)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(0);
      this.e.setVisibility(0);
      return;
    }
    this.b.setVisibility(0);
    this.c.setVisibility(8);
    this.e.setVisibility(8);
    if (paramSubscriptRecommendAccountInfo.e != null)
    {
      localObject1 = this.f.getLayoutParams();
      SubscriptRecommendAdapter.a(this.m).a(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramSubscriptRecommendAccountInfo.e.mFirstPagePicUrl, 1, Long.valueOf(paramSubscriptRecommendAccountInfo.a)), this.f, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, null, 5);
    }
    Object localObject2 = paramSubscriptRecommendAccountInfo.e;
    Object localObject1 = "";
    if (localObject2 != null) {
      localObject1 = paramSubscriptRecommendAccountInfo.e.mTitle.replaceFirst("^\\s+", "");
    }
    localObject2 = localObject1;
    if (this.m.f)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("\n");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    this.g.setText((CharSequence)localObject2);
    localObject1 = String.valueOf(paramSubscriptRecommendAccountInfo.a);
    this.i.setText(paramSubscriptRecommendAccountInfo.b);
    if (AppSetting.e) {
      this.a.setContentDescription(paramSubscriptRecommendAccountInfo.b);
    }
    localObject2 = this.m.b.getBitmapFromCache(1, (String)localObject1);
    if (localObject2 == null)
    {
      this.m.b.requestDecodeFace((String)localObject1, 1, true);
      this.h.setImageResource(2130841060);
    }
    else
    {
      this.h.setImageBitmap((Bitmap)localObject2);
    }
    localObject2 = (IPublicAccountDataManager)this.m.d.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject2 != null)
    {
      if ((PublicAccountInfo)((IPublicAccountDataManager)localObject2).findPublicAccountInfoCache((String)localObject1) != null)
      {
        a(1);
        paramSubscriptRecommendAccountInfo.f = 1;
        return;
      }
      if (paramSubscriptRecommendAccountInfo.f == 2)
      {
        a(2);
        return;
      }
      a(0);
      paramSubscriptRecommendAccountInfo.f = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter.RecommendItem
 * JD-Core Version:    0.7.0.1
 */