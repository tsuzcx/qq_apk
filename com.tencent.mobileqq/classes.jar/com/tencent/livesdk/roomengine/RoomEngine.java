package com.tencent.livesdk.roomengine;

import android.content.Context;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.anchorchangerateservice.AnchorChangeRateInterface;
import com.tencent.ilivesdk.anchorfinishpageserviceinterface.AnchorFinishPageServiceInterface;
import com.tencent.ilivesdk.avmediaservice_interface.MediaPlayerInterface;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.balanceservice_interface.BalanceServiceInterface;
import com.tencent.ilivesdk.changevideorateservice_interface.ChangeVideoRateServiceInterface;
import com.tencent.ilivesdk.charmservice_interface.CharmServiceInterface;
import com.tencent.ilivesdk.coredataserviceinterface.CoreDataServiceInterface;
import com.tencent.ilivesdk.ecommerceservice_interface.ECommerceServiceInterface;
import com.tencent.ilivesdk.floatheartservice_interface.FloatHeartServiceInterface;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface;
import com.tencent.ilivesdk.harvestservice_interface.HarvestServiceInterface;
import com.tencent.ilivesdk.linkmicavservice_interface.LinkMicAvServiceInterface;
import com.tencent.ilivesdk.linkmicbizserviceinterface.LinkMicBizServiceInterface;
import com.tencent.ilivesdk.liveoverservice_interface.LiveOverServiceInterface;
import com.tencent.ilivesdk.messagefilterserviceinterface.MessageFilterServiceInterface;
import com.tencent.ilivesdk.messageservice_interface.MessageServiceInterface;
import com.tencent.ilivesdk.minicardservice_interface.MiniCardServiceInterface;
import com.tencent.ilivesdk.musicmanagerservice_interface.MusicManagerServiceInterface;
import com.tencent.ilivesdk.musicservice_interface.MusicServiceInterface;
import com.tencent.ilivesdk.pendantservice_interface.PendantServiceInterface;
import com.tencent.ilivesdk.recordservice_interface.RecordServiceInterface;
import com.tencent.ilivesdk.roomaudienceservice_interface.RoomAudienceServiceInterface;
import com.tencent.ilivesdk.roomcomponenthiderservice_interface.RoomComponentHiderServiceInterface;
import com.tencent.ilivesdk.roomlikeservice_interface.RoomlikeServiceInterface;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface;
import com.tencent.ilivesdk.supervisionservice_interface.SupervisionServiceInterface;
import com.tencent.ilivesdk.violationstrikeservice_interface.ViolationStrikeServiceInterface;
import com.tencent.livesdk.servicefactory.BaseEngine;
import com.tencent.livesdk.servicefactory.EnginServiceConfig;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.ServiceEnginScope;
import com.tencent.livesdk.servicefactory.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RoomEngine
  extends BaseEngine
  implements EnginServiceConfig
{
  private static final String TAG = "RoomEngine";
  private Context context;
  private RoomEnginLogic enginLogic;
  private boolean inRoom = false;
  private boolean isUnInit = false;
  
  public RoomEngine(Context paramContext, ServiceAccessor paramServiceAccessor)
  {
    this.context = paramContext;
    initServiceConfig();
    this.serviceManager = new ServiceManager(paramContext, paramServiceAccessor, this);
    this.enginLogic = new RoomEnginLogic(this.serviceManager);
    this.isUnInit = false;
  }
  
  private void initServiceConfig()
  {
    if (this.scopeServices.size() > 0) {
      this.scopeServices.clear();
    }
    this.scopeServices.add(AVPlayerBuilderServiceInterface.class);
    this.scopeServices.add(CharmServiceInterface.class);
    this.scopeServices.add(ECommerceServiceInterface.class);
    this.scopeServices.add(FloatHeartServiceInterface.class);
    this.scopeServices.add(GiftServiceInterface.class);
    this.scopeServices.add(BalanceServiceInterface.class);
    this.scopeServices.add(LiveOverServiceInterface.class);
    this.scopeServices.add(MessageServiceInterface.class);
    this.scopeServices.add(MiniCardServiceInterface.class);
    this.scopeServices.add(RoomAudienceServiceInterface.class);
    this.scopeServices.add(RoomPushServiceInterface.class);
    this.scopeServices.add(RoomServiceInterface.class);
    this.scopeServices.add(SupervisionServiceInterface.class);
    this.scopeServices.add(MusicServiceInterface.class);
    this.scopeServices.add(MusicManagerServiceInterface.class);
    this.scopeServices.add(ViolationStrikeServiceInterface.class);
    this.scopeServices.add(RoomSwitchInterface.class);
    this.scopeServices.add(PendantServiceInterface.class);
    this.scopeServices.add(HarvestServiceInterface.class);
    this.scopeServices.add(RoomlikeServiceInterface.class);
    this.scopeServices.add(RecordServiceInterface.class);
    this.scopeServices.add(LinkMicAvServiceInterface.class);
    this.scopeServices.add(LinkMicBizServiceInterface.class);
    this.scopeServices.add(ChangeVideoRateServiceInterface.class);
    this.scopeServices.add(RoomComponentHiderServiceInterface.class);
    this.scopeServices.add(CoreDataServiceInterface.class);
    this.scopeServices.add(AnchorChangeRateInterface.class);
    this.scopeServices.add(AnchorFinishPageServiceInterface.class);
    this.scopeServices.add(MessageFilterServiceInterface.class);
    this.scopeServices.add(MediaPlayerInterface.class);
    initNewServiceScope(ServiceEnginScope.Room);
  }
  
  public void clearEventOutput()
  {
    if (this.serviceManager.getAllAvailableService().size() > 0)
    {
      Iterator localIterator = this.serviceManager.getAllAvailableService().values().iterator();
      while (localIterator.hasNext()) {
        ((ServiceBaseInterface)localIterator.next()).clearEventOutput();
      }
    }
  }
  
  public void destroyService(Class<? extends ServiceBaseInterface> paramClass)
  {
    this.serviceManager.destroyService(paramClass);
  }
  
  public void enterRoomSuccess()
  {
    this.inRoom = true;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public RoomEnginLogic getEnginLogic()
  {
    return this.enginLogic;
  }
  
  public String getOwnerEngine()
  {
    return "RoomEngine";
  }
  
  public Set<Class> getScopeServices()
  {
    return this.scopeServices;
  }
  
  public <T extends ServiceBaseInterface> T getService(Class<? extends T> paramClass)
  {
    return this.serviceManager.getService(paramClass);
  }
  
  public boolean isInRoom()
  {
    return this.inRoom;
  }
  
  public boolean isUnInit()
  {
    return this.isUnInit;
  }
  
  public void setUnInit()
  {
    this.isUnInit = true;
  }
  
  public void unint()
  {
    getEnginLogic().setReWatchEnterRoomListener(null);
    if (this.serviceManager.getAllAvailableService().size() > 0)
    {
      Iterator localIterator = this.serviceManager.getAllAvailableService().values().iterator();
      while (localIterator.hasNext()) {
        ((ServiceBaseInterface)localIterator.next()).onDestroy();
      }
    }
    this.serviceManager.getAllAvailableService().clear();
    this.inRoom = false;
    this.isUnInit = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.roomengine.RoomEngine
 * JD-Core Version:    0.7.0.1
 */