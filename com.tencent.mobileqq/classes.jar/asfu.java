import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.MineFragment.2;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import tencent.im.oidb.cmd0x91f.oidb_0x91f.ReqBody;

public class asfu
{
  public static void a(NearbyAppInterface paramNearbyAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby", 2, "clearLbsInfoAndExit");
    }
    auwq.a(paramNearbyAppInterface.getAccount(), "nearby_enter_time", Long.valueOf(0L));
    if ((alxp)paramNearbyAppInterface.a(3) != null)
    {
      oidb_0x91f.ReqBody localReqBody = new oidb_0x91f.ReqBody();
      localReqBody.uint32_state.set(0);
      mzy.a(paramNearbyAppInterface, new asfv(paramNearbyAppInterface), localReqBody.toByteArray(), "OidbSvc.0x91f", 2335, 5, null, 0L);
    }
    auwq.a(paramNearbyAppInterface.getAccount(), false);
    auwq.a(paramNearbyAppInterface.getAccount(), "nearby_people_disclaimer_ok_5.8.0", Boolean.valueOf(false));
    paramNearbyAppInterface.c = false;
    ThreadManager.post(new MineFragment.2(paramNearbyAppInterface), 10, null, true);
  }
  
  public static void b(NearbyAppInterface paramNearbyAppInterface)
  {
    File localFile = BaseApplicationImpl.getContext().getFileStreamPath(paramNearbyAppInterface.getCurrentAccountUin() + "v5.3.nb");
    if (localFile.exists())
    {
      localFile.delete();
      auwz.a("Q.nearby", "clearNearbyCache", new Object[0]);
    }
    auwq.a(paramNearbyAppInterface.getAccount(), "history_valid", Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfu
 * JD-Core Version:    0.7.0.1
 */