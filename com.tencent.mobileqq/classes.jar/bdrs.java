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

public class bdrs
  extends bdrr
  implements bdrq, bdsa
{
  private int jdField_a_of_type_Int;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private bdrg jdField_a_of_type_Bdrg;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Map<Long, bdrh> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public bdrs(Context paramContext, long paramLong, bdrm parambdrm)
  {
    super(paramContext, paramLong, parambdrm);
    bdru.c("MultiOperatorImpl", String.format("MultiOperatorImpl context=%s selfUin=%s videoChannel=%s", new Object[] { paramContext, Long.valueOf(paramLong), parambdrm }));
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    bdrx.a().a(this);
  }
  
  private bdrh a(long paramLong)
  {
    bdrh localbdrh = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localbdrh = (bdrh)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    return localbdrh;
  }
  
  private List<bdrh> a()
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
  
  private void a(bdrh parambdrh)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(parambdrh.jdField_a_of_type_Long), parambdrh);
    }
  }
  
  private void a(bdrh parambdrh, boolean paramBoolean)
  {
    bdsd.a().a(bdrt.class, 5, new Object[] { parambdrh, Boolean.valueOf(paramBoolean) });
  }
  
  private bdrh b(long paramLong)
  {
    bdrh localbdrh = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localbdrh = (bdrh)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
    }
    return localbdrh;
  }
  
  private void b(int paramInt)
  {
    bdru.a("MultiOperatorImpl", String.format("notifyError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    bdsd.a().a(bdrt.class, 2, new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void b(bdrh parambdrh)
  {
    bdsd.a().a(bdrt.class, 3, new Object[] { parambdrh });
  }
  
  private void c(bdrh parambdrh)
  {
    bdsd.a().a(bdrt.class, 4, new Object[] { parambdrh });
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.requestMemPosInfoList();
    }
  }
  
  private void e()
  {
    bdru.c("MultiOperatorImpl", String.format("checkInterruptCurrentCall mHasEnterRoom=%s", new Object[] { Boolean.valueOf(this.c) }));
    if (this.c)
    {
      a();
      b(4);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    bdru.c("MultiOperatorImpl", String.format("setLocalAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
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
      bdse.a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    bdru.c("MultiOperatorImpl", String.format("setRemoteAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
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
      bdse.b(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public int a(bdrg parambdrg)
  {
    for (;;)
    {
      try
      {
        bdru.c("MultiOperatorImpl", String.format("enterRoom param=%s", new Object[] { parambdrg }));
        boolean bool1 = bdrx.a().a();
        boolean bool2 = bdrx.a().b();
        bdru.c("MultiOperatorImpl", String.format("enterRoom isVideoChatting=%s isPhoneCalling=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        int i;
        if ((bool1) || (bool2))
        {
          bdru.a("MultiOperatorImpl", "enterRoom device take up.");
          i = -2;
          return i;
        }
        if (this.c)
        {
          bdru.a("MultiOperatorImpl", "enterRoom duplicate call.");
          i = -3;
        }
        else
        {
          bdrp.a(this.jdField_a_of_type_Bdrm);
          bdrp.a(this.jdField_a_of_type_Bdrm, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
          {
            this.jdField_a_of_type_Bdrg = parambdrg;
            i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startCommonGAudio(parambdrg.jdField_a_of_type_Int, parambdrg.b, parambdrg.c, parambdrg.d, this.jdField_a_of_type_Long, parambdrg.jdField_a_of_type_JavaLangString, parambdrg.e, parambdrg.jdField_a_of_type_ArrayOfByte);
            bdru.c("MultiOperatorImpl", String.format("enterRoom result=%s", new Object[] { Integer.valueOf(i) }));
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
      bdru.c("MultiOperatorImpl", "exitRoom");
      this.jdField_a_of_type_Bdrg = null;
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
    if (paramInt == 1) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(true);
      this.jdField_a_of_type_AndroidMediaAudioManager.setMode(0);
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    catch (Exception localException)
    {
      bdru.a("MultiOperatorImpl", "setAudioRoute fail.", localException);
      return;
    }
    if (paramInt == 0)
    {
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
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    bdru.a("MultiOperatorImpl", String.format("onGAudioSDKError relationType=%s groupId=%s reason=%s detail=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
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
    bdrh localbdrh;
    if (!paramBoolean)
    {
      bool1 = true;
      bdru.c("MultiOperatorImpl", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool1) }));
      localbdrh = a(paramLong);
      if (localbdrh != null) {
        if (paramBoolean) {
          break label107;
        }
      }
    }
    label107:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localbdrh.jdField_a_of_type_Boolean = paramBoolean;
      if ((!TextUtils.isEmpty(localbdrh.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bdrg.jdField_a_of_type_Int != 11)) {
        a(localbdrh, bool1);
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3)
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
          bdrh localbdrh = a(paramArrayOfLong[paramInt1]);
          if ((localbdrh != null) && ((!TextUtils.isEmpty(localbdrh.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bdrg.jdField_a_of_type_Int != 11))) {
            bdsd.a().a(bdrt.class, 6, new Object[] { localbdrh, Boolean.valueOf(bool) });
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void a(lnu paramlnu, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.jdField_a_of_type_Bdrg == null) {}
    do
    {
      do
      {
        return;
        if (paramInt1 == 70)
        {
          bdru.c("MultiOperatorImpl", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramlnu.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
          if (paramlnu.jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0)
            {
              g();
              bdsd.a().a(bdrt.class, 1, new Object[0]);
            }
            paramVarArgs = a(paramlnu.jdField_a_of_type_Long);
            if ((paramVarArgs == null) && (paramInt1 == 0)) {
              break;
            }
            paramlnu = paramVarArgs;
            if (paramInt1 != 0)
            {
              paramlnu = new bdrh();
              paramlnu.jdField_a_of_type_Long = this.jdField_a_of_type_Bdrg.jdField_a_of_type_Long;
              paramlnu.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bdrg.jdField_a_of_type_JavaLangString;
              paramlnu.jdField_a_of_type_Boolean = true;
              a(paramlnu);
            }
            b(paramlnu);
            return;
          }
          paramVarArgs = new bdrh();
          paramVarArgs.jdField_a_of_type_Long = paramlnu.jdField_a_of_type_Long;
          paramVarArgs.jdField_a_of_type_Boolean = true;
          a(paramVarArgs);
          if (this.jdField_a_of_type_Bdrg.jdField_a_of_type_Int == 11)
          {
            d();
            return;
          }
          b(paramVarArgs);
          return;
        }
      } while (paramInt1 != 71);
      bdru.c("MultiOperatorImpl", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramlnu.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
      paramlnu = b(paramlnu.jdField_a_of_type_Long);
    } while (paramlnu == null);
    c(paramlnu);
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
      bdru.c("MultiOperatorImpl", "updateRoomInfo");
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
    bdru.c("MultiOperatorImpl", String.format("onGroupVideoClosed relationType=%s groupId=%s reason=%s avtype=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    a();
    g();
    b(2);
  }
  
  public void b(long paramLong, ArrayList<lnu> paramArrayList)
  {
    if (this.jdField_a_of_type_Bdrg == null) {
      return;
    }
    Iterator localIterator;
    if (this.jdField_a_of_type_Bdrg.jdField_a_of_type_Int == 11) {
      localIterator = paramArrayList.iterator();
    }
    label26:
    label204:
    label208:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        lnu locallnu = (lnu)localIterator.next();
        bdrh localbdrh = a(locallnu.jdField_a_of_type_Long);
        paramArrayList = localbdrh;
        if (localbdrh == null)
        {
          paramArrayList = new bdrh();
          paramArrayList.jdField_a_of_type_Long = locallnu.jdField_a_of_type_Long;
          paramArrayList.jdField_a_of_type_Boolean = true;
          a(paramArrayList);
        }
        if (!TextUtils.isEmpty(paramArrayList.jdField_a_of_type_JavaLangString)) {
          break label204;
        }
        paramArrayList.jdField_a_of_type_JavaLangString = locallnu.jdField_a_of_type_JavaLangString;
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
        bdru.c("MultiOperatorImpl", String.format("onMemberPosChanged groupId=%s userInfos=%s", new Object[] { Long.valueOf(paramLong), paramArrayList }));
        bdsd.a().a(bdrt.class, 7, new Object[] { paramArrayList });
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
      bdrx.a().a(null);
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
    bdru.c("MultiOperatorImpl", String.format("onCreateRoomSuc relationType=%s groupId=%s multiAvType=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdrs
 * JD-Core Version:    0.7.0.1
 */