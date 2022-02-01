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
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.script.ISpriteUtil;
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
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inScaled = true;
    ((BitmapFactory.Options)localObject1).inSampleSize = 1;
    ((BitmapFactory.Options)localObject1).inMutable = true;
    try
    {
      localObject1 = ImageUtil.a(paramString1 + "01.png", (BitmapFactory.Options)localObject1);
      paramString2 = new CustomFrameAnimationDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1, PokeItemAnimationManager.a().a(), paramMessageForPoke.mFrameState, paramString2, PokeItemHelper.a(this.a.b));
      paramString2.i();
      i = 40;
      if (paramMessageForPoke.interactType == 2) {
        i = 30;
      }
      if ((paramMessageForPoke.interactType == 4) && (paramHolder.jdField_a_of_type_Float == 2.0F))
      {
        j = 0;
        for (;;)
        {
          if (j >= 20) {
            break label265;
          }
          if (j + 1 >= 10) {
            break;
          }
          paramString2.a(j, i, paramString1 + "0" + (j + 1) + ".png");
          j += 1;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      int i;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, localOutOfMemoryError.toString());
        }
        Object localObject2 = null;
        continue;
        paramString2.a(j, i, paramString1 + (j + 1) + ".png");
      }
      label265:
      int j = 20;
      while (j < paramInt)
      {
        paramString2.a(j, i, paramString1 + 21 + ".png");
        j += 1;
        continue;
        j = 0;
        if (j < paramInt)
        {
          if (j + 1 < 10) {
            paramString2.a(j, i, paramString1 + "0" + (j + 1) + ".png");
          }
          for (;;)
          {
            j += 1;
            break;
            paramString2.a(j, i, paramString1 + (j + 1) + ".png");
          }
        }
      }
    }
    return paramString2;
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    boolean bool2 = true;
    UnlimitedBladeWorks localUnlimitedBladeWorks;
    if ((PokeBigResHandler.a) && (!paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a()))
    {
      localUnlimitedBladeWorks = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      Context localContext = this.a.jdField_a_of_type_AndroidContentContext;
      if (!paramMessageForPoke.isSend())
      {
        bool1 = true;
        localUnlimitedBladeWorks.a(localContext, bool1, PokeItemHelper.a(this.a.b), paramHolder.jdField_a_of_type_Float);
      }
    }
    else
    {
      localUnlimitedBladeWorks = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      if (paramMessageForPoke.isSend()) {
        break label219;
      }
      bool1 = true;
      label80:
      localUnlimitedBladeWorks.setParams(bool1);
      localUnlimitedBladeWorks = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      if (paramMessageForPoke.isSend()) {
        break label224;
      }
    }
    label219:
    label224:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localUnlimitedBladeWorks.setMirror(bool1);
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
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label80;
    }
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    boolean bool1 = true;
    if (a(paramHolder, paramMessageForPoke)) {}
    do
    {
      return;
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(paramCustomFrameAnimationDrawable);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      if (!paramMessageForPoke.mFrameState.a) {
        break;
      }
      paramCustomFrameAnimationDrawable.d();
    } while (!QLog.isColorLevel());
    QLog.d("GivingHeart", 2, "[click]resume to play");
    return;
    paramCustomFrameAnimationDrawable.c();
    label141:
    Activity localActivity;
    boolean bool2;
    if (paramHolder.jdField_a_of_type_Float == 2.0F)
    {
      if (paramMessageForPoke.interactType == 2)
      {
        PokeItemAnimationManager.a().a(1);
        PokeItemAnimationManager.a().a(2, 1500L, paramMessageForPoke.isSend());
      }
    }
    else if ((paramMessageForPoke.interactType == 1) || (paramMessageForPoke.interactType == 0))
    {
      paramCustomFrameAnimationDrawable = this.a;
      localActivity = (Activity)this.a.jdField_a_of_type_AndroidContentContext;
      bool2 = paramMessageForPoke.isSend();
      if (paramHolder.jdField_a_of_type_Float != 2.0F) {
        break label271;
      }
    }
    for (;;)
    {
      GivingHeartItemBuilder.a(paramCustomFrameAnimationDrawable, localActivity, bool2, bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GivingHeart", 2, "[click]start to play");
      return;
      if (paramMessageForPoke.interactType == 3)
      {
        PokeItemAnimationManager.a().a(4);
        PokeItemAnimationManager.a().a(5, 700L);
        break label141;
      }
      if (paramMessageForPoke.interactType != 4) {
        break label141;
      }
      PokeItemAnimationManager.a().a(13);
      PokeItemAnimationManager.a().a(14, 800L);
      break label141;
      label271:
      bool1 = false;
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
      paramMessageForPoke = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.a.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362327)).a();
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
    if (!paramMessageForPoke.isSend())
    {
      if (paramMessageForPoke.interactType == 5) {
        break label43;
      }
      paramCustomFrameAnimationDrawable.b();
    }
    for (;;)
    {
      paramCustomFrameAnimationDrawable.h();
      paramCustomFrameAnimationDrawable.a(new GivingHeartItemBuilder.PokeClickListener.2(this, paramHolder, paramMessageForPoke));
      return;
      label43:
      paramCustomFrameAnimationDrawable.a(2);
    }
  }
  
  private boolean b(View paramView, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    boolean bool = false;
    int i;
    if (paramView.findViewById(2131378891).getVisibility() == 0)
    {
      i = 1;
      if (i == 0) {
        break label246;
      }
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
      paramView.downloadItem(21L, "poke.item.effect." + paramMessageForPoke.subId, "getbubbleview");
      paramView.downloadItem(21L, "poke.item.res." + paramMessageForPoke.subId, "getbubbleview");
      paramView.addCallBacker(this.a.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
      bool = true;
    }
    label246:
    while (PokeItemHelper.a("bubble", paramMessageForPoke.subId))
    {
      return bool;
      i = 0;
      break;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 0, HardCodeUtil.a(2131705299), 0).a();
    return true;
  }
  
  private boolean b(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    boolean bool = false;
    if (!PokeBigResHandler.a)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 0, HardCodeUtil.a(2131705292), 0).a();
      paramHolder = (PokeBigResHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.POKE_BIG_RES_HANDLER);
      if (paramHolder != null) {
        paramHolder.a(true);
      }
      if (paramMessageForPoke.isSend()) {
        paramMessageForPoke.setPlayed(this.a.b);
      }
      bool = true;
    }
    return bool;
  }
  
  private boolean c(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if (((ISpriteUtil)QRoute.api(ISpriteUtil.class)).getSpriteContext(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.a.b, "vas_poke", true);
        if (QLog.isColorLevel()) {
          QLog.i("GivingHeart.sprite", 2, "hide sprite (normal) in click.");
        }
      }
      PokeItemHelper.a(this.a.b, this.a.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, paramHolder, paramMessageForPoke.subId, "bubble");
      return true;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getContext() instanceof ChatHistoryActivity)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AIOUtils.o = true;
      if (!this.a.a())
      {
        GivingHeartItemBuilder.Holder localHolder = (GivingHeartItemBuilder.Holder)AIOUtils.a(paramView);
        MessageForPoke localMessageForPoke = (MessageForPoke)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, "poke onClick() is called, type:" + localMessageForPoke.interactType);
        }
        if ((!a(paramView, localHolder, localMessageForPoke)) && (!b(localHolder, localMessageForPoke)))
        {
          Object localObject2 = this.a.a(localMessageForPoke);
          Object localObject1 = ((GivingHeartItemBuilder.FileNumEntity)localObject2).jdField_a_of_type_JavaLangString;
          int i = ((GivingHeartItemBuilder.FileNumEntity)localObject2).jdField_a_of_type_Int;
          localObject2 = GivingHeartItemBuilder.a(localMessageForPoke.interactType);
          if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType <= 0) || (localMessageForPoke.interactType > 6)) {}
          for (localObject1 = GivingHeartItemBuilder.a(this.a, localHolder, localMessageForPoke, (String)localObject2);; localObject1 = a(localHolder, localMessageForPoke, (String)localObject1, i, (String)localObject2))
          {
            b(localHolder, localMessageForPoke, (CustomFrameAnimationDrawable)localObject1);
            if (localMessageForPoke.interactType == 6) {
              break label231;
            }
            a(localHolder, localMessageForPoke, (CustomFrameAnimationDrawable)localObject1);
            break;
          }
          label231:
          a(localHolder, localMessageForPoke);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.PokeClickListener
 * JD-Core Version:    0.7.0.1
 */