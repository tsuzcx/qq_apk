import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper;
import com.tencent.widget.ListView;

public class arai
  extends EmoticonPanelHotPicSearchHelper
{
  private Context jdField_a_of_type_AndroidContentContext;
  private aufg jdField_a_of_type_Aufg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public arai(QQAppInterface paramQQAppInterface, Context paramContext, aufg paramaufg)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aufg = paramaufg;
  }
  
  public void a(ListView paramListView, BaseEmotionAdapter paramBaseEmotionAdapter)
  {
    attach(paramListView, paramBaseEmotionAdapter);
    paramBaseEmotionAdapter = getFooterView();
    if (paramBaseEmotionAdapter.getParent() == null) {
      paramListView.addFooterView(paramBaseEmotionAdapter);
    }
  }
  
  public void clearSearchWords()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public QQAppInterface getApp()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public Context getContext()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public int getPageType()
  {
    return 2;
  }
  
  public String getSearchWord()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String getTag()
  {
    return "RichTextPanelEmoticonSearchLayoutHelper";
  }
  
  public void onPullDown()
  {
    this.jdField_a_of_type_Aufg.onPullDown();
  }
  
  public void onPullUp() {}
  
  public void setSearchWords(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arai
 * JD-Core Version:    0.7.0.1
 */