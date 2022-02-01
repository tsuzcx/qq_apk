package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.LinkedList;
import java.util.List;

public class PlayViewPagerAdapter
  extends PagerAdapter
{
  public static final String DEFAULT_TAB_ID = "-1";
  private AEPlayShowPageView currentPageView;
  private int lastPos = -1;
  private List<AEMaterialCategory> mCategoryList;
  private Context mContext;
  private VideoStoryCapturePartManager mPartManager;
  
  public PlayViewPagerAdapter(@NonNull Context paramContext, @NonNull VideoStoryCapturePartManager paramVideoStoryCapturePartManager, @NonNull List<AEMaterialCategory> paramList)
  {
    this.mContext = paramContext;
    this.mPartManager = paramVideoStoryCapturePartManager;
    this.mCategoryList = paramList;
  }
  
  private int getLayoutType(int paramInt)
  {
    AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)this.mCategoryList.get(paramInt);
    if (localAEMaterialCategory == null) {
      return 2;
    }
    return localAEMaterialCategory.b;
  }
  
  private List<AEMaterialMetaData> getMaterialList(int paramInt)
  {
    Object localObject = this.mCategoryList;
    if ((localObject != null) && (((List)localObject).size() > paramInt)) {
      localObject = (AEMaterialCategory)this.mCategoryList.get(paramInt);
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((AEMaterialCategory)localObject).jdField_a_of_type_JavaUtilList != null)) {
      return ((AEMaterialCategory)localObject).jdField_a_of_type_JavaUtilList;
    }
    return new LinkedList();
  }
  
  private String getMaterialTabId(int paramInt)
  {
    List localList = this.mCategoryList;
    if ((localList != null) && (localList.size() > paramInt)) {
      return ((AEMaterialCategory)this.mCategoryList.get(paramInt)).jdField_a_of_type_JavaLangString;
    }
    return "-1";
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof AEPlayShowPageView)) {
      ((AEPlayShowPageView)paramObject).onDestroy();
    }
    AEQLog.a("AEPlayShowPart", "page destroy.......");
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    List localList = this.mCategoryList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public AEPlayShowPageView getCurrentPageView()
  {
    return this.currentPageView;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public String getLastMaterialTabId()
  {
    int i = this.lastPos;
    if (i <= 0) {
      return "-1";
    }
    return getMaterialTabId(i);
  }
  
  public List<AEMaterialCategory> getmCategoryList()
  {
    return this.mCategoryList;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AEPlayShowPageView localAEPlayShowPageView = new AEPlayShowPageView(this.mContext, this.mPartManager, getLayoutType(paramInt), getMaterialList(paramInt));
    paramViewGroup.addView(localAEPlayShowPageView);
    return localAEPlayShowPageView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setCategoryList(List<AEMaterialCategory> paramList)
  {
    this.mCategoryList = paramList;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    boolean bool = paramObject instanceof AEPlayShowPageView;
    if (bool) {
      this.currentPageView = ((AEPlayShowPageView)paramObject);
    }
    if (this.lastPos != paramInt)
    {
      this.lastPos = paramInt;
      paramViewGroup = this.mCategoryList;
      if ((paramViewGroup != null) && (paramViewGroup.size() > paramInt))
      {
        paramViewGroup = (AEMaterialCategory)this.mCategoryList.get(paramInt);
        if (paramViewGroup != null)
        {
          paramObject = AEBaseReportParam.a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramViewGroup.jdField_a_of_type_JavaLangString);
          localStringBuilder.append("");
          paramObject.n(localStringBuilder.toString());
        }
      }
      if (bool)
      {
        this.currentPageView.post(new PlayViewPagerAdapter.1(this, paramInt));
        this.currentPageView.initDownloadObservers();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.PlayViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */