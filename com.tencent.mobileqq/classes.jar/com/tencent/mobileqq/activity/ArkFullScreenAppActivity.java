package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkTopGestureLayout;
import com.tencent.mobileqq.ark.ArkViewAdjustFromKeyboard;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
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
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import rpj;
import rpk;
import rpl;
import rpm;
import rpn;
import rpo;
import rpp;

public class ArkFullScreenAppActivity
  extends IphoneTitleBarActivity
{
  private static ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_a_of_type_Int = 0;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ArkAppContainer.ArkAppModuleCallback jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback = new rpj(this);
  ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  protected ArkTopGestureLayout a;
  private QQCustomArkDialog.AppInfo jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo;
  private Stack jdField_a_of_type_JavaUtilStack = new Stack();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramFloat, ArkAppCenter.a(paramString2, "0.0.0.1"));
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, float paramFloat, Map paramMap)
  {
    String str2 = "0.0.0.1";
    label369:
    label382:
    for (;;)
    {
      Object localObject;
      try
      {
        if (TextUtils.isEmpty(paramString2)) {
          return null;
        }
        str1 = null;
        if (paramMap != null)
        {
          if (paramMap.containsKey("desc"))
          {
            str1 = (String)paramMap.get("desc");
            if (!paramMap.containsKey("version")) {
              break label390;
            }
            str2 = (String)paramMap.get("version");
            break label387;
          }
        }
        else
        {
          if (!TextUtils.isEmpty(str1)) {
            break label382;
          }
          str1 = paramString2;
          String str3 = String.format("[应用]%s", new Object[] { str1 });
          localObject = new JSONObject();
          ((JSONObject)localObject).put("forward", 1);
          ((JSONObject)localObject).put("autosize", 1);
          if ((paramMap == null) || (!"normal".equals(paramMap.get("type")))) {
            break label369;
          }
          ((JSONObject)localObject).put("type", "normal");
          localObject = ((JSONObject)localObject).toString();
          paramMap = QQCustomArkDialog.AppInfo.a(paramString2, paramString1, str2, paramString3, paramFloat, null, null);
          paramMap.putBoolean("forward_ark_app_direct", false);
          paramMap.putString("forward_ark_app_name", paramString2);
          paramMap.putString("forward_ark_app_view", paramString1);
          paramMap.putString("forward_ark_app_desc", str1);
          paramMap.putString("forward_ark_app_ver", str2);
          paramMap.putString("forward_ark_app_meta", paramString3);
          paramMap.putString("forward_ark_app_prompt", str3);
          paramMap.putString("forward_ark_app_config", (String)localObject);
          paramString1 = new Intent();
          paramString1.setClass(paramContext, ForwardRecentActivity.class);
          paramString1.putExtra("forward_type", 27);
          paramString1.putExtra("is_ark_display_share", true);
          paramString1.putExtras(paramMap);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("ArkFullScreenAppActivity", 2, "buildForwardIntent: " + paramMap);
          return paramString1;
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ArkFullScreenAppActivity", 1, "buildForwardIntent send message parameter error: " + paramContext.getMessage());
        }
        return null;
      }
      String str1 = "";
      continue;
      ((JSONObject)localObject).put("type", "card");
    }
    return paramString1;
    for (;;)
    {
      label387:
      break;
      label390:
      str2 = "0.0.0.1";
    }
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, float paramFloat)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramFloat, ArkAppCenter.a(paramString2, "0.0.0.1"));
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, float paramFloat, Map paramMap)
  {
    Object localObject = "0.0.0.1";
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2)) {
          return null;
        }
        str1 = null;
        if (paramMap != null)
        {
          if (paramMap.containsKey("desc"))
          {
            str1 = (String)paramMap.get("desc");
            if (!paramMap.containsKey("version")) {
              break label319;
            }
            paramMap = (String)paramMap.get("version");
            break label335;
          }
        }
        else
        {
          if (!TextUtils.isEmpty(str1)) {
            break label326;
          }
          paramMap = paramString2;
          str1 = String.format("[应用]%s", new Object[] { paramMap });
          String str2 = a(paramString4);
          paramString4 = QQCustomArkDialog.AppInfo.a(paramString2, paramString1, (String)localObject, paramString3, paramFloat, null, null);
          paramString4.putBoolean("forward_ark_app_direct", false);
          paramString4.putString("forward_ark_app_name", paramString2);
          paramString4.putString("forward_ark_app_view", paramString1);
          paramString4.putString("forward_ark_app_desc", paramMap);
          paramString4.putString("forward_ark_app_ver", (String)localObject);
          paramString4.putString("forward_ark_app_meta", paramString3);
          paramString4.putString("forward_ark_app_prompt", str1);
          paramString4.putString("forward_ark_app_config", str2);
          paramString4.putBoolean("forward_ark_from_sdk", true);
          paramString4.putString("forward_appId_ark_from_sdk", paramString5);
          paramString1 = new Intent();
          paramString1.setClass(paramContext, ForwardRecentActivity.class);
          paramString1.putExtra("forward_type", 11);
          paramString1.putExtras(paramString4);
          if (!QLog.isColorLevel()) {
            break label333;
          }
          QLog.i("ArkFullScreenAppActivity", 2, "buildForwardIntent: " + paramString4);
          return paramString1;
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ArkFullScreenAppActivity", 1, "buildForwardIntent send message parameter error: " + paramContext.getMessage());
        }
        return null;
      }
      String str1 = "";
      continue;
      label319:
      paramMap = "0.0.0.1";
      break label335;
      label326:
      paramMap = str1;
      continue;
      label333:
      return paramString1;
      label335:
      localObject = paramMap;
    }
  }
  
  private ArkAppContainer a(QQCustomArkDialog.AppInfo paramAppInfo)
  {
    ArkAppContainer localArkAppContainer = new ArkAppContainer();
    paramAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = localArkAppContainer;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight();
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "create App: w=" + i + ",h=" + j);
    }
    localArkAppContainer.a(paramAppInfo.jdField_a_of_type_JavaLangString, paramAppInfo.b, paramAppInfo.c, paramAppInfo.d, paramAppInfo.jdField_a_of_type_Float, paramAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
    for (;;)
    {
      return paramString.toString();
      paramString = new JSONObject();
      paramString.put("forward", 1);
      paramString.put("autosize", 1);
      paramString.put("type", "card");
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    paramString1 = QQCustomArkDialog.AppInfo.a(paramString1, paramString2, "0.0.0.1", paramString3, paramActivity.getResources().getDisplayMetrics().scaledDensity, null, null);
    paramString1.putInt("sourceType", 0);
    paramString2 = new Intent(paramActivity, ArkFullScreenAppActivity.class);
    paramString2.putExtras(paramString1);
    paramString2.putExtra("card_height", AIOUtils.a(297.0F, paramActivity.getResources()));
    paramString2.putExtra("show_as_card", true);
    paramActivity.startActivity(paramString2);
    paramActivity.overridePendingTransition(2131034134, 2131034135);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, String paramString5, int paramInt)
  {
    paramString1 = QQCustomArkDialog.AppInfo.a(paramString1, paramString2, paramString3, paramString4, paramFloat, paramString5, null);
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
    QQCustomArkDialog.AppInfo localAppInfo = new QQCustomArkDialog.AppInfo(paramBundle);
    this.jdField_a_of_type_Int = paramBundle.getInt("sourceType", 0);
    paramBundle = a(localAppInfo);
    this.jdField_a_of_type_JavaUtilStack.push(localAppInfo);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo = localAppInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.initArkView(paramBundle);
    if (localAppInfo != null)
    {
      setTitle(localAppInfo.e);
      if (1 == this.jdField_a_of_type_Int) {
        ArkAppDataReport.a(this.app, localAppInfo.jdField_a_of_type_JavaLangString, "ArkFullEnterFromAppManage", 1, 0, 0L, 0L, 0L, null, null);
      }
    }
    if (this.jdField_a_of_type_JavaUtilStack.size() > 1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkFullScreenAppActivity", 2, "init: " + localAppInfo.jdField_a_of_type_JavaLangString + ", " + this.jdField_a_of_type_JavaUtilStack.size());
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
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
      Object localObject1 = paramArkAppContainer.getViewShare();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
      localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes()));
      Object localObject2 = ((Document)localObject1).getElementsByTagName("View").item(0);
      if ((localObject2 != null) && (((Node)localObject2).getChildNodes().getLength() > 0) && ((((Node)localObject2).getFirstChild() instanceof Text)))
      {
        String str = ((Node)localObject2).getFirstChild().getNodeValue();
        if (!TextUtils.isEmpty(str))
        {
          Node localNode = ((Document)localObject1).getElementsByTagName("Metadata").item(0);
          localObject2 = new JSONObject();
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
          paramArkAppContainer = a(this, str, paramArkAppContainer.getAppName(), ((JSONObject)localObject1).toString(), getResources().getDisplayMetrics().scaledDensity);
          return paramArkAppContainer;
        }
      }
    }
    catch (Exception paramArkAppContainer)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkFullScreenAppActivity", 1, "getShareMsg send message parameter error: " + paramArkAppContainer.getMessage());
      }
    }
    return null;
  }
  
  public void a()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131438265), 0);
    localActionSheet.a(new rpp(this, localActionSheet));
    localActionSheet.c(2131433029);
    localActionSheet.show();
  }
  
  public void a(ArkAppContainer paramArkAppContainer, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer == paramArkAppContainer))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo.e = paramString;
      setTitle(paramString);
    }
    QQCustomArkDialog.AppInfo localAppInfo;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.jdField_a_of_type_JavaUtilStack.iterator();
      }
      localAppInfo = (QQCustomArkDialog.AppInfo)localIterator.next();
    } while ((localAppInfo == null) || (localAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer != paramArkAppContainer));
    localAppInfo.e = paramString;
  }
  
  public void a(ArkAppContainer paramArkAppContainer, boolean paramBoolean)
  {
    int j = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilStack.iterator();
    while (localIterator.hasNext())
    {
      QQCustomArkDialog.AppInfo localAppInfo = (QQCustomArkDialog.AppInfo)localIterator.next();
      if ((localAppInfo != null) && (localAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer == paramArkAppContainer))
      {
        localAppInfo.jdField_a_of_type_Boolean = paramBoolean;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo == localAppInfo)
        {
          if ((!localAppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.checkShare()) || (!localAppInfo.jdField_a_of_type_Boolean)) {
            break label102;
          }
          i = 1;
          paramArkAppContainer = this.rightViewImg;
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
      paramArkAppContainer.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 100) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo != null))
    {
      ArkAppDataReport.c(this.app, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo.jdField_a_of_type_JavaLangString, ArkAppDataReport.e);
      ArkAppDataReport.m(this.app, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo.jdField_a_of_type_JavaLangString);
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
    setContentView(2130968707);
    Object localObject = (FrameLayout)findViewById(16908290);
    if (this.titleRoot != null) {
      this.titleRoot.setBackgroundColor(getResources().getColor(2131493862));
    }
    ((NavBarCommon)this.vg).a(true);
    this.leftView.setText("");
    this.leftView.setMinWidth(AIOUtils.a(35.0F, getResources()));
    localObject = (RelativeLayout)findViewById(2131363261);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839161);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(1, 2131363262);
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new rpk(this));
    int i = AIOUtils.a(6.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, i, 0);
    this.rightViewImg = ((ImageView)findViewById(2131363493));
    this.rightViewImg.setBackgroundDrawable(null);
    setLayerType(this.rightViewImg);
    this.rightViewImg.setVisibility(4);
    this.rightViewImg.setImageResource(2130839163);
    this.rightViewImg.setContentDescription("分享");
    this.rightViewImg.setOnClickListener(new rpl(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)findViewById(2131363326));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new rpm(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.post(new rpn(this, paramBundle));
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "doOnCreate:" + paramBundle);
    }
    findViewById(2131363261);
    ArkAppDataReport.d(this.app, paramBundle.getString("appName"), ArkAppDataReport.h, 0);
    ArkViewAdjustFromKeyboard.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkTopGestureLayout = new ArkTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentMobileqqArkArkTopGestureLayout);
    }
    if (ThemeUtil.isInNightMode(this.app))
    {
      paramBundle = (RelativeLayout)findViewById(2131364044);
      LayoutInflater.from(this).inflate(2130969637, paramBundle);
    }
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("show_as_card", false);
    this.b = getIntent().getIntExtra("card_height", 0);
    if ((this.jdField_a_of_type_Boolean) && (this.b > 0))
    {
      findViewById(2131363261).setVisibility(8);
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getLayoutParams();
      paramBundle.addRule(12);
      paramBundle.height = this.b;
      this.titleRoot.setBackgroundResource(0);
      this.titleRoot.setOnClickListener(new rpo(this));
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
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "doOnNewIntent" + paramIntent);
    }
  }
  
  protected void doOnResume()
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
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo != null) {
      ArkAppDataReport.c(this.app, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo.jdField_a_of_type_JavaLangString, ArkAppDataReport.jdField_a_of_type_Int);
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
        overridePendingTransition(2131034134, 2131034135);
        return true;
      }
      return super.onBackEvent();
    }
    ArkAppContainer localArkAppContainer = ((QQCustomArkDialog.AppInfo)this.jdField_a_of_type_JavaUtilStack.pop()).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
    if (localArkAppContainer != null) {
      localArkAppContainer.doOnEvent(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo = ((QQCustomArkDialog.AppInfo)this.jdField_a_of_type_JavaUtilStack.peek());
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.initArkView(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer);
      setTitle(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomArkDialog$AppInfo.e);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity
 * JD-Core Version:    0.7.0.1
 */