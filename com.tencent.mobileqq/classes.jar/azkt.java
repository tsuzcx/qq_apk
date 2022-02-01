import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class azkt
  extends azjn
{
  private static azkt jdField_a_of_type_Azkt;
  public int a;
  public long a;
  public String a;
  private ArrayList<azke> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<azke> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 90;
  private long jdField_c_of_type_Long = 209715200L;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 70;
  private long jdField_d_of_type_Long = 157286400L;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 50;
  private long jdField_e_of_type_Long = 73400320L;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long = 52428800L;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  private boolean i;
  
  public azkt(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_g_of_type_Int = paramInt2;
    long l1 = azkc.a("presend_lastDayTime", 0L);
    long l2 = System.currentTimeMillis();
    azjq.a("PresendPicMgrService", "[@]PresendPicMgrService", "currentTime = " + l2 + ", lastDayTime = " + l1 + ", curFriendUin = " + paramString1 + ",troopUin = " + paramString2 + ",myUin = " + paramString3);
    e();
    if (l2 - l1 > 86400000L)
    {
      azjq.a("PresendPicMgrService", "PresendPicMgrService", "more than one day, clear wastesize");
      aklj.a(azkc.a("presend_FlowWaste", 0L));
      azkc.a("presend_lastDayTime", l2);
      azkc.a("presend_FlowWaste", 0L);
    }
    this.jdField_b_of_type_Long = azkc.a("presend_FlowWaste", 0L);
    jdField_a_of_type_Azkt = this;
  }
  
  private azke a(ArrayList<azke> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      azke localazke = (azke)paramArrayList.next();
      if (localazke.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localazke;
      }
    }
    return null;
  }
  
  private azkn a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new azko();
    azjq.a("PresendPicMgrService", "[@]buildPicUploadInfo", "curFriendUin = " + this.jdField_b_of_type_JavaLangString);
    ((azko)localObject).d(this.jdField_b_of_type_JavaLangString);
    ((azko)localObject).a(paramString);
    ((azko)localObject).e(this.jdField_f_of_type_Int);
    ((azko)localObject).e(this.jdField_c_of_type_JavaLangString);
    ((azko)localObject).d(paramInt1);
    ((azko)localObject).f(0);
    ((azko)localObject).k(paramInt2);
    ((azko)localObject).l(this.jdField_g_of_type_Int);
    localObject = ((azko)localObject).a();
    if (paramInt2 == 10)
    {
      if (((azkn)localObject).jdField_a_of_type_Azkm == null) {
        ((azkn)localObject).jdField_a_of_type_Azkm = new azkm();
      }
      ((azkn)localObject).jdField_a_of_type_Azkm.jdField_a_of_type_Int = 9;
    }
    ((azkn)localObject).jdField_c_of_type_Boolean = true;
    if (blvp.a(paramString)) {
      bhfd.a();
    }
    try
    {
      ((azkn)localObject).jdField_a_of_type_JavaUtilArrayList = blvp.a(paramString);
      if ((((azkn)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (QLog.isColorLevel())) {
        QLog.d("peak_pgjpeg", 2, "PresendPicMgrService.buildPicUploadInfo:" + ((azkn)localObject).jdField_a_of_type_JavaUtilArrayList.toString());
      }
      bhfd.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramString + ")");
      if (paramBoolean)
      {
        ((azkn)localObject).jdField_g_of_type_Int = 1;
        azjq.a(localObject, "fixProtocolType", "sendReq.upInfo.protocolType");
        return localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramString + "'s size is " + FileUtils.getFileSizes(paramString));
        }
      }
      ((azkn)localObject).jdField_g_of_type_Int = ((azkn)localObject).a();
    }
    return localObject;
  }
  
  public static azkt a()
  {
    return jdField_a_of_type_Azkt;
  }
  
  private void a(long paramLong, int paramInt)
  {
    this.jdField_b_of_type_Long += paramLong;
    azkc.a("presend_FlowWaste", this.jdField_b_of_type_Long);
    aklj.a(paramLong, paramInt);
    azjq.a("PresendPicMgrService", "calcWasteFlow ", "PresendStatus:  wastesize = " + paramLong + ",mWastedUploadFlow = " + this.jdField_b_of_type_Long + ",cancelType = " + paramInt);
  }
  
  private void a(azke paramazke, int paramInt)
  {
    synchronized (paramazke.jdField_a_of_type_Azkn)
    {
      paramazke.jdField_a_of_type_Azkn.jdField_d_of_type_Boolean = true;
      if (paramazke.jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangObject == null)
      {
        azjq.b("PresendPicMgrService", "doCancel", " req.upInfo.picExtraObject == null!");
        return;
      }
    }
    ??? = (MessageRecord)paramazke.jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangObject;
    for (;;)
    {
      BaseUploadProcessor localBaseUploadProcessor;
      long l1;
      try
      {
        localBaseUploadProcessor = (BaseUploadProcessor)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString)).getTransFileController().findProcessor(((MessageRecord)???).frienduin, ((MessageRecord)???).uniseq);
        if (localBaseUploadProcessor != null) {
          break label243;
        }
        azjq.a("PresendPicMgrService", "doCancel", " processor == null!");
        l1 = ((MessageForPic)???).mPresendTransferedSize;
        long l2 = FileUtils.getFileSizes(((MessageForPic)???).path);
        azjq.a("PresendPicMgrService", "doCancel", "picSize = " + l2);
        a(l1, paramInt);
        azjq.a("PresendPicMgrService", "doCancel ", "PresendStatus: Path:" + paramazke.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString + ",uuid:" + paramazke.jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
        return;
      }
      catch (AccountNotMatchException paramazke) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PresendPicMgrService", 2, "no appRuntime");
      return;
      label243:
      int j = b();
      if (localBaseUploadProcessor.getRealProgress() < j)
      {
        azjq.a("PresendPicMgrService", "doCancel", " processor upload less than cancelPercent:" + j + ", do cancel! ");
        localBaseUploadProcessor.cancel();
        l1 = localBaseUploadProcessor.getTransferedSize();
      }
      else
      {
        azjq.a("PresendPicMgrService", "doCancel", " processor upload more than cancelPercent:" + j + ", do not cancel!");
        l1 = localBaseUploadProcessor.getFileSize();
      }
    }
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    azjq.a("PresendPicMgrService", "reuploadPhoto", " ");
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString);
      localQQAppInterface.getMessageFacade().removeMsgByUniseq(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        localQQAppInterface.getTransFileController().removeProcessor(localQQAppInterface.getTransFileController().makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      azko localazko = new azko();
      localazko.a(paramMessageForPic.path);
      localazko.d(5);
      localazko.d(paramMessageForPic.frienduin);
      localazko.b(paramMessageForPic.uniseq);
      if (paramMessageForPic.fileSizeFlag == 1) {
        localazko.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_RAW_PHOTO);
      }
      for (;;)
      {
        localazko.e(paramMessageForPic.senderuin);
        localazko.c(paramMessageForPic.selfuin);
        localazko.e(paramMessageForPic.istroop);
        localazko.jdField_i_of_type_Int = paramMessageForPic.extLong;
        localazko.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
        azkp localazkp = new azkp();
        localazkp.jdField_a_of_type_Long = paramMessageForPic.msgseq;
        localazkp.jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
        localazkp.jdField_a_of_type_Long = paramMessageForPic.msgseq;
        localazko.a(localazkp);
        paramMessageForPic = azjv.a(4, 5);
        paramMessageForPic.a(localazko.a());
        azjv.a(paramMessageForPic, localQQAppInterface);
        return;
        localazko.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
      }
      return;
    }
    catch (AccountNotMatchException paramMessageForPic)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    bbob localbbob = (bbob)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER);
    localbbob.a(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
    localbbob.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  private int b()
  {
    int j = 0;
    int k = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    switch (k)
    {
    }
    for (;;)
    {
      azjq.a("PresendPicMgrService", "getCancelPercent", " NetType = " + k + ", cancelpercent = " + j);
      return j;
      j = this.jdField_b_of_type_Int;
      continue;
      j = this.jdField_c_of_type_Int;
      continue;
      j = this.jdField_d_of_type_Int;
      continue;
      j = this.jdField_e_of_type_Int;
    }
  }
  
  private boolean b()
  {
    boolean bool = true;
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    switch (j)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      azjq.a("PresendPicMgrService", "isOverWasteLimit", "PresendStatus : nettype = " + j + " result =  " + bool + ",mWastedUploadFlow = " + this.jdField_b_of_type_Long);
      return bool;
      if (this.jdField_b_of_type_Long <= this.jdField_c_of_type_Long) {
        break;
      }
      continue;
      if (this.jdField_b_of_type_Long <= this.jdField_f_of_type_Long) {
        break;
      }
      continue;
      if (this.jdField_b_of_type_Long <= this.jdField_e_of_type_Long) {
        break;
      }
      continue;
      if (this.jdField_b_of_type_Long <= this.jdField_d_of_type_Long) {
        break;
      }
    }
  }
  
  private void e()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pic_presend.name());
    if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()))
    {
      localObject = "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50";
      azjq.a("PresendPicMgrService", "getServerConfig", "In VIP list, presendConfigString " + "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50");
    }
    azjq.a("PresendPicMgrService", "getServerConfig", "presendConfigString = " + (String)localObject);
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length >= 16)
      {
        this.jdField_a_of_type_Boolean = localObject[0].equals("1");
        this.jdField_b_of_type_Boolean = localObject[1].equals("1");
        this.jdField_c_of_type_Boolean = localObject[2].equals("1");
        this.jdField_d_of_type_Boolean = localObject[3].equals("1");
        this.jdField_e_of_type_Boolean = localObject[4].equals("1");
        this.jdField_f_of_type_Boolean = localObject[5].equals("1");
        this.jdField_g_of_type_Boolean = localObject[6].equals("1");
        this.h = localObject[7].equals("1");
      }
    }
    try
    {
      this.jdField_c_of_type_Long = Long.valueOf(localObject[8]).longValue();
      this.jdField_f_of_type_Long = Long.valueOf(localObject[9]).longValue();
      this.jdField_e_of_type_Long = Long.valueOf(localObject[10]).longValue();
      this.jdField_d_of_type_Long = Long.valueOf(localObject[11]).longValue();
      this.jdField_b_of_type_Int = Integer.parseInt(localObject[12]);
      this.jdField_c_of_type_Int = Integer.parseInt(localObject[13]);
      this.jdField_d_of_type_Int = Integer.parseInt(localObject[14]);
      this.jdField_e_of_type_Int = Integer.parseInt(localObject[15]);
      azjq.a("PresendPicMgrService", "getServerConfig", "mEnablePreCompress_WIFI = " + this.jdField_a_of_type_Boolean + "mEnablePreCompress_2G = " + this.jdField_b_of_type_Boolean + "mEnablePreCompress_3G = " + this.jdField_c_of_type_Boolean + "mEnablePreCompress_4G = " + this.jdField_d_of_type_Boolean + "mEnablePreUpload_WIFI = " + this.jdField_e_of_type_Boolean + ",mEnablePreUpload_2G = " + this.jdField_f_of_type_Boolean + ",mEnablePreUpload_3G = " + this.jdField_g_of_type_Boolean + ",mEnablePreUpload_4G = " + this.h + "mPreUpMaxWasteSizeWIFI = " + this.jdField_c_of_type_Long + ", mPreUpMaxWasteSize2G = " + this.jdField_f_of_type_Long + ",mPreUpMaxWasteSize3G = " + this.jdField_e_of_type_Long + ",mPreUpMaxWasteSize4G = " + this.jdField_d_of_type_Long + ",mCancelPercentWIFI = " + this.jdField_b_of_type_Int + ",mCancelPercent2G = " + this.jdField_c_of_type_Int + ",mCancelPercent3G = " + this.jdField_d_of_type_Int + ",mCancelPercent4G = " + this.jdField_e_of_type_Int);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public void a()
  {
    azjq.a("PresendPicMgrService", "sendMsg__ start!", " ");
    jdField_a_of_type_Azkt = null;
    ArrayList localArrayList1 = new ArrayList();
    long l1 = 0L;
    Object localObject4;
    ArrayList localArrayList2;
    int j;
    Object localObject5;
    long l2;
    try
    {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        this.i = true;
        localObject4 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString);
        localArrayList2 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        ??? = new ArrayList(this.jdField_b_of_type_JavaUtilArrayList);
        j = 0;
        if (j >= localArrayList2.size()) {
          break label592;
        }
        localObject5 = (azke)localArrayList2.get(j);
        if (((azke)localObject5).jdField_a_of_type_Azkn.jdField_c_of_type_Int != 4) {
          break label204;
        }
        azjq.a("PresendPicMgrService", "sendMsg", "FLAG_UPLOADINFO_ERROR do not send! uuid = " + ((azke)localObject5).jdField_a_of_type_JavaLangString);
        l2 = l1;
        j += 1;
        l1 = l2;
      }
      azjq.a("PresendPicMgrService", "sendMsg__ end!", " ");
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
      }
    }
    for (;;)
    {
      for (;;)
      {
        d();
        return;
        label204:
        synchronized (((azke)localObject5).jdField_a_of_type_Azkn)
        {
          for (;;)
          {
            Object localObject7 = ((azke)localObject5).jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangObject;
            if (localObject7 == null) {}
            try
            {
              azjq.a("PresendPicMgrService", "sendMsg", "start wait! uuid = " + ((azke)localObject5).jdField_a_of_type_JavaLangString);
              ((azke)localObject5).jdField_a_of_type_Azkn.jdField_e_of_type_Boolean = true;
              ((azke)localObject5).jdField_a_of_type_Azkn.wait();
              azjq.a("PresendPicMgrService", "sendMsg", "finish wait! uuid = " + ((azke)localObject5).jdField_a_of_type_JavaLangString);
              ((azke)localObject5).jdField_a_of_type_Azkn.jdField_f_of_type_Boolean = true;
              if (((azke)localObject5).jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangObject == null)
              {
                azjq.b("PresendPicMgrService", "sendMsg", "get MR failed! uuid = " + ((azke)localObject5).jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangString);
                l2 = l1;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }
        }
      }
      ??? = (MessageRecord)((azke)localObject5).jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangObject;
      if (this.jdField_a_of_type_Int == 1)
      {
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_album_id", this.jdField_a_of_type_JavaLangString);
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(this.jdField_a_of_type_Long));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(((azke)localObject5).jdField_a_of_type_Azkn.jdField_g_of_type_Int));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(localArrayList2.size()));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(j));
      }
      a((MessageRecord)???);
      if ((??? instanceof MessageForPic))
      {
        localObject2.add(((MessageForPic)???).path);
        l1 = ((MessageRecord)???).uniseq;
      }
      l2 = l1;
      if (((azke)localObject5).jdField_a_of_type_Azkn.jdField_c_of_type_Int != 3) {
        break;
      }
      azjq.a("PresendPicMgrService", "sendMsg", "Pic not upload,reupload! mr = " + ???);
      a((MessageForPic)???);
      l2 = l1;
      break;
      for (;;)
      {
        label592:
        MessageRecord localMessageRecord;
        try
        {
          localObject5 = ((ArrayList)???).iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          ??? = (azke)((Iterator)localObject5).next();
          j = ((azke)???).jdField_a_of_type_Azkn.jdField_c_of_type_Int;
          localMessageRecord = (MessageRecord)((azke)???).jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangObject;
          if (!localArrayList2.contains(???)) {
            break label759;
          }
          if (j == 1)
          {
            azjq.a("PresendPicMgrService", "sendMsg", "preupload success,dosend! mr =  " + localMessageRecord);
            ((bbob)((QQAppInterface)localObject4).getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(localMessageRecord, null);
            continue;
          }
          azjq.a("PresendPicMgrService", "sendMsg", "preupload failed,reupload! mr =  " + localMessageRecord);
        }
        finally {}
        a((MessageForPic)localMessageRecord);
        continue;
        label759:
        azjq.a("PresendPicMgrService", "sendMsg", "unselect,do not send mr =  " + localMessageRecord);
      }
      if ((localList.size() >= 5) && (this.jdField_f_of_type_Int == 1))
      {
        if (QLog.isColorLevel())
        {
          ??? = localList.iterator();
          while (((Iterator)???).hasNext())
          {
            localObject4 = (String)((Iterator)???).next();
            QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  mSendPaths path=" + (String)localObject4);
          }
          QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  lastMessageUniseq=" + l1);
        }
        bglc.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localList, l1);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  mSendPaths size=" + localList.size());
      }
    }
  }
  
  public void a(int paramInt)
  {
    azjq.a("PresendPicMgrService", "cancelAll", "cancelType = " + paramInt);
    c();
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    azjq.a("PresendPicMgrService", "cancelUploadReq", " start,localUUID = " + paramString + ", cancelType = " + paramInt);
    azke localazke = a(this.jdField_a_of_type_JavaUtilArrayList, paramString);
    if (localazke == null)
    {
      azjq.a("PresendPicMgrService", "cancelUploadReq", " find req failed ");
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localazke);
    a(localazke, paramInt);
    azjq.a("PresendPicMgrService", "cancelUploadReq", " end,localUUID = " + paramString);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "presendPic in main process " + paramInt2);
    }
    azjq.a("PresendPicMgrService", "presendPic", "PresendStatus : path = " + paramString1 + ", localUUID = " + paramString2 + ",fileSize = " + FileUtils.getFileSizes(paramString1) + ",entrance = " + paramInt2);
    azke localazke = azjv.a(2, 1052);
    paramString1 = a(paramString1, paramBoolean, paramInt1, paramInt2);
    localazke.a(paramString1);
    localazke.a(paramString2);
    if (!paramString1.a())
    {
      azjq.b("PresendPicMgrService", paramString2, paramString1.jdField_a_of_type_Azkb.jdField_a_of_type_JavaLangString, paramString1.jdField_a_of_type_Azkb.jdField_b_of_type_JavaLangString);
      paramString1.jdField_c_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilArrayList.add(localazke);
    }
    do
    {
      return;
      localazke.a(new azku(this, localazke, paramString1));
      if ((!a()) || (b()) || (FileUtils.getFileSizes(localazke.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString) > 512000L))
      {
        azjq.a("PresendPicMgrService", "presendPic", "set FLAG_NOT_UPLOAD!");
        localazke.a(null);
        localazke.jdField_a_of_type_Azkn.jdField_c_of_type_Int = 3;
      }
      try
      {
        azjv.a(localazke, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString));
        this.jdField_a_of_type_JavaUtilArrayList.add(localazke);
        return;
      }
      catch (AccountNotMatchException paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.d("PresendPicMgrService", 2, "no appRuntime");
  }
  
  boolean a()
  {
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    boolean bool = false;
    switch (j)
    {
    }
    for (;;)
    {
      azjq.a("PresendPicMgrService", "isPreuploadEnable", "nettype = " + j + " result =  " + bool);
      return bool;
      bool = this.jdField_e_of_type_Boolean;
      continue;
      bool = this.jdField_f_of_type_Boolean;
      continue;
      bool = this.jdField_g_of_type_Boolean;
      continue;
      bool = this.h;
    }
  }
  
  public int[] a()
  {
    try
    {
      int[] arrayOfInt = azjv.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString));
      return arrayOfInt;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "getPicCompressArgConfig no appRuntime");
      }
    }
    return null;
  }
  
  public boolean[] a()
  {
    return new boolean[] { this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean };
  }
  
  public void b()
  {
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    azjq.a("PresendPicMgrService", "handletWifi2Mobile", "netType = " + j);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      azjq.a("PresendPicMgrService", "handletWifi2Mobile", "mUploadReqList is Null! ");
    }
    for (;;)
    {
      return;
      Iterator localIterator;
      azke localazke;
      if (j == 2)
      {
        azjq.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G2,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localazke = (azke)localIterator.next();
          a(localazke, 1001);
          localazke.jdField_a_of_type_Azkn.jdField_c_of_type_Int = 3;
        }
      }
      if (((j == 3) || (j == 4)) && (b()))
      {
        azjq.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G3/G4,overWastLimit,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localazke = (azke)localIterator.next();
          a(localazke, 1002);
          localazke.jdField_a_of_type_Azkn.jdField_c_of_type_Int = 3;
        }
      }
    }
  }
  
  void c()
  {
    azjq.a("PresendPicMgrService", "resetStatus", "");
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.i = false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkt
 * JD-Core Version:    0.7.0.1
 */