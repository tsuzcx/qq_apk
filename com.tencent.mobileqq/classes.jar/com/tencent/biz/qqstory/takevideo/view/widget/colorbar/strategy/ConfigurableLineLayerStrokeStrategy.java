package com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.PersonalityStroke;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.PureStroke;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.Stroke;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ConfigurableLineLayerStrokeStrategy
  implements StrokeStrategy
{
  public static final String[] a;
  private AppInterface a;
  public boolean a;
  public boolean b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "vivo X20A" };
  }
  
  public ConfigurableLineLayerStrokeStrategy(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void a(@NonNull ArrayList paramArrayList, @NonNull Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Doodle_Strokes_CfgLineLayerStrokeStrategy", 2, "createStroke");
    }
    int i = 0;
    while (i < PureStroke.a.length)
    {
      paramArrayList.add(new PureStroke(paramContext, i));
      i += 1;
    }
    int k = UIUtils.b(paramContext);
    int j = 0;
    i = j;
    Object localObject;
    if (this.b)
    {
      boolean bool = PtvFilterSoLoad.c();
      i = j;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        i = j;
        if (bool)
        {
          localObject = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).b();
          if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
            break label417;
          }
          localObject = ((ArrayList)localObject).iterator();
          i = 0;
          while (((Iterator)localObject).hasNext())
          {
            PtvTemplateManager.DoodleInfo localDoodleInfo = (PtvTemplateManager.DoodleInfo)((Iterator)localObject).next();
            if (((!"doodle_highlighter".equals(localDoodleInfo.doodleName)) || (Build.VERSION.SDK_INT >= 18)) && ((k > 800) || ((!"doodle_fireworks".equals(localDoodleInfo.doodleName)) && (!"doodle_image_mouth".equals(localDoodleInfo.doodleName)))))
            {
              ArrayList localArrayList = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(localDoodleInfo);
              if (localArrayList != null)
              {
                paramArrayList.add(new PersonalityStroke(paramContext, UIUtils.a(paramContext, 14.0F), UIUtils.a(paramContext, 24.0F), new BitmapDrawable(paramContext.getResources(), (Bitmap)localArrayList.get(2)), new BitmapDrawable(paramContext.getResources(), (Bitmap)localArrayList.get(1)), new BitmapDrawable(paramContext.getResources(), (Bitmap)localArrayList.get(0)), 2, Integer.valueOf(localDoodleInfo.doodleId).intValue()));
                i = 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        ((PureStroke)paramArrayList.get(PureStroke.a.length - 1)).a();
      }
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = new PersonalityStroke(paramContext, UIUtils.a(paramContext, 17.0F), UIUtils.a(paramContext, 17.0F), paramContext.getResources().getDrawable(2130843549), paramContext.getResources().getDrawable(2130843291), paramContext.getResources().getDrawable(2130843283), 1, 0);
        ((Stroke)localObject).a(UIUtils.a(paramContext, 12.0F), 0);
        paramArrayList.add(localObject);
      }
      return;
      label417:
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("Doodle_Strokes_CfgLineLayerStrokeStrategy", 2, "createStroke doodleInfo is NUll !");
        i = j;
      }
    }
  }
  
  public void b(@NonNull ArrayList paramArrayList, @NonNull Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Doodle_Strokes_CfgLineLayerStrokeStrategy", 2, "createHorizontalStroke");
    }
    if (this.jdField_a_of_type_Boolean) {
      paramArrayList.add(new HorizontalStroke(paramContext.getResources().getDrawable(2130843578), 1, 0));
    }
    Iterator localIterator;
    Object localObject1;
    Object localObject9;
    HorizontalStroke localHorizontalStroke2;
    Object localObject10;
    Object localObject3;
    Object localObject11;
    Object localObject2;
    Object localObject12;
    HorizontalStroke localHorizontalStroke1;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    int i;
    if (this.b)
    {
      localIterator = null;
      localObject1 = null;
      localObject9 = null;
      localHorizontalStroke2 = null;
      localObject10 = null;
      localObject3 = null;
      localObject11 = null;
      localObject2 = null;
      localObject12 = null;
      localHorizontalStroke1 = null;
      boolean bool = PtvFilterSoLoad.c();
      localObject4 = localObject12;
      localObject5 = localObject11;
      localObject6 = localObject10;
      localObject7 = localObject9;
      localObject8 = localIterator;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        localObject4 = localObject12;
        localObject5 = localObject11;
        localObject6 = localObject10;
        localObject7 = localObject9;
        localObject8 = localIterator;
        if (bool)
        {
          localObject4 = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).b();
          if ((localObject4 != null) && (!((ArrayList)localObject4).isEmpty()))
          {
            localIterator = ((ArrayList)localObject4).iterator();
            do
            {
              localObject4 = localHorizontalStroke1;
              localObject5 = localObject2;
              localObject6 = localObject3;
              localObject7 = localHorizontalStroke2;
              localObject8 = localObject1;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject4 = (PtvTemplateManager.DoodleInfo)localIterator.next();
            } while (("doodle_highlighter".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName)) && (Build.VERSION.SDK_INT < 18));
            i = Integer.valueOf(((PtvTemplateManager.DoodleInfo)localObject4).doodleId).intValue();
            if ("doodle_image_family".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
            {
              localObject4 = new HorizontalStroke(paramContext.getResources().getDrawable(2130842405), 2, i);
              localObject2 = localObject3;
              localObject3 = localObject1;
              localObject1 = localObject4;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject4 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
      break;
      if ("doodle_image_mouth".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localHorizontalStroke1 = new HorizontalStroke(paramContext.getResources().getDrawable(2130842406), 2, i);
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      else if ("doodle_image_xin".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localObject4 = new HorizontalStroke(paramContext.getResources().getDrawable(2130842407), 2, i);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else if ("doodle_highlighter".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localObject4 = new HorizontalStroke(paramContext.getResources().getDrawable(2130842404), 2, i);
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      else if ("doodle_fireworks".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localHorizontalStroke2 = new HorizontalStroke(paramContext.getResources().getDrawable(2130842402), 2, i);
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        continue;
        localObject4 = localObject12;
        localObject5 = localObject11;
        localObject6 = localObject10;
        localObject7 = localObject9;
        localObject8 = localIterator;
        if (QLog.isColorLevel())
        {
          QLog.d("Doodle_Strokes_CfgLineLayerStrokeStrategy", 2, "createHorizontalStroke doodleInfo is NUll !");
          localObject8 = localIterator;
          localObject7 = localObject9;
          localObject6 = localObject10;
          localObject5 = localObject11;
          localObject4 = localObject12;
        }
        i = 0;
        while (i < 4)
        {
          paramArrayList.add(new HorizontalStroke(paramContext.getResources().getDrawable(HorizontalStroke.b[i]), 0, HorizontalStroke.a[i]));
          i += 1;
        }
        paramArrayList.add(new HorizontalStroke(paramContext.getResources().getDrawable(2130843571), 0, -1));
        int k = 0;
        paramContext = jdField_a_of_type_ArrayOfJavaLangString;
        int m = paramContext.length;
        i = 0;
        int j = k;
        if (i < m)
        {
          if (paramContext[i].equals(Build.MODEL)) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break label714;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CfgLineLayerStrokeStrategy", 2, "createHorizontalStroke black model " + Build.MODEL);
          }
        }
        for (;;)
        {
          return;
          i += 1;
          break;
          label714:
          if (localObject8 != null) {
            paramArrayList.add(localObject8);
          }
          if (localObject7 != null) {
            paramArrayList.add(localObject7);
          }
          if (localObject6 != null) {
            paramArrayList.add(localObject6);
          }
          if (localObject5 != null) {
            paramArrayList.add(localObject5);
          }
          if (localObject4 != null)
          {
            paramArrayList.add(localObject4);
            return;
            i = 0;
            while (i < HorizontalStroke.a.length)
            {
              if (HorizontalStroke.a[i] != -9576193) {
                paramArrayList.add(new HorizontalStroke(paramContext.getResources().getDrawable(HorizontalStroke.b[i]), 0, HorizontalStroke.a[i]));
              }
              i += 1;
            }
          }
        }
      }
      else
      {
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy.ConfigurableLineLayerStrokeStrategy
 * JD-Core Version:    0.7.0.1
 */