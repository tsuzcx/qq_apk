package com.tencent.biz.pubaccount.subscript;

import android.os.Bundle;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class SubscriptFeedsActivity$15
  extends SubscriptObserver
{
  SubscriptFeedsActivity$15(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  protected void a(boolean paramBoolean, ArrayList<ReadInJoyArticle> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetRecommendReadInJoyArticleList isSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" | data: ");
      ((StringBuilder)localObject).append(paramArrayList);
      QLog.d("SubscriptObserver", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean) {
      return;
    }
    if ((paramArrayList != null) && (paramArrayList.size() == 4))
    {
      if (this.a.l != null)
      {
        localObject = new Message();
        ((Message)localObject).what = 1003;
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("ReadInJoyArticleList", paramArrayList);
        ((Message)localObject).setData(localBundle);
        this.a.l.removeMessages(1003);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("SubscriptObserver", 2, "onGetRecommendReadInJoyArticleList data is null or small than 4");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.15
 * JD-Core Version:    0.7.0.1
 */