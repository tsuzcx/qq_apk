package com.tencent.biz.qqcircle.flutter;

import android.text.TextUtils;
import android.util.Pair;
import com.qflutter.superchannel.SuperChannelPlugin;
import com.qflutter.vistaplayer.IVistaPlayer;
import com.tencent.biz.qqcircle.QCircleAVController;
import com.tencent.biz.qqcircle.QCirclePluginConfig.PhoneCallState;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent;
import com.tencent.biz.qqcircle.flutter.animation.PushCountImageRenderer;
import com.tencent.biz.qqcircle.richframework.video.QCirclePlayer;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleVistaPlayerImpl
  implements IVistaPlayer
{
  public static final String TAG = "QCircleVistaPlayerImpl";
  private static Pair<String, Long> needContinuePositionPair;
  private Map<Long, QCircleFlutterPlayerBundle> bundleMap = new ConcurrentHashMap();
  
  public static void mayNeedVideoContinue(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[mayNeedVideoContinue] feedId=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", position=");
      localStringBuilder.append(paramLong);
      QLog.d("QCircleVistaPlayerImpl", 2, localStringBuilder.toString());
    }
    if (paramLong < 0L)
    {
      paramString = new StringBuilder();
      paramString.append("[mayNeedVideoContinue] invalid position, ");
      paramString.append(paramLong);
      QLog.w("QCircleVistaPlayerImpl", 1, paramString.toString());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[mayNeedVideoContinue] invalid feedId, ");
      localStringBuilder.append(paramString);
      QLog.w("QCircleVistaPlayerImpl", 1, localStringBuilder.toString());
      return;
    }
    needContinuePositionPair = new Pair(paramString, Long.valueOf(paramLong));
  }
  
  public void clear()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[clear] this=");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(", bundle size=");
    ((StringBuilder)localObject).append(this.bundleMap.size());
    QLog.i("QCircleVistaPlayerImpl", 1, ((StringBuilder)localObject).toString());
    localObject = this.bundleMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[cleanAll] textureId=");
        localStringBuilder.append(localEntry.getKey());
        QLog.d("QCircleVistaPlayerImpl", 2, localStringBuilder.toString());
      }
      ((QCircleFlutterPlayerBundle)localEntry.getValue()).b();
    }
    this.bundleMap.clear();
    needContinuePositionPair = null;
    PushCountImageRenderer.a();
    QCircleAVController.a.b();
  }
  
  public void dispose(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[dispose] this=");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d("QCircleVistaPlayerImpl", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QCircleFlutterPlayerBundle)this.bundleMap.remove(Long.valueOf(paramLong));
    if (localObject != null)
    {
      ((QCircleFlutterPlayerBundle)localObject).b();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[dispose] not found bundle, textureId=");
    ((StringBuilder)localObject).append(paramLong);
    QLog.w("QCircleVistaPlayerImpl", 1, ((StringBuilder)localObject).toString());
  }
  
  public boolean initialize()
  {
    QCircleAVController.a.c();
    return true;
  }
  
  public void loop(long paramLong, boolean paramBoolean)
  {
    Object localObject = (QCircleFlutterPlayerBundle)this.bundleMap.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((QCircleFlutterPlayerBundle)localObject).a != null))
    {
      ((QCircleFlutterPlayerBundle)localObject).a.b(paramBoolean);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[setLooping] not found bundle, textureId=");
    ((StringBuilder)localObject).append(paramLong);
    QLog.w("QCircleVistaPlayerImpl", 1, ((StringBuilder)localObject).toString());
  }
  
  public void pause(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleVistaPlayerImpl", 2, "[pause]");
    }
    Object localObject = (QCircleFlutterPlayerBundle)this.bundleMap.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((QCircleFlutterPlayerBundle)localObject).a != null))
    {
      ((QCircleFlutterPlayerBundle)localObject).a.b();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[pause] not found bundle, textureId=");
    ((StringBuilder)localObject).append(paramLong);
    QLog.w("QCircleVistaPlayerImpl", 1, ((StringBuilder)localObject).toString());
  }
  
  public void playback(long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[playback] this=");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append(", textureId=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("QCircleVistaPlayerImpl", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = (QCircleFlutterPlayerBundle)this.bundleMap.get(Long.valueOf(paramLong));
      if ((localObject != null) && (((QCircleFlutterPlayerBundle)localObject).a != null))
      {
        if (QCircleAVController.a.a())
        {
          QLog.d("QCircleVistaPlayerImpl", 1, "is in calling,loss AVFocus, [start] paused");
          localObject = new HashMap(2);
          ((HashMap)localObject).put("state", Integer.valueOf(QCirclePluginConfig.PhoneCallState.TALKING.ordinal()));
          SuperChannelPlugin.sendEvent("tencent_qqcircle/phone_call_state", (Map)localObject);
          return;
        }
        ((QCircleFlutterPlayerBundle)localObject).a.a();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[play] not found bundle, textureId=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.w("QCircleVistaPlayerImpl", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleVistaPlayerImpl", 1, "start error", localException);
    }
  }
  
  public int position(long paramLong)
  {
    Object localObject = (QCircleFlutterPlayerBundle)this.bundleMap.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((QCircleFlutterPlayerBundle)localObject).a != null) && (((QCircleFlutterPlayerBundle)localObject).c != null))
    {
      long l = ((QCircleFlutterPlayerBundle)localObject).a.e();
      localObject = ((QCircleFlutterPlayerBundle)localObject).a();
      paramLong = l;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedVideoPositionLinkEvent((String)localObject, l));
        paramLong = l;
      }
    }
    else
    {
      paramLong = 0L;
    }
    return (int)paramLong;
  }
  
  public long prepare(Object paramObject, TextureRegistry paramTextureRegistry)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[prepare] this=");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append(", registry=");
      ((StringBuilder)localObject).append(paramTextureRegistry.hashCode());
      QLog.d("QCircleVistaPlayerImpl", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = (byte[])paramObject;
      paramObject = new FeedCloudMeta.StFeed();
      paramObject.mergeFrom((byte[])localObject);
      paramTextureRegistry = new QCircleFlutterPlayerBundle(paramTextureRegistry, paramObject.video.width.get(), paramObject.video.height.get());
      long l2 = 0L;
      long l1 = l2;
      if (needContinuePositionPair != null)
      {
        l1 = l2;
        if (((String)needContinuePositionPair.first).equals(paramObject.id.get()))
        {
          l1 = ((Long)needContinuePositionPair.second).longValue();
          needContinuePositionPair = null;
        }
      }
      paramTextureRegistry.a(paramObject, l1);
      this.bundleMap.put(Long.valueOf(paramTextureRegistry.c.id()), paramTextureRegistry);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[prepare] this=");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append(", textureId=");
      ((StringBuilder)localObject).append(paramTextureRegistry.c.id());
      ((StringBuilder)localObject).append(", startOffset=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", bundleMap size=");
      ((StringBuilder)localObject).append(this.bundleMap.size());
      ((StringBuilder)localObject).append(", url=");
      ((StringBuilder)localObject).append(paramObject.video.playUrl.get());
      QLog.i("QCircleVistaPlayerImpl", 2, ((StringBuilder)localObject).toString());
      l1 = paramTextureRegistry.c.id();
      return l1;
    }
    catch (Exception paramObject)
    {
      QLog.e("QCircleVistaPlayerImpl", 1, paramObject, new Object[0]);
      QLog.e("QCircleVistaPlayerImpl", 1, "[prepare] null texture");
    }
    return -1L;
  }
  
  public void seekTo(long paramLong, int paramInt)
  {
    Object localObject = (QCircleFlutterPlayerBundle)this.bundleMap.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((QCircleFlutterPlayerBundle)localObject).a != null))
    {
      ((QCircleFlutterPlayerBundle)localObject).a.a(paramInt);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[seekTo] not found bundle, textureId=");
    ((StringBuilder)localObject).append(paramLong);
    QLog.w("QCircleVistaPlayerImpl", 1, ((StringBuilder)localObject).toString());
  }
  
  public void speed(long paramLong, double paramDouble) {}
  
  public void stop(long paramLong) {}
  
  public void volume(long paramLong, double paramDouble) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QCircleVistaPlayerImpl
 * JD-Core Version:    0.7.0.1
 */