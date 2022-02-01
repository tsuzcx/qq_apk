package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class StickerRecLocalEmoticonHandleListener
  extends BaseLocalEmoticonHandleListener
{
  public StickerRecLocalEmoticonHandleListener(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface);
  }
  
  private List<StickerRecLocalData> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecLocalEmoticonHandleListener", 2, "local emoticon search start.");
    }
    Object localObject2 = (IEmoticonManagerService)this.a.getRuntimeService(IEmoticonManagerService.class);
    List localList = ((IEmoticonManagerService)localObject2).syncGetEmoticonsByKeyword(paramString, true);
    Object localObject1;
    if ((localList != null) && (!localList.isEmpty()))
    {
      localObject1 = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        Emoticon localEmoticon = (Emoticon)localList.get(i);
        EmoticonPackage localEmoticonPackage = ((IEmoticonManagerService)localObject2).syncFindEmoticonPackageById(localEmoticon.epId);
        if (localEmoticonPackage == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons emoticonPackage is null.");
          }
        }
        else if ((((IEmoticonManagerService)localObject2).getTabCache() != null) && (((IEmoticonManagerService)localObject2).getTabCache().contains(localEmoticon.epId)) && (localEmoticonPackage.status == 2)) {
          ((List)localObject1).add(new StickerRecLocalData(localEmoticon));
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("findLocalMatchEmoticons stickerRecEmotionList.size:");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        ((StringBuilder)localObject2).append(",keyWord: ");
        ((StringBuilder)localObject2).append(MessageRecordUtil.a(paramString));
        QLog.d("StickerRecLocalEmoticonHandleListener", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("findLocalMatchEmoticons arrEmoticon is null or empty,keyWord: ");
      ((StringBuilder)localObject1).append(MessageRecordUtil.a(paramString));
      QLog.d("StickerRecLocalEmoticonHandleListener", 2, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  public List<StickerRecLocalData> a(String paramString, BaseSessionInfo paramBaseSessionInfo)
  {
    return a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecLocalEmoticonHandleListener
 * JD-Core Version:    0.7.0.1
 */