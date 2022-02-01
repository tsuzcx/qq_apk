import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.data.AEGifCategoryWrapper;
import java.util.Iterator;
import java.util.List;

class bnlt
  implements Observer<bnkn>
{
  bnlt(bnln parambnln) {}
  
  public void a(@Nullable bnkn parambnkn)
  {
    label4:
    Object localObject1;
    Object localObject2;
    if (parambnkn == null)
    {
      return;
    }
    else
    {
      boolean bool = bnln.a(this.a);
      if (bool) {
        bnln.a(this.a, null);
      }
      localObject1 = bnln.a(this.a).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bnkg)((Iterator)localObject1).next();
        if (((bnkg)localObject2).jdField_a_of_type_JavaLangString.equals(parambnkn.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id))
        {
          if (((bnkg)localObject2).jdField_a_of_type_Int != parambnkn.jdField_a_of_type_Int)
          {
            ((bnkg)localObject2).jdField_a_of_type_Int = parambnkn.jdField_a_of_type_Int;
            bnln.a(this.a).a((bnkg)localObject2, bool);
          }
          if ((((bnkg)localObject2).jdField_a_of_type_Int == 2) && (((bnkg)localObject2).jdField_a_of_type_JavaLangString.equals(bnln.b(this.a))) && (!bool)) {
            bnln.a(this.a).b((bnkg)localObject2);
          }
        }
      }
      localObject2 = bnln.b(this.a).iterator();
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
        localObject1 = (bnkg)localIterator.next();
      } while ((localObject1 == null) || (TextUtils.isEmpty(((bnkg)localObject1).jdField_a_of_type_JavaLangString)) || (!((bnkg)localObject1).jdField_a_of_type_JavaLangString.equals(parambnkn.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)));
      for (;;)
      {
        if (localObject1 == null) {
          break label293;
        }
        if (((bnkg)localObject1).jdField_a_of_type_Int == parambnkn.jdField_a_of_type_Int) {
          break;
        }
        ((bnkg)localObject1).jdField_a_of_type_Int = parambnkn.jdField_a_of_type_Int;
        return;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlt
 * JD-Core Version:    0.7.0.1
 */