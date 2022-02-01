package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.util.SparseIntArray;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class SearchStickerRecEmoticonUtil
{
  private static final SparseIntArray a = new SparseIntArray();
  
  static
  {
    a.put(2, 10);
    a.put(3, 20);
    a.put(4, 30);
  }
  
  public static <T extends IEmoticonSort> List<T> a(AppRuntime paramAppRuntime, List<T> paramList)
  {
    paramAppRuntime = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSearchStickerRecEmotions stickerRecSearches.size:");
        ((StringBuilder)localObject).append(paramList.size());
        QLog.d("SearchStickerRecEmoticonUtil", 2, ((StringBuilder)localObject).toString());
      }
      a(paramList, paramAppRuntime);
      a(paramList);
      if (paramList.size() > 0) {
        paramAppRuntime.add(paramList.remove(0));
      }
      if (paramList.size() > 0) {
        b(paramList, paramAppRuntime);
      }
      if (paramList.size() > 0)
      {
        Collections.sort(paramList, new SearchStickerRecEmoticonUtil.1());
        b(paramList, paramAppRuntime);
      }
      if (QLog.isColorLevel())
      {
        paramList = paramAppRuntime.iterator();
        while (paramList.hasNext())
        {
          localObject = (IEmoticonSort)paramList.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getSearchStickerRecEmotions item.ClickNum:");
          localStringBuilder.append(((IEmoticonSort)localObject).i());
          localStringBuilder.append(",item.ExposeNum: ");
          localStringBuilder.append(((IEmoticonSort)localObject).h());
          QLog.d("SearchStickerRecEmoticonUtil", 2, localStringBuilder.toString());
        }
        paramList = new StringBuilder();
        paramList.append("getSearchStickerRecEmotions stickerRecEmotionList.size:");
        paramList.append(paramAppRuntime.size());
        QLog.d("SearchStickerRecEmoticonUtil", 2, paramList.toString());
      }
    }
    return paramAppRuntime;
  }
  
  public static <T extends IEmoticonSort> void a(List<T> paramList)
  {
    Collections.sort(paramList, new SearchStickerRecEmoticonUtil.2());
  }
  
  public static <T extends IEmoticonSort> void a(List<T> paramList1, List<T> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      IEmoticonSort localIEmoticonSort = (IEmoticonSort)localIterator.next();
      if (localIEmoticonSort.j() == 5)
      {
        paramList2.add(localIEmoticonSort);
        localArrayList.add(localIEmoticonSort);
      }
    }
    paramList1.removeAll(localArrayList);
  }
  
  private static <T extends IEmoticonSort> boolean a(List<T> paramList, T paramT)
  {
    if (paramList != null)
    {
      if (paramT == null) {
        return false;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject2 = (IEmoticonSort)paramList.next();
        if (((IEmoticonSort)localObject2).j() != paramT.j())
        {
          Object localObject3;
          Object localObject1;
          String str;
          if ((((IEmoticonSort)localObject2).j() == 2) && (paramT.j() == 4))
          {
            localObject2 = (StickerRecLocalData)localObject2;
            localObject3 = (StickerRecFavoriteData)paramT;
            localObject1 = ((StickerRecFavoriteData)localObject3).a.emoPath;
            localObject3 = ((StickerRecFavoriteData)localObject3).a.eId;
            str = ((StickerRecLocalData)localObject2).a.epId;
            localObject2 = ((StickerRecLocalData)localObject2).a.eId;
            if ((localObject1 != null) && (((String)localObject1).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject2))) {
              return true;
            }
          }
          else if ((((IEmoticonSort)localObject2).j() == 4) && (paramT.j() == 2))
          {
            localObject1 = (StickerRecLocalData)paramT;
            localObject3 = (StickerRecFavoriteData)localObject2;
            localObject2 = ((StickerRecFavoriteData)localObject3).a.emoPath;
            localObject3 = ((StickerRecFavoriteData)localObject3).a.eId;
            str = ((StickerRecLocalData)localObject1).a.epId;
            localObject1 = ((StickerRecLocalData)localObject1).a.eId;
            if ((localObject2 != null) && (((String)localObject2).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject1))) {
              return true;
            }
          }
          else
          {
            if ((((IEmoticonSort)localObject2).j() == 4) && (paramT.j() == 3))
            {
              localObject1 = (StickerRecFavoriteData)localObject2;
              if ((((StickerRecFavoriteData)localObject1).l() != null) && (((StickerRecFavoriteData)localObject1).l().equals(((StickerRecCameraData)paramT).l()))) {
                return true;
              }
            }
            if ((((IEmoticonSort)localObject2).j() == 3) && (paramT.j() == 4))
            {
              localObject1 = (StickerRecFavoriteData)paramT;
              if ((((StickerRecFavoriteData)localObject1).l() != null) && (((StickerRecFavoriteData)localObject1).l().equals(((StickerRecCameraData)localObject2).l()))) {
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  private static <T extends IEmoticonSort> void b(List<T> paramList1, List<T> paramList2)
  {
    if (paramList2 == null) {
      return;
    }
    if (paramList1 != null)
    {
      if (paramList1.isEmpty()) {
        return;
      }
      for (IEmoticonSort localIEmoticonSort = (IEmoticonSort)paramList1.remove(0); (a(paramList2, localIEmoticonSort)) && (paramList1.size() > 0); localIEmoticonSort = (IEmoticonSort)paramList1.remove(0)) {}
      if (!a(paramList2, localIEmoticonSort)) {
        paramList2.add(localIEmoticonSort);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.SearchStickerRecEmoticonUtil
 * JD-Core Version:    0.7.0.1
 */