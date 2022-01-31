import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.ARMapHongBaoListView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bjzr
{
  private bjzu jdField_a_of_type_Bjzu;
  private bjzz jdField_a_of_type_Bjzz;
  private bkaa jdField_a_of_type_Bkaa;
  private bkch jdField_a_of_type_Bkch = new bjzs(this);
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ARMapHongBaoListView jdField_a_of_type_ComTencentWidgetARMapHongBaoListView;
  
  public bjzr(QQAppInterface paramQQAppInterface, Conversation paramConversation, ARMapHongBaoListView paramARMapHongBaoListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView = paramARMapHongBaoListView;
  }
  
  private void a(TianShuAccess.AdItem paramAdItem)
  {
    if (this.jdField_a_of_type_Bjzu == null) {
      this.jdField_a_of_type_Bjzu = new bjzu(this.jdField_a_of_type_ComTencentMobileqqActivityConversation);
    }
    this.jdField_a_of_type_Bjzu.a(paramAdItem);
  }
  
  private void a(TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null)) {}
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
      if (this.jdField_a_of_type_Bkaa == null)
      {
        this.jdField_a_of_type_Bkaa = new bkaa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView);
        this.jdField_a_of_type_Bkaa.a();
      }
      this.jdField_a_of_type_Bkaa.a(paramAdItem);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setPendantHolder(this.jdField_a_of_type_Bkaa);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setOnPendentClickListener(this.jdField_a_of_type_Bkaa);
    }
  }
  
  private void c(TianShuAccess.AdItem paramAdItem)
  {
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null)
    {
      if (this.jdField_a_of_type_Bjzz == null)
      {
        this.jdField_a_of_type_Bjzz = new bjzz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView);
        this.jdField_a_of_type_Bjzz.a();
      }
      this.jdField_a_of_type_Bjzz.a(paramAdItem);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a(this.jdField_a_of_type_Bjzz);
    }
  }
  
  public void a()
  {
    bkci.a().a(bjzt.a(), this.jdField_a_of_type_Bkch);
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
    this.jdField_a_of_type_Bjzz = null;
    this.jdField_a_of_type_Bkaa = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjzr
 * JD-Core Version:    0.7.0.1
 */