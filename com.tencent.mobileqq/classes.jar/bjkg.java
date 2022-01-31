import NS_USER_ACTION_REPORT.ActionInfo;
import NS_USER_ACTION_REPORT.ItemInfo;
import java.util.ArrayList;

class bjkg
{
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ActionInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String b;
  
  public ItemInfo a()
  {
    ItemInfo localItemInfo = new ItemInfo();
    localItemInfo.item_id = this.jdField_a_of_type_JavaLangString;
    localItemInfo.action_infos = this.jdField_a_of_type_JavaUtilArrayList;
    localItemInfo.busi_info = this.b;
    return localItemInfo;
  }
  
  public bjkg a(ActionInfo paramActionInfo)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramActionInfo);
    return this;
  }
  
  public bjkg a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bjkg b(String paramString)
  {
    this.b = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjkg
 * JD-Core Version:    0.7.0.1
 */