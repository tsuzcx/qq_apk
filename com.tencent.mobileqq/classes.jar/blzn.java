import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.QCirclePublishPictureTagInfo;
import java.util.HashMap;

public final class blzn
  implements Parcelable.Creator<QCirclePublishPictureTagInfo>
{
  public QCirclePublishPictureTagInfo a(Parcel paramParcel)
  {
    QCirclePublishPictureTagInfo localQCirclePublishPictureTagInfo = new QCirclePublishPictureTagInfo();
    localQCirclePublishPictureTagInfo.picId = paramParcel.readString();
    localQCirclePublishPictureTagInfo.picTags = paramParcel.readArrayList(String.class.getClassLoader());
    localQCirclePublishPictureTagInfo.materialId = paramParcel.readString();
    localQCirclePublishPictureTagInfo.filterId = paramParcel.readString();
    localQCirclePublishPictureTagInfo.exif = ((HashMap)paramParcel.readSerializable());
    return localQCirclePublishPictureTagInfo;
  }
  
  public QCirclePublishPictureTagInfo[] a(int paramInt)
  {
    return new QCirclePublishPictureTagInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzn
 * JD-Core Version:    0.7.0.1
 */