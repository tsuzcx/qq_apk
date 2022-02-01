package com.tencent.mobileqq.activity.aio.item;

import android.widget.ImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class MarketFaceItemBuilder$7
  extends EmoticonPackageDownloadListener
{
  MarketFaceItemBuilder$7(MarketFaceItemBuilder paramMarketFaceItemBuilder) {}
  
  private void a(EmoticonPackage paramEmoticonPackage, Boolean paramBoolean, List<Emoticon> paramList)
  {
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      Emoticon localEmoticon = (Emoticon)paramList.next();
      Iterator localIterator = this.a.B.iterator();
      boolean bool;
      do
      {
        bool = localIterator.hasNext();
        localBoolean = null;
        if (!bool) {
          break;
        }
        paramList = (MarketFaceItemBuilder.Holder)localIterator.next();
      } while ((paramList.a == null) || (!paramEmoticonPackage.epId.equals(paramList.a.getEmoticon().epId)));
      paramBoolean = paramList.q;
      if ((paramList.x) && (paramList.s.hasWindowFocus())) {
        bool = true;
      } else {
        bool = false;
      }
      Boolean localBoolean = Boolean.valueOf(bool);
      paramList.x = false;
      paramEmoticonPackage = paramList;
      paramList = localBoolean;
      break label158;
      paramEmoticonPackage = null;
      paramList = paramBoolean;
      paramBoolean = paramEmoticonPackage;
      paramEmoticonPackage = localBoolean;
      label158:
      if (paramList.booleanValue())
      {
        if (paramBoolean != null)
        {
          paramBoolean = paramBoolean.senderuin;
          ((BaseActivity)this.a.A).runOnUiThread(new MarketFaceItemBuilder.7.2(this, localEmoticon, paramBoolean, paramEmoticonPackage));
        }
      }
      else if ((localEmoticon != null) && (localEmoticon.jobType == 4)) {
        ((BaseActivity)this.a.A).runOnUiThread(new MarketFaceItemBuilder.7.3(this, paramEmoticonPackage, localEmoticon));
      }
    }
  }
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    Object localObject;
    MarketFaceItemBuilder.Holder localHolder;
    if (paramInt != 0)
    {
      localObject = this.a.B.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localHolder = (MarketFaceItemBuilder.Holder)((Iterator)localObject).next();
      } while ((localHolder.a == null) || (!paramEmoticonPackage.epId.equals(localHolder.a.getEmoticon().epId)));
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "Download magic Emoji fail!");
      }
      ((BaseActivity)this.a.A).runOnUiThread(new MarketFaceItemBuilder.7.1(this, localHolder));
      this.a.B.remove(localHolder);
      return;
    }
    if (this.a.d.getMessageFacade().n())
    {
      if (paramEmoticonPackage == null) {
        return;
      }
      localObject = ((IEmoticonManagerService)this.a.d.getRuntimeService(IEmoticonManagerService.class)).syncGetSubEmoticonsByPackageId(paramEmoticonPackage.epId);
      if (localObject == null) {
        return;
      }
      a(paramEmoticonPackage, Boolean.valueOf(false), (List)localObject);
      localObject = this.a.B.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localHolder = (MarketFaceItemBuilder.Holder)((Iterator)localObject).next();
        if ((localHolder.a != null) && (paramEmoticonPackage.epId.equals(localHolder.a.getEmoticon().epId)))
        {
          if (localHolder.a.getEmoticon().jobType == 2) {
            VasUtils.a(this.a.A, null);
          }
          this.a.B.remove(localHolder);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */