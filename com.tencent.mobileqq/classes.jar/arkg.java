import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;

public final class arkg
  implements Parcelable.Creator<NewTogetherRoomMessageData>
{
  public NewTogetherRoomMessageData a(Parcel paramParcel)
  {
    return new NewTogetherRoomMessageData(paramParcel);
  }
  
  public NewTogetherRoomMessageData[] a(int paramInt)
  {
    return new NewTogetherRoomMessageData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arkg
 * JD-Core Version:    0.7.0.1
 */