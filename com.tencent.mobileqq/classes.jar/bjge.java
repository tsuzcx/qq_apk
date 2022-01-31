import NS_USER_ACTION_REPORT.ItemInfo;
import NS_USER_ACTION_REPORT.PageInfo;
import NS_USER_ACTION_REPORT.TraceInfo;
import NS_USER_ACTION_REPORT.UserActionReport;
import java.util.ArrayList;

class bjge
{
  private bjgb jdField_a_of_type_Bjgb;
  private ArrayList<ItemInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public UserActionReport a()
  {
    UserActionReport localUserActionReport = new UserActionReport();
    Object localObject = new PageInfo();
    ((PageInfo)localObject).appid = this.jdField_a_of_type_Bjgb.c;
    ((PageInfo)localObject).page_id = this.jdField_a_of_type_Bjgb.d;
    ((PageInfo)localObject).item_infos = this.jdField_a_of_type_JavaUtilArrayList;
    localUserActionReport.page_info = ((PageInfo)localObject);
    localObject = new TraceInfo();
    ((TraceInfo)localObject).trace_id = this.jdField_a_of_type_Bjgb.jdField_a_of_type_JavaLangString;
    ((TraceInfo)localObject).trace_num = this.jdField_a_of_type_Bjgb.jdField_a_of_type_Int;
    ((TraceInfo)localObject).trace_detail = this.jdField_a_of_type_Bjgb.a();
    localUserActionReport.trace_info = ((TraceInfo)localObject);
    return localUserActionReport;
  }
  
  public bjge a(ItemInfo paramItemInfo)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramItemInfo);
    return this;
  }
  
  public bjge a(bjgb parambjgb)
  {
    this.jdField_a_of_type_Bjgb = parambjgb;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjge
 * JD-Core Version:    0.7.0.1
 */