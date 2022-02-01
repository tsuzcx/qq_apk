package com.tencent.aelight.camera.aeeditor.view.classifier;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.AdapterUtil;
import com.tencent.aelight.camera.aeeditor.util.AEQCircleReport;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public abstract class MaterialContentAdapter
  extends RecyclerView.Adapter<MaterialContentAdapter.ContentItemVH>
{
  private final int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ApplyMaterialTask jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask;
  private MaterialContentAdapter.ItemListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$ItemListener;
  private QQToast.IToastValidListener jdField_a_of_type_ComTencentMobileqqWidgetQQToast$IToastValidListener;
  private List<MetaMaterial> jdField_a_of_type_JavaUtilList;
  protected boolean a;
  private int b = -1;
  private int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  @DrawableRes
  private final int h;
  
  public MaterialContentAdapter(@NonNull Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 1);
  }
  
  public MaterialContentAdapter(@NonNull Context paramContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.d = AIOUtils.b(12.0F, paramContext.getResources());
    this.e = AIOUtils.b(6.0F, paramContext.getResources());
    this.f = AIOUtils.b(2.0F, paramContext.getResources());
    this.g = AIOUtils.b(16.0F, paramContext.getResources());
    if (paramInt1 != 2)
    {
      this.h = 2064056481;
      return;
    }
    this.h = 2064056480;
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial, String paramString)
  {
    if (paramMetaMaterial != null)
    {
      long l = AEQCircleReport.a().a(paramMetaMaterial.id);
      if (l > 0L)
      {
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).P_MATERIAL_DOWNLOAD_FINISH(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT1(), paramMetaMaterial.id), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT3(), String.valueOf(l)), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).KEY_RET_CODE(), paramString) }));
        return;
      }
      AEQLog.b("MaterialContentAdapter", "reportMaterialDownloadCost time < 0");
    }
  }
  
  private void a(ApplyMaterialTask.Status paramStatus, int paramInt, MetaMaterial paramMetaMaterial)
  {
    ApplyMaterialTaskHelper.a("onPostDownloadMaterial", paramMetaMaterial, "start");
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask.a(paramStatus, paramInt, paramMetaMaterial, new MaterialContentAdapter.3(this, paramMetaMaterial, paramStatus, paramInt));
  }
  
  private void b(int paramInt, MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial == null) {
      return;
    }
    if (paramInt == this.b) {
      return;
    }
    this.c = paramInt;
    c(paramInt, paramMetaMaterial);
  }
  
  private void c(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask == null) {
      return;
    }
    ApplyMaterialTaskHelper.a("onPreExecute", paramMetaMaterial, "start");
    if (paramMetaMaterial != null) {
      AEQCircleReport.a().a(paramMetaMaterial.id);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask.a(paramInt, paramMetaMaterial, new MaterialContentAdapter.2(this, paramMetaMaterial, paramInt));
  }
  
  private void d(int paramInt, MetaMaterial paramMetaMaterial)
  {
    MetaMaterialKt.a(paramMetaMaterial, -1);
    ThreadManager.getUIHandler().post(new MaterialContentAdapter.4(this, paramInt));
  }
  
  public int a()
  {
    return this.b;
  }
  
  protected abstract MaterialContentAdapter.ContentItemVH a(ViewGroup paramViewGroup, int paramInt);
  
  public List<MetaMaterial> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt, MetaMaterial paramMetaMaterial)
  {
    b(paramInt, paramMetaMaterial);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" setSelectedIndex:");
      localStringBuilder.append(paramInt);
      QLog.i("MaterialContentAdapter", 2, localStringBuilder.toString());
    }
    if ((paramInt >= 0) && ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager() instanceof LinearLayoutManager))) {
      if (((LinearLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).getOrientation() == 0) {
        AdapterUtil.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.b, paramInt, paramBoolean, false);
      } else {
        AdapterUtil.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.b, paramInt, paramBoolean, false);
      }
    }
    this.b = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ApplyMaterialTask paramApplyMaterialTask)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask = paramApplyMaterialTask;
  }
  
  public final void a(MaterialContentAdapter.ContentItemVH paramContentItemVH, int paramInt)
  {
    MetaMaterial localMetaMaterial = (MetaMaterial)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$ItemListener;
    if (localObject != null) {
      ((MaterialContentAdapter.ItemListener)localObject).a(paramInt, localMetaMaterial);
    }
    if (localMetaMaterial == null) {
      return;
    }
    int i = this.b;
    boolean bool1 = true;
    if (i == paramInt) {
      i = 1;
    } else {
      i = 0;
    }
    if (!TextUtils.isEmpty(MetaMaterialKt.f(localMetaMaterial)))
    {
      paramContentItemVH.a.setVisibility(0);
      paramContentItemVH.a.setText(MetaMaterialKt.f(localMetaMaterial));
      paramContentItemVH.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    else if (TextUtils.isEmpty(localMetaMaterial.thumbUrl))
    {
      paramContentItemVH.a.setVisibility(4);
      paramContentItemVH.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramContentItemVH.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContentItemVH.jdField_b_of_type_AndroidWidgetImageView.setImageResource(this.h);
    }
    else if (localMetaMaterial.thumbUrl.startsWith("http"))
    {
      paramContentItemVH.a.setVisibility(4);
      paramContentItemVH.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramContentItemVH.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      UIUtils.a(paramContentItemVH.jdField_b_of_type_AndroidWidgetImageView, localMetaMaterial.thumbUrl, UIUtils.a(paramContentItemVH.jdField_b_of_type_AndroidWidgetImageView.getContext(), 67.0F), UIUtils.a(paramContentItemVH.jdField_b_of_type_AndroidWidgetImageView.getContext(), 67.0F), ContextCompat.getDrawable(paramContentItemVH.jdField_b_of_type_AndroidWidgetImageView.getContext(), this.h), null);
    }
    else
    {
      paramContentItemVH.a.setVisibility(4);
      paramContentItemVH.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramContentItemVH.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramContentItemVH.jdField_b_of_type_AndroidWidgetImageView.setImageResource(MetaMaterialKt.e(localMetaMaterial));
    }
    if (paramContentItemVH.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramContentItemVH.jdField_b_of_type_AndroidWidgetTextView.setText(MetaMaterialKt.a(localMetaMaterial));
    }
    if (i != 0)
    {
      paramContentItemVH.d.setVisibility(0);
      paramContentItemVH.d.setImageResource(MetaMaterialKt.d(localMetaMaterial));
      MaterialContentAdapter.ContentItemVH.a(paramContentItemVH, false, -1);
      MaterialContentAdapter.ContentItemVH.a(paramContentItemVH, false);
    }
    else
    {
      paramContentItemVH.d.setVisibility(4);
      if (MetaMaterialKt.c(localMetaMaterial))
      {
        i = MetaMaterialKt.c(localMetaMaterial);
        if ((i != -1) && (i != 100))
        {
          MaterialContentAdapter.ContentItemVH.a(paramContentItemVH, true, i);
        }
        else
        {
          MaterialContentAdapter.ContentItemVH.a(paramContentItemVH, false, i);
          localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask;
          if (localObject != null)
          {
            boolean bool2 = ((ApplyMaterialTask)localObject).b(paramInt, localMetaMaterial);
            if ((i != -1) || (bool2) || (!MetaMaterialKt.a(localMetaMaterial))) {
              bool1 = false;
            }
            MaterialContentAdapter.ContentItemVH.a(paramContentItemVH, bool1);
          }
        }
      }
    }
    if (TextUtils.isEmpty(MetaMaterialKt.c(localMetaMaterial)))
    {
      paramContentItemVH.e.setVisibility(4);
    }
    else
    {
      paramContentItemVH.e.setVisibility(0);
      UIUtils.a(paramContentItemVH.e, MetaMaterialKt.c(localMetaMaterial), UIUtils.a(paramContentItemVH.e.getContext(), 26.0F), UIUtils.a(paramContentItemVH.e.getContext(), 26.0F), null, null);
    }
    paramContentItemVH.itemView.setOnClickListener(new MaterialContentAdapter.1(this, paramInt, localMetaMaterial));
    a(paramContentItemVH, paramInt, localMetaMaterial);
  }
  
  protected void a(MaterialContentAdapter.ContentItemVH paramContentItemVH, int paramInt, @NonNull MetaMaterial paramMetaMaterial) {}
  
  public void a(MaterialContentAdapter.ItemListener paramItemListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$ItemListener = paramItemListener;
  }
  
  public void a(QQToast.IToastValidListener paramIToastValidListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast$IToastValidListener = paramIToastValidListener;
  }
  
  public final void a(List<MetaMaterial> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        return false;
      }
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) != null) && (paramString.equals(((MetaMaterial)this.jdField_a_of_type_JavaUtilList.get(i)).id)))
        {
          a(i, (MetaMaterial)this.jdField_a_of_type_JavaUtilList.get(i));
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        return false;
      }
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) != null) && (paramString.equals(((MetaMaterial)this.jdField_a_of_type_JavaUtilList.get(i)).id)))
        {
          a(i, paramBoolean);
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public final MaterialContentAdapter.ContentItemVH b(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = a(paramViewGroup, paramInt);
    if (this.jdField_a_of_type_Int == 1)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramViewGroup.itemView.getLayoutParams();
      if (paramInt == 0) {
        localLayoutParams.leftMargin = this.d;
      } else if (paramInt == 2) {
        localLayoutParams.rightMargin = this.d;
      }
    }
    MaterialContentAdapter.ContentItemVH.a(paramViewGroup, this.e, this.f, this.g);
    return paramViewGroup;
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt == localList.size() - 1)) {
      return 2;
    }
    return 1;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter
 * JD-Core Version:    0.7.0.1
 */