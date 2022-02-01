package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public abstract class BaseBubbleBuilderHeadIconController
{
  protected Context a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  protected View.OnLongClickListener a;
  private BaseChatItemLayout jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
  protected SessionInfo a;
  protected QQAppInterface a;
  protected IFaceDecoder a;
  protected ChatMessage a;
  protected VasAvatar a;
  
  protected final int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility();
    }
    return 8;
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
      return ImageUtil.c();
    }
    return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
  }
  
  protected abstract void a();
  
  protected final void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setVisibility(paramInt);
    }
  }
  
  protected final void a(View paramView)
  {
    if (paramView != null) {
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  protected final void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramView, paramLayoutParams);
  }
  
  public void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, BaseChatItemLayout paramBaseChatItemLayout, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
  }
  
  protected final void a(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setHeaderIcon(paramObject);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar;
  }
  
  public abstract boolean a();
  
  protected final int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a();
  }
  
  protected abstract void b();
  
  protected final void b(View paramView)
  {
    if ((paramView instanceof VasAvatar)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = ((VasAvatar)paramView);
    }
  }
  
  protected final int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b();
  }
  
  protected abstract void c();
  
  protected abstract void d();
  
  public void e()
  {
    a();
    c();
    b();
    g();
    d();
    f();
  }
  
  protected void f() {}
  
  protected void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController
 * JD-Core Version:    0.7.0.1
 */