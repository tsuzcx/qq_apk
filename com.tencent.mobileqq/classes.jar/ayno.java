import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.List;
import pb.unify.search.UnifySearchUnite.TabItemGroup;
import pb.unite.search.UniteSearch.TabItemGroup;

public class ayno
{
  public String a;
  public List<Long> a;
  
  public ayno() {}
  
  public ayno(UnifySearchUnite.TabItemGroup paramTabItemGroup)
  {
    if (paramTabItemGroup == null) {
      throw new RuntimeException("group is null in GroupTabModel Constructor.");
    }
    this.jdField_a_of_type_JavaLangString = paramTabItemGroup.tab_name.get().toStringUtf8();
    this.jdField_a_of_type_JavaUtilList = paramTabItemGroup.rpt_group_mask.get();
  }
  
  public ayno(UniteSearch.TabItemGroup paramTabItemGroup)
  {
    if (paramTabItemGroup == null) {
      throw new RuntimeException("group is null in GroupTabModel Constructor.");
    }
    this.jdField_a_of_type_JavaLangString = paramTabItemGroup.tab_name.get().toStringUtf8();
    this.jdField_a_of_type_JavaUtilList = paramTabItemGroup.rpt_group_mask.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayno
 * JD-Core Version:    0.7.0.1
 */