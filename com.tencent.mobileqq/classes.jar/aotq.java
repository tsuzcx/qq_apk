import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.transfile.ShortVideoPresendStats;
import com.tencent.mobileqq.transfile.ShortVideoUploadABTest;
import com.tencent.mobileqq.transfile.VideoSliceInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import dov.com.tencent.mobileqq.richmedia.ICallBack;
import dov.com.tencent.mobileqq.richmedia.ICallBack.Stub;
import dov.com.tencent.mobileqq.richmedia.LOG;
import dov.com.tencent.mobileqq.richmedia.RichmediaService;
import dov.com.tencent.mobileqq.richmedia.VideoSendTaskManager;
import java.lang.ref.WeakReference;

public class aotq
  extends Handler
{
  final WeakReference a;
  
  public aotq(Looper paramLooper, RichmediaService paramRichmediaService)
  {
    super(paramLooper);
    this.a = new WeakReference(paramRichmediaService);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    Object localObject1 = (RichmediaService)this.a.get();
    if (localObject1 == null) {
      return;
    }
    Bundle localBundle = paramMessage.getData();
    if (localBundle != null) {
      localBundle.setClassLoader(getClass().getClassLoader());
    }
    for (int i = localBundle.getInt("msg_sub_cmd");; i = 0)
    {
      switch (paramMessage.what)
      {
      }
      while ((localBundle != null) && (paramMessage.what >= 100) && (paramMessage.what <= 106) && (QQAppInterface.class.isInstance(RichmediaService.b((RichmediaService)localObject1))))
      {
        Object localObject2 = localBundle.getString("vidoe_record_uniseq");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label332;
        }
        throw new IllegalArgumentException("VideoData id is " + (String)localObject2 + ", msg is " + paramMessage.what);
        LOG.a("RichmediaService", "handleMessage MSG_C2S_REGISTER_CLIENT");
        ((RichmediaService)localObject1).b = paramMessage.replyTo;
        if (localBundle != null)
        {
          localObject2 = (BinderWarpper)localBundle.getParcelable("ICallBack_BinderWrapper");
          if (localObject2 != null)
          {
            ((RichmediaService)localObject1).a = ICallBack.Stub.a(((BinderWarpper)localObject2).a);
            localObject2 = new Bundle();
            int[] arrayOfInt = PicBusiManager.a((QQAppInterface)RichmediaService.a((RichmediaService)localObject1));
            try
            {
              ((Bundle)localObject2).putIntArray("key_compress_config", arrayOfInt);
              ((RichmediaService)localObject1).a.a(6, (Bundle)localObject2);
            }
            catch (RemoteException localRemoteException)
            {
              LOG.a("RichmediaService", "ICALLBACK_CMD_INIT_COMPRESS_CONFIG remote error:" + localRemoteException);
              localRemoteException.printStackTrace();
            }
            continue;
            LOG.a("RichmediaService", "handleMessage MSG_C2S_UNREGISTER_CLIENT");
            ((RichmediaService)localObject1).b = null;
            ((RichmediaService)localObject1).a = null;
          }
        }
      }
      break;
      label332:
      localObject1 = (QQAppInterface)RichmediaService.c((RichmediaService)localObject1);
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
        return;
      case 100: 
        paramMessage = new VideoSliceInfo();
        paramMessage.jdField_a_of_type_JavaLangString = localBundle.getString("video_slice_path");
        paramMessage.jdField_a_of_type_Int = localBundle.getInt("video_slice_index");
        paramMessage.jdField_c_of_type_Int = localBundle.getInt("video_slice_width");
        paramMessage.d = localBundle.getInt("video_slice_height");
        VideoSendTaskManager.a().a((QQAppInterface)localObject1, localRemoteException, paramMessage);
        return;
      case 102: 
        paramMessage = new VideoSliceInfo();
        paramMessage.jdField_a_of_type_Boolean = true;
        VideoSendTaskManager.a().a((QQAppInterface)localObject1, localRemoteException, paramMessage);
        return;
      case 103: 
        VideoSendTaskManager.a().b((QQAppInterface)localObject1, localRemoteException, localBundle);
        return;
      case 104: 
        VideoSendTaskManager.a().a((QQAppInterface)localObject1, localRemoteException, localBundle);
        return;
      case 101: 
        if (i == 2) {
          bool = true;
        }
        i = localBundle.getInt("roll_back_reason");
        VideoSendTaskManager.a().a((QQAppInterface)localObject1, localRemoteException, bool, i);
        return;
      case 105: 
        VideoSendTaskManager.a().a((QQAppInterface)localObject1, localRemoteException);
        paramMessage = new VideoSliceInfo();
        paramMessage.b = true;
        paramMessage.jdField_c_of_type_Boolean = localBundle.getBoolean("video_full_slice_sync_to_story", false);
        if (QLog.isColorLevel()) {
          QLog.d("PTV", 2, "clickSend si.mVideoSyncStory = " + paramMessage.jdField_c_of_type_Boolean);
        }
        VideoSendTaskManager.a().a((QQAppInterface)localObject1, localRemoteException, paramMessage);
        return;
      }
      paramMessage = localBundle.getString("vidoe_record_uniseq");
      i = localBundle.getInt("ab_test_video_duration");
      long l1 = localBundle.getLong("ab_test_send_btn_click_time");
      long l2 = localBundle.getLong("video_record_touch_up_time");
      int j = localBundle.getInt("video_record_touch_up_times");
      if (ShortVideoUploadABTest.a()) {
        ShortVideoUploadABTest.a((QQAppInterface)localObject1, Long.valueOf(paramMessage).longValue(), l1, i);
      }
      ShortVideoPresendStats.a((QQAppInterface)localObject1, Long.valueOf(paramMessage).longValue(), l1, i, l2, j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aotq
 * JD-Core Version:    0.7.0.1
 */