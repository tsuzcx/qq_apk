import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import java.util.ArrayList;

public abstract class aygz
  extends ayjm
{
  protected QQAppInterface a;
  protected FTSEntity a;
  protected CharSequence a;
  protected String a;
  protected ArrayList<String> a;
  protected CharSequence b;
  protected CharSequence c;
  private CharSequence d;
  
  public aygz(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, FTSEntity paramFTSEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity = paramFTSEntity;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if (this.d == null) {
      this.d = ayrd.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity.mContent, this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity.mProximityStart, this.jdField_a_of_type_JavaUtilArrayList);
    }
    return this.d;
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public abstract CharSequence e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygz
 * JD-Core Version:    0.7.0.1
 */