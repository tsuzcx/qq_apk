import NS_USER_ACTION_REPORT.ItemInfo;
import NS_USER_ACTION_REPORT.PageInfo;
import NS_USER_ACTION_REPORT.TraceInfo;
import NS_USER_ACTION_REPORT.UserActionReport;
import java.util.ArrayList;

class bjkl
{
  private bjki jdField_a_of_type_Bjki;
  private ArrayList<ItemInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public UserActionReport a()
  {
    UserActionReport localUserActionReport = new UserActionReport();
    Object localObject = new PageInfo();
    ((PageInfo)localObject).appid = this.jdField_a_of_type_Bjki.c;
    ((PageInfo)localObject).page_id = this.jdField_a_of_type_Bjki.d;
    ((PageInfo)localObject).item_infos = this.jdField_a_of_type_JavaUtilArrayList;
    localUserActionReport.page_info = ((PageInfo)localObject);
    localObject = new TraceInfo();
    ((TraceInfo)localObject).trace_id = this.jdField_a_of_type_Bjki.jdField_a_of_type_JavaLangString;
    ((TraceInfo)localObject).trace_num = this.jdField_a_of_type_Bjki.jdField_a_of_type_Int;
    ((TraceInfo)localObject).trace_detail = this.jdField_a_of_type_Bjki.a();
    localUserActionReport.trace_info = ((TraceInfo)localObject);
    return localUserActionReport;
  }
  
  public bjkl a(ItemInfo paramItemInfo)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramItemInfo);
    return this;
  }
  
  public bjkl a(bjki parambjki)
  {
    this.jdField_a_of_type_Bjki = parambjki;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjkl
 * JD-Core Version:    0.7.0.1
 */