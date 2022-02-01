import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.agent.datamodel.Friend;

public final class bjpy
  implements Parcelable.Creator<Friend>
{
  public Friend a(Parcel paramParcel)
  {
    Friend localFriend = new Friend();
    localFriend.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localFriend.b = paramParcel.readString();
    localFriend.c = paramParcel.readString();
    localFriend.d = paramParcel.readString();
    localFriend.jdField_a_of_type_Int = paramParcel.readInt();
    localFriend.e = paramParcel.readString();
    return localFriend;
  }
  
  public Friend[] a(int paramInt)
  {
    return new Friend[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpy
 * JD-Core Version:    0.7.0.1
 */