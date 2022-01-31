package com.tencent.biz.pubaccount.readinjoy.struct;

import atmo;
import atnz;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import pro;
import prp;
import prr;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerRoundRspBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.DynamicBannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.MoreChannelItem;

public class TopBannerInfo
  extends atmo
{
  private static final String TAG = "TopBannerInfo";
  @atnz
  public final List<prp> dynamicItems = new ArrayList();
  @atnz
  public final List<pro> items = new ArrayList();
  public byte[] itemsByte;
  public int mChannelId = -1;
  public String mCookie;
  @atnz
  public prr moreChannelItem;
  
  public void addDynamicItem(prp paramprp)
  {
    this.dynamicItems.add(paramprp);
  }
  
  public void addItem(pro parampro)
  {
    this.items.add(parampro);
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
            localObject = pro.a((oidb_cmd0xbc9.BannerItem)localIterator.next());
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
    prr localprr;
    do
    {
      do
      {
        if ((localInvalidProtocolBufferMicroException.rpt_msg_dynamic_banner_list.has()) && (localInvalidProtocolBufferMicroException.rpt_msg_dynamic_banner_list.size() > 0))
        {
          localIterator = localInvalidProtocolBufferMicroException.rpt_msg_dynamic_banner_list.get().iterator();
          while (localIterator.hasNext())
          {
            localObject = prp.a((oidb_cmd0xbc9.DynamicBannerItem)localIterator.next());
            if (localObject != null) {
              this.dynamicItems.addAll((Collection)localObject);
            }
          }
        }
      } while (!localInvalidProtocolBufferMicroException.msg_more_channel_item.has());
      localprr = prr.a((oidb_cmd0xbc9.MoreChannelItem)localInvalidProtocolBufferMicroException.msg_more_channel_item.get());
    } while (localprr == null);
    this.moreChannelItem = localprr;
  }
  
  public void prewrite()
  {
    if (!isBothEmpty())
    {
      oidb_cmd0xbc9.BannerRoundRspBody localBannerRoundRspBody = new oidb_cmd0xbc9.BannerRoundRspBody();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.items.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((pro)localIterator.next()).a());
      }
      localBannerRoundRspBody.rpt_msg_banner_list.addAll(localArrayList);
      localArrayList = new ArrayList();
      localIterator = this.dynamicItems.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((prp)localIterator.next()).a());
      }
      if (this.moreChannelItem != null) {
        localBannerRoundRspBody.msg_more_channel_item.set(this.moreChannelItem.a());
      }
      localBannerRoundRspBody.rpt_msg_dynamic_banner_list.addAll(localArrayList);
      this.itemsByte = localBannerRoundRspBody.toByteArray();
    }
  }
  
  public void setMoreChannelItem(prr paramprr)
  {
    this.moreChannelItem = paramprr;
  }
  
  public String toString()
  {
    return "mCookie : " + this.mCookie + "  mChannelId: " + this.mChannelId + " items size: " + this.items.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo
 * JD-Core Version:    0.7.0.1
 */