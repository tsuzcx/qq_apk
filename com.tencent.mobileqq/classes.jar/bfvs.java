import NS_USER_ACTION_REPORT.ItemInfo;
import NS_USER_ACTION_REPORT.PageInfo;
import NS_USER_ACTION_REPORT.TraceInfo;
import NS_USER_ACTION_REPORT.UserActionReport;
import java.util.ArrayList;

class bfvs
{
  private bfvp jdField_a_of_type_Bfvp;
  private ArrayList<ItemInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public UserActionReport a()
  {
    UserActionReport localUserActionReport = new UserActionReport();
    Object localObject = new PageInfo();
    ((PageInfo)localObject).appid = this.jdField_a_of_type_Bfvp.c;
    ((PageInfo)localObject).page_id = this.jdField_a_of_type_Bfvp.d;
    ((PageInfo)localObject).item_infos = this.jdField_a_of_type_JavaUtilArrayList;
    localUserActionReport.page_info = ((PageInfo)localObject);
    localObject = new TraceInfo();
    ((TraceInfo)localObject).trace_id = this.jdField_a_of_type_Bfvp.jdField_a_of_type_JavaLangString;
    ((TraceInfo)localObject).trace_num = this.jdField_a_of_type_Bfvp.jdField_a_of_type_Int;
    ((TraceInfo)localObject).trace_detail = this.jdField_a_of_type_Bfvp.a();
    localUserActionReport.trace_info = ((TraceInfo)localObject);
    return localUserActionReport;
  }
  
  public bfvs a(ItemInfo paramItemInfo)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramItemInfo);
    return this;
  }
  
  public bfvs a(bfvp parambfvp)
  {
    this.jdField_a_of_type_Bfvp = parambfvp;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfvs
 * JD-Core Version:    0.7.0.1
 */