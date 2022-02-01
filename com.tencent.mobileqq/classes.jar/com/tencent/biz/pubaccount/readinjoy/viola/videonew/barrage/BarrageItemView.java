package com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.viola.adapter.ui.ComponentAdapter;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appearState", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageItemView$AppearState;", "getAppearState", "()Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageItemView$AppearState;", "setAppearState", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageItemView$AppearState;)V", "authorImageView", "Landroid/widget/ImageView;", "barrageTextView", "Landroid/widget/TextView;", "barrageType", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageItemView$BarrageType;", "blockDistance", "getBlockDistance", "()I", "setBlockDistance", "(I)V", "busyInLineEntry", "", "getBusyInLineEntry", "()Z", "setBusyInLineEntry", "(Z)V", "componentAdapter", "Lcom/tencent/biz/pubaccount/readinjoy/viola/adapter/ui/ComponentAdapter;", "placeLines", "", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageTrack$BarrageLine;", "getPlaceLines", "()Ljava/util/List;", "setPlaceLines", "(Ljava/util/List;)V", "calculateBlockDistance", "updateBarrageBg", "", "alpha", "", "updateUi", "barrageInfo", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageInfo;", "barrageConfig", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageConfig;", "AppearState", "BarrageType", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class BarrageItemView
  extends LinearLayout
{
  public static final BarrageItemView.Companion a;
  private static final int b = DisplayUtil.a((Context)BaseApplication.getContext(), 10.0F);
  private static final int c = DisplayUtil.a((Context)BaseApplication.getContext(), 24.0F);
  private int jdField_a_of_type_Int;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final ComponentAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterUiComponentAdapter = new ComponentAdapter();
  @NotNull
  private BarrageItemView.AppearState jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView$AppearState = BarrageItemView.AppearState.NONE;
  private BarrageItemView.BarrageType jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView$BarrageType = BarrageItemView.BarrageType.SHORT;
  @NotNull
  private List<BarrageTrack.BarrageLine> jdField_a_of_type_JavaUtilList = CollectionsKt.emptyList();
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView$Companion = new BarrageItemView.Companion(null);
  }
  
  @JvmOverloads
  public BarrageItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public BarrageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public BarrageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131560544, (ViewGroup)this);
    paramContext = findViewById(2131380227);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_barrage)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(2131369573);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_author)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    a(0.2F);
    setPadding(b, 0, b, 0);
    setGravity(16);
    setMinimumHeight(c);
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
  }
  
  private final void a(float paramFloat)
  {
    Drawable localDrawable = getResources().getDrawable(2130841868);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "shapeDrawable");
    localDrawable.setAlpha((int)('ÿ' * paramFloat));
    setBackgroundDrawable(localDrawable);
  }
  
  private final int c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView$BarrageType == BarrageItemView.BarrageType.DOUBLE_LINE)
    {
      Size localSize = DisplayUtil.a((Context)BaseApplication.getContext());
      Intrinsics.checkExpressionValueIsNotNull(localSize, "DisplayUtil.getScreenSiz…Application.getContext())");
      return localSize.a() / 2;
    }
    return BarrageController.a.a()[kotlin.random.Random.Default.nextInt(BarrageController.a.a().length)].intValue();
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final BarrageItemView.AppearState a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView$AppearState;
  }
  
  @NotNull
  public final List<BarrageTrack.BarrageLine> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public final void a(@NotNull BarrageInfo paramBarrageInfo, @NotNull BarrageConfig paramBarrageConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramBarrageInfo, "barrageInfo");
    Intrinsics.checkParameterIsNotNull(paramBarrageConfig, "barrageConfig");
    a(paramBarrageConfig.b());
    paramBarrageInfo.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramBarrageInfo.jdField_a_of_type_ComTencentMobileqqTextQQText);
    int i;
    if (paramBarrageInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo$Sender != null)
    {
      paramBarrageConfig = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBarrageInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo$Sender.jdField_a_of_type_Boolean)
      {
        i = 0;
        paramBarrageConfig.setVisibility(i);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView$BarrageType = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView$Companion.a(paramBarrageInfo.b);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView$BarrageType != BarrageItemView.BarrageType.DOUBLE_LINE) {
        break label116;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setLines(2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = c();
      return;
      i = 8;
      break;
      label116:
      this.jdField_a_of_type_AndroidWidgetTextView.setLines(1);
    }
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final void setAppearState(@NotNull BarrageItemView.AppearState paramAppearState)
  {
    Intrinsics.checkParameterIsNotNull(paramAppearState, "<set-?>");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView$AppearState = paramAppearState;
  }
  
  public final void setBlockDistance(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void setBusyInLineEntry(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final void setPlaceLines(@NotNull List<BarrageTrack.BarrageLine> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageItemView
 * JD-Core Version:    0.7.0.1
 */