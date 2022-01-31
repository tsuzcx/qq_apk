package com.tencent.av.business.manager.zimu;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.SparseArray;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.opengl.Tlv;
import com.tencent.av.opengl.TlvUtils;
import com.tencent.av.opengl.effects.EffectController;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class SpitZimuTask
  extends ARZimuTask
{
  private long jdField_a_of_type_Long;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  protected volatile boolean a;
  
  public SpitZimuTask(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject1 = TlvUtils.a(paramArrayOfByte);
    paramArrayOfByte = (Tlv)((SparseArray)localObject1).get(1);
    Object localObject2 = (Tlv)((SparseArray)localObject1).get(4);
    int i;
    if (localObject2 != null)
    {
      paramArrayOfByte = ((Tlv)localObject2).a();
      i = 1;
    }
    for (;;)
    {
      int j;
      int k;
      int m;
      label162:
      int n;
      float f1;
      label192:
      float f2;
      if (paramArrayOfByte != null)
      {
        localObject1 = (Tlv)((SparseArray)localObject1).get(3);
        if (localObject1 != null)
        {
          localObject1 = ((Tlv)localObject1).a();
          j = localObject1[0];
          k = (short)(localObject1[1] & 0xFF | j << 8);
          m = (short)(localObject1[2] << 8 | localObject1[3] & 0xFF);
          j = (short)(localObject1[4] << 8 | localObject1[5] & 0xFF);
          j = localObject1[6];
          j = (short)(localObject1[7] & 0xFF | j << 8);
          if (i != 0)
          {
            j = 4;
            n = j * 81 * 2;
            paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
            if (i == 0) {
              break label472;
            }
            f1 = paramArrayOfByte.getInt(n) / 1000000;
            if (i == 0) {
              break label483;
            }
            f2 = paramArrayOfByte.getInt(n + j) / 1000000;
            label212:
            localObject1 = new PointF(f1, f2);
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().b(paramString) == 4) {
              break label588;
            }
            f1 = m - f1;
          }
        }
      }
      label290:
      label310:
      label588:
      for (;;)
      {
        localObject2 = new PointF(f1 / m, f2 / k);
        k = j * 73 * 2;
        PointF localPointF1;
        label347:
        label367:
        PointF localPointF2;
        if (i != 0)
        {
          f1 = paramArrayOfByte.getInt(k) / 1000000;
          if (i == 0) {
            break label509;
          }
          f2 = paramArrayOfByte.getInt(k + j) / 1000000;
          localPointF1 = new PointF(f1, f2);
          k = j * 65 * 2;
          if (i == 0) {
            break label524;
          }
          f1 = paramArrayOfByte.getInt(k) / 1000000;
          if (i == 0) {
            break label535;
          }
          f2 = paramArrayOfByte.getInt(k + j) / 1000000;
          localPointF2 = new PointF(f1, f2);
          k = j * 66 * 2;
          if (i == 0) {
            break label550;
          }
          f1 = paramArrayOfByte.getInt(k) / 1000000;
          if (i == 0) {
            break label561;
          }
        }
        for (f2 = paramArrayOfByte.getInt(j + k) / 1000000;; f2 = paramArrayOfByte.getShort(j + k))
        {
          a(paramString, (PointF)localObject2, ARZimuUtil.a(localPointF2, new PointF(f1, f2), (PointF)localObject1, localPointF1));
          return;
          if (paramArrayOfByte == null) {
            break label591;
          }
          paramArrayOfByte = paramArrayOfByte.a();
          i = 0;
          break;
          j = 2;
          break label162;
          label472:
          f1 = paramArrayOfByte.getShort(n);
          break label192;
          label483:
          f2 = paramArrayOfByte.getShort(n + j);
          break label212;
          f1 = paramArrayOfByte.getShort(k);
          break label290;
          label509:
          f2 = paramArrayOfByte.getShort(k + j);
          break label310;
          f1 = paramArrayOfByte.getShort(k);
          break label347;
          f2 = paramArrayOfByte.getShort(k + j);
          break label367;
          f1 = paramArrayOfByte.getShort(k);
          break label404;
        }
        b(paramString);
        return;
        b(paramString);
        return;
      }
      label404:
      label535:
      label550:
      label561:
      label591:
      paramArrayOfByte = null;
      label524:
      i = 0;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    AVLog.c("ARZimuTask_SpitZimuTask", "onSmallScreenMoveChanged");
    SpitZimuTask.ISpitZimuTaskPlayer localISpitZimuTaskPlayer = a();
    if (localISpitZimuTaskPlayer == null) {
      return;
    }
    AVLog.c("ARZimuTask_SpitZimuTask", "taskPlayer has");
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localISpitZimuTaskPlayer.setDrawParticle(paramBoolean);
      localISpitZimuTaskPlayer.a(false);
      return;
    }
  }
  
  public int a()
  {
    return 300;
  }
  
  PointF a(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {}
    for (paramString = (SpitZimuTask.MouthLoactionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);; paramString = null)
    {
      if (paramString == null)
      {
        AVLog.c("ARZimuTask_SpitZimuTask", "tryGetMouthInfoByUin info == null");
        return null;
      }
      if (!paramString.a())
      {
        AVLog.c("ARZimuTask_SpitZimuTask", "tryGetMouthInfoByUin info.checkIsOpenMouth() = false");
        paramString.a();
        return null;
      }
      PointF localPointF = paramString.jdField_a_of_type_AndroidGraphicsPointF;
      paramString.a();
      paramString = localPointF;
      if (paramBoolean) {
        break;
      }
      paramString = localPointF;
      if (localPointF == null) {
        break;
      }
      return ARZimuTask.a(localPointF);
    }
  }
  
  SpitZimuTask.IMouthDetector a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (SpitZimuTask.IMouthDetector)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  SpitZimuTask.ISpitZimuTaskPlayer a()
  {
    ARZimuTask.IARZimuShowPlayer localIARZimuShowPlayer = super.a();
    if ((localIARZimuShowPlayer == null) || (!(localIARZimuShowPlayer instanceof SpitZimuTask.ISpitZimuTaskPlayer))) {
      return null;
    }
    return (SpitZimuTask.ISpitZimuTaskPlayer)localIARZimuShowPlayer;
  }
  
  protected List a(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    c();
    ArrayList localArrayList = new ArrayList();
    paramSentenceInfo = new SpitZimuItemTask(paramSentenceInfo, paramBoolean);
    paramSentenceInfo.a(paramBoolean);
    paramSentenceInfo.b = true;
    paramSentenceInfo.a(this.jdField_a_of_type_AndroidGraphicsTypeface, 32, null);
    localArrayList.add(paramSentenceInfo);
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    b(0);
    b(1);
    b(true);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() / 1000L);
  }
  
  void a(ARZimuItemTask paramARZimuItemTask)
  {
    AVLog.c("ARZimuTask_SpitZimuTask", "requestRender");
    SpitZimuTask.ISpitZimuTaskPlayer localISpitZimuTaskPlayer = a();
    if (localISpitZimuTaskPlayer == null) {}
    label341:
    label598:
    for (;;)
    {
      return;
      AVLog.c("ARZimuTask_SpitZimuTask", "taskPlayer has");
      if ((paramARZimuItemTask instanceof SpitZimuItemTask)) {
        paramARZimuItemTask = (SpitZimuItemTask)paramARZimuItemTask;
      }
      for (;;)
      {
        if (paramARZimuItemTask == null) {
          break label598;
        }
        Object localObject1 = a();
        Object localObject2 = b();
        String str = paramARZimuItemTask.a.jdField_a_of_type_JavaLangString;
        boolean bool;
        if ((localObject1 != null) && (str.equals(localObject1))) {
          bool = true;
        }
        for (;;)
        {
          localObject1 = a((String)localObject1, bool);
          if (localObject1 != null) {
            break label372;
          }
          localISpitZimuTaskPlayer.a(bool);
          return;
          paramARZimuItemTask = this.jdField_a_of_type_JavaUtilList.iterator();
          do
          {
            if (!paramARZimuItemTask.hasNext()) {
              break;
            }
            localObject1 = (ARZimuItemTask)paramARZimuItemTask.next();
          } while ((!((ARZimuItemTask)localObject1).b()) || (!(localObject1 instanceof SpitZimuItemTask)));
          paramARZimuItemTask = (SpitZimuItemTask)localObject1;
          break;
          if ((localObject2 != null) && (str.equals(localObject2)))
          {
            localObject1 = localObject2;
            bool = false;
          }
          else
          {
            if (localObject1 != null)
            {
              AVLog.c("ARZimuTask_SpitZimuTask", "requestRender uin not equal currentPlayUin=" + (String)localObject1 + " taskUin=" + str);
              paramARZimuItemTask.b = false;
              return;
            }
            if (localObject2 != null)
            {
              AVLog.c("ARZimuTask_SpitZimuTask", "requestRender uin not equal smallScreenUin=" + (String)localObject2 + " taskUin=" + str);
              paramARZimuItemTask.b = false;
              return;
            }
            localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
            if ((localObject1 == null) || (!str.equals(localObject1))) {
              break label341;
            }
            AVLog.c("ARZimuTask_SpitZimuTask", "requestRender uin not equal currentPlayUin&smallScreenUin=null selfUin=" + (String)localObject1 + " taskUin=" + str);
            bool = true;
          }
        }
        AVLog.c("ARZimuTask_SpitZimuTask", "requestRender uin not equal currentPlayUin&smallScreenUin&selfUin=null taskUin=" + str);
        paramARZimuItemTask.b = false;
        return;
        label372:
        AVLog.c("ARZimuTask_SpitZimuTask", "requestRender spitZimuItemTask=" + paramARZimuItemTask.a.jdField_a_of_type_JavaLangCharSequence);
        localISpitZimuTaskPlayer.a(((PointF)localObject1).x, ((PointF)localObject1).y, bool);
        AVLog.c("ARZimuTask_SpitZimuTask", "requestRender updateEmitterLocation=" + ((PointF)localObject1).x + "|" + ((PointF)localObject1).y);
        localObject1 = paramARZimuItemTask.b();
        if (localObject1 != null)
        {
          int i = ((Bitmap)localObject1).getWidth();
          int j = ((Bitmap)localObject1).getHeight();
          int k = ((Bitmap)localObject1).getByteCount();
          localObject2 = ByteBuffer.allocate(k);
          ((Bitmap)localObject1).copyPixelsToBuffer((Buffer)localObject2);
          localISpitZimuTaskPlayer.a(((ByteBuffer)localObject2).array(), i, j, bool);
          AVLog.c("ARZimuTask_SpitZimuTask", "requestRender updateParticleTexture=" + i + "|" + j + "|" + k);
          paramARZimuItemTask.b = false;
        }
        if (!paramARZimuItemTask.a.a()) {
          break;
        }
        localISpitZimuTaskPlayer.a(bool);
        return;
        paramARZimuItemTask = null;
      }
    }
  }
  
  public void a(SpitZimuTask.IMouthDetector paramIMouthDetector)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIMouthDetector);
  }
  
  void a(String paramString, PointF paramPointF, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      localObject = (SpitZimuTask.MouthLoactionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (((SpitZimuTask.MouthLoactionInfo)localObject).jdField_a_of_type_AndroidGraphicsPointF == null) {
        AVLog.c("ARZimuTask_SpitZimuTask", "updateMouthInfo temp == null is:|" + paramString + "|" + paramPointF.x + "|" + paramPointF.y);
      }
      ((SpitZimuTask.MouthLoactionInfo)localObject).a(paramPointF);
      ((SpitZimuTask.MouthLoactionInfo)localObject).jdField_a_of_type_Boolean = paramBoolean;
      if (paramBoolean)
      {
        ((SpitZimuTask.MouthLoactionInfo)localObject).jdField_a_of_type_Long = System.currentTimeMillis();
        if ((paramPointF.x >= 0.0F) && (paramPointF.y >= 0.0F)) {
          a(paramString, (SpitZimuTask.MouthLoactionInfo)localObject);
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  paramPointF = a();
                } while (paramPointF == null);
                localObject = a();
                str = b();
                if ((localObject != null) && (((String)localObject).equals(paramString)))
                {
                  paramPointF.a(true);
                  return;
                }
                if ((str != null) && (str.equals(paramString)))
                {
                  paramPointF.a(false);
                  return;
                }
                localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
              } while ((localObject == null) || (!((String)localObject).equals(paramString)));
              paramPointF.a(true);
              return;
              if (System.currentTimeMillis() - ((SpitZimuTask.MouthLoactionInfo)localObject).jdField_a_of_type_Long <= 1500L) {
                break;
              }
              paramPointF = a();
            } while (paramPointF == null);
            localObject = a();
            str = b();
            if ((localObject != null) && (((String)localObject).equals(paramString)))
            {
              paramPointF.a(true);
              return;
            }
            if ((str != null) && (str.equals(paramString)))
            {
              paramPointF.a(false);
              return;
            }
            localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
          } while ((localObject == null) || (!((String)localObject).equals(paramString)));
          paramPointF.a(true);
          return;
          if ((paramPointF.x > 0.0F) && (paramPointF.y > 0.0F))
          {
            a(paramString, (SpitZimuTask.MouthLoactionInfo)localObject);
            return;
          }
          paramPointF = a();
        } while (paramPointF == null);
        localObject = a();
        String str = b();
        if ((localObject != null) && (((String)localObject).equals(paramString)))
        {
          paramPointF.a(true);
          return;
        }
        if ((str != null) && (str.equals(paramString)))
        {
          paramPointF.a(false);
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      } while ((localObject == null) || (!((String)localObject).equals(paramString)));
      paramPointF.a(true);
      return;
    }
    Object localObject = new SpitZimuTask.MouthLoactionInfo();
    ((SpitZimuTask.MouthLoactionInfo)localObject).a(paramPointF);
    ((SpitZimuTask.MouthLoactionInfo)localObject).jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      ((SpitZimuTask.MouthLoactionInfo)localObject).jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    AVLog.c("ARZimuTask_SpitZimuTask", "updateMouthInfo is:|" + paramString + "|" + paramPointF.x + "|" + paramPointF.y);
  }
  
  void a(String paramString, SpitZimuTask.MouthLoactionInfo paramMouthLoactionInfo)
  {
    if (paramString == null) {}
    SpitZimuTask.ISpitZimuTaskPlayer localISpitZimuTaskPlayer;
    SpitZimuTask.MouthLoactionInfo localMouthLoactionInfo;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localISpitZimuTaskPlayer = a();
          } while (localISpitZimuTaskPlayer == null);
          localMouthLoactionInfo = paramMouthLoactionInfo;
          if (paramMouthLoactionInfo == null)
          {
            localMouthLoactionInfo = paramMouthLoactionInfo;
            if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
              localMouthLoactionInfo = (SpitZimuTask.MouthLoactionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
            }
          }
        } while (localMouthLoactionInfo == null);
        paramMouthLoactionInfo = a();
        if ((paramMouthLoactionInfo == null) || (!paramMouthLoactionInfo.equals(paramString))) {
          break;
        }
      } while (!localMouthLoactionInfo.a());
      localISpitZimuTaskPlayer.a(localMouthLoactionInfo.jdField_a_of_type_AndroidGraphicsPointF.x, localMouthLoactionInfo.jdField_a_of_type_AndroidGraphicsPointF.y, true);
      return;
      paramMouthLoactionInfo = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    } while ((paramMouthLoactionInfo == null) || (!paramMouthLoactionInfo.equals(paramString)) || (!localMouthLoactionInfo.a()));
    localISpitZimuTaskPlayer.a(localMouthLoactionInfo.jdField_a_of_type_AndroidGraphicsPointF.x, localMouthLoactionInfo.jdField_a_of_type_AndroidGraphicsPointF.y, true);
  }
  
  protected void a(Observable paramObservable, Object paramObject)
  {
    super.a(paramObservable, paramObject);
    paramObservable = (Object[])paramObject;
    int i = ((Integer)paramObservable[0]).intValue();
    switch (i)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              a((String)paramObservable[1], (byte[])paramObservable[2]);
              return;
              c(((Boolean)paramObservable[1]).booleanValue());
              return;
            } while (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$IARZimuShowPlayer == null);
            AVLog.c("ARZimuTask_SpitZimuTask", "handleSubNotify msgType:" + i);
          } while (!this.jdField_a_of_type_Boolean);
          this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$IARZimuShowPlayer.b();
          this.jdField_a_of_type_Boolean = false;
          return;
        } while (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$IARZimuShowPlayer == null);
        this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$IARZimuShowPlayer.a();
        this.jdField_a_of_type_Boolean = true;
        return;
      } while (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$IARZimuShowPlayer == null);
      paramObservable = a();
    } while (paramObservable == null);
    paramObservable.a(true);
    paramObservable.a(false);
  }
  
  public void b()
  {
    super.b();
    c(0);
    c(1);
    b(false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    SpitZimuTask.ISpitZimuTaskPlayer localISpitZimuTaskPlayer = a();
    if (localISpitZimuTaskPlayer != null)
    {
      localISpitZimuTaskPlayer.a(true);
      localISpitZimuTaskPlayer.a(false);
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((SpitZimuTask.IMouthDetector)localObject).a();
      if (localObject != null) {
        ((VideoController)localObject).a(((VideoController)localObject).a()).b(paramInt);
      }
    }
  }
  
  void b(String paramString)
  {
    SpitZimuTask.ISpitZimuTaskPlayer localISpitZimuTaskPlayer;
    String str2;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      ((SpitZimuTask.MouthLoactionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString)).a();
      localISpitZimuTaskPlayer = a();
      if (localISpitZimuTaskPlayer != null)
      {
        String str1 = a();
        str2 = b();
        if (!str1.equals(paramString)) {
          break label63;
        }
        localISpitZimuTaskPlayer.a(true);
      }
    }
    label63:
    while (!str2.equals(paramString)) {
      return;
    }
    localISpitZimuTaskPlayer.a(false);
  }
  
  protected void b(boolean paramBoolean)
  {
    Object localObject = a();
    VideoController localVideoController;
    if (localObject != null)
    {
      localVideoController = ((SpitZimuTask.IMouthDetector)localObject).a();
      if (localVideoController != null) {
        if (!paramBoolean) {
          break label72;
        }
      }
    }
    label72:
    for (localObject = "START";; localObject = "STOP")
    {
      AVLog.c("ARZimuTask_SpitZimuTask", "requestFaceFeatureExp:" + paramBoolean + "|" + (String)localObject);
      localVideoController.a(6, (String)localObject);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((SpitZimuTask.IMouthDetector)localObject).a();
      if (localObject != null) {
        ((VideoController)localObject).a(((VideoController)localObject).a()).c(paramInt);
      }
    }
  }
  
  public String d()
  {
    return "spit";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.SpitZimuTask
 * JD-Core Version:    0.7.0.1
 */