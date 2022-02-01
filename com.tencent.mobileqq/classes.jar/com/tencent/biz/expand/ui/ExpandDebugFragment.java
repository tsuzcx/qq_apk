package com.tencent.biz.expand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable.Callback;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.expand.NativeNavigateUtils;
import com.tencent.biz.expand.provider.AppRuntimeProvider;
import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendLabelUtils;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/ui/ExpandDebugFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/tencent/biz/expand/provider/AppRuntimeProvider;", "Landroid/view/View$OnClickListener;", "appRuntimeProvider", "(Lcom/tencent/biz/expand/provider/AppRuntimeProvider;)V", "appRuntime", "Lmqq/app/AppRuntime;", "getAppRuntime", "()Lmqq/app/AppRuntime;", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "getCanvas", "()Landroid/graphics/Canvas;", "identify", "", "getIdentify", "()I", "setIdentify", "(I)V", "mapOfCallbacks", "", "", "Landroid/graphics/drawable/Drawable$Callback;", "getMapOfCallbacks", "()Ljava/util/Map;", "urlDrawable", "Lcom/tencent/image/URLDrawable;", "getUrlDrawable", "()Lcom/tencent/image/URLDrawable;", "setUrlDrawable", "(Lcom/tencent/image/URLDrawable;)V", "onClick", "", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ValidFragment"})
public final class ExpandDebugFragment
  extends ReportV4Fragment
  implements View.OnClickListener, AppRuntimeProvider
{
  public static final ExpandDebugFragment.Companion a;
  private int jdField_a_of_type_Int;
  @NotNull
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @NotNull
  private final Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  @NotNull
  public URLDrawable a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  @NotNull
  private final Map<String, Drawable.Callback> jdField_a_of_type_JavaUtilMap;
  
  static
  {
    jdField_a_of_type_ComTencentBizExpandUiExpandDebugFragment$Companion = new ExpandDebugFragment.Companion(null);
  }
  
  public ExpandDebugFragment(@NotNull AppRuntimeProvider paramAppRuntimeProvider)
  {
    this.jdField_a_of_type_ComTencentBizExpandProviderAppRuntimeProvider = paramAppRuntimeProvider;
    this.jdField_a_of_type_Int = System.identityHashCode(this);
    paramAppRuntimeProvider = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
    Intrinsics.checkExpressionValueIsNotNull(paramAppRuntimeProvider, "Bitmap.createBitmap(10, … Bitmap.Config.ARGB_8888)");
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramAppRuntimeProvider;
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_JavaUtilMap = ((Map)new LinkedHashMap());
  }
  
  @NotNull
  public final Canvas a()
  {
    return this.jdField_a_of_type_AndroidGraphicsCanvas;
  }
  
  @NotNull
  public AppRuntime a()
  {
    return this.jdField_a_of_type_ComTencentBizExpandProviderAppRuntimeProvider.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).openFlutterPageForQCircle((Context)getActivity(), "cirSearchDetailWidget", "QQCirSearchDetailWidget", (Map)new HashMap(), null);
      continue;
      Object localObject1 = (Context)getActivity();
      Object localObject2 = a();
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
      }
      ExtendFriendLabelUtils.b((Context)localObject1, (AppInterface)localObject2, 0, "");
      continue;
      localObject1 = NativeNavigateUtils.a;
      localObject2 = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity");
      ((NativeNavigateUtils)localObject1).b((Context)localObject2, "http://www.qq.com");
      continue;
      localObject1 = NativeNavigateUtils.a;
      localObject2 = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity");
      ((NativeNavigateUtils)localObject1).c((Context)localObject2, "mqqapi://forward/url?src_type=web&version=1&url_prefix=aHR0cHM6Ly9pbC5xcS5jb20vc3R1ZHktcm9vbS9pbmRleC5odG1sP193dj0xODk1MDExNSZfYmlkPTQyNDYmX3d3dj0xOTY2MDgmZW50cnk9a3VvbGll");
      continue;
      localObject1 = NativeNavigateUtils.a;
      localObject2 = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity");
      ((NativeNavigateUtils)localObject1).a((Context)localObject2, "mqqapi://miniapp/open?_atype=1&_mappid=1109564055&_mvid=&_path=kl%3Dbattle&_vt=3&via=kl_minigame&_sig=2c6744031c28e4c7ca4eb6feece9ef3268c6238ef295f8e7d444dbf8b6433fac");
      continue;
      ExtendFriendPublicFragmentActivity.a((Context)getActivity(), 0);
      continue;
      localObject1 = (Context)getActivity();
      localObject2 = a();
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
      }
      ExtendFriendLabelUtils.a((Context)localObject1, (AppInterface)localObject2, "qqExpandWidgetTest", "ExpandDebugPage", 0, "");
    }
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131561209, paramViewGroup, false);
    paramViewGroup = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandDebugFragment", 2, "onCreateView fragment [" + this.jdField_a_of_type_Int + ']');
    }
    paramViewGroup = ((Iterable)CollectionsKt.listOf(new Integer[] { Integer.valueOf(2131364233), Integer.valueOf(2131364234), Integer.valueOf(2131364235), Integer.valueOf(2131364236), Integer.valueOf(2131364237), Integer.valueOf(2131364238), Integer.valueOf(2131364239) })).iterator();
    while (paramViewGroup.hasNext()) {
      paramLayoutInflater.findViewById(((Number)paramViewGroup.next()).intValue()).setOnClickListener((View.OnClickListener)this);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = jdField_a_of_type_ComTencentBizExpandUiExpandDebugFragment$Companion.a("image3", "http://gif2apng.sourceforge.net/grace-hoppers-107th-birthday.png", 0, 0);
    paramViewGroup = new ExpandDebugFragment.onCreateView.callback.1(this);
    this.jdField_a_of_type_JavaUtilMap.put("image3", paramViewGroup);
    paramBundle = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("urlDrawable");
    }
    paramBundle.setCallback((Drawable.Callback)paramViewGroup);
    paramViewGroup = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("urlDrawable");
    }
    paramViewGroup.downloadImediatly();
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "root");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandDebugFragment
 * JD-Core Version:    0.7.0.1
 */