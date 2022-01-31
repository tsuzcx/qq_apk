import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

public final class bghd
  implements Parcelable.Creator<QzoneVerticalVideoTopicInfo>
{
  public QzoneVerticalVideoTopicInfo a(Parcel paramParcel)
  {
    QzoneVerticalVideoTopicInfo localQzoneVerticalVideoTopicInfo = new QzoneVerticalVideoTopicInfo();
    QzoneVerticalVideoTopicInfo.a(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.b(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.c(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.d(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.e(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.f(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.g(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.h(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    return localQzoneVerticalVideoTopicInfo;
  }
  
  public QzoneVerticalVideoTopicInfo[] a(int paramInt)
  {
    return new QzoneVerticalVideoTopicInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bghd
 * JD-Core Version:    0.7.0.1
 */