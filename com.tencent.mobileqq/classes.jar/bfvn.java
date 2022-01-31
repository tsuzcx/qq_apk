import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qav.controller.multi.MultiOperatorImpl.1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bfvn
  extends bfvm
  implements bfvl, bfvv
{
  private int jdField_a_of_type_Int;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private bfvb jdField_a_of_type_Bfvb;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Map<Long, bfvc> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public bfvn(Context paramContext, long paramLong, bfvh parambfvh)
  {
    super(paramContext, paramLong, parambfvh);
    bfvp.c("MultiOperatorImpl", String.format("MultiOperatorImpl context=%s selfUin=%s videoChannel=%s", new Object[] { paramContext, Long.valueOf(paramLong), parambfvh }));
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    bfvs.a().a(this);
  }
  
  private bfvc a(long paramLong)
  {
    bfvc localbfvc = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localbfvc = (bfvc)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    return localbfvc;
  }
  
  private List<bfvc> a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Collection localCollection = this.jdField_a_of_type_JavaUtilMap.values();
      localObject1 = localObject2;
      if (!localCollection.isEmpty()) {
        localObject1 = new ArrayList(localCollection);
      }
    }
    return localObject1;
  }
  
  private void a(bfvc parambfvc)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(parambfvc.jdField_a_of_type_Long), parambfvc);
    }
  }
  
  private void a(bfvc parambfvc, boolean paramBoolean)
  {
    bfvy.a().a(bfvo.class, 5, new Object[] { parambfvc, Boolean.valueOf(paramBoolean) });
  }
  
  private bfvc b(long paramLong)
  {
    bfvc localbfvc = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localbfvc = (bfvc)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
    }
    return localbfvc;
  }
  
  private void b(int paramInt)
  {
    bfvp.a("MultiOperatorImpl", String.format("notifyError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    bfvy.a().a(bfvo.class, 2, new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void b(bfvc parambfvc)
  {
    bfvy.a().a(bfvo.class, 3, new Object[] { parambfvc });
  }
  
  private void c(bfvc parambfvc)
  {
    bfvy.a().a(bfvo.class, 4, new Object[] { parambfvc });
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.requestMemPosInfoList();
    }
  }
  
  private void e()
  {
    bfvp.c("MultiOperatorImpl", String.format("checkInterruptCurrentCall mHasEnterRoom=%s", new Object[] { Boolean.valueOf(this.c) }));
    if (this.c)
    {
      a();
      b(4);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    bfvp.c("MultiOperatorImpl", String.format("setLocalAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioSend(true);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioSend(true);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      this.jdField_a_of_type_JavaLangRunnable = new MultiOperatorImpl.1(this);
      bfvz.a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    bfvp.c("MultiOperatorImpl", String.format("setRemoteAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      bfvz.b(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public int a(bfvb parambfvb)
  {
    for (;;)
    {
      try
      {
        bfvp.c("MultiOperatorImpl", String.format("enterRoom param=%s", new Object[] { parambfvb }));
        boolean bool1 = bfvs.a().a();
        boolean bool2 = bfvs.a().b();
        bfvp.c("MultiOperatorImpl", String.format("enterRoom isVideoChatting=%s isPhoneCalling=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        int i;
        if ((bool1) || (bool2))
        {
          bfvp.a("MultiOperatorImpl", "enterRoom device take up.");
          i = -2;
          return i;
        }
        if (this.c)
        {
          bfvp.a("MultiOperatorImpl", "enterRoom duplicate call.");
          i = -3;
        }
        else
        {
          bfvk.a(this.jdField_a_of_type_Bfvh);
          bfvk.a(this.jdField_a_of_type_Bfvh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
          {
            this.jdField_a_of_type_Bfvb = parambfvb;
            i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startCommonGAudio(parambfvb.jdField_a_of_type_Int, parambfvb.b, parambfvb.c, parambfvb.d, this.jdField_a_of_type_Long, parambfvb.jdField_a_of_type_JavaLangString, parambfvb.e, parambfvb.jdField_a_of_type_ArrayOfByte);
            bfvp.c("MultiOperatorImpl", String.format("enterRoom result=%s", new Object[] { Integer.valueOf(i) }));
            if (i == 0) {
              f();
            }
            this.c = true;
            if (i == 0) {
              i = 0;
            } else {
              i = -1;
            }
          }
          else
          {
            i = -1;
          }
        }
      }
      finally {}
    }
  }
  
  public void a()
  {
    try
    {
      bfvp.c("MultiOperatorImpl", "exitRoom");
      this.jdField_a_of_type_Bfvb = null;
      if (this.jdField_a_of_type_JavaUtilMap != null) {
        this.jdField_a_of_type_JavaUtilMap.clear();
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.quit(0);
        g();
        this.c = false;
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
        this.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
        this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(false);
        if (Build.VERSION.SDK_INT >= 21) {
          this.jdField_a_of_type_AndroidMediaAudioManager.setMode(3);
        }
        for (;;)
        {
          this.jdField_a_of_type_Int = paramInt;
          return;
          this.jdField_a_of_type_AndroidMediaAudioManager.setMode(2);
        }
        if (paramInt != 1) {
          break label113;
        }
      }
      catch (Exception localException)
      {
        bfvp.a("MultiOperatorImpl", "setAudioRoute fail.", localException);
        return;
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
      this.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
      this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(true);
      this.jdField_a_of_type_AndroidMediaAudioManager.setMode(0);
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    label113:
    if (paramInt == 2)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.startBluetoothSco();
      this.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(true);
      this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(false);
      this.jdField_a_of_type_AndroidMediaAudioManager.setMode(3);
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    bfvp.a("MultiOperatorImpl", String.format("onGAudioSDKError relationType=%s groupId=%s reason=%s detail=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    a();
    g();
    if (paramInt2 == 15)
    {
      b(3);
      return;
    }
    b(2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    bfvc localbfvc;
    if (!paramBoolean)
    {
      bool1 = true;
      bfvp.c("MultiOperatorImpl", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool1) }));
      localbfvc = a(paramLong);
      if (localbfvc != null) {
        if (paramBoolean) {
          break label107;
        }
      }
    }
    label107:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localbfvc.jdField_a_of_type_Boolean = paramBoolean;
      if ((!TextUtils.isEmpty(localbfvc.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bfvb.jdField_a_of_type_Int != 11)) {
        a(localbfvc, bool1);
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 42) || (paramInt1 == 43))
    {
      if (paramInt1 == 42) {}
      for (boolean bool = true;; bool = false)
      {
        paramInt2 = paramArrayOfLong.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          bfvc localbfvc = a(paramArrayOfLong[paramInt1]);
          if ((localbfvc != null) && ((!TextUtils.isEmpty(localbfvc.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bfvb.jdField_a_of_type_Int != 11))) {
            bfvy.a().a(bfvo.class, 6, new Object[] { localbfvc, Boolean.valueOf(bool), Integer.valueOf(paramInt4) });
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void a(lps paramlps, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.jdField_a_of_type_Bfvb == null) {}
    do
    {
      do
      {
        return;
        if (paramInt1 == 70)
        {
          bfvp.c("MultiOperatorImpl", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramlps.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
          if (paramlps.jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0)
            {
              g();
              bfvy.a().a(bfvo.class, 1, new Object[0]);
            }
            paramVarArgs = a(paramlps.jdField_a_of_type_Long);
            if ((paramVarArgs == null) && (paramInt1 == 0)) {
              break;
            }
            paramlps = paramVarArgs;
            if (paramInt1 != 0)
            {
              paramlps = new bfvc();
              paramlps.jdField_a_of_type_Long = this.jdField_a_of_type_Bfvb.jdField_a_of_type_Long;
              paramlps.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bfvb.jdField_a_of_type_JavaLangString;
              paramlps.jdField_a_of_type_Boolean = true;
              a(paramlps);
            }
            b(paramlps);
            return;
          }
          paramVarArgs = new bfvc();
          paramVarArgs.jdField_a_of_type_Long = paramlps.jdField_a_of_type_Long;
          paramVarArgs.jdField_a_of_type_Boolean = true;
          a(paramVarArgs);
          if (this.jdField_a_of_type_Bfvb.jdField_a_of_type_Int == 11)
          {
            d();
            return;
          }
          b(paramVarArgs);
          return;
        }
      } while (paramInt1 != 71);
      bfvp.c("MultiOperatorImpl", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramlps.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
      paramlps = b(paramlps.jdField_a_of_type_Long);
    } while (paramlps == null);
    c(paramlps);
  }
  
  public void a(boolean paramBoolean)
  {
    e(paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    try
    {
      bfvp.c("MultiOperatorImpl", "updateRoomInfo");
      d();
      this.d = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    bfvp.c("MultiOperatorImpl", String.format("onGroupVideoClosed relationType=%s groupId=%s reason=%s avtype=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    a();
    g();
    b(2);
  }
  
  public void b(long paramLong, ArrayList<lps> paramArrayList)
  {
    if (this.jdField_a_of_type_Bfvb == null) {
      return;
    }
    Iterator localIterator;
    if (this.jdField_a_of_type_Bfvb.jdField_a_of_type_Int == 11) {
      localIterator = paramArrayList.iterator();
    }
    label26:
    label204:
    label208:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        lps locallps = (lps)localIterator.next();
        bfvc localbfvc = a(locallps.jdField_a_of_type_Long);
        paramArrayList = localbfvc;
        if (localbfvc == null)
        {
          paramArrayList = new bfvc();
          paramArrayList.jdField_a_of_type_Long = locallps.jdField_a_of_type_Long;
          paramArrayList.jdField_a_of_type_Boolean = true;
          a(paramArrayList);
        }
        if (!TextUtils.isEmpty(paramArrayList.jdField_a_of_type_JavaLangString)) {
          break label204;
        }
        paramArrayList.jdField_a_of_type_JavaLangString = locallps.jdField_a_of_type_JavaLangString;
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label208;
        }
        b(paramArrayList);
        if (paramArrayList.jdField_a_of_type_Boolean) {
          break label26;
        }
        a(paramArrayList, false);
        break label26;
        if (!this.d) {
          break;
        }
        paramArrayList = a();
        bfvp.c("MultiOperatorImpl", String.format("onMemberPosChanged groupId=%s userInfos=%s", new Object[] { Long.valueOf(paramLong), paramArrayList }));
        bfvy.a().a(bfvo.class, 7, new Object[] { paramArrayList });
        this.d = false;
        return;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    f(paramBoolean);
    this.b = paramBoolean;
  }
  
  public void c()
  {
    try
    {
      bfvs.a().a(null);
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_JavaUtilMap = null;
      }
      super.c();
      return;
    }
    finally {}
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      e();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      e();
    }
  }
  
  public void e(int paramInt1, long paramLong, int paramInt2)
  {
    bfvp.c("MultiOperatorImpl", String.format("onCreateRoomSuc relationType=%s groupId=%s multiAvType=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) }));
  }
  
  public void f(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfvn
 * JD-Core Version:    0.7.0.1
 */