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
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 3000L;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 0;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = true;
  private boolean p = false;
  private boolean q = false;
  
  public static ServiceAccountFolderConfBean a()
  {
    ServiceAccountFolderConfBean localServiceAccountFolderConfBean = new ServiceAccountFolderConfBean();
    localServiceAccountFolderConfBean.jdField_a_of_type_JavaLangString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderName();
    localServiceAccountFolderConfBean.jdField_b_of_type_JavaLangString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon();
    localServiceAccountFolderConfBean.jdField_b_of_type_Boolean = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isServiceAccountFolderDelete();
    localServiceAccountFolderConfBean.jdField_c_of_type_Boolean = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isClearAllPublicAccountFolderRedNumber();
    localServiceAccountFolderConfBean.jdField_a_of_type_Boolean = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isServiceFolderRedSpots();
    localServiceAccountFolderConfBean.jdField_d_of_type_Boolean = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreload();
    localServiceAccountFolderConfBean.jdField_e_of_type_Boolean = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreloadWifi();
    localServiceAccountFolderConfBean.jdField_f_of_type_Boolean = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreload4G();
    localServiceAccountFolderConfBean.jdField_g_of_type_Boolean = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreload3G();
    localServiceAccountFolderConfBean.jdField_h_of_type_Boolean = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsPreload2G();
    localServiceAccountFolderConfBean.jdField_i_of_type_Boolean = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isNeedPABottomBar();
    localServiceAccountFolderConfBean.j = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyFeedsImagePreload();
    localServiceAccountFolderConfBean.jdField_c_of_type_JavaLangString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyflingLToRHost();
    localServiceAccountFolderConfBean.jdField_a_of_type_Long = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyADBackgroundShowTime();
    localServiceAccountFolderConfBean.k = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyIpConnect();
    localServiceAccountFolderConfBean.jdField_a_of_type_Int = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyIpConnectReportSwitch();
    localServiceAccountFolderConfBean.jdField_d_of_type_JavaLangString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyIpConnectReportTail();
    localServiceAccountFolderConfBean.l = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyLoadImg();
    localServiceAccountFolderConfBean.m = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceFolderRedDelete();
    localServiceAccountFolderConfBean.n = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isDisableBigDataChannel();
    localServiceAccountFolderConfBean.jdField_a_of_type_JavaUtilArrayList = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getBigDataChannelWhiteList();
    localServiceAccountFolderConfBean.jdField_b_of_type_Int = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getImageCollectionPreload();
    localServiceAccountFolderConfBean.jdField_c_of_type_Int = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getImageCollectionPreloadCover();
    localServiceAccountFolderConfBean.jdField_d_of_type_Int = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getImageCollectionPreloadImage();
    localServiceAccountFolderConfBean.o = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isPreloadToolProcess();
    Object localObject = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyPreloadToolConfig();
    localServiceAccountFolderConfBean.jdField_e_of_type_JavaLangString = ((String)localObject);
    localServiceAccountFolderConfBean.jdField_f_of_type_JavaLangString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadInJoyReleaseWebServiceConfig();
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
        this.jdField_a_of_type_JavaLangString = paramServiceAccountFolderConfBean.jdField_a_of_type_JavaLangString;
      }
      if (paramString.has("service_folder_icon")) {
        this.jdField_b_of_type_JavaLangString = paramServiceAccountFolderConfBean.jdField_b_of_type_JavaLangString;
      }
      if (paramString.has("service_folder_redspots")) {
        this.jdField_a_of_type_Boolean = paramServiceAccountFolderConfBean.jdField_a_of_type_Boolean;
      }
      if (paramString.has("service_folder_delete")) {
        this.jdField_b_of_type_Boolean = paramServiceAccountFolderConfBean.jdField_b_of_type_Boolean;
      }
      if (paramString.has("ServiceFolder_RedClean_After_Enter")) {
        this.jdField_c_of_type_Boolean = paramServiceAccountFolderConfBean.jdField_c_of_type_Boolean;
      }
      if (paramString.has("readInJoy_feeds_preload")) {
        this.jdField_d_of_type_Boolean = paramServiceAccountFolderConfBean.jdField_d_of_type_Boolean;
      }
      if (paramString.has("readInJoy_feeds_preload_wifi")) {
        this.jdField_e_of_type_Boolean = paramServiceAccountFolderConfBean.jdField_e_of_type_Boolean;
      }
      if (paramString.has("readInJoy_feeds_preload_4G")) {
        this.jdField_f_of_type_Boolean = paramServiceAccountFolderConfBean.jdField_f_of_type_Boolean;
      }
      if (paramString.has("readInJoy_feeds_preload_3G")) {
        this.jdField_g_of_type_Boolean = paramServiceAccountFolderConfBean.jdField_g_of_type_Boolean;
      }
      if (paramString.has("readInJoy_feeds_preload_2G")) {
        this.jdField_h_of_type_Boolean = paramServiceAccountFolderConfBean.jdField_h_of_type_Boolean;
      }
      if (paramString.has("pub_account_bottom_bar")) {
        this.jdField_i_of_type_Boolean = paramServiceAccountFolderConfBean.jdField_i_of_type_Boolean;
      }
      if (paramString.has("readInJoy_feeds_image_preload")) {
        this.j = paramServiceAccountFolderConfBean.j;
      }
      if (paramString.has("kandian_feeds_fling_LToR_host")) {
        this.jdField_c_of_type_JavaLangString = paramServiceAccountFolderConfBean.jdField_c_of_type_JavaLangString;
      }
      if (paramString.has("kandian_ad_background_showtime")) {
        this.jdField_a_of_type_Long = paramServiceAccountFolderConfBean.jdField_a_of_type_Long;
      }
      if (paramString.has("readInJoy_ip_connect")) {
        this.k = paramServiceAccountFolderConfBean.k;
      }
      if ((paramString.has("readInJoy_ip_connect_full_report")) && (paramString.has("readInJoy_ip_connect_report_tail")))
      {
        this.jdField_a_of_type_Int = paramServiceAccountFolderConfBean.jdField_a_of_type_Int;
        this.jdField_d_of_type_JavaLangString = paramServiceAccountFolderConfBean.jdField_d_of_type_JavaLangString;
      }
      if (paramString.has("readInJoy_load_img")) {
        this.l = paramServiceAccountFolderConfBean.l;
      }
      if (paramString.has("service_account_folder_redspots_delete")) {
        this.m = paramServiceAccountFolderConfBean.m;
      }
      int i1 = 0;
      if (paramString.has("disable_big_data_channel"))
      {
        this.n = paramServiceAccountFolderConfBean.n;
        i1 = 1;
      }
      if ((i1 != 0) && (paramString.has("host_white_list"))) {
        this.jdField_a_of_type_JavaUtilArrayList = paramServiceAccountFolderConfBean.jdField_a_of_type_JavaUtilArrayList;
      }
      if (paramString.has("album_predown_enable")) {
        this.jdField_b_of_type_Int = paramServiceAccountFolderConfBean.jdField_b_of_type_Int;
      }
      if (paramString.has("album_predown_photo_rule")) {
        this.jdField_c_of_type_Int = paramServiceAccountFolderConfBean.jdField_c_of_type_Int;
      }
      if (paramString.has("album_predown_slide_photocounts")) {
        this.jdField_d_of_type_Int = paramServiceAccountFolderConfBean.jdField_d_of_type_Int;
      }
      if (paramString.has("preload_tool_process")) {
        this.o = paramServiceAccountFolderConfBean.o;
      }
      if (paramString.has("useNewLogic"))
      {
        this.jdField_e_of_type_JavaLangString = paramServiceAccountFolderConfBean.jdField_e_of_type_JavaLangString;
        this.p = paramServiceAccountFolderConfBean.p;
        this.jdField_e_of_type_Int = paramServiceAccountFolderConfBean.jdField_e_of_type_Int;
        this.jdField_f_of_type_Int = paramServiceAccountFolderConfBean.jdField_f_of_type_Int;
        this.jdField_g_of_type_Int = paramServiceAccountFolderConfBean.jdField_g_of_type_Int;
        this.jdField_h_of_type_Int = paramServiceAccountFolderConfBean.jdField_h_of_type_Int;
      }
      if (paramString.has("releaseServiceMinMem"))
      {
        this.jdField_f_of_type_JavaLangString = paramServiceAccountFolderConfBean.jdField_f_of_type_JavaLangString;
        this.jdField_i_of_type_Int = paramServiceAccountFolderConfBean.jdField_i_of_type_Int;
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
          String str = paramArrayOfQConfItem[i1].jdField_a_of_type_JavaLangString;
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
    paramServiceAccountFolderConfBean.jdField_i_of_type_Int = paramJSONObject.optInt("releaseServiceMinMem", 80);
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
    paramServiceAccountFolderConfBean.p = paramJSONObject.optBoolean("useNewLogic", false);
    paramServiceAccountFolderConfBean.jdField_e_of_type_Int = paramJSONObject.optInt("minTotalMem", 1024);
    paramServiceAccountFolderConfBean.jdField_f_of_type_Int = paramJSONObject.optInt("minAvailableMem", 100);
    paramServiceAccountFolderConfBean.jdField_g_of_type_Int = paramJSONObject.optInt("minCpuNum", 2);
    paramServiceAccountFolderConfBean.jdField_h_of_type_Int = paramJSONObject.optInt("minCpuFreq", 1000);
  }
  
  public void a()
  {
    a(this.q);
  }
  
  public void a(String paramString)
  {
    boolean bool;
    Object localObject1;
    label151:
    label221:
    int i4;
    label290:
    label360:
    label500:
    int i1;
    label430:
    label570:
    label712:
    label856:
    label1006:
    label1267:
    int i17;
    label640:
    label784:
    label931:
    label1081:
    label1339:
    int i19;
    label1195:
    label1463:
    int i18;
    label1411:
    label1543:
    label1615:
    label1759:
    label1898:
    int i2;
    label1687:
    label1831:
    label1965:
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
        break label2110;
      }
      localObject1 = localJSONObject.getString("service_folder_name");
      if (localJSONObject.has("service_folder_icon")) {
        localObject2 = localJSONObject.getString("service_folder_icon");
      }
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break label2122;
      }
      this.jdField_a_of_type_JavaLangString = ((String)localObject1);
      this.jdField_b_of_type_JavaLangString = ((String)localObject2);
      if (!QLog.isColorLevel()) {
        break label2117;
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
      this.jdField_a_of_type_Boolean = localJSONObject.getBoolean("service_folder_redspots");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_redspots:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2127;
        if (!localJSONObject.has("service_folder_delete")) {
          break label2139;
        }
        bool = localJSONObject.getBoolean("service_folder_delete");
        this.jdField_b_of_type_Boolean = bool;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_delete:");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("ServiceAccountFolderConfProcessor", 1, ((StringBuilder)localObject1).toString());
        i4 = 1;
        if (!localJSONObject.has("ServiceFolder_RedClean_After_Enter")) {
          break label2151;
        }
        this.jdField_c_of_type_Boolean = localJSONObject.getBoolean("ServiceFolder_RedClean_After_Enter");
        if (!QLog.isColorLevel()) {
          break label2145;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ServiceFolder_RedClean_After_Enter = ");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Boolean);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2145;
        if (!localJSONObject.has("readInJoy_feeds_preload")) {
          break label2163;
        }
        this.jdField_d_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload");
        if (!QLog.isColorLevel()) {
          break label2157;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload:");
        ((StringBuilder)localObject1).append(this.jdField_d_of_type_Boolean);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2157;
        if (!localJSONObject.has("readInJoy_feeds_preload_wifi")) {
          break label2175;
        }
        this.jdField_e_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_wifi");
        if (!QLog.isColorLevel()) {
          break label2169;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload wifi:");
        ((StringBuilder)localObject1).append(this.jdField_e_of_type_Boolean);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2169;
        if (!localJSONObject.has("readInJoy_feeds_preload_4G")) {
          break label2187;
        }
        this.jdField_f_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_4G");
        if (!QLog.isColorLevel()) {
          break label2181;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload 4G:");
        ((StringBuilder)localObject1).append(this.jdField_f_of_type_Boolean);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2181;
        if (!localJSONObject.has("readInJoy_feeds_preload_3G")) {
          break label2199;
        }
        this.jdField_g_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_3G");
        if (!QLog.isColorLevel()) {
          break label2193;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload 3G:");
        ((StringBuilder)localObject1).append(this.jdField_g_of_type_Boolean);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2193;
        if (!localJSONObject.has("readInJoy_feeds_preload_2G")) {
          break label2211;
        }
        this.jdField_h_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_2G");
        if (!QLog.isColorLevel()) {
          break label2205;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload 2G:");
        ((StringBuilder)localObject1).append(this.jdField_h_of_type_Boolean);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2205;
        if (!localJSONObject.has("pub_account_bottom_bar")) {
          break label2223;
        }
        this.jdField_i_of_type_Boolean = localJSONObject.getBoolean("pub_account_bottom_bar");
        if (!QLog.isColorLevel()) {
          break label2217;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("needPABottomBar: ");
        ((StringBuilder)localObject1).append(this.jdField_i_of_type_Boolean);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2217;
        if (!localJSONObject.has("readInJoy_feeds_image_preload")) {
          break label2235;
        }
        this.j = localJSONObject.getBoolean("readInJoy_feeds_image_preload");
        if (!QLog.isColorLevel()) {
          break label2229;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds image preload");
        ((StringBuilder)localObject1).append(this.j);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2229;
        if (!localJSONObject.has("kandian_feeds_fling_LToR_host")) {
          break label2246;
        }
        this.jdField_c_of_type_JavaLangString = localJSONObject.optJSONArray("kandian_feeds_fling_LToR_host").toString();
        if (!QLog.isColorLevel()) {
          break label2241;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("kandian_feeds_fling_LToR_host");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2241;
        if (!localJSONObject.has("kandian_ad_background_showtime")) {
          break label2257;
        }
        this.jdField_a_of_type_Long = localJSONObject.optLong("kandian_ad_background_showtime", 3000L);
        if (!QLog.isColorLevel()) {
          break label2251;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("kandian_ad_background_showtime");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2251;
        i24 = i1;
        if (!localJSONObject.has("readInJoy_ip_connect")) {
          break label2268;
        }
        this.k = localJSONObject.getBoolean("readInJoy_ip_connect");
        if (!QLog.isColorLevel()) {
          break label2263;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy_ip_connect:");
        ((StringBuilder)localObject1).append(this.k);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2263;
        if ((!localJSONObject.has("readInJoy_ip_connect_full_report")) || (!localJSONObject.has("readInJoy_ip_connect_report_tail"))) {
          break label2279;
        }
        this.jdField_a_of_type_Int = localJSONObject.getInt("readInJoy_ip_connect_full_report");
        this.jdField_d_of_type_JavaLangString = localJSONObject.getString("readInJoy_ip_connect_report_tail");
        if (!QLog.isColorLevel()) {
          break label2273;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy_ip_connect_full_report:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(", readInJoy_ip_connect_report_tail:");
        ((StringBuilder)localObject1).append(this.jdField_d_of_type_JavaLangString);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2273;
        if (!localJSONObject.has("readInJoy_load_img")) {
          break label2291;
        }
        this.l = localJSONObject.getBoolean("readInJoy_load_img");
        if (!QLog.isColorLevel()) {
          break label2285;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoyLoadImg:");
        ((StringBuilder)localObject1).append(this.l);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2285;
        if (!localJSONObject.has("service_account_folder_redspots_delete")) {
          break label2303;
        }
        this.m = localJSONObject.getBoolean("service_account_folder_redspots_delete");
        if (!QLog.isColorLevel()) {
          break label2297;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("service_account_folder_redspots_delete:");
        ((StringBuilder)localObject1).append(this.m);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2297;
        if (!localJSONObject.has("disable_big_data_channel")) {
          break label2315;
        }
        this.n = localJSONObject.getBoolean("disable_big_data_channel");
        if (!QLog.isColorLevel()) {
          break label2309;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("disable big data channel is ");
        ((StringBuilder)localObject1).append(this.n);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2309;
        if ((i17 == 0) || (!localJSONObject.has("host_white_list"))) {
          break label2336;
        }
        localObject1 = localJSONObject.optJSONArray("host_white_list");
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        if (localObject1 == null) {
          break label2330;
        }
        i19 = 0;
        i18 = i1;
        if (i19 < ((JSONArray)localObject1).length())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(((JSONArray)localObject1).getString(i19));
          if (!QLog.isColorLevel()) {
            break label2321;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" big data channel white host is ");
          ((StringBuilder)localObject2).append(((JSONArray)localObject1).getString(i19));
          QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject2).toString());
          break label2321;
        }
        if (!localJSONObject.has("album_predown_enable")) {
          break label2347;
        }
        this.jdField_b_of_type_Int = localJSONObject.getInt("album_predown_enable");
        if (!QLog.isColorLevel()) {
          break label2342;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("imageCollectionPreloadEnable is ");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2342;
        if (!localJSONObject.has("album_predown_photo_rule")) {
          break label2358;
        }
        this.jdField_c_of_type_Int = localJSONObject.getInt("album_predown_photo_rule");
        if (!QLog.isColorLevel()) {
          break label2352;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("imageCollectionPreloadCoverEnable is ");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Int);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2352;
        if (!localJSONObject.has("album_predown_slide_photocounts")) {
          break label2370;
        }
        this.jdField_d_of_type_Int = localJSONObject.getInt("album_predown_slide_photocounts");
        if (!QLog.isColorLevel()) {
          break label2364;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("imageCollectionPreloadImageEnable is ");
        ((StringBuilder)localObject1).append(this.jdField_d_of_type_Int);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2364;
        if (!localJSONObject.has("preload_tool_process")) {
          break label2382;
        }
        this.o = localJSONObject.getBoolean("preload_tool_process");
        if (!QLog.isColorLevel()) {
          break label2376;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("preload tool progress is ");
        ((StringBuilder)localObject1).append(this.o);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2376;
        if (!localJSONObject.has("useNewLogic")) {
          break label2394;
        }
        this.jdField_e_of_type_JavaLangString = paramString;
        b(this, localJSONObject);
        if (!QLog.isColorLevel()) {
          break label2388;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("read in joy preload tool progress config is ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2388;
        if (!localJSONObject.has("releaseServiceMinMem")) {
          break label2406;
        }
        this.jdField_f_of_type_JavaLangString = paramString;
        a(this, localJSONObject);
        if (!QLog.isColorLevel()) {
          break label2400;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("release web service config is ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("ServiceAccountFolderConfProcessor", 2, ((StringBuilder)localObject1).toString());
        break label2400;
        b();
        if ((i2 != 0) || (i3 != 0) || (i4 != 0) || (i6 != 0) || (i7 != 0) || (i8 != 0) || (i9 != 0) || (i10 != 0) || (i11 != 0) || (i12 != 0) || (i18 != 0) || (i14 != 0) || (i15 != 0) || (i16 != 0) || (i17 != 0) || (i1 != 0) || (i19 != 0) || (i20 != 0) || (i21 != 0) || (i24 != 0) || (i22 != 0) || (i13 != 0) || (i23 != 0)) {
          break label2418;
        }
        if (i5 == 0) {
          break label2412;
        }
        break label2418;
      }
    }
    for (;;)
    {
      this.q = bool;
      return;
      label2110:
      localObject1 = "";
      break;
      label2117:
      i2 = 1;
      break label151;
      label2122:
      i2 = 0;
      break label151;
      label2127:
      i3 = 1;
      break label221;
      i3 = 0;
      break label221;
      label2139:
      i4 = 0;
      break label290;
      label2145:
      i5 = 1;
      break label360;
      label2151:
      i5 = 0;
      break label360;
      label2157:
      i6 = 1;
      break label430;
      label2163:
      i6 = 0;
      break label430;
      label2169:
      i7 = 1;
      break label500;
      label2175:
      i7 = 0;
      break label500;
      label2181:
      i8 = 1;
      break label570;
      label2187:
      i8 = 0;
      break label570;
      label2193:
      i9 = 1;
      break label640;
      label2199:
      i9 = 0;
      break label640;
      label2205:
      i10 = 1;
      break label712;
      label2211:
      i10 = 0;
      break label712;
      label2217:
      i11 = 1;
      break label784;
      label2223:
      i11 = 0;
      break label784;
      label2229:
      i12 = 1;
      break label856;
      label2235:
      i12 = 0;
      break label856;
      label2241:
      i1 = 1;
      break label931;
      label2246:
      i1 = 0;
      break label931;
      label2251:
      i13 = 1;
      break label1006;
      label2257:
      i13 = 0;
      break label1006;
      label2263:
      i1 = 1;
      break label1081;
      label2268:
      i1 = 0;
      break label1081;
      label2273:
      i14 = 1;
      break label1195;
      label2279:
      i14 = 0;
      break label1195;
      label2285:
      i15 = 1;
      break label1267;
      label2291:
      i15 = 0;
      break label1267;
      label2297:
      i16 = 1;
      break label1339;
      label2303:
      i16 = 0;
      break label1339;
      label2309:
      i17 = 1;
      break label1411;
      label2315:
      i17 = 0;
      break label1411;
      label2321:
      i19 += 1;
      break label1463;
      label2330:
      i18 = i1;
      break label1543;
      label2336:
      i18 = i1;
      break label1543;
      label2342:
      i1 = 1;
      break label1615;
      label2347:
      i1 = 0;
      break label1615;
      label2352:
      i19 = 1;
      break label1687;
      label2358:
      i19 = 0;
      break label1687;
      label2364:
      i20 = 1;
      break label1759;
      label2370:
      i20 = 0;
      break label1759;
      label2376:
      i21 = 1;
      break label1831;
      label2382:
      i21 = 0;
      break label1831;
      label2388:
      i22 = 1;
      break label1898;
      label2394:
      i22 = 0;
      break label1898;
      label2400:
      i23 = 1;
      break label1965;
      label2406:
      i23 = 0;
      break label1965;
      label2412:
      bool = false;
      continue;
      label2418:
      bool = true;
    }
  }
  
  public void b()
  {
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceAccountFolderName(this.jdField_a_of_type_JavaLangString);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceAccountFolderIcon(this.jdField_b_of_type_JavaLangString);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderDelete(this.jdField_b_of_type_Boolean);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderRedCleanAfterEnter(this.jdField_c_of_type_Boolean);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderRedSpots(this.jdField_a_of_type_Boolean);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreload(this.jdField_d_of_type_Boolean);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreloadWifi(this.jdField_e_of_type_Boolean);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreload4G(this.jdField_f_of_type_Boolean);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreload3G(this.jdField_g_of_type_Boolean);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsPreload2G(this.jdField_h_of_type_Boolean);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setNeedPABottomBar(this.jdField_i_of_type_Boolean);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyFeedsImagePreload(this.j);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyflingLToRHost(this.jdField_c_of_type_JavaLangString);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyADBackgroundShowTime(this.jdField_a_of_type_Long);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyIpConnect(this.k);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyIpConnectReportSwitch(this.jdField_a_of_type_Int);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyIpConnectReportTail(this.jdField_d_of_type_JavaLangString);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyLoadImg(this.l);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderRedDelete(this.m);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setDisableBigDataChannel(this.n);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setBigDataChannelWhiteList(this.jdField_a_of_type_JavaUtilArrayList);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setImageCollectionPreload(this.jdField_b_of_type_Int);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setImageCollectionPreloadCover(this.jdField_c_of_type_Int);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setImageCollectionPreloadImage(this.jdField_d_of_type_Int);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setPreloadToolProcess(this.o);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyPreloadToolConfig(this.jdField_e_of_type_JavaLangString);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setReadInJoyReleaseWebServiceConfig(this.jdField_f_of_type_JavaLangString);
  }
  
  public void c()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).updateServiceAccountFolderConfigData((AppInterface)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.conf.ServiceAccountFolderConfBean
 * JD-Core Version:    0.7.0.1
 */