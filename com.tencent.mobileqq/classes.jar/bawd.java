import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public abstract class bawd<M extends bayq, V extends bbgz>
  extends baun<M, V>
{
  FTSEntitySearchDetailActivity jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity;
  private String jdField_a_of_type_JavaLangString;
  private List<bawh> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private List<FTSEntity> jdField_b_of_type_JavaUtilList;
  private int c;
  private int d;
  
  public bawd(ListView paramListView, FaceDecoder paramFaceDecoder, List<FTSEntity> paramList, String paramString, FTSEntitySearchDetailActivity paramFTSEntitySearchDetailActivity)
  {
    super(paramListView, paramFaceDecoder);
    this.jdField_b_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity = paramFTSEntitySearchDetailActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void b()
  {
    if ((this.d - this.c == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Int == 0)) {
      a();
    }
  }
  
  public void a()
  {
    ArrayList localArrayList = bgbo.a(this.jdField_a_of_type_JavaLangString);
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i;
    if (j + 50 < this.jdField_b_of_type_JavaUtilList.size()) {
      i = j + 50;
    }
    while (j < i)
    {
      bawh localbawh = bawj.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, localArrayList, (FTSEntity)this.jdField_b_of_type_JavaUtilList.get(j));
      if (localbawh != null) {
        this.jdField_a_of_type_JavaUtilList.add(localbawh);
      }
      j += 1;
      continue;
      i = this.jdField_b_of_type_JavaUtilList.size();
    }
    a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.d = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawd
 * JD-Core Version:    0.7.0.1
 */