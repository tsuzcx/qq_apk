import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class awfr
  extends awek
{
  private static awfr jdField_a_of_type_Awfr;
  public int a;
  public long a;
  public String a;
  private ArrayList<awfc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<awfc> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
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
  
  public awfr(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_g_of_type_Int = paramInt2;
    long l1 = awez.a("presend_lastDayTime", 0L);
    long l2 = System.currentTimeMillis();
    awen.a("PresendPicMgrService", "[@]PresendPicMgrService", "currentTime = " + l2 + ", lastDayTime = " + l1 + ", curFriendUin = " + paramString1 + ",troopUin = " + paramString2 + ",myUin = " + paramString3);
    e();
    if (l2 - l1 > 86400000L)
    {
      awen.a("PresendPicMgrService", "PresendPicMgrService", "more than one day, clear wastesize");
      aild.a(awez.a("presend_FlowWaste", 0L));
      awez.a("presend_lastDayTime", l2);
      awez.a("presend_FlowWaste", 0L);
    }
    this.jdField_b_of_type_Long = awez.a("presend_FlowWaste", 0L);
    jdField_a_of_type_Awfr = this;
  }
  
  private awfc a(ArrayList<awfc> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      awfc localawfc = (awfc)paramArrayList.next();
      if (localawfc.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localawfc;
      }
    }
    return null;
  }
  
  private awfl a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new awfm();
    awen.a("PresendPicMgrService", "[@]buildPicUploadInfo", "curFriendUin = " + this.jdField_b_of_type_JavaLangString);
    ((awfm)localObject).d(this.jdField_b_of_type_JavaLangString);
    ((awfm)localObject).a(paramString);
    ((awfm)localObject).e(this.jdField_f_of_type_Int);
    ((awfm)localObject).e(this.jdField_c_of_type_JavaLangString);
    ((awfm)localObject).d(paramInt1);
    ((awfm)localObject).f(0);
    ((awfm)localObject).k(paramInt2);
    ((awfm)localObject).l(this.jdField_g_of_type_Int);
    localObject = ((awfm)localObject).a();
    ((awfl)localObject).jdField_c_of_type_Boolean = true;
    if (bilx.a(paramString)) {
      bddw.a();
    }
    try
    {
      ((awfl)localObject).jdField_a_of_type_JavaUtilArrayList = bilx.a(paramString);
      if ((((awfl)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (QLog.isColorLevel())) {
        QLog.d("peak_pgjpeg", 2, "PresendPicMgrService.buildPicUploadInfo:" + ((awfl)localObject).jdField_a_of_type_JavaUtilArrayList.toString());
      }
      bddw.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramString + ")");
      if (paramBoolean)
      {
        ((awfl)localObject).jdField_g_of_type_Int = 1;
        awen.a(localObject, "fixProtocolType", "sendReq.upInfo.protocolType");
        return localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramString + "'s size is " + bdcs.a(paramString));
        }
      }
      ((awfl)localObject).jdField_g_of_type_Int = ((awfl)localObject).a();
    }
    return localObject;
  }
  
  public static awfr a()
  {
    return jdField_a_of_type_Awfr;
  }
  
  private void a(long paramLong, int paramInt)
  {
    this.jdField_b_of_type_Long += paramLong;
    awez.a("presend_FlowWaste", this.jdField_b_of_type_Long);
    aild.a(paramLong, paramInt);
    awen.a("PresendPicMgrService", "calcWasteFlow ", "PresendStatus:  wastesize = " + paramLong + ",mWastedUploadFlow = " + this.jdField_b_of_type_Long + ",cancelType = " + paramInt);
  }
  
  private void a(awfc paramawfc, int paramInt)
  {
    synchronized (paramawfc.jdField_a_of_type_Awfl)
    {
      paramawfc.jdField_a_of_type_Awfl.jdField_d_of_type_Boolean = true;
      if (paramawfc.jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangObject == null)
      {
        awen.b("PresendPicMgrService", "doCancel", " req.upInfo.picExtraObject == null!");
        return;
      }
    }
    ??? = (MessageRecord)paramawfc.jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangObject;
    for (;;)
    {
      banb localbanb;
      long l1;
      try
      {
        localbanb = (banb)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString)).a().a(((MessageRecord)???).frienduin, ((MessageRecord)???).uniseq);
        if (localbanb != null) {
          break label243;
        }
        awen.a("PresendPicMgrService", "doCancel", " processor == null!");
        l1 = ((MessageForPic)???).mPresendTransferedSize;
        long l2 = bdcs.a(((MessageForPic)???).path);
        awen.a("PresendPicMgrService", "doCancel", "picSize = " + l2);
        a(l1, paramInt);
        awen.a("PresendPicMgrService", "doCancel ", "PresendStatus: Path:" + paramawfc.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString + ",uuid:" + paramawfc.jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
        return;
      }
      catch (AccountNotMatchException paramawfc) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PresendPicMgrService", 2, "no appRuntime");
      return;
      label243:
      int j = b();
      if (localbanb.g() < j)
      {
        awen.a("PresendPicMgrService", "doCancel", " processor upload less than cancelPercent:" + j + ", do cancel! ");
        localbanb.a();
        l1 = localbanb.b();
      }
      else
      {
        awen.a("PresendPicMgrService", "doCancel", " processor upload more than cancelPercent:" + j + ", do not cancel!");
        l1 = localbanb.a();
      }
    }
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    awen.a("PresendPicMgrService", "reuploadPhoto", " ");
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString);
      localQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        localQQAppInterface.a().a(localQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      awfm localawfm = new awfm();
      localawfm.a(paramMessageForPic.path);
      localawfm.d(5);
      localawfm.d(paramMessageForPic.frienduin);
      localawfm.b(paramMessageForPic.uniseq);
      if (paramMessageForPic.fileSizeFlag == 1) {
        localawfm.c(batv.jdField_e_of_type_Int);
      }
      for (;;)
      {
        localawfm.e(paramMessageForPic.senderuin);
        localawfm.c(paramMessageForPic.selfuin);
        localawfm.e(paramMessageForPic.istroop);
        localawfm.jdField_i_of_type_Int = paramMessageForPic.extLong;
        localawfm.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
        awfn localawfn = new awfn();
        localawfn.jdField_a_of_type_Long = paramMessageForPic.msgseq;
        localawfn.jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
        localawfn.jdField_a_of_type_Long = paramMessageForPic.msgseq;
        localawfm.a(localawfn);
        paramMessageForPic = awes.a(4, 5);
        paramMessageForPic.a(localawfm.a());
        awes.a(paramMessageForPic, localQQAppInterface);
        return;
        localawfm.c(batv.jdField_d_of_type_Int);
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
    axso localaxso = (axso)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(326);
    localaxso.a(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
    localaxso.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  private int b()
  {
    int j = 0;
    int k = bdee.a(BaseApplication.getContext());
    switch (k)
    {
    }
    for (;;)
    {
      awen.a("PresendPicMgrService", "getCancelPercent", " NetType = " + k + ", cancelpercent = " + j);
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
    int j = bdee.a(BaseApplication.getContext());
    switch (j)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      awen.a("PresendPicMgrService", "isOverWasteLimit", "PresendStatus : nettype = " + j + " result =  " + bool + ",mWastedUploadFlow = " + this.jdField_b_of_type_Long);
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
      awen.a("PresendPicMgrService", "getServerConfig", "In VIP list, presendConfigString " + "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50");
    }
    awen.a("PresendPicMgrService", "getServerConfig", "presendConfigString = " + (String)localObject);
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
      awen.a("PresendPicMgrService", "getServerConfig", "mEnablePreCompress_WIFI = " + this.jdField_a_of_type_Boolean + "mEnablePreCompress_2G = " + this.jdField_b_of_type_Boolean + "mEnablePreCompress_3G = " + this.jdField_c_of_type_Boolean + "mEnablePreCompress_4G = " + this.jdField_d_of_type_Boolean + "mEnablePreUpload_WIFI = " + this.jdField_e_of_type_Boolean + ",mEnablePreUpload_2G = " + this.jdField_f_of_type_Boolean + ",mEnablePreUpload_3G = " + this.jdField_g_of_type_Boolean + ",mEnablePreUpload_4G = " + this.h + "mPreUpMaxWasteSizeWIFI = " + this.jdField_c_of_type_Long + ", mPreUpMaxWasteSize2G = " + this.jdField_f_of_type_Long + ",mPreUpMaxWasteSize3G = " + this.jdField_e_of_type_Long + ",mPreUpMaxWasteSize4G = " + this.jdField_d_of_type_Long + ",mCancelPercentWIFI = " + this.jdField_b_of_type_Int + ",mCancelPercent2G = " + this.jdField_c_of_type_Int + ",mCancelPercent3G = " + this.jdField_d_of_type_Int + ",mCancelPercent4G = " + this.jdField_e_of_type_Int);
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
    awen.a("PresendPicMgrService", "sendMsg__ start!", " ");
    jdField_a_of_type_Awfr = null;
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
        localObject5 = (awfc)localArrayList2.get(j);
        if (((awfc)localObject5).jdField_a_of_type_Awfl.jdField_c_of_type_Int != 4) {
          break label204;
        }
        awen.a("PresendPicMgrService", "sendMsg", "FLAG_UPLOADINFO_ERROR do not send! uuid = " + ((awfc)localObject5).jdField_a_of_type_JavaLangString);
        l2 = l1;
        j += 1;
        l1 = l2;
      }
      awen.a("PresendPicMgrService", "sendMsg__ end!", " ");
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
        synchronized (((awfc)localObject5).jdField_a_of_type_Awfl)
        {
          for (;;)
          {
            Object localObject7 = ((awfc)localObject5).jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangObject;
            if (localObject7 == null) {}
            try
            {
              awen.a("PresendPicMgrService", "sendMsg", "start wait! uuid = " + ((awfc)localObject5).jdField_a_of_type_JavaLangString);
              ((awfc)localObject5).jdField_a_of_type_Awfl.jdField_e_of_type_Boolean = true;
              ((awfc)localObject5).jdField_a_of_type_Awfl.wait();
              awen.a("PresendPicMgrService", "sendMsg", "finish wait! uuid = " + ((awfc)localObject5).jdField_a_of_type_JavaLangString);
              ((awfc)localObject5).jdField_a_of_type_Awfl.jdField_f_of_type_Boolean = true;
              if (((awfc)localObject5).jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangObject == null)
              {
                awen.b("PresendPicMgrService", "sendMsg", "get MR failed! uuid = " + ((awfc)localObject5).jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangString);
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
      ??? = (MessageRecord)((awfc)localObject5).jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangObject;
      if (this.jdField_a_of_type_Int == 1)
      {
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_album_id", this.jdField_a_of_type_JavaLangString);
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(this.jdField_a_of_type_Long));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(((awfc)localObject5).jdField_a_of_type_Awfl.jdField_g_of_type_Int));
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
      if (((awfc)localObject5).jdField_a_of_type_Awfl.jdField_c_of_type_Int != 3) {
        break;
      }
      awen.a("PresendPicMgrService", "sendMsg", "Pic not upload,reupload! mr = " + ???);
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
          ??? = (awfc)((Iterator)localObject5).next();
          j = ((awfc)???).jdField_a_of_type_Awfl.jdField_c_of_type_Int;
          localMessageRecord = (MessageRecord)((awfc)???).jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangObject;
          if (!localArrayList2.contains(???)) {
            break label759;
          }
          if (j == 1)
          {
            awen.a("PresendPicMgrService", "sendMsg", "preupload success,dosend! mr =  " + localMessageRecord);
            ((axso)((QQAppInterface)localObject4).getManager(326)).a(localMessageRecord, null);
            continue;
          }
          awen.a("PresendPicMgrService", "sendMsg", "preupload failed,reupload! mr =  " + localMessageRecord);
        }
        finally {}
        a((MessageForPic)localMessageRecord);
        continue;
        label759:
        awen.a("PresendPicMgrService", "sendMsg", "unselect,do not send mr =  " + localMessageRecord);
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
        bcki.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localList, l1);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  mSendPaths size=" + localList.size());
      }
    }
  }
  
  public void a(int paramInt)
  {
    awen.a("PresendPicMgrService", "cancelAll", "cancelType = " + paramInt);
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
    awen.a("PresendPicMgrService", "cancelUploadReq", " start,localUUID = " + paramString + ", cancelType = " + paramInt);
    awfc localawfc = a(this.jdField_a_of_type_JavaUtilArrayList, paramString);
    if (localawfc == null)
    {
      awen.a("PresendPicMgrService", "cancelUploadReq", " find req failed ");
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localawfc);
    a(localawfc, paramInt);
    awen.a("PresendPicMgrService", "cancelUploadReq", " end,localUUID = " + paramString);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "presendPic in main process " + paramInt2);
    }
    awen.a("PresendPicMgrService", "presendPic", "PresendStatus : path = " + paramString1 + ", localUUID = " + paramString2 + ",fileSize = " + bdcs.a(paramString1) + ",entrance = " + paramInt2);
    awfc localawfc = awes.a(2, 1052);
    paramString1 = a(paramString1, paramBoolean, paramInt1, paramInt2);
    localawfc.a(paramString1);
    localawfc.a(paramString2);
    if (!paramString1.a())
    {
      awen.b("PresendPicMgrService", paramString2, paramString1.jdField_a_of_type_Awey.jdField_a_of_type_JavaLangString, paramString1.jdField_a_of_type_Awey.jdField_b_of_type_JavaLangString);
      paramString1.jdField_c_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilArrayList.add(localawfc);
    }
    do
    {
      return;
      localawfc.a(new awfs(this, localawfc, paramString1));
      if ((!a()) || (b()) || (bdcs.a(localawfc.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString) > 512000L))
      {
        awen.a("PresendPicMgrService", "presendPic", "set FLAG_NOT_UPLOAD!");
        localawfc.a(null);
        localawfc.jdField_a_of_type_Awfl.jdField_c_of_type_Int = 3;
      }
      try
      {
        awes.a(localawfc, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString));
        this.jdField_a_of_type_JavaUtilArrayList.add(localawfc);
        return;
      }
      catch (AccountNotMatchException paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.d("PresendPicMgrService", 2, "no appRuntime");
  }
  
  boolean a()
  {
    int j = bdee.a(BaseApplication.getContext());
    boolean bool = false;
    switch (j)
    {
    }
    for (;;)
    {
      awen.a("PresendPicMgrService", "isPreuploadEnable", "nettype = " + j + " result =  " + bool);
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
      int[] arrayOfInt = awes.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString));
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
    int j = bdee.a(BaseApplication.getContext());
    awen.a("PresendPicMgrService", "handletWifi2Mobile", "netType = " + j);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      awen.a("PresendPicMgrService", "handletWifi2Mobile", "mUploadReqList is Null! ");
    }
    for (;;)
    {
      return;
      Iterator localIterator;
      awfc localawfc;
      if (j == 2)
      {
        awen.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G2,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localawfc = (awfc)localIterator.next();
          a(localawfc, 1001);
          localawfc.jdField_a_of_type_Awfl.jdField_c_of_type_Int = 3;
        }
      }
      if (((j == 3) || (j == 4)) && (b()))
      {
        awen.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G3/G4,overWastLimit,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localawfc = (awfc)localIterator.next();
          a(localawfc, 1002);
          localawfc.jdField_a_of_type_Awfl.jdField_c_of_type_Int = 3;
        }
      }
    }
  }
  
  void c()
  {
    awen.a("PresendPicMgrService", "resetStatus", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awfr
 * JD-Core Version:    0.7.0.1
 */