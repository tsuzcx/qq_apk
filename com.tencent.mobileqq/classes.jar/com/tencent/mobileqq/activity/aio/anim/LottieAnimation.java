package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.RenderMode;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LottieAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  private LinearLayout d = null;
  private DiniFlyAnimationView e = null;
  private RelativeLayout f = null;
  private LottieAnimationInfo g = null;
  private HashMap<String, Bitmap> h = new HashMap();
  private Queue<LottieAnimation.EggAnimInfo> i = new LinkedList();
  private int j = 0;
  
  public LottieAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private void a(File paramFile)
  {
    paramFile = paramFile.getAbsolutePath();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playNextAnim absolutePath");
      localStringBuilder.append(paramFile);
      QLog.d("LottieAnimation", 2, localStringBuilder.toString());
    }
    this.e.setImageAssetDelegate(new LottieAnimation.3(this, paramFile));
  }
  
  private boolean e()
  {
    Object localObject1 = this.e;
    if ((localObject1 != null) && (this.d != null))
    {
      if (((DiniFlyAnimationView)localObject1).isAnimating())
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim mLottieView isAnimating");
        }
        return true;
      }
      localObject1 = "";
      Object localObject3 = this.i;
      int k;
      if ((localObject3 != null) && (((Queue)localObject3).size() > 0))
      {
        localObject3 = (LottieAnimation.EggAnimInfo)this.i.peek();
        if (localObject3 != null)
        {
          localObject1 = ((LottieAnimation.EggAnimInfo)localObject3).b;
          k = ((LottieAnimation.EggAnimInfo)localObject3).a;
        }
        else
        {
          k = 0;
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("playNextAnim strAnimPath");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("id");
          ((StringBuilder)localObject3).append(k);
          QLog.d("LottieAnimation", 2, ((StringBuilder)localObject3).toString());
        }
      }
      else
      {
        k = 0;
      }
      if (((String)localObject1).isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim strAnimPath isEmpty");
        }
        return false;
      }
      if (this.f == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim listViewParent is null");
        }
        return false;
      }
      localObject3 = null;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(this.f.getContext().getFilesDir().getAbsoluteFile());
      ((StringBuilder)localObject4).append(File.separator);
      ((StringBuilder)localObject4).append("animConfig/");
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append("/data.json");
      localObject4 = new File(((StringBuilder)localObject4).toString());
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(this.f.getContext().getFilesDir().getAbsoluteFile());
      ((StringBuilder)localObject5).append(File.separator);
      ((StringBuilder)localObject5).append("animConfig/");
      ((StringBuilder)localObject5).append((String)localObject1);
      ((StringBuilder)localObject5).append("/images");
      localObject5 = new File(((StringBuilder)localObject5).toString());
      localObject1 = localObject3;
      if (((File)localObject4).exists()) {
        try
        {
          localObject1 = new FileInputStream((File)localObject4);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "playNextAnim tempFis Exception");
          }
          return false;
        }
      }
      if (localException == null) {
        return false;
      }
      if (!((File)localObject5).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim fis == null || !imageDir.exists()");
        }
        if (localException != null) {
          try
          {
            localException.close();
            return false;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
          }
        }
        return false;
      }
      a((File)localObject5);
      LottieComposition.Factory.fromInputStream(this.e.getContext(), localIOException, new LottieAnimation.2(this, localIOException));
      Object localObject2 = this.g;
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim extraInfo null");
        }
        return false;
      }
      if (((LottieAnimationInfo)localObject2).a != 1) {
        return true;
      }
      if (this.g.c == null) {
        return false;
      }
      localObject2 = this.g.c.troopuin;
      long l = this.g.c.dwGroupClassExt;
      ReportController.b(null, "dc00898", "", this.g.b, "0X800AE17", "0X800AE17", k, 0, (String)localObject2, String.valueOf(l), "", "");
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "playNextAnim mLottieView == null || mLottieLayout == null");
    }
    return false;
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
      int k = 0;
      if (localObject != null) {
        paramInt4 = ((InputLinearLayout)localObject).getHeight();
      } else {
        paramInt4 = 0;
      }
      localObject = (PanelIconLinearLayout)this.f.findViewById(2131439817);
      if (localObject != null) {
        k = ((PanelIconLinearLayout)localObject).getHeight();
      }
      paramInt4 = UIUtils.d(this.f.getContext()) - paramInt4 - k;
      k = this.e.getLeft();
      int m = this.e.getRight();
      int n = this.e.getTop();
      int i1 = this.e.getBottom();
      if ((k != paramInt1) || (m != paramInt3) || (n != paramInt2) || (i1 != paramInt4))
      {
        this.d.layout(paramInt1, paramInt2, paramInt3, paramInt4);
        this.e.layout(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    return true;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if (paramVarArgs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LottieAnimation", 2, "startAnim args is null");
      }
      return false;
    }
    if (paramVarArgs.length > 2)
    {
      String str = (String)paramVarArgs[0];
      int k = ((Integer)paramVarArgs[1]).intValue();
      if ((!TextUtils.isEmpty(str)) && (k != 0)) {
        this.i.add(new LottieAnimation.EggAnimInfo(this, str, k, null));
      }
      paramVarArgs = paramVarArgs[2];
      if ((paramVarArgs != null) && ((paramVarArgs instanceof LottieAnimationInfo))) {
        this.g = ((LottieAnimationInfo)paramVarArgs);
      }
      paramVarArgs = this.e;
      if ((paramVarArgs != null) && (paramVarArgs.isAnimating()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "startAnim mLottieView isAnimating");
        }
        return true;
      }
      if (this.d == null)
      {
        this.f = ((RelativeLayout)this.b.getParent());
        paramVarArgs = this.f;
        if (paramVarArgs == null) {
          return false;
        }
        this.d = ((LinearLayout)View.inflate(paramVarArgs.getContext(), 2131624073, null));
        paramVarArgs = this.d;
        if (paramVarArgs == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "startAnim mLottieLayout null");
          }
          return false;
        }
        this.e = ((DiniFlyAnimationView)paramVarArgs.findViewById(2131427917));
        paramVarArgs = this.e;
        if (paramVarArgs == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "startAnim mLottieView null");
          }
          return false;
        }
        paramVarArgs.addAnimatorListener(new LottieAnimation.1(this));
        paramVarArgs = new RelativeLayout.LayoutParams(-1, -1);
        this.a.addView(this.d, paramVarArgs);
        this.e.setRenderMode(RenderMode.HARDWARE);
      }
      if (!e())
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim false");
        }
        c();
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LottieAnimation", 2, "startAnim succ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "startAnim args error!");
    }
    return false;
  }
  
  protected boolean b(int paramInt)
  {
    return true;
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "stopAnim");
    }
    Object localObject = this.i;
    if ((localObject != null) && (!((Queue)localObject).isEmpty())) {
      this.i.clear();
    }
    localObject = this.h;
    if ((localObject != null) && (!((HashMap)localObject).isEmpty())) {
      this.h.clear();
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "mLottieView == null || mLottieLayout == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.LottieAnimation
 * JD-Core Version:    0.7.0.1
 */