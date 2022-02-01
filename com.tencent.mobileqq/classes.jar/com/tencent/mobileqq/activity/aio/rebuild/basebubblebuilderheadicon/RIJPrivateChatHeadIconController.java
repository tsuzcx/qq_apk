package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.activity.recent.RecentRIJPrivateChatItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class RIJPrivateChatHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  private long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getUinLong] e = ");
      localStringBuilder.append(paramString);
      QLog.e("RIJPrivateChatHeadIconController", 1, localStringBuilder.toString());
    }
    return 0L;
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    b(RecentRIJPrivateChatItemBuilder.k);
    if (paramReadInJoyUserInfo == null) {
      return;
    }
    paramReadInJoyUserInfo = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getResultFaceUrl(paramReadInJoyUserInfo);
    if (TextUtils.isEmpty(paramReadInJoyUserInfo)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = RecentRIJPrivateChatItemBuilder.k;
    localURLDrawableOptions.mFailedDrawable = RecentRIJPrivateChatItemBuilder.k;
    paramReadInJoyUserInfo = URLDrawable.getDrawable(paramReadInJoyUserInfo, localURLDrawableOptions);
    paramReadInJoyUserInfo.setTag(URLDrawableDecodeHandler.a(ViewUtils.dip2px(40.0F), ViewUtils.dip2px(40.0F)));
    paramReadInJoyUserInfo.setDecodeHandler(URLDrawableDecodeHandler.c);
    b(paramReadInJoyUserInfo);
  }
  
  protected void b()
  {
    if (this.a == null) {
      return;
    }
    long l = a(this.a.senderuin);
    a(((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getSingleKDUserInfo(l, new RIJPrivateChatHeadIconController.1(this)));
  }
  
  protected void c()
  {
    a(this.h);
  }
  
  protected void d() {}
  
  protected void g()
  {
    a(this.a);
  }
  
  public boolean h()
  {
    ChatMessage localChatMessage = this.a;
    boolean bool = false;
    if (localChatMessage == null) {
      return false;
    }
    if (this.a.istroop == 10013) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.RIJPrivateChatHeadIconController
 * JD-Core Version:    0.7.0.1
 */