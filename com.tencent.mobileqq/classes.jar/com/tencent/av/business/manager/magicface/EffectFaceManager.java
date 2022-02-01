package com.tencent.av.business.manager.magicface;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.AVPathUtil;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.Checker;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.EffectMutexManager;
import com.tencent.av.business.manager.EffectMutexManager.IMutexItem;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.business.processor.FaceConfigFileProcessor;
import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.av.ui.ControlUIObserver.RequestPlayMagicFace;
import com.tencent.av.ui.ControlUIObserver.ZimuRequest;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.TimeZone;
import java.util.concurrent.ArrayBlockingQueue;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class EffectFaceManager
  extends EffectConfigBase<FaceItem>
  implements EffectMutexManager.IMutexItem, MagicfaceBaseDecoder.MagicPlayListener
{
  public static final String k;
  EffectFaceManager.VoiceStickerGuideTips l = new EffectFaceManager.VoiceStickerGuideTips();
  private ArrayList<String> m = new ArrayList();
  private ArrayList<EffectFaceManager.BlessingTips> n = new ArrayList();
  private EffectSupportManager o;
  private MagicFaceDataEntity p;
  private WeakReference<MagicfaceBaseDecoder.MagicfaceRenderListener> q = new WeakReference(null);
  private String r;
  private MagicfacePlayer s = new MagicfacePlayer();
  private Queue<MagicFaceDataEntity> t = new ArrayBlockingQueue(8);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AVPathUtil.a());
    localStringBuilder.append(176);
    localStringBuilder.append(File.separator);
    k = localStringBuilder.toString();
  }
  
  public EffectFaceManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private MagicFaceDataEntity a(FaceItem paramFaceItem, String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramFaceItem != null)
    {
      AVLog.printColorLog(this.a, String.format("createMagicEntity: id=%s, senderType%s.", new Object[] { paramFaceItem.getId(), Integer.valueOf(paramInt) }));
      String str1 = paramFaceItem.getId();
      String str2 = paramFaceItem.getType();
      if ("multi_result".equalsIgnoreCase(paramFaceItem.getAttr())) {
        paramString = new MagicFaceDataEntityMultiResult(this.c, str1, str2, paramString, paramBoolean, paramInt);
      } else {
        paramString = new MagicFaceDataEntity(this.c, str1, str2, paramString, paramBoolean, paramInt);
      }
      paramFaceItem.lastPositionIndex = paramString.e(paramFaceItem.lastPositionIndex);
      return paramString;
    }
    return null;
  }
  
  private void a(long paramLong, MagicFaceDataEntity paramMagicFaceDataEntity, MagicfaceBaseDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    this.p = paramMagicFaceDataEntity;
    if (this.p != null)
    {
      FaceItem localFaceItem = (FaceItem)b(paramMagicFaceDataEntity.i());
      if (localFaceItem != null)
      {
        String str = b(localFaceItem);
        if (!TextUtils.isEmpty(str))
        {
          if ((localFaceItem.isSameType("voicesticker")) || (localFaceItem.isSameType("face"))) {
            AVVoiceRecog.b().b(2);
          }
          this.s.a(paramLong, str, paramMagicFaceDataEntity, paramMagicfaceRenderListener, this);
        }
      }
    }
  }
  
  private boolean a(long paramLong)
  {
    if (this.t.size() > 0)
    {
      MagicFaceDataEntity localMagicFaceDataEntity = (MagicFaceDataEntity)this.t.remove();
      if (AudioHelper.e())
      {
        String str = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playItemFromQueueHead, id[");
        localStringBuilder.append(localMagicFaceDataEntity);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      a(paramLong, localMagicFaceDataEntity, (MagicfaceBaseDecoder.MagicfaceRenderListener)this.q.get());
      a(paramLong, localMagicFaceDataEntity.i());
      if (localMagicFaceDataEntity.k())
      {
        a(paramLong, 6102, null, null);
        this.r = null;
      }
      return true;
    }
    return false;
  }
  
  private MagicFaceDataEntity b(String paramString, boolean paramBoolean)
  {
    paramString = (FaceItem)b(paramString);
    if (paramString != null)
    {
      Object localObject1 = b(paramString);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("config.json");
      localObject1 = new File(((StringBuilder)localObject2).toString());
      boolean bool = ((File)localObject1).exists();
      int i = 1;
      if (bool)
      {
        localObject1 = FileUtils.readFileContent((File)localObject1);
        bool = this.c.b().k().B;
        if (!paramBoolean) {
          i = 2;
        }
        return a(paramString, (String)localObject1, bool ^ true, i);
      }
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add("config.json");
      this.i.a(paramString, a(paramString), b(paramString), (ArrayList)localObject2, false);
      paramString = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("prepareEntity FILE not exist: ");
      ((StringBuilder)localObject2).append(((File)localObject1).getPath());
      AVLog.printErrorLog(paramString, ((StringBuilder)localObject2).toString());
    }
    return null;
  }
  
  private void f(String paramString)
  {
    paramString = (FaceItem)b(paramString);
    if (paramString != null)
    {
      int i;
      if (paramString.isInteract())
      {
        i = 3;
        StringBuilder localStringBuilder;
        if (paramString.isSameType("voicesticker"))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("VSTART_");
          localStringBuilder.append(paramString.getId());
          paramString = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("START_");
          localStringBuilder.append(paramString.getId());
          paramString = localStringBuilder.toString();
        }
      }
      else
      {
        i = 1;
        paramString = paramString.getId();
      }
      a_(i, paramString);
    }
  }
  
  private void g(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int j = 3;
    Object localObject;
    int i;
    if (bool)
    {
      localObject = "START_0";
      i = 3;
    }
    else
    {
      localObject = "0";
      i = 1;
    }
    paramString = (FaceItem)b(paramString);
    if (paramString != null) {
      if (paramString.isInteract())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("STOP");
        ((StringBuilder)localObject).append(paramString.getId());
        localObject = ((StringBuilder)localObject).toString();
        i = j;
      }
      else
      {
        localObject = paramString.getId();
        i = 1;
      }
    }
    a_(i, (String)localObject);
  }
  
  public int a(int paramInt, String paramString)
  {
    long l1 = AudioHelper.c();
    String str = this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceivedMessageOfPeer, type[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("], info[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    QLog.w(str, 1, ((StringBuilder)localObject).toString());
    if (paramInt == 3)
    {
      paramInt = paramString.indexOf('_');
      if (paramInt == -1) {
        return -1;
      }
      str = paramString.substring(0, paramInt);
      localObject = paramString.substring(paramInt + 1, paramString.length());
      boolean bool1 = "START".equals(str);
      boolean bool2 = "VSTART".equals(str);
      if ((!bool1) && (!bool2))
      {
        "STOP".equals(str);
        return 0;
      }
      if ((!"0".equalsIgnoreCase((String)localObject)) && (!"0_iOS".equalsIgnoreCase((String)localObject)))
      {
        if (bool1) {
          a(l1, 6104, paramString, null);
        }
        new ControlUIObserver.RequestPlayMagicFace(l1, (String)localObject, false, 4).a(this.c);
        a(l1, 164, Integer.valueOf(0), null);
        return 0;
      }
      a(l1, 6101, null, Boolean.valueOf(false));
      return 0;
    }
    if (paramInt == 1) {
      new ControlUIObserver.RequestPlayMagicFace(l1, paramString, false, 4).a(this.c);
    }
    return 0;
  }
  
  protected void a()
  {
    super.a();
    EffectMutexManager localEffectMutexManager = (EffectMutexManager)this.c.c(12);
    if (localEffectMutexManager != null) {
      localEffectMutexManager.a(3003, this);
    }
    this.o = ((EffectSupportManager)this.c.c(5));
  }
  
  protected void a(long paramLong, int paramInt, Object paramObject1, Object paramObject2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyEvent, event[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], value[");
      localStringBuilder.append(paramObject1);
      localStringBuilder.append("], value2[");
      localStringBuilder.append(paramObject2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.c.a(new Object[] { Integer.valueOf(paramInt), paramObject1, paramObject2 });
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3) {
        return;
      }
      a(paramLong, 6101, null, Boolean.valueOf(false));
      return;
    }
    a(paramLong, 6101, null, Boolean.valueOf(false));
    new ControlUIObserver.ZimuRequest(paramLong, "onSessionStatusChanged", 5, null).a(this.c);
    MagicDataReport.a(this.c, paramString1);
    MagicDataReport.a(2, paramString1);
    MagicDataReport.a(2);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    Object localObject1 = (MagicFaceDataEntity)this.t.peek();
    Object localObject2 = this.p;
    if ((localObject2 != null) && (((MagicFaceDataEntity)localObject2).i().equalsIgnoreCase(paramString)) && (localObject1 != null))
    {
      boolean bool2 = this.p.a((MagicfaceData)localObject1);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (this.t.size() < 8)
        {
          a(this.p);
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    if (AudioHelper.e())
    {
      localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEndMagicPlay, id[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], reason[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], cur[");
      localStringBuilder.append(this.p);
      localStringBuilder.append("], next[");
      localStringBuilder.append(localObject1);
      localStringBuilder.append("], size[");
      localStringBuilder.append(this.t.size());
      localStringBuilder.append("], needBeRestore[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], mLastPendantId[");
      localStringBuilder.append(this.r);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
    }
    d("onEndMagicPlay.1");
    this.p = null;
    localObject1 = (FaceItem)b(paramString);
    if ((localObject1 != null) && ((((FaceItem)localObject1).isSameType("voicesticker")) || (((FaceItem)localObject1).isSameType("face")))) {
      AVVoiceRecog.b().c(2);
    }
    boolean bool1 = a(paramLong);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onEndMagicPlay.2_");
    ((StringBuilder)localObject1).append(bool1);
    d(((StringBuilder)localObject1).toString());
    if (!bool1)
    {
      a(paramLong, 6101, paramString, Boolean.valueOf(false));
      if (!TextUtils.isEmpty(this.r))
      {
        ((EffectPendantTools)this.c.c(2)).a(paramLong, this.r);
        a(paramLong, 6102, null, null);
        this.r = null;
      }
    }
    a(paramLong, 165, Integer.valueOf(3), null);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean) {}
  
  protected void a(Message paramMessage)
  {
    if (paramMessage.what != 101) {
      return;
    }
    this.c.a(new Object[] { Integer.valueOf(168), paramMessage.obj });
  }
  
  void a(MagicFaceDataEntity paramMagicFaceDataEntity)
  {
    if (paramMagicFaceDataEntity == null) {
      return;
    }
    Object localObject2 = null;
    Iterator localIterator = this.t.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (MagicFaceDataEntity)localIterator.next();
    } while (!((MagicFaceDataEntity)localObject1).k());
    this.t.offer(paramMagicFaceDataEntity);
    if (localObject1 != null)
    {
      this.t.remove(localObject1);
      if (!paramMagicFaceDataEntity.k()) {
        this.t.offer(localObject1);
      }
    }
    d("addItemToQueue");
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    if ((paramBoolean) && (paramString.equals(this.c.b().k().s))) {
      this.r = null;
    }
  }
  
  public boolean a(int paramInt, String paramString, boolean paramBoolean)
  {
    long l1 = AudioHelper.c();
    StringBuilder localStringBuilder;
    if (AudioHelper.e())
    {
      localObject = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop, id[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], reason[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], isSender[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((MagicFaceDataEntity)localObject).i();
      if ((TextUtils.isEmpty(paramString)) || (((String)localObject).equalsIgnoreCase(paramString)))
      {
        this.t.clear();
        localObject = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("stop dequeue");
        localStringBuilder.append(paramString);
        AVLog.printErrorLog((String)localObject, localStringBuilder.toString());
        this.p = null;
        if (paramBoolean) {
          g(paramString);
        }
        a(l1, null);
        if (this.s.b())
        {
          this.s.c();
          localObject = this.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("stop ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", mStopType =");
          localStringBuilder.append(paramInt);
          AVLog.printErrorLog((String)localObject, localStringBuilder.toString());
        }
      }
    }
    return true;
  }
  
  public boolean a(long paramLong, FaceItem paramFaceItem)
  {
    boolean bool = super.a(paramLong, paramFaceItem);
    if (bool)
    {
      this.g.obtainMessage(101, this.d).sendToTarget();
      if (paramFaceItem != null)
      {
        paramFaceItem = paramFaceItem.getType();
        if ((!paramFaceItem.equalsIgnoreCase("face")) && (!paramFaceItem.equalsIgnoreCase("voicesticker")))
        {
          EffectMutexManager localEffectMutexManager = (EffectMutexManager)this.c.c(12);
          if (localEffectMutexManager != null) {
            localEffectMutexManager.a(3003, paramFaceItem);
          }
        }
      }
    }
    return bool;
  }
  
  public boolean a(long paramLong, FaceItem paramFaceItem, String paramString, boolean paramBoolean, MagicfaceBaseDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    Object localObject;
    if (AudioHelper.e())
    {
      paramFaceItem = this.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start, id[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], curData[");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append("], isSender[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], queue[");
      ((StringBuilder)localObject).append(this.t.size());
      ((StringBuilder)localObject).append("], isPlaying[");
      ((StringBuilder)localObject).append(this.s.b());
      ((StringBuilder)localObject).append("], mLastPendantId[");
      ((StringBuilder)localObject).append(this.r);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramFaceItem, 1, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.t.size() < 8))
    {
      paramFaceItem = this.p;
      if ((paramFaceItem == null) || (!paramString.equalsIgnoreCase(paramFaceItem.i())))
      {
        this.q = new WeakReference(paramMagicfaceRenderListener);
        paramFaceItem = this.s;
        if ((paramFaceItem != null) && (paramFaceItem.b()))
        {
          paramFaceItem = b(paramString, paramBoolean);
          a(paramFaceItem);
          this.s.c();
        }
        else
        {
          localObject = b(paramString, paramBoolean);
          paramFaceItem = (FaceItem)localObject;
          if (localObject != null)
          {
            a(paramLong, (MagicFaceDataEntity)localObject, paramMagicfaceRenderListener);
            paramFaceItem = (FaceItem)localObject;
          }
        }
        if (paramFaceItem != null)
        {
          paramMagicfaceRenderListener = this.r;
          a(paramLong, paramString);
          int i;
          if ((paramFaceItem != null) && (paramFaceItem.j()))
          {
            paramFaceItem = this.c;
            int j = 2;
            paramFaceItem = (EffectPendantTools)paramFaceItem.c(2);
            localObject = (PendantItem)paramFaceItem.c();
            i = j;
            if (localObject != null)
            {
              i = j;
              if (((PendantItem)localObject).isShow())
              {
                i = j;
                if (!TextUtils.isEmpty(((PendantItem)localObject).getId()))
                {
                  this.r = ((PendantItem)localObject).getId();
                  localObject = (FaceItem)c();
                  paramFaceItem.a(paramLong, null);
                  i = 1;
                }
              }
            }
          }
          else
          {
            i = 3;
            this.r = null;
          }
          paramFaceItem = this.a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("start, step[");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("], mLastPendantId[");
          ((StringBuilder)localObject).append(paramMagicfaceRenderListener);
          ((StringBuilder)localObject).append("->");
          ((StringBuilder)localObject).append(this.r);
          ((StringBuilder)localObject).append("]");
          QLog.w(paramFaceItem, 1, ((StringBuilder)localObject).toString());
        }
        if (paramBoolean) {
          f(paramString);
        }
        return true;
      }
    }
    return false;
  }
  
  protected boolean a(String paramString)
  {
    return true;
  }
  
  public int b()
  {
    return 176;
  }
  
  public void b(int paramInt, String paramString)
  {
    long l1 = AudioHelper.c();
    if (paramInt == 3003) {}
    boolean bool;
    while (paramInt == 3002)
    {
      bool = false;
      break;
    }
    if (paramInt == 3001) {}
    while (paramInt == 3004)
    {
      bool = true;
      break;
    }
    for (;;)
    {
      if (paramInt != 3005) {
        if (paramInt != 3006) {
          break;
        }
      }
    }
    if (QLog.isDevelopLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MuteByOthers, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], fromMuteKey[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], data[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], mute[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w(str, 2, localStringBuilder.toString());
    }
    if (bool)
    {
      this.c.a(new Object[] { Integer.valueOf(134) });
      a(0, null, true);
      paramString = this.t;
      if (paramString != null) {
        paramString.clear();
      }
      this.p = null;
      a(l1, null);
      if (this.s.b()) {
        this.s.c();
      }
    }
  }
  
  public void b(long paramLong, String paramString)
  {
    a(paramLong, 165, Integer.valueOf(2), null);
  }
  
  protected List<FaceItem> c(int paramInt, String paramString)
  {
    label452:
    label459:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (paramInt == 370)
        {
          try
          {
            if (localJSONObject.has("blessingTips"))
            {
              SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
              localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
              localObject1 = localJSONObject.getJSONArray("blessingTips");
              int i = 0;
              if (i < ((JSONArray)localObject1).length())
              {
                Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
                EffectFaceManager.BlessingTips localBlessingTips = new EffectFaceManager.BlessingTips();
                localBlessingTips.a = ((JSONObject)localObject2).optString("id");
                if (!((JSONObject)localObject2).has("start_date")) {
                  break label459;
                }
                localBlessingTips.b = localSimpleDateFormat.parse(((JSONObject)localObject2).optString("start_date")).getTime();
                if (((JSONObject)localObject2).has("end_date")) {
                  localBlessingTips.c = localSimpleDateFormat.parse(((JSONObject)localObject2).optString("end_date")).getTime();
                }
                if (((JSONObject)localObject2).has("text")) {
                  localBlessingTips.d = ((JSONObject)localObject2).getString("text");
                }
                if (((JSONObject)localObject2).has("image_url")) {
                  localBlessingTips.e = ((JSONObject)localObject2).getString("image_url");
                }
                if (((JSONObject)localObject2).has("call_time_len")) {
                  localBlessingTips.f = ((JSONObject)localObject2).getInt("call_time_len");
                }
                if (((JSONObject)localObject2).has("show_time_len")) {
                  localBlessingTips.g = ((JSONObject)localObject2).getInt("show_time_len");
                }
                this.n.add(localBlessingTips);
                localObject2 = this.a;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("parseConfig, blessingTips[");
                localStringBuilder.append(localBlessingTips);
                localStringBuilder.append("]");
                QLog.w((String)localObject2, 1, localStringBuilder.toString());
                i += 1;
                continue;
              }
            }
            Object localObject1 = localJSONObject.optJSONObject("triggerTips");
            if (localObject1 == null) {
              break label452;
            }
            this.l.a = ((JSONObject)localObject1).optInt("exposure_show_time_len", 5);
            this.l.b = ((JSONObject)localObject1).optInt("exposure_call_time", 2);
            this.l.d = ((JSONObject)localObject1).optInt("click_call_time", 2);
            this.l.e = ((JSONObject)localObject1).optInt("click_show_time_len", 5);
            this.l.c = ((JSONObject)localObject1).optString("exposure_show_text", this.l.c);
          }
          catch (Exception localException1) {}
          localException2.printStackTrace();
        }
      }
      catch (Exception localException2) {}
      return super.c(paramInt, paramString);
    }
  }
  
  public List<FaceItem> c(String paramString)
  {
    List localList = super.c(paramString);
    ArrayList localArrayList = new ArrayList();
    if (localList != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        int j = localList.size();
        int i = 0;
        while (i < j)
        {
          FaceItem localFaceItem = (FaceItem)localList.get(i);
          if (localFaceItem.isSameType(paramString)) {
            localArrayList.add(localFaceItem);
          }
          i += 1;
        }
      }
      localArrayList.addAll(localList);
    }
    return localArrayList;
  }
  
  public void c(long paramLong, String paramString) {}
  
  void d(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("\n");
      paramString = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("size :");
      ((StringBuilder)localObject1).append(this.t.size());
      ((StringBuilder)localObject1).append("\n");
      paramString = ((StringBuilder)localObject1).toString();
      int i = 0;
      localObject1 = this.t.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MagicFaceDataEntity)((Iterator)localObject1).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(i);
        localStringBuilder.append(":");
        localStringBuilder.append(localObject2);
        localStringBuilder.append("\n");
        paramString = localStringBuilder.toString();
        i += 1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("\ncur :");
      ((StringBuilder)localObject1).append(this.p);
      paramString = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("\nmLastPendantId :");
      ((StringBuilder)localObject1).append(this.r);
      paramString = ((StringBuilder)localObject1).toString();
      localObject1 = this.a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("printQueue, ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public FaceItem e(String paramString)
  {
    List localList = c("voicesticker");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        if (((FaceItem)localList.get(i)).voice_text != null)
        {
          int j = 0;
          while (j < ((FaceItem)localList.get(i)).voice_text.length)
          {
            if (TextUtils.equals(paramString, ((FaceItem)localList.get(i)).voice_text[j])) {
              return (FaceItem)localList.get(i);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  protected boolean e()
  {
    return true;
  }
  
  protected void f()
  {
    if ((this.e == null) || (this.e.size() == 0))
    {
      Object localObject = (FaceConfigFileProcessor)((EffectMaterialManager)this.c.c(15)).a(2);
      this.e = ((FaceConfigFileProcessor)localObject).a(AVPathUtil.k(), "face_update_template.json", "face_default_template.json");
      a(this.e);
      localObject = ((FaceConfigFileProcessor)localObject).c();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.m = new ArrayList(Arrays.asList(((String)localObject).split(",")));
      }
    }
    if ((b() == 176) && ((this.f == null) || (this.f.size() == 0))) {
      this.f = c(370, QAVConfig.b(370).b);
    }
  }
  
  protected String h()
  {
    return "resources";
  }
  
  protected Class<?> i()
  {
    return FaceItem.class;
  }
  
  public EffectFaceManager.VoiceStickerGuideTips j()
  {
    return this.l;
  }
  
  public boolean k()
  {
    MagicFaceDataEntity localMagicFaceDataEntity = this.p;
    return (localMagicFaceDataEntity != null) && (localMagicFaceDataEntity.c());
  }
  
  public ArrayList<EffectFaceManager.BlessingTips> l()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.EffectFaceManager
 * JD-Core Version:    0.7.0.1
 */