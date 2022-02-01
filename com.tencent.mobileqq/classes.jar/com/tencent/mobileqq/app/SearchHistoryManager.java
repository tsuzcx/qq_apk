package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class SearchHistoryManager
  implements Manager
{
  public static boolean a = false;
  private final int jdField_a_of_type_Int = 10000;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected EntityManager a;
  private final int b = 10001;
  
  public SearchHistoryManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_keyword");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  private String a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Friends localFriends = ((FriendsManager)localObject2).e(paramString);
    paramString = localObject1;
    if (localFriends != null)
    {
      paramString = new StringBuilder();
      paramString.append(localFriends.groupid);
      paramString.append("");
      localObject2 = ((FriendsManager)localObject2).a(paramString.toString());
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = ((Groups)localObject2).group_name;
      }
    }
    return paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_Boolean = true;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_keyword");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localEditor.putString(localStringBuilder.toString(), paramString);
    localEditor.commit();
  }
  
  private boolean a(SearchHistory paramSearchHistory, IPhoneContactService paramIPhoneContactService)
  {
    boolean bool2 = paramIPhoneContactService.isBindedIgnoreUpload();
    boolean bool1 = true;
    if (!bool2) {
      return true;
    }
    paramSearchHistory = paramIPhoneContactService.queryContactByCodeNumber(paramSearchHistory.uin);
    if (paramSearchHistory != null)
    {
      if (!"0".equals(paramSearchHistory.uin)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private boolean c(SearchHistory paramSearchHistory)
  {
    paramSearchHistory = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramSearchHistory.uin);
    return (paramSearchHistory == null) || (paramSearchHistory.isHidden());
  }
  
  private boolean d(SearchHistory paramSearchHistory)
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (localIPhoneContactService.isBindedIgnoreUpload()) {
      return true;
    }
    paramSearchHistory = localIPhoneContactService.queryContactByCodeNumber(paramSearchHistory.uin);
    if (paramSearchHistory == null) {
      return true;
    }
    return TextUtils.isEmpty(paramSearchHistory.uin);
  }
  
  private boolean e(SearchHistory paramSearchHistory)
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool3 = true;
    boolean bool1;
    if ((localObject != null) && (((FriendsManager)localObject).b(paramSearchHistory.uin))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramSearchHistory.type == 1000)
    {
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (((TroopManager)localObject).b(((TroopManager)localObject).c(paramSearchHistory.troopUin), paramSearchHistory.uin) == null) {
        return true;
      }
    }
    else if (paramSearchHistory.type == 1004)
    {
      paramSearchHistory = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramSearchHistory.troopUin);
      bool2 = bool3;
      if (paramSearchHistory == null) {
        return bool2;
      }
      bool2 = bool3;
      if (paramSearchHistory.isDiscussHrMeeting()) {
        return bool2;
      }
      if (paramSearchHistory.isHidden()) {
        return true;
      }
    }
    boolean bool2 = bool1;
    return bool2;
  }
  
  public ArrayList<SearchHistory> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    Object localObject3 = null;
    try
    {
      try
      {
        Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(false, SearchHistory.class.getSimpleName(), null, null, null, null, null, "time desc", null);
        int i = 0;
        if (localCursor != null)
        {
          localObject3 = localCursor;
          localObject1 = localCursor;
          if (localCursor.moveToFirst())
          {
            boolean bool;
            do
            {
              localObject3 = localCursor;
              localObject1 = localCursor;
              SearchHistory localSearchHistory = new SearchHistory();
              localObject3 = localCursor;
              localObject1 = localCursor;
              localSearchHistory.key = localCursor.getString(localCursor.getColumnIndex("key"));
              localObject3 = localCursor;
              localObject1 = localCursor;
              localSearchHistory.displayName = localCursor.getString(localCursor.getColumnIndex("displayName"));
              localObject3 = localCursor;
              localObject1 = localCursor;
              localSearchHistory.uin = localCursor.getString(localCursor.getColumnIndex("uin"));
              localObject3 = localCursor;
              localObject1 = localCursor;
              localSearchHistory.troopUin = localCursor.getString(localCursor.getColumnIndex("troopUin"));
              localObject3 = localCursor;
              localObject1 = localCursor;
              localSearchHistory.type = localCursor.getInt(localCursor.getColumnIndex("type"));
              localObject3 = localCursor;
              localObject1 = localCursor;
              localSearchHistory.extralInfo = localCursor.getString(localCursor.getColumnIndex("extralInfo"));
              localObject3 = localCursor;
              localObject1 = localCursor;
              localSearchHistory.count = localCursor.getInt(localCursor.getColumnIndex("count"));
              localObject3 = localCursor;
              localObject1 = localCursor;
              localSearchHistory.time = localCursor.getLong(localCursor.getColumnIndex("time"));
              localObject3 = localCursor;
              localObject1 = localCursor;
              localSearchHistory.setId(localCursor.getInt(localCursor.getColumnIndex("_id")));
              localObject3 = localCursor;
              localObject1 = localCursor;
              bool = a(localSearchHistory);
              if (i >= 5) {
                bool = true;
              }
              if (bool)
              {
                localObject3 = localCursor;
                localObject1 = localCursor;
                localSearchHistory = (SearchHistory)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(SearchHistory.class, localSearchHistory.key);
                if (localSearchHistory != null)
                {
                  localObject3 = localCursor;
                  localObject1 = localCursor;
                  this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localSearchHistory);
                }
              }
              else if (i < 5)
              {
                localObject3 = localCursor;
                localObject1 = localCursor;
                localArrayList.add(localSearchHistory);
              }
              i += 1;
              localObject3 = localCursor;
              localObject1 = localCursor;
              bool = localCursor.moveToNext();
            } while (bool);
          }
        }
        if (localCursor == null) {
          break label487;
        }
        localObject1 = localCursor;
      }
      finally
      {
        if (localObject3 != null) {
          localObject3.close();
        }
      }
    }
    catch (Exception localException)
    {
      label477:
      break label477;
    }
    if (localObject2 != null) {
      localObject2.close();
    }
    label487:
    return localArrayList;
  }
  
  /* Error */
  public void a(SearchHistory paramSearchHistory)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: putfield 256	com/tencent/mobileqq/data/SearchHistory:count	I
    //   5: aload_1
    //   6: invokestatic 299	java/lang/System:currentTimeMillis	()J
    //   9: putfield 265	com/tencent/mobileqq/data/SearchHistory:time	J
    //   12: aload_1
    //   13: getfield 185	com/tencent/mobileqq/data/SearchHistory:type	I
    //   16: istore_2
    //   17: iload_2
    //   18: ifeq +476 -> 494
    //   21: iload_2
    //   22: iconst_1
    //   23: if_icmpeq +425 -> 448
    //   26: iload_2
    //   27: sipush 1000
    //   30: if_icmpeq +372 -> 402
    //   33: iload_2
    //   34: sipush 1004
    //   37: if_icmpeq +319 -> 356
    //   40: iload_2
    //   41: sipush 1006
    //   44: if_icmpeq +266 -> 310
    //   47: iload_2
    //   48: sipush 1008
    //   51: if_icmpeq +200 -> 251
    //   54: iload_2
    //   55: sipush 1021
    //   58: if_icmpeq +147 -> 205
    //   61: iload_2
    //   62: sipush 3000
    //   65: if_icmpeq +94 -> 159
    //   68: iload_2
    //   69: sipush 7220
    //   72: if_icmpeq +41 -> 113
    //   75: iload_2
    //   76: tableswitch	default:+36 -> 112, 56938:+234->310, 56939:+234->310, 56940:+234->310, 56941:+234->310, 56942:+234->310
    //   113: aload_1
    //   114: ldc_w 300
    //   117: invokestatic 304	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   120: putfield 252	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   123: new 55	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   130: astore_3
    //   131: aload_3
    //   132: aload_1
    //   133: getfield 144	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   136: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_3
    //   141: sipush 10001
    //   144: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_1
    //   149: aload_3
    //   150: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: putfield 237	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   156: goto +400 -> 556
    //   159: aload_1
    //   160: ldc_w 305
    //   163: invokestatic 304	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   166: putfield 252	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   169: new 55	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   176: astore_3
    //   177: aload_3
    //   178: aload_1
    //   179: getfield 144	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   182: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_3
    //   187: sipush 10000
    //   190: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_1
    //   195: aload_3
    //   196: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: putfield 237	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   202: goto +354 -> 556
    //   205: aload_1
    //   206: ldc_w 306
    //   209: invokestatic 304	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   212: putfield 252	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   215: new 55	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   222: astore_3
    //   223: aload_3
    //   224: aload_1
    //   225: getfield 144	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   228: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_3
    //   233: sipush 10001
    //   236: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_1
    //   241: aload_3
    //   242: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: putfield 237	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   248: goto +308 -> 556
    //   251: aload_1
    //   252: getfield 144	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   255: getstatic 311	com/tencent/mobileqq/app/AppConstants:NEW_KANDIAN_UIN	Ljava/lang/String;
    //   258: invokestatic 314	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   261: ifeq +295 -> 556
    //   264: aload_1
    //   265: ldc_w 315
    //   268: invokestatic 304	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   271: putfield 252	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   274: new 55	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   281: astore_3
    //   282: aload_3
    //   283: aload_1
    //   284: getfield 144	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   287: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_3
    //   292: sipush 10001
    //   295: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload_1
    //   300: aload_3
    //   301: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: putfield 237	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   307: goto +249 -> 556
    //   310: aload_1
    //   311: ldc_w 316
    //   314: invokestatic 304	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   317: putfield 252	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   320: new 55	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   327: astore_3
    //   328: aload_3
    //   329: aload_1
    //   330: getfield 144	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   333: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_3
    //   338: sipush 10001
    //   341: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_1
    //   346: aload_3
    //   347: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: putfield 237	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   353: goto +203 -> 556
    //   356: aload_1
    //   357: ldc_w 317
    //   360: invokestatic 304	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   363: putfield 252	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   366: new 55	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   373: astore_3
    //   374: aload_3
    //   375: aload_1
    //   376: getfield 144	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   379: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload_3
    //   384: sipush 10001
    //   387: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload_1
    //   392: aload_3
    //   393: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: putfield 237	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   399: goto +157 -> 556
    //   402: aload_1
    //   403: ldc_w 318
    //   406: invokestatic 304	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   409: putfield 252	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   412: new 55	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   419: astore_3
    //   420: aload_3
    //   421: aload_1
    //   422: getfield 144	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   425: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload_3
    //   430: sipush 10001
    //   433: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload_1
    //   438: aload_3
    //   439: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: putfield 237	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   445: goto +111 -> 556
    //   448: aload_1
    //   449: ldc_w 319
    //   452: invokestatic 304	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   455: putfield 252	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   458: new 55	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   465: astore_3
    //   466: aload_3
    //   467: aload_1
    //   468: getfield 144	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   471: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload_3
    //   476: sipush 10000
    //   479: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload_1
    //   484: aload_3
    //   485: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: putfield 237	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   491: goto +65 -> 556
    //   494: aload_1
    //   495: aload_0
    //   496: aload_1
    //   497: getfield 144	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   500: invokespecial 321	com/tencent/mobileqq/app/SearchHistoryManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   503: putfield 252	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   506: aload_1
    //   507: getfield 252	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   510: ifnonnull +13 -> 523
    //   513: aload_1
    //   514: ldc_w 322
    //   517: invokestatic 304	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   520: putfield 252	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   523: new 55	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   530: astore_3
    //   531: aload_3
    //   532: aload_1
    //   533: getfield 144	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   536: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload_3
    //   541: sipush 10001
    //   544: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload_1
    //   549: aload_3
    //   550: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: putfield 237	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   556: aload_0
    //   557: getfield 40	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   560: ldc 141
    //   562: aload_1
    //   563: getfield 237	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   566: invokevirtual 277	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   569: checkcast 141	com/tencent/mobileqq/data/SearchHistory
    //   572: astore_3
    //   573: aload_3
    //   574: ifnull +74 -> 648
    //   577: aload_3
    //   578: aload_1
    //   579: getfield 265	com/tencent/mobileqq/data/SearchHistory:time	J
    //   582: putfield 265	com/tencent/mobileqq/data/SearchHistory:time	J
    //   585: aload_3
    //   586: aload_3
    //   587: getfield 256	com/tencent/mobileqq/data/SearchHistory:count	I
    //   590: iconst_1
    //   591: iadd
    //   592: putfield 256	com/tencent/mobileqq/data/SearchHistory:count	I
    //   595: aload_3
    //   596: getfield 185	com/tencent/mobileqq/data/SearchHistory:type	I
    //   599: aload_1
    //   600: getfield 185	com/tencent/mobileqq/data/SearchHistory:type	I
    //   603: if_icmpeq +35 -> 638
    //   606: aload_3
    //   607: aload_1
    //   608: getfield 252	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   611: putfield 252	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   614: aload_3
    //   615: aload_1
    //   616: getfield 185	com/tencent/mobileqq/data/SearchHistory:type	I
    //   619: putfield 185	com/tencent/mobileqq/data/SearchHistory:type	I
    //   622: aload_3
    //   623: aload_1
    //   624: getfield 193	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   627: putfield 193	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   630: aload_3
    //   631: aload_1
    //   632: getfield 241	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   635: putfield 241	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   638: aload_0
    //   639: getfield 40	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   642: aload_3
    //   643: invokevirtual 325	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   646: pop
    //   647: return
    //   648: aconst_null
    //   649: astore_3
    //   650: aconst_null
    //   651: astore 4
    //   653: aload_0
    //   654: getfield 40	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   657: iconst_0
    //   658: ldc 141
    //   660: invokevirtual 212	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   663: aconst_null
    //   664: aconst_null
    //   665: aconst_null
    //   666: aconst_null
    //   667: aconst_null
    //   668: ldc_w 327
    //   671: aconst_null
    //   672: invokevirtual 220	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   675: astore 5
    //   677: aload 5
    //   679: ifnull +69 -> 748
    //   682: aload 5
    //   684: astore 4
    //   686: aload 5
    //   688: astore_3
    //   689: iconst_5
    //   690: aload 5
    //   692: invokeinterface 331 1 0
    //   697: if_icmpgt +51 -> 748
    //   700: aload 5
    //   702: astore 4
    //   704: aload 5
    //   706: astore_3
    //   707: aload 5
    //   709: invokeinterface 225 1 0
    //   714: ifeq +49 -> 763
    //   717: aload 5
    //   719: astore 4
    //   721: aload 5
    //   723: astore_3
    //   724: aload_0
    //   725: aload_1
    //   726: aload 5
    //   728: aload 5
    //   730: ldc 228
    //   732: invokeinterface 232 2 0
    //   737: invokeinterface 235 2 0
    //   742: invokevirtual 334	com/tencent/mobileqq/app/SearchHistoryManager:a	(Lcom/tencent/mobileqq/data/SearchHistory;Ljava/lang/String;)V
    //   745: goto +18 -> 763
    //   748: aload 5
    //   750: astore 4
    //   752: aload 5
    //   754: astore_3
    //   755: aload_0
    //   756: getfield 40	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   759: aload_1
    //   760: invokevirtual 338	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   763: aload 5
    //   765: ifnull +31 -> 796
    //   768: aload 5
    //   770: astore_3
    //   771: goto +19 -> 790
    //   774: astore_1
    //   775: goto +22 -> 797
    //   778: astore_1
    //   779: aload_3
    //   780: astore 4
    //   782: aload_1
    //   783: invokevirtual 341	java/lang/Exception:printStackTrace	()V
    //   786: aload_3
    //   787: ifnull +9 -> 796
    //   790: aload_3
    //   791: invokeinterface 290 1 0
    //   796: return
    //   797: aload 4
    //   799: ifnull +10 -> 809
    //   802: aload 4
    //   804: invokeinterface 290 1 0
    //   809: aload_1
    //   810: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	811	0	this	SearchHistoryManager
    //   0	811	1	paramSearchHistory	SearchHistory
    //   16	60	2	i	int
    //   130	661	3	localObject1	Object
    //   651	152	4	localObject2	Object
    //   675	94	5	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   653	677	774	finally
    //   689	700	774	finally
    //   707	717	774	finally
    //   724	745	774	finally
    //   755	763	774	finally
    //   782	786	774	finally
    //   653	677	778	java/lang/Exception
    //   689	700	778	java/lang/Exception
    //   707	717	778	java/lang/Exception
    //   724	745	778	java/lang/Exception
    //   755	763	778	java/lang/Exception
  }
  
  public void a(SearchHistory paramSearchHistory, String paramString)
  {
    paramString = (SearchHistory)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(SearchHistory.class, paramString);
    if (paramString != null)
    {
      paramString.key = paramSearchHistory.key;
      paramString.uin = paramSearchHistory.uin;
      paramString.troopUin = paramSearchHistory.troopUin;
      paramString.time = paramSearchHistory.time;
      paramString.displayName = paramSearchHistory.displayName;
      paramString.type = paramSearchHistory.type;
      paramString.count = paramSearchHistory.count;
      paramString.extralInfo = paramSearchHistory.extralInfo;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramString);
      return;
    }
    QLog.i("SearchHistoryManager", 1, "original == null");
  }
  
  boolean a(SearchHistory paramSearchHistory)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    int i = paramSearchHistory.type;
    boolean bool2 = true;
    if (i != 0)
    {
      if (i != 1)
      {
        if ((i != 1000) && (i != 1004))
        {
          if (i != 1008)
          {
            bool1 = bool2;
            if (i == 1021) {
              return bool1;
            }
            if (i != 3000)
            {
              if (i != 7220)
              {
                switch (i)
                {
                default: 
                  break;
                case 56942: 
                  paramSearchHistory = localIPhoneContactService.queryContactByCodeNumber(paramSearchHistory.uin);
                  if (paramSearchHistory == null) {
                    break;
                  }
                  bool1 = bool2;
                  if (!TextUtils.isEmpty(paramSearchHistory.uin)) {
                    return bool1;
                  }
                  break;
                case 56941: 
                  return a(paramSearchHistory, localIPhoneContactService);
                case 56940: 
                  return d(paramSearchHistory);
                case 56939: 
                  paramSearchHistory = localIPhoneContactService.queryContactByCodeNumber(paramSearchHistory.uin);
                  bool1 = bool2;
                  if (paramSearchHistory == null) {
                    return bool1;
                  }
                  bool1 = bool2;
                  if (TextUtils.isEmpty(paramSearchHistory.uin)) {
                    return bool1;
                  }
                  if (!"0".equals(paramSearchHistory.uin)) {
                    break;
                  }
                  return true;
                }
              }
              else
              {
                bool1 = bool2;
                if (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()) {
                  return bool1;
                }
                if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab()) {
                  return true;
                }
                paramSearchHistory.displayName = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
              }
            }
            else {
              return c(paramSearchHistory);
            }
          }
          else
          {
            bool1 = bool2;
            if (!TextUtils.equals(paramSearchHistory.uin, AppConstants.NEW_KANDIAN_UIN)) {
              return bool1;
            }
            if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()) {
              return true;
            }
            paramSearchHistory.displayName = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getXinKandianName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
          }
        }
        else {
          return e(paramSearchHistory);
        }
      }
      else
      {
        localObject = ((TroopManager)localObject).b(paramSearchHistory.uin);
        if (localObject == null) {
          return true;
        }
        paramSearchHistory.displayName = ((TroopInfo)localObject).getNewTroopNameOrTroopName();
      }
    }
    else if (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramSearchHistory.uin)) {
      return true;
    }
    boolean bool1 = false;
    return bool1;
  }
  
  public boolean b(SearchHistory paramSearchHistory)
  {
    if (paramSearchHistory != null)
    {
      paramSearchHistory.setStatus(1001);
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramSearchHistory);
    }
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SearchHistoryManager
 * JD-Core Version:    0.7.0.1
 */