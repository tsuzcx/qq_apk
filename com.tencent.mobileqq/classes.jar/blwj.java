import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.data.AEGifCategoryWrapper;
import java.util.Iterator;
import java.util.List;

class blwj
  implements Observer<blvg>
{
  blwj(blwd paramblwd) {}
  
  public void a(@Nullable blvg paramblvg)
  {
    label4:
    Object localObject1;
    Object localObject2;
    if (paramblvg == null)
    {
      return;
    }
    else
    {
      boolean bool = blwd.a(this.a);
      if (bool) {
        blwd.a(this.a, null);
      }
      localObject1 = blwd.a(this.a).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (blvd)((Iterator)localObject1).next();
        if (((blvd)localObject2).jdField_a_of_type_JavaLangString.equals(paramblvg.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id))
        {
          if (((blvd)localObject2).jdField_a_of_type_Int != paramblvg.jdField_a_of_type_Int)
          {
            ((blvd)localObject2).jdField_a_of_type_Int = paramblvg.jdField_a_of_type_Int;
            blwd.a(this.a).a((blvd)localObject2, bool);
          }
          if ((((blvd)localObject2).jdField_a_of_type_Int == 2) && (((blvd)localObject2).jdField_a_of_type_JavaLangString.equals(blwd.b(this.a))) && (!bool)) {
            blwd.a(this.a).b((blvd)localObject2);
          }
        }
      }
      localObject2 = blwd.b(this.a).iterator();
    }
    label293:
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label4;
      }
      localObject1 = (AEGifCategoryWrapper)((Iterator)localObject2).next();
      if ((localObject1 == null) || (CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject1).materialWrapperList))) {
        break;
      }
      Iterator localIterator = ((AEGifCategoryWrapper)localObject1).materialWrapperList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (blvd)localIterator.next();
      } while ((localObject1 == null) || (TextUtils.isEmpty(((blvd)localObject1).jdField_a_of_type_JavaLangString)) || (!((blvd)localObject1).jdField_a_of_type_JavaLangString.equals(paramblvg.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)));
      for (;;)
      {
        if (localObject1 == null) {
          break label293;
        }
        if (((blvd)localObject1).jdField_a_of_type_Int == paramblvg.jdField_a_of_type_Int) {
          break;
        }
        ((blvd)localObject1).jdField_a_of_type_Int = paramblvg.jdField_a_of_type_Int;
        return;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwj
 * JD-Core Version:    0.7.0.1
 */