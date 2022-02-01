package com.tencent.mobileqq.apollo.view.pannel;

import android.graphics.drawable.Drawable;
import bbbq;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$29
  implements Runnable
{
  ApolloPanel$29(ApolloPanel paramApolloPanel, BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      ((bbbq)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ApolloPanel.a(this.this$0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ApolloPanel.a(this.this$0);
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "[parseShopRedTouchManager] shopDrawable not ready");
        }
        ((URLDrawable)localObject).startDownload();
      }
      if (this.this$0.jdField_a_of_type_ComTencentImageURLImageView != null) {
        this.this$0.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.29
 * JD-Core Version:    0.7.0.1
 */