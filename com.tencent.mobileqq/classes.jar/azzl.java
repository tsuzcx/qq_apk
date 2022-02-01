import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.Quest;

public class azzl
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public long f;
  public long g;
  
  public azzl()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static azzl a(oidb_0xec4.Quest paramQuest, long paramLong)
  {
    boolean bool2 = false;
    try
    {
      azzl localazzl = new azzl();
      localazzl.jdField_a_of_type_JavaLangString = paramQuest.str_id.get();
      localazzl.jdField_b_of_type_JavaLangString = paramQuest.str_quest.get();
      localazzl.jdField_a_of_type_Long = paramQuest.uint64_quest_uin.get();
      localazzl.jdField_b_of_type_Long = paramQuest.uint64_time.get();
      localazzl.jdField_c_of_type_Long = paramLong;
      if (paramQuest.uint64_show_type.get() == 1L) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localazzl.jdField_a_of_type_Boolean = bool1;
        localazzl.jdField_c_of_type_JavaLangString = paramQuest.str_ans.get();
        localazzl.jdField_d_of_type_Long = paramQuest.uint64_ans_time.get();
        localazzl.jdField_d_of_type_JavaLangString = paramQuest.str_like_key.get();
        bool1 = bool2;
        if (paramQuest.uint64_been_praised.get() == 1L) {
          bool1 = true;
        }
        localazzl.jdField_b_of_type_Boolean = bool1;
        localazzl.e = paramQuest.uint64_praise_num.get();
        localazzl.f = paramQuest.uint64_comment_num.get();
        localazzl.g = paramQuest.uint64_show_times.get();
        return localazzl;
      }
      return null;
    }
    catch (Exception paramQuest)
    {
      QLog.e("AnonymousQuestion", 1, "convertQuest fail.", paramQuest);
    }
  }
  
  public String toString()
  {
    return "AnonymousQuestion{mId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mQuestUin='" + this.jdField_a_of_type_Long + '\'' + ", mQuestTime='" + this.jdField_b_of_type_Long + '\'' + ", mOwnerUin='" + this.jdField_c_of_type_Long + '\'' + ", mPrivate='" + this.jdField_a_of_type_Boolean + '\'' + ", mAnswer='" + this.jdField_c_of_type_JavaLangString + '\'' + ", mAnswerTime='" + this.jdField_d_of_type_Long + '\'' + ", mPraiseKey='" + this.jdField_d_of_type_JavaLangString + '\'' + ", mPraised='" + this.jdField_b_of_type_Boolean + '\'' + ", mTotalPraiseCount='" + this.e + '\'' + ", mTotalCommentCount='" + this.f + '\'' + ", mTotalViewCount='" + this.g + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzl
 * JD-Core Version:    0.7.0.1
 */