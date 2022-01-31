import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.ImageTagInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.VideoInfo;
import java.util.ArrayList;

public final class amus
  implements Parcelable.Creator
{
  public PhotoInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localPhotoInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localPhotoInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localPhotoInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localPhotoInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localPhotoInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
    localPhotoInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localPhotoInfo.jdField_d_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localPhotoInfo.jdField_a_of_type_Boolean = bool1;
      localPhotoInfo.jdField_g_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_h_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_i_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_j_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_a_of_type_JavaUtilMap = paramParcel.readHashMap(getClass().getClassLoader());
      localPhotoInfo.jdField_a_of_type_JavaUtilArrayList = paramParcel.readArrayList(getClass().getClassLoader());
      localPhotoInfo.jdField_e_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_f_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_g_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_h_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage = ((GpsInfo4LocalImage)paramParcel.readParcelable(getClass().getClassLoader()));
      if (paramParcel.readInt() != 1) {
        break label672;
      }
      bool1 = true;
      label232:
      localPhotoInfo.jdField_b_of_type_Boolean = bool1;
      localPhotoInfo.jdField_a_of_type_Long = paramParcel.readLong();
      localPhotoInfo.jdField_b_of_type_Long = paramParcel.readLong();
      localPhotoInfo.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      paramParcel.readTypedList(localPhotoInfo.jdField_b_of_type_JavaUtilArrayList, ImageTagInfo.CREATOR);
      if (paramParcel.readInt() != 1) {
        break label677;
      }
      bool1 = true;
      label290:
      localPhotoInfo.jdField_i_of_type_Boolean = bool1;
      localPhotoInfo.jdField_k_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_i_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_o_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_p_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_q_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo = ((VideoInfo)paramParcel.readParcelable(VideoInfo.class.getClassLoader()));
      localPhotoInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_r_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_s_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_k_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_c_of_type_Long = paramParcel.readLong();
      localPhotoInfo.jdField_t_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_l_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_m_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_n_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_u_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_o_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_p_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_b_of_type_JavaUtilMap = paramParcel.readHashMap(getClass().getClassLoader());
      if (paramParcel.readInt() != 1) {
        break label682;
      }
      bool1 = true;
      label492:
      localPhotoInfo.jdField_j_of_type_Boolean = bool1;
      localPhotoInfo.jdField_q_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_r_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_s_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_t_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_u_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_v_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_w_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label687;
      }
      bool1 = true;
      label571:
      localPhotoInfo.jdField_k_of_type_Boolean = bool1;
      localPhotoInfo.jdField_c_of_type_JavaUtilArrayList = ((ArrayList)paramParcel.readSerializable());
      if (paramParcel.readInt() != 1) {
        break label692;
      }
      bool1 = true;
      label599:
      localPhotoInfo.jdField_l_of_type_Boolean = bool1;
      localPhotoInfo.jdField_d_of_type_Long = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label697;
      }
      bool1 = true;
      label624:
      localPhotoInfo.jdField_m_of_type_Boolean = bool1;
      localPhotoInfo.jdField_v_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_w_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label702;
      }
    }
    label672:
    label677:
    label682:
    label687:
    label692:
    label697:
    label702:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPhotoInfo.jdField_n_of_type_Boolean = bool1;
      return localPhotoInfo;
      bool1 = false;
      break;
      bool1 = false;
      break label232;
      bool1 = false;
      break label290;
      bool1 = false;
      break label492;
      bool1 = false;
      break label571;
      bool1 = false;
      break label599;
      bool1 = false;
      break label624;
    }
  }
  
  public PhotoInfo[] a(int paramInt)
  {
    return new PhotoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amus
 * JD-Core Version:    0.7.0.1
 */