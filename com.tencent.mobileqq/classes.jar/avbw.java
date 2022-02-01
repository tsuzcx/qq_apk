import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo.SimpleMessage;

public final class avbw
  implements Parcelable.Creator<GameCenterSessionInfo.SimpleMessage>
{
  public GameCenterSessionInfo.SimpleMessage a(Parcel paramParcel)
  {
    return new GameCenterSessionInfo.SimpleMessage(paramParcel);
  }
  
  public GameCenterSessionInfo.SimpleMessage[] a(int paramInt)
  {
    return new GameCenterSessionInfo.SimpleMessage[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbw
 * JD-Core Version:    0.7.0.1
 */