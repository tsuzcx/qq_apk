package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.BitmapsCache;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.DecodeCallBack;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.DecodeData;
import com.tencent.mobileqq.vas.trooppobing.PobingManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import mqq.util.WeakReference;

public class TroopPobingEffectItemView
  extends RelativeLayout
  implements View.OnClickListener, PobingDecoder.DecodeCallBack
{
  public static final HashMap<Integer, String> a = new TroopPobingEffectItemView.1();
  ApngDrawable.OnPlayRepeatListener b = new TroopPobingEffectItemView.3(this);
  private String c;
  private boolean d;
  private int e;
  private long f;
  private View g;
  private TroopPobingItemBuilder.Callback h;
  private WeakReference<URLImageView> i;
  private WeakReference<Button> j;
  private URLDrawable k;
  private URLDrawable l;
  
  public TroopPobingEffectItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TroopPobingEffectItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate(paramContext, 2131628425, this);
    findViewById(2131432284).setOnClickListener(this);
    findViewById(2131432283).setOnClickListener(this);
    setHorizontalGravity(0);
    this.i = new WeakReference((URLImageView)findViewById(2131432283));
    this.j = new WeakReference((Button)findViewById(2131432284));
  }
  
  private void a()
  {
    post(new TroopPobingEffectItemView.4(this));
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if (!(paramURLDrawable instanceof ApngDrawable)) {
      return;
    }
    ((ApngDrawable)paramURLDrawable).setOnPlayRepeatListener(this.b);
  }
  
  private void a(PobingDecoder.BitmapsCache paramBitmapsCache)
  {
    c(paramBitmapsCache);
    b(paramBitmapsCache);
    TroopPobingItemBuilder.a(this.g, true);
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4F6", 3, 0, "", "", "", "");
  }
  
  private void b()
  {
    Object localObject = (URLImageView)this.i.get();
    if (localObject != null) {
      ((URLImageView)localObject).setImageDrawable(this.k);
    }
    localObject = (Button)this.j.get();
    if (localObject != null)
    {
      int m;
      if (this.d) {
        m = 8;
      } else {
        m = 0;
      }
      ((Button)localObject).setVisibility(m);
    }
    localObject = (TextView)findViewById(2131432282);
    ((TextView)localObject).setText(this.c);
    ((TextView)localObject).setVisibility(0);
  }
  
  private void b(PobingDecoder.BitmapsCache paramBitmapsCache)
  {
    if (this.d) {
      return;
    }
    StateListDrawable localStateListDrawable = new StateListDrawable();
    URLDrawable localURLDrawable = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("press", new ApngOptions(), paramBitmapsCache.a(2131432284));
    localURLDrawable.setColorFilter(1291845632, PorterDuff.Mode.SRC_ATOP);
    paramBitmapsCache = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("normal", new ApngOptions(), paramBitmapsCache.a(2131432284));
    localStateListDrawable.addState(new int[] { 16842919 }, localURLDrawable);
    localStateListDrawable.addState(new int[] { 0 }, paramBitmapsCache);
    paramBitmapsCache = (Button)this.j.get();
    if (paramBitmapsCache != null) {
      paramBitmapsCache.setBackgroundDrawable(localStateListDrawable);
    }
  }
  
  private void c(PobingDecoder.BitmapsCache paramBitmapsCache)
  {
    this.k = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", new ApngOptions(), paramBitmapsCache.a(2131432282));
    if (!PobingManager.a(this.f))
    {
      b();
      return;
    }
    URLImageView localURLImageView = (URLImageView)this.i.get();
    if (localURLImageView == null) {
      return;
    }
    if (localURLImageView.getBackground() != null) {
      return;
    }
    ApngOptions localApngOptions = new ApngOptions();
    localApngOptions.a(1);
    localApngOptions.a(new TroopPobingEffectItemView.2(this));
    this.l = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", localApngOptions, paramBitmapsCache.a(2131432283));
    localURLImageView.setImageDrawable(this.l);
    if (this.l.getStatus() == 1) {
      a(this.l);
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    this.e = paramInt;
    this.f = paramLong;
    this.d = paramBoolean;
    PobingDecoder.BitmapsCache localBitmapsCache = PobingDecoder.a(PobingManager.a(this.e));
    if (localBitmapsCache != null)
    {
      a(localBitmapsCache);
      return;
    }
    new PobingDecoder(this.e, a, this);
  }
  
  public void a(PobingDecoder.DecodeData paramDecodeData)
  {
    paramDecodeData = PobingDecoder.a(paramDecodeData, false);
    if (paramDecodeData == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new TroopPobingEffectItemView.5(this, paramDecodeData));
  }
  
  public void a(String paramString, View paramView, TroopPobingItemBuilder.Callback paramCallback)
  {
    this.c = paramString;
    this.g = paramView;
    this.h = paramCallback;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131432284: 
      TroopPobingItemBuilder.Callback localCallback = this.h;
      if (localCallback != null) {
        localCallback.a(this);
      }
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4F7", 3, 0, "", "", "", "");
      break;
    case 2131432283: 
      PobingManager.a(getContext());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingEffectItemView
 * JD-Core Version:    0.7.0.1
 */