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
  public static final int[] a = { 2130848557, 2130848560, 2130848558, 2130848563, 2130848562 };
  public static final int[] b = { 2130848559, 2130848557, 2130848560, 2130848558, 2130848563, 2130848562 };
  private AppInterface c;
  private final boolean d;
  private final boolean e;
  private final boolean f;
  
  public ConfigurableLineLayerStrokeStrategy(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.c = paramAppInterface;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramBoolean3;
  }
  
  public void a(Context paramContext, ArrayList<HorizontalStroke> paramArrayList)
  {
    int[] arrayOfInt1;
    if (this.f) {
      arrayOfInt1 = b;
    } else {
      arrayOfInt1 = a;
    }
    int[] arrayOfInt2;
    if (this.f) {
      arrayOfInt2 = HorizontalStroke.b;
    } else {
      arrayOfInt2 = HorizontalStroke.a;
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
      QLog.e("CfgLineLayerStrokeStrategy", 2, new Object[] { "createHorizontalStroke, mNeedMosaic:", Boolean.valueOf(this.d), " mNeedPersonality:", Boolean.valueOf(this.e), " mIsEditPic:", Boolean.valueOf(this.f) });
    }
    Object localObject1;
    if (this.d)
    {
      localObject1 = new HorizontalStroke(paramContext.getResources().getDrawable(2130848565), 1, 0);
      ((HorizontalStroke)localObject1).g = HardCodeUtil.a(2131900614);
      paramArrayList.add(localObject1);
    }
    if (this.e)
    {
      boolean bool = PtvFilterSoLoad.d();
      localObject1 = this.c;
      Object localObject6 = null;
      HorizontalStroke localHorizontalStroke2 = null;
      if ((localObject1 != null) && (bool))
      {
        localObject1 = PtvTemplateManager.a().d();
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
            if ((!"doodle_highlighter".equals(((DoodleInfo)localObject3).b)) || (Build.VERSION.SDK_INT >= 18))
            {
              int i = Integer.valueOf(((DoodleInfo)localObject3).a).intValue();
              if ("doodle_image_family".equals(((DoodleInfo)localObject3).b))
              {
                localObject2 = new HorizontalStroke(paramContext.getResources().getDrawable(2130846500), 2, i);
                ((HorizontalStroke)localObject2).g = HardCodeUtil.a(2131900613);
              }
              else if ("doodle_image_mouth".equals(((DoodleInfo)localObject3).b))
              {
                localObject1 = new HorizontalStroke(paramContext.getResources().getDrawable(2130846501), 2, i);
                ((HorizontalStroke)localObject1).g = HardCodeUtil.a(2131900612);
              }
              else if ("doodle_image_xin".equals(((DoodleInfo)localObject3).b))
              {
                localHorizontalStroke1 = new HorizontalStroke(paramContext.getResources().getDrawable(2130846502), 2, i);
                localHorizontalStroke1.g = HardCodeUtil.a(2131900615);
              }
              else if ("doodle_highlighter".equals(((DoodleInfo)localObject3).b))
              {
                localHorizontalStroke2 = new HorizontalStroke(paramContext.getResources().getDrawable(2130846499), 2, i);
                localHorizontalStroke2.g = HardCodeUtil.a(2131900610);
              }
              else if ("doodle_fireworks".equals(((DoodleInfo)localObject3).b))
              {
                localHorizontalStroke3 = new HorizontalStroke(paramContext.getResources().getDrawable(2130846498), 2, i);
                localHorizontalStroke3.g = HardCodeUtil.a(2131900611);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.strategy.ConfigurableLineLayerStrokeStrategy
 * JD-Core Version:    0.7.0.1
 */