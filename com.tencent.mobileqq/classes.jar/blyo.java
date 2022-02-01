import NS_USER_ACTION_REPORT.ActionInfo;
import NS_USER_ACTION_REPORT.ItemInfo;
import java.util.ArrayList;

public class blyo
{
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ActionInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String b = "";
  private String c;
  private String d = "";
  
  public ItemInfo a()
  {
    ItemInfo localItemInfo = new ItemInfo();
    localItemInfo.item_id = this.jdField_a_of_type_JavaLangString;
    localItemInfo.action_infos = this.jdField_a_of_type_JavaUtilArrayList;
    localItemInfo.busi_info = this.c;
    localItemInfo.module_id = this.d;
    localItemInfo.item_type = this.b;
    return localItemInfo;
  }
  
  public blyo a(ActionInfo paramActionInfo)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramActionInfo);
    return this;
  }
  
  public blyo a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public blyo b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public blyo c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public blyo d(String paramString)
  {
    this.d = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyo
 * JD-Core Version:    0.7.0.1
 */