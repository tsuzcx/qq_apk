package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.RequiresApi;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.intimate.info.LoveTreeInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/intimate/view/LoveTreeView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loveTreeInfo", "Lcom/tencent/mobileqq/activity/aio/intimate/info/LoveTreeInfo;", "treeID", "treeLp", "Landroid/widget/RelativeLayout$LayoutParams;", "treeSize", "treeURL", "", "treeView", "Landroid/widget/ImageView;", "waterID", "waterLp", "waterSize", "waterURL", "waterView", "init", "", "jumpToMiniApp", "showWaterDrop", "show", "", "updateLoveTreeInfo", "updateLoveTreeURL", "url", "updateWaterDropPosition", "level", "updateWaterDropURL", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
@RequiresApi(api=17)
public final class LoveTreeView
  extends RelativeLayout
{
  public static final LoveTreeView.Companion a;
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private LoveTreeInfo jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoLoveTreeInfo;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewLoveTreeView$Companion = new LoveTreeView.Companion(null);
  }
  
  public LoveTreeView(@NotNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public LoveTreeView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public LoveTreeView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private final void a()
  {
    LoveTreeInfo localLoveTreeInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoLoveTreeInfo;
    if (localLoveTreeInfo != null)
    {
      if (!TextUtils.isEmpty((CharSequence)localLoveTreeInfo.c)) {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(getContext(), localLoveTreeInfo.c, 2064, null);
      }
      if (!localLoveTreeInfo.jdField_a_of_type_Boolean) {
        break label80;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B791", "0X800B790", 0, 0, "1", "", "", "");
    }
    for (;;)
    {
      return;
      label80:
      ReportController.b(null, "dc00898", "", "", "0X800B791", "0X800B790", 0, 0, "2", "", "", "");
    }
  }
  
  private final void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoveTreeView", 2, "updateWaterDropPosition level = " + paramInt);
    }
    int i;
    if (paramInt == 0)
    {
      paramInt = ViewUtils.a(10.0F);
      i = ViewUtils.a(10.0F);
    }
    for (;;)
    {
      Object localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("waterLp");
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("waterLp");
      }
      ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("waterView");
      }
      RelativeLayout.LayoutParams localLayoutParams = this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
      if (localLayoutParams == null) {
        Intrinsics.throwUninitializedPropertyAccessException("waterLp");
      }
      ((ImageView)localObject).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      return;
      if (paramInt == 1)
      {
        paramInt = ViewUtils.a(-5.0F);
        i = ViewUtils.a(5.0F);
      }
      else
      {
        paramInt = ViewUtils.a(-10.0F);
        i = ViewUtils.a(0.0F);
      }
    }
  }
  
  private final void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_Int = View.generateViewId();
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("treeView");
    }
    ((ImageView)localObject).setId(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_Int = View.generateViewId();
    paramContext = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("waterView");
    }
    paramContext.setId(this.jdField_b_of_type_Int);
    this.c = ViewUtils.a(100.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(this.c, this.c);
    paramContext = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("treeView");
    }
    paramContext = (View)paramContext;
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("treeLp");
    }
    addView(paramContext, (ViewGroup.LayoutParams)localObject);
    this.d = ViewUtils.a(45.0F);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(this.d, this.d);
    paramContext = this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("waterLp");
    }
    paramContext.addRule(6, this.jdField_a_of_type_Int);
    paramContext = this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("waterLp");
    }
    paramContext.addRule(7, this.jdField_a_of_type_Int);
    paramContext = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("waterView");
    }
    paramContext = (View)paramContext;
    localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("waterLp");
    }
    addView(paramContext, (ViewGroup.LayoutParams)localObject);
    setOnClickListener((View.OnClickListener)new LoveTreeView.init.1(this));
  }
  
  private final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoveTreeView", 2, "updateLoveTreeURL url = " + paramString);
    }
    if (TextUtils.isEmpty((CharSequence)paramString)) {}
    while (Intrinsics.areEqual(paramString, this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = URLDrawable.URLDrawableOptions.obtain();
    paramString.mRequestWidth = this.c;
    paramString.mRequestHeight = this.c;
    paramString.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    paramString.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    paramString = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, paramString);
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("treeView");
    }
    localImageView.setImageDrawable((Drawable)paramString);
  }
  
  private final void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoveTreeView", 2, "showWaterDrop show = " + paramBoolean);
    }
    if (paramBoolean)
    {
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("waterView");
      }
      localImageView.setVisibility(0);
      return;
    }
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("waterView");
    }
    localImageView.setVisibility(8);
  }
  
  private final void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoveTreeView", 2, "updateWaterDropURL url = " + paramString);
    }
    if (TextUtils.isEmpty((CharSequence)paramString)) {}
    while (Intrinsics.areEqual(paramString, this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    paramString = new VasApngFactory.Options();
    paramString.a((Drawable)new ColorDrawable(7));
    paramString.b(this.d);
    paramString.c(this.d);
    Object localObject = this.jdField_b_of_type_JavaLangString;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    paramString = VasApngFactory.a((String)localObject, paramString, null, 4, null);
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("waterView");
    }
    ((ImageView)localObject).setImageDrawable((Drawable)paramString);
  }
  
  public final void a(@Nullable LoveTreeInfo paramLoveTreeInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoLoveTreeInfo = paramLoveTreeInfo;
    if (paramLoveTreeInfo == null)
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    a(paramLoveTreeInfo.jdField_a_of_type_Boolean);
    a(paramLoveTreeInfo.jdField_a_of_type_JavaLangString);
    b(paramLoveTreeInfo.jdField_b_of_type_JavaLangString);
    a(paramLoveTreeInfo.jdField_a_of_type_Int);
    if (paramLoveTreeInfo.jdField_a_of_type_Boolean)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B790", "0X800B790", 0, 0, "1", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B790", "0X800B790", 0, 0, "2", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.LoveTreeView
 * JD-Core Version:    0.7.0.1
 */