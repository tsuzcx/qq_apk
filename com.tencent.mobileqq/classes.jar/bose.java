import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.data.AEGifCategoryWrapper;
import java.util.Iterator;
import java.util.List;

class bose
  implements Observer<boqz>
{
  bose(bory parambory) {}
  
  public void a(@Nullable boqz paramboqz)
  {
    label4:
    Object localObject1;
    Object localObject2;
    if (paramboqz == null)
    {
      return;
    }
    else
    {
      localObject1 = bory.a(this.a).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (boqw)((Iterator)localObject1).next();
        if (((boqw)localObject2).jdField_a_of_type_JavaLangString.equals(paramboqz.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id))
        {
          if (((boqw)localObject2).jdField_a_of_type_Int != paramboqz.jdField_a_of_type_Int)
          {
            ((boqw)localObject2).jdField_a_of_type_Int = paramboqz.jdField_a_of_type_Int;
            bory.a(this.a).notifyItemChanged(bory.a(this.a).indexOf(localObject2));
          }
          if ((((boqw)localObject2).jdField_a_of_type_Int == 2) && (((boqw)localObject2).jdField_a_of_type_JavaLangString.equals(bory.b(this.a)))) {
            bory.a(this.a).b((boqw)localObject2);
          }
        }
      }
      localObject2 = bory.b(this.a).iterator();
    }
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
        localObject1 = (boqw)localIterator.next();
      } while ((localObject1 == null) || (TextUtils.isEmpty(((boqw)localObject1).jdField_a_of_type_JavaLangString)) || (!((boqw)localObject1).jdField_a_of_type_JavaLangString.equals(paramboqz.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)));
      while (localObject1 != null)
      {
        ((boqw)localObject1).jdField_a_of_type_Int = paramboqz.jdField_a_of_type_Int;
        return;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bose
 * JD-Core Version:    0.7.0.1
 */