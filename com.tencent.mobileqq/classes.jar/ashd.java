import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;

public final class ashd
  implements Parcelable.Creator<GameCenterSessionInfo>
{
  public GameCenterSessionInfo a(Parcel paramParcel)
  {
    GameCenterSessionInfo localGameCenterSessionInfo = new GameCenterSessionInfo();
    localGameCenterSessionInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.e = paramParcel.readString();
    localGameCenterSessionInfo.f = paramParcel.readString();
    localGameCenterSessionInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localGameCenterSessionInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.g = paramParcel.readString();
    localGameCenterSessionInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localGameCenterSessionInfo.jdField_c_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.jdField_d_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.h = paramParcel.readString();
    localGameCenterSessionInfo.i = paramParcel.readString();
    localGameCenterSessionInfo.j = paramParcel.readString();
    return localGameCenterSessionInfo;
  }
  
  public GameCenterSessionInfo[] a(int paramInt)
  {
    return new GameCenterSessionInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashd
 * JD-Core Version:    0.7.0.1
 */