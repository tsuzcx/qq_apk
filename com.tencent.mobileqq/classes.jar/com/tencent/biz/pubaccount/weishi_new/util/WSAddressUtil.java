package com.tencent.biz.pubaccount.weishi_new.util;

import NS_KING_SOCIALIZE_META.stMetaAddr;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/util/WSAddressUtil;", "", "()V", "getShortAddress", "", "address", "LNS_KING_SOCIALIZE_META/stMetaAddr;", "needSpace", "", "country", "province", "city", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSAddressUtil
{
  public static final WSAddressUtil a = new WSAddressUtil();
  
  private final String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = " ";
    } else {
      str = "";
    }
    CharSequence localCharSequence1 = (CharSequence)paramString1;
    int j = 0;
    int i;
    if ((localCharSequence1 != null) && (!StringsKt.isBlank(localCharSequence1))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      CharSequence localCharSequence2 = (CharSequence)paramString2;
      if ((localCharSequence2 != null) && (!StringsKt.isBlank(localCharSequence2))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        localCharSequence2 = (CharSequence)paramString3;
        if ((localCharSequence2 != null) && (!StringsKt.isBlank(localCharSequence2))) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          paramString1 = new StringBuilder();
          paramString1.append(paramString2);
          paramString1.append(str);
          paramString1.append(paramString3);
          return paramString1.toString();
        }
      }
    }
    if ((localCharSequence1 != null) && (!StringsKt.isBlank(localCharSequence1))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      paramString3 = (CharSequence)paramString2;
      if ((paramString3 != null) && (!StringsKt.isBlank(paramString3))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        paramString3 = new StringBuilder();
        paramString3.append(paramString1);
        paramString3.append(str);
        paramString3.append(paramString2);
        return paramString3.toString();
      }
    }
    if (localCharSequence1 != null)
    {
      i = j;
      if (!StringsKt.isBlank(localCharSequence1)) {}
    }
    else
    {
      i = 1;
    }
    if (i == 0) {
      return paramString1;
    }
    return "";
  }
  
  @NotNull
  public final String a(@Nullable stMetaAddr paramstMetaAddr, boolean paramBoolean)
  {
    if (paramstMetaAddr == null) {
      return "";
    }
    return a(paramstMetaAddr.country, paramstMetaAddr.province, paramstMetaAddr.city, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSAddressUtil
 * JD-Core Version:    0.7.0.1
 */