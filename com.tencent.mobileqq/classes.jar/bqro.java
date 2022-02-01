import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;

public class bqro
  extends bqrm
{
  public final int c;
  @NonNull
  public final String c;
  public final int d;
  @NonNull
  public final String d;
  public final int e;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  
  public bqro(int paramInt1, String paramString1, int paramInt2, @NonNull String paramString2, @NonNull String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramInt1, paramString1, paramInt2);
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_e_of_type_JavaLangString = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramString7;
    this.i = paramString8;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_e_of_type_Int = paramInt5;
  }
  
  @NonNull
  public bqrn a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new bqrp(this, paramContext, paramViewGroup);
  }
  
  @NonNull
  public Class<? extends bqrn> a()
  {
    return bqrp.class;
  }
  
  public String a()
  {
    if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))) {
      return "";
    }
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
      return this.jdField_c_of_type_JavaLangString + "，" + this.jdField_d_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return this.jdField_c_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      return this.jdField_d_of_type_JavaLangString;
    }
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqro
 * JD-Core Version:    0.7.0.1
 */