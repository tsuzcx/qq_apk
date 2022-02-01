import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.mode.AECaptureMode;
import org.jetbrains.annotations.NotNull;

public class bmvr
{
  private int jdField_a_of_type_Int;
  private alsn jdField_a_of_type_Alsn;
  private bmvu jdField_a_of_type_Bmvu;
  private SessionWrap jdField_a_of_type_DovComQqImAeSessionWrap;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private Float jdField_a_of_type_JavaLangFloat;
  private Integer jdField_a_of_type_JavaLangInteger;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private AECaptureMode[] jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private final int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int l;
  private int m;
  
  private bmvr(bmvt parambmvt)
  {
    this.jdField_g_of_type_Boolean = bmvt.a(parambmvt);
    this.jdField_e_of_type_Int = bmvt.a(parambmvt);
    this.jdField_h_of_type_Int = bmvt.b(parambmvt);
    this.jdField_i_of_type_Int = bmvt.c(parambmvt);
    this.jdField_j_of_type_Int = bmvt.d(parambmvt);
    this.l = bmvt.e(parambmvt);
    this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = bmvt.a(parambmvt);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureMode = bmvt.a(parambmvt);
    this.m = bmvt.f(parambmvt);
    this.jdField_k_of_type_Boolean = bmvt.b(parambmvt);
    this.jdField_a_of_type_DovComQqImAeSessionWrap = bmvt.a(parambmvt);
    this.jdField_a_of_type_JavaLangString = bmvt.a(parambmvt);
    this.jdField_j_of_type_Boolean = bmvt.c(parambmvt);
    this.jdField_a_of_type_Alsn = bmvt.a(parambmvt);
    this.jdField_a_of_type_JavaLangFloat = bmvt.a(parambmvt);
    this.jdField_a_of_type_JavaLangInteger = bmvt.a(parambmvt);
    this.jdField_h_of_type_Boolean = bmvt.d(parambmvt);
    this.jdField_i_of_type_Boolean = bmvt.e(parambmvt);
    this.jdField_g_of_type_Int = bmvt.g(parambmvt);
    this.jdField_k_of_type_Int = bmvt.h(parambmvt);
    this.jdField_f_of_type_Int = bmvt.i(parambmvt);
    this.jdField_d_of_type_Int = bmvt.j(parambmvt);
    this.jdField_b_of_type_Boolean = bmvt.f(parambmvt);
    this.jdField_d_of_type_Boolean = bmvt.g(parambmvt);
    this.jdField_e_of_type_Boolean = bmvt.h(parambmvt);
    this.jdField_a_of_type_Boolean = bmvt.i(parambmvt);
    this.jdField_f_of_type_Boolean = bmvt.j(parambmvt);
    this.jdField_b_of_type_Int = parambmvt.jdField_b_of_type_Int;
    this.jdField_a_of_type_Int = parambmvt.jdField_c_of_type_Int;
    this.jdField_c_of_type_Int = parambmvt.jdField_a_of_type_Int;
    this.jdField_c_of_type_Boolean = parambmvt.jdField_a_of_type_Boolean;
    if (bmvt.a(parambmvt) == null)
    {
      this.jdField_a_of_type_Bmvu = a();
      return;
    }
    this.jdField_a_of_type_Bmvu = bmvt.a(parambmvt);
  }
  
  @NotNull
  private bmvu a()
  {
    return new bmvs(this);
  }
  
  public int a()
  {
    return this.jdField_k_of_type_Int;
  }
  
  public alsn a()
  {
    if (this.jdField_a_of_type_Alsn == null) {
      this.jdField_a_of_type_Alsn = bbhu.a().a(this.jdField_h_of_type_Int);
    }
    return this.jdField_a_of_type_Alsn;
  }
  
  public SessionWrap a()
  {
    return this.jdField_a_of_type_DovComQqImAeSessionWrap;
  }
  
  public AECaptureMode a()
  {
    return this.jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  }
  
  public Float a()
  {
    if (this.jdField_a_of_type_JavaLangFloat == null) {
      this.jdField_a_of_type_JavaLangFloat = Float.valueOf(bbhu.a().a(this.jdField_h_of_type_Int));
    }
    return this.jdField_a_of_type_JavaLangFloat;
  }
  
  public Integer a()
  {
    if (this.jdField_a_of_type_JavaLangInteger == null) {
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(bbhu.a().a(this.jdField_h_of_type_Int) * 1000);
    }
    return this.jdField_a_of_type_JavaLangInteger;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public AECaptureMode[] a()
  {
    return this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public Integer b()
  {
    return Integer.valueOf(this.l);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int e()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public boolean e()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int f()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public boolean f()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int g()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public boolean g()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public int h()
  {
    return this.jdField_i_of_type_Int;
  }
  
  public boolean h()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public int i()
  {
    return this.jdField_j_of_type_Int;
  }
  
  public boolean i()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  public int j()
  {
    return this.m;
  }
  
  public boolean j()
  {
    return this.jdField_k_of_type_Boolean;
  }
  
  public int k()
  {
    return this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvr
 * JD-Core Version:    0.7.0.1
 */