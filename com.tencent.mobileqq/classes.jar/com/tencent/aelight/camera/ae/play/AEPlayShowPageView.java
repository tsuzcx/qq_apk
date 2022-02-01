package com.tencent.aelight.camera.ae.play;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;

public class AEPlayShowPageView
  extends FrameLayout
{
  private static final AEPlayShowGridAdapter.SizeInfo ONE_COLUMN_SIZE = calcSizeInfo(1);
  private static final String TAG = "AEPlayShowPageView";
  private static final AEPlayShowGridAdapter.SizeInfo TWO_COLUMN_SIZE = calcSizeInfo(2);
  private GridLayoutManager gridLayoutManager;
  private List<AEMaterialMetaData> mInfoWrappers;
  private int mLayoutType = 2;
  private VideoStoryCapturePartManager mPartManger;
  private AEPlayShowGridAdapter mPlayShowGridAdapter;
  private RecyclerView mPlayShowGridView;
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, @NonNull VideoStoryCapturePartManager paramVideoStoryCapturePartManager, int paramInt2, @NonNull List<AEMaterialMetaData> paramList)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    initConfig(paramVideoStoryCapturePartManager, paramInt2, paramList);
    initViews(paramContext);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @NonNull VideoStoryCapturePartManager paramVideoStoryCapturePartManager, int paramInt, @NonNull List<AEMaterialMetaData> paramList)
  {
    this(paramContext, paramAttributeSet, 0, paramVideoStoryCapturePartManager, paramInt, paramList);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @NonNull VideoStoryCapturePartManager paramVideoStoryCapturePartManager, int paramInt, @NonNull List<AEMaterialMetaData> paramList)
  {
    this(paramContext, null, paramVideoStoryCapturePartManager, paramInt, paramList);
  }
  
  private static AEPlayShowGridAdapter.SizeInfo calcSizeInfo(int paramInt)
  {
    int j = ViewUtils.dip2px(10.0F);
    int k = ViewUtils.dip2px(4.0F);
    int m = (int)(k * 0.96F);
    int i;
    if (paramInt == 1) {
      i = ViewUtils.getScreenWidth() - j * 2 - k * 2;
    } else {
      i = (ViewUtils.getScreenWidth() - j * 2 - k * 4) / 2;
    }
    int n = (int)(i * 0.96F * 59.0F / 34.0F);
    AEPlayShowGridAdapter.SizeInfo localSizeInfo = new AEPlayShowGridAdapter.SizeInfo();
    localSizeInfo.itemWidth = (i + k * 2);
    localSizeInfo.itemHeight = (n + m * 2);
    localSizeInfo.itemHorizontalPadding = k;
    localSizeInfo.itemVerticalPadding = m;
    if (paramInt == 1) {
      localSizeInfo.itemVerticalPadding = j;
    }
    return localSizeInfo;
  }
  
  private void clearPositionFlag()
  {
    Object localObject = this.mPartManger;
    if (localObject == null) {
      return;
    }
    localObject = ((VideoStoryCapturePartManager)localObject).a(65537, new Object[0]);
    if ((localObject instanceof AEPituCameraUnit))
    {
      localObject = (AEPituCameraUnit)localObject;
      if ((((AEPituCameraUnit)localObject).s() != null) && (((AEPituCameraUnit)localObject).s().getIntent() != null))
      {
        ((AEPituCameraUnit)localObject).s().getIntent().putExtra("KEY_CURRENT_SELECT_ID", "");
        ((AEPituCameraUnit)localObject).s().getIntent().putExtra("KEY_CURRENT_TYPE", "");
      }
    }
  }
  
  private void initConfig(@NonNull VideoStoryCapturePartManager paramVideoStoryCapturePartManager, int paramInt, @NonNull List<AEMaterialMetaData> paramList)
  {
    this.mPartManger = paramVideoStoryCapturePartManager;
    this.mLayoutType = paramInt;
    this.mInfoWrappers = paramList;
  }
  
  private void initViews(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2064056418, this, true);
    this.mPlayShowGridView = ((RecyclerView)findViewById(2063990848));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("rv toString ");
    ((StringBuilder)localObject).append(this.mPlayShowGridView.toString());
    AEQLog.a("AEPlayShowPart", ((StringBuilder)localObject).toString());
    this.mPlayShowGridView.addOnScrollListener(new AEPlayShowPageView.1(this));
    if (this.mLayoutType == 1) {
      this.gridLayoutManager = new GridLayoutManager(paramContext, 1, 1, false);
    } else {
      this.gridLayoutManager = new GridLayoutManager(paramContext, 2, 1, false);
    }
    this.mPlayShowGridView.setLayoutManager(this.gridLayoutManager);
    if (this.mLayoutType == 1) {
      localObject = new AEPlayShowGridAdapter.SizeInfo(ONE_COLUMN_SIZE);
    } else {
      localObject = new AEPlayShowGridAdapter.SizeInfo(TWO_COLUMN_SIZE);
    }
    this.mPlayShowGridView.addItemDecoration(new AEPlayShowPageView.2(this, (AEPlayShowGridAdapter.SizeInfo)localObject));
    this.mPlayShowGridAdapter = new AEPlayShowGridAdapter(paramContext, this.mPartManger, (AEPlayShowGridAdapter.SizeInfo)localObject, this.mLayoutType);
    this.mPlayShowGridView.setAdapter(this.mPlayShowGridAdapter);
    updateData(this.mInfoWrappers);
  }
  
  public int getCurrentY()
  {
    RecyclerView localRecyclerView = this.mPlayShowGridView;
    if (localRecyclerView == null) {
      return 0;
    }
    return localRecyclerView.getScrollY();
  }
  
  public void initDownloadObservers()
  {
    this.mPlayShowGridAdapter.initObservers();
  }
  
  public void onDestroy()
  {
    Object localObject = this.mPlayShowGridView;
    if (localObject != null) {
      ((RecyclerView)localObject).removeCallbacks(null);
    }
    localObject = this.mPlayShowGridAdapter;
    if (localObject != null) {
      ((AEPlayShowGridAdapter)localObject).onDestroy();
    }
  }
  
  public void reportItemExpose()
  {
    int i = this.gridLayoutManager.findFirstVisibleItemPosition();
    int j = this.gridLayoutManager.findLastVisibleItemPosition();
    if ((this.mInfoWrappers != null) && (i >= 0))
    {
      if (j < 0) {
        return;
      }
      while (i < this.mInfoWrappers.size())
      {
        if (i > j) {
          return;
        }
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)this.mInfoWrappers.get(i);
        AEBaseReportParam.a().g(localAEMaterialMetaData.P);
        AEBaseReportParam localAEBaseReportParam = AEBaseReportParam.a();
        i += 1;
        localAEBaseReportParam.f(i);
        AEBaseDataReporter.a().f(localAEMaterialMetaData.m);
      }
    }
  }
  
  public void scrollTo(int paramInt)
  {
    RecyclerView localRecyclerView = this.mPlayShowGridView;
    if (localRecyclerView != null) {
      localRecyclerView.scrollTo(0, paramInt);
    }
  }
  
  public void scrollToPosWithClick(int paramInt)
  {
    if (this.mPlayShowGridView != null)
    {
      Object localObject = this.gridLayoutManager;
      if (localObject != null) {
        ((GridLayoutManager)localObject).scrollToPositionWithOffset(paramInt, 0);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("out........");
      ((StringBuilder)localObject).append(this.mPlayShowGridView.toString());
      AEQLog.a("AEPlayShowPart", ((StringBuilder)localObject).toString());
      this.mPlayShowGridView.post(new AEPlayShowPageView.3(this, paramInt));
    }
  }
  
  public void setTabId(String paramString)
  {
    this.mPlayShowGridAdapter.setCurTabId(paramString);
  }
  
  public void updateData(@NonNull List<AEMaterialMetaData> paramList)
  {
    AEPlayShowGridAdapter localAEPlayShowGridAdapter = this.mPlayShowGridAdapter;
    if (localAEPlayShowGridAdapter != null) {
      localAEPlayShowGridAdapter.putData(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowPageView
 * JD-Core Version:    0.7.0.1
 */