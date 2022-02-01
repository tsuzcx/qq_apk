import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class ayeh
  extends aydb
{
  private static ayeh jdField_a_of_type_Ayeh;
  public int a;
  public long a;
  public String a;
  private ArrayList<ayds> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<ayds> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
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
  
  public ayeh(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_g_of_type_Int = paramInt2;
    long l1 = aydq.a("presend_lastDayTime", 0L);
    long l2 = System.currentTimeMillis();
    ayde.a("PresendPicMgrService", "[@]PresendPicMgrService", "currentTime = " + l2 + ", lastDayTime = " + l1 + ", curFriendUin = " + paramString1 + ",troopUin = " + paramString2 + ",myUin = " + paramString3);
    e();
    if (l2 - l1 > 86400000L)
    {
      ayde.a("PresendPicMgrService", "PresendPicMgrService", "more than one day, clear wastesize");
      ajpv.a(aydq.a("presend_FlowWaste", 0L));
      aydq.a("presend_lastDayTime", l2);
      aydq.a("presend_FlowWaste", 0L);
    }
    this.jdField_b_of_type_Long = aydq.a("presend_FlowWaste", 0L);
    jdField_a_of_type_Ayeh = this;
  }
  
  private ayds a(ArrayList<ayds> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ayds localayds = (ayds)paramArrayList.next();
      if (localayds.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localayds;
      }
    }
    return null;
  }
  
  private ayeb a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new ayec();
    ayde.a("PresendPicMgrService", "[@]buildPicUploadInfo", "curFriendUin = " + this.jdField_b_of_type_JavaLangString);
    ((ayec)localObject).d(this.jdField_b_of_type_JavaLangString);
    ((ayec)localObject).a(paramString);
    ((ayec)localObject).e(this.jdField_f_of_type_Int);
    ((ayec)localObject).e(this.jdField_c_of_type_JavaLangString);
    ((ayec)localObject).d(paramInt1);
    ((ayec)localObject).f(0);
    ((ayec)localObject).k(paramInt2);
    ((ayec)localObject).l(this.jdField_g_of_type_Int);
    localObject = ((ayec)localObject).a();
    if (paramInt2 == 10)
    {
      if (((ayeb)localObject).jdField_a_of_type_Ayea == null) {
        ((ayeb)localObject).jdField_a_of_type_Ayea = new ayea();
      }
      ((ayeb)localObject).jdField_a_of_type_Ayea.jdField_a_of_type_Int = 9;
    }
    ((ayeb)localObject).jdField_c_of_type_Boolean = true;
    if (bkkh.a(paramString)) {
      bfwl.a();
    }
    try
    {
      ((ayeb)localObject).jdField_a_of_type_JavaUtilArrayList = bkkh.a(paramString);
      if ((((ayeb)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (QLog.isColorLevel())) {
        QLog.d("peak_pgjpeg", 2, "PresendPicMgrService.buildPicUploadInfo:" + ((ayeb)localObject).jdField_a_of_type_JavaUtilArrayList.toString());
      }
      bfwl.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramString + ")");
      if (paramBoolean)
      {
        ((ayeb)localObject).jdField_g_of_type_Int = 1;
        ayde.a(localObject, "fixProtocolType", "sendReq.upInfo.protocolType");
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
      ((ayeb)localObject).jdField_g_of_type_Int = ((ayeb)localObject).a();
    }
    return localObject;
  }
  
  public static ayeh a()
  {
    return jdField_a_of_type_Ayeh;
  }
  
  private void a(long paramLong, int paramInt)
  {
    this.jdField_b_of_type_Long += paramLong;
    aydq.a("presend_FlowWaste", this.jdField_b_of_type_Long);
    ajpv.a(paramLong, paramInt);
    ayde.a("PresendPicMgrService", "calcWasteFlow ", "PresendStatus:  wastesize = " + paramLong + ",mWastedUploadFlow = " + this.jdField_b_of_type_Long + ",cancelType = " + paramInt);
  }
  
  private void a(ayds paramayds, int paramInt)
  {
    synchronized (paramayds.jdField_a_of_type_Ayeb)
    {
      paramayds.jdField_a_of_type_Ayeb.jdField_d_of_type_Boolean = true;
      if (paramayds.jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangObject == null)
      {
        ayde.b("PresendPicMgrService", "doCancel", " req.upInfo.picExtraObject == null!");
        return;
      }
    }
    ??? = (MessageRecord)paramayds.jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangObject;
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
        ayde.a("PresendPicMgrService", "doCancel", " processor == null!");
        l1 = ((MessageForPic)???).mPresendTransferedSize;
        long l2 = FileUtils.getFileSizes(((MessageForPic)???).path);
        ayde.a("PresendPicMgrService", "doCancel", "picSize = " + l2);
        a(l1, paramInt);
        ayde.a("PresendPicMgrService", "doCancel ", "PresendStatus: Path:" + paramayds.jdField_a_of_type_Ayeb.jdField_g_of_type_JavaLangString + ",uuid:" + paramayds.jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
        return;
      }
      catch (AccountNotMatchException paramayds) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PresendPicMgrService", 2, "no appRuntime");
      return;
      label243:
      int j = b();
      if (localBaseUploadProcessor.getRealProgress() < j)
      {
        ayde.a("PresendPicMgrService", "doCancel", " processor upload less than cancelPercent:" + j + ", do cancel! ");
        localBaseUploadProcessor.cancel();
        l1 = localBaseUploadProcessor.getTransferedSize();
      }
      else
      {
        ayde.a("PresendPicMgrService", "doCancel", " processor upload more than cancelPercent:" + j + ", do not cancel!");
        l1 = localBaseUploadProcessor.getFileSize();
      }
    }
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    ayde.a("PresendPicMgrService", "reuploadPhoto", " ");
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString);
      localQQAppInterface.getMessageFacade().removeMsgByUniseq(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        localQQAppInterface.getTransFileController().removeProcessor(localQQAppInterface.getTransFileController().makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      ayec localayec = new ayec();
      localayec.a(paramMessageForPic.path);
      localayec.d(5);
      localayec.d(paramMessageForPic.frienduin);
      localayec.b(paramMessageForPic.uniseq);
      if (paramMessageForPic.fileSizeFlag == 1) {
        localayec.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_RAW_PHOTO);
      }
      for (;;)
      {
        localayec.e(paramMessageForPic.senderuin);
        localayec.c(paramMessageForPic.selfuin);
        localayec.e(paramMessageForPic.istroop);
        localayec.jdField_i_of_type_Int = paramMessageForPic.extLong;
        localayec.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
        ayed localayed = new ayed();
        localayed.jdField_a_of_type_Long = paramMessageForPic.msgseq;
        localayed.jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
        localayed.jdField_a_of_type_Long = paramMessageForPic.msgseq;
        localayec.a(localayed);
        paramMessageForPic = aydj.a(4, 5);
        paramMessageForPic.a(localayec.a());
        aydj.a(paramMessageForPic, localQQAppInterface);
        return;
        localayec.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
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
    bahm localbahm = (bahm)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(326);
    localbahm.a(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
    localbahm.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
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
      ayde.a("PresendPicMgrService", "getCancelPercent", " NetType = " + k + ", cancelpercent = " + j);
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
      ayde.a("PresendPicMgrService", "isOverWasteLimit", "PresendStatus : nettype = " + j + " result =  " + bool + ",mWastedUploadFlow = " + this.jdField_b_of_type_Long);
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
      ayde.a("PresendPicMgrService", "getServerConfig", "In VIP list, presendConfigString " + "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50");
    }
    ayde.a("PresendPicMgrService", "getServerConfig", "presendConfigString = " + (String)localObject);
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
      ayde.a("PresendPicMgrService", "getServerConfig", "mEnablePreCompress_WIFI = " + this.jdField_a_of_type_Boolean + "mEnablePreCompress_2G = " + this.jdField_b_of_type_Boolean + "mEnablePreCompress_3G = " + this.jdField_c_of_type_Boolean + "mEnablePreCompress_4G = " + this.jdField_d_of_type_Boolean + "mEnablePreUpload_WIFI = " + this.jdField_e_of_type_Boolean + ",mEnablePreUpload_2G = " + this.jdField_f_of_type_Boolean + ",mEnablePreUpload_3G = " + this.jdField_g_of_type_Boolean + ",mEnablePreUpload_4G = " + this.h + "mPreUpMaxWasteSizeWIFI = " + this.jdField_c_of_type_Long + ", mPreUpMaxWasteSize2G = " + this.jdField_f_of_type_Long + ",mPreUpMaxWasteSize3G = " + this.jdField_e_of_type_Long + ",mPreUpMaxWasteSize4G = " + this.jdField_d_of_type_Long + ",mCancelPercentWIFI = " + this.jdField_b_of_type_Int + ",mCancelPercent2G = " + this.jdField_c_of_type_Int + ",mCancelPercent3G = " + this.jdField_d_of_type_Int + ",mCancelPercent4G = " + this.jdField_e_of_type_Int);
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
    ayde.a("PresendPicMgrService", "sendMsg__ start!", " ");
    jdField_a_of_type_Ayeh = null;
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
        localObject5 = (ayds)localArrayList2.get(j);
        if (((ayds)localObject5).jdField_a_of_type_Ayeb.jdField_c_of_type_Int != 4) {
          break label204;
        }
        ayde.a("PresendPicMgrService", "sendMsg", "FLAG_UPLOADINFO_ERROR do not send! uuid = " + ((ayds)localObject5).jdField_a_of_type_JavaLangString);
        l2 = l1;
        j += 1;
        l1 = l2;
      }
      ayde.a("PresendPicMgrService", "sendMsg__ end!", " ");
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
        synchronized (((ayds)localObject5).jdField_a_of_type_Ayeb)
        {
          for (;;)
          {
            Object localObject7 = ((ayds)localObject5).jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangObject;
            if (localObject7 == null) {}
            try
            {
              ayde.a("PresendPicMgrService", "sendMsg", "start wait! uuid = " + ((ayds)localObject5).jdField_a_of_type_JavaLangString);
              ((ayds)localObject5).jdField_a_of_type_Ayeb.jdField_e_of_type_Boolean = true;
              ((ayds)localObject5).jdField_a_of_type_Ayeb.wait();
              ayde.a("PresendPicMgrService", "sendMsg", "finish wait! uuid = " + ((ayds)localObject5).jdField_a_of_type_JavaLangString);
              ((ayds)localObject5).jdField_a_of_type_Ayeb.jdField_f_of_type_Boolean = true;
              if (((ayds)localObject5).jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangObject == null)
              {
                ayde.b("PresendPicMgrService", "sendMsg", "get MR failed! uuid = " + ((ayds)localObject5).jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangString);
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
      ??? = (MessageRecord)((ayds)localObject5).jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangObject;
      if (this.jdField_a_of_type_Int == 1)
      {
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_album_id", this.jdField_a_of_type_JavaLangString);
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(this.jdField_a_of_type_Long));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(((ayds)localObject5).jdField_a_of_type_Ayeb.jdField_g_of_type_Int));
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
      if (((ayds)localObject5).jdField_a_of_type_Ayeb.jdField_c_of_type_Int != 3) {
        break;
      }
      ayde.a("PresendPicMgrService", "sendMsg", "Pic not upload,reupload! mr = " + ???);
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
          ??? = (ayds)((Iterator)localObject5).next();
          j = ((ayds)???).jdField_a_of_type_Ayeb.jdField_c_of_type_Int;
          localMessageRecord = (MessageRecord)((ayds)???).jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangObject;
          if (!localArrayList2.contains(???)) {
            break label759;
          }
          if (j == 1)
          {
            ayde.a("PresendPicMgrService", "sendMsg", "preupload success,dosend! mr =  " + localMessageRecord);
            ((bahm)((QQAppInterface)localObject4).getManager(326)).a(localMessageRecord, null);
            continue;
          }
          ayde.a("PresendPicMgrService", "sendMsg", "preupload failed,reupload! mr =  " + localMessageRecord);
        }
        finally {}
        a((MessageForPic)localMessageRecord);
        continue;
        label759:
        ayde.a("PresendPicMgrService", "sendMsg", "unselect,do not send mr =  " + localMessageRecord);
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
        bfcw.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localList, l1);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  mSendPaths size=" + localList.size());
      }
    }
  }
  
  public void a(int paramInt)
  {
    ayde.a("PresendPicMgrService", "cancelAll", "cancelType = " + paramInt);
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
    ayde.a("PresendPicMgrService", "cancelUploadReq", " start,localUUID = " + paramString + ", cancelType = " + paramInt);
    ayds localayds = a(this.jdField_a_of_type_JavaUtilArrayList, paramString);
    if (localayds == null)
    {
      ayde.a("PresendPicMgrService", "cancelUploadReq", " find req failed ");
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localayds);
    a(localayds, paramInt);
    ayde.a("PresendPicMgrService", "cancelUploadReq", " end,localUUID = " + paramString);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "presendPic in main process " + paramInt2);
    }
    ayde.a("PresendPicMgrService", "presendPic", "PresendStatus : path = " + paramString1 + ", localUUID = " + paramString2 + ",fileSize = " + FileUtils.getFileSizes(paramString1) + ",entrance = " + paramInt2);
    ayds localayds = aydj.a(2, 1052);
    paramString1 = a(paramString1, paramBoolean, paramInt1, paramInt2);
    localayds.a(paramString1);
    localayds.a(paramString2);
    if (!paramString1.a())
    {
      ayde.b("PresendPicMgrService", paramString2, paramString1.jdField_a_of_type_Aydp.jdField_a_of_type_JavaLangString, paramString1.jdField_a_of_type_Aydp.jdField_b_of_type_JavaLangString);
      paramString1.jdField_c_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilArrayList.add(localayds);
    }
    do
    {
      return;
      localayds.a(new ayei(this, localayds, paramString1));
      if ((!a()) || (b()) || (FileUtils.getFileSizes(localayds.jdField_a_of_type_Ayeb.jdField_g_of_type_JavaLangString) > 512000L))
      {
        ayde.a("PresendPicMgrService", "presendPic", "set FLAG_NOT_UPLOAD!");
        localayds.a(null);
        localayds.jdField_a_of_type_Ayeb.jdField_c_of_type_Int = 3;
      }
      try
      {
        aydj.a(localayds, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString));
        this.jdField_a_of_type_JavaUtilArrayList.add(localayds);
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
      ayde.a("PresendPicMgrService", "isPreuploadEnable", "nettype = " + j + " result =  " + bool);
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
      int[] arrayOfInt = aydj.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString));
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
    ayde.a("PresendPicMgrService", "handletWifi2Mobile", "netType = " + j);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      ayde.a("PresendPicMgrService", "handletWifi2Mobile", "mUploadReqList is Null! ");
    }
    for (;;)
    {
      return;
      Iterator localIterator;
      ayds localayds;
      if (j == 2)
      {
        ayde.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G2,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localayds = (ayds)localIterator.next();
          a(localayds, 1001);
          localayds.jdField_a_of_type_Ayeb.jdField_c_of_type_Int = 3;
        }
      }
      if (((j == 3) || (j == 4)) && (b()))
      {
        ayde.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G3/G4,overWastLimit,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localayds = (ayds)localIterator.next();
          a(localayds, 1002);
          localayds.jdField_a_of_type_Ayeb.jdField_c_of_type_Int = 3;
        }
      }
    }
  }
  
  void c()
  {
    ayde.a("PresendPicMgrService", "resetStatus", "");
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
 * Qualified Name:     ayeh
 * JD-Core Version:    0.7.0.1
 */