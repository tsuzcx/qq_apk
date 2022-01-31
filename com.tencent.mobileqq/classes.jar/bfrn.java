import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.widget.ExpandableListConnector.GroupMetadata;

public final class bfrn
  implements Parcelable.Creator<ExpandableListConnector.GroupMetadata>
{
  public ExpandableListConnector.GroupMetadata a(Parcel paramParcel)
  {
    return ExpandableListConnector.GroupMetadata.a(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readLong());
  }
  
  public ExpandableListConnector.GroupMetadata[] a(int paramInt)
  {
    return new ExpandableListConnector.GroupMetadata[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfrn
 * JD-Core Version:    0.7.0.1
 */