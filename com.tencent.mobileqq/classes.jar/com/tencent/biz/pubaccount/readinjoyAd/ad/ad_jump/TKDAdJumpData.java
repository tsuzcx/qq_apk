package com.tencent.biz.pubaccount.readinjoyAd.ad.ad_jump;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pkh;
import udo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/ad_jump/TKDAdJumpData;", "", "(Ljava/lang/String;I)V", "deepLinkUrl", "", "getDeepLinkUrl", "()Ljava/lang/String;", "setDeepLinkUrl", "(Ljava/lang/String;)V", "downloadJumpUrl", "getDownloadJumpUrl", "setDownloadJumpUrl", "jumpType", "", "getJumpType", "()I", "setJumpType", "(I)V", "packageName", "getPackageName", "setPackageName", "qqMiniProSchema", "getQqMiniProSchema", "setQqMiniProSchema", "violaUrl", "getViolaUrl", "setViolaUrl", "webViewUrl", "getWebViewUrl", "setWebViewUrl", "checkValidData", "", "jumpUrl", "doJumpAction", "Lcom/tencent/biz/pubaccount/NativeAd/report/JumpMode;", "activity", "Landroid/content/Context;", "getJumpUrl", "obtainJumpData", "adInfo", "", "SoftAdJumpData", "NormalAdJumpData", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum TKDAdJumpData
{
  public static final udo Companion = new udo(null);
  private static final String TAG = "TKDAdJumpMgr";
  @Nullable
  private String deepLinkUrl;
  @Nullable
  private String downloadJumpUrl;
  private int jumpType;
  @Nullable
  private String packageName;
  @Nullable
  private String qqMiniProSchema;
  @Nullable
  private String violaUrl;
  @Nullable
  private String webViewUrl;
  
  static
  {
    TKDAdJumpData.SoftAdJumpData localSoftAdJumpData = new TKDAdJumpData.SoftAdJumpData("SoftAdJumpData", 0);
    SoftAdJumpData = localSoftAdJumpData;
    TKDAdJumpData.NormalAdJumpData localNormalAdJumpData = new TKDAdJumpData.NormalAdJumpData("NormalAdJumpData", 1);
    NormalAdJumpData = localNormalAdJumpData;
    $VALUES = new TKDAdJumpData[] { localSoftAdJumpData, localNormalAdJumpData };
  }
  
  private TKDAdJumpData() {}
  
  private final boolean checkValidData(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      QLog.d("TKDAdJumpMgr", 1, "jumpType = 0, invalid");
      return false;
    }
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.d("TKDAdJumpMgr", 1, "invalid liuJin jump: type = " + paramInt + " url = " + paramString);
      return false;
    }
    return true;
  }
  
  private final String getJumpUrl()
  {
    String str = (String)null;
    switch (this.jumpType)
    {
    case 3: 
    default: 
      return this.webViewUrl;
    case 1: 
      return this.violaUrl;
    case 6: 
      return this.webViewUrl;
    case 2: 
      return this.qqMiniProSchema;
    case 4: 
      return this.downloadJumpUrl;
    }
    return this.downloadJumpUrl;
  }
  
  @NotNull
  public final JumpMode doJumpAction(@Nullable Context paramContext)
  {
    if (paramContext == null)
    {
      QLog.d("TKDAdJumpMgr", 1, "doJumpAction with null activity ");
      return JumpMode.FAIL;
    }
    int i = this.jumpType;
    String str = getJumpUrl();
    if (!checkValidData(i, str)) {
      return JumpMode.FAIL;
    }
    QLog.d("TKDAdJumpMgr", 1, "TKDJumpType = " + i + " TKDJumpUrl = " + str + ' ');
    paramContext = pkh.b(paramContext, str);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ReadInJoyUtils.jumpToUrl(activity, jumpUrl)");
    return paramContext;
  }
  
  @Nullable
  public final String getDeepLinkUrl()
  {
    return this.deepLinkUrl;
  }
  
  @Nullable
  public final String getDownloadJumpUrl()
  {
    return this.downloadJumpUrl;
  }
  
  public final int getJumpType()
  {
    return this.jumpType;
  }
  
  @Nullable
  public final String getPackageName()
  {
    return this.packageName;
  }
  
  @Nullable
  public final String getQqMiniProSchema()
  {
    return this.qqMiniProSchema;
  }
  
  @Nullable
  public final String getViolaUrl()
  {
    return this.violaUrl;
  }
  
  @Nullable
  public final String getWebViewUrl()
  {
    return this.webViewUrl;
  }
  
  @NotNull
  public abstract TKDAdJumpData obtainJumpData(@Nullable Object paramObject);
  
  public final void setDeepLinkUrl(@Nullable String paramString)
  {
    this.deepLinkUrl = paramString;
  }
  
  public final void setDownloadJumpUrl(@Nullable String paramString)
  {
    this.downloadJumpUrl = paramString;
  }
  
  public final void setJumpType(int paramInt)
  {
    this.jumpType = paramInt;
  }
  
  public final void setPackageName(@Nullable String paramString)
  {
    this.packageName = paramString;
  }
  
  public final void setQqMiniProSchema(@Nullable String paramString)
  {
    this.qqMiniProSchema = paramString;
  }
  
  public final void setViolaUrl(@Nullable String paramString)
  {
    this.violaUrl = paramString;
  }
  
  public final void setWebViewUrl(@Nullable String paramString)
  {
    this.webViewUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.ad_jump.TKDAdJumpData
 * JD-Core Version:    0.7.0.1
 */