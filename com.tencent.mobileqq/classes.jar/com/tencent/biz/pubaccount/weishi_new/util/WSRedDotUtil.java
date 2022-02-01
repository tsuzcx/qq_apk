package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stRedDotMenu;
import UserGrowth.stSchema;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/util/WSRedDotUtil;", "", "()V", "KEY_FEEDBACK_JUMP_URL", "", "KEY_MENU_FEEDBACK", "TAG", "getRedDotMenu", "LUserGrowth/stRedDotMenu;", "menuKey", "menuList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "readFeedbackJumpUrl", "saveFeedbackJumpUrl", "", "h5Url", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSRedDotUtil
{
  public static final WSRedDotUtil a = new WSRedDotUtil();
  
  @JvmStatic
  @Nullable
  public static final stRedDotMenu a(@NotNull String paramString, @Nullable ArrayList<stRedDotMenu> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "menuKey");
    if (paramArrayList == null) {
      return null;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      stRedDotMenu localstRedDotMenu = (stRedDotMenu)localIterator.next();
      if (localstRedDotMenu != null) {
        paramArrayList = localstRedDotMenu.menuKey;
      } else {
        paramArrayList = null;
      }
      if (Intrinsics.areEqual(paramString, paramArrayList)) {
        return localstRedDotMenu;
      }
    }
    return null;
  }
  
  @JvmStatic
  @NotNull
  public static final String a()
  {
    String str = LocalMultiProcConfig.getString("key_feedback_jump_url", "");
    Intrinsics.checkExpressionValueIsNotNull(str, "LocalMultiProcConfig.get…EY_FEEDBACK_JUMP_URL, \"\")");
    return str;
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence != null) && (!StringsKt.isBlank(localCharSequence))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    LocalMultiProcConfig.putString("key_feedback_jump_url", paramString);
  }
  
  @JvmStatic
  public static final void a(@Nullable ArrayList<stRedDotMenu> paramArrayList)
  {
    paramArrayList = a("Feedback", paramArrayList);
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.schema;
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.H5Url;
        break label30;
      }
    }
    paramArrayList = null;
    label30:
    a(paramArrayList);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("feedBack url = ");
    localStringBuilder.append(paramArrayList);
    WSLog.e("WSRedDotUtil", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSRedDotUtil
 * JD-Core Version:    0.7.0.1
 */