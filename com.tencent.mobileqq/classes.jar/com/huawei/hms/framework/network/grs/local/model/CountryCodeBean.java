package com.huawei.hms.framework.network.grs.local.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.SystemPropUtils;
import java.util.Locale;

public class CountryCodeBean
{
  private static final String ANDRIOD_SYSTEMPROP = "android.os.SystemProperties";
  private static final int COUNTRYCODE_SIZE = 2;
  private static final String LOCALE_COUNTRYSYSTEMPROP = "ro.product.locale";
  private static final String LOCALE_REGION_COUNTRYSYSTEMPROP = "ro.product.locale.region";
  private static final String SPECIAL_COUNTRYCODE_CN = "cn";
  private static final String SPECIAL_COUNTRYCODE_EU = "eu";
  private static final String SPECIAL_COUNTRYCODE_GB = "gb";
  private static final String SPECIAL_COUNTRYCODE_LA = "la";
  private static final String SPECIAL_COUNTRYCODE_UK = "uk";
  private static final String TAG = "CountryCodeBean";
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
    String str = this.countryCode;
    if ((str == null) || (str.length() != 2))
    {
      this.countryCode = "UNKNOWN";
      this.countrySource = "UNKNOWN";
    }
  }
  
  private void getLocaleCountryCode()
  {
    if (EmuiUtil.isUpPVersion()) {
      getRegionSettingCountryCode();
    } else {
      getProductCountryCode();
    }
    this.countrySource = "LOCALE_INFO";
  }
  
  private void getProductCountryCode()
  {
    this.countryCode = SystemPropUtils.getProperty("get", "ro.product.locale.region", "android.os.SystemProperties", "UNKNOWN");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("countryCode by ro.product.locale.region is:");
    localStringBuilder.append(this.countryCode);
    Logger.i(str, localStringBuilder.toString());
    if ((TextUtils.isEmpty(this.countryCode)) || ("UNKNOWN".equals(this.countryCode)))
    {
      str = SystemPropUtils.getProperty("get", "ro.product.locale", "android.os.SystemProperties", "UNKNOWN");
      if (!TextUtils.isEmpty(str))
      {
        int i = str.lastIndexOf("-");
        if (i != -1)
        {
          this.countryCode = str.substring(i + 1);
          str = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("countryCode by ro.product.locale is:");
          localStringBuilder.append(this.countryCode);
          Logger.i(str, localStringBuilder.toString());
        }
      }
    }
    if (!"cn".equalsIgnoreCase(this.countryCode)) {
      this.countryCode = "UNKNOWN";
    }
  }
  
  private void getRegionSettingCountryCode()
  {
    this.countryCode = Locale.getDefault().getCountry();
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("countryCode by system's region setting is: ");
    localStringBuilder.append(this.countryCode);
    Logger.i(str, localStringBuilder.toString());
    if (TextUtils.isEmpty(this.countryCode)) {
      this.countryCode = "UNKNOWN";
    }
  }
  
  private void getSimCountryCode(Context paramContext)
  {
    getSimCountryCode(paramContext, false);
  }
  
  private void getSimCountryCode(Context paramContext, boolean paramBoolean)
  {
    paramContext = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
    if (paramContext != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if ((paramBoolean) && (paramContext.getPhoneType() != 2))
      {
        this.countryCode = paramContext.getNetworkCountryIso();
        this.countrySource = "NETWORK_COUNTRY";
        str = TAG;
        localStringBuilder = new StringBuilder();
        paramContext = "countryCode by NetworkCountryIso is: ";
      }
      else
      {
        this.countryCode = paramContext.getSimCountryIso();
        this.countrySource = "SIM_COUNTRY";
        str = TAG;
        localStringBuilder = new StringBuilder();
        paramContext = "countryCode by SimCountryIso is: ";
      }
      localStringBuilder.append(paramContext);
      localStringBuilder.append(this.countryCode);
      Logger.i(str, localStringBuilder.toString());
    }
    checkCodeLenth();
  }
  
  private void getVendorCountryCode()
  {
    this.countrySource = "VENDOR_COUNTRY";
    this.countryCode = SystemPropUtils.getProperty("get", "ro.hw.country", "android.os.SystemProperties", "UNKNOWN");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("countryCode by ro.hw.country is: ");
    localStringBuilder.append(this.countryCode);
    Logger.i(str, localStringBuilder.toString());
    if ((!"eu".equalsIgnoreCase(this.countryCode)) && (!"la".equalsIgnoreCase(this.countryCode)))
    {
      if ("uk".equalsIgnoreCase(this.countryCode))
      {
        Logger.i(TAG, "special country of UK to map GB.");
        this.countryCode = "gb";
        this.countrySource = "VENDOR_COUNTRY";
        return;
      }
      checkCodeLenth();
      return;
    }
    this.countryCode = "UNKNOWN";
    this.countrySource = "UNKNOWN";
  }
  
  private void init(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null) {}
    try
    {
      getVendorCountryCode();
      if (isCodeValidate())
      {
        paramContext = TAG;
        Logger.i(paramContext, "get issue_country code from VENDOR_COUNTRY");
        return;
      }
      getSimCountryCode(paramContext);
      if (isCodeValidate())
      {
        paramContext = TAG;
        Logger.i(paramContext, "get issue_country code from SIM_COUNTRY");
        return;
      }
      getLocaleCountryCode();
      if (!isCodeValidate()) {
        break label79;
      }
      paramContext = TAG;
      Logger.i(paramContext, "get issue_country code from LOCALE_INFO");
      return;
    }
    catch (Exception paramContext)
    {
      label71:
      break label71;
    }
    Logger.w(TAG, "get CountryCode error");
    label79:
    return;
    throw new NullPointerException("context must be not null.Please provide app's Context");
  }
  
  private boolean isCodeValidate()
  {
    return "UNKNOWN".equals(this.countryCode) ^ true;
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