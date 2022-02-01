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
  public abstract URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions);
  
  public abstract void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt);
  
  public abstract void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo);
  
  public abstract boolean b();
  
  public abstract URLDrawable.URLDrawableOptions c();
  
  public abstract boolean d();
  
  public abstract String e();
  
  public abstract String f();
  
  public abstract boolean g();
  
  public abstract URL k();
  
  public abstract String l();
  
  public abstract String m();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
 * JD-Core Version:    0.7.0.1
 */