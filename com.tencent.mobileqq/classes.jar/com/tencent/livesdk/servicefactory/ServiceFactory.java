package com.tencent.livesdk.servicefactory;

import android.content.Context;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.apm.APMInterface;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.crash.CrashInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.libapi.location.LocationInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.lottie.LottieServiceInterface;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.falco.base.libapi.notification.NotificationInterface;
import com.tencent.falco.base.libapi.qqsdk.QQSdkInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.falco.base.libapi.web.WebInterface;
import com.tencent.falco.base.libapi.weibosdk.WeiboSdkInterface;
import com.tencent.falco.base.libapi.wns.WnsInterface;
import com.tencent.falco.base.libapi.wxsdk.WxSdkInterface;
import com.tencent.ilivesdk.anchorchangerateservice.AnchorChangeRateInterface;
import com.tencent.ilivesdk.anchorfinishpageserviceinterface.AnchorFinishPageServiceInterface;
import com.tencent.ilivesdk.anchortagserviceinterface.AnchorTagServiceInterface;
import com.tencent.ilivesdk.avmediaservice_interface.AVMediaServiceInterface;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface;
import com.tencent.ilivesdk.balanceservice_interface.BalanceServiceInterface;
import com.tencent.ilivesdk.beautyfilterservice_interface.BeautyFilterServiceInterface;
import com.tencent.ilivesdk.changevideorateservice_interface.ChangeVideoRateServiceInterface;
import com.tencent.ilivesdk.charmservice_interface.CharmServiceInterface;
import com.tencent.ilivesdk.coredataserviceinterface.CoreDataServiceInterface;
import com.tencent.ilivesdk.coverservice_interface.CoverServiceInterface;
import com.tencent.ilivesdk.ecommerceservice_interface.ECommerceServiceInterface;
import com.tencent.ilivesdk.faceverifyservice_interface.FaceVerifyServiceInterface;
import com.tencent.ilivesdk.floatheartservice_interface.FloatHeartServiceInterface;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface;
import com.tencent.ilivesdk.harvestservice_interface.HarvestServiceInterface;
import com.tencent.ilivesdk.linkmicavservice_interface.LinkMicAvServiceInterface;
import com.tencent.ilivesdk.linkmicbizserviceinterface.LinkMicBizServiceInterface;
import com.tencent.ilivesdk.liveconfigservice_interface.LiveConfigServiceInterface;
import com.tencent.ilivesdk.liveoverservice_interface.LiveOverServiceInterface;
import com.tencent.ilivesdk.livestartcustomerconfigservice_interface.LiveStartCusConfServiceInterface;
import com.tencent.ilivesdk.messagefilterserviceinterface.MessageFilterServiceInterface;
import com.tencent.ilivesdk.messageservice_interface.MessageServiceInterface;
import com.tencent.ilivesdk.minicardservice_interface.MiniCardServiceInterface;
import com.tencent.ilivesdk.musicmanagerservice_interface.MusicManagerServiceInterface;
import com.tencent.ilivesdk.musicservice_interface.MusicServiceInterface;
import com.tencent.ilivesdk.pendantservice_interface.PendantServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceInterface;
import com.tencent.ilivesdk.recordservice_interface.RecordServiceInterface;
import com.tencent.ilivesdk.roomaudienceservice_interface.RoomAudienceServiceInterface;
import com.tencent.ilivesdk.roomcomponenthiderservice_interface.RoomComponentHiderServiceInterface;
import com.tencent.ilivesdk.roomlikeservice_interface.RoomlikeServiceInterface;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.startliveservice_interface.StartLiveServiceInterface;
import com.tencent.ilivesdk.supervisionservice_interface.SupervisionServiceInterface;
import com.tencent.ilivesdk.uicustomservice_interface.UICustomServiceInterface;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface;
import com.tencent.ilivesdk.violationstrikeservice_interface.ViolationStrikeServiceInterface;
import com.tencent.ilivesdk.webcommonserviceinterface.WebCommonServiceInterface;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.RoomlikeServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.activitylife.ActivityLifeBuilder;
import com.tencent.livesdk.servicefactory.builder.anchorfinish.AnchorFinishPageServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.anchorrate.AnchorRateChangeServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.anchortag.AnchorTagServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.apm.APMServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.appinfo.AppInfoBuilder;
import com.tencent.livesdk.servicefactory.builder.avmedia.AVMediaServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.avplayer.AVPlayerServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.avplayer.AVPreloadServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.balance.BalanceServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.beautyfilter.BeautyFilterServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.changevideorate.ChangeVideoRateServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.channel.ChannelServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.chatmessage.ChatMessageServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.coredata.CoreDataBuilder;
import com.tencent.livesdk.servicefactory.builder.cover.CoverServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.crash.CrashServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.customuiconfig.UICustomServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.datareport.DataReportServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.downloader.DownloadServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.faceverify.FaceVerifyServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.floatheart.FloatHeartServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.floatwindowconfig.FloatWindowConfigServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.floatwindowpermission.FloatWindowPermissionBuilder;
import com.tencent.livesdk.servicefactory.builder.harvest.HarvestServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.hostproxy.HostProxyBuilder;
import com.tencent.livesdk.servicefactory.builder.http.HttpServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.imageloader.ImageLoaderServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.linkmic.LinkMicAvServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.linkmic.LinkMicBizServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.liveconfig.LiveConfigServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.livegift.LiveGiftServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.liveover.LiveOverServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.livestartcustomerconfig.LiveStartCusConfServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.location.LocationServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.log.LogSdkServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.log.LogServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.login.LoginServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.lottie.LottieServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.messagefilter.MessageFilterServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.minicard.MiniCardServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.music.MusicDubServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.musicmanager.MusicManagerBuilder;
import com.tencent.livesdk.servicefactory.builder.network.NetworkServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.notification.NotificationServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.pendant.PendantServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.qqsdk.QQSdkBuilder;
import com.tencent.livesdk.servicefactory.builder.qualityreport.QualityReportServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.recordscreen.RecordScreenServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.room.RoomServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.roomaudience.RoomAudienceServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.roomhidecmp.RoomComponentHideBuilder;
import com.tencent.livesdk.servicefactory.builder.roommanager.CharmServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.roompush.RoomPushServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.startlive.StartLiveServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.supervision.SupervisionServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.toast.ToastServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.userinfo.UserInfoServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.violationstrike.ViolationStrikeBuilder;
import com.tencent.livesdk.servicefactory.builder.web.WebCommonUseBuilder;
import com.tencent.livesdk.servicefactory.builder.web.WebServiceBuilder;
import com.tencent.livesdk.servicefactory.builder.weibosdk.WeiboSdkBuilder;
import com.tencent.livesdk.servicefactory.builder.wns.WnsBuilder;
import com.tencent.livesdk.servicefactory.builder.wxsdk.WxSdkBuilder;
import com.tencent.livesdk.servicefactory.ecommerce.ECommerceServiceBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServiceFactory
{
  private static Map<ServiceEnginScope, List<Class<? extends ServiceBaseInterface>>> scopeServiceListMap = new HashMap();
  private static ServiceConfig serviceConfig = new ServiceConfig();
  
  public static void config(ServiceConfig paramServiceConfig)
  {
    if (paramServiceConfig.get().size() > 0) {
      serviceConfig.merge(paramServiceConfig);
    }
    configServiceScope();
  }
  
  private static void configServiceScope()
  {
    if (scopeServiceListMap.size() > 0) {
      scopeServiceListMap.clear();
    }
    Map localMap = serviceConfig.getEnginScope();
    if ((localMap != null) && (localMap.size() > 0))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        ServiceEnginScope localServiceEnginScope = (ServiceEnginScope)localMap.get(localClass);
        int i = ServiceFactory.1.$SwitchMap$com$tencent$livesdk$servicefactory$ServiceEnginScope[localServiceEnginScope.ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              localArrayList3.add(localClass);
            }
          }
          else {
            localArrayList2.add(localClass);
          }
        }
        else {
          localArrayList1.add(localClass);
        }
      }
      scopeServiceListMap.put(ServiceEnginScope.Live, localArrayList1);
      scopeServiceListMap.put(ServiceEnginScope.User, localArrayList2);
      scopeServiceListMap.put(ServiceEnginScope.Room, localArrayList3);
    }
  }
  
  public static <T extends ServiceBaseInterface> T createService(Context paramContext, Class<? extends T> paramClass)
  {
    paramContext = (BaseServiceBuilder)serviceConfig.get().get(paramClass);
    if (paramContext != null) {
      return paramContext.build(null);
    }
    return null;
  }
  
  public static <T extends ServiceBaseInterface> T createService(Context paramContext, Class<? extends T> paramClass, ServiceAccessor paramServiceAccessor)
  {
    paramClass = (BaseServiceBuilder)serviceConfig.get().get(paramClass);
    if (paramClass != null)
    {
      paramClass = paramClass.build(paramServiceAccessor);
      paramClass.onCreate(paramContext);
      return paramClass;
    }
    return null;
  }
  
  public static <T extends ServiceBaseInterface> void customizeServiceBuilder(Class<? extends T> paramClass, BaseServiceBuilder paramBaseServiceBuilder)
  {
    serviceConfig.add(paramClass, paramBaseServiceBuilder);
  }
  
  public static Map<ServiceEnginScope, List<Class<? extends ServiceBaseInterface>>> getScopeServiceListMap()
  {
    return scopeServiceListMap;
  }
  
  public static void init()
  {
    serviceConfig.add(LoginServiceInterface.class, new LoginServiceBuilder());
    serviceConfig.add(LiveOverServiceInterface.class, new LiveOverServiceBuilder());
    serviceConfig.add(StartLiveServiceInterface.class, new StartLiveServiceBuilder());
    serviceConfig.add(RoomServiceInterface.class, new RoomServiceBuilder());
    serviceConfig.add(AVMediaServiceInterface.class, new AVMediaServiceBuilder());
    serviceConfig.add(LogSdkServiceInterface.class, new LogSdkServiceBuilder());
    serviceConfig.add(LogInterface.class, new LogServiceBuilder());
    serviceConfig.add(ImageLoaderInterface.class, new ImageLoaderServiceBuilder());
    serviceConfig.add(ChannelInterface.class, new ChannelServiceBuilder());
    serviceConfig.add(HttpInterface.class, new HttpServiceBuilder());
    serviceConfig.add(LiveConfigServiceInterface.class, new LiveConfigServiceBuilder());
    serviceConfig.add(DownLoaderInterface.class, new DownloadServiceBuilder());
    serviceConfig.add(LocationInterface.class, new LocationServiceBuilder());
    serviceConfig.add(AppGeneralInfoService.class, new AppInfoBuilder());
    serviceConfig.add(ActivityLifeService.class, new ActivityLifeBuilder());
    serviceConfig.add(DataReportInterface.class, new DataReportServiceBuilder());
    serviceConfig.add(QualityReportServiceInterface.class, new QualityReportServiceBuilder());
    serviceConfig.add(ToastInterface.class, new ToastServiceBuilder());
    serviceConfig.add(HostProxyInterface.class, new HostProxyBuilder());
    serviceConfig.add(NetworkStateInterface.class, new NetworkServiceBuilder());
    serviceConfig.add(RoomPushServiceInterface.class, new RoomPushServiceBuilder());
    serviceConfig.add(MessageServiceInterface.class, new ChatMessageServiceBuilder());
    serviceConfig.add(ChangeVideoRateServiceInterface.class, new ChangeVideoRateServiceBuilder());
    serviceConfig.add(GiftServiceInterface.class, new LiveGiftServiceBuilder());
    serviceConfig.add(BalanceServiceInterface.class, new BalanceServiceBuilder());
    serviceConfig.add(FloatHeartServiceInterface.class, new FloatHeartServiceBuilder());
    serviceConfig.add(FloatWindowConfigServiceInterface.class, new FloatWindowConfigServiceBuilder());
    serviceConfig.add(FloatWindowPermissionInterface.class, new FloatWindowPermissionBuilder());
    serviceConfig.add(APMInterface.class, new APMServiceBuilder());
    serviceConfig.add(CrashInterface.class, new CrashServiceBuilder());
    serviceConfig.add(CharmServiceInterface.class, new CharmServiceBuilder());
    serviceConfig.add(MiniCardServiceInterface.class, new MiniCardServiceBuilder());
    serviceConfig.add(PendantServiceInterface.class, new PendantServiceBuilder());
    serviceConfig.add(CoverServiceInterface.class, new CoverServiceBuilder());
    serviceConfig.add(RoomAudienceServiceInterface.class, new RoomAudienceServiceBuilder());
    serviceConfig.add(WebInterface.class, new WebServiceBuilder());
    serviceConfig.add(WebCommonServiceInterface.class, new WebCommonUseBuilder());
    serviceConfig.add(UserInfoServiceInterface.class, new UserInfoServiceBuilder());
    serviceConfig.add(ECommerceServiceInterface.class, new ECommerceServiceBuilder());
    serviceConfig.add(QQSdkInterface.class, new QQSdkBuilder());
    serviceConfig.add(WxSdkInterface.class, new WxSdkBuilder());
    serviceConfig.add(WeiboSdkInterface.class, new WeiboSdkBuilder());
    serviceConfig.add(WnsInterface.class, new WnsBuilder());
    serviceConfig.add(SupervisionServiceInterface.class, new SupervisionServiceBuilder());
    serviceConfig.add(BeautyFilterServiceInterface.class, new BeautyFilterServiceBuilder());
    serviceConfig.add(MusicServiceInterface.class, new MusicDubServiceBuilder());
    serviceConfig.add(MusicManagerServiceInterface.class, new MusicManagerBuilder());
    serviceConfig.add(ViolationStrikeServiceInterface.class, new ViolationStrikeBuilder());
    serviceConfig.add(HarvestServiceInterface.class, new HarvestServiceBuilder());
    serviceConfig.add(RoomlikeServiceInterface.class, new RoomlikeServiceBuilder());
    serviceConfig.add(RecordServiceInterface.class, new RecordScreenServiceBuilder());
    serviceConfig.add(AVPlayerBuilderServiceInterface.class, new AVPlayerServiceBuilder());
    serviceConfig.add(AVPreloadServiceInterface.class, new AVPreloadServiceBuilder());
    serviceConfig.add(LiveStartCusConfServiceInterface.class, new LiveStartCusConfServiceBuilder());
    serviceConfig.add(LinkMicBizServiceInterface.class, new LinkMicBizServiceBuilder());
    serviceConfig.add(LinkMicAvServiceInterface.class, new LinkMicAvServiceBuilder());
    serviceConfig.add(UICustomServiceInterface.class, new UICustomServiceBuilder());
    serviceConfig.add(NotificationInterface.class, new NotificationServiceBuilder());
    serviceConfig.add(FaceVerifyServiceInterface.class, new FaceVerifyServiceBuilder());
    serviceConfig.add(RoomComponentHiderServiceInterface.class, new RoomComponentHideBuilder());
    serviceConfig.add(CoreDataServiceInterface.class, new CoreDataBuilder());
    serviceConfig.add(AnchorChangeRateInterface.class, new AnchorRateChangeServiceBuilder());
    serviceConfig.add(AnchorFinishPageServiceInterface.class, new AnchorFinishPageServiceBuilder());
    serviceConfig.add(AnchorTagServiceInterface.class, new AnchorTagServiceBuilder());
    serviceConfig.add(MessageFilterServiceInterface.class, new MessageFilterServiceBuilder());
    serviceConfig.add(LottieServiceInterface.class, new LottieServiceBuilder());
  }
  
  public static void unInit()
  {
    serviceConfig.unInit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.ServiceFactory
 * JD-Core Version:    0.7.0.1
 */