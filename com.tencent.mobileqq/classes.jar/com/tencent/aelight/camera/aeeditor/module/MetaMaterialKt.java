package com.tencent.aelight.camera.aeeditor.module;

import android.support.annotation.DrawableRes;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"NON_CATEGORY_ID", "", "THUMB_FILTER_AI", "THUMB_NON", "TYPE_FILTER", "", "TYPE_FRAME", "TYPE_IMAGE_TEMPLATE", "TYPE_STICKER", "TYPE_TEXT", "TYPE_VIDEO_TEMPLATE", "value", "badgeDisappearTimestamp", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getBadgeDisappearTimestamp", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I", "setBadgeDisappearTimestamp", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;I)V", "badgeURL", "getBadgeURL", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", "setBadgeURL", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "categoryId", "getCategoryId", "setCategoryId", "", "displayDownloadIcon", "getDisplayDownloadIcon", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Z", "setDisplayDownloadIcon", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "downloadProgress", "getDownloadProgress", "setDownloadProgress", "hashTag", "getHashTag", "setHashTag", "isApplyLocal", "setApplyLocal", "isPreDownload", "setPreDownload", "isSmallLoading", "setSmallLoading", "name", "getName", "setName", "overlayIconRes", "getOverlayIconRes", "setOverlayIconRes", "packagePath", "getPackagePath", "setPackagePath", "redPointTimeStamp", "getRedPointTimeStamp", "setRedPointTimeStamp", "thumbText", "getThumbText", "setThumbText", "findFirstItemPositionByCategoryPosition", "categories", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "materials", "categoryItemPosition", "findItemPositionByContentPosition", "contentItemPosition", "calculateNewestRedPoint", "newestRedPoint", "getFloatOrDefault", "", "key", "default", "getFloatOrZero", "getIntOrDefault", "getIntOrZero", "getMapOrNull", "", "getStringOrEmpty", "getThumbLocalRes", "putMap", "", "putNumber", "", "putString", "aelight_impl_release"}, k=2, mv={1, 1, 16})
public final class MetaMaterialKt
{
  public static final float a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$getFloatOrZero");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    return a(paramMetaMaterial, paramString, 0.0F);
  }
  
  public static final float a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$getFloatOrDefault");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (paramMetaMaterial.additionalFields == null) {
      return paramFloat;
    }
    paramMetaMaterial = (String)paramMetaMaterial.additionalFields.get(paramString);
    float f = paramFloat;
    if (paramMetaMaterial != null) {}
    try
    {
      f = Float.parseFloat(paramMetaMaterial);
      return f;
    }
    catch (Exception paramMetaMaterial) {}
    return paramFloat;
  }
  
  public static final int a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$badgeDisappearTimestamp");
    return a(paramMetaMaterial, "badgeDisappearTimestamp", -1);
  }
  
  public static final int a(@NotNull MetaMaterial paramMetaMaterial, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$calculateNewestRedPoint");
    return RangesKt.coerceAtLeast(paramInt, b(paramMetaMaterial));
  }
  
  public static final int a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$getIntOrZero");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    return a(paramMetaMaterial, paramString, 0);
  }
  
  public static final int a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$getIntOrDefault");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (paramMetaMaterial.additionalFields == null) {
      return paramInt;
    }
    paramMetaMaterial = (String)paramMetaMaterial.additionalFields.get(paramString);
    int i = paramInt;
    if (paramMetaMaterial != null) {}
    try
    {
      i = Integer.parseInt(paramMetaMaterial);
      return i;
    }
    catch (Exception paramMetaMaterial) {}
    return paramInt;
  }
  
  public static final int a(@Nullable List<MetaCategory> paramList, @Nullable List<MetaMaterial> paramList1, int paramInt)
  {
    if ((paramList != null) && (paramList1 != null))
    {
      if (paramList1.size() < paramInt) {
        return 0;
      }
      paramList1 = d((MetaMaterial)paramList1.get(paramInt));
      int i = ((Collection)paramList).size();
      paramInt = 0;
      while (paramInt < i)
      {
        if (Intrinsics.areEqual(paramList1, ((MetaCategory)paramList.get(paramInt)).id)) {
          return paramInt;
        }
        paramInt += 1;
      }
    }
    return 0;
  }
  
  @NotNull
  public static final String a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$name");
    return a(paramMetaMaterial, "name");
  }
  
  @NotNull
  public static final String a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$getStringOrEmpty");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (paramMetaMaterial.additionalFields == null) {
      return "";
    }
    paramMetaMaterial = (String)paramMetaMaterial.additionalFields.get(paramString);
    if (paramMetaMaterial != null) {
      return paramMetaMaterial;
    }
    return "";
  }
  
  @Nullable
  public static final Map<String, String> a(@NotNull MetaMaterial paramMetaMaterial, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$getMapOrNull");
    paramMetaMaterial = (String)paramMetaMaterial.additionalFields.get(paramString);
    try
    {
      paramMetaMaterial = (Map)new Gson().fromJson(paramMetaMaterial, new MetaMaterialKt.getMapOrNull.1().getType());
      return paramMetaMaterial;
    }
    catch (JsonSyntaxException paramMetaMaterial)
    {
      label47:
      break label47;
    }
    return null;
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$downloadProgress");
    a(paramMetaMaterial, "downloadProgress", (Number)Integer.valueOf(Math.min(paramInt, 100)));
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$categoryId");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    a(paramMetaMaterial, "categoryId", paramString);
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString, @NotNull Number paramNumber)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$putNumber");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramNumber, "value");
    if (paramMetaMaterial.additionalFields == null) {
      paramMetaMaterial.additionalFields = ((Map)new HashMap());
    }
    try
    {
      paramMetaMaterial = paramMetaMaterial.additionalFields;
      Intrinsics.checkExpressionValueIsNotNull(paramMetaMaterial, "this.additionalFields");
      paramMetaMaterial.put(paramString, paramNumber.toString());
      return;
    }
    catch (Exception paramMetaMaterial) {}
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$putString");
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    if (paramMetaMaterial.additionalFields == null) {
      paramMetaMaterial.additionalFields = ((Map)new HashMap());
    }
    paramMetaMaterial = paramMetaMaterial.additionalFields;
    Intrinsics.checkExpressionValueIsNotNull(paramMetaMaterial, "this.additionalFields");
    paramMetaMaterial.put(paramString1, paramString2);
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @Nullable String paramString, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$putMap");
    if (paramMetaMaterial.additionalFields == null) {
      paramMetaMaterial.additionalFields = ((Map)new HashMap());
    }
    try
    {
      Gson localGson = new Gson();
      paramMetaMaterial = paramMetaMaterial.additionalFields;
      Intrinsics.checkExpressionValueIsNotNull(paramMetaMaterial, "this.additionalFields");
      paramMetaMaterial.put(paramString, localGson.toJson(paramMap, new MetaMaterialKt.putMap.1().getType()));
      return;
    }
    catch (JsonSyntaxException paramMetaMaterial) {}
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final boolean a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$displayDownloadIcon");
    return a(paramMetaMaterial, "displayDownloadIcon") == 1;
  }
  
  public static final int b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$redPointTimeStamp");
    return a(paramMetaMaterial, "redPointTimestamp", -1);
  }
  
  public static final int b(@Nullable List<MetaCategory> paramList, @Nullable List<MetaMaterial> paramList1, int paramInt)
  {
    if ((paramList != null) && (paramList1 != null))
    {
      if (paramList.size() < paramInt) {
        return 0;
      }
      paramList = (MetaCategory)paramList.get(paramInt);
      int i = ((Collection)paramList1).size();
      paramInt = 0;
      while (paramInt < i)
      {
        if (Intrinsics.areEqual(paramList.id, d((MetaMaterial)paramList1.get(paramInt)))) {
          return paramInt;
        }
        paramInt += 1;
      }
    }
    return 0;
  }
  
  @NotNull
  public static final String b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$hashTag");
    return a(paramMetaMaterial, "topic");
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, @DrawableRes int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$overlayIconRes");
    a(paramMetaMaterial, "exOverlayIconRes", (Number)Integer.valueOf(paramInt));
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$packagePath");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    a(paramMetaMaterial, "packagePath", paramString);
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final boolean b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isApplyLocal");
    return a(paramMetaMaterial, "isApplyLocal", 1) == 1;
  }
  
  public static final int c(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$downloadProgress");
    return a(paramMetaMaterial, "downloadProgress", -1);
  }
  
  @NotNull
  public static final String c(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$badgeURL");
    String str = a(paramMetaMaterial, "badgeURL");
    if (!Intrinsics.areEqual(str, ""))
    {
      if ((a(paramMetaMaterial) > 0) && ((int)(System.currentTimeMillis() / 1000) > a(paramMetaMaterial))) {
        return "";
      }
      return str;
    }
    return "";
  }
  
  public static final void c(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$thumbText");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    a(paramMetaMaterial, "thumbText", paramString);
  }
  
  public static final boolean c(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isSmallLoading");
    return a(paramMetaMaterial, "isSmallLoading", 1) == 1;
  }
  
  @DrawableRes
  public static final int d(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$overlayIconRes");
    return a(paramMetaMaterial, "exOverlayIconRes", 2064056532);
  }
  
  @NotNull
  public static final String d(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$categoryId");
    return a(paramMetaMaterial, "categoryId");
  }
  
  @DrawableRes
  public static final int e(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$getThumbLocalRes");
    if (Intrinsics.areEqual("thumbNon", paramMetaMaterial.thumbUrl)) {
      return 2064056491;
    }
    if (Intrinsics.areEqual("thumbFilterAI", paramMetaMaterial.thumbUrl)) {
      return 2064056451;
    }
    return 2064056481;
  }
  
  @NotNull
  public static final String e(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$packagePath");
    return a(paramMetaMaterial, "packagePath");
  }
  
  @NotNull
  public static final String f(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$thumbText");
    return a(paramMetaMaterial, "thumbText");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt
 * JD-Core Version:    0.7.0.1
 */