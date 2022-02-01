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
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
  private final D8SafeAnimatorListener jdField_a_of_type_ComTencentMobileqqWidgetD8SafeAnimatorListener = new DigitLottieAnimation.1(this);
  private final List<Bitmap> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private final Queue<DigitLottieAnimation.EggAnimInfo> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private RelativeLayout b = null;
  
  public DigitLottieAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  @org.jetbrains.annotations.Nullable
  private Bitmap a(LottieImageAsset paramLottieImageAsset, String paramString)
  {
    Object localObject1 = this.b;
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inScaled = true;
    localOptions.inDensity = this.b.getContext().getResources().getDisplayMetrics().densityDpi;
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
      this.jdField_a_of_type_JavaUtilList.add(paramLottieImageAsset);
      return paramLottieImageAsset;
    }
    catch (Exception paramLottieImageAsset)
    {
      label126:
      break label126;
    }
    QLog.d("DigitLottieAnimation", 2, "playNextAnim setImageAssetDelegate Exception");
    return localObject1;
  }
  
  private void a(AioAnimationRule paramAioAnimationRule, AioAnimationRule.JumpImage paramJumpImage, File paramFile, FileInputStream paramFileInputStream)
  {
    paramFile = paramFile.getAbsolutePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playNextAnim absolutePath");
    localStringBuilder.append(paramFile);
    QLog.d("DigitLottieAnimation", 2, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetDelegate(new DigitLottieAnimation.4(this, paramFile));
    LottieComposition.Factory.fromInputStream(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getContext(), paramFileInputStream, new DigitLottieAnimation.5(this, paramFileInputStream, paramJumpImage, paramAioAnimationRule));
  }
  
  private void a(@android.support.annotation.Nullable LottieComposition paramLottieComposition, AioAnimationRule.JumpImage paramJumpImage, AioAnimationRule paramAioAnimationRule)
  {
    if (paramLottieComposition != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setComposition(paramLottieComposition);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(false);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      if ((paramJumpImage != null) && (paramAioAnimationRule != null))
      {
        float f = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getResources().getDisplayMetrics().density;
        paramLottieComposition = new LevelEggsPosition(paramJumpImage.b);
        paramAioAnimationRule = paramLottieComposition.jdField_a_of_type_JavaUtilList;
        Point localPoint = (Point)paramAioAnimationRule.get(RandomUtils.a(0, paramAioAnimationRule.size()));
        paramAioAnimationRule = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
        int i = paramLottieComposition.jdField_a_of_type_Int / 2;
        int j = paramLottieComposition.b / 2;
        paramAioAnimationRule.width = ((int)(i * f));
        paramAioAnimationRule.height = ((int)(j * f));
        paramAioAnimationRule.leftMargin = ((int)((localPoint.x - paramLottieComposition.jdField_a_of_type_Int / 2) * f / 2.0F));
        paramAioAnimationRule.topMargin = ((int)(f * (localPoint.y - paramLottieComposition.b / 2) / 2.0F));
        f = this.jdField_a_of_type_ComTencentWidgetListView.getContext().getResources().getDisplayMetrics().density / 2.0F;
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScale(f);
        i = paramAioAnimationRule.leftMargin;
        j = paramAioAnimationRule.topMargin;
        int k = paramAioAnimationRule.width + i;
        int m = paramAioAnimationRule.height + j;
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.layout(i, j, k, m);
        paramLottieComposition = new StringBuilder();
        paramLottieComposition.append("[onCompositionLoaded] layout. l:");
        paramLottieComposition.append(i);
        paramLottieComposition.append(", t:");
        paramLottieComposition.append(j);
        paramLottieComposition.append(", r:");
        paramLottieComposition.append(k);
        paramLottieComposition.append(", b:");
        paramLottieComposition.append(m);
        QLog.d("DigitLottieAnimation", 1, paramLottieComposition.toString());
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams(paramAioAnimationRule);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
        QLog.d("DigitLottieAnimation", 2, "playNextAnim fromInputStream succ");
        ReportController.b(null, "dc00898", "", "", "0X800BC05", "0X800BC05", 0, 0, "", "", paramJumpImage.e, "");
      }
    }
    else
    {
      QLog.d("DigitLottieAnimation", 2, "playNextAnim fromInputStream composition null");
      c();
    }
  }
  
  private void a(@android.support.annotation.Nullable LottieComposition paramLottieComposition, FileInputStream paramFileInputStream, AioAnimationRule.JumpImage paramJumpImage, AioAnimationRule paramAioAnimationRule)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null)
    {
      QLog.d("DigitLottieAnimation", 2, "LottieComposition.Factory.fromInputStream mLottieView is null!");
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
    ((StringBuilder)localObject).append(this.b.getContext().getFilesDir().getAbsoluteFile());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("animConfig/");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/data.json");
    File localFile = new File(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b.getContext().getFilesDir().getAbsoluteFile());
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
    QLog.d("DigitLottieAnimation", 2, "playNextAnim tempFis Exception");
    return;
    paramString = null;
    if (paramString == null) {
      return;
    }
    if (!((File)localObject).exists())
    {
      QLog.d("DigitLottieAnimation", 2, "playNextAnim fis == null || !imageDir.exists()");
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
  
  private boolean a()
  {
    return Build.VERSION.SDK_INT > 24;
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.b = ((RelativeLayout)this.jdField_a_of_type_ComTencentWidgetListView.getParent());
      Object localObject = this.b;
      if (localObject == null) {
        return true;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(((RelativeLayout)localObject).getContext(), 2131558531, null));
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localObject == null)
      {
        QLog.d("DigitLottieAnimation", 2, "startAnim mLottieLayout null");
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)((RelativeLayout)localObject).findViewById(2131362317));
      localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
      if (localObject == null)
      {
        QLog.d("DigitLottieAnimation", 2, "startAnim mLottieView null");
        return true;
      }
      ((DiniFlyAnimationView)localObject).addAnimatorListener(this.jdField_a_of_type_ComTencentMobileqqWidgetD8SafeAnimatorListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setRenderMode(RenderMode.HARDWARE);
    }
    return false;
  }
  
  private boolean c()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if ((localDiniFlyAnimationView != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      if (localDiniFlyAnimationView.isAnimating())
      {
        QLog.d("DigitLottieAnimation", 2, "playNextAnim mLottieView isAnimating");
        return true;
      }
      return false;
    }
    QLog.d("DigitLottieAnimation", 2, "playNextAnim mLottieView == null || mLottieLayout == null");
    return true;
  }
  
  private void e()
  {
    if (c()) {
      return;
    }
    int i = 0;
    String str = "";
    int j = this.jdField_a_of_type_JavaUtilQueue.size();
    StringBuilder localStringBuilder = null;
    Object localObject1 = null;
    Object localObject2;
    if (j > 0)
    {
      localObject2 = (DigitLottieAnimation.EggAnimInfo)this.jdField_a_of_type_JavaUtilQueue.peek();
      if (localObject2 != null)
      {
        str = ((DigitLottieAnimation.EggAnimInfo)localObject2).jdField_a_of_type_JavaLangString;
        i = ((DigitLottieAnimation.EggAnimInfo)localObject2).jdField_a_of_type_Int;
        localObject1 = ((DigitLottieAnimation.EggAnimInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule;
        localObject2 = ((DigitLottieAnimation.EggAnimInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$JumpImage;
      }
      else
      {
        localObject2 = null;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("playNextAnim strAnimPath");
      localStringBuilder.append(str);
      localStringBuilder.append("id");
      localStringBuilder.append(i);
      QLog.d("DigitLottieAnimation", 2, localStringBuilder.toString());
    }
    else
    {
      localObject2 = null;
      localObject1 = localStringBuilder;
    }
    if ((!str.isEmpty()) && (localObject1 != null) && (localObject2 != null))
    {
      if (this.b == null)
      {
        QLog.d("DigitLottieAnimation", 2, "playNextAnim listViewParent is null");
        return;
      }
      a(str, (AioAnimationRule)localObject1, (AioAnimationRule.JumpImage)localObject2);
      return;
    }
    QLog.d("DigitLottieAnimation", 2, "playNextAnim strAnimPath isEmpty");
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      Object localObject = this.b;
      if (localObject == null) {
        return true;
      }
      localObject = (InputLinearLayout)((RelativeLayout)localObject).findViewById(2131368875);
      int i = 0;
      if (localObject != null) {
        paramInt4 = ((InputLinearLayout)localObject).getHeight();
      } else {
        paramInt4 = 0;
      }
      localObject = (PanelIconLinearLayout)this.b.findViewById(2131372306);
      if (localObject != null) {
        i = ((PanelIconLinearLayout)localObject).getHeight();
      }
      paramInt4 = UIUtils.c(this.b.getContext()) - paramInt4 - i;
      i = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLeft();
      int j = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getRight();
      int k = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getTop();
      int m = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getBottom();
      if ((i != paramInt1) || (j != paramInt3) || (k != paramInt2) || (m != paramInt4)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    return true;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if (!a())
    {
      QLog.d("DigitLottieAnimation", 1, "[start] version too low not support lottie.");
      return false;
    }
    if (paramVarArgs == null)
    {
      QLog.d("DigitLottieAnimation", 2, "startAnim args is null");
      return false;
    }
    if (paramVarArgs.length == 2)
    {
      AioAnimationRule.JumpImage localJumpImage = (AioAnimationRule.JumpImage)paramVarArgs[0];
      String str = localJumpImage.e;
      paramVarArgs = (AioAnimationRule)paramVarArgs[1];
      int i = paramVarArgs.b;
      if ((!TextUtils.isEmpty(str)) && (i != 0)) {
        this.jdField_a_of_type_JavaUtilQueue.add(new DigitLottieAnimation.EggAnimInfo(str, i, paramVarArgs, localJumpImage, null));
      }
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
      if ((paramVarArgs != null) && (paramVarArgs.isAnimating()))
      {
        QLog.d("DigitLottieAnimation", 2, "startAnim mLottieView isAnimating");
        return true;
      }
      if (b()) {
        return false;
      }
      ThreadManagerV2.executeOnSubThread(new DigitLottieAnimation.2(this));
      QLog.d("DigitLottieAnimation", 2, "startAnim succ");
      return true;
    }
    QLog.d("DigitLottieAnimation", 2, "startAnim args error!");
    return false;
  }
  
  protected void c()
  {
    QLog.d("DigitLottieAnimation", 2, "stopAnim");
    Object localObject = this.jdField_a_of_type_JavaUtilQueue;
    if ((localObject != null) && (!((Queue)localObject).isEmpty())) {
      this.jdField_a_of_type_JavaUtilQueue.clear();
    }
    ThreadManagerV2.executeOnSubThread(new DigitLottieAnimation.3(this));
    localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if ((localObject != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      ((DiniFlyAnimationView)localObject).removeAllAnimatorListener();
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
      d();
      return;
    }
    QLog.d("DigitLottieAnimation", 2, "mLottieView == null || mLottieLayout == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.DigitLottieAnimation
 * JD-Core Version:    0.7.0.1
 */