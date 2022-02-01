package com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.strategy;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager;
import com.tencent.aelight.camera.struct.editor.DoodleInfo;
import com.tencent.aelight.camera.struct.editor.HorizontalStroke;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ConfigurableLineLayerStrokeStrategy
  implements StrokeStrategy
{
  public static final int[] a;
  public static final int[] b;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private final boolean jdField_a_of_type_Boolean;
  private final boolean b;
  private final boolean c;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2130847005, 2130847008, 2130847006, 2130847011, 2130847010 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130847007, 2130847005, 2130847008, 2130847006, 2130847011, 2130847010 };
  }
  
  public ConfigurableLineLayerStrokeStrategy(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.c = paramBoolean3;
  }
  
  public void a(Context paramContext, ArrayList<HorizontalStroke> paramArrayList)
  {
    int[] arrayOfInt1;
    if (this.c) {
      arrayOfInt1 = jdField_b_of_type_ArrayOfInt;
    } else {
      arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    }
    int[] arrayOfInt2;
    if (this.c) {
      arrayOfInt2 = HorizontalStroke.jdField_b_of_type_ArrayOfInt;
    } else {
      arrayOfInt2 = HorizontalStroke.jdField_a_of_type_ArrayOfInt;
    }
    int i = 0;
    while (i < arrayOfInt1.length)
    {
      paramArrayList.add(new HorizontalStroke(paramContext.getResources().getDrawable(arrayOfInt1[i]), 0, arrayOfInt2[i]));
      i += 1;
    }
  }
  
  public void a(@NonNull ArrayList<HorizontalStroke> paramArrayList, @NonNull Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.e("CfgLineLayerStrokeStrategy", 2, new Object[] { "createHorizontalStroke, mNeedMosaic:", Boolean.valueOf(this.jdField_a_of_type_Boolean), " mNeedPersonality:", Boolean.valueOf(this.jdField_b_of_type_Boolean), " mIsEditPic:", Boolean.valueOf(this.c) });
    }
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = new HorizontalStroke(paramContext.getResources().getDrawable(2130847013), 1, 0);
      ((HorizontalStroke)localObject1).jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131702621);
      paramArrayList.add(localObject1);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      boolean bool = PtvFilterSoLoad.b();
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      Object localObject6 = null;
      HorizontalStroke localHorizontalStroke2 = null;
      if ((localObject1 != null) && (bool))
      {
        localObject1 = PtvTemplateManager.a().a();
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
        {
          Iterator localIterator = ((ArrayList)localObject1).iterator();
          HorizontalStroke localHorizontalStroke3 = null;
          HorizontalStroke localHorizontalStroke1 = localHorizontalStroke3;
          localObject2 = localHorizontalStroke1;
          localObject1 = localObject2;
          for (;;)
          {
            localHorizontalStroke4 = localHorizontalStroke3;
            localObject6 = localHorizontalStroke2;
            localObject5 = localHorizontalStroke1;
            localObject4 = localObject2;
            localObject3 = localObject1;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject3 = (DoodleInfo)localIterator.next();
            if ((!"doodle_highlighter".equals(((DoodleInfo)localObject3).jdField_b_of_type_JavaLangString)) || (Build.VERSION.SDK_INT >= 18))
            {
              int i = Integer.valueOf(((DoodleInfo)localObject3).a).intValue();
              if ("doodle_image_family".equals(((DoodleInfo)localObject3).jdField_b_of_type_JavaLangString))
              {
                localObject2 = new HorizontalStroke(paramContext.getResources().getDrawable(2130845063), 2, i);
                ((HorizontalStroke)localObject2).jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131702620);
              }
              else if ("doodle_image_mouth".equals(((DoodleInfo)localObject3).jdField_b_of_type_JavaLangString))
              {
                localObject1 = new HorizontalStroke(paramContext.getResources().getDrawable(2130845064), 2, i);
                ((HorizontalStroke)localObject1).jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131702619);
              }
              else if ("doodle_image_xin".equals(((DoodleInfo)localObject3).jdField_b_of_type_JavaLangString))
              {
                localHorizontalStroke1 = new HorizontalStroke(paramContext.getResources().getDrawable(2130845065), 2, i);
                localHorizontalStroke1.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131702622);
              }
              else if ("doodle_highlighter".equals(((DoodleInfo)localObject3).jdField_b_of_type_JavaLangString))
              {
                localHorizontalStroke2 = new HorizontalStroke(paramContext.getResources().getDrawable(2130845062), 2, i);
                localHorizontalStroke2.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131702617);
              }
              else if ("doodle_fireworks".equals(((DoodleInfo)localObject3).jdField_b_of_type_JavaLangString))
              {
                localHorizontalStroke3 = new HorizontalStroke(paramContext.getResources().getDrawable(2130845061), 2, i);
                localHorizontalStroke3.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131702618);
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Doodle_Strokes_CfgLineLayerStrokeStrategy", 2, "createHorizontalStroke doodleInfo is NUll !");
        }
      }
      HorizontalStroke localHorizontalStroke4 = null;
      localObject1 = localHorizontalStroke4;
      Object localObject2 = localObject1;
      Object localObject3 = localObject2;
      Object localObject4 = localObject2;
      Object localObject5 = localObject1;
      a(paramContext, paramArrayList);
      if (localObject6 != null) {
        paramArrayList.add(localObject6);
      }
      if (localHorizontalStroke4 != null) {
        paramArrayList.add(localHorizontalStroke4);
      }
      if (localObject5 != null) {
        paramArrayList.add(localObject5);
      }
      if (localObject4 != null) {
        paramArrayList.add(localObject4);
      }
      if (localObject3 != null) {
        paramArrayList.add(localObject3);
      }
    }
    else
    {
      a(paramContext, paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.strategy.ConfigurableLineLayerStrokeStrategy
 * JD-Core Version:    0.7.0.1
 */