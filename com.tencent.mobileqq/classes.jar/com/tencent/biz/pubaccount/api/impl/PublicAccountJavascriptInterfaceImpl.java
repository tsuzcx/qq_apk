package com.tencent.biz.pubaccount.api.impl;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface.ActionItem;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsWebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebProgressInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.ThreeDes;
import cooperation.plugin.PluginBaseActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.util.LogUtil;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountJavascriptInterfaceImpl
  extends JsWebViewPlugin
  implements IPublicAccountJavascriptInterface
{
  public static final int ANIM_STYLE_SHOW_UP_CLOSE_DOWN = 1001;
  public static final int ERROR_DATA_NOT_EXIST = -11;
  public static final int ERROR_EMPTY_DATA = -8;
  public static final int ERROR_EMPTY_KEY = -7;
  public static final int ERROR_EMPTY_PARAMS = -3;
  public static final int ERROR_EMPTY_PATH = -6;
  public static final int ERROR_EMPTY_URL = -4;
  public static final int ERROR_NO_PERMISSION_TO_DOMAIN = -5;
  public static final int ERROR_NO_SPACE_OR_NO_SDCARD = -9;
  public static final int ERROR_TOO_MANY_DATA = -12;
  public static final int ERROR_WRONG_IMAGE_DATA = -10;
  public static final int ERROR_WRONG_JSON = -2;
  protected static final String LBSDES_KEY = "nbyvie";
  protected static final String LBS_CALLER = "webview";
  private static final String METHOD_SET_NAVIGATION_BAR_STYLE = "setNavigationBarStyle";
  public static final String PUBACCOUNT_DATA_PATH;
  protected static final String SOSO_JSONEN_CRYPT_PUBKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrkUA+dDEQT52svdheRw04+xrExuTvNj3g7pjcyUkH3+86FiYNhHtyWJc11BywUZ2Ey3RomCyTb/szl5qQEJqR7UC5z4mhLrhgXlbRI0BgmI/LhaMRsfskGM7ziyQ2ZpS0qbHX2xoum6ou/541/VePIwmcnIk6eWUx6GYnA4euZQIDAQAB";
  protected static final String TAG = "PAjs";
  protected static final String TAG_LOCATION = "PAjs.location";
  private static long sH5DataUsage = 0L;
  protected static HashMap<String, String> storage;
  protected Activity context;
  boolean hasAsked = false;
  boolean isRegisteredBroadCast = false;
  private BroadcastReceiver mBroadcastReceiver = new PublicAccountJavascriptInterfaceImpl.2(this);
  QQCustomDialog mDialog;
  private WebUiUtils.WebviewReportSpeedInterface reportSpeedInterface = null;
  protected List<PublicAccountJavascriptInterfaceImpl.HttpTask> taskList;
  private WebUiUtils.WebUiMethodInterface uiMethodInterface = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("pubaccount/");
    PUBACCOUNT_DATA_PATH = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    storage = new HashMap();
  }
  
  private String decrypt(String paramString1, String paramString2)
  {
    return ThreeDes.b(paramString1, paramString2);
  }
  
  private void deleteHash(String paramString)
  {
    Object localObject = this.mRuntime.b();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString = ((EntityManager)localObject).query(CouponH5Data.class, false, "mHost = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        ((EntityManager)localObject).remove((CouponH5Data)paramString.next());
      }
    }
    ((EntityManager)localObject).close();
  }
  
  private void deleteHash(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.b();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = ((EntityManager)localObject).query(CouponH5Data.class, false, "mHost = ? AND mPath = ?", new String[] { paramString1, paramString2 }, null, null, null, null);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext()) {
        ((EntityManager)localObject).remove((CouponH5Data)paramString1.next());
      }
    }
    ((EntityManager)localObject).close();
  }
  
  private void deleteHash(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.mRuntime.b();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (paramString1 != null) {
      ((EntityManager)localObject).remove(paramString1);
    }
    ((EntityManager)localObject).close();
  }
  
  private String encrypt(String paramString1, String paramString2)
  {
    return ThreeDes.a(paramString1, paramString2);
  }
  
  private String formatLocData(byte[] paramArrayOfByte)
  {
    localObject6 = new JSONObject();
    try
    {
      localObject1 = new String(paramArrayOfByte, "UTF-8");
      paramArrayOfByte = (byte[])localObject1;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      try
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte);
        localObject6 = paramArrayOfByte;
        localJSONObject3 = new JSONObject();
        localJSONArray1 = new JSONArray();
        localJSONArray2 = new JSONArray();
        localJSONObject4 = new JSONObject();
        localJSONObject5 = new JSONObject();
        localObject5 = new JSONArray();
        localObject4 = new JSONArray();
        localJSONObject2 = new JSONObject();
        paramArrayOfByte = new JSONObject();
        localObject3 = localObject5;
        localObject1 = localObject4;
      }
      catch (JSONException paramArrayOfByte)
      {
        try
        {
          JSONObject localJSONObject1 = ((JSONObject)localObject6).getJSONObject("attribute");
          localObject3 = localObject5;
          localObject1 = localObject4;
          paramArrayOfByte = localJSONObject1;
          localObject4 = ((JSONObject)localObject6).getJSONArray("cells");
          localObject3 = localObject5;
          localObject1 = localObject4;
          paramArrayOfByte = localJSONObject1;
          localObject5 = ((JSONObject)localObject6).getJSONArray("wifis");
          localObject3 = localObject5;
          localObject1 = localObject4;
          paramArrayOfByte = localJSONObject1;
          localObject6 = ((JSONObject)localObject6).getJSONObject("location");
          paramArrayOfByte = localJSONObject1;
          localObject1 = localObject6;
          localObject3 = localObject5;
        }
        catch (JSONException paramArrayOfByte)
        {
          try
          {
            localJSONObject5.put("strImei", paramArrayOfByte.getString("imei"));
            localJSONObject5.put("strImsi", paramArrayOfByte.getString("imsi"));
            localJSONObject5.put("strPhonenum", paramArrayOfByte.getString("phonenum"));
            k = 0;
            i = 0;
            j = k;
          }
          catch (JSONException paramArrayOfByte)
          {
            try
            {
              int i;
              if (i >= ((JSONArray)localObject4).length()) {
                break label417;
              }
              paramArrayOfByte = new JSONObject();
              Object localObject5 = (JSONObject)((JSONArray)localObject4).get(i);
              paramArrayOfByte.put("shMcc", String.valueOf(((JSONObject)localObject5).getInt("mcc")));
              paramArrayOfByte.put("shMnc", String.valueOf(((JSONObject)localObject5).getInt("mnc")));
              paramArrayOfByte.put("iLac", String.valueOf(((JSONObject)localObject5).getInt("lac")));
              paramArrayOfByte.put("iCellId", String.valueOf(((JSONObject)localObject5).getInt("cellid")));
              paramArrayOfByte.put("shRssi", String.valueOf(((JSONObject)localObject5).getInt("rss")));
              localJSONArray2.put(paramArrayOfByte);
              i += 1;
            }
            catch (JSONException paramArrayOfByte)
            {
              try
              {
                Object localObject4;
                Object localObject3;
                while (j < localObject3.length())
                {
                  paramArrayOfByte = new JSONObject();
                  localObject4 = (JSONObject)localObject3.get(j);
                  paramArrayOfByte.put("lMac", ((JSONObject)localObject4).getString("mac"));
                  paramArrayOfByte.put("shRssi", String.valueOf(((JSONObject)localObject4).getInt("rssi")));
                  localJSONArray1.put(paramArrayOfByte);
                  j += 1;
                }
              }
              catch (JSONException paramArrayOfByte)
              {
                try
                {
                  Object localObject1;
                  localJSONObject4.put("iLat", String.valueOf(((JSONObject)localObject1).getInt("lat")));
                  localJSONObject4.put("iLon", String.valueOf(((JSONObject)localObject1).getInt("lon")));
                  localJSONObject4.put("iAlt", String.valueOf(((JSONObject)localObject1).getInt("alt")));
                  localJSONObject4.put("eType", String.valueOf(((JSONObject)localObject1).getInt("type")));
                }
                catch (JSONException paramArrayOfByte)
                {
                  try
                  {
                    JSONObject localJSONObject5;
                    localJSONObject3.put("stAttr", localJSONObject5);
                  }
                  catch (JSONException paramArrayOfByte)
                  {
                    try
                    {
                      JSONObject localJSONObject4;
                      localJSONObject3.put("stGps", localJSONObject4);
                    }
                    catch (JSONException paramArrayOfByte)
                    {
                      try
                      {
                        JSONArray localJSONArray2;
                        localJSONObject3.put("vCells", localJSONArray2);
                      }
                      catch (JSONException paramArrayOfByte)
                      {
                        try
                        {
                          for (;;)
                          {
                            JSONObject localJSONObject3;
                            JSONArray localJSONArray1;
                            JSONObject localJSONObject2;
                            int k;
                            localJSONObject3.put("vWifis", localJSONArray1);
                            return localJSONObject3.toString();
                            localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
                            continue;
                            paramArrayOfByte = paramArrayOfByte;
                            continue;
                            localJSONException = localJSONException;
                            UnsupportedEncodingException localUnsupportedEncodingException2 = localUnsupportedEncodingException1;
                            Object localObject2 = localJSONObject2;
                            continue;
                            paramArrayOfByte = paramArrayOfByte;
                            continue;
                            paramArrayOfByte = paramArrayOfByte;
                            int j = k;
                            continue;
                            paramArrayOfByte = paramArrayOfByte;
                            continue;
                            paramArrayOfByte = paramArrayOfByte;
                            continue;
                            paramArrayOfByte = paramArrayOfByte;
                            continue;
                            paramArrayOfByte = paramArrayOfByte;
                            continue;
                            paramArrayOfByte = paramArrayOfByte;
                          }
                        }
                        catch (JSONException paramArrayOfByte)
                        {
                          break label618;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    paramArrayOfByte = new String(paramArrayOfByte);
  }
  
  private static String getBitmapBase64String(String paramString)
  {
    Object localObject = new ByteArrayOutputStream(1024);
    for (;;)
    {
      byte[] arrayOfByte;
      try
      {
        paramString = (HttpURLConnection)new URL(paramString).openConnection();
        paramString.setDoInput(true);
        paramString.connect();
        paramString = paramString.getInputStream();
        arrayOfByte = new byte[1024];
        int i = paramString.read(arrayOfByte);
        if (i == -1)
        {
          paramString.close();
          arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
          if (BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length) == null)
          {
            return null;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(Base64Util.encodeToString(arrayOfByte, 2));
            return ((StringBuilder)localObject).toString();
          }
        }
        else
        {
          ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, i);
          continue;
        }
        localObject = "data:image;base64,";
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      if (((arrayOfByte[0] & 0xFF) == 255) && ((arrayOfByte[1] & 0xFF) == 216))
      {
        paramString = "data:image/jpeg;base64,";
      }
      else if (((arrayOfByte[0] & 0xFF) == 66) && ((arrayOfByte[1] & 0xFF) == 77))
      {
        paramString = "data:image/bmp;base64,";
      }
      else if (((arrayOfByte[0] & 0xFF) == 137) && ((arrayOfByte[1] & 0xFF) == 80))
      {
        paramString = "data:image/png;base64,";
      }
      else
      {
        paramString = (String)localObject;
        if ((arrayOfByte[0] & 0xFF) == 71)
        {
          paramString = (String)localObject;
          if ((arrayOfByte[1] & 0xFF) == 73) {
            paramString = "data:image/gif;base64,";
          }
        }
      }
    }
  }
  
  private static long getH5DataUsage()
  {
    Object localObject = new File(PUBACCOUNT_DATA_PATH);
    boolean bool = ((File)localObject).exists();
    long l = 0L;
    if (!bool) {
      return 0L;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    while (!localArrayList.isEmpty())
    {
      int i = 0;
      localObject = (File)localArrayList.remove(0);
      if (((File)localObject).isFile())
      {
        l += ((File)localObject).length();
      }
      else
      {
        localObject = ((File)localObject).listFiles();
        if (localObject != null)
        {
          int j = localObject.length;
          while (i < j)
          {
            localArrayList.add(localObject[i]);
            i += 1;
          }
        }
      }
    }
    return l;
  }
  
  private void getLocationImpl(String paramString, long paramLong)
  {
    ((AppActivity)this.context).requestPermissions(new PublicAccountJavascriptInterfaceImpl.6(this, paramString, paramLong), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
  }
  
  private void getRealLocationImpl(boolean paramBoolean, String paramString1, String paramString2)
  {
    long l1 = 0L;
    try
    {
      paramString1 = new JSONObject(paramString1);
      bool = paramString1.optBoolean("fallback", false);
    }
    catch (JSONException paramString1)
    {
      boolean bool;
      int i;
      long l2;
      label53:
      label56:
      label59:
      break label53;
    }
    try
    {
      i = paramString1.optInt("decrypt_padding", 0);
    }
    catch (JSONException paramString1)
    {
      break label56;
    }
    try
    {
      l2 = paramString1.optLong("allowCacheTime", 0L);
      l1 = l2 * 1000L;
    }
    catch (JSONException paramString1)
    {
      break label59;
    }
    bool = false;
    i = 0;
    ((AppActivity)this.context).requestPermissions(new PublicAccountJavascriptInterfaceImpl.10(this, paramBoolean, i, bool, paramString2, l1), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
  }
  
  private void getRealLocationPrivate(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (this.mRuntime.a() == null) {
      return;
    }
    Object localObject = this.context;
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      if ((this.context instanceof AppActivity))
      {
        localObject = this.mDialog;
        if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
          this.mDialog.dismiss();
        }
        localObject = this.mRuntime.b();
        String str = "";
        if (localObject != null) {
          localObject = ((AppInterface)localObject).getAccount();
        } else {
          localObject = "";
        }
        if (this.mRuntime.a() != null) {
          str = Util.d(this.mRuntime.a().getUrl());
        }
        if (getLocationPermissionGrant((String)localObject, str))
        {
          getRealLocationImpl(paramBoolean, paramString1, paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("PAjs", 2, "already grant");
          }
          return;
        }
        if (this.hasAsked)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PAjs", 2, "already ask");
          }
          return;
        }
        this.mDialog = DialogUtil.a(this.context, 0);
        this.mDialog.setMessage(this.context.getString(2131918007, new Object[] { str }));
        this.mDialog.setPositiveButton(2131918065, new PublicAccountJavascriptInterfaceImpl.7(this, paramBoolean, paramString1, paramString2, (String)localObject, str));
        this.mDialog.setNegativeButton(this.context.getString(2131918076), new PublicAccountJavascriptInterfaceImpl.8(this, paramString2));
        this.mDialog.setOnCancelListener(new PublicAccountJavascriptInterfaceImpl.9(this, paramString2));
        this.mDialog.show();
        return;
      }
      callJs(paramString2, new String[] { "-4", "{}" });
    }
  }
  
  private String hash(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = HexUtil.bytes2HexStr(localMessageDigest.digest());
      localMessageDigest.reset();
      return paramString;
    }
    catch (NoSuchAlgorithmException|UnsupportedEncodingException paramString)
    {
      label32:
      break label32;
    }
    return "wronghash";
  }
  
  private static boolean isParentDomain(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (paramString2 == null) {
      return false;
    }
    boolean bool1;
    if (!paramString2.equals(paramString1))
    {
      bool1 = bool2;
      if (paramString1.indexOf(".") > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(".");
        localStringBuilder.append(paramString1);
        bool1 = bool2;
        if (!paramString2.endsWith(localStringBuilder.toString())) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private String readHash(String paramString1, String paramString2, String paramString3)
  {
    Object localObject2 = this.mRuntime.b();
    Object localObject1 = null;
    if (localObject2 == null) {
      return null;
    }
    localObject2 = ((AppInterface)localObject2).getEntityManagerFactory(((AppInterface)localObject2).getAccount()).createEntityManager();
    paramString2 = (CouponH5Data)((EntityManager)localObject2).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    ((EntityManager)localObject2).close();
    paramString1 = localObject1;
    if (paramString2 != null) {
      paramString1 = paramString2.mData;
    }
    return paramString1;
  }
  
  public static void setLocationPermissionGrant(String paramString1, String paramString2, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("LocationPermissionPref");
      paramString1 = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("-location");
      paramString1.putInt(((StringBuilder)localObject).toString(), paramInt).commit();
      return;
    }
    QLog.e("PAjs", 1, new Object[] { "uin:", LogUtil.wrapLogUin(paramString1), " host:", paramString2 });
  }
  
  private void writeDataInMainThread(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {
      return;
    }
    try
    {
      ThreadManager.post(new PublicAccountJavascriptInterfaceImpl.15(this, new URL(localCustomWebView.getUrl()), paramString1, paramString2, paramJSONObject), 5, null, false);
      return;
    }
    catch (MalformedURLException paramString1) {}
  }
  
  /* Error */
  private void writeDataWithURL(URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 181	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4: invokevirtual 515	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 181	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15: invokevirtual 186	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   18: astore 8
    //   20: aload 8
    //   22: ifnonnull +4 -> 26
    //   25: return
    //   26: aload 8
    //   28: invokevirtual 191	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   31: ifnonnull +4 -> 35
    //   34: return
    //   35: new 256	org/json/JSONObject
    //   38: dup
    //   39: aload_2
    //   40: invokespecial 267	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   43: astore 10
    //   45: aload 10
    //   47: ldc_w 728
    //   50: invokevirtual 731	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 6
    //   55: aload 6
    //   57: astore 5
    //   59: aload 6
    //   61: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +25 -> 89
    //   67: aload 6
    //   69: ldc_w 733
    //   72: ldc_w 735
    //   75: invokevirtual 739	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   78: ldc_w 741
    //   81: ldc_w 743
    //   84: invokevirtual 739	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   87: astore 5
    //   89: aload 4
    //   91: ldc_w 728
    //   94: aload 5
    //   96: invokevirtual 297	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   99: pop
    //   100: getstatic 109	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:sH5DataUsage	J
    //   103: ldc2_w 744
    //   106: lcmp
    //   107: ifle +19 -> 126
    //   110: new 747	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl$16
    //   113: dup
    //   114: aload_0
    //   115: aload_3
    //   116: aload 4
    //   118: aload_2
    //   119: invokespecial 750	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl$16:<init>	(Lcom/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   122: invokestatic 754	com/tencent/mobileqq/app/ThreadManager:executeOnNetWorkThread	(Ljava/lang/Runnable;)V
    //   125: return
    //   126: aload 10
    //   128: ldc_w 756
    //   131: invokevirtual 731	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore 6
    //   136: aload 6
    //   138: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifeq +54 -> 195
    //   144: new 76	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   151: astore_1
    //   152: aload_1
    //   153: ldc_w 758
    //   156: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_1
    //   161: aload 4
    //   163: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   166: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_1
    //   171: ldc_w 760
    //   174: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_0
    //   179: aload_3
    //   180: iconst_1
    //   181: anewarray 207	java/lang/String
    //   184: dup
    //   185: iconst_0
    //   186: aload_1
    //   187: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: aastore
    //   191: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   194: return
    //   195: aload 10
    //   197: ldc_w 762
    //   200: invokevirtual 731	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   203: astore 7
    //   205: aload 7
    //   207: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   210: ifeq +54 -> 264
    //   213: new 76	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   220: astore_1
    //   221: aload_1
    //   222: ldc_w 764
    //   225: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_1
    //   230: aload 4
    //   232: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   235: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_1
    //   240: ldc_w 760
    //   243: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_0
    //   248: aload_3
    //   249: iconst_1
    //   250: anewarray 207	java/lang/String
    //   253: dup
    //   254: iconst_0
    //   255: aload_1
    //   256: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: aastore
    //   260: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   263: return
    //   264: aload 10
    //   266: ldc_w 766
    //   269: invokevirtual 731	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   272: astore 9
    //   274: aload 9
    //   276: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   279: ifeq +54 -> 333
    //   282: new 76	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   289: astore_1
    //   290: aload_1
    //   291: ldc_w 768
    //   294: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_1
    //   299: aload 4
    //   301: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   304: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_1
    //   309: ldc_w 760
    //   312: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_0
    //   317: aload_3
    //   318: iconst_1
    //   319: anewarray 207	java/lang/String
    //   322: dup
    //   323: iconst_0
    //   324: aload_1
    //   325: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: aastore
    //   329: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   332: return
    //   333: aload_1
    //   334: invokevirtual 771	java/net/URL:getHost	()Ljava/lang/String;
    //   337: astore_2
    //   338: aload 10
    //   340: ldc_w 773
    //   343: invokevirtual 731	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   346: astore 5
    //   348: aload_2
    //   349: astore_1
    //   350: aload 5
    //   352: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   355: ifne +69 -> 424
    //   358: aload 5
    //   360: aload_2
    //   361: invokestatic 775	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:isParentDomain	(Ljava/lang/String;Ljava/lang/String;)Z
    //   364: ifeq +9 -> 373
    //   367: aload 5
    //   369: astore_1
    //   370: goto +54 -> 424
    //   373: new 76	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   380: astore_1
    //   381: aload_1
    //   382: ldc_w 777
    //   385: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_1
    //   390: aload 4
    //   392: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   395: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload_1
    //   400: ldc_w 760
    //   403: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload_0
    //   408: aload_3
    //   409: iconst_1
    //   410: anewarray 207	java/lang/String
    //   413: dup
    //   414: iconst_0
    //   415: aload_1
    //   416: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: aastore
    //   420: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   423: return
    //   424: aload_1
    //   425: astore_2
    //   426: aload_1
    //   427: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   430: ifeq +7 -> 437
    //   433: ldc_w 779
    //   436: astore_2
    //   437: aload_0
    //   438: aload 9
    //   440: invokespecial 781	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:hash	(Ljava/lang/String;)Ljava/lang/String;
    //   443: astore_1
    //   444: aload_0
    //   445: aload_2
    //   446: aload 6
    //   448: aload 7
    //   450: aload_1
    //   451: invokespecial 785	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:writeHash	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload_0
    //   455: aload 9
    //   457: aload_1
    //   458: invokespecial 787	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:encrypt	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   461: astore 9
    //   463: new 76	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   470: astore_1
    //   471: aload_1
    //   472: getstatic 102	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:PUBACCOUNT_DATA_PATH	Ljava/lang/String;
    //   475: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload_1
    //   480: ldc_w 789
    //   483: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload_1
    //   488: aload 8
    //   490: invokevirtual 191	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   493: invokestatic 792	com/tencent/mobileqq/utils/HexUtil:string2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   496: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: new 447	java/io/File
    //   503: dup
    //   504: aload_1
    //   505: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokespecial 448	java/io/File:<init>	(Ljava/lang/String;)V
    //   511: astore_1
    //   512: aload_1
    //   513: invokevirtual 451	java/io/File:exists	()Z
    //   516: ifne +11 -> 527
    //   519: aload_1
    //   520: invokevirtual 795	java/io/File:mkdirs	()Z
    //   523: pop
    //   524: goto +20 -> 544
    //   527: aload_1
    //   528: invokevirtual 466	java/io/File:isFile	()Z
    //   531: ifeq +13 -> 544
    //   534: aload_1
    //   535: invokevirtual 798	java/io/File:delete	()Z
    //   538: pop
    //   539: aload_1
    //   540: invokevirtual 795	java/io/File:mkdirs	()Z
    //   543: pop
    //   544: new 447	java/io/File
    //   547: dup
    //   548: aload_1
    //   549: aload_2
    //   550: invokespecial 801	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   553: astore_1
    //   554: aload_1
    //   555: invokevirtual 451	java/io/File:exists	()Z
    //   558: ifne +11 -> 569
    //   561: aload_1
    //   562: invokevirtual 795	java/io/File:mkdirs	()Z
    //   565: pop
    //   566: goto +20 -> 586
    //   569: aload_1
    //   570: invokevirtual 466	java/io/File:isFile	()Z
    //   573: ifeq +13 -> 586
    //   576: aload_1
    //   577: invokevirtual 798	java/io/File:delete	()Z
    //   580: pop
    //   581: aload_1
    //   582: invokevirtual 795	java/io/File:mkdirs	()Z
    //   585: pop
    //   586: new 447	java/io/File
    //   589: dup
    //   590: aload_1
    //   591: aload 6
    //   593: invokestatic 792	com/tencent/mobileqq/utils/HexUtil:string2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   596: invokespecial 801	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   599: astore 8
    //   601: aload 8
    //   603: invokevirtual 451	java/io/File:exists	()Z
    //   606: ifne +12 -> 618
    //   609: aload 8
    //   611: invokevirtual 795	java/io/File:mkdirs	()Z
    //   614: pop
    //   615: goto +23 -> 638
    //   618: aload 8
    //   620: invokevirtual 466	java/io/File:isFile	()Z
    //   623: ifeq +15 -> 638
    //   626: aload 8
    //   628: invokevirtual 798	java/io/File:delete	()Z
    //   631: pop
    //   632: aload 8
    //   634: invokevirtual 795	java/io/File:mkdirs	()Z
    //   637: pop
    //   638: aconst_null
    //   639: astore_1
    //   640: aconst_null
    //   641: astore_2
    //   642: aconst_null
    //   643: astore 6
    //   645: aload_0
    //   646: monitorenter
    //   647: aload 6
    //   649: astore 5
    //   651: new 447	java/io/File
    //   654: dup
    //   655: aload 8
    //   657: aload 7
    //   659: invokestatic 792	com/tencent/mobileqq/utils/HexUtil:string2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   662: invokespecial 801	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   665: astore_2
    //   666: aload 6
    //   668: astore 5
    //   670: aload_2
    //   671: invokevirtual 451	java/io/File:exists	()Z
    //   674: ifeq +12 -> 686
    //   677: aload 6
    //   679: astore 5
    //   681: aload_2
    //   682: invokevirtual 798	java/io/File:delete	()Z
    //   685: pop
    //   686: aload 6
    //   688: astore 5
    //   690: new 803	java/io/FileWriter
    //   693: dup
    //   694: aload_2
    //   695: invokespecial 806	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   698: astore_1
    //   699: aload_1
    //   700: aload 9
    //   702: invokevirtual 808	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   705: getstatic 109	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:sH5DataUsage	J
    //   708: aload_2
    //   709: invokevirtual 468	java/io/File:length	()J
    //   712: ladd
    //   713: putstatic 109	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:sH5DataUsage	J
    //   716: aload_0
    //   717: monitorexit
    //   718: new 76	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   725: astore_2
    //   726: aload_2
    //   727: ldc_w 810
    //   730: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: aload_2
    //   735: aload 4
    //   737: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   740: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload_2
    //   745: ldc_w 760
    //   748: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: aload_0
    //   753: aload_3
    //   754: iconst_1
    //   755: anewarray 207	java/lang/String
    //   758: dup
    //   759: iconst_0
    //   760: aload_2
    //   761: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: aastore
    //   765: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   768: aload_1
    //   769: invokevirtual 811	java/io/FileWriter:close	()V
    //   772: return
    //   773: astore_1
    //   774: aload_1
    //   775: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   778: return
    //   779: astore_2
    //   780: goto +108 -> 888
    //   783: aload_1
    //   784: astore_2
    //   785: goto +29 -> 814
    //   788: astore 6
    //   790: aload_1
    //   791: astore_2
    //   792: goto +8 -> 800
    //   795: astore 6
    //   797: aload 5
    //   799: astore_2
    //   800: aload_2
    //   801: astore 5
    //   803: aload_0
    //   804: monitorexit
    //   805: aload_2
    //   806: astore_1
    //   807: aload 6
    //   809: athrow
    //   810: astore_2
    //   811: goto +77 -> 888
    //   814: aload_2
    //   815: astore_1
    //   816: new 76	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   823: astore 5
    //   825: aload_2
    //   826: astore_1
    //   827: aload 5
    //   829: ldc_w 813
    //   832: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: pop
    //   836: aload_2
    //   837: astore_1
    //   838: aload 5
    //   840: aload 4
    //   842: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   845: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: pop
    //   849: aload_2
    //   850: astore_1
    //   851: aload 5
    //   853: ldc_w 760
    //   856: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: aload_2
    //   861: astore_1
    //   862: aload_0
    //   863: aload_3
    //   864: iconst_1
    //   865: anewarray 207	java/lang/String
    //   868: dup
    //   869: iconst_0
    //   870: aload 5
    //   872: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: aastore
    //   876: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   879: aload_2
    //   880: ifnull +76 -> 956
    //   883: aload_2
    //   884: invokevirtual 811	java/io/FileWriter:close	()V
    //   887: return
    //   888: aload_1
    //   889: ifnull +15 -> 904
    //   892: aload_1
    //   893: invokevirtual 811	java/io/FileWriter:close	()V
    //   896: goto +8 -> 904
    //   899: astore_1
    //   900: aload_1
    //   901: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   904: aload_2
    //   905: athrow
    //   906: new 76	java/lang/StringBuilder
    //   909: dup
    //   910: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   913: astore_1
    //   914: aload_1
    //   915: ldc_w 815
    //   918: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload_1
    //   923: aload 4
    //   925: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   928: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: pop
    //   932: aload_1
    //   933: ldc_w 760
    //   936: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: pop
    //   940: aload_0
    //   941: aload_3
    //   942: iconst_1
    //   943: anewarray 207	java/lang/String
    //   946: dup
    //   947: iconst_0
    //   948: aload_1
    //   949: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   952: aastore
    //   953: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   956: return
    //   957: astore_1
    //   958: goto -52 -> 906
    //   961: astore_1
    //   962: goto -148 -> 814
    //   965: astore_2
    //   966: goto -183 -> 783
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	969	0	this	PublicAccountJavascriptInterfaceImpl
    //   0	969	1	paramURL	URL
    //   0	969	2	paramString1	String
    //   0	969	3	paramString2	String
    //   0	969	4	paramJSONObject	JSONObject
    //   57	814	5	localObject1	Object
    //   53	634	6	str1	String
    //   788	1	6	localObject2	Object
    //   795	13	6	localObject3	Object
    //   203	455	7	str2	String
    //   18	638	8	localObject4	Object
    //   272	429	9	str3	String
    //   43	296	10	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   768	772	773	java/io/IOException
    //   883	887	773	java/io/IOException
    //   718	768	779	finally
    //   699	718	788	finally
    //   651	666	795	finally
    //   670	677	795	finally
    //   681	686	795	finally
    //   690	699	795	finally
    //   803	805	795	finally
    //   645	647	810	finally
    //   807	810	810	finally
    //   816	825	810	finally
    //   827	836	810	finally
    //   838	849	810	finally
    //   851	860	810	finally
    //   862	879	810	finally
    //   892	896	899	java/io/IOException
    //   0	10	957	org/json/JSONException
    //   11	20	957	org/json/JSONException
    //   26	34	957	org/json/JSONException
    //   35	55	957	org/json/JSONException
    //   59	89	957	org/json/JSONException
    //   89	125	957	org/json/JSONException
    //   126	194	957	org/json/JSONException
    //   195	263	957	org/json/JSONException
    //   264	332	957	org/json/JSONException
    //   333	348	957	org/json/JSONException
    //   350	367	957	org/json/JSONException
    //   373	423	957	org/json/JSONException
    //   426	433	957	org/json/JSONException
    //   437	524	957	org/json/JSONException
    //   527	544	957	org/json/JSONException
    //   544	566	957	org/json/JSONException
    //   569	586	957	org/json/JSONException
    //   586	615	957	org/json/JSONException
    //   618	638	957	org/json/JSONException
    //   768	772	957	org/json/JSONException
    //   774	778	957	org/json/JSONException
    //   883	887	957	org/json/JSONException
    //   892	896	957	org/json/JSONException
    //   900	904	957	org/json/JSONException
    //   904	906	957	org/json/JSONException
    //   645	647	961	java/io/IOException
    //   807	810	961	java/io/IOException
    //   718	768	965	java/io/IOException
  }
  
  private void writeHash(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = this.mRuntime.b();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    CouponH5Data localCouponH5Data = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (localCouponH5Data == null)
    {
      ((EntityManager)localObject).persist(new CouponH5Data(paramString1, paramString2, paramString3, paramString4));
    }
    else
    {
      localCouponH5Data.mData = paramString4;
      ((EntityManager)localObject).update(localCouponH5Data);
    }
    ((EntityManager)localObject).close();
  }
  
  public void actionSheetAdditionalItems(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("actionSheetAdditionalItems->paramStr:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      if (localObject != null)
      {
        paramString = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
        if (((JSONObject)localObject).has("pageType"))
        {
          int j = ((JSONObject)localObject).getInt("pageType");
          localObject = ((JSONObject)localObject).getJSONArray("itemList");
          ArrayList localArrayList = new ArrayList();
          if (localObject != null)
          {
            int i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              IPublicAccountJavascriptInterface.ActionItem localActionItem = new IPublicAccountJavascriptInterface.ActionItem();
              localActionItem.a = localJSONObject.optInt("itemType");
              localActionItem.b = localJSONObject.optString("itemName");
              localActionItem.c = localJSONObject.optString("itemActionData");
              localArrayList.add(localActionItem);
              i += 1;
            }
          }
          if (paramString != null)
          {
            if (j == 1) {
              paramString.y = true;
            } else {
              paramString.z = true;
            }
            paramString.A = localArrayList;
            return;
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("actionSheetAdditionalItems->error:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void close()
  {
    this.context.finish();
  }
  
  public void deleteAllH5Data(AppInterface paramAppInterface)
  {
    EntityManager localEntityManager = paramAppInterface.getEntityManagerFactory(paramAppInterface.getAccount()).createEntityManager();
    Object localObject1 = localEntityManager.query(CouponH5Data.class);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (CouponH5Data)((Iterator)localObject1).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(PUBACCOUNT_DATA_PATH);
        localStringBuilder.append("/");
        localStringBuilder.append(HexUtil.string2HexString(paramAppInterface.getAccount()));
        localStringBuilder.append("/");
        localStringBuilder.append(((CouponH5Data)localObject2).mHost);
        localObject2 = new File(localStringBuilder.toString());
        if (((File)localObject2).exists()) {
          FileUtil.a((File)localObject2);
        }
      }
    }
    localEntityManager.drop(CouponH5Data.class);
    localEntityManager.close();
  }
  
  public void deleteH5Data(String paramString1, String paramString2)
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {
      return;
    }
    AppInterface localAppInterface = this.mRuntime.b();
    if (localAppInterface == null) {
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append("{ret:-3, response:");
      paramString1.append(localJSONObject1.toString());
      paramString1.append("}");
      callJs(paramString2, new String[] { paramString1.toString() });
      return;
    }
    try
    {
      localJSONObject2 = new JSONObject(paramString1);
      str1 = localJSONObject2.optString("callid");
      paramString1 = str1;
      if (!TextUtils.isEmpty(str1)) {
        paramString1 = str1.replace("\\", "\\\\").replace("'", "\\'");
      }
      localJSONObject1.put("callid", paramString1);
      str2 = localJSONObject2.optString("path");
      if (TextUtils.isEmpty(str2))
      {
        paramString1 = new StringBuilder();
        paramString1.append("{ret:-6, response:");
        paramString1.append(localJSONObject1.toString());
        paramString1.append("}");
        callJs(paramString2, new String[] { paramString1.toString() });
        return;
      }
      str3 = localJSONObject2.optString("key");
      paramString1 = null;
    }
    catch (JSONException paramString1)
    {
      JSONObject localJSONObject2;
      String str1;
      String str2;
      String str3;
      label260:
      label344:
      boolean bool;
      label629:
      break label629;
    }
    try
    {
      str1 = new URL(localCustomWebView.getUrl()).getHost();
      paramString1 = str1;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      break label260;
      break label344;
    }
    str1 = localJSONObject2.optString("host");
    if (!TextUtils.isEmpty(str1))
    {
      if (isParentDomain(str1, paramString1))
      {
        paramString1 = str1;
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append("{ret:-5, response:");
        paramString1.append(localJSONObject1.toString());
        paramString1.append("}");
        callJs(paramString2, new String[] { paramString1.toString() });
        return;
      }
      str1 = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        str1 = "defaulthost";
      }
      bool = TextUtils.isEmpty(str3);
      if (bool)
      {
        deleteHash(str1, str2);
        paramString1 = new StringBuilder();
        paramString1.append(PUBACCOUNT_DATA_PATH);
        paramString1.append("/");
        paramString1.append(HexUtil.string2HexString(localAppInterface.getAccount()));
        paramString1.append("/");
        paramString1.append(str1);
        paramString1.append("/");
        paramString1.append(HexUtil.string2HexString(str2));
        FileUtil.a(new File(paramString1.toString()));
      }
      else
      {
        deleteHash(str1, str2, str3);
        paramString1 = new StringBuilder();
        paramString1.append(PUBACCOUNT_DATA_PATH);
        paramString1.append("/");
        paramString1.append(HexUtil.string2HexString(localAppInterface.getAccount()));
        paramString1.append("/");
        paramString1.append(str1);
        paramString1.append("/");
        paramString1.append(HexUtil.string2HexString(str2));
        paramString1.append("/");
        paramString1.append(HexUtil.string2HexString(str3));
        FileUtil.a(new File(paramString1.toString()));
      }
      paramString1 = new StringBuilder();
      paramString1.append("{ret:0, response:");
      paramString1.append(localJSONObject1.toString());
      paramString1.append("}");
      callJs(paramString2, new String[] { paramString1.toString() });
      return;
      paramString1 = new StringBuilder();
      paramString1.append("{ret:-2, response:");
      paramString1.append(localJSONObject1.toString());
      paramString1.append("}");
      callJs(paramString2, new String[] { paramString1.toString() });
      return;
    }
  }
  
  public void deleteH5DataByHost(String paramString1, String paramString2)
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {
      return;
    }
    AppInterface localAppInterface = this.mRuntime.b();
    if (localAppInterface == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append("{ret:-3, response:");
      paramString1.append(localJSONObject.toString());
      paramString1.append("}");
      callJs(paramString2, new String[] { paramString1.toString() });
      return;
    }
    try
    {
      localObject2 = new JSONObject(paramString1);
      localObject1 = ((JSONObject)localObject2).optString("callid");
      paramString1 = (String)localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramString1 = ((String)localObject1).replace("\\", "\\\\").replace("'", "\\'");
      }
      localJSONObject.put("callid", paramString1);
      paramString1 = null;
    }
    catch (JSONException paramString1)
    {
      Object localObject2;
      Object localObject1;
      label175:
      break label396;
    }
    try
    {
      localObject1 = new URL(localCustomWebView.getUrl()).getHost();
      paramString1 = (String)localObject1;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      break label175;
    }
    localObject2 = ((JSONObject)localObject2).optString("host");
    localObject1 = paramString1;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      if (isParentDomain((String)localObject2, paramString1))
      {
        localObject1 = localObject2;
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append("{ret:-5, response:");
        paramString1.append(localJSONObject.toString());
        paramString1.append("}");
        callJs(paramString2, new String[] { paramString1.toString() });
        return;
      }
    }
    paramString1 = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString1 = "defaulthost";
    }
    deleteHash(paramString1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(PUBACCOUNT_DATA_PATH);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(HexUtil.string2HexString(localAppInterface.getAccount()));
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(paramString1);
    FileUtil.a(new File(((StringBuilder)localObject1).toString()));
    paramString1 = new StringBuilder();
    paramString1.append("{ret:0, response:");
    paramString1.append(localJSONObject.toString());
    paramString1.append("}");
    callJs(paramString2, new String[] { paramString1.toString() });
    return;
    label396:
    paramString1 = new StringBuilder();
    paramString1.append("{ret:-2, response:");
    paramString1.append(localJSONObject.toString());
    paramString1.append("}");
    callJs(paramString2, new String[] { paramString1.toString() });
  }
  
  public void enableNotCare(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enable share dian dian->paramStr:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      if (localObject != null)
      {
        paramString = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
        if (((JSONObject)localObject).has("enable"))
        {
          localObject = ((JSONObject)localObject).getString("enable");
          if (paramString != null)
          {
            if ("1".equals(localObject))
            {
              paramString.e(true);
              return;
            }
            paramString.e(false);
            return;
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enable Share dian dian->error:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void enableScreenshot(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enableScreenshot->enable:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (SwiftBrowserScreenShotHandler)super.getBrowserComponent(64);
    if (localObject != null)
    {
      if ("1".equals(paramString))
      {
        ((SwiftBrowserScreenShotHandler)localObject).b("");
        return;
      }
      ((SwiftBrowserScreenShotHandler)localObject).c();
    }
  }
  
  public void enableShareDianDian(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enable share dian dian->paramStr:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      if (localObject != null)
      {
        paramString = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
        boolean bool = ((JSONObject)localObject).has("enable");
        if (bool)
        {
          String str = ((JSONObject)localObject).getString("enable");
          if (paramString != null) {
            if ("1".equals(str)) {
              paramString.c(true);
            } else {
              paramString.c(false);
            }
          }
        }
        if (((JSONObject)localObject).has("enableShortLink"))
        {
          localObject = ((JSONObject)localObject).getString("enableShortLink");
          if (paramString != null)
          {
            if ("1".equals(localObject))
            {
              paramString.d(true);
              return;
            }
            paramString.d(false);
            return;
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enable Share dian dian->error:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void enableShareSinaWeibo(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enableShareSinaWeibo->paramStr:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      if ((paramString != null) && (paramString.has("enable")))
      {
        paramString = paramString.getString("enable");
        localObject = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
        if (localObject != null)
        {
          if ("1".equals(paramString))
          {
            ((SwiftBrowserShareMenuHandler)localObject).b(true);
            return;
          }
          ((SwiftBrowserShareMenuHandler)localObject).b(false);
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enableShareSinaWeibo->error:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public int excuteShowProfile(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showProfile: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("PAjs", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString == null) {
      return -1;
    }
    String str1 = paramString.trim();
    boolean bool = str1.startsWith("{");
    String str3 = null;
    localObject1 = null;
    paramString = null;
    int k = 0;
    int i = 0;
    String str4 = "";
    if (bool) {}
    try
    {
      localObject3 = new JSONObject(str1);
      str1 = ((JSONObject)localObject3).getString("uin");
      k = ((JSONObject)localObject3).optInt("uinType", 0);
      j = ((JSONObject)localObject3).optInt("isFinish", 0);
      bool = "groupSearchOther".equals(((JSONObject)localObject3).optString("jump_from"));
      localObject2 = "group";
      if (bool)
      {
        i = ((JSONObject)localObject3).optInt("subSourceID");
        localObject1 = localObject2;
      }
      else if (k == 1)
      {
        i = ((JSONObject)localObject3).optInt("wSourceSubID");
        localObject1 = localObject2;
      }
      else
      {
        paramString = (String)localObject1;
        if (k != 0) {
          break label799;
        }
        str2 = ((JSONObject)localObject3).optString("from");
        localObject2 = ((JSONObject)localObject3).optString("troopuin");
        if (("groupActivity".equals(str2)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          localObject1 = new AllInOne(str1, 120);
          ((AllInOne)localObject1).troopCode = ((String)localObject2);
          paramString = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.mRuntime.d(), (AllInOne)localObject1);
          paramString.putExtra("AllInOne", (Parcelable)localObject1);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("troop_uin", (String)localObject2);
          paramString.putExtra("flc_extra_param", (Bundle)localObject1);
          localObject1 = "";
        }
        else
        {
          paramString = (String)localObject1;
          if (!"groupMembers".equals(str2)) {
            break label799;
          }
          paramString = (String)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label799;
          }
          paramString = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.mRuntime.d(), null);
          paramString.putExtra("troopUin", (String)localObject2);
          paramString.putExtra("memberUin", str1);
        }
      }
    }
    catch (JSONException paramAppInterface)
    {
      for (;;)
      {
        Object localObject3;
        int j;
        String str2;
        Object localObject4;
        label535:
        continue;
        localObject1 = "";
        continue;
        Object localObject2 = "";
      }
    }
    if (((JSONObject)localObject3).optInt("colorScreen") != 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&colorScreen=");
      ((StringBuilder)localObject2).append(((JSONObject)localObject3).optInt("colorScreen"));
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject4 = ((JSONObject)localObject3).optString("authKey");
      str2 = ((JSONObject)localObject3).optString("authSig");
      str3 = paramString;
      localObject3 = localObject1;
      break label535;
      if (QLog.isDevelopLevel()) {
        QLog.d("PAjs", 4, "showProfile param error");
      }
      return -1;
      localObject2 = "";
      paramString = (String)localObject2;
      localObject1 = paramString;
      localObject3 = localObject1;
      j = 0;
      localObject4 = localObject1;
      i = k;
      str2 = paramString;
      if (str1 != null)
      {
        if (str1.length() < 5) {
          return -1;
        }
        if (str3 != null)
        {
          paramContext.startActivity(str3);
          return j;
        }
        localObject1 = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          paramString = new StringBuilder();
          paramString.append("&authKey=");
          paramString.append((String)localObject4);
          paramString = paramString.toString();
        }
        else
        {
          paramString = "";
        }
        ((StringBuilder)localObject1).append(paramString);
        paramString = str4;
        if (!TextUtils.isEmpty(str2))
        {
          paramString = new StringBuilder();
          paramString.append("&authSig=");
          paramString.append(str2);
          paramString = paramString.toString();
        }
        ((StringBuilder)localObject1).append(paramString);
        paramString = new StringBuilder();
        paramString.append("mqq://card/show_pslcard/?uin=");
        paramString.append(str1);
        paramString.append("&card_type=");
        paramString.append((String)localObject3);
        paramString.append("&wSourceSubID=");
        paramString.append(i);
        paramString.append(((StringBuilder)localObject1).toString());
        paramString.append((String)localObject2);
        paramString = paramString.toString();
        if ((paramAppInterface instanceof QQAppInterface))
        {
          JumpParser.a((QQAppInterface)paramAppInterface, paramContext, paramString).a();
          return j;
        }
        paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramString)));
        return j;
      }
      return -1;
    }
  }
  
  public String getDataPath()
  {
    return PUBACCOUNT_DATA_PATH;
  }
  
  public void getJson(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    callJs("clientCallback", new String[] { Util.c("{'r': -102, 'msg': 'no such method'}"), Util.c(paramString4) });
  }
  
  public void getLocation(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getLocation:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("PAjs.location", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.mRuntime.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PAjs.location", 2, "getWebView()==null, return");
      }
      return;
    }
    Object localObject1 = this.context;
    if ((localObject1 != null) && (!((Activity)localObject1).isFinishing()))
    {
      long l;
      boolean bool;
      if (paramString.charAt(0) == '{')
      {
        try
        {
          localObject1 = new JSONObject(paramString);
          paramString = ((JSONObject)localObject1).getString("callback");
          l = ((JSONObject)localObject1).optLong("allowCacheTime", 0L);
          bool = ((JSONObject)localObject1).optBoolean("is_for_ecshop_map");
          l *= 1000L;
        }
        catch (JSONException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.w("PAjs.location", 2, "getLocation exception:", paramString);
          }
          return;
        }
      }
      else
      {
        l = 0L;
        bool = false;
      }
      Object localObject2 = this.mRuntime.b();
      if (localObject2 != null) {
        localObject1 = ((AppInterface)localObject2).getAccount();
      } else {
        localObject1 = "";
      }
      if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null))
      {
        localObject1 = ((AppInterface)localObject2).getApp().getSharedPreferences((String)localObject1, 0);
        double d1 = ((SharedPreferences)localObject1).getFloat(SearchProtocol.d, 0.0F);
        double d2 = ((SharedPreferences)localObject1).getFloat(SearchProtocol.c, 0.0F);
        if (QLog.isColorLevel()) {
          QLog.i("EcShopAssistantActivity", 2, String.format("'longitude:%1$1.15f,latitude:%2$1.15f'", new Object[] { Double.valueOf(d1), Double.valueOf(d2) }));
        }
        callJs(paramString, new String[] { String.format("'%1$1.15f,%2$1.15f'", new Object[] { Double.valueOf(d1), Double.valueOf(d2) }) });
        return;
      }
      if (this.mRuntime.a() != null) {
        localObject2 = Util.a(this.mRuntime.a().getUrl(), 2);
      } else {
        localObject2 = "";
      }
      if (!TextUtils.isEmpty(paramString))
      {
        if ((this.context instanceof AppActivity))
        {
          QQCustomDialog localQQCustomDialog = this.mDialog;
          if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
            this.mDialog.dismiss();
          }
          if (getLocationPermissionGrant((String)localObject1, (String)localObject2))
          {
            getLocationImpl(paramString, l);
            if (QLog.isColorLevel()) {
              QLog.d("PAjs", 2, "already grant");
            }
            return;
          }
          if (this.hasAsked)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PAjs", 2, "already ask");
            }
            return;
          }
          this.mDialog = DialogUtil.a(this.context, 0);
          this.mDialog.setMessage(this.context.getString(2131918007, new Object[] { localObject2 }));
          this.mDialog.setPositiveButton(2131918065, new PublicAccountJavascriptInterfaceImpl.3(this, paramString, l, (String)localObject1, (String)localObject2));
          this.mDialog.setNegativeButton(this.context.getString(2131918076), new PublicAccountJavascriptInterfaceImpl.4(this, paramString));
          this.mDialog.setOnCancelListener(new PublicAccountJavascriptInterfaceImpl.5(this, paramString));
          this.mDialog.show();
          return;
        }
        callJs(paramString, new String[] { "-4", "{}" });
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("PAjs.location", 2, "context==null || isFinishing, return");
    }
  }
  
  public boolean getLocationPermissionGrant(String paramString1, String paramString2)
  {
    boolean bool2 = TextUtils.isEmpty(paramString1);
    boolean bool1 = false;
    if ((!bool2) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramString2.contains("qq.com"))
      {
        QLog.d("PAjs", 1, "qq.com can grant");
        return true;
      }
      Object localObject = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("LocationPermissionPref");
      paramString1 = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("-location");
      if (paramString1.getInt(((StringBuilder)localObject).toString(), 0) == 1) {
        bool1 = true;
      }
      return bool1;
    }
    QLog.e("PAjs", 1, new Object[] { "uin:", LogUtil.wrapLogUin(paramString1), " host:", paramString2 });
    return false;
  }
  
  protected String getNameSpace()
  {
    return "publicAccount";
  }
  
  public int getNetworkState()
  {
    return NetworkUtil.getNetworkType(BaseApplication.getContext());
  }
  
  public String getNetworkType()
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo != null)
    {
      int i = localNetworkInfo.getType();
      if (i != 0)
      {
        if (i != 1) {
          return "other";
        }
        return "WiFi";
      }
      String str;
      switch (localNetworkInfo.getSubtype())
      {
      case 7: 
      case 10: 
      case 11: 
      default: 
        str = "other_";
        break;
      case 12: 
        str = "EVDO_B_";
        break;
      case 9: 
        str = "HSUPA_";
        break;
      case 8: 
        str = "HSDPA_";
        break;
      case 6: 
        str = "EVDO_A_";
        break;
      case 5: 
        str = "EVDO_0_";
        break;
      case 4: 
        str = "CDMA_";
        break;
      case 3: 
        str = "UMTS_";
        break;
      case 2: 
        str = "EDGE_";
        break;
      case 1: 
        str = "GPRS";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(localNetworkInfo.getExtraInfo());
      return localStringBuilder.toString();
    }
    return "empty";
  }
  
  public void getPageLoadStamp(String paramString)
  {
    Object localObject = this.uiMethodInterface;
    if (localObject != null)
    {
      if (!TextUtils.isEmpty(((WebUiUtils.WebUiMethodInterface)localObject).getCurrentUrl())) {
        localObject = this.uiMethodInterface.getCurrentUrl();
      } else {
        localObject = "";
      }
      if (this.reportSpeedInterface != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{ret:0, onCreateTime:");
        localStringBuilder.append(this.reportSpeedInterface.getmOnCreateMilliTimeStamp());
        localStringBuilder.append(", startLoadUrlTime:");
        localStringBuilder.append(this.reportSpeedInterface.getmStartLoadUrlMilliTimeStamp());
        localStringBuilder.append(", url:'");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("'}");
        callJs(paramString, new String[] { localStringBuilder.toString() });
      }
    }
    else
    {
      callJs(paramString, new String[] { "{ret: -1}" });
    }
  }
  
  public void getRealLocation(String paramString1, String paramString2)
  {
    getRealLocationPrivate(false, paramString1, paramString2);
  }
  
  public void getRealLocationDes(String paramString1, String paramString2)
  {
    getRealLocationPrivate(true, paramString1, paramString2);
  }
  
  public void getUrlImage(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(paramString1))
    {
      new PublicAccountJavascriptInterfaceImpl.12(this, paramString1, localJSONObject, paramString2).start();
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("{ret:-3, response:");
    paramString1.append(localJSONObject.toString());
    paramString1.append("}");
    callJs(paramString2, new String[] { paramString1.toString() });
  }
  
  public WebViewPlugin getWebViewPlugin()
  {
    return this;
  }
  
  public void hideLoading()
  {
    Object localObject = this.mRuntime.a(this.mRuntime.d());
    if ((localObject != null) && ((localObject instanceof WebUiUtils.WebProgressInterface)))
    {
      ((WebUiUtils.WebProgressInterface)localObject).a();
      return;
    }
    localObject = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
    if ((localObject != null) && (((SwiftBrowserUIStyleHandler)localObject).B != null)) {
      ((SwiftBrowserUIStyleHandler)localObject).B.setVisibility(8);
    }
  }
  
  protected String httpRequest(String paramString1, String paramString2)
  {
    AppInterface localAppInterface = this.mRuntime.b();
    if (localAppInterface == null) {
      return "";
    }
    Object localObject2 = "GET";
    try
    {
      localObject1 = new JSONObject(paramString2);
      localObject3 = localObject1;
    }
    catch (JSONException paramString2)
    {
      Object localObject1;
      label83:
      label86:
      Bundle localBundle;
      break label83;
    }
    try
    {
      if (!QLog.isColorLevel()) {
        break label86;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(" httpRequest strParams:");
      ((StringBuilder)localObject3).append(paramString2);
      QLog.i("PAjs", 2, ((StringBuilder)localObject3).toString());
      localObject3 = localObject1;
    }
    catch (JSONException paramString2)
    {
      localObject3 = str;
      break label86;
    }
    localObject3 = null;
    localBundle = new Bundle();
    localBundle.putString("from", "native");
    paramString2 = (String)localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      paramString2 = (String)localObject2;
      try
      {
        if (((JSONObject)localObject3).has("method"))
        {
          localObject1 = localObject2;
          paramString2 = ((JSONObject)localObject3).getString("method");
          localObject1 = paramString2;
          paramString2 = paramString2.toUpperCase();
        }
      }
      catch (JSONException paramString2)
      {
        paramString2.printStackTrace();
        paramString2 = (String)localObject1;
      }
    }
    if (localObject3 != null) {
      try
      {
        if (((JSONObject)localObject3).has("param"))
        {
          localObject1 = ((JSONObject)localObject3).getJSONObject("param");
          localObject2 = ((JSONObject)localObject1).keys();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next().toString();
            localBundle.putString((String)localObject3, ((JSONObject)localObject1).getString((String)localObject3));
          }
        }
        str = localAppInterface.getAccount();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("uin=");
    ((StringBuilder)localObject2).append(str);
    str = ((StringBuilder)localObject2).toString();
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("Cookie", str);
    try
    {
      paramString1 = HttpUtil.openUrl(this.context.getApplicationContext(), paramString1, paramString2, localBundle, (Bundle)localObject2);
      return paramString1;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      return "{'r': -105, 'msg' : 'httpRequest:IOException'}";
    }
    catch (ClientProtocolException paramString1)
    {
      paramString1.printStackTrace();
      return "{'r': -104, 'msg' : 'httpRequest:ClientProtocolException'}";
    }
  }
  
  public void isFollowUin(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append("{ret:-3, response:");
      paramString1.append(localJSONObject.toString());
      paramString1.append("}");
      callJs(paramString2, new String[] { paramString1.toString() });
      return;
    }
    Object localObject = this.mRuntime.b();
    if (localObject == null) {
      return;
    }
    try
    {
      paramString1 = new JSONObject(paramString1).optString("uin");
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      if (((localObject instanceof BrowserAppInterface)) || (localObject.getClass().getSimpleName().equalsIgnoreCase("ReadInJoyInterfaceProxy"))) {
        break label230;
      }
      localObject = (IPublicAccountDataManager)((AppInterface)localObject).getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject == null) {
        break label303;
      }
      bool = ((IPublicAccountDataManager)localObject).isFollowedUin(Long.valueOf(paramString1));
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        continue;
        boolean bool = false;
      }
    }
    localJSONObject.put("follow", bool);
    paramString1 = new StringBuilder();
    paramString1.append("{ret:0, response:");
    paramString1.append(localJSONObject.toString());
    paramString1.append("}");
    callJs(paramString2, new String[] { paramString1.toString() });
    return;
    label230:
    ThreadManager.executeOnSubThread(new PublicAccountJavascriptInterfaceImpl.18(this, (AppInterface)localObject, paramString1, localJSONObject, paramString2));
    return;
    paramString1 = new StringBuilder();
    paramString1.append("{ret:-2, response:");
    paramString1.append(localJSONObject.toString());
    paramString1.append("}");
    callJs(paramString2, new String[] { paramString1.toString() });
  }
  
  public void officalAccountShareRichMsg2QQ(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        String str3 = ((JSONObject)localObject).getString("oaUin");
        String str4 = ((JSONObject)localObject).getString("title");
        String str5 = ((JSONObject)localObject).getString("summary");
        String str6 = ((JSONObject)localObject).getString("targetUrl");
        boolean bool = ((JSONObject)localObject).has("imageUrl");
        if (bool)
        {
          paramString = ((JSONObject)localObject).getString("imageUrl");
          if (!((JSONObject)localObject).has("sourceName")) {
            break label263;
          }
          str1 = ((JSONObject)localObject).getString("sourceName");
          if (!((JSONObject)localObject).has("needback")) {
            break label270;
          }
          str2 = ((JSONObject)localObject).getString("needback");
          if (!((JSONObject)localObject).has("callback")) {
            break label278;
          }
          localObject = ((JSONObject)localObject).getString("callback");
          WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.d());
          if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebShareInterface))) {
            ((WebUiUtils.WebShareInterface)localWebUiBaseInterface).shareStructMsgForH5(str3, str4, str5, str6, paramString, str1, str2, (String)localObject);
          }
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_30", "share_click", 0, 0, str3, "", "", "");
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d(getClass().getSimpleName(), 2, paramString.getMessage());
        }
        return;
      }
      paramString = "";
      continue;
      label263:
      String str1 = "";
      continue;
      label270:
      String str2 = "false";
      continue;
      label278:
      Object localObject = "";
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.context = this.mRuntime.d();
    this.taskList = new ArrayList();
    if (sH5DataUsage == 0L) {
      ThreadManager.executeOnNetWorkThread(new PublicAccountJavascriptInterfaceImpl.1(this));
    }
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.d());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))) {
      this.uiMethodInterface = ((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.d());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebviewReportSpeedInterface))) {
      this.reportSpeedInterface = ((WebUiUtils.WebviewReportSpeedInterface)localWebUiBaseInterface);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.taskList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublicAccountJavascriptInterfaceImpl.HttpTask localHttpTask = (PublicAccountJavascriptInterfaceImpl.HttpTask)((Iterator)localObject).next();
      if (!localHttpTask.isCancelled()) {
        localHttpTask.cancel(true);
      }
    }
    this.taskList.clear();
    this.taskList = null;
    if (this.isRegisteredBroadCast) {
      this.context.unregisterReceiver(this.mBroadcastReceiver);
    }
    localObject = this.mDialog;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      this.mDialog.dismiss();
    }
    super.onDestroy();
  }
  
  public void open(String paramString)
  {
    if ("com.tencent.mobileqq.activity.ChatBubbleSettingActivity".equals(paramString))
    {
      paramString = this.context;
      VasWebviewUtil.b(paramString, IndividuationUrlHelper.a(paramString, "bubble", ""), 64L, null, false, -1);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(this.context, paramString));
    this.context.startActivity(localIntent);
  }
  
  public void openAccountPageMore(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openAccountPageMore->paramStr:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      if (paramString != null)
      {
        long l = paramString.getLong("puin");
        if (this.context != null)
        {
          paramString = new ActivityURIRequest(this.context, "/pubaccount/detail");
          localObject = paramString.extra();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(l);
          ((Bundle)localObject).putString("uin", localStringBuilder.toString());
          paramString.extra().putBoolean("from_js", true);
          QRoute.startUri(paramString, null);
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openAccountPageMore->error:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void openEmoji()
  {
    AppInterface localAppInterface = this.mRuntime.b();
    if (localAppInterface == null) {
      return;
    }
    EmojiHomeUiPlugin.openEmojiHomePage(this.context, localAppInterface.getAccount(), 2);
  }
  
  public void openInExternalBrowser(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openInExternalBrowser:");
      localStringBuilder.append(paramString);
      QLog.i("PAjs", 2, localStringBuilder.toString());
    }
    if (paramString != null) {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    }
    try
    {
      Thread.sleep(200L);
      this.context.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException|Exception paramString) {}
  }
  
  public void openUrl(String paramString)
  {
    if (paramString != null)
    {
      Object localObject1 = this.context.getIntent();
      Object localObject2 = this.context;
      localObject2 = new Intent((Context)localObject2, localObject2.getClass());
      localObject1 = ((Intent)localObject1).getExtras();
      if (localObject1 == null)
      {
        localObject1 = new Bundle();
      }
      else
      {
        ((Bundle)localObject1).remove("title");
        ((Bundle)localObject1).remove("leftViewText");
        ((Bundle)localObject1).remove("post_data");
        ((Bundle)localObject1).remove("options");
      }
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtra("url", paramString);
      ((Intent)localObject2).setFlags(0);
      this.context.startActivityForResult((Intent)localObject2, 100);
    }
  }
  
  /* Error */
  protected void readData(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 181	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4: invokevirtual 186	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   7: astore 9
    //   9: aload 9
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: new 256	org/json/JSONObject
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 267	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   23: astore 10
    //   25: aload 10
    //   27: ldc_w 728
    //   30: invokevirtual 731	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 5
    //   35: aload 5
    //   37: astore_1
    //   38: aload 5
    //   40: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +24 -> 67
    //   46: aload 5
    //   48: ldc_w 733
    //   51: ldc_w 735
    //   54: invokevirtual 739	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   57: ldc_w 741
    //   60: ldc_w 743
    //   63: invokevirtual 739	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   66: astore_1
    //   67: aload_3
    //   68: ldc_w 728
    //   71: aload_1
    //   72: invokevirtual 297	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   75: pop
    //   76: aload 10
    //   78: ldc_w 756
    //   81: invokevirtual 731	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 11
    //   86: aload 11
    //   88: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifeq +53 -> 144
    //   94: new 76	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   101: astore_1
    //   102: aload_1
    //   103: ldc_w 758
    //   106: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_1
    //   111: aload_3
    //   112: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   115: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_1
    //   120: ldc_w 760
    //   123: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_0
    //   128: aload_2
    //   129: iconst_1
    //   130: anewarray 207	java/lang/String
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: aastore
    //   140: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   143: return
    //   144: aconst_null
    //   145: astore 7
    //   147: aconst_null
    //   148: astore 6
    //   150: aconst_null
    //   151: astore 5
    //   153: new 386	java/net/URL
    //   156: dup
    //   157: aload 4
    //   159: invokespecial 387	java/net/URL:<init>	(Ljava/lang/String;)V
    //   162: invokevirtual 771	java/net/URL:getHost	()Ljava/lang/String;
    //   165: astore 4
    //   167: goto +6 -> 173
    //   170: aconst_null
    //   171: astore 4
    //   173: aload 10
    //   175: ldc_w 773
    //   178: invokevirtual 731	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   181: astore 8
    //   183: aload 4
    //   185: astore_1
    //   186: aload 8
    //   188: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +69 -> 260
    //   194: aload 8
    //   196: aload 4
    //   198: invokestatic 775	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:isParentDomain	(Ljava/lang/String;Ljava/lang/String;)Z
    //   201: ifeq +9 -> 210
    //   204: aload 8
    //   206: astore_1
    //   207: goto +53 -> 260
    //   210: new 76	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   217: astore_1
    //   218: aload_1
    //   219: ldc_w 777
    //   222: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_1
    //   227: aload_3
    //   228: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   231: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_1
    //   236: ldc_w 760
    //   239: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload_0
    //   244: aload_2
    //   245: iconst_1
    //   246: anewarray 207	java/lang/String
    //   249: dup
    //   250: iconst_0
    //   251: aload_1
    //   252: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: aastore
    //   256: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   259: return
    //   260: aload_1
    //   261: astore 4
    //   263: aload_1
    //   264: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   267: ifeq +8 -> 275
    //   270: ldc_w 779
    //   273: astore 4
    //   275: aload 10
    //   277: ldc_w 762
    //   280: invokevirtual 731	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   283: astore_1
    //   284: aload_1
    //   285: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   288: ifeq +53 -> 341
    //   291: new 76	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   298: astore_1
    //   299: aload_1
    //   300: ldc_w 764
    //   303: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_1
    //   308: aload_3
    //   309: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   312: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_1
    //   317: ldc_w 760
    //   320: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload_0
    //   325: aload_2
    //   326: iconst_1
    //   327: anewarray 207	java/lang/String
    //   330: dup
    //   331: iconst_0
    //   332: aload_1
    //   333: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: aastore
    //   337: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   340: return
    //   341: aload_0
    //   342: aload 4
    //   344: aload 11
    //   346: aload_1
    //   347: invokespecial 1565	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:readHash	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   350: astore 8
    //   352: aload 8
    //   354: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   357: ifeq +53 -> 410
    //   360: new 76	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   367: astore_1
    //   368: aload_1
    //   369: ldc_w 1567
    //   372: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_1
    //   377: aload_3
    //   378: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   381: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_1
    //   386: ldc_w 760
    //   389: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload_0
    //   394: aload_2
    //   395: iconst_1
    //   396: anewarray 207	java/lang/String
    //   399: dup
    //   400: iconst_0
    //   401: aload_1
    //   402: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: aastore
    //   406: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   409: return
    //   410: new 76	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   417: astore 10
    //   419: aload 10
    //   421: getstatic 102	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:PUBACCOUNT_DATA_PATH	Ljava/lang/String;
    //   424: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 10
    //   430: ldc_w 789
    //   433: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 10
    //   439: aload 9
    //   441: invokevirtual 191	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   444: invokestatic 792	com/tencent/mobileqq/utils/HexUtil:string2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   447: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload 10
    //   453: ldc_w 789
    //   456: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 10
    //   462: aload 4
    //   464: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 10
    //   470: ldc_w 789
    //   473: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 10
    //   479: aload 11
    //   481: invokestatic 792	com/tencent/mobileqq/utils/HexUtil:string2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   484: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload 10
    //   490: ldc_w 789
    //   493: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload 10
    //   499: aload_1
    //   500: invokestatic 792	com/tencent/mobileqq/utils/HexUtil:string2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   503: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: new 447	java/io/File
    //   510: dup
    //   511: aload 10
    //   513: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokespecial 448	java/io/File:<init>	(Ljava/lang/String;)V
    //   519: astore 9
    //   521: aload 9
    //   523: invokevirtual 451	java/io/File:exists	()Z
    //   526: ifne +53 -> 579
    //   529: new 76	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   536: astore_1
    //   537: aload_1
    //   538: ldc_w 1567
    //   541: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload_1
    //   546: aload_3
    //   547: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   550: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload_1
    //   555: ldc_w 760
    //   558: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload_0
    //   563: aload_2
    //   564: iconst_1
    //   565: anewarray 207	java/lang/String
    //   568: dup
    //   569: iconst_0
    //   570: aload_1
    //   571: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: aastore
    //   575: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   578: return
    //   579: aload 7
    //   581: astore_1
    //   582: aload 6
    //   584: astore 4
    //   586: aload_0
    //   587: monitorenter
    //   588: new 1569	java/io/FileInputStream
    //   591: dup
    //   592: aload 9
    //   594: invokespecial 1570	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   597: astore_1
    //   598: aload 9
    //   600: invokevirtual 468	java/io/File:length	()J
    //   603: l2i
    //   604: newarray byte
    //   606: astore 4
    //   608: aload_1
    //   609: aload 4
    //   611: invokevirtual 410	java/io/InputStream:read	([B)I
    //   614: pop
    //   615: aload_0
    //   616: new 207	java/lang/String
    //   619: dup
    //   620: aload 4
    //   622: invokespecial 265	java/lang/String:<init>	([B)V
    //   625: aload 8
    //   627: invokespecial 1572	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:decrypt	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   630: astore 4
    //   632: aload 4
    //   634: ifnonnull +70 -> 704
    //   637: new 76	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   644: astore 4
    //   646: aload 4
    //   648: ldc_w 1567
    //   651: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload 4
    //   657: aload_3
    //   658: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   661: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: pop
    //   665: aload 4
    //   667: ldc_w 760
    //   670: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload_0
    //   675: aload_2
    //   676: iconst_1
    //   677: anewarray 207	java/lang/String
    //   680: dup
    //   681: iconst_0
    //   682: aload 4
    //   684: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: aastore
    //   688: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   691: aload_0
    //   692: monitorexit
    //   693: aload_1
    //   694: invokevirtual 411	java/io/InputStream:close	()V
    //   697: return
    //   698: astore_1
    //   699: aload_1
    //   700: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   703: return
    //   704: aload_3
    //   705: ldc_w 766
    //   708: aload 4
    //   710: ldc_w 733
    //   713: ldc_w 735
    //   716: invokevirtual 739	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   719: ldc_w 741
    //   722: ldc_w 743
    //   725: invokevirtual 739	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   728: invokevirtual 297	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   731: pop
    //   732: aload_0
    //   733: monitorexit
    //   734: new 76	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   741: astore 4
    //   743: aload 4
    //   745: ldc_w 810
    //   748: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: aload 4
    //   754: aload_3
    //   755: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   758: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload 4
    //   764: ldc_w 760
    //   767: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: aload_0
    //   772: aload_2
    //   773: iconst_1
    //   774: anewarray 207	java/lang/String
    //   777: dup
    //   778: iconst_0
    //   779: aload 4
    //   781: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: aastore
    //   785: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   788: aload_1
    //   789: invokevirtual 411	java/io/InputStream:close	()V
    //   792: return
    //   793: astore_1
    //   794: aload_1
    //   795: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   798: return
    //   799: astore 4
    //   801: goto +120 -> 921
    //   804: aload_1
    //   805: astore 4
    //   807: goto +34 -> 841
    //   810: astore 6
    //   812: aload_1
    //   813: astore 4
    //   815: goto +9 -> 824
    //   818: astore 6
    //   820: aload 5
    //   822: astore 4
    //   824: aload 4
    //   826: astore 5
    //   828: aload_0
    //   829: monitorexit
    //   830: aload 4
    //   832: astore_1
    //   833: aload 6
    //   835: athrow
    //   836: astore 4
    //   838: goto +83 -> 921
    //   841: aload 4
    //   843: astore_1
    //   844: new 76	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   851: astore 5
    //   853: aload 4
    //   855: astore_1
    //   856: aload 5
    //   858: ldc_w 813
    //   861: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: aload 4
    //   867: astore_1
    //   868: aload 5
    //   870: aload_3
    //   871: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   874: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: pop
    //   878: aload 4
    //   880: astore_1
    //   881: aload 5
    //   883: ldc_w 760
    //   886: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload 4
    //   892: astore_1
    //   893: aload_0
    //   894: aload_2
    //   895: iconst_1
    //   896: anewarray 207	java/lang/String
    //   899: dup
    //   900: iconst_0
    //   901: aload 5
    //   903: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   906: aastore
    //   907: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   910: aload 4
    //   912: ifnull +77 -> 989
    //   915: aload 4
    //   917: invokevirtual 411	java/io/InputStream:close	()V
    //   920: return
    //   921: aload_1
    //   922: ifnull +15 -> 937
    //   925: aload_1
    //   926: invokevirtual 411	java/io/InputStream:close	()V
    //   929: goto +8 -> 937
    //   932: astore_1
    //   933: aload_1
    //   934: invokevirtual 435	java/io/IOException:printStackTrace	()V
    //   937: aload 4
    //   939: athrow
    //   940: new 76	java/lang/StringBuilder
    //   943: dup
    //   944: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   947: astore_1
    //   948: aload_1
    //   949: ldc_w 815
    //   952: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: pop
    //   956: aload_1
    //   957: aload_3
    //   958: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   961: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: pop
    //   965: aload_1
    //   966: ldc_w 760
    //   969: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: pop
    //   973: aload_0
    //   974: aload_2
    //   975: iconst_1
    //   976: anewarray 207	java/lang/String
    //   979: dup
    //   980: iconst_0
    //   981: aload_1
    //   982: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: aastore
    //   986: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   989: return
    //   990: astore_1
    //   991: goto -51 -> 940
    //   994: astore_1
    //   995: goto -825 -> 170
    //   998: astore_1
    //   999: goto -158 -> 841
    //   1002: astore 4
    //   1004: goto -200 -> 804
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1007	0	this	PublicAccountJavascriptInterfaceImpl
    //   0	1007	1	paramString1	String
    //   0	1007	2	paramString2	String
    //   0	1007	3	paramJSONObject	JSONObject
    //   0	1007	4	paramString3	String
    //   33	869	5	localObject1	Object
    //   148	435	6	localObject2	Object
    //   810	1	6	localObject3	Object
    //   818	16	6	localObject4	Object
    //   145	435	7	localObject5	Object
    //   181	445	8	str1	String
    //   7	592	9	localObject6	Object
    //   23	489	10	localObject7	Object
    //   84	396	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   693	697	698	java/io/IOException
    //   788	792	793	java/io/IOException
    //   915	920	793	java/io/IOException
    //   734	788	799	finally
    //   598	632	810	finally
    //   637	693	810	finally
    //   704	734	810	finally
    //   588	598	818	finally
    //   828	830	818	finally
    //   586	588	836	finally
    //   833	836	836	finally
    //   844	853	836	finally
    //   856	865	836	finally
    //   868	878	836	finally
    //   881	890	836	finally
    //   893	910	836	finally
    //   925	929	932	java/io/IOException
    //   0	9	990	org/json/JSONException
    //   15	35	990	org/json/JSONException
    //   38	67	990	org/json/JSONException
    //   67	143	990	org/json/JSONException
    //   153	167	990	org/json/JSONException
    //   173	183	990	org/json/JSONException
    //   186	204	990	org/json/JSONException
    //   210	259	990	org/json/JSONException
    //   263	270	990	org/json/JSONException
    //   275	340	990	org/json/JSONException
    //   341	409	990	org/json/JSONException
    //   410	578	990	org/json/JSONException
    //   693	697	990	org/json/JSONException
    //   699	703	990	org/json/JSONException
    //   788	792	990	org/json/JSONException
    //   794	798	990	org/json/JSONException
    //   915	920	990	org/json/JSONException
    //   925	929	990	org/json/JSONException
    //   933	937	990	org/json/JSONException
    //   937	940	990	org/json/JSONException
    //   153	167	994	java/net/MalformedURLException
    //   586	588	998	java/io/IOException
    //   833	836	998	java/io/IOException
    //   734	788	1002	java/io/IOException
  }
  
  public void readH5Data(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append("{ret:-3, response:");
      paramString1.append(localJSONObject.toString());
      paramString1.append("}");
      callJs(paramString2, new String[] { paramString1.toString() });
      return;
    }
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {
      return;
    }
    new Thread(new PublicAccountJavascriptInterfaceImpl.17(this, paramString1, paramString2, localJSONObject, localCustomWebView.getUrl())).start();
  }
  
  public void setNavigationBarStyle(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    WebViewFragment localWebViewFragment = (WebViewFragment)this.mRuntime.f();
    if (localWebViewFragment != null) {
      try
      {
        int i = new JSONObject(paramString).optInt("style");
        if (i != 0)
        {
          if (i != 1) {
            return;
          }
          localWebViewFragment.getUIStyleHandler().a(true);
          return;
        }
        localWebViewFragment.getUIStyleHandler().a(false);
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setRightButton(String paramString1, String paramString2, String paramString3)
  {
    ((AbsBaseWebViewActivity)this.context).setRightButton(paramString3, paramString1, paramString2, false, 0, 0, null, null);
  }
  
  public void setScreenshotAttr(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setScreenshotAttr->paramStr:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = (SwiftBrowserScreenShotHandler)super.getBrowserComponent(64);
      paramString = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      String str;
      if ((paramString != null) && (paramString.has("title")))
      {
        str = paramString.getString("title");
        if (localObject != null) {
          ((SwiftBrowserScreenShotHandler)localObject).c(str);
        }
      }
      if ((paramString != null) && (paramString.has("shareUrl")))
      {
        str = paramString.getString("shareUrl");
        if (localObject != null) {
          ((SwiftBrowserScreenShotHandler)localObject).e(str);
        }
      }
      if ((paramString != null) && (paramString.has("sinaShareTitle")))
      {
        str = paramString.getString("sinaShareTitle");
        if (localObject != null) {
          ((SwiftBrowserScreenShotHandler)localObject).d(str);
        }
      }
      if ((paramString != null) && (paramString.has("shareActionSheetTitle")))
      {
        paramString = paramString.optJSONArray("shareActionSheetTitle");
        if (localObject != null)
        {
          ((SwiftBrowserScreenShotHandler)localObject).a(paramString);
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setScreenshotAttr->error:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  @Deprecated
  public void showDialog(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    boolean bool1 = "true".equals(paramString3);
    boolean bool2 = "true".equals(paramString4);
    paramString3 = DialogUtil.a(this.context, 0);
    paramString3.setTitle(paramString1);
    paramString3.setMessage(paramString2);
    paramString1 = new PublicAccountJavascriptInterfaceImpl.11(this, paramString6, paramString5);
    if (bool2) {
      paramString3.setNegativeButton(HardCodeUtil.a(2131898212), paramString1);
    }
    if (bool1) {
      paramString3.setPositiveButton(HardCodeUtil.a(2131899883), paramString1);
    }
    try
    {
      paramString3.show();
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void showLoading()
  {
    Object localObject = this.mRuntime.a(this.mRuntime.d());
    if ((localObject != null) && ((localObject instanceof WebUiUtils.WebProgressInterface)))
    {
      ((WebUiUtils.WebProgressInterface)localObject).b();
      return;
    }
    localObject = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
    if ((localObject != null) && (((SwiftBrowserUIStyleHandler)localObject).B != null)) {
      ((SwiftBrowserUIStyleHandler)localObject).B.setVisibility(0);
    }
  }
  
  public void showProfile(String paramString)
  {
    if (excuteShowProfile(this.mRuntime.b(), this.context, paramString) == 1)
    {
      paramString = new IntentFilter();
      paramString.addAction("start_recomend_page");
      this.context.registerReceiver(this.mBroadcastReceiver, paramString);
      this.isRegisteredBroadCast = true;
    }
  }
  
  public void startMultiShare(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startMultiShare->paramStr:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      JSONObject localJSONObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      localObject = "";
      paramString = (String)localObject;
      if (localJSONObject != null)
      {
        paramString = (String)localObject;
        if (localJSONObject.has("image_url")) {
          paramString = localJSONObject.getString("image_url");
        }
      }
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localJSONObject != null)
      {
        bool1 = bool2;
        if (localJSONObject.has("isGif")) {
          bool1 = localJSONObject.getBoolean("isGif");
        }
      }
      localObject = (SwiftBrowserScreenShotHandler)super.getBrowserComponent(64);
      if (localObject != null)
      {
        ((SwiftBrowserScreenShotHandler)localObject).a(paramString, bool1);
        return;
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startMultiShare->error:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void viewAccount(String paramString)
  {
    viewAccount(paramString, "false");
  }
  
  public void viewAccount(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    AppInterface localAppInterface = this.mRuntime.b();
    if (localAppInterface == null) {
      return;
    }
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      localObject = ((BrowserAppInterface)localAppInterface).getEntityManagerFactory(null).createEntityManager();
      if (localObject != null)
      {
        localObject = (PublicAccountInfo)((EntityManager)localObject).find(PublicAccountInfo.class, "uin = ?", new String[] { paramString1 });
        break label108;
      }
    }
    else
    {
      localObject = (IPublicAccountDataManager)localAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null)
      {
        localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfo(paramString1);
        break label108;
      }
    }
    Object localObject = null;
    label108:
    Activity localActivity2 = this.context;
    Activity localActivity1 = localActivity2;
    if ((localActivity2 instanceof BasePluginActivity)) {
      localActivity1 = ((BasePluginActivity)localActivity2).getOutActivity();
    }
    if (((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isHealthUin(paramString1))
    {
      paramString1 = (IQQHealthService)localAppInterface.getRuntimeService(IQQHealthService.class, "");
      if (paramString1 != null) {
        paramString1.redirectAIOToMainPageInPA(this.context);
      }
      return;
    }
    if ((localObject != null) && ("true".equals(paramString2)))
    {
      paramString2 = new Intent(localActivity1, ChatActivity.class);
      paramString2.putExtra("uin", paramString1);
      paramString2.putExtra("uintype", 1008);
      paramString2.putExtra("uinname", ((PublicAccountInfo)localObject).name);
      localActivity1.startActivity(paramString2);
    }
    else
    {
      paramString2 = new ActivityURIRequest(localActivity1, "/pubaccount/detail");
      paramString2.extra().putString("uin", paramString1);
      paramString2.extra().putString("report_src_param_type", "");
      paramString2.extra().putString("report_src_param_name", "");
      paramString2.extra().putBoolean("fromBrowser", true);
      paramString2.setFlags(67108864);
      QRoute.startUri(paramString2, null);
    }
    PublicAccountHandlerImpl.reportClickPublicAccountEventInner(localAppInterface, paramString1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
  }
  
  public void viewAccount(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func viewAccount(****), sopType:");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(",sopName:");
      ((StringBuilder)localObject).append(paramString4);
      QLog.d("PAjs", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    AppInterface localAppInterface = this.mRuntime.b();
    if (localAppInterface == null) {
      return;
    }
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      localObject = ((BrowserAppInterface)localAppInterface).getEntityManagerFactory(null).createEntityManager();
      if (localObject != null)
      {
        localObject = (PublicAccountInfo)((EntityManager)localObject).find(PublicAccountInfo.class, "uin = ?", new String[] { paramString1 });
        break label176;
      }
    }
    else
    {
      localObject = (IPublicAccountDataManager)localAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null)
      {
        localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfo(paramString1);
        break label176;
      }
    }
    Object localObject = null;
    label176:
    Activity localActivity2 = this.context;
    Activity localActivity1 = localActivity2;
    if (localActivity2.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity")) {
      localActivity1 = ((PluginBaseActivity)this.context).getOutActivity();
    }
    if ((localObject != null) && ("true".equals(paramString2)))
    {
      paramString2 = new Intent(localActivity1, ChatActivity.class);
      paramString2.putExtra("uin", paramString1);
      paramString2.putExtra("uintype", 1008);
      paramString2.putExtra("uinname", ((PublicAccountInfo)localObject).name);
      localActivity1.startActivity(paramString2);
    }
    else
    {
      paramString2 = new ActivityURIRequest(localActivity1, "/pubaccount/detail");
      paramString2.extra().putString("uin", paramString1);
      paramString2.extra().putString("report_src_param_type", paramString3);
      paramString2.extra().putString("report_src_param_name", paramString4);
      QRoute.startUri(paramString2, null);
    }
    PublicAccountHandlerImpl.reportClickPublicAccountEventInner(localAppInterface, paramString1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
  }
  
  public void viewTroopBarAccount(String paramString)
  {
    viewAccount(paramString);
  }
  
  protected void writeData(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new PublicAccountJavascriptInterfaceImpl.14(this, paramString1, paramString2, paramJSONObject));
      return;
    }
    writeDataInMainThread(paramString1, paramString2, paramJSONObject);
  }
  
  public void writeH5Data(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append("{ret:-3, response:");
      paramString1.append(localJSONObject.toString());
      paramString1.append("}");
      callJs(paramString2, new String[] { paramString1.toString() });
      return;
    }
    ThreadManager.post(new PublicAccountJavascriptInterfaceImpl.13(this, paramString1, paramString2, localJSONObject), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */