import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_PAIR.sweet_pair_check_req;
import android.content.Intent;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneExternalRequest;

class blav
  extends QzoneExternalRequest
{
  blav(blau paramblau, Intent paramIntent) {}
  
  public String getCmdString()
  {
    return "SweetQzoneService.getPairState";
  }
  
  public JceStruct getReq()
  {
    sweet_pair_check_req localsweet_pair_check_req = new sweet_pair_check_req();
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      long l = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("currentUin", -1L);
      sweet_req_comm localsweet_req_comm = new sweet_req_comm();
      localsweet_req_comm.opuin = l;
      localsweet_req_comm.uin = l;
      localsweet_req_comm.loveuin = 0L;
      localsweet_req_comm.qua = QUA.getQUA3();
      localsweet_req_comm.pf = 1;
      localsweet_req_comm.src = 3;
      localsweet_pair_check_req.req_comm = localsweet_req_comm;
    }
    return localsweet_pair_check_req;
  }
  
  public String uniKey()
  {
    return "getPairState";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blav
 * JD-Core Version:    0.7.0.1
 */