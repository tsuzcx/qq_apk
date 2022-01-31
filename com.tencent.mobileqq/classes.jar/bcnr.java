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

public class bcnr
  extends bcnq
  implements bcnp, bcnz
{
  private int jdField_a_of_type_Int;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private bcnf jdField_a_of_type_Bcnf;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Map<Long, bcng> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public bcnr(Context paramContext, long paramLong, bcnl parambcnl)
  {
    super(paramContext, paramLong, parambcnl);
    bcnt.c("MultiOperatorImpl", String.format("MultiOperatorImpl context=%s selfUin=%s videoChannel=%s", new Object[] { paramContext, Long.valueOf(paramLong), parambcnl }));
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    bcnw.a().a(this);
  }
  
  private bcng a(long paramLong)
  {
    bcng localbcng = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localbcng = (bcng)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    return localbcng;
  }
  
  private List<bcng> a()
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
  
  private void a(bcng parambcng)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(parambcng.jdField_a_of_type_Long), parambcng);
    }
  }
  
  private void a(bcng parambcng, boolean paramBoolean)
  {
    bcoc.a().a(bcns.class, 5, new Object[] { parambcng, Boolean.valueOf(paramBoolean) });
  }
  
  private bcng b(long paramLong)
  {
    bcng localbcng = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localbcng = (bcng)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
    }
    return localbcng;
  }
  
  private void b(int paramInt)
  {
    bcnt.a("MultiOperatorImpl", String.format("notifyError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    bcoc.a().a(bcns.class, 2, new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void b(bcng parambcng)
  {
    bcoc.a().a(bcns.class, 3, new Object[] { parambcng });
  }
  
  private void c(bcng parambcng)
  {
    bcoc.a().a(bcns.class, 4, new Object[] { parambcng });
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.requestMemPosInfoList();
    }
  }
  
  private void e()
  {
    bcnt.c("MultiOperatorImpl", String.format("checkInterruptCurrentCall mHasEnterRoom=%s", new Object[] { Boolean.valueOf(this.c) }));
    if (this.c)
    {
      a();
      b(4);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    bcnt.c("MultiOperatorImpl", String.format("setLocalAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
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
      bcod.a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    bcnt.c("MultiOperatorImpl", String.format("setRemoteAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
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
      bcod.b(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public int a(bcnf parambcnf)
  {
    for (;;)
    {
      try
      {
        bcnt.c("MultiOperatorImpl", String.format("enterRoom param=%s", new Object[] { parambcnf }));
        boolean bool1 = bcnw.a().a();
        boolean bool2 = bcnw.a().b();
        bcnt.c("MultiOperatorImpl", String.format("enterRoom isVideoChatting=%s isPhoneCalling=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        int i;
        if ((bool1) || (bool2))
        {
          bcnt.a("MultiOperatorImpl", "enterRoom device take up.");
          i = -2;
          return i;
        }
        if (this.c)
        {
          bcnt.a("MultiOperatorImpl", "enterRoom duplicate call.");
          i = -3;
        }
        else
        {
          bcno.a(this.jdField_a_of_type_Bcnl);
          bcno.a(this.jdField_a_of_type_Bcnl, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
          {
            this.jdField_a_of_type_Bcnf = parambcnf;
            i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startCommonGAudio(parambcnf.jdField_a_of_type_Int, parambcnf.b, parambcnf.c, parambcnf.d, this.jdField_a_of_type_Long, parambcnf.jdField_a_of_type_JavaLangString, parambcnf.e, parambcnf.jdField_a_of_type_ArrayOfByte);
            bcnt.c("MultiOperatorImpl", String.format("enterRoom result=%s", new Object[] { Integer.valueOf(i) }));
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
      bcnt.c("MultiOperatorImpl", "exitRoom");
      this.jdField_a_of_type_Bcnf = null;
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
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(true);
      this.jdField_a_of_type_AndroidMediaAudioManager.setMode(0);
      this.jdField_a_of_type_Int = paramInt;
    }
    while (paramInt != 0) {
      return;
    }
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
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    bcnt.a("MultiOperatorImpl", String.format("onGAudioSDKError relationType=%s groupId=%s reason=%s detail=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
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
    bcng localbcng;
    if (!paramBoolean)
    {
      bool1 = true;
      bcnt.c("MultiOperatorImpl", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool1) }));
      localbcng = a(paramLong);
      if (localbcng != null) {
        if (paramBoolean) {
          break label107;
        }
      }
    }
    label107:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localbcng.jdField_a_of_type_Boolean = paramBoolean;
      if ((!TextUtils.isEmpty(localbcng.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bcnf.jdField_a_of_type_Int != 11)) {
        a(localbcng, bool1);
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
          bcng localbcng = a(paramArrayOfLong[paramInt1]);
          if ((localbcng != null) && ((!TextUtils.isEmpty(localbcng.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bcnf.jdField_a_of_type_Int != 11))) {
            bcoc.a().a(bcns.class, 6, new Object[] { localbcng, Boolean.valueOf(bool) });
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void a(ldd paramldd, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.jdField_a_of_type_Bcnf == null) {}
    do
    {
      do
      {
        return;
        if (paramInt1 == 70)
        {
          bcnt.c("MultiOperatorImpl", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramldd.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
          if (paramldd.jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0)
            {
              g();
              bcoc.a().a(bcns.class, 1, new Object[0]);
            }
            paramVarArgs = a(paramldd.jdField_a_of_type_Long);
            if ((paramVarArgs == null) && (paramInt1 == 0)) {
              break;
            }
            paramldd = paramVarArgs;
            if (paramInt1 != 0)
            {
              paramldd = new bcng();
              paramldd.jdField_a_of_type_Long = this.jdField_a_of_type_Bcnf.jdField_a_of_type_Long;
              paramldd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bcnf.jdField_a_of_type_JavaLangString;
              paramldd.jdField_a_of_type_Boolean = true;
              a(paramldd);
            }
            b(paramldd);
            return;
          }
          paramVarArgs = new bcng();
          paramVarArgs.jdField_a_of_type_Long = paramldd.jdField_a_of_type_Long;
          paramVarArgs.jdField_a_of_type_Boolean = true;
          a(paramVarArgs);
          if (this.jdField_a_of_type_Bcnf.jdField_a_of_type_Int == 11)
          {
            d();
            return;
          }
          b(paramVarArgs);
          return;
        }
      } while (paramInt1 != 71);
      bcnt.c("MultiOperatorImpl", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramldd.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
      paramldd = b(paramldd.jdField_a_of_type_Long);
    } while (paramldd == null);
    c(paramldd);
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
      bcnt.c("MultiOperatorImpl", "updateRoomInfo");
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
    bcnt.c("MultiOperatorImpl", String.format("onGroupVideoClosed relationType=%s groupId=%s reason=%s avtype=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    a();
    g();
    b(2);
  }
  
  public void b(long paramLong, ArrayList<ldd> paramArrayList)
  {
    if (this.jdField_a_of_type_Bcnf == null) {
      return;
    }
    Iterator localIterator;
    if (this.jdField_a_of_type_Bcnf.jdField_a_of_type_Int == 11) {
      localIterator = paramArrayList.iterator();
    }
    label26:
    label204:
    label208:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        ldd localldd = (ldd)localIterator.next();
        bcng localbcng = a(localldd.jdField_a_of_type_Long);
        paramArrayList = localbcng;
        if (localbcng == null)
        {
          paramArrayList = new bcng();
          paramArrayList.jdField_a_of_type_Long = localldd.jdField_a_of_type_Long;
          paramArrayList.jdField_a_of_type_Boolean = true;
          a(paramArrayList);
        }
        if (!TextUtils.isEmpty(paramArrayList.jdField_a_of_type_JavaLangString)) {
          break label204;
        }
        paramArrayList.jdField_a_of_type_JavaLangString = localldd.jdField_a_of_type_JavaLangString;
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
        bcnt.c("MultiOperatorImpl", String.format("onMemberPosChanged groupId=%s userInfos=%s", new Object[] { Long.valueOf(paramLong), paramArrayList }));
        bcoc.a().a(bcns.class, 7, new Object[] { paramArrayList });
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
      bcnw.a().a(null);
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
    bcnt.c("MultiOperatorImpl", String.format("onCreateRoomSuc relationType=%s groupId=%s multiAvType=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcnr
 * JD-Core Version:    0.7.0.1
 */