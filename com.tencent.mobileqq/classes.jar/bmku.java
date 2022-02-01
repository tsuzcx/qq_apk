import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.ARMapHongBaoListView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.tianshu.TianShuGetAdvCallback;
import cooperation.vip.tianshu.TianShuManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bmku
{
  private bmkx jdField_a_of_type_Bmkx;
  private bmlc jdField_a_of_type_Bmlc;
  private bmld jdField_a_of_type_Bmld;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ARMapHongBaoListView jdField_a_of_type_ComTencentWidgetARMapHongBaoListView;
  private TianShuGetAdvCallback jdField_a_of_type_CooperationVipTianshuTianShuGetAdvCallback = new bmkv(this);
  
  public bmku(QQAppInterface paramQQAppInterface, Conversation paramConversation, ARMapHongBaoListView paramARMapHongBaoListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView = paramARMapHongBaoListView;
  }
  
  private void a(TianShuAccess.AdItem paramAdItem)
  {
    if (this.jdField_a_of_type_Bmkx == null) {
      this.jdField_a_of_type_Bmkx = new bmkx(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation);
    }
    TianShuManager.getInstance().cacheTraceInfo(paramAdItem);
    this.jdField_a_of_type_Bmkx.a(paramAdItem);
  }
  
  private void a(TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation == null)) {}
    do
    {
      HashMap localHashMap;
      do
      {
        for (;;)
        {
          return;
          if (paramGetAdsRsp.mapAds.has()) {}
          for (paramGetAdsRsp = paramGetAdsRsp.mapAds.get(); paramGetAdsRsp != null; paramGetAdsRsp = null)
          {
            localHashMap = new HashMap();
            paramGetAdsRsp = paramGetAdsRsp.iterator();
            while (paramGetAdsRsp.hasNext())
            {
              TianShuAccess.RspEntry localRspEntry = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
              if ((localRspEntry != null) && (localRspEntry.key.has())) {
                localHashMap.put(Integer.valueOf(localRspEntry.key.get()), localRspEntry);
              }
            }
          }
        }
        paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(340));
        if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (paramGetAdsRsp.value.lst.size() != 0) && (paramGetAdsRsp.value.lst.get(0) != null)) {
          a((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0));
        }
        paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(341));
        if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (paramGetAdsRsp.value.lst.size() != 0) && (paramGetAdsRsp.value.lst.get(0) != null)) {
          b((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0));
        }
      } while ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) || (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a != null));
      paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(339));
    } while ((paramGetAdsRsp == null) || (paramGetAdsRsp.value == null) || (paramGetAdsRsp.value.lst.size() == 0) || (paramGetAdsRsp.value.lst.get(0) == null));
    c((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0));
  }
  
  private void b(TianShuAccess.AdItem paramAdItem)
  {
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null)
    {
      if (this.jdField_a_of_type_Bmld == null)
      {
        this.jdField_a_of_type_Bmld = new bmld(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView);
        this.jdField_a_of_type_Bmld.a();
      }
      TianShuManager.getInstance().cacheTraceInfo(paramAdItem);
      this.jdField_a_of_type_Bmld.a(paramAdItem);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setPendantHolder(this.jdField_a_of_type_Bmld);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setOnPendentClickListener(this.jdField_a_of_type_Bmld);
    }
  }
  
  private void c(TianShuAccess.AdItem paramAdItem)
  {
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null)
    {
      if (this.jdField_a_of_type_Bmlc == null)
      {
        this.jdField_a_of_type_Bmlc = new bmlc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView);
        this.jdField_a_of_type_Bmlc.a();
      }
      TianShuManager.getInstance().cacheTraceInfo(paramAdItem);
      this.jdField_a_of_type_Bmlc.a(paramAdItem);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a(this.jdField_a_of_type_Bmlc);
    }
  }
  
  public void a()
  {
    TianShuManager.getInstance().requestAdv(bmkw.a(), this.jdField_a_of_type_CooperationVipTianshuTianShuGetAdvCallback);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setPendantHolder(null);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.c();
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setOnPendentClickListener(null);
    }
    this.jdField_a_of_type_Bmlc = null;
    this.jdField_a_of_type_Bmld = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmku
 * JD-Core Version:    0.7.0.1
 */