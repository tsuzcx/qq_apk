import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class bbov
{
  public static List<aruc> a(long paramLong1, long paramLong2, aqwe paramaqwe, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap)
  {
    paramConcurrentHashMap = (Set)paramConcurrentHashMap.get(Long.valueOf(paramLong1));
    if (paramConcurrentHashMap != null) {
      return a(a(paramConcurrentHashMap, paramLong2), paramaqwe);
    }
    return null;
  }
  
  public static List<aruc> a(long paramLong, List<DanmuItemBean> paramList, aqwe paramaqwe, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramaqwe == null)) {
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDanmakuUtils", 4, "buildPictureDanmakuList list is null");
    }
    do
    {
      return null;
      paramConcurrentHashMap = a(paramLong, paramList, paramConcurrentHashMap);
    } while ((paramConcurrentHashMap == null) || (paramConcurrentHashMap.isEmpty()));
    paramList = new ArrayList();
    paramConcurrentHashMap = paramConcurrentHashMap.iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      aruc localaruc = paramaqwe.a(new aqwj((DanmuItemBean)paramConcurrentHashMap.next()));
      if (localaruc != null)
      {
        localaruc.a(5000);
        localaruc.e(true);
        paramList.add(localaruc);
      }
    }
    return paramList;
  }
  
  public static List<aruc> a(long paramLong1, List<DanmuItemBean> paramList, aqwe paramaqwe, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap, long paramLong2)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDanmakuUtils", 4, "buildVideoDanmakuList list is null");
      return null;
    }
    return a(a(paramLong1, paramList, paramConcurrentHashMap, paramLong2), paramaqwe);
  }
  
  private static List<DanmuItemBean> a(long paramLong, List<DanmuItemBean> paramList, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap)
  {
    Object localObject = (Set)paramConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      localObject = new ArraySet();
      ((Set)localObject).addAll(paramList);
      paramConcurrentHashMap.put(Long.valueOf(paramLong), localObject);
      return paramList;
    }
    paramConcurrentHashMap.clear();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DanmuItemBean localDanmuItemBean = (DanmuItemBean)paramList.next();
      if (!((Set)localObject).contains(localDanmuItemBean)) {
        localArrayList.add(localDanmuItemBean);
      }
    }
    ((Set)localObject).addAll(localArrayList);
    paramConcurrentHashMap.put(Long.valueOf(paramLong), localObject);
    return localArrayList;
  }
  
  private static List<DanmuItemBean> a(long paramLong1, List<DanmuItemBean> paramList, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap, long paramLong2)
  {
    Set localSet = (Set)paramConcurrentHashMap.get(Long.valueOf(paramLong1));
    Object localObject = new ArraySet();
    ((Set)localObject).addAll(paramList);
    if (localSet == null)
    {
      paramConcurrentHashMap.put(Long.valueOf(paramLong1), localObject);
      return a((Set)localObject, paramLong2);
    }
    paramConcurrentHashMap.clear();
    paramList = new ArraySet();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DanmuItemBean localDanmuItemBean = (DanmuItemBean)((Iterator)localObject).next();
      if (!localSet.contains(localDanmuItemBean)) {
        paramList.add(localDanmuItemBean);
      }
    }
    localSet.addAll(paramList);
    paramConcurrentHashMap.put(Long.valueOf(paramLong1), localSet);
    return a(paramList, paramLong2);
  }
  
  private static List<aruc> a(List<DanmuItemBean> paramList, aqwe paramaqwe)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramaqwe != null))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (DanmuItemBean)paramList.next();
        aqwj localaqwj = new aqwj((DanmuItemBean)localObject);
        aruc localaruc = paramaqwe.a(localaqwj);
        if (localaruc != null)
        {
          localaruc.b(((DanmuItemBean)localObject).c);
          if (!TextUtils.isEmpty(localaqwj.a))
          {
            localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(localaqwj.a))) {
              localaruc.e(true);
            }
          }
          localArrayList.add(localaruc);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private static List<DanmuItemBean> a(Set<DanmuItemBean> paramSet, long paramLong)
  {
    if ((paramSet != null) && (!paramSet.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        DanmuItemBean localDanmuItemBean = (DanmuItemBean)paramSet.next();
        if (localDanmuItemBean.c + 1000L >= paramLong) {
          localArrayList.add(localDanmuItemBean);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public static boolean a()
  {
    return (aqwa.a()) && (bbox.a().a() == 1);
  }
  
  public static boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (!aqwa.a()) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldShowDanmakuBtn, paramsManager.isFromMultiMsg() = ").append(bbox.a().c());
      localStringBuilder.append(" , paramsManager.getmCurType() = ").append(bbox.a().a());
      localStringBuilder.append(" , paramsManager.getSourceEntrance() = ").append(bbox.a().c());
      localStringBuilder.append(" , paramsManager.isReplyMsgFromSameSession() = ").append(bbox.a().h());
      localStringBuilder.append(" , paramsManager.isMixedMsg = ").append(bbox.a().b);
      localStringBuilder.append(" , paramsManager.isReplySrcMsgExist = ").append(bbox.a().c);
      if ((paramRichMediaBrowserInfo != null) && ((paramRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)))
      {
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData;
        localStringBuilder.append(", galleryInfo.mData.isInMixedMsg = ").append(localAIOBrowserBaseData.b).append(" isMsgSeqReady = ").append(localAIOBrowserBaseData.c);
      }
      QLog.d("BrowserDanmakuUtils", 2, localStringBuilder.toString());
    }
    return (!bbox.a().c()) && (bbox.a().a() == 1) && (bbox.a().c() != 4) && (bbox.a().h()) && (bbox.a().c) && ((paramRichMediaBrowserInfo == null) || (!(paramRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) || (!((AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData).b)) && ((paramRichMediaBrowserInfo == null) || (!(paramRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) || (((AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData).c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbov
 * JD-Core Version:    0.7.0.1
 */