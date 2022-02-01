package com.tencent.av.business.manager.magicface;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.Tlv;
import com.tencent.av.opengl.TlvUtils;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MagicFaceDataEntity
  extends MagicfaceData
{
  int jdField_a_of_type_Int;
  protected Handler a;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  protected VideoAppInterface a;
  protected MagicFaceDataEntity.MyDataObserver a;
  MagicFaceDataEntity.MyDownloadListener jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$MyDownloadListener;
  MagicFaceDataEntity.StopSelfDecorationRunnable jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable;
  EffectPendantTools jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTools;
  BitSet jdField_a_of_type_JavaUtilBitSet;
  boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  boolean b;
  
  public MagicFaceDataEntity(VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramString3, paramString1, paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("MagicFaceDataEntity constructor:");
    paramString2.append(paramString1);
    paramString2.append("|");
    paramString2.append(paramBoolean);
    paramString2.append("|");
    paramString2.append(paramInt);
    AVLog.printColorLog("MagicFaceDataEntity", paramString2.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.b = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new MagicFaceDataEntity.MyHandler(this, Looper.getMainLooper());
    this.jdField_a_of_type_ArrayOfInt = a();
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet();
    if ((paramInt & 0x1) != 0) {
      this.jdField_a_of_type_JavaUtilBitSet.set(0);
    }
    if ((paramInt & 0x2) != 0) {
      this.jdField_a_of_type_JavaUtilBitSet.set(1);
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTools = ((EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2));
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$MyDownloadListener = new MagicFaceDataEntity.MyDownloadListener(this);
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$MyDataObserver = new MagicFaceDataEntity.MyDataObserver(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$MyDataObserver);
    this.jdField_a_of_type_Int = 0;
  }
  
  @Nullable
  private PendantItem a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTools;
    StringBuilder localStringBuilder = null;
    Iterator localIterator = ((EffectPendantTools)localObject).a(null).iterator();
    do
    {
      localObject = localStringBuilder;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (PendantItem)localIterator.next();
    } while (!paramString.equals(((PendantItem)localObject).getName()));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPtvTemplateInfo 1:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|");
    localStringBuilder.append(localObject);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    return localObject;
  }
  
  private void a(long paramLong, PendantItem paramPendantItem)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startSelfDecoration, info[");
    ((StringBuilder)localObject1).append(paramPendantItem.getName());
    ((StringBuilder)localObject1).append("], seq[");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("]");
    QLog.w("MagicFaceDataEntity", 1, ((StringBuilder)localObject1).toString());
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTools.a(paramLong, paramPendantItem);
    if (!TextUtils.isEmpty(paramPendantItem.getName()))
    {
      Object localObject2 = a(paramPendantItem.getName());
      localObject1 = (MagicfaceDataPendantJason)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startSelfDecoration 2:");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("|");
      localStringBuilder.append(localObject1);
      AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
      if ((localObject1 != null) && (((MagicfaceDataPendantJason)localObject1).duration > 0))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startSelfDecoration 3:");
        ((StringBuilder)localObject2).append(((MagicfaceDataPendantJason)localObject1).duration);
        AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject2).toString());
        int i = ((MagicfaceDataPendantJason)localObject1).duration;
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable = new MagicFaceDataEntity.StopSelfDecorationRunnable(this, paramPendantItem);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable, i);
      }
    }
  }
  
  private void a(MagicfaceDataPendantJason paramMagicfaceDataPendantJason)
  {
    paramMagicfaceDataPendantJason = a(paramMagicfaceDataPendantJason);
    if (paramMagicfaceDataPendantJason != null) {
      c(paramMagicfaceDataPendantJason);
    }
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onReceiveFunChatExpData:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(paramArrayOfByte.length);
    AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject1).toString());
    localObject1 = TlvUtils.a(paramArrayOfByte);
    paramArrayOfByte = (Tlv)((SparseArray)localObject1).get(1);
    Object localObject2 = (Tlv)((SparseArray)localObject1).get(4);
    boolean bool;
    if (localObject2 != null)
    {
      paramArrayOfByte = ((Tlv)localObject2).a();
      bool = true;
    }
    else
    {
      if (paramArrayOfByte != null) {
        paramArrayOfByte = paramArrayOfByte.a();
      } else {
        paramArrayOfByte = null;
      }
      bool = false;
    }
    if (paramArrayOfByte != null)
    {
      localObject2 = (Tlv)((SparseArray)localObject1).get(3);
      short s3 = 240;
      short s2;
      short s4;
      short s1;
      if (localObject2 != null)
      {
        localObject2 = ((Tlv)localObject2).a();
        int i = localObject2[0];
        s2 = (short)(localObject2[1] & 0xFF | i << 8);
        i = localObject2[2];
        s3 = (short)(localObject2[3] & 0xFF | i << 8);
        s4 = (short)(localObject2[4] << 8 | localObject2[5] & 0xFF);
        s1 = (short)(localObject2[6] << 8 | localObject2[7] & 0xFF);
      }
      else
      {
        s2 = 320;
        s4 = 0;
        s1 = 0;
      }
      a(paramString, paramArrayOfByte, s3, s2, s4, s1, bool);
    }
    paramArrayOfByte = (Tlv)((SparseArray)localObject1).get(2);
    if (paramArrayOfByte != null) {
      a(paramString, ByteBuffer.wrap(paramArrayOfByte.a()).getShort());
    }
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    switch (((Integer)paramArrayOfObject[0]).intValue())
    {
    default: 
      return;
    case 132: 
      a(3, (String)paramArrayOfObject[1]);
      return;
    case 131: 
      a(1, (String)paramArrayOfObject[1]);
      return;
    }
    a((String)paramArrayOfObject[1], (byte[])paramArrayOfObject[2]);
  }
  
  private boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      int i = 0;
      for (;;)
      {
        int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
        if (i >= arrayOfInt.length) {
          break;
        }
        if (arrayOfInt[i] == paramInt) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private int[] a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getPendantStartFrames 11:");
      ((StringBuilder)localObject1).append(i);
      AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject1).toString());
      if (i > 0)
      {
        localObject1 = new int[i];
        i = 0;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject1[i] = ((MagicfaceDataPendantJason)((Map.Entry)localObject2).getValue()).startframe;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getPendantStartFrames 22:");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("|");
          ((StringBuilder)localObject2).append(localObject1[i]);
          AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject2).toString());
          i += 1;
        }
        return localObject1;
      }
    }
    return null;
  }
  
  @Nullable
  private String b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    int i = 0;
    String str;
    if (localObject != null)
    {
      str = null;
      i = 0;
      while (((Iterator)localObject).hasNext())
      {
        MagicfaceDataPendantJason localMagicfaceDataPendantJason = (MagicfaceDataPendantJason)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (!TextUtils.isEmpty(localMagicfaceDataPendantJason.belongto))
        {
          if ((localMagicfaceDataPendantJason.belongto.equals("sender")) && (this.jdField_a_of_type_JavaUtilBitSet.get(0))) {
            str = localMagicfaceDataPendantJason.name;
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localMagicfaceDataPendantJason.belongto.equals("reciever")) && (this.jdField_a_of_type_JavaUtilBitSet.get(1)))
            {
              str = localMagicfaceDataPendantJason.name;
            }
            else
            {
              if (!localMagicfaceDataPendantJason.belongto.equals("both")) {
                break;
              }
              str = localMagicfaceDataPendantJason.name;
            }
          }
        }
      }
    }
    else
    {
      str = null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getDecorateNameById: ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(str);
    AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject).toString());
    if (i == 1) {
      return str;
    }
    return null;
  }
  
  private void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reloadDecrateList 1:");
    localStringBuilder.append(paramString);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    PtvTemplateManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(new MagicFaceDataEntity.1(this, paramString));
  }
  
  private void c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startSelfPendant 1:");
    ((StringBuilder)localObject).append(paramString);
    AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject).toString());
    if (paramString != null)
    {
      localObject = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
      if ((localObject != null) && (((ArrayList)localObject).size() != 0))
      {
        d(paramString);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startSelfPendant, infos[");
      boolean bool;
      if (localObject != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w("MagicFaceDataEntity", 1, localStringBuilder.toString());
      b(paramString);
    }
  }
  
  private void d(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      long l = AudioHelper.b();
      if (AudioHelper.b())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doStartSelfDecoration, seq[");
        localStringBuilder.append(l);
        localStringBuilder.append("], target[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w("MagicFaceDataEntity", 1, localStringBuilder.toString());
      }
      if (!paramString.isUsable())
      {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTools.a(l, paramString);
        return;
      }
      a(l, paramString);
    }
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.frame_count;
  }
  
  public PendantItem a()
  {
    String str = b(this.jdField_a_of_type_JavaLangString);
    if (str != null) {
      return a(str);
    }
    return null;
  }
  
  String a(int paramInt)
  {
    return "video";
  }
  
  protected String a(MagicfaceDataPendantJason paramMagicfaceDataPendantJason)
  {
    return paramMagicfaceDataPendantJason.name;
  }
  
  String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.endsWith("_mirror")) {
        str = paramString.substring(0, paramString.length() - 7);
      }
    }
    return str;
  }
  
  protected void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append(this);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2).sendToTarget();
  }
  
  protected void a(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("processStartDecoration:");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilBitSet.get(0));
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilBitSet.get(1));
    AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject1).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (MagicfaceDataPendantJason)((Map.Entry)localObject2).getValue();
      if ((paramInt == ((MagicfaceDataPendantJason)localObject2).startframe) && (!TextUtils.isEmpty(((MagicfaceDataPendantJason)localObject2).belongto))) {
        if ((((MagicfaceDataPendantJason)localObject2).belongto.equals("sender")) && (this.jdField_a_of_type_JavaUtilBitSet.get(0))) {
          a((MagicfaceDataPendantJason)localObject2);
        } else if ((((MagicfaceDataPendantJason)localObject2).belongto.equals("reciever")) && (this.jdField_a_of_type_JavaUtilBitSet.get(1))) {
          a((MagicfaceDataPendantJason)localObject2);
        } else if (((MagicfaceDataPendantJason)localObject2).belongto.equals("both")) {
          a((MagicfaceDataPendantJason)localObject2);
        }
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MagicFaceDataEntity run:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    this.d = paramInt1;
    if (a(paramInt1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" inPendantStartFrames:");
      localStringBuilder.append(paramInt1);
      AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, Integer.valueOf(paramInt1)).sendToTarget();
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveFunChatExpCMD:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveFunChatExpCMD 22:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString);
      localStringBuilder.append("|");
      localStringBuilder.append("START");
      AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
      if (paramString.equals("START"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceiveFunChatExpCMD 33:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("|");
        localStringBuilder.append(paramString);
        AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
        c(paramInt);
        return;
      }
      if (paramString.equals("STOP")) {
        b(paramInt);
      }
    }
  }
  
  protected void a(PendantItem paramPendantItem)
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTools.a(l, null);
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1016);
      return;
    }
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1016, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveVolume:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, short paramShort1, short paramShort2, short paramShort3, short paramShort4, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivePeerFaceFeature:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|");
    localStringBuilder.append(paramArrayOfByte.length);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
  }
  
  protected void a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "START";
    } else {
      str = "STOP";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestFaceFeatureExp:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("|");
    localStringBuilder.append(str);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvVideoController.a(6, str);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(0);
  }
  
  protected boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin().equals(paramString);
  }
  
  protected void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3).sendToTarget();
  }
  
  protected void b(int paramInt)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    EffectsRenderController localEffectsRenderController = this.jdField_a_of_type_ComTencentAvVideoController.a(false);
    if (localEffectsRenderController != null) {
      localEffectsRenderController.c(paramInt);
    }
    localSessionInfo.jdField_a_of_type_JavaUtilBitSet.clear(0);
  }
  
  protected void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processStart:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append(this);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTools.a(-1041L, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$MyDownloadListener);
  }
  
  protected void c(int paramInt)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    EffectsRenderController localEffectsRenderController = this.jdField_a_of_type_ComTencentAvVideoController.a(true);
    if (localEffectsRenderController != null) {
      localEffectsRenderController.b(paramInt);
    }
    localSessionInfo.jdField_a_of_type_JavaUtilBitSet.set(0);
  }
  
  protected void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("processStop:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject).toString());
    if (a() != null) {
      a(null);
    }
    localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localObject);
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable.run();
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable = null;
    }
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTools.b(-1042L, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$MyDownloadListener);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$MyDataObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntity
 * JD-Core Version:    0.7.0.1
 */