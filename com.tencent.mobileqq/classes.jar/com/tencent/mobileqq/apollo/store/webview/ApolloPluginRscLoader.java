package com.tencent.mobileqq.apollo.store.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.CmShowRscDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.res.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.api.res.ICmShowRscUpdateHandler;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscCacheManagerImpl;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscCacheManagerImpl.IdolRscItem;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscUpdateHandlerImpl;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscUpdateHandlerImpl.OnCheckContentListener;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloPluginRscLoader
{
  private SparseArray<CmShowRscUpdateHandlerImpl.OnCheckContentListener> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private VasWebviewJsPlugin jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin;
  
  public ApolloPluginRscLoader(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin = paramVasWebviewJsPlugin;
  }
  
  private JSONObject a(int paramInt1, String paramString, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resType", paramInt1);
      localJSONObject.put("resId", paramString);
      localJSONObject.put("resultCode", paramInt2);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloPluginRscLoader", 1, paramString, new Object[0]);
    }
    return localJSONObject;
  }
  
  private static void a(WebResourceResponse paramWebResourceResponse)
  {
    if (paramWebResourceResponse != null)
    {
      Map localMap = paramWebResourceResponse.getResponseHeaders();
      Object localObject = localMap;
      if (localMap == null) {
        localObject = new HashMap();
      }
      ((Map)localObject).put("Access-Control-Allow-Origin", "*");
      paramWebResourceResponse.setResponseHeaders((Map)localObject);
    }
  }
  
  private void a(int[] paramArrayOfInt, String paramString, JSONArray paramJSONArray)
  {
    int k = 0;
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc");
    AppInterface localAppInterface;
    ArrayList localArrayList;
    int i;
    if (paramArrayOfInt != null)
    {
      localAppInterface = this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin.mRuntime.a();
      localArrayList = new ArrayList();
      i = 0;
      int j = 0;
      if (i < paramArrayOfInt.length)
      {
        CmShowRscCacheManagerImpl.IdolRscItem localIdolRscItem = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, paramArrayOfInt[i]);
        if (localIdolRscItem == null) {
          j = 1;
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList.add(localIdolRscItem);
        }
      }
      if (j != 0)
      {
        localArrayList.clear();
        i = paramArrayOfInt.hashCode();
        paramArrayOfInt = new ApolloPluginRscLoader.3(this, i, paramArrayOfInt, localArrayList, localAppInterface, paramJSONArray, paramString);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramArrayOfInt);
        paramString = (CmShowRscUpdateHandlerImpl)QRoute.api(ICmShowRscUpdateHandler.class);
        paramString.addChecListener(i, paramArrayOfInt);
        paramString.checkCmShowContentUpdate(localAppInterface, i, true);
      }
    }
    else
    {
      return;
    }
    if (localArrayList.isEmpty())
    {
      i = k;
      while (i < paramArrayOfInt.length)
      {
        paramJSONArray.put(a(8, String.valueOf(paramArrayOfInt[i]), 2));
        i += 1;
      }
      a(paramString, HardCodeUtil.a(2131700576), paramJSONArray);
      return;
    }
    CmShowRscDownloader.a(localAppInterface, "", new ApolloPluginRscLoader.4(this, paramArrayOfInt, paramJSONArray, paramString), localArrayList, false, null);
  }
  
  private static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.contains("..")) {
      return false;
    }
    return true;
  }
  
  private byte[] a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      int j;
      String str;
      Object localObject3;
      int i;
      try
      {
        localObject1 = new File(paramString);
        if (!((File)localObject1).exists()) {
          return null;
        }
        localObject1 = ((File)localObject1).listFiles();
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          localObject2 = new ArrayList();
          int m = localObject1.length;
          k = 6;
          j = 0;
          if (j >= m) {
            break label231;
          }
          str = localObject1[j];
          localObject3 = str.getName();
          if (paramBoolean)
          {
            i = k;
            if (((String)localObject3).endsWith("face.json"))
            {
              i = (int)(k + (((String)localObject3).getBytes().length + 1 + 4 + str.length()));
              ((List)localObject2).add(localObject3);
            }
          }
          else if ((!((String)localObject3).endsWith("bin")) && (!((String)localObject3).endsWith("etc")) && (!((String)localObject3).endsWith("png")))
          {
            i = k;
            if (!((String)localObject3).endsWith("pvr")) {}
          }
          else
          {
            i = (int)(k + (((String)localObject3).getBytes().length + 1 + 4 + str.length()));
            ((List)localObject2).add(localObject3);
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloPluginRscLoader", 1, paramString, new Object[0]);
      }
      return null;
      label231:
      Object localObject1 = new ByteArrayOutputStream(k);
      ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 24 & 0xFF);
      ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 16 & 0xFF);
      ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 8 & 0xFF);
      ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 0 & 0xFF);
      ((ByteArrayOutputStream)localObject1).write((byte)paramInt2);
      ((ByteArrayOutputStream)localObject1).write((byte)((List)localObject2).size());
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        localObject3 = new File(paramString, str);
        paramInt1 = (int)((File)localObject3).length();
        byte[] arrayOfByte = FileUtils.a(((File)localObject3).getAbsolutePath());
        if (arrayOfByte != null)
        {
          ((ByteArrayOutputStream)localObject1).write((byte)str.getBytes().length);
          ((ByteArrayOutputStream)localObject1).write(str.getBytes("utf-8"));
          ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 24 & 0xFF);
          ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 16 & 0xFF);
          ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 8 & 0xFF);
          ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 0 & 0xFF);
          ((ByteArrayOutputStream)localObject1).write(arrayOfByte);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, new Object[] { "getResourceResponse name:", str, " length:" + ((File)localObject3).length() });
        }
      }
      paramString = ((ByteArrayOutputStream)localObject1).toByteArray();
      return paramString;
      j += 1;
      int k = i;
    }
  }
  
  private WebResourceResponse b(String paramString)
  {
    int i;
    Object localObject3;
    CmShowRscCacheManagerImpl.IdolRscItem localIdolRscItem;
    if (paramString.contains("https://cmshow.qq.com/3dresource/combination"))
    {
      QLog.i("ApolloPluginRscLoader", 1, "getCombination url:" + paramString);
      i = -1;
      localObject3 = null;
      localIdolRscItem = null;
    }
    for (;;)
    {
      AppInterface localAppInterface;
      Object localObject4;
      int i2;
      int i3;
      Object localObject2;
      Object localObject6;
      int k;
      String str2;
      WebResourceResponse localWebResourceResponse;
      try
      {
        localAppInterface = this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin.mRuntime.a();
        Object localObject5 = Uri.parse(paramString);
        Object localObject1;
        if (((Uri)localObject5).isHierarchical())
        {
          localObject4 = ((Uri)localObject5).getQueryParameter("roleId");
          i2 = 1;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            i = ApolloUtilImpl.parseToInt((String)localObject4);
            i2 = true & ApolloUtilImpl.checkRoleRes(i);
            QLog.d("ApolloPluginRscLoader", 1, new Object[] { "getCombination roleId:", Integer.valueOf(i), " resExsit:", Boolean.valueOf(i2) });
          }
          String str1 = ((Uri)localObject5).getQueryParameter("dressIds");
          i3 = i2;
          localObject2 = localObject4;
          localObject1 = localObject3;
          int m;
          if (!TextUtils.isEmpty(str1))
          {
            localObject4 = (String)localObject4 + str1;
            localObject6 = new JSONArray(str1);
            i3 = i2;
            localObject2 = localObject4;
            localObject1 = localObject3;
            if (localObject6 != null)
            {
              i3 = i2;
              localObject2 = localObject4;
              localObject1 = localObject3;
              if (((JSONArray)localObject6).length() > 0)
              {
                m = ((JSONArray)localObject6).length();
                localObject3 = new int[m];
                int j = 0;
                i3 = i2;
                localObject2 = localObject4;
                localObject1 = localObject3;
                if (j < m)
                {
                  localObject3[j] = ((JSONArray)localObject6).optInt(j);
                  i3 = ApolloUtilImpl.checkDressRes(localObject3[j]);
                  j += 1;
                  i2 = i3 & i2;
                  continue;
                }
              }
            }
          }
          localObject6 = ((Uri)localObject5).getQueryParameter("faceDataUrl");
          str2 = ((Uri)localObject5).getQueryParameter("callbackId");
          localObject3 = null;
          i2 = i3;
          if (!TextUtils.isEmpty((CharSequence)localObject6))
          {
            localObject3 = MD5Utils.toMD5(URLDecoder.decode((String)localObject6));
            localObject3 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/" + (String)localObject3 + File.separator + (String)localObject3 + ".zip");
            i2 = i3 & ((File)localObject3).exists();
          }
          QLog.d("ApolloPluginRscLoader", 1, new Object[] { "getCombination faceDataUrl:", localObject6, " resExsit:", Boolean.valueOf(i2) });
          String str3 = ((Uri)localObject5).getQueryParameter("roomIds");
          localObject5 = new ArrayList();
          i3 = i2;
          localObject4 = localIdolRscItem;
          if (!TextUtils.isEmpty(str3))
          {
            new StringBuilder().append((String)localObject2).append(str1).toString();
            localObject2 = new JSONArray(str3);
            i3 = i2;
            localObject4 = localIdolRscItem;
            if (localObject2 != null)
            {
              i3 = i2;
              localObject4 = localIdolRscItem;
              if (((JSONArray)localObject2).length() > 0)
              {
                int i1 = ((JSONArray)localObject2).length();
                localObject4 = new int[i1];
                k = 0;
                if (k >= i1) {
                  break label1344;
                }
                localObject4[k] = ((JSONArray)localObject2).optInt(k);
                localIdolRscItem = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, localObject4[k]);
                if ((localIdolRscItem == null) || (!localIdolRscItem.a())) {
                  break label1338;
                }
                m = 1;
                i2 &= m;
                if (localIdolRscItem == null) {
                  break label1331;
                }
                ((List)localObject5).add(localIdolRscItem);
                break label1331;
              }
            }
          }
          QLog.d("ApolloPluginRscLoader", 1, new Object[] { "getCombination roomIdStr:", str3, " resExsit:", Boolean.valueOf(i3) });
          if (i3 != 0)
          {
            localObject2 = new ByteArrayOutputStream();
            if (localObject3 != null)
            {
              localObject3 = a(0, 6, ((File)localObject3).getParent(), true);
              if (localObject3 != null) {
                ((ByteArrayOutputStream)localObject2).write((byte[])localObject3);
              }
            }
            if (i <= 0) {
              break label1351;
            }
            localObject3 = a(i, 1, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + i + File.separator, false);
            if (localObject3 == null) {
              break label1351;
            }
            ((ByteArrayOutputStream)localObject2).write((byte[])localObject3);
            break label1351;
            if (i >= localObject1.length) {
              break label1368;
            }
            k = localObject1[i];
            localObject1[i] = k;
            QLog.d("ApolloPluginRscLoader", 2, new Object[] { "getCombination dressId:", Integer.valueOf(k) });
            localObject3 = a(k, 2, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + k + File.separator, false);
            if (localObject3 == null) {
              break label1361;
            }
            ((ByteArrayOutputStream)localObject2).write((byte[])localObject3);
            break label1361;
            if (i < ((List)localObject5).size())
            {
              localObject1 = (CmShowRscCacheManagerImpl.IdolRscItem)((List)localObject5).get(i);
              localObject1 = a(((CmShowRscCacheManagerImpl.IdolRscItem)localObject1).b, 8, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/room/" + ((CmShowRscCacheManagerImpl.IdolRscItem)localObject1).b + File.separator, false);
              if (localObject1 == null) {
                break label1373;
              }
              ((ByteArrayOutputStream)localObject2).write((byte[])localObject1);
              break label1373;
            }
            localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
            QLog.d("ApolloPluginRscLoader", 1, new Object[] { "getCombination url:", paramString, " retBytes:" + localObject1.length });
            localObject1 = new WebResourceResponse("application/octet-stream", "utf-8", new ByteArrayInputStream((byte[])localObject1));
            a((WebResourceResponse)localObject1);
            return localObject1;
          }
          localObject2 = new JSONArray();
          if ((i > 0) || ((localObject1 != null) && (localObject1.length > 0))) {
            ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(localAppInterface, "", new ApolloPluginRscLoader.1(this, (JSONArray)localObject2, (File)localObject3, localAppInterface, (String)localObject6, (int[])localObject4, str2), i, (int[])localObject1, -1, -1, false);
          }
        }
        else
        {
          localObject1 = new WebResourceResponse("application/octet-stream", "utf-8", new BridgeStream(null, null, null));
          a((WebResourceResponse)localObject1);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloPluginRscLoader", 1, localException, new Object[0]);
        localWebResourceResponse = new WebResourceResponse("application/octet-stream", "utf-8", new BridgeStream(null, null, null));
        a(localWebResourceResponse);
        QLog.e("ApolloPluginRscLoader", 1, "getCombination url 解析失败:" + paramString);
        a(d(paramString), -1, HardCodeUtil.a(2131700586));
        return localWebResourceResponse;
      }
      if ((localObject3 != null) && (!((File)localObject3).exists()))
      {
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).checkDownloadFaceData(localAppInterface, (String)localObject6, new ApolloPluginRscLoader.2(this, (String)localObject6, (File)localObject3, (JSONArray)localObject2, (int[])localObject4, str2));
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)localObject6)) {
          ((JSONArray)localObject2).put(a(6, (String)localObject6, 0));
        }
        if ((localObject4 == null) || (localObject4.length <= 0))
        {
          a(str2, HardCodeUtil.a(2131700572), (JSONArray)localObject2);
        }
        else
        {
          a((int[])localObject4, str2, (JSONArray)localObject2);
          continue;
          return null;
          label1331:
          k += 1;
          continue;
          label1338:
          int n = 0;
          continue;
          label1344:
          i3 = i2;
          continue;
          label1351:
          if (localWebResourceResponse != null)
          {
            i = 0;
            continue;
            label1361:
            i += 1;
          }
          else
          {
            label1368:
            i = 0;
            continue;
            label1373:
            i += 1;
          }
        }
      }
    }
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.indexOf("/");
    if (i > 0) {
      return paramString.substring(0, i);
    }
    return "";
  }
  
  private static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    int i;
    String str;
    do
    {
      return paramString;
      i = paramString.indexOf("/");
      str = paramString;
      if (i > 0) {
        str = paramString.substring(i + 1);
      }
      i = str.indexOf("?");
      paramString = str;
    } while (i <= 0);
    return str.substring(0, i);
  }
  
  private static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = Uri.parse(paramString);
        if (paramString.isHierarchical())
        {
          paramString = paramString.getQueryParameter("callbackId");
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloPluginRscLoader", 2, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  public WebResourceResponse a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin.mRuntime == null)) {
      return null;
    }
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin.mRuntime.a();
    Object localObject3;
    do
    {
      try
      {
        paramString = paramString.replace("https://open.cmshow.qq.com", "https://cmshow.qq.com");
        localObject1 = b(paramString);
        if (localObject1 != null)
        {
          a((WebResourceResponse)localObject1);
          QLog.i("ApolloPluginRscLoader", 1, "getApolloRsc getCombination resourceUrl:" + paramString);
          return localObject1;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloPluginRscLoader", 2, paramString, new Object[0]);
        return null;
      }
      int i;
      if (paramString.startsWith("https://cmshow.qq.com/3dresource/Room/"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc resourceUrl:" + paramString);
        }
        paramString = paramString.replace("https://cmshow.qq.com/3dresource/Room/", "");
        i = ApolloUtilImpl.parseToInt(b(paramString));
        localObject1 = c(paramString);
        if ((i <= 0) || (TextUtils.isEmpty((CharSequence)localObject1)))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1 + " roomId:" + i);
          return null;
        }
        if (!a((String)localObject1))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1 + " roomId:" + i);
          return null;
        }
        localObject2 = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/room/" + i + File.separator + (String)localObject1;
        localObject1 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc path:" + (String)localObject2);
        }
        QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc start download roomId:" + i);
        localObject2 = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, i);
        if (localObject2 == null)
        {
          QLog.i("ApolloPluginRscLoader", 1, "idolRscItem == null ");
          int j = ((File)localObject1).hashCode();
          localObject2 = (CmShowRscUpdateHandlerImpl)QRoute.api(ICmShowRscUpdateHandler.class);
          ((CmShowRscUpdateHandlerImpl)localObject2).checkCmShowContentUpdate(localAppInterface, j, true);
          ((CmShowRscUpdateHandlerImpl)localObject2).addChecListener(j, new ApolloPluginRscLoader.5(this, i, paramString, localAppInterface, (File)localObject1));
        }
        for (;;)
        {
          paramString = new WebResourceResponse("application/octet-stream", "utf-8", new BridgeStream(null, null, null));
          a(paramString);
          return paramString;
          if (((CmShowRscCacheManagerImpl.IdolRscItem)localObject2).a())
          {
            if (((File)localObject1).exists())
            {
              paramString = new FileInputStream((File)localObject1);
              localObject1 = new WebResourceResponse("application/octet-stream", "utf-8", paramString);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc inputStream.available();:" + paramString.available());
              }
              a((WebResourceResponse)localObject1);
              return localObject1;
            }
            localObject1 = d(paramString);
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + paramString);
              return null;
            }
            a((String)localObject1, 1, i + HardCodeUtil.a(2131700571));
          }
          else
          {
            localObject3 = new ArrayList();
            ((List)localObject3).add(localObject2);
            CmShowRscDownloader.a(localAppInterface, "", new ApolloPluginRscLoader.6(this, paramString, (File)localObject1, i), (List)localObject3, false, null);
          }
        }
      }
      if (paramString.startsWith("https://cmshow.qq.com/3dresource/Role/"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc resourceUrl:" + paramString);
        }
        paramString = paramString.replace("https://cmshow.qq.com/3dresource/Role/", "");
        i = ApolloUtilImpl.parseToInt(b(paramString));
        localObject1 = c(paramString);
        if ((i <= 0) || (TextUtils.isEmpty((CharSequence)localObject1)))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1 + " roleId:" + i);
          return null;
        }
        if (!a((String)localObject1))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1);
          return null;
        }
        localObject2 = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + i + File.separator + (String)localObject1;
        localObject1 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc path:" + (String)localObject2);
        }
        if (((File)localObject1).exists())
        {
          paramString = new FileInputStream((File)localObject1);
          localObject1 = new WebResourceResponse("application/octet-stream", "utf-8", paramString);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc inputStream.available();:" + paramString.available());
          }
          a((WebResourceResponse)localObject1);
          return localObject1;
        }
        localObject2 = d(paramString);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + paramString);
          return null;
        }
        if (ApolloUtilImpl.checkRoleRes(i)) {
          a((String)localObject2, 1, i + HardCodeUtil.a(2131700580));
        }
        for (;;)
        {
          paramString = new WebResourceResponse("application/octet-stream", "utf-8", new BridgeStream(null, null, null));
          a(paramString);
          return paramString;
          QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc start download roleId:" + i);
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(localAppInterface, null, new ApolloPluginRscLoader.7(this, (File)localObject1, (String)localObject2), i, null, -1, -1, false);
        }
      }
      if (paramString.startsWith("https://cmshow.qq.com/3dresource/Dress/"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc resourceUrl:" + paramString);
        }
        paramString = paramString.replace("https://cmshow.qq.com/3dresource/Dress/", "");
        i = ApolloUtilImpl.parseToInt(b(paramString));
        localObject1 = c(paramString);
        if ((i <= 0) || (TextUtils.isEmpty((CharSequence)localObject1)))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1 + " dressId:" + i);
          return null;
        }
        if (!a((String)localObject1))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1);
          return null;
        }
        localObject2 = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + i + File.separator + (String)localObject1;
        localObject1 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc path:" + (String)localObject2);
        }
        if (((File)localObject1).exists())
        {
          paramString = new FileInputStream((File)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc inputStream.available();:" + paramString.available());
          }
          paramString = new WebResourceResponse("application/octet-stream", "utf-8", paramString);
          a(paramString);
          return paramString;
        }
        localObject2 = d(paramString);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + paramString);
          return null;
        }
        if (ApolloUtilImpl.checkDressRes(i)) {
          a((String)localObject2, 1, i + HardCodeUtil.a(2131700592));
        }
        for (;;)
        {
          paramString = new WebResourceResponse("application/octet-stream", "utf-8", new BridgeStream(null, null, null));
          a(paramString);
          return paramString;
          QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc start download dressId:" + i);
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(localAppInterface, null, new ApolloPluginRscLoader.8(this, i, (File)localObject1, (String)localObject2), -1, new int[] { i }, -1, -1, false);
        }
      }
      if (paramString.startsWith("https://cmshow.qq.com/3dresource/Action/"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc resourceUrl:" + paramString);
        }
        paramString = paramString.replace("https://cmshow.qq.com/3dresource/Action/", "");
        i = ApolloUtilImpl.parseToInt(b(paramString));
        localObject1 = c(paramString);
        if ((i <= 0) || (TextUtils.isEmpty((CharSequence)localObject1)))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1 + " actionId:" + i);
          return null;
        }
        if (!a((String)localObject1))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1);
          return null;
        }
        localObject2 = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/" + i + File.separator + (String)localObject1;
        localObject1 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc path:" + (String)localObject2);
        }
        if (((File)localObject1).exists())
        {
          paramString = new FileInputStream((File)localObject1);
          localObject1 = new WebResourceResponse("application/octet-stream", "utf-8", paramString);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc inputStream.available();:" + paramString.available());
          }
          a((WebResourceResponse)localObject1);
          return localObject1;
        }
        localObject2 = d(paramString);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + paramString);
          return null;
        }
        if (ApolloUtilImpl.isActionResDone(i, 0)) {
          a((String)localObject2, 1, i + HardCodeUtil.a(2131700581));
        }
        for (;;)
        {
          paramString = new WebResourceResponse("application/octet-stream", "utf-8", new BridgeStream(null, null, null));
          a(paramString);
          return paramString;
          QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc start download actionId:" + i);
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(localAppInterface, null, new ApolloPluginRscLoader.9(this, (File)localObject1, (String)localObject2), -1, null, i, -1, false);
        }
      }
    } while (!paramString.startsWith("https://cmshow.qq.com/3dresource/FaceData/"));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc resourceUrl:" + paramString);
    }
    String str4 = paramString.replace("https://cmshow.qq.com/3dresource/FaceData/", "");
    String str3 = c(str4);
    if (TextUtils.isEmpty(str3))
    {
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + str3);
      return null;
    }
    if (!a(str3))
    {
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + str3);
      return null;
    }
    Object localObject2 = null;
    paramString = null;
    Object localObject1 = localObject2;
    String str1;
    try
    {
      localObject3 = b(str4);
      paramString = (String)localObject3;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        paramString = (String)localObject3;
        localObject1 = localObject2;
        QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc faceDataUrl is null");
        return null;
      }
      paramString = (String)localObject3;
      localObject1 = localObject2;
      localObject3 = URLDecoder.decode((String)localObject3);
      paramString = (String)localObject3;
      localObject1 = localObject2;
      String str2 = MD5Utils.toMD5((String)localObject3);
      localObject2 = localObject3;
      localObject4 = str2;
      paramString = (String)localObject3;
      localObject1 = str2;
      if (QLog.isColorLevel())
      {
        paramString = (String)localObject3;
        localObject1 = str2;
        QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc faceDataUrl:" + (String)localObject3);
        localObject4 = str2;
        localObject2 = localObject3;
      }
    }
    catch (Exception localException)
    {
      Object localObject4;
      for (;;)
      {
        QLog.e("ApolloPluginRscLoader", 1, "checkDownloadFaceData e" + localException);
        str1 = paramString;
        localObject4 = localObject1;
      }
      new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/").mkdir();
      new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/").mkdir();
      paramString = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/" + (String)localObject4 + File.separator + str3;
      localObject1 = new File(paramString);
      if (!QLog.isColorLevel()) {
        break label2559;
      }
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc path:" + paramString);
      label2559:
      if (!((File)localObject1).exists()) {
        break label2676;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject4)) {
      return null;
    }
    QLog.i("ApolloPluginRscLoader", 1, "checkDownloadFaceData url data is exists:" + str4);
    if (str3.endsWith(".json")) {}
    for (paramString = "application/json";; paramString = "application/octet-stream")
    {
      localObject1 = new FileInputStream((File)localObject1);
      paramString = new WebResourceResponse(paramString, "utf-8", (InputStream)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc inputStream.available();:" + ((FileInputStream)localObject1).available());
      }
      a(paramString);
      return paramString;
      label2676:
      paramString = d(str4);
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc faceDataUrl callbackId is null");
        return null;
      }
      QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc start download faceDataUrl:" + str1);
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).checkDownloadFaceData(localAppInterface, str1, new ApolloPluginRscLoader.10(this, (File)localObject1, paramString));
      localObject1 = new BridgeStream(null, null, null);
      if (str3.endsWith(".json")) {}
      for (paramString = "application/json";; paramString = "application/octet-stream")
      {
        paramString = new WebResourceResponse(paramString, "utf-8", (InputStream)localObject1);
        a(paramString);
        return paramString;
      }
    }
  }
  
  void a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin == null) {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramInt);
      localJSONObject.put("msg", paramString2);
      this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin.callJs(paramString1 + "(" + localJSONObject.toString() + ");");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloPluginRscLoader", 2, localException.getMessage());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      QLog.i("ApolloPluginRscLoader", 2, "callbackId->" + paramString1 + " retCode:" + paramInt + " errorMsg: " + paramString2);
      return;
    }
  }
  
  void a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    int i = 0;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin == null) {
        return;
      }
      localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      localJSONObject.put("msg", paramString2);
      if (paramJSONArray == null) {
        break label97;
      }
      localJSONObject.put("IdStates", paramJSONArray);
      j = paramJSONArray.length();
    }
    catch (Exception paramString1)
    {
      JSONObject localJSONObject;
      int j;
      label97:
      while (QLog.isColorLevel())
      {
        QLog.e("ApolloPluginRscLoader", 2, paramString1.getMessage());
        return;
        i += 1;
      }
    }
    if (i < j)
    {
      paramString2 = paramJSONArray.optJSONObject(i);
      if ((paramString2 != null) && (paramString2.optInt("resultCode") != 0)) {
        localJSONObject.put("result", 2);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin.callJs(paramString1 + "(" + localJSONObject.toString() + ");");
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("ApolloPluginRscLoader", 2, "callbackIdStatesResult result:" + localJSONObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader
 * JD-Core Version:    0.7.0.1
 */