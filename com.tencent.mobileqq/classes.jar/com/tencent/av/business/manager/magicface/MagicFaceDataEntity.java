package com.tencent.av.business.manager.magicface;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lbd;
import lfe;
import lhh;
import lhi;
import lhj;
import lho;
import lid;
import loj;
import lok;
import lph;
import mbf;

public class MagicFaceDataEntity
  extends lho
{
  public int a;
  public Handler a;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  protected VideoAppInterface a;
  MagicFaceDataEntity.StopSelfDecorationRunnable jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable;
  protected BitSet a;
  protected lhh a;
  lhi jdField_a_of_type_Lhi;
  lid jdField_a_of_type_Lid;
  protected boolean a;
  int[] jdField_a_of_type_ArrayOfInt;
  protected boolean b;
  
  public MagicFaceDataEntity(VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramString3, paramString1, paramString2);
    lbd.f("MagicFaceDataEntity", "MagicFaceDataEntity constructor:" + paramString1 + "|" + paramBoolean + "|" + paramInt);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.b = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new lhj(this, Looper.getMainLooper());
    this.jdField_a_of_type_ArrayOfInt = a();
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet();
    if ((paramInt & 0x1) != 0) {
      this.jdField_a_of_type_JavaUtilBitSet.set(0);
    }
    if ((paramInt & 0x2) != 0) {
      this.jdField_a_of_type_JavaUtilBitSet.set(1);
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_Lid = ((lid)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2));
    this.jdField_a_of_type_Lhi = new lhi(this);
    this.jdField_a_of_type_Lhh = new lhh(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lhh);
    this.jdField_a_of_type_Int = 0;
  }
  
  @Nullable
  private PendantItem a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_Lid.a(null).iterator();
    PendantItem localPendantItem;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localPendantItem = (PendantItem)localIterator.next();
    } while (!paramString.equals(localPendantItem.getName()));
    for (;;)
    {
      lbd.f("MagicFaceDataEntity", "getPtvTemplateInfo 1:" + paramString + "|" + localPendantItem);
      return localPendantItem;
      localPendantItem = null;
    }
  }
  
  private void a(long paramLong, PendantItem paramPendantItem)
  {
    QLog.w("MagicFaceDataEntity", 1, "startSelfDecoration, info[" + paramPendantItem.getName() + "], seq[" + paramLong + "]");
    this.jdField_a_of_type_Lid.a(paramLong, paramPendantItem);
    if (!TextUtils.isEmpty(paramPendantItem.getName()))
    {
      String str = a(paramPendantItem.getName());
      MagicfaceDataPendantJason localMagicfaceDataPendantJason = (MagicfaceDataPendantJason)this.jdField_a_of_type_JavaUtilMap.get(str);
      lbd.f("MagicFaceDataEntity", "startSelfDecoration 2:" + str + "|" + localMagicfaceDataPendantJason);
      if ((localMagicfaceDataPendantJason != null) && (localMagicfaceDataPendantJason.duration > 0))
      {
        lbd.f("MagicFaceDataEntity", "startSelfDecoration 3:" + localMagicfaceDataPendantJason.duration);
        int i = localMagicfaceDataPendantJason.duration;
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
    short s3 = 0;
    lbd.f("MagicFaceDataEntity", "onReceiveFunChatExpData:" + paramString + "|" + paramArrayOfByte.length);
    SparseArray localSparseArray = lok.a(paramArrayOfByte);
    paramArrayOfByte = null;
    Object localObject = (loj)localSparseArray.get(1);
    loj localloj = (loj)localSparseArray.get(4);
    boolean bool;
    if (localloj != null)
    {
      paramArrayOfByte = localloj.a();
      bool = true;
    }
    for (;;)
    {
      short s2;
      short s1;
      int i;
      if (paramArrayOfByte != null)
      {
        localObject = (loj)localSparseArray.get(3);
        s2 = 320;
        s1 = 240;
        if (localObject == null) {
          break label260;
        }
        localObject = ((loj)localObject).a();
        s2 = (short)(localObject[0] << 8 | localObject[1] & 0xFF);
        s1 = (short)(localObject[2] << 8 | localObject[3] & 0xFF);
        s3 = (short)(localObject[4] << 8 | localObject[5] & 0xFF);
        i = localObject[6];
      }
      label260:
      for (short s4 = (short)(localObject[7] & 0xFF | i << 8);; s4 = 0)
      {
        a(paramString, paramArrayOfByte, s1, s2, s3, s4, bool);
        paramArrayOfByte = (loj)localSparseArray.get(2);
        if (paramArrayOfByte != null) {
          a(paramString, ByteBuffer.wrap(paramArrayOfByte.a()).getShort());
        }
        return;
        if (localObject == null) {
          break label266;
        }
        paramArrayOfByte = ((loj)localObject).a();
        bool = false;
        break;
      }
      label266:
      bool = false;
    }
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    switch (((Integer)paramArrayOfObject[0]).intValue())
    {
    default: 
      return;
    case 130: 
      a((String)paramArrayOfObject[1], (byte[])paramArrayOfObject[2]);
      return;
    case 131: 
      a(1, (String)paramArrayOfObject[1]);
      return;
    }
    a(3, (String)paramArrayOfObject[1]);
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.jdField_a_of_type_ArrayOfInt != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (this.jdField_a_of_type_ArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private int[] a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      lbd.f("MagicFaceDataEntity", "getPendantStartFrames 11:" + i);
      if (i > 0)
      {
        int[] arrayOfInt = new int[i];
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str = (String)localEntry.getKey();
          arrayOfInt[i] = ((MagicfaceDataPendantJason)localEntry.getValue()).startframe;
          lbd.f("MagicFaceDataEntity", "getPendantStartFrames 22:" + str + "|" + arrayOfInt[i]);
          i += 1;
        }
        return arrayOfInt;
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    int i;
    String str;
    label35:
    int j;
    Object localObject;
    if (localIterator != null)
    {
      i = 0;
      str = null;
      j = i;
      localObject = str;
      if (!localIterator.hasNext()) {
        break label193;
      }
      localObject = (MagicfaceDataPendantJason)((Map.Entry)localIterator.next()).getValue();
      if (TextUtils.isEmpty(((MagicfaceDataPendantJason)localObject).belongto)) {
        break label245;
      }
      if ((((MagicfaceDataPendantJason)localObject).belongto.equals("sender")) && (this.jdField_a_of_type_JavaUtilBitSet.get(0)))
      {
        str = ((MagicfaceDataPendantJason)localObject).name;
        i += 1;
      }
    }
    label193:
    label245:
    for (;;)
    {
      break label35;
      if ((((MagicfaceDataPendantJason)localObject).belongto.equals("reciever")) && (this.jdField_a_of_type_JavaUtilBitSet.get(1)))
      {
        str = ((MagicfaceDataPendantJason)localObject).name;
        i += 1;
      }
      else if (((MagicfaceDataPendantJason)localObject).belongto.equals("both"))
      {
        str = ((MagicfaceDataPendantJason)localObject).name;
        i += 1;
        continue;
        j = 0;
        localObject = null;
        lbd.f("MagicFaceDataEntity", "getDecorateNameById: " + j + "|" + paramString + "|" + (String)localObject);
        if (j != 1) {
          break;
        }
        return localObject;
      }
    }
  }
  
  private void b(String paramString)
  {
    lbd.f("MagicFaceDataEntity", "reloadDecrateList 1:" + paramString);
    PtvTemplateManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(new MagicFaceDataEntity.1(this, paramString));
  }
  
  private void c(String paramString)
  {
    lbd.f("MagicFaceDataEntity", "startSelfPendant 1:" + paramString);
    StringBuilder localStringBuilder;
    if (paramString != null)
    {
      ArrayList localArrayList = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
      if ((localArrayList != null) && (localArrayList.size() != 0)) {
        break label103;
      }
      localStringBuilder = new StringBuilder().append("startSelfPendant, infos[");
      if (localArrayList == null) {
        break label98;
      }
    }
    label98:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("MagicFaceDataEntity", 1, bool + "]");
      b(paramString);
      return;
    }
    label103:
    d(paramString);
  }
  
  private void d(String paramString)
  {
    paramString = a(paramString);
    long l;
    if (paramString != null)
    {
      l = AudioHelper.b();
      if (AudioHelper.f()) {
        QLog.w("MagicFaceDataEntity", 1, "doStartSelfDecoration, seq[" + l + "], target[" + paramString + "]");
      }
      if (!paramString.isUsable()) {
        this.jdField_a_of_type_Lid.a(l, paramString);
      }
    }
    else
    {
      return;
    }
    a(l, paramString);
  }
  
  public int a()
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
  
  public String a(int paramInt)
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
        str = paramString.substring(0, paramString.length() - "_mirror".length());
      }
    }
    return str;
  }
  
  public void a()
  {
    lbd.f("MagicFaceDataEntity", "start:" + this.jdField_a_of_type_JavaLangString + "|" + this);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2).sendToTarget();
  }
  
  public void a(int paramInt)
  {
    lbd.f("MagicFaceDataEntity", "processStartDecoration:" + this.jdField_a_of_type_JavaLangString + "|" + paramInt + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(0) + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(1));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (MagicfaceDataPendantJason)((Map.Entry)localObject).getValue();
      if ((paramInt == ((MagicfaceDataPendantJason)localObject).startframe) && (!TextUtils.isEmpty(((MagicfaceDataPendantJason)localObject).belongto))) {
        if ((((MagicfaceDataPendantJason)localObject).belongto.equals("sender")) && (this.jdField_a_of_type_JavaUtilBitSet.get(0))) {
          a((MagicfaceDataPendantJason)localObject);
        } else if ((((MagicfaceDataPendantJason)localObject).belongto.equals("reciever")) && (this.jdField_a_of_type_JavaUtilBitSet.get(1))) {
          a((MagicfaceDataPendantJason)localObject);
        } else if (((MagicfaceDataPendantJason)localObject).belongto.equals("both")) {
          a((MagicfaceDataPendantJason)localObject);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    lbd.f("MagicFaceDataEntity", "MagicFaceDataEntity run:" + paramInt1 + "|" + paramInt2 + "|");
    this.d = paramInt1;
    if (a(paramInt1))
    {
      lbd.f("MagicFaceDataEntity", " inPendantStartFrames:" + paramInt1);
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, Integer.valueOf(paramInt1)).sendToTarget();
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    lbd.f("MagicFaceDataEntity", "onReceiveFunChatExpCMD:" + paramInt + "|" + paramString);
    if (paramString != null)
    {
      lbd.f("MagicFaceDataEntity", "onReceiveFunChatExpCMD 22:" + paramInt + "|" + paramString + "|" + "START");
      if (!paramString.equals("START")) {
        break label133;
      }
      lbd.f("MagicFaceDataEntity", "onReceiveFunChatExpCMD 33:" + paramInt + "|" + paramString);
      c(paramInt);
    }
    label133:
    while (!paramString.equals("STOP")) {
      return;
    }
    b(paramInt);
  }
  
  protected void a(PendantItem paramPendantItem)
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_Lid.a(l, null);
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1016);
      return;
    }
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1016, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    lbd.f("MagicFaceDataEntity", "onReceiveVolume:" + paramString + "|" + paramInt);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, short paramShort1, short paramShort2, short paramShort3, short paramShort4, boolean paramBoolean)
  {
    lbd.f("MagicFaceDataEntity", "onReceivePeerFaceFeature:" + paramString + "|" + paramArrayOfByte.length);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "START";; str = "STOP")
    {
      lbd.f("MagicFaceDataEntity", "requestFaceFeatureExp:" + paramBoolean + "|" + str);
      this.jdField_a_of_type_ComTencentAvVideoController.a(6, str);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(0);
  }
  
  protected boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin().equals(paramString);
  }
  
  public void b()
  {
    lbd.f("MagicFaceDataEntity", "stop:" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3).sendToTarget();
  }
  
  protected void b(int paramInt)
  {
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    Object localObject = BaseApplicationImpl.getContext();
    localObject = this.jdField_a_of_type_ComTencentAvVideoController.a((Context)localObject);
    if (localObject != null) {
      ((lph)localObject).c(paramInt);
    }
    locallfe.jdField_a_of_type_JavaUtilBitSet.clear(0);
  }
  
  public void c()
  {
    lbd.f("MagicFaceDataEntity", "processStart:" + this.jdField_a_of_type_JavaLangString + "|" + this);
    this.jdField_a_of_type_Lid.a(-1041L, this.jdField_a_of_type_Lhi);
  }
  
  protected void c(int paramInt)
  {
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    Object localObject = BaseApplicationImpl.getContext();
    localObject = this.jdField_a_of_type_ComTencentAvVideoController.a((Context)localObject);
    if (localObject != null) {
      ((lph)localObject).a(paramInt);
    }
    locallfe.jdField_a_of_type_JavaUtilBitSet.set(0);
  }
  
  public void d()
  {
    lbd.f("MagicFaceDataEntity", "processStop:" + this.jdField_a_of_type_JavaLangString);
    if (a() != null) {
      a(null);
    }
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable);
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable.run();
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable = null;
    }
    this.jdField_a_of_type_Lid.b(-1042L, this.jdField_a_of_type_Lhi);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lhh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntity
 * JD-Core Version:    0.7.0.1
 */