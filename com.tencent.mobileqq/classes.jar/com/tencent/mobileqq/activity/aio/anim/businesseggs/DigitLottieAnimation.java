package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.AIOAnimator;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule.JumpImage;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.dinifly.RenderMode;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.RandomUtils;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DigitLottieAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  private RelativeLayout d = null;
  private DiniFlyAnimationView e = null;
  private RelativeLayout f = null;
  private final List<Bitmap> g = Collections.synchronizedList(new ArrayList());
  private final Queue<DigitLottieAnimation.EggAnimInfo> h = new LinkedList();
  private final D8SafeAnimatorListener i = new DigitLottieAnimation.1(this);
  
  public DigitLottieAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  @org.jetbrains.annotations.Nullable
  private Bitmap a(LottieImageAsset paramLottieImageAsset, String paramString)
  {
    Object localObject1 = this.f;
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inScaled = true;
    localOptions.inDensity = this.f.getContext().getResources().getDisplayMetrics().densityDpi;
    localObject1 = localObject2;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = localObject2;
      localStringBuilder.append(paramString);
      localObject1 = localObject2;
      localStringBuilder.append(File.separator);
      localObject1 = localObject2;
      localStringBuilder.append(paramLottieImageAsset.getFileName());
      localObject1 = localObject2;
      paramLottieImageAsset = BitmapFactory.decodeFile(localStringBuilder.toString(), localOptions);
      localObject1 = paramLottieImageAsset;
      this.g.add(paramLottieImageAsset);
      return paramLottieImageAsset;
    }
    catch (Exception paramLottieImageAsset)
    {
      label126:
      break label126;
    }
    QLog.d("DigitLottieAnimation", 1, "playNextAnim setImageAssetDelegate Exception");
    return localObject1;
  }
  
  private void a(AioAnimationRule paramAioAnimationRule, AioAnimationRule.JumpImage paramJumpImage, File paramFile, FileInputStream paramFileInputStream)
  {
    paramFile = paramFile.getAbsolutePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playNextAnim absolutePath");
    localStringBuilder.append(paramFile);
    QLog.d("DigitLottieAnimation", 1, localStringBuilder.toString());
    this.e.setImageAssetDelegate(new DigitLottieAnimation.4(this, paramFile));
    LottieComposition.Factory.fromInputStream(this.e.getContext(), paramFileInputStream, new DigitLottieAnimation.5(this, paramFileInputStream, paramJumpImage, paramAioAnimationRule));
  }
  
  private void a(@android.support.annotation.Nullable LottieComposition paramLottieComposition, AioAnimationRule.JumpImage paramJumpImage, AioAnimationRule paramAioAnimationRule)
  {
    if (paramLottieComposition != null)
    {
      Object localObject = this.e;
      if (localObject != null)
      {
        ((DiniFlyAnimationView)localObject).setComposition(paramLottieComposition);
        this.e.loop(false);
        this.e.setVisibility(0);
        if ((paramJumpImage == null) || (paramAioAnimationRule == null)) {
          return;
        }
        float f1 = this.e.getResources().getDisplayMetrics().density;
        paramLottieComposition = new LevelEggsPosition(paramJumpImage.d);
        paramAioAnimationRule = paramLottieComposition.c;
        localObject = (Point)paramAioAnimationRule.get(RandomUtils.a(0, paramAioAnimationRule.size()));
        paramAioAnimationRule = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
        int j = paramLottieComposition.a / 2;
        int k = paramLottieComposition.b / 2;
        paramAioAnimationRule.width = ((int)(j * f1));
        paramAioAnimationRule.height = ((int)(k * f1));
        paramAioAnimationRule.leftMargin = ((int)((((Point)localObject).x - paramLottieComposition.a / 2) * f1 / 2.0F));
        paramAioAnimationRule.topMargin = ((int)(f1 * (((Point)localObject).y - paramLottieComposition.b / 2) / 2.0F));
        f1 = this.b.getContext().getResources().getDisplayMetrics().density / 2.0F;
        this.e.setScale(f1);
        j = paramAioAnimationRule.leftMargin;
        k = paramAioAnimationRule.topMargin;
        int m = paramAioAnimationRule.width + j;
        int n = paramAioAnimationRule.height + k;
        this.e.layout(j, k, m, n);
        paramLottieComposition = new StringBuilder();
        paramLottieComposition.append("[onCompositionLoaded] layout. l:");
        paramLottieComposition.append(j);
        paramLottieComposition.append(", t:");
        paramLottieComposition.append(k);
        paramLottieComposition.append(", r:");
        paramLottieComposition.append(m);
        paramLottieComposition.append(", b:");
        paramLottieComposition.append(n);
        QLog.d("DigitLottieAnimation", 1, paramLottieComposition.toString());
        this.e.setLayoutParams(paramAioAnimationRule);
        this.e.playAnimation();
        QLog.d("DigitLottieAnimation", 1, "playNextAnim fromInputStream succ");
        ReportController.b(null, "dc00898", "", "", "0X800BC05", "0X800BC05", 0, 0, "", "", paramJumpImage.h, "");
        return;
      }
    }
    QLog.d("DigitLottieAnimation", 1, "playNextAnim fromInputStream composition null");
    c();
  }
  
  private void a(@android.support.annotation.Nullable LottieComposition paramLottieComposition, FileInputStream paramFileInputStream, AioAnimationRule.JumpImage paramJumpImage, AioAnimationRule paramAioAnimationRule)
  {
    if (this.e == null)
    {
      QLog.d("DigitLottieAnimation", 1, "LottieComposition.Factory.fromInputStream mLottieView is null!");
      return;
    }
    if (paramFileInputStream != null) {}
    try
    {
      paramFileInputStream.close();
      label25:
      ThreadManagerV2.getUIHandlerV2().post(new DigitLottieAnimation.6(this, paramLottieComposition, paramJumpImage, paramAioAnimationRule));
      return;
    }
    catch (IOException paramFileInputStream)
    {
      break label25;
    }
  }
  
  private void a(String paramString, AioAnimationRule paramAioAnimationRule, AioAnimationRule.JumpImage paramJumpImage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.f.getContext().getFilesDir().getAbsoluteFile());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("animConfig/");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/data.json");
    File localFile = new File(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.f.getContext().getFilesDir().getAbsoluteFile());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("animConfig/");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/images");
    localObject = new File(((StringBuilder)localObject).toString());
    if (localFile.exists()) {}
    try
    {
      paramString = new FileInputStream(localFile);
    }
    catch (Exception paramString)
    {
      label173:
      break label173;
    }
    QLog.d("DigitLottieAnimation", 1, "playNextAnim tempFis Exception");
    return;
    paramString = null;
    if (paramString == null) {
      return;
    }
    if (!((File)localObject).exists())
    {
      QLog.d("DigitLottieAnimation", 1, "playNextAnim fis == null || !imageDir.exists()");
      if (paramString == null) {}
    }
    try
    {
      paramString.close();
      return;
    }
    catch (IOException paramString) {}
    a(paramAioAnimationRule, paramJumpImage, (File)localObject, paramString);
    return;
  }
  
  private boolean e()
  {
    return Build.VERSION.SDK_INT > 24;
  }
  
  private boolean f()
  {
    if (this.d == null)
    {
      this.f = ((RelativeLayout)this.b.getParent());
      Object localObject = this.f;
      if (localObject == null) {
        return true;
      }
      this.d = ((RelativeLayout)View.inflate(((RelativeLayout)localObject).getContext(), 2131624084, null));
      localObject = this.d;
      if (localObject == null)
      {
        QLog.d("DigitLottieAnimation", 1, "startAnim mLottieLayout null");
        return true;
      }
      this.e = ((DiniFlyAnimationView)((RelativeLayout)localObject).findViewById(2131427917));
      localObject = this.e;
      if (localObject == null)
      {
        QLog.d("DigitLottieAnimation", 1, "startAnim mLottieView null");
        return true;
      }
      ((DiniFlyAnimationView)localObject).addAnimatorListener(this.i);
      this.a.addView(this.d);
      this.e.setRenderMode(RenderMode.HARDWARE);
    }
    return false;
  }
  
  private void g()
  {
    if (h()) {
      return;
    }
    int j = 0;
    String str = "";
    int k = this.h.size();
    StringBuilder localStringBuilder = null;
    Object localObject1 = null;
    Object localObject2;
    if (k > 0)
    {
      localObject2 = (DigitLottieAnimation.EggAnimInfo)this.h.peek();
      if (localObject2 != null)
      {
        str = ((DigitLottieAnimation.EggAnimInfo)localObject2).b;
        j = ((DigitLottieAnimation.EggAnimInfo)localObject2).a;
        localObject1 = ((DigitLottieAnimation.EggAnimInfo)localObject2).c;
        localObject2 = ((DigitLottieAnimation.EggAnimInfo)localObject2).d;
      }
      else
      {
        localObject2 = null;
      }
      this.h.clear();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("playNextAnim strAnimPath");
      localStringBuilder.append(str);
      localStringBuilder.append("id");
      localStringBuilder.append(j);
      QLog.d("DigitLottieAnimation", 1, localStringBuilder.toString());
    }
    else
    {
      localObject2 = null;
      localObject1 = localStringBuilder;
    }
    if ((!str.isEmpty()) && (localObject1 != null) && (localObject2 != null))
    {
      if (this.f == null)
      {
        QLog.d("DigitLottieAnimation", 1, "playNextAnim listViewParent is null");
        return;
      }
      a(str, (AioAnimationRule)localObject1, (AioAnimationRule.JumpImage)localObject2);
      return;
    }
    QLog.d("DigitLottieAnimation", 1, "playNextAnim strAnimPath isEmpty");
  }
  
  private boolean h()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = this.e;
    if ((localDiniFlyAnimationView != null) && (this.d != null))
    {
      if (localDiniFlyAnimationView.isAnimating())
      {
        QLog.d("DigitLottieAnimation", 1, "playNextAnim mLottieView isAnimating");
        return true;
      }
      return false;
    }
    QLog.d("DigitLottieAnimation", 1, "playNextAnim mLottieView == null || mLottieLayout == null");
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.e != null) && (this.d != null))
    {
      Object localObject = this.f;
      if (localObject == null) {
        return true;
      }
      localObject = (InputLinearLayout)((RelativeLayout)localObject).findViewById(2131435809);
      int j = 0;
      if (localObject != null) {
        paramInt4 = ((InputLinearLayout)localObject).getHeight();
      } else {
        paramInt4 = 0;
      }
      localObject = (PanelIconLinearLayout)this.f.findViewById(2131439817);
      if (localObject != null) {
        j = ((PanelIconLinearLayout)localObject).getHeight();
      }
      paramInt4 = UIUtils.d(this.f.getContext()) - paramInt4 - j;
      j = this.e.getLeft();
      int k = this.e.getRight();
      int m = this.e.getTop();
      int n = this.e.getBottom();
      if ((j != paramInt1) || (k != paramInt3) || (m != paramInt2) || (n != paramInt4)) {
        this.d.layout(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    return true;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if (!e())
    {
      QLog.d("DigitLottieAnimation", 1, "[start] version too low not support lottie.");
      return false;
    }
    if (paramVarArgs == null)
    {
      QLog.d("DigitLottieAnimation", 1, "startAnim args is null");
      return false;
    }
    if (paramVarArgs.length == 2)
    {
      AioAnimationRule.JumpImage localJumpImage = (AioAnimationRule.JumpImage)paramVarArgs[0];
      String str = localJumpImage.h;
      paramVarArgs = (AioAnimationRule)paramVarArgs[1];
      int j = paramVarArgs.b;
      if ((!TextUtils.isEmpty(str)) && (j != 0)) {
        this.h.add(new DigitLottieAnimation.EggAnimInfo(str, j, paramVarArgs, localJumpImage, null));
      }
      paramVarArgs = this.e;
      if ((paramVarArgs != null) && (paramVarArgs.isAnimating()))
      {
        QLog.d("DigitLottieAnimation", 1, "startAnim mLottieView isAnimating");
        return true;
      }
      if (f()) {
        return false;
      }
      ThreadManagerV2.executeOnSubThread(new DigitLottieAnimation.2(this));
      QLog.d("DigitLottieAnimation", 1, "startAnim succ");
      return true;
    }
    QLog.d("DigitLottieAnimation", 1, "startAnim args error!");
    return false;
  }
  
  protected boolean b(int paramInt)
  {
    return true;
  }
  
  protected void c()
  {
    QLog.d("DigitLottieAnimation", 1, "stopAnim");
    Object localObject = this.h;
    if ((localObject != null) && (!((Queue)localObject).isEmpty())) {
      this.h.clear();
    }
    ThreadManagerV2.executeOnSubThread(new DigitLottieAnimation.3(this));
    localObject = this.e;
    if ((localObject != null) && (this.d != null))
    {
      ((DiniFlyAnimationView)localObject).removeAllAnimatorListener();
      if (this.e.isAnimating()) {
        this.e.endAnimation();
      }
      if (this.a != null) {
        this.a.removeView(this.d);
      }
      this.d = null;
      this.e = null;
      d();
      return;
    }
    QLog.d("DigitLottieAnimation", 1, "mLottieView == null || mLottieLayout == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.DigitLottieAnimation
 * JD-Core Version:    0.7.0.1
 */