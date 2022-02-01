package com.tencent.ad.tangram.device;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdUin;
import com.tencent.ad.tangram.experiment.AdExperimentManager;
import com.tencent.ad.tangram.lbs.AdLocationManager;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdIPV4;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt.HevcCompatibilityInfo;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt.IdInfo;
import com.tencent.ad.tangram.settings.AdSettingsManager;
import com.tencent.ad.tangram.video.AdVideo;
import com.tencent.ad.tangram.video.AdVideo.CodecCapability;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Keep
public enum AdDeviceInfo
{
  INSTANCE;
  
  public static final String NEW_DEVICE_INFO_KEY = "newDeviceInfo";
  private static final String TAG = "AdDeviceInfo";
  public static final String TRAFFIC_TYPE = "26";
  private static final String WX_OPENSDK_VERSION = "com.tencent.mm.BuildInfo.OPEN_SDK_VERSION";
  private static final String WX_PACKAGE_NAME = "com.tencent.mm";
  private volatile boolean initialized = false;
  
  private AdDeviceInfo() {}
  
  private AdDeviceInfo.Result createV1(Context paramContext, AdDeviceInfo.Params paramParams, gdt_settings.Settings paramSettings)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static qq_common.DeviceExt.HevcCompatibilityInfo[] getHevcCompatibilityInfo()
  {
    Object localObject = AdVideo.INSTANCE.getHEVCMaxCapability(1);
    if (localObject == null) {
      return null;
    }
    qq_common.DeviceExt.HevcCompatibilityInfo localHevcCompatibilityInfo = new qq_common.DeviceExt.HevcCompatibilityInfo();
    localHevcCompatibilityInfo.video_player_type = 1;
    localHevcCompatibilityInfo.max_luma_samples = ((AdVideo.CodecCapability)localObject).lumaSamples;
    localHevcCompatibilityInfo.max_fps = ((AdVideo.CodecCapability)localObject).framerateForLumaSamples;
    localObject = new ArrayList();
    ((ArrayList)localObject).add(localHevcCompatibilityInfo);
    return (qq_common.DeviceExt.HevcCompatibilityInfo[])((ArrayList)localObject).toArray(new qq_common.DeviceExt.HevcCompatibilityInfo[((ArrayList)localObject).size()]);
  }
  
  private static qq_common.DeviceExt.IdInfo[] getIdInfoArray(Map<Integer, AdDeviceIdentifier> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.isEmpty()) {
        return null;
      }
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      qq_common.DeviceExt.IdInfo localIdInfo;
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        Integer localInteger = (Integer)paramMap.getKey();
        if ((localInteger != null) && (localInteger.intValue() != 0))
        {
          if (paramMap.getValue() != null) {
            paramMap = ((AdDeviceIdentifier)paramMap.getValue()).idHash;
          } else {
            paramMap = null;
          }
          if (!TextUtils.isEmpty(paramMap))
          {
            localIdInfo = (qq_common.DeviceExt.IdInfo)localHashMap.get(paramMap);
            localObject = localIdInfo;
            if (localIdInfo == null)
            {
              localObject = new qq_common.DeviceExt.IdInfo();
              ((qq_common.DeviceExt.IdInfo)localObject).id_h = paramMap;
            }
            int i = ((qq_common.DeviceExt.IdInfo)localObject).bitmap;
            ((qq_common.DeviceExt.IdInfo)localObject).bitmap = (localInteger.intValue() | i);
            localHashMap.put(paramMap, localObject);
          }
        }
      }
      paramMap = new ArrayList();
      Object localObject = localHashMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localIdInfo = (qq_common.DeviceExt.IdInfo)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localIdInfo != null) && (!TextUtils.isEmpty(localIdInfo.id_h)) && (localIdInfo.bitmap != 0)) {
          paramMap.add(localIdInfo);
        }
      }
      if (paramMap.isEmpty()) {
        return null;
      }
      return (qq_common.DeviceExt.IdInfo[])paramMap.toArray(new qq_common.DeviceExt.IdInfo[paramMap.size()]);
    }
    return null;
  }
  
  private static int getWeChatAPIVer(Context paramContext)
  {
    if (paramContext == null)
    {
      AdLog.e("AdDeviceInfo", "getWXAppSupportAPI: context is null");
      return 0;
    }
    try
    {
      if (paramContext.getPackageManager() == null)
      {
        AdLog.e("AdDeviceInfo", "getWXAppSupportAPI: getPackageManager is null");
        return 0;
      }
      paramContext = paramContext.getPackageManager().getApplicationInfo("com.tencent.mm", 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        int i = paramContext.metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
        return i;
      }
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWXAppSupportAPI: error ");
      localStringBuilder.append(paramContext);
      AdLog.e("AdDeviceInfo", localStringBuilder.toString());
    }
    return 0;
  }
  
  private static boolean isHitDeviceInfoSdkV2(gdt_settings.Settings paramSettings)
  {
    return AdExperimentManager.INSTANCE.isHitExperiment(AdUin.INSTANCE.getUIN(), "newDeviceInfo", paramSettings);
  }
  
  public AdDeviceInfo.Result create(Context paramContext, AdDeviceInfo.Params paramParams)
  {
    gdt_settings.Settings localSettings = AdSettingsManager.INSTANCE.getCacheByFile();
    if (paramParams != null) {
      paramParams.expIds = AdExperimentManager.INSTANCE.getAllExpIdsByCache(AdUin.INSTANCE.getUIN(), localSettings);
    }
    if (isHitDeviceInfoSdkV2(localSettings))
    {
      AdLog.i("AdDeviceInfo", "use new device sdk");
      return AdDeviceInfoV2.getInstance().createV2(paramContext, paramParams, localSettings);
    }
    AdLog.i("AdDeviceInfo", "use old device sdk");
    return createV1(paramContext, paramParams, localSettings);
  }
  
  public void init(Context paramContext)
  {
    if (this.initialized) {
      return;
    }
    try
    {
      if (this.initialized) {
        return;
      }
      this.initialized = true;
      AdIPV4.INSTANCE.init(paramContext);
      h.INSTANCE.init(paramContext);
      AdTAID.getInstance().init(paramContext);
      AdLocationManager.INSTANCE.init(paramContext);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceInfo
 * JD-Core Version:    0.7.0.1
 */