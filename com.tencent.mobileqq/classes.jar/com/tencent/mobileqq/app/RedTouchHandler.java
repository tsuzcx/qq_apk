package com.tencent.mobileqq.app;

import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class RedTouchHandler
  extends BusinessHandler
{
  public RedTouchHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return RedTouchObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((!paramFromServiceMsg.getServiceCmd().equals("RedTouchSvc.EntranceSetting")) || (!paramFromServiceMsg.isSuccess())) {}
    do
    {
      for (;;)
      {
        return;
        paramToServiceMsg = new BusinessInfoCheckUpdate.ReportRspBody();
        try
        {
          paramFromServiceMsg = (BusinessInfoCheckUpdate.ReportRspBody)paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramToServiceMsg = paramFromServiceMsg;
          if (paramToServiceMsg.code.get() == 0)
          {
            i = paramToServiceMsg.appid.get();
            paramToServiceMsg = paramToServiceMsg.buffer.get();
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          try
          {
            int i;
            paramToServiceMsg = new JSONObject(paramToServiceMsg);
            if (paramToServiceMsg.getInt("cmd") == 4)
            {
              boolean bool = paramToServiceMsg.getBoolean("setting");
              long l1 = paramToServiceMsg.getLong("modify_ts");
              long l2 = paramToServiceMsg.getLong("server_ts");
              if ((l1 != l2) && (l2 > 0L)) {
                LebaShowListManager.a().a(this.b, i, bool, l1, l2);
              }
              if (QLog.isColorLevel()) {
                QLog.i("Q.lebatab.mgr", 4, "onReceiver, [" + i + "," + bool + "," + l1 + "," + l2 + "]");
              }
              a(2, true, Boolean.valueOf(bool));
              return;
            }
          }
          catch (Exception paramToServiceMsg)
          {
            if (QLog.isColorLevel())
            {
              QLog.i("Q.lebatab.mgr", 2, paramToServiceMsg.toString());
              return;
              paramFromServiceMsg = paramFromServiceMsg;
              paramToServiceMsg.code.set(-1);
              paramToServiceMsg.errmsg.set("prb.mergeFrom exception");
              paramFromServiceMsg.printStackTrace();
            }
          }
          catch (Throwable paramToServiceMsg) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.lebatab.mgr", 2, paramToServiceMsg.toString());
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +53 -> 56
    //   6: aload_1
    //   7: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +46 -> 56
    //   13: ldc 181
    //   15: iconst_2
    //   16: new 118	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   23: ldc 183
    //   25: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 185
    //   34: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload_2
    //   38: invokevirtual 133	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: ldc 187
    //   43: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: lload_3
    //   47: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   50: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 145	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: new 189	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody
    //   59: dup
    //   60: invokespecial 190	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:<init>	()V
    //   63: astore 5
    //   65: aload 5
    //   67: getfield 194	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   70: aload_0
    //   71: getfield 106	com/tencent/mobileqq/app/RedTouchHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   74: invokevirtual 199	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   77: invokestatic 204	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   80: invokevirtual 209	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   83: aload 5
    //   85: getfield 212	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:clientver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   88: ldc 214
    //   90: invokevirtual 166	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   93: aload 5
    //   95: getfield 217	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   98: bipush 109
    //   100: invokevirtual 218	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   103: aload 5
    //   105: getfield 221	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   108: new 118	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   115: getstatic 227	android/os/Build$VERSION:SDK_INT	I
    //   118: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: ldc 229
    //   123: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokevirtual 166	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   132: aload 5
    //   134: getfield 230	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   137: aload_1
    //   138: invokestatic 234	com/tencent/mobileqq/redtouch/RedTouchManager:a	(Ljava/lang/String;)I
    //   141: invokevirtual 218	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   144: new 74	org/json/JSONObject
    //   147: dup
    //   148: invokespecial 235	org/json/JSONObject:<init>	()V
    //   151: astore 6
    //   153: aload 6
    //   155: ldc 79
    //   157: iconst_4
    //   158: invokevirtual 239	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   161: pop
    //   162: aload 6
    //   164: ldc 85
    //   166: iload_2
    //   167: invokevirtual 242	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   170: pop
    //   171: aload 6
    //   173: ldc 91
    //   175: lload_3
    //   176: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   179: pop
    //   180: aload 5
    //   182: getfield 246	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   185: aload 6
    //   187: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   190: invokevirtual 166	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   193: aload_0
    //   194: ldc 26
    //   196: invokevirtual 250	com/tencent/mobileqq/app/RedTouchHandler:a	(Ljava/lang/String;)Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   199: astore 6
    //   201: aload 6
    //   203: getfield 256	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   206: ldc_w 258
    //   209: iconst_1
    //   210: invokevirtual 264	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   213: aload 6
    //   215: getfield 256	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   218: ldc_w 266
    //   221: aload 5
    //   223: getfield 230	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   226: invokevirtual 64	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   229: invokevirtual 264	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   232: aload 6
    //   234: getfield 256	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   237: ldc_w 268
    //   240: iload_2
    //   241: invokevirtual 272	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   244: aload 6
    //   246: aload 5
    //   248: invokevirtual 276	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:toByteArray	()[B
    //   251: invokevirtual 280	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   254: aload_0
    //   255: aload 6
    //   257: invokespecial 283	com/tencent/mobileqq/app/BusinessHandler:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   260: aload_1
    //   261: invokestatic 204	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   264: ldc2_w 284
    //   267: lcmp
    //   268: ifne +87 -> 355
    //   271: iload_2
    //   272: ifeq +54 -> 326
    //   275: aconst_null
    //   276: ldc_w 287
    //   279: ldc_w 289
    //   282: ldc 229
    //   284: ldc_w 291
    //   287: ldc_w 293
    //   290: iconst_0
    //   291: iconst_0
    //   292: ldc 229
    //   294: ldc 229
    //   296: ldc 229
    //   298: ldc 229
    //   300: invokestatic 298	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   303: return
    //   304: astore 6
    //   306: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq -116 -> 193
    //   312: ldc 116
    //   314: iconst_2
    //   315: aload 6
    //   317: invokevirtual 299	org/json/JSONException:toString	()Ljava/lang/String;
    //   320: invokestatic 145	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: goto -130 -> 193
    //   326: aconst_null
    //   327: ldc_w 287
    //   330: ldc_w 289
    //   333: ldc 229
    //   335: ldc_w 291
    //   338: ldc_w 301
    //   341: iconst_0
    //   342: iconst_0
    //   343: ldc 229
    //   345: ldc 229
    //   347: ldc 229
    //   349: ldc 229
    //   351: invokestatic 298	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   354: return
    //   355: aload_1
    //   356: invokestatic 204	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   359: ldc2_w 302
    //   362: lcmp
    //   363: ifne -60 -> 303
    //   366: iload_2
    //   367: ifeq +39 -> 406
    //   370: ldc_w 305
    //   373: ldc_w 307
    //   376: iconst_0
    //   377: iconst_0
    //   378: iconst_4
    //   379: anewarray 28	java/lang/String
    //   382: dup
    //   383: iconst_0
    //   384: ldc 229
    //   386: aastore
    //   387: dup
    //   388: iconst_1
    //   389: ldc 229
    //   391: aastore
    //   392: dup
    //   393: iconst_2
    //   394: ldc 229
    //   396: aastore
    //   397: dup
    //   398: iconst_3
    //   399: ldc 229
    //   401: aastore
    //   402: invokestatic 312	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   405: return
    //   406: ldc_w 305
    //   409: ldc_w 314
    //   412: iconst_0
    //   413: iconst_0
    //   414: iconst_4
    //   415: anewarray 28	java/lang/String
    //   418: dup
    //   419: iconst_0
    //   420: ldc 229
    //   422: aastore
    //   423: dup
    //   424: iconst_1
    //   425: ldc 229
    //   427: aastore
    //   428: dup
    //   429: iconst_2
    //   430: ldc 229
    //   432: aastore
    //   433: dup
    //   434: iconst_3
    //   435: ldc 229
    //   437: aastore
    //   438: invokestatic 312	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   441: return
    //   442: astore_1
    //   443: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	RedTouchHandler
    //   0	444	1	paramString	String
    //   0	444	2	paramBoolean	boolean
    //   0	444	3	paramLong	long
    //   63	184	5	localReportReqBody	com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody
    //   151	105	6	localObject	Object
    //   304	12	6	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   153	193	304	org/json/JSONException
    //   260	271	442	java/lang/Exception
    //   275	303	442	java/lang/Exception
    //   326	354	442	java/lang/Exception
    //   355	366	442	java/lang/Exception
    //   370	405	442	java/lang/Exception
    //   406	441	442	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RedTouchHandler
 * JD-Core Version:    0.7.0.1
 */