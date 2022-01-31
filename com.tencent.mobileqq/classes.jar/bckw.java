import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xce5.Oidb_0xce5.RobotInfo;

public class bckw
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  
  public static bckw a(Oidb_0xce5.RobotInfo paramRobotInfo)
  {
    if (paramRobotInfo != null)
    {
      bckw localbckw = new bckw();
      localbckw.jdField_a_of_type_Long = paramRobotInfo.robot_uin.get();
      localbckw.jdField_a_of_type_JavaLangString = paramRobotInfo.name.get();
      localbckw.jdField_a_of_type_Int = paramRobotInfo.status.get();
      localbckw.jdField_b_of_type_JavaLangString = paramRobotInfo.desc.get();
      localbckw.jdField_b_of_type_Int = paramRobotInfo.enabled_groups.get();
      localbckw.jdField_c_of_type_JavaLangString = paramRobotInfo.welcome_msg.get();
      localbckw.jdField_d_of_type_JavaLangString = paramRobotInfo.call_name.get();
      localbckw.jdField_c_of_type_Int = paramRobotInfo.show_invite.get();
      localbckw.jdField_d_of_type_Int = paramRobotInfo.offline.get();
      localbckw.e = paramRobotInfo.verify.get();
      return localbckw;
    }
    return null;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Int == 1;
  }
  
  public String toString()
  {
    return "robot_uin:" + this.jdField_a_of_type_Long + " name:" + this.jdField_a_of_type_JavaLangString + " status:" + this.jdField_a_of_type_Int + " desc:" + this.jdField_b_of_type_JavaLangString + " enabled_groups:" + this.jdField_b_of_type_Int + " welcome_msg:" + this.jdField_c_of_type_JavaLangString + " call_name:" + this.jdField_d_of_type_JavaLangString + " show_invite:" + this.jdField_c_of_type_Int + " offline:" + this.jdField_d_of_type_Int + " verify:" + this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckw
 * JD-Core Version:    0.7.0.1
 */