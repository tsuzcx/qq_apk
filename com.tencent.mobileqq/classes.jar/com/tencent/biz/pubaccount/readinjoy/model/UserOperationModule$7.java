package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pkh;
import qia;
import qxp;
import rjm;
import rjn;
import rjo;
import rjp;
import rjr;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.ActiveZoneFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedExpInfo;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedScrollStateInfo;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedsCtxFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedsExpFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.GestureEvent;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.GestureFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.ReqBody;

public class UserOperationModule$7
  implements Runnable
{
  public UserOperationModule$7(qia paramqia, rjm paramrjm, Context paramContext) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject3;
    try
    {
      oidb_cmd0xde0.ReqBody localReqBody = new oidb_cmd0xde0.ReqBody();
      localObject1 = new oidb_cmd0xde0.ActiveZoneFeature();
      ((oidb_cmd0xde0.ActiveZoneFeature)localObject1).top.set(this.jdField_a_of_type_Rjm.jdField_a_of_type_ArrayOfInt[0]);
      ((oidb_cmd0xde0.ActiveZoneFeature)localObject1).bottom.set(this.jdField_a_of_type_Rjm.jdField_a_of_type_ArrayOfInt[1]);
      localReqBody.active_zone.set((MessageMicro)localObject1);
      localObject1 = new oidb_cmd0xde0.FeedsCtxFeature();
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_device_id.set(pkh.b());
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_device_model.set(rjr.a());
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_enter_reason.set(this.jdField_a_of_type_Rjm.h);
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_headset.set(rjr.a(this.jdField_a_of_type_AndroidContentContext));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_lightness.set((float)rjr.a(this.jdField_a_of_type_AndroidContentContext));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_network_type.set(qia.a(this.this$0));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_power.set((float)rjr.a());
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_screen_info.set(rjr.a(this.jdField_a_of_type_AndroidContentContext));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_volume.set((float)rjr.b(this.jdField_a_of_type_AndroidContentContext));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).timestamp.set(System.currentTimeMillis() / 1000L);
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_scene.set(this.jdField_a_of_type_Rjm.jdField_b_of_type_Long);
      localReqBody.ctx_feature.set((MessageMicro)localObject1);
      localObject1 = new StringBuilder("UserActionCollector: ");
      localObject2 = new oidb_cmd0xde0.GestureFeature();
      localIterator = new ArrayList(this.jdField_a_of_type_Rjm.jdField_b_of_type_JavaUtilList).iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label581;
        }
        localObject4 = (rjp)localIterator.next();
        ((StringBuilder)localObject1).append(localObject4 + "\n");
        localObject3 = new oidb_cmd0xde0.GestureEvent();
        if (TextUtils.isEmpty(((rjp)localObject4).jdField_b_of_type_JavaLangString)) {
          break;
        }
        ((oidb_cmd0xde0.GestureEvent)localObject3).ges_click_point.set(((rjp)localObject4).jdField_b_of_type_JavaLangString);
        ((oidb_cmd0xde0.GestureFeature)localObject2).gesture_event.add((MessageMicro)localObject3);
      }
      ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_direction.set(((rjp)localObject4).jdField_a_of_type_Int);
    }
    catch (Exception localException)
    {
      AIOUtils.catchedExceptionInRelease("UserOperationModule", "report exception!", localException);
      return;
    }
    ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_distance.set((float)((rjp)localObject4).jdField_b_of_type_Long);
    ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_mills.set(((rjp)localObject4).jdField_c_of_type_Long);
    ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_speed.set(((rjp)localObject4).jdField_a_of_type_Float);
    if (!TextUtils.isEmpty(((rjp)localObject4).jdField_a_of_type_JavaLangString)) {
      ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_downNup.set(((rjp)localObject4).jdField_a_of_type_JavaLangString);
    }
    Object localObject4 = ((rjp)localObject4).jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      rjo localrjo = (rjo)((Iterator)localObject4).next();
      oidb_cmd0xde0.FeedScrollStateInfo localFeedScrollStateInfo = new oidb_cmd0xde0.FeedScrollStateInfo();
      localFeedScrollStateInfo.enter_active_zone_speed.set((float)localrjo.jdField_a_of_type_Double);
      if (!TextUtils.isEmpty(localrjo.jdField_a_of_type_JavaLangString)) {
        localFeedScrollStateInfo.feeds_id.set(localrjo.jdField_a_of_type_JavaLangString);
      }
      localFeedScrollStateInfo.start_top.set(localrjo.jdField_b_of_type_Int);
      localFeedScrollStateInfo.start_bottom.set(localrjo.d);
      localFeedScrollStateInfo.stop_top.set(localrjo.jdField_c_of_type_Int);
      localFeedScrollStateInfo.stop_bottom.set(localrjo.e);
      ((oidb_cmd0xde0.GestureEvent)localObject3).get_scroll_feeds_info.add(localFeedScrollStateInfo);
    }
    label581:
    localException.usr_gesture_feature.set((MessageMicro)localObject2);
    Object localObject2 = new oidb_cmd0xde0.FeedsExpFeature();
    ((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_chnl_duration.set(this.jdField_a_of_type_Rjm.c());
    ((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_first_scrn_duration.set(this.jdField_a_of_type_Rjm.a());
    ((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_last_scrn_duration.set(this.jdField_a_of_type_Rjm.b());
    ((oidb_cmd0xde0.FeedsExpFeature)localObject2).is_user_active.set(this.jdField_a_of_type_Rjm.jdField_a_of_type_Boolean);
    Iterator localIterator = this.jdField_a_of_type_Rjm.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localObject3 = (rjn)localIterator.next();
      localObject4 = new oidb_cmd0xde0.FeedExpInfo();
      if (!TextUtils.isEmpty(((rjn)localObject3).jdField_a_of_type_JavaLangString)) {
        ((oidb_cmd0xde0.FeedExpInfo)localObject4).feeds_id.set(((rjn)localObject3).jdField_a_of_type_JavaLangString);
      }
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).exp_duration.set(((rjn)localObject3).jdField_b_of_type_Long);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).exp_duration_in_active_zone.set(((rjn)localObject3).jdField_c_of_type_Long);
      if (!TextUtils.isEmpty(((rjn)localObject3).jdField_c_of_type_JavaLangString)) {
        ((oidb_cmd0xde0.FeedExpInfo)localObject4).exp_orientation.set(((rjn)localObject3).jdField_c_of_type_JavaLangString);
      }
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).exp_pos_in_list.set(((rjn)localObject3).d);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).feed_card_height.set(((rjn)localObject3).jdField_c_of_type_Int);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).is_clicked.set(((rjn)localObject3).jdField_c_of_type_Boolean);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).is_first_scrn.set(((rjn)localObject3).jdField_a_of_type_Boolean);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).is_last_scrn.set(((rjn)localObject3).jdField_b_of_type_Boolean);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).style.set(((rjn)localObject3).jdField_a_of_type_Int);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).word_cnt_for_display.set(((rjn)localObject3).jdField_b_of_type_Int);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).read_duratiion.set(((rjn)localObject3).jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(((rjn)localObject3).jdField_b_of_type_JavaLangString)) {
        ((oidb_cmd0xde0.FeedExpInfo)localObject4).rec_reason.set(((rjn)localObject3).jdField_b_of_type_JavaLangString);
      }
      ((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_feeds.add((MessageMicro)localObject4);
    }
    localException.feeds_exp_feature.set((MessageMicro)localObject2);
    ((StringBuilder)localObject1).append("\nFeedsExpInfo : ").append("stayDuration : ").append(((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_chnl_duration.get()).append(", hasOpt : ").append(((oidb_cmd0xde0.FeedsExpFeature)localObject2).is_user_active.get()).append(", enter2Scroll : ").append(((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_first_scrn_duration.get()).append(", scroll2exit : ").append(((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_last_scrn_duration.get()).append(", ").append(this.jdField_a_of_type_Rjm.jdField_a_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, ((StringBuilder)localObject1).toString());
    }
    ToServiceMsg localToServiceMsg = qxp.a("OidbSvc.0xde0", 3552, 0, localException.toByteArray());
    this.this$0.a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.7
 * JD-Core Version:    0.7.0.1
 */