import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.VideoInfo.VideoRemark;

public final class amet
  implements Parcelable.Creator
{
  public VideoInfo.VideoRemark a(Parcel paramParcel)
  {
    VideoInfo.VideoRemark localVideoRemark = new VideoInfo.VideoRemark();
    localVideoRemark.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localVideoRemark.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localVideoRemark.c = paramParcel.readString();
    localVideoRemark.jdField_a_of_type_Int = paramParcel.readInt();
    localVideoRemark.d = paramParcel.readString();
    localVideoRemark.jdField_b_of_type_Int = paramParcel.readInt();
    return localVideoRemark;
  }
  
  public VideoInfo.VideoRemark[] a(int paramInt)
  {
    return new VideoInfo.VideoRemark[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amet
 * JD-Core Version:    0.7.0.1
 */