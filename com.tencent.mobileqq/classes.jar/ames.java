import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoInfo.VideoRemark;
import cooperation.qzone.model.VideoUrl;

public final class ames
  implements Parcelable.Creator
{
  public VideoInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localVideoInfo.jdField_a_of_type_CooperationQzoneModelVideoUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_a_of_type_CooperationQzoneModelPictureUrl = ((PictureUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_b_of_type_CooperationQzoneModelPictureUrl = ((PictureUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_c_of_type_CooperationQzoneModelPictureUrl = ((PictureUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_d_of_type_CooperationQzoneModelPictureUrl = ((PictureUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localVideoInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localVideoInfo.jdField_b_of_type_CooperationQzoneModelVideoUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_c_of_type_CooperationQzoneModelVideoUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_d_of_type_CooperationQzoneModelVideoUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_e_of_type_CooperationQzoneModelVideoUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localVideoInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localVideoInfo.jdField_c_of_type_Int = paramParcel.readInt();
    localVideoInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localVideoInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localVideoInfo.jdField_a_of_type_Byte = paramParcel.readByte();
    localVideoInfo.jdField_d_of_type_Int = paramParcel.readInt();
    localVideoInfo.jdField_e_of_type_Int = paramParcel.readInt();
    localVideoInfo.jdField_c_of_type_Long = paramParcel.readLong();
    localVideoInfo.jdField_f_of_type_Int = paramParcel.readInt();
    localVideoInfo.jdField_g_of_type_Int = paramParcel.readInt();
    localVideoInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localVideoInfo.jdField_b_of_type_Boolean = bool1;
      localVideoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark = ((VideoInfo.VideoRemark)paramParcel.readParcelable(getClass().getClassLoader()));
      localVideoInfo.jdField_d_of_type_Long = paramParcel.readLong();
      localVideoInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label505;
      }
      bool1 = true;
      label380:
      localVideoInfo.jdField_i_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label510;
      }
      bool1 = true;
      label396:
      localVideoInfo.jdField_j_of_type_Boolean = bool1;
      localVideoInfo.h = paramParcel.readInt();
      localVideoInfo.jdField_g_of_type_JavaLangString = paramParcel.readString();
      localVideoInfo.jdField_i_of_type_Int = paramParcel.readInt();
      localVideoInfo.jdField_j_of_type_Int = paramParcel.readInt();
      localVideoInfo.jdField_k_of_type_Int = paramParcel.readInt();
      localVideoInfo.jdField_e_of_type_Long = paramParcel.readLong();
      localVideoInfo.jdField_l_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label515;
      }
      bool1 = true;
      label475:
      localVideoInfo.jdField_k_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label520;
      }
    }
    label515:
    label520:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localVideoInfo.jdField_l_of_type_Boolean = bool1;
      return localVideoInfo;
      bool1 = false;
      break;
      label505:
      bool1 = false;
      break label380;
      label510:
      bool1 = false;
      break label396;
      bool1 = false;
      break label475;
    }
  }
  
  public VideoInfo[] a(int paramInt)
  {
    return new VideoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ames
 * JD-Core Version:    0.7.0.1
 */