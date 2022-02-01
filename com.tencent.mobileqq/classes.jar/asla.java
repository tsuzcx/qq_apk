import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonWebBean;

public final class asla
  implements Parcelable.Creator<SearchEmoticonWebBean>
{
  public SearchEmoticonWebBean a(Parcel paramParcel)
  {
    return new SearchEmoticonWebBean(paramParcel);
  }
  
  public SearchEmoticonWebBean[] a(int paramInt)
  {
    return new SearchEmoticonWebBean[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asla
 * JD-Core Version:    0.7.0.1
 */