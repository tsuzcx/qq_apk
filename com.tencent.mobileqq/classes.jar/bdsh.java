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

public class bdsh
  extends bdsg
  implements bdsf, bdsp
{
  private int jdField_a_of_type_Int;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private bdrv jdField_a_of_type_Bdrv;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Map<Long, bdrw> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public bdsh(Context paramContext, long paramLong, bdsb parambdsb)
  {
    super(paramContext, paramLong, parambdsb);
    bdsj.c("MultiOperatorImpl", String.format("MultiOperatorImpl context=%s selfUin=%s videoChannel=%s", new Object[] { paramContext, Long.valueOf(paramLong), parambdsb }));
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    bdsm.a().a(this);
  }
  
  private bdrw a(long paramLong)
  {
    bdrw localbdrw = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localbdrw = (bdrw)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    return localbdrw;
  }
  
  private List<bdrw> a()
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
  
  private void a(bdrw parambdrw)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(parambdrw.jdField_a_of_type_Long), parambdrw);
    }
  }
  
  private void a(bdrw parambdrw, boolean paramBoolean)
  {
    bdss.a().a(bdsi.class, 5, new Object[] { parambdrw, Boolean.valueOf(paramBoolean) });
  }
  
  private bdrw b(long paramLong)
  {
    bdrw localbdrw = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localbdrw = (bdrw)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
    }
    return localbdrw;
  }
  
  private void b(int paramInt)
  {
    bdsj.a("MultiOperatorImpl", String.format("notifyError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    bdss.a().a(bdsi.class, 2, new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void b(bdrw parambdrw)
  {
    bdss.a().a(bdsi.class, 3, new Object[] { parambdrw });
  }
  
  private void c(bdrw parambdrw)
  {
    bdss.a().a(bdsi.class, 4, new Object[] { parambdrw });
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.requestMemPosInfoList();
    }
  }
  
  private void e()
  {
    bdsj.c("MultiOperatorImpl", String.format("checkInterruptCurrentCall mHasEnterRoom=%s", new Object[] { Boolean.valueOf(this.c) }));
    if (this.c)
    {
      a();
      b(4);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    bdsj.c("MultiOperatorImpl", String.format("setLocalAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
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
      bdst.a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    bdsj.c("MultiOperatorImpl", String.format("setRemoteAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
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
      bdst.b(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public int a(bdrv parambdrv)
  {
    for (;;)
    {
      try
      {
        bdsj.c("MultiOperatorImpl", String.format("enterRoom param=%s", new Object[] { parambdrv }));
        boolean bool1 = bdsm.a().a();
        boolean bool2 = bdsm.a().b();
        bdsj.c("MultiOperatorImpl", String.format("enterRoom isVideoChatting=%s isPhoneCalling=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        int i;
        if ((bool1) || (bool2))
        {
          bdsj.a("MultiOperatorImpl", "enterRoom device take up.");
          i = -2;
          return i;
        }
        if (this.c)
        {
          bdsj.a("MultiOperatorImpl", "enterRoom duplicate call.");
          i = -3;
        }
        else
        {
          bdse.a(this.jdField_a_of_type_Bdsb);
          bdse.a(this.jdField_a_of_type_Bdsb, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
          {
            this.jdField_a_of_type_Bdrv = parambdrv;
            i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startCommonGAudio(parambdrv.jdField_a_of_type_Int, parambdrv.b, parambdrv.c, parambdrv.d, this.jdField_a_of_type_Long, parambdrv.jdField_a_of_type_JavaLangString, parambdrv.e, parambdrv.jdField_a_of_type_ArrayOfByte);
            bdsj.c("MultiOperatorImpl", String.format("enterRoom result=%s", new Object[] { Integer.valueOf(i) }));
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
      bdsj.c("MultiOperatorImpl", "exitRoom");
      this.jdField_a_of_type_Bdrv = null;
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
      bdsj.a("MultiOperatorImpl", "setAudioRoute fail.", localException);
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
    bdsj.a("MultiOperatorImpl", String.format("onGAudioSDKError relationType=%s groupId=%s reason=%s detail=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
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
    bdrw localbdrw;
    if (!paramBoolean)
    {
      bool1 = true;
      bdsj.c("MultiOperatorImpl", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool1) }));
      localbdrw = a(paramLong);
      if (localbdrw != null) {
        if (paramBoolean) {
          break label107;
        }
      }
    }
    label107:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localbdrw.jdField_a_of_type_Boolean = paramBoolean;
      if ((!TextUtils.isEmpty(localbdrw.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bdrv.jdField_a_of_type_Int != 11)) {
        a(localbdrw, bool1);
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
          bdrw localbdrw = a(paramArrayOfLong[paramInt1]);
          if ((localbdrw != null) && ((!TextUtils.isEmpty(localbdrw.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bdrv.jdField_a_of_type_Int != 11))) {
            bdss.a().a(bdsi.class, 6, new Object[] { localbdrw, Boolean.valueOf(bool) });
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void a(lnp paramlnp, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.jdField_a_of_type_Bdrv == null) {}
    do
    {
      do
      {
        return;
        if (paramInt1 == 70)
        {
          bdsj.c("MultiOperatorImpl", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramlnp.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
          if (paramlnp.jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0)
            {
              g();
              bdss.a().a(bdsi.class, 1, new Object[0]);
            }
            paramVarArgs = a(paramlnp.jdField_a_of_type_Long);
            if ((paramVarArgs == null) && (paramInt1 == 0)) {
              break;
            }
            paramlnp = paramVarArgs;
            if (paramInt1 != 0)
            {
              paramlnp = new bdrw();
              paramlnp.jdField_a_of_type_Long = this.jdField_a_of_type_Bdrv.jdField_a_of_type_Long;
              paramlnp.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bdrv.jdField_a_of_type_JavaLangString;
              paramlnp.jdField_a_of_type_Boolean = true;
              a(paramlnp);
            }
            b(paramlnp);
            return;
          }
          paramVarArgs = new bdrw();
          paramVarArgs.jdField_a_of_type_Long = paramlnp.jdField_a_of_type_Long;
          paramVarArgs.jdField_a_of_type_Boolean = true;
          a(paramVarArgs);
          if (this.jdField_a_of_type_Bdrv.jdField_a_of_type_Int == 11)
          {
            d();
            return;
          }
          b(paramVarArgs);
          return;
        }
      } while (paramInt1 != 71);
      bdsj.c("MultiOperatorImpl", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramlnp.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
      paramlnp = b(paramlnp.jdField_a_of_type_Long);
    } while (paramlnp == null);
    c(paramlnp);
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
      bdsj.c("MultiOperatorImpl", "updateRoomInfo");
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
    bdsj.c("MultiOperatorImpl", String.format("onGroupVideoClosed relationType=%s groupId=%s reason=%s avtype=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    a();
    g();
    b(2);
  }
  
  public void b(long paramLong, ArrayList<lnp> paramArrayList)
  {
    if (this.jdField_a_of_type_Bdrv == null) {
      return;
    }
    Iterator localIterator;
    if (this.jdField_a_of_type_Bdrv.jdField_a_of_type_Int == 11) {
      localIterator = paramArrayList.iterator();
    }
    label26:
    label204:
    label208:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        lnp locallnp = (lnp)localIterator.next();
        bdrw localbdrw = a(locallnp.jdField_a_of_type_Long);
        paramArrayList = localbdrw;
        if (localbdrw == null)
        {
          paramArrayList = new bdrw();
          paramArrayList.jdField_a_of_type_Long = locallnp.jdField_a_of_type_Long;
          paramArrayList.jdField_a_of_type_Boolean = true;
          a(paramArrayList);
        }
        if (!TextUtils.isEmpty(paramArrayList.jdField_a_of_type_JavaLangString)) {
          break label204;
        }
        paramArrayList.jdField_a_of_type_JavaLangString = locallnp.jdField_a_of_type_JavaLangString;
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
        bdsj.c("MultiOperatorImpl", String.format("onMemberPosChanged groupId=%s userInfos=%s", new Object[] { Long.valueOf(paramLong), paramArrayList }));
        bdss.a().a(bdsi.class, 7, new Object[] { paramArrayList });
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
      bdsm.a().a(null);
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
    bdsj.c("MultiOperatorImpl", String.format("onCreateRoomSuc relationType=%s groupId=%s multiAvType=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) }));
  }
  
  public void g(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsh
 * JD-Core Version:    0.7.0.1
 */