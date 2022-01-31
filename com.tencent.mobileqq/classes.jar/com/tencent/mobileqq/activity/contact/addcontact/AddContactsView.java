package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.adapter.MayKnowAdapter;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.ConditionSearchManager.IFirstLocationReqCancelListener;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wea;
import web;
import wec;
import wee;
import wef;

public class AddContactsView
  extends ContactBaseView
  implements View.OnClickListener
{
  private MayKnowAdapter jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new wea(this);
  ConditionSearchManager.IFirstLocationReqCancelListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener = new web(this);
  public ConditionSearchManager a;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new wee(this);
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  public FormMutiItem a;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private String jdField_a_of_type_JavaLangString = "PhoneContactRecommendNames";
  private List jdField_a_of_type_JavaUtilList = new ArrayList(3);
  public boolean a;
  public String[] a;
  public FormMutiItem b;
  public boolean b;
  private String[] b;
  FormMutiItem c;
  FormMutiItem d;
  FormMutiItem e;
  
  public AddContactsView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
  }
  
  private FormMutiItem a(int paramInt1, int paramInt2, int paramInt3)
  {
    FormMutiItem localFormMutiItem = new FormMutiItem(this.jdField_a_of_type_AndroidAppActivity);
    localFormMutiItem.setId(paramInt1);
    localFormMutiItem.setClickable(true);
    localFormMutiItem.setFocusable(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    if (paramInt3 == 0) {
      localLayoutParams.topMargin = ((int)(DeviceInfoUtil.a() * 20.0F));
    }
    if ((paramInt2 == this.jdField_b_of_type_ArrayOfJavaLangString.length - 1) && (paramInt3 == this.jdField_b_of_type_ArrayOfJavaLangString[paramInt2].length() - 1)) {
      localLayoutParams.bottomMargin = ((int)(DeviceInfoUtil.a() * 20.0F));
    }
    localFormMutiItem.setLayoutParams(localLayoutParams);
    return localFormMutiItem;
  }
  
  private String a(List paramList)
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    StringBuffer localStringBuffer = new StringBuffer(100);
    int i = 0;
    while (i < paramList.size())
    {
      PhoneContact localPhoneContact = localPhoneContactManager.b((String)paramList.get(i));
      if (localPhoneContact != null)
      {
        localStringBuffer.append(localPhoneContact.name);
        localStringBuffer.append("、");
      }
      i += 1;
    }
    if (localStringBuffer.length() > 1) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    return localStringBuffer.toString();
  }
  
  private List a()
  {
    Object localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    List localList = b();
    if (localList.size() < 3)
    {
      localObject = ((PhoneContactManager)localObject).e();
      if ((localObject != null) && (((List)localObject).size() > 1))
      {
        localObject = (List)((List)localObject).get(0);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          int i = 0;
          while ((i < ((List)localObject).size()) && (localList.size() < 3))
          {
            PhoneContact localPhoneContact = (PhoneContact)((List)localObject).get(i);
            if ((localPhoneContact != null) && (localPhoneContact.uin != null) && (localPhoneContact.uin.equals("0")) && (!localFriendsManager.c(localPhoneContact.nationCode + localPhoneContact.mobileCode)) && (!localList.contains(localPhoneContact.mobileNo))) {
              localList.add(localPhoneContact.mobileNo);
            }
            i += 1;
          }
        }
      }
    }
    return localList;
  }
  
  /* Error */
  private List b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 120	com/tencent/mobileqq/activity/contact/addcontact/AddContactsView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: bipush 10
    //   6: invokevirtual 126	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9: checkcast 128	com/tencent/mobileqq/model/PhoneContactManager
    //   12: astore 13
    //   14: aload_0
    //   15: getfield 120	com/tencent/mobileqq/activity/contact/addcontact/AddContactsView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: bipush 50
    //   20: invokevirtual 126	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   23: checkcast 166	com/tencent/mobileqq/app/FriendsManager
    //   26: astore 14
    //   28: new 57	java/util/ArrayList
    //   31: dup
    //   32: iconst_3
    //   33: invokespecial 60	java/util/ArrayList:<init>	(I)V
    //   36: astore 12
    //   38: aload_0
    //   39: getfield 120	com/tencent/mobileqq/activity/contact/addcontact/AddContactsView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: invokevirtual 218	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   45: invokevirtual 224	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   48: getstatic 230	android/provider/CallLog$Calls:CONTENT_URI	Landroid/net/Uri;
    //   51: iconst_2
    //   52: anewarray 101	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: ldc 232
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: ldc 234
    //   64: aastore
    //   65: aconst_null
    //   66: aconst_null
    //   67: ldc 236
    //   69: invokevirtual 242	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore 8
    //   74: aload 8
    //   76: invokeinterface 247 1 0
    //   81: istore 6
    //   83: new 249	java/util/HashSet
    //   86: dup
    //   87: iconst_4
    //   88: invokespecial 250	java/util/HashSet:<init>	(I)V
    //   91: astore 15
    //   93: iconst_0
    //   94: istore 4
    //   96: iconst_0
    //   97: istore_3
    //   98: iconst_0
    //   99: istore_2
    //   100: iconst_0
    //   101: istore_1
    //   102: aload 8
    //   104: invokeinterface 254 1 0
    //   109: ifeq +241 -> 350
    //   112: aload 8
    //   114: aload 8
    //   116: ldc 232
    //   118: invokeinterface 258 2 0
    //   123: invokeinterface 262 2 0
    //   128: invokestatic 267	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 10
    //   133: aload 10
    //   135: ldc_w 269
    //   138: invokevirtual 272	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   141: ifeq +165 -> 306
    //   144: aload 10
    //   146: iconst_3
    //   147: invokevirtual 275	java/lang/String:substring	(I)Ljava/lang/String;
    //   150: astore 9
    //   152: aload 15
    //   154: aload 10
    //   156: invokevirtual 276	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   159: ifne -57 -> 102
    //   162: aload 15
    //   164: aload 9
    //   166: invokevirtual 276	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   169: ifne -67 -> 102
    //   172: aload 15
    //   174: aload 10
    //   176: invokevirtual 277	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   179: pop
    //   180: aload 15
    //   182: aload 9
    //   184: invokevirtual 277	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   187: pop
    //   188: aload 13
    //   190: aload 10
    //   192: invokeinterface 143 2 0
    //   197: astore 11
    //   199: aload 11
    //   201: astore 10
    //   203: aload 11
    //   205: ifnonnull +14 -> 219
    //   208: aload 13
    //   210: aload 9
    //   212: invokeinterface 143 2 0
    //   217: astore 10
    //   219: aload 10
    //   221: ifnull +577 -> 798
    //   224: ldc 175
    //   226: aload 10
    //   228: getfield 173	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   231: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +98 -> 332
    //   237: iload_1
    //   238: iconst_1
    //   239: iadd
    //   240: istore_1
    //   241: aload 14
    //   243: new 181	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   250: aload 10
    //   252: getfield 187	com/tencent/mobileqq/data/PhoneContact:nationCode	Ljava/lang/String;
    //   255: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload 10
    //   260: getfield 193	com/tencent/mobileqq/data/PhoneContact:mobileCode	Ljava/lang/String;
    //   263: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokevirtual 197	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Z
    //   272: ifne +516 -> 788
    //   275: aload 12
    //   277: aload 10
    //   279: getfield 200	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   282: invokeinterface 203 2 0
    //   287: ifne +501 -> 788
    //   290: aload 12
    //   292: aload 10
    //   294: getfield 200	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   297: invokeinterface 206 2 0
    //   302: pop
    //   303: goto -201 -> 102
    //   306: new 181	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   313: ldc_w 269
    //   316: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload 10
    //   321: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: astore 9
    //   329: goto -177 -> 152
    //   332: aload 10
    //   334: getfield 173	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   337: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   340: ifne +451 -> 791
    //   343: iload_3
    //   344: iconst_1
    //   345: iadd
    //   346: istore_3
    //   347: goto -245 -> 102
    //   350: new 285	java/util/HashMap
    //   353: dup
    //   354: invokespecial 286	java/util/HashMap:<init>	()V
    //   357: astore 9
    //   359: aload 9
    //   361: ldc_w 288
    //   364: aload 15
    //   366: invokevirtual 289	java/util/HashSet:size	()I
    //   369: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   372: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   375: pop
    //   376: aload 9
    //   378: ldc_w 298
    //   381: iload 6
    //   383: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   386: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   389: pop
    //   390: aload 9
    //   392: ldc_w 300
    //   395: iload_3
    //   396: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   399: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   402: pop
    //   403: aload 9
    //   405: ldc_w 302
    //   408: iload_1
    //   409: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   412: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   415: pop
    //   416: aload 9
    //   418: ldc_w 304
    //   421: iload_2
    //   422: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   425: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   428: pop
    //   429: aload 9
    //   431: ldc_w 306
    //   434: iload 4
    //   436: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   439: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   442: pop
    //   443: aload 13
    //   445: invokeinterface 170 1 0
    //   450: astore 10
    //   452: iconst_0
    //   453: istore_2
    //   454: iconst_0
    //   455: istore_3
    //   456: aload 10
    //   458: iconst_1
    //   459: invokeinterface 140 2 0
    //   464: checkcast 133	java/util/List
    //   467: invokeinterface 136 1 0
    //   472: istore_1
    //   473: aload 10
    //   475: iconst_0
    //   476: invokeinterface 140 2 0
    //   481: checkcast 133	java/util/List
    //   484: astore 10
    //   486: aload 10
    //   488: invokeinterface 136 1 0
    //   493: istore 7
    //   495: iconst_0
    //   496: istore 4
    //   498: iload 4
    //   500: iload 7
    //   502: if_icmpge +74 -> 576
    //   505: aload 10
    //   507: iload 4
    //   509: invokeinterface 140 2 0
    //   514: checkcast 145	com/tencent/mobileqq/data/PhoneContact
    //   517: astore 11
    //   519: aload 11
    //   521: ifnull +256 -> 777
    //   524: ldc 175
    //   526: aload 11
    //   528: getfield 173	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   531: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   534: ifeq +16 -> 550
    //   537: iload_3
    //   538: iconst_1
    //   539: iadd
    //   540: istore 5
    //   542: iload_1
    //   543: istore_3
    //   544: iload 5
    //   546: istore_1
    //   547: goto +260 -> 807
    //   550: aload 11
    //   552: getfield 173	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   555: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   558: ifne +270 -> 828
    //   561: iload_1
    //   562: istore 5
    //   564: iload_3
    //   565: istore_1
    //   566: iload_2
    //   567: iconst_1
    //   568: iadd
    //   569: istore_2
    //   570: iload 5
    //   572: istore_3
    //   573: goto +234 -> 807
    //   576: aload 9
    //   578: ldc_w 308
    //   581: iload 7
    //   583: iload_1
    //   584: iadd
    //   585: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   588: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   591: pop
    //   592: aload 9
    //   594: ldc_w 310
    //   597: iload_2
    //   598: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   601: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   604: pop
    //   605: aload 9
    //   607: ldc_w 312
    //   610: iload_3
    //   611: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   614: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   617: pop
    //   618: aload 9
    //   620: ldc_w 314
    //   623: iload_1
    //   624: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   627: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   630: pop
    //   631: aload_0
    //   632: invokevirtual 318	com/tencent/mobileqq/activity/contact/addcontact/AddContactsView:getContext	()Landroid/content/Context;
    //   635: invokestatic 323	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   638: aconst_null
    //   639: ldc_w 325
    //   642: iconst_1
    //   643: iload 6
    //   645: i2l
    //   646: lconst_0
    //   647: aload 9
    //   649: aconst_null
    //   650: invokevirtual 328	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   653: aload 8
    //   655: ifnull +10 -> 665
    //   658: aload 8
    //   660: invokeinterface 331 1 0
    //   665: aload 12
    //   667: invokeinterface 136 1 0
    //   672: iconst_3
    //   673: if_icmple +101 -> 774
    //   676: aload 12
    //   678: iconst_0
    //   679: iconst_3
    //   680: invokeinterface 335 3 0
    //   685: areturn
    //   686: astore 9
    //   688: aconst_null
    //   689: astore 8
    //   691: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   694: ifeq +15 -> 709
    //   697: ldc_w 342
    //   700: iconst_2
    //   701: ldc_w 344
    //   704: aload 9
    //   706: invokestatic 347	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   709: aload 8
    //   711: ifnull -46 -> 665
    //   714: aload 8
    //   716: invokeinterface 331 1 0
    //   721: goto -56 -> 665
    //   724: astore 8
    //   726: goto -61 -> 665
    //   729: astore 9
    //   731: aconst_null
    //   732: astore 8
    //   734: aload 8
    //   736: ifnull +10 -> 746
    //   739: aload 8
    //   741: invokeinterface 331 1 0
    //   746: aload 9
    //   748: athrow
    //   749: astore 8
    //   751: goto -86 -> 665
    //   754: astore 8
    //   756: goto -10 -> 746
    //   759: astore 9
    //   761: goto -27 -> 734
    //   764: astore 9
    //   766: goto -32 -> 734
    //   769: astore 9
    //   771: goto -80 -> 691
    //   774: aload 12
    //   776: areturn
    //   777: iload_1
    //   778: istore 5
    //   780: iload_3
    //   781: istore_1
    //   782: iload 5
    //   784: istore_3
    //   785: goto +22 -> 807
    //   788: goto -686 -> 102
    //   791: iload_2
    //   792: iconst_1
    //   793: iadd
    //   794: istore_2
    //   795: goto -693 -> 102
    //   798: iload 4
    //   800: iconst_1
    //   801: iadd
    //   802: istore 4
    //   804: goto -702 -> 102
    //   807: iload 4
    //   809: iconst_1
    //   810: iadd
    //   811: istore 5
    //   813: iload_3
    //   814: istore 4
    //   816: iload_1
    //   817: istore_3
    //   818: iload 4
    //   820: istore_1
    //   821: iload 5
    //   823: istore 4
    //   825: goto -327 -> 498
    //   828: iload_1
    //   829: iconst_1
    //   830: iadd
    //   831: istore 5
    //   833: iload_3
    //   834: istore_1
    //   835: iload 5
    //   837: istore_3
    //   838: goto -31 -> 807
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	841	0	this	AddContactsView
    //   101	734	1	i	int
    //   99	696	2	j	int
    //   97	741	3	k	int
    //   94	730	4	m	int
    //   540	296	5	n	int
    //   81	563	6	i1	int
    //   493	92	7	i2	int
    //   72	643	8	localCursor	android.database.Cursor
    //   724	1	8	localException1	java.lang.Exception
    //   732	8	8	localObject1	Object
    //   749	1	8	localException2	java.lang.Exception
    //   754	1	8	localException3	java.lang.Exception
    //   150	498	9	localObject2	Object
    //   686	19	9	localThrowable1	java.lang.Throwable
    //   729	18	9	localObject3	Object
    //   759	1	9	localObject4	Object
    //   764	1	9	localObject5	Object
    //   769	1	9	localThrowable2	java.lang.Throwable
    //   131	375	10	localObject6	Object
    //   197	354	11	localPhoneContact	PhoneContact
    //   36	739	12	localArrayList	ArrayList
    //   12	432	13	localPhoneContactManager	PhoneContactManager
    //   26	216	14	localFriendsManager	FriendsManager
    //   91	274	15	localHashSet	java.util.HashSet
    // Exception table:
    //   from	to	target	type
    //   38	74	686	java/lang/Throwable
    //   714	721	724	java/lang/Exception
    //   38	74	729	finally
    //   658	665	749	java/lang/Exception
    //   739	746	754	java/lang/Exception
    //   74	93	759	finally
    //   102	152	759	finally
    //   152	199	759	finally
    //   208	219	759	finally
    //   224	237	759	finally
    //   241	303	759	finally
    //   306	329	759	finally
    //   332	343	759	finally
    //   350	452	759	finally
    //   456	495	759	finally
    //   505	519	759	finally
    //   524	537	759	finally
    //   550	561	759	finally
    //   576	653	759	finally
    //   691	709	764	finally
    //   74	93	769	java/lang/Throwable
    //   102	152	769	java/lang/Throwable
    //   152	199	769	java/lang/Throwable
    //   208	219	769	java/lang/Throwable
    //   224	237	769	java/lang/Throwable
    //   241	303	769	java/lang/Throwable
    //   306	329	769	java/lang/Throwable
    //   332	343	769	java/lang/Throwable
    //   350	452	769	java/lang/Throwable
    //   456	495	769	java/lang/Throwable
    //   505	519	769	java/lang/Throwable
    //   524	537	769	java/lang/Throwable
    //   550	561	769	java/lang/Throwable
    //   576	653	769	java/lang/Throwable
  }
  
  private void h()
  {
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "initSearchConditions|autoReqLocation = " + this.jdField_a_of_type_Boolean + ", locCode[0] = " + arrayOfString[0]);
    }
    if ((this.jdField_a_of_type_Boolean) || ("0".equals(arrayOfString[0])))
    {
      if ((DatingUtil.a()) || (!NetworkUtil.d(this.jdField_a_of_type_AndroidAppActivity))) {
        break label177;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : yes");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      ((LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3)).c();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener);
      }
      return;
      label177:
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "-1", "-1", "-1", "-1" };
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : no");
      }
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131362848));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding(getResources().getDimensionPixelSize(2131558912), 0, 0, 0);
    Drawable localDrawable = getResources().getDrawable(2130845864);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCompoundDrawables(localDrawable, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(this);
    if (AppSetting.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription("搜索栏、QQ号、手机号、群、公共号");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130842327));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(this.jdField_a_of_type_AndroidAppActivity.getString(2131435474));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130842106));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131435494));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText("");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription("添加手机联系人");
      }
    }
    if (this.c != null)
    {
      this.c.setLeftIcon(getResources().getDrawable(2130842105));
      this.c.setFirstLineText("查看附近的人");
      this.c.setSecondLineVisible(false);
      this.c.a(true);
      this.c.setOnClickListener(this);
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.c.setContentDescription("查看附近的人");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131362859));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131362860));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter);
    if (this.d != null)
    {
      this.d.setLeftIcon(getResources().getDrawable(2130837548));
      this.d.setFirstLineText(getResources().getString(2131435481));
      this.d.setSecondLineText(getResources().getString(2131435483));
      this.d.a(true);
      this.d.setOnClickListener(this);
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.d.setContentDescription(getResources().getString(2131435483));
      }
    }
    if (this.e != null)
    {
      this.e.setLeftIcon(getResources().getDrawable(2130837547));
      this.e.setFirstLineText(getResources().getString(2131435475));
      this.e.setSecondLineVisible(false);
      this.e.a(true);
      this.e.setOnClickListener(this);
    }
  }
  
  private void j()
  {
    h();
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().getIntent();
    this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter = new MayKnowAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, 1, localIntent.getIntExtra("EntranceId", 0));
    k();
  }
  
  private void k()
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Object localObject = localSharedPreferences.getString(this.jdField_a_of_type_JavaLangString, "");
    if (((String)localObject).length() > 0)
    {
      localObject = ((String)localObject).split(",");
      if (localObject.length > 0) {
        this.jdField_a_of_type_JavaUtilList = Arrays.asList((Object[])localObject);
      }
    }
    localObject = a(this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText("");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      }
    }
    else if (localPhoneContactManager != null)
    {
      if (!localPhoneContactManager.c()) {
        break label154;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new wef(this, (String)localObject, localSharedPreferences));
    }
    label154:
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText((CharSequence)localObject);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(true);
      break;
      localSharedPreferences.edit().putString(this.jdField_a_of_type_JavaLangString, "").commit();
    } while (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem == null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
  }
  
  private void l()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131362847);
    if ((this.jdField_b_of_type_ArrayOfJavaLangString != null) && (this.jdField_b_of_type_ArrayOfJavaLangString.length > 0))
    {
      int i = 0;
      while (i < this.jdField_b_of_type_ArrayOfJavaLangString.length)
      {
        int j = 0;
        if (j < this.jdField_b_of_type_ArrayOfJavaLangString[i].length())
        {
          switch (this.jdField_b_of_type_ArrayOfJavaLangString[i].charAt(j))
          {
          }
          for (;;)
          {
            j += 1;
            break;
            if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
            {
              this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1001, i, j);
              if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
              {
                localLinearLayout.addView(this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem, localLinearLayout.getChildCount() - 3);
                continue;
                if (this.d == null)
                {
                  this.d = a(1004, i, j);
                  if (this.d != null)
                  {
                    localLinearLayout.addView(this.d, localLinearLayout.getChildCount() - 3);
                    continue;
                    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
                    {
                      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1002, i, j);
                      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
                      {
                        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem, localLinearLayout.getChildCount() - 3);
                        continue;
                        if (this.c == null)
                        {
                          this.c = a(1003, i, j);
                          if (this.c != null)
                          {
                            localLinearLayout.addView(this.c, localLinearLayout.getChildCount() - 3);
                            continue;
                            if (this.e == null)
                            {
                              this.e = a(1006, i, j);
                              if (this.e != null) {
                                localLinearLayout.addView(this.e, localLinearLayout.getChildCount() - 3);
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private void m()
  {
    String str2 = SharedPreUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if ((str2 != null) && (!str2.equals("")) && (str2.length() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "AddContactsViewConfig fetches successfully，content=" + str2);
      }
      String str1 = str2;
      if (str2.contains("6"))
      {
        QLog.d("AddContactsView", 1, "行家已经下架，不应该出现。 content=" + str2);
        str1 = str2.replace("6", "");
      }
      if (!str1.equals(""))
      {
        this.jdField_b_of_type_ArrayOfJavaLangString = str1.split("\\|");
        return;
      }
      this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "13524" };
      return;
    }
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "13524" };
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131559038);
  }
  
  protected void a()
  {
    super.a();
    super.a(2130968613);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58));
    m();
    l();
    i();
    j();
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222);
    }
  }
  
  protected void b()
  {
    super.b();
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter.a();
    }
    int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("entrence_data_report", 0);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800760D", "0X800760D", i, 0, "", "", "", "");
    if (i != 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800760D", "0X800760D", 0, 0, "", "", "", "");
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter.b();
    }
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter.c();
    }
  }
  
  public void e()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("fillSearchConditions | autoReqLocation = ").append(this.jdField_a_of_type_Boolean).append(" | code one = ");
      if ((this.jdField_a_of_type_ArrayOfJavaLangString == null) || (this.jdField_a_of_type_ArrayOfJavaLangString.length != 4)) {
        break label95;
      }
    }
    label95:
    for (Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString[0];; localObject = Integer.valueOf(-1000))
    {
      QLog.d("AddContactsView", 2, localObject);
      ThreadManager.postImmediately(new wec(this, new StringBuilder("条件：")), null, true);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onClick id=" + paramView.getId());
    }
    int i;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362848: 
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 1, 0, "", "", "", "");
      return;
    case 1002: 
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setRightIcon(null);
      }
      this.jdField_a_of_type_AndroidAppActivity.startActivity(new Intent(this.jdField_a_of_type_AndroidAppActivity, ConditionSearchFriendActivity.class).putExtra("from", "addcontacts").putExtra("key_first_req_location", this.jdField_a_of_type_Boolean));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004240", "0X8004240", 0, 0, "", "", "", "");
      return;
    case 1001: 
      paramView = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      i = paramView.c();
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "onClick ADD_PHONE_CONTACTS_ID selfBindState=" + i);
      }
      if ((i == 2) || (i == 4) || (i == 9) || (i == 8)) {
        ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222, paramView.a());
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474A", "0X800474A", 0, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A6", "0X80068A6", 0, 0, "", "", "", "");
        switch (paramView.c())
        {
        default: 
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A7", "0X80068A7", 0, 0, "", "", "", "");
        return;
        Intent localIntent;
        if ((i == 3) || (i == 6) || (i == 7))
        {
          localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, PhoneMatchActivity.class);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
        }
        else if ((i == 1) || (i == 5))
        {
          localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, BindNumberActivity.class);
          localIntent.putExtra("kSrouce", 14);
          this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 1);
        }
        else
        {
          localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, PhoneFrameActivity.class);
          localIntent.putExtra("key_reserved_mobile", (String[])this.jdField_a_of_type_JavaUtilList.toArray(new String[this.jdField_a_of_type_JavaUtilList.size()]));
          localIntent.putExtra("key_req_type", 3);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
        }
      }
    case 1003: 
      if (!NearbySPUtil.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
      {
        paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, NearbyActivity.class);
        paramView.putExtra("ENTER_TIME", System.currentTimeMillis());
        paramView.putExtra("FROM_WHERE", 1004);
        paramView.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131434461));
        NearbyFakeActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramView);
      }
      for (;;)
      {
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FA1", "0X8004FA1", 0, 0, "", "", "", "");
        return;
        paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, NearbyGuideActivity.class);
        paramView.putExtra("FROM_WHERE", 1004);
        paramView.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131434461));
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      }
    case 1004: 
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, CreateFaceToFaceDiscussionActivity.class);
      paramView.putExtra("create_source", 7);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800776D", "0X800776D", 0, 0, "", "", "", "");
      return;
    case 2131362859: 
      i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().getIntent().getIntExtra("EntranceId", 0);
      switch (i)
      {
      }
      for (;;)
      {
        paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, RecommendFriendActivity.class);
        paramView.putExtra("EntranceId", i);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006747", "0X8006747", 0, 0, "", "", "", "");
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006770", "0X8006770", 0, 0, "", "", "", "");
      }
    }
    paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, ScannerActivity.class);
    paramView.putExtra("from", "AddContactsActivity");
    paramView.setFlags(67108864);
    paramView.putExtra("QRDecode", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800760C", "0X800760C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView
 * JD-Core Version:    0.7.0.1
 */