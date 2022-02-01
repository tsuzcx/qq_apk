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
  public static boolean b = false;
  protected EntityManager a;
  private QQAppInterface c;
  private final int d = 10000;
  private final int e = 10001;
  
  public SearchHistoryManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    this.a = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
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
    Object localObject2 = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Friends localFriends = ((FriendsManager)localObject2).m(paramString);
    paramString = localObject1;
    if (localFriends != null)
    {
      paramString = new StringBuilder();
      paramString.append(localFriends.groupid);
      paramString.append("");
      localObject2 = ((FriendsManager)localObject2).u(paramString.toString());
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = ((Groups)localObject2).group_name;
      }
    }
    return paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    b = true;
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
  
  private boolean d(SearchHistory paramSearchHistory)
  {
    paramSearchHistory = ((DiscussionManager)this.c.getManager(QQManagerFactory.DISCUSSION_MANAGER)).d(paramSearchHistory.uin);
    return (paramSearchHistory == null) || (paramSearchHistory.isHidden());
  }
  
  private boolean e(SearchHistory paramSearchHistory)
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.c.getRuntimeService(IPhoneContactService.class, "");
    if (localIPhoneContactService.isBindedIgnoreUpload()) {
      return true;
    }
    paramSearchHistory = localIPhoneContactService.queryContactByCodeNumber(paramSearchHistory.uin);
    if (paramSearchHistory == null) {
      return true;
    }
    return TextUtils.isEmpty(paramSearchHistory.uin);
  }
  
  private boolean f(SearchHistory paramSearchHistory)
  {
    Object localObject = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool3 = true;
    boolean bool1;
    if ((localObject != null) && (((FriendsManager)localObject).n(paramSearchHistory.uin))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramSearchHistory.type == 1000)
    {
      localObject = (TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER);
      if (((TroopManager)localObject).g(((TroopManager)localObject).u(paramSearchHistory.troopUin), paramSearchHistory.uin) == null) {
        return true;
      }
    }
    else if (paramSearchHistory.type == 1004)
    {
      paramSearchHistory = ((DiscussionManager)this.c.getManager(QQManagerFactory.DISCUSSION_MANAGER)).d(paramSearchHistory.troopUin);
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
        Cursor localCursor = this.a.query(false, SearchHistory.class.getSimpleName(), null, null, null, null, null, "time desc", null);
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
                localSearchHistory = (SearchHistory)this.a.find(SearchHistory.class, localSearchHistory.key);
                if (localSearchHistory != null)
                {
                  localObject3 = localCursor;
                  localObject1 = localCursor;
                  this.a.remove(localSearchHistory);
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
          break label488;
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
      label478:
      break label478;
    }
    if (localObject2 != null) {
      localObject2.close();
    }
    label488:
    return localArrayList;
  }
  
  public void a(SearchHistory paramSearchHistory, String paramString)
  {
    paramString = (SearchHistory)this.a.find(SearchHistory.class, paramString);
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
      this.a.update(paramString);
      return;
    }
    QLog.i("SearchHistoryManager", 1, "original == null");
  }
  
  boolean a(SearchHistory paramSearchHistory)
  {
    Object localObject = (TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER);
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.c.getRuntimeService(IPhoneContactService.class, "");
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
                  return e(paramSearchHistory);
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
                paramSearchHistory.displayName = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this.c, BaseApplicationImpl.getContext());
              }
            }
            else {
              return d(paramSearchHistory);
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
            paramSearchHistory.displayName = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getXinKandianName(this.c, BaseApplicationImpl.getContext());
          }
        }
        else {
          return f(paramSearchHistory);
        }
      }
      else
      {
        localObject = ((TroopManager)localObject).f(paramSearchHistory.uin);
        if (localObject == null) {
          return true;
        }
        paramSearchHistory.displayName = ((TroopInfo)localObject).getNewTroopNameOrTroopName();
      }
    }
    else if (!((FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramSearchHistory.uin)) {
      return true;
    }
    boolean bool1 = false;
    return bool1;
  }
  
  /* Error */
  public void b(SearchHistory paramSearchHistory)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: putfield 261	com/tencent/mobileqq/data/SearchHistory:count	I
    //   5: aload_1
    //   6: invokestatic 368	java/lang/System:currentTimeMillis	()J
    //   9: putfield 270	com/tencent/mobileqq/data/SearchHistory:time	J
    //   12: aload_1
    //   13: getfield 189	com/tencent/mobileqq/data/SearchHistory:type	I
    //   16: istore_2
    //   17: iload_2
    //   18: ifeq +523 -> 541
    //   21: iload_2
    //   22: iconst_1
    //   23: if_icmpeq +472 -> 495
    //   26: iload_2
    //   27: sipush 1000
    //   30: if_icmpeq +419 -> 449
    //   33: iload_2
    //   34: sipush 1004
    //   37: if_icmpeq +366 -> 403
    //   40: iload_2
    //   41: sipush 1006
    //   44: if_icmpeq +313 -> 357
    //   47: iload_2
    //   48: sipush 1008
    //   51: if_icmpeq +247 -> 298
    //   54: iload_2
    //   55: sipush 1021
    //   58: if_icmpeq +194 -> 252
    //   61: iload_2
    //   62: sipush 3000
    //   65: if_icmpeq +141 -> 206
    //   68: iload_2
    //   69: sipush 7220
    //   72: if_icmpeq +88 -> 160
    //   75: iload_2
    //   76: sipush 10007
    //   79: if_icmpeq +38 -> 117
    //   82: iload_2
    //   83: tableswitch	default:+33 -> 116, 56938:+274->357, 56939:+274->357, 56940:+274->357, 56941:+274->357, 56942:+274->357
    //   117: aload_1
    //   118: ldc_w 370
    //   121: putfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   124: new 58	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   131: astore_3
    //   132: aload_3
    //   133: aload_1
    //   134: getfield 148	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   137: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_3
    //   142: sipush 10001
    //   145: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_1
    //   150: aload_3
    //   151: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: putfield 242	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   157: goto +446 -> 603
    //   160: aload_1
    //   161: ldc_w 371
    //   164: invokestatic 375	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   167: putfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   170: new 58	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   177: astore_3
    //   178: aload_3
    //   179: aload_1
    //   180: getfield 148	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   183: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_3
    //   188: sipush 10001
    //   191: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_1
    //   196: aload_3
    //   197: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: putfield 242	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   203: goto +400 -> 603
    //   206: aload_1
    //   207: ldc_w 376
    //   210: invokestatic 375	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   213: putfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   216: new 58	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   223: astore_3
    //   224: aload_3
    //   225: aload_1
    //   226: getfield 148	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   229: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_3
    //   234: sipush 10000
    //   237: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_1
    //   242: aload_3
    //   243: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: putfield 242	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   249: goto +354 -> 603
    //   252: aload_1
    //   253: ldc_w 377
    //   256: invokestatic 375	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   259: putfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   262: new 58	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   269: astore_3
    //   270: aload_3
    //   271: aload_1
    //   272: getfield 148	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   275: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload_3
    //   280: sipush 10001
    //   283: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_1
    //   288: aload_3
    //   289: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: putfield 242	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   295: goto +308 -> 603
    //   298: aload_1
    //   299: getfield 148	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   302: getstatic 345	com/tencent/mobileqq/app/AppConstants:NEW_KANDIAN_UIN	Ljava/lang/String;
    //   305: invokestatic 348	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   308: ifeq +295 -> 603
    //   311: aload_1
    //   312: ldc_w 378
    //   315: invokestatic 375	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   318: putfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   321: new 58	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   328: astore_3
    //   329: aload_3
    //   330: aload_1
    //   331: getfield 148	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   334: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_3
    //   339: sipush 10001
    //   342: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_1
    //   347: aload_3
    //   348: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: putfield 242	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   354: goto +249 -> 603
    //   357: aload_1
    //   358: ldc_w 379
    //   361: invokestatic 375	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   364: putfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   367: new 58	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   374: astore_3
    //   375: aload_3
    //   376: aload_1
    //   377: getfield 148	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   380: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload_3
    //   385: sipush 10001
    //   388: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload_1
    //   393: aload_3
    //   394: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: putfield 242	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   400: goto +203 -> 603
    //   403: aload_1
    //   404: ldc_w 380
    //   407: invokestatic 375	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   410: putfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   413: new 58	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   420: astore_3
    //   421: aload_3
    //   422: aload_1
    //   423: getfield 148	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   426: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload_3
    //   431: sipush 10001
    //   434: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_1
    //   439: aload_3
    //   440: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: putfield 242	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   446: goto +157 -> 603
    //   449: aload_1
    //   450: ldc_w 381
    //   453: invokestatic 375	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   456: putfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   459: new 58	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   466: astore_3
    //   467: aload_3
    //   468: aload_1
    //   469: getfield 148	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   472: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload_3
    //   477: sipush 10001
    //   480: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload_1
    //   485: aload_3
    //   486: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: putfield 242	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   492: goto +111 -> 603
    //   495: aload_1
    //   496: ldc_w 382
    //   499: invokestatic 375	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   502: putfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   505: new 58	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   512: astore_3
    //   513: aload_3
    //   514: aload_1
    //   515: getfield 148	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   518: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload_3
    //   523: sipush 10000
    //   526: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload_1
    //   531: aload_3
    //   532: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: putfield 242	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   538: goto +65 -> 603
    //   541: aload_1
    //   542: aload_0
    //   543: aload_1
    //   544: getfield 148	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   547: invokespecial 384	com/tencent/mobileqq/app/SearchHistoryManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   550: putfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   553: aload_1
    //   554: getfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   557: ifnonnull +13 -> 570
    //   560: aload_1
    //   561: ldc_w 385
    //   564: invokestatic 375	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   567: putfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   570: new 58	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   577: astore_3
    //   578: aload_3
    //   579: aload_1
    //   580: getfield 148	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   583: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload_3
    //   588: sipush 10001
    //   591: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload_1
    //   596: aload_3
    //   597: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: putfield 242	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   603: aload_0
    //   604: getfield 43	com/tencent/mobileqq/app/SearchHistoryManager:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   607: ldc 145
    //   609: aload_1
    //   610: getfield 242	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   613: invokevirtual 282	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   616: checkcast 145	com/tencent/mobileqq/data/SearchHistory
    //   619: astore_3
    //   620: aload_3
    //   621: ifnull +74 -> 695
    //   624: aload_3
    //   625: aload_1
    //   626: getfield 270	com/tencent/mobileqq/data/SearchHistory:time	J
    //   629: putfield 270	com/tencent/mobileqq/data/SearchHistory:time	J
    //   632: aload_3
    //   633: aload_3
    //   634: getfield 261	com/tencent/mobileqq/data/SearchHistory:count	I
    //   637: iconst_1
    //   638: iadd
    //   639: putfield 261	com/tencent/mobileqq/data/SearchHistory:count	I
    //   642: aload_3
    //   643: getfield 189	com/tencent/mobileqq/data/SearchHistory:type	I
    //   646: aload_1
    //   647: getfield 189	com/tencent/mobileqq/data/SearchHistory:type	I
    //   650: if_icmpeq +35 -> 685
    //   653: aload_3
    //   654: aload_1
    //   655: getfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   658: putfield 257	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   661: aload_3
    //   662: aload_1
    //   663: getfield 189	com/tencent/mobileqq/data/SearchHistory:type	I
    //   666: putfield 189	com/tencent/mobileqq/data/SearchHistory:type	I
    //   669: aload_3
    //   670: aload_1
    //   671: getfield 197	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   674: putfield 197	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   677: aload_3
    //   678: aload_1
    //   679: getfield 246	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   682: putfield 246	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   685: aload_0
    //   686: getfield 43	com/tencent/mobileqq/app/SearchHistoryManager:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   689: aload_3
    //   690: invokevirtual 301	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   693: pop
    //   694: return
    //   695: aconst_null
    //   696: astore_3
    //   697: aconst_null
    //   698: astore 4
    //   700: aload_0
    //   701: getfield 43	com/tencent/mobileqq/app/SearchHistoryManager:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   704: iconst_0
    //   705: ldc 145
    //   707: invokevirtual 217	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   710: aconst_null
    //   711: aconst_null
    //   712: aconst_null
    //   713: aconst_null
    //   714: aconst_null
    //   715: ldc_w 387
    //   718: aconst_null
    //   719: invokevirtual 225	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   722: astore 5
    //   724: aload 5
    //   726: ifnull +69 -> 795
    //   729: aload 5
    //   731: astore 4
    //   733: aload 5
    //   735: astore_3
    //   736: iconst_5
    //   737: aload 5
    //   739: invokeinterface 391 1 0
    //   744: if_icmpgt +51 -> 795
    //   747: aload 5
    //   749: astore 4
    //   751: aload 5
    //   753: astore_3
    //   754: aload 5
    //   756: invokeinterface 230 1 0
    //   761: ifeq +49 -> 810
    //   764: aload 5
    //   766: astore 4
    //   768: aload 5
    //   770: astore_3
    //   771: aload_0
    //   772: aload_1
    //   773: aload 5
    //   775: aload 5
    //   777: ldc 233
    //   779: invokeinterface 237 2 0
    //   784: invokeinterface 240 2 0
    //   789: invokevirtual 393	com/tencent/mobileqq/app/SearchHistoryManager:a	(Lcom/tencent/mobileqq/data/SearchHistory;Ljava/lang/String;)V
    //   792: goto +18 -> 810
    //   795: aload 5
    //   797: astore 4
    //   799: aload 5
    //   801: astore_3
    //   802: aload_0
    //   803: getfield 43	com/tencent/mobileqq/app/SearchHistoryManager:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   806: aload_1
    //   807: invokevirtual 397	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   810: aload 5
    //   812: ifnull +31 -> 843
    //   815: aload 5
    //   817: astore_3
    //   818: goto +19 -> 837
    //   821: astore_1
    //   822: goto +22 -> 844
    //   825: astore_1
    //   826: aload_3
    //   827: astore 4
    //   829: aload_1
    //   830: invokevirtual 400	java/lang/Exception:printStackTrace	()V
    //   833: aload_3
    //   834: ifnull +9 -> 843
    //   837: aload_3
    //   838: invokeinterface 295 1 0
    //   843: return
    //   844: aload 4
    //   846: ifnull +10 -> 856
    //   849: aload 4
    //   851: invokeinterface 295 1 0
    //   856: aload_1
    //   857: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	858	0	this	SearchHistoryManager
    //   0	858	1	paramSearchHistory	SearchHistory
    //   16	67	2	i	int
    //   131	707	3	localObject1	Object
    //   698	152	4	localObject2	Object
    //   722	94	5	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   700	724	821	finally
    //   736	747	821	finally
    //   754	764	821	finally
    //   771	792	821	finally
    //   802	810	821	finally
    //   829	833	821	finally
    //   700	724	825	java/lang/Exception
    //   736	747	825	java/lang/Exception
    //   754	764	825	java/lang/Exception
    //   771	792	825	java/lang/Exception
    //   802	810	825	java/lang/Exception
  }
  
  public boolean c(SearchHistory paramSearchHistory)
  {
    if (paramSearchHistory != null)
    {
      paramSearchHistory.setStatus(1001);
      return this.a.remove(paramSearchHistory);
    }
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SearchHistoryManager
 * JD-Core Version:    0.7.0.1
 */