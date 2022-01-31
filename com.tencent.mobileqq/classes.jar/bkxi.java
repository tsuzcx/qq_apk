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

public class bkxi
  extends bmag
{
  private bmab<List<bkvz>> jdField_a_of_type_Bmab = new bmab();
  private Map<String, bkvx> jdField_a_of_type_JavaUtilMap = new HashMap();
  private bmab<bkwc> b = new bmab();
  private bmab<bkvz> c = new bmab();
  private bmab<String> d = new bmab();
  
  private void c()
  {
    Object localObject1 = bkvk.a();
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
      } while (!((MetaCategory)localObject1).name.equals(alpo.a(2131700383)));
      while ((localObject1 != null) && (((MetaCategory)localObject1).materials != null))
      {
        localObject2 = new ArrayList();
        localObject1 = ((MetaCategory)localObject1).materials.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          MetaMaterial localMetaMaterial = (MetaMaterial)((Iterator)localObject1).next();
          bkvz localbkvz = new bkvz();
          localbkvz.jdField_a_of_type_JavaLangString = localMetaMaterial.id;
          localbkvz.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localMetaMaterial;
          if (bkvv.a().a(localMetaMaterial)) {}
          for (int i = 2;; i = 0)
          {
            localbkvz.jdField_a_of_type_Int = i;
            ((List)localObject2).add(localbkvz);
            break;
          }
        }
        this.jdField_a_of_type_Bmab.a(localObject2);
        return;
        localObject1 = null;
      }
    }
  }
  
  public bmab<List<bkvz>> a()
  {
    return this.jdField_a_of_type_Bmab;
  }
  
  public void a()
  {
    bkvz localbkvz = (bkvz)this.c.a();
    blfg.b("AEVideoStoryGIFTplViewModel", "applyGIFTplAgain---lastMaterial=" + localbkvz);
    this.c.a(localbkvz);
  }
  
  public void a(bkle parambkle)
  {
    ThreadManager.getSubThreadHandler().post(new AEVideoStoryGIFTplViewModel.1(this));
    bkvk.a().a(parambkle, new bkxj(this));
  }
  
  public void a(bkvz parambkvz)
  {
    bkxk localbkxk = new bkxk(this);
    this.jdField_a_of_type_JavaUtilMap.put(parambkvz.jdField_a_of_type_JavaLangString, localbkxk);
    bkvv.a().a(bllv.a(), parambkvz.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, localbkxk);
  }
  
  public bmab<bkwc> b()
  {
    return this.b;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void b(@Nullable bkvz parambkvz)
  {
    this.c.a(parambkvz);
  }
  
  public bmab<bkvz> c()
  {
    return this.c;
  }
  
  public void c(@Nullable bkvz parambkvz)
  {
    if (parambkvz != null)
    {
      parambkvz = (String)parambkvz.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename");
      this.d.a(parambkvz);
      return;
    }
    this.d.a(null);
  }
  
  public bmab<String> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxi
 * JD-Core Version:    0.7.0.1
 */