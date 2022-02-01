package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.script.api.ISpriteUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import java.util.Vector;
import org.jetbrains.annotations.NotNull;

class GivingHeartItemBuilder$PokeClickListener
  implements View.OnClickListener
{
  private GivingHeartItemBuilder$PokeClickListener(GivingHeartItemBuilder paramGivingHeartItemBuilder) {}
  
  @NotNull
  private CustomFrameAnimationDrawable a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, String paramString1, int paramInt, String paramString2)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inScaled = true;
    ((BitmapFactory.Options)localObject).inSampleSize = 1;
    ((BitmapFactory.Options)localObject).inMutable = true;
    Bitmap localBitmap;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("01.png");
      localObject = ImageUtil.a(localStringBuilder.toString(), (BitmapFactory.Options)localObject);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, localOutOfMemoryError.toString());
      }
      localBitmap = null;
    }
    paramString2 = new CustomFrameAnimationDrawable(this.a.e.getResources(), localBitmap, PokeItemAnimationManager.c().b(), paramMessageForPoke.mFrameState, paramString2, PokeItemHelper.c(this.a.w));
    paramString2.l();
    int i = 40;
    if (paramMessageForPoke.interactType == 2) {
      i = 30;
    }
    int n = paramMessageForPoke.interactType;
    int m = 0;
    int k = 0;
    int j = m;
    if (n == 4)
    {
      j = m;
      if (paramHolder.t == 2.0F)
      {
        for (j = k;; j = k)
        {
          k = 20;
          if (j >= 20) {
            break;
          }
          k = j + 1;
          if (k < 10)
          {
            paramHolder = new StringBuilder();
            paramHolder.append(paramString1);
            paramHolder.append("0");
            paramHolder.append(k);
            paramHolder.append(".png");
            paramString2.a(j, i, paramHolder.toString());
          }
          else
          {
            paramHolder = new StringBuilder();
            paramHolder.append(paramString1);
            paramHolder.append(k);
            paramHolder.append(".png");
            paramString2.a(j, i, paramHolder.toString());
          }
        }
        while (k < paramInt)
        {
          paramHolder = new StringBuilder();
          paramHolder.append(paramString1);
          paramHolder.append(21);
          paramHolder.append(".png");
          paramString2.a(k, i, paramHolder.toString());
          k += 1;
        }
      }
    }
    while (j < paramInt)
    {
      k = j + 1;
      if (k < 10)
      {
        paramHolder = new StringBuilder();
        paramHolder.append(paramString1);
        paramHolder.append("0");
        paramHolder.append(k);
        paramHolder.append(".png");
        paramString2.a(j, i, paramHolder.toString());
      }
      else
      {
        paramHolder = new StringBuilder();
        paramHolder.append(paramString1);
        paramHolder.append(k);
        paramHolder.append(".png");
        paramString2.a(j, i, paramHolder.toString());
      }
      j = k;
    }
    return paramString2;
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if ((PokeBigResHandler.e) && (!paramHolder.d.b())) {
      paramHolder.d.a(this.a.e, paramMessageForPoke.isSend() ^ true, PokeItemHelper.c(this.a.w), paramHolder.t);
    }
    paramHolder.d.setParams(paramMessageForPoke.isSend() ^ true);
    paramHolder.d.setMirror(paramMessageForPoke.isSend() ^ true);
    paramHolder.d.setVisibility(0);
    paramHolder.c.clearAnimation();
    paramHolder.c.setVisibility(8);
    paramHolder.c.setImageDrawable(null);
    paramHolder.b.setVisibility(8);
    paramHolder.g.setVisibility(8);
    paramHolder.b.clearAnimation();
    paramHolder.d.setEndListener(new GivingHeartItemBuilder.PokeClickListener.1(this, paramHolder, paramMessageForPoke));
    if (!paramMessageForPoke.mUnlimitedState.d)
    {
      if (QLog.isColorLevel()) {
        QLog.i("fangdazhao", 2, "[click]start to play");
      }
      paramHolder.d.d();
    }
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    if (b(paramHolder, paramMessageForPoke)) {
      return;
    }
    paramHolder.c.setImageDrawable(paramCustomFrameAnimationDrawable);
    Object localObject = paramHolder.c;
    boolean bool1 = false;
    ((DiniFlyAnimationView)localObject).setVisibility(0);
    paramHolder.b.setVisibility(8);
    paramHolder.b.clearAnimation();
    paramHolder.g.setVisibility(8);
    paramHolder.d.clearAnimation();
    paramHolder.d.setVisibility(8);
    if (paramMessageForPoke.mFrameState.d)
    {
      paramCustomFrameAnimationDrawable.d();
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, "[click]resume to play");
      }
    }
    else
    {
      paramCustomFrameAnimationDrawable.c();
      if (paramHolder.t == 2.0F) {
        if (paramMessageForPoke.interactType == 2)
        {
          PokeItemAnimationManager.c().a(1);
          PokeItemAnimationManager.c().a(2, 1500L, paramMessageForPoke.isSend());
        }
        else if (paramMessageForPoke.interactType == 3)
        {
          PokeItemAnimationManager.c().a(4);
          PokeItemAnimationManager.c().a(5, 700L);
        }
        else if (paramMessageForPoke.interactType == 4)
        {
          PokeItemAnimationManager.c().a(13);
          PokeItemAnimationManager.c().a(14, 800L);
        }
      }
      if ((paramMessageForPoke.interactType == 1) || (paramMessageForPoke.interactType == 0))
      {
        paramCustomFrameAnimationDrawable = this.a;
        localObject = (Activity)paramCustomFrameAnimationDrawable.e;
        boolean bool2 = paramMessageForPoke.isSend();
        if (paramHolder.t == 2.0F) {
          bool1 = true;
        }
        GivingHeartItemBuilder.a(paramCustomFrameAnimationDrawable, (Activity)localObject, bool2, bool1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, "[click]start to play");
      }
    }
  }
  
  private boolean a(View paramView, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if (126 == paramMessageForPoke.interactType)
    {
      if (b(paramView, paramHolder, paramMessageForPoke)) {
        return true;
      }
      return d(paramHolder, paramMessageForPoke);
    }
    return false;
  }
  
  private void b(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    paramCustomFrameAnimationDrawable.a(1);
    if (!paramMessageForPoke.isSend()) {
      if (paramMessageForPoke.interactType != 5) {
        paramCustomFrameAnimationDrawable.b();
      } else {
        paramCustomFrameAnimationDrawable.a(2);
      }
    }
    paramCustomFrameAnimationDrawable.i();
    paramCustomFrameAnimationDrawable.a(new GivingHeartItemBuilder.PokeClickListener.2(this, paramHolder, paramMessageForPoke));
  }
  
  private boolean b(View paramView, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    int i;
    if (paramView.findViewById(2131446799).getVisibility() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (!PokeItemHelper.i.contains(Integer.valueOf(paramMessageForPoke.subId))) {
        PokeItemHelper.i.add(Integer.valueOf(paramMessageForPoke.subId));
      }
      if (!PokeItemHelper.j.contains(Integer.valueOf(paramMessageForPoke.subId))) {
        PokeItemHelper.j.add(Integer.valueOf(paramMessageForPoke.subId));
      }
      if (!PokeItemHelper.h.contains(Integer.valueOf(paramMessageForPoke.subId))) {
        PokeItemHelper.h.add(Integer.valueOf(paramMessageForPoke.subId));
      }
      paramHolder.e.setVisibility(0);
      paramHolder.f.setVisibility(8);
      paramView = (IVasQuickUpdateService)this.a.d.getRuntimeService(IVasQuickUpdateService.class, "");
      paramHolder = new StringBuilder();
      paramHolder.append("poke.item.effect.");
      paramHolder.append(paramMessageForPoke.subId);
      paramView.downloadItem(21L, paramHolder.toString(), "getbubbleview");
      paramHolder = new StringBuilder();
      paramHolder.append("poke.item.res.");
      paramHolder.append(paramMessageForPoke.subId);
      paramView.downloadItem(21L, paramHolder.toString(), "getbubbleview");
      paramView.addCallBacker(this.a.B);
      return true;
    }
    if (!PokeItemHelper.a("bubble", paramMessageForPoke.subId))
    {
      QQToast.makeText(this.a.e, 0, HardCodeUtil.a(2131903254), 0).show();
      return true;
    }
    return false;
  }
  
  private boolean b(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if ((paramMessageForPoke.interactType == 5) && (paramHolder.t == 2.0F))
    {
      paramHolder.b.setVisibility(8);
      paramHolder.g.setVisibility(8);
      paramMessageForPoke = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.a.e).getWindow().getDecorView()).getChildAt(0).findViewById(2131427887)).getSixCombolEffectView();
      paramHolder.s.setVisibility(0);
      paramMessageForPoke.a(paramHolder, PokeItemHelper.c(this.a.d));
      paramMessageForPoke.setListener(this.a);
      return true;
    }
    return false;
  }
  
  private boolean c(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if (!PokeBigResHandler.e)
    {
      paramHolder.c.clearAnimation();
      paramHolder.c.setVisibility(8);
      paramHolder.b.setVisibility(0);
      QQToast.makeText(this.a.e, 0, HardCodeUtil.a(2131903248), 0).show();
      paramHolder = (PokeBigResHandler)this.a.d.getBusinessHandler(BusinessHandlerFactory.POKE_BIG_RES_HANDLER);
      if (paramHolder != null) {
        paramHolder.a(true);
      }
      if (paramMessageForPoke.isSend()) {
        paramMessageForPoke.setPlayed(this.a.w);
      }
      return true;
    }
    return false;
  }
  
  private boolean d(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if ((((ISpriteUtil)QRoute.api(ISpriteUtil.class)).getSpriteContext(this.a.d).a() ^ true))
    {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.a.w, "vas_poke", true);
      if (QLog.isColorLevel()) {
        QLog.i("GivingHeart.sprite", 2, "hide sprite (normal) in click.");
      }
    }
    PokeItemHelper.a(this.a.w, this.a.e, paramHolder.c, paramHolder, paramMessageForPoke.subId, "bubble");
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (!(paramView.getContext() instanceof ChatHistoryActivity))
    {
      AIOUtils.q = true;
      if (!this.a.c())
      {
        GivingHeartItemBuilder.Holder localHolder = (GivingHeartItemBuilder.Holder)AIOUtils.b(paramView);
        MessageForPoke localMessageForPoke = (MessageForPoke)localHolder.q;
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("poke onClick() is called, type:");
          ((StringBuilder)localObject1).append(localMessageForPoke.interactType);
          QLog.d("GivingHeart", 2, ((StringBuilder)localObject1).toString());
        }
        if ((!a(paramView, localHolder, localMessageForPoke)) && (!c(localHolder, localMessageForPoke)))
        {
          Object localObject2 = this.a.b(localMessageForPoke);
          localObject1 = ((GivingHeartItemBuilder.FileNumEntity)localObject2).a;
          int i = ((GivingHeartItemBuilder.FileNumEntity)localObject2).b;
          localObject2 = GivingHeartItemBuilder.a(localMessageForPoke.interactType);
          if ((localMessageForPoke.interactType != 1) && (localMessageForPoke.interactType > 0) && (localMessageForPoke.interactType <= 6)) {
            localObject1 = a(localHolder, localMessageForPoke, (String)localObject1, i, (String)localObject2);
          } else {
            localObject1 = GivingHeartItemBuilder.a(this.a, localHolder, localMessageForPoke, (String)localObject2);
          }
          b(localHolder, localMessageForPoke, (CustomFrameAnimationDrawable)localObject1);
          if (localMessageForPoke.interactType != 6) {
            a(localHolder, localMessageForPoke, (CustomFrameAnimationDrawable)localObject1);
          } else {
            a(localHolder, localMessageForPoke);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.PokeClickListener
 * JD-Core Version:    0.7.0.1
 */