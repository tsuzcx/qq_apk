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

public abstract interface IOpenSdk
{
  public abstract void attachContext(Context paramContext);
  
  public abstract void changeRole(int paramInt, RtcCoreEventObserver paramRtcCoreEventObserver);
  
  public abstract int createPreview(WeakReference<View> paramWeakReference, String paramString1, String paramString2, RtcCoreEventObserver paramRtcCoreEventObserver);
  
  public abstract int destroyPreview();
  
  public abstract void enableMic(boolean paramBoolean);
  
  public abstract void enterRoom(RtcRoomEnterParams paramRtcRoomEnterParams);
  
  public abstract void exitRoom();
  
  public abstract int getCameraId();
  
  public abstract <T> T getDescription(long paramLong, String paramString, Class<T> paramClass);
  
  public abstract long getDynamicVolume(long paramLong);
  
  public abstract String getQualityTips();
  
  public abstract int initAnchor(int paramInt1, int paramInt2, byte[] paramArrayOfByte, RtcCoreEventObserver paramRtcCoreEventObserver);
  
  public abstract int initAnchor(WeakReference<View> paramWeakReference, String paramString, RtcCoreEventObserver paramRtcCoreEventObserver);
  
  public abstract void initEngine(RtcInitParam paramRtcInitParam, RtcInitCallback paramRtcInitCallback);
  
  public abstract boolean isCameraMirror();
  
  public abstract boolean isSupportBeautyRender();
  
  public abstract boolean isUseBeautyRender();
  
  public abstract int pause();
  
  public abstract int pauseById(long paramLong);
  
  public abstract int pausePreview();
  
  public abstract void registerGLRenderFactory(IGLRenderFactory<? extends SimpleVideoRender360> paramIGLRenderFactory);
  
  public abstract void registerMultiSubViewRenderFactory(IMultiSubViewRenderFactory<? extends SimpleMultiSubViewRender> paramIMultiSubViewRenderFactory);
  
  public abstract void registerMusicDecoderFactory(IMusicDecoderFactory<? extends SimpleMusicDecoder> paramIMusicDecoderFactory);
  
  public abstract int release();
  
  public abstract int resume();
  
  public abstract int resumeById(long paramLong);
  
  public abstract int resumePreview();
  
  public abstract void setBeautyData(List<PTFilterItem> paramList);
  
  public abstract int setBeautyEffectMode(int paramInt);
  
  public abstract void setBeautyFaceLevel(int paramInt);
  
  public abstract int setBeautyFilter(String paramString, float paramFloat);
  
  public abstract void setBeautyFilterInterface(SimpleBeautyFilter paramSimpleBeautyFilter);
  
  public abstract int setBeautyFilterLevel(int paramInt1, int paramInt2);
  
  public abstract void setBeautyWhitenLevel(int paramInt);
  
  public abstract int setCameraFocusRect(Rect paramRect);
  
  public abstract int setCameraMirror(boolean paramBoolean);
  
  public abstract void setColorSpaceTransformDelegate(RtcColorSpaceTransform paramRtcColorSpaceTransform);
  
  public abstract void setFilterData(List<PTFilterItem> paramList);
  
  public abstract void setLoger(SimpleLogInterface paramSimpleLogInterface);
  
  public abstract void setMessageChannel(RtcCoreMessageChannel paramRtcCoreMessageChannel);
  
  public abstract void setReporter(SimpleCoreHttpImpl paramSimpleCoreHttpImpl);
  
  public abstract void setSelfUin(long paramLong);
  
  public abstract void setTinyId(long paramLong);
  
  public abstract void setYunTinyId(long paramLong);
  
  public abstract int start();
  
  public abstract int startPreview();
  
  public abstract int stop();
  
  public abstract int stopPreview();
  
  public abstract int switchCamera();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.opensdk.apiinterfaces.IOpenSdk
 * JD-Core Version:    0.7.0.1
 */