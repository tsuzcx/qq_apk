import QC.Concise;
import QC.UniBusinessItem;
import QC.UniSetReq;
import QC.UniSetRsp;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class bcnd
  extends anii
{
  public Activity a;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-2147483648);
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  volatile boolean jdField_a_of_type_Boolean = true;
  private final AtomicInteger b = new AtomicInteger(-2147483648);
  private final AtomicInteger c = new AtomicInteger(-2147483648);
  
  public bcnd(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    bhba.d();
  }
  
  private int a(AtomicInteger paramAtomicInteger)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
    {
      int i = paramAtomicInteger.get();
      return i;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j;
    String str;
    boolean bool4;
    boolean bool5;
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      j = 1;
      str = paramToServiceMsg.extraData.getString("uin", "");
      bool4 = false;
      bool5 = false;
      i = bcnj.c();
      if (!QLog.isColorLevel()) {
        break label657;
      }
    }
    label657:
    for (StringBuilder localStringBuilder = new StringBuilder(1024);; localStringBuilder = null)
    {
      if (j != 0)
      {
        paramFromServiceMsg = (byte[])paramObject;
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      for (;;)
      {
        boolean bool1;
        boolean bool2;
        boolean bool6;
        boolean bool3;
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
          paramToServiceMsg = paramFromServiceMsg;
          if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0)) {
            break label504;
          }
          if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
          }
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          try
          {
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            if (paramFromServiceMsg.rpt_msg_uin_data.size() > 0)
            {
              paramToServiceMsg = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0);
              i = paramToServiceMsg.uint32_simple_ui_switch.get();
              if (paramToServiceMsg.uint32_flag_study_mode_switch.get() == 1)
              {
                bool1 = true;
                if (i != 1) {
                  continue;
                }
                bool2 = true;
                j = bcnj.c();
                bool6 = true;
                bcnj.a(str, bool2, 2);
                bcnj.a(str, j, 2);
                bdch.a(bool1, this.app);
                bool5 = bool2;
                bool4 = bool1;
                i = j;
                bool1 = bool4;
                bool2 = bool5;
                bool3 = bool6;
                if (localStringBuilder != null)
                {
                  localStringBuilder.append(String.format("suc=%b %s", new Object[] { Boolean.valueOf(bool6), str }));
                  bool3 = bool6;
                  bool2 = bool5;
                  bool1 = bool4;
                  i = j;
                }
                bool4 = bool1;
                bool1 = bool2;
                bool2 = bool4;
                j = i;
                if ((QLog.isColorLevel()) && (localStringBuilder != null))
                {
                  localStringBuilder.append("; bSwitch = ").append(bool1).append("; bPref = ").append(j);
                  QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("handleReqGetSimpleUISwitch %s", new Object[] { localStringBuilder.toString() }));
                }
                notifyUI(1, bool3, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j), str });
                return;
                j = 0;
                break;
                paramFromServiceMsg = paramFromServiceMsg;
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            paramToServiceMsg.printStackTrace();
            continue;
            bool1 = false;
            continue;
            bool2 = false;
            continue;
            bool4 = false;
            bool5 = false;
            bool6 = false;
            j = i;
            continue;
          }
        }
        if (localStringBuilder != null)
        {
          localStringBuilder.append("fail pkg.bytes is null");
          bool1 = false;
          bool2 = false;
          bool3 = false;
          continue;
          label504:
          if (localStringBuilder != null)
          {
            if (paramToServiceMsg != null) {
              break label547;
            }
            paramToServiceMsg = "pkg=null";
          }
          for (;;)
          {
            localStringBuilder.append(String.format("fail %s", new Object[] { paramToServiceMsg }));
            bool1 = false;
            bool2 = false;
            bool3 = false;
            break;
            label547:
            if (paramToServiceMsg.uint32_result.has()) {
              paramToServiceMsg = Integer.valueOf(paramToServiceMsg.uint32_result.get());
            } else {
              paramToServiceMsg = "no result";
            }
          }
          bool6 = false;
          bool3 = bool6;
          j = i;
          bool2 = bool5;
          bool1 = bool4;
          if (localStringBuilder != null)
          {
            localStringBuilder.append(String.format("fail resultCode=%d", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
            bool3 = bool6;
            j = i;
            bool2 = bool5;
            bool1 = bool4;
          }
        }
        else
        {
          bool1 = false;
          bool2 = false;
          bool3 = false;
        }
      }
    }
  }
  
  private void a(AtomicInteger paramAtomicInteger1, int paramInt1, AtomicInteger paramAtomicInteger2, int paramInt2, AtomicInteger paramAtomicInteger3, int paramInt3)
  {
    AtomicInteger localAtomicInteger = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
    if (paramAtomicInteger1 != null) {}
    try
    {
      paramAtomicInteger1.set(paramInt1);
      if (paramAtomicInteger2 != null) {
        paramAtomicInteger2.set(paramInt2);
      }
      if (paramAtomicInteger3 != null) {
        paramAtomicInteger3.set(paramInt3);
      }
      return;
    }
    finally {}
  }
  
  public static void a(boolean paramBoolean, int paramInt, anil paramanil)
  {
    bhhm localbhhm = new bhhm("QC.UniBusinessLogicServer.UniBusinessLogicObj", "QCUniBusinessLogic.uniSet", "stReq", "rsp");
    UniSetReq localUniSetReq = new UniSetReq();
    localUniSetReq.stLogin = bhhm.a();
    localUniSetReq.stUniBusinessItem = new UniBusinessItem();
    localUniSetReq.stUniBusinessItem.appid = 307;
    localUniSetReq.stUniBusinessItem.itemid = Integer.decode(bcnj.a(paramInt)).intValue();
    localUniSetReq.stConcise = new Concise();
    Concise localConcise = localUniSetReq.stConcise;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localConcise.isSwitch = paramInt;
      localbhhm.a("uniSet", localUniSetReq, new UniSetRsp(), paramanil, false);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt, QQAppInterface paramQQAppInterface)
  {
    int i = bcnj.a(String.valueOf(paramInt));
    if (i != -1)
    {
      bcnj.a(paramQQAppInterface.getCurrentAccountUin(), paramBoolean, 1);
      bcnj.a(paramQQAppInterface.getCurrentAccountUin(), i, 1);
      return;
    }
    bcnj.a(paramQQAppInterface, paramBoolean, String.valueOf(paramInt));
  }
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    boolean bool = ThemeUtil.isNowThemeIsSimple(this.app, true, null);
    String str = ThemeUtil.getUserCurrentThemeId(this.app);
    if (bool != paramBoolean) {}
    do
    {
      return true;
      if (!paramBoolean) {
        return false;
      }
    } while (!paramString.equals(str));
    return false;
  }
  
  public long a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramBoolean1, paramInt, new bcnf(this, paramBoolean1, paramInt, paramBoolean3, paramBoolean2));
    Object localObject = this.app.getCurrentAccountUin();
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("reqSetSimpleUISwitch [%b,%d,%b] uin=%s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), localObject }));
    }
    for (;;)
    {
      try
      {
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        localByteBuffer = ByteBuffer.allocate(25);
        l2 = Long.parseLong((String)localObject);
        if (!paramBoolean1) {
          continue;
        }
        s1 = 1;
      }
      catch (Exception localException)
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
        ByteBuffer localByteBuffer;
        long l2;
        short s1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SimpleUILog.SimpleUIHandler", 1, "reqSetSimpleUISwitch ex", localException);
        return l1;
      }
      localByteBuffer.putInt(bgjw.a(l2)).put((byte)0).putShort((short)3).putShort((short)-23251).putShort((short)2).putShort(s1).putShort((short)-23238).putShort((short)2).putShort((short)0).putShort((short)-23174).putShort((short)2).putShort(s2);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
      localObject = createToServiceMsg("OidbSvc.0x4ff_SimpleUI");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putBoolean("studyModeSwitch", paramBoolean3);
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean1);
      ((ToServiceMsg)localObject).extraData.putInt("pref", 0);
      ((ToServiceMsg)localObject).extraData.putBoolean("switchElsePref", paramBoolean2);
      ((ToServiceMsg)localObject).extraData.putLong("reqTs", l1);
      sendPbReq((ToServiceMsg)localObject);
      return l1;
      s1 = 0;
      break label346;
      short s2 = 0;
      continue;
      label346:
      if (paramBoolean3) {
        s2 = 1;
      }
    }
  }
  
  public void a()
  {
    String str = this.app.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("reqGetSimpleUISwitch uin=%s", new Object[] { str }));
    }
    Object localObject = new oidb_0x5eb.ReqBody();
    try
    {
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      ((oidb_0x5eb.ReqBody)localObject).uint32_simple_ui_switch.set(1);
      ((oidb_0x5eb.ReqBody)localObject).uint32_simple_ui_pref.set(1);
      ((oidb_0x5eb.ReqBody)localObject).uint32_flag_study_mode_switch.set(1);
      localObject = makeOIDBPkg("OidbSvc.0x5eb_SimpleUI", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", str);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(paramLong);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (!paramBoolean1)
    {
      int i;
      if (paramBoolean5) {
        if (this.jdField_a_of_type_AndroidAppActivity != null)
        {
          AtomicInteger localAtomicInteger = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
          if (!paramBoolean2) {
            break label75;
          }
          i = 1;
          localAtomicInteger.set(i);
          this.b.set(paramInt);
          localAtomicInteger = this.c;
          if (!paramBoolean3) {
            break label81;
          }
          paramInt = 1;
          label57:
          localAtomicInteger.set(paramInt);
          bgzo.a(this.jdField_a_of_type_AndroidAppActivity, aqyk.a(), 1);
        }
      }
      label75:
      label81:
      do
      {
        return;
        i = 0;
        break;
        paramInt = 0;
        break label57;
        ((bdby)this.app.getManager(361)).a(this.b.get(), 1);
        a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.b, -2147483648, this.c, -2147483648);
        notifyUI(3, paramBoolean1, new Object[] { Boolean.valueOf(true), Boolean.valueOf(paramBoolean4), Integer.valueOf(5) });
        if ((this.jdField_a_of_type_AndroidAppActivity != null) && ((this.jdField_a_of_type_AndroidAppActivity instanceof GeneralSettingActivity))) {
          ((GeneralSettingActivity)this.jdField_a_of_type_AndroidAppActivity).a(1, bcnj.c(), false, true);
        }
      } while (this.jdField_a_of_type_AndroidAppActivity == null);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, "付费失败", 0).a();
      return;
    }
    bdch.a(paramBoolean3, this.app);
    bcnj.a(this.app.getCurrentAccountUin(), paramBoolean2, 3);
    bcnj.a(this.app.getCurrentAccountUin(), paramInt, 3);
    a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.b, -2147483648, this.c, -2147483648);
    notifyUI(3, paramBoolean1, new Object[] { Boolean.valueOf(true), Boolean.valueOf(paramBoolean4), Integer.valueOf(5) });
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, "装扮成功", 0).a();
    }
    blyl.a().a(bcnj.a(paramInt), "4", "platform898", "4", "1", 113, 1, System.currentTimeMillis());
    bcst.b(this.app, "dc00898", "", "", "qq_vip", "0X800B15D", Integer.decode(bcnj.a(paramInt)).intValue(), 0, "", "", "", "");
  }
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    if (a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger) != -2147483648) {
      return false;
    }
    Object localObject = ThemeUtil.getUserCurrentThemeId(this.app);
    boolean bool2 = a(paramBoolean, bcnj.a(paramInt));
    if (bool2) {}
    for (boolean bool1 = a(false, "212", paramBoolean, true, bcnj.a(paramInt));; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("onGetSimpleUISwtichLogin [%b,%b] cur=%s needChange=%b start=%b", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), localObject, Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      int i;
      if (bool1)
      {
        localObject = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
        if (paramBoolean)
        {
          i = 1;
          a((AtomicInteger)localObject, i, this.b, paramInt, null, -2147483648);
        }
      }
      for (;;)
      {
        return bool1;
        i = 0;
        break;
        a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.b, -2147483648, null, -2147483648);
      }
    }
  }
  
  public boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramInt, paramBoolean2, false);
  }
  
  public boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = 0;
    if (a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger) != -2147483648) {
      return false;
    }
    Object localObject = bcnj.a(paramInt);
    boolean bool = a(paramBoolean1, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("startSwitchSimpleUI [%b,%s,%b] needSwitch=%b", new Object[] { Boolean.valueOf(paramBoolean1), localObject, Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool) }));
    }
    int i;
    if (bool)
    {
      bool = a(true, "211", paramBoolean1, paramBoolean2, (String)localObject);
      if (!bool) {
        break label206;
      }
      localObject = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
      if (!paramBoolean1) {
        break label200;
      }
      i = 1;
      label119:
      AtomicInteger localAtomicInteger1 = this.b;
      AtomicInteger localAtomicInteger2 = this.c;
      if (paramBoolean3) {
        j = 1;
      }
      a((AtomicInteger)localObject, i, localAtomicInteger1, paramInt, localAtomicInteger2, j);
      this.jdField_a_of_type_Boolean = paramBoolean2;
    }
    for (;;)
    {
      return bool;
      long l = ((bcnd)this.app.a(154)).a(paramBoolean1, paramInt, paramBoolean2, paramBoolean3);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
      bool = true;
      break;
      label200:
      i = 0;
      break label119;
      label206:
      a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.b, -2147483648, this.c, -2147483648);
    }
  }
  
  protected boolean a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(this.app, true, null);
    String str = ThemeUtil.getUserCurrentThemeId(this.app);
    Object localObject1 = bdpw.a(this.app).getString("themeID");
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "1000";
    }
    if (paramBoolean3) {
      if (bool) {
        if (paramBoolean2) {
          localObject1 = "2920";
        }
      }
    }
    for (;;)
    {
      QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("doSwitchTheme needCallback=%b dst=[%b,%s][cur,pre,to]=[%s,%s,%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString2, str, localObject2, localObject1 }));
      if (str.equals(localObject1))
      {
        return false;
        localObject1 = "1103";
        continue;
        if (paramBoolean2)
        {
          localObject1 = paramString2;
          continue;
        }
        localObject1 = localObject2;
        continue;
        if (paramBoolean2) {
          localObject1 = paramString2;
        }
      }
      else
      {
        localObject2 = this.app;
        if (paramBoolean1) {}
        for (paramString2 = new bcnh(this);; paramString2 = new bcng(this)) {
          return ThemeSwitcher.a((QQAppInterface)localObject2, (String)localObject1, paramString1, paramString2);
        }
      }
      localObject1 = paramString2;
    }
  }
  
  public void b()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {}
    for (;;)
    {
      a(bool, this.b.get(), new bcne(this));
      return;
      bool = false;
    }
  }
  
  public void c()
  {
    if (a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger) != -2147483648) {}
    boolean bool1 = ThemeUtil.isNowThemeIsSimple(this.app, false, null);
    boolean bool2 = bcnj.b();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("onPostThemeChanged bSimpleSwitch=%b isSimpleMode=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
    }
    if (bool1 != bool2) {
      QLog.e("SimpleUILog.SimpleUIHandler", 1, String.format("onPostThemeChanged switch inconsistent [%b,%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
    }
  }
  
  protected Class<? extends anil> observerClass()
  {
    return bcni.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bcnj.a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (TextUtils.equals("OidbSvc.0x5eb_SimpleUI", paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!TextUtils.equals("OidbSvc.0x4ff_SimpleUI", paramFromServiceMsg.getServiceCmd())) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnd
 * JD-Core Version:    0.7.0.1
 */