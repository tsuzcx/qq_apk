import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class auoj
  extends aund
{
  private static auoj jdField_a_of_type_Auoj;
  public int a;
  public long a;
  public String a;
  private ArrayList<aunv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<aunv> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
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
  
  public auoj(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_g_of_type_Int = paramInt2;
    long l1 = auns.a("presend_lastDayTime", 0L);
    long l2 = System.currentTimeMillis();
    aung.a("PresendPicMgrService", "[@]PresendPicMgrService", "currentTime = " + l2 + ", lastDayTime = " + l1 + ", curFriendUin = " + paramString1 + ",troopUin = " + paramString2 + ",myUin = " + paramString3);
    e();
    if (l2 - l1 > 86400000L)
    {
      aung.a("PresendPicMgrService", "PresendPicMgrService", "more than one day, clear wastesize");
      agqd.a(auns.a("presend_FlowWaste", 0L));
      auns.a("presend_lastDayTime", l2);
      auns.a("presend_FlowWaste", 0L);
    }
    this.jdField_b_of_type_Long = auns.a("presend_FlowWaste", 0L);
    jdField_a_of_type_Auoj = this;
  }
  
  private aunv a(ArrayList<aunv> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      aunv localaunv = (aunv)paramArrayList.next();
      if (localaunv.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localaunv;
      }
    }
    return null;
  }
  
  private auod a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new auoe();
    aung.a("PresendPicMgrService", "[@]buildPicUploadInfo", "curFriendUin = " + this.jdField_b_of_type_JavaLangString);
    ((auoe)localObject).d(this.jdField_b_of_type_JavaLangString);
    ((auoe)localObject).a(paramString);
    ((auoe)localObject).e(this.jdField_f_of_type_Int);
    ((auoe)localObject).e(this.jdField_c_of_type_JavaLangString);
    ((auoe)localObject).d(paramInt1);
    ((auoe)localObject).f(0);
    ((auoe)localObject).k(paramInt2);
    ((auoe)localObject).l(this.jdField_g_of_type_Int);
    localObject = ((auoe)localObject).a();
    ((auod)localObject).jdField_c_of_type_Boolean = true;
    if (bgky.a(paramString)) {
      bbfb.a();
    }
    try
    {
      ((auod)localObject).jdField_a_of_type_JavaUtilArrayList = bgky.a(paramString);
      if ((((auod)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (QLog.isColorLevel())) {
        QLog.d("peak_pgjpeg", 2, "PresendPicMgrService.buildPicUploadInfo:" + ((auod)localObject).jdField_a_of_type_JavaUtilArrayList.toString());
      }
      bbfb.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramString + ")");
      if (paramBoolean)
      {
        ((auod)localObject).jdField_g_of_type_Int = 1;
        aung.a(localObject, "fixProtocolType", "sendReq.upInfo.protocolType");
        return localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramString + "'s size is " + bbdx.a(paramString));
        }
      }
      ((auod)localObject).jdField_g_of_type_Int = ((auod)localObject).a();
    }
    return localObject;
  }
  
  public static auoj a()
  {
    return jdField_a_of_type_Auoj;
  }
  
  private void a(long paramLong, int paramInt)
  {
    this.jdField_b_of_type_Long += paramLong;
    auns.a("presend_FlowWaste", this.jdField_b_of_type_Long);
    agqd.a(paramLong, paramInt);
    aung.a("PresendPicMgrService", "calcWasteFlow ", "PresendStatus:  wastesize = " + paramLong + ",mWastedUploadFlow = " + this.jdField_b_of_type_Long + ",cancelType = " + paramInt);
  }
  
  private void a(aunv paramaunv, int paramInt)
  {
    synchronized (paramaunv.jdField_a_of_type_Auod)
    {
      paramaunv.jdField_a_of_type_Auod.jdField_d_of_type_Boolean = true;
      if (paramaunv.jdField_a_of_type_Auod.jdField_a_of_type_JavaLangObject == null)
      {
        aung.b("PresendPicMgrService", "doCancel", " req.upInfo.picExtraObject == null!");
        return;
      }
    }
    ??? = (MessageRecord)paramaunv.jdField_a_of_type_Auod.jdField_a_of_type_JavaLangObject;
    for (;;)
    {
      aypg localaypg;
      long l1;
      try
      {
        localaypg = (aypg)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString)).a().a(((MessageRecord)???).frienduin, ((MessageRecord)???).uniseq);
        if (localaypg != null) {
          break label243;
        }
        aung.a("PresendPicMgrService", "doCancel", " processor == null!");
        l1 = ((MessageForPic)???).mPresendTransferedSize;
        long l2 = bbdx.a(((MessageForPic)???).path);
        aung.a("PresendPicMgrService", "doCancel", "picSize = " + l2);
        a(l1, paramInt);
        aung.a("PresendPicMgrService", "doCancel ", "PresendStatus: Path:" + paramaunv.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString + ",uuid:" + paramaunv.jdField_a_of_type_Auod.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
        return;
      }
      catch (AccountNotMatchException paramaunv) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PresendPicMgrService", 2, "no appRuntime");
      return;
      label243:
      int j = b();
      if (localaypg.g() < j)
      {
        aung.a("PresendPicMgrService", "doCancel", " processor upload less than cancelPercent:" + j + ", do cancel! ");
        localaypg.a();
        l1 = localaypg.b();
      }
      else
      {
        aung.a("PresendPicMgrService", "doCancel", " processor upload more than cancelPercent:" + j + ", do not cancel!");
        l1 = localaypg.a();
      }
    }
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    aung.a("PresendPicMgrService", "reuploadPhoto", " ");
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString);
      localQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        localQQAppInterface.a().a(localQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      auoe localauoe = new auoe();
      localauoe.a(paramMessageForPic.path);
      localauoe.d(5);
      localauoe.d(paramMessageForPic.frienduin);
      localauoe.b(paramMessageForPic.uniseq);
      if (paramMessageForPic.fileSizeFlag == 1) {
        localauoe.c(ayvw.jdField_e_of_type_Int);
      }
      for (;;)
      {
        localauoe.e(paramMessageForPic.senderuin);
        localauoe.c(paramMessageForPic.selfuin);
        localauoe.e(paramMessageForPic.istroop);
        localauoe.jdField_i_of_type_Int = paramMessageForPic.extLong;
        localauoe.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
        auof localauof = new auof();
        localauof.jdField_a_of_type_Long = paramMessageForPic.msgseq;
        localauof.jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
        localauof.jdField_a_of_type_Long = paramMessageForPic.msgseq;
        localauoe.a(localauof);
        paramMessageForPic = aunl.a(4, 5);
        paramMessageForPic.a(localauoe.a());
        aunl.a(paramMessageForPic, localQQAppInterface);
        return;
        localauoe.c(ayvw.jdField_d_of_type_Int);
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
    awap localawap = (awap)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(326);
    localawap.a(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
    localawap.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  private int b()
  {
    int j = 0;
    int k = bbfj.a(BaseApplication.getContext());
    switch (k)
    {
    }
    for (;;)
    {
      aung.a("PresendPicMgrService", "getCancelPercent", " NetType = " + k + ", cancelpercent = " + j);
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
    int j = bbfj.a(BaseApplication.getContext());
    switch (j)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      aung.a("PresendPicMgrService", "isOverWasteLimit", "PresendStatus : nettype = " + j + " result =  " + bool + ",mWastedUploadFlow = " + this.jdField_b_of_type_Long);
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
      aung.a("PresendPicMgrService", "getServerConfig", "In VIP list, presendConfigString " + "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50");
    }
    aung.a("PresendPicMgrService", "getServerConfig", "presendConfigString = " + (String)localObject);
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
      aung.a("PresendPicMgrService", "getServerConfig", "mEnablePreCompress_WIFI = " + this.jdField_a_of_type_Boolean + "mEnablePreCompress_2G = " + this.jdField_b_of_type_Boolean + "mEnablePreCompress_3G = " + this.jdField_c_of_type_Boolean + "mEnablePreCompress_4G = " + this.jdField_d_of_type_Boolean + "mEnablePreUpload_WIFI = " + this.jdField_e_of_type_Boolean + ",mEnablePreUpload_2G = " + this.jdField_f_of_type_Boolean + ",mEnablePreUpload_3G = " + this.jdField_g_of_type_Boolean + ",mEnablePreUpload_4G = " + this.h + "mPreUpMaxWasteSizeWIFI = " + this.jdField_c_of_type_Long + ", mPreUpMaxWasteSize2G = " + this.jdField_f_of_type_Long + ",mPreUpMaxWasteSize3G = " + this.jdField_e_of_type_Long + ",mPreUpMaxWasteSize4G = " + this.jdField_d_of_type_Long + ",mCancelPercentWIFI = " + this.jdField_b_of_type_Int + ",mCancelPercent2G = " + this.jdField_c_of_type_Int + ",mCancelPercent3G = " + this.jdField_d_of_type_Int + ",mCancelPercent4G = " + this.jdField_e_of_type_Int);
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
    aung.a("PresendPicMgrService", "sendMsg__ start!", " ");
    jdField_a_of_type_Auoj = null;
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
        localObject5 = (aunv)localArrayList2.get(j);
        if (((aunv)localObject5).jdField_a_of_type_Auod.jdField_c_of_type_Int != 4) {
          break label204;
        }
        aung.a("PresendPicMgrService", "sendMsg", "FLAG_UPLOADINFO_ERROR do not send! uuid = " + ((aunv)localObject5).jdField_a_of_type_JavaLangString);
        l2 = l1;
        j += 1;
        l1 = l2;
      }
      aung.a("PresendPicMgrService", "sendMsg__ end!", " ");
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
        synchronized (((aunv)localObject5).jdField_a_of_type_Auod)
        {
          for (;;)
          {
            Object localObject7 = ((aunv)localObject5).jdField_a_of_type_Auod.jdField_a_of_type_JavaLangObject;
            if (localObject7 == null) {}
            try
            {
              aung.a("PresendPicMgrService", "sendMsg", "start wait! uuid = " + ((aunv)localObject5).jdField_a_of_type_JavaLangString);
              ((aunv)localObject5).jdField_a_of_type_Auod.jdField_e_of_type_Boolean = true;
              ((aunv)localObject5).jdField_a_of_type_Auod.wait();
              aung.a("PresendPicMgrService", "sendMsg", "finish wait! uuid = " + ((aunv)localObject5).jdField_a_of_type_JavaLangString);
              ((aunv)localObject5).jdField_a_of_type_Auod.jdField_f_of_type_Boolean = true;
              if (((aunv)localObject5).jdField_a_of_type_Auod.jdField_a_of_type_JavaLangObject == null)
              {
                aung.b("PresendPicMgrService", "sendMsg", "get MR failed! uuid = " + ((aunv)localObject5).jdField_a_of_type_Auod.jdField_a_of_type_JavaLangString);
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
      ??? = (MessageRecord)((aunv)localObject5).jdField_a_of_type_Auod.jdField_a_of_type_JavaLangObject;
      if (this.jdField_a_of_type_Int == 1)
      {
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_album_id", this.jdField_a_of_type_JavaLangString);
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(this.jdField_a_of_type_Long));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(((aunv)localObject5).jdField_a_of_type_Auod.jdField_g_of_type_Int));
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
      if (((aunv)localObject5).jdField_a_of_type_Auod.jdField_c_of_type_Int != 3) {
        break;
      }
      aung.a("PresendPicMgrService", "sendMsg", "Pic not upload,reupload! mr = " + ???);
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
          ??? = (aunv)((Iterator)localObject5).next();
          j = ((aunv)???).jdField_a_of_type_Auod.jdField_c_of_type_Int;
          localMessageRecord = (MessageRecord)((aunv)???).jdField_a_of_type_Auod.jdField_a_of_type_JavaLangObject;
          if (!localArrayList2.contains(???)) {
            break label759;
          }
          if (j == 1)
          {
            aung.a("PresendPicMgrService", "sendMsg", "preupload success,dosend! mr =  " + localMessageRecord);
            ((awap)((QQAppInterface)localObject4).getManager(326)).a(localMessageRecord, null);
            continue;
          }
          aung.a("PresendPicMgrService", "sendMsg", "preupload failed,reupload! mr =  " + localMessageRecord);
        }
        finally {}
        a((MessageForPic)localMessageRecord);
        continue;
        label759:
        aung.a("PresendPicMgrService", "sendMsg", "unselect,do not send mr =  " + localMessageRecord);
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
        balv.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localList, l1);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  mSendPaths size=" + localList.size());
      }
    }
  }
  
  public void a(int paramInt)
  {
    aung.a("PresendPicMgrService", "cancelAll", "cancelType = " + paramInt);
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
    aung.a("PresendPicMgrService", "cancelUploadReq", " start,localUUID = " + paramString + ", cancelType = " + paramInt);
    aunv localaunv = a(this.jdField_a_of_type_JavaUtilArrayList, paramString);
    if (localaunv == null)
    {
      aung.a("PresendPicMgrService", "cancelUploadReq", " find req failed ");
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localaunv);
    a(localaunv, paramInt);
    aung.a("PresendPicMgrService", "cancelUploadReq", " end,localUUID = " + paramString);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "presendPic in main process " + paramInt2);
    }
    aung.a("PresendPicMgrService", "presendPic", "PresendStatus : path = " + paramString1 + ", localUUID = " + paramString2 + ",fileSize = " + bbdx.a(paramString1) + ",entrance = " + paramInt2);
    aunv localaunv = aunl.a(2, 1052);
    paramString1 = a(paramString1, paramBoolean, paramInt1, paramInt2);
    localaunv.a(paramString1);
    localaunv.a(paramString2);
    if (!paramString1.a())
    {
      aung.b("PresendPicMgrService", paramString2, paramString1.jdField_a_of_type_Aunr.jdField_a_of_type_JavaLangString, paramString1.jdField_a_of_type_Aunr.jdField_b_of_type_JavaLangString);
      paramString1.jdField_c_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilArrayList.add(localaunv);
    }
    do
    {
      return;
      localaunv.a(new auok(this, localaunv, paramString1));
      if ((!a()) || (b()) || (bbdx.a(localaunv.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString) > 512000L))
      {
        aung.a("PresendPicMgrService", "presendPic", "set FLAG_NOT_UPLOAD!");
        localaunv.a(null);
        localaunv.jdField_a_of_type_Auod.jdField_c_of_type_Int = 3;
      }
      try
      {
        aunl.a(localaunv, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString));
        this.jdField_a_of_type_JavaUtilArrayList.add(localaunv);
        return;
      }
      catch (AccountNotMatchException paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.d("PresendPicMgrService", 2, "no appRuntime");
  }
  
  boolean a()
  {
    int j = bbfj.a(BaseApplication.getContext());
    boolean bool = false;
    switch (j)
    {
    }
    for (;;)
    {
      aung.a("PresendPicMgrService", "isPreuploadEnable", "nettype = " + j + " result =  " + bool);
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
      int[] arrayOfInt = aunl.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString));
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
    int j = bbfj.a(BaseApplication.getContext());
    aung.a("PresendPicMgrService", "handletWifi2Mobile", "netType = " + j);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      aung.a("PresendPicMgrService", "handletWifi2Mobile", "mUploadReqList is Null! ");
    }
    for (;;)
    {
      return;
      Iterator localIterator;
      aunv localaunv;
      if (j == 2)
      {
        aung.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G2,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localaunv = (aunv)localIterator.next();
          a(localaunv, 1001);
          localaunv.jdField_a_of_type_Auod.jdField_c_of_type_Int = 3;
        }
      }
      if (((j == 3) || (j == 4)) && (b()))
      {
        aung.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G3/G4,overWastLimit,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localaunv = (aunv)localIterator.next();
          a(localaunv, 1002);
          localaunv.jdField_a_of_type_Auod.jdField_c_of_type_Int = 3;
        }
      }
    }
  }
  
  void c()
  {
    aung.a("PresendPicMgrService", "resetStatus", "");
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
 * Qualified Name:     auoj
 * JD-Core Version:    0.7.0.1
 */