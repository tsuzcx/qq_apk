package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiVideoColumnInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.RspBody;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.SubscribeVideoColumnRsp;

class ColumnTwoVideoProteusItem$ColumnSubscriptionCallback
  extends ProtoUtils.TroopProtocolObserver
{
  private int jdField_a_of_type_Int;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  ColumnTwoVideoProteusItem$ColumnSubscriptionCallback(ArticleInfo paramArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    boolean bool = true;
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.multiVideoColumnInfo.d;
    MultiVideoColumnInfo localMultiVideoColumnInfo;
    if (this.jdField_a_of_type_Int == 1)
    {
      i += 1;
      localMultiVideoColumnInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.multiVideoColumnInfo;
      if (this.jdField_a_of_type_Int != 1) {
        break label80;
      }
    }
    for (;;)
    {
      localMultiVideoColumnInfo.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.multiVideoColumnInfo.d = i;
      ThreadManager.getUIHandler().post(new ColumnTwoVideoProteusItem.ColumnSubscriptionCallback.1(this));
      return;
      i -= 1;
      break;
      label80:
      bool = false;
    }
  }
  
  private void a(byte[] paramArrayOfByte, Bundle paramBundle)
  {
    oidb_0xd4b.RspBody localRspBody = new oidb_0xd4b.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      int i = ((oidb_0xd4b.SubscribeVideoColumnRsp)((oidb_0xd4b.RspBody)localRspBody.get()).msg_subscribe_video_column_rsp.get()).uint32_guide_type.get();
      QLog.i("ColumnTwoVideoProteusItem", 1, "ColumnSubscriptionCallback " + i);
      ThreadManager.getUIHandler().post(new ColumnTwoVideoProteusItem.ColumnSubscriptionCallback.2(this, paramBundle, i));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e("ColumnTwoVideoProteusItem", 1, paramArrayOfByte.toString());
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      a();
      a(paramArrayOfByte, paramBundle);
      return;
    }
    QLog.e("ColumnTwoVideoProteusItem", 1, "ColumnTwoVideoProteusItem subscribe column fail. columnId:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.multiVideoColumnInfo.jdField_a_of_type_Int + " subscribeAction:" + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.ColumnTwoVideoProteusItem.ColumnSubscriptionCallback
 * JD-Core Version:    0.7.0.1
 */