import com.tencent.mobileqq.transfile.ProtoReqManager;
import java.util.List;

public class bfca
{
  public static bfcc a(bfau parambfau)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null) && (parambfau.jdField_a_of_type_Bfcb != null) && (parambfau.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      if ("c2c_pic_up".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfag();
      }
      if ("grp_pic_up".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfak();
      }
      if ("grp_ptt_up".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfam();
      }
      if ("c2c_pic_dw".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfaf();
      }
      if ("grp_pic_dw".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfaj();
      }
      if ("c2c_ptt_up".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfai();
      }
      if ("c2c_ptt_dw".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfah();
      }
      if ("grp_ptt_dw".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfal();
      }
      if ("short_video_dw".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfce();
      }
      if ("short_video_up".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfcg();
      }
      if ("multi_msg_dw".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfan();
      }
      if ("multi_msg_up".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfao();
      }
      if (("nearby_people_pic_up".equals(parambfau.jdField_a_of_type_JavaLangString)) || ("friend_avatar_up".equals(parambfau.jdField_a_of_type_JavaLangString))) {
        return new bfap();
      }
      if ("short_video_fw".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfcf();
      }
      if ("bdh_common_up".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfad();
      }
      if ("pa_long_message".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfaq();
      }
      if ("art_filter_up".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfac();
      }
      if ("share_pic_to_wx".equals(parambfau.jdField_a_of_type_JavaLangString)) {
        return new bfcd();
      }
    }
    return null;
  }
  
  public static void a(bfau parambfau)
  {
    bfcc localbfcc = a(parambfau);
    if (localbfcc != null) {
      localbfcc.a(parambfau);
    }
  }
  
  public static void a(bfau parambfau, bfbj parambfbj)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_Bfcb != null))
    {
      parambfau.jdField_a_of_type_Bevx = null;
      parambfau.jdField_a_of_type_Bfcb.a(parambfau, parambfbj);
      parambfau.jdField_a_of_type_Bfcb = null;
      parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = null;
    }
  }
  
  public static void b(bfau parambfau)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.b(parambfau.jdField_a_of_type_Bevx);
      parambfau.jdField_a_of_type_Bfcb = null;
      parambfau.jdField_a_of_type_Bevx = null;
      parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfca
 * JD-Core Version:    0.7.0.1
 */