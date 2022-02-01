import android.util.SparseArray;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.vas.VasExtensionHandler;

public class ansp
{
  public static void a(SparseArray<Class<? extends BusinessHandler>> paramSparseArray)
  {
    paramSparseArray.put(BusinessHandlerFactory.MESSAGE_HANDLER, MessageHandler.class);
    paramSparseArray.put(BusinessHandlerFactory.MESSAGE_HANDLER, MessageHandler.class);
    paramSparseArray.put(BusinessHandlerFactory.FRIENDLIST_HANDLER, FriendListHandler.class);
    paramSparseArray.put(BusinessHandlerFactory.CARD_HANLDER, anri.class);
    paramSparseArray.put(BusinessHandlerFactory.REPORT_HANDLER, aocs.class);
    paramSparseArray.put(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER, aocn.class);
    paramSparseArray.put(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT, PublicAccountHandler.class);
    paramSparseArray.put(BusinessHandlerFactory.SVIP_HANDLER, aocy.class);
    paramSparseArray.put(BusinessHandlerFactory.THEME_HANDLER, aoei.class);
    paramSparseArray.put(BusinessHandlerFactory.SUBACCOUNT_HANDLER, aoed.class);
    paramSparseArray.put(BusinessHandlerFactory.TROOP_HANDLER, aoep.class);
    paramSparseArray.put(BusinessHandlerFactory.RED_TOUCH_HANDLER, aoch.class);
    paramSparseArray.put(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER, ntj.class);
    paramSparseArray.put(BusinessHandlerFactory.REDPOINT_HANDER, aocj.class);
    paramSparseArray.put(BusinessHandlerFactory.QWALLET_HANDLER, aobx.class);
    paramSparseArray.put(BusinessHandlerFactory.LOGIN_WELCOME_HANDLER, awoy.class);
    paramSparseArray.put(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER, ook.class);
    paramSparseArray.put(BusinessHandlerFactory.VAS_MONITOR_HANDLER, bhpe.class);
    paramSparseArray.put(BusinessHandlerFactory.WEREWOLVES_HANDLER, bikt.class);
    paramSparseArray.put(BusinessHandlerFactory.APOLLO_CONTENT_UPDATE_HANDLER, aozm.class);
    paramSparseArray.put(BusinessHandlerFactory.TEAM_WORK_HANDLER, becb.class);
    paramSparseArray.put(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER, aslm.class);
    paramSparseArray.put(BusinessHandlerFactory.APPLET_PUSH_HANDLER, apap.class);
    paramSparseArray.put(BusinessHandlerFactory.QQ_DAILY_HANDLER, aoyy.class);
    paramSparseArray.put(BusinessHandlerFactory.ONLINE_STATUS_HANDLER, azff.class);
    paramSparseArray.put(BusinessHandlerFactory.VAS_EXTENSION_HANDLER, VasExtensionHandler.class);
    paramSparseArray.put(BusinessHandlerFactory.VIPINFO_HANDLER, aogw.class);
    paramSparseArray.put(BusinessHandlerFactory.MINIMSG_HANDLER, akes.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansp
 * JD-Core Version:    0.7.0.1
 */