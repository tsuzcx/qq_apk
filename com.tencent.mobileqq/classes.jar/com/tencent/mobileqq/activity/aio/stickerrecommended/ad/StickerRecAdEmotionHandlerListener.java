package com.tencent.mobileqq.activity.aio.stickerrecommended.ad;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BaseLocalEmoticonHandleListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StickerRecAdEmotionHandlerListener
  extends BaseLocalEmoticonHandleListener
{
  public StickerRecAdEmotionHandlerListener(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface);
  }
  
  private static boolean a(List<String> paramList, String paramString)
  {
    if ((paramList != null) && (paramList.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (((String)paramList.next()).equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public List<StickerRecAdData> a(String paramString, BaseSessionInfo paramBaseSessionInfo)
  {
    return a(paramString, AdEmoCfgProvider.a(this.a.getApp(), this.a.getCurrentUin()), paramBaseSessionInfo);
  }
  
  public List<StickerRecAdData> a(String paramString, AdEmoCfg paramAdEmoCfg, BaseSessionInfo paramBaseSessionInfo)
  {
    ArrayList localArrayList = null;
    Object localObject1 = localArrayList;
    if (paramAdEmoCfg != null)
    {
      if (!paramAdEmoCfg.a) {
        return null;
      }
      Object localObject2 = paramAdEmoCfg.c;
      localObject1 = localArrayList;
      if (localObject2 != null)
      {
        if (((List)localObject2).size() == 0) {
          return null;
        }
        localArrayList = new ArrayList();
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AdItem)((Iterator)localObject1).next();
          if (a(((AdItem)localObject2).a, paramString))
          {
            new AdEmoReportUtil().a(this.a, paramBaseSessionInfo, paramString);
            if ((((AdItem)localObject2).b != null) && (((AdItem)localObject2).b.size() > 0))
            {
              localObject2 = ((AdItem)localObject2).b.iterator();
              while (((Iterator)localObject2).hasNext()) {
                localArrayList.add(new StickerRecAdData((AdEmoItem)((Iterator)localObject2).next(), paramBaseSessionInfo, paramString));
              }
            }
          }
        }
        localObject1 = localArrayList;
        if (paramAdEmoCfg.b == 1)
        {
          Collections.shuffle(localArrayList);
          localObject1 = localArrayList;
        }
      }
    }
    return localObject1;
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.ad.StickerRecAdEmotionHandlerListener
 * JD-Core Version:    0.7.0.1
 */