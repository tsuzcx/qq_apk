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
import com.tencent.av.business.manager.pendant.ItemBase;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.ui.ControlUIObserver.RequestPlayMagicFace;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class MagicfaceViewProxy
  implements EffectConfigBase.IEffectConfigCallback<FaceItem>
{
  protected RelativeLayout a;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private EffectFaceManager jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager;
  FaceItem jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem;
  protected MagicfaceViewForAV a;
  WeakReference<ViewGroup> jdField_a_of_type_JavaLangRefWeakReference;
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
  
  private void a(long paramLong, ViewGroup paramViewGroup, boolean paramBoolean, FaceItem paramFaceItem, int paramInt)
  {
    if (paramFaceItem.isSameType("face")) {
      b(paramViewGroup);
    } else if (paramFaceItem.isSameType("pendant")) {
      a(paramViewGroup);
    } else if (paramFaceItem.isSameType("voicesticker")) {
      b(paramViewGroup);
    }
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager.a(paramLong, paramFaceItem, paramFaceItem.getId(), paramBoolean, this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV);
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("realyShowView : ");
    boolean bool;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    AVLog.printErrorLog("MagicfaceViewProxy", ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      localObject = View.inflate(BaseApplicationImpl.getContext(), 2131559722, null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131370610));
      this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV = ((MagicfaceViewForAV)((View)localObject).findViewById(2131370608));
      this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV.setZOrderMediaOverlay(true);
      this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV.getHolder().setFormat(-2);
      localObject = paramViewGroup.findViewById(2131373660);
      int i = -1;
      if (localObject != null) {
        i = paramViewGroup.indexOfChild((View)localObject);
      }
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, i);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void a(long paramLong, ViewGroup paramViewGroup, ControlUIObserver.RequestPlayMagicFace paramRequestPlayMagicFace)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showView, requestPlayMagicFace[");
    ((StringBuilder)localObject).append(paramRequestPlayMagicFace);
    ((StringBuilder)localObject).append("], mRootView[");
    boolean bool1;
    if (paramViewGroup != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append("], mItem[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("MagicfaceViewProxy", 1, ((StringBuilder)localObject).toString());
    if (paramViewGroup == null) {
      return;
    }
    a();
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager.a(paramLong, this);
    localObject = (FaceItem)this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager.a(paramRequestPlayMagicFace.c);
    boolean bool2;
    if (localObject != null)
    {
      EffectSupportManager localEffectSupportManager = (EffectSupportManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5);
      bool1 = localEffectSupportManager.a(3, "normal");
      bool2 = localEffectSupportManager.a(3, "interact");
      if ((bool1) && ((bool2) || (!((FaceItem)localObject).isInteract()))) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1) {
        if (((FaceItem)localObject).isUsable())
        {
          a(paramLong, paramViewGroup, paramRequestPlayMagicFace.b, (FaceItem)localObject, paramRequestPlayMagicFace.a);
          bool2 = bool1;
        }
        else
        {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramViewGroup);
          this.jdField_a_of_type_Boolean = paramRequestPlayMagicFace.b;
          this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem = ((FaceItem)localObject);
          this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager.a(paramRequestPlayMagicFace.a(), (ItemBase)localObject);
          bool2 = bool1;
        }
      }
    }
    else
    {
      bool2 = false;
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("showView, dimmed[");
    paramViewGroup.append(bool2);
    paramViewGroup.append("], item[");
    paramViewGroup.append(localObject);
    paramViewGroup.append("]");
    QLog.w("MagicfaceViewProxy", 1, paramViewGroup.toString());
  }
  
  public void a(long paramLong, FaceItem paramFaceItem) {}
  
  public void a(long paramLong, FaceItem paramFaceItem, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (paramFaceItem != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem;
      if ((localObject != null) && (((FaceItem)localObject).getId().equalsIgnoreCase(paramFaceItem.getId())))
      {
        localObject = (ViewGroup)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDownloadFinish, prepareShow, seq[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("], FaceItem[");
          localStringBuilder.append(paramFaceItem);
          localStringBuilder.append("]");
          QLog.w("MagicfaceViewProxy", 1, localStringBuilder.toString());
          a(paramLong, (ViewGroup)localObject, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem, 6);
        }
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("realyHideView : ");
    boolean bool;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    AVLog.printColorLog("MagicfaceViewProxy", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null)
    {
      paramViewGroup.removeView((View)localObject);
      this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV = null;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
  }
  
  public void a(ViewGroup paramViewGroup, String paramString, boolean paramBoolean)
  {
    if (paramViewGroup == null) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)) {
      return;
    }
    a();
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager.b(-1048L, this);
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager.a(0, paramString, paramBoolean);
    a(paramViewGroup);
  }
  
  public void a(FaceItem paramFaceItem, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.magicface.MagicfaceViewProxy
 * JD-Core Version:    0.7.0.1
 */