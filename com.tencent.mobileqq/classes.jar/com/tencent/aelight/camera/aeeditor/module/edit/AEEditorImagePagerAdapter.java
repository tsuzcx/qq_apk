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
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.qcircle.tavcut.view.TAVCutImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AEEditorImagePagerAdapter
  extends PagerAdapter
{
  private static final String a = "AEEditorImagePagerAdapter";
  private TAVCutImageSession b;
  private List<String> c = new ArrayList();
  private HashMap<String, AEEditorImageInfo> d = new HashMap();
  private SparseArray<String> e;
  private AEEditorImagePagerAdapter.ImagePagerAdapterCallback f;
  private int g = 0;
  private HashMap<Integer, Boolean> h = new HashMap();
  
  public AEEditorImagePagerAdapter(TAVCutImageSession paramTAVCutImageSession, List<String> paramList, List<AEEditorImageInfo> paramList1, SparseArray<String> paramSparseArray, AEEditorImagePagerAdapter.ImagePagerAdapterCallback paramImagePagerAdapterCallback)
  {
    this.b = paramTAVCutImageSession;
    this.e = paramSparseArray;
    this.f = paramImagePagerAdapterCallback;
    if (paramList != null) {
      this.c = paramList;
    }
    paramTAVCutImageSession = paramList1.iterator();
    while (paramTAVCutImageSession.hasNext())
    {
      paramList = (AEEditorImageInfo)paramTAVCutImageSession.next();
      this.d.put(paramList.a, paramList);
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt, TAVCutImageView paramTAVCutImageView)
  {
    this.b.setTAVCutImageView(paramInt, paramTAVCutImageView);
    paramViewGroup = this.f;
    if (paramViewGroup != null) {
      paramViewGroup.a(paramInt);
    }
    paramViewGroup = a;
    paramTAVCutImageView = new StringBuilder();
    paramTAVCutImageView.append("render position = ");
    paramTAVCutImageView.append(paramInt);
    AEQLog.b(paramViewGroup, paramTAVCutImageView.toString());
  }
  
  public void a()
  {
    Iterator localIterator = this.h.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (((Boolean)this.h.get(localInteger)).booleanValue() == true) {
        this.b.releaseTAVCutImageView(localInteger.intValue());
      }
    }
  }
  
  public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    this.h.put(Integer.valueOf(paramInt), Boolean.valueOf(false));
    this.b.releaseTAVCutImageView(paramInt);
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  @NonNull
  public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2064056443, null);
    TAVCutImageView localTAVCutImageView = (TAVCutImageView)localView.findViewById(2063991468);
    localTAVCutImageView.setOnScaleChangeListener(new AEEditorImagePagerAdapter.1(this));
    localTAVCutImageView.setOnViewDragListener(new AEEditorImagePagerAdapter.2(this));
    localTAVCutImageView.setOnRotationListener(new AEEditorImagePagerAdapter.3(this));
    localTAVCutImageView.setActiveBasePicListener(new AEEditorImagePagerAdapter.4(this, paramInt));
    localTAVCutImageView.setOnClick(new AEEditorImagePagerAdapter.5(this));
    localTAVCutImageView.setLongPressListener(new AEEditorImagePagerAdapter.6(this, paramInt));
    localTAVCutImageView.setZoomResId(2063925441);
    localTAVCutImageView.setTag(Integer.valueOf(paramInt));
    localTAVCutImageView.setGestureCallback(new AEEditorImagePagerAdapter.7(this));
    this.h.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    AEEditorImagePagerAdapter.8 local8 = new AEEditorImagePagerAdapter.8(this, paramViewGroup, paramInt, localTAVCutImageView);
    if (this.g == 0) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImagePagerAdapter
 * JD-Core Version:    0.7.0.1
 */