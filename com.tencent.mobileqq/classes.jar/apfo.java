import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.SearchTypeDetailActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class apfo
  implements apfn
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  
  public apfo(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, List<Integer> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.i("QFileOfflineSearchTypeController", 4, "unknown search type.");
      return;
    case 3: 
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 1, 0, "", "", "", "");
      SearchTypeDetailActivity.a(this.jdField_a_of_type_AndroidContentContext, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
      return;
    case 2: 
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 2, 0, "", "", "", "");
      SearchTypeDetailActivity.a(this.jdField_a_of_type_AndroidContentContext, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
      return;
    case 0: 
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 3, 0, "", "", "", "");
      SearchTypeDetailActivity.a(this.jdField_a_of_type_AndroidContentContext, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
      return;
    case 1: 
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 4, 0, "", "", "", "");
      SearchTypeDetailActivity.a(this.jdField_a_of_type_AndroidContentContext, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 5, 0, "", "", "", "");
    SearchTypeDetailActivity.a(this.jdField_a_of_type_AndroidContentContext, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfo
 * JD-Core Version:    0.7.0.1
 */