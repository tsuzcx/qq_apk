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
  public static final String b;
  EffectFaceManager.VoiceStickerGuideTips jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$VoiceStickerGuideTips = new EffectFaceManager.VoiceStickerGuideTips();
  private MagicFaceDataEntity jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity;
  private MagicfacePlayer jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer = new MagicfacePlayer();
  private EffectSupportManager jdField_a_of_type_ComTencentAvBusinessManagerSupportEffectSupportManager;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Queue<MagicFaceDataEntity> jdField_a_of_type_JavaUtilQueue = new ArrayBlockingQueue(8);
  private WeakReference<MagicfaceBaseDecoder.MagicfaceRenderListener> jdField_a_of_type_MqqUtilWeakReference = new WeakReference(null);
  private ArrayList<EffectFaceManager.BlessingTips> b;
  private String c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AVPathUtil.a());
    localStringBuilder.append(176);
    localStringBuilder.append(File.separator);
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public EffectFaceManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private MagicFaceDataEntity a(FaceItem paramFaceItem, String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramFaceItem != null)
    {
      AVLog.printColorLog(this.jdField_a_of_type_JavaLangString, String.format("createMagicEntity: id=%s, senderType%s.", new Object[] { paramFaceItem.getId(), Integer.valueOf(paramInt) }));
      String str1 = paramFaceItem.getId();
      String str2 = paramFaceItem.getType();
      if ("multi_result".equalsIgnoreCase(paramFaceItem.getAttr())) {
        paramString = new MagicFaceDataEntityMultiResult(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str1, str2, paramString, paramBoolean, paramInt);
      } else {
        paramString = new MagicFaceDataEntity(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str1, str2, paramString, paramBoolean, paramInt);
      }
      paramFaceItem.lastPositionIndex = paramString.a(paramFaceItem.lastPositionIndex);
      return paramString;
    }
    return null;
  }
  
  private MagicFaceDataEntity a(String paramString, boolean paramBoolean)
  {
    paramString = (FaceItem)a(paramString);
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
        bool = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().e;
        if (!paramBoolean) {
          i = 2;
        }
        return a(paramString, (String)localObject1, bool ^ true, i);
      }
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add("config.json");
      this.jdField_a_of_type_ComTencentAvBusinessManagerChecker.a(paramString, a(paramString), b(paramString), (ArrayList)localObject2, false);
      paramString = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("prepareEntity FILE not exist: ");
      ((StringBuilder)localObject2).append(((File)localObject1).getPath());
      AVLog.printErrorLog(paramString, ((StringBuilder)localObject2).toString());
    }
    return null;
  }
  
  private void a(long paramLong, MagicFaceDataEntity paramMagicFaceDataEntity, MagicfaceBaseDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = paramMagicFaceDataEntity;
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null)
    {
      FaceItem localFaceItem = (FaceItem)a(paramMagicFaceDataEntity.b());
      if (localFaceItem != null)
      {
        String str = b(localFaceItem);
        if (!TextUtils.isEmpty(str))
        {
          if ((localFaceItem.isSameType("voicesticker")) || (localFaceItem.isSameType("face"))) {
            AVVoiceRecog.a().a(2);
          }
          this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer.a(paramLong, str, paramMagicFaceDataEntity, paramMagicfaceRenderListener, this);
        }
      }
    }
  }
  
  private boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 0)
    {
      MagicFaceDataEntity localMagicFaceDataEntity = (MagicFaceDataEntity)this.jdField_a_of_type_JavaUtilQueue.remove();
      if (AudioHelper.b())
      {
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playItemFromQueueHead, id[");
        localStringBuilder.append(localMagicFaceDataEntity);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      a(paramLong, localMagicFaceDataEntity, (MagicfaceBaseDecoder.MagicfaceRenderListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
      a(paramLong, localMagicFaceDataEntity.b());
      if (localMagicFaceDataEntity.c())
      {
        a(paramLong, 6102, null, null);
        this.c = null;
      }
      return true;
    }
    return false;
  }
  
  private void b(String paramString)
  {
    paramString = (FaceItem)a(paramString);
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
      b(i, paramString);
    }
  }
  
  private void c(String paramString)
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
    paramString = (FaceItem)a(paramString);
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
    b(i, (String)localObject);
  }
  
  public int a()
  {
    return 176;
  }
  
  public int a(int paramInt, String paramString)
  {
    long l = AudioHelper.b();
    String str = this.jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceivedMessageOfPeer, type[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(l);
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
          a(l, 6104, paramString, null);
        }
        new ControlUIObserver.RequestPlayMagicFace(l, (String)localObject, false, 4).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        a(l, 164, Integer.valueOf(0), null);
        return 0;
      }
      a(l, 6101, null, Boolean.valueOf(false));
      return 0;
    }
    if (paramInt == 1) {
      new ControlUIObserver.RequestPlayMagicFace(l, paramString, false, 4).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    return 0;
  }
  
  public EffectFaceManager.VoiceStickerGuideTips a()
  {
    return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$VoiceStickerGuideTips;
  }
  
  public FaceItem a(String paramString)
  {
    List localList = a("voicesticker");
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
  
  protected Class<?> a()
  {
    return FaceItem.class;
  }
  
  public ArrayList<EffectFaceManager.BlessingTips> a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  protected List<FaceItem> a(int paramInt, String paramString)
  {
    label453:
    label460:
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
                localBlessingTips.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("id");
                if (!((JSONObject)localObject2).has("start_date")) {
                  break label460;
                }
                localBlessingTips.jdField_a_of_type_Long = localSimpleDateFormat.parse(((JSONObject)localObject2).optString("start_date")).getTime();
                if (((JSONObject)localObject2).has("end_date")) {
                  localBlessingTips.jdField_b_of_type_Long = localSimpleDateFormat.parse(((JSONObject)localObject2).optString("end_date")).getTime();
                }
                if (((JSONObject)localObject2).has("text")) {
                  localBlessingTips.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("text");
                }
                if (((JSONObject)localObject2).has("image_url")) {
                  localBlessingTips.c = ((JSONObject)localObject2).getString("image_url");
                }
                if (((JSONObject)localObject2).has("call_time_len")) {
                  localBlessingTips.jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("call_time_len");
                }
                if (((JSONObject)localObject2).has("show_time_len")) {
                  localBlessingTips.jdField_b_of_type_Int = ((JSONObject)localObject2).getInt("show_time_len");
                }
                this.jdField_b_of_type_JavaUtilArrayList.add(localBlessingTips);
                localObject2 = this.jdField_a_of_type_JavaLangString;
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
              break label453;
            }
            this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$VoiceStickerGuideTips.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("exposure_show_time_len", 5);
            this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$VoiceStickerGuideTips.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("exposure_call_time", 2);
            this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$VoiceStickerGuideTips.c = ((JSONObject)localObject1).optInt("click_call_time", 2);
            this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$VoiceStickerGuideTips.d = ((JSONObject)localObject1).optInt("click_show_time_len", 5);
            this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$VoiceStickerGuideTips.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("exposure_show_text", this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$VoiceStickerGuideTips.jdField_a_of_type_JavaLangString);
          }
          catch (Exception localException1) {}
          localException2.printStackTrace();
        }
      }
      catch (Exception localException2) {}
      return super.a(paramInt, paramString);
    }
  }
  
  public List<FaceItem> a(String paramString)
  {
    List localList = super.a(paramString);
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
  
  protected void a()
  {
    super.a();
    EffectMutexManager localEffectMutexManager = (EffectMutexManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
    if (localEffectMutexManager != null) {
      localEffectMutexManager.a(3003, this);
    }
    this.jdField_a_of_type_ComTencentAvBusinessManagerSupportEffectSupportManager = ((EffectSupportManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5));
  }
  
  public void a(int paramInt, String paramString)
  {
    long l = AudioHelper.b();
    if (paramInt == 3003) {}
    boolean bool;
    while (paramInt == 3002)
    {
      bool = false;
      break;
    }
    if (paramInt == 3001) {}
    for (;;)
    {
      bool = true;
      break label60;
      if (paramInt != 3004) {
        if (paramInt != 3005) {
          break;
        }
      }
    }
    label60:
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MuteByOthers, seq[");
      localStringBuilder.append(l);
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
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(134) });
      a(0, null, true);
      paramString = this.jdField_a_of_type_JavaUtilQueue;
      if (paramString != null) {
        paramString.clear();
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = null;
      a(l, null);
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer.a()) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer.b();
      }
    }
  }
  
  protected void a(long paramLong, int paramInt, Object paramObject1, Object paramObject2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt), paramObject1, paramObject2 });
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
    new ControlUIObserver.ZimuRequest(paramLong, "onSessionStatusChanged", 5, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    MagicDataReport.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString1);
    MagicDataReport.a(2, paramString1);
    MagicDataReport.a(2);
  }
  
  public void a(long paramLong, String paramString)
  {
    a(paramLong, 165, Integer.valueOf(2), null);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    Object localObject1 = (MagicFaceDataEntity)this.jdField_a_of_type_JavaUtilQueue.peek();
    Object localObject2 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity;
    if ((localObject2 != null) && (((MagicFaceDataEntity)localObject2).b().equalsIgnoreCase(paramString)) && (localObject1 != null))
    {
      boolean bool2 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.a((MagicfaceData)localObject1);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilQueue.size() < 8)
        {
          a(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity);
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    if (AudioHelper.b())
    {
      localObject2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEndMagicPlay, id[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], reason[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], cur[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity);
      localStringBuilder.append("], next[");
      localStringBuilder.append(localObject1);
      localStringBuilder.append("], size[");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilQueue.size());
      localStringBuilder.append("], needBeRestore[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], mLastPendantId[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
    }
    a("onEndMagicPlay.1");
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = null;
    localObject1 = (FaceItem)a(paramString);
    if ((localObject1 != null) && ((((FaceItem)localObject1).isSameType("voicesticker")) || (((FaceItem)localObject1).isSameType("face")))) {
      AVVoiceRecog.a().b(2);
    }
    boolean bool1 = a(paramLong);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onEndMagicPlay.2_");
    ((StringBuilder)localObject1).append(bool1);
    a(((StringBuilder)localObject1).toString());
    if (!bool1)
    {
      a(paramLong, 6101, paramString, Boolean.valueOf(false));
      if (!TextUtils.isEmpty(this.c))
      {
        ((EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).a(paramLong, this.c);
        a(paramLong, 6102, null, null);
        this.c = null;
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(168), paramMessage.obj });
  }
  
  void a(MagicFaceDataEntity paramMagicFaceDataEntity)
  {
    if (paramMagicFaceDataEntity == null) {
      return;
    }
    Object localObject2 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (MagicFaceDataEntity)localIterator.next();
    } while (!((MagicFaceDataEntity)localObject1).c());
    this.jdField_a_of_type_JavaUtilQueue.offer(paramMagicFaceDataEntity);
    if (localObject1 != null)
    {
      this.jdField_a_of_type_JavaUtilQueue.remove(localObject1);
      if (!paramMagicFaceDataEntity.c()) {
        this.jdField_a_of_type_JavaUtilQueue.offer(localObject1);
      }
    }
    a("addItemToQueue");
  }
  
  void a(String paramString)
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
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilQueue.size());
      ((StringBuilder)localObject1).append("\n");
      paramString = ((StringBuilder)localObject1).toString();
      int i = 0;
      localObject1 = this.jdField_a_of_type_JavaUtilQueue.iterator();
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
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity);
      paramString = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("\nmLastPendantId :");
      ((StringBuilder)localObject1).append(this.c);
      paramString = ((StringBuilder)localObject1).toString();
      localObject1 = this.jdField_a_of_type_JavaLangString;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("printQueue, ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    if ((paramBoolean) && (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c))) {
      this.c = null;
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt, String paramString, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    StringBuilder localStringBuilder;
    if (AudioHelper.b())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop, id[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], reason[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], isSender[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity;
    if (localObject != null)
    {
      localObject = ((MagicFaceDataEntity)localObject).b();
      if ((TextUtils.isEmpty(paramString)) || (((String)localObject).equalsIgnoreCase(paramString)))
      {
        this.jdField_a_of_type_JavaUtilQueue.clear();
        localObject = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("stop dequeue");
        localStringBuilder.append(paramString);
        AVLog.printErrorLog((String)localObject, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = null;
        if (paramBoolean) {
          c(paramString);
        }
        a(l, null);
        if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer.a())
        {
          this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer.b();
          localObject = this.jdField_a_of_type_JavaLangString;
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
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101, this.jdField_a_of_type_ComTencentAvBusinessManagerPendantItemBase).sendToTarget();
      if (paramFaceItem != null)
      {
        paramFaceItem = paramFaceItem.getType();
        if ((!paramFaceItem.equalsIgnoreCase("face")) && (!paramFaceItem.equalsIgnoreCase("voicesticker")))
        {
          EffectMutexManager localEffectMutexManager = (EffectMutexManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
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
    if (AudioHelper.b())
    {
      paramFaceItem = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start, id[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], curData[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity);
      ((StringBuilder)localObject).append("], isSender[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], queue[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilQueue.size());
      ((StringBuilder)localObject).append("], isPlaying[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer.a());
      ((StringBuilder)localObject).append("], mLastPendantId[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramFaceItem, 1, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilQueue.size() < 8))
    {
      paramFaceItem = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity;
      if ((paramFaceItem == null) || (!paramString.equalsIgnoreCase(paramFaceItem.b())))
      {
        this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramMagicfaceRenderListener);
        paramFaceItem = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer;
        if ((paramFaceItem != null) && (paramFaceItem.a()))
        {
          paramFaceItem = a(paramString, paramBoolean);
          a(paramFaceItem);
          this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer.b();
        }
        else
        {
          localObject = a(paramString, paramBoolean);
          paramFaceItem = (FaceItem)localObject;
          if (localObject != null)
          {
            a(paramLong, (MagicFaceDataEntity)localObject, paramMagicfaceRenderListener);
            paramFaceItem = (FaceItem)localObject;
          }
        }
        if (paramFaceItem != null)
        {
          paramMagicfaceRenderListener = this.c;
          a(paramLong, paramString);
          int i;
          if ((paramFaceItem != null) && (paramFaceItem.b()))
          {
            paramFaceItem = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
            int j = 2;
            paramFaceItem = (EffectPendantTools)paramFaceItem.a(2);
            localObject = (PendantItem)paramFaceItem.a();
            i = j;
            if (localObject != null)
            {
              i = j;
              if (((PendantItem)localObject).isShow())
              {
                i = j;
                if (!TextUtils.isEmpty(((PendantItem)localObject).getId()))
                {
                  this.c = ((PendantItem)localObject).getId();
                  localObject = (FaceItem)a();
                  paramFaceItem.a(paramLong, null);
                  i = 1;
                }
              }
            }
          }
          else
          {
            i = 3;
            this.c = null;
          }
          paramFaceItem = this.jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("start, step[");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("], mLastPendantId[");
          ((StringBuilder)localObject).append(paramMagicfaceRenderListener);
          ((StringBuilder)localObject).append("->");
          ((StringBuilder)localObject).append(this.c);
          ((StringBuilder)localObject).append("]");
          QLog.w(paramFaceItem, 1, ((StringBuilder)localObject).toString());
        }
        if (paramBoolean) {
          b(paramString);
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
  
  protected String b()
  {
    return "resources";
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      Object localObject = (FaceConfigFileProcessor)((EffectMaterialManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(2);
      this.jdField_a_of_type_JavaUtilList = ((FaceConfigFileProcessor)localObject).a(AVPathUtil.i(), "face_update_template.json", "face_default_template.json");
      a(this.jdField_a_of_type_JavaUtilList);
      localObject = ((FaceConfigFileProcessor)localObject).b();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(((String)localObject).split(",")));
      }
    }
    if ((a() == 176) && ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0))) {
      this.jdField_b_of_type_JavaUtilList = a(370, QAVConfig.b(370).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(long paramLong, String paramString) {}
  
  public boolean b()
  {
    MagicFaceDataEntity localMagicFaceDataEntity = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity;
    return (localMagicFaceDataEntity != null) && (localMagicFaceDataEntity.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.EffectFaceManager
 * JD-Core Version:    0.7.0.1
 */