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

public class bfre
  extends bfrd
  implements bfrc, bfrm
{
  private int jdField_a_of_type_Int;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private bfqs jdField_a_of_type_Bfqs;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Map<Long, bfqt> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public bfre(Context paramContext, long paramLong, bfqy parambfqy)
  {
    super(paramContext, paramLong, parambfqy);
    bfrg.c("MultiOperatorImpl", String.format("MultiOperatorImpl context=%s selfUin=%s videoChannel=%s", new Object[] { paramContext, Long.valueOf(paramLong), parambfqy }));
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    bfrj.a().a(this);
  }
  
  private bfqt a(long paramLong)
  {
    bfqt localbfqt = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localbfqt = (bfqt)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    return localbfqt;
  }
  
  private List<bfqt> a()
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
  
  private void a(bfqt parambfqt)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(parambfqt.jdField_a_of_type_Long), parambfqt);
    }
  }
  
  private void a(bfqt parambfqt, boolean paramBoolean)
  {
    bfrp.a().a(bfrf.class, 5, new Object[] { parambfqt, Boolean.valueOf(paramBoolean) });
  }
  
  private bfqt b(long paramLong)
  {
    bfqt localbfqt = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localbfqt = (bfqt)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
    }
    return localbfqt;
  }
  
  private void b(int paramInt)
  {
    bfrg.a("MultiOperatorImpl", String.format("notifyError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    bfrp.a().a(bfrf.class, 2, new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void b(bfqt parambfqt)
  {
    bfrp.a().a(bfrf.class, 3, new Object[] { parambfqt });
  }
  
  private void c(bfqt parambfqt)
  {
    bfrp.a().a(bfrf.class, 4, new Object[] { parambfqt });
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.requestMemPosInfoList();
    }
  }
  
  private void e()
  {
    bfrg.c("MultiOperatorImpl", String.format("checkInterruptCurrentCall mHasEnterRoom=%s", new Object[] { Boolean.valueOf(this.c) }));
    if (this.c)
    {
      a();
      b(4);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    bfrg.c("MultiOperatorImpl", String.format("setLocalAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
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
      bfrq.a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    bfrg.c("MultiOperatorImpl", String.format("setRemoteAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
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
      bfrq.b(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public int a(bfqs parambfqs)
  {
    for (;;)
    {
      try
      {
        bfrg.c("MultiOperatorImpl", String.format("enterRoom param=%s", new Object[] { parambfqs }));
        boolean bool1 = bfrj.a().a();
        boolean bool2 = bfrj.a().b();
        bfrg.c("MultiOperatorImpl", String.format("enterRoom isVideoChatting=%s isPhoneCalling=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        int i;
        if ((bool1) || (bool2))
        {
          bfrg.a("MultiOperatorImpl", "enterRoom device take up.");
          i = -2;
          return i;
        }
        if (this.c)
        {
          bfrg.a("MultiOperatorImpl", "enterRoom duplicate call.");
          i = -3;
        }
        else
        {
          bfrb.a(this.jdField_a_of_type_Bfqy);
          bfrb.a(this.jdField_a_of_type_Bfqy, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
          {
            this.jdField_a_of_type_Bfqs = parambfqs;
            i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startCommonGAudio(parambfqs.jdField_a_of_type_Int, parambfqs.b, parambfqs.c, parambfqs.d, this.jdField_a_of_type_Long, parambfqs.jdField_a_of_type_JavaLangString, parambfqs.e, parambfqs.jdField_a_of_type_ArrayOfByte);
            bfrg.c("MultiOperatorImpl", String.format("enterRoom result=%s", new Object[] { Integer.valueOf(i) }));
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
      bfrg.c("MultiOperatorImpl", "exitRoom");
      this.jdField_a_of_type_Bfqs = null;
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
        bfrg.a("MultiOperatorImpl", "setAudioRoute fail.", localException);
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
    bfrg.a("MultiOperatorImpl", String.format("onGAudioSDKError relationType=%s groupId=%s reason=%s detail=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
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
    bfqt localbfqt;
    if (!paramBoolean)
    {
      bool1 = true;
      bfrg.c("MultiOperatorImpl", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool1) }));
      localbfqt = a(paramLong);
      if (localbfqt != null) {
        if (paramBoolean) {
          break label107;
        }
      }
    }
    label107:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localbfqt.jdField_a_of_type_Boolean = paramBoolean;
      if ((!TextUtils.isEmpty(localbfqt.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bfqs.jdField_a_of_type_Int != 11)) {
        a(localbfqt, bool1);
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
          bfqt localbfqt = a(paramArrayOfLong[paramInt1]);
          if ((localbfqt != null) && ((!TextUtils.isEmpty(localbfqt.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bfqs.jdField_a_of_type_Int != 11))) {
            bfrp.a().a(bfrf.class, 6, new Object[] { localbfqt, Boolean.valueOf(bool), Integer.valueOf(paramInt4) });
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void a(lps paramlps, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.jdField_a_of_type_Bfqs == null) {}
    do
    {
      do
      {
        return;
        if (paramInt1 == 70)
        {
          bfrg.c("MultiOperatorImpl", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramlps.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
          if (paramlps.jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0)
            {
              g();
              bfrp.a().a(bfrf.class, 1, new Object[0]);
            }
            paramVarArgs = a(paramlps.jdField_a_of_type_Long);
            if ((paramVarArgs == null) && (paramInt1 == 0)) {
              break;
            }
            paramlps = paramVarArgs;
            if (paramInt1 != 0)
            {
              paramlps = new bfqt();
              paramlps.jdField_a_of_type_Long = this.jdField_a_of_type_Bfqs.jdField_a_of_type_Long;
              paramlps.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bfqs.jdField_a_of_type_JavaLangString;
              paramlps.jdField_a_of_type_Boolean = true;
              a(paramlps);
            }
            b(paramlps);
            return;
          }
          paramVarArgs = new bfqt();
          paramVarArgs.jdField_a_of_type_Long = paramlps.jdField_a_of_type_Long;
          paramVarArgs.jdField_a_of_type_Boolean = true;
          a(paramVarArgs);
          if (this.jdField_a_of_type_Bfqs.jdField_a_of_type_Int == 11)
          {
            d();
            return;
          }
          b(paramVarArgs);
          return;
        }
      } while (paramInt1 != 71);
      bfrg.c("MultiOperatorImpl", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramlps.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
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
      bfrg.c("MultiOperatorImpl", "updateRoomInfo");
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
    bfrg.c("MultiOperatorImpl", String.format("onGroupVideoClosed relationType=%s groupId=%s reason=%s avtype=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    a();
    g();
    b(2);
  }
  
  public void b(long paramLong, ArrayList<lps> paramArrayList)
  {
    if (this.jdField_a_of_type_Bfqs == null) {
      return;
    }
    Iterator localIterator;
    if (this.jdField_a_of_type_Bfqs.jdField_a_of_type_Int == 11) {
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
        bfqt localbfqt = a(locallps.jdField_a_of_type_Long);
        paramArrayList = localbfqt;
        if (localbfqt == null)
        {
          paramArrayList = new bfqt();
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
        bfrg.c("MultiOperatorImpl", String.format("onMemberPosChanged groupId=%s userInfos=%s", new Object[] { Long.valueOf(paramLong), paramArrayList }));
        bfrp.a().a(bfrf.class, 7, new Object[] { paramArrayList });
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
      bfrj.a().a(null);
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
    bfrg.c("MultiOperatorImpl", String.format("onCreateRoomSuc relationType=%s groupId=%s multiAvType=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) }));
  }
  
  public void f(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfre
 * JD-Core Version:    0.7.0.1
 */