package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.IStickerModel;
import java.net.URL;

public abstract interface IStickerRecEmoticon
  extends IEmoticonExposure, IEmoticonSort, IStickerModel
{
  public abstract URLDrawable.URLDrawableOptions a();
  
  public abstract URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions);
  
  public abstract String a();
  
  public abstract URL a();
  
  public abstract void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt);
  
  public abstract void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo);
  
  public abstract boolean a();
  
  public abstract String b();
  
  public abstract boolean b();
  
  public abstract String c();
  
  public abstract boolean c();
  
  public abstract String d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
 * JD-Core Version:    0.7.0.1
 */