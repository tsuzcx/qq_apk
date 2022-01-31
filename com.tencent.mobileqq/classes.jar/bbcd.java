import com.tencent.mobileqq.transfile.ProtoReqManager;
import java.util.List;

public class bbcd
{
  public static bbcf a(bbax parambbax)
  {
    if ((parambbax != null) && (parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null) && (parambbax.jdField_a_of_type_Bbce != null) && (parambbax.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      if ("c2c_pic_up".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbal();
      }
      if ("grp_pic_up".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbap();
      }
      if ("grp_ptt_up".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbar();
      }
      if ("c2c_pic_dw".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbak();
      }
      if ("grp_pic_dw".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbao();
      }
      if ("c2c_ptt_up".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bban();
      }
      if ("c2c_ptt_dw".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbam();
      }
      if ("grp_ptt_dw".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbaq();
      }
      if ("short_video_dw".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbch();
      }
      if ("short_video_up".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbcj();
      }
      if ("multi_msg_dw".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbas();
      }
      if ("multi_msg_up".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbat();
      }
      if (("nearby_people_pic_up".equals(parambbax.jdField_a_of_type_JavaLangString)) || ("friend_avatar_up".equals(parambbax.jdField_a_of_type_JavaLangString))) {
        return new bbau();
      }
      if ("short_video_fw".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbci();
      }
      if ("bdh_common_up".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbai();
      }
      if ("pa_long_message".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbav();
      }
      if ("art_filter_up".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbah();
      }
      if ("share_pic_to_wx".equals(parambbax.jdField_a_of_type_JavaLangString)) {
        return new bbcg();
      }
    }
    return null;
  }
  
  public static void a(bbax parambbax)
  {
    bbcf localbbcf = a(parambbax);
    if (localbbcf != null) {
      localbbcf.a(parambbax);
    }
  }
  
  public static void a(bbax parambbax, bbbm parambbbm)
  {
    if ((parambbax != null) && (parambbax.jdField_a_of_type_Bbce != null))
    {
      parambbax.jdField_a_of_type_Bavq = null;
      parambbax.jdField_a_of_type_Bbce.a(parambbax, parambbbm);
      parambbax.jdField_a_of_type_Bbce = null;
      parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = null;
    }
  }
  
  public static void b(bbax parambbax)
  {
    if ((parambbax != null) && (parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.b(parambbax.jdField_a_of_type_Bavq);
      parambbax.jdField_a_of_type_Bbce = null;
      parambbax.jdField_a_of_type_Bavq = null;
      parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcd
 * JD-Core Version:    0.7.0.1
 */