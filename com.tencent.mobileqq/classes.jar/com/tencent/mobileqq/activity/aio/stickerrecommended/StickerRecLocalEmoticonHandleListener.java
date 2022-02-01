package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class StickerRecLocalEmoticonHandleListener
  extends BaseLocalEmoticonHandleListener
{
  public StickerRecLocalEmoticonHandleListener(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private List<StickerRecLocalData> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecLocalEmoticonHandleListener", 2, "local emoticon search start.");
    }
    EmoticonManager localEmoticonManager = (EmoticonManager)this.a.getManager(QQManagerFactory.EMOTICON_MANAGER);
    List localList = localEmoticonManager.b(paramString, true);
    if ((localList == null) || (localList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons arrEmoticon is null or empty,keyWord: " + MessageRecordUtil.a(paramString));
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      Object localObject = (Emoticon)localList.get(i);
      EmoticonPackage localEmoticonPackage = localEmoticonManager.a(((Emoticon)localObject).epId);
      if (localEmoticonPackage == null) {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons emoticonPackage is null.");
        }
      }
      label226:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if ((localEmoticonManager.a == null) || (!localEmoticonManager.a.contains(((Emoticon)localObject).epId)) || (localEmoticonPackage.status != 2)) {
            break label226;
          }
          localArrayList.add(new StickerRecLocalData((Emoticon)localObject));
        }
      } while (!QLog.isColorLevel());
      localObject = new StringBuilder().append("findLocalMatchEmoticons emoticonPackage not match, status: ").append(localEmoticonPackage.status).append(" tabCache.size: ");
      if (localEmoticonManager.a != null) {}
      for (int j = localEmoticonManager.a.size();; j = -1)
      {
        QLog.d("StickerRecLocalEmoticonHandleListener", 2, j);
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons stickerRecEmotionList.size:" + localArrayList.size() + ",keyWord: " + MessageRecordUtil.a(paramString));
    }
    return localArrayList;
  }
  
  public List<StickerRecLocalData> a(String paramString, SessionInfo paramSessionInfo)
  {
    return a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecLocalEmoticonHandleListener
 * JD-Core Version:    0.7.0.1
 */