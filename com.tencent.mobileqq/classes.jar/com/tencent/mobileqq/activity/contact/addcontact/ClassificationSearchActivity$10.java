package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.search.api.OnTipClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import java.util.List;

class ClassificationSearchActivity$10
  implements OnTipClickListener
{
  ClassificationSearchActivity$10(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      Object localObject2 = null;
      Iterator localIterator = this.a.c.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (ChannelInfo)localIterator.next();
      } while (!paramString.equals(((ChannelInfo)localObject1).mChannelName));
      if (localObject1 != null)
      {
        if (!TextUtils.isEmpty(((ChannelInfo)localObject1).mJumpUrl))
        {
          paramString = new Intent(this.a, QQBrowserActivity.class);
          paramString.putExtra("hide_operation_bar", true);
          paramString.putExtra("url", ((ChannelInfo)localObject1).mJumpUrl);
          this.a.startActivity(paramString);
          return;
        }
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchChannelActivity(this.a, ((ChannelInfo)localObject1).mChannelID, ((ChannelInfo)localObject1).mChannelName, ((ChannelInfo)localObject1).mChannelType, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.10
 * JD-Core Version:    0.7.0.1
 */