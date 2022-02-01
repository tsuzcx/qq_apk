package com.tencent.mobileqq.activity.aio.stickerrecommended.ad;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BaseLocalEmoticonHandleListener;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StickerRecAdEmotionHandlerListener
  extends BaseLocalEmoticonHandleListener
{
  public StickerRecAdEmotionHandlerListener(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
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
  
  public List<StickerRecAdData> a(String paramString, SessionInfo paramSessionInfo)
  {
    return a(paramString, AdEmoCfgProvider.a(this.a.getApp(), this.a.getCurrentUin()), paramSessionInfo);
  }
  
  public List<StickerRecAdData> a(String paramString, AdEmoCfg paramAdEmoCfg, SessionInfo paramSessionInfo)
  {
    if ((paramAdEmoCfg == null) || (!paramAdEmoCfg.jdField_a_of_type_Boolean)) {}
    do
    {
      return null;
      localObject1 = paramAdEmoCfg.jdField_a_of_type_JavaUtilList;
    } while ((localObject1 == null) || (((List)localObject1).size() == 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (AdItem)((Iterator)localObject1).next();
      if (a(((AdItem)localObject2).jdField_a_of_type_JavaUtilList, paramString))
      {
        new AdEmoReportUtil().a(this.a, paramSessionInfo, paramString);
        if ((((AdItem)localObject2).b != null) && (((AdItem)localObject2).b.size() > 0))
        {
          localObject2 = ((AdItem)localObject2).b.iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayList.add(new StickerRecAdData((AdEmoItem)((Iterator)localObject2).next(), paramSessionInfo, paramString));
          }
        }
      }
    }
    if (paramAdEmoCfg.jdField_a_of_type_Int == 1) {
      Collections.shuffle(localArrayList);
    }
    return localArrayList;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.ad.StickerRecAdEmotionHandlerListener
 * JD-Core Version:    0.7.0.1
 */