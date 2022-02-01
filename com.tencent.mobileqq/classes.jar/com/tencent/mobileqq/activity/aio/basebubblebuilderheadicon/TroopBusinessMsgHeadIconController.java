package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import java.net.MalformedURLException;
import java.net.URL;

public class TroopBusinessMsgHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  private boolean b()
  {
    boolean bool = false;
    if (TroopBusinessUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) != null) {
      bool = true;
    }
    return bool;
  }
  
  protected void a()
  {
    TroopBusinessUtil.TroopBusinessMessage localTroopBusinessMessage = TroopBusinessUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840452);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    Object localObject2 = null;
    URLDrawable localURLDrawable = null;
    Object localObject1 = localURLDrawable;
    if (localTroopBusinessMessage != null)
    {
      localObject1 = localURLDrawable;
      if (localTroopBusinessMessage.a != null) {
        localObject1 = localObject2;
      }
    }
    try
    {
      localURLDrawable = URLDrawable.getDrawable(new URL(localTroopBusinessMessage.a), localURLDrawableOptions);
      localObject1 = localURLDrawable;
      localURLDrawable.setTag(URLDrawableDecodeHandler.b(100, 100, 6));
      localObject1 = localURLDrawable;
      localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.a);
      localObject1 = localURLDrawable;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
      }
      a(localDrawable);
    }
    if (localObject1 != null)
    {
      a(localObject1);
      return;
    }
  }
  
  public boolean a()
  {
    return b();
  }
  
  protected void b()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
  }
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.TroopBusinessMsgHeadIconController
 * JD-Core Version:    0.7.0.1
 */