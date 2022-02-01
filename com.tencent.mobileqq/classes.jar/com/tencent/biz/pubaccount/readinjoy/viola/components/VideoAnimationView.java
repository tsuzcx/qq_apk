package com.tencent.biz.pubaccount.readinjoy.viola.components;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import bicl;
import bicm;
import bico;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import com.tencent.viola.ui.view.IVView;
import cooperation.liveroom.LiveRoomGiftCallback;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tuz;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/components/VideoAnimationView;", "Lcom/tencent/mobileqq/vpng/view/VPNGImageView;", "Lcom/tencent/viola/ui/view/IVView;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/components/VideoAnimationComponent;", "Lcooperation/liveroom/LiveRoomGiftCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "componentWeakRef", "Ljava/lang/ref/WeakReference;", "currentState", "", "isAutoPlay", "", "bindComponent", "", "component", "destroy", "fireStateChange", "state", "getComponent", "init", "autoPlay", "src", "", "loop", "onCall", "type", "args", "onSurfaceTextureAvailable", "surface", "Landroid/graphics/SurfaceTexture;", "width", "height", "pause", "play", "playOnSubThread", "resume", "stop", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoAnimationView
  extends VPNGImageView
  implements IVView<VideoAnimationComponent>, LiveRoomGiftCallback
{
  @NotNull
  private static final Map<Integer, Integer> jdField_a_of_type_JavaUtilMap = MapsKt.mutableMapOf(new Pair[] { TuplesKt.to(Integer.valueOf(1), Integer.valueOf(1)), TuplesKt.to(Integer.valueOf(2), Integer.valueOf(2)), TuplesKt.to(Integer.valueOf(3), Integer.valueOf(3)) });
  public static final tuz a;
  private int jdField_a_of_type_Int;
  private WeakReference<VideoAnimationComponent> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Tuz = new tuz(null);
  }
  
  public VideoAnimationView(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  private final void a(int paramInt)
  {
    VideoAnimationComponent localVideoAnimationComponent = a();
    if (localVideoAnimationComponent != null) {
      localVideoAnimationComponent.fireEvent("stateChange", new JSONObject().put("state", paramInt));
    }
  }
  
  private final void f()
  {
    if (this.mVPNGRenderer == null) {
      return;
    }
    this.jdField_a_of_type_Int = 1;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.mVPNGRenderer.a(getWidth(), getHeight());
      bicm localbicm = this.mVPNGRenderer;
      TextureView localTextureView = this.mTextureView;
      Intrinsics.checkExpressionValueIsNotNull(localTextureView, "mTextureView");
      localbicm.a(localTextureView.getSurfaceTexture());
    }
    ThreadManagerV2.executeOnSubThread((Runnable)new VideoAnimationView.playOnSubThread.1(this));
  }
  
  @Nullable
  public VideoAnimationComponent a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (VideoAnimationComponent)localWeakReference.get();
    }
    return null;
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_Int == 1) {
      return;
    }
    f();
  }
  
  public void a(@Nullable VideoAnimationComponent paramVideoAnimationComponent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoAnimationComponent);
  }
  
  public final void a(boolean paramBoolean1, @NotNull String paramString, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "src");
    this.jdField_a_of_type_Boolean = paramBoolean1;
    setVideo(paramString, paramBoolean2, 1, (LiveRoomGiftCallback)this);
  }
  
  public final void b()
  {
    if ((this.jdField_a_of_type_Int == 1) && (this.mVPNGRenderer != null))
    {
      this.mVPNGRenderer.i();
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public final void c()
  {
    if ((this.jdField_a_of_type_Int == 2) && (this.mVPNGRenderer != null))
    {
      this.mVPNGRenderer.j();
      this.jdField_a_of_type_Int = 1;
      a(1);
    }
  }
  
  public final void d()
  {
    if (((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)) && (this.mVPNGRenderer != null))
    {
      this.mVPNGRenderer.c();
      this.jdField_a_of_type_Int = 3;
    }
  }
  
  public final void e()
  {
    d();
  }
  
  public void onCall(int paramInt, @Nullable String paramString)
  {
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    case 4: 
    case 6: 
      if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 3)) {
        break;
      }
    }
    do
    {
      do
      {
        return;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
      } while ((i == 0) || (i == this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Int = i;
      paramString = (Integer)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    } while (paramString == null);
    a(((Number)paramString).intValue());
  }
  
  public void onSurfaceTextureAvailable(@Nullable SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.mVPNGRenderer == null)
    {
      this.mVPNGRenderer = bico.a().a((bicl)this, this.mWidth, this.mHeight);
      if (this.mVPNGRenderer != null)
      {
        this.mVPNGRenderer.a(this.mVideoPath, this.mAlign, this.mCallback);
        this.mVPNGRenderer.b(this.mIsLoop);
      }
    }
    if ((this.jdField_a_of_type_Boolean) && (this.mVPNGRenderer != null))
    {
      this.mVPNGRenderer.a(paramInt1, paramInt2);
      this.mVPNGRenderer.a(paramSurfaceTexture);
      f();
    }
    paramSurfaceTexture = this.mTextureView;
    Intrinsics.checkExpressionValueIsNotNull(paramSurfaceTexture, "mTextureView");
    paramSurfaceTexture.setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.components.VideoAnimationView
 * JD-Core Version:    0.7.0.1
 */