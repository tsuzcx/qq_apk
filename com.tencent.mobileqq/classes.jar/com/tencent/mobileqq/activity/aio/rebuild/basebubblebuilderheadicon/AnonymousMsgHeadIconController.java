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
  protected void b()
  {
    Object localObject1 = this.c.getResources().getDrawable(2130844765);
    Object localObject2 = AnonymousChatHelper.g(this.a);
    localObject1 = URLDrawable.getDrawable(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject2).d), (Drawable)localObject1, (Drawable)localObject1);
    localObject2 = ((AnonymousChatHelper.AnonymousExtInfo)localObject2).f;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      try
      {
        int i = DisplayUtil.a(this.c, 1.0F);
        ((URLDrawable)localObject1).setTag(new int[] { Color.parseColor((String)localObject2), i });
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.q);
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
    a(this.h);
  }
  
  protected void d()
  {
    a(null);
  }
  
  protected void g() {}
  
  public boolean h()
  {
    return AnonymousChatHelper.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.AnonymousMsgHeadIconController
 * JD-Core Version:    0.7.0.1
 */