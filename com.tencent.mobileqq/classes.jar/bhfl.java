import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.PictureUrl;

public final class bhfl
  implements Parcelable.Creator<PictureUrl>
{
  public PictureUrl a(Parcel paramParcel)
  {
    PictureUrl localPictureUrl = new PictureUrl();
    localPictureUrl.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localPictureUrl.jdField_a_of_type_Int = paramParcel.readInt();
    localPictureUrl.jdField_b_of_type_Int = paramParcel.readInt();
    localPictureUrl.c = paramParcel.readInt();
    localPictureUrl.jdField_a_of_type_Float = paramParcel.readFloat();
    localPictureUrl.jdField_b_of_type_Float = paramParcel.readFloat();
    localPictureUrl.d = paramParcel.readInt();
    return localPictureUrl;
  }
  
  public PictureUrl[] a(int paramInt)
  {
    return new PictureUrl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhfl
 * JD-Core Version:    0.7.0.1
 */