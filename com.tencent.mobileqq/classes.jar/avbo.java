import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;

class avbo
  implements avbm
{
  private IBinder a;
  
  avbo(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public Message a(Message paramMessage)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
        if (paramMessage != null)
        {
          localParcel1.writeInt(1);
          paramMessage.writeToParcel(localParcel1, 0);
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramMessage = (Message)Message.CREATOR.createFromParcel(localParcel2);
            return paramMessage;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramMessage = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public BasicTypeDataParcel a(BasicTypeDataParcel paramBasicTypeDataParcel)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
        if (paramBasicTypeDataParcel != null)
        {
          localParcel1.writeInt(1);
          paramBasicTypeDataParcel.writeToParcel(localParcel1, 0);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramBasicTypeDataParcel = (BasicTypeDataParcel)BasicTypeDataParcel.CREATOR.createFromParcel(localParcel2);
            return paramBasicTypeDataParcel;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramBasicTypeDataParcel = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avbo
 * JD-Core Version:    0.7.0.1
 */