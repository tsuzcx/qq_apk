import android.support.annotation.Nullable;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class blbp
  extends bmes
{
  private bmen<List<blag>> jdField_a_of_type_Bmen = new bmen();
  private Map<String, blae> jdField_a_of_type_JavaUtilMap = new HashMap();
  private bmen<blaj> b = new bmen();
  private bmen<blag> c = new bmen();
  private bmen<String> d = new bmen();
  
  private void c()
  {
    Object localObject1 = bkzr.a();
    if ((localObject1 == null) || (((GetCategoryMaterialRsp)localObject1).Categories == null)) {}
    for (;;)
    {
      return;
      Object localObject2 = ((GetCategoryMaterialRsp)localObject1).Categories.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (MetaCategory)((Iterator)localObject2).next();
      } while (!((MetaCategory)localObject1).name.equals(alud.a(2131700395)));
      while ((localObject1 != null) && (((MetaCategory)localObject1).materials != null))
      {
        localObject2 = new ArrayList();
        localObject1 = ((MetaCategory)localObject1).materials.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          MetaMaterial localMetaMaterial = (MetaMaterial)((Iterator)localObject1).next();
          blag localblag = new blag();
          localblag.jdField_a_of_type_JavaLangString = localMetaMaterial.id;
          localblag.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localMetaMaterial;
          if (blac.a().a(localMetaMaterial)) {}
          for (int i = 2;; i = 0)
          {
            localblag.jdField_a_of_type_Int = i;
            ((List)localObject2).add(localblag);
            break;
          }
        }
        this.jdField_a_of_type_Bmen.a(localObject2);
        return;
        localObject1 = null;
      }
    }
  }
  
  public bmen<List<blag>> a()
  {
    return this.jdField_a_of_type_Bmen;
  }
  
  public void a()
  {
    blag localblag = (blag)this.c.a();
    bljn.b("AEVideoStoryGIFTplViewModel", "applyGIFTplAgain---lastMaterial=" + localblag);
    this.c.a(localblag);
  }
  
  public void a(bkpl parambkpl)
  {
    ThreadManager.getSubThreadHandler().post(new AEVideoStoryGIFTplViewModel.1(this));
    bkzr.a().a(parambkpl, new blbq(this));
  }
  
  public void a(blag paramblag)
  {
    blbr localblbr = new blbr(this);
    this.jdField_a_of_type_JavaUtilMap.put(paramblag.jdField_a_of_type_JavaLangString, localblbr);
    blac.a().a(blqh.a(), paramblag.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, localblbr);
  }
  
  public bmen<blaj> b()
  {
    return this.b;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void b(@Nullable blag paramblag)
  {
    this.c.a(paramblag);
  }
  
  public bmen<blag> c()
  {
    return this.c;
  }
  
  public void c(@Nullable blag paramblag)
  {
    if (paramblag != null)
    {
      paramblag = (String)paramblag.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename");
      this.d.a(paramblag);
      return;
    }
    this.d.a(null);
  }
  
  public bmen<String> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbp
 * JD-Core Version:    0.7.0.1
 */