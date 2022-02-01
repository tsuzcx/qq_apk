package com.tencent.biz.pubaccount.readinjoy.logic;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.CheckFavoriteRspBody;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.CheckFavoriteRspItem;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.RspBody;

class ReadInJoyAtlasManager$6
  extends ProtoUtils.AppProtocolObserver
{
  ReadInJoyAtlasManager$6(ReadInJoyAtlasManager paramReadInJoyAtlasManager, ReadInJoyAtlasManager.AtlasCallback paramAtlasCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyAtlasManager.a, 2, "getAtlasFavoriteStatus onResult, errorCode=" + paramInt);
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        paramBundle = new oidb_0xb40.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((oidb_0xb40.CheckFavoriteRspBody)paramBundle.msg_check_favorite_rsp.get()).rpt_msg_rsp_items.get().iterator();
        if (paramArrayOfByte.hasNext())
        {
          Object localObject = (oidb_0xb40.CheckFavoriteRspItem)paramArrayOfByte.next();
          paramBundle = ((oidb_0xb40.CheckFavoriteRspItem)localObject).bytes_rowkey.get().toStringUtf8();
          if (((oidb_0xb40.CheckFavoriteRspItem)localObject).uint32_result.get() == 1)
          {
            bool = true;
            localArrayList = new ArrayList();
            if (!bool) {
              break label242;
            }
            localObject = ((oidb_0xb40.CheckFavoriteRspItem)localObject).bytes_cid_list.get().iterator();
            if (!((Iterator)localObject).hasNext()) {
              break label242;
            }
            localArrayList.add(((ByteStringMicro)((Iterator)localObject).next()).toStringUtf8());
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(false, null, false, null);
        }
        QLog.e(ReadInJoyAtlasManager.a, 1, "getAtlasFavoriteStatus onResult(), exception=" + paramArrayOfByte.toString());
      }
      boolean bool = false;
      continue;
      label242:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(true, paramBundle, bool, localArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.6
 * JD-Core Version:    0.7.0.1
 */