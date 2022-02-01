package com.tencent.mobileqq.adapter;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.vas.AvatarInPendantHeadportraitInfo;
import java.util.ArrayList;
import java.util.List;

public class AvatarPendantAdapter$FaceGridAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int = 1;
  List<AvatarInPendantHeadportraitInfo> jdField_a_of_type_JavaUtilList;
  
  public AvatarPendantAdapter$FaceGridAdapter(AvatarPendantAdapter paramAvatarPendantAdapter) {}
  
  public void a(List<AvatarInPendantHeadportraitInfo> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  /* Error */
  public android.view.View getView(int paramInt, android.view.View paramView, android.view.ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 22	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7: ifnonnull +9 -> 16
    //   10: aload_2
    //   11: astore 5
    //   13: goto +560 -> 573
    //   16: aload_2
    //   17: ifnonnull +248 -> 265
    //   20: aload_2
    //   21: astore 5
    //   23: new 57	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 60	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:<init>	(Lcom/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter;)V
    //   31: astore 7
    //   33: aload_2
    //   34: astore 5
    //   36: aload_0
    //   37: getfield 13	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter	Lcom/tencent/mobileqq/adapter/AvatarPendantAdapter;
    //   40: getfield 65	com/tencent/mobileqq/adapter/AvatarPendantAdapter:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   43: invokestatic 71	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   46: ldc 72
    //   48: aload_3
    //   49: iconst_0
    //   50: invokevirtual 76	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   53: astore_2
    //   54: aload_2
    //   55: astore 5
    //   57: aload 7
    //   59: aload_2
    //   60: ldc 77
    //   62: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
    //   65: checkcast 85	android/widget/RelativeLayout
    //   68: putfield 88	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   71: aload_2
    //   72: astore 5
    //   74: aload 7
    //   76: aload_2
    //   77: ldc 89
    //   79: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
    //   82: checkcast 91	com/tencent/mobileqq/vas/avatar/VasAvatar
    //   85: putfield 94	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   88: aload_2
    //   89: astore 5
    //   91: aload 7
    //   93: aload_2
    //   94: ldc 95
    //   96: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
    //   99: checkcast 97	android/widget/ImageView
    //   102: putfield 100	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   105: aload_2
    //   106: astore 5
    //   108: aload 7
    //   110: aload_2
    //   111: ldc 101
    //   113: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
    //   116: checkcast 103	android/widget/TextView
    //   119: putfield 106	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   122: aload_2
    //   123: astore 5
    //   125: aload 7
    //   127: aload_2
    //   128: ldc 107
    //   130: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
    //   133: checkcast 97	android/widget/ImageView
    //   136: putfield 110	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:b	Landroid/widget/ImageView;
    //   139: aload_2
    //   140: astore 5
    //   142: aload 7
    //   144: getfield 88	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   147: invokevirtual 114	android/widget/RelativeLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   150: astore 6
    //   152: aload 6
    //   154: ifnull +36 -> 190
    //   157: aload_2
    //   158: astore 5
    //   160: aload 6
    //   162: aload_0
    //   163: getfield 13	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter	Lcom/tencent/mobileqq/adapter/AvatarPendantAdapter;
    //   166: getfield 117	com/tencent/mobileqq/adapter/AvatarPendantAdapter:h	I
    //   169: putfield 122	android/view/ViewGroup$LayoutParams:width	I
    //   172: aload_2
    //   173: astore 5
    //   175: aload 6
    //   177: aload_0
    //   178: getfield 13	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter	Lcom/tencent/mobileqq/adapter/AvatarPendantAdapter;
    //   181: getfield 117	com/tencent/mobileqq/adapter/AvatarPendantAdapter:h	I
    //   184: putfield 125	android/view/ViewGroup$LayoutParams:height	I
    //   187: goto +49 -> 236
    //   190: aload_2
    //   191: astore 5
    //   193: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +14 -> 210
    //   199: aload_2
    //   200: astore 5
    //   202: ldc 133
    //   204: iconst_2
    //   205: ldc 135
    //   207: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: aload_2
    //   211: astore 5
    //   213: new 119	android/view/ViewGroup$LayoutParams
    //   216: dup
    //   217: aload_0
    //   218: getfield 13	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter	Lcom/tencent/mobileqq/adapter/AvatarPendantAdapter;
    //   221: getfield 117	com/tencent/mobileqq/adapter/AvatarPendantAdapter:h	I
    //   224: aload_0
    //   225: getfield 13	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter	Lcom/tencent/mobileqq/adapter/AvatarPendantAdapter;
    //   228: getfield 142	com/tencent/mobileqq/adapter/AvatarPendantAdapter:i	I
    //   231: invokespecial 145	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   234: astore 6
    //   236: aload_2
    //   237: astore 5
    //   239: aload 7
    //   241: getfield 88	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   244: aload 6
    //   246: invokevirtual 149	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   249: aload_2
    //   250: astore 5
    //   252: aload_2
    //   253: aload 7
    //   255: invokevirtual 153	android/view/View:setTag	(Ljava/lang/Object;)V
    //   258: aload 7
    //   260: astore 6
    //   262: goto +15 -> 277
    //   265: aload_2
    //   266: astore 5
    //   268: aload_2
    //   269: invokevirtual 157	android/view/View:getTag	()Ljava/lang/Object;
    //   272: checkcast 57	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder
    //   275: astore 6
    //   277: aload_2
    //   278: astore 5
    //   280: aload_0
    //   281: iload_1
    //   282: invokevirtual 159	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:getItem	(I)Ljava/lang/Object;
    //   285: checkcast 161	com/tencent/mobileqq/vas/AvatarInPendantHeadportraitInfo
    //   288: astore 8
    //   290: aload_2
    //   291: astore 5
    //   293: aload 8
    //   295: ifnull +278 -> 573
    //   298: aload_2
    //   299: astore 5
    //   301: aload 6
    //   303: getfield 106	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   306: aload 8
    //   308: getfield 164	com/tencent/mobileqq/vas/AvatarInPendantHeadportraitInfo:b	Ljava/lang/String;
    //   311: invokevirtual 168	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   314: aload_2
    //   315: astore 5
    //   317: aload 8
    //   319: getfield 169	com/tencent/mobileqq/vas/AvatarInPendantHeadportraitInfo:jdField_a_of_type_Int	I
    //   322: istore 4
    //   324: aload_2
    //   325: astore 5
    //   327: aload 6
    //   329: getfield 94	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   332: invokevirtual 173	com/tencent/mobileqq/vas/avatar/VasAvatar:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   335: astore 7
    //   337: aload_2
    //   338: astore 5
    //   340: aload 7
    //   342: instanceof 175
    //   345: ifeq +250 -> 595
    //   348: aload_2
    //   349: astore 5
    //   351: aload 7
    //   353: checkcast 175	com/tencent/image/URLDrawable
    //   356: invokevirtual 178	com/tencent/image/URLDrawable:getCurrDrawable	()Landroid/graphics/drawable/Drawable;
    //   359: astore 7
    //   361: goto +3 -> 364
    //   364: aload_2
    //   365: astore 5
    //   367: new 180	com/tencent/mobileqq/vas/avatar/VasAvatarLoader
    //   370: dup
    //   371: iload 4
    //   373: bipush 7
    //   375: ldc 182
    //   377: iconst_1
    //   378: invokespecial 185	com/tencent/mobileqq/vas/avatar/VasAvatarLoader:<init>	(IILjava/lang/String;Z)V
    //   381: astore 9
    //   383: aload_2
    //   384: astore 5
    //   386: aload 9
    //   388: aload 7
    //   390: putfield 188	com/tencent/mobileqq/vas/avatar/VasAvatarLoader:a	Landroid/graphics/drawable/Drawable;
    //   393: aload_2
    //   394: astore 5
    //   396: aload 6
    //   398: getfield 94	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   401: aconst_null
    //   402: aload 9
    //   404: invokevirtual 192	com/tencent/mobileqq/vas/avatar/VasAvatar:setLoader	(Lcom/tencent/mobileqq/vas/avatar/AvatarLayout;Lcom/tencent/mobileqq/vas/avatar/VasAvatarLoader;)V
    //   407: aload_2
    //   408: astore 5
    //   410: aload 6
    //   412: getfield 88	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   415: aload 8
    //   417: invokevirtual 193	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   420: aload_2
    //   421: astore 5
    //   423: aload_0
    //   424: getfield 13	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter	Lcom/tencent/mobileqq/adapter/AvatarPendantAdapter;
    //   427: invokestatic 199	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   430: ldc 201
    //   432: iconst_0
    //   433: invokevirtual 205	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   436: putfield 208	com/tencent/mobileqq/adapter/AvatarPendantAdapter:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   439: aload_2
    //   440: astore 5
    //   442: aload_0
    //   443: getfield 13	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter	Lcom/tencent/mobileqq/adapter/AvatarPendantAdapter;
    //   446: aload_0
    //   447: getfield 13	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter	Lcom/tencent/mobileqq/adapter/AvatarPendantAdapter;
    //   450: getfield 208	com/tencent/mobileqq/adapter/AvatarPendantAdapter:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   453: ldc 210
    //   455: iconst_0
    //   456: invokeinterface 216 3 0
    //   461: putfield 219	com/tencent/mobileqq/adapter/AvatarPendantAdapter:o	I
    //   464: aload_2
    //   465: astore 5
    //   467: aload_0
    //   468: getfield 13	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter	Lcom/tencent/mobileqq/adapter/AvatarPendantAdapter;
    //   471: getfield 219	com/tencent/mobileqq/adapter/AvatarPendantAdapter:o	I
    //   474: aload 8
    //   476: getfield 169	com/tencent/mobileqq/vas/AvatarInPendantHeadportraitInfo:jdField_a_of_type_Int	I
    //   479: if_icmpne +28 -> 507
    //   482: aload_2
    //   483: astore 5
    //   485: aload_2
    //   486: aload_0
    //   487: getfield 13	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter	Lcom/tencent/mobileqq/adapter/AvatarPendantAdapter;
    //   490: getfield 65	com/tencent/mobileqq/adapter/AvatarPendantAdapter:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   493: invokevirtual 225	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   496: ldc 226
    //   498: invokevirtual 231	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   501: invokevirtual 235	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   504: goto +11 -> 515
    //   507: aload_2
    //   508: astore 5
    //   510: aload_2
    //   511: aconst_null
    //   512: invokevirtual 235	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   515: aload_2
    //   516: astore 5
    //   518: aload 8
    //   520: getfield 169	com/tencent/mobileqq/vas/AvatarInPendantHeadportraitInfo:jdField_a_of_type_Int	I
    //   523: aload_0
    //   524: getfield 13	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter	Lcom/tencent/mobileqq/adapter/AvatarPendantAdapter;
    //   527: getfield 238	com/tencent/mobileqq/adapter/AvatarPendantAdapter:n	I
    //   530: if_icmpne +21 -> 551
    //   533: aload_2
    //   534: astore 5
    //   536: aload 6
    //   538: getfield 100	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   541: iconst_0
    //   542: invokevirtual 242	android/widget/ImageView:setVisibility	(I)V
    //   545: aload_2
    //   546: astore 5
    //   548: goto +25 -> 573
    //   551: aload_2
    //   552: astore 5
    //   554: aload 6
    //   556: getfield 100	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter$GridFaceItemHolder:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   559: bipush 8
    //   561: invokevirtual 242	android/widget/ImageView:setVisibility	(I)V
    //   564: aload_2
    //   565: astore 5
    //   567: goto +6 -> 573
    //   570: astore_2
    //   571: aload_2
    //   572: athrow
    //   573: invokestatic 248	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   576: iload_1
    //   577: aload 5
    //   579: aload_3
    //   580: aload_0
    //   581: iload_1
    //   582: invokevirtual 250	com/tencent/mobileqq/adapter/AvatarPendantAdapter$FaceGridAdapter:getItemId	(I)J
    //   585: invokevirtual 254	com/tencent/qqlive/module/videoreport/collect/EventCollector:onListGetView	(ILandroid/view/View;Landroid/view/ViewGroup;J)V
    //   588: aload 5
    //   590: areturn
    //   591: astore_2
    //   592: goto -19 -> 573
    //   595: aconst_null
    //   596: astore 7
    //   598: goto -234 -> 364
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	this	FaceGridAdapter
    //   0	601	1	paramInt	int
    //   0	601	2	paramView	android.view.View
    //   0	601	3	paramViewGroup	android.view.ViewGroup
    //   322	50	4	i	int
    //   1	588	5	localView	android.view.View
    //   150	405	6	localObject1	Object
    //   31	566	7	localObject2	Object
    //   288	231	8	localAvatarInPendantHeadportraitInfo	AvatarInPendantHeadportraitInfo
    //   381	22	9	localVasAvatarLoader	com.tencent.mobileqq.vas.avatar.VasAvatarLoader
    // Exception table:
    //   from	to	target	type
    //   3	10	570	finally
    //   23	33	570	finally
    //   36	54	570	finally
    //   57	71	570	finally
    //   74	88	570	finally
    //   91	105	570	finally
    //   108	122	570	finally
    //   125	139	570	finally
    //   142	152	570	finally
    //   160	172	570	finally
    //   175	187	570	finally
    //   193	199	570	finally
    //   202	210	570	finally
    //   213	236	570	finally
    //   239	249	570	finally
    //   252	258	570	finally
    //   268	277	570	finally
    //   280	290	570	finally
    //   301	314	570	finally
    //   317	324	570	finally
    //   327	337	570	finally
    //   340	348	570	finally
    //   351	361	570	finally
    //   367	383	570	finally
    //   386	393	570	finally
    //   396	407	570	finally
    //   410	420	570	finally
    //   423	439	570	finally
    //   442	464	570	finally
    //   467	482	570	finally
    //   485	504	570	finally
    //   510	515	570	finally
    //   518	533	570	finally
    //   536	545	570	finally
    //   554	564	570	finally
    //   3	10	591	java/lang/Throwable
    //   23	33	591	java/lang/Throwable
    //   36	54	591	java/lang/Throwable
    //   57	71	591	java/lang/Throwable
    //   74	88	591	java/lang/Throwable
    //   91	105	591	java/lang/Throwable
    //   108	122	591	java/lang/Throwable
    //   125	139	591	java/lang/Throwable
    //   142	152	591	java/lang/Throwable
    //   160	172	591	java/lang/Throwable
    //   175	187	591	java/lang/Throwable
    //   193	199	591	java/lang/Throwable
    //   202	210	591	java/lang/Throwable
    //   213	236	591	java/lang/Throwable
    //   239	249	591	java/lang/Throwable
    //   252	258	591	java/lang/Throwable
    //   268	277	591	java/lang/Throwable
    //   280	290	591	java/lang/Throwable
    //   301	314	591	java/lang/Throwable
    //   317	324	591	java/lang/Throwable
    //   327	337	591	java/lang/Throwable
    //   340	348	591	java/lang/Throwable
    //   351	361	591	java/lang/Throwable
    //   367	383	591	java/lang/Throwable
    //   386	393	591	java/lang/Throwable
    //   396	407	591	java/lang/Throwable
    //   410	420	591	java/lang/Throwable
    //   423	439	591	java/lang/Throwable
    //   442	464	591	java/lang/Throwable
    //   467	482	591	java/lang/Throwable
    //   485	504	591	java/lang/Throwable
    //   510	515	591	java/lang/Throwable
    //   518	533	591	java/lang/Throwable
    //   536	545	591	java/lang/Throwable
    //   554	564	591	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AvatarPendantAdapter.FaceGridAdapter
 * JD-Core Version:    0.7.0.1
 */