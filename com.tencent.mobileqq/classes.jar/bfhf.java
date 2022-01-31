import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare.StTemplateInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import java.util.concurrent.TimeUnit;

public class bfhf
{
  public static MiniProgramShare.StAdaptShareInfoReq a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, String paramString5, String paramString6, String paramString7, COMM.StCommonExt paramStCommonExt, int paramInt5, String paramString8, int paramInt6, boolean paramBoolean, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    MiniProgramShare.StAdaptShareInfoReq localStAdaptShareInfoReq = new MiniProgramShare.StAdaptShareInfoReq();
    if (paramString1 != null) {
      localStAdaptShareInfoReq.appid.set(paramString1);
    }
    if (paramString2 != null) {
      localStAdaptShareInfoReq.title.set(paramString2);
    }
    if (paramString3 != null) {
      localStAdaptShareInfoReq.desc.set(paramString3);
    }
    localStAdaptShareInfoReq.time.set(paramInt1);
    localStAdaptShareInfoReq.scene.set(paramInt2);
    localStAdaptShareInfoReq.templetType.set(paramInt3);
    localStAdaptShareInfoReq.businessType.set(paramInt4);
    if (paramString4 != null) {
      localStAdaptShareInfoReq.picUrl.set(paramString4);
    }
    if (paramString5 != null) {
      localStAdaptShareInfoReq.vidUrl.set(paramString5);
    }
    if (paramString6 != null) {
      localStAdaptShareInfoReq.jumpUrl.set(paramString6);
    }
    if (paramString7 != null) {
      localStAdaptShareInfoReq.iconUrl.set(paramString7);
    }
    if (paramStCommonExt != null) {
      localStAdaptShareInfoReq.extInfo.set(paramStCommonExt);
    }
    localStAdaptShareInfoReq.verType.set(paramInt5);
    if (paramString8 != null) {
      localStAdaptShareInfoReq.versionId.set(paramString8);
    }
    localStAdaptShareInfoReq.shareType.set(paramInt6);
    paramString1 = localStAdaptShareInfoReq.withShareTicket;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.set(paramInt1);
      if (paramString9 != null) {
        localStAdaptShareInfoReq.webURL.set(paramString9);
      }
      if (paramString10 != null) {
        localStAdaptShareInfoReq.appidRich.set(paramString10);
      }
      if ((paramString11 != null) && (paramString12 != null))
      {
        paramString1 = new MiniProgramShare.StTemplateInfo();
        paramString1.templateId.set(paramString11);
        paramString1.templateData.set(paramString12);
        localStAdaptShareInfoReq.template.set(paramString1);
      }
      if ((paramInt6 == 5) && (paramString13 != null)) {
        localStAdaptShareInfoReq.rcvOpenId.set(paramString13);
      }
      return localStAdaptShareInfoReq;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4, String paramString8, String paramString9, String paramString10, int paramInt5, AsyncResult paramAsyncResult)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getShareInfo(a(paramString1, paramString2, paramString3, (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7, null, paramInt4, paramString8, paramInt5, false, null, paramString10, null, null, paramString9), paramAsyncResult);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4, String paramString8, String paramString9, String paramString10, AsyncResult paramAsyncResult)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getShareInfo(a(paramString1, paramString2, paramString3, (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7, null, paramInt4, paramString8, 1, false, null, paramString10, null, null, paramString9), paramAsyncResult);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4, String paramString8, String paramString9, boolean paramBoolean, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt5, AsyncResult paramAsyncResult)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getShareInfo(a(paramString1, paramString2, paramString3, (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7, null, paramInt4, paramString8, paramInt5, paramBoolean, paramString9, paramString13, paramString10, paramString11, paramString12), paramAsyncResult);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4, String paramString8, String paramString9, String paramString10, AsyncResult paramAsyncResult)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getShareInfo(a(paramString1, paramString2, paramString3, (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7, null, paramInt4, paramString8, 6, false, null, paramString10, null, null, paramString9), paramAsyncResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfhf
 * JD-Core Version:    0.7.0.1
 */