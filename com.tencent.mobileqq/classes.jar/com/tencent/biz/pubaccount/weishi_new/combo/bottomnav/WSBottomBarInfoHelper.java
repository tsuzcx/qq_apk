package com.tencent.biz.pubaccount.weishi_new.combo.bottomnav;

import androidx.annotation.StringRes;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfoHelper;", "", "()V", "createBottomBarInfoList", "", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;", "createDefaultBarInfoList", "selectedBarId", "", "getBottomBarInfoById", "barId", "barInfoList", "getTextById", "id", "", "Id", "Type", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSBottomBarInfoHelper
{
  public static final WSBottomBarInfoHelper a = new WSBottomBarInfoHelper();
  
  private final String a(@StringRes int paramInt)
  {
    String str = BaseApplicationImpl.getContext().getString(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(str, "BaseApplicationImpl.getContext().getString(id)");
    return str;
  }
  
  private final List<WSBottomBarInfo> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new WSBottomBarInfo(0, "waterfall_tab", paramString, 1, a.a(1929838596)));
    localArrayList.add(new WSBottomBarInfo(1, "monofeed_tab", paramString, 1, a.a(1929838597)));
    localArrayList.add(new WSBottomBarInfo(2, "publish", paramString, 2, a.a(1929838600)));
    localArrayList.add(new WSBottomBarInfo(3, "message_tab", paramString, 1, a.a(1929838598)));
    localArrayList.add(new WSBottomBarInfo(4, "my_tab", paramString, 1, a.a(1929838599)));
    return (List)localArrayList;
  }
  
  @Nullable
  public final WSBottomBarInfo a(@NotNull String paramString, @NotNull List<WSBottomBarInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "barId");
    Intrinsics.checkParameterIsNotNull(paramList, "barInfoList");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WSBottomBarInfo localWSBottomBarInfo = (WSBottomBarInfo)paramList.next();
      if (Intrinsics.areEqual(localWSBottomBarInfo.f(), paramString)) {
        return localWSBottomBarInfo;
      }
    }
    return null;
  }
  
  @NotNull
  public final List<WSBottomBarInfo> a()
  {
    List localList2 = WSComboExpHelper.a.c();
    List localList1 = localList2;
    if (localList2.isEmpty()) {
      localList1 = a(WSComboExpHelper.a.b());
    }
    return localList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarInfoHelper
 * JD-Core Version:    0.7.0.1
 */