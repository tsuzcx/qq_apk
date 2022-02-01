package com.tencent.biz.pubaccount.readinjoy;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

class ReadInJoyTabController$1
  extends ReadInJoyObserver
{
  public void a(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        this.a.a(paramList);
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (TabChannelCoverInfo)localIterator.next();
        if ((!TextUtils.isEmpty(((TabChannelCoverInfo)localObject).mChannelJumpUrl)) && (((TabChannelCoverInfo)localObject).mChannelJumpUrl.indexOf("html/topic.html") != -1)) {
          for (;;)
          {
            int i;
            try
            {
              for (;;)
              {
                localObject = new URL(((TabChannelCoverInfo)localObject).mChannelJumpUrl);
                if (TextUtils.isEmpty(((URL)localObject).getQuery())) {
                  break;
                }
                localObject = ((URL)localObject).getQuery().split("[&]");
                int j = localObject.length;
                i = 0;
                if (i >= j) {
                  break;
                }
                String[] arrayOfString = localObject[i].split("[=]");
                if (arrayOfString.length <= 1) {
                  break label272;
                }
                boolean bool = "topicid".equals(arrayOfString[0]);
                if (!bool) {
                  break label272;
                }
                try
                {
                  Integer.valueOf(arrayOfString[1]).intValue();
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("ReadInJoyTabController", 2, "onMainChannelListUpdate preload topic and topicId = " + arrayOfString[1]);
                }
                catch (Exception localException) {}
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ReadInJoyTabController", 2, "onMainChannelListUpdate preload topic and topic is illegal");
            }
            catch (MalformedURLException localMalformedURLException) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ReadInJoyTabController", 2, "onMainChannelListUpdate preload topic MalformedURLException " + localMalformedURLException);
            break;
            label272:
            i += 1;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTabController", 2, "onMainChannelListUpdate infos size" + paramList.size());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabController", 2, "onMainChannelListUpdate" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyTabController.1
 * JD-Core Version:    0.7.0.1
 */