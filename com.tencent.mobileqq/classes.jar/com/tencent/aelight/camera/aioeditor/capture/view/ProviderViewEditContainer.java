package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ProviderViewEditContainer
  extends FrameLayout
{
  private int jdField_a_of_type_Int = 100;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private IFaceSelectedListener jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener;
  private ProviderView.ProviderViewListener jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener;
  private ProviderView jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView;
  private HashMap<Integer, ProviderView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int[] jdField_a_of_type_ArrayOfInt = { 103, 107 };
  private int b = 0;
  
  public ProviderViewEditContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProviderViewEditContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProviderViewEditContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private ProviderView a(int paramInt)
  {
    if (paramInt != 103)
    {
      if (paramInt != 107) {
        return null;
      }
      MusicFragmentProviderView localMusicFragmentProviderView = new MusicFragmentProviderView(getContext());
      localMusicFragmentProviderView.setNeedTabBar(false);
      return localMusicFragmentProviderView;
    }
    return new StaticStickerProviderView(getContext());
  }
  
  private boolean a(int paramInt, Object... paramVarArgs)
  {
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      localObject1 = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    else
    {
      localObject2 = a(paramInt);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject2);
        addView((View)localObject2);
        localObject1 = localObject2;
      }
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProviderViewEditContainer", 2, new Object[] { "openContainerProviderView view not exsist, id:", Integer.valueOf(paramInt) });
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView = ((ProviderView)localObject1);
    if (paramInt != 103)
    {
      if (paramInt != 107) {
        return true;
      }
      localObject1 = (MusicFragmentProviderView)localObject1;
      if (!((MusicFragmentProviderView)localObject1).d())
      {
        ((MusicFragmentProviderView)localObject1).d(250);
        ((MusicFragmentProviderView)localObject1).a(null);
        localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener;
        if (localObject2 != null) {
          ((MusicFragmentProviderView)localObject1).setProviderViewListener((ProviderView.ProviderViewListener)localObject2);
        }
      }
      ((MusicFragmentProviderView)localObject1).setCaptureScene(this.b);
      if ((paramVarArgs != null) && (paramVarArgs.length == 1)) {
        ((MusicFragmentProviderView)localObject1).setMusicProviderView((MusicItemInfo)paramVarArgs[0]);
      }
      paramVarArgs = getLayoutParams();
      paramInt = UIUtils.a(getContext(), 250.0F);
      if (paramVarArgs.height != paramInt)
      {
        paramVarArgs.height = paramInt;
        setLayoutParams(paramVarArgs);
      }
      paramVarArgs = getLayoutParams();
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramVarArgs.height += this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        setLayoutParams(paramVarArgs);
      }
      this.jdField_a_of_type_Int = 107;
      return true;
    }
    Object localObject1 = (StaticStickerProviderView)localObject1;
    if (!((StaticStickerProviderView)localObject1).d())
    {
      ((StaticStickerProviderView)localObject1).a(null);
      ((StaticStickerProviderView)localObject1).setOnFaceSelectedListener(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener);
    }
    ((StaticStickerProviderView)localObject1).setCaptureScene(this.b);
    ((StaticStickerProviderView)localObject1).i();
    ((StaticStickerProviderView)localObject1).c();
    if ((paramVarArgs != null) && (paramVarArgs.length == 1)) {
      ((StaticStickerProviderView)localObject1).a((GestureHelper.ZoomItem)paramVarArgs[0]);
    }
    paramVarArgs = getLayoutParams();
    paramInt = UIUtils.a(getContext(), 250.0F);
    if (paramVarArgs.height != paramInt)
    {
      paramVarArgs.height = paramInt;
      setLayoutParams(paramVarArgs);
    }
    this.jdField_a_of_type_Int = 103;
    return true;
  }
  
  public void a()
  {
    setVisibility(8);
    ProviderView localProviderView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView;
    if (localProviderView != null)
    {
      localProviderView.d();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView = null;
    }
    this.jdField_a_of_type_Int = 100;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!a(paramInt, paramVarArgs)) {
      return;
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView;
    if (paramVarArgs != null)
    {
      paramVarArgs.setVisibility(0);
      setVisibility(0);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int != 100)
    {
      if (getVisibility() != 0) {
        return false;
      }
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
      if (localObject == null) {
        return false;
      }
      localObject = (ProviderView)((HashMap)localObject).get(Integer.valueOf(this.jdField_a_of_type_Int));
      if (localObject != null) {
        return ((ProviderView)localObject).a();
      }
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView != null) && (getVisibility() == 0)) {
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.a(paramMotionEvent);
    }
    return false;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).b();
    }
  }
  
  public void setLiuHaiParentView(RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
  }
  
  public void setProviderViewListener(ProviderView.ProviderViewListener paramProviderViewListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener = paramProviderViewListener;
  }
  
  public void setStickerListener(IFaceSelectedListener paramIFaceSelectedListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener = paramIFaceSelectedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.ProviderViewEditContainer
 * JD-Core Version:    0.7.0.1
 */