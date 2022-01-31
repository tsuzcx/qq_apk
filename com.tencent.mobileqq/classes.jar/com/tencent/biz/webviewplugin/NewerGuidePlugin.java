package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Window;
import anql;
import anqp;
import anvl;
import atbg;
import bamn;
import bazo;
import bbdr;
import bcdb;
import bcpq;
import bfol;
import bfoy;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
import xks;
import xkt;
import xku;
import xkv;
import xkw;
import xkx;
import xky;
import xkz;
import xla;
import xlb;

public class NewerGuidePlugin
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new xkt(this);
  private Uri jdField_a_of_type_AndroidNetUri;
  private anql jdField_a_of_type_Anql = new xks(this);
  private bcpq jdField_a_of_type_Bcpq;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public NewerGuidePlugin()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "NewerGuidePlugin this=" + this);
    }
    this.mPluginNameSpace = "newerguide";
  }
  
  public static JSONObject a(String paramString)
  {
    paramString = atbg.a("upload_for_new_guide", paramString, 4).getString("upload_for_new_guide", "");
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuidePlugin", 2, "registerAvatarReceiver");
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT");
      this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    int j;
    int i;
    if ((paramInt1 >= 1897) && (paramInt2 >= 1) && (paramInt2 <= 12) && (paramInt3 >= 1))
    {
      k = paramInt1;
      j = paramInt2;
      i = paramInt3;
      if (paramInt3 <= 31) {}
    }
    else
    {
      QLog.d("NewerGuidePlugin", 1, String.format("showDatePicker invalid params year=%s month=%s day=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      k = 1900;
      i = 1;
      j = 1;
    }
    Object localObject1 = this.mRuntime.a();
    IphonePickerView localIphonePickerView = (IphonePickerView)((Activity)localObject1).getLayoutInflater().inflate(2131560805, null);
    localIphonePickerView.a(new xlb(this, -1));
    localObject1 = bfol.c((Context)localObject1);
    ((bfol)localObject1).d(true);
    ((bfol)localObject1).a(localIphonePickerView, null);
    Object localObject2 = (DispatchActionMoveScrollView)((bfol)localObject1).findViewById(2131361923);
    ((DispatchActionMoveScrollView)localObject2).jdField_a_of_type_Boolean = true;
    ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject2 = ((bfol)localObject1).getWindow();
      if (localObject2 != null) {
        ((Window)localObject2).setFlags(16777216, 16777216);
      }
    }
    localIphonePickerView.setPickListener(new xky(this, localIphonePickerView, (bfol)localObject1));
    this.b = (k - 1897);
    this.c = (j - 1);
    this.d = (i - 1);
    localIphonePickerView.setSelection(0, this.b);
    localIphonePickerView.setSelection(1, this.c);
    localIphonePickerView.setSelection(2, this.d);
    try
    {
      ((bfol)localObject1).show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i = Integer.parseInt(paramJSONObject.getString("type"));
    try
    {
      String str = paramJSONObject.getString("uin");
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuidePlugin", 2, String.format("handleJumpCard type=%s uin=%s", new Object[] { Integer.valueOf(i), str }));
      }
      if ((i != 5) && (TextUtils.isEmpty(str))) {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localObject = null;
        }
        switch (i)
        {
        default: 
          return;
        case 1: 
          paramJSONObject = QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "getPhoneBindState", null);
        }
      } while (!paramJSONObject.isSuccess());
      int j = paramJSONObject.data.getInt("selfBindState");
      i = 34;
      if (j <= 5) {
        i = 29;
      }
      paramJSONObject = new ProfileActivity.AllInOne((String)localObject, i);
      paramJSONObject.jdField_h_of_type_Int = 100;
      localObject = new Intent(this.mRuntime.a(), FriendProfileCardActivity.class);
      ((Intent)localObject).putExtra("AllInOne", paramJSONObject);
      ((Intent)localObject).putExtra("from_newer_guide", true);
      startActivityForResult((Intent)localObject, (byte)1);
      return;
      paramJSONObject = new Intent(this.mRuntime.a(), AccountDetailActivity.class);
      paramJSONObject.putExtra("uin", (String)localObject);
      paramJSONObject.putExtra("from_newer_guide", true);
      this.mRuntime.a().overridePendingTransition(2130771992, 2130771993);
      startActivityForResult(paramJSONObject, (byte)i);
      return;
      localObject = TroopInfoActivity.a(String.valueOf(localObject), 35);
      ((Bundle)localObject).putString("authSig", paramJSONObject.optString("authSig"));
      ((Bundle)localObject).putBoolean("from_newer_guide", true);
      bamn.a(this.mRuntime.a(), (Bundle)localObject, 2, 3);
      return;
      long l = Long.parseLong((String)localObject);
      paramJSONObject = new ProfileActivity.AllInOne("0", 41);
      paramJSONObject.jdField_h_of_type_Int = 100;
      localObject = new Intent(this.mRuntime.a(), NearbyPeopleProfileActivity.class);
      ((Intent)localObject).putExtra("param_mode", 3);
      ((Intent)localObject).putExtra("AllInOne", paramJSONObject);
      ((Intent)localObject).putExtra("param_tiny_id", l);
      ((Intent)localObject).putExtra("from_newer_guide", true);
      startActivityForResult((Intent)localObject, (byte)i);
      return;
    }
    paramJSONObject = new ProfileActivity.AllInOne(this.mRuntime.a().getCurrentAccountUin(), 0);
    paramJSONObject.jdField_h_of_type_JavaLangString = this.mRuntime.a().getCurrentNickname();
    paramJSONObject.jdField_h_of_type_Int = 100;
    Object localObject = new Intent(this.mRuntime.a(), FriendProfileCardActivity.class);
    ((Intent)localObject).putExtra("AllInOne", paramJSONObject);
    ((Intent)localObject).putExtra("from_newer_guide", true);
    this.mRuntime.a().startActivity((Intent)localObject);
  }
  
  /* Error */
  private void a(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +30 -> 42
    //   15: ldc 38
    //   17: iconst_2
    //   18: ldc_w 400
    //   21: iconst_2
    //   22: anewarray 136	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: iload_1
    //   28: invokestatic 405	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: aload_2
    //   35: aastore
    //   36: invokestatic 148	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   39: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: new 96	org/json/JSONObject
    //   45: dup
    //   46: invokespecial 406	org/json/JSONObject:<init>	()V
    //   49: astore 7
    //   51: iload_1
    //   52: ifeq +149 -> 201
    //   55: iconst_1
    //   56: istore_3
    //   57: aload 7
    //   59: ldc_w 408
    //   62: iload_3
    //   63: invokevirtual 412	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   66: pop
    //   67: iload_1
    //   68: ifeq +291 -> 359
    //   71: aload_2
    //   72: invokestatic 259	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifne +284 -> 359
    //   78: new 414	java/io/File
    //   81: dup
    //   82: aload_2
    //   83: invokespecial 415	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: astore 8
    //   88: aload 8
    //   90: invokevirtual 418	java/io/File:exists	()Z
    //   93: ifeq +266 -> 359
    //   96: aload 8
    //   98: invokevirtual 422	java/io/File:length	()J
    //   101: l2i
    //   102: newarray byte
    //   104: astore 6
    //   106: new 424	java/io/FileInputStream
    //   109: dup
    //   110: aload 8
    //   112: invokespecial 427	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   115: astore_2
    //   116: new 429	java/io/BufferedInputStream
    //   119: dup
    //   120: aload_2
    //   121: invokespecial 432	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   124: astore 4
    //   126: aload 4
    //   128: aload 6
    //   130: invokevirtual 436	java/io/BufferedInputStream:read	([B)I
    //   133: ifle +18 -> 151
    //   136: aload 7
    //   138: ldc_w 438
    //   141: aload 6
    //   143: iconst_0
    //   144: invokestatic 444	bbca:encodeToString	([BI)Ljava/lang/String;
    //   147: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload 8
    //   153: invokevirtual 450	java/io/File:delete	()Z
    //   156: pop
    //   157: aload_2
    //   158: astore 5
    //   160: aload 4
    //   162: astore_2
    //   163: aload 5
    //   165: ifnull +8 -> 173
    //   168: aload 5
    //   170: invokevirtual 453	java/io/FileInputStream:close	()V
    //   173: aload_2
    //   174: ifnull +7 -> 181
    //   177: aload_2
    //   178: invokevirtual 454	java/io/BufferedInputStream:close	()V
    //   181: aload_0
    //   182: ldc_w 456
    //   185: iconst_1
    //   186: anewarray 144	java/lang/String
    //   189: dup
    //   190: iconst_0
    //   191: aload 7
    //   193: invokevirtual 457	org/json/JSONObject:toString	()Ljava/lang/String;
    //   196: aastore
    //   197: invokevirtual 461	com/tencent/biz/webviewplugin/NewerGuidePlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   200: return
    //   201: iconst_0
    //   202: istore_3
    //   203: goto -146 -> 57
    //   206: astore 5
    //   208: aconst_null
    //   209: astore_2
    //   210: ldc 38
    //   212: iconst_1
    //   213: ldc_w 463
    //   216: aload 5
    //   218: invokestatic 467	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: aload 4
    //   223: ifnull +8 -> 231
    //   226: aload 4
    //   228: invokevirtual 453	java/io/FileInputStream:close	()V
    //   231: aload_2
    //   232: ifnull -51 -> 181
    //   235: aload_2
    //   236: invokevirtual 454	java/io/BufferedInputStream:close	()V
    //   239: goto -58 -> 181
    //   242: astore_2
    //   243: goto -62 -> 181
    //   246: astore 4
    //   248: aconst_null
    //   249: astore_2
    //   250: aload_2
    //   251: ifnull +7 -> 258
    //   254: aload_2
    //   255: invokevirtual 453	java/io/FileInputStream:close	()V
    //   258: aload 5
    //   260: ifnull +8 -> 268
    //   263: aload 5
    //   265: invokevirtual 454	java/io/BufferedInputStream:close	()V
    //   268: aload 4
    //   270: athrow
    //   271: astore 4
    //   273: goto -100 -> 173
    //   276: astore_2
    //   277: goto -96 -> 181
    //   280: astore 4
    //   282: goto -51 -> 231
    //   285: astore_2
    //   286: goto -28 -> 258
    //   289: astore_2
    //   290: goto -22 -> 268
    //   293: astore 4
    //   295: goto -45 -> 250
    //   298: astore 6
    //   300: aload 4
    //   302: astore 5
    //   304: aload 6
    //   306: astore 4
    //   308: goto -58 -> 250
    //   311: astore 5
    //   313: aload 4
    //   315: astore 6
    //   317: aload 5
    //   319: astore 4
    //   321: aload_2
    //   322: astore 5
    //   324: aload 6
    //   326: astore_2
    //   327: goto -77 -> 250
    //   330: astore 5
    //   332: aconst_null
    //   333: astore 6
    //   335: aload_2
    //   336: astore 4
    //   338: aload 6
    //   340: astore_2
    //   341: goto -131 -> 210
    //   344: astore 5
    //   346: aload_2
    //   347: astore 6
    //   349: aload 4
    //   351: astore_2
    //   352: aload 6
    //   354: astore 4
    //   356: goto -146 -> 210
    //   359: aconst_null
    //   360: astore 5
    //   362: aload 6
    //   364: astore_2
    //   365: goto -202 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	NewerGuidePlugin
    //   0	368	1	paramBoolean	boolean
    //   0	368	2	paramString	String
    //   56	147	3	i	int
    //   1	226	4	localBufferedInputStream	java.io.BufferedInputStream
    //   246	23	4	localObject1	Object
    //   271	1	4	localException1	Exception
    //   280	1	4	localException2	Exception
    //   293	8	4	localObject2	Object
    //   306	49	4	localObject3	Object
    //   4	165	5	str1	String
    //   206	58	5	localException3	Exception
    //   302	1	5	localObject4	Object
    //   311	7	5	localObject5	Object
    //   322	1	5	str2	String
    //   330	1	5	localException4	Exception
    //   344	1	5	localException5	Exception
    //   360	1	5	localObject6	Object
    //   7	135	6	arrayOfByte	byte[]
    //   298	7	6	localObject7	Object
    //   315	48	6	localObject8	Object
    //   49	143	7	localJSONObject	JSONObject
    //   86	66	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   57	67	206	java/lang/Exception
    //   71	116	206	java/lang/Exception
    //   235	239	242	java/lang/Exception
    //   57	67	246	finally
    //   71	116	246	finally
    //   168	173	271	java/lang/Exception
    //   177	181	276	java/lang/Exception
    //   226	231	280	java/lang/Exception
    //   254	258	285	java/lang/Exception
    //   263	268	289	java/lang/Exception
    //   116	126	293	finally
    //   126	151	298	finally
    //   151	157	298	finally
    //   210	221	311	finally
    //   116	126	330	java/lang/Exception
    //   126	151	344	java/lang/Exception
    //   151	157	344	java/lang/Exception
  }
  
  private void a(String[] paramArrayOfString, int paramInt)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      QLog.d("NewerGuidePlugin", 1, "showSelector invalid params");
      return;
    }
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < paramArrayOfString.length) {}
    }
    else
    {
      i = 0;
    }
    Object localObject = this.mRuntime.a();
    IphonePickerView localIphonePickerView = (IphonePickerView)((Activity)localObject).getLayoutInflater().inflate(2131560805, null);
    localIphonePickerView.a(new xkw(this, paramArrayOfString));
    paramArrayOfString = bfol.c((Context)localObject);
    paramArrayOfString.d(true);
    paramArrayOfString.a(localIphonePickerView, null);
    localObject = (DispatchActionMoveScrollView)paramArrayOfString.findViewById(2131361923);
    ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = paramArrayOfString.getWindow();
      if (localObject != null) {
        ((Window)localObject).setFlags(16777216, 16777216);
      }
    }
    localIphonePickerView.setPickListener(new xkx(this, paramArrayOfString));
    this.jdField_a_of_type_Int = i;
    localIphonePickerView.setSelection(0, i);
    try
    {
      paramArrayOfString.show();
      return;
    }
    catch (Exception paramArrayOfString) {}
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "unregisterAvatarReceiver");
    }
    this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "handleUploadContacts");
    }
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && ((localActivity instanceof BaseActivity)))
    {
      if (((BaseActivity)localActivity).checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
        c(paramJSONObject);
      }
    }
    else {
      return;
    }
    ((BaseActivity)localActivity).requestPermissions(new xkz(this, paramJSONObject, localActivity), 1, new String[] { "android.permission.READ_CONTACTS" });
  }
  
  private void c()
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mRuntime.a();
    if (localBaseActivity != null)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label94;
      }
      int i = localBaseActivity.checkSelfPermission("android.permission.CAMERA");
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuidePlugin", 2, String.format("handleSetAvatar permission=%s", new Object[] { Integer.valueOf(i) }));
      }
      if (i == 0) {
        d();
      }
    }
    else
    {
      return;
    }
    localBaseActivity.requestPermissions(new xku(this, localBaseActivity), 1, new String[] { "android.permission.CAMERA" });
    return;
    label94:
    d();
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("uploadContacts args=%s", new Object[] { paramJSONObject }));
    }
    paramJSONObject = new Bundle();
    paramJSONObject.putString("key_action", "uploadContacts");
    paramJSONObject = anqp.a("ipc_newer_guide", null, this.jdField_a_of_type_Anql.key, paramJSONObject);
    anvl.a().a(paramJSONObject);
  }
  
  private void d()
  {
    Activity localActivity = this.mRuntime.a();
    String[] arrayOfString = localActivity.getResources().getStringArray(2130968634);
    bfol localbfol = (bfol)bfoy.a(localActivity, null);
    localbfol.c(arrayOfString[22]);
    localbfol.c(arrayOfString[24]);
    localbfol.c(arrayOfString[13]);
    localbfol.d(arrayOfString[16]);
    localbfol.a(new xkv(this, localActivity, localbfol));
    if (!localActivity.isFinishing()) {}
    try
    {
      localbfol.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void d(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "handleGetRecommended");
    }
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && ((localActivity instanceof BaseActivity))) {
      if (Build.VERSION.SDK_INT < 23) {
        break label92;
      }
    }
    label92:
    for (int i = ((BaseActivity)localActivity).checkSelfPermission("android.permission.READ_CONTACTS");; i = 0)
    {
      if (i == 0)
      {
        e(paramJSONObject);
        return;
      }
      ((BaseActivity)localActivity).requestPermissions(new xla(this, paramJSONObject, localActivity), 1, new String[] { "android.permission.READ_CONTACTS" });
      return;
    }
  }
  
  private void e(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("getRecommended args=%s", new Object[] { paramJSONObject }));
    }
    int i = Integer.parseInt(paramJSONObject.getString("wantCount"));
    paramJSONObject = new Bundle();
    paramJSONObject.putString("key_action", "getRecommendedList");
    paramJSONObject.putInt("wantCount", i);
    paramJSONObject = anqp.a("ipc_newer_guide", null, this.jdField_a_of_type_Anql.key, paramJSONObject);
    anvl.a().a(paramJSONObject);
  }
  
  private void f(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("getRecommendedNew args=%s", new Object[] { paramJSONObject }));
    }
    long l = Long.parseLong(paramJSONObject.getString("uin"));
    int i = Integer.parseInt(paramJSONObject.getString("startIndex"));
    int j = Integer.parseInt(paramJSONObject.getString("num"));
    paramJSONObject = paramJSONObject.getString("callback");
    Bundle localBundle = new Bundle();
    localBundle.putString("key_action", "getRecommendedListNew");
    localBundle.putLong("uin", l);
    localBundle.putInt("startIndex", i);
    localBundle.putInt("num", j);
    localBundle.putString("callback", paramJSONObject);
    paramJSONObject = anqp.a("ipc_newer_guide", null, this.jdField_a_of_type_Anql.key, localBundle);
    anvl.a().a(paramJSONObject);
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("callJs func=%s", new Object[] { paramString }));
    }
    super.callJs(paramString, paramVarArgs);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("handleJsRequest pkgName=%s method=%s url=%s args=%s", new Object[] { paramString2, paramString3, paramString1, Arrays.toString(paramVarArgs) }));
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ("newerguide".equals(paramString2))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString3))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString1))
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            if (paramString3.equals("uploadContacts")) {
              b(paramJsBridgeListener);
            } else if (paramString3.equals("getRecommendedList")) {
              d(paramJsBridgeListener);
            }
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.e("NewerGuidePlugin", 1, "handleJsRequest fail", paramJsBridgeListener);
          }
          if (paramString3.equals("getRecommendedListNew"))
          {
            f(paramJsBridgeListener);
          }
          else
          {
            int j;
            int i;
            if (paramString3.equals("skipGuide"))
            {
              j = 0;
              paramJsBridgeListener = QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "getPhoneBindState", null);
              i = j;
              if (paramJsBridgeListener.isSuccess())
              {
                i = j;
                if (paramJsBridgeListener.data.getInt("selfBindState") <= 5)
                {
                  paramJsBridgeListener = this.mRuntime.a();
                  paramString1 = new Intent(paramJsBridgeListener, BindNumberActivity.class);
                  paramString1.putExtra("kSrouce", 10);
                  paramJsBridgeListener.startActivity(paramString1);
                  i = 1;
                }
              }
              if (i == 0)
              {
                paramJsBridgeListener = new Intent(this.mRuntime.a(), SplashActivity.class);
                paramJsBridgeListener.putExtra("main_tab_id", 1);
                paramJsBridgeListener.setFlags(603979776);
                this.mRuntime.a().startActivity(paramJsBridgeListener);
              }
            }
            else if (paramString3.equals("addFriend"))
            {
              paramString1 = QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "getPhoneBindState", null);
              if (paramString1.isSuccess())
              {
                i = 3006;
                j = 11;
                if (paramString1.data.getInt("selfBindState") <= 5)
                {
                  i = 3075;
                  j = 3;
                }
                paramString1 = paramJsBridgeListener.getString("uin");
                paramJsBridgeListener = paramJsBridgeListener.getString("name");
                paramJsBridgeListener = AddFriendLogicActivity.a(this.mRuntime.a(), 2, paramString1, null, i, j, paramJsBridgeListener, null, null, null, null);
                paramJsBridgeListener.putExtra("from_newer_guide", true);
                startActivityForResult(paramJsBridgeListener, (byte)7);
              }
            }
            else if (paramString3.equals("followPublicAccount"))
            {
              paramJsBridgeListener = paramJsBridgeListener.getString("uin");
              paramString1 = new Bundle();
              paramString1.putString("key_action", "followPublicAccount");
              paramString1.putString("uin", paramJsBridgeListener);
              paramJsBridgeListener = anqp.a("ipc_newer_guide", null, this.jdField_a_of_type_Anql.key, paramString1);
              anvl.a().a(paramJsBridgeListener);
            }
            else if (paramString3.equals("joinTroop"))
            {
              paramString1 = paramJsBridgeListener.getString("uin");
              paramString2 = paramJsBridgeListener.getString("name");
              paramJsBridgeListener = paramJsBridgeListener.optString("authSig");
              paramString3 = new Bundle();
              paramString3.putString("key_action", "joinTroop");
              paramString3.putString("uin", paramString1);
              paramString3.putString("name", paramString2);
              paramString3.putString("authSig", paramJsBridgeListener);
              paramJsBridgeListener = anqp.a("ipc_newer_guide", null, this.jdField_a_of_type_Anql.key, paramString3);
              anvl.a().a(paramJsBridgeListener);
            }
            else if (paramString3.equals("joinTroopByTap"))
            {
              paramString1 = paramJsBridgeListener.getString("uin");
              paramString2 = paramJsBridgeListener.getString("name");
              paramJsBridgeListener = paramJsBridgeListener.optString("authSig");
              paramString3 = new Bundle();
              paramString3.putString("key_action", "joinTroopByTap");
              paramString3.putString("uin", paramString1);
              paramString3.putString("name", paramString2);
              paramString3.putString("authSig", paramJsBridgeListener);
              paramJsBridgeListener = anqp.a("ipc_newer_guide", null, this.jdField_a_of_type_Anql.key, paramString3);
              anvl.a().a(paramJsBridgeListener);
            }
            else if (paramString3.equals("sayHi"))
            {
              long l = Long.parseLong(paramJsBridgeListener.getString("uin"));
              paramJsBridgeListener = new Bundle();
              paramJsBridgeListener.putString("key_action", "sayHi");
              paramJsBridgeListener.putLong("tinyId", l);
              paramJsBridgeListener = anqp.a("ipc_newer_guide", null, this.jdField_a_of_type_Anql.key, paramJsBridgeListener);
              anvl.a().a(paramJsBridgeListener);
            }
            else if (paramString3.equals("jumpCard"))
            {
              a(paramJsBridgeListener);
            }
            else if (paramString3.equals("setAvatar"))
            {
              c();
            }
            else
            {
              int k;
              if (paramString3.equals("selector"))
              {
                paramString1 = null;
                j = paramJsBridgeListener.getInt("index");
                paramString2 = paramJsBridgeListener.getJSONArray("options");
                paramJsBridgeListener = paramString1;
                if (paramString2 != null)
                {
                  paramJsBridgeListener = paramString1;
                  if (paramString2.length() > 0)
                  {
                    k = paramString2.length();
                    paramString1 = new String[k];
                    i = 0;
                    for (;;)
                    {
                      paramJsBridgeListener = paramString1;
                      if (i >= k) {
                        break;
                      }
                      paramString1[i] = paramString2.getString(i);
                      i += 1;
                    }
                  }
                }
                a(paramJsBridgeListener, j);
              }
              else if (paramString3.equals("datePicker"))
              {
                a(paramJsBridgeListener.getInt("year"), paramJsBridgeListener.getInt("month"), paramJsBridgeListener.getInt("date"));
              }
              else if (paramString3.equals("queryUploadProgress"))
              {
                paramJsBridgeListener = paramJsBridgeListener.getString("callback");
                j = 0;
                i = 0;
                int m = 0;
                k = 0;
                paramString1 = a(this.mRuntime.a().getAccount());
                if (paramString1 != null)
                {
                  j = paramString1.optInt("state");
                  i = paramString1.optInt("total");
                  m = paramString1.optInt("curPer");
                  k = paramString1.optInt("expPer");
                }
                if (QLog.isColorLevel()) {
                  QLog.i("NewerGuidePlugin", 2, String.format("METHOD_QUERY_UPLOAD_PROGRESS [%s, %s, %s, %s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(k) }));
                }
                double d1 = m / 100.0F;
                k = (int)(i * d1);
                paramString1 = new JSONObject();
                paramString1.put("state", j);
                paramString1.put("total", i);
                paramString1.put("progress", d1);
                paramString1.put("upload_count", k);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              else if (paramString3.equals("profileAvatar"))
              {
                paramJsBridgeListener = new Intent(this.mRuntime.a(), AvatarPendantActivity.class);
                paramJsBridgeListener.putExtra("AllInOne", new ProfileActivity.AllInOne(this.mRuntime.a().getCurrentAccountUin(), 0));
                paramJsBridgeListener.putExtra("showActionSheet", true);
                this.mRuntime.a().startActivity(paramJsBridgeListener);
              }
              else if (paramString3.equals("profileSex"))
              {
                paramJsBridgeListener = new Intent(this.mRuntime.a(), FriendProfileMoreInfoActivity.class);
                paramJsBridgeListener.putExtra("profile_jump_to_edit", 1);
                this.mRuntime.a().startActivity(paramJsBridgeListener);
              }
              else if (paramString3.equals("profileBirthday"))
              {
                paramJsBridgeListener = new Intent(this.mRuntime.a(), FriendProfileMoreInfoActivity.class);
                paramJsBridgeListener.putExtra("profile_jump_to_edit", 2);
                this.mRuntime.a().startActivity(paramJsBridgeListener);
              }
              else if (paramString3.equals("profileLocation"))
              {
                paramJsBridgeListener = new Intent(this.mRuntime.a(), FriendProfileMoreInfoActivity.class);
                paramJsBridgeListener.putExtra("profile_jump_to_edit", 3);
                this.mRuntime.a().startActivity(paramJsBridgeListener);
              }
              else if (paramString3.equals("profileSchool"))
              {
                paramJsBridgeListener = new Intent(this.mRuntime.a(), FriendProfileMoreInfoActivity.class);
                paramJsBridgeListener.putExtra("profile_jump_to_edit", 4);
                this.mRuntime.a().startActivity(paramJsBridgeListener);
              }
            }
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("onActivityResult requestCode=%s resultCode=%s intent=%s", new Object[] { Byte.valueOf(paramByte), Integer.valueOf(paramInt), paramIntent }));
    }
    Object localObject;
    if ((paramByte != 100) || ((paramInt == -1) && (paramIntent != null)))
    {
      try
      {
        a(true, paramIntent.getStringExtra("key_photo_file_path"));
        return;
      }
      catch (Exception paramIntent)
      {
        String str;
        Intent localIntent;
        QLog.e("NewerGuidePlugin", 1, "onActivityResult fail, requestCode=" + paramByte, paramIntent);
        return;
      }
      if (paramByte == 101)
      {
        if (paramInt == -1)
        {
          paramIntent = this.mRuntime.a();
          localObject = bbdr.b(paramIntent, this.jdField_a_of_type_AndroidNetUri);
          str = bazo.a();
          paramInt = bazo.b(paramIntent);
          localIntent = new Intent();
          localIntent.setClass(paramIntent, PhotoCropForPortraitActivity.class);
          localIntent.putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT");
          localIntent.putExtra("Business_Origin", 100);
          localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
          localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
          localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
          localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localObject);
          localIntent.putExtra("PhotoConst.TARGET_PATH", str);
          localIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt);
          localIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt);
          localIntent.putExtra("PhotoConst.TARGET_WIDTH", 1080);
          localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 1080);
          paramIntent.startActivity(localIntent);
        }
      }
      else if ((paramInt == -1) && (paramIntent != null))
      {
        localObject = new JSONObject();
        paramInt = i;
        if (paramIntent.getBooleanExtra("has_operation", false)) {
          paramInt = 1;
        }
        paramIntent = paramIntent.getStringExtra("uin");
        ((JSONObject)localObject).put("result", paramInt);
        ((JSONObject)localObject).put("uin", paramIntent);
        paramIntent = null;
        switch (paramByte)
        {
        }
      }
    }
    for (;;)
    {
      if (paramIntent != null)
      {
        callJs(paramIntent, new String[] { ((JSONObject)localObject).toString() });
        return;
        paramIntent = "respCard";
        ((JSONObject)localObject).put("type", paramByte);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("NewerGuidePlugin", 1, "onActivityResult no result");
        }
      }
      return;
      continue;
      paramIntent = "respTroop";
      continue;
      paramIntent = "respFriend";
      continue;
      paramIntent = "respSayHi";
    }
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "onCreate this=" + this);
    }
    anvl.a().a(this.jdField_a_of_type_Anql);
    a();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "onDestroy this=" + this);
    }
    super.onDestroy();
    anvl.a().b(this.jdField_a_of_type_Anql);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin
 * JD-Core Version:    0.7.0.1
 */