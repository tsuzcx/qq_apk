import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.weiyun.utils.Utils;
import cooperation.weiyun.channel.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp;
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

public final class bieh
{
  private static final AtomicBoolean[] a = { new AtomicBoolean(false), new AtomicBoolean(false), new AtomicBoolean(false), new AtomicBoolean(false) };
  
  public static String a(Context paramContext)
  {
    return bifz.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_signature");
  }
  
  public static void a(Context paramContext)
  {
    ThreadManager.executeOnSubThread(new WeiyunApi.1(paramContext));
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    bifz.a(paramContext, String.valueOf(paramLong), "key_pwd_queried");
    bifz.a(paramContext, String.valueOf(paramLong), "key_pwd_has");
    bifz.a(paramContext, String.valueOf(paramLong), "key_pwd_verified");
    a[0].set(false);
    a[1].set(false);
    a[2].set(false);
    a[3].set(false);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    bifz.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_signature", paramString);
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
        bifz.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_queried", Boolean.toString(paramBoolean));
      }
      return;
      bool = false;
    }
  }
  
  public static void a(bieg<WeiyunPB.PwdQueryMsgRsp> parambieg)
  {
    if (parambieg == null) {
      return;
    }
    if (a[0].get())
    {
      WeiyunPB.PwdQueryMsgRsp localPwdQueryMsgRsp = new WeiyunPB.PwdQueryMsgRsp();
      if ((a[1].get()) && (!a[2].get()))
      {
        localPwdQueryMsgRsp.pwd_open.set(true);
        parambieg.a(localPwdQueryMsgRsp);
        return;
      }
      localPwdQueryMsgRsp.pwd_open.set(false);
      parambieg.a(localPwdQueryMsgRsp);
      return;
    }
    bieb.a().a(Integer.toString(11001), a(11001, new WeiyunPB.PwdQueryMsgReq()), new bief(11001, parambieg));
  }
  
  public static void a(WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq paramAioPicAndVideoCopyToWeiyunMsgReq, bieg<WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp> parambieg)
  {
    bieb.a().a(Integer.toString(246001), a(246001, paramAioPicAndVideoCopyToWeiyunMsgReq), new bief(246001, parambieg));
  }
  
  public static void a(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq paramCrossBidProxyCopyFileToOtherBidMsgReq, bieg<WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp> parambieg)
  {
    bieb.a().a(Integer.toString(245700), a(245700, paramCrossBidProxyCopyFileToOtherBidMsgReq), new bief(245700, parambieg));
  }
  
  public static void a(WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq paramCrossBidProxyOfflineFileGetListMsgReq, bieg<WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp> parambieg)
  {
    bieb.a().a(Integer.toString(245706), a(245706, paramCrossBidProxyOfflineFileGetListMsgReq), new bief(245706, parambieg));
  }
  
  public static void a(WeiyunPB.DiskDirFileBatchDeleteExMsgReq paramDiskDirFileBatchDeleteExMsgReq, bieg<WeiyunPB.DiskDirFileBatchDeleteExMsgRsp> parambieg)
  {
    bieb.a().a(Integer.toString(2509), a(2509, paramDiskDirFileBatchDeleteExMsgReq), new bief(2509, parambieg));
  }
  
  public static void a(WeiyunPB.DiskFileBatchDownloadMsgReq paramDiskFileBatchDownloadMsgReq, bieg<WeiyunPB.DiskFileBatchDownloadMsgRsp> parambieg)
  {
    bieb.a().a(Integer.toString(2402), a(2402, paramDiskFileBatchDownloadMsgReq), new bief(2402, parambieg));
  }
  
  public static void a(WeiyunPB.DiskFileDocDownloadAbsMsgReq paramDiskFileDocDownloadAbsMsgReq, bieg<WeiyunPB.DiskFileDocDownloadAbsMsgRsp> parambieg)
  {
    bieb.a().a(Integer.toString(2414), a(2414, paramDiskFileDocDownloadAbsMsgReq), new bief(2414, parambieg));
  }
  
  public static void a(WeiyunPB.DiskPicBackupReq paramDiskPicBackupReq, bieg<WeiyunPB.DiskPicBackupRsp> parambieg)
  {
    bieb.a().a(Integer.toString(2803), a(2803, paramDiskPicBackupReq), new bief(2803, parambieg));
  }
  
  public static void a(WeiyunPB.LibInfoListGetMsgReq paramLibInfoListGetMsgReq, bieg<WeiyunPB.LibInfoListGetMsgRsp> parambieg)
  {
    bieb.a().a(Integer.toString(26113), a(26113, paramLibInfoListGetMsgReq), new bief(26113, parambieg));
  }
  
  public static void a(WeiyunPB.PwdVerifyMsgReq paramPwdVerifyMsgReq, bieg<WeiyunPB.PwdVerifyMsgRsp> parambieg)
  {
    bieb.a().a(Integer.toString(11005), a(11005, paramPwdVerifyMsgReq), new bief(11005, parambieg));
  }
  
  public static void a(WeiyunPB.QqSdkFileUploadMsgReq paramQqSdkFileUploadMsgReq, bieg<WeiyunPB.QqSdkFileUploadMsgRsp> parambieg)
  {
    bieb.a().a(Integer.toString(246000), a(246000, paramQqSdkFileUploadMsgReq), new bief(246000, parambieg));
  }
  
  public static void a(WeiyunPB.WeiyunShareAddFromMobileQQMsgReq paramWeiyunShareAddFromMobileQQMsgReq, bieg<WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp> parambieg)
  {
    bieb.a().a(Integer.toString(12102), a(12102, paramWeiyunShareAddFromMobileQQMsgReq), new bief(12102, parambieg));
  }
  
  public static void a(WeiyunPB.WeiyunTrialCouponUseMsgReq paramWeiyunTrialCouponUseMsgReq, bieg<WeiyunPB.WeiyunTrialCouponUseMsgRsp> parambieg)
  {
    bieb.a().a(Integer.toString(245520), a(245520, paramWeiyunTrialCouponUseMsgReq), new bief(245520, parambieg));
  }
  
  public static void a(String paramString, bieg<WeiyunPB.PwdVerifyMsgRsp> parambieg)
  {
    WeiyunPB.PwdVerifyMsgReq localPwdVerifyMsgReq = new WeiyunPB.PwdVerifyMsgReq();
    paramString = Utils.bytes2HexStr(Utils.str2Md5(paramString));
    localPwdVerifyMsgReq.pwd_md5.set(bige.a(paramString));
    a(localPwdVerifyMsgReq, parambieg);
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
        bifz.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_has", Boolean.toString(paramBoolean));
      }
      return;
      bool = false;
    }
  }
  
  public static void b(String paramString, bieg<WeiyunPB.PwdVerifyMsgRsp> parambieg)
  {
    WeiyunPB.PwdVerifyMsgReq localPwdVerifyMsgReq = new WeiyunPB.PwdVerifyMsgReq();
    localPwdVerifyMsgReq.cs_sig.set(bige.a(paramString));
    a(localPwdVerifyMsgReq, parambieg);
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
        bifz.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_verified", Boolean.toString(paramBoolean));
      }
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bieh
 * JD-Core Version:    0.7.0.1
 */