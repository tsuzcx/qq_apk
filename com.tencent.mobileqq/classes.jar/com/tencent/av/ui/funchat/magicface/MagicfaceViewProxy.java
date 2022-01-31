package com.tencent.av.ui.funchat.magicface;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;

public class MagicfaceViewProxy
  implements EffectConfigBase.IEffectConfigCallback
{
  protected RelativeLayout a;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private EffectFaceManager jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager;
  FaceItem jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem;
  protected MagicfaceViewForAV a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  
  public MagicfaceViewProxy(VideoAppInterface paramVideoAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager == null) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager = ((EffectFaceManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3));
    }
  }
  
  private void a(ViewGroup paramViewGroup, boolean paramBoolean, FaceItem paramFaceItem)
  {
    if ("face".equalsIgnoreCase(paramFaceItem.getType())) {
      b(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager.a(paramFaceItem.getId(), paramBoolean, this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV);
      return;
      if ("pendant".equalsIgnoreCase(paramFaceItem.getType())) {
        a(paramViewGroup);
      }
    }
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    Object localObject = new StringBuilder().append("realyShowView : ");
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {}
    for (boolean bool = true;; bool = false)
    {
      AVLog.e("MagicfaceViewProxy", bool);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
      {
        localObject = View.inflate(BaseApplicationImpl.getContext(), 2130969318, null);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131366100));
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV = ((MagicfaceViewForAV)((View)localObject).findViewById(2131366101));
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV.setZOrderMediaOverlay(true);
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV.getHolder().setFormat(-2);
        localObject = paramViewGroup.findViewById(2131362516);
        int i = -1;
        if (localObject != null) {
          i = paramViewGroup.indexOfChild((View)localObject);
        }
        paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, i);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("realyHideView : ");
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {}
    for (boolean bool = true;; bool = false)
    {
      AVLog.c("MagicfaceViewProxy", bool);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV = null;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      }
      return;
    }
  }
  
  public void a(ViewGroup paramViewGroup, String paramString, boolean paramBoolean)
  {
    if (paramViewGroup == null) {
      AVLog.c("MagicfaceViewProxy", "showView: " + paramString);
    }
    do
    {
      return;
      a();
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager.a(this);
      paramString = (FaceItem)this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager.a(paramString);
    } while (paramString == null);
    if (paramString.isUsable())
    {
      a(paramViewGroup, paramBoolean, paramString);
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramViewGroup);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem = paramString;
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager.a(paramString);
  }
  
  public void a(FaceItem paramFaceItem) {}
  
  public void a(FaceItem paramFaceItem, int paramInt) {}
  
  public void a(FaceItem paramFaceItem, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (paramFaceItem != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem.getId().equalsIgnoreCase(paramFaceItem.getId())))
    {
      paramFaceItem = (ViewGroup)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramFaceItem != null) {
        a(paramFaceItem, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem);
      }
    }
  }
  
  public void b(ViewGroup paramViewGroup, String paramString, boolean paramBoolean)
  {
    if (paramViewGroup == null) {}
    while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)) {
      return;
    }
    a();
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager.b(this);
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager.a(0, paramString, paramBoolean);
    a(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.magicface.MagicfaceViewProxy
 * JD-Core Version:    0.7.0.1
 */