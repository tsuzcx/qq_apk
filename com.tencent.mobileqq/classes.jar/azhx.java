import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
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

public class azhx
  extends alko
{
  bakk jdField_a_of_type_Bakk = new azhy(this);
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-2147483648);
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  volatile boolean jdField_a_of_type_Boolean = true;
  bakk jdField_b_of_type_Bakk = new azhz(this);
  private final AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-2147483648);
  private final AtomicInteger c = new AtomicInteger(-2147483648);
  
  public azhx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    bdrp.d();
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
    int i;
    String str;
    boolean bool4;
    boolean bool5;
    int j;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      str = paramToServiceMsg.extraData.getString("uin", "");
      bool4 = false;
      bool5 = false;
      j = 1;
      if (!QLog.isColorLevel()) {
        break label663;
      }
    }
    label663:
    for (StringBuilder localStringBuilder = new StringBuilder(1024);; localStringBuilder = null)
    {
      if (i != 0)
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
                j = paramToServiceMsg.uint32_simple_ui_pref.get();
                bool6 = true;
                azib.a(str, bool2, 2);
                azib.a(str, j, 2);
                azwu.a(bool1, this.app);
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
                if ((QLog.isColorLevel()) && (localStringBuilder != null))
                {
                  localStringBuilder.append("; bSwitch = ").append(bool1).append("; bPref = ").append(i);
                  QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("handleReqGetSimpleUISwitch %s", new Object[] { localStringBuilder.toString() }));
                }
                notifyUI(1, bool3, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(i), str });
                return;
                i = 0;
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
            j = 1;
            continue;
          }
        }
        if (localStringBuilder != null)
        {
          localStringBuilder.append("fail pkg.bytes is null");
          bool1 = false;
          bool2 = false;
          bool3 = false;
          i = 1;
          continue;
          label504:
          if (localStringBuilder != null)
          {
            if (paramToServiceMsg != null) {
              break label550;
            }
            paramToServiceMsg = "pkg=null";
          }
          for (;;)
          {
            localStringBuilder.append(String.format("fail %s", new Object[] { paramToServiceMsg }));
            i = 1;
            bool1 = false;
            bool2 = false;
            bool3 = false;
            break;
            label550:
            if (paramToServiceMsg.uint32_result.has()) {
              paramToServiceMsg = Integer.valueOf(paramToServiceMsg.uint32_result.get());
            } else {
              paramToServiceMsg = "no result";
            }
          }
          bool6 = false;
          bool3 = bool6;
          i = j;
          bool2 = bool5;
          bool1 = bool4;
          if (localStringBuilder != null)
          {
            localStringBuilder.append(String.format("fail resultCode=%d", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
            bool3 = bool6;
            i = j;
            bool2 = bool5;
            bool1 = bool4;
          }
        }
        else
        {
          bool1 = false;
          bool2 = false;
          bool3 = false;
          i = 1;
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
  
  private boolean a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(this.app, true, null);
    String str = ThemeUtil.getUserCurrentThemeId(this.app);
    Object localObject1 = bakj.a(this.app).getString("themeID");
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
        for (paramString2 = this.jdField_b_of_type_Bakk;; paramString2 = this.jdField_a_of_type_Bakk) {
          return ThemeSwitcher.a((QQAppInterface)localObject2, (String)localObject1, paramString1, paramString2);
        }
      }
      localObject1 = paramString2;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    boolean bool3;
    boolean bool5;
    int j;
    boolean bool4;
    long l1;
    String str;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      bool3 = paramToServiceMsg.extraData.getBoolean("switch");
      bool5 = paramToServiceMsg.extraData.getBoolean("studyModeSwitch");
      j = paramToServiceMsg.extraData.getInt("pref");
      bool4 = paramToServiceMsg.extraData.getBoolean("switchElsePref");
      l1 = paramToServiceMsg.extraData.getLong("reqTs");
      str = this.app.getCurrentAccountUin();
      if (!QLog.isColorLevel()) {
        break label703;
      }
    }
    label678:
    label703:
    for (StringBuilder localStringBuilder = new StringBuilder(1024);; localStringBuilder = null)
    {
      boolean bool1;
      if (i != 0)
      {
        paramFromServiceMsg = (byte[])paramObject;
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
          paramToServiceMsg = paramFromServiceMsg;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          for (;;)
          {
            long l2;
            label321:
            paramFromServiceMsg.printStackTrace();
            continue;
            boolean bool2 = false;
            bool1 = bool2;
            if (localStringBuilder != null)
            {
              localStringBuilder.append("fail pkg.bytes is null");
              bool1 = bool2;
            }
          }
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0)) {
          if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
          {
            l2 = bdal.a(ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt());
            bool2 = str.equals(String.valueOf(l2));
            if (localStringBuilder != null) {
              localStringBuilder.append(String.format("suc=%b bSwitch=%b bPref=%d [%d vs %s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(j), Long.valueOf(l2), this.app.getCurrentAccountUin() }));
            }
            bool1 = bool2;
            if (bool2)
            {
              azwu.a(bool5, this.app);
              azib.a(this.app.getCurrentAccountUin(), bool3, 3);
              azib.a(this.app.getCurrentAccountUin(), j, 3);
              bool1 = bool2;
            }
            if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
              QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("handleReqSetSimpleUISwitch %s", new Object[] { localStringBuilder.toString() }));
            }
            if (l1 == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get())
            {
              if (bool1) {
                break label678;
              }
              bool2 = a(false, "211", azib.b(), true, azhw.jdField_b_of_type_ArrayOfJavaLangString[azib.c()]);
              if (!bool2) {
                a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.c, -2147483648);
              }
              if (QLog.isColorLevel()) {
                QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("handleReqSetSimpleUISwitch revert theme bStartSwtich=%b", new Object[] { Boolean.valueOf(bool2) }));
              }
            }
          }
        }
      }
      for (;;)
      {
        notifyUI(3, bool1, new Object[] { Boolean.valueOf(true), Boolean.valueOf(bool4), Integer.valueOf(5) });
        notifyUI(2, bool1, new Object[] { Boolean.valueOf(bool3), Integer.valueOf(j), Boolean.valueOf(bool4), str, Long.valueOf(l1) });
        return;
        i = 0;
        break;
        if (localStringBuilder != null)
        {
          if (paramToServiceMsg != null) {
            break label612;
          }
          paramToServiceMsg = "pkg=null";
        }
        for (;;)
        {
          localStringBuilder.append(String.format("fail %s", new Object[] { paramToServiceMsg }));
          bool1 = false;
          break;
          label612:
          if (paramToServiceMsg.uint32_result.has()) {
            paramToServiceMsg = Integer.valueOf(paramToServiceMsg.uint32_result.get());
          } else {
            paramToServiceMsg = "no result";
          }
        }
        if (localStringBuilder != null) {
          localStringBuilder.append(String.format("fail resultCode=%d", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
        }
        bool1 = false;
        break label321;
        a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.c, -2147483648);
      }
    }
  }
  
  public long a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramInt = azhw.jdField_b_of_type_ArrayOfInt[paramInt];
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
      localByteBuffer.putInt(bdal.a(l2)).put((byte)0).putShort((short)3).putShort((short)-23251).putShort((short)2).putShort(s1).putShort((short)-23238).putShort((short)2).putShort((short)paramInt).putShort((short)-23174).putShort((short)2).putShort(s2);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
      localObject = createToServiceMsg("OidbSvc.0x4ff_SimpleUI");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putBoolean("studyModeSwitch", paramBoolean3);
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean1);
      ((ToServiceMsg)localObject).extraData.putInt("pref", paramInt);
      ((ToServiceMsg)localObject).extraData.putBoolean("switchElsePref", paramBoolean2);
      ((ToServiceMsg)localObject).extraData.putLong("reqTs", l1);
      sendPbReq((ToServiceMsg)localObject);
      return l1;
      s1 = 0;
      break label335;
      short s2 = 0;
      continue;
      label335:
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
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    if (a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger) != -2147483648) {
      return false;
    }
    Object localObject = ThemeUtil.getUserCurrentThemeId(this.app);
    boolean bool2 = a(paramBoolean, azhw.jdField_b_of_type_ArrayOfJavaLangString[paramInt]);
    if (bool2) {}
    for (boolean bool1 = a(false, "212", paramBoolean, true, azhw.jdField_b_of_type_ArrayOfJavaLangString[paramInt]);; bool1 = false)
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
          a((AtomicInteger)localObject, i, this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger, paramInt, null, -2147483648);
        }
      }
      for (;;)
      {
        return bool1;
        i = 0;
        break;
        a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, null, -2147483648);
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
    Object localObject = azhw.jdField_b_of_type_ArrayOfJavaLangString[paramInt];
    boolean bool = a(paramBoolean1, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("startSwitchSimpleUI [%b,%s,%b] needSwitch=%b", new Object[] { Boolean.valueOf(paramBoolean1), localObject, Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool) }));
    }
    int i;
    if (bool)
    {
      bool = a(true, "211", paramBoolean1, paramBoolean2, (String)localObject);
      if (!bool) {
        break label207;
      }
      localObject = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
      if (!paramBoolean1) {
        break label201;
      }
      i = 1;
      label120:
      AtomicInteger localAtomicInteger1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
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
      long l = ((azhx)this.app.a(154)).a(paramBoolean1, paramInt, paramBoolean2, paramBoolean3);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
      bool = true;
      break;
      label201:
      i = 0;
      break label120;
      label207:
      a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.c, -2147483648);
    }
  }
  
  public void b()
  {
    if (a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger) != -2147483648) {}
    boolean bool1 = ThemeUtil.isNowThemeIsSimple(this.app, false, null);
    boolean bool2 = azib.b();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("onPostThemeChanged bSimpleSwitch=%b isSimpleMode=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
    }
    if (bool1 != bool2) {
      QLog.e("SimpleUILog.SimpleUIHandler", 1, String.format("onPostThemeChanged switch inconsistent [%b,%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
    }
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return azia.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    azib.a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (TextUtils.equals("OidbSvc.0x5eb_SimpleUI", paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!TextUtils.equals("OidbSvc.0x4ff_SimpleUI", paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhx
 * JD-Core Version:    0.7.0.1
 */