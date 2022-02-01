package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.aelight.camera.ae.control.IAEQIMManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.editor.filter.FilterMetaMaterialKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowFilterDataManager;", "Lcom/tencent/aelight/camera/ae/control/IAEQIMManager;", "()V", "asyncHandler", "Landroid/os/Handler;", "filterDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowFilterDataManager$FilterData;", "Lkotlin/collections/HashMap;", "mPreference", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "selectedFilter", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowFilterDataManager$SelectFilter;", "getFilterData", "filterID", "getSelectedFilter", "handlerAsyncMessage", "", "msg", "Landroid/os/Message;", "onDestroy", "", "onInit", "readFilterDataFromSharedPreference", "readSelectedFilterDataFromSharedPreference", "setFilterData", "filterData", "setSelectedFilter", "filterMaterial", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Companion", "FilterData", "SelectFilter", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowFilterDataManager
  extends IAEQIMManager
{
  public static final AEFlashShowFilterDataManager.Companion a = new AEFlashShowFilterDataManager.Companion(null);
  private final SharedPreferences b = BaseApplicationImpl.getApplication().getSharedPreferences("pre_capture_combo_select", 0);
  private AEFlashShowFilterDataManager.SelectFilter c = c();
  private HashMap<String, AEFlashShowFilterDataManager.FilterData> d = b();
  private final Handler e = new Handler(ThreadManager.getSubThreadLooper(), (Handler.Callback)new AEFlashShowFilterDataManager.asyncHandler.1(this));
  
  private final boolean a(Message arg1)
  {
    int i = ???.what;
    if (i != 1) {
      if (i != 3) {
        break label126;
      }
    }
    try
    {
      try
      {
        ??? = new Gson().toJson(this.c);
      }
      finally
      {
        break label76;
      }
    }
    catch (Exception ???)
    {
      label42:
      break label42;
    }
    ??? = "";
    this.b.edit().putString("selected_filter_id", ???).apply();
    ??? = Unit.INSTANCE;
    break label126;
    label76:
    throw ???;
    synchronized (this.d)
    {
      String str = new Gson().toJson(this.d);
      this.b.edit().putString("filter_data", str).apply();
      label126:
      return false;
    }
  }
  
  private final HashMap<String, AEFlashShowFilterDataManager.FilterData> b()
  {
    Object localObject = this.b.getString("filter_data", "");
    if (localObject == null) {
      localObject = "";
    }
    try
    {
      localObject = (HashMap)new Gson().fromJson((String)localObject, new AEFlashShowFilterDataManager.readFilterDataFromSharedPreference.1().getType());
      if (localObject != null) {
        return localObject;
      }
      localObject = new HashMap();
      return localObject;
    }
    catch (JsonSyntaxException localJsonSyntaxException)
    {
      label65:
      break label65;
    }
    return new HashMap();
  }
  
  private final AEFlashShowFilterDataManager.SelectFilter c()
  {
    Object localObject = this.b.getString("selected_filter_id", null);
    try
    {
      localObject = (AEFlashShowFilterDataManager.SelectFilter)new Gson().fromJson((String)localObject, AEFlashShowFilterDataManager.SelectFilter.class);
      return localObject;
    }
    catch (Exception localException)
    {
      label32:
      break label32;
    }
    return null;
  }
  
  @Nullable
  public final AEFlashShowFilterDataManager.SelectFilter a()
  {
    try
    {
      AEFlashShowFilterDataManager.SelectFilter localSelectFilter = this.c;
      return localSelectFilter;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(@Nullable MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial != null) {}
    try
    {
      String str1 = paramMetaMaterial.id;
      Intrinsics.checkExpressionValueIsNotNull(str1, "it.id");
      String str2 = paramMetaMaterial.thumbUrl;
      Intrinsics.checkExpressionValueIsNotNull(str2, "it.thumbUrl");
      String str3 = paramMetaMaterial.packageUrl;
      Intrinsics.checkExpressionValueIsNotNull(str3, "it.packageUrl");
      paramMetaMaterial = new AEFlashShowFilterDataManager.SelectFilter(str1, str2, str3, FilterMetaMaterialKt.k(paramMetaMaterial));
      break label70;
      paramMetaMaterial = (AEFlashShowFilterDataManager)this;
      paramMetaMaterial = (AEFlashShowFilterDataManager.SelectFilter)null;
      label70:
      this.c = paramMetaMaterial;
      paramMetaMaterial = Unit.INSTANCE;
      if (this.e.hasMessages(3)) {
        this.e.removeMessages(3);
      }
      this.e.sendEmptyMessage(3);
      return;
    }
    finally {}
  }
  
  public final void a(@NotNull String paramString, @NotNull AEFlashShowFilterDataManager.FilterData paramFilterData)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filterID");
    Intrinsics.checkParameterIsNotNull(paramFilterData, "filterData");
    synchronized (this.d)
    {
      ((Map)this.d).put(paramString, paramFilterData);
      paramString = Unit.INSTANCE;
      if (this.e.hasMessages(1)) {
        this.e.removeMessages(1);
      }
      this.e.sendEmptyMessage(1);
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowFilterDataManager
 * JD-Core Version:    0.7.0.1
 */