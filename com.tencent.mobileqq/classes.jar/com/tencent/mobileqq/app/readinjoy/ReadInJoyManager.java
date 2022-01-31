package com.tencent.mobileqq.app.readinjoy;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.readinjoy.content.ReadInJoyDataProvider;
import cooperation.readinjoy.storage.ReadInJoyFeedsMsgRecord;
import cooperation.readinjoy.storage.ReadInJoyNotifyRedTouchInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import zvz;

public class ReadInJoyManager
  extends Observable
  implements Manager
{
  public static String a;
  private int jdField_a_of_type_Int = 14;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ReadInJoyManager.NotifyReceiver jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private BusinessInfoCheckUpdate.RedTypeInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  
  static
  {
    jdField_a_of_type_JavaLangString = ReadInJoyManager.class.getSimpleName();
  }
  
  public ReadInJoyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver = new ReadInJoyManager.NotifyReceiver(this);
    this.jdField_a_of_type_AndroidContentSharedPreferences = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    if (((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSystemService("window")).getDefaultDisplay().getWidth() <= 720) {}
    for (int i = 14;; i = 24)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, b());
      paramQQAppInterface = new IntentFilter();
      paramQQAppInterface.addAction("notify_main_feeds_msg_newfeeds_read");
      paramQQAppInterface.addAction("notify_main_feeds_msg_newcomment_read");
      paramQQAppInterface.addAction("notify_main_feeds_msg_publish_fail");
      paramQQAppInterface.addAction("notify_main_feeds_msg_republish");
      paramQQAppInterface.addAction("notify_main_new_channel_clear");
      paramQQAppInterface.addAction("notify_main_guide_clear");
      paramQQAppInterface.addAction("config_local_channel_flag");
      paramQQAppInterface.addAction("config_follow_uin");
      paramQQAppInterface.addAction("config_update_app_setting");
      paramQQAppInterface.addAction("readInJoy_video_play_real_time_report");
      paramQQAppInterface.addAction("notify_main_share_friend_video");
      paramQQAppInterface.addAction("READINJOY_VIDEO_DATA_REPORT_WITH_FANS_INFO");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver, paramQQAppInterface);
      return;
    }
  }
  
  private long a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return 0L;
    }
    long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_process_seq", 0L) + 1L;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putLong("config_feeds_process_seq", l);
    ReadInJoyHelper.a(localEditor, true);
    return l;
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private Bundle a(Uri paramUri, int[] paramArrayOfInt, long paramLong, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: new 183	android/os/Bundle
    //   6: dup
    //   7: invokespecial 184	android/os/Bundle:<init>	()V
    //   10: astore 13
    //   12: getstatic 189	android/os/Build$VERSION:SDK_INT	I
    //   15: bipush 11
    //   17: if_icmpge +6 -> 23
    //   20: aload 13
    //   22: areturn
    //   23: ldc 191
    //   25: astore 10
    //   27: iconst_0
    //   28: istore 6
    //   30: iload 6
    //   32: aload_2
    //   33: arraylength
    //   34: if_icmpge +67 -> 101
    //   37: aload 10
    //   39: astore 11
    //   41: iload 6
    //   43: ifle +25 -> 68
    //   46: new 193	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   53: aload 10
    //   55: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 200
    //   60: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore 11
    //   68: new 193	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   75: aload 11
    //   77: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: iload 6
    //   83: iaload
    //   84: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 10
    //   92: iload 6
    //   94: iconst_1
    //   95: iadd
    //   96: istore 6
    //   98: goto -68 -> 30
    //   101: new 193	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   108: ldc 208
    //   110: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: lload_3
    //   114: invokestatic 213	java/lang/Long:toString	(J)Ljava/lang/String;
    //   117: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 215
    //   122: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 217
    //   127: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 219
    //   132: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 10
    //   137: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 221
    //   142: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore_2
    //   149: aload_0
    //   150: getfield 54	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   153: invokevirtual 143	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   156: invokevirtual 225	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   159: aload_1
    //   160: aconst_null
    //   161: aload_2
    //   162: aconst_null
    //   163: ldc 227
    //   165: invokevirtual 233	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   168: astore_2
    //   169: aload_2
    //   170: astore_1
    //   171: aload_2
    //   172: invokeinterface 239 1 0
    //   177: ifeq +130 -> 307
    //   180: aload_2
    //   181: astore_1
    //   182: aload 5
    //   184: arraylength
    //   185: istore 7
    //   187: iconst_0
    //   188: istore 6
    //   190: iload 6
    //   192: iload 7
    //   194: if_icmpge +113 -> 307
    //   197: aload 5
    //   199: iload 6
    //   201: aaload
    //   202: astore 10
    //   204: aload_2
    //   205: astore_1
    //   206: aload_2
    //   207: aload 10
    //   209: invokeinterface 243 2 0
    //   214: istore 8
    //   216: iload 8
    //   218: iflt +152 -> 370
    //   221: aload_2
    //   222: astore_1
    //   223: aload_2
    //   224: iload 8
    //   226: invokeinterface 247 2 0
    //   231: istore 9
    //   233: iload 9
    //   235: iconst_1
    //   236: if_icmpne +23 -> 259
    //   239: aload_2
    //   240: astore_1
    //   241: aload 13
    //   243: aload 10
    //   245: aload_2
    //   246: iload 8
    //   248: invokeinterface 250 2 0
    //   253: invokevirtual 253	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   256: goto +114 -> 370
    //   259: iload 9
    //   261: iconst_3
    //   262: if_icmpne +108 -> 370
    //   265: aload_2
    //   266: astore_1
    //   267: aload 13
    //   269: aload 10
    //   271: aload_2
    //   272: iload 8
    //   274: invokeinterface 257 2 0
    //   279: invokevirtual 261	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: goto +88 -> 370
    //   285: astore 5
    //   287: aload_2
    //   288: astore_1
    //   289: aload 5
    //   291: invokevirtual 264	java/lang/Exception:printStackTrace	()V
    //   294: aload_2
    //   295: ifnull +9 -> 304
    //   298: aload_2
    //   299: invokeinterface 267 1 0
    //   304: aload 13
    //   306: areturn
    //   307: aload_2
    //   308: astore_1
    //   309: aload 13
    //   311: ldc_w 269
    //   314: aload_2
    //   315: invokeinterface 272 1 0
    //   320: i2l
    //   321: invokevirtual 253	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   324: aload_2
    //   325: ifnull -21 -> 304
    //   328: aload_2
    //   329: invokeinterface 267 1 0
    //   334: goto -30 -> 304
    //   337: astore_1
    //   338: aload 12
    //   340: astore_2
    //   341: aload_2
    //   342: ifnull +9 -> 351
    //   345: aload_2
    //   346: invokeinterface 267 1 0
    //   351: aload_1
    //   352: athrow
    //   353: astore 5
    //   355: aload_1
    //   356: astore_2
    //   357: aload 5
    //   359: astore_1
    //   360: goto -19 -> 341
    //   363: astore 5
    //   365: aconst_null
    //   366: astore_2
    //   367: goto -80 -> 287
    //   370: iload 6
    //   372: iconst_1
    //   373: iadd
    //   374: istore 6
    //   376: goto -186 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	ReadInJoyManager
    //   0	379	1	paramUri	Uri
    //   0	379	2	paramArrayOfInt	int[]
    //   0	379	3	paramLong	long
    //   0	379	5	paramArrayOfString	String[]
    //   28	347	6	i	int
    //   185	10	7	j	int
    //   214	59	8	k	int
    //   231	32	9	m	int
    //   25	245	10	str1	String
    //   39	37	11	str2	String
    //   1	338	12	localObject	Object
    //   10	300	13	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   171	180	285	java/lang/Exception
    //   182	187	285	java/lang/Exception
    //   206	216	285	java/lang/Exception
    //   223	233	285	java/lang/Exception
    //   241	256	285	java/lang/Exception
    //   267	282	285	java/lang/Exception
    //   309	324	285	java/lang/Exception
    //   30	37	337	finally
    //   46	68	337	finally
    //   68	92	337	finally
    //   101	169	337	finally
    //   171	180	353	finally
    //   182	187	353	finally
    //   206	216	353	finally
    //   223	233	353	finally
    //   241	256	353	finally
    //   267	282	353	finally
    //   289	294	353	finally
    //   309	324	353	finally
    //   30	37	363	java/lang/Exception
    //   46	68	363	java/lang/Exception
    //   68	92	363	java/lang/Exception
    //   101	169	363	java/lang/Exception
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    Object localObject = ReadInJoyDataProvider.c.buildUpon();
    ((Uri.Builder)localObject).appendQueryParameter("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    localObject = ((Uri.Builder)localObject).build();
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_newfeeds_leba_read_id", 0L);
    Bundle localBundle = a((Uri)localObject, new int[] { 10 }, l1, new String[] { "_id", "feedsOwner" });
    long l2 = localBundle.getLong("unread");
    l1 = 0L;
    if (l2 > 0L)
    {
      l3 = localBundle.getLong("_id");
      l1 = localBundle.getLong("feedsOwner");
      localEditor.putLong("config_feeds_newfeeds_leba_max_id", l3);
    }
    localEditor.putLong("config_feeds_newfeeds_leba_unread_count", l2);
    localEditor.putLong("config_feeds_newfeeds_leba_latest_owner", l1);
    localEditor.putLong("config_feeds_newfeeds_leba_updated_time", NetConnInfoCenter.getServerTime());
    l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_newcomment_leba_read_id", 0L);
    localBundle = a((Uri)localObject, new int[] { 12, 11 }, l1, new String[] { "_id", "likeUin", "commentUin" });
    long l3 = localBundle.getLong("unread");
    l2 = 0L;
    l1 = 0L;
    if (l3 > 0L)
    {
      long l4 = localBundle.getLong("_id");
      l2 = localBundle.getLong("likeUin");
      l1 = localBundle.getLong("commentUin");
      localEditor.putLong("config_feeds_newcomment_leba_max_id", l4);
    }
    if (l2 > 0L) {}
    for (;;)
    {
      localEditor.putLong("config_feeds_newcomment_leba_latest_uin", l2);
      localEditor.putLong("config_feeds_newcomment_leba_unread_count", l3);
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_publishfail_leba_read_id", 0L);
      localObject = a((Uri)localObject, new int[] { 999999 }, l1, new String[] { "_id" });
      l1 = ((Bundle)localObject).getLong("unread");
      if (l1 > 0L) {
        localEditor.putLong("config_feeds_publishfail_leba_max_id", ((Bundle)localObject).getLong("_id"));
      }
      localEditor.putLong("config_feeds_publishfail_leba_unread_count", l1);
      ReadInJoyHelper.a(localEditor, true);
      b();
      return;
      l2 = l1;
    }
  }
  
  private boolean a(Uri paramUri, ReadInJoyFeedsMsgRecord paramReadInJoyFeedsMsgRecord, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("pushTime", Integer.valueOf(paramReadInJoyFeedsMsgRecord.jdField_a_of_type_Int));
    localContentValues.put("notifyType", Integer.valueOf(paramReadInJoyFeedsMsgRecord.jdField_c_of_type_Int));
    localContentValues.put("feedsOwner", Long.valueOf(paramReadInJoyFeedsMsgRecord.jdField_a_of_type_Long));
    localContentValues.put("feedsID", Long.valueOf(paramReadInJoyFeedsMsgRecord.jdField_b_of_type_Long));
    localContentValues.put("feedsSubject", paramReadInJoyFeedsMsgRecord.jdField_a_of_type_JavaLangString);
    localContentValues.put("deleteUin", Long.valueOf(paramReadInJoyFeedsMsgRecord.f));
    localContentValues.put("publishFail", Integer.valueOf(paramReadInJoyFeedsMsgRecord.jdField_d_of_type_Int));
    localContentValues.put("likeUin", Long.valueOf(paramReadInJoyFeedsMsgRecord.e));
    localContentValues.put("commentUin", Long.valueOf(paramReadInJoyFeedsMsgRecord.jdField_c_of_type_Long));
    localContentValues.put("commentID", paramReadInJoyFeedsMsgRecord.jdField_b_of_type_JavaLangString);
    localContentValues.put("replyUin", Long.valueOf(paramReadInJoyFeedsMsgRecord.jdField_d_of_type_Long));
    localContentValues.put("replyID", paramReadInJoyFeedsMsgRecord.jdField_c_of_type_JavaLangString);
    localContentValues.put("commentInfo", paramReadInJoyFeedsMsgRecord.jdField_d_of_type_JavaLangString);
    localContentValues.put("receiveTime", Long.valueOf(paramReadInJoyFeedsMsgRecord.g));
    localContentValues.put("processSeq", Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().insert(paramUri, localContentValues) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handlePushedFeedsMsgRecords, insertMsgRecordToFeedsTable failed, feedID=" + paramReadInJoyFeedsMsgRecord.jdField_b_of_type_Long + ", commentID=" + paramReadInJoyFeedsMsgRecord.jdField_b_of_type_JavaLangString);
      }
      return false;
    }
    return true;
  }
  
  private ReadInJoyNotifyRedTouchInfo b()
  {
    ReadInJoyNotifyRedTouchInfo localReadInJoyNotifyRedTouchInfo = new ReadInJoyNotifyRedTouchInfo();
    localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return localReadInJoyNotifyRedTouchInfo;
    }
    if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("share_to_news", false)) {
      return localReadInJoyNotifyRedTouchInfo;
    }
    long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_newfeeds_leba_latest_owner", 0L);
    int i;
    long l1;
    long l2;
    int j;
    label119:
    int k;
    label144:
    String str;
    label185:
    int m;
    if (l3 > 0L)
    {
      i = 1;
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_newcomment_leba_unread_count", 0L);
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_publishfail_leba_unread_count", 0L);
      if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("config_new_channel_id_list", null))) {
        break label344;
      }
      j = 1;
      k = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("config_new_channel_notify_flag", 0);
      if ((j == 0) || (k == -1)) {
        break label349;
      }
      j = 1;
      str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("config_notify_guide_wording", null);
      k = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("config_notify_guide_flag", 0);
      if ((str == null) || (k == -1)) {
        break label354;
      }
      k = 1;
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("readinjoy_push_channel_article_flag", 0) == -1) {
        break label359;
      }
      m = 1;
      label205:
      if (l1 <= 0L) {
        break label365;
      }
      localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 1;
      localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_Int = ((int)l1);
      localReadInJoyNotifyRedTouchInfo.jdField_d_of_type_Int = 3;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString))
      {
        k = localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString.length();
        if (k * 2 > this.jdField_a_of_type_Int)
        {
          i = 0;
          j = 0;
          label266:
          if (j < k)
          {
            if (localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString.charAt(j) >= 'ÿ') {
              break label741;
            }
            i += 1;
            label290:
            if ((i <= this.jdField_a_of_type_Int) || (j <= 0)) {
              break label748;
            }
            localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString = (localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString.substring(0, j) + "...");
          }
        }
      }
      return localReadInJoyNotifyRedTouchInfo;
      i = 0;
      break;
      label344:
      j = 0;
      break label119;
      label349:
      j = 0;
      break label144;
      label354:
      k = 0;
      break label185;
      label359:
      m = 0;
      break label205;
      label365:
      if (j == 0) {
        break label386;
      }
      localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 4;
      localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString = "新";
    }
    label386:
    if ((k != 0) || (i != 0) || (m != 0))
    {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_notify_guide_updated_time", 0L);
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_newfeeds_leba_updated_time", 0L);
      long l4 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("readinjoy_push_channel_article_updated_time", 0L);
      HashMap localHashMap = new HashMap();
      if (k != 0) {
        localHashMap.put(Integer.valueOf(1), Long.valueOf(l1));
      }
      if (i != 0) {
        localHashMap.put(Integer.valueOf(2), Long.valueOf(l2));
      }
      if (m != 0) {
        localHashMap.put(Integer.valueOf(5), Long.valueOf(l4));
      }
      Iterator localIterator = localHashMap.keySet().iterator();
      i = 0;
      l1 = 0L;
      label528:
      if (localIterator.hasNext())
      {
        j = ((Integer)localIterator.next()).intValue();
        l2 = ((Long)localHashMap.get(Integer.valueOf(j))).longValue();
        if (l2 <= l1) {
          break label755;
        }
        l1 = l2;
        i = j;
      }
    }
    label741:
    label748:
    label755:
    for (;;)
    {
      break label528;
      switch (i)
      {
      case 3: 
      case 4: 
      default: 
        break;
      case 1: 
        localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 2;
        localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString = str;
        localReadInJoyNotifyRedTouchInfo.jdField_d_of_type_Int = i;
        break;
      case 2: 
        localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 2;
        localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString = ContactUtils.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(l3));
        localReadInJoyNotifyRedTouchInfo.jdField_d_of_type_Int = i;
        break;
      case 5: 
        localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 2;
        localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("readinjoy_push_channel_article_content_wording", "");
        localReadInJoyNotifyRedTouchInfo.jdField_d_of_type_Int = i;
        break;
        if (l2 <= 0L) {
          break;
        }
        localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 3;
        localReadInJoyNotifyRedTouchInfo.jdField_c_of_type_Int = 2130842532;
        localReadInJoyNotifyRedTouchInfo.jdField_d_of_type_Int = 4;
        break;
        i += 2;
        break label290;
        j += 1;
        break label266;
      }
    }
  }
  
  private void b()
  {
    ReadInJoyNotifyRedTouchInfo localReadInJoyNotifyRedTouchInfo = b();
    int i = localReadInJoyNotifyRedTouchInfo.a(a());
    if (i != 0)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.set(0, localReadInJoyNotifyRedTouchInfo);
      ((ReadInJoyHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(62)).a(true, true, i);
    }
  }
  
  public BusinessInfoCheckUpdate.AppInfo a()
  {
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null) {
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = new BusinessInfoCheckUpdate.AppInfo();
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.clear();
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo == null) {
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo;
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.clear();
    }
  }
  
  public ReadInJoyNotifyRedTouchInfo a()
  {
    return (ReadInJoyNotifyRedTouchInfo)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0);
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    switch (a().jdField_d_of_type_Int)
    {
    default: 
      return;
    case 2: 
    case 3: 
    case 4: 
      paramIntent.putExtra("channel_id", 9999);
      return;
    }
    long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("readinjoy_push_channel_article_content_channel_id", 0L);
    String str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("readinjoy_push_channel_article_content_channel_name", "推荐");
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("readinjoy_push_channel_article_content_article_id_list", "");
    ArrayList localArrayList = new ArrayList(((String)localObject).length());
    localObject = StringUtil.a((String)localObject, ',');
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      CharSequence localCharSequence = localObject[i];
      if (!TextUtils.isEmpty(localCharSequence)) {
        localArrayList.add(Long.valueOf(Long.parseLong(localCharSequence)));
      }
      i += 1;
    }
    paramIntent.putExtra("channel_id", (int)l);
    paramIntent.putExtra("channel_name", str);
    paramIntent.putExtra("subscription_all_article_id", localArrayList);
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new zvz(this, paramList));
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.readinjoy.ReadInJoyManager
 * JD-Core Version:    0.7.0.1
 */