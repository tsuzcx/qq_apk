import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.manager.EngineChannel;

public final class bdof
  implements Parcelable.Creator<EngineChannel>
{
  public EngineChannel a(Parcel paramParcel)
  {
    EngineChannel localEngineChannel = new EngineChannel((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel), null);
    localEngineChannel.a(paramParcel.readString());
    return localEngineChannel;
  }
  
  public EngineChannel[] a(int paramInt)
  {
    return new EngineChannel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdof
 * JD-Core Version:    0.7.0.1
 */