package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;

public class AnonymousMsgHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  public boolean a()
  {
    return AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
  
  protected void b()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843811);
    Object localObject2 = AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    localObject1 = URLDrawable.getDrawable(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject2).b), (Drawable)localObject1, (Drawable)localObject1);
    localObject2 = ((AnonymousChatHelper.AnonymousExtInfo)localObject2).c;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      try
      {
        int i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
        ((URLDrawable)localObject1).setTag(new int[] { Color.parseColor((String)localObject2), i });
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.p);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    b(localObject1);
  }
  
  protected void c()
  {
    a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  protected void d()
  {
    a(null);
  }
  
  protected void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.AnonymousMsgHeadIconController
 * JD-Core Version:    0.7.0.1
 */