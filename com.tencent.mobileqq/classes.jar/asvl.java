import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.music.SongInfo;

public abstract class asvl
  extends Binder
  implements asvk
{
  private static final String DESCRIPTOR = "com.tencent.mobileqq.music.IQQPlayerCallback";
  static final int TRANSACTION_onPlaySongChanged = 2;
  static final int TRANSACTION_onPlayStateChanged = 1;
  
  public asvl()
  {
    attachInterface(this, "com.tencent.mobileqq.music.IQQPlayerCallback");
  }
  
  public static asvk asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.music.IQQPlayerCallback");
    if ((localIInterface != null) && ((localIInterface instanceof asvk))) {
      return (asvk)localIInterface;
    }
    return new asvm(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mobileqq.music.IQQPlayerCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerCallback");
      onPlayStateChanged(paramParcel1.readInt());
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerCallback");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (SongInfo)SongInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      onPlaySongChanged(paramParcel1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asvl
 * JD-Core Version:    0.7.0.1
 */