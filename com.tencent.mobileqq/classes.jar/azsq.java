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

public class azsq
  implements bbsh
{
  protected int a;
  protected ajuc a;
  protected azsz a;
  protected bahv a;
  protected bbms a;
  bcqu jdField_a_of_type_Bcqu = new azsw(this);
  protected begr a;
  protected behb a;
  public BaseActivity a;
  public TroopInfoData a;
  protected String a;
  boolean jdField_a_of_type_Boolean = false;
  protected int b;
  protected begr b;
  protected String b;
  protected boolean b;
  protected String c;
  private boolean c;
  protected String d;
  protected String e;
  
  public azsq(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData)
  {
    this(paramBaseActivity, paramTroopInfoData, null);
  }
  
  public azsq(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData, azsz paramazsz)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Ajuc = new azsv(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = paramTroopInfoData;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Bcqu);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Ajuc);
    WXShareHelper.a().a(this);
    this.jdField_a_of_type_Azsz = paramazsz;
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
    Object localObject = vvp.a(paramString, -1);
    int m = ((gq)localObject).a();
    paramString = new int[m * m];
    int i = 0;
    while (i < m)
    {
      int j = 0;
      if (j < m)
      {
        if (((gq)localObject).a(j, i)) {}
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
        paramResources = azvq.a(paramResources, 2130839365);
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
      str = paramContext.getString(2131653630);
    }
    return str;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    try
    {
      localAbsShareMsg = new awui(StructMsgForGeneralShare.class).c(132).a(paramBundle.getString("summary")).e(paramBundle.getString("targetUrl")).a(1105290942L).a();
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
        localObject = awuv.a(2);
        String str = paramBundle.getString("summary");
        ((awum)localObject).a(paramBundle.getString("imageUrl"), paramBundle.getString("title"), str);
        localAbsShareMsg.addItem((awul)localObject);
        paramBundle = new Intent();
        paramBundle.putExtra("forward_type", -3);
        paramBundle.putExtra("emoInputType", 2);
        paramBundle.putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
        aphp.a(paramActivity, paramBundle, paramInt);
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
      AbsShareMsg localAbsShareMsg = new awui(StructMsgForGeneralShare.class).c(80).a(paramMessageForQQStory.brief).e("").a();
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
        aphp.a(paramActivity, (Intent)localObject, paramInt);
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
    localIntent = aciy.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    ForwardUtils.a(paramQQAppInterface, paramActivity, ForwardUtils.a(localIntent), localIntent);
    return;
  }
  
  public static List<bahx>[] a(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new bahx();
    ((bahx)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131630983);
    ((bahx)localObject).jdField_b_of_type_Int = 2130838732;
    ((bahx)localObject).jdField_b_of_type_Boolean = true;
    ((bahx)localObject).c = 2;
    ((bahx)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new bahx();
    ((bahx)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131630996);
    ((bahx)localObject).jdField_b_of_type_Int = 2130838733;
    ((bahx)localObject).jdField_b_of_type_Boolean = true;
    ((bahx)localObject).c = 3;
    ((bahx)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new bahx();
    ((bahx)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131631003);
    ((bahx)localObject).jdField_b_of_type_Int = 2130838736;
    ((bahx)localObject).c = 9;
    ((bahx)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new bahx();
    ((bahx)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131630986);
    ((bahx)localObject).jdField_b_of_type_Int = 2130838730;
    ((bahx)localObject).c = 10;
    ((bahx)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    bahx localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630975);
    localbahx.jdField_b_of_type_Int = 2130838728;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 1;
    localbahx.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localbahx);
    if (paramBoolean)
    {
      localbahx = new bahx();
      localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131651399);
      localbahx.jdField_b_of_type_Int = 2130841846;
      localbahx.jdField_b_of_type_Boolean = true;
      localbahx.c = 23;
      localbahx.jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject).add(localbahx);
    }
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    try
    {
      Object localObject = new awui(StructMsgForGeneralShare.class);
      if ("action_mqq".equals(paramBundle.getString("jump_action")))
      {
        localObject = ((awui)localObject).c(129).a(paramBundle.getString("summary")).a(1104763709L).a();
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
        awum localawum = awuv.a(2);
        String str = paramBundle.getString("summary");
        localawum.a(paramBundle.getString("imageUrl"), paramBundle.getString("title"), str);
        ((AbsShareMsg)localObject).addItem(localawum);
        paramBundle = new Intent();
        paramBundle.putExtra("forward_type", -3);
        paramBundle.putExtra("emoInputType", 2);
        paramBundle.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
        paramBundle.putExtra("structmsg_service_id", ((AbsShareMsg)localObject).mMsgServiceID);
        aphp.a(paramActivity, paramBundle, paramInt);
        return;
        localObject = ((awui)localObject).c(129).a(paramBundle.getString("summary")).e(paramBundle.getString("targetUrl")).a(1104763709L).a();
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
    localIntent = aciy.a(new Intent(paramActivity, SplashActivity.class), null);
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
    localIntent = aciy.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    ForwardUtils.a(paramQQAppInterface, paramActivity, ForwardUtils.a(localIntent), localIntent);
    return;
  }
  
  private void h()
  {
    Object localObject = "";
    label56:
    QQAppInterface localQQAppInterface;
    if (this.jdField_b_of_type_Int == 1)
    {
      str = "0";
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
        awqx.b(localQQAppInterface, "CliOper", "", "", "Grp", (String)localObject, 0, 0, str, "", "", "");
        bool = badq.d(BaseApplication.getContext());
        if ((!bool) && (this.jdField_a_of_type_Int != 4))
        {
          bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131626719), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          if (QLog.isColorLevel()) {
            QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
          }
          if (this.jdField_a_of_type_Azsz != null) {
            this.jdField_a_of_type_Azsz.a(this.jdField_a_of_type_Int, false);
          }
          this.jdField_a_of_type_Int = -1;
          this.jdField_b_of_type_Int = -1;
          if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            ((TroopCreateLogicActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          }
        }
        break;
      }
    }
    do
    {
      return;
      str = "1";
      break;
      localObject = "Grplink_moments";
      break label56;
      localObject = "Grplink_wechat";
      break label56;
      localObject = "Grplink_qq";
      break label56;
      localObject = "Grplink_qzone";
      break label56;
      localObject = "Copy_grplink";
      break label56;
      if (a() != null) {
        break label452;
      }
      if ((bool) || (this.jdField_a_of_type_Int != 4)) {
        break label370;
      }
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131626719), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
      }
      if (this.jdField_a_of_type_Azsz != null) {
        this.jdField_a_of_type_Azsz.a(this.jdField_a_of_type_Int, false);
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
    } while (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity));
    ((TroopCreateLogicActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
    return;
    label370:
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isQidianPrivateTroop)
    {
      ((bcqv)localQQAppInterface.a(85)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      return;
    }
    localObject = (ajtg)localQQAppInterface.a(20);
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_b_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ajtg)localObject).a(str, bool);
      return;
    }
    label452:
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      this.jdField_c_of_type_JavaLangString = azge.a("", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
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
        localObject1 = ajjy.a(2131649995) + babh.e(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
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
        break label329;
      }
      str1 = ajjy.a(2131649991) + babh.e(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
    }
    label329:
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
      a(new azsx(this));
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
      localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131653623), new Object[] { localObject2 }) + "(" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + ")" + a();
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("title", (String)localObject2);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        break label539;
      }
      ((Bundle)localObject3).putString("desc", ajjy.a(2131649994) + babh.e(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin));
    }
    for (;;)
    {
      ((Bundle)localObject3).putLong("req_share_id", 0L);
      ((Bundle)localObject3).putString("detail_url", str);
      ((Bundle)localObject3).putString("url", str);
      ((Bundle)localObject3).putStringArrayList("image_url", localArrayList);
      ((Bundle)localObject3).putString("troop_wording", (String)localObject1);
      ((Bundle)localObject3).putString("bizname", "JoinTroopLink");
      bfqn.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Bundle)localObject3, null, 145);
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "shareToQzone.troopname:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName + " shareLink:" + str + " desc:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      return;
      localObject1 = azge.a("", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0) + "100";
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
      a(new azsy(this));
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
      AbsShareMsg localAbsShareMsg = new awui(StructMsgForGeneralShare.class).c(15).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131652820) + (String)localObject3).a("web", a(), (String)localObject1, (String)localObject1, (String)localObject1).a();
      if ((!bool) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
        localObject1 = this.jdField_c_of_type_JavaLangString + "100";
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopShareUtility", 2, "shareToMobileQQ.coverUrl:" + (String)localObject1);
        }
        awyk localawyk = new awyk();
        localawyk.b(1);
        localawyk.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131630780));
        awum localawum = awuv.a(2);
        String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
        if (TextUtils.isEmpty(str))
        {
          localObject2 = ajjy.a(2131649993) + babh.e(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
          label423:
          localawum.a((String)localObject1, (String)localObject3, (String)localObject2, 1);
          localAbsShareMsg.addItem(localawyk);
          localAbsShareMsg.addItem(localawum);
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
          aphp.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject2, i);
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
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    }
    str1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131628050), new Object[] { str1, a() });
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "copyTroopLink.text:" + str1);
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((android.text.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("clipboard")).setText(str1);
    }
    for (;;)
    {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625735), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      if (this.jdField_a_of_type_Azsz != null) {
        this.jdField_a_of_type_Azsz.a(this.jdField_a_of_type_Int, true);
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
      if (this.jdField_a_of_type_Bbms == null)
      {
        this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_Bbms.c(2131629253);
        this.jdField_a_of_type_Bbms.c(false);
      }
      this.jdField_a_of_type_Bbms.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopShareUtility", 2, localException.toString());
    }
  }
  
  public void a(azta paramazta)
  {
    ThreadManager.post(new TroopShareUtility.10(this, paramazta), 8, null, false);
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.e == null) || (!this.e.equals(paramBaseResp.transaction))) {
      return;
    }
    azsz localazsz;
    int i;
    if (this.jdField_a_of_type_Azsz != null)
    {
      localazsz = this.jdField_a_of_type_Azsz;
      i = this.jdField_a_of_type_Int;
      if (paramBaseResp.errCode != 0) {
        break label123;
      }
    }
    label123:
    for (boolean bool = true;; bool = false)
    {
      localazsz.a(i, bool);
      this.jdField_a_of_type_Int = -1;
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131653595), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
    }
    bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131653612), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  public void a(TroopInfoData paramTroopInfoData)
  {
    awqx.b((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime(), "CliOper", "", "", "Grp", "Clk_share_grplink", 0, 0, "", "", "", "");
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
      if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
        this.jdField_a_of_type_Bbms.dismiss();
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
    awrb localawrb;
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
        localawrb = new awrb(null).a("P_CliOper").b("Grp_set").c("Grp_data").d((String)localObject);
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
      localawrb.a(new String[] { str2, localObject, str1 }).a();
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
        ((List)localObject).add(behb.a(j));
        j += 1;
      }
    }
    if (this.jdField_a_of_type_Behb == null) {
      this.jdField_a_of_type_Behb = new behb(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_Behb.a((List)localObject);
    if (this.jdField_a_of_type_Begr == null)
    {
      localObject = new azsr(this);
      if (this.jdField_a_of_type_Bahv == null)
      {
        this.jdField_a_of_type_Bahv = new bahv(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_Bahv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131653614));
        this.jdField_a_of_type_Bahv.a(a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember));
        this.jdField_a_of_type_Bahv.a(new azss(this));
        this.jdField_a_of_type_Bahv.a((AdapterView.OnItemClickListener)localObject);
      }
    }
    try
    {
      this.jdField_a_of_type_Bahv.a();
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
    this.jdField_b_of_type_Begr = ((begr)behe.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null));
    this.jdField_b_of_type_Begr.b(2131654702);
    this.jdField_b_of_type_Begr.b(2131654703);
    this.jdField_b_of_type_Begr.c(2131625035);
    this.jdField_b_of_type_Begr.setOnDismissListener(new azst(this));
    this.jdField_b_of_type_Begr.a(new azsu(this));
    String str;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131654700);
    }
    for (;;)
    {
      this.jdField_b_of_type_Begr.a(str);
      if (!this.jdField_b_of_type_Begr.isShowing())
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_b_of_type_Begr.show();
      }
      return;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625230), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131654701) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625230), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131654704) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625230), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131653619) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625230), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131653622) });
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Azsz = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Bcqu);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Ajuc);
    WXShareHelper.a().b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = null;
  }
  
  public void g()
  {
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
    localIntent.putExtra("title", ajjy.a(2131649990));
    int i;
    if (TextUtils.isEmpty(localTroopInfoData.troopName))
    {
      localIntent.putExtra("nick", localTroopInfoData.newTroopName);
      localIntent.putExtra("uin", localTroopInfoData.troopUin);
      if (!localTroopInfoData.bOwner) {
        break label219;
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
      label219:
      if (localTroopInfoData.bAdmin) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azsq
 * JD-Core Version:    0.7.0.1
 */