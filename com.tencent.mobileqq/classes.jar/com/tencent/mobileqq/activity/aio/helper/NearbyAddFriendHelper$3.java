package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import nearby.nearbyLivebarSvr.nearbyLivebarSvr.GetLiveBarStatusRequest;

class NearbyAddFriendHelper$3
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyAddFriendHelper$3(NearbyAddFriendHelper paramNearbyAddFriendHelper, GetLiveBarStatusRequest paramGetLiveBarStatusRequest) {}
  
  /* Error */
  public void onResult(int paramInt, byte[] paramArrayOfByte, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 11	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3:jdField_a_of_type_ComTencentMobileqqActivityAioHelperNearbyAddFriendHelper	Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;
    //   4: invokestatic 28	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper:a	(Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;)Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: iload_1
    //   12: ifeq +4 -> 16
    //   15: return
    //   16: new 30	nearby/nearbyLivebarSvr/nearbyLivebarSvr/GetLiveBarStatusResponse
    //   19: dup
    //   20: invokespecial 31	nearby/nearbyLivebarSvr/nearbyLivebarSvr/GetLiveBarStatusResponse:<init>	()V
    //   23: aload_2
    //   24: invokestatic 35	nearby/nearbyLivebarSvr/nearbyLivebarSvr/GetLiveBarStatusResponse:mergeFrom	(Lcom/tencent/mobileqq/pb/MessageMicro;[B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: checkcast 30	nearby/nearbyLivebarSvr/nearbyLivebarSvr/GetLiveBarStatusResponse
    //   30: astore_2
    //   31: aload_2
    //   32: getfield 39	nearby/nearbyLivebarSvr/nearbyLivebarSvr/GetLiveBarStatusResponse:ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   35: invokevirtual 45	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   38: ifeq +4 -> 42
    //   41: return
    //   42: aload_2
    //   43: getfield 49	nearby/nearbyLivebarSvr/nearbyLivebarSvr/GetLiveBarStatusResponse:anchor_info	Lnearby/nearbyLivebarSvr/nearbyLivebarSvr/AnchorInfo;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +78 -> 126
    //   51: aload_0
    //   52: getfield 13	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3:jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrGetLiveBarStatusRequest	Lnearby/nearbyLivebarSvr/nearbyLivebarSvr/GetLiveBarStatusRequest;
    //   55: getfield 55	nearby/nearbyLivebarSvr/nearbyLivebarSvr/GetLiveBarStatusRequest:need_anchorInfo	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   58: invokevirtual 58	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   61: ifeq +65 -> 126
    //   64: aload_0
    //   65: getfield 11	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3:jdField_a_of_type_ComTencentMobileqqActivityAioHelperNearbyAddFriendHelper	Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;
    //   68: aload_3
    //   69: getfield 64	nearby/nearbyLivebarSvr/nearbyLivebarSvr/AnchorInfo:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   72: invokevirtual 69	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   75: invokestatic 72	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper:a	(Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;Ljava/lang/String;)Ljava/lang/String;
    //   78: pop
    //   79: aload_0
    //   80: getfield 11	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3:jdField_a_of_type_ComTencentMobileqqActivityAioHelperNearbyAddFriendHelper	Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;
    //   83: invokestatic 75	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper:a	(Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;)Ljava/lang/String;
    //   86: invokestatic 81	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   89: astore 4
    //   91: aload_0
    //   92: getfield 11	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3:jdField_a_of_type_ComTencentMobileqqActivityAioHelperNearbyAddFriendHelper	Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;
    //   95: aload 4
    //   97: ldc 83
    //   99: invokevirtual 87	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   102: invokestatic 90	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper:b	(Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;Ljava/lang/String;)Ljava/lang/String;
    //   105: pop
    //   106: aload_0
    //   107: getfield 11	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3:jdField_a_of_type_ComTencentMobileqqActivityAioHelperNearbyAddFriendHelper	Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;
    //   110: aload_3
    //   111: invokestatic 93	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper:a	(Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;Lnearby/nearbyLivebarSvr/nearbyLivebarSvr/AnchorInfo;)Lnearby/nearbyLivebarSvr/nearbyLivebarSvr/AnchorInfo;
    //   114: pop
    //   115: aload_0
    //   116: getfield 13	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3:jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrGetLiveBarStatusRequest	Lnearby/nearbyLivebarSvr/nearbyLivebarSvr/GetLiveBarStatusRequest;
    //   119: getfield 55	nearby/nearbyLivebarSvr/nearbyLivebarSvr/GetLiveBarStatusRequest:need_anchorInfo	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   122: iconst_0
    //   123: invokevirtual 97	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   126: aload_2
    //   127: getfield 100	nearby/nearbyLivebarSvr/nearbyLivebarSvr/GetLiveBarStatusResponse:display_livebar	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   130: invokevirtual 45	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   133: ifne +13 -> 146
    //   136: aload_0
    //   137: getfield 11	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3:jdField_a_of_type_ComTencentMobileqqActivityAioHelperNearbyAddFriendHelper	Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;
    //   140: invokestatic 103	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper:a	(Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;)V
    //   143: goto +40 -> 183
    //   146: aload_0
    //   147: getfield 11	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3:jdField_a_of_type_ComTencentMobileqqActivityAioHelperNearbyAddFriendHelper	Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;
    //   150: invokestatic 106	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper:a	(Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;)Landroid/view/View;
    //   153: ifnull +16 -> 169
    //   156: aload_0
    //   157: getfield 11	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3:jdField_a_of_type_ComTencentMobileqqActivityAioHelperNearbyAddFriendHelper	Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;
    //   160: invokestatic 106	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper:a	(Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;)Landroid/view/View;
    //   163: invokevirtual 111	android/view/View:getVisibility	()I
    //   166: ifeq +17 -> 183
    //   169: aload_0
    //   170: getfield 11	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3:jdField_a_of_type_ComTencentMobileqqActivityAioHelperNearbyAddFriendHelper	Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;
    //   173: invokestatic 113	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper:b	(Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;)V
    //   176: aload_0
    //   177: getfield 11	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3:jdField_a_of_type_ComTencentMobileqqActivityAioHelperNearbyAddFriendHelper	Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;
    //   180: invokestatic 116	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper:c	(Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper;)V
    //   183: aload_2
    //   184: getfield 119	nearby/nearbyLivebarSvr/nearbyLivebarSvr/GetLiveBarStatusResponse:need_livebar	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   187: invokevirtual 45	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   190: ifne +4 -> 194
    //   193: return
    //   194: invokestatic 125	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   197: new 127	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3$1
    //   200: dup
    //   201: aload_0
    //   202: invokespecial 130	com/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3$1:<init>	(Lcom/tencent/mobileqq/activity/aio/helper/NearbyAddFriendHelper$3;)V
    //   205: sipush 5000
    //   208: aload_2
    //   209: getfield 133	nearby/nearbyLivebarSvr/nearbyLivebarSvr/GetLiveBarStatusResponse:time_threshold	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   212: invokevirtual 58	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   215: sipush 1000
    //   218: imul
    //   219: invokestatic 139	java/lang/Math:max	(II)I
    //   222: i2l
    //   223: invokevirtual 145	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   226: pop
    //   227: return
    //   228: astore_2
    //   229: return
    //   230: astore 4
    //   232: goto -126 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	3
    //   0	235	1	paramInt	int
    //   0	235	2	paramArrayOfByte	byte[]
    //   0	235	3	paramBundle	android.os.Bundle
    //   89	7	4	localUri	android.net.Uri
    //   230	1	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   16	31	228	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   79	106	230	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearbyAddFriendHelper.3
 * JD-Core Version:    0.7.0.1
 */