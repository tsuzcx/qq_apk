import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import java.util.HashMap;

public class bjno
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private bjnh jdField_a_of_type_Bjnh;
  private PanoramaPieceManager jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public bjno(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.g = false;
      this.jdField_a_of_type_Bjnh = new bjnj(this.g);
    }
    while (paramInt != 2) {
      return;
    }
    this.g = true;
    this.jdField_a_of_type_Bjnh = new bjng(this.g);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable a()
  {
    this.f = false;
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public bjnh a()
  {
    return this.jdField_a_of_type_Bjnh;
  }
  
  public bjno a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Bjnh != null) {
      this.jdField_a_of_type_Bjnh.d(paramInt);
    }
    return this;
  }
  
  public bjno a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.f = true;
    if ((paramDrawable != null) && (this.jdField_a_of_type_Bjnh != null)) {
      this.jdField_a_of_type_Bjnh.a(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    }
    return this;
  }
  
  public bjno a(bjni parambjni)
  {
    if ((this.jdField_a_of_type_Bjnh != null) && (parambjni != null)) {
      this.jdField_a_of_type_Bjnh.a(parambjni);
    }
    return this;
  }
  
  public bjno a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bjno a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return this;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
    return this;
  }
  
  public bjno a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public PanoramaPieceManager a()
  {
    return this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilHashMap == null)) {
      return null;
    }
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a(PanoramaPieceManager paramPanoramaPieceManager)
  {
    this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager = paramPanoramaPieceManager;
    if (this.jdField_a_of_type_Bjnh != null) {
      this.jdField_a_of_type_Bjnh.a(paramPanoramaPieceManager);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public bjno b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public bjno b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bjno b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public bjno c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public bjno c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public bjno d(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public bjno e(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public boolean g()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjno
 * JD-Core Version:    0.7.0.1
 */