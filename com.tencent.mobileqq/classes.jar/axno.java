import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.util.BinderWarpper;

class axno
  implements ServiceConnection
{
  axno(axnn paramaxnn) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    axnm.a("PTV.RichmediaClient", "onServiceConnected");
    this.a.b = new Messenger(paramIBinder);
    paramComponentName = Message.obtain(null, 1);
    paramComponentName.replyTo = this.a.jdField_a_of_type_AndroidOsMessenger;
    paramIBinder = new BinderWarpper(this.a.jdField_a_of_type_Axnj.asBinder());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ICallBack_BinderWrapper", paramIBinder);
    paramComponentName.setData(localBundle);
    try
    {
      this.a.b.send(paramComponentName);
      return;
    }
    catch (RemoteException paramComponentName)
    {
      axnm.b("PTV.RichmediaClient", "MSG_C2S_REGISTER_CLIENT send failed. e = " + paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axno
 * JD-Core Version:    0.7.0.1
 */