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
    paramString2 = new CustomFrameAnimationDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap, PokeItemAnimationManager.a().a(), paramMessageForPoke.mFrameState, paramString2, PokeItemHelper.a(this.a.b));
    paramString2.i();
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
      if (paramHolder.jdField_a_of_type_Float == 2.0F)
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
    if ((PokeBigResHandler.a) && (!paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a())) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a(this.a.jdField_a_of_type_AndroidContentContext, paramMessageForPoke.isSend() ^ true, PokeItemHelper.a(this.a.b), paramHolder.jdField_a_of_type_Float);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setParams(paramMessageForPoke.isSend() ^ true);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setMirror(paramMessageForPoke.isSend() ^ true);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(0);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setEndListener(new GivingHeartItemBuilder.PokeClickListener.1(this, paramHolder, paramMessageForPoke));
    if (!paramMessageForPoke.mUnlimitedState.a)
    {
      if (QLog.isColorLevel()) {
        QLog.i("fangdazhao", 2, "[click]start to play");
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.c();
    }
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    if (a(paramHolder, paramMessageForPoke)) {
      return;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(paramCustomFrameAnimationDrawable);
    Object localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    boolean bool1 = false;
    ((DiniFlyAnimationView)localObject).setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    if (paramMessageForPoke.mFrameState.a)
    {
      paramCustomFrameAnimationDrawable.d();
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, "[click]resume to play");
      }
    }
    else
    {
      paramCustomFrameAnimationDrawable.c();
      if (paramHolder.jdField_a_of_type_Float == 2.0F) {
        if (paramMessageForPoke.interactType == 2)
        {
          PokeItemAnimationManager.a().a(1);
          PokeItemAnimationManager.a().a(2, 1500L, paramMessageForPoke.isSend());
        }
        else if (paramMessageForPoke.interactType == 3)
        {
          PokeItemAnimationManager.a().a(4);
          PokeItemAnimationManager.a().a(5, 700L);
        }
        else if (paramMessageForPoke.interactType == 4)
        {
          PokeItemAnimationManager.a().a(13);
          PokeItemAnimationManager.a().a(14, 800L);
        }
      }
      if ((paramMessageForPoke.interactType == 1) || (paramMessageForPoke.interactType == 0))
      {
        paramCustomFrameAnimationDrawable = this.a;
        localObject = (Activity)paramCustomFrameAnimationDrawable.jdField_a_of_type_AndroidContentContext;
        boolean bool2 = paramMessageForPoke.isSend();
        if (paramHolder.jdField_a_of_type_Float == 2.0F) {
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
      return c(paramHolder, paramMessageForPoke);
    }
    return false;
  }
  
  private boolean a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if ((paramMessageForPoke.interactType == 5) && (paramHolder.jdField_a_of_type_Float == 2.0F))
    {
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramMessageForPoke = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.a.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362288)).a();
      paramHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
      paramMessageForPoke.a(paramHolder, PokeItemHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      paramMessageForPoke.setListener(this.a);
      return true;
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
    paramCustomFrameAnimationDrawable.h();
    paramCustomFrameAnimationDrawable.a(new GivingHeartItemBuilder.PokeClickListener.2(this, paramHolder, paramMessageForPoke));
  }
  
  private boolean b(View paramView, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    int i;
    if (paramView.findViewById(2131378280).getVisibility() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (!PokeItemHelper.c.contains(Integer.valueOf(paramMessageForPoke.subId))) {
        PokeItemHelper.c.add(Integer.valueOf(paramMessageForPoke.subId));
      }
      if (!PokeItemHelper.d.contains(Integer.valueOf(paramMessageForPoke.subId))) {
        PokeItemHelper.d.add(Integer.valueOf(paramMessageForPoke.subId));
      }
      if (!PokeItemHelper.b.contains(Integer.valueOf(paramMessageForPoke.subId))) {
        PokeItemHelper.b.add(Integer.valueOf(paramMessageForPoke.subId));
      }
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramHolder.b.setVisibility(8);
      paramView = (IVasQuickUpdateService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
      paramHolder = new StringBuilder();
      paramHolder.append("poke.item.effect.");
      paramHolder.append(paramMessageForPoke.subId);
      paramView.downloadItem(21L, paramHolder.toString(), "getbubbleview");
      paramHolder = new StringBuilder();
      paramHolder.append("poke.item.res.");
      paramHolder.append(paramMessageForPoke.subId);
      paramView.downloadItem(21L, paramHolder.toString(), "getbubbleview");
      paramView.addCallBacker(this.a.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
      return true;
    }
    if (!PokeItemHelper.a("bubble", paramMessageForPoke.subId))
    {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 0, HardCodeUtil.a(2131705373), 0).a();
      return true;
    }
    return false;
  }
  
  private boolean b(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if (!PokeBigResHandler.a)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 0, HardCodeUtil.a(2131705366), 0).a();
      paramHolder = (PokeBigResHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.POKE_BIG_RES_HANDLER);
      if (paramHolder != null) {
        paramHolder.a(true);
      }
      if (paramMessageForPoke.isSend()) {
        paramMessageForPoke.setPlayed(this.a.b);
      }
      return true;
    }
    return false;
  }
  
  private boolean c(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if ((((ISpriteUtil)QRoute.api(ISpriteUtil.class)).getSpriteContext(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a() ^ true))
    {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.a.b, "vas_poke", true);
      if (QLog.isColorLevel()) {
        QLog.i("GivingHeart.sprite", 2, "hide sprite (normal) in click.");
      }
    }
    PokeItemHelper.a(this.a.b, this.a.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, paramHolder, paramMessageForPoke.subId, "bubble");
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (!(paramView.getContext() instanceof ChatHistoryActivity))
    {
      AIOUtils.o = true;
      if (!this.a.a())
      {
        GivingHeartItemBuilder.Holder localHolder = (GivingHeartItemBuilder.Holder)AIOUtils.a(paramView);
        MessageForPoke localMessageForPoke = (MessageForPoke)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("poke onClick() is called, type:");
          ((StringBuilder)localObject1).append(localMessageForPoke.interactType);
          QLog.d("GivingHeart", 2, ((StringBuilder)localObject1).toString());
        }
        if ((!a(paramView, localHolder, localMessageForPoke)) && (!b(localHolder, localMessageForPoke)))
        {
          Object localObject2 = this.a.a(localMessageForPoke);
          localObject1 = ((GivingHeartItemBuilder.FileNumEntity)localObject2).jdField_a_of_type_JavaLangString;
          int i = ((GivingHeartItemBuilder.FileNumEntity)localObject2).jdField_a_of_type_Int;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.PokeClickListener
 * JD-Core Version:    0.7.0.1
 */