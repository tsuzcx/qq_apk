import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.PhotoParam;

public final class bjlb
  implements Parcelable.Creator<PhotoParam>
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
    localPhotoParam.jdField_f_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_c_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localPhotoParam.jdField_a_of_type_Boolean = bool1;
      localPhotoParam.jdField_g_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_h_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_d_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_e_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_f_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_g_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_h_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_i_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_a_of_type_JavaUtilMap = paramParcel.readHashMap(getClass().getClassLoader());
      localPhotoParam.jdField_i_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label447;
      }
      bool1 = true;
      label251:
      localPhotoParam.jdField_b_of_type_Boolean = bool1;
      localPhotoParam.jdField_j_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label452;
      }
      bool1 = true;
      label276:
      localPhotoParam.jdField_c_of_type_Boolean = bool1;
      localPhotoParam.jdField_j_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label457;
      }
      bool1 = true;
      label301:
      localPhotoParam.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label462;
      }
      bool1 = true;
      label317:
      localPhotoParam.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label467;
      }
      bool1 = true;
      label333:
      localPhotoParam.jdField_f_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label472;
      }
      bool1 = true;
      label349:
      localPhotoParam.jdField_g_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label477;
      }
      bool1 = true;
      label365:
      localPhotoParam.jdField_h_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label482;
      }
      bool1 = true;
      label381:
      localPhotoParam.jdField_i_of_type_Boolean = bool1;
      localPhotoParam.jdField_k_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_e_of_type_Long = paramParcel.readLong();
      localPhotoParam.jdField_k_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_f_of_type_Long = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label487;
      }
    }
    label447:
    label452:
    label457:
    label462:
    label467:
    label472:
    label477:
    label482:
    label487:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPhotoParam.jdField_j_of_type_Boolean = bool1;
      return localPhotoParam;
      bool1 = false;
      break;
      bool1 = false;
      break label251;
      bool1 = false;
      break label276;
      bool1 = false;
      break label301;
      bool1 = false;
      break label317;
      bool1 = false;
      break label333;
      bool1 = false;
      break label349;
      bool1 = false;
      break label365;
      bool1 = false;
      break label381;
    }
  }
  
  public PhotoParam[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjlb
 * JD-Core Version:    0.7.0.1
 */