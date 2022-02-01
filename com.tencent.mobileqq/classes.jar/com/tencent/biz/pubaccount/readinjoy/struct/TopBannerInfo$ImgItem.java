package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.ContentBannerItem;

public class TopBannerInfo$ImgItem
  extends TopBannerInfo.BaseItem
{
  public String f;
  
  public TopBannerInfo$ImgItem(int paramInt)
  {
    super(paramInt);
  }
  
  public static TopBannerInfo.BaseItem b(oidb_cmd0xbc9.BannerItem paramBannerItem)
  {
    if (!paramBannerItem.msg_article_content_item.has()) {
      return null;
    }
    oidb_cmd0xbc9.ContentBannerItem localContentBannerItem = paramBannerItem.msg_article_content_item;
    if (paramBannerItem.uint32_banner_type.has()) {}
    for (ImgItem localImgItem = new ImgItem(paramBannerItem.uint32_banner_type.get());; localImgItem = new ImgItem(4))
    {
      if (localContentBannerItem.bytes_image_url.has()) {
        localImgItem.c = localContentBannerItem.bytes_image_url.get().toStringUtf8();
      }
      if (localContentBannerItem.bytes_link_url.has()) {
        localImgItem.f = localContentBannerItem.bytes_link_url.get().toStringUtf8();
      }
      if (localContentBannerItem.bytes_rowkey.has()) {
        localImgItem.e = localContentBannerItem.bytes_rowkey.get().toStringUtf8();
      }
      a(localImgItem, paramBannerItem);
      a(paramBannerItem, localImgItem);
      return localImgItem;
    }
  }
  
  public oidb_cmd0xbc9.BannerItem a()
  {
    oidb_cmd0xbc9.BannerItem localBannerItem = super.a();
    oidb_cmd0xbc9.ContentBannerItem localContentBannerItem = new oidb_cmd0xbc9.ContentBannerItem();
    if (!TextUtils.isEmpty(this.c)) {
      localContentBannerItem.bytes_image_url.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.f)) {
      localContentBannerItem.bytes_link_url.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    if (!TextUtils.isEmpty(this.e)) {
      localContentBannerItem.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    localBannerItem.msg_article_content_item.set(localContentBannerItem);
    return localBannerItem;
  }
  
  public String toString()
  {
    return " jump: " + this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.ImgItem
 * JD-Core Version:    0.7.0.1
 */