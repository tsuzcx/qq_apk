package com.tencent.aelight.camera.aioeditor.takevideo.view.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureComboListener;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.ProviderViewListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AEFilterContentView
  extends FrameLayout
  implements CaptureComboManager.CaptureComboListener
{
  private RecyclerView a;
  private AEFilterListAdapter b;
  private CaptureComboManager c;
  
  public AEFilterContentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEFilterContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEFilterContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    addView(LayoutInflater.from(paramContext).inflate(2131624070, this, false));
    a(paramContext);
    this.c = ((CaptureComboManager)QIMManager.a(5));
    this.c.a(this);
  }
  
  private void a(Context paramContext)
  {
    this.a = ((RecyclerView)findViewById(2131445203));
    this.b = new AEFilterListAdapter();
    this.a.setAdapter(this.b);
    paramContext = new LinearLayoutManager(paramContext, 0, false);
    this.a.setLayoutManager(paramContext);
  }
  
  private void a(FilterSet paramFilterSet)
  {
    if ((paramFilterSet != null) && ((paramFilterSet.e instanceof QIMFilterCategoryItem)))
    {
      paramFilterSet = ((QIMFilterCategoryItem)paramFilterSet.e).a;
      List localList = this.b.a();
      if ((paramFilterSet != null) && (localList != null))
      {
        int i = 0;
        while (i < localList.size())
        {
          if (paramFilterSet.equals(((QIMFilterCategoryItem)localList.get(i)).a))
          {
            this.a.scrollToPosition(i);
            return;
          }
          i += 1;
        }
      }
      return;
    }
    AEQLog.d("AEFilterContainerView", "filterSet is null.");
  }
  
  private void b(int paramInt)
  {
    this.b.a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "FilterProviderView onCreate");
    }
    Object localObject = null;
    CaptureComboManager localCaptureComboManager = this.c;
    if (localCaptureComboManager != null) {
      localObject = localCaptureComboManager.l;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AEFilterContainerView", 2, "filterProviderView get data is null");
      }
    }
    else
    {
      localObject = ((VideoFilterTools.ComboFilterData)localObject).a(paramInt);
      if (localObject != null)
      {
        this.b.a(getContext(), VideoFilterTools.ComboFilterData.a(((VideoFilterTools.DataSet)localObject).c));
        return;
      }
      AEQLog.d("AEFilterContainerView", "dataSet is null");
    }
  }
  
  public void a(int paramInt)
  {
    b(paramInt);
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData) {}
  
  public void a(ComboSet paramComboSet) {}
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    this.b.notifyDataSetChanged();
    a(paramFilterSet);
  }
  
  public int getFilterCount()
  {
    AEFilterListAdapter localAEFilterListAdapter = this.b;
    if (localAEFilterListAdapter != null) {
      return localAEFilterListAdapter.getItemCount();
    }
    return 0;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    CaptureComboManager localCaptureComboManager = this.c;
    if (localCaptureComboManager != null) {
      localCaptureComboManager.a(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    CaptureComboManager localCaptureComboManager = this.c;
    if (localCaptureComboManager != null) {
      localCaptureComboManager.b(this);
    }
  }
  
  public void setProviderViewListener(ProviderView.ProviderViewListener paramProviderViewListener)
  {
    AEFilterListAdapter localAEFilterListAdapter = this.b;
    if (localAEFilterListAdapter != null) {
      localAEFilterListAdapter.a(paramProviderViewListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.AEFilterContentView
 * JD-Core Version:    0.7.0.1
 */