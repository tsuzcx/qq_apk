package com.tencent.aelight.camera.ae.cmshow;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.protobuf.AEPbData.CartoonPtaRequest;
import com.tencent.aelight.camera.ae.protobuf.AEPbData.CartoonPtaResponse;
import com.tencent.aelight.camera.ae.protobuf.AEPbData.DressItem;
import com.tencent.aelight.camera.ae.protobuf.AEPbData.FaceAttr;
import com.tencent.aelight.camera.ae.protobuf.AEPbData.ImageInfo;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.api.IApolloIPCHelper;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class AECMShowRequestController
{
  private int a;
  private AECMShowRequestController.Callback b;
  private int c;
  private Runnable d = new AECMShowRequestController.1(this);
  private HttpNetReq e;
  
  public AECMShowRequestController(int paramInt, @Nullable AECMShowRequestController.Callback paramCallback)
  {
    this.a = paramInt;
    if (paramCallback != null) {
      this.b = paramCallback;
    }
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 736;
    }
    paramInt = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = Math.max(paramInt, j);
    float f = 1.0F;
    if (k > i) {
      f = i * 1.0F / k;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f, f);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramInt, j, localMatrix, true);
  }
  
  @NonNull
  private String a(@NonNull AEPbData.CartoonPtaResponse paramCartoonPtaResponse)
  {
    return AECMShowJsonModel.convertModel2JsonString(AECMShowJsonModel.convertFromPbData(paramCartoonPtaResponse));
  }
  
  private HashMap<String, String> a(@NonNull HashMap<Integer, String> paramHashMap1, @NonNull HashMap<Integer, String> paramHashMap2)
  {
    HashMap localHashMap = new HashMap();
    paramHashMap2 = paramHashMap2.entrySet().iterator();
    while (paramHashMap2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap2.next();
      if (localEntry != null) {
        localHashMap.put(paramHashMap1.get(localEntry.getKey()), localEntry.getValue());
      }
    }
    return localHashMap;
  }
  
  private Map<String, Integer> a(@NonNull List<AEPbData.DressItem> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AEPbData.DressItem localDressItem = (AEPbData.DressItem)paramList.next();
      if (localDressItem.id.get() > 0) {
        localHashMap.put(localDressItem.name.get(), Integer.valueOf(localDressItem.id.get()));
      }
    }
    return localHashMap;
  }
  
  private void a(int paramInt, @NonNull HashMap<String, String> paramHashMap, @NonNull String paramString, @NonNull Map<String, Integer> paramMap)
  {
    ((IApolloIPCHelper)QRoute.api(IApolloIPCHelper.class)).getApolloRoleInfo(paramInt, 0, new AECMShowRequestController.5(this, paramHashMap, paramMap, paramString));
  }
  
  private void a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AEQLog.b("AECMShowRequestController", "realDoSendCartoonRequest");
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new AECMShowRequestController.3(this);
    localHttpNetReq.mReqUrl = "https://api.shadowai.qq.com/trpc.mobile_qq_http.mobile_qq_http_cgi.MobileQQHttpCgi/CartoonPta";
    localHttpNetReq.mHttpMethod = 1;
    localHttpNetReq.mExcuteTimeLimit = 30000L;
    localHttpNetReq.mSendData = b(paramBitmap, paramInt1, paramInt2);
    localHttpNetReq.mPrioty = 0;
    localHttpNetReq.mReqProperties.put("Content-Type", "application/proto; charset=UTF-8");
    localHttpNetReq.mReqProperties.put("Accept", "application/proto");
    paramBitmap = BaseApplicationImpl.getApplication().getRuntime();
    if (paramBitmap == null)
    {
      AEQLog.d("AECMShowRequestController", "appRuntime is null");
      paramBitmap = this.b;
      if (paramBitmap != null) {
        paramBitmap.a(2, null);
      }
      return;
    }
    Object localObject2 = (TicketManager)paramBitmap.getManager(2);
    paramBitmap = paramBitmap.getAccount();
    Object localObject1 = ((TicketManager)localObject2).getSkey(paramBitmap);
    localObject2 = ((TicketManager)localObject2).getPskey(paramBitmap, "shadowai.qq.com");
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localHttpNetReq.mReqProperties;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramBitmap);
      localStringBuilder.append(";pskey=");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(";qqversion=");
      localStringBuilder.append("8.8.17");
      localStringBuilder.append(";aekitversion=");
      localStringBuilder.append("2.6.0.23");
      localStringBuilder.append(";platform=");
      localStringBuilder.append("Android");
      ((HashMap)localObject1).put("Cookie", localStringBuilder.toString());
    }
    else
    {
      c();
      localObject2 = localHttpNetReq.mReqProperties;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramBitmap);
      localStringBuilder.append(";skey=");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(";qqversion=");
      localStringBuilder.append("8.8.17");
      localStringBuilder.append(";aekitversion=");
      localStringBuilder.append("2.6.0.23");
      localStringBuilder.append(";platform=");
      localStringBuilder.append("Android");
      ((HashMap)localObject2).put("Cookie", localStringBuilder.toString());
    }
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    paramBitmap = e();
    if (paramBitmap != null)
    {
      ((IHttpEngineService)paramBitmap.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
      this.e = localHttpNetReq;
      this.c = 1;
      paramBitmap = this.b;
      if (paramBitmap != null) {
        paramBitmap.d(this.c);
      }
      if (this.d != null)
      {
        ThreadManager.getUIHandler().removeCallbacks(this.d);
        ThreadManager.getUIHandler().postDelayed(this.d, 150L);
      }
    }
    else
    {
      AEQLog.d("AECMShowRequestController", "[sendRequest] peakAppInterface is null");
      if (this.d != null) {
        ThreadManager.getUIHandler().removeCallbacks(this.d);
      }
      paramBitmap = this.b;
      if (paramBitmap != null) {
        paramBitmap.a(2, null);
      }
    }
  }
  
  private void a(@NonNull NetResp paramNetResp)
  {
    AEPbData.CartoonPtaResponse localCartoonPtaResponse = new AEPbData.CartoonPtaResponse();
    for (;;)
    {
      try
      {
        localCartoonPtaResponse.mergeFrom(paramNetResp.mRespData);
        if ((localCartoonPtaResponse.code != null) && (localCartoonPtaResponse.code.get() != 1001) && (localCartoonPtaResponse.code.get() != 1005) && (localCartoonPtaResponse.dressList != null) && (!CollectionUtils.isEmpty(localCartoonPtaResponse.dressList.get())) && (localCartoonPtaResponse.faceAttr != null) && (localCartoonPtaResponse.faceAttr.get() != null) && (((AEPbData.FaceAttr)localCartoonPtaResponse.faceAttr.get()).roleID != null))
        {
          AEQLog.a("AECMShowRequestController", "[processCartonResponse] valid dressList");
          String str = a(localCartoonPtaResponse);
          if (this.a == 1)
          {
            a(localCartoonPtaResponse.dressList.get(), ((AEPbData.FaceAttr)localCartoonPtaResponse.faceAttr.get()).roleID.get(), str);
          }
          else if (this.a == 2)
          {
            if (this.d != null) {
              ThreadManager.getUIHandler().removeCallbacks(this.d);
            }
            if (this.b != null)
            {
              this.c = 100;
              this.b.d(this.c);
              CmShowDataWrapper localCmShowDataWrapper = new CmShowDataWrapper();
              localCmShowDataWrapper.sceneMode = this.a;
              localCmShowDataWrapper.dressidMaps = a(localCartoonPtaResponse.dressList.get());
              localCmShowDataWrapper.cmJsonString = str;
              this.b.a(1, localCmShowDataWrapper);
            }
          }
        }
        else
        {
          AEQLog.a("AECMShowRequestController", "[processCartonResponse] dressList is empty");
          if (localCartoonPtaResponse.code != null)
          {
            if (localCartoonPtaResponse.code.get() == 1001)
            {
              i = 3;
            }
            else
            {
              if (localCartoonPtaResponse.code.get() != 1005) {
                break label461;
              }
              i = 4;
            }
            if (this.d != null) {
              ThreadManager.getUIHandler().removeCallbacks(this.d);
            }
            if (this.b != null) {
              this.b.a(i, null);
            }
          }
          else
          {
            if (this.d != null) {
              ThreadManager.getUIHandler().removeCallbacks(this.d);
            }
            if (this.b != null) {
              this.b.a(2, null);
            }
          }
        }
        AEBaseDataReporter.a().a(1000, String.valueOf(paramNetResp.reqCost), "CartoonPta", localCartoonPtaResponse.code.get());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramNetResp)
      {
        AEQLog.a("AECMShowRequestController", "[processCartonResponse] e=", paramNetResp);
        if (this.d != null) {
          ThreadManager.getUIHandler().removeCallbacks(this.d);
        }
        paramNetResp = this.b;
        if (paramNetResp != null) {
          paramNetResp.a(2, null);
        }
        return;
      }
      label461:
      int i = 2;
    }
  }
  
  private void a(@NonNull List<AEPbData.DressItem> paramList, int paramInt, @NonNull String paramString)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AEPbData.DressItem localDressItem = (AEPbData.DressItem)localIterator.next();
      if (localDressItem.id.get() > 0) {
        localHashMap.put(Integer.valueOf(localDressItem.id.get()), localDressItem.name.get());
      }
    }
    ((IApolloIPCHelper)QRoute.api(IApolloIPCHelper.class)).getApolloDressInfo(new ArrayList(localHashMap.keySet()), 0, new AECMShowRequestController.4(this, localHashMap, paramList, paramInt, paramString));
  }
  
  private byte[] b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject1 = new ByteArrayOutputStream();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("before: ");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(", uploadMaxSize=");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(", src bitmap size=[");
    ((StringBuilder)localObject2).append(paramBitmap.getWidth());
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(paramBitmap.getHeight());
    ((StringBuilder)localObject2).append("]");
    AEQLog.b("AECMShowRequestController", ((StringBuilder)localObject2).toString());
    paramBitmap = a(paramBitmap, paramInt1);
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt2, (OutputStream)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("after: ");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(", scaled bitmap size=[");
    ((StringBuilder)localObject2).append(paramBitmap.getWidth());
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(paramBitmap.getHeight());
    ((StringBuilder)localObject2).append("]");
    AEQLog.b("AECMShowRequestController", ((StringBuilder)localObject2).toString());
    localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
    localObject2 = new AEPbData.CartoonPtaRequest();
    ((AEPbData.CartoonPtaRequest)localObject2).img.setHasFlag(true);
    ((AEPbData.CartoonPtaRequest)localObject2).img.imgWidth.set(paramBitmap.getWidth());
    ((AEPbData.CartoonPtaRequest)localObject2).img.imgHeight.set(paramBitmap.getHeight());
    ((AEPbData.CartoonPtaRequest)localObject2).img.imageRawData.set(ByteStringMicro.copyFrom((byte[])localObject1), true);
    BitmapUtils.recycle(paramBitmap);
    ((AEPbData.CartoonPtaRequest)localObject2).setHasFlag(true);
    return ((AEPbData.CartoonPtaRequest)localObject2).toByteArray();
  }
  
  private void c()
  {
    if (!TextUtils.isEmpty(d()))
    {
      AEQLog.b("AECMShowRequestController", "psKey not empty.");
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
    localObject = ((AppRuntime)localObject).getAccount();
    AECMShowRequestController.6 local6 = new AECMShowRequestController.6(this);
    localTicketManager.getPskey((String)localObject, 16L, new String[] { "shadowai.qq.com" }, local6);
  }
  
  private String d()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      AEQLog.d("AECMShowRequestController", "appRuntime is null");
      return "";
    }
    String str = localAppRuntime.getAccount();
    return ((TicketManager)localAppRuntime.getManager(2)).getPskey(str, "shadowai.qq.com");
  }
  
  private PeakAppInterface e()
  {
    AppInterface localAppInterface = AECaptureContext.a();
    if ((localAppInterface instanceof PeakAppInterface)) {
      return (PeakAppInterface)localAppInterface;
    }
    return null;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(Bitmap paramBitmap)
  {
    AEQLog.b("AECMShowRequestController", "sendCartoonRequest");
    AECMShowQipcModule.b(new AECMShowRequestController.2(this, paramBitmap));
  }
  
  public void b()
  {
    if (this.b != null) {
      this.b = null;
    }
    if (this.d != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.d);
    }
    if (this.e != null)
    {
      PeakAppInterface localPeakAppInterface = e();
      if (localPeakAppInterface != null) {
        ((IHttpEngineService)localPeakAppInterface.getRuntimeService(IHttpEngineService.class, "all")).cancelReq(this.e);
      }
      this.e = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowRequestController
 * JD-Core Version:    0.7.0.1
 */