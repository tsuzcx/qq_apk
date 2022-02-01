package com.tencent.av.opengl.effects;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.EffectPendantTips;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class TipsInfo
{
  private static TipsInfo jdField_a_of_type_ComTencentAvOpenglEffectsTipsInfo;
  private int jdField_a_of_type_Int = 0;
  private EffectPendantTips jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips = null;
  private String jdField_a_of_type_JavaLangString = null;
  private final Map<String, Drawable> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public static TipsInfo a()
  {
    if (jdField_a_of_type_ComTencentAvOpenglEffectsTipsInfo == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvOpenglEffectsTipsInfo == null) {
          jdField_a_of_type_ComTencentAvOpenglEffectsTipsInfo = new TipsInfo();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvOpenglEffectsTipsInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    d();
    e();
    a(0);
  }
  
  public void a(int paramInt)
  {
    if (!this.b) {
      return;
    }
    EffectPendantTips localEffectPendantTips = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips;
    if (localEffectPendantTips != null) {
      localEffectPendantTips.a(paramInt, new TipsInfo.1(this));
    }
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("TipsInfo", "hideErrorTips");
    }
  }
  
  public void a(long paramLong)
  {
    e();
    d();
    a(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearState_");
    localStringBuilder.append(paramLong);
    a(localStringBuilder.toString(), null);
  }
  
  public void a(EffectPendantTips paramEffectPendantTips)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips = paramEffectPendantTips;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setEffectPendantTips, tip[");
      localStringBuilder.append(paramEffectPendantTips);
      localStringBuilder.append("]");
      QLog.i("TipsInfo", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)))
    {
      Object localObject = BaseApplicationImpl.getApplication().getResources();
      if ("fivea".equals(paramString)) {
        localObject = ((Resources)localObject).getDrawable(2130842206);
      } else if ("palmup".equals(paramString)) {
        localObject = ((Resources)localObject).getDrawable(2130842207);
      } else if ("qheart".equals(paramString)) {
        localObject = ((Resources)localObject).getDrawable(2130842208);
      } else {
        localObject = null;
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
      if (AVCoreLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadGestureTipIcon, drawable[");
        localStringBuilder.append(localObject);
        localStringBuilder.append("], gestureType[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        AVCoreLog.i("TipsInfo", localStringBuilder.toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGestureType[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], GestureTips[");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("->");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("]");
      QLog.d("TipsInfo", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_Int -= 1;
    } else {
      this.jdField_a_of_type_Int += 1;
    }
    if (this.jdField_a_of_type_Int < 0) {
      this.jdField_a_of_type_Int = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCanShowTip, canShowTip[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], disableShowTipCount[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("]");
      QLog.i("TipsInfo", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int <= 0;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void b(String paramString)
  {
    if (!a()) {
      return;
    }
    d();
    e();
    EffectPendantTips localEffectPendantTips = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips;
    if (localEffectPendantTips != null) {
      localEffectPendantTips.b(paramString);
    }
    this.b = true;
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("TipsInfo", "showErrorTips");
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (a())
    {
      if (this.b) {
        return;
      }
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString1)) {
        return;
      }
      d();
      paramString2 = (Drawable)this.jdField_a_of_type_JavaUtilMap.get(paramString2);
      Object localObject;
      if (paramString2 != null)
      {
        localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips;
        if (localObject != null) {
          ((EffectPendantTips)localObject).a(paramString2, paramString1);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips;
        if (localObject != null) {
          ((EffectPendantTips)localObject).a(paramString1);
        }
      }
      a("showGestureTips", paramString1);
      if (AVCoreLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showGestureTips, wording[");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append("], drawable[");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("]");
        AVCoreLog.i("TipsInfo", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void c()
  {
    if (a())
    {
      if (this.b) {
        return;
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      e();
      EffectPendantTips localEffectPendantTips = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips;
      if (localEffectPendantTips != null) {
        localEffectPendantTips.a(100);
      }
      this.jdField_a_of_type_Boolean = true;
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.i("TipsInfo", "showFaceTips");
      }
    }
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    EffectPendantTips localEffectPendantTips = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips;
    if (localEffectPendantTips != null) {
      localEffectPendantTips.b(0);
    }
    this.jdField_a_of_type_Boolean = false;
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("TipsInfo", "hideFaceTips");
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideGestureTips, mCurGestureTip[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("]");
      QLog.w("TipsInfo", 1, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    a("hideGestureTips", null);
    Object localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips;
    if (localObject != null) {
      ((EffectPendantTips)localObject).b(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.TipsInfo
 * JD-Core Version:    0.7.0.1
 */