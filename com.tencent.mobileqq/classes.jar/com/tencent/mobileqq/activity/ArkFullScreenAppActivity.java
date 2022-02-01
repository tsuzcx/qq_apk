package com.tencent.mobileqq.activity;

import Override;
import adul;
import adum;
import adun;
import aduo;
import adup;
import aduq;
import agyw;
import agyz;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anzj;
import aqbx;
import aqca;
import aqcy;
import aqdg;
import aqet;
import bhow;
import blir;
import blji;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.ark.ArkTopGestureLayout;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class ArkFullScreenAppActivity
  extends IphoneTitleBarActivity
{
  private static ArrayList<Bundle> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_a_of_type_Int = 0;
  private agyz jdField_a_of_type_Agyz = new adul(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bhow jdField_a_of_type_Bhow;
  ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  protected ArkTopGestureLayout a;
  private Stack<bhow> jdField_a_of_type_JavaUtilStack = new Stack();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  private agyw a(bhow parambhow)
  {
    agyw localagyw = new agyw();
    parambhow.jdField_a_of_type_Agyw = localagyw;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight();
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "create App: w=" + i + ",h=" + j);
    }
    localagyw.a(parambhow.jdField_a_of_type_JavaLangString, parambhow.b, parambhow.c, parambhow.d, aqbx.a(), parambhow.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localagyw.setFixSize(i, j);
    localagyw.setMaxSize(i, j);
    localagyw.setMinSize(i, j);
    localagyw.a(this.jdField_a_of_type_Agyz);
    return localagyw;
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramString4, paramFloat, ArkAppCacheMgr.getApplicationFromManifest(paramString2, "0.0.0.1"));
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, Map<String, String> paramMap)
  {
    Object localObject1 = "0.0.0.1";
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2)) {
          return null;
        }
        if (paramMap == null) {
          break label308;
        }
        if (!paramMap.containsKey("desc")) {
          break label294;
        }
        localObject1 = (String)paramMap.get("desc");
        if (!paramMap.containsKey("version")) {
          break label301;
        }
        localObject2 = (String)paramMap.get("version");
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ArkFullScreenAppActivity", 1, "buildForwardIntent send message parameter error: " + paramContext.getMessage());
        return null;
      }
      Object localObject3 = String.format(anzj.a(2131699598), new Object[] { localObject2 });
      paramMap = a(paramString4, paramMap);
      paramString4 = bhow.a(paramString2, paramString1, (String)localObject1, paramString3, paramFloat, null, null);
      paramString4.putBoolean("forward_ark_app_direct", false);
      paramString4.putString("forward_ark_app_name", paramString2);
      paramString4.putString("forward_ark_app_view", paramString1);
      paramString4.putString("forward_ark_app_desc", (String)localObject2);
      paramString4.putString("forward_ark_app_ver", (String)localObject1);
      paramString4.putString("forward_ark_app_meta", paramString3);
      paramString4.putString("forward_ark_app_prompt", (String)localObject3);
      paramString4.putString("forward_ark_app_config", paramMap);
      paramString1 = new Intent();
      paramString1.setClass(paramContext, ForwardRecentActivity.class);
      paramString1.putExtra("forward_type", 27);
      paramString1.putExtra("is_ark_display_share", true);
      paramString1.putExtras(paramString4);
      if (QLog.isColorLevel())
      {
        QLog.i("ArkFullScreenAppActivity", 2, "buildForwardIntent: " + paramString4);
        return paramString1;
        label294:
        localObject1 = "";
        continue;
        label301:
        localObject2 = "0.0.0.1";
        break label317;
        label308:
        localObject2 = "";
        continue;
      }
      else
      {
        return paramString1;
      }
      label317:
      localObject3 = localObject1;
      localObject1 = localObject2;
      Object localObject2 = localObject3;
    }
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, float paramFloat)
  {
    aqet.a(true);
    return a(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramFloat, ArkAppCacheMgr.getApplicationFromManifest(paramString2, "0.0.0.1"));
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, float paramFloat, Map<String, String> paramMap)
  {
    Object localObject = "0.0.0.1";
    label304:
    label311:
    label318:
    label335:
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2)) {
          return null;
        }
        if (paramMap == null) {
          break label318;
        }
        if (!paramMap.containsKey("desc")) {
          break label304;
        }
        localObject = (String)paramMap.get("desc");
        if (!paramMap.containsKey("version")) {
          break label311;
        }
        paramMap = (String)paramMap.get("version");
      }
      catch (Exception paramContext)
      {
        String str2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ArkFullScreenAppActivity", 1, "buildForwardIntent send message parameter error: " + paramContext.getMessage());
        return null;
      }
      String str1 = String.format(anzj.a(2131699600), new Object[] { localObject });
      str2 = a(paramString4);
      paramString4 = bhow.a(paramString2, paramString1, paramMap, paramString3, paramFloat, null, null);
      paramString4.putBoolean("forward_ark_app_direct", false);
      paramString4.putString("forward_ark_app_name", paramString2);
      paramString4.putString("forward_ark_app_view", paramString1);
      paramString4.putString("forward_ark_app_desc", (String)localObject);
      paramString4.putString("forward_ark_app_ver", paramMap);
      paramString4.putString("forward_ark_app_meta", paramString3);
      paramString4.putString("forward_ark_app_prompt", str1);
      paramString4.putString("forward_ark_app_config", str2);
      paramString4.putBoolean("forward_ark_from_sdk", true);
      paramString4.putString("forward_appId_ark_from_sdk", paramString5);
      paramString1 = new Intent();
      paramString1.setClass(paramContext, ForwardRecentActivity.class);
      paramString1.putExtra("forward_type", 11);
      paramString1.putExtras(paramString4);
      if (QLog.isColorLevel())
      {
        QLog.i("ArkFullScreenAppActivity", 2, "buildForwardIntent: " + paramString4);
        return paramString1;
        localObject = "";
        continue;
        paramMap = "0.0.0.1";
        break label335;
        str1 = "";
        paramMap = (Map<String, String>)localObject;
        localObject = str1;
      }
      else
      {
        return paramString1;
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localJSONObject.put("forward", 1);
      paramString = localJSONObject;
      if (!localJSONObject.has("type"))
      {
        localJSONObject.put("type", "card");
        paramString = localJSONObject;
      }
    }
    for (;;)
    {
      return paramString.toString();
      paramString = new JSONObject();
      paramString.put("forward", 1);
      paramString.put("autosize", 1);
      paramString.put("type", "card");
    }
  }
  
  private static String a(String paramString, Map<String, String> paramMap)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("forward", 1);
        localJSONObject.put("autosize", 1);
        if ((paramMap != null) && ("normal".equals(paramMap.get("type"))))
        {
          localJSONObject.put("type", "normal");
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          paramString = new JSONObject(paramString);
          paramMap = paramString.keys();
          if (!paramMap.hasNext()) {
            break;
          }
          String str = (String)paramMap.next();
          localJSONObject.put(str, paramString.getString(str));
          continue;
        }
        localJSONObject.put("type", "card");
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return "";
      }
    }
    paramString = localJSONObject.toString();
    return paramString;
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    paramString1 = bhow.a(paramString1, paramString2, "0.0.0.1", paramString3, aqbx.a(), null, null);
    paramString1.putInt("sourceType", 0);
    paramString2 = new Intent(paramActivity, ArkFullScreenAppActivity.class);
    paramString2.putExtras(paramString1);
    paramString2.putExtra("card_height", MessageForArkApp.dp2px(297.0F));
    paramString2.putExtra("show_as_card", true);
    paramActivity.startActivity(paramString2);
    paramActivity.overridePendingTransition(2130771997, 2130772001);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, String paramString5, int paramInt)
  {
    paramString1 = bhow.a(paramString1, paramString2, paramString3, paramString4, aqbx.a(), paramString5, null);
    paramString1.putInt("sourceType", paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "startFullScreenApp:" + paramString1);
    }
    paramString2 = new Intent(paramContext, ArkFullScreenAppActivity.class);
    paramString2.putExtras(paramString1);
    paramContext.startActivity(paramString2);
  }
  
  private void a(Bundle paramBundle)
  {
    bhow localbhow = new bhow(paramBundle);
    this.jdField_a_of_type_Int = paramBundle.getInt("sourceType", 0);
    paramBundle = a(localbhow);
    this.jdField_a_of_type_JavaUtilStack.push(localbhow);
    this.jdField_a_of_type_Bhow = localbhow;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.initArkView(paramBundle, false);
    if (localbhow != null)
    {
      setTitle(localbhow.e);
      if (1 == this.jdField_a_of_type_Int) {
        aqca.a(this.app, localbhow.jdField_a_of_type_JavaLangString, "ArkFullEnterFromAppManage", 1, 0, 0L, 0L, 0L, null, null);
      }
    }
    if (this.jdField_a_of_type_JavaUtilStack.size() > 1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkFullScreenAppActivity", 2, "init: " + localbhow.jdField_a_of_type_JavaLangString + ", " + this.jdField_a_of_type_JavaUtilStack.size());
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public static boolean a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("forward_ark_app_name");
    String str2 = paramBundle.getString("forward_ark_app_view");
    String str3 = paramBundle.getString("forward_ark_app_ver");
    String str4 = paramBundle.getString("forward_ark_app_meta");
    paramBundle = paramBundle.getString("forward_ark_app_config");
    if (QLog.isColorLevel()) {
      QLog.e("ArkFullScreenAppActivity", 2, "richMsgBody displayArk appName =" + str1 + ", appView =" + str2 + ", appMeta =" + str4 + ", config =" + paramBundle + ", appVer" + str3);
    }
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str4));
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilStack.iterator();
    while (localIterator.hasNext())
    {
      agyw localagyw = ((bhow)localIterator.next()).jdField_a_of_type_Agyw;
      if (localagyw != null) {
        localagyw.doOnEvent(2);
      }
    }
    this.jdField_a_of_type_JavaUtilStack.clear();
  }
  
  public Intent a(agyw paramagyw)
  {
    try
    {
      Object localObject1 = paramagyw.getViewShare();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
      Document localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes()));
      localObject1 = localDocument.getElementsByTagName("View").item(0);
      if ((localObject1 != null) && (((Node)localObject1).getChildNodes().getLength() > 0) && ((((Node)localObject1).getFirstChild() instanceof Text)))
      {
        String str = ((Node)localObject1).getFirstChild().getNodeValue();
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        Node localNode = localDocument.getElementsByTagName("Metadata").item(0);
        Object localObject2 = new JSONObject();
        localObject1 = localObject2;
        if (localNode != null)
        {
          localObject1 = localObject2;
          if (localNode.getChildNodes().getLength() > 0)
          {
            localObject1 = localObject2;
            if (!aqcy.a(localNode.getFirstChild(), (JSONObject)localObject2)) {
              localObject1 = new JSONObject();
            }
          }
        }
        paramagyw = paramagyw.getAppName();
        localObject1 = ((JSONObject)localObject1).toString();
        float f = aqbx.a();
        localObject2 = MessageForArkApp.getConfigFromXml(localDocument);
        if (QLog.isColorLevel()) {
          QLog.i("ArkApp", 2, "ArkFullScreenApp config getShareMsg:" + (String)localObject2);
        }
        paramagyw = a(this, str, paramagyw, (String)localObject1, (String)localObject2, f);
        return paramagyw;
      }
    }
    catch (Exception paramagyw)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkFullScreenAppActivity", 1, "getShareMsg send message parameter error: " + paramagyw.getMessage());
      }
      return null;
    }
    return null;
  }
  
  public void a()
  {
    blir localblir = (blir)blji.a(this, null);
    localblir.a(getString(2131718173), 0);
    localblir.a(new aduq(this, localblir));
    localblir.c(2131690580);
    localblir.show();
  }
  
  public void a(agyw paramagyw, String paramString)
  {
    if ((this.jdField_a_of_type_Bhow != null) && (this.jdField_a_of_type_Bhow.jdField_a_of_type_Agyw == paramagyw))
    {
      this.jdField_a_of_type_Bhow.e = paramString;
      setTitle(paramString);
    }
    bhow localbhow;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.jdField_a_of_type_JavaUtilStack.iterator();
      }
      localbhow = (bhow)localIterator.next();
    } while ((localbhow == null) || (localbhow.jdField_a_of_type_Agyw != paramagyw));
    localbhow.e = paramString;
  }
  
  public void a(agyw paramagyw, boolean paramBoolean)
  {
    int j = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilStack.iterator();
    while (localIterator.hasNext())
    {
      bhow localbhow = (bhow)localIterator.next();
      if ((localbhow != null) && (localbhow.jdField_a_of_type_Agyw == paramagyw))
      {
        localbhow.jdField_a_of_type_Boolean = paramBoolean;
        if (this.jdField_a_of_type_Bhow == localbhow)
        {
          if ((!localbhow.jdField_a_of_type_Agyw.checkShare()) || (!localbhow.jdField_a_of_type_Boolean)) {
            break label102;
          }
          i = 1;
          paramagyw = this.rightViewImg;
          if (i == 0) {
            break label107;
          }
        }
      }
    }
    label102:
    label107:
    for (int i = j;; i = 4)
    {
      paramagyw.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 100) && (this.jdField_a_of_type_Bhow != null))
    {
      aqca.a(this.app, "FullScreenClickOper", this.jdField_a_of_type_Bhow.jdField_a_of_type_JavaLangString, null, aqca.e, 0, 0);
      aqca.a(this.app, this.jdField_a_of_type_Bhow.jdField_a_of_type_JavaLangString, "FullScreenShareSuccess", 0, 0, 0L, 0L, 0L, "", "");
      if (1 == this.jdField_a_of_type_Int) {
        aqca.a(this.app, this.jdField_a_of_type_Bhow.jdField_a_of_type_JavaLangString, "ArkFullShareFromAppManage", 1, 0, 0L, 0L, 0L, null, null);
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      finish();
      return false;
    }
    Object localObject = getWindowManager().getDefaultDisplay();
    if (localObject != null)
    {
      this.c = ((Display)localObject).getWidth();
      this.d = ((Display)localObject).getHeight();
    }
    setContentView(2131558696);
    localObject = (FrameLayout)findViewById(16908290);
    if (this.titleRoot != null) {
      this.titleRoot.setBackgroundColor(getResources().getColor(2131165427));
    }
    ((NavBarCommon)this.vg).changeBg(true);
    this.leftView.setText("");
    this.leftView.setMinWidth(MessageForArkApp.dp2px(35.0F));
    localObject = (RelativeLayout)findViewById(2131376731);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840290);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(1, 2131369042);
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new adum(this));
    int i = MessageForArkApp.dp2px(6.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, i, 0);
    this.rightViewImg = ((ImageView)findViewById(2131369056));
    this.rightViewImg.setBackgroundDrawable(null);
    setLayerType(this.rightViewImg);
    this.rightViewImg.setVisibility(4);
    this.rightViewImg.setImageResource(2130840292);
    this.rightViewImg.setContentDescription(anzj.a(2131699596));
    this.rightViewImg.setOnClickListener(new adun(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)findViewById(2131362945));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new aduo(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.post(new ArkFullScreenAppActivity.5(this, paramBundle));
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "doOnCreate:" + paramBundle);
    }
    findViewById(2131376731);
    aqca.a(this.app, "ShowView", paramBundle.getString("appName"), null, aqca.h, 0, 0);
    aqdg.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkTopGestureLayout = new ArkTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentMobileqqArkArkTopGestureLayout);
    }
    if (ThemeUtil.isInNightMode(this.app))
    {
      paramBundle = (RelativeLayout)findViewById(2131379050);
      LayoutInflater.from(this).inflate(2131560238, paramBundle);
    }
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("show_as_card", false);
    this.b = getIntent().getIntExtra("card_height", 0);
    if ((this.jdField_a_of_type_Boolean) && (this.b > 0))
    {
      findViewById(2131376731).setVisibility(8);
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getLayoutParams();
      paramBundle.addRule(12);
      paramBundle.height = this.b;
      this.titleRoot.setBackgroundResource(0);
      this.titleRoot.setOnClickListener(new adup(this));
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    b();
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("ArkFullScreenAppActivity", 2, "doOnDestroy: ");
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getExtras();
    a(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "doOnNewIntent" + paramIntent);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    SystemBarCompact localSystemBarCompact;
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusBarDrawable(null);
      localSystemBarCompact = this.mSystemBarComp;
      if (!this.jdField_a_of_type_Boolean) {
        break label39;
      }
    }
    label39:
    for (int i = 0;; i = -16777216)
    {
      localSystemBarCompact.setStatusBarColor(i);
      return;
    }
  }
  
  public void finish()
  {
    b();
    super.finish();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Bhow != null) {
      aqca.a(this.app, "FullScreenClickOper", this.jdField_a_of_type_Bhow.jdField_a_of_type_JavaLangString, null, aqca.jdField_a_of_type_Int, 0, 0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkFullScreenAppActivity", 2, "onBackEvent: " + this.jdField_a_of_type_JavaUtilStack.size());
    }
    if (this.jdField_a_of_type_JavaUtilStack.size() <= 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_Boolean)
      {
        finish();
        overridePendingTransition(2130771997, 2130772001);
        return true;
      }
      return super.onBackEvent();
    }
    agyw localagyw = ((bhow)this.jdField_a_of_type_JavaUtilStack.pop()).jdField_a_of_type_Agyw;
    if (localagyw != null) {
      localagyw.doOnEvent(2);
    }
    this.jdField_a_of_type_Bhow = ((bhow)this.jdField_a_of_type_JavaUtilStack.peek());
    if (this.jdField_a_of_type_Bhow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.initArkView(this.jdField_a_of_type_Bhow.jdField_a_of_type_Agyw);
      setTitle(this.jdField_a_of_type_Bhow.e);
    }
    if (this.jdField_a_of_type_JavaUtilStack.size() > 1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Display localDisplay = getWindowManager().getDefaultDisplay();
    if (localDisplay == null) {
      QLog.d("ArkFullScreenAppActivity", 2, "onConfigurationChanged:get display null");
    }
    for (;;)
    {
      EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
      return;
      int i = localDisplay.getWidth();
      int j = localDisplay.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("ArkFullScreenAppActivity", 2, new Object[] { "onConfigurationChanged:width=", Integer.valueOf(i), ", height=", Integer.valueOf(j), ", mScreenWidth=", Integer.valueOf(this.c), ", mScreenheight=", Integer.valueOf(this.d) });
      }
      if ((this.c != 0) && (this.d != 0) && ((this.c != i) || (this.d != j)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setFixSize(i, j);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setMinSize(i, j);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setMaxSize(i, j);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setViewRect(i, j);
      }
      this.c = i;
      this.d = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity
 * JD-Core Version:    0.7.0.1
 */