import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_COMM_SVR.sweet_comm_cfg_get_req;
import android.content.Intent;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

class biaa
  extends QzoneExternalRequest
{
  biaa(bhzz parambhzz, Intent paramIntent) {}
  
  public String getCmdString()
  {
    return "SweetQzoneService.GetCommCfg";
  }
  
  public JceStruct getReq()
  {
    sweet_comm_cfg_get_req localsweet_comm_cfg_get_req = new sweet_comm_cfg_get_req();
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(1));
    localsweet_comm_cfg_get_req.vec_cfg = ((ArrayList)localObject);
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      long l = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("currentUin", -1L);
      localObject = new sweet_req_comm();
      ((sweet_req_comm)localObject).opuin = l;
      ((sweet_req_comm)localObject).uin = l;
      ((sweet_req_comm)localObject).loveuin = 0L;
      ((sweet_req_comm)localObject).qua = bgyi.a();
      ((sweet_req_comm)localObject).pf = 1;
      ((sweet_req_comm)localObject).src = 3;
      localsweet_comm_cfg_get_req.req_comm = ((sweet_req_comm)localObject);
    }
    return localsweet_comm_cfg_get_req;
  }
  
  public String uniKey()
  {
    return "GetCommCfg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     biaa
 * JD-Core Version:    0.7.0.1
 */