import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo.SimpleMessage;

public final class avbv
  implements Parcelable.Creator<GameCenterSessionInfo>
{
  public GameCenterSessionInfo a(Parcel paramParcel)
  {
    GameCenterSessionInfo localGameCenterSessionInfo = new GameCenterSessionInfo();
    localGameCenterSessionInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.f = paramParcel.readString();
    localGameCenterSessionInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localGameCenterSessionInfo.jdField_c_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.g = paramParcel.readString();
    localGameCenterSessionInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localGameCenterSessionInfo.jdField_d_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.jdField_e_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.h = paramParcel.readString();
    localGameCenterSessionInfo.i = paramParcel.readString();
    localGameCenterSessionInfo.j = paramParcel.readString();
    localGameCenterSessionInfo.k = paramParcel.readString();
    paramParcel = paramParcel.readParcelableArray(GameCenterSessionInfo.SimpleMessage.class.getClassLoader());
    if (paramParcel != null)
    {
      localGameCenterSessionInfo.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage = new GameCenterSessionInfo.SimpleMessage[paramParcel.length];
      int i = 0;
      while (i < paramParcel.length)
      {
        localGameCenterSessionInfo.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage[i] = ((GameCenterSessionInfo.SimpleMessage)paramParcel[i]);
        i += 1;
      }
    }
    return localGameCenterSessionInfo;
  }
  
  public GameCenterSessionInfo[] a(int paramInt)
  {
    return new GameCenterSessionInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbv
 * JD-Core Version:    0.7.0.1
 */