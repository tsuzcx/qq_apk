package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class MarketFaceItemBuilder$MarketFaceView
  extends URLImageView
{
  public MarketFaceItemBuilder$MarketFaceView(MarketFaceItemBuilder paramMarketFaceItemBuilder, Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((!EmoticonPanelUtils.a()) || (2 != paramHolder.a.getEmoticon().jobType) || (this.a.D.verifyMagicFacePackageIntact(paramHolder.a.getEmoticon().epId)) || (!MagicfaceViewController.b()) || (EmoticonPanelUtils.c()))
    {
      float f = this.a.D.getEmoticonPackageLoadingProgress(paramHolder.a.getEmoticon().epId);
      if ((f < 0.0F) || (1.0F == f))
      {
        paramHolder.v.setVisibility(8);
        paramHolder.j.setProgressVisable(false);
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
        }
      }
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (MarketFaceItemBuilder.Holder)AIOUtils.b(this);
    paramThrowable.v.setVisibility(8);
    this.a.a(paramThrowable, paramURLDrawable);
    if (AppSetting.e) {
      paramThrowable.u.setContentDescription(HardCodeUtil.a(2131904377));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Object localObject = (MarketFaceItemBuilder.Holder)AIOUtils.b(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoadSuccessed  holder == null url=");
      ((StringBuilder)localObject).append(paramURLDrawable.getURL());
      QLog.e("MarketFaceItemBuilder", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (((MarketFaceItemBuilder.Holder)localObject).a == null)
    {
      int j = -1;
      paramURLDrawable = ((MarketFaceItemBuilder.Holder)localObject).q;
      int i = j;
      if ((paramURLDrawable instanceof MessageForMarketFace))
      {
        paramURLDrawable = ((MessageForMarketFace)paramURLDrawable).mMarkFaceMessage;
        i = j;
        if (paramURLDrawable != null) {
          i = paramURLDrawable.dwTabID;
        }
      }
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadSuccessed  emoticonInfo == null epId = ");
      paramURLDrawable.append(i);
      QLog.e("MarketFaceItemBuilder", 1, paramURLDrawable.toString());
      return;
    }
    a((MarketFaceItemBuilder.Holder)localObject);
    this.a.a((MarketFaceItemBuilder.Holder)localObject, paramURLDrawable);
    if ((2 == ((MarketFaceItemBuilder.Holder)localObject).a.getEmoticon().jobType) && (MagicfaceViewController.b()) && (this.a.D.verifyMagicFacePackageIntact(((MarketFaceItemBuilder.Holder)localObject).a.getEmoticon().epId))) {
      if (PngFrameUtil.b(((MarketFaceItemBuilder.Holder)localObject).a.getEmoticon().magicValue) == 1)
      {
        ((MarketFaceItemBuilder.Holder)localObject).t.setVisibility(8);
      }
      else if (!this.a.o)
      {
        ((MarketFaceItemBuilder.Holder)localObject).t.setImageResource(2130837998);
        ((MarketFaceItemBuilder.Holder)localObject).t.setVisibility(0);
      }
    }
    if ((4 == ((MarketFaceItemBuilder.Holder)localObject).a.getEmoticon().jobType) && (this.a.D.isDPCSupportH5Magic()) && (this.a.D.isH5MagicIntact(((MarketFaceItemBuilder.Holder)localObject).a.getEmoticon().epId, true, true)) && (!this.a.o))
    {
      ((MarketFaceItemBuilder.Holder)localObject).t.setImageResource(2130837998);
      ((MarketFaceItemBuilder.Holder)localObject).t.setVisibility(0);
    }
    if ((MarketFaceItemBuilder.C != 0L) && (MarketFaceItemBuilder.C == ((MarketFaceItemBuilder.Holder)localObject).q.uniseq) && (((MarketFaceItemBuilder.Holder)localObject).a.isSound())) {
      if (this.a.d.isVideoChatting()) {
        QQToast.makeText(this.a.d.getApp(), 2131892896, 0).show(this.a.A.getResources().getDimensionPixelSize(2131299920));
      } else {
        MediaPlayerManager.a(this.a.d).a(((MarketFaceItemBuilder.Holder)localObject).q);
      }
    }
    if (AppSetting.e) {
      ((MarketFaceItemBuilder.Holder)localObject).u.setContentDescription("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.MarketFaceView
 * JD-Core Version:    0.7.0.1
 */