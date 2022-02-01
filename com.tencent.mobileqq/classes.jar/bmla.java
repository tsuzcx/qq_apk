import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean.FilterID;

public class bmla
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 0;
  private bmgl jdField_a_of_type_Bmgl;
  private bmgo jdField_a_of_type_Bmgo;
  private AEEditorFilterBean.FilterID jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.NON;
  private String jdField_a_of_type_JavaLangString;
  private int b = 0;
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public bmgl a()
  {
    return this.jdField_a_of_type_Bmgl;
  }
  
  public bmgo a()
  {
    return this.jdField_a_of_type_Bmgo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = this.b;
    this.b = 0;
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.NON;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(bmgl parambmgl)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Bmgl = parambmgl;
    this.jdField_a_of_type_Int = this.b;
    this.b = 1;
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.AIFilter;
  }
  
  public void a(bmgo parambmgo, int paramInt)
  {
    this.jdField_a_of_type_Bmgo = parambmgo;
    this.jdField_a_of_type_Int = this.b;
    this.b = paramInt;
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.NETWORK;
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = this.b;
    this.b = paramInt;
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.CLIENT;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID == AEEditorFilterBean.FilterID.NON;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID == AEEditorFilterBean.FilterID.AIFilter;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID == AEEditorFilterBean.FilterID.NETWORK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmla
 * JD-Core Version:    0.7.0.1
 */