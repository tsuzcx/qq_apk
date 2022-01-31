import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean.FilterID;

public class blof
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 0;
  private bllj jdField_a_of_type_Bllj;
  private bllm jdField_a_of_type_Bllm;
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
  
  public bllj a()
  {
    return this.jdField_a_of_type_Bllj;
  }
  
  public bllm a()
  {
    return this.jdField_a_of_type_Bllm;
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
  
  public void a(bllj parambllj)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Bllj = parambllj;
    this.jdField_a_of_type_Int = this.b;
    this.b = 1;
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.AIFilter;
  }
  
  public void a(bllm parambllm)
  {
    this.jdField_a_of_type_Bllm = parambllm;
    this.jdField_a_of_type_Int = this.b;
    this.b = 2;
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.Comics;
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = this.b;
    this.b = paramInt;
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.COLOR;
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
    return this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID == AEEditorFilterBean.FilterID.Comics;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blof
 * JD-Core Version:    0.7.0.1
 */