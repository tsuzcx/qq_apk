package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import rsa;
import rsb;
import rsd;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerRoundRspBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.DynamicBannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.MoreChannelItem;

public class TopBannerInfo
  extends Entity
{
  private static final String TAG = "TopBannerInfo";
  @notColumn
  public final List<rsb> dynamicItems = new ArrayList();
  @notColumn
  public final List<rsa> items = new ArrayList();
  public byte[] itemsByte;
  public int mChannelId = -1;
  public String mCookie;
  @notColumn
  public rsd moreChannelItem;
  
  public void addDynamicItem(rsb paramrsb)
  {
    this.dynamicItems.add(paramrsb);
  }
  
  public void addItem(rsa paramrsa)
  {
    this.items.add(paramrsa);
  }
  
  public boolean isBothEmpty()
  {
    return (this.items.isEmpty()) && (this.dynamicItems.isEmpty());
  }
  
  public boolean isDynamicItemsEmpty()
  {
    return this.dynamicItems.isEmpty();
  }
  
  public boolean isEmpty()
  {
    return (this.items.isEmpty()) && (this.dynamicItems.isEmpty());
  }
  
  public void postRead()
  {
    Iterator localIterator;
    Object localObject;
    if ((this.itemsByte != null) && (this.itemsByte.length > 0))
    {
      oidb_cmd0xbc9.BannerRoundRspBody localBannerRoundRspBody = new oidb_cmd0xbc9.BannerRoundRspBody();
      try
      {
        localBannerRoundRspBody.mergeFrom(this.itemsByte);
        if (localBannerRoundRspBody.rpt_msg_banner_list.has())
        {
          localIterator = localBannerRoundRspBody.rpt_msg_banner_list.get().iterator();
          while (localIterator.hasNext())
          {
            localObject = rsa.a((oidb_cmd0xbc9.BannerItem)localIterator.next());
            if (localObject != null)
            {
              this.items.add(localObject);
              continue;
              return;
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        this.items.clear();
        QLog.d("TopBannerInfo", 1, "", localInvalidProtocolBufferMicroException);
      }
    }
    rsd localrsd;
    do
    {
      do
      {
        if ((localInvalidProtocolBufferMicroException.rpt_msg_dynamic_banner_list.has()) && (localInvalidProtocolBufferMicroException.rpt_msg_dynamic_banner_list.size() > 0))
        {
          localIterator = localInvalidProtocolBufferMicroException.rpt_msg_dynamic_banner_list.get().iterator();
          while (localIterator.hasNext())
          {
            localObject = rsb.a((oidb_cmd0xbc9.DynamicBannerItem)localIterator.next());
            if (localObject != null) {
              this.dynamicItems.addAll((Collection)localObject);
            }
          }
        }
      } while (!localInvalidProtocolBufferMicroException.msg_more_channel_item.has());
      localrsd = rsd.a((oidb_cmd0xbc9.MoreChannelItem)localInvalidProtocolBufferMicroException.msg_more_channel_item.get());
    } while (localrsd == null);
    this.moreChannelItem = localrsd;
  }
  
  public void prewrite()
  {
    if (!isBothEmpty())
    {
      oidb_cmd0xbc9.BannerRoundRspBody localBannerRoundRspBody = new oidb_cmd0xbc9.BannerRoundRspBody();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.items.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((rsa)localIterator.next()).a());
      }
      localBannerRoundRspBody.rpt_msg_banner_list.addAll(localArrayList);
      localArrayList = new ArrayList();
      localIterator = this.dynamicItems.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((rsb)localIterator.next()).a());
      }
      if (this.moreChannelItem != null) {
        localBannerRoundRspBody.msg_more_channel_item.set(this.moreChannelItem.a());
      }
      localBannerRoundRspBody.rpt_msg_dynamic_banner_list.addAll(localArrayList);
      this.itemsByte = localBannerRoundRspBody.toByteArray();
    }
  }
  
  public void setMoreChannelItem(rsd paramrsd)
  {
    this.moreChannelItem = paramrsd;
  }
  
  public String toString()
  {
    return "mCookie : " + this.mCookie + "  mChannelId: " + this.mChannelId + " items size: " + this.items.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo
 * JD-Core Version:    0.7.0.1
 */