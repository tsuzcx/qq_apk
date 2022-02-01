package com.tencent.aelight.camera.aeeditor.module.edit;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.view.TAVCutImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AEEditorImagePagerAdapter
  extends PagerAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "AEEditorImagePagerAdapter";
  private int jdField_a_of_type_Int = 0;
  private SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray;
  private AEEditorImagePagerAdapter.ImagePagerAdapterCallback jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImagePagerAdapter$ImagePagerAdapterCallback;
  private TAVCutImageSession jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  private HashMap<String, AEEditorImageInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private HashMap<Integer, Boolean> b = new HashMap();
  
  public AEEditorImagePagerAdapter(TAVCutImageSession paramTAVCutImageSession, List<String> paramList, List<AEEditorImageInfo> paramList1, SparseArray<String> paramSparseArray, AEEditorImagePagerAdapter.ImagePagerAdapterCallback paramImagePagerAdapterCallback)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = paramTAVCutImageSession;
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImagePagerAdapter$ImagePagerAdapterCallback = paramImagePagerAdapterCallback;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    paramTAVCutImageSession = paramList1.iterator();
    while (paramTAVCutImageSession.hasNext())
    {
      paramList = (AEEditorImageInfo)paramTAVCutImageSession.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramList.jdField_a_of_type_JavaLangString, paramList);
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt, TAVCutImageView paramTAVCutImageView)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setTAVCutImageView(paramInt, paramTAVCutImageView);
    paramViewGroup = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImagePagerAdapter$ImagePagerAdapterCallback;
    if (paramViewGroup != null) {
      paramViewGroup.a(paramInt);
    }
    paramViewGroup = jdField_a_of_type_JavaLangString;
    paramTAVCutImageView = new StringBuilder();
    paramTAVCutImageView.append("render position = ");
    paramTAVCutImageView.append(paramInt);
    AEQLog.b(paramViewGroup, paramTAVCutImageView.toString());
  }
  
  public void a()
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (((Boolean)this.b.get(localInteger)).booleanValue() == true) {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.releaseTAVCutImageView(localInteger.intValue());
      }
    }
  }
  
  public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    this.b.put(Integer.valueOf(paramInt), Boolean.valueOf(false));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.releaseTAVCutImageView(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  @NonNull
  public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2064318571, null);
    TAVCutImageView localTAVCutImageView = (TAVCutImageView)localView.findViewById(2064122670);
    localTAVCutImageView.setOnScaleChangeListener(new AEEditorImagePagerAdapter.1(this));
    localTAVCutImageView.setOnViewDragListener(new AEEditorImagePagerAdapter.2(this));
    localTAVCutImageView.setOnRotationListener(new AEEditorImagePagerAdapter.3(this));
    localTAVCutImageView.setActiveBasePicListener(new AEEditorImagePagerAdapter.4(this, paramInt));
    localTAVCutImageView.setOnClick(new AEEditorImagePagerAdapter.5(this));
    localTAVCutImageView.setLongPressListener(new AEEditorImagePagerAdapter.6(this, paramInt));
    localTAVCutImageView.setZoomResId(2064056473);
    localTAVCutImageView.setTag(Integer.valueOf(paramInt));
    localTAVCutImageView.setGestureCallback(new AEEditorImagePagerAdapter.7(this));
    this.b.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    AEEditorImagePagerAdapter.8 local8 = new AEEditorImagePagerAdapter.8(this, paramViewGroup, paramInt, localTAVCutImageView);
    if (this.jdField_a_of_type_Int == 0) {
      localTAVCutImageView.post(local8);
    } else {
      local8.run();
    }
    paramViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    return localView;
  }
  
  public boolean isViewFromObject(@NonNull View paramView, @NonNull Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImagePagerAdapter
 * JD-Core Version:    0.7.0.1
 */