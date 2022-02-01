package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import bgln;
import bmqa;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import pha;
import pwb;
import pxz;
import pyv;
import qnf;
import qnk;
import qnl;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.InnerMsg;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ReqBody;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ReqChannelPara;

public class VideoArticleModule$2
  implements Runnable
{
  public void run()
  {
    oidb_cmd0xbed.ReqChannelPara localReqChannelPara;
    Object localObject;
    for (;;)
    {
      try
      {
        oidb_cmd0xbed.ReqBody localReqBody = new oidb_cmd0xbed.ReqBody();
        localReqChannelPara = new oidb_cmd0xbed.ReqChannelPara();
        localReqChannelPara.uint32_channel_id.set(this.a.jdField_a_of_type_Int);
        localReqChannelPara.uint32_channel_type.set(this.a.jdField_b_of_type_Int);
        if (this.a.jdField_a_of_type_Long != -1L) {
          localReqChannelPara.uint64_begin_recommend_seq.set(this.a.jdField_a_of_type_Long);
        }
        if (this.a.jdField_b_of_type_Long != -1L) {
          localReqChannelPara.uint64_end_recommend_seq.set(this.a.jdField_b_of_type_Long);
        }
        if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
          localReqChannelPara.bytes_begin_recommend_rowkey.set(ByteStringMicro.copyFromUtf8(this.a.jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) {
          localReqChannelPara.bytes_end_recommend_rowkey.set(ByteStringMicro.copyFromUtf8(this.a.jdField_b_of_type_JavaLangString));
        }
        localReqChannelPara.uint64_begin_collection_id.set(this.a.jdField_c_of_type_Long);
        localReqChannelPara.uint64_end_collection_id.set(this.a.jdField_d_of_type_Long);
        localObject = bgln.a();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localReqChannelPara.bytes_device_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
        }
        localReqChannelPara.uint32_update_times.set(this.a.jdField_c_of_type_Int);
        localReqChannelPara.uint32_sim_type.set(bmqa.b());
        localReqChannelPara.uint32_network_type.set(pwb.b());
        if (this.a.jdField_a_of_type_ArrayOfByte != null) {
          localReqChannelPara.bytes_business_info.set(ByteStringMicro.copyFrom(this.a.jdField_a_of_type_ArrayOfByte));
        }
        if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label587;
        }
        localReqChannelPara.rpt_subscription_article_list.set(this.a.jdField_a_of_type_JavaUtilList);
        localObject = new ArrayList();
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Long localLong = (Long)localIterator.next();
        oidb_cmd0xbed.InnerMsg localInnerMsg = new oidb_cmd0xbed.InnerMsg();
        if (this.a.jdField_d_of_type_Int > 0)
        {
          localInnerMsg.uint32_jump_src_type.set(this.a.jdField_d_of_type_Int);
          localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(localLong)));
          if (!TextUtils.isEmpty(this.a.jdField_a_of_type_Qnl.c))
          {
            localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(this.a.jdField_a_of_type_Qnl.c));
            if (QLog.isColorLevel()) {
              QLog.d(pyv.jdField_a_of_type_JavaLangString, 2, "add push contenxt:" + this.a.jdField_a_of_type_Qnl.c);
            }
          }
          localInnerMsg.uint64_algorithm_id.set(this.a.jdField_a_of_type_Qnl.jdField_a_of_type_Long);
          localInnerMsg.uint32_strategy_id.set(this.a.jdField_a_of_type_Qnl.jdField_a_of_type_Int);
          ((List)localObject).add(localInnerMsg);
        }
        else
        {
          localInnerMsg.uint32_jump_src_type.set(1);
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e(pyv.jdField_a_of_type_JavaLangString, 2, "request0xbedSendWeiShiArticleInfoList makeParams:" + pha.a(localThrowable));
        }
        return;
      }
    }
    localReqChannelPara.rpt_inner_msg_list.set((List)localObject);
    label587:
    localThrowable.reqChannelPara.set(localReqChannelPara);
    ToServiceMsg localToServiceMsg = qnf.a("OidbSvc.0xbed", 3053, 1, localThrowable.toByteArray());
    if (localToServiceMsg != null)
    {
      localToServiceMsg.getAttributes().put("channelID", Integer.valueOf(this.a.jdField_a_of_type_Int));
      localToServiceMsg.getAttributes().put(pxz.d, Long.valueOf(this.a.jdField_a_of_type_Long));
      localToServiceMsg.getAttributes().put(pxz.e, Long.valueOf(this.a.jdField_b_of_type_Long));
      localToServiceMsg.getAttributes().put("CountOfRequest_0xbed", Integer.valueOf(1));
    }
    this.this$0.a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.VideoArticleModule.2
 * JD-Core Version:    0.7.0.1
 */