package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public class AnonymousMsgHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  protected void a()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843891);
    Object localObject2 = AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    localObject1 = URLDrawable.getDrawable(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject2).b), (Drawable)localObject1, (Drawable)localObject1);
    localObject2 = ((AnonymousChatHelper.AnonymousExtInfo)localObject2).c;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      int i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
      ((URLDrawable)localObject1).setTag(new int[] { Color.parseColor((String)localObject2), i });
      ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.r);
      a(localObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean a()
  {
    return AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
  
  protected void b()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
    }
  }
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.AnonymousMsgHeadIconController
 * JD-Core Version:    0.7.0.1
 */