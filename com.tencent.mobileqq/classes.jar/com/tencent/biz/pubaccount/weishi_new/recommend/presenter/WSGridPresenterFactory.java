package com.tencent.biz.pubaccount.weishi_new.recommend.presenter;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageContract.Presenter;

public class WSGridPresenterFactory
{
  public static WSGridPageContract.Presenter a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return b(paramString);
    }
    if (TextUtils.equals(paramString, "1000")) {
      return b(paramString);
    }
    return new WSGridForCommonPresenter(paramString);
  }
  
  private static WSGridPageContract.Presenter b(String paramString)
  {
    if (WSComboExpHelper.a.a()) {
      return new WSGridForComboHotPresenter(paramString);
    }
    return new WSGridForHotPresenter(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.presenter.WSGridPresenterFactory
 * JD-Core Version:    0.7.0.1
 */