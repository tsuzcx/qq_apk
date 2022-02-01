package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class StickerRecCameraEmoticonHandleListener
  extends BaseLocalEmoticonHandleListener
{
  private Collection<String> b = null;
  
  public StickerRecCameraEmoticonHandleListener(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface);
  }
  
  private List<StickerRecCameraData> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecCameraEmoticonHandleListener", 2, "camera emoticon search start.");
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = (ICameraEmotionRoamingDBManagerService)this.a.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
    StickerRecManagerImpl localStickerRecManagerImpl = StickerRecManagerImpl.get(this.a);
    localObject2 = ((ICameraEmotionRoamingDBManagerService)localObject2).getEmoticonDataList();
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject2).next();
        if (("normal".equals(localCameraEmotionData.RomaingType)) && (paramString.equals(localStickerRecManagerImpl.preProcessUsrTextUseLocalSearch(localCameraEmotionData.strContext)))) {
          ((List)localObject1).add(new StickerRecCameraData(this.a, localCameraEmotionData));
        }
      }
    }
    if (((List)localObject1).isEmpty())
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("findMatchCameraEmoticons matchList is null or empty,keyWord: ");
        ((StringBuilder)localObject1).append(MessageRecordUtil.a(paramString));
        QLog.d("StickerRecCameraEmoticonHandleListener", 2, ((StringBuilder)localObject1).toString());
      }
      return null;
    }
    return localObject1;
  }
  
  public List<StickerRecCameraData> a(String paramString, BaseSessionInfo paramBaseSessionInfo)
  {
    return a(paramString);
  }
  
  public void a()
  {
    StickerRecManagerImpl localStickerRecManagerImpl = StickerRecManagerImpl.get(this.a);
    if (localStickerRecManagerImpl != null) {
      this.b = localStickerRecManagerImpl.loadKeywordForCameraEmotion();
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCameraEmoticonHandleListener
 * JD-Core Version:    0.7.0.1
 */