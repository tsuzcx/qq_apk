package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step;

import android.text.TextUtils;
import com.dataline.util.file.FileUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "adData", "Lorg/json/JSONObject;", "resInfo", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "needReport", "", "scene", "", "(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;ZI)V", "getAdData", "()Lorg/json/JSONObject;", "adId", "", "bidMask", "configFile", "Ljava/io/File;", "manifestJson", "getNeedReport", "()Z", "getResInfo", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "resPath", "resVersion", "getScene", "()I", "checkManifest", "checkMaskType", "checkResFile", "checkVersion", "doStep", "isBidMask", "AdResCheckInfo", "Companion", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ResCheckStep
  extends SuperMaskStep
{
  public static final ResCheckStep.Companion a = new ResCheckStep.Companion(null);
  private String b;
  private final File c;
  private JSONObject d;
  private final String e;
  private final int f;
  private final String g;
  @Nullable
  private final JSONObject h;
  @Nullable
  private final ResCheckStep.AdResCheckInfo i;
  private final boolean j;
  private final int k;
  
  public ResCheckStep(@Nullable JSONObject paramJSONObject, @Nullable ResCheckStep.AdResCheckInfo paramAdResCheckInfo, boolean paramBoolean, int paramInt)
  {
    this.h = paramJSONObject;
    this.i = paramAdResCheckInfo;
    this.j = paramBoolean;
    this.k = paramInt;
    paramJSONObject = this.h;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("res_path");
      if (paramJSONObject != null) {}
    }
    else
    {
      paramJSONObject = "";
    }
    this.b = paramJSONObject;
    this.c = new File(this.b, "manifest.json");
    paramJSONObject = this.h;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("adid");
      if (paramJSONObject != null) {}
    }
    else
    {
      paramJSONObject = "";
    }
    this.e = paramJSONObject;
    paramJSONObject = this.h;
    int m = 1;
    if (paramJSONObject != null) {
      paramInt = paramJSONObject.optInt("res_version");
    } else {
      paramInt = 1;
    }
    this.f = paramInt;
    paramJSONObject = this.h;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("bid_mask");
      if (paramJSONObject != null) {}
    }
    else
    {
      paramJSONObject = "0";
    }
    this.g = paramJSONObject;
    if (TextUtils.isEmpty((CharSequence)this.b))
    {
      paramJSONObject = this.h;
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optString("ad_source");
        if (paramJSONObject != null) {}
      }
      else
      {
        paramJSONObject = "";
      }
      paramAdResCheckInfo = this.h;
      if (paramAdResCheckInfo != null) {
        paramAdResCheckInfo = paramAdResCheckInfo.optString("adid");
      } else {
        paramAdResCheckInfo = null;
      }
      JSONObject localJSONObject = this.h;
      paramInt = m;
      if (localJSONObject != null) {
        paramInt = localJSONObject.optInt("res_version");
      }
      paramJSONObject = AdMaterialResManager.a(paramJSONObject, paramAdResCheckInfo, paramInt);
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "AdMaterialResManager.obt…kConfig.resVersion) ?: 1)");
      this.b = paramJSONObject;
    }
  }
  
  private final boolean d()
  {
    b("checkVersion");
    if (this.h == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(" : ResCheckStep : checkVersion : adData is empty");
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject).toString());
      return false;
    }
    if (this.i == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(" : ResCheckStep : checkVersion : resInfo is empty");
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject).toString());
      return false;
    }
    boolean bool2 = h();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    Object localObject = this.h.optString("adid");
    String str = this.h.optString("ad_source");
    int m = this.h.optInt("res_version", -1);
    if ((!Intrinsics.areEqual(localObject, this.i.a())) || (!Intrinsics.areEqual(str, this.i.b())) || (m != this.i.c())) {
      bool1 = false;
    }
    if ((!bool1) && (this.k == 2)) {
      SuperMaskReportMgr.a(SuperMaskReportMgr.a, "versionNoMatch", null, 2, null);
    }
    return SuperMaskStepUtil.a.a(bool1, (SuperMaskStep)this);
  }
  
  private final boolean e()
  {
    b("checkManifest");
    Object localObject = this.h;
    boolean bool2 = false;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(" : ResCheckStep : checkManifest : adData is empty");
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject).toString());
      return false;
    }
    if (h()) {
      return true;
    }
    boolean bool1 = bool2;
    if (this.c.exists())
    {
      bool1 = bool2;
      if (this.c.isFile())
      {
        bool1 = bool2;
        if (this.c.canRead()) {
          bool1 = true;
        }
      }
    }
    if (!bool1)
    {
      if (this.k == 2) {
        SuperMaskReportMgr.a(SuperMaskReportMgr.a, "noManifest", null, 2, null);
      }
      if (this.k == 1) {
        SuperMaskReportMgr.a.a(this.e, "noManifest", this.f);
      }
    }
    return SuperMaskStepUtil.a.a(bool1, (SuperMaskStep)this);
  }
  
  private final boolean f()
  {
    b("checkResFile");
    Object localObject1 = this.h;
    boolean bool2 = false;
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a());
      ((StringBuilder)localObject1).append(" : ResCheckStep : checkResFile : adData is empty");
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject1).toString());
      return false;
    }
    if (h()) {
      return true;
    }
    Object localObject2 = this.h.optString("animFileName");
    if (this.k != 1)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    }
    else
    {
      long l1 = System.currentTimeMillis();
      localObject1 = new StringBuffer();
      FileUtil.a((StringBuffer)localObject1, this.c.getPath());
      localObject1 = ((StringBuffer)localObject1).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "buffer.toString()");
      long l2 = System.currentTimeMillis();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a());
      ((StringBuilder)localObject2).append(" : ResCheckStep : checkResFile : readTime = ");
      ((StringBuilder)localObject2).append(l2 - l1);
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject2).toString());
      this.d = new JSONObject((String)localObject1);
      localObject1 = this.d;
      if (localObject1 != null)
      {
        localObject1 = ((JSONObject)localObject1).optString("animFileName");
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      try
      {
        this.h.put("animFileName", localObject1);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(a());
        localStringBuilder.append(" : checkResFile, adData put animFileName fail been catch : ");
        localException.printStackTrace();
        localStringBuilder.append(Unit.INSTANCE);
        ReadInJoyAdLog.a("ReadInJoySuperMaskAd", localStringBuilder.toString());
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a());
      ((StringBuilder)localObject1).append(" : ResCheckStep : checkResFile : animFileName is empty");
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject1).toString());
      if (this.k == 2) {
        SuperMaskReportMgr.a(SuperMaskReportMgr.a, "noFileName", null, 2, null);
      }
      if (this.k == 1) {
        SuperMaskReportMgr.a.a(this.e, "noFileName", this.f);
      }
      return false;
    }
    localObject1 = new File(this.b, (String)localObject1);
    boolean bool1 = bool2;
    if (((File)localObject1).exists())
    {
      bool1 = bool2;
      if (((File)localObject1).isFile())
      {
        bool1 = bool2;
        if (((File)localObject1).canRead()) {
          bool1 = true;
        }
      }
    }
    if (!bool1)
    {
      if (this.k == 2) {
        SuperMaskReportMgr.a(SuperMaskReportMgr.a, "noVideoFile", null, 2, null);
      }
      if (this.k == 1) {
        SuperMaskReportMgr.a.a(this.e, "noVideoFile", this.f);
      }
    }
    return SuperMaskStepUtil.a.a(bool1, (SuperMaskStep)this);
  }
  
  private final boolean g()
  {
    b("checkMaskType");
    Object localObject = this.h;
    boolean bool = false;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(" : ResCheckStep : checkMaskType : adData is empty");
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject).toString());
      return false;
    }
    int m = this.k;
    if (m == 1)
    {
      localObject = this.d;
      if (localObject != null) {
        m = ((JSONObject)localObject).optInt("superMaskType", 1);
      } else {
        m = 1;
      }
      try
      {
        this.h.put("superMaskType", m);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(a());
        localStringBuilder.append(" : checkResFile, adData put animFileName fail been catch : ");
        localException.printStackTrace();
        localStringBuilder.append(Unit.INSTANCE);
        ReadInJoyAdLog.a("ReadInJoySuperMaskAd", localStringBuilder.toString());
      }
    }
    else if (m == 2)
    {
      m = localException.optInt("superMaskType", 1);
    }
    else
    {
      m = 1;
    }
    if (m != 1) {
      bool = true;
    }
    if (!bool)
    {
      if (this.k == 2) {
        SuperMaskReportMgr.a(SuperMaskReportMgr.a, "invalidType", null, 2, null);
      }
      if (this.k == 1) {
        SuperMaskReportMgr.a.a(this.e, "invalidType", this.f);
      }
    }
    return SuperMaskStepUtil.a.a(bool, (SuperMaskStep)this);
  }
  
  private final boolean h()
  {
    if (this.h != null)
    {
      String str = this.g;
      if ((str != null) && (str.equals("1"))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (d())
      {
        bool1 = bool2;
        if (e())
        {
          bool1 = bool2;
          if (f())
          {
            boolean bool3 = g();
            bool1 = bool2;
            if (bool3) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ResCheckStep
 * JD-Core Version:    0.7.0.1
 */