import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import java.util.List;

public class amws
  implements Runnable
{
  public ISearchListener a;
  public SearchRequest a;
  
  private amws(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    SearchRequest localSearchRequest = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest;
    String str = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.a;
    List localList = this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine.a(localSearchRequest);
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) && (localSearchRequest == this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.a))) {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localList, 1);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amws
 * JD-Core Version:    0.7.0.1
 */