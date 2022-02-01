package com.tencent.hippy.qq.module.tkd;

import acwz;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.jetbrains.annotations.Nullable;
import pqp;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

@HippyNativeModule(name="TKDDeviceModule")
public class TKDDeviceModule
  extends HippyNativeModuleBase
{
  private static float sHardwareCodecLevel = -1.0F;
  
  public TKDDeviceModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private static String getApnType()
  {
    String str = "";
    int i = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
    if (1 == i) {
      str = "wifi";
    }
    do
    {
      return str;
      if (2 == i) {
        return "2g";
      }
      if (3 == i) {
        return "3g";
      }
      if (4 == i) {
        return "4g";
      }
    } while (6 != i);
    return "5g";
  }
  
  public static HippyMap getDeviceInfo()
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("guid", TKDAccountModule.getCurAccountInfo().qqNum);
    localHippyMap.pushString("qua", pqp.c());
    localHippyMap.pushString("qua2", pqp.c());
    localHippyMap.pushString("macAddress", DeviceInfoUtil.getLocalMacAddress(BaseApplicationImpl.getApplication().getApplicationContext()));
    localHippyMap.pushString("networkType", getApnType());
    localHippyMap.pushString("id", acwz.p());
    localHippyMap.pushString("qimei", UserAction.getQIMEI());
    localHippyMap.pushString("dpi", String.valueOf(ViewUtils.getDensityDpi()));
    localHippyMap.pushBoolean("isKingCardUser", HippyTKDListView.isKingCardMobileNetWork());
    return localHippyMap;
  }
  
  @Nullable
  private qq_ad_get.QQAdGet.DeviceInfo getGdtDeviceInfo()
  {
    Object localObject = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject).businessIdForAidTicketAndTaidTicket = "ce2d9f";
    localObject = GdtDeviceInfoHelper.create(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject);
    if (localObject != null) {
      return ((GdtDeviceInfoHelper.Result)localObject).deviceInfo;
    }
    return null;
  }
  
  public static String getHardWareCodecLevel()
  {
    if (sHardwareCodecLevel > 0.0F) {
      return String.valueOf(sHardwareCodecLevel);
    }
    float f1 = -1.0F;
    for (;;)
    {
      int j;
      int k;
      try
      {
        Object localObject1 = Class.forName("android.media.MediaCodecList");
        Object localObject3 = ((Class)localObject1).getDeclaredMethod("getCodecCount", new Class[0]);
        localObject1 = ((Class)localObject1).getDeclaredMethod("getCodecInfoAt", new Class[] { Integer.TYPE });
        Object localObject2 = Class.forName("android.media.MediaCodecInfo");
        Method localMethod1 = ((Class)localObject2).getDeclaredMethod("getSupportedTypes", new Class[0]);
        ((Class)localObject2).getDeclaredMethod("getName", new Class[0]);
        Method localMethod2 = ((Class)localObject2).getDeclaredMethod("isEncoder", new Class[0]);
        localObject2 = ((Class)localObject2).getDeclaredMethod("getCapabilitiesForType", new Class[] { String.class });
        Field localField1 = Class.forName("android.media.MediaCodecInfo$CodecCapabilities").getDeclaredField("profileLevels");
        Field localField2 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel").getDeclaredField("level");
        int n = ((Integer)((Method)localObject3).invoke(null, new Object[0])).intValue();
        int i = -1;
        j = 0;
        f2 = f1;
        if (j < n)
        {
          localObject3 = ((Method)localObject1).invoke(null, new Object[] { Integer.valueOf(j) });
          if (((Boolean)localMethod2.invoke(localObject3, new Object[0])).booleanValue()) {
            break label376;
          }
          String[] arrayOfString = (String[])localMethod1.invoke(localObject3, new Object[0]);
          int m = arrayOfString.length;
          k = 0;
          if (k >= m) {
            break label376;
          }
          if (arrayOfString[k].equalsIgnoreCase("video/hevc"))
          {
            localObject3 = (Object[])localField1.get(((Method)localObject2).invoke(localObject3, new Object[] { "video/hevc" }));
            int i1 = localObject3.length;
            k = 0;
            if (k < i1)
            {
              m = ((Integer)localField2.get(localObject3[k])).intValue();
              if (m <= i) {
                break label373;
              }
              i = m;
              break label383;
            }
            f1 = innerCalculateRealLevel(i);
            break label376;
          }
          k += 1;
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        float f2 = 0.0F;
        sHardwareCodecLevel = f2;
        return String.valueOf("");
      }
      label373:
      label376:
      j += 1;
      continue;
      label383:
      k += 1;
    }
  }
  
  private static float innerCalculateRealLevel(int paramInt)
  {
    try
    {
      Class localClass = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
      int i = ((Integer)localClass.getField("HEVCHighTierLevel1").get(null)).intValue();
      int j = ((Integer)localClass.getField("HEVCHighTierLevel2").get(null)).intValue();
      int k = ((Integer)localClass.getField("HEVCHighTierLevel21").get(null)).intValue();
      int m = ((Integer)localClass.getField("HEVCHighTierLevel3").get(null)).intValue();
      int n = ((Integer)localClass.getField("HEVCHighTierLevel31").get(null)).intValue();
      int i1 = ((Integer)localClass.getField("HEVCHighTierLevel4").get(null)).intValue();
      int i2 = ((Integer)localClass.getField("HEVCHighTierLevel41").get(null)).intValue();
      int i3 = ((Integer)localClass.getField("HEVCHighTierLevel5").get(null)).intValue();
      int i4 = ((Integer)localClass.getField("HEVCHighTierLevel51").get(null)).intValue();
      int i5 = ((Integer)localClass.getField("HEVCHighTierLevel52").get(null)).intValue();
      int i6 = ((Integer)localClass.getField("HEVCHighTierLevel6").get(null)).intValue();
      int i7 = ((Integer)localClass.getField("HEVCHighTierLevel61").get(null)).intValue();
      int i8 = ((Integer)localClass.getField("HEVCHighTierLevel62").get(null)).intValue();
      int i9 = ((Integer)localClass.getField("HEVCMainTierLevel1").get(null)).intValue();
      int i10 = ((Integer)localClass.getField("HEVCMainTierLevel2").get(null)).intValue();
      int i11 = ((Integer)localClass.getField("HEVCMainTierLevel21").get(null)).intValue();
      int i12 = ((Integer)localClass.getField("HEVCMainTierLevel3").get(null)).intValue();
      int i13 = ((Integer)localClass.getField("HEVCMainTierLevel31").get(null)).intValue();
      int i14 = ((Integer)localClass.getField("HEVCMainTierLevel4").get(null)).intValue();
      int i15 = ((Integer)localClass.getField("HEVCMainTierLevel41").get(null)).intValue();
      int i16 = ((Integer)localClass.getField("HEVCMainTierLevel5").get(null)).intValue();
      int i17 = ((Integer)localClass.getField("HEVCMainTierLevel51").get(null)).intValue();
      int i18 = ((Integer)localClass.getField("HEVCMainTierLevel52").get(null)).intValue();
      int i19 = ((Integer)localClass.getField("HEVCMainTierLevel6").get(null)).intValue();
      int i20 = ((Integer)localClass.getField("HEVCMainTierLevel61").get(null)).intValue();
      int i21 = ((Integer)localClass.getField("HEVCMainTierLevel62").get(null)).intValue();
      if ((paramInt == i) || (paramInt == i9)) {
        return 1.0F;
      }
      if ((paramInt == j) || (paramInt == i10)) {
        return 2.0F;
      }
      if ((paramInt == k) || (paramInt == i11)) {
        return 2.1F;
      }
      if ((paramInt == m) || (paramInt == i12)) {
        return 3.0F;
      }
      if ((paramInt == n) || (paramInt == i13)) {
        return 3.1F;
      }
      if ((paramInt == i1) || (paramInt == i14)) {
        return 4.0F;
      }
      if ((paramInt == i2) || (paramInt == i15)) {
        return 4.1F;
      }
      if ((paramInt == i3) || (paramInt == i16)) {
        return 5.0F;
      }
      if ((paramInt == i4) || (paramInt == i17)) {
        return 5.1F;
      }
      if ((paramInt == i5) || (paramInt == i18)) {
        return 5.2F;
      }
      if ((paramInt == i6) || (paramInt == i19)) {
        return 6.0F;
      }
      if ((paramInt >= i7) || (paramInt == i20)) {
        return 6.1F;
      }
      if ((paramInt >= i8) || (paramInt == i21)) {
        return 6.2F;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0.0F;
  }
  
  @HippyMethod(name="getDeviceInfo")
  public void getDeviceInfo(Promise paramPromise)
  {
    paramPromise.resolve(getDeviceInfo());
  }
  
  @HippyMethod(name="getHWCodecLevel")
  public void getHWCodecLevel(Promise paramPromise)
  {
    paramPromise.resolve(getHardWareCodecLevel());
  }
  
  @HippyMethod(name="getOAID")
  public void getOAID(Promise paramPromise)
  {
    HippyMap localHippyMap = new HippyMap();
    qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = getGdtDeviceInfo();
    if (localDeviceInfo != null) {
      localHippyMap.pushString("oaid", localDeviceInfo.oaid.get());
    }
    paramPromise.resolve(localHippyMap);
  }
  
  @HippyMethod(name="getQADID")
  public void getQADID(Promise paramPromise)
  {
    HippyMap localHippyMap = new HippyMap();
    qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = getGdtDeviceInfo();
    if (localDeviceInfo != null) {
      localHippyMap.pushString("qadid", localDeviceInfo.qadid.get());
    }
    paramPromise.resolve(localHippyMap);
  }
  
  @HippyMethod(name="getQAID")
  public void getQAID(Promise paramPromise)
  {
    paramPromise.resolve(new HippyMap());
  }
  
  @HippyMethod(name="getTAID")
  public void getTAID(Promise paramPromise)
  {
    HippyMap localHippyMap = new HippyMap();
    qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = getGdtDeviceInfo();
    if (localDeviceInfo != null) {
      localHippyMap.pushString("taid", localDeviceInfo.taid_ticket.get());
    }
    paramPromise.resolve(localHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDDeviceModule
 * JD-Core Version:    0.7.0.1
 */