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
  protected Context a;
  protected View.OnClickListener a;
  protected View.OnLongClickListener a;
  private BaseChatItemLayout a;
  protected SessionInfo a;
  protected QQAppInterface a;
  protected IFaceDecoder a;
  protected ChatMessage a;
  protected VasAvatar a;
  
  private final VasAvatar a()
  {
    HeadIconWrapper localHeadIconWrapper = a();
    if (localHeadIconWrapper != null) {
      return ((IHeadIconProcessor)localHeadIconWrapper.a()).a();
    }
    return null;
  }
  
  protected final Drawable a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder == null) {
      return null;
    }
    Object localObject = (BaseBubbleBuilder.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    if (localObject != null)
    {
      ((BaseBubbleBuilder.ViewHolder)localObject).a = paramString;
      ((BaseBubbleBuilder.ViewHolder)localObject).d = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTag(localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCacheFrom(paramInt, paramString, 6);
    if (localObject == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt, true);
      }
      return ImageUtil.e();
    }
    return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
  }
  
  protected final BaseChatItemLayoutViewBasicAbility a()
  {
    HeadIconWrapper localHeadIconWrapper = a();
    if (localHeadIconWrapper != null) {
      return localHeadIconWrapper.a();
    }
    return null;
  }
  
  protected final HeadIconWrapper a()
  {
    return (HeadIconWrapper)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(HeadIconWrapper.class);
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
    BaseChatItemLayoutViewBasicAbility localBaseChatItemLayoutViewBasicAbility = a();
    if (localBaseChatItemLayoutViewBasicAbility != null) {
      localBaseChatItemLayoutViewBasicAbility.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected final void a(View.OnLongClickListener paramOnLongClickListener)
  {
    BaseChatItemLayoutViewBasicAbility localBaseChatItemLayoutViewBasicAbility = a();
    if (localBaseChatItemLayoutViewBasicAbility != null) {
      localBaseChatItemLayoutViewBasicAbility.setOnLongClickListener(paramOnLongClickListener);
    }
  }
  
  public void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, BaseChatItemLayout paramBaseChatItemLayout, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = a();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
  }
  
  protected final void a(CharSequence paramCharSequence)
  {
    BaseChatItemLayoutViewBasicAbility localBaseChatItemLayoutViewBasicAbility = a();
    if (localBaseChatItemLayoutViewBasicAbility != null) {
      localBaseChatItemLayoutViewBasicAbility.setContentDescription(paramCharSequence);
    }
  }
  
  protected final void a(Object paramObject)
  {
    BaseChatItemLayoutViewBasicAbility localBaseChatItemLayoutViewBasicAbility = a();
    if (localBaseChatItemLayoutViewBasicAbility != null) {
      localBaseChatItemLayoutViewBasicAbility.setTag(paramObject);
    }
  }
  
  protected final void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    HeadIconWrapper localHeadIconWrapper = a();
    if (localHeadIconWrapper != null) {
      ((IHeadIconProcessor)localHeadIconWrapper.a()).a(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    }
  }
  
  public abstract boolean a();
  
  protected abstract void b();
  
  protected final void b(Object paramObject)
  {
    HeadIconWrapper localHeadIconWrapper = a();
    if (localHeadIconWrapper != null) {
      ((IHeadIconProcessor)localHeadIconWrapper.a()).a(paramObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = a();
  }
  
  protected abstract void c();
  
  protected abstract void d();
  
  protected void e() {}
  
  protected void f() {}
  
  protected abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController
 * JD-Core Version:    0.7.0.1
 */