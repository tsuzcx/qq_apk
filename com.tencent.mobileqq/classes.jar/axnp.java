import android.os.Bundle;
import android.os.Messenger;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.util.Arrays;

class axnp
  extends axnk
{
  axnp(axnn paramaxnn) {}
  
  public Bundle a(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    PresendPicMgr localPresendPicMgr;
    if (paramInt == 16)
    {
      axnm.a("PTV.RichmediaClient", "ICallBack.Stub() getData start. ICALLBACK_CMD_GET_PRESEND_MGR_HANDLER");
      localPresendPicMgr = PresendPicMgr.a();
      Object localObject = null;
      if ((localPresendPicMgr != null) && (localPresendPicMgr.jdField_a_of_type_Boolean)) {
        break label113;
      }
      paramBundle = localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("PTV.RichmediaClient", 2, "ICALLBACK_CMD_GET_PRESEND_MGR_HANDLER failed, presendMgr is null or disable preCompress,presendMgr = " + localPresendPicMgr);
        paramBundle = localObject;
      }
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        localBundle.putParcelable("key_presend_mgr_handler", new BinderWarpper(paramBundle));
        localBundle.putInt("PhotoConst.PHOTO_COUNT", localPresendPicMgr.a());
      }
      return localBundle;
      label113:
      paramBundle = new Messenger(localPresendPicMgr.jdField_a_of_type_Awjy).getBinder();
      axnm.a("PTV.RichmediaClient", "ICallBack.Stub() getData. ICALLBACK_CMD_GET_PRESEND_MGR_HANDLER , b = " + paramBundle);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    axnm.a("PTV.RichmediaClient", "sendRequest. cmd = " + paramInt + ",data = " + paramBundle);
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          Object localObject;
          do
          {
            do
            {
              return;
              paramBundle = (BinderWarpper)paramBundle.getParcelable("binder_presendService");
              if (paramBundle != null)
              {
                localObject = PresendPicMgr.a();
                if (localObject != null) {
                  ((PresendPicMgr)localObject).b();
                }
                paramBundle = PresendPicMgr.b(awit.a(paramBundle.a));
                axnm.a("PTV.RichmediaClient", "ICALLBACK_CMD_INIT_PRESEND_PIC_MGR  presendMgr = " + paramBundle);
                return;
              }
              axnm.a("PTV.RichmediaClient", "ICALLBACK_CMD_INIT_PRESEND_PIC_MGR  failed, bw is null ! ");
              return;
              localObject = paramBundle.getString("key_presend_path");
              paramInt = paramBundle.getInt("entrance", 0);
              paramBundle = PresendPicMgr.a();
            } while ((localObject == null) || (paramBundle == null));
            paramBundle.a((String)localObject, 1052, paramInt);
            return;
            localObject = paramBundle.getString("key_presend_path");
            paramInt = paramBundle.getInt("key_presend_cancel_type");
            paramBundle = PresendPicMgr.a();
          } while ((localObject == null) || (paramBundle == null));
          paramBundle.b((String)localObject, paramInt);
          return;
          paramInt = paramBundle.getInt("key_presend_cancel_type");
          paramBundle = PresendPicMgr.a();
        } while (paramBundle == null);
        paramBundle.a(paramInt);
        paramBundle.b();
        return;
        paramBundle = paramBundle.getIntArray("key_compress_config");
      } while ((paramBundle == null) || (paramBundle.length < 9));
      awkl.e = paramBundle[0];
      awkl.f = paramBundle[1];
      awkl.g = paramBundle[2];
      awkl.h = paramBundle[3];
      awkl.i = paramBundle[4];
      awkl.j = paramBundle[5];
      awkl.a = paramBundle[6];
      awkl.b = paramBundle[7];
      awkl.c = paramBundle[8];
    } while (!QLog.isColorLevel());
    QLog.d("PTV.RichmediaClient", 2, "ICALLBACK_CMD_INIT_COMPRESS_CONFIG, compressConfig = " + Arrays.toString(paramBundle));
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    axnm.a("PTV.RichmediaClient", "ICallBack.Stub() compress start. info.src = " + paramCompressInfo.c + ",uuid = " + paramCompressInfo.a);
    awkj.a(paramCompressInfo);
    axnm.a("PTV.RichmediaClient", "ICallBack.Stub() compress finish. info = " + paramCompressInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axnp
 * JD-Core Version:    0.7.0.1
 */