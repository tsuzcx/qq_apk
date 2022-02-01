import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.richmedia.RichmediaService.IncomingHandler.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class azzn
  extends Handler
{
  final WeakReference<RichmediaService> a;
  
  public azzn(Looper paramLooper, RichmediaService paramRichmediaService)
  {
    super(paramLooper);
    this.a = new WeakReference(paramRichmediaService);
  }
  
  void a(QQAppInterface paramQQAppInterface, Message paramMessage, Bundle paramBundle)
  {
    long l = paramBundle.getLong("vidoe_record_uniseq");
    int i = paramBundle.getInt("video_segment_mode");
    baie localbaie = bahz.a(paramQQAppInterface).a(l, i);
    baid localbaid = new baid();
    switch (paramMessage.what)
    {
    case 205: 
    default: 
      super.handleMessage(paramMessage);
    case 204: 
    case 206: 
      return;
    case 200: 
      localbaid.jdField_a_of_type_JavaLangString = paramBundle.getString("video_slice_path");
      localbaid.d = paramBundle.getInt("video_slice_index");
      localbaid.jdField_a_of_type_Int = paramBundle.getInt("video_slice_width");
      localbaid.jdField_b_of_type_Int = paramBundle.getInt("video_slice_height");
      localbaid.jdField_c_of_type_Long = paramBundle.getLong("video_slice_timestamp");
      localbaid.jdField_c_of_type_Int = 1;
      localbaie.a(localbaid, paramBundle);
      return;
    case 201: 
      localbaid.jdField_c_of_type_Int = 3;
      localbaie.a(localbaid, paramBundle);
      return;
    case 202: 
      localbaid.jdField_c_of_type_Int = 4;
      localbaie.a(localbaid, paramBundle);
      return;
    case 203: 
      localbaid.jdField_c_of_type_Int = 5;
      localbaid.jdField_a_of_type_Int = paramBundle.getInt("video_slice_width");
      localbaid.jdField_b_of_type_Int = paramBundle.getInt("video_slice_height");
      localbaid.e = ((int)paramBundle.getLong("video_duration"));
      localbaie.a(localbaid, paramBundle);
      return;
    case 207: 
      localbaie.jdField_b_of_type_Int = ((int)paramBundle.getLong("video_duration"));
      localbaie.jdField_b_of_type_Long = paramBundle.getLong("video_start_time");
      localbaie.a();
      return;
    }
    localbaie.b();
    bahz.a(paramQQAppInterface).a(localbaie);
  }
  
  public void handleMessage(Message paramMessage)
  {
    RichmediaService localRichmediaService = (RichmediaService)this.a.get();
    if (localRichmediaService == null) {
      return;
    }
    Bundle localBundle = paramMessage.getData();
    if (localBundle != null)
    {
      localBundle.setClassLoader(getClass().getClassLoader());
      localBundle.getInt("msg_sub_cmd");
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      if ((localBundle != null) && (paramMessage.what >= 200) && (paramMessage.what <= 208))
      {
        if (!QQAppInterface.class.isInstance(RichmediaService.b(localRichmediaService))) {
          break;
        }
        a((QQAppInterface)RichmediaService.c(localRichmediaService), paramMessage, localBundle);
      }
      if (((paramMessage.what != 250) && (paramMessage.what != 1)) || (!QQAppInterface.class.isInstance(RichmediaService.d(localRichmediaService)))) {
        break;
      }
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
        return;
        azzi.a("RichmediaService", "handleMessage MSG_C2S_REGISTER_CLIENT");
        localRichmediaService.b = paramMessage.replyTo;
        if (localBundle != null)
        {
          Object localObject = (BinderWarpper)localBundle.getParcelable("ICallBack_BinderWrapper");
          if (localObject != null)
          {
            localRichmediaService.a = azzg.a(((BinderWarpper)localObject).a);
            localObject = new Bundle();
            int[] arrayOfInt = aydj.a((QQAppInterface)RichmediaService.a(localRichmediaService));
            try
            {
              ((Bundle)localObject).putIntArray("key_compress_config", arrayOfInt);
              localRichmediaService.a.a(6, (Bundle)localObject);
            }
            catch (RemoteException localRemoteException)
            {
              azzi.a("RichmediaService", "ICALLBACK_CMD_INIT_COMPRESS_CONFIG remote error:" + localRemoteException);
              localRemoteException.printStackTrace();
            }
            continue;
            azzi.a("RichmediaService", "handleMessage MSG_C2S_UNREGISTER_CLIENT");
            localRichmediaService.b = null;
            localRichmediaService.a = null;
          }
        }
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("RichmediaService", 2, "Call RichMediaService: " + paramMessage.what);
    }
    ThreadManager.getUIHandler().post(new RichmediaService.IncomingHandler.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzn
 * JD-Core Version:    0.7.0.1
 */