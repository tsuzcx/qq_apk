package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.widget.QQToast;

class ShareToComputerHelper$1
  extends DataLineObserver
{
  ShareToComputerHelper$1(ShareToComputerHelper paramShareToComputerHelper) {}
  
  public void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(ShareToComputerHelper.a(this.a))))
    {
      paramLong = BaseApplicationImpl.getApplication().getBaseContext();
      if (paramBoolean) {
        QQToast.a(BaseApplicationImpl.getApplication(), 2, 2131719036, 0).b(paramLong.getResources().getDimensionPixelSize(2131299166));
      }
    }
    else
    {
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131719023, 0).b(paramLong.getResources().getDimensionPixelSize(2131299166));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ShareToComputerHelper.1
 * JD-Core Version:    0.7.0.1
 */