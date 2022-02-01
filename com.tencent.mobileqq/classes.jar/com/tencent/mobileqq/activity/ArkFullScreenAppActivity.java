package com.tencent.mobileqq.activity;

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
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkTopGestureLayout;
import com.tencent.mobileqq.ark.ArkViewAdjustFromKeyboard;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
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
  private static int c = 0;
  private int jdField_a_of_type_Int = 0;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final ArkAppContainer.ArkAppModuleCallback jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback = new ArkFullScreenAppActivity.1(this);
  ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  protected ArkTopGestureLayout a;
  private QQCustomArkDialog.AppInfo jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo = null;
  private Stack<QQCustomArkDialog.AppInfo> jdField_a_of_type_JavaUtilStack = new Stack();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int d = 0;
  private int e = 0;
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramString4, paramFloat, ArkAppCacheMgr.getApplicationFromManifest(paramString2, "0.0.0.1"));
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, Map<String, String> paramMap)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString2);
      if (bool) {
        return null;
      }
      String str1 = "";
      String str4 = "0.0.0.1";
      String str2 = str1;
      String str3 = str4;
      if (paramMap != null)
      {
        if (paramMap.containsKey("desc")) {
          str1 = (String)paramMap.get("desc");
        }
        str2 = str1;
        str3 = str4;
        if (paramMap.containsKey("version"))
        {
          str3 = (String)paramMap.get("version");
          str2 = str1;
        }
      }
      str1 = String.format(HardCodeUtil.a(2131700906), new Object[] { str2 });
      paramMap = a(paramString4, paramMap);
      paramString4 = QQCustomArkDialog.AppInfo.a(paramString2, paramString1, str3, paramString3, paramFloat, null, null);
      paramString4.putBoolean("forward_ark_app_direct", false);
      paramString4.putString("forward_ark_app_name", paramString2);
      paramString4.putString("forward_ark_app_view", paramString1);
      paramString4.putString("forward_ark_app_desc", str2);
      paramString4.putString("forward_ark_app_ver", str3);
      paramString4.putString("forward_ark_app_meta", paramString3);
      paramString4.putString("forward_ark_app_prompt", str1);
      paramString4.putString("forward_ark_app_config", paramMap);
      paramString1 = new Intent();
      paramString1.setClass(paramContext, ForwardRecentActivity.class);
      paramString1.putExtra("forward_type", 27);
      paramString1.putExtra("is_ark_display_share", true);
      paramString1.putExtras(paramString4);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("buildForwardIntent: ");
        paramContext.append(paramString4);
        QLog.i("ArkFullScreenAppActivity", 2, paramContext.toString());
      }
      return paramString1;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("buildForwardIntent send message parameter error: ");
        paramString1.append(paramContext.getMessage());
        QLog.i("ArkFullScreenAppActivity", 1, paramString1.toString());
      }
    }
    return null;
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, float paramFloat)
  {
    ArkMultiProcUtil.a(true);
    return a(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramFloat, ArkAppCacheMgr.getApplicationFromManifest(paramString2, "0.0.0.1"));
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, float paramFloat, Map<String, String> paramMap)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString2);
        if (bool) {
          return null;
        }
        str3 = "0.0.0.1";
        if (paramMap == null) {
          break label335;
        }
        if (!paramMap.containsKey("desc")) {
          break label328;
        }
        str2 = (String)paramMap.get("desc");
        str1 = str2;
        if (!paramMap.containsKey("version")) {
          break label339;
        }
        str3 = (String)paramMap.get("version");
        str1 = str2;
      }
      catch (Exception paramContext)
      {
        String str3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramString1 = new StringBuilder();
        paramString1.append("buildForwardIntent send message parameter error: ");
        paramString1.append(paramContext.getMessage());
        QLog.i("ArkFullScreenAppActivity", 1, paramString1.toString());
        return null;
      }
      String str1 = String.format(HardCodeUtil.a(2131700908), new Object[] { paramMap });
      String str2 = a(paramString4);
      paramString4 = QQCustomArkDialog.AppInfo.a(paramString2, paramString1, str3, paramString3, paramFloat, null, null);
      paramString4.putBoolean("forward_ark_app_direct", false);
      paramString4.putString("forward_ark_app_name", paramString2);
      paramString4.putString("forward_ark_app_view", paramString1);
      paramString4.putString("forward_ark_app_desc", paramMap);
      paramString4.putString("forward_ark_app_ver", str3);
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
        paramContext = new StringBuilder();
        paramContext.append("buildForwardIntent: ");
        paramContext.append(paramString4);
        QLog.i("ArkFullScreenAppActivity", 2, paramContext.toString());
      }
      return paramString1;
      label328:
      str2 = "";
      continue;
      label335:
      str1 = "";
      label339:
      paramMap = str1;
      if (str1 == null) {
        paramMap = "";
      }
    }
  }
  
  private ArkAppContainer a(QQCustomArkDialog.AppInfo paramAppInfo)
  {
    ArkAppContainer localArkAppContainer = new ArkAppContainer();
    paramAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = localArkAppContainer;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create App: w=");
      localStringBuilder.append(i);
      localStringBuilder.append(",h=");
      localStringBuilder.append(j);
      QLog.d("ArkFullScreenAppActivity", 2, localStringBuilder.toString());
    }
    localArkAppContainer.a(paramAppInfo.jdField_a_of_type_JavaLangString, paramAppInfo.b, paramAppInfo.c, paramAppInfo.d, ArkAppCenterUtil.a(), paramAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localArkAppContainer.setFixSize(i, j);
    localArkAppContainer.setMaxSize(i, j);
    localArkAppContainer.setMinSize(i, j);
    localArkAppContainer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback);
    return localArkAppContainer;
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
    else
    {
      paramString = new JSONObject();
      paramString.put("forward", 1);
      paramString.put("autosize", 1);
      paramString.put("type", "card");
    }
    return paramString.toString();
  }
  
  private static String a(String paramString, Map<String, String> paramMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("forward", 1);
      localJSONObject.put("autosize", 1);
      if ((paramMap != null) && ("normal".equals(paramMap.get("type")))) {
        localJSONObject.put("type", "normal");
      } else {
        localJSONObject.put("type", "card");
      }
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        paramMap = paramString.keys();
        while (paramMap.hasNext())
        {
          String str = (String)paramMap.next();
          localJSONObject.put(str, paramString.getString(str));
        }
      }
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      paramString1 = QQCustomArkDialog.AppInfo.a(paramString1, paramString2, "0.0.0.1", paramString3, ArkAppCenterUtil.a(), null, null);
      paramString1.putInt("sourceType", 0);
      paramString2 = new Intent(paramActivity, ArkFullScreenAppActivity.class);
      paramString2.putExtras(paramString1);
      paramString2.putExtra("card_height", MessageForArkApp.dp2px(297.0F));
      paramString2.putExtra("show_as_card", true);
      paramActivity.startActivity(paramString2);
      paramActivity.overridePendingTransition(2130772011, 2130772015);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, String paramString5, int paramInt)
  {
    paramString1 = QQCustomArkDialog.AppInfo.a(paramString1, paramString2, paramString3, paramString4, ArkAppCenterUtil.a(), paramString5, null);
    paramString1.putInt("sourceType", paramInt);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("startFullScreenApp:");
      paramString2.append(paramString1);
      QLog.d("ArkFullScreenAppActivity", 2, paramString2.toString());
    }
    paramString2 = new Intent(paramContext, ArkFullScreenAppActivity.class);
    paramString2.putExtras(paramString1);
    paramContext.startActivity(paramString2);
  }
  
  private void a(Bundle paramBundle)
  {
    QQCustomArkDialog.AppInfo localAppInfo = new QQCustomArkDialog.AppInfo(paramBundle);
    this.jdField_a_of_type_Int = paramBundle.getInt("sourceType", 0);
    paramBundle = a(localAppInfo);
    this.jdField_a_of_type_JavaUtilStack.push(localAppInfo);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo = localAppInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.initArkView(paramBundle, false);
    setTitle(localAppInfo.e);
    if (1 == this.jdField_a_of_type_Int) {
      ArkAppDataReport.a(this.app, localAppInfo.jdField_a_of_type_JavaLangString, "ArkFullEnterFromAppManage", 1, 0, 0L, 0L, 0L, null, null);
    }
    if (this.jdField_a_of_type_JavaUtilStack.size() > 1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("init: ");
      paramBundle.append(localAppInfo.jdField_a_of_type_JavaLangString);
      paramBundle.append(", ");
      paramBundle.append(this.jdField_a_of_type_JavaUtilStack.size());
      QLog.i("ArkFullScreenAppActivity", 2, paramBundle.toString());
    }
  }
  
  public static boolean a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("forward_ark_app_name");
    String str2 = paramBundle.getString("forward_ark_app_view");
    String str3 = paramBundle.getString("forward_ark_app_ver");
    String str4 = paramBundle.getString("forward_ark_app_meta");
    paramBundle = paramBundle.getString("forward_ark_app_config");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("richMsgBody displayArk appName =");
      localStringBuilder.append(str1);
      localStringBuilder.append(", appView =");
      localStringBuilder.append(str2);
      localStringBuilder.append(", appMeta =");
      localStringBuilder.append(str4);
      localStringBuilder.append(", config =");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(", appVer");
      localStringBuilder.append(str3);
      QLog.e("ArkFullScreenAppActivity", 2, localStringBuilder.toString());
    }
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str4));
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilStack.iterator();
    while (localIterator.hasNext())
    {
      ArkAppContainer localArkAppContainer = ((QQCustomArkDialog.AppInfo)localIterator.next()).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
      if (localArkAppContainer != null) {
        localArkAppContainer.doOnEvent(2);
      }
    }
    this.jdField_a_of_type_JavaUtilStack.clear();
  }
  
  public Intent a(ArkAppContainer paramArkAppContainer)
  {
    try
    {
      localObject1 = paramArkAppContainer.getViewShare();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
      Object localObject3 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes()));
      localObject1 = ((Document)localObject3).getElementsByTagName("View").item(0);
      if ((localObject1 != null) && (((Node)localObject1).getChildNodes().getLength() > 0))
      {
        if (!(((Node)localObject1).getFirstChild() instanceof Text)) {
          return null;
        }
        String str = ((Node)localObject1).getFirstChild().getNodeValue();
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        Node localNode = ((Document)localObject3).getElementsByTagName("Metadata").item(0);
        Object localObject2 = new JSONObject();
        localObject1 = localObject2;
        if (localNode != null)
        {
          localObject1 = localObject2;
          if (localNode.getChildNodes().getLength() > 0)
          {
            localObject1 = localObject2;
            if (!ArkRecommendController.a(localNode.getFirstChild(), (JSONObject)localObject2)) {
              localObject1 = new JSONObject();
            }
          }
        }
        paramArkAppContainer = paramArkAppContainer.getAppName();
        localObject1 = ((JSONObject)localObject1).toString();
        float f = ArkAppCenterUtil.a();
        localObject2 = MessageForArkApp.getConfigFromXml((Document)localObject3);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("ArkFullScreenApp config getShareMsg:");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.i("ArkApp", 2, ((StringBuilder)localObject3).toString());
        }
        paramArkAppContainer = a(this, str, paramArkAppContainer, (String)localObject1, (String)localObject2, f);
        return paramArkAppContainer;
      }
      return null;
    }
    catch (Exception paramArkAppContainer)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getShareMsg send message parameter error: ");
        ((StringBuilder)localObject1).append(paramArkAppContainer.getMessage());
        QLog.i("ArkFullScreenAppActivity", 1, ((StringBuilder)localObject1).toString());
      }
    }
    return null;
  }
  
  void a()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addButton(getString(2131719043), 0);
    localActionSheet.setOnButtonClickListener(new ArkFullScreenAppActivity.8(this, localActionSheet));
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.show();
  }
  
  public void a(ArkAppContainer paramArkAppContainer, String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo;
    if ((localObject != null) && (((QQCustomArkDialog.AppInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer == paramArkAppContainer))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo.e = paramString;
      setTitle(paramString);
      return;
    }
    localObject = this.jdField_a_of_type_JavaUtilStack.iterator();
    while (((Iterator)localObject).hasNext())
    {
      QQCustomArkDialog.AppInfo localAppInfo = (QQCustomArkDialog.AppInfo)((Iterator)localObject).next();
      if ((localAppInfo != null) && (localAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer == paramArkAppContainer)) {
        localAppInfo.e = paramString;
      }
    }
  }
  
  public void a(ArkAppContainer paramArkAppContainer, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilStack.iterator();
    while (localIterator.hasNext())
    {
      QQCustomArkDialog.AppInfo localAppInfo = (QQCustomArkDialog.AppInfo)localIterator.next();
      if ((localAppInfo != null) && (localAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer == paramArkAppContainer))
      {
        localAppInfo.jdField_a_of_type_Boolean = paramBoolean;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo == localAppInfo)
        {
          paramBoolean = localAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.checkShare();
          int j = 0;
          int i;
          if ((paramBoolean) && (localAppInfo.jdField_a_of_type_Boolean)) {
            i = 1;
          } else {
            i = 0;
          }
          paramArkAppContainer = this.rightViewImg;
          if (i != 0) {
            i = j;
          } else {
            i = 4;
          }
          paramArkAppContainer.setVisibility(i);
        }
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 100) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo != null))
    {
      ArkAppDataReport.a(this.app, "FullScreenClickOper", this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo.jdField_a_of_type_JavaLangString, null, ArkAppDataReport.e, 0, 0);
      ArkAppDataReport.a(this.app, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo.jdField_a_of_type_JavaLangString, "FullScreenShareSuccess", 0, 0, 0L, 0L, 0L, "", "");
      if (1 == this.jdField_a_of_type_Int) {
        ArkAppDataReport.a(this.app, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo.jdField_a_of_type_JavaLangString, "ArkFullShareFromAppManage", 1, 0, 0L, 0L, 0L, null, null);
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
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
      this.d = ((Display)localObject).getWidth();
      this.e = ((Display)localObject).getHeight();
    }
    setContentView(2131558640);
    localObject = (FrameLayout)findViewById(16908290);
    if (this.titleRoot != null) {
      this.titleRoot.setBackgroundColor(getResources().getColor(2131165417));
    }
    ((NavBarCommon)this.vg).changeBg(true);
    this.leftView.setText("");
    this.leftView.setMinWidth(MessageForArkApp.dp2px(35.0F));
    localObject = (RelativeLayout)findViewById(2131376636);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840346);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(1, 2131369202);
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ArkFullScreenAppActivity.2(this));
    int i = MessageForArkApp.dp2px(6.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, i, 0);
    this.rightViewImg = ((ImageView)findViewById(2131369216));
    this.rightViewImg.setBackgroundDrawable(null);
    setLayerType(this.rightViewImg);
    this.rightViewImg.setVisibility(4);
    this.rightViewImg.setImageResource(2130840348);
    this.rightViewImg.setContentDescription(HardCodeUtil.a(2131700904));
    this.rightViewImg.setOnClickListener(new ArkFullScreenAppActivity.3(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)findViewById(2131362965));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    ((ArkAppView)localObject).setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new ArkFullScreenAppActivity.4(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.post(new ArkFullScreenAppActivity.5(this, paramBundle));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnCreate:");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("ArkFullScreenAppActivity", 2, ((StringBuilder)localObject).toString());
    }
    findViewById(2131376636);
    ArkAppDataReport.a(this.app, "ShowView", paramBundle.getString("appName"), null, ArkAppDataReport.h, 0, 0);
    ArkViewAdjustFromKeyboard.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkTopGestureLayout = new ArkTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentMobileqqArkArkTopGestureLayout);
    }
    if (ThemeUtil.isInNightMode(this.app))
    {
      paramBundle = (RelativeLayout)findViewById(2131378893);
      LayoutInflater.from(this).inflate(2131560251, paramBundle);
    }
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("show_as_card", false);
    this.b = getIntent().getIntExtra("card_height", 0);
    if ((this.jdField_a_of_type_Boolean) && (this.b > 0))
    {
      findViewById(2131376636).setVisibility(8);
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getLayoutParams();
      paramBundle.addRule(12);
      paramBundle.height = this.b;
      this.titleRoot.setBackgroundResource(0);
      this.titleRoot.setOnClickListener(new ArkFullScreenAppActivity.7(this));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    b();
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("ArkFullScreenAppActivity", 2, "doOnDestroy: ");
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getExtras();
    a(paramIntent);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnNewIntent");
      localStringBuilder.append(paramIntent);
      QLog.d("ArkFullScreenAppActivity", 2, localStringBuilder.toString());
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusBarDrawable(null);
      SystemBarCompact localSystemBarCompact = this.mSystemBarComp;
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = 0;
      } else {
        i = -16777216;
      }
      localSystemBarCompact.setStatusBarColor(i);
    }
  }
  
  public void finish()
  {
    b();
    super.finish();
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo != null) {
      ArkAppDataReport.a(this.app, "FullScreenClickOper", this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo.jdField_a_of_type_JavaLangString, null, ArkAppDataReport.jdField_a_of_type_Int, 0, 0);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBackEvent: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilStack.size());
      QLog.i("ArkFullScreenAppActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_JavaUtilStack.size() <= 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_Boolean)
      {
        finish();
        overridePendingTransition(2130772011, 2130772015);
        return true;
      }
      return super.onBackEvent();
    }
    Object localObject = ((QQCustomArkDialog.AppInfo)this.jdField_a_of_type_JavaUtilStack.pop()).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
    if (localObject != null) {
      ((ArkAppContainer)localObject).doOnEvent(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo = ((QQCustomArkDialog.AppInfo)this.jdField_a_of_type_JavaUtilStack.peek());
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.initArkView(((QQCustomArkDialog.AppInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer);
      setTitle(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo.e);
    }
    if (this.jdField_a_of_type_JavaUtilStack.size() > 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return true;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Display localDisplay = getWindowManager().getDefaultDisplay();
    if (localDisplay == null)
    {
      QLog.d("ArkFullScreenAppActivity", 2, "onConfigurationChanged:get display null");
    }
    else
    {
      int i = localDisplay.getWidth();
      int j = localDisplay.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("ArkFullScreenAppActivity", 2, new Object[] { "onConfigurationChanged:width=", Integer.valueOf(i), ", height=", Integer.valueOf(j), ", mScreenWidth=", Integer.valueOf(this.d), ", mScreenheight=", Integer.valueOf(this.e) });
      }
      int k = this.d;
      if (k != 0)
      {
        int m = this.e;
        if ((m != 0) && ((k != i) || (m != j)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setFixSize(i, j);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setMinSize(i, j);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setMaxSize(i, j);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setViewRect(i, j);
        }
      }
      this.d = i;
      this.e = j;
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity
 * JD-Core Version:    0.7.0.1
 */