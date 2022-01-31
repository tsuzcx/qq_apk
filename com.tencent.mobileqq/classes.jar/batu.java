import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility.10;
import com.tencent.mobileqq.troopshare.TroopShareUtility.9;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class batu
  implements bcwh
{
  protected int a;
  protected akim a;
  protected baud a;
  protected bbjc a;
  protected bcpq a;
  bduv jdField_a_of_type_Bduv = new baua(this);
  protected bfol a;
  protected bfov a;
  public BaseActivity a;
  public TroopInfoData a;
  protected String a;
  boolean jdField_a_of_type_Boolean = false;
  protected int b;
  protected bfol b;
  protected String b;
  protected boolean b;
  protected String c;
  private boolean c;
  protected String d;
  protected String e;
  
  public batu(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData)
  {
    this(paramBaseActivity, paramTroopInfoData, null);
  }
  
  public batu(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData, baud parambaud)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Akim = new batz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = paramTroopInfoData;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Bduv);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Akim);
    }
    WXShareHelper.a().a(this);
    this.jdField_a_of_type_Baud = parambaud;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = null;
    if (paramBitmap != null)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
    }
    return localBitmap;
  }
  
  public static Bitmap a(String paramString, Resources paramResources)
  {
    return a(paramString, paramResources, 540, 70, true);
  }
  
  public static Bitmap a(String paramString, Resources paramResources, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = wim.a(paramString, -1);
    int m = ((ij)localObject).a();
    paramString = new int[m * m];
    int i = 0;
    while (i < m)
    {
      int j = 0;
      if (j < m)
      {
        if (((ij)localObject).a(j, i)) {}
        for (int k = -16777216;; k = 16777215)
        {
          paramString[(i * m + j)] = k;
          j += 1;
          break;
        }
      }
      i += 1;
    }
    localObject = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(paramString, 0, m, 0, 0, m, m);
    try
    {
      paramString = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
      if (paramString == null)
      {
        ((Bitmap)localObject).recycle();
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        System.gc();
        try
        {
          paramString = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
        }
        catch (OutOfMemoryError paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopShareUtility", 2, paramString.getMessage());
          }
          return null;
        }
      }
      Canvas localCanvas = new Canvas(paramString);
      Paint localPaint = new Paint();
      localPaint.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, 600.0F, -657931, -1513240, Shader.TileMode.REPEAT));
      localCanvas.drawRect(0.0F, 0.0F, paramInt1, paramInt1, localPaint);
      localCanvas.drawBitmap((Bitmap)localObject, null, new Rect(paramInt2, paramInt2, paramInt1 - paramInt2, paramInt1 - paramInt2), null);
      if (paramBoolean)
      {
        paramInt1 = (paramInt1 - 106) / 2;
        localPaint = new Paint();
        localPaint.setAntiAlias(true);
        Rect localRect = new Rect(paramInt1, paramInt1, paramInt1 + 106, 106 + paramInt1);
        paramResources = bawu.a(paramResources, 2130839395);
        if (paramResources != null)
        {
          localCanvas.drawBitmap(paramResources, null, localRect, localPaint);
          paramResources.recycle();
        }
      }
      ((Bitmap)localObject).recycle();
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TroopShareUtility", 2, "getQrCode cost time:" + (l2 - l1));
      }
    }
    return paramString;
  }
  
  private String a()
  {
    if (this.jdField_b_of_type_Int == -1) {
      return null;
    }
    if (this.jdField_b_of_type_Int == 0) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public static String a(String paramString, Context paramContext)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramContext.getString(2131719513);
    }
    return str;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    try
    {
      localAbsShareMsg = new axuk(StructMsgForGeneralShare.class).c(132).a(paramBundle.getString("summary")).e(paramBundle.getString("targetUrl")).a(1105290942L).a();
      localAbsShareMsg.mMsgBrief = paramBundle.getString("summary");
      localAbsShareMsg.mContentSummary = paramBundle.getString("summary");
      localAbsShareMsg.mContentTitle = paramBundle.getString("title");
      localObject = paramBundle.getString("sourcename");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (localAbsShareMsg.mSourceName = "NOW";; localAbsShareMsg.mSourceName = "")
      {
        localAbsShareMsg.mSourceAction = "";
        localAbsShareMsg.mMsgUrl = paramBundle.getString("targetUrl");
        localAbsShareMsg.mContentCover = paramBundle.getString("imageUrl");
        if (!TextUtils.isEmpty(paramBundle.getString("msgActionData")))
        {
          localAbsShareMsg.mMsgActionData = paramBundle.getString("msgActionData");
          localAbsShareMsg.mMsgAction = "plugin";
        }
        localObject = axux.a(2);
        String str = paramBundle.getString("summary");
        ((axuo)localObject).a(paramBundle.getString("imageUrl"), paramBundle.getString("title"), str);
        localAbsShareMsg.addItem((axun)localObject);
        paramBundle = new Intent();
        paramBundle.putExtra("forward_type", -3);
        paramBundle.putExtra("emoInputType", 2);
        paramBundle.putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
        aqbc.a(paramActivity, paramBundle, paramInt);
        return;
        if (!((String)localObject).equals("null")) {
          break;
        }
      }
    }
    catch (Exception paramActivity)
    {
      AbsShareMsg localAbsShareMsg;
      Object localObject;
      while (QLog.isColorLevel())
      {
        QLog.e("Q.qqstory.share", 2, "shareStoryToQQ exception", paramActivity);
        return;
        localAbsShareMsg.mSourceName = ((String)localObject);
      }
    }
  }
  
  public static void a(Activity paramActivity, MessageForQQStory paramMessageForQQStory, int paramInt)
  {
    try
    {
      AbsShareMsg localAbsShareMsg = new axuk(StructMsgForGeneralShare.class).c(80).a(paramMessageForQQStory.brief).e("").a();
      if (paramMessageForQQStory.briefBgColor == 0) {
        paramMessageForQQStory.briefBgColor = Color.parseColor("#d8000000");
      }
      paramMessageForQQStory.briefBgColor &= 0xFFFFFF;
      paramMessageForQQStory.briefBgColor |= 0xD8000000;
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("coverImgUrl", paramMessageForQQStory.coverImgUrl);
        ((JSONObject)localObject).put("logoImgUrl", paramMessageForQQStory.logoImgUrl);
        ((JSONObject)localObject).put("briefBgColor", paramMessageForQQStory.briefBgColor);
        ((JSONObject)localObject).put("authorName", paramMessageForQQStory.authorName);
        ((JSONObject)localObject).put("type", paramMessageForQQStory.type);
        ((JSONObject)localObject).put("vid", paramMessageForQQStory.mVid);
        ((JSONObject)localObject).put("headtip", paramMessageForQQStory.mHeadTip);
        ((JSONObject)localObject).put("storyTitle", paramMessageForQQStory.storyTitle);
        ((JSONObject)localObject).put("storyBrief", paramMessageForQQStory.storyBrief);
        localAbsShareMsg.mQQStoryExtra = ((JSONObject)localObject).toString();
        localAbsShareMsg.mCompatibleText = MessageForQQStory.buildCompatibleText(paramMessageForQQStory.authorName, paramMessageForQQStory.brief, paramMessageForQQStory.srcName);
        localAbsShareMsg.mMsgBrief = paramMessageForQQStory.brief;
        localAbsShareMsg.mSourceName = paramMessageForQQStory.srcName;
        localAbsShareMsg.mSourceAction = paramMessageForQQStory.srcAction;
        localAbsShareMsg.mMsgAction = paramMessageForQQStory.msgAction;
        localObject = new Intent();
        ((Intent)localObject).putExtra("forward_type", 28);
        ((Intent)localObject).putExtra("emoInputType", 2);
        ((Intent)localObject).putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
        aqbc.a(paramActivity, (Intent)localObject, paramInt);
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.share", 2, "shareStoryToQQ: " + paramMessageForQQStory.toString() + ", compatibleTxt=" + localAbsShareMsg.mCompatibleText + ", qqstoryExtra=" + localAbsShareMsg.mQQStoryExtra);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      return;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.share", 2, "shareStoryToQQ exception", paramActivity);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, Intent paramIntent)
  {
    try
    {
      if (!QLog.isColorLevel()) {
        break label102;
      }
      QLog.d("Q.qqstory.share", 2, "handleShareQQStory: resultCode=" + paramInt);
    }
    catch (Exception paramQQAppInterface)
    {
      label102:
      do
      {
        Intent localIntent;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqstory.share", 2, "handleShareQQStory exception", paramQQAppInterface);
        return;
      } while (paramInt == -1);
    }
    localIntent = actn.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    ForwardUtils.a(paramQQAppInterface, paramActivity, ForwardUtils.a(localIntent), localIntent);
    return;
  }
  
  public static List<bbje>[] a(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new bbje();
    ((bbje)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131696695);
    ((bbje)localObject).jdField_b_of_type_Int = 2130838754;
    ((bbje)localObject).jdField_b_of_type_Boolean = true;
    ((bbje)localObject).c = 2;
    ((bbje)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new bbje();
    ((bbje)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131696708);
    ((bbje)localObject).jdField_b_of_type_Int = 2130838755;
    ((bbje)localObject).jdField_b_of_type_Boolean = true;
    ((bbje)localObject).c = 3;
    ((bbje)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new bbje();
    ((bbje)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131696715);
    ((bbje)localObject).jdField_b_of_type_Int = 2130838758;
    ((bbje)localObject).c = 9;
    ((bbje)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new bbje();
    ((bbje)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131696698);
    ((bbje)localObject).jdField_b_of_type_Int = 2130838752;
    ((bbje)localObject).c = 10;
    ((bbje)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    bbje localbbje = new bbje();
    localbbje.jdField_a_of_type_JavaLangString = paramContext.getString(2131696687);
    localbbje.jdField_b_of_type_Int = 2130838750;
    localbbje.jdField_b_of_type_Boolean = true;
    localbbje.c = 1;
    localbbje.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localbbje);
    if (paramBoolean)
    {
      localbbje = new bbje();
      localbbje.jdField_a_of_type_JavaLangString = paramContext.getString(2131717191);
      localbbje.jdField_b_of_type_Int = 2130841940;
      localbbje.jdField_b_of_type_Boolean = true;
      localbbje.c = 23;
      localbbje.jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject).add(localbbje);
    }
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    try
    {
      Object localObject = new axuk(StructMsgForGeneralShare.class);
      if ("action_mqq".equals(paramBundle.getString("jump_action")))
      {
        localObject = ((axuk)localObject).c(129).a(paramBundle.getString("summary")).a(1104763709L).a();
        ((AbsShareMsg)localObject).mMsgBrief = paramBundle.getString("summary");
        ((AbsShareMsg)localObject).mContentSummary = paramBundle.getString("summary");
        ((AbsShareMsg)localObject).mContentTitle = paramBundle.getString("title");
        ((AbsShareMsg)localObject).mSourceAction = "";
        ((AbsShareMsg)localObject).mContentCover = paramBundle.getString("imageUrl");
        ((AbsShareMsg)localObject).mMsgAction = "plugin";
        ((AbsShareMsg)localObject).mMsg_A_ActionData = paramBundle.getString("action_data");
      }
      for (;;)
      {
        axuo localaxuo = axux.a(2);
        String str = paramBundle.getString("summary");
        localaxuo.a(paramBundle.getString("imageUrl"), paramBundle.getString("title"), str);
        ((AbsShareMsg)localObject).addItem(localaxuo);
        paramBundle = new Intent();
        paramBundle.putExtra("forward_type", -3);
        paramBundle.putExtra("emoInputType", 2);
        paramBundle.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
        paramBundle.putExtra("structmsg_service_id", ((AbsShareMsg)localObject).mMsgServiceID);
        aqbc.a(paramActivity, paramBundle, paramInt);
        return;
        localObject = ((axuk)localObject).c(129).a(paramBundle.getString("summary")).e(paramBundle.getString("targetUrl")).a(1104763709L).a();
        ((AbsShareMsg)localObject).mMsgBrief = paramBundle.getString("summary");
        ((AbsShareMsg)localObject).mContentSummary = paramBundle.getString("summary");
        ((AbsShareMsg)localObject).mContentTitle = paramBundle.getString("title");
        ((AbsShareMsg)localObject).mSourceAction = "";
        ((AbsShareMsg)localObject).mMsgUrl = paramBundle.getString("targetUrl");
        ((AbsShareMsg)localObject).mContentCover = paramBundle.getString("imageUrl");
        ((AbsShareMsg)localObject).mMsgAction = "web";
      }
      return;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.share", 2, "shareQQGroupVideoToQQ exception", paramActivity);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, Intent paramIntent)
  {
    try
    {
      if (!QLog.isColorLevel()) {
        break label102;
      }
      QLog.d("Q.qqstory.share", 2, "handleShareQQNow: resultCode=" + paramInt);
    }
    catch (Exception paramQQAppInterface)
    {
      label102:
      do
      {
        Intent localIntent;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqstory.share", 2, "handleShareQQNow exception", paramQQAppInterface);
        return;
      } while (paramInt == -1);
    }
    localIntent = actn.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    ForwardUtils.a(paramQQAppInterface, paramActivity, ForwardUtils.a(localIntent), localIntent);
    return;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, Intent paramIntent)
  {
    try
    {
      if (!QLog.isColorLevel()) {
        break label102;
      }
      QLog.d("Q.qqstory.share", 2, "handleShareQQGroupVideo: resultCode=" + paramInt);
    }
    catch (Exception paramQQAppInterface)
    {
      label102:
      do
      {
        Intent localIntent;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqstory.share", 2, "handleShareQQGroupVideo exception", paramQQAppInterface);
        return;
      } while (paramInt == -1);
    }
    localIntent = actn.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    ForwardUtils.a(paramQQAppInterface, paramActivity, ForwardUtils.a(localIntent), localIntent);
    return;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    label24:
    QQAppInterface localQQAppInterface;
    label263:
    do
    {
      return;
      localObject = "";
      if (this.jdField_b_of_type_Int == 1)
      {
        str = "0";
        switch (this.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
        axqw.b(localQQAppInterface, "CliOper", "", "", "Grp", (String)localObject, 0, 0, str, "", "", "");
        bool = bbev.d(BaseApplication.getContext());
        if ((bool) || (this.jdField_a_of_type_Int == 4)) {
          break label263;
        }
        bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692321), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        if (QLog.isColorLevel()) {
          QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
        }
        if (this.jdField_a_of_type_Baud != null) {
          this.jdField_a_of_type_Baud.a(this.jdField_a_of_type_Int, false);
        }
        this.jdField_a_of_type_Int = -1;
        this.jdField_b_of_type_Int = -1;
        if (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
          break;
        }
        ((TroopCreateLogicActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
        return;
        str = "1";
        break label24;
        localObject = "Grplink_moments";
        continue;
        localObject = "Grplink_wechat";
        continue;
        localObject = "Grplink_qq";
        continue;
        localObject = "Grplink_qzone";
        continue;
        localObject = "Copy_grplink";
      }
      if (a() != null) {
        break label460;
      }
      if ((bool) || (this.jdField_a_of_type_Int != 4)) {
        break;
      }
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692321), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
      }
      if (this.jdField_a_of_type_Baud != null) {
        this.jdField_a_of_type_Baud.a(this.jdField_a_of_type_Int, false);
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
    } while (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity));
    ((TroopCreateLogicActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
    return;
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isQidianPrivateTroop)
    {
      ((bduw)localQQAppInterface.a(85)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      return;
    }
    Object localObject = (akhq)localQQAppInterface.a(20);
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_b_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((akhq)localObject).a(str, bool);
      return;
    }
    label460:
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      this.jdField_c_of_type_JavaLangString = bahh.a("", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
      l();
      return;
    case 3: 
      i();
      return;
    case 2: 
      j();
      return;
    case 1: 
      k();
      return;
    }
    m();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    this.e = String.valueOf(System.currentTimeMillis());
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
    Bitmap localBitmap = a(localQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (byte)3, false, false));
    String str = a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    }
    for (;;)
    {
      Object localObject3 = ((TroopManager)localQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      Object localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (!((TroopInfo)localObject3).hasSetTroopName())
        {
          localObject2 = localObject1;
          if (((TroopInfo)localObject3).wMemberNum > 0) {
            localObject2 = (String)localObject1 + "(" + ((TroopInfo)localObject3).wMemberNum + ")";
          }
        }
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = ajyc.a(2131715786) + bbcl.e(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      }
      WXShareHelper.a().a(this.e, (String)localObject2, localBitmap, (String)localObject1, str);
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "shareToFriendCircle.transaction: " + this.e + " troopname:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName + " memo:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo + " shareLink:" + str);
      }
      this.jdField_b_of_type_Int = -1;
      return;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    String str2 = String.valueOf(System.currentTimeMillis());
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
    TroopInfo localTroopInfo = ((TroopManager)localQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Bitmap localBitmap = a(localQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (byte)3, false, false));
    String str3 = a();
    String str1;
    StringBuffer localStringBuffer;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName == null)
    {
      str1 = "";
      localStringBuffer = new StringBuffer(str1);
      if (TextUtils.isEmpty(localStringBuffer)) {
        localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      if ((localTroopInfo != null) && (!localTroopInfo.hasSetTroopName()) && (localTroopInfo.wMemberNumClient > 0)) {
        localStringBuffer.append("(").append(localTroopInfo.wMemberNumClient).append(")");
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      if (!TextUtils.isEmpty(str1)) {
        break label337;
      }
      str1 = ajyc.a(2131715782) + bbcl.e(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
    }
    label337:
    for (;;)
    {
      str1 = a(str1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      WXShareHelper.a().b(str2, localStringBuffer.toString(), localBitmap, str1, str3);
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "shareToWXFriend.transaction: " + str2 + " troopname:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName + " memo:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopIntro + " shareLink:" + str3);
      }
      this.jdField_b_of_type_Int = -1;
      return;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
      break;
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
    Object localObject3 = ((TroopManager)localQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (localObject3 != null) {}
    for (boolean bool = ((TroopInfo)localObject3).isNewTroop; (bool) && (this.d == null); bool = false)
    {
      a(new baub(this));
      return;
    }
    String str = a();
    Object localObject1;
    ArrayList localArrayList;
    if (bool)
    {
      localObject1 = this.d;
      localArrayList = new ArrayList();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      }
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (!((TroopInfo)localObject3).hasSetTroopName())
        {
          localObject2 = localObject1;
          if (((TroopInfo)localObject3).wMemberNumClient > 0) {
            localObject2 = (String)localObject1 + "(" + ((TroopInfo)localObject3).wMemberNum + ")";
          }
        }
      }
      localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719506), new Object[] { localObject2 }) + "(" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + ")" + a();
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("title", (String)localObject2);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        break label539;
      }
      ((Bundle)localObject3).putString("desc", ajyc.a(2131715785) + bbcl.e(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin));
    }
    for (;;)
    {
      ((Bundle)localObject3).putLong("req_share_id", 0L);
      ((Bundle)localObject3).putString("detail_url", str);
      ((Bundle)localObject3).putString("url", str);
      ((Bundle)localObject3).putStringArrayList("image_url", localArrayList);
      ((Bundle)localObject3).putString("troop_wording", (String)localObject1);
      ((Bundle)localObject3).putString("bizname", "JoinTroopLink");
      bgyu.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Bundle)localObject3, null, 145);
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "shareToQzone.troopname:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName + " shareLink:" + str + " desc:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      return;
      localObject1 = bahh.a("", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0) + "100";
      break;
      label539:
      ((Bundle)localObject3).putString("desc", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
    Object localObject3 = ((TroopManager)localQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (localObject3 != null) {}
    for (boolean bool = ((TroopInfo)localObject3).isNewTroop; (bool) && (this.d == null); bool = false)
    {
      a(new bauc(this));
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    }
    if ((localObject3 != null) && (!((TroopInfo)localObject3).hasSetTroopName()) && (((TroopInfo)localObject3).wMemberNumClient > 0)) {}
    for (localObject3 = (String)localObject1 + "(" + ((TroopInfo)localObject3).wMemberNum + ")";; localObject3 = localObject1)
    {
      localObject1 = "group:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      AbsShareMsg localAbsShareMsg = new axuk(StructMsgForGeneralShare.class).c(15).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718645) + (String)localObject3).a("web", a(), (String)localObject1, (String)localObject1, (String)localObject1).a();
      if ((!bool) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
        localObject1 = this.jdField_c_of_type_JavaLangString + "100";
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopShareUtility", 2, "shareToMobileQQ.coverUrl:" + (String)localObject1);
        }
        axym localaxym = new axym();
        localaxym.b(1);
        localaxym.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696483));
        axuo localaxuo = axux.a(2);
        String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
        if (TextUtils.isEmpty(str))
        {
          localObject2 = ajyc.a(2131715784) + bbcl.e(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
          label423:
          localaxuo.a((String)localObject1, (String)localObject3, (String)localObject2, 1);
          localAbsShareMsg.addItem(localaxym);
          localAbsShareMsg.addItem(localaxuo);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("forward_type", -3);
          ((Intent)localObject2).putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
          if (!this.jdField_c_of_type_Boolean) {
            break label689;
          }
        }
        label689:
        for (int i = 21;; i = 3)
        {
          aqbc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject2, i);
          if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            ((TroopCreateLogicActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).jdField_a_of_type_Boolean = true;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TroopShareUtility", 2, "shareToMobileQQ.mMsgServiceID:" + localAbsShareMsg.mMsgServiceID + " mMsgBrief:" + localAbsShareMsg.mMsgBrief + " mContentTitle:" + localAbsShareMsg.mContentTitle + " mContentSummary:" + localAbsShareMsg.mContentSummary + " mMsgUrl:" + localAbsShareMsg.mMsgUrl + " coverUrl:" + (String)localObject1 + " mSourceName:" + localAbsShareMsg.mSourceName);
          }
          this.jdField_a_of_type_Int = -1;
          this.jdField_b_of_type_Int = -1;
          return;
          if (!bool) {
            break label694;
          }
          localObject1 = this.d;
          break;
          localObject2 = str;
          if (str.length() <= 40) {
            break label423;
          }
          localObject2 = str.substring(0, 40);
          break label423;
        }
        label694:
        localObject1 = null;
      }
    }
  }
  
  @TargetApi(11)
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    }
    str1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693691), new Object[] { str1, a() });
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "copyTroopLink.text:" + str1);
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((android.text.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("clipboard")).setText(str1);
    }
    for (;;)
    {
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691311), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      if (this.jdField_a_of_type_Baud != null) {
        this.jdField_a_of_type_Baud.a(this.jdField_a_of_type_Int, true);
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      return;
      ((android.content.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("troop_url", str1));
    }
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_Bcpq == null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
      {
        this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_Bcpq.c(2131694930);
        this.jdField_a_of_type_Bcpq.c(false);
      }
      if (this.jdField_a_of_type_Bcpq != null) {
        this.jdField_a_of_type_Bcpq.show();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopShareUtility", 2, localException.toString());
    }
  }
  
  public void a(baue parambaue)
  {
    ThreadManager.post(new TroopShareUtility.10(this, parambaue), 8, null, false);
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.e == null) || (!this.e.equals(paramBaseResp.transaction)) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null)) {
      return;
    }
    baud localbaud;
    int i;
    if (this.jdField_a_of_type_Baud != null)
    {
      localbaud = this.jdField_a_of_type_Baud;
      i = this.jdField_a_of_type_Int;
      if (paramBaseResp.errCode != 0) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      localbaud.a(i, bool);
      this.jdField_a_of_type_Int = -1;
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719476), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
    }
    bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719495), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  public void a(TroopInfoData paramTroopInfoData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    axqw.b((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime(), "CliOper", "", "", "Grp", "Clk_share_grplink", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = paramTroopInfoData;
    d();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
        this.jdField_a_of_type_Bcpq.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopShareUtility", 2, localException.toString());
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    String str1;
    label63:
    axra localaxra;
    String str2;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localObject = null;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = "2";
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label166;
        }
        str1 = "0";
        localaxra = new axra(null).a("P_CliOper").b("Grp_set").c("Grp_data").d((String)localObject);
        str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!paramBoolean) {
          break label183;
        }
      }
      break;
    }
    label166:
    label183:
    for (Object localObject = "0";; localObject = "1")
    {
      localaxra.a(new String[] { str2, localObject, str1 }).a();
      return;
      localObject = "share_qq";
      break;
      localObject = "share_qzone";
      break;
      localObject = "share_circle";
      break;
      localObject = "share_wechat";
      break;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        break label63;
      }
      str1 = "1";
      break label63;
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Int = 0;
    h();
  }
  
  protected void d()
  {
    Object localObject = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (int i = 5;; i = 4)
    {
      int j = 0;
      while (j <= i)
      {
        ((List)localObject).add(bfov.a(j));
        j += 1;
      }
    }
    if ((this.jdField_a_of_type_Bfov == null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)) {
      this.jdField_a_of_type_Bfov = new bfov(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    if (this.jdField_a_of_type_Bfov != null) {
      this.jdField_a_of_type_Bfov.a((List)localObject);
    }
    if (this.jdField_a_of_type_Bfol == null)
    {
      localObject = new batv(this);
      if (this.jdField_a_of_type_Bbjc == null)
      {
        this.jdField_a_of_type_Bbjc = new bbjc(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_Bbjc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719497));
        this.jdField_a_of_type_Bbjc.a(a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember));
        this.jdField_a_of_type_Bbjc.a(new batw(this));
        this.jdField_a_of_type_Bbjc.a((AdapterView.OnItemClickListener)localObject);
      }
    }
    try
    {
      this.jdField_a_of_type_Bbjc.a();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  protected void e()
  {
    this.jdField_b_of_type_Bfol = ((bfol)bfoy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null));
    this.jdField_b_of_type_Bfol.b(2131720600);
    this.jdField_b_of_type_Bfol.b(2131720601);
    this.jdField_b_of_type_Bfol.c(2131690596);
    this.jdField_b_of_type_Bfol.setOnDismissListener(new batx(this));
    this.jdField_b_of_type_Bfol.a(new baty(this));
    String str;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720598);
    }
    for (;;)
    {
      this.jdField_b_of_type_Bfol.a(str);
      if (!this.jdField_b_of_type_Bfol.isShowing())
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_b_of_type_Bfol.show();
      }
      return;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690791), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720599) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690791), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720602) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690791), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719502) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690791), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719505) });
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Baud = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Bduv);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Akim);
    WXShareHelper.a().b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = null;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
    localIntent.putExtra("title", ajyc.a(2131715781));
    int i;
    if (TextUtils.isEmpty(localTroopInfoData.troopName))
    {
      localIntent.putExtra("nick", localTroopInfoData.newTroopName);
      localIntent.putExtra("uin", localTroopInfoData.troopUin);
      if (!localTroopInfoData.bOwner) {
        break label227;
      }
      i = 0;
    }
    for (;;)
    {
      localIntent.putExtra("adminLevel", i);
      localIntent.putExtra("type", 2);
      localIntent.putExtra("GroupFlagExt", localTroopInfoData.dwGroupFlagExt);
      localIntent.putExtra("AuthGroupType", localTroopInfoData.dwAuthGroupType);
      QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
      boolean bool = TroopInfo.isQidianPrivateTroop(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("isQidianPrivateTroop", bool);
      if (bool) {
        localIntent.putExtra("groupOwner", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      }
      ThreadManager.post(new TroopShareUtility.9(this, localQQAppInterface, localTroopInfoData, localIntent), 8, null, true);
      return;
      localIntent.putExtra("nick", localTroopInfoData.troopName);
      break;
      label227:
      if (localTroopInfoData.bAdmin) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     batu
 * JD-Core Version:    0.7.0.1
 */