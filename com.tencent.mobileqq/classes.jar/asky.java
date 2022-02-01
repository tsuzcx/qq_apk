import android.content.Intent;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.EmotionGallery;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BasePicDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class asky
  extends askp
  implements asks
{
  private long jdField_a_of_type_Long;
  public asko a;
  private asks jdField_a_of_type_Asks;
  public SessionInfo a;
  public MessageRecord a;
  private EmotionGallery jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery;
  private HashMap<MessageForPic, askr> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public asky(Intent paramIntent, askx paramaskx, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_Asko = new asko(paramSessionInfo.curFriendUin, paramSessionInfo.curType);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramaskx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("key_multi_forward_seq", 0L);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("key_is_multi_forward_msg", false);
  }
  
  private BasePicDownloadProcessor a(MessageForPic paramMessageForPic)
  {
    boolean bool = true;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      azjx localazjx = new azjx();
      localazjx.e = paramMessageForPic.fileSizeFlag;
      if (localazjx.e == 1) {}
      for (;;)
      {
        int i = URLDrawableHelper.getFileSizeType("chatimg", bool);
        paramMessageForPic = localQQAppInterface.getTransFileController().findProcessor(TransFileController.makeReceiveKey(paramMessageForPic.md5, paramMessageForPic.uuid, i));
        if ((paramMessageForPic == null) || (!(paramMessageForPic instanceof BasePicDownloadProcessor))) {
          break;
        }
        return (BasePicDownloadProcessor)paramMessageForPic;
        bool = false;
      }
    }
    return null;
  }
  
  public int a()
  {
    return 1;
  }
  
  protected QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public List<askm> a(boolean paramBoolean)
  {
    Object localObject2 = new ArrayList();
    long l;
    label34:
    List localList;
    Object localObject1;
    Object localObject3;
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isMultiMsg))
    {
      l = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq;
      localList = this.jdField_a_of_type_Asko.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramBoolean, l);
      if (localList == null) {
        break label354;
      }
      localObject1 = localList.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject1).next();
          if ((localObject3 != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageRecord)localObject3).time == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
            if ((((MessageRecord)localObject3).msgtype == 1) || (((MessageRecord)localObject3).msgtype == 3000))
            {
              if (((MessageRecord)localObject3).shmsgseq != this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq) {
                continue;
              }
              bool = true;
            }
          }
        }
      }
    }
    for (;;)
    {
      label161:
      if (localList != null) {
        ((List)localObject2).addAll(0, localList);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("getEmotionDataIncremental tempList size:");
        if (localList == null)
        {
          localObject1 = "null";
          label206:
          QLog.d("MsgEmotionFragmentDataSource", 2, localObject1 + " contains:" + bool);
        }
      }
      else
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (localList != null) && (!localList.isEmpty())) {
          break label344;
        }
        QLog.d("MsgEmotionFragmentDataSource", 1, "mCurMsgRecord or tempList is null or empty");
      }
      for (;;)
      {
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add(new askx((MessageRecord)((Iterator)localObject2).next()));
        }
        l = -1L;
        break label34;
        bool = true;
        break label161;
        localObject1 = Integer.valueOf(localList.size());
        break label206;
        label344:
        if (!bool) {
          break;
        }
      }
      return localObject1;
      label354:
      bool = false;
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        BasePicDownloadProcessor localBasePicDownloadProcessor = a((MessageForPic)localEntry.getKey());
        if (localBasePicDownloadProcessor != null) {
          localBasePicDownloadProcessor.removeDownCallBack((azjj)localEntry.getValue());
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic)
  {
    askm localaskm = (askm)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    if (!(localaskm instanceof askx)) {}
    while (((askx)localaskm).jdField_a_of_type_ComTencentMobileqqDataMessageRecord != paramMessageForPic) {
      return;
    }
    this.jdField_a_of_type_Asks.a(paramInt, paramMessageForPic);
  }
  
  public void a(EmotionGallery paramEmotionGallery, Handler paramHandler, askm paramaskm, asks paramasks)
  {
    if (!(paramaskm instanceof askx)) {}
    do
    {
      return;
      paramaskm = (askx)paramaskm;
    } while (!(paramaskm.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic));
    this.jdField_a_of_type_Asks = paramasks;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery = paramEmotionGallery;
    paramEmotionGallery = (MessageForPic)paramaskm.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (QLog.isColorLevel()) {
      QLog.d("MsgEmotionFragmentDataSource", 2, "triggerDownloadPic, mr uniseq: " + paramEmotionGallery.uniseq);
    }
    paramHandler = new askr(paramEmotionGallery, paramHandler, this);
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramEmotionGallery)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramEmotionGallery, paramHandler);
    }
    paramaskm = a(paramEmotionGallery);
    if (paramaskm != null) {
      paramaskm.addDownCallback(paramHandler);
    }
    for (;;)
    {
      AIOImageProviderService.a(a(), paramEmotionGallery);
      return;
      paramaskm = azjv.a(6, 1536, 1);
      paramaskm.a(paramEmotionGallery, paramEmotionGallery.getPicDownloadInfo());
      paramaskm.a(paramHandler);
      paramHandler = a();
      if (paramHandler != null) {
        azjv.a(paramaskm, paramHandler);
      }
    }
  }
  
  public void a(EmotionGallery paramEmotionGallery, askn paramaskn, long paramLong, askq paramaskq)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramLong == this.jdField_a_of_type_Long))
    {
      paramaskq.c();
      return;
    }
    paramaskn = paramaskn.a();
    Object localObject;
    if (paramaskn != null)
    {
      paramaskn = paramaskn.iterator();
      do
      {
        if (!paramaskn.hasNext()) {
          break;
        }
        localObject = (askm)paramaskn.next();
      } while ((!(localObject instanceof askx)) || (((askx)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq != paramLong));
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MsgEmotionFragmentDataSource", 2, "onRevokeMsg notContain seq:" + paramLong);
        return;
      }
      paramEmotionGallery = (askm)paramEmotionGallery.getSelectedItem();
      if (paramEmotionGallery == null) {
        break;
      }
      paramaskn = ((askx)paramEmotionGallery).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onRevokeMsg seq:").append(paramLong).append(", selectItem seq:");
        if (paramaskn == null) {
          break label223;
        }
      }
      label223:
      for (long l = paramaskn.uniseq;; l = 0L)
      {
        QLog.d("MsgEmotionFragmentDataSource", 2, l);
        if (paramaskn == null) {
          break;
        }
        if (paramLong != paramaskn.uniseq) {
          break label229;
        }
        paramaskq.c();
        return;
      }
      label229:
      a(paramaskq, paramEmotionGallery, true);
      return;
    }
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    Object localObject = (askr)this.jdField_a_of_type_JavaUtilHashMap.remove(paramMessageForPic);
    BasePicDownloadProcessor localBasePicDownloadProcessor = a(paramMessageForPic);
    if (localBasePicDownloadProcessor != null) {
      localBasePicDownloadProcessor.removeDownCallBack((azjj)localObject);
    }
    localObject = (askm)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    if (!(localObject instanceof askx)) {}
    do
    {
      return;
      localObject = ((askx)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localObject == null) || (paramMessageForPic == null) || (localObject == paramMessageForPic)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MsgEmotionFragmentDataSource", 2, "onUIResult, mr not equal, picMr:" + paramMessageForPic.uniseq + " mr:" + ((MessageRecord)localObject).uniseq);
    return;
    this.jdField_a_of_type_Asks.a(paramBoolean, paramMessageForPic);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(askm paramaskm)
  {
    if (!(paramaskm instanceof askx)) {
      return true;
    }
    paramaskm = ((askx)paramaskm).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if ((paramaskm instanceof MessageForPic))
    {
      paramaskm = (MessageForPic)paramaskm;
      File localFile = AbsDownloader.getFile(URLDrawableHelper.getURL(paramaskm, 1).toString());
      if (localFile == null) {
        return false;
      }
      if ((paramaskm.fileSizeFlag != 1) && (paramaskm.mShowLength > 0))
      {
        long l1 = paramaskm.size;
        if (!paramaskm.isMixed)
        {
          long l2 = localFile.length();
          if (l2 < l1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("MsgEmotionFragmentDataSource", 2, "checkMsgPicReady, fileLen:" + l2 + " fileLenBySender:" + l1);
            }
            return false;
          }
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asky
 * JD-Core Version:    0.7.0.1
 */