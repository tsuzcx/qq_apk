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
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private LottieAnimationInfo jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo = null;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Queue<LottieAnimation.EggAnimInfo> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private int b = 0;
  
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
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetDelegate(new LottieAnimation.3(this, paramFile));
  }
  
  private boolean a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if ((localObject1 != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      if (((DiniFlyAnimationView)localObject1).isAnimating())
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim mLottieView isAnimating");
        }
        return true;
      }
      localObject1 = "";
      Object localObject3 = this.jdField_a_of_type_JavaUtilQueue;
      int i;
      if ((localObject3 != null) && (((Queue)localObject3).size() > 0))
      {
        localObject3 = (LottieAnimation.EggAnimInfo)this.jdField_a_of_type_JavaUtilQueue.peek();
        if (localObject3 != null)
        {
          localObject1 = ((LottieAnimation.EggAnimInfo)localObject3).jdField_a_of_type_JavaLangString;
          i = ((LottieAnimation.EggAnimInfo)localObject3).jdField_a_of_type_Int;
        }
        else
        {
          i = 0;
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("playNextAnim strAnimPath");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("id");
          ((StringBuilder)localObject3).append(i);
          QLog.d("LottieAnimation", 2, ((StringBuilder)localObject3).toString());
        }
      }
      else
      {
        i = 0;
      }
      if (((String)localObject1).isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim strAnimPath isEmpty");
        }
        return false;
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim listViewParent is null");
        }
        return false;
      }
      localObject3 = null;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext().getFilesDir().getAbsoluteFile());
      ((StringBuilder)localObject4).append(File.separator);
      ((StringBuilder)localObject4).append("animConfig/");
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append("/data.json");
      localObject4 = new File(((StringBuilder)localObject4).toString());
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext().getFilesDir().getAbsoluteFile());
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
      LottieComposition.Factory.fromInputStream(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getContext(), localIOException, new LottieAnimation.2(this, localIOException));
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo;
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim extraInfo null");
        }
        return false;
      }
      if (((LottieAnimationInfo)localObject2).jdField_a_of_type_Int != 1) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
        return false;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
      long l = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt;
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo.jdField_a_of_type_JavaLangString, "0X800AE17", "0X800AE17", i, 0, (String)localObject2, String.valueOf(l), "", "");
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "playNextAnim mLottieView == null || mLottieLayout == null");
    }
    return false;
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
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
      localObject = (PanelIconLinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372306);
      if (localObject != null) {
        i = ((PanelIconLinearLayout)localObject).getHeight();
      }
      paramInt4 = UIUtils.c(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext()) - paramInt4 - i;
      i = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLeft();
      int j = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getRight();
      int k = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getTop();
      int m = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getBottom();
      if ((i != paramInt1) || (j != paramInt3) || (k != paramInt2) || (m != paramInt4))
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
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
      int i = ((Integer)paramVarArgs[1]).intValue();
      if ((!TextUtils.isEmpty(str)) && (i != 0)) {
        this.jdField_a_of_type_JavaUtilQueue.add(new LottieAnimation.EggAnimInfo(this, str, i, null));
      }
      paramVarArgs = paramVarArgs[2];
      if ((paramVarArgs != null) && ((paramVarArgs instanceof LottieAnimationInfo))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimationInfo = ((LottieAnimationInfo)paramVarArgs);
      }
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
      if ((paramVarArgs != null) && (paramVarArgs.isAnimating()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "startAnim mLottieView isAnimating");
        }
        return true;
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentWidgetListView.getParent());
        paramVarArgs = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
        if (paramVarArgs == null) {
          return false;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(paramVarArgs.getContext(), 2131558520, null));
        paramVarArgs = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        if (paramVarArgs == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "startAnim mLottieLayout null");
          }
          return false;
        }
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)paramVarArgs.findViewById(2131362317));
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
        if (paramVarArgs == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "startAnim mLottieView null");
          }
          return false;
        }
        paramVarArgs.addAnimatorListener(new LottieAnimation.1(this));
        paramVarArgs = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramVarArgs);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setRenderMode(RenderMode.HARDWARE);
      }
      if (!a())
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
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "stopAnim");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilQueue;
    if ((localObject != null) && (!((Queue)localObject).isEmpty())) {
      this.jdField_a_of_type_JavaUtilQueue.clear();
    }
    localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if ((localObject != null) && (!((HashMap)localObject).isEmpty())) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if ((localObject != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      ((DiniFlyAnimationView)localObject).removeAllAnimatorListener();
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
      d();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "mLottieView == null || mLottieLayout == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.LottieAnimation
 * JD-Core Version:    0.7.0.1
 */