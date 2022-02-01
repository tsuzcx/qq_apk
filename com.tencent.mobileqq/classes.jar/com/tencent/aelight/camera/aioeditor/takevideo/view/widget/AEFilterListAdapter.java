package com.tencent.aelight.camera.aioeditor.takevideo.view.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.ProviderViewListener;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingProgress;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.qav.thread.ThreadManager;
import java.util.ArrayList;
import java.util.List;

public class AEFilterListAdapter
  extends RecyclerView.Adapter<AEFilterListAdapter.VH>
{
  private int jdField_a_of_type_Int = 1;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(872415231);
  protected ProviderView.ProviderViewListener a;
  private List<QIMFilterCategoryItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void a(Context paramContext, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (!(paramContext instanceof Activity))
    {
      AEQLog.d("AEFilterListAdapter", "context error.");
      return;
    }
    boolean bool = paramQIMFilterCategoryItem.f();
    int i = 2;
    if (bool)
    {
      WeishiGuideUtils.a(paramContext, paramQIMFilterCategoryItem, 2);
      return;
    }
    if (paramQIMFilterCategoryItem.d()) {
      i = 1;
    }
    AEBaseDataReporter.a().b(i, paramQIMFilterCategoryItem.a);
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", this.jdField_a_of_type_Int);
    paramContext = (Activity)paramContext;
    localCaptureComboManager.a(paramQIMFilterCategoryItem, paramContext, localBundle);
    ((CaptureComboManager)QIMManager.a(5)).a(this.jdField_a_of_type_Int, paramContext);
  }
  
  public AEFilterListAdapter.VH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEFilterListAdapter.VH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558516, paramViewGroup, false));
  }
  
  public List<QIMFilterCategoryItem> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Context paramContext, List<QIMFilterCategoryItem> paramList)
  {
    if (paramList == null)
    {
      AEQLog.d("AEFilterListAdapter", "filter items null.");
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    VideoFilterTools.a(paramContext, this.jdField_a_of_type_JavaUtilList);
    ThreadManager.a().post(new AEFilterListAdapter.1(this));
  }
  
  public void a(ProviderView.ProviderViewListener paramProviderViewListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener = paramProviderViewListener;
  }
  
  public void a(AEFilterListAdapter.VH paramVH, int paramInt)
  {
    Object localObject = AEFilterListAdapter.VH.a(paramVH).getContext();
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramVH.getAdapterPosition());
    AEFilterListAdapter.VH.a(paramVH).setText(localQIMFilterCategoryItem.b);
    AEFilterListAdapter.VH.a(paramVH).setBgCorner(QIMCommonLoadingView.a(7.0F, (Context)localObject));
    AEFilterListAdapter.VH.a(paramVH).setImageDrawable(null);
    AEFilterListAdapter.VH.a(paramVH).setBackgroundResource(0);
    if (localQIMFilterCategoryItem.c())
    {
      AEFilterListAdapter.VH.a(paramVH).setVisibility(8);
      AEFilterListAdapter.VH.b(paramVH).setVisibility(8);
      AEFilterListAdapter.VH.a(paramVH).setBackgroundResource(2130837820);
    }
    else if (localQIMFilterCategoryItem.d())
    {
      AEFilterListAdapter.VH.a(paramVH).setVisibility(8);
      AEFilterListAdapter.VH.b(paramVH).setVisibility(8);
      UIUtils.a(AEFilterListAdapter.VH.a(paramVH), localQIMFilterCategoryItem.d, UIUtils.a((Context)localObject, 70.0F), UIUtils.a((Context)localObject, 70.0F), this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, null);
    }
    else
    {
      UIUtils.a(AEFilterListAdapter.VH.a(paramVH), localQIMFilterCategoryItem.d, UIUtils.a((Context)localObject, 70.0F), UIUtils.a((Context)localObject, 70.0F), this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, null);
      localObject = ((CaptureComboManager)QIMManager.a(5)).a(localQIMFilterCategoryItem);
      if (((FilterSet)localObject).jdField_a_of_type_Int == 1)
      {
        AEFilterListAdapter.VH.a(paramVH).setVisibility(0);
        AEFilterListAdapter.VH.a(paramVH).a(QIMCommonLoadingProgress.a(localObject));
      }
      else
      {
        AEFilterListAdapter.VH.a(paramVH).setVisibility(8);
      }
      paramInt = ((FilterSet)localObject).d();
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            break label298;
          }
        }
        else
        {
          AEFilterListAdapter.VH.b(paramVH).setVisibility(0);
          break label298;
        }
      }
      AEFilterListAdapter.VH.b(paramVH).setVisibility(8);
    }
    label298:
    localObject = VideoFilterTools.a().c(this.jdField_a_of_type_Int);
    boolean bool;
    if (localObject != null) {
      bool = TextUtils.equals(((QIMFilterCategoryItem)localObject).a, localQIMFilterCategoryItem.a);
    } else if (localQIMFilterCategoryItem.c()) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      AEFilterListAdapter.VH.c(paramVH).setVisibility(0);
    } else {
      AEFilterListAdapter.VH.c(paramVH).setVisibility(8);
    }
    AEFilterListAdapter.VH.a(paramVH).setOnClickListener(new AEFilterListAdapter.2(this, localQIMFilterCategoryItem));
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.AEFilterListAdapter
 * JD-Core Version:    0.7.0.1
 */