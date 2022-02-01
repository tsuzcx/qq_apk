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
  public static final ResCheckStep.Companion a;
  private final int jdField_a_of_type_Int;
  @Nullable
  private final ResCheckStep.AdResCheckInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskStepResCheckStep$AdResCheckInfo;
  private final File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private final boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString;
  @Nullable
  private final JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private final String c;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskStepResCheckStep$Companion = new ResCheckStep.Companion(null);
  }
  
  public ResCheckStep(@Nullable JSONObject paramJSONObject, @Nullable ResCheckStep.AdResCheckInfo paramAdResCheckInfo, boolean paramBoolean, int paramInt)
  {
    this.jdField_b_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskStepResCheckStep$AdResCheckInfo = paramAdResCheckInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt;
    paramJSONObject = this.jdField_b_of_type_OrgJsonJSONObject;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("res_path");
      if (paramJSONObject != null) {}
    }
    else
    {
      paramJSONObject = "";
    }
    this.jdField_a_of_type_JavaLangString = paramJSONObject;
    this.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_JavaLangString, "manifest.json");
    paramJSONObject = this.jdField_b_of_type_OrgJsonJSONObject;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("adid");
      if (paramJSONObject != null) {}
    }
    else
    {
      paramJSONObject = "";
    }
    this.jdField_b_of_type_JavaLangString = paramJSONObject;
    paramJSONObject = this.jdField_b_of_type_OrgJsonJSONObject;
    int i = 1;
    if (paramJSONObject != null) {
      paramInt = paramJSONObject.optInt("res_version");
    } else {
      paramInt = 1;
    }
    this.jdField_a_of_type_Int = paramInt;
    paramJSONObject = this.jdField_b_of_type_OrgJsonJSONObject;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("bid_mask");
      if (paramJSONObject != null) {}
    }
    else
    {
      paramJSONObject = "0";
    }
    this.c = paramJSONObject;
    if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString))
    {
      paramJSONObject = this.jdField_b_of_type_OrgJsonJSONObject;
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optString("ad_source");
        if (paramJSONObject != null) {}
      }
      else
      {
        paramJSONObject = "";
      }
      paramAdResCheckInfo = this.jdField_b_of_type_OrgJsonJSONObject;
      if (paramAdResCheckInfo != null) {
        paramAdResCheckInfo = paramAdResCheckInfo.optString("adid");
      } else {
        paramAdResCheckInfo = null;
      }
      JSONObject localJSONObject = this.jdField_b_of_type_OrgJsonJSONObject;
      paramInt = i;
      if (localJSONObject != null) {
        paramInt = localJSONObject.optInt("res_version");
      }
      paramJSONObject = AdMaterialResManager.a(paramJSONObject, paramAdResCheckInfo, paramInt);
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "AdMaterialResManager.obt…kConfig.resVersion) ?: 1)");
      this.jdField_a_of_type_JavaLangString = paramJSONObject;
    }
  }
  
  private final boolean b()
  {
    b("checkVersion");
    if (this.jdField_b_of_type_OrgJsonJSONObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(" : ResCheckStep : checkVersion : adData is empty");
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject).toString());
      return false;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskStepResCheckStep$AdResCheckInfo == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(" : ResCheckStep : checkVersion : resInfo is empty");
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject).toString());
      return false;
    }
    boolean bool2 = f();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    Object localObject = this.jdField_b_of_type_OrgJsonJSONObject.optString("adid");
    String str = this.jdField_b_of_type_OrgJsonJSONObject.optString("ad_source");
    int i = this.jdField_b_of_type_OrgJsonJSONObject.optInt("res_version", -1);
    if ((!Intrinsics.areEqual(localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskStepResCheckStep$AdResCheckInfo.a())) || (!Intrinsics.areEqual(str, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskStepResCheckStep$AdResCheckInfo.b())) || (i != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskStepResCheckStep$AdResCheckInfo.a())) {
      bool1 = false;
    }
    if ((!bool1) && (this.jdField_b_of_type_Int == 2)) {
      SuperMaskReportMgr.a(SuperMaskReportMgr.a, "versionNoMatch", null, 2, null);
    }
    return SuperMaskStepUtil.a.a(bool1, (SuperMaskStep)this);
  }
  
  private final boolean c()
  {
    b("checkManifest");
    Object localObject = this.jdField_b_of_type_OrgJsonJSONObject;
    boolean bool2 = false;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(" : ResCheckStep : checkManifest : adData is empty");
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject).toString());
      return false;
    }
    if (f()) {
      return true;
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaIoFile.exists())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaIoFile.isFile())
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaIoFile.canRead()) {
          bool1 = true;
        }
      }
    }
    if (!bool1)
    {
      if (this.jdField_b_of_type_Int == 2) {
        SuperMaskReportMgr.a(SuperMaskReportMgr.a, "noManifest", null, 2, null);
      }
      if (this.jdField_b_of_type_Int == 1) {
        SuperMaskReportMgr.a.a(this.jdField_b_of_type_JavaLangString, "noManifest", this.jdField_a_of_type_Int);
      }
    }
    return SuperMaskStepUtil.a.a(bool1, (SuperMaskStep)this);
  }
  
  private final boolean d()
  {
    b("checkResFile");
    Object localObject1 = this.jdField_b_of_type_OrgJsonJSONObject;
    boolean bool2 = false;
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a());
      ((StringBuilder)localObject1).append(" : ResCheckStep : checkResFile : adData is empty");
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject1).toString());
      return false;
    }
    if (f()) {
      return true;
    }
    Object localObject2 = this.jdField_b_of_type_OrgJsonJSONObject.optString("animFileName");
    if (this.jdField_b_of_type_Int != 1)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    }
    else
    {
      long l1 = System.currentTimeMillis();
      localObject1 = new StringBuffer();
      FileUtil.a((StringBuffer)localObject1, this.jdField_a_of_type_JavaIoFile.getPath());
      localObject1 = ((StringBuffer)localObject1).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "buffer.toString()");
      long l2 = System.currentTimeMillis();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a());
      ((StringBuilder)localObject2).append(" : ResCheckStep : checkResFile : readTime = ");
      ((StringBuilder)localObject2).append(l2 - l1);
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject((String)localObject1);
      localObject1 = this.jdField_a_of_type_OrgJsonJSONObject;
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
        this.jdField_b_of_type_OrgJsonJSONObject.put("animFileName", localObject1);
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
      if (this.jdField_b_of_type_Int == 2) {
        SuperMaskReportMgr.a(SuperMaskReportMgr.a, "noFileName", null, 2, null);
      }
      if (this.jdField_b_of_type_Int == 1) {
        SuperMaskReportMgr.a.a(this.jdField_b_of_type_JavaLangString, "noFileName", this.jdField_a_of_type_Int);
      }
      return false;
    }
    localObject1 = new File(this.jdField_a_of_type_JavaLangString, (String)localObject1);
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
      if (this.jdField_b_of_type_Int == 2) {
        SuperMaskReportMgr.a(SuperMaskReportMgr.a, "noVideoFile", null, 2, null);
      }
      if (this.jdField_b_of_type_Int == 1) {
        SuperMaskReportMgr.a.a(this.jdField_b_of_type_JavaLangString, "noVideoFile", this.jdField_a_of_type_Int);
      }
    }
    return SuperMaskStepUtil.a.a(bool1, (SuperMaskStep)this);
  }
  
  private final boolean e()
  {
    b("checkMaskType");
    Object localObject = this.jdField_b_of_type_OrgJsonJSONObject;
    boolean bool = false;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(" : ResCheckStep : checkMaskType : adData is empty");
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject).toString());
      return false;
    }
    int i = this.jdField_b_of_type_Int;
    if (i == 1)
    {
      localObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if (localObject != null) {
        i = ((JSONObject)localObject).optInt("superMaskType", 1);
      } else {
        i = 1;
      }
      try
      {
        this.jdField_b_of_type_OrgJsonJSONObject.put("superMaskType", i);
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
    else if (i == 2)
    {
      i = localException.optInt("superMaskType", 1);
    }
    else
    {
      i = 1;
    }
    if (i != 1) {
      bool = true;
    }
    if (!bool)
    {
      if (this.jdField_b_of_type_Int == 2) {
        SuperMaskReportMgr.a(SuperMaskReportMgr.a, "invalidType", null, 2, null);
      }
      if (this.jdField_b_of_type_Int == 1) {
        SuperMaskReportMgr.a.a(this.jdField_b_of_type_JavaLangString, "invalidType", this.jdField_a_of_type_Int);
      }
    }
    return SuperMaskStepUtil.a.a(bool, (SuperMaskStep)this);
  }
  
  private final boolean f()
  {
    if (this.jdField_b_of_type_OrgJsonJSONObject != null)
    {
      String str = this.c;
      if ((str != null) && (str.equals("1"))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (b())
      {
        bool1 = bool2;
        if (c())
        {
          bool1 = bool2;
          if (d())
          {
            boolean bool3 = e();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ResCheckStep
 * JD-Core Version:    0.7.0.1
 */