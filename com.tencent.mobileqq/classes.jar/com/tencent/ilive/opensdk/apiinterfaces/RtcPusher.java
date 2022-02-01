package com.tencent.ilive.opensdk.apiinterfaces;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.ilive.opensdk.bridgeinterface.RtcColorSpaceTransform;
import com.tencent.ilive.opensdk.bridgeinterface.SimpleBeautyFilter;
import com.tencent.ilive.opensdk.bridgeinterface.SimpleMultiSubViewRender;
import com.tencent.ilive.opensdk.bridgeinterface.SimpleMusicDecoder;
import com.tencent.ilive.opensdk.bridgeinterface.SimpleVideoRender360;
import com.tencent.ilive.opensdk.callbacks.RtcCoreEventObserver;
import com.tencent.ilive.opensdk.callbacks.RtcCoreMessageChannel;
import com.tencent.ilive.opensdk.callbacks.RtcInitCallback;
import com.tencent.ilive.opensdk.coreinterface.IGLRenderFactory;
import com.tencent.ilive.opensdk.coreinterface.IMultiSubViewRenderFactory;
import com.tencent.ilive.opensdk.coreinterface.IMusicDecoderFactory;
import com.tencent.ilive.opensdk.loginterface.SimpleLogInterface;
import com.tencent.ilive.opensdk.params.PTFilterItem;
import com.tencent.ilive.opensdk.params.RtcInitParam;
import com.tencent.ilive.opensdk.params.RtcRoomEnterParams;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpImpl;
import java.lang.ref.WeakReference;
import java.util.List;

public class RtcPusher
  implements IOpenSdk
{
  public void attachContext(Context paramContext) {}
  
  public void changeRole(int paramInt, RtcCoreEventObserver paramRtcCoreEventObserver) {}
  
  public int createPreview(WeakReference<View> paramWeakReference, String paramString1, String paramString2, RtcCoreEventObserver paramRtcCoreEventObserver)
  {
    return 0;
  }
  
  public int destroyPreview()
  {
    return 0;
  }
  
  public void enableMic(boolean paramBoolean) {}
  
  public void enterRoom(RtcRoomEnterParams paramRtcRoomEnterParams) {}
  
  public void exitRoom() {}
  
  public int getCameraId()
  {
    return 0;
  }
  
  public <T> T getDescription(long paramLong, String paramString, Class<T> paramClass)
  {
    return null;
  }
  
  public long getDynamicVolume(long paramLong)
  {
    return 0L;
  }
  
  public String getQualityTips()
  {
    return null;
  }
  
  public int initAnchor(int paramInt1, int paramInt2, byte[] paramArrayOfByte, RtcCoreEventObserver paramRtcCoreEventObserver)
  {
    return 0;
  }
  
  public int initAnchor(WeakReference<View> paramWeakReference, String paramString, RtcCoreEventObserver paramRtcCoreEventObserver)
  {
    return 0;
  }
  
  public void initEngine(RtcInitParam paramRtcInitParam, RtcInitCallback paramRtcInitCallback) {}
  
  public boolean isCameraMirror()
  {
    return false;
  }
  
  public boolean isSupportBeautyRender()
  {
    return false;
  }
  
  public boolean isUseBeautyRender()
  {
    return false;
  }
  
  public int pause()
  {
    return 0;
  }
  
  public int pauseById(long paramLong)
  {
    return 0;
  }
  
  public int pausePreview()
  {
    return 0;
  }
  
  public void registerGLRenderFactory(IGLRenderFactory<? extends SimpleVideoRender360> paramIGLRenderFactory) {}
  
  public void registerMultiSubViewRenderFactory(IMultiSubViewRenderFactory<? extends SimpleMultiSubViewRender> paramIMultiSubViewRenderFactory) {}
  
  public void registerMusicDecoderFactory(IMusicDecoderFactory<? extends SimpleMusicDecoder> paramIMusicDecoderFactory) {}
  
  public int release()
  {
    return 0;
  }
  
  public int resume()
  {
    return 0;
  }
  
  public int resumeById(long paramLong)
  {
    return 0;
  }
  
  public int resumePreview()
  {
    return 0;
  }
  
  public void setBeautyData(List<PTFilterItem> paramList) {}
  
  public int setBeautyEffectMode(int paramInt)
  {
    return 0;
  }
  
  public void setBeautyFaceLevel(int paramInt) {}
  
  public int setBeautyFilter(String paramString, float paramFloat)
  {
    return 0;
  }
  
  public void setBeautyFilterInterface(SimpleBeautyFilter paramSimpleBeautyFilter) {}
  
  public int setBeautyFilterLevel(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public void setBeautyWhitenLevel(int paramInt) {}
  
  public int setCameraFocusRect(Rect paramRect)
  {
    return 0;
  }
  
  public int setCameraMirror(boolean paramBoolean)
  {
    return 0;
  }
  
  public void setColorSpaceTransformDelegate(RtcColorSpaceTransform paramRtcColorSpaceTransform) {}
  
  public void setFilterData(List<PTFilterItem> paramList) {}
  
  public void setLoger(SimpleLogInterface paramSimpleLogInterface) {}
  
  public void setMessageChannel(RtcCoreMessageChannel paramRtcCoreMessageChannel) {}
  
  public void setReporter(SimpleCoreHttpImpl paramSimpleCoreHttpImpl) {}
  
  public void setSelfUin(long paramLong) {}
  
  public void setTinyId(long paramLong) {}
  
  public void setYunTinyId(long paramLong) {}
  
  public int start()
  {
    return 0;
  }
  
  public int startPreview()
  {
    return 0;
  }
  
  public int stop()
  {
    return 0;
  }
  
  public int stopPreview()
  {
    return 0;
  }
  
  public int switchCamera()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.opensdk.apiinterfaces.RtcPusher
 * JD-Core Version:    0.7.0.1
 */