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
  private IFaceSelectedListener a;
  private ProviderView b;
  private ProviderView.ProviderViewListener c;
  private int d = 100;
  private int e = 0;
  private RelativeLayout f;
  private HashMap<Integer, ProviderView> g = new HashMap();
  private int[] h = { 103, 107 };
  
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
  
  private ProviderView b(int paramInt)
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
  
  private boolean b(int paramInt, Object... paramVarArgs)
  {
    Object localObject2;
    if (this.g.containsKey(Integer.valueOf(paramInt)))
    {
      localObject1 = (ProviderView)this.g.get(Integer.valueOf(paramInt));
    }
    else
    {
      localObject2 = b(paramInt);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        this.g.put(Integer.valueOf(paramInt), localObject2);
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
    this.b = ((ProviderView)localObject1);
    if (paramInt != 103)
    {
      if (paramInt != 107) {
        return true;
      }
      localObject1 = (MusicFragmentProviderView)localObject1;
      if (!((MusicFragmentProviderView)localObject1).l())
      {
        ((MusicFragmentProviderView)localObject1).d(250);
        ((MusicFragmentProviderView)localObject1).a(null);
        localObject2 = this.c;
        if (localObject2 != null) {
          ((MusicFragmentProviderView)localObject1).setProviderViewListener((ProviderView.ProviderViewListener)localObject2);
        }
      }
      ((MusicFragmentProviderView)localObject1).setCaptureScene(this.e);
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
      if (this.f != null)
      {
        paramVarArgs.height += this.f.getHeight();
        setLayoutParams(paramVarArgs);
      }
      this.d = 107;
      return true;
    }
    Object localObject1 = (StaticStickerProviderView)localObject1;
    if (!((StaticStickerProviderView)localObject1).l())
    {
      ((StaticStickerProviderView)localObject1).a(null);
      ((StaticStickerProviderView)localObject1).setOnFaceSelectedListener(this.a);
    }
    ((StaticStickerProviderView)localObject1).setCaptureScene(this.e);
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
    this.d = 103;
    return true;
  }
  
  public void a()
  {
    setVisibility(8);
    ProviderView localProviderView = this.b;
    if (localProviderView != null)
    {
      localProviderView.d();
      this.b.setVisibility(8);
      this.b = null;
    }
    this.d = 100;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!b(paramInt, paramVarArgs)) {
      return;
    }
    paramVarArgs = this.b;
    if (paramVarArgs != null)
    {
      paramVarArgs.setVisibility(0);
      setVisibility(0);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((this.b != null) && (getVisibility() == 0)) {
      return this.b.a(paramMotionEvent);
    }
    return false;
  }
  
  public void b()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).b();
    }
  }
  
  public boolean c()
  {
    if (this.d != 100)
    {
      if (getVisibility() != 0) {
        return false;
      }
      Object localObject = this.g;
      if (localObject == null) {
        return false;
      }
      localObject = (ProviderView)((HashMap)localObject).get(Integer.valueOf(this.d));
      if (localObject != null) {
        return ((ProviderView)localObject).k();
      }
    }
    return false;
  }
  
  public void setLiuHaiParentView(RelativeLayout paramRelativeLayout)
  {
    this.f = paramRelativeLayout;
  }
  
  public void setProviderViewListener(ProviderView.ProviderViewListener paramProviderViewListener)
  {
    this.c = paramProviderViewListener;
  }
  
  public void setStickerListener(IFaceSelectedListener paramIFaceSelectedListener)
  {
    this.a = paramIFaceSelectedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.ProviderViewEditContainer
 * JD-Core Version:    0.7.0.1
 */