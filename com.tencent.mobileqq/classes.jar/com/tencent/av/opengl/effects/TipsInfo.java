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
  private static TipsInfo jdField_a_of_type_ComTencentAvOpenglEffectsTipsInfo = null;
  private int jdField_a_of_type_Int = 0;
  private EffectPendantTips jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips = null;
  private String jdField_a_of_type_JavaLangString = null;
  private final Map<String, Drawable> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  public static TipsInfo a()
  {
    if (jdField_a_of_type_ComTencentAvOpenglEffectsTipsInfo == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvOpenglEffectsTipsInfo == null) {
        jdField_a_of_type_ComTencentAvOpenglEffectsTipsInfo = new TipsInfo();
      }
      return jdField_a_of_type_ComTencentAvOpenglEffectsTipsInfo;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    d();
    e();
  }
  
  public void a(long paramLong)
  {
    e();
    d();
    a("clearState_" + paramLong, null);
  }
  
  public void a(EffectPendantTips paramEffectPendantTips)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips = paramEffectPendantTips;
    if (QLog.isColorLevel()) {
      QLog.i("TipsInfo", 2, "setEffectPendantTips, tip[" + paramEffectPendantTips + "]");
    }
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString)) && (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)))
    {
      localObject = BaseApplicationImpl.getApplication().getResources();
      if (!"fivea".equals(paramString)) {
        break label100;
      }
      localObject = ((Resources)localObject).getDrawable(2130842308);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.i("TipsInfo", "loadGestureTipIcon, drawable[" + localObject + "], gestureType[" + paramString + "]");
      }
      return;
      label100:
      if ("palmup".equals(paramString)) {
        localObject = ((Resources)localObject).getDrawable(2130842309);
      } else if ("qheart".equals(paramString)) {
        localObject = ((Resources)localObject).getDrawable(2130842310);
      } else {
        localObject = null;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsInfo", 1, "setGestureType[" + paramString1 + "], GestureTips[" + this.jdField_a_of_type_JavaLangString + "->" + paramString2 + "]");
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.jdField_a_of_type_Int -= 1;; this.jdField_a_of_type_Int += 1)
    {
      if (this.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Int = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TipsInfo", 2, "setCanShowTip, canShowTip[" + paramBoolean + "], disableShowTipCount[" + this.jdField_a_of_type_Int + "]");
      }
      return;
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
  
  public void b(String paramString1, String paramString2)
  {
    if (!a()) {
      break label7;
    }
    label7:
    while (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString1)) {
      return;
    }
    d();
    paramString2 = (Drawable)this.jdField_a_of_type_JavaUtilMap.get(paramString2);
    if (paramString2 != null) {
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips != null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.a(paramString2, paramString1);
      }
    }
    for (;;)
    {
      a("showGestureTips", paramString1);
      if (!AVCoreLog.isColorLevel()) {
        break;
      }
      AVCoreLog.i("TipsInfo", "showGestureTips, wording[" + paramString1 + "], drawable[" + paramString2 + "]");
      return;
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips != null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.a(paramString1);
      }
    }
  }
  
  public void c()
  {
    if (!a()) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Boolean);
      e();
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips != null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.a(100);
      }
      this.jdField_a_of_type_Boolean = true;
    } while (!AVCoreLog.isColorLevel());
    AVCoreLog.i("TipsInfo", "showFaceTips");
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips != null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.b(0);
      }
      this.jdField_a_of_type_Boolean = false;
    } while (!AVCoreLog.isColorLevel());
    AVCoreLog.i("TipsInfo", "hideFaceTips");
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.w("TipsInfo", 1, "hideGestureTips, mCurGestureTip[" + this.jdField_a_of_type_JavaLangString + "]");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      a("hideGestureTips", null);
    } while (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips == null);
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.b(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.TipsInfo
 * JD-Core Version:    0.7.0.1
 */