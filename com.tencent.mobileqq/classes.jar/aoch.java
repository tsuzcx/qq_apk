import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoch
  extends BusinessHandler
{
  public aoch(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 21	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +53 -> 56
    //   6: aload_1
    //   7: invokestatic 27	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +46 -> 56
    //   13: ldc 29
    //   15: iconst_2
    //   16: new 31	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   23: ldc 36
    //   25: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 42
    //   34: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload_2
    //   38: invokevirtual 45	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: ldc 47
    //   43: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: lload_3
    //   47: invokevirtual 50	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   50: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 58	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: new 60	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody
    //   59: dup
    //   60: invokespecial 61	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:<init>	()V
    //   63: astore 5
    //   65: aload 5
    //   67: getfield 65	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   70: aload_0
    //   71: getfield 69	aoch:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   74: invokevirtual 74	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   77: invokestatic 80	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   80: invokevirtual 86	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   83: aload 5
    //   85: getfield 90	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:clientver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   88: ldc 92
    //   90: invokevirtual 97	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   93: aload 5
    //   95: getfield 101	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   98: bipush 109
    //   100: invokevirtual 106	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   103: aload 5
    //   105: getfield 109	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   108: new 31	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   115: getstatic 115	android/os/Build$VERSION:SDK_INT	I
    //   118: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: ldc 120
    //   123: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokevirtual 97	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   132: aload 5
    //   134: getfield 123	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   137: aload_1
    //   138: invokestatic 128	bbbq:a	(Ljava/lang/String;)I
    //   141: invokevirtual 106	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   144: new 130	org/json/JSONObject
    //   147: dup
    //   148: invokespecial 131	org/json/JSONObject:<init>	()V
    //   151: astore 6
    //   153: aload 6
    //   155: ldc 133
    //   157: iconst_4
    //   158: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   161: pop
    //   162: aload 6
    //   164: ldc 139
    //   166: iload_2
    //   167: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   170: pop
    //   171: aload 6
    //   173: ldc 144
    //   175: lload_3
    //   176: invokevirtual 147	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   179: pop
    //   180: aload 5
    //   182: getfield 150	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   185: aload 6
    //   187: invokevirtual 151	org/json/JSONObject:toString	()Ljava/lang/String;
    //   190: invokevirtual 97	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   193: aload_0
    //   194: ldc 153
    //   196: invokevirtual 157	aoch:createToServiceMsg	(Ljava/lang/String;)Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   199: astore 6
    //   201: aload 6
    //   203: getfield 163	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   206: ldc 165
    //   208: iconst_1
    //   209: invokevirtual 171	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   212: aload 6
    //   214: getfield 163	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   217: ldc 173
    //   219: aload 5
    //   221: getfield 123	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   224: invokevirtual 177	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   227: invokevirtual 171	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   230: aload 6
    //   232: getfield 163	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   235: ldc 179
    //   237: iload_2
    //   238: invokevirtual 183	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   241: aload 6
    //   243: aload 5
    //   245: invokevirtual 187	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:toByteArray	()[B
    //   248: invokevirtual 191	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   251: aload_0
    //   252: aload 6
    //   254: invokespecial 195	com/tencent/mobileqq/app/BusinessHandler:sendPbReq	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   257: aload_1
    //   258: invokestatic 80	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   261: ldc2_w 196
    //   264: lcmp
    //   265: ifne +79 -> 344
    //   268: iload_2
    //   269: ifeq +50 -> 319
    //   272: aconst_null
    //   273: ldc 199
    //   275: ldc 201
    //   277: ldc 120
    //   279: ldc 203
    //   281: ldc 205
    //   283: iconst_0
    //   284: iconst_0
    //   285: ldc 120
    //   287: ldc 120
    //   289: ldc 120
    //   291: ldc 120
    //   293: invokestatic 211	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   296: return
    //   297: astore 6
    //   299: invokestatic 21	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq -109 -> 193
    //   305: ldc 213
    //   307: iconst_2
    //   308: aload 6
    //   310: invokevirtual 214	org/json/JSONException:toString	()Ljava/lang/String;
    //   313: invokestatic 58	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: goto -123 -> 193
    //   319: aconst_null
    //   320: ldc 199
    //   322: ldc 201
    //   324: ldc 120
    //   326: ldc 203
    //   328: ldc 216
    //   330: iconst_0
    //   331: iconst_0
    //   332: ldc 120
    //   334: ldc 120
    //   336: ldc 120
    //   338: ldc 120
    //   340: invokestatic 211	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   343: return
    //   344: aload_1
    //   345: invokestatic 80	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   348: getstatic 220	nyv:a	I
    //   351: i2l
    //   352: lcmp
    //   353: ifne -57 -> 296
    //   356: iload_2
    //   357: ifeq +37 -> 394
    //   360: ldc 222
    //   362: ldc 224
    //   364: iconst_0
    //   365: iconst_0
    //   366: iconst_4
    //   367: anewarray 226	java/lang/String
    //   370: dup
    //   371: iconst_0
    //   372: ldc 120
    //   374: aastore
    //   375: dup
    //   376: iconst_1
    //   377: ldc 120
    //   379: aastore
    //   380: dup
    //   381: iconst_2
    //   382: ldc 120
    //   384: aastore
    //   385: dup
    //   386: iconst_3
    //   387: ldc 120
    //   389: aastore
    //   390: invokestatic 231	ykv:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   393: return
    //   394: ldc 222
    //   396: ldc 233
    //   398: iconst_0
    //   399: iconst_0
    //   400: iconst_4
    //   401: anewarray 226	java/lang/String
    //   404: dup
    //   405: iconst_0
    //   406: ldc 120
    //   408: aastore
    //   409: dup
    //   410: iconst_1
    //   411: ldc 120
    //   413: aastore
    //   414: dup
    //   415: iconst_2
    //   416: ldc 120
    //   418: aastore
    //   419: dup
    //   420: iconst_3
    //   421: ldc 120
    //   423: aastore
    //   424: invokestatic 231	ykv:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   427: return
    //   428: astore_1
    //   429: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	this	aoch
    //   0	430	1	paramString	String
    //   0	430	2	paramBoolean	boolean
    //   0	430	3	paramLong	long
    //   63	181	5	localReportReqBody	com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody
    //   151	102	6	localObject	Object
    //   297	12	6	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   153	193	297	org/json/JSONException
    //   257	268	428	java/lang/Exception
    //   272	296	428	java/lang/Exception
    //   319	343	428	java/lang/Exception
    //   344	356	428	java/lang/Exception
    //   360	393	428	java/lang/Exception
    //   394	427	428	java/lang/Exception
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return aoci.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
                ajzy.a().a(this.app, i, bool, l1, l2);
              }
              QLog.i("Q.lebatab.mgr", 1, "leba_study onReceiver, [" + i + "," + bool + "," + l1 + "," + l2 + "]");
              notifyUI(2, true, Boolean.valueOf(bool));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoch
 * JD-Core Version:    0.7.0.1
 */