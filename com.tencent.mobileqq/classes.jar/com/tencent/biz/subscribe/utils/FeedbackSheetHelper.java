package com.tencent.biz.subscribe.utils;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import com.tencent.widget.ActionSheet;

public class FeedbackSheetHelper
{
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, FeedbackSheetHelper.ResultListener paramResultListener, FeedbackSheetHelper.ClickItemListener paramClickItemListener)
  {
    a(paramContext, null, paramStFeed, paramResultListener, paramClickItemListener);
  }
  
  private static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, FeedbackSheetHelper.ResultListener paramResultListener, FeedbackSheetHelper.ClickItemListener paramClickItemListener)
  {
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    localActionSheet.setMainTitle(paramContext.getString(2131719382));
    localActionSheet.addButton(2131719383, 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnDismissListener(new FeedbackSheetHelper.1(localActionSheet, paramClickItemListener));
    localActionSheet.setOnButtonClickListener(new FeedbackSheetHelper.2(paramStUser, paramStFeed, paramResultListener, paramClickItemListener, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, FeedbackSheetHelper.ResultListener paramResultListener, FeedbackSheetHelper.ClickItemListener paramClickItemListener)
  {
    a(paramContext, paramStUser, null, paramResultListener, paramClickItemListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.FeedbackSheetHelper
 * JD-Core Version:    0.7.0.1
 */