import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import cooperation.weiyun.channel.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskAlbumStatusReportReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileBatchDownloadMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileBatchDownloadMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileDocDownloadAbsMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileDocDownloadAbsMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskPicBackupReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskPicBackupRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.LibInfoListGetMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.LibInfoListGetMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgBody;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdQueryMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdQueryMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdVerifyMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdVerifyMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.QqSdkFileUploadMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.QqSdkFileUploadMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.ReqMsgBody;
import cooperation.weiyun.channel.pb.WeiyunPB.WeiyunShareAddFromMobileQQMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.WeiyunTrialCouponUseMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.WeiyunTrialCouponUseMsgRsp;
import cooperation.weiyun.sdk.api.WeiyunApi.1;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public final class bmsd
{
  private static final AtomicBoolean[] a = { new AtomicBoolean(false), new AtomicBoolean(false), new AtomicBoolean(false), new AtomicBoolean(false) };
  
  public static String a(Context paramContext)
  {
    return bmtv.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_md5");
  }
  
  public static void a(Context paramContext)
  {
    ThreadManager.executeOnSubThread(new WeiyunApi.1(paramContext));
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    bmtv.a(paramContext, String.valueOf(paramLong), "key_pwd_queried");
    bmtv.a(paramContext, String.valueOf(paramLong), "key_pwd_has");
    bmtv.a(paramContext, String.valueOf(paramLong), "key_pwd_verified");
    a[0].set(false);
    a[1].set(false);
    a[2].set(false);
    a[3].set(false);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    bmtv.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_md5", paramString);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    a[3].set(true);
    AtomicBoolean localAtomicBoolean = a[0];
    if (!paramBoolean) {}
    for (;;)
    {
      if (localAtomicBoolean.compareAndSet(bool, paramBoolean)) {
        bmtv.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_queried", Boolean.toString(paramBoolean));
      }
      return;
      bool = false;
    }
  }
  
  public static void a(bmsc<WeiyunPB.PwdQueryMsgRsp> parambmsc)
  {
    if (parambmsc == null) {
      return;
    }
    if (a[0].get())
    {
      WeiyunPB.PwdQueryMsgRsp localPwdQueryMsgRsp = new WeiyunPB.PwdQueryMsgRsp();
      if ((a[1].get()) && (!a[2].get()))
      {
        localPwdQueryMsgRsp.pwd_open.set(true);
        parambmsc.a(localPwdQueryMsgRsp);
        return;
      }
      localPwdQueryMsgRsp.pwd_open.set(false);
      parambmsc.a(localPwdQueryMsgRsp);
      return;
    }
    bmrx.a().a(Integer.toString(11001), a(11001, new WeiyunPB.PwdQueryMsgReq()), new bmsb(11001, parambmsc));
  }
  
  public static void a(WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq paramAioPicAndVideoCopyToWeiyunMsgReq, bmsc<WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp> parambmsc)
  {
    bmrx.a().a(Integer.toString(246001), a(246001, paramAioPicAndVideoCopyToWeiyunMsgReq), new bmsb(246001, parambmsc));
  }
  
  public static void a(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq paramCrossBidProxyCopyFileToOtherBidMsgReq, bmsc<WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp> parambmsc)
  {
    bmrx.a().a(Integer.toString(245700), a(245700, paramCrossBidProxyCopyFileToOtherBidMsgReq), new bmsb(245700, parambmsc));
  }
  
  public static void a(WeiyunPB.DiskDirFileBatchDeleteExMsgReq paramDiskDirFileBatchDeleteExMsgReq, bmsc<WeiyunPB.DiskDirFileBatchDeleteExMsgRsp> parambmsc)
  {
    bmrx.a().a(Integer.toString(2509), a(2509, paramDiskDirFileBatchDeleteExMsgReq), new bmsb(2509, parambmsc));
  }
  
  public static void a(WeiyunPB.DiskFileBatchDownloadMsgReq paramDiskFileBatchDownloadMsgReq, bmsc<WeiyunPB.DiskFileBatchDownloadMsgRsp> parambmsc)
  {
    bmrx.a().a(Integer.toString(2402), a(2402, paramDiskFileBatchDownloadMsgReq), new bmsb(2402, parambmsc));
  }
  
  public static void a(WeiyunPB.DiskFileDocDownloadAbsMsgReq paramDiskFileDocDownloadAbsMsgReq, bmsc<WeiyunPB.DiskFileDocDownloadAbsMsgRsp> parambmsc)
  {
    bmrx.a().a(Integer.toString(2414), a(2414, paramDiskFileDocDownloadAbsMsgReq), new bmsb(2414, parambmsc));
  }
  
  public static void a(WeiyunPB.DiskPicBackupReq paramDiskPicBackupReq, bmsc<WeiyunPB.DiskPicBackupRsp> parambmsc)
  {
    bmrx.a().a(Integer.toString(2803), a(2803, paramDiskPicBackupReq), new bmsb(2803, parambmsc));
  }
  
  public static void a(WeiyunPB.LibInfoListGetMsgReq paramLibInfoListGetMsgReq, bmsc<WeiyunPB.LibInfoListGetMsgRsp> parambmsc)
  {
    bmrx.a().a(Integer.toString(26113), a(26113, paramLibInfoListGetMsgReq), new bmsb(26113, parambmsc));
  }
  
  public static void a(WeiyunPB.PwdVerifyMsgReq paramPwdVerifyMsgReq, bmsc<WeiyunPB.PwdVerifyMsgRsp> parambmsc)
  {
    bmrx.a().a(Integer.toString(11005), a(11005, paramPwdVerifyMsgReq), new bmsb(11005, parambmsc));
  }
  
  public static void a(WeiyunPB.QqSdkFileUploadMsgReq paramQqSdkFileUploadMsgReq, bmsc<WeiyunPB.QqSdkFileUploadMsgRsp> parambmsc)
  {
    bmrx.a().a(Integer.toString(246000), a(246000, paramQqSdkFileUploadMsgReq), new bmsb(246000, parambmsc));
  }
  
  public static void a(WeiyunPB.WeiyunShareAddFromMobileQQMsgReq paramWeiyunShareAddFromMobileQQMsgReq, bmsc<WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp> parambmsc)
  {
    bmrx.a().a(Integer.toString(12102), a(12102, paramWeiyunShareAddFromMobileQQMsgReq), new bmsb(12102, parambmsc));
  }
  
  public static void a(WeiyunPB.WeiyunTrialCouponUseMsgReq paramWeiyunTrialCouponUseMsgReq, bmsc<WeiyunPB.WeiyunTrialCouponUseMsgRsp> parambmsc)
  {
    bmrx.a().a(Integer.toString(245520), a(245520, paramWeiyunTrialCouponUseMsgReq), new bmsb(245520, parambmsc));
  }
  
  public static void a(String paramString, bmsc<WeiyunPB.PwdVerifyMsgRsp> parambmsc)
  {
    WeiyunPB.PwdVerifyMsgReq localPwdVerifyMsgReq = new WeiyunPB.PwdVerifyMsgReq();
    localPwdVerifyMsgReq.pwd_md5.set(bmua.a(paramString));
    a(localPwdVerifyMsgReq, parambmsc);
  }
  
  public static boolean a()
  {
    return a[0].get();
  }
  
  static byte[] a(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    WeiyunPB.MsgBody localMsgBody = new WeiyunPB.MsgBody();
    WeiyunPB.ReqMsgBody localReqMsgBody = new WeiyunPB.ReqMsgBody();
    switch (paramInt)
    {
    }
    for (;;)
    {
      localMsgBody.ReqMsg_body = localReqMsgBody;
      localMsgBody.ReqMsg_body.setHasFlag(true);
      localMsgBody.setHasFlag(true);
      return localMsgBody.toByteArray();
      localReqMsgBody.LibInfoListGetMsgReq_body.set((WeiyunPB.LibInfoListGetMsgReq)paramObject);
      continue;
      localReqMsgBody.DiskFileBatchDownloadMsgReq_body.set((WeiyunPB.DiskFileBatchDownloadMsgReq)paramObject);
      continue;
      localReqMsgBody.DiskFileDocDownloadAbsMsgReq_body.set((WeiyunPB.DiskFileDocDownloadAbsMsgReq)paramObject);
      continue;
      localReqMsgBody.DiskDirFileBatchDeleteExMsgReq_body.set((WeiyunPB.DiskDirFileBatchDeleteExMsgReq)paramObject);
      continue;
      localReqMsgBody.DiskPicBackupReq_body.set((WeiyunPB.DiskPicBackupReq)paramObject);
      continue;
      localReqMsgBody.DiskAlbumStatusReportReq_body.set((WeiyunPB.DiskAlbumStatusReportReq)paramObject);
      continue;
      localReqMsgBody.PwdQueryMsgReq_body.set((WeiyunPB.PwdQueryMsgReq)paramObject);
      continue;
      localReqMsgBody.PwdVerifyMsgReq_body.set((WeiyunPB.PwdVerifyMsgReq)paramObject);
      continue;
      localReqMsgBody.CrossBidProxyCopyFileToOtherBidMsgReq_body.set((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)paramObject);
      continue;
      localReqMsgBody.CrossBidProxyOfflineFileGetListMsgReq_body.set((WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq)paramObject);
      continue;
      localReqMsgBody.QqSdkFileUploadMsgReq_body.set((WeiyunPB.QqSdkFileUploadMsgReq)paramObject);
      continue;
      localReqMsgBody.AioPicAndVideoCopyToWeiyunMsgReq_body.set((WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq)paramObject);
      continue;
      localReqMsgBody.WeiyunTrialCouponUseMsgReq_body.set((WeiyunPB.WeiyunTrialCouponUseMsgReq)paramObject);
      continue;
      localReqMsgBody.WeiyunShareAddFromMobileQQMsgReq_body.set((WeiyunPB.WeiyunShareAddFromMobileQQMsgReq)paramObject);
    }
  }
  
  public static void b(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    a[3].set(true);
    AtomicBoolean localAtomicBoolean = a[1];
    if (!paramBoolean) {}
    for (;;)
    {
      if (localAtomicBoolean.compareAndSet(bool, paramBoolean)) {
        bmtv.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_has", Boolean.toString(paramBoolean));
      }
      return;
      bool = false;
    }
  }
  
  public static void c(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    a[3].set(true);
    AtomicBoolean localAtomicBoolean = a[2];
    if (!paramBoolean) {}
    for (;;)
    {
      if (localAtomicBoolean.compareAndSet(bool, paramBoolean)) {
        bmtv.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_verified", Boolean.toString(paramBoolean));
      }
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsd
 * JD-Core Version:    0.7.0.1
 */