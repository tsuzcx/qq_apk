import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class bkpb
  implements bkpd
{
  private AppInterface a;
  public boolean a;
  public boolean b;
  
  public bkpb(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void a(@NonNull ArrayList<bkpe> paramArrayList, @NonNull Context paramContext)
  {
    Object localObject7 = null;
    bkpe localbkpe1 = null;
    if (QLog.isColorLevel()) {
      QLog.e("Doodle_Strokes_CfgLineLayerStrokeStrategy", 2, "createHorizontalStroke");
    }
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = new bkpe(paramContext.getResources().getDrawable(2130845883), 1, 0);
      ((bkpe)localObject1).jdField_b_of_type_JavaLangString = ajya.a(2131702437);
      paramArrayList.add(localObject1);
    }
    Object localObject2;
    Object localObject3;
    bkpe localbkpe2;
    Object localObject6;
    Object localObject5;
    bkpe localbkpe3;
    Object localObject4;
    int i;
    if (this.b)
    {
      boolean bool = axle.e();
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (bool))
      {
        localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a();
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
        {
          Iterator localIterator = ((ArrayList)localObject1).iterator();
          localObject2 = null;
          localObject3 = null;
          localbkpe2 = null;
          localObject1 = null;
          do
          {
            localObject7 = localbkpe1;
            localObject6 = localObject2;
            localObject5 = localObject3;
            localbkpe3 = localbkpe2;
            localObject4 = localObject1;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject4 = (PtvTemplateManager.DoodleInfo)localIterator.next();
          } while (("doodle_highlighter".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName)) && (Build.VERSION.SDK_INT < 18));
          i = Integer.valueOf(((PtvTemplateManager.DoodleInfo)localObject4).doodleId).intValue();
          if ("doodle_image_family".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
          {
            localObject4 = new bkpe(paramContext.getResources().getDrawable(2130844247), 2, i);
            ((bkpe)localObject4).jdField_b_of_type_JavaLangString = ajya.a(2131702436);
            localObject2 = localObject3;
            localObject3 = localObject1;
            localObject1 = localObject4;
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
        localbkpe1 = new bkpe(paramContext.getResources().getDrawable(2130844248), 2, i);
        localbkpe1.jdField_b_of_type_JavaLangString = ajya.a(2131702435);
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      else if ("doodle_image_xin".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localObject4 = new bkpe(paramContext.getResources().getDrawable(2130844249), 2, i);
        ((bkpe)localObject4).jdField_b_of_type_JavaLangString = ajya.a(2131702438);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else if ("doodle_highlighter".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localObject4 = new bkpe(paramContext.getResources().getDrawable(2130844246), 2, i);
        ((bkpe)localObject4).jdField_b_of_type_JavaLangString = ajya.a(2131702433);
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      else if ("doodle_fireworks".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localbkpe2 = new bkpe(paramContext.getResources().getDrawable(2130844245), 2, i);
        localbkpe2.jdField_b_of_type_JavaLangString = ajya.a(2131702434);
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Doodle_Strokes_CfgLineLayerStrokeStrategy", 2, "createHorizontalStroke doodleInfo is NUll !");
        }
        localObject6 = null;
        localObject5 = null;
        localbkpe3 = null;
        localObject4 = null;
        i = 0;
        while (i < bkpe.jdField_b_of_type_ArrayOfInt.length)
        {
          paramArrayList.add(new bkpe(paramContext.getResources().getDrawable(bkpe.jdField_b_of_type_ArrayOfInt[i]), 0, bkpe.a[i]));
          i += 1;
        }
        if (localObject4 != null) {
          paramArrayList.add(localObject4);
        }
        if (localbkpe3 != null) {
          paramArrayList.add(localbkpe3);
        }
        if (localObject5 != null) {
          paramArrayList.add(localObject5);
        }
        if (localObject6 != null) {
          paramArrayList.add(localObject6);
        }
        if (localObject7 != null) {
          paramArrayList.add(localObject7);
        }
        for (;;)
        {
          return;
          i = 0;
          while (i < bkpe.a.length)
          {
            paramArrayList.add(new bkpe(paramContext.getResources().getDrawable(bkpe.jdField_b_of_type_ArrayOfInt[i]), 0, bkpe.a[i]));
            i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpb
 * JD-Core Version:    0.7.0.1
 */