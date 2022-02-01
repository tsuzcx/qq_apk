package com.tencent.mobileqq.apollo.aio.panel;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$28
  implements Runnable
{
  ApolloPanel$28(ApolloPanel paramApolloPanel, BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString) {}
  
  public void run()
  {
    if (ApolloPanel.a(this.this$0) != null)
    {
      if (ApolloPanel.a(this.this$0).a == null) {
        return;
      }
      ApolloPanel.a(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      ((IRedTouchManager)ApolloPanel.a(this.this$0).a.getRuntimeService(IRedTouchManager.class, "")).onReportRedPointExposure(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ApolloPanel.a(this.this$0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ApolloPanel.a(this.this$0);
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloPanel", 2, "[parseShopRedTouchManager] shopDrawable not ready");
        }
        ((URLDrawable)localObject).startDownload();
      }
      if (ApolloPanel.b(this.this$0) != null) {
        ApolloPanel.b(this.this$0).setImageDrawable((Drawable)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.28
 * JD-Core Version:    0.7.0.1
 */