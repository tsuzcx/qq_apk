import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.VideoConstants.ThirdCallType;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qav.controller.multi.MultiOperatorImpl.1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bjco
  extends bjcn
  implements bjcm, bjcw
{
  private int jdField_a_of_type_Int;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected bjcd a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  protected Map<Long, QavDef.MultiUserInfo> a;
  protected boolean a;
  protected boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public bjco(Context paramContext, long paramLong, bjci parambjci)
  {
    super(paramContext, paramLong, parambjci);
    bjcq.c("MultiOperatorImpl", String.format("MultiOperatorImpl context=%s selfUin=%s videoChannel=%s", new Object[] { paramContext, Long.valueOf(paramLong), parambjci }));
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    bjct.a().a(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.requestMemPosInfoList();
    }
  }
  
  private void e(boolean paramBoolean)
  {
    bjcq.c("MultiOperatorImpl", String.format("setLocalAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
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
  
  private void f(boolean paramBoolean)
  {
    bjcq.c("MultiOperatorImpl", String.format("setRemoteAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
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
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(bjcd parambjcd)
  {
    for (;;)
    {
      try
      {
        bjcq.c("MultiOperatorImpl", String.format("enterRoom param=%s", new Object[] { parambjcd }));
        boolean bool1 = bjct.a().a();
        boolean bool2 = bjct.a().b();
        bjcq.c("MultiOperatorImpl", String.format("enterRoom isVideoChatting=%s isPhoneCalling=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        if ((bool1) || (bool2))
        {
          bjcq.a("MultiOperatorImpl", "enterRoom device take up.");
          i = -2;
          return i;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          bjcq.a("MultiOperatorImpl", "enterRoom duplicate call.");
          i = -3;
          continue;
        }
        bjcl.a(this.jdField_a_of_type_Bjci);
        bjcl.a(this.jdField_a_of_type_Bjci, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long);
        i = -1;
        int j = i;
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
        {
          this.jdField_a_of_type_Bjcd = parambjcd;
          if (parambjcd.e == 1)
          {
            i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startCommonGAudio(parambjcd.jdField_a_of_type_Int, parambjcd.b, parambjcd.c, parambjcd.d, this.jdField_a_of_type_Long, parambjcd.jdField_a_of_type_JavaLangString, parambjcd.e, parambjcd.jdField_a_of_type_ArrayOfByte, 0);
            bjcq.c("MultiOperatorImpl", String.format("enterRoom result=%s", new Object[] { Integer.valueOf(i) }));
            if (i == 0) {
              h();
            }
            this.jdField_a_of_type_Boolean = true;
            this.b = false;
            j = i;
          }
          else
          {
            if (parambjcd.e != 2) {
              continue;
            }
            i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.commonRequest(parambjcd.jdField_a_of_type_Int, parambjcd.d, parambjcd.b, parambjcd.c, parambjcd.e, 0, 8, "", parambjcd.e, parambjcd.jdField_a_of_type_ArrayOfByte, parambjcd.f);
            continue;
            i = -1;
            continue;
          }
        }
        if (j != 0) {
          continue;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  protected QavDef.MultiUserInfo a(long paramLong)
  {
    QavDef.MultiUserInfo localMultiUserInfo = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localMultiUserInfo = (QavDef.MultiUserInfo)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    return localMultiUserInfo;
  }
  
  protected List<QavDef.MultiUserInfo> a()
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
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    bjcq.a("MultiOperatorImpl", String.format("onGAudioSDKError relationType=%s groupId=%s reason=%s detail=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    e();
    i();
    if (paramInt2 == 15)
    {
      c(3);
      return;
    }
    c(2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    QavDef.MultiUserInfo localMultiUserInfo;
    if (!paramBoolean)
    {
      bool1 = true;
      bjcq.c("MultiOperatorImpl", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool1) }));
      localMultiUserInfo = a(paramLong);
      if (localMultiUserInfo != null) {
        if (paramBoolean) {
          break label106;
        }
      }
    }
    label106:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localMultiUserInfo.mMicOn = paramBoolean;
      if ((!TextUtils.isEmpty(localMultiUserInfo.mOpenId)) || (this.jdField_a_of_type_Bjcd.jdField_a_of_type_Int != 11)) {
        a(localMultiUserInfo, bool1);
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
          QavDef.MultiUserInfo localMultiUserInfo = a(paramArrayOfLong[paramInt1]);
          if ((localMultiUserInfo != null) && ((!TextUtils.isEmpty(localMultiUserInfo.mOpenId)) || (this.jdField_a_of_type_Bjcd.jdField_a_of_type_Int != 11))) {
            bjcz.a().a(bjcp.class, 6, new Object[] { localMultiUserInfo, Boolean.valueOf(bool), Integer.valueOf(paramInt4) });
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  protected void a(VideoConstants.ThirdCallType paramThirdCallType, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bjcq.c("MultiOperatorImpl", String.format("checkInterruptCurrentCall callType[%s], enterRoom[%s]", new Object[] { paramThirdCallType, Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
      if (this.jdField_a_of_type_Boolean)
      {
        e();
        c(4);
      }
    }
  }
  
  protected void a(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramMultiUserInfo.mUin), paramMultiUserInfo);
    }
  }
  
  protected void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    bjcz.a().a(bjcp.class, 5, new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) });
  }
  
  public void a(lmp paramlmp, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.jdField_a_of_type_Bjcd == null) {}
    do
    {
      do
      {
        return;
        if (paramInt1 == 70)
        {
          bjcq.c("MultiOperatorImpl", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramlmp.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
          if (paramlmp.jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0)
            {
              i();
              bjcz.a().a(bjcp.class, 1, new Object[0]);
            }
            paramVarArgs = a(paramlmp.jdField_a_of_type_Long);
            if ((paramVarArgs == null) && (paramInt1 == 0)) {
              break;
            }
            paramlmp = paramVarArgs;
            if (paramInt1 != 0)
            {
              paramlmp = new QavDef.MultiUserInfo();
              paramlmp.mUin = this.jdField_a_of_type_Bjcd.jdField_a_of_type_Long;
              paramlmp.mOpenId = this.jdField_a_of_type_Bjcd.jdField_a_of_type_JavaLangString;
              paramlmp.mMicOn = true;
              a(paramlmp);
            }
            b(paramlmp);
            return;
          }
          paramVarArgs = new QavDef.MultiUserInfo();
          paramVarArgs.mUin = paramlmp.jdField_a_of_type_Long;
          paramVarArgs.mMicOn = true;
          a(paramVarArgs);
          if (this.jdField_a_of_type_Bjcd.jdField_a_of_type_Int == 11)
          {
            a();
            return;
          }
          b(paramVarArgs);
          return;
        }
      } while (paramInt1 != 71);
      bjcq.c("MultiOperatorImpl", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramlmp.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
      paramlmp = b(paramlmp.jdField_a_of_type_Long);
    } while (paramlmp == null);
    c(paramlmp);
  }
  
  public void a(boolean paramBoolean)
  {
    e(paramBoolean);
    this.c = paramBoolean;
  }
  
  protected QavDef.MultiUserInfo b(long paramLong)
  {
    QavDef.MultiUserInfo localMultiUserInfo = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localMultiUserInfo = (QavDef.MultiUserInfo)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
    }
    return localMultiUserInfo;
  }
  
  public void b(int paramInt)
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
        bjcq.a("MultiOperatorImpl", "setAudioRoute fail.", localException);
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
  
  public void b(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    bjcq.c("MultiOperatorImpl", String.format("onGroupVideoClosed relationType=%s groupId=%s reason=%s avtype=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    e();
    i();
    c(2);
  }
  
  public void b(long paramLong, ArrayList<lmp> paramArrayList)
  {
    if (this.jdField_a_of_type_Bjcd == null) {
      return;
    }
    Iterator localIterator;
    if (this.jdField_a_of_type_Bjcd.jdField_a_of_type_Int == 11) {
      localIterator = paramArrayList.iterator();
    }
    label26:
    label204:
    label208:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        lmp locallmp = (lmp)localIterator.next();
        QavDef.MultiUserInfo localMultiUserInfo = a(locallmp.jdField_a_of_type_Long);
        paramArrayList = localMultiUserInfo;
        if (localMultiUserInfo == null)
        {
          paramArrayList = new QavDef.MultiUserInfo();
          paramArrayList.mUin = locallmp.jdField_a_of_type_Long;
          paramArrayList.mMicOn = true;
          a(paramArrayList);
        }
        if (!TextUtils.isEmpty(paramArrayList.mOpenId)) {
          break label204;
        }
        paramArrayList.mOpenId = locallmp.jdField_a_of_type_JavaLangString;
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label208;
        }
        b(paramArrayList);
        if (paramArrayList.mMicOn) {
          break label26;
        }
        a(paramArrayList, false);
        break label26;
        if (!this.e) {
          break;
        }
        paramArrayList = a();
        bjcq.c("MultiOperatorImpl", String.format("onMemberPosChanged groupId=%s userInfos=%s", new Object[] { Long.valueOf(paramLong), paramArrayList }));
        bjcz.a().a(bjcp.class, 7, new Object[] { paramArrayList });
        this.e = false;
        return;
      }
    }
  }
  
  protected void b(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    bjcz.a().a(bjcp.class, 3, new Object[] { paramMultiUserInfo });
  }
  
  public void b(boolean paramBoolean)
  {
    f(paramBoolean);
    this.d = paramBoolean;
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    bjcq.a("MultiOperatorImpl", String.format("notifyError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    bjcz.a().a(bjcp.class, 2, new Object[] { Integer.valueOf(paramInt) });
  }
  
  protected void c(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    bjcz.a().a(bjcp.class, 4, new Object[] { paramMultiUserInfo });
  }
  
  public void c(boolean paramBoolean)
  {
    a(VideoConstants.ThirdCallType.AV_CHAT, paramBoolean);
  }
  
  public void d() {}
  
  public void d(boolean paramBoolean)
  {
    a(VideoConstants.ThirdCallType.SYSTEM_CALL, paramBoolean);
  }
  
  public void e()
  {
    try
    {
      bjcq.c("MultiOperatorImpl", "exitRoom");
      this.jdField_a_of_type_Bjcd = null;
      if (this.jdField_a_of_type_JavaUtilMap != null) {
        this.jdField_a_of_type_JavaUtilMap.clear();
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.quit(0);
        i();
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    finally {}
  }
  
  public void e(int paramInt1, long paramLong, int paramInt2)
  {
    bjcq.c("MultiOperatorImpl", String.format("onCreateRoomSuc relationType=%s groupId=%s multiAvType=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) }));
  }
  
  public void f()
  {
    try
    {
      bjcq.c("MultiOperatorImpl", "updateRoomInfo");
      a();
      this.e = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f(long paramLong) {}
  
  public void g()
  {
    try
    {
      bjct.a().a(null);
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_JavaUtilMap = null;
      }
      super.g();
      return;
    }
    finally {}
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      this.jdField_a_of_type_JavaLangRunnable = new MultiOperatorImpl.1(this);
      bjda.a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    }
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      bjda.b(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjco
 * JD-Core Version:    0.7.0.1
 */