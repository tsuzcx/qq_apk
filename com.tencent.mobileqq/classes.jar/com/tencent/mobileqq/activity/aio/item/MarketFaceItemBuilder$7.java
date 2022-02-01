package com.tencent.mobileqq.activity.aio.item;

import android.widget.ImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
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
    Boolean localBoolean = null;
    paramList = paramList.iterator();
    Emoticon localEmoticon;
    boolean bool;
    if (paramList.hasNext())
    {
      localEmoticon = (Emoticon)paramList.next();
      Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramList = (MarketFaceItemBuilder.Holder)localIterator.next();
          if ((paramList.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(paramList.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)))
          {
            paramBoolean = paramList.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if ((paramList.jdField_a_of_type_Boolean) && (paramList.e.hasWindowFocus()))
            {
              bool = true;
              localBoolean = Boolean.valueOf(bool);
              paramList.jdField_a_of_type_Boolean = false;
              paramEmoticonPackage = paramList;
              paramList = paramBoolean;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localBoolean.booleanValue()) {
        if (paramList != null)
        {
          paramBoolean = paramList.senderuin;
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.7.2(this, localEmoticon, paramBoolean, paramEmoticonPackage));
        }
      }
      while ((localEmoticon == null) || (localEmoticon.jobType != 4))
      {
        return;
        bool = false;
        break;
      }
      ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.7.3(this, paramEmoticonPackage, localEmoticon));
      return;
      paramList = null;
      paramEmoticonPackage = localBoolean;
      localBoolean = paramBoolean;
    }
  }
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    Object localObject;
    MarketFaceItemBuilder.Holder localHolder;
    if (paramInt != 0)
    {
      localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localHolder = (MarketFaceItemBuilder.Holder)((Iterator)localObject).next();
        if ((localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "Download magic Emoji fail!");
          }
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.7.1(this, localHolder));
        }
      }
    }
    label118:
    do
    {
      do
      {
        do
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(localHolder);
          return;
          break label118;
          while ((!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a()) || (paramEmoticonPackage == null)) {}
          localObject = ((EmoticonManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramEmoticonPackage.epId);
        } while (localObject == null);
        a(paramEmoticonPackage, Boolean.valueOf(false), (List)localObject);
        localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      } while (!((Iterator)localObject).hasNext());
      localHolder = (MarketFaceItemBuilder.Holder)((Iterator)localObject).next();
    } while ((localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (!paramEmoticonPackage.epId.equals(localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)));
    if (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType == 2) {
      VasUtils.a(this.a.b, null);
    }
    this.a.jdField_a_of_type_JavaUtilList.remove(localHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */