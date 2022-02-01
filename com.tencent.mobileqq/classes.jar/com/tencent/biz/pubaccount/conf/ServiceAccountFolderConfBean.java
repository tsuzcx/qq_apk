package com.tencent.biz.pubaccount.conf;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
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
import mqq.app.AppRuntime;
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
    localServiceAccountFolderConfBean.jdField_a_of_type_JavaLangString = PublicAccountConfigUtilImpl.SERVICE_ACCOUNT_FOLDER_NAME;
    localServiceAccountFolderConfBean.jdField_b_of_type_JavaLangString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon();
    localServiceAccountFolderConfBean.jdField_b_of_type_Boolean = PublicAccountConfigUtilImpl.SERVICE_ACCOUNT_FOLDER_DELETE;
    localServiceAccountFolderConfBean.jdField_c_of_type_Boolean = PublicAccountConfigUtilImpl.ServiceFolder_RedClean_After_Enter;
    localServiceAccountFolderConfBean.jdField_a_of_type_Boolean = PublicAccountConfigUtilImpl.SERVICE_FOLDER_REDSPOTS;
    localServiceAccountFolderConfBean.jdField_d_of_type_Boolean = PublicAccountConfigUtilImpl.readInJoyFeedsPreload;
    localServiceAccountFolderConfBean.jdField_e_of_type_Boolean = PublicAccountConfigUtilImpl.readInJoyFeedsPreloadWifi;
    localServiceAccountFolderConfBean.jdField_f_of_type_Boolean = PublicAccountConfigUtilImpl.readInJoyFeedsPreload4G;
    localServiceAccountFolderConfBean.jdField_g_of_type_Boolean = PublicAccountConfigUtilImpl.readInJoyFeedsPreload3G;
    localServiceAccountFolderConfBean.jdField_h_of_type_Boolean = PublicAccountConfigUtilImpl.readInJoyFeedsPreload2G;
    localServiceAccountFolderConfBean.jdField_i_of_type_Boolean = PublicAccountConfigUtilImpl.needPABottomBar;
    localServiceAccountFolderConfBean.j = PublicAccountConfigUtilImpl.readInJoyFeedsImagePreload;
    localServiceAccountFolderConfBean.jdField_c_of_type_JavaLangString = PublicAccountConfigUtilImpl.readInJoyflingLToRHost;
    localServiceAccountFolderConfBean.jdField_a_of_type_Long = PublicAccountConfigUtilImpl.readInJoyADBackgroundShowTime;
    localServiceAccountFolderConfBean.k = PublicAccountConfigUtilImpl.readInJoyIpConnect;
    localServiceAccountFolderConfBean.jdField_a_of_type_Int = PublicAccountConfigUtilImpl.readInJoyIpConnectReportSwitch;
    localServiceAccountFolderConfBean.jdField_d_of_type_JavaLangString = PublicAccountConfigUtilImpl.readInJoyIpConnectReportTail;
    localServiceAccountFolderConfBean.l = PublicAccountConfigUtilImpl.readInJoyLoadImg;
    localServiceAccountFolderConfBean.m = PublicAccountConfigUtilImpl.SERVICE_FOLDER_RED_DELETE;
    localServiceAccountFolderConfBean.n = PublicAccountConfigUtilImpl.disableBigDataChannel;
    localServiceAccountFolderConfBean.jdField_a_of_type_JavaUtilArrayList = PublicAccountConfigUtilImpl.bigDataChannelWhiteList;
    localServiceAccountFolderConfBean.jdField_b_of_type_Int = PublicAccountConfigUtilImpl.imageCollectionPreload;
    localServiceAccountFolderConfBean.jdField_c_of_type_Int = PublicAccountConfigUtilImpl.imageCollectionPreloadCover;
    localServiceAccountFolderConfBean.jdField_d_of_type_Int = PublicAccountConfigUtilImpl.imageCollectionPreloadImage;
    localServiceAccountFolderConfBean.o = PublicAccountConfigUtilImpl.preloadToolProcess;
    Object localObject = PublicAccountConfigUtilImpl.readInJoyPreloadToolConfig;
    localServiceAccountFolderConfBean.jdField_e_of_type_JavaLangString = ((String)localObject);
    localServiceAccountFolderConfBean.jdField_f_of_type_JavaLangString = PublicAccountConfigUtilImpl.readInJoyReleaseWebServiceConfig;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("useNewLogic")) {
          b(localServiceAccountFolderConfBean, (JSONObject)localObject);
        }
        if (((JSONObject)localObject).has("releaseServiceMinMem")) {
          a(localServiceAccountFolderConfBean, (JSONObject)localObject);
        }
      }
      return localServiceAccountFolderConfBean;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localServiceAccountFolderConfBean;
  }
  
  private ServiceAccountFolderConfBean a(ServiceAccountFolderConfBean paramServiceAccountFolderConfBean, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return this;
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
    }
    return this;
  }
  
  public static ServiceAccountFolderConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject1 = new ServiceAccountFolderConfBean();
    Object localObject2 = localObject1;
    label96:
    Object localObject3;
    if (paramArrayOfQConfItem != null)
    {
      localObject2 = localObject1;
      if (paramArrayOfQConfItem.length > 0)
      {
        int i1 = 0;
        String str;
        for (;;)
        {
          if (i1 >= paramArrayOfQConfItem.length) {
            break label96;
          }
          str = paramArrayOfQConfItem[i1].jdField_a_of_type_JavaLangString;
          try
          {
            localObject2 = ((ServiceAccountFolderConfBean)localObject1).a((ServiceAccountFolderConfBean)QStorage.a(str, ServiceAccountFolderConfBean.class), str);
            localObject1 = localObject2;
          }
          catch (QStorageInstantiateException localQStorageInstantiateException)
          {
            for (;;)
            {
              QLog.i("ServiceAccountFolderConfProcessor", 1, "loadConfig l :" + str, localQStorageInstantiateException);
            }
          }
          i1 += 1;
        }
        localObject3 = localObject1;
      }
    }
    return localObject3;
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
    Object localObject;
    String str;
    label48:
    label124:
    boolean bool;
    label184:
    int i3;
    label240:
    label1012:
    int i18;
    label300:
    label360:
    label1136:
    int i19;
    label420:
    label480:
    label1250:
    label1379:
    int i24;
    label540:
    label600:
    label1503:
    int i1;
    label660:
    label722:
    label852:
    label1622:
    int i2;
    label787:
    label1074:
    int i5;
    label914:
    label1198:
    int i6;
    label1441:
    int i7;
    label1565:
    int i8;
    label1682:
    int i9;
    int i10;
    int i11;
    int i14;
    int i15;
    int i16;
    int i17;
    int i20;
    int i21;
    int i22;
    int i12;
    int i23;
    int i13;
    int i4;
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (!localJSONObject.has("service_folder_name")) {
        break label2078;
      }
      localObject = localJSONObject.getString("service_folder_name");
      if (!localJSONObject.has("service_folder_icon")) {
        break label2085;
      }
      str = localJSONObject.getString("service_folder_icon");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str))) {
        break label1964;
      }
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_b_of_type_JavaLangString = str;
      if (!QLog.isColorLevel()) {
        break label1969;
      }
      QLog.d("ServiceAccountFolderConfProcessor", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData SERVICE_ACCOUNT_FOLDER_NAME:" + (String)localObject + " SERVICE_ACCOUNT_FOLDER_ICON:" + str);
    }
    catch (JSONException paramString)
    {
      JSONObject localJSONObject;
      QLog.e("ServiceAccountFolderConfProcessor", 1, "handleFlashChatConfig failed", paramString);
      return;
    }
    if (localJSONObject.has("service_folder_redspots"))
    {
      this.jdField_a_of_type_Boolean = localJSONObject.getBoolean("service_folder_redspots");
      if (!QLog.isColorLevel()) {
        break label1974;
      }
      QLog.d("ServiceAccountFolderConfProcessor", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_redspots:" + this.jdField_a_of_type_Boolean);
      break label1974;
      if (localJSONObject.has("service_folder_delete"))
      {
        bool = localJSONObject.getBoolean("service_folder_delete");
        this.jdField_b_of_type_Boolean = bool;
        QLog.d("ServiceAccountFolderConfProcessor", 1, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_delete:" + bool);
        i3 = 1;
        if (localJSONObject.has("ServiceFolder_RedClean_After_Enter"))
        {
          this.jdField_c_of_type_Boolean = localJSONObject.getBoolean("ServiceFolder_RedClean_After_Enter");
          if (!QLog.isColorLevel()) {
            break label1979;
          }
          QLog.d("ServiceAccountFolderConfProcessor", 2, "ServiceFolder_RedClean_After_Enter = " + this.jdField_c_of_type_Boolean);
          break label1979;
          if (localJSONObject.has("readInJoy_feeds_preload"))
          {
            this.jdField_d_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload");
            if (!QLog.isColorLevel()) {
              break label1985;
            }
            QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload:" + this.jdField_d_of_type_Boolean);
            break label1985;
            if (localJSONObject.has("readInJoy_feeds_preload_wifi"))
            {
              this.jdField_e_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_wifi");
              if (!QLog.isColorLevel()) {
                break label1991;
              }
              QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload wifi:" + this.jdField_e_of_type_Boolean);
              break label1991;
              if (localJSONObject.has("readInJoy_feeds_preload_4G"))
              {
                this.jdField_f_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_4G");
                if (!QLog.isColorLevel()) {
                  break label1997;
                }
                QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload 4G:" + this.jdField_f_of_type_Boolean);
                break label1997;
                if (localJSONObject.has("readInJoy_feeds_preload_3G"))
                {
                  this.jdField_g_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_3G");
                  if (!QLog.isColorLevel()) {
                    break label2003;
                  }
                  QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload 3G:" + this.jdField_g_of_type_Boolean);
                  break label2003;
                  if (localJSONObject.has("readInJoy_feeds_preload_2G"))
                  {
                    this.jdField_h_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_2G");
                    if (!QLog.isColorLevel()) {
                      break label2009;
                    }
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload 2G:" + this.jdField_h_of_type_Boolean);
                    break label2009;
                    if (localJSONObject.has("pub_account_bottom_bar"))
                    {
                      this.jdField_i_of_type_Boolean = localJSONObject.getBoolean("pub_account_bottom_bar");
                      if (!QLog.isColorLevel()) {
                        break label2015;
                      }
                      QLog.d("ServiceAccountFolderConfProcessor", 2, "needPABottomBar: " + this.jdField_i_of_type_Boolean);
                      break label2015;
                      if (localJSONObject.has("readInJoy_feeds_image_preload"))
                      {
                        this.j = localJSONObject.getBoolean("readInJoy_feeds_image_preload");
                        if (!QLog.isColorLevel()) {
                          break label2021;
                        }
                        QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds image preload" + this.j);
                        break label2021;
                        if (localJSONObject.has("kandian_feeds_fling_LToR_host"))
                        {
                          this.jdField_c_of_type_JavaLangString = localJSONObject.optJSONArray("kandian_feeds_fling_LToR_host").toString();
                          if (!QLog.isColorLevel()) {
                            break label2027;
                          }
                          QLog.d("ServiceAccountFolderConfProcessor", 2, "kandian_feeds_fling_LToR_host" + this.jdField_c_of_type_JavaLangString);
                          break label2027;
                          if (localJSONObject.has("kandian_ad_background_showtime"))
                          {
                            this.jdField_a_of_type_Long = localJSONObject.optLong("kandian_ad_background_showtime", 3000L);
                            if (!QLog.isColorLevel()) {
                              break label2033;
                            }
                            QLog.d("ServiceAccountFolderConfProcessor", 2, "kandian_ad_background_showtime" + this.jdField_a_of_type_Long);
                            break label2033;
                            if (localJSONObject.has("readInJoy_ip_connect"))
                            {
                              this.k = localJSONObject.getBoolean("readInJoy_ip_connect");
                              if (!QLog.isColorLevel()) {
                                break label2039;
                              }
                              QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy_ip_connect:" + this.k);
                              break label2039;
                              if ((localJSONObject.has("readInJoy_ip_connect_full_report")) && (localJSONObject.has("readInJoy_ip_connect_report_tail")))
                              {
                                this.jdField_a_of_type_Int = localJSONObject.getInt("readInJoy_ip_connect_full_report");
                                this.jdField_d_of_type_JavaLangString = localJSONObject.getString("readInJoy_ip_connect_report_tail");
                                if (!QLog.isColorLevel()) {
                                  break label2045;
                                }
                                QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy_ip_connect_full_report:" + this.jdField_a_of_type_Int + ", readInJoy_ip_connect_report_tail:" + this.jdField_d_of_type_JavaLangString);
                                break label2045;
                                if (localJSONObject.has("readInJoy_load_img"))
                                {
                                  this.l = localJSONObject.getBoolean("readInJoy_load_img");
                                  if (!QLog.isColorLevel()) {
                                    break label2051;
                                  }
                                  QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoyLoadImg:" + this.l);
                                  break label2051;
                                  if (localJSONObject.has("service_account_folder_redspots_delete"))
                                  {
                                    this.m = localJSONObject.getBoolean("service_account_folder_redspots_delete");
                                    if (!QLog.isColorLevel()) {
                                      break label2057;
                                    }
                                    QLog.d("ServiceAccountFolderConfProcessor", 2, "service_account_folder_redspots_delete:" + this.m);
                                    break label2057;
                                    if (localJSONObject.has("disable_big_data_channel"))
                                    {
                                      this.n = localJSONObject.getBoolean("disable_big_data_channel");
                                      if (!QLog.isColorLevel()) {
                                        break label2063;
                                      }
                                      QLog.d("ServiceAccountFolderConfProcessor", 2, "disable big data channel is " + this.n);
                                      break label2063;
                                      if ((i18 != 0) && (localJSONObject.has("host_white_list")))
                                      {
                                        localObject = localJSONObject.optJSONArray("host_white_list");
                                        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                                        this.jdField_a_of_type_JavaUtilArrayList.clear();
                                        if (localObject != null)
                                        {
                                          i19 = 0;
                                          if (i19 < ((JSONArray)localObject).length())
                                          {
                                            this.jdField_a_of_type_JavaUtilArrayList.add(((JSONArray)localObject).getString(i19));
                                            if (!QLog.isColorLevel()) {
                                              break label2069;
                                            }
                                            QLog.d("ServiceAccountFolderConfProcessor", 2, " big data channel white host is " + ((JSONArray)localObject).getString(i19));
                                            break label2069;
                                          }
                                        }
                                      }
                                      if (localJSONObject.has("album_predown_enable"))
                                      {
                                        this.jdField_b_of_type_Int = localJSONObject.getInt("album_predown_enable");
                                        if (!QLog.isColorLevel()) {
                                          break label2092;
                                        }
                                        QLog.d("ServiceAccountFolderConfProcessor", 2, "imageCollectionPreloadEnable is " + this.jdField_b_of_type_Int);
                                        break label2092;
                                        if (localJSONObject.has("album_predown_photo_rule"))
                                        {
                                          this.jdField_c_of_type_Int = localJSONObject.getInt("album_predown_photo_rule");
                                          if (!QLog.isColorLevel()) {
                                            break label2098;
                                          }
                                          QLog.d("ServiceAccountFolderConfProcessor", 2, "imageCollectionPreloadCoverEnable is " + this.jdField_c_of_type_Int);
                                          break label2098;
                                          if (localJSONObject.has("album_predown_slide_photocounts"))
                                          {
                                            this.jdField_d_of_type_Int = localJSONObject.getInt("album_predown_slide_photocounts");
                                            if (!QLog.isColorLevel()) {
                                              break label2104;
                                            }
                                            QLog.d("ServiceAccountFolderConfProcessor", 2, "imageCollectionPreloadImageEnable is " + this.jdField_d_of_type_Int);
                                            break label2104;
                                            if (localJSONObject.has("preload_tool_process"))
                                            {
                                              this.o = localJSONObject.getBoolean("preload_tool_process");
                                              if (!QLog.isColorLevel()) {
                                                break label2110;
                                              }
                                              QLog.d("ServiceAccountFolderConfProcessor", 2, "preload tool progress is " + this.o);
                                              break label2110;
                                              if (localJSONObject.has("useNewLogic"))
                                              {
                                                this.jdField_e_of_type_JavaLangString = paramString;
                                                b(this, localJSONObject);
                                                if (!QLog.isColorLevel()) {
                                                  break label2116;
                                                }
                                                QLog.d("ServiceAccountFolderConfProcessor", 2, "read in joy preload tool progress config is " + paramString);
                                                break label2116;
                                                i24 = 0;
                                                if (localJSONObject.has("releaseServiceMinMem"))
                                                {
                                                  this.jdField_f_of_type_JavaLangString = paramString;
                                                  a(this, localJSONObject);
                                                  if (!QLog.isColorLevel()) {
                                                    break label2122;
                                                  }
                                                  QLog.d("ServiceAccountFolderConfProcessor", 2, "release web service config is " + paramString);
                                                  break label2122;
                                                }
                                                b();
                                                if ((i1 != 0) || (i2 != 0) || (i3 != 0) || (i5 != 0) || (i6 != 0) || (i7 != 0) || (i8 != 0) || (i9 != 0) || (i10 != 0) || (i11 != 0) || (i14 != 0) || (i15 != 0) || (i16 != 0) || (i17 != 0) || (i18 != 0) || (i19 != 0) || (i20 != 0) || (i21 != 0) || (i22 != 0) || (i12 != 0) || (i23 != 0) || (i13 != 0) || (i24 != 0)) {
                                                  break label2128;
                                                }
                                                if (i4 != 0) {
                                                  break label2128;
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
    }
    for (;;)
    {
      this.q = bool;
      return;
      bool = false;
      continue;
      i23 = 0;
      break label1622;
      i22 = 0;
      break label1565;
      i21 = 0;
      break label1503;
      i20 = 0;
      break label1441;
      i19 = 0;
      break label1379;
      i18 = 0;
      break label1198;
      i17 = 0;
      break label1136;
      i16 = 0;
      break label1074;
      i15 = 0;
      break label1012;
      i14 = 0;
      break label914;
      i13 = 0;
      break label852;
      i12 = 0;
      break label787;
      i11 = 0;
      break label722;
      i10 = 0;
      break label660;
      i9 = 0;
      break label600;
      i8 = 0;
      break label540;
      i7 = 0;
      break label480;
      i6 = 0;
      break label420;
      i5 = 0;
      break label360;
      i4 = 0;
      break label300;
      i3 = 0;
      break label240;
      i2 = 0;
      break label184;
      label1964:
      i1 = 0;
      break label124;
      label1969:
      i1 = 1;
      break label124;
      label1974:
      i2 = 1;
      break label184;
      label1979:
      i4 = 1;
      break label300;
      label1985:
      i5 = 1;
      break label360;
      label1991:
      i6 = 1;
      break label420;
      label1997:
      i7 = 1;
      break label480;
      label2003:
      i8 = 1;
      break label540;
      label2009:
      i9 = 1;
      break label600;
      label2015:
      i10 = 1;
      break label660;
      label2021:
      i11 = 1;
      break label722;
      label2027:
      i12 = 1;
      break label787;
      label2033:
      i13 = 1;
      break label852;
      label2039:
      i14 = 1;
      break label914;
      label2045:
      i15 = 1;
      break label1012;
      label2051:
      i16 = 1;
      break label1074;
      label2057:
      i17 = 1;
      break label1136;
      label2063:
      i18 = 1;
      break label1198;
      label2069:
      i19 += 1;
      break label1250;
      label2078:
      localObject = "";
      break;
      label2085:
      str = "";
      break label48;
      label2092:
      i19 = 1;
      break label1379;
      label2098:
      i20 = 1;
      break label1441;
      label2104:
      i21 = 1;
      break label1503;
      label2110:
      i22 = 1;
      break label1565;
      label2116:
      i23 = 1;
      break label1622;
      label2122:
      i24 = 1;
      break label1682;
      label2128:
      bool = true;
    }
  }
  
  public void b()
  {
    PublicAccountConfigUtilImpl.SERVICE_ACCOUNT_FOLDER_NAME = this.jdField_a_of_type_JavaLangString;
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceAccountFolderIcon(this.jdField_b_of_type_JavaLangString);
    PublicAccountConfigUtilImpl.SERVICE_ACCOUNT_FOLDER_DELETE = this.jdField_b_of_type_Boolean;
    PublicAccountConfigUtilImpl.ServiceFolder_RedClean_After_Enter = this.jdField_c_of_type_Boolean;
    PublicAccountConfigUtilImpl.SERVICE_FOLDER_REDSPOTS = this.jdField_a_of_type_Boolean;
    PublicAccountConfigUtilImpl.readInJoyFeedsPreload = this.jdField_d_of_type_Boolean;
    PublicAccountConfigUtilImpl.readInJoyFeedsPreloadWifi = this.jdField_e_of_type_Boolean;
    PublicAccountConfigUtilImpl.readInJoyFeedsPreload4G = this.jdField_f_of_type_Boolean;
    PublicAccountConfigUtilImpl.readInJoyFeedsPreload3G = this.jdField_g_of_type_Boolean;
    PublicAccountConfigUtilImpl.readInJoyFeedsPreload2G = this.jdField_h_of_type_Boolean;
    PublicAccountConfigUtilImpl.needPABottomBar = this.jdField_i_of_type_Boolean;
    PublicAccountConfigUtilImpl.readInJoyFeedsImagePreload = this.j;
    PublicAccountConfigUtilImpl.readInJoyflingLToRHost = this.jdField_c_of_type_JavaLangString;
    PublicAccountConfigUtilImpl.readInJoyADBackgroundShowTime = this.jdField_a_of_type_Long;
    PublicAccountConfigUtilImpl.readInJoyIpConnect = this.k;
    PublicAccountConfigUtilImpl.readInJoyIpConnectReportSwitch = this.jdField_a_of_type_Int;
    PublicAccountConfigUtilImpl.readInJoyIpConnectReportTail = this.jdField_d_of_type_JavaLangString;
    PublicAccountConfigUtilImpl.readInJoyLoadImg = this.l;
    PublicAccountConfigUtilImpl.SERVICE_FOLDER_RED_DELETE = this.m;
    PublicAccountConfigUtilImpl.disableBigDataChannel = this.n;
    PublicAccountConfigUtilImpl.bigDataChannelWhiteList = this.jdField_a_of_type_JavaUtilArrayList;
    PublicAccountConfigUtilImpl.imageCollectionPreload = this.jdField_b_of_type_Int;
    PublicAccountConfigUtilImpl.imageCollectionPreloadCover = this.jdField_c_of_type_Int;
    PublicAccountConfigUtilImpl.imageCollectionPreloadImage = this.jdField_d_of_type_Int;
    PublicAccountConfigUtilImpl.preloadToolProcess = this.o;
    PublicAccountConfigUtilImpl.readInJoyPreloadToolConfig = this.jdField_e_of_type_JavaLangString;
    PublicAccountConfigUtilImpl.readInJoyReleaseWebServiceConfig = this.jdField_f_of_type_JavaLangString;
  }
  
  public void c()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      PublicAccountConfigUtilImpl.updateServiceAccountFolderConfigData((QQAppInterface)localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.conf.ServiceAccountFolderConfBean
 * JD-Core Version:    0.7.0.1
 */