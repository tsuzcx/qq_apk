import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;

public final class aqmi
  implements Parcelable.Creator<GalleryBaseData>
{
  public GalleryBaseData a(Parcel paramParcel)
  {
    Object localObject = paramParcel.readString();
    try
    {
      localObject = GalleryBaseData.a((String)localObject);
      ((GalleryBaseData)localObject).a(paramParcel);
      return localObject;
    }
    catch (ClassNotFoundException paramParcel)
    {
      throw new RuntimeException(paramParcel);
    }
  }
  
  public GalleryBaseData[] a(int paramInt)
  {
    return new GalleryBaseData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqmi
 * JD-Core Version:    0.7.0.1
 */