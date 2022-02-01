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

public class bnsc
  implements bnse
{
  private AppInterface a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public bnsc(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
  }
  
  public void a(Context paramContext, ArrayList<bnsf> paramArrayList)
  {
    int[] arrayOfInt1;
    if (this.c)
    {
      arrayOfInt1 = bnsf.d;
      if (!this.c) {
        break label76;
      }
    }
    label76:
    for (int[] arrayOfInt2 = bnsf.jdField_b_of_type_ArrayOfInt;; arrayOfInt2 = bnsf.a)
    {
      int i = 0;
      while (i < arrayOfInt1.length)
      {
        paramArrayList.add(new bnsf(paramContext.getResources().getDrawable(arrayOfInt1[i]), 0, arrayOfInt2[i]));
        i += 1;
      }
      arrayOfInt1 = bnsf.c;
      break;
    }
  }
  
  public void a(@NonNull ArrayList<bnsf> paramArrayList, @NonNull Context paramContext)
  {
    Object localObject7 = null;
    bnsf localbnsf1 = null;
    if (QLog.isColorLevel()) {
      QLog.e("CfgLineLayerStrokeStrategy", 2, new Object[] { "createHorizontalStroke, mNeedMosaic:", Boolean.valueOf(this.jdField_a_of_type_Boolean), " mNeedPersonality:", Boolean.valueOf(this.b), " mIsEditPic:", Boolean.valueOf(this.c) });
    }
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = new bnsf(paramContext.getResources().getDrawable(2130846699), 1, 0);
      ((bnsf)localObject1).jdField_b_of_type_JavaLangString = amtj.a(2131701583);
      paramArrayList.add(localObject1);
    }
    Object localObject2;
    Object localObject3;
    bnsf localbnsf2;
    Object localObject6;
    Object localObject5;
    bnsf localbnsf3;
    Object localObject4;
    int i;
    if (this.b)
    {
      boolean bool = bbxj.b();
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (bool))
      {
        localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a();
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
        {
          Iterator localIterator = ((ArrayList)localObject1).iterator();
          localObject2 = null;
          localObject3 = null;
          localbnsf2 = null;
          localObject1 = null;
          do
          {
            localObject7 = localbnsf1;
            localObject6 = localObject2;
            localObject5 = localObject3;
            localbnsf3 = localbnsf2;
            localObject4 = localObject1;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject4 = (PtvTemplateManager.DoodleInfo)localIterator.next();
          } while (("doodle_highlighter".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName)) && (Build.VERSION.SDK_INT < 18));
          i = Integer.valueOf(((PtvTemplateManager.DoodleInfo)localObject4).doodleId).intValue();
          if ("doodle_image_family".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
          {
            localObject4 = new bnsf(paramContext.getResources().getDrawable(2130844952), 2, i);
            ((bnsf)localObject4).jdField_b_of_type_JavaLangString = amtj.a(2131701582);
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
        localbnsf1 = new bnsf(paramContext.getResources().getDrawable(2130844953), 2, i);
        localbnsf1.jdField_b_of_type_JavaLangString = amtj.a(2131701581);
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      else if ("doodle_image_xin".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localObject4 = new bnsf(paramContext.getResources().getDrawable(2130844954), 2, i);
        ((bnsf)localObject4).jdField_b_of_type_JavaLangString = amtj.a(2131701584);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else if ("doodle_highlighter".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localObject4 = new bnsf(paramContext.getResources().getDrawable(2130844951), 2, i);
        ((bnsf)localObject4).jdField_b_of_type_JavaLangString = amtj.a(2131701579);
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      else if ("doodle_fireworks".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localbnsf2 = new bnsf(paramContext.getResources().getDrawable(2130844950), 2, i);
        localbnsf2.jdField_b_of_type_JavaLangString = amtj.a(2131701580);
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
        localbnsf3 = null;
        localObject4 = null;
        a(paramContext, paramArrayList);
        if (localObject4 != null) {
          paramArrayList.add(localObject4);
        }
        if (localbnsf3 != null) {
          paramArrayList.add(localbnsf3);
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
        return;
        a(paramContext, paramArrayList);
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
 * Qualified Name:     bnsc
 * JD-Core Version:    0.7.0.1
 */