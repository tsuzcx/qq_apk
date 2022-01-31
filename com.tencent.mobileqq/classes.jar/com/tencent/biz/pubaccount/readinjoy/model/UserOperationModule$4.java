package com.tencent.biz.pubaccount.readinjoy.model;

import aekt;
import android.content.Context;
import android.text.TextUtils;
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
import ors;
import phg;
import pvb;
import qhl;
import qhm;
import qhn;
import qho;
import qhq;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.ActiveZoneFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedExpInfo;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedScrollStateInfo;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedsCtxFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedsExpFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.GestureEvent;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.GestureFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.ReqBody;

public class UserOperationModule$4
  implements Runnable
{
  public UserOperationModule$4(phg paramphg, qhl paramqhl, Context paramContext) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject3;
    try
    {
      oidb_cmd0xde0.ReqBody localReqBody = new oidb_cmd0xde0.ReqBody();
      localObject1 = new oidb_cmd0xde0.ActiveZoneFeature();
      ((oidb_cmd0xde0.ActiveZoneFeature)localObject1).top.set(this.jdField_a_of_type_Qhl.jdField_a_of_type_ArrayOfInt[0]);
      ((oidb_cmd0xde0.ActiveZoneFeature)localObject1).bottom.set(this.jdField_a_of_type_Qhl.jdField_a_of_type_ArrayOfInt[1]);
      localReqBody.active_zone.set((MessageMicro)localObject1);
      localObject1 = new oidb_cmd0xde0.FeedsCtxFeature();
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_device_id.set(ors.f());
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_device_model.set(qhq.a());
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_enter_reason.set(this.jdField_a_of_type_Qhl.h);
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_headset.set(qhq.a(this.jdField_a_of_type_AndroidContentContext));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_lightness.set((float)qhq.a(this.jdField_a_of_type_AndroidContentContext));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_network_type.set(phg.a(this.this$0));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_power.set((float)qhq.a());
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_screen_info.set(qhq.a(this.jdField_a_of_type_AndroidContentContext));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_volume.set((float)qhq.b(this.jdField_a_of_type_AndroidContentContext));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).timestamp.set(System.currentTimeMillis() / 1000L);
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_scene.set(this.jdField_a_of_type_Qhl.jdField_b_of_type_Long);
      localReqBody.ctx_feature.set((MessageMicro)localObject1);
      localObject1 = new StringBuilder("UserActionCollector: ");
      localObject2 = new oidb_cmd0xde0.GestureFeature();
      localIterator = new ArrayList(this.jdField_a_of_type_Qhl.jdField_b_of_type_JavaUtilList).iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label581;
        }
        localObject4 = (qho)localIterator.next();
        ((StringBuilder)localObject1).append(localObject4 + "\n");
        localObject3 = new oidb_cmd0xde0.GestureEvent();
        if (TextUtils.isEmpty(((qho)localObject4).jdField_b_of_type_JavaLangString)) {
          break;
        }
        ((oidb_cmd0xde0.GestureEvent)localObject3).ges_click_point.set(((qho)localObject4).jdField_b_of_type_JavaLangString);
        ((oidb_cmd0xde0.GestureFeature)localObject2).gesture_event.add((MessageMicro)localObject3);
      }
      ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_direction.set(((qho)localObject4).jdField_a_of_type_Int);
    }
    catch (Exception localException)
    {
      aekt.a("UserOperationModule", "report exception!", localException);
      return;
    }
    ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_distance.set((float)((qho)localObject4).jdField_b_of_type_Long);
    ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_mills.set(((qho)localObject4).jdField_c_of_type_Long);
    ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_speed.set(((qho)localObject4).jdField_a_of_type_Float);
    if (!TextUtils.isEmpty(((qho)localObject4).jdField_a_of_type_JavaLangString)) {
      ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_downNup.set(((qho)localObject4).jdField_a_of_type_JavaLangString);
    }
    Object localObject4 = ((qho)localObject4).jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      qhn localqhn = (qhn)((Iterator)localObject4).next();
      oidb_cmd0xde0.FeedScrollStateInfo localFeedScrollStateInfo = new oidb_cmd0xde0.FeedScrollStateInfo();
      localFeedScrollStateInfo.enter_active_zone_speed.set((float)localqhn.jdField_a_of_type_Double);
      if (!TextUtils.isEmpty(localqhn.jdField_a_of_type_JavaLangString)) {
        localFeedScrollStateInfo.feeds_id.set(localqhn.jdField_a_of_type_JavaLangString);
      }
      localFeedScrollStateInfo.start_top.set(localqhn.jdField_b_of_type_Int);
      localFeedScrollStateInfo.start_bottom.set(localqhn.d);
      localFeedScrollStateInfo.stop_top.set(localqhn.jdField_c_of_type_Int);
      localFeedScrollStateInfo.stop_bottom.set(localqhn.e);
      ((oidb_cmd0xde0.GestureEvent)localObject3).get_scroll_feeds_info.add(localFeedScrollStateInfo);
    }
    label581:
    localException.usr_gesture_feature.set((MessageMicro)localObject2);
    Object localObject2 = new oidb_cmd0xde0.FeedsExpFeature();
    ((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_chnl_duration.set(this.jdField_a_of_type_Qhl.c());
    ((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_first_scrn_duration.set(this.jdField_a_of_type_Qhl.a());
    ((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_last_scrn_duration.set(this.jdField_a_of_type_Qhl.b());
    ((oidb_cmd0xde0.FeedsExpFeature)localObject2).is_user_active.set(this.jdField_a_of_type_Qhl.jdField_a_of_type_Boolean);
    Iterator localIterator = this.jdField_a_of_type_Qhl.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localObject3 = (qhm)localIterator.next();
      localObject4 = new oidb_cmd0xde0.FeedExpInfo();
      if (!TextUtils.isEmpty(((qhm)localObject3).jdField_a_of_type_JavaLangString)) {
        ((oidb_cmd0xde0.FeedExpInfo)localObject4).feeds_id.set(((qhm)localObject3).jdField_a_of_type_JavaLangString);
      }
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).exp_duration.set(((qhm)localObject3).jdField_b_of_type_Long);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).exp_duration_in_active_zone.set(((qhm)localObject3).jdField_c_of_type_Long);
      if (!TextUtils.isEmpty(((qhm)localObject3).jdField_c_of_type_JavaLangString)) {
        ((oidb_cmd0xde0.FeedExpInfo)localObject4).exp_orientation.set(((qhm)localObject3).jdField_c_of_type_JavaLangString);
      }
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).exp_pos_in_list.set(((qhm)localObject3).d);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).feed_card_height.set(((qhm)localObject3).jdField_c_of_type_Int);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).is_clicked.set(((qhm)localObject3).jdField_c_of_type_Boolean);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).is_first_scrn.set(((qhm)localObject3).jdField_a_of_type_Boolean);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).is_last_scrn.set(((qhm)localObject3).jdField_b_of_type_Boolean);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).style.set(((qhm)localObject3).jdField_a_of_type_Int);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).word_cnt_for_display.set(((qhm)localObject3).jdField_b_of_type_Int);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).read_duratiion.set(((qhm)localObject3).jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(((qhm)localObject3).jdField_b_of_type_JavaLangString)) {
        ((oidb_cmd0xde0.FeedExpInfo)localObject4).rec_reason.set(((qhm)localObject3).jdField_b_of_type_JavaLangString);
      }
      ((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_feeds.add((MessageMicro)localObject4);
    }
    localException.feeds_exp_feature.set((MessageMicro)localObject2);
    ((StringBuilder)localObject1).append("\nFeedsExpInfo : ").append("stayDuration : ").append(((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_chnl_duration.get()).append(", hasOpt : ").append(((oidb_cmd0xde0.FeedsExpFeature)localObject2).is_user_active.get()).append(", enter2Scroll : ").append(((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_first_scrn_duration.get()).append(", scroll2exit : ").append(((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_last_scrn_duration.get()).append(", ").append(this.jdField_a_of_type_Qhl.jdField_a_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, ((StringBuilder)localObject1).toString());
    }
    ToServiceMsg localToServiceMsg = pvb.a("OidbSvc.0xde0", 3552, 0, localException.toByteArray());
    this.this$0.a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.4
 * JD-Core Version:    0.7.0.1
 */