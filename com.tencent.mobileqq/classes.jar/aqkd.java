import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;

public class aqkd
{
  long jdField_a_of_type_Long = 0L;
  aqkg jdField_a_of_type_Aqkg = new aqkg(this);
  List<aqkh> jdField_a_of_type_JavaUtilList = new ArrayList();
  WtloginHelper jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper;
  boolean jdField_a_of_type_Boolean;
  
  private void a(String paramString, boolean paramBoolean, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      aqkh localaqkh = (aqkh)localIterator.next();
      if (localaqkh != null) {
        localaqkh.a(paramString, paramBoolean, paramInt);
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public aqkg a()
  {
    return this.jdField_a_of_type_Aqkg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aqkg = new aqkg(this);
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, aqkh paramaqkh)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Aqkg.b))
    {
      if (paramaqkh != null) {
        paramaqkh.a(paramString1, true, 0);
      }
      return;
    }
    aqkf localaqkf = new aqkf(this, paramaqkh, paramString1);
    FastAuthorize.AuthorizeRequest localAuthorizeRequest = new FastAuthorize.AuthorizeRequest();
    localAuthorizeRequest.uin.set(Long.parseLong(paramAppInterface.getCurrentAccountUin()));
    localAuthorizeRequest.client_id.set(Long.parseLong(paramString2));
    localAuthorizeRequest.pf.set("");
    paramString2 = bcev.a(paramContext);
    localAuthorizeRequest.qqv.set(paramString2);
    localAuthorizeRequest.sdkp.set("a");
    paramString2 = Build.DISPLAY;
    localAuthorizeRequest.os.set(paramString2);
    paramString2 = ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
    localAuthorizeRequest.skey.set(paramString2);
    paramString2 = "";
    if ((paramAppInterface instanceof QQAppInterface)) {
      paramString2 = ((QQAppInterface)paramAppInterface).a();
    }
    for (;;)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      localAuthorizeRequest.vkey.set(str);
      localAuthorizeRequest.flags.set(7);
      paramContext = new NewIntent(paramContext, mmi.class);
      localAuthorizeRequest.apk_sign.set("");
      paramContext.putExtra("cmd", "ConnAuthSvr.fast_qq_login");
      try
      {
        paramContext.putExtra("data", localAuthorizeRequest.toByteArray());
        paramContext.setObserver(localaqkf);
        paramAppInterface.startServlet(paramContext);
        return;
        if (!(paramAppInterface instanceof BrowserAppInterface)) {
          continue;
        }
        paramString2 = ((BrowserAppInterface)paramAppInterface).a();
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramaqkh.a(paramString1, false, -10001);
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, aqkh paramaqkh, boolean paramBoolean, String paramString5)
  {
    QLog.i("XProxy", 2, "开始拉取A1，uin = " + paramString1 + " appid = " + paramString4);
    if ((this.jdField_a_of_type_Aqkg.a != null) && (!paramBoolean) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 43200000L))
    {
      if (paramaqkh != null) {
        paramaqkh.a(paramString2, true, 0);
      }
      return true;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramaqkh);
      return true;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper == null)
    {
      QLog.i("XProxy", 2, "new WtloginHelper");
      this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper = new WtloginHelper(BaseApplicationImpl.getContext());
    }
    if (paramString3.equals("com.tencent.huayang"))
    {
      paramString5 = new byte[16];
      String tmp155_153 = paramString5;
      tmp155_153[0] = -33;
      String tmp161_155 = tmp155_153;
      tmp161_155[1] = 11;
      String tmp167_161 = tmp161_155;
      tmp167_161[2] = -29;
      String tmp173_167 = tmp167_161;
      tmp173_167[3] = -119;
      String tmp179_173 = tmp173_167;
      tmp179_173[4] = 66;
      String tmp185_179 = tmp179_173;
      tmp185_179[5] = 110;
      String tmp191_185 = tmp185_179;
      tmp191_185[6] = 87;
      String tmp198_191 = tmp191_185;
      tmp198_191[7] = 53;
      String tmp205_198 = tmp198_191;
      tmp205_198[8] = -16;
      String tmp212_205 = tmp205_198;
      tmp212_205[9] = -77;
      String tmp219_212 = tmp212_205;
      tmp219_212[10] = -121;
      String tmp226_219 = tmp219_212;
      tmp226_219[11] = -112;
      String tmp233_226 = tmp226_219;
      tmp233_226[12] = 46;
      String tmp240_233 = tmp233_226;
      tmp240_233[13] = 51;
      String tmp247_240 = tmp240_233;
      tmp247_240[14] = -96;
      String tmp254_247 = tmp247_240;
      tmp254_247[15] = 62;
      tmp254_247;
    }
    for (;;)
    {
      this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper.SetListener(new aqke(this, paramString2));
      this.jdField_a_of_type_JavaUtilList.add(paramaqkh);
      int i = this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper.GetA1WithA1(paramString1, 16L, 16L, paramString3.getBytes(), 1L, Long.valueOf(paramString4).longValue(), 1L, "5.2".getBytes(), paramString5, new WUserSigInfo(), new WFastLoginInfo());
      if (i != -1001)
      {
        if (QLog.isColorLevel()) {
          QLog.i("XProxy", 2, "获取Now结合版A1票据失败，retCode = " + i);
        }
        a(paramString2, false, i);
      }
      return true;
      if (paramString3.equals("com.tencent.now"))
      {
        paramString5 = new byte[16];
        String tmp412_410 = paramString5;
        tmp412_410[0] = -51;
        String tmp418_412 = tmp412_410;
        tmp418_412[1] = 50;
        String tmp424_418 = tmp418_412;
        tmp424_418[2] = 114;
        String tmp430_424 = tmp424_418;
        tmp430_424[3] = -105;
        String tmp436_430 = tmp430_424;
        tmp436_430[4] = -54;
        String tmp442_436 = tmp436_430;
        tmp442_436[5] = -19;
        String tmp448_442 = tmp442_436;
        tmp448_442[6] = 112;
        String tmp455_448 = tmp448_442;
        tmp455_448[7] = -124;
        String tmp462_455 = tmp455_448;
        tmp462_455[8] = -125;
        String tmp469_462 = tmp462_455;
        tmp469_462[9] = -52;
        String tmp476_469 = tmp469_462;
        tmp476_469[10] = -72;
        String tmp483_476 = tmp476_469;
        tmp483_476[11] = -101;
        String tmp490_483 = tmp483_476;
        tmp490_483[12] = -27;
        String tmp497_490 = tmp490_483;
        tmp497_490[13] = 33;
        String tmp504_497 = tmp497_490;
        tmp504_497[14] = 65;
        String tmp511_504 = tmp504_497;
        tmp511_504[15] = -128;
        tmp511_504;
      }
      else
      {
        paramString5 = bach.a(paramString5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqkd
 * JD-Core Version:    0.7.0.1
 */