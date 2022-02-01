package com.tencent.biz.pubaccount.conf;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServiceAccountFolderConfBean
  implements IQStorageSafable<String>
{
  private boolean A = false;
  private int B = 0;
  private int C = 0;
  private int D = 0;
  private int E = 0;
  private String F = "";
  private int G = 0;
  private boolean H = false;
  private String a = "";
  private String b = "";
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private String m = "";
  private long n = 3000L;
  private boolean o = false;
  private int p = 0;
  private String q = "";
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private ArrayList<String> u = new ArrayList();
  private int v = 0;
  private int w = 0;
  private int x = 0;
  private boolean y = true;
  private String z = "";
  
  public static ServiceAccountFolderConfBean a()
  {
    ServiceAccountFolderConfBean localServiceAccountFolderConfBean = new ServiceAccountFolderConfBean();
    localServiceAccountFolderConfBean.a = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderName();
    localServiceAccountFolderConfBean.b = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon();
    localServiceAccountFolderConfBean.d = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isServiceAccountFolderDelete();
    localServiceAccountFolderConfBean.e = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isClearAllPublicAccountFolderRedNumber();
    localServiceAccountFolderConfBean.c = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isServiceFolderRedSpots();
    localServiceAccountFolderConfBean.f = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreload();
    localServiceAccountFolderConfBean.g = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreloadWifi();
    localServiceAccountFolderConfBean.h = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreload4G();
    localServiceAccountFolderConfBean.i = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreload3G();
    localServiceAccountFolderConfBean.j = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreload2G();
    localServiceAccountFolderConfBean.k = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isNeedPABottomBar();
    localServiceAccountFolderConfBean.l = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsImagePreload();
    localServiceAccountFolderConfBean.m = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyflingLToRHost();
    localServiceAccountFolderConfBean.n = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyADBackgroundShowTime();
    localServiceAccountFolderConfBean.o = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyIpConnect();
    localServiceAccountFolderConfBean.p = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyIpConnectReportSwitch();
    localServiceAccountFolderConfBean.q = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyIpConnectReportTail();
    localServiceAccountFolderConfBean.r = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyLoadImg();
    localServiceAccountFolderConfBean.s = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceFolderRedDelete();
    localServiceAccountFolderConfBean.t = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isDisableBigDataChannel();
    localServiceAccountFolderConfBean.u = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getBigDataChannelWhiteList();
    localServiceAccountFolderConfBean.v = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getImageCollectionPreload();
    localServiceAccountFolderConfBean.w = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getImageCollectionPreloadCover();
    localServiceAccountFolderConfBean.x = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getImageCollectionPreloadImage();
    localServiceAccountFolderConfBean.y = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isPreloadToolProcess();
    Object localObject = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyPreloadToolConfig();
    localServiceAccountFolderConfBean.z = ((String)localObject);
    localServiceAccountFolderConfBean.F = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyReleaseWebServiceConfig();
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("useNewLogic")) {
          b(localServiceAccountFolderConfBean, (JSONObject)localObject);
        }
        if (((JSONObject)localObject).has("releaseServiceMinMem"))
        {
          a(localServiceAccountFolderConfBean, (JSONObject)localObject);
          return localServiceAccountFolderConfBean;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localServiceAccountFolderConfBean;
  }
  
  private ServiceAccountFolderConfBean a(ServiceAccountFolderConfBean paramServiceAccountFolderConfBean, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return this;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("service_folder_name")) {
        this.a = paramServiceAccountFolderConfBean.a;
      }
      if (paramString.has("service_folder_icon")) {
        this.b = paramServiceAccountFolderConfBean.b;
      }
      if (paramString.has("service_folder_redspots")) {
        this.c = paramServiceAccountFolderConfBean.c;
      }
      if (paramString.has("service_folder_delete")) {
        this.d = paramServiceAccountFolderConfBean.d;
      }
      if (paramString.has("ServiceFolder_RedClean_After_Enter")) {
        this.e = paramServiceAccountFolderConfBean.e;
      }
      if (paramString.has("readInJoy_feeds_preload")) {
        this.f = paramServiceAccountFolderConfBean.f;
      }
      if (paramString.has("readInJoy_feeds_preload_wifi")) {
        this.g = paramServiceAccountFolderConfBean.g;
      }
      if (paramString.has("readInJoy_feeds_preload_4G")) {
        this.h = paramServiceAccountFolderConfBean.h;
      }
      if (paramString.has("readInJoy_feeds_preload_3G")) {
        this.i = paramServiceAccountFolderConfBean.i;
      }
      if (paramString.has("readInJoy_feeds_preload_2G")) {
        this.j = paramServiceAccountFolderConfBean.j;
      }
      if (paramString.has("pub_account_bottom_bar")) {
        this.k = paramServiceAccountFolderConfBean.k;
      }
      if (paramString.has("readInJoy_feeds_image_preload")) {
        this.l = paramServiceAccountFolderConfBean.l;
      }
      if (paramString.has("kandian_feeds_fling_LToR_host")) {
        this.m = paramServiceAccountFolderConfBean.m;
      }
      if (paramString.has("kandian_ad_background_showtime")) {
        this.n = paramServiceAccountFolderConfBean.n;
      }
      if (paramString.has("readInJoy_ip_connect")) {
        this.o = paramServiceAccountFolderConfBean.o;
      }
      if ((paramString.has("readInJoy_ip_connect_full_report")) && (paramString.has("readInJoy_ip_connect_report_tail")))
      {
        this.p = paramServiceAccountFolderConfBean.p;
        this.q = paramServiceAccountFolderConfBean.q;
      }
      if (paramString.has("readInJoy_load_img")) {
        this.r = paramServiceAccountFolderConfBean.r;
      }
      if (paramString.has("service_account_folder_redspots_delete")) {
        this.s = paramServiceAccountFolderConfBean.s;
      }
      int i1 = 0;
      if (paramString.has("disable_big_data_channel"))
      {
        this.t = paramServiceAccountFolderConfBean.t;
        i1 = 1;
      }
      if ((i1 != 0) && (paramString.has("host_white_list"))) {
        this.u = paramServiceAccountFolderConfBean.u;
      }
      if (paramString.has("album_predown_enable")) {
        this.v = paramServiceAccountFolderConfBean.v;
      }
      if (paramString.has("album_predown_photo_rule")) {
        this.w = paramServiceAccountFolderConfBean.w;
      }
      if (paramString.has("album_predown_slide_photocounts")) {
        this.x = paramServiceAccountFolderConfBean.x;
      }
      if (paramString.has("preload_tool_process")) {
        this.y = paramServiceAccountFolderConfBean.y;
      }
      if (paramString.has("useNewLogic"))
      {
        this.z = paramServiceAccountFolderConfBean.z;
        this.A = paramServiceAccountFolderConfBean.A;
        this.B = paramServiceAccountFolderConfBean.B;
        this.C = paramServiceAccountFolderConfBean.C;
        this.D = paramServiceAccountFolderConfBean.D;
        this.E = paramServiceAccountFolderConfBean.E;
      }
      if (paramString.has("releaseServiceMinMem"))
      {
        this.F = paramServiceAccountFolderConfBean.F;
        this.G = paramServiceAccountFolderConfBean.G;
        return this;
      }
    }
    catch (JSONException paramServiceAccountFolderConfBean)
    {
      paramServiceAccountFolderConfBean.printStackTrace();
    }
    return this;
  }
  
  public static ServiceAccountFolderConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject1 = new ServiceAccountFolderConfBean();
    Object localObject2 = localObject1;
    if (paramArrayOfQConfItem != null)
    {
      localObject2 = localObject1;
      if (paramArrayOfQConfItem.length > 0)
      {
        int i1 = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i1 >= paramArrayOfQConfItem.length) {
            break;
          }
          String str = paramArrayOfQConfItem[i1].b;
          try
          {
            localObject2 = ((ServiceAccountFolderConfBean)localObject1).a((ServiceAccountFolderConfBean)QStorage.a(str, ServiceAccountFolderConfBean.class), str);
            localObject1 = localObject2;
          }
          catch (QStorageInstantiateException localQStorageInstantiateException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("loadConfig l :");
            localStringBuilder.append(str);
            QLog.i("ServiceAccountFolderConfProcessor", 1, localStringBuilder.toString(), localQStorageInstantiateException);
          }
          i1 += 1;
        }
      }
    }
    return localQStorageInstantiateException;
  }
  
  private static void a(ServiceAccountFolderConfBean paramServiceAccountFolderConfBean, JSONObject paramJSONObject)
  {
    paramServiceAccountFolderConfBean.G = paramJSONObject.optInt("releaseServiceMinMem", 80);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendEmptyMessage(1009);
        }
      }
    }
  }
  
  private static void b(ServiceAccountFolderConfBean paramServiceAccountFolderConfBean, JSONObject paramJSONObject)
  {
    paramServiceAccountFolderConfBean.A = paramJSONObject.optBoolean("useNewLogic", false);
    paramServiceAccountFolderConfBean.B = paramJSONObject.optInt("minTotalMem", 1024);
    paramServiceAccountFolderConfBean.C = paramJSONObject.optInt("minAvailableMem", 100);
    paramServiceAccountFolderConfBean.D = paramJSONObject.optInt("minCpuNum", 2);
    paramServiceAccountFolderConfBean.E = paramJSONObject.optInt("minCpuFreq", 1000);
  }
  
  public void a(String paramString)
  {
    boolean bool;
    Object localObject1;
    label153:
    label225:
    int i4;
    label296:
    label368:
    label1022:
    int i1;
    label440:
    label584:
    label728:
    label872:
    int i17;
    label512:
    label656:
    label800:
    label947:
    label1097:
    label1355:
    int i19;
    label1211:
    label1479:
    int i18;
    label1283:
    label1427:
    label1559:
    label1631:
    label1775:
    label1914:
    int i2;
    label1703:
    label1847:
    label1981:
    int i3;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    int i14;
    int i15;
    int i16;
    int i20;
    int i21;
    int i22;
    int i13;
    int i23;
    int i5;
    try
    {
      localJSONObject = new JSONObject(paramString);
      bool = localJSONObject.has("service_folder_name");
      localObject2 = "";
      if (!bool) {
        break label2126;
      }
      localObject1 = localJSONObject.getString("service_folder_name");
      if (localJSONObject.has("service_folder_icon")) {
        localObject2 = localJSONObject.getString("service_folder_icon");
      }
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break label2138;
      }
      this.a = ((String)localObject1);
      this.b = ((String)localObject2);
      if (!QLog.isColorLevel()) {
        break label2133;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData SERVICE_ACCOUNT_FOLDER_NAME:");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" SERVICE_ACCOUNT_FOLDER_ICON:");
      localStringBuilder.append((String)localObject2);
      QLog.d("ServiceAccountFolderConfProcessor", 2, localStringBuilder.toString());
    }
    catch (JSONException paramString)
    {
      JSONObject localJSONObject;
      Object localObject2;
      int i24;
      QLog.e("ServiceAccountFolderConfProcessor", 1, "handleFlashChatConfig failed", paramString);
      return;
    }
    if (localJSONObject.has("service_folder_redspots"))
    {
      this.c = localJSONObject.getBoolean("service_folder_redspots");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_redspots:");
        ((StringBuilder)localObject1).append(this.c);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2143;
        if (!localJSONObject.has("service_folder_delete")) {
          break label2155;
        }
        bool = localJSONObject.getBoolean("service_folder_delete");
        this.d = bool;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_delete:");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("ServiceAccountFolderConfProcessor", 1, ((StringBuilder)localObject1).toString());
        i4 = 1;
        if (!localJSONObject.has("ServiceFolder_RedClean_After_Enter")) {
          break label2167;
        }
        this.e = localJSONObject.getBoolean("ServiceFolder_RedClean_After_Enter");
        if (!QLog.isColorLevel()) {
          break label2161;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ServiceFolder_RedClean_After_Enter = ");
        ((StringBuilder)localObject1).append(this.e);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2161;
        if (!localJSONObject.has("readInJoy_feeds_preload")) {
          break label2179;
        }
        this.f = localJSONObject.getBoolean("readInJoy_feeds_preload");
        if (!QLog.isColorLevel()) {
          break label2173;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload:");
        ((StringBuilder)localObject1).append(this.f);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2173;
        if (!localJSONObject.has("readInJoy_feeds_preload_wifi")) {
          break label2191;
        }
        this.g = localJSONObject.getBoolean("readInJoy_feeds_preload_wifi");
        if (!QLog.isColorLevel()) {
          break label2185;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload wifi:");
        ((StringBuilder)localObject1).append(this.g);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2185;
        if (!localJSONObject.has("readInJoy_feeds_preload_4G")) {
          break label2203;
        }
        this.h = localJSONObject.getBoolean("readInJoy_feeds_preload_4G");
        if (!QLog.isColorLevel()) {
          break label2197;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload 4G:");
        ((StringBuilder)localObject1).append(this.h);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2197;
        if (!localJSONObject.has("readInJoy_feeds_preload_3G")) {
          break label2215;
        }
        this.i = localJSONObject.getBoolean("readInJoy_feeds_preload_3G");
        if (!QLog.isColorLevel()) {
          break label2209;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload 3G:");
        ((StringBuilder)localObject1).append(this.i);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2209;
        if (!localJSONObject.has("readInJoy_feeds_preload_2G")) {
          break label2227;
        }
        this.j = localJSONObject.getBoolean("readInJoy_feeds_preload_2G");
        if (!QLog.isColorLevel()) {
          break label2221;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload 2G:");
        ((StringBuilder)localObject1).append(this.j);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2221;
        if (!localJSONObject.has("pub_account_bottom_bar")) {
          break label2239;
        }
        this.k = localJSONObject.getBoolean("pub_account_bottom_bar");
        if (!QLog.isColorLevel()) {
          break label2233;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("needPABottomBar: ");
        ((StringBuilder)localObject1).append(this.k);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2233;
        if (!localJSONObject.has("readInJoy_feeds_image_preload")) {
          break label2251;
        }
        this.l = localJSONObject.getBoolean("readInJoy_feeds_image_preload");
        if (!QLog.isColorLevel()) {
          break label2245;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds image preload");
        ((StringBuilder)localObject1).append(this.l);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2245;
        if (!localJSONObject.has("kandian_feeds_fling_LToR_host")) {
          break label2262;
        }
        this.m = localJSONObject.optJSONArray("kandian_feeds_fling_LToR_host").toString();
        if (!QLog.isColorLevel()) {
          break label2257;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("kandian_feeds_fling_LToR_host");
        ((StringBuilder)localObject1).append(this.m);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2257;
        if (!localJSONObject.has("kandian_ad_background_showtime")) {
          break label2273;
        }
        this.n = localJSONObject.optLong("kandian_ad_background_showtime", 3000L);
        if (!QLog.isColorLevel()) {
          break label2267;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("kandian_ad_background_showtime");
        ((StringBuilder)localObject1).append(this.n);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2267;
        i24 = i1;
        if (!localJSONObject.has("readInJoy_ip_connect")) {
          break label2284;
        }
        this.o = localJSONObject.getBoolean("readInJoy_ip_connect");
        if (!QLog.isColorLevel()) {
          break label2279;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy_ip_connect:");
        ((StringBuilder)localObject1).append(this.o);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2279;
        if ((!localJSONObject.has("readInJoy_ip_connect_full_report")) || (!localJSONObject.has("readInJoy_ip_connect_report_tail"))) {
          break label2295;
        }
        this.p = localJSONObject.getInt("readInJoy_ip_connect_full_report");
        this.q = localJSONObject.getString("readInJoy_ip_connect_report_tail");
        if (!QLog.isColorLevel()) {
          break label2289;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy_ip_connect_full_report:");
        ((StringBuilder)localObject1).append(this.p);
        ((StringBuilder)localObject1).append(", readInJoy_ip_connect_report_tail:");
        ((StringBuilder)localObject1).append(this.q);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2289;
        if (!localJSONObject.has("readInJoy_load_img")) {
          break label2307;
        }
        this.r = localJSONObject.getBoolean("readInJoy_load_img");
        if (!QLog.isColorLevel()) {
          break label2301;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoyLoadImg:");
        ((StringBuilder)localObject1).append(this.r);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2301;
        if (!localJSONObject.has("service_account_folder_redspots_delete")) {
          break label2319;
        }
        this.s = localJSONObject.getBoolean("service_account_folder_redspots_delete");
        if (!QLog.isColorLevel()) {
          break label2313;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("service_account_folder_redspots_delete:");
        ((StringBuilder)localObject1).append(this.s);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2313;
        if (!localJSONObject.has("disable_big_data_channel")) {
          break label2331;
        }
        this.t = localJSONObject.getBoolean("disable_big_data_channel");
        if (!QLog.isColorLevel()) {
          break label2325;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("disable big data channel is ");
        ((StringBuilder)localObject1).append(this.t);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2325;
        if ((i17 == 0) || (!localJSONObject.has("host_white_list"))) {
          break label2352;
        }
        localObject1 = localJSONObject.optJSONArray("host_white_list");
        this.u = new ArrayList();
        this.u.clear();
        if (localObject1 == null) {
          break label2346;
        }
        i19 = 0;
        i18 = i1;
        if (i19 < ((JSONArray)localObject1).length())
        {
          this.u.add(((JSONArray)localObject1).getString(i19));
          if (!QLog.isColorLevel()) {
            break label2337;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" big data channel white host is ");
          ((StringBuilder)localObject2).append(((JSONArray)localObject1).getString(i19));
          QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject2).toString());
          break label2337;
        }
        if (!localJSONObject.has("album_predown_enable")) {
          break label2363;
        }
        this.v = localJSONObject.getInt("album_predown_enable");
        if (!QLog.isColorLevel()) {
          break label2358;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("imageCollectionPreloadEnable is ");
        ((StringBuilder)localObject1).append(this.v);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2358;
        if (!localJSONObject.has("album_predown_photo_rule")) {
          break label2374;
        }
        this.w = localJSONObject.getInt("album_predown_photo_rule");
        if (!QLog.isColorLevel()) {
          break label2368;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("imageCollectionPreloadCoverEnable is ");
        ((StringBuilder)localObject1).append(this.w);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2368;
        if (!localJSONObject.has("album_predown_slide_photocounts")) {
          break label2386;
        }
        this.x = localJSONObject.getInt("album_predown_slide_photocounts");
        if (!QLog.isColorLevel()) {
          break label2380;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("imageCollectionPreloadImageEnable is ");
        ((StringBuilder)localObject1).append(this.x);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2380;
        if (!localJSONObject.has("preload_tool_process")) {
          break label2398;
        }
        this.y = localJSONObject.getBoolean("preload_tool_process");
        if (!QLog.isColorLevel()) {
          break label2392;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("preload tool progress is ");
        ((StringBuilder)localObject1).append(this.y);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2392;
        if (!localJSONObject.has("useNewLogic")) {
          break label2410;
        }
        this.z = paramString;
        b(this, localJSONObject);
        if (!QLog.isColorLevel()) {
          break label2404;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("read in joy preload tool progress config is ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2404;
        if (!localJSONObject.has("releaseServiceMinMem")) {
          break label2422;
        }
        this.F = paramString;
        a(this, localJSONObject);
        if (!QLog.isColorLevel()) {
          break label2416;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("release web service config is ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2416;
        c();
        if ((i2 != 0) || (i3 != 0) || (i4 != 0) || (i6 != 0) || (i7 != 0) || (i8 != 0) || (i9 != 0) || (i10 != 0) || (i11 != 0) || (i12 != 0) || (i18 != 0) || (i14 != 0) || (i15 != 0) || (i16 != 0) || (i17 != 0) || (i1 != 0) || (i19 != 0) || (i20 != 0) || (i21 != 0) || (i24 != 0) || (i22 != 0) || (i13 != 0) || (i23 != 0)) {
          break label2434;
        }
        if (i5 == 0) {
          break label2428;
        }
        break label2434;
      }
    }
    for (;;)
    {
      this.H = bool;
      return;
      label2126:
      localObject1 = "";
      break;
      label2133:
      i2 = 1;
      break label153;
      label2138:
      i2 = 0;
      break label153;
      label2143:
      i3 = 1;
      break label225;
      i3 = 0;
      break label225;
      label2155:
      i4 = 0;
      break label296;
      label2161:
      i5 = 1;
      break label368;
      label2167:
      i5 = 0;
      break label368;
      label2173:
      i6 = 1;
      break label440;
      label2179:
      i6 = 0;
      break label440;
      label2185:
      i7 = 1;
      break label512;
      label2191:
      i7 = 0;
      break label512;
      label2197:
      i8 = 1;
      break label584;
      label2203:
      i8 = 0;
      break label584;
      label2209:
      i9 = 1;
      break label656;
      label2215:
      i9 = 0;
      break label656;
      label2221:
      i10 = 1;
      break label728;
      label2227:
      i10 = 0;
      break label728;
      label2233:
      i11 = 1;
      break label800;
      label2239:
      i11 = 0;
      break label800;
      label2245:
      i12 = 1;
      break label872;
      label2251:
      i12 = 0;
      break label872;
      label2257:
      i1 = 1;
      break label947;
      label2262:
      i1 = 0;
      break label947;
      label2267:
      i13 = 1;
      break label1022;
      label2273:
      i13 = 0;
      break label1022;
      label2279:
      i1 = 1;
      break label1097;
      label2284:
      i1 = 0;
      break label1097;
      label2289:
      i14 = 1;
      break label1211;
      label2295:
      i14 = 0;
      break label1211;
      label2301:
      i15 = 1;
      break label1283;
      label2307:
      i15 = 0;
      break label1283;
      label2313:
      i16 = 1;
      break label1355;
      label2319:
      i16 = 0;
      break label1355;
      label2325:
      i17 = 1;
      break label1427;
      label2331:
      i17 = 0;
      break label1427;
      label2337:
      i19 += 1;
      break label1479;
      label2346:
      i18 = i1;
      break label1559;
      label2352:
      i18 = i1;
      break label1559;
      label2358:
      i1 = 1;
      break label1631;
      label2363:
      i1 = 0;
      break label1631;
      label2368:
      i19 = 1;
      break label1703;
      label2374:
      i19 = 0;
      break label1703;
      label2380:
      i20 = 1;
      break label1775;
      label2386:
      i20 = 0;
      break label1775;
      label2392:
      i21 = 1;
      break label1847;
      label2398:
      i21 = 0;
      break label1847;
      label2404:
      i22 = 1;
      break label1914;
      label2410:
      i22 = 0;
      break label1914;
      label2416:
      i23 = 1;
      break label1981;
      label2422:
      i23 = 0;
      break label1981;
      label2428:
      bool = false;
      continue;
      label2434:
      bool = true;
    }
  }
  
  public void b()
  {
    a(this.H);
  }
  
  public void c()
  {
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceAccountFolderName(this.a);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceAccountFolderIcon(this.b);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderDelete(this.d);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderRedCleanAfterEnter(this.e);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderRedSpots(this.c);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreload(this.f);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreloadWifi(this.g);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreload4G(this.h);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreload3G(this.i);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreload2G(this.j);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setNeedPABottomBar(this.k);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsImagePreload(this.l);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyflingLToRHost(this.m);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyADBackgroundShowTime(this.n);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyIpConnect(this.o);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyIpConnectReportSwitch(this.p);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyIpConnectReportTail(this.q);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyLoadImg(this.r);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderRedDelete(this.s);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setDisableBigDataChannel(this.t);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setBigDataChannelWhiteList(this.u);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setImageCollectionPreload(this.v);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setImageCollectionPreloadCover(this.w);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setImageCollectionPreloadImage(this.x);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setPreloadToolProcess(this.y);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyPreloadToolConfig(this.z);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyReleaseWebServiceConfig(this.F);
  }
  
  public void d()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).updateServiceAccountFolderConfigData((AppInterface)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.conf.ServiceAccountFolderConfBean
 * JD-Core Version:    0.7.0.1
 */