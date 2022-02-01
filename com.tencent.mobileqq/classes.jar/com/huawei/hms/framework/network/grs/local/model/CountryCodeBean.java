package com.huawei.hms.framework.network.grs.local.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.SystemPropUtils;
import java.util.Locale;

public class CountryCodeBean
{
  private static final String ANDRIOD_SYSTEMPROP = "android.os.SystemProperties";
  private static final int COUNTRYCODE_SIZE = 2;
  private static final String LOCALE_COUNTRYSYSTEMPROP = "ro.product.locale.region";
  private static final String SPECIAL_COUNTRYCODE_CN = "cn";
  private static final String SPECIAL_COUNTRYCODE_EU = "eu";
  private static final String SPECIAL_COUNTRYCODE_LA = "la";
  private static final String TAG = CountryCodeBean.class.getSimpleName();
  private static final String VENDORCOUNTRY_SYSTEMPROP = "ro.hw.country";
  private String countryCode = "UNKNOWN";
  private String countrySource = "UNKNOWN";
  
  public CountryCodeBean(Context paramContext, boolean paramBoolean)
  {
    init(paramContext, paramBoolean);
    this.countryCode = this.countryCode.toUpperCase(Locale.ENGLISH);
  }
  
  private void checkCodeLenth()
  {
    if ((this.countryCode == null) || (this.countryCode.length() != 2))
    {
      this.countryCode = "UNKNOWN";
      this.countrySource = "UNKNOWN";
    }
  }
  
  private void getLocaleCountryCode()
  {
    this.countryCode = SystemPropUtils.getProperty("get", "ro.product.locale.region", "android.os.SystemProperties", "UNKNOWN");
    this.countrySource = "LOCALE_INFO";
    if (!"cn".equalsIgnoreCase(this.countryCode))
    {
      Logger.w(TAG, "countryCode from system language is not reliable.");
      this.countryCode = "UNKNOWN";
      this.countrySource = "UNKNOWN";
    }
  }
  
  private void getSimCountryCode(Context paramContext, boolean paramBoolean)
  {
    paramContext = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
    if (paramContext != null)
    {
      if ((!paramBoolean) || (paramContext.getPhoneType() == 2)) {
        break label65;
      }
      Logger.v(TAG, "getCountryCode get country code from {%s}", new Object[] { "NETWORK_COUNTRY" });
      this.countryCode = paramContext.getNetworkCountryIso();
    }
    for (this.countrySource = "NETWORK_COUNTRY";; this.countrySource = "SIM_COUNTRY")
    {
      checkCodeLenth();
      return;
      label65:
      Logger.v(TAG, "getCountryCode get country code from {%s}", new Object[] { "SIM_COUNTRY" });
      this.countryCode = paramContext.getSimCountryIso();
    }
  }
  
  private void getVendorCountryCode()
  {
    this.countrySource = "VENDOR_COUNTRY";
    this.countryCode = SystemPropUtils.getProperty("get", "ro.hw.country", "android.os.SystemProperties", "UNKNOWN");
    if (("eu".equalsIgnoreCase(this.countryCode)) || ("la".equalsIgnoreCase(this.countryCode)))
    {
      this.countryCode = "UNKNOWN";
      this.countrySource = "UNKNOWN";
      return;
    }
    checkCodeLenth();
  }
  
  private void init(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      throw new NullPointerException("context must be not null.Please provide app's Context");
    }
    try
    {
      getVendorCountryCode();
      if (isCodeValidate())
      {
        Logger.v(TAG, "getCountryCode get country code from {%s}", new Object[] { "VENDOR_COUNTRY" });
        return;
      }
      getSimCountryCode(paramContext, paramBoolean);
      if (isCodeValidate())
      {
        Logger.v(TAG, "getCountryCode get country code from {%s}", new Object[] { "SIM_COUNTRY" });
        return;
      }
    }
    catch (Exception paramContext)
    {
      Logger.w(TAG, "get CountryCode error");
      return;
    }
    getLocaleCountryCode();
    if (isCodeValidate()) {
      Logger.v(TAG, "getCountryCode get country code from {%s}", new Object[] { "LOCALE_INFO" });
    }
  }
  
  private boolean isCodeValidate()
  {
    return !"UNKNOWN".equals(this.countryCode);
  }
  
  public String getCountryCode()
  {
    return this.countryCode;
  }
  
  public String getCountrySource()
  {
    return this.countrySource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.local.model.CountryCodeBean
 * JD-Core Version:    0.7.0.1
 */