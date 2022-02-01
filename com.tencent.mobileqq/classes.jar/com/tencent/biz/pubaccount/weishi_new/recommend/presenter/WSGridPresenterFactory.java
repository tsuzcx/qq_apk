package com.tencent.biz.pubaccount.weishi_new.recommend.presenter;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageContract.Presenter;

public class WSGridPresenterFactory
{
  public static WSGridPageContract.Presenter a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new WSGridForHotPresenter(paramString);
    }
    if (TextUtils.equals(paramString, "1000")) {
      return new WSGridForHotPresenter(paramString);
    }
    return new WSGridForCommonPresenter(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.presenter.WSGridPresenterFactory
 * JD-Core Version:    0.7.0.1
 */