import android.content.Intent;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.EmotionGallery;
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

public class annp
  extends anng
  implements annj
{
  private long jdField_a_of_type_Long;
  public annf a;
  private annj jdField_a_of_type_Annj;
  public SessionInfo a;
  public MessageRecord a;
  private EmotionGallery jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery;
  private HashMap<MessageForPic, anni> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public annp(Intent paramIntent, anno paramanno, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_Annf = new annf(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramanno.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("key_multi_forward_seq", 0L);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("key_is_multi_forward_msg", false);
  }
  
  private axop a(MessageForPic paramMessageForPic)
  {
    boolean bool = true;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      atpn localatpn = new atpn();
      localatpn.e = paramMessageForPic.fileSizeFlag;
      if (localatpn.e == 1) {}
      for (;;)
      {
        int i = axwd.a("chatimg", bool);
        paramMessageForPic = localQQAppInterface.a().a(axvo.a(paramMessageForPic.md5, paramMessageForPic.uuid, i));
        if ((paramMessageForPic == null) || (!(paramMessageForPic instanceof axop))) {
          break;
        }
        return (axop)paramMessageForPic;
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
  
  public List<annd> a(boolean paramBoolean)
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
      localList = this.jdField_a_of_type_Annf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBoolean, l);
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
          ((List)localObject1).add(new anno((MessageRecord)((Iterator)localObject2).next()));
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
        axop localaxop = a((MessageForPic)localEntry.getKey());
        if (localaxop != null) {
          localaxop.a((atpa)localEntry.getValue());
        }
      }
    }
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic)
  {
    annd localannd = (annd)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    if (!(localannd instanceof anno)) {}
    while (((anno)localannd).jdField_a_of_type_ComTencentMobileqqDataMessageRecord != paramMessageForPic) {
      return;
    }
    this.jdField_a_of_type_Annj.a(paramInt, paramMessageForPic);
  }
  
  public void a(EmotionGallery paramEmotionGallery, Handler paramHandler, annd paramannd, annj paramannj)
  {
    if (!(paramannd instanceof anno)) {}
    do
    {
      return;
      paramannd = (anno)paramannd;
    } while (!(paramannd.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic));
    this.jdField_a_of_type_Annj = paramannj;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery = paramEmotionGallery;
    paramEmotionGallery = (MessageForPic)paramannd.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (QLog.isColorLevel()) {
      QLog.d("MsgEmotionFragmentDataSource", 2, "triggerDownloadPic, mr uniseq: " + paramEmotionGallery.uniseq);
    }
    paramHandler = new anni(paramEmotionGallery, paramHandler, this);
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramEmotionGallery)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramEmotionGallery, paramHandler);
    }
    paramannd = a(paramEmotionGallery);
    if (paramannd != null) {
      paramannd.b(paramHandler);
    }
    for (;;)
    {
      AIOImageProviderService.a(a(), paramEmotionGallery);
      return;
      paramannd = atpl.a(6, 1536, 1);
      paramannd.a(paramEmotionGallery, paramEmotionGallery.getPicDownloadInfo());
      paramannd.a(paramHandler);
      paramHandler = a();
      if (paramHandler != null) {
        atpl.a(paramannd, paramHandler);
      }
    }
  }
  
  public void a(EmotionGallery paramEmotionGallery, anne paramanne, long paramLong, annh paramannh)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramLong == this.jdField_a_of_type_Long))
    {
      paramannh.c();
      return;
    }
    paramanne = paramanne.a();
    Object localObject;
    if (paramanne != null)
    {
      paramanne = paramanne.iterator();
      do
      {
        if (!paramanne.hasNext()) {
          break;
        }
        localObject = (annd)paramanne.next();
      } while ((!(localObject instanceof anno)) || (((anno)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq != paramLong));
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
      paramEmotionGallery = (annd)paramEmotionGallery.getSelectedItem();
      paramanne = ((anno)paramEmotionGallery).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onRevokeMsg seq:").append(paramLong).append(", selectItem seq:");
        if (paramanne == null) {
          break label219;
        }
      }
      label219:
      for (long l = paramanne.uniseq;; l = 0L)
      {
        QLog.d("MsgEmotionFragmentDataSource", 2, l);
        if (paramanne == null) {
          break;
        }
        if (paramLong != paramanne.uniseq) {
          break label225;
        }
        paramannh.c();
        return;
      }
      label225:
      a(paramannh, paramEmotionGallery, true);
      return;
    }
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    Object localObject = (anni)this.jdField_a_of_type_JavaUtilHashMap.remove(paramMessageForPic);
    axop localaxop = a(paramMessageForPic);
    if (localaxop != null) {
      localaxop.a((atpa)localObject);
    }
    localObject = (annd)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    if (!(localObject instanceof anno)) {}
    do
    {
      return;
      localObject = ((anno)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localObject == null) || (paramMessageForPic == null) || (localObject == paramMessageForPic)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MsgEmotionFragmentDataSource", 2, "onUIResult, mr not equal, picMr:" + paramMessageForPic.uniseq + " mr:" + ((MessageRecord)localObject).uniseq);
    return;
    this.jdField_a_of_type_Annj.a(paramBoolean, paramMessageForPic);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(annd paramannd)
  {
    if (!(paramannd instanceof anno)) {
      return true;
    }
    paramannd = ((anno)paramannd).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if ((paramannd instanceof MessageForPic))
    {
      paramannd = (MessageForPic)paramannd;
      File localFile = axoa.a(axwd.a(paramannd, 1).toString());
      if (localFile == null) {
        return false;
      }
      if ((paramannd.fileSizeFlag != 1) && (paramannd.mShowLength > 0))
      {
        long l1 = paramannd.size;
        if (!paramannd.isMixed)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     annp
 * JD-Core Version:    0.7.0.1
 */