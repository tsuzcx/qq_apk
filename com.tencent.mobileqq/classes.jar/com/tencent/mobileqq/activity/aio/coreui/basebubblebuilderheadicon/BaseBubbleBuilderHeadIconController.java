package com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.IHeadIconProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public abstract class BaseBubbleBuilderHeadIconController
{
  protected ChatMessage a;
  protected QQAppInterface b;
  protected Context c;
  protected SessionInfo d;
  protected VasAvatar e;
  protected IFaceDecoder f;
  protected View.OnLongClickListener g;
  protected View.OnClickListener h;
  private BaseChatItemLayout i;
  
  private final VasAvatar k()
  {
    HeadIconWrapper localHeadIconWrapper = i();
    if (localHeadIconWrapper != null) {
      return ((IHeadIconProcessor)localHeadIconWrapper.a()).c();
    }
    return null;
  }
  
  protected final Drawable a(int paramInt, String paramString)
  {
    if (this.f == null) {
      return null;
    }
    Object localObject = (BaseBubbleBuilder.ViewHolder)this.i.getTag();
    if (localObject != null)
    {
      ((BaseBubbleBuilder.ViewHolder)localObject).o = paramString;
      ((BaseBubbleBuilder.ViewHolder)localObject).n = paramInt;
      this.i.setTag(localObject);
    }
    localObject = this.f.getBitmapFromCacheFrom(paramInt, paramString, 6);
    if (localObject == null)
    {
      if (!this.f.isPausing()) {
        this.f.requestDecodeFace(paramString, paramInt, true);
      }
      return ImageUtil.j();
    }
    return new BitmapDrawable(this.c.getResources(), (Bitmap)localObject);
  }
  
  public void a()
  {
    b();
    d();
    c();
    f();
    g();
    e();
  }
  
  protected final void a(View.OnClickListener paramOnClickListener)
  {
    BaseChatItemLayoutViewBasicAbility localBaseChatItemLayoutViewBasicAbility = j();
    if (localBaseChatItemLayoutViewBasicAbility != null) {
      localBaseChatItemLayoutViewBasicAbility.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected final void a(View.OnLongClickListener paramOnLongClickListener)
  {
    BaseChatItemLayoutViewBasicAbility localBaseChatItemLayoutViewBasicAbility = j();
    if (localBaseChatItemLayoutViewBasicAbility != null) {
      localBaseChatItemLayoutViewBasicAbility.setOnLongClickListener(paramOnLongClickListener);
    }
  }
  
  public void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, BaseChatItemLayout paramBaseChatItemLayout, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IFaceDecoder paramIFaceDecoder)
  {
    this.a = paramChatMessage;
    this.i = paramBaseChatItemLayout;
    this.b = paramQQAppInterface;
    this.c = paramContext;
    this.d = paramSessionInfo;
    this.i = paramBaseChatItemLayout;
    this.e = k();
    this.h = paramOnClickListener;
    this.g = paramOnLongClickListener;
    this.f = paramIFaceDecoder;
  }
  
  protected final void a(CharSequence paramCharSequence)
  {
    BaseChatItemLayoutViewBasicAbility localBaseChatItemLayoutViewBasicAbility = j();
    if (localBaseChatItemLayoutViewBasicAbility != null) {
      localBaseChatItemLayoutViewBasicAbility.setContentDescription(paramCharSequence);
    }
  }
  
  protected final void a(Object paramObject)
  {
    BaseChatItemLayoutViewBasicAbility localBaseChatItemLayoutViewBasicAbility = j();
    if (localBaseChatItemLayoutViewBasicAbility != null) {
      localBaseChatItemLayoutViewBasicAbility.setTag(paramObject);
    }
  }
  
  protected final void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    HeadIconWrapper localHeadIconWrapper = i();
    if (localHeadIconWrapper != null) {
      ((IHeadIconProcessor)localHeadIconWrapper.a()).a(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    }
  }
  
  protected abstract void b();
  
  protected final void b(Object paramObject)
  {
    HeadIconWrapper localHeadIconWrapper = i();
    if (localHeadIconWrapper != null) {
      ((IHeadIconProcessor)localHeadIconWrapper.a()).a(paramObject);
    }
    this.e = k();
  }
  
  protected abstract void c();
  
  protected abstract void d();
  
  protected void e() {}
  
  protected void f() {}
  
  protected abstract void g();
  
  public abstract boolean h();
  
  protected final HeadIconWrapper i()
  {
    return (HeadIconWrapper)this.i.a(HeadIconWrapper.class);
  }
  
  protected final BaseChatItemLayoutViewBasicAbility j()
  {
    HeadIconWrapper localHeadIconWrapper = i();
    if (localHeadIconWrapper != null) {
      return localHeadIconWrapper.c();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController
 * JD-Core Version:    0.7.0.1
 */