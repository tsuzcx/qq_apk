import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;

public final class avcq
  implements Parcelable.Creator<Comments.Comment>
{
  public Comments.Comment a(Parcel paramParcel)
  {
    return new Comments.Comment(paramParcel);
  }
  
  public Comments.Comment[] a(int paramInt)
  {
    return new Comments.Comment[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avcq
 * JD-Core Version:    0.7.0.1
 */