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
  protected MagicfaceViewForAV b;
  WeakReference<ViewGroup> c;
  boolean d;
  FaceItem e;
  private VideoAppInterface f;
  private EffectFaceManager g;
  
  public MagicfaceViewProxy(VideoAppInterface paramVideoAppInterface, Context paramContext)
  {
    this.f = paramVideoAppInterface;
  }
  
  private void a()
  {
    if (this.g == null) {
      this.g = ((EffectFaceManager)this.f.c(3));
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
    this.g.a(paramLong, paramFaceItem, paramFaceItem.getId(), paramBoolean, this.b);
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("realyShowView : ");
    boolean bool;
    if (this.a == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    AVLog.printErrorLog("MagicfaceViewProxy", ((StringBuilder)localObject).toString());
    if (this.a == null)
    {
      localObject = View.inflate(BaseApplicationImpl.getContext(), 2131625762, null);
      this.a = ((RelativeLayout)((View)localObject).findViewById(2131437884));
      this.b = ((MagicfaceViewForAV)((View)localObject).findViewById(2131437882));
      this.b.setZOrderMediaOverlay(true);
      this.b.getHolder().setFormat(-2);
      localObject = paramViewGroup.findViewById(2131441334);
      int i = -1;
      if (localObject != null) {
        i = paramViewGroup.indexOfChild((View)localObject);
      }
      paramViewGroup.addView(this.a, i);
    }
    this.a.setVisibility(0);
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
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("MagicfaceViewProxy", 1, ((StringBuilder)localObject).toString());
    if (paramViewGroup == null) {
      return;
    }
    a();
    this.g.a(paramLong, this);
    localObject = (FaceItem)this.g.b(paramRequestPlayMagicFace.b);
    boolean bool2;
    if (localObject != null)
    {
      EffectSupportManager localEffectSupportManager = (EffectSupportManager)this.f.c(5);
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
          a(paramLong, paramViewGroup, paramRequestPlayMagicFace.c, (FaceItem)localObject, paramRequestPlayMagicFace.f);
          bool2 = bool1;
        }
        else
        {
          this.c = new WeakReference(paramViewGroup);
          this.d = paramRequestPlayMagicFace.c;
          this.e = ((FaceItem)localObject);
          this.g.b(paramRequestPlayMagicFace.a(), (ItemBase)localObject);
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
    if ((paramBoolean) && (this.c != null) && (paramFaceItem != null))
    {
      Object localObject = this.e;
      if ((localObject != null) && (((FaceItem)localObject).getId().equalsIgnoreCase(paramFaceItem.getId())))
      {
        localObject = (ViewGroup)this.c.get();
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDownloadFinish, prepareShow, seq[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("], FaceItem[");
          localStringBuilder.append(paramFaceItem);
          localStringBuilder.append("]");
          QLog.w("MagicfaceViewProxy", 1, localStringBuilder.toString());
          a(paramLong, (ViewGroup)localObject, this.d, this.e, 6);
        }
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("realyHideView : ");
    boolean bool;
    if (this.a == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    AVLog.printColorLog("MagicfaceViewProxy", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null)
    {
      paramViewGroup.removeView((View)localObject);
      this.b = null;
      this.a = null;
    }
  }
  
  public void a(ViewGroup paramViewGroup, String paramString, boolean paramBoolean)
  {
    if (paramViewGroup == null) {
      return;
    }
    if (!this.f.d(3)) {
      return;
    }
    a();
    this.g.b(-1048L, this);
    this.g.a(0, paramString, paramBoolean);
    a(paramViewGroup);
  }
  
  public void a(FaceItem paramFaceItem, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.magicface.MagicfaceViewProxy
 * JD-Core Version:    0.7.0.1
 */