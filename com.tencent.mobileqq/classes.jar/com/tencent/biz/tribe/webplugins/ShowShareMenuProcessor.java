package com.tencent.biz.tribe.webplugins;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.biz.pubaccount.util.ShareToComputerHelper;
import com.tencent.biz.tribe.TribeWebViewPlugin;
import com.tencent.biz.tribe.TribeWebViewPlugin.BaseTribePluginProcessor;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/tribe/webplugins/ShowShareMenuProcessor;", "Lcom/tencent/biz/tribe/TribeWebViewPlugin$BaseTribePluginProcessor;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Landroid/content/DialogInterface$OnCancelListener;", "Landroid/content/DialogInterface$OnDismissListener;", "plugin", "Lcom/tencent/biz/tribe/TribeWebViewPlugin;", "(Lcom/tencent/biz/tribe/TribeWebViewPlugin;)V", "actionToIdMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "callbackId", "hasInit", "", "idToActionMap", "shareActionSheet", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareToComputerHelper", "Lcom/tencent/biz/pubaccount/util/ShareToComputerHelper;", "init", "", "initMaps", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onItemClick", "item", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "process", "json", "Lorg/json/JSONObject;", "putToMap", "id", "action", "showActionSheet", "showRecentFriend", "paths", "", "operations", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ShowShareMenuProcessor
  extends TribeWebViewPlugin.BaseTribePluginProcessor
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, ShareActionSheet.OnItemClickListener
{
  private ShareToComputerHelper jdField_a_of_type_ComTencentBizPubaccountUtilShareToComputerHelper;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private String jdField_a_of_type_JavaLangString = "";
  private final HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private final HashMap<Integer, String> b = new HashMap();
  
  public ShowShareMenuProcessor(@NotNull TribeWebViewPlugin paramTribeWebViewPlugin)
  {
    super(paramTribeWebViewPlugin);
  }
  
  private final ShareActionSheet a(boolean paramBoolean, List<? extends ShareActionSheetBuilder.ActionSheetItem> paramList1, List<? extends ShareActionSheetBuilder.ActionSheetItem> paramList2)
  {
    Object localObject = a().mRuntime;
    if (localObject != null)
    {
      localObject = ((WebViewPlugin.PluginRuntime)localObject).a();
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getIntent();
        if (localObject != null) {
          ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_feeds_buluo");
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
      }
      ((ShareActionSheet)localObject).setActionSheetItems(paramList1, paramList2);
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
      if (paramList1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
      }
      paramList1.setItemClickListenerV2((ShareActionSheet.OnItemClickListener)this);
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
      if (paramList1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
      }
      paramList1.setCancelListener((DialogInterface.OnCancelListener)this);
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
      if (paramList1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
      }
      paramList1.setOnDismissListener((DialogInterface.OnDismissListener)this);
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
      if (paramList1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
      }
      paramList1.setIntentForStartForwardRecentActivity(new Intent());
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
      if (paramList1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
      }
      if (!paramBoolean) {
        break label245;
      }
    }
    label245:
    for (int i = 0;; i = 8)
    {
      paramList1.setRowVisibility(i, 0, 0);
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
      if (paramList1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
      }
      paramList1.show();
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
      if (paramList1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
      }
      return paramList1;
      localObject = null;
      break;
    }
  }
  
  private final void a()
  {
    Object localObject1 = new ShareActionSheetV2.Param();
    WebViewPlugin.PluginRuntime localPluginRuntime = a().mRuntime;
    if (localPluginRuntime != null)
    {
      Object localObject2 = a().mRuntime;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "plugin.mRuntime");
      localObject2 = ((WebViewPlugin.PluginRuntime)localObject2).a();
      ((ShareActionSheetV2.Param)localObject1).context = ((Context)localObject2);
      localObject1 = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "ShareActionSheetFactory.create(param)");
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ((ShareActionSheet)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity");
      ((Activity)localObject2).getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
      this.jdField_a_of_type_ComTencentBizPubaccountUtilShareToComputerHelper = new ShareToComputerHelper(localPluginRuntime.a());
    }
    b();
  }
  
  private final void a(String paramString, int paramInt)
  {
    ((Map)this.jdField_a_of_type_JavaUtilHashMap).put(paramString, Integer.valueOf(paramInt));
    ((Map)this.b).put(Integer.valueOf(paramInt), paramString);
  }
  
  private final void b()
  {
    a("Qfriend", 2);
    a("Qzone", 3);
    a("wechat", 9);
    a("wechat_", 10);
    a("weibo", 12);
    a("Qbrowser", 5);
    a("sys_browser", 4);
    a("sent_pc", 26);
    a("add_to_digest", 145);
    a("cancel_digest", 146);
    a("interest", 147);
    a("look_owner", 148);
    a("push_topics", 149);
    a("pull_black", 150);
    a("feedback", 151);
    a("colornote", 70);
    a("colornote_cancel", 82);
    a("save", 43);
    a("adjust_font", 7);
    a("copy_link", 1);
    a("report", 11);
    a("aio_position", 54);
    a("collect", 6);
    a("collect_cancel", 84);
    a("stick", 96);
    a("unstick", 97);
    a("follow", 87);
    a("unfollow", 32);
  }
  
  public void a(@NotNull JSONObject paramJSONObject)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      a();
    }
    Object localObject = paramJSONObject.optJSONArray("secondLineIcons");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("thirdLineIcons");
    boolean bool = paramJSONObject.optBoolean("needRecentFriend");
    ArrayList localArrayList = new ArrayList();
    int k = ((JSONArray)localObject).length();
    int i = 0;
    Integer localInteger;
    while (i < k)
    {
      localInteger = (Integer)((Map)this.jdField_a_of_type_JavaUtilHashMap).get(((JSONArray)localObject).get(i));
      if (localInteger != null) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(localInteger.intValue()));
      }
      i += 1;
    }
    localObject = new ArrayList();
    k = localJSONArray.length();
    i = j;
    while (i < k)
    {
      localInteger = (Integer)((Map)this.jdField_a_of_type_JavaUtilHashMap).get(localJSONArray.get(i));
      if (localInteger != null) {
        ((ArrayList)localObject).add(ShareActionSheetBuilder.ActionSheetItem.build(localInteger.intValue()));
      }
      i += 1;
    }
    paramJSONObject = paramJSONObject.optString("callback");
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "json.optString(\"callback\")");
    this.jdField_a_of_type_JavaLangString = paramJSONObject;
    a(bool, (List)localArrayList, (List)localObject);
  }
  
  public void onCancel(@Nullable DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    paramDialogInterface.putOpt("id", Integer.valueOf(0));
    paramDialogInterface.putOpt("shared", Boolean.valueOf(false));
    paramDialogInterface.putOpt("toUin", Long.valueOf(0L));
    paramDialogInterface.putOpt("uinType", Integer.valueOf(0));
    a().callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramDialogInterface.toString() });
  }
  
  public void onDismiss(@Nullable DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    paramDialogInterface.putOpt("id", Integer.valueOf(0));
    paramDialogInterface.putOpt("shared", Boolean.valueOf(false));
    paramDialogInterface.putOpt("toUin", Long.valueOf(0L));
    paramDialogInterface.putOpt("uinType", Integer.valueOf(0));
    a().callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramDialogInterface.toString() });
  }
  
  public void onItemClick(@Nullable ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, @Nullable ShareActionSheet paramShareActionSheet)
  {
    JSONObject localJSONObject;
    if (paramActionSheetItem != null)
    {
      localJSONObject = new JSONObject();
      paramShareActionSheet = (String)this.b.get(Integer.valueOf(paramActionSheetItem.action));
      if (paramShareActionSheet == null) {
        break label140;
      }
      localJSONObject.putOpt("id", paramShareActionSheet);
      localJSONObject.putOpt("shared", Boolean.valueOf(true));
      paramShareActionSheet = paramActionSheetItem.uin;
      if (paramShareActionSheet == null) {
        break label148;
      }
      paramShareActionSheet = StringsKt.toLongOrNull(paramShareActionSheet);
      if (paramShareActionSheet == null) {
        break label148;
      }
    }
    for (;;)
    {
      localJSONObject.putOpt("toUin", paramShareActionSheet);
      localJSONObject.putOpt("uinType", Integer.valueOf(paramActionSheetItem.uinType));
      a().callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
      if (paramActionSheetItem == null) {
        Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
      }
      paramActionSheetItem.dismiss();
      return;
      label140:
      paramShareActionSheet = Integer.valueOf(0);
      break;
      label148:
      paramShareActionSheet = Long.valueOf(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.tribe.webplugins.ShowShareMenuProcessor
 * JD-Core Version:    0.7.0.1
 */