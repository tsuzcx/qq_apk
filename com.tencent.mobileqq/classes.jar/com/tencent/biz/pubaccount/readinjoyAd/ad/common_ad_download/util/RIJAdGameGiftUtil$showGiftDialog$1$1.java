package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.content.Context;
import com.tencent.util.Pair;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJAdGameGiftUtil$showGiftDialog$1$1
  implements Runnable
{
  RIJAdGameGiftUtil$showGiftDialog$1$1(RIJAdGameGiftUtil.showGiftDialog.1 param1, Context paramContext, int paramInt, Pair paramPair, Ref.ObjectRef paramObjectRef) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4: checkcast 47	android/app/Activity
    //   7: invokevirtual 51	android/app/Activity:isFinishing	()Z
    //   10: ifne +333 -> 343
    //   13: aload_0
    //   14: getfield 31	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1:this$0	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1;
    //   17: getfield 56	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1:jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;
    //   20: invokevirtual 61	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView:a	()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;
    //   23: ifnull +45 -> 68
    //   26: aload_0
    //   27: getfield 31	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1:this$0	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1;
    //   30: getfield 56	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1:jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;
    //   33: invokevirtual 61	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView:a	()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnull +30 -> 68
    //   41: aload_1
    //   42: invokevirtual 66	com/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog:isShowing	()Z
    //   45: iconst_1
    //   46: if_icmpne +22 -> 68
    //   49: aload_0
    //   50: getfield 31	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1:this$0	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1;
    //   53: getfield 56	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1:jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;
    //   56: invokevirtual 61	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView:a	()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 69	com/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog:dismiss	()V
    //   68: new 63	com/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog
    //   71: dup
    //   72: aload_0
    //   73: getfield 31	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1:this$0	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1;
    //   76: getfield 70	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   79: aload_0
    //   80: getfield 35	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1:jdField_a_of_type_Int	I
    //   83: invokespecial 73	com/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog:<init>	(Landroid/content/Context;I)V
    //   86: astore 6
    //   88: aload_0
    //   89: getfield 31	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1:this$0	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1;
    //   92: getfield 56	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1:jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;
    //   95: aload 6
    //   97: invokevirtual 77	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView:setDialog	(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;)V
    //   100: aload 6
    //   102: aload_0
    //   103: getfield 31	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1:this$0	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1;
    //   106: getfield 80	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   109: invokevirtual 83	com/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   112: aload 6
    //   114: iconst_1
    //   115: invokevirtual 86	com/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog:a	(Z)V
    //   118: aload_0
    //   119: getfield 31	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1:this$0	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1;
    //   122: getfield 80	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   125: getfield 92	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:gameAdComData	Lcom/tencent/biz/pubaccount/readinjoy/video/playfeeds/GameAdComData;
    //   128: astore_1
    //   129: aload_1
    //   130: ifnull +214 -> 344
    //   133: aload_1
    //   134: getfield 98	com/tencent/biz/pubaccount/readinjoy/video/playfeeds/GameAdComData:u	Ljava/lang/String;
    //   137: astore_1
    //   138: aload_1
    //   139: ifnull +205 -> 344
    //   142: goto +3 -> 145
    //   145: new 100	org/json/JSONObject
    //   148: dup
    //   149: aload_1
    //   150: invokespecial 103	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   153: astore_3
    //   154: aload_3
    //   155: ldc 105
    //   157: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   160: astore_2
    //   161: aload_2
    //   162: ldc 111
    //   164: invokestatic 117	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   167: aload_3
    //   168: ldc 119
    //   170: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   173: astore_1
    //   174: aload_1
    //   175: ldc 121
    //   177: invokestatic 117	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   180: aload_3
    //   181: ldc 123
    //   183: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore_3
    //   187: aload_3
    //   188: ldc 125
    //   190: invokestatic 117	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   193: goto +27 -> 220
    //   196: astore_3
    //   197: goto +16 -> 213
    //   200: astore_3
    //   201: ldc 126
    //   203: astore_1
    //   204: goto +9 -> 213
    //   207: astore_3
    //   208: ldc 126
    //   210: astore_2
    //   211: aload_2
    //   212: astore_1
    //   213: aload_3
    //   214: invokevirtual 129	java/lang/Exception:printStackTrace	()V
    //   217: ldc 126
    //   219: astore_3
    //   220: aload_0
    //   221: getfield 37	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1:jdField_a_of_type_ComTencentUtilPair	Lcom/tencent/util/Pair;
    //   224: getfield 135	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   227: checkcast 137	java/util/List
    //   230: astore 7
    //   232: aload_0
    //   233: getfield 37	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1:jdField_a_of_type_ComTencentUtilPair	Lcom/tencent/util/Pair;
    //   236: getfield 140	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   239: checkcast 137	java/util/List
    //   242: astore 8
    //   244: aload_0
    //   245: getfield 31	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1:this$0	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1;
    //   248: getfield 80	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   251: getfield 92	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:gameAdComData	Lcom/tencent/biz/pubaccount/readinjoy/video/playfeeds/GameAdComData;
    //   254: astore 4
    //   256: aload 4
    //   258: ifnull +13 -> 271
    //   261: aload 4
    //   263: getfield 143	com/tencent/biz/pubaccount/readinjoy/video/playfeeds/GameAdComData:d	Ljava/lang/String;
    //   266: astore 4
    //   268: goto +6 -> 274
    //   271: aconst_null
    //   272: astore 4
    //   274: aload_0
    //   275: getfield 31	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1:this$0	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1;
    //   278: getfield 80	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   281: getfield 92	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:gameAdComData	Lcom/tencent/biz/pubaccount/readinjoy/video/playfeeds/GameAdComData;
    //   284: astore 5
    //   286: aload 5
    //   288: ifnull +13 -> 301
    //   291: aload 5
    //   293: getfield 146	com/tencent/biz/pubaccount/readinjoy/video/playfeeds/GameAdComData:g	Ljava/lang/String;
    //   296: astore 5
    //   298: goto +6 -> 304
    //   301: aconst_null
    //   302: astore 5
    //   304: aload 6
    //   306: aload 7
    //   308: aload 8
    //   310: aload 4
    //   312: aload_2
    //   313: aload_1
    //   314: aload 5
    //   316: aload_3
    //   317: invokevirtual 149	com/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog:a	(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload 6
    //   322: new 151	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1$1
    //   325: dup
    //   326: aload_0
    //   327: aload 6
    //   329: invokespecial 154	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1$1:<init>	(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil$showGiftDialog$1$1;Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;)V
    //   332: checkcast 156	com/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageListener
    //   335: invokevirtual 159	com/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog:a	(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageListener;)V
    //   338: aload 6
    //   340: invokevirtual 162	com/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog:show	()V
    //   343: return
    //   344: ldc 126
    //   346: astore_1
    //   347: goto -202 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	1
    //   36	311	1	localObject1	Object
    //   160	153	2	str1	java.lang.String
    //   153	35	3	localObject2	Object
    //   196	1	3	localException1	java.lang.Exception
    //   200	1	3	localException2	java.lang.Exception
    //   207	7	3	localException3	java.lang.Exception
    //   219	98	3	str2	java.lang.String
    //   254	57	4	localObject3	Object
    //   284	31	5	localObject4	Object
    //   86	253	6	localGiftPackageDialog	com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog
    //   230	77	7	localList1	java.util.List
    //   242	67	8	localList2	java.util.List
    // Exception table:
    //   from	to	target	type
    //   180	193	196	java/lang/Exception
    //   167	180	200	java/lang/Exception
    //   118	129	207	java/lang/Exception
    //   133	138	207	java/lang/Exception
    //   145	167	207	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdGameGiftUtil.showGiftDialog.1.1
 * JD-Core Version:    0.7.0.1
 */