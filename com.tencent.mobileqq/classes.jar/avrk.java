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

public class avrk
  extends Handler
{
  final WeakReference<RichmediaService> a;
  
  public avrk(Looper paramLooper, RichmediaService paramRichmediaService)
  {
    super(paramLooper);
    this.a = new WeakReference(paramRichmediaService);
  }
  
  public void handleMessage(Message paramMessage)
  {
    RichmediaService localRichmediaService = (RichmediaService)this.a.get();
    if (localRichmediaService == null) {}
    Bundle localBundle;
    label76:
    do
    {
      return;
      localBundle = paramMessage.getData();
      if (localBundle != null)
      {
        localBundle.setClassLoader(getClass().getClassLoader());
        localBundle.getInt("msg_sub_cmd");
      }
      switch (paramMessage.what)
      {
      default: 
        if ((localBundle == null) || (paramMessage.what < 200) || (paramMessage.what > 208)) {
          break label221;
        }
      }
    } while (!QQAppInterface.class.isInstance(RichmediaService.b(localRichmediaService)));
    long l = localBundle.getLong("vidoe_record_uniseq");
    int i = localBundle.getInt("video_segment_mode");
    Object localObject1 = (QQAppInterface)RichmediaService.c(localRichmediaService);
    Object localObject2 = awbc.a((QQAppInterface)localObject1).a(l, i);
    awbg localawbg = new awbg();
    switch (paramMessage.what)
    {
    case 205: 
    default: 
      super.handleMessage(paramMessage);
    }
    label221:
    while (((paramMessage.what == 250) || (paramMessage.what == 1)) && (QQAppInterface.class.isInstance(RichmediaService.d(localRichmediaService))))
    {
      for (;;)
      {
        switch (paramMessage.what)
        {
        default: 
          super.handleMessage(paramMessage);
          return;
          avrf.a("RichmediaService", "handleMessage MSG_C2S_REGISTER_CLIENT");
          localRichmediaService.b = paramMessage.replyTo;
          if (localBundle == null) {
            break label76;
          }
          localObject1 = (BinderWarpper)localBundle.getParcelable("ICallBack_BinderWrapper");
          if (localObject1 == null) {
            break label76;
          }
          localRichmediaService.a = avrd.a(((BinderWarpper)localObject1).a);
          localObject1 = new Bundle();
          localObject2 = aunl.a((QQAppInterface)RichmediaService.a(localRichmediaService));
          try
          {
            ((Bundle)localObject1).putIntArray("key_compress_config", (int[])localObject2);
            localRichmediaService.a.a(6, (Bundle)localObject1);
          }
          catch (RemoteException localRemoteException)
          {
            avrf.a("RichmediaService", "ICALLBACK_CMD_INIT_COMPRESS_CONFIG remote error:" + localRemoteException);
            localRemoteException.printStackTrace();
          }
        }
      }
      break label76;
      avrf.a("RichmediaService", "handleMessage MSG_C2S_UNREGISTER_CLIENT");
      localRichmediaService.b = null;
      localRichmediaService.a = null;
      break label76;
      localawbg.jdField_a_of_type_JavaLangString = localBundle.getString("video_slice_path");
      localawbg.d = localBundle.getInt("video_slice_index");
      localawbg.jdField_a_of_type_Int = localBundle.getInt("video_slice_width");
      localawbg.jdField_b_of_type_Int = localBundle.getInt("video_slice_height");
      localawbg.jdField_c_of_type_Long = localBundle.getLong("video_slice_timestamp");
      localawbg.jdField_c_of_type_Int = 1;
      ((awbh)localObject2).a(localawbg, localBundle);
      continue;
      localawbg.jdField_c_of_type_Int = 3;
      ((awbh)localObject2).a(localawbg, localBundle);
      continue;
      localawbg.jdField_c_of_type_Int = 4;
      ((awbh)localObject2).a(localawbg, localBundle);
      continue;
      localawbg.jdField_c_of_type_Int = 5;
      localawbg.jdField_a_of_type_Int = localBundle.getInt("video_slice_width");
      localawbg.jdField_b_of_type_Int = localBundle.getInt("video_slice_height");
      localawbg.e = ((int)localBundle.getLong("video_duration"));
      ((awbh)localObject2).a(localawbg, localBundle);
      continue;
      ((awbh)localObject2).jdField_b_of_type_Int = ((int)localBundle.getLong("video_duration"));
      ((awbh)localObject2).jdField_b_of_type_Long = localBundle.getLong("video_start_time");
      ((awbh)localObject2).a();
      continue;
      ((awbh)localObject2).b();
      awbc.a(localRemoteException).a((awbh)localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.i("RichmediaService", 2, "Call RichMediaService: " + paramMessage.what);
    }
    ThreadManager.getUIHandler().post(new RichmediaService.IncomingHandler.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avrk
 * JD-Core Version:    0.7.0.1
 */