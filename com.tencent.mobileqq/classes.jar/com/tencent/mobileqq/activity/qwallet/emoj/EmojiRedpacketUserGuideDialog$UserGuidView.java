package com.tencent.mobileqq.activity.qwallet.emoj;

import alud;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bayu;
import bczz;
import bdaq;
import com.tencent.mobileqq.widget.RoundImageView;
import cooperation.qwallet.plugin.QWalletPicHelper;
import xsm;

class EmojiRedpacketUserGuideDialog$UserGuidView
  extends FrameLayout
{
  public EmojiRedpacketUserGuideDialog$UserGuidView(EmojiRedpacketUserGuideDialog paramEmojiRedpacketUserGuideDialog, @NonNull Context paramContext)
  {
    super(paramContext);
    Object localObject1 = new RelativeLayout(paramContext);
    ((RelativeLayout)localObject1).setClickable(true);
    addView((View)localObject1);
    Object localObject2 = (FrameLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).width = -1;
    ((FrameLayout.LayoutParams)localObject2).height = -1;
    ((RelativeLayout)localObject1).setOnClickListener(new EmojiRedpacketUserGuideDialog.UserGuidView.1(this, paramEmojiRedpacketUserGuideDialog));
    paramEmojiRedpacketUserGuideDialog = new View(paramContext);
    ((RelativeLayout)localObject1).addView(paramEmojiRedpacketUserGuideDialog);
    localObject2 = (RelativeLayout.LayoutParams)paramEmojiRedpacketUserGuideDialog.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    ((RelativeLayout.LayoutParams)localObject2).width = bdaq.a(paramContext, 40.0F);
    ((RelativeLayout.LayoutParams)localObject2).height = bdaq.a(paramContext, 40.0F);
    localObject2 = getResources().getDrawable(2130843053);
    paramEmojiRedpacketUserGuideDialog.setBackgroundDrawable((Drawable)localObject2);
    ((Animatable)localObject2).start();
    paramEmojiRedpacketUserGuideDialog = new LinearLayout(paramContext);
    paramEmojiRedpacketUserGuideDialog.setOrientation(1);
    ((RelativeLayout)localObject1).addView(paramEmojiRedpacketUserGuideDialog);
    localObject1 = (RelativeLayout.LayoutParams)paramEmojiRedpacketUserGuideDialog.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    ((RelativeLayout.LayoutParams)localObject1).width = -1;
    ((RelativeLayout.LayoutParams)localObject1).height = -2;
    localObject1 = new RoundImageView(paramContext);
    ((RoundImageView)localObject1).setmRadius(xsm.a(paramContext, 10.0F), false);
    ((RoundImageView)localObject1).setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(EmojiRedpacketUserGuideDialog.URL_DEFAULT, bayu.a, bayu.a));
    paramEmojiRedpacketUserGuideDialog.addView((View)localObject1);
    localObject1 = (LinearLayout.LayoutParams)((RoundImageView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).gravity = 1;
    ((LinearLayout.LayoutParams)localObject1).height = ((int)(xsm.d(paramContext) * 0.7D));
    ((LinearLayout.LayoutParams)localObject1).width = xsm.a(paramContext, 320.0F);
    localObject1 = new ImageView(paramContext);
    ((ImageView)localObject1).setImageResource(2130846088);
    paramEmojiRedpacketUserGuideDialog.addView((View)localObject1);
    paramEmojiRedpacketUserGuideDialog = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
    paramEmojiRedpacketUserGuideDialog.topMargin = ((int)(xsm.d(paramContext) * 0.02D));
    paramEmojiRedpacketUserGuideDialog.gravity = 1;
    paramEmojiRedpacketUserGuideDialog.width = xsm.a(paramContext, 37.0F);
    paramEmojiRedpacketUserGuideDialog.height = xsm.a(paramContext, 37.0F);
    bczz.a((View)localObject1, alud.a(2131704412), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiRedpacketUserGuideDialog.UserGuidView
 * JD-Core Version:    0.7.0.1
 */