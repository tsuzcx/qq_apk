import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class bleg
  extends bmes
{
  private bmen<List<blag>> jdField_a_of_type_Bmen = new bmen();
  private Map<String, blae> jdField_a_of_type_JavaUtilMap = new HashMap();
  private bmen<blaj> b = new bmen();
  
  public bmen<List<blag>> a()
  {
    return this.jdField_a_of_type_Bmen;
  }
  
  public void a(bmdn parambmdn, String paramString)
  {
    QLog.d("AEGIFMaterialViewModel", 4, "LoadingGifTplData");
    ThreadManager.getSubThreadHandler().post(new AEGIFMaterialViewModel.1(this, paramString));
    bkzr.a().a(parambmdn, new bleh(this, paramString));
  }
  
  public void a(AppInterface paramAppInterface, blca paramblca)
  {
    blei localblei = new blei(this);
    this.jdField_a_of_type_JavaUtilMap.put(paramblca.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id, localblei);
    blac.a().a(paramAppInterface, paramblca.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, localblei);
  }
  
  public void a(String paramString)
  {
    Object localObject1 = bkzr.a();
    QLog.d("AEGIFMaterialViewModel", 4, "Parsing EmoCategories");
    if (localObject1 == null)
    {
      QLog.e("AEGIFMaterialViewModel", 4, "CategoryMaterialRsp is null");
      if ((localObject1 != null) && (((GetCategoryMaterialRsp)localObject1).Categories != null)) {
        break label54;
      }
    }
    for (;;)
    {
      return;
      if (((GetCategoryMaterialRsp)localObject1).Categories != null) {
        break;
      }
      QLog.e("AEGIFMaterialViewModel", 4, "Categories null");
      break;
      label54:
      Object localObject2 = ((GetCategoryMaterialRsp)localObject1).Categories.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (MetaCategory)((Iterator)localObject2).next();
      } while (!((MetaCategory)localObject1).name.toLowerCase().equals(paramString));
      for (paramString = (String)localObject1; (paramString != null) && (paramString.materials != null); paramString = null)
      {
        localObject1 = new ArrayList();
        paramString = paramString.materials.iterator();
        if (paramString.hasNext())
        {
          localObject2 = (MetaMaterial)paramString.next();
          blag localblag = new blag();
          localblag.jdField_a_of_type_JavaLangString = ((MetaMaterial)localObject2).id;
          localblag.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = ((MetaMaterial)localObject2);
          if (blac.a().a((MetaMaterial)localObject2)) {}
          for (int i = 2;; i = 0)
          {
            localblag.jdField_a_of_type_Int = i;
            ((List)localObject1).add(localblag);
            break;
          }
        }
        QLog.e("AEGIFMaterialViewModel", 4, "Updating Materials size === " + ((List)localObject1).size());
        this.jdField_a_of_type_Bmen.a(localObject1);
        return;
      }
    }
  }
  
  public bmen<blaj> b()
  {
    return this.b;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bleg
 * JD-Core Version:    0.7.0.1
 */