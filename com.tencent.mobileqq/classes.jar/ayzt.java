import com.tencent.mobileqq.transfile.ProtoReqManager;
import java.util.List;

public class ayzt
{
  public static ayzv a(ayyn paramayyn)
  {
    if ((paramayyn != null) && (paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null) && (paramayyn.jdField_a_of_type_Ayzu != null) && (paramayyn.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      if ("c2c_pic_up".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayyb();
      }
      if ("grp_pic_up".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayyf();
      }
      if ("grp_ptt_up".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayyh();
      }
      if ("c2c_pic_dw".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayya();
      }
      if ("grp_pic_dw".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayye();
      }
      if ("c2c_ptt_up".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayyd();
      }
      if ("c2c_ptt_dw".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayyc();
      }
      if ("grp_ptt_dw".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayyg();
      }
      if ("short_video_dw".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayzx();
      }
      if ("short_video_up".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayzz();
      }
      if ("multi_msg_dw".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayyi();
      }
      if ("multi_msg_up".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayyj();
      }
      if (("nearby_people_pic_up".equals(paramayyn.jdField_a_of_type_JavaLangString)) || ("friend_avatar_up".equals(paramayyn.jdField_a_of_type_JavaLangString))) {
        return new ayyk();
      }
      if ("short_video_fw".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayzy();
      }
      if ("bdh_common_up".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayxy();
      }
      if ("pa_long_message".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayyl();
      }
      if ("art_filter_up".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayxx();
      }
      if ("share_pic_to_wx".equals(paramayyn.jdField_a_of_type_JavaLangString)) {
        return new ayzw();
      }
    }
    return null;
  }
  
  public static void a(ayyn paramayyn)
  {
    ayzv localayzv = a(paramayyn);
    if (localayzv != null) {
      localayzv.a(paramayyn);
    }
  }
  
  public static void a(ayyn paramayyn, ayzc paramayzc)
  {
    if ((paramayyn != null) && (paramayyn.jdField_a_of_type_Ayzu != null))
    {
      paramayyn.jdField_a_of_type_Ayti = null;
      paramayyn.jdField_a_of_type_Ayzu.a(paramayyn, paramayzc);
      paramayyn.jdField_a_of_type_Ayzu = null;
      paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = null;
    }
  }
  
  public static void b(ayyn paramayyn)
  {
    if ((paramayyn != null) && (paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.b(paramayyn.jdField_a_of_type_Ayti);
      paramayyn.jdField_a_of_type_Ayzu = null;
      paramayyn.jdField_a_of_type_Ayti = null;
      paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayzt
 * JD-Core Version:    0.7.0.1
 */