package com.tencent.biz.pubaccount.readinjoy.viola.components;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.TextureView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vpng.glrenderer.Renderable;
import com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer;
import com.tencent.mobileqq.vpng.glrenderer.VPNGRendererManager;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import com.tencent.viola.ui.view.IVView;
import cooperation.liveroom.LiveRoomGiftCallback;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/components/VideoAnimationView;", "Lcom/tencent/mobileqq/vpng/view/VPNGImageView;", "Lcom/tencent/viola/ui/view/IVView;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/components/VideoAnimationComponent;", "Lcooperation/liveroom/LiveRoomGiftCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "componentWeakRef", "Ljava/lang/ref/WeakReference;", "currentState", "", "isAutoPlay", "", "bindComponent", "", "component", "destroy", "fireStateChange", "state", "getComponent", "getFilePath", "", "src", "init", "autoPlay", "loop", "onCall", "type", "args", "onSurfaceTextureAvailable", "surface", "Landroid/graphics/SurfaceTexture;", "width", "height", "pause", "play", "playOnSubThread", "resume", "setupVideo", "stop", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoAnimationView
  extends VPNGImageView
  implements IVView<VideoAnimationComponent>, LiveRoomGiftCallback
{
  public static final VideoAnimationView.Companion a;
  @NotNull
  private static final Map<Integer, Integer> jdField_a_of_type_JavaUtilMap = MapsKt.mutableMapOf(new Pair[] { TuplesKt.to(Integer.valueOf(1), Integer.valueOf(1)), TuplesKt.to(Integer.valueOf(2), Integer.valueOf(2)), TuplesKt.to(Integer.valueOf(3), Integer.valueOf(3)) });
  private int jdField_a_of_type_Int;
  private WeakReference<VideoAnimationComponent> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaComponentsVideoAnimationView$Companion = new VideoAnimationView.Companion(null);
  }
  
  public VideoAnimationView(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  private final String a(String paramString)
  {
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString, '/', 0, false, 6, null);
    if (i != -1)
    {
      int j = paramString.length();
      if (paramString == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      paramString = paramString.substring(i + 1, j);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (!TextUtils.isEmpty((CharSequence)paramString)) {
        return VFSAssistantUtils.getSDKPrivatePath(new StringBuilder().append(AppConstants.SDCARD_PATH).append(".readInjoy/resource/video_animation/").toString()) + paramString;
      }
    }
    return "";
  }
  
  private final void a(int paramInt)
  {
    VideoAnimationComponent localVideoAnimationComponent = a();
    if (localVideoAnimationComponent != null) {
      localVideoAnimationComponent.fireEvent("stateChange", new JSONObject().put("state", paramInt));
    }
  }
  
  private final void a(String paramString, boolean paramBoolean)
  {
    String str = a(paramString);
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      File localFile = new File(str);
      if (localFile.exists())
      {
        setVideo(str, paramBoolean, 1, (LiveRoomGiftCallback)this);
        return;
      }
      ThreadManagerV2.executeOnSubThread((Runnable)new VideoAnimationView.setupVideo.1(paramString, localFile));
    }
    setVideo(paramString, paramBoolean, 1, (LiveRoomGiftCallback)this);
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
      VPNGRenderer localVPNGRenderer = this.mVPNGRenderer;
      TextureView localTextureView = this.mTextureView;
      Intrinsics.checkExpressionValueIsNotNull(localTextureView, "mTextureView");
      localVPNGRenderer.a(localTextureView.getSurfaceTexture());
    }
    playRender();
    a(1);
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
    setPlayOnSubThread(true);
    a(paramString, paramBoolean2);
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
      this.mVPNGRenderer = VPNGRendererManager.a().a((Renderable)this, this.mWidth, this.mHeight);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.components.VideoAnimationView
 * JD-Core Version:    0.7.0.1
 */