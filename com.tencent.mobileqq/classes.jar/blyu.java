import NS_USER_ACTION_REPORT.ItemInfo;
import NS_USER_ACTION_REPORT.PageInfo;
import NS_USER_ACTION_REPORT.TraceInfo;
import NS_USER_ACTION_REPORT.UserActionReport;
import java.util.ArrayList;

class blyu
{
  private blyq jdField_a_of_type_Blyq;
  private ArrayList<ItemInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public UserActionReport a()
  {
    UserActionReport localUserActionReport = new UserActionReport();
    Object localObject = new PageInfo();
    ((PageInfo)localObject).appid = this.jdField_a_of_type_Blyq.c;
    ((PageInfo)localObject).page_id = this.jdField_a_of_type_Blyq.d;
    ((PageInfo)localObject).item_infos = this.jdField_a_of_type_JavaUtilArrayList;
    localUserActionReport.page_info = ((PageInfo)localObject);
    localObject = new TraceInfo();
    ((TraceInfo)localObject).trace_id = this.jdField_a_of_type_Blyq.jdField_a_of_type_JavaLangString;
    ((TraceInfo)localObject).trace_num = this.jdField_a_of_type_Blyq.jdField_a_of_type_Int;
    ((TraceInfo)localObject).trace_detail = this.jdField_a_of_type_Blyq.a();
    localUserActionReport.trace_info = ((TraceInfo)localObject);
    return localUserActionReport;
  }
  
  public blyu a(ItemInfo paramItemInfo)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramItemInfo);
    return this;
  }
  
  public blyu a(blyq paramblyq)
  {
    this.jdField_a_of_type_Blyq = paramblyq;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyu
 * JD-Core Version:    0.7.0.1
 */