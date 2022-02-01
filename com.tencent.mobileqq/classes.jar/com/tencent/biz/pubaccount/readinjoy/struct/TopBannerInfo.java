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
import rft;
import rfu;
import rfw;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerRoundRspBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.DynamicBannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.MoreChannelItem;

public class TopBannerInfo
  extends Entity
{
  private static final String TAG = "TopBannerInfo";
  @notColumn
  public final List<rfu> dynamicItems = new ArrayList();
  @notColumn
  public final List<rft> items = new ArrayList();
  public byte[] itemsByte;
  public int mChannelId = -1;
  public String mCookie;
  @notColumn
  public rfw moreChannelItem;
  
  public void addDynamicItem(rfu paramrfu)
  {
    this.dynamicItems.add(paramrfu);
  }
  
  public void addItem(rft paramrft)
  {
    this.items.add(paramrft);
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
            localObject = rft.a((oidb_cmd0xbc9.BannerItem)localIterator.next());
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
    rfw localrfw;
    do
    {
      do
      {
        if ((localInvalidProtocolBufferMicroException.rpt_msg_dynamic_banner_list.has()) && (localInvalidProtocolBufferMicroException.rpt_msg_dynamic_banner_list.size() > 0))
        {
          localIterator = localInvalidProtocolBufferMicroException.rpt_msg_dynamic_banner_list.get().iterator();
          while (localIterator.hasNext())
          {
            localObject = rfu.a((oidb_cmd0xbc9.DynamicBannerItem)localIterator.next());
            if (localObject != null) {
              this.dynamicItems.addAll((Collection)localObject);
            }
          }
        }
      } while (!localInvalidProtocolBufferMicroException.msg_more_channel_item.has());
      localrfw = rfw.a((oidb_cmd0xbc9.MoreChannelItem)localInvalidProtocolBufferMicroException.msg_more_channel_item.get());
    } while (localrfw == null);
    this.moreChannelItem = localrfw;
  }
  
  public void prewrite()
  {
    if (!isBothEmpty())
    {
      oidb_cmd0xbc9.BannerRoundRspBody localBannerRoundRspBody = new oidb_cmd0xbc9.BannerRoundRspBody();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.items.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((rft)localIterator.next()).a());
      }
      localBannerRoundRspBody.rpt_msg_banner_list.addAll(localArrayList);
      localArrayList = new ArrayList();
      localIterator = this.dynamicItems.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((rfu)localIterator.next()).a());
      }
      if (this.moreChannelItem != null) {
        localBannerRoundRspBody.msg_more_channel_item.set(this.moreChannelItem.a());
      }
      localBannerRoundRspBody.rpt_msg_dynamic_banner_list.addAll(localArrayList);
      this.itemsByte = localBannerRoundRspBody.toByteArray();
    }
  }
  
  public void setMoreChannelItem(rfw paramrfw)
  {
    this.moreChannelItem = paramrfw;
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