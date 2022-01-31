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

public final class bkgd
{
  private static final AtomicBoolean[] a = { new AtomicBoolean(false), new AtomicBoolean(false), new AtomicBoolean(false), new AtomicBoolean(false) };
  
  public static String a(Context paramContext)
  {
    return bkhv.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_signature");
  }
  
  public static void a(Context paramContext)
  {
    ThreadManager.executeOnSubThread(new WeiyunApi.1(paramContext));
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    bkhv.a(paramContext, String.valueOf(paramLong), "key_pwd_queried");
    bkhv.a(paramContext, String.valueOf(paramLong), "key_pwd_has");
    bkhv.a(paramContext, String.valueOf(paramLong), "key_pwd_verified");
    a[0].set(false);
    a[1].set(false);
    a[2].set(false);
    a[3].set(false);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    bkhv.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_signature", paramString);
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
        bkhv.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_queried", Boolean.toString(paramBoolean));
      }
      return;
      bool = false;
    }
  }
  
  public static void a(bkgc<WeiyunPB.PwdQueryMsgRsp> parambkgc)
  {
    if (parambkgc == null) {
      return;
    }
    if (a[0].get())
    {
      WeiyunPB.PwdQueryMsgRsp localPwdQueryMsgRsp = new WeiyunPB.PwdQueryMsgRsp();
      if ((a[1].get()) && (!a[2].get()))
      {
        localPwdQueryMsgRsp.pwd_open.set(true);
        parambkgc.a(localPwdQueryMsgRsp);
        return;
      }
      localPwdQueryMsgRsp.pwd_open.set(false);
      parambkgc.a(localPwdQueryMsgRsp);
      return;
    }
    bkfx.a().a(Integer.toString(11001), a(11001, new WeiyunPB.PwdQueryMsgReq()), new bkgb(11001, parambkgc));
  }
  
  public static void a(WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq paramAioPicAndVideoCopyToWeiyunMsgReq, bkgc<WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp> parambkgc)
  {
    bkfx.a().a(Integer.toString(246001), a(246001, paramAioPicAndVideoCopyToWeiyunMsgReq), new bkgb(246001, parambkgc));
  }
  
  public static void a(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq paramCrossBidProxyCopyFileToOtherBidMsgReq, bkgc<WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp> parambkgc)
  {
    bkfx.a().a(Integer.toString(245700), a(245700, paramCrossBidProxyCopyFileToOtherBidMsgReq), new bkgb(245700, parambkgc));
  }
  
  public static void a(WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq paramCrossBidProxyOfflineFileGetListMsgReq, bkgc<WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp> parambkgc)
  {
    bkfx.a().a(Integer.toString(245706), a(245706, paramCrossBidProxyOfflineFileGetListMsgReq), new bkgb(245706, parambkgc));
  }
  
  public static void a(WeiyunPB.DiskDirFileBatchDeleteExMsgReq paramDiskDirFileBatchDeleteExMsgReq, bkgc<WeiyunPB.DiskDirFileBatchDeleteExMsgRsp> parambkgc)
  {
    bkfx.a().a(Integer.toString(2509), a(2509, paramDiskDirFileBatchDeleteExMsgReq), new bkgb(2509, parambkgc));
  }
  
  public static void a(WeiyunPB.DiskFileBatchDownloadMsgReq paramDiskFileBatchDownloadMsgReq, bkgc<WeiyunPB.DiskFileBatchDownloadMsgRsp> parambkgc)
  {
    bkfx.a().a(Integer.toString(2402), a(2402, paramDiskFileBatchDownloadMsgReq), new bkgb(2402, parambkgc));
  }
  
  public static void a(WeiyunPB.DiskFileDocDownloadAbsMsgReq paramDiskFileDocDownloadAbsMsgReq, bkgc<WeiyunPB.DiskFileDocDownloadAbsMsgRsp> parambkgc)
  {
    bkfx.a().a(Integer.toString(2414), a(2414, paramDiskFileDocDownloadAbsMsgReq), new bkgb(2414, parambkgc));
  }
  
  public static void a(WeiyunPB.DiskPicBackupReq paramDiskPicBackupReq, bkgc<WeiyunPB.DiskPicBackupRsp> parambkgc)
  {
    bkfx.a().a(Integer.toString(2803), a(2803, paramDiskPicBackupReq), new bkgb(2803, parambkgc));
  }
  
  public static void a(WeiyunPB.LibInfoListGetMsgReq paramLibInfoListGetMsgReq, bkgc<WeiyunPB.LibInfoListGetMsgRsp> parambkgc)
  {
    bkfx.a().a(Integer.toString(26113), a(26113, paramLibInfoListGetMsgReq), new bkgb(26113, parambkgc));
  }
  
  public static void a(WeiyunPB.PwdVerifyMsgReq paramPwdVerifyMsgReq, bkgc<WeiyunPB.PwdVerifyMsgRsp> parambkgc)
  {
    bkfx.a().a(Integer.toString(11005), a(11005, paramPwdVerifyMsgReq), new bkgb(11005, parambkgc));
  }
  
  public static void a(WeiyunPB.QqSdkFileUploadMsgReq paramQqSdkFileUploadMsgReq, bkgc<WeiyunPB.QqSdkFileUploadMsgRsp> parambkgc)
  {
    bkfx.a().a(Integer.toString(246000), a(246000, paramQqSdkFileUploadMsgReq), new bkgb(246000, parambkgc));
  }
  
  public static void a(WeiyunPB.WeiyunShareAddFromMobileQQMsgReq paramWeiyunShareAddFromMobileQQMsgReq, bkgc<WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp> parambkgc)
  {
    bkfx.a().a(Integer.toString(12102), a(12102, paramWeiyunShareAddFromMobileQQMsgReq), new bkgb(12102, parambkgc));
  }
  
  public static void a(WeiyunPB.WeiyunTrialCouponUseMsgReq paramWeiyunTrialCouponUseMsgReq, bkgc<WeiyunPB.WeiyunTrialCouponUseMsgRsp> parambkgc)
  {
    bkfx.a().a(Integer.toString(245520), a(245520, paramWeiyunTrialCouponUseMsgReq), new bkgb(245520, parambkgc));
  }
  
  public static void a(String paramString, bkgc<WeiyunPB.PwdVerifyMsgRsp> parambkgc)
  {
    WeiyunPB.PwdVerifyMsgReq localPwdVerifyMsgReq = new WeiyunPB.PwdVerifyMsgReq();
    paramString = Utils.bytes2HexStr(Utils.str2Md5(paramString));
    localPwdVerifyMsgReq.pwd_md5.set(bkia.a(paramString));
    a(localPwdVerifyMsgReq, parambkgc);
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
        bkhv.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_has", Boolean.toString(paramBoolean));
      }
      return;
      bool = false;
    }
  }
  
  public static void b(String paramString, bkgc<WeiyunPB.PwdVerifyMsgRsp> parambkgc)
  {
    WeiyunPB.PwdVerifyMsgReq localPwdVerifyMsgReq = new WeiyunPB.PwdVerifyMsgReq();
    localPwdVerifyMsgReq.cs_sig.set(bkia.a(paramString));
    a(localPwdVerifyMsgReq, parambkgc);
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
        bkhv.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_verified", Boolean.toString(paramBoolean));
      }
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgd
 * JD-Core Version:    0.7.0.1
 */