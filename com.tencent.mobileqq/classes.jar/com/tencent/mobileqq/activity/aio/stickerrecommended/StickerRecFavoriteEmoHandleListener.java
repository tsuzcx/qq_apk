package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class StickerRecFavoriteEmoHandleListener
  extends BaseLocalEmoticonHandleListener
{
  private Collection<String> b = null;
  
  public StickerRecFavoriteEmoHandleListener(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface);
  }
  
  public List<? extends IStickerRecEmoticon> a(String paramString, BaseSessionInfo paramBaseSessionInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticon search start.");
    }
    paramBaseSessionInfo = new ArrayList();
    IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)this.a.getRuntimeService(IEmoticonManagerService.class);
    Object localObject1 = (IFavroamingDBManagerService)this.a.getRuntimeService(IFavroamingDBManagerService.class);
    StickerRecManagerImpl localStickerRecManagerImpl = StickerRecManagerImpl.get(this.a);
    localObject1 = ((IFavroamingDBManagerService)localObject1).getEmoticonDataList();
    if (localObject1 != null)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("favorite emoticonDataList.size : ");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.d("StickerRecFavoriteEmoHandleListener", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CustomEmotionData)((Iterator)localObject1).next();
        if (("isUpdate".equals(((CustomEmotionData)localObject2).RomaingType)) || ("needDownload".equals(((CustomEmotionData)localObject2).RomaingType)) || ("overflow".equals(((CustomEmotionData)localObject2).RomaingType)) || ("overflow_downloaded".equals(((CustomEmotionData)localObject2).RomaingType))) {
          if ((!TextUtils.isEmpty(((CustomEmotionData)localObject2).modifyWord)) && (paramString.equals(localStickerRecManagerImpl.preProcessUsrTextUseLocalSearch(((CustomEmotionData)localObject2).modifyWord))))
          {
            paramBaseSessionInfo.add(new StickerRecFavoriteData(this.a, (CustomEmotionData)localObject2));
          }
          else if ((!TextUtils.isEmpty(((CustomEmotionData)localObject2).ocrWord)) && (paramString.equals(localStickerRecManagerImpl.preProcessUsrTextUseLocalSearch(((CustomEmotionData)localObject2).ocrWord))))
          {
            paramBaseSessionInfo.add(new StickerRecFavoriteData(this.a, (CustomEmotionData)localObject2));
          }
          else if (((CustomEmotionData)localObject2).isMarkFace)
          {
            Emoticon localEmoticon = localIEmoticonManagerService.syncFindEmoticonById(((CustomEmotionData)localObject2).emoPath, ((CustomEmotionData)localObject2).eId);
            if ((localEmoticon != null) && (!TextUtils.isEmpty(localEmoticon.name)) && (paramString.equals(localStickerRecManagerImpl.preProcessUsrTextUseLocalSearch(localEmoticon.name)))) {
              paramBaseSessionInfo.add(new StickerRecFavoriteData(this.a, (CustomEmotionData)localObject2));
            }
          }
        }
      }
    }
    if (paramBaseSessionInfo.isEmpty())
    {
      if (QLog.isColorLevel())
      {
        paramBaseSessionInfo = new StringBuilder();
        paramBaseSessionInfo.append("favorite onSearchStickerRecLocalEmoticon matchList is null or empty,keyWord: ");
        paramBaseSessionInfo.append(MessageRecordUtil.a(paramString));
        QLog.d("StickerRecFavoriteEmoHandleListener", 2, paramBaseSessionInfo.toString());
      }
      return null;
    }
    return paramBaseSessionInfo;
  }
  
  public void a()
  {
    StickerRecManagerImpl localStickerRecManagerImpl = StickerRecManagerImpl.get(this.a);
    if (localStickerRecManagerImpl != null) {
      this.b = localStickerRecManagerImpl.loadKeywordForFavEmotion();
    }
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if (this.b == null) {
      a();
    }
    paramBaseQQAppInterface = this.b;
    return (paramBaseQQAppInterface != null) && (paramBaseQQAppInterface.contains(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecFavoriteEmoHandleListener
 * JD-Core Version:    0.7.0.1
 */