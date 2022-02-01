import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.emoticonview.EmotionPreviewInfo;

public final class asqa
  implements Parcelable.Creator<EmotionPreviewInfo>
{
  public EmotionPreviewInfo a(Parcel paramParcel)
  {
    return new EmotionPreviewInfo(paramParcel);
  }
  
  public EmotionPreviewInfo[] a(int paramInt)
  {
    return new EmotionPreviewInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqa
 * JD-Core Version:    0.7.0.1
 */