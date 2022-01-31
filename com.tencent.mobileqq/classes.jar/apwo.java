import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;

public abstract class apwo
  extends apte
{
  apsb jdField_a_of_type_Apsb = new apwq(this);
  apse jdField_a_of_type_Apse = new apwp(this);
  protected int h = 2;
  
  public apwo(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, apuc paramapuc)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramapuc);
    aprn.a().a(this.jdField_a_of_type_Apsb);
    apsf.a().a(this.jdField_a_of_type_Apse);
  }
  
  public void a()
  {
    super.a();
    aprn.a().b(this.jdField_a_of_type_Apsb);
    apsf.a().b(this.jdField_a_of_type_Apse);
  }
  
  public void a(int paramInt) {}
  
  public void a(EmoticonPackage paramEmoticonPackage) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
  
  public void b(EmoticonPackage paramEmoticonPackage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwo
 * JD-Core Version:    0.7.0.1
 */