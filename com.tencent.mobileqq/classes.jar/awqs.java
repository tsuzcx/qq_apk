import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate.1;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate.2;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateReq;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateReqBatch;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateRsp;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateRspBatch;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class awqs
  implements azal
{
  int a;
  public QQAppInterface a;
  
  public awqs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private SummaryCardUpdate.SUpdateReq a(int paramInt, String paramString)
  {
    SummaryCardUpdate.SUpdateReq localSUpdateReq = new SummaryCardUpdate.SUpdateReq();
    localSUpdateReq.cmd.set(paramInt);
    localSUpdateReq.uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    localSUpdateReq.version.set(paramString);
    localSUpdateReq.client_version.set("8.3.5");
    localSUpdateReq.platform.set(109);
    if (paramInt == 5) {
      localSUpdateReq.appname.set("fun_call");
    }
    return localSUpdateReq;
  }
  
  private List<ProfileLabelTypeInfo> a(String paramString)
  {
    Object localObject1 = null;
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson labelConfigJsonData length is :" + paramString.length());
      }
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONArray(paramString);
      int k = paramString.length();
      int i = 0;
      while (i < k)
      {
        Object localObject2 = paramString.optJSONObject(i);
        localObject1 = new ProfileLabelTypeInfo();
        ((ProfileLabelTypeInfo)localObject1).typeId = ((JSONObject)localObject2).optString("id");
        ((ProfileLabelTypeInfo)localObject1).typeName = ((JSONObject)localObject2).optString("name");
        ((ProfileLabelTypeInfo)localObject1).typeInfo = ((JSONObject)localObject2).optString("classinfo");
        localObject2 = ((JSONObject)localObject2).optJSONArray("taglist");
        int j = 0;
        int m = ((JSONArray)localObject2).length();
        while (j < m)
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
          ProfileLabelInfo localProfileLabelInfo = new ProfileLabelInfo();
          localProfileLabelInfo.labelId = Long.valueOf(localJSONObject.optLong("id"));
          localProfileLabelInfo.labelName = localJSONObject.optString("name");
          localProfileLabelInfo.typeId = ((ProfileLabelTypeInfo)localObject1).typeId;
          ((ProfileLabelTypeInfo)localObject1).labels.add(localProfileLabelInfo);
          j += 1;
        }
        localArrayList.add(localObject1);
        i += 1;
      }
      localObject1 = localArrayList;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "downloadLabelConfigJson the new typeList size =" + localArrayList.size());
        localObject1 = localArrayList;
      }
    }
    return localObject1;
  }
  
  /* Error */
  private void a(File paramFile)
  {
    // Byte code:
    //   0: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +31 -> 34
    //   6: ldc 83
    //   8: iconst_2
    //   9: new 85	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   16: ldc 201
    //   18: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 206	java/io/File:exists	()Z
    //   25: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_1
    //   35: invokevirtual 206	java/io/File:exists	()Z
    //   38: ifeq +97 -> 135
    //   41: new 211	java/io/FileInputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 213	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: astore 4
    //   51: aload 4
    //   53: astore_3
    //   54: new 215	java/io/ByteArrayOutputStream
    //   57: dup
    //   58: invokespecial 216	java/io/ByteArrayOutputStream:<init>	()V
    //   61: astore 5
    //   63: aload 4
    //   65: astore_3
    //   66: sipush 4096
    //   69: newarray byte
    //   71: astore 6
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: aload 6
    //   80: iconst_0
    //   81: sipush 4096
    //   84: invokevirtual 222	java/io/InputStream:read	([BII)I
    //   87: istore_2
    //   88: iload_2
    //   89: iconst_m1
    //   90: if_icmpeq +46 -> 136
    //   93: aload 4
    //   95: astore_3
    //   96: aload 5
    //   98: aload 6
    //   100: iconst_0
    //   101: iload_2
    //   102: invokevirtual 226	java/io/ByteArrayOutputStream:write	([BII)V
    //   105: goto -32 -> 73
    //   108: astore_3
    //   109: aload 4
    //   111: astore_1
    //   112: aload_3
    //   113: astore 4
    //   115: aload_1
    //   116: astore_3
    //   117: ldc 83
    //   119: iconst_1
    //   120: ldc 228
    //   122: aload 4
    //   124: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 235	java/io/InputStream:close	()V
    //   135: return
    //   136: aload 4
    //   138: astore_3
    //   139: aload 4
    //   141: invokevirtual 235	java/io/InputStream:close	()V
    //   144: aload 4
    //   146: astore_3
    //   147: aload_1
    //   148: new 203	java/io/File
    //   151: dup
    //   152: aload_0
    //   153: getfield 18	awqs:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   156: invokevirtual 239	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   159: invokestatic 244	bddf:a	(Landroid/content/Context;)Ljava/lang/String;
    //   162: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   165: invokevirtual 249	java/io/File:renameTo	(Ljava/io/File;)Z
    //   168: pop
    //   169: aload 4
    //   171: astore_3
    //   172: new 94	java/lang/String
    //   175: dup
    //   176: aload 5
    //   178: invokevirtual 253	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   181: ldc 255
    //   183: invokespecial 258	java/lang/String:<init>	([BLjava/lang/String;)V
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull +21 -> 209
    //   191: aload 4
    //   193: astore_3
    //   194: aload_1
    //   195: invokevirtual 98	java/lang/String:length	()I
    //   198: ifle +11 -> 209
    //   201: aload 4
    //   203: astore_3
    //   204: aload_0
    //   205: aload_1
    //   206: invokespecial 260	awqs:a	(Ljava/lang/String;)V
    //   209: aload 4
    //   211: ifnull -76 -> 135
    //   214: aload 4
    //   216: invokevirtual 235	java/io/InputStream:close	()V
    //   219: return
    //   220: astore_1
    //   221: ldc 83
    //   223: iconst_1
    //   224: ldc 228
    //   226: aload_1
    //   227: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   230: return
    //   231: astore_1
    //   232: aload 4
    //   234: astore_3
    //   235: aload_1
    //   236: invokevirtual 263	java/lang/Exception:printStackTrace	()V
    //   239: goto -70 -> 169
    //   242: astore_1
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 235	java/io/InputStream:close	()V
    //   251: aload_1
    //   252: athrow
    //   253: astore_1
    //   254: ldc 83
    //   256: iconst_1
    //   257: ldc 228
    //   259: aload_1
    //   260: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   263: return
    //   264: astore_3
    //   265: ldc 83
    //   267: iconst_1
    //   268: ldc 228
    //   270: aload_3
    //   271: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   274: goto -23 -> 251
    //   277: astore_1
    //   278: aconst_null
    //   279: astore_3
    //   280: goto -37 -> 243
    //   283: astore 4
    //   285: aconst_null
    //   286: astore_1
    //   287: goto -172 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	awqs
    //   0	290	1	paramFile	File
    //   87	15	2	i	int
    //   53	43	3	localObject1	Object
    //   108	5	3	localException1	Exception
    //   116	132	3	localObject2	Object
    //   264	7	3	localException2	Exception
    //   279	1	3	localObject3	Object
    //   49	184	4	localObject4	Object
    //   283	1	4	localException3	Exception
    //   61	116	5	localByteArrayOutputStream	ByteArrayOutputStream
    //   71	28	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   54	63	108	java/lang/Exception
    //   66	73	108	java/lang/Exception
    //   76	88	108	java/lang/Exception
    //   96	105	108	java/lang/Exception
    //   139	144	108	java/lang/Exception
    //   172	187	108	java/lang/Exception
    //   194	201	108	java/lang/Exception
    //   204	209	108	java/lang/Exception
    //   235	239	108	java/lang/Exception
    //   214	219	220	java/lang/Exception
    //   147	169	231	java/lang/Exception
    //   54	63	242	finally
    //   66	73	242	finally
    //   76	88	242	finally
    //   96	105	242	finally
    //   117	127	242	finally
    //   139	144	242	finally
    //   147	169	242	finally
    //   172	187	242	finally
    //   194	201	242	finally
    //   204	209	242	finally
    //   235	239	242	finally
    //   131	135	253	java/lang/Exception
    //   247	251	264	java/lang/Exception
    //   41	51	277	finally
    //   41	51	283	java/lang/Exception
  }
  
  private void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramString);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      bdhb.a(new File(BaseApplicationImpl.getApplication().getFilesDir(), "labelList").getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
    }
  }
  
  private boolean b()
  {
    return false;
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    try
    {
      long l1 = BaseApplicationImpl.getApplication().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getLong("specialcareCheckUpdateTime", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject = new StringBuilder().append("isSendSpecialCareUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label191;
        }
      }
      label191:
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, bool1);
        if (l2 <= l1)
        {
          boolean bool3 = new File(BaseApplicationImpl.getApplication().getApplicationContext().getFilesDir(), "pddata/vas/special_remind/new_config.json").exists();
          bool1 = bool2;
          if (bool3) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean d()
  {
    try
    {
      long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("nextCheckUpdateTimeMillis", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject = new StringBuilder().append("isSendTemplateCheckUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label149;
        }
      }
      label149:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, bool);
        if (l2 <= l1) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    try
    {
      long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("nextCheckLabelUpdateTimeMillis", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject = new StringBuilder().append("isSendCheckLabelUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label190;
        }
      }
      label190:
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, bool1);
        localObject = new File(bddf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()));
        if (l2 <= l1)
        {
          boolean bool3 = ((File)localObject).exists();
          bool1 = bool2;
          if (bool3) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean f()
  {
    return false;
  }
  
  public int a()
  {
    return 3;
  }
  
  public ReqItem a(int paramInt)
  {
    Object localObject1;
    if (!a()) {
      localObject1 = null;
    }
    String str1;
    String str2;
    ReqItem localReqItem;
    int i;
    do
    {
      return localObject1;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      long l = System.currentTimeMillis();
      ((SharedPreferences)localObject1).edit().putLong("nextCheckUpdateTimeMillis", l + 3600000L).commit();
      str1 = ((SharedPreferences)localObject1).getString("cardTemplateVersion", "0");
      str2 = ((SharedPreferences)localObject1).getString("profileLabelVersion", "0");
      Object localObject2 = ((SharedPreferences)localObject1).getString("profileFuncallVersion", "0");
      String str3 = ((SharedPreferences)localObject1).getString("WebviewCGIWhitelistVersion", "0");
      localReqItem = new ReqItem();
      localReqItem.eServiceID = 122;
      localObject1 = new SummaryCardUpdate.SUpdateReqBatch();
      SummaryCardUpdate.SUpdateReq localSUpdateReq;
      if ((this.jdField_a_of_type_Int & 0x1) != 0)
      {
        localSUpdateReq = a(3, str1);
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add(localSUpdateReq);
      }
      if ((this.jdField_a_of_type_Int & 0x2) != 0)
      {
        localSUpdateReq = a(4, str2);
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add(localSUpdateReq);
      }
      if ((this.jdField_a_of_type_Int & 0x4) != 0)
      {
        localSUpdateReq = a(5, (String)localObject2);
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add(localSUpdateReq);
      }
      if ((this.jdField_a_of_type_Int & 0x8) != 0)
      {
        localObject2 = a(5, (String)localObject2);
        ((SummaryCardUpdate.SUpdateReq)localObject2).appname.set("special_remind");
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add((MessageMicro)localObject2);
      }
      if ((this.jdField_a_of_type_Int & 0x10) != 0)
      {
        localObject2 = a(6, str3);
        ((SummaryCardUpdate.SUpdateReq)localObject2).appname.set("white_list");
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add((MessageMicro)localObject2);
      }
      localObject1 = ((SummaryCardUpdate.SUpdateReqBatch)localObject1).toByteArray();
      paramInt = localObject1.length;
      i = paramInt + 4;
      localObject2 = new byte[i];
      System.arraycopy(bdas.b(i), 0, localObject2, 0, 4);
      System.arraycopy(localObject1, 0, localObject2, 4, paramInt);
      localReqItem.vecParam = ((byte[])localObject2);
      localObject1 = localReqItem;
    } while (!QLog.isColorLevel());
    QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "getCheckUpdateItemData uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin() + ",cardVersion=" + str1 + "labelVersion=" + str2 + ",client_version=" + "8.3.5" + ",dataLen=" + i);
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem != null)
    {
      int i = paramRespItem.cResult;
      Object localObject = paramRespItem.vecUpdate;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "handleCheckUpdateItemData result=" + i + ",dataLen=" + localObject.length);
      }
      if (i == 2) {
        for (;;)
        {
          try
          {
            if (localObject.length <= 4) {
              break;
            }
            i = (int)bdqa.a((byte[])localObject, 0);
            paramRespItem = new byte[i - 4];
            bdqa.a(paramRespItem, 0, (byte[])localObject, 4, i - 4);
            localObject = new SummaryCardUpdate.SUpdateRspBatch();
            ((SummaryCardUpdate.SUpdateRspBatch)localObject).mergeFrom(paramRespItem);
            if (((SummaryCardUpdate.SUpdateRspBatch)localObject).rsps.size() < 0)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate SUpdateRspBatch have no rsp");
              return;
            }
            paramRespItem = ((SummaryCardUpdate.SUpdateRspBatch)localObject).rsps.get().iterator();
            if (!paramRespItem.hasNext()) {
              break;
            }
            localObject = (SummaryCardUpdate.SUpdateRsp)paramRespItem.next();
            if (localObject == null) {
              continue;
            }
            i = ((SummaryCardUpdate.SUpdateRsp)localObject).cmd.get();
            if (i == 3)
            {
              e((SummaryCardUpdate.SUpdateRsp)localObject);
              continue;
            }
            if (i != 4) {
              break label242;
            }
          }
          catch (Exception paramRespItem)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate Exception msg=" + paramRespItem.getMessage());
            }
            paramRespItem.printStackTrace();
            return;
          }
          d((SummaryCardUpdate.SUpdateRsp)localObject);
          continue;
          label242:
          if (i == 5)
          {
            if ((((SummaryCardUpdate.SUpdateRsp)localObject).appname != null) && (((SummaryCardUpdate.SUpdateRsp)localObject).appname.get().equals("special_remind"))) {
              b((SummaryCardUpdate.SUpdateRsp)localObject);
            } else {
              a((SummaryCardUpdate.SUpdateRsp)localObject);
            }
          }
          else if (i == 6) {
            c((SummaryCardUpdate.SUpdateRsp)localObject);
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleCheckUpdateItemData respitem is null");
    }
  }
  
  public void a(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    paramSUpdateRsp.buff.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleFunCallRsp data code=" + i + ",version=" + str1 + ",url=" + str2 + ",interval=" + j);
    }
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate code == 0" + j);
      }
      return;
    }
    bfhz.a().a("SummaryCardUpdate.EM_RT_FUN_CALL", 100, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, alud.a(2131708845), true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ThreadManagerV2.excute(new ProfileCardCheckUpdate.2(this, paramString1, paramString2), 128, null, false);
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool3 = d();
    boolean bool4 = e();
    boolean bool5 = b();
    boolean bool6 = c();
    boolean bool2 = f();
    int j = this.jdField_a_of_type_Int;
    if (bool3)
    {
      i = 1;
      this.jdField_a_of_type_Int = (i | j);
      j = this.jdField_a_of_type_Int;
      if (!bool4) {
        break label163;
      }
      i = 2;
      label63:
      this.jdField_a_of_type_Int = (i | j);
      j = this.jdField_a_of_type_Int;
      if (!bool5) {
        break label168;
      }
      i = 4;
      label82:
      this.jdField_a_of_type_Int = (i | j);
      j = this.jdField_a_of_type_Int;
      if (!bool6) {
        break label173;
      }
      i = 8;
      label102:
      this.jdField_a_of_type_Int = (i | j);
      j = this.jdField_a_of_type_Int;
      if (!bool2) {
        break label178;
      }
    }
    label163:
    label168:
    label173:
    label178:
    for (int i = 16;; i = 0)
    {
      this.jdField_a_of_type_Int = (i | j);
      if ((bool3) || (bool4) || (bool5) || (bool6) || (bool2)) {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
      i = 0;
      break label63;
      i = 0;
      break label82;
      i = 0;
      break label102;
    }
  }
  
  public void b(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str2 = paramSUpdateRsp.version.get();
    String str1 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSpecialCareRsp data code=" + i + ",version=" + str2 + ",url=" + str1 + ",interval=" + j);
    }
    if (i == 0)
    {
      paramSUpdateRsp = BaseApplicationImpl.getApplication().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      str2 = paramSUpdateRsp.getString("specialcare_config", "");
      if (j >= 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = j * 1000;
        paramSUpdateRsp.edit().putLong("specialcareCheckUpdateTime", l1 + l2).commit();
      }
      if ((str1 != null) && (!str1.equals(str2)))
      {
        paramSUpdateRsp.edit().putString("specialcare_config", str1).commit();
        paramSUpdateRsp.edit().putBoolean("special_care_red_point_one", true).commit();
        paramSUpdateRsp.edit().putBoolean("special_care_red_point_two", true).commit();
        ThreadManager.post(new ProfileCardCheckUpdate.1(this), 5, null, true);
      }
      return;
    }
    bfhz.a().a("SummaryCardUpdate.EM_RT_SPECIAL_REMIND", 100, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, alud.a(2131708880), true);
  }
  
  public void c(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp) {}
  
  public void d(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSummaryLabelRsp data code=" + i + ",version=" + str1 + ",url=" + str2 + ",interval=" + j);
    }
    if (i == 0)
    {
      paramSUpdateRsp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      if (j >= 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = j * 1000;
        paramSUpdateRsp.edit().putLong("nextCheckLabelUpdateTimeMillis", l1 + l2).commit();
      }
      if ((!paramSUpdateRsp.getString("profileLabelVersion", "0").equals(str1)) && (str2 != null)) {
        a(str2, str1);
      }
      return;
    }
    bfhz.a().a("SummaryCardUpdate.EM_RT_SUMMARY_LABEL", 100, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, alud.a(2131708850), true);
  }
  
  public void e(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSummaryUpdateRsp data code=" + i + ",version=" + str1 + ",url=" + str2 + ",interval=" + j);
    }
    if (i == 0)
    {
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (j >= 0))
      {
        paramSUpdateRsp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
        paramSUpdateRsp.putLong("nextCheckUpdateTimeMillis", System.currentTimeMillis() + j * 1000);
        paramSUpdateRsp.putString("cardTemplateServerUrl", str2);
        paramSUpdateRsp.putString("cardTemplateServerVersion", str1);
        paramSUpdateRsp.commit();
      }
      return;
    }
    bfhz.a().a("SummaryCardUpdate.EM_RT_SUMMARY_UPDATE", 100, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, alud.a(2131708870), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awqs
 * JD-Core Version:    0.7.0.1
 */