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

public class aoef
  extends aodw
  implements aodz
{
  private long jdField_a_of_type_Long;
  public aodv a;
  private aodz jdField_a_of_type_Aodz;
  public SessionInfo a;
  public MessageRecord a;
  private EmotionGallery jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery;
  private HashMap<MessageForPic, aody> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public aoef(Intent paramIntent, aoee paramaoee, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_Aodv = new aodv(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramaoee.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("key_multi_forward_seq", 0L);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("key_is_multi_forward_msg", false);
  }
  
  private ayox a(MessageForPic paramMessageForPic)
  {
    boolean bool = true;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      aunn localaunn = new aunn();
      localaunn.e = paramMessageForPic.fileSizeFlag;
      if (localaunn.e == 1) {}
      for (;;)
      {
        int i = aywm.a("chatimg", bool);
        paramMessageForPic = localQQAppInterface.a().a(ayvx.a(paramMessageForPic.md5, paramMessageForPic.uuid, i));
        if ((paramMessageForPic == null) || (!(paramMessageForPic instanceof ayox))) {
          break;
        }
        return (ayox)paramMessageForPic;
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
  
  public List<aodt> a(boolean paramBoolean)
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
      localList = this.jdField_a_of_type_Aodv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBoolean, l);
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
          ((List)localObject1).add(new aoee((MessageRecord)((Iterator)localObject2).next()));
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
        ayox localayox = a((MessageForPic)localEntry.getKey());
        if (localayox != null) {
          localayox.a((auna)localEntry.getValue());
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic)
  {
    aodt localaodt = (aodt)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    if (!(localaodt instanceof aoee)) {}
    while (((aoee)localaodt).jdField_a_of_type_ComTencentMobileqqDataMessageRecord != paramMessageForPic) {
      return;
    }
    this.jdField_a_of_type_Aodz.a(paramInt, paramMessageForPic);
  }
  
  public void a(EmotionGallery paramEmotionGallery, Handler paramHandler, aodt paramaodt, aodz paramaodz)
  {
    if (!(paramaodt instanceof aoee)) {}
    do
    {
      return;
      paramaodt = (aoee)paramaodt;
    } while (!(paramaodt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic));
    this.jdField_a_of_type_Aodz = paramaodz;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery = paramEmotionGallery;
    paramEmotionGallery = (MessageForPic)paramaodt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (QLog.isColorLevel()) {
      QLog.d("MsgEmotionFragmentDataSource", 2, "triggerDownloadPic, mr uniseq: " + paramEmotionGallery.uniseq);
    }
    paramHandler = new aody(paramEmotionGallery, paramHandler, this);
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramEmotionGallery)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramEmotionGallery, paramHandler);
    }
    paramaodt = a(paramEmotionGallery);
    if (paramaodt != null) {
      paramaodt.b(paramHandler);
    }
    for (;;)
    {
      AIOImageProviderService.a(a(), paramEmotionGallery);
      return;
      paramaodt = aunl.a(6, 1536, 1);
      paramaodt.a(paramEmotionGallery, paramEmotionGallery.getPicDownloadInfo());
      paramaodt.a(paramHandler);
      paramHandler = a();
      if (paramHandler != null) {
        aunl.a(paramaodt, paramHandler);
      }
    }
  }
  
  public void a(EmotionGallery paramEmotionGallery, aodu paramaodu, long paramLong, aodx paramaodx)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramLong == this.jdField_a_of_type_Long))
    {
      paramaodx.c();
      return;
    }
    paramaodu = paramaodu.a();
    Object localObject;
    if (paramaodu != null)
    {
      paramaodu = paramaodu.iterator();
      do
      {
        if (!paramaodu.hasNext()) {
          break;
        }
        localObject = (aodt)paramaodu.next();
      } while ((!(localObject instanceof aoee)) || (((aoee)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq != paramLong));
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
      paramEmotionGallery = (aodt)paramEmotionGallery.getSelectedItem();
      paramaodu = ((aoee)paramEmotionGallery).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onRevokeMsg seq:").append(paramLong).append(", selectItem seq:");
        if (paramaodu == null) {
          break label219;
        }
      }
      label219:
      for (long l = paramaodu.uniseq;; l = 0L)
      {
        QLog.d("MsgEmotionFragmentDataSource", 2, l);
        if (paramaodu == null) {
          break;
        }
        if (paramLong != paramaodu.uniseq) {
          break label225;
        }
        paramaodx.c();
        return;
      }
      label225:
      a(paramaodx, paramEmotionGallery, true);
      return;
    }
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    Object localObject = (aody)this.jdField_a_of_type_JavaUtilHashMap.remove(paramMessageForPic);
    ayox localayox = a(paramMessageForPic);
    if (localayox != null) {
      localayox.a((auna)localObject);
    }
    localObject = (aodt)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    if (!(localObject instanceof aoee)) {}
    do
    {
      return;
      localObject = ((aoee)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localObject == null) || (paramMessageForPic == null) || (localObject == paramMessageForPic)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MsgEmotionFragmentDataSource", 2, "onUIResult, mr not equal, picMr:" + paramMessageForPic.uniseq + " mr:" + ((MessageRecord)localObject).uniseq);
    return;
    this.jdField_a_of_type_Aodz.a(paramBoolean, paramMessageForPic);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(aodt paramaodt)
  {
    if (!(paramaodt instanceof aoee)) {
      return true;
    }
    paramaodt = ((aoee)paramaodt).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if ((paramaodt instanceof MessageForPic))
    {
      paramaodt = (MessageForPic)paramaodt;
      File localFile = ayoi.a(aywm.a(paramaodt, 1).toString());
      if (localFile == null) {
        return false;
      }
      if ((paramaodt.fileSizeFlag != 1) && (paramaodt.mShowLength > 0))
      {
        long l1 = paramaodt.size;
        if (!paramaodt.isMixed)
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
 * Qualified Name:     aoef
 * JD-Core Version:    0.7.0.1
 */