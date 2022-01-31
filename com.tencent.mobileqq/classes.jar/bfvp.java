import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qidian.proto.mobileqq_qidian.ConfigGroupInfo;
import com.tencent.qidian.proto.mobileqq_qidian.ConfigInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bfvp
{
  public List<bfvq> a;
  
  public bfvp() {}
  
  public bfvp(mobileqq_qidian.ConfigGroupInfo paramConfigGroupInfo)
  {
    if (paramConfigGroupInfo.rpt_msg_config_info.has())
    {
      paramConfigGroupInfo = paramConfigGroupInfo.rpt_msg_config_info.get();
      this.a = new ArrayList(paramConfigGroupInfo.size());
      paramConfigGroupInfo = paramConfigGroupInfo.iterator();
      while (paramConfigGroupInfo.hasNext())
      {
        mobileqq_qidian.ConfigInfo localConfigInfo = (mobileqq_qidian.ConfigInfo)paramConfigGroupInfo.next();
        this.a.add(new bfvq(localConfigInfo));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfvp
 * JD-Core Version:    0.7.0.1
 */