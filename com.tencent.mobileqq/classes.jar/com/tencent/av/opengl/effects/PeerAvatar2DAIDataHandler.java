package com.tencent.av.opengl.effects;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.avatar2d.Avatar2dItem;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.LinkedList;
import org.light.bean.LightAIDataWrapper;

public class PeerAvatar2DAIDataHandler
{
  protected VideoAppInterface a;
  private AEFilterAVWrapper b = null;
  private LinkedList<LightAIDataWrapper> c = null;
  private VideoMaterial d;
  private VideoMaterial e;
  private int f;
  private int g;
  private int h = -1;
  private String i;
  private String j;
  private GLSurfaceView k;
  private boolean l = false;
  
  public PeerAvatar2DAIDataHandler(VideoAppInterface paramVideoAppInterface, String paramString, GLSurfaceView paramGLSurfaceView)
  {
    this.a = paramVideoAppInterface;
    this.i = paramString;
    this.k = paramGLSurfaceView;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    boolean bool = this.a.d(16);
    String str = "";
    Object localObject;
    if (bool)
    {
      if (TextUtils.isEmpty(paramString))
      {
        localObject = str;
        if (!TextUtils.isEmpty(this.j)) {}
      }
      else
      {
        EffectAvatar2dManager localEffectAvatar2dManager = (EffectAvatar2dManager)this.a.c(16);
        Avatar2dItem localAvatar2dItem = (Avatar2dItem)localEffectAvatar2dManager.b(paramString);
        localObject = str;
        if (localAvatar2dItem != null) {
          if ((!localAvatar2dItem.isUsable()) && (!localAvatar2dItem.isDownloading) && (!TextUtils.isEmpty(localAvatar2dItem.getResUrl())))
          {
            localEffectAvatar2dManager.b(AudioHelper.c(), localAvatar2dItem);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateCurBackgroundById startDownload: ");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("Avatar2DAIDataHandler", 1, ((StringBuilder)localObject).toString());
            localObject = str;
          }
          else
          {
            localObject = str;
            if (localAvatar2dItem.isUsable())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(localEffectAvatar2dManager.a(localAvatar2dItem));
              ((StringBuilder)localObject).append(localAvatar2dItem.a());
              ((StringBuilder)localObject).append(File.separator);
              ((StringBuilder)localObject).append(localAvatar2dItem.a());
              ((StringBuilder)localObject).append(".pag");
              localObject = ((StringBuilder)localObject).toString();
            }
          }
        }
      }
    }
    else
    {
      this.a.a(16, null);
      localObject = str;
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = null;
    }
    if (this.b == null) {
      return;
    }
    bool = TextUtils.isEmpty(this.j);
    if (((TextUtils.isEmpty(paramString) ^ bool)) || ((!bool) && (!this.j.equals(paramString))) || (paramBoolean))
    {
      this.j = paramString;
      this.b.a((String)localObject);
      paramString = new StringBuilder();
      paramString.append("updateCurBackgroundById setPresetData d: ");
      paramString.append((String)localObject);
      QLog.d("Avatar2DAIDataHandler", 1, paramString.toString());
    }
  }
  
  private void b()
  {
    if (this.b != null) {
      a();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Avatar2DAIDataHandler init width:");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append(" height:");
    ((StringBuilder)localObject).append(this.g);
    QLog.d("Avatar2DAIDataHandler", 1, ((StringBuilder)localObject).toString(), new Throwable("打印堆栈"));
    this.b = new AEFilterAVWrapperImpl(0);
    this.b.a(this.f, this.g);
    if (this.h < 0)
    {
      localObject = new int[1];
      GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
      this.h = localObject[0];
    }
  }
  
  private void b(LightAIDataWrapper paramLightAIDataWrapper)
  {
    try
    {
      boolean bool = EffectsRenderController.m();
      if (!bool) {
        return;
      }
      if (this.c.size() > 30) {
        this.c.removeFirst();
      }
      this.c.addLast(paramLightAIDataWrapper);
      return;
    }
    finally {}
  }
  
  private void c()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((LinkedList)localObject).clear();
      this.c = null;
    }
    QLog.d("Avatar2DAIDataHandler", 1, "Avatar2DAIDataHandler unInit ", new Throwable("打印堆栈"));
    localObject = this.b;
    if (localObject != null)
    {
      ((AEFilterAVWrapper)localObject).a(0L);
      this.b.a();
      this.b.b();
      this.b = null;
    }
    int m = this.h;
    if (m != -1)
    {
      localObject = new int[1];
      localObject[0] = m;
      GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
      this.h = -1;
    }
    this.l = false;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    AEFilterAVWrapper localAEFilterAVWrapper = this.b;
    if (localAEFilterAVWrapper == null) {
      return;
    }
    localAEFilterAVWrapper.b(this.f, this.g);
  }
  
  private void c(String paramString)
  {
    if (this.a.d(16))
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.d = null;
      }
      else
      {
        localObject = this.d;
        if ((localObject != null) && (paramString.equals(((VideoMaterial)localObject).getId()))) {
          return;
        }
        this.e = this.d;
        localObject = (EffectAvatar2dManager)this.a.c(16);
        Avatar2dItem localAvatar2dItem = (Avatar2dItem)((EffectAvatar2dManager)localObject).b(paramString);
        if ((localAvatar2dItem != null) && (!localAvatar2dItem.isUsable()) && (!localAvatar2dItem.isDownloading) && (!TextUtils.isEmpty(localAvatar2dItem.getResUrl())))
        {
          ((EffectAvatar2dManager)localObject).b(AudioHelper.c(), localAvatar2dItem);
          this.a.a(new Object[] { Integer.valueOf(525), Boolean.valueOf(true) });
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateCurVideoMaterialById startDownload: ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("Avatar2DAIDataHandler", 1, ((StringBuilder)localObject).toString());
          return;
        }
        if ((localAvatar2dItem != null) && (localAvatar2dItem.isDownloading))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateCurVideoMaterialById downloading: ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("Avatar2DAIDataHandler", 1, ((StringBuilder)localObject).toString());
          return;
        }
        if (!EffectsRenderController.m()) {
          return;
        }
        localObject = ((EffectAvatar2dManager)localObject).c(localAvatar2dItem);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.d = VideoMaterial.loadLightAsset((String)localObject);
        }
      }
      if (this.b == null) {
        b();
      }
      if ((this.d != null) || (this.e != null))
      {
        if (this.d != null)
        {
          localObject = this.e;
          if ((localObject == null) || (!((VideoMaterial)localObject).getId().equals(this.d.getId()))) {}
        }
      }
      else {
        return;
      }
      this.l = true;
      this.b.a(null, this.d);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Avatar2DAIDataHandler updateCurVideoMaterialById=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Avatar2DAIDataHandler", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.a.a(16, null);
  }
  
  public void a()
  {
    this.k.queueEvent(new PeerAvatar2DAIDataHandler.6(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.k.queueEvent(new PeerAvatar2DAIDataHandler.1(this));
  }
  
  public void a(String paramString)
  {
    this.k.queueEvent(new PeerAvatar2DAIDataHandler.4(this, paramString));
  }
  
  public void a(LightAIDataWrapper paramLightAIDataWrapper)
  {
    try
    {
      this.k.queueEvent(new PeerAvatar2DAIDataHandler.3(this, paramLightAIDataWrapper));
      return;
    }
    finally
    {
      paramLightAIDataWrapper = finally;
      throw paramLightAIDataWrapper;
    }
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    try
    {
      int n = this.c.size();
      int m = -1;
      if (n <= 0) {
        return -1;
      }
      if (this.b == null) {
        a(paramInt1, paramInt2);
      }
      c(paramInt1, paramInt2);
      LightAIDataWrapper localLightAIDataWrapper = (LightAIDataWrapper)this.c.pollFirst();
      if (this.l)
      {
        a(this.j, true);
        this.l = false;
      }
      paramInt1 = m;
      if (this.d != null)
      {
        this.b.a(localLightAIDataWrapper);
        paramInt1 = this.b.a(this.h, false);
      }
      return paramInt1;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    this.k.queueEvent(new PeerAvatar2DAIDataHandler.5(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.PeerAvatar2DAIDataHandler
 * JD-Core Version:    0.7.0.1
 */