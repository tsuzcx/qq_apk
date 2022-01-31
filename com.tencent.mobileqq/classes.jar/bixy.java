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

public class bixy
  implements biya
{
  private AppInterface a;
  public boolean a;
  public boolean b;
  
  public bixy(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void a(@NonNull ArrayList<biyb> paramArrayList, @NonNull Context paramContext)
  {
    Object localObject7 = null;
    biyb localbiyb1 = null;
    if (QLog.isColorLevel()) {
      QLog.e("Doodle_Strokes_CfgLineLayerStrokeStrategy", 2, "createHorizontalStroke");
    }
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = new biyb(paramContext.getResources().getDrawable(2130845695), 1, 0);
      ((biyb)localObject1).jdField_b_of_type_JavaLangString = ajjy.a(2131636642);
      paramArrayList.add(localObject1);
    }
    Object localObject2;
    Object localObject3;
    biyb localbiyb2;
    Object localObject6;
    Object localObject5;
    biyb localbiyb3;
    Object localObject4;
    int i;
    if (this.b)
    {
      boolean bool = awlw.e();
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (bool))
      {
        localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a();
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
        {
          Iterator localIterator = ((ArrayList)localObject1).iterator();
          localObject2 = null;
          localObject3 = null;
          localbiyb2 = null;
          localObject1 = null;
          do
          {
            localObject7 = localbiyb1;
            localObject6 = localObject2;
            localObject5 = localObject3;
            localbiyb3 = localbiyb2;
            localObject4 = localObject1;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject4 = (PtvTemplateManager.DoodleInfo)localIterator.next();
          } while (("doodle_highlighter".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName)) && (Build.VERSION.SDK_INT < 18));
          i = Integer.valueOf(((PtvTemplateManager.DoodleInfo)localObject4).doodleId).intValue();
          if ("doodle_image_family".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
          {
            localObject4 = new biyb(paramContext.getResources().getDrawable(2130844169), 2, i);
            ((biyb)localObject4).jdField_b_of_type_JavaLangString = ajjy.a(2131636641);
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
        localbiyb1 = new biyb(paramContext.getResources().getDrawable(2130844170), 2, i);
        localbiyb1.jdField_b_of_type_JavaLangString = ajjy.a(2131636640);
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      else if ("doodle_image_xin".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localObject4 = new biyb(paramContext.getResources().getDrawable(2130844171), 2, i);
        ((biyb)localObject4).jdField_b_of_type_JavaLangString = ajjy.a(2131636643);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else if ("doodle_highlighter".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localObject4 = new biyb(paramContext.getResources().getDrawable(2130844168), 2, i);
        ((biyb)localObject4).jdField_b_of_type_JavaLangString = ajjy.a(2131636638);
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      else if ("doodle_fireworks".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localbiyb2 = new biyb(paramContext.getResources().getDrawable(2130844166), 2, i);
        localbiyb2.jdField_b_of_type_JavaLangString = ajjy.a(2131636639);
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
        localbiyb3 = null;
        localObject4 = null;
        i = 0;
        while (i < biyb.jdField_b_of_type_ArrayOfInt.length)
        {
          paramArrayList.add(new biyb(paramContext.getResources().getDrawable(biyb.jdField_b_of_type_ArrayOfInt[i]), 0, biyb.a[i]));
          i += 1;
        }
        if (localObject4 != null) {
          paramArrayList.add(localObject4);
        }
        if (localbiyb3 != null) {
          paramArrayList.add(localbiyb3);
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
          while (i < biyb.a.length)
          {
            paramArrayList.add(new biyb(paramContext.getResources().getDrawable(biyb.jdField_b_of_type_ArrayOfInt[i]), 0, biyb.a[i]));
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
 * Qualified Name:     bixy
 * JD-Core Version:    0.7.0.1
 */