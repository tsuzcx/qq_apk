import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.PhotoParam;

public final class ance
  implements Parcelable.Creator
{
  public PhotoParam a(Parcel paramParcel)
  {
    boolean bool2 = true;
    PhotoParam localPhotoParam = new PhotoParam();
    localPhotoParam.jdField_a_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_b_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_c_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_d_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localPhotoParam.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localPhotoParam.jdField_a_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_b_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_c_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_d_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_e_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_c_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localPhotoParam.jdField_a_of_type_Boolean = bool1;
      localPhotoParam.jdField_f_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_g_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_d_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_e_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_f_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_g_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_h_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_h_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_a_of_type_JavaUtilMap = paramParcel.readHashMap(getClass().getClassLoader());
      localPhotoParam.jdField_i_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label438;
      }
      bool1 = true;
      label242:
      localPhotoParam.jdField_b_of_type_Boolean = bool1;
      localPhotoParam.jdField_i_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label443;
      }
      bool1 = true;
      label267:
      localPhotoParam.jdField_c_of_type_Boolean = bool1;
      localPhotoParam.jdField_j_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label448;
      }
      bool1 = true;
      label292:
      localPhotoParam.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label453;
      }
      bool1 = true;
      label308:
      localPhotoParam.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label458;
      }
      bool1 = true;
      label324:
      localPhotoParam.jdField_f_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label463;
      }
      bool1 = true;
      label340:
      localPhotoParam.jdField_g_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label468;
      }
      bool1 = true;
      label356:
      localPhotoParam.jdField_h_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label473;
      }
      bool1 = true;
      label372:
      localPhotoParam.jdField_i_of_type_Boolean = bool1;
      localPhotoParam.jdField_j_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_e_of_type_Long = paramParcel.readLong();
      localPhotoParam.k = paramParcel.readString();
      localPhotoParam.jdField_f_of_type_Long = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label478;
      }
    }
    label438:
    label443:
    label448:
    label453:
    label458:
    label463:
    label468:
    label473:
    label478:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPhotoParam.jdField_j_of_type_Boolean = bool1;
      return localPhotoParam;
      bool1 = false;
      break;
      bool1 = false;
      break label242;
      bool1 = false;
      break label267;
      bool1 = false;
      break label292;
      bool1 = false;
      break label308;
      bool1 = false;
      break label324;
      bool1 = false;
      break label340;
      bool1 = false;
      break label356;
      bool1 = false;
      break label372;
    }
  }
  
  public PhotoParam[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ance
 * JD-Core Version:    0.7.0.1
 */