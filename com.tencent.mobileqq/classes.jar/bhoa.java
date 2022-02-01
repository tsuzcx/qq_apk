import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.ims.bankcode_info.ElemPos;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.3;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.5;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class bhoa
{
  private static int jdField_a_of_type_Int;
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bhod();
  private static Bundle jdField_a_of_type_AndroidOsBundle = new Bundle();
  private static bhoa jdField_a_of_type_Bhoa;
  private static String jdField_a_of_type_JavaLangString = "0";
  
  private static int a(String paramString, int paramInt)
  {
    int k = 0;
    if (paramInt > 0) {
      i = paramInt;
    }
    while (k < paramInt) {
      try
      {
        int m = paramString.codePointAt(k);
        int j;
        if (m == 20) {
          j = i + 1;
        }
        for (;;)
        {
          k += 1;
          i = j;
          break;
          i = 0;
          break;
          j = i;
          if (EmotcationConstants.EMOJI_MAP.get(m, -1) >= 0)
          {
            j = i;
            if (m > 65535) {
              j = i + 1;
            }
          }
        }
        return i;
      }
      catch (Exception paramString) {}
    }
  }
  
  public static bhoa a()
  {
    if (jdField_a_of_type_Bhoa == null)
    {
      jdField_a_of_type_Bhoa = new bhoa();
      a();
    }
    return jdField_a_of_type_Bhoa;
  }
  
  private static Object a(String paramString, int paramInt, long paramLong, boolean paramBoolean, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo)
  {
    return new bhoe(paramString, paramInt, paramLong, paramBankcodeCtrlInfo, paramBoolean);
  }
  
  private static void a()
  {
    Object localObject = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
    BaseApplication.getContext().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null) {}
    while (!((AppRuntime)localObject).isLogin()) {
      return;
    }
    c(((AppRuntime)localObject).getAccount());
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramSpannableStringBuilder == null) {
      return;
    }
    Object[] arrayOfObject = paramSpannableStringBuilder.getSpans(paramInt1, paramInt2, Object.class);
    int j = arrayOfObject.length;
    int i = 0;
    label22:
    Object localObject;
    int k;
    int m;
    int n;
    if (i < j)
    {
      localObject = arrayOfObject[i];
      k = paramSpannableStringBuilder.getSpanStart(localObject);
      m = paramSpannableStringBuilder.getSpanEnd(localObject);
      n = paramSpannableStringBuilder.getSpanFlags(localObject);
      if ((k >= paramInt1) || (m > paramInt2)) {
        break label88;
      }
      paramSpannableStringBuilder.setSpan(localObject, k, paramInt1, n);
    }
    for (;;)
    {
      i += 1;
      break label22;
      break;
      label88:
      if ((k >= paramInt1) && (m <= paramInt2) && (!(localObject instanceof QQText.EmoticonSpan)))
      {
        paramSpannableStringBuilder.removeSpan(localObject);
      }
      else if ((k > paramInt1) && (k < paramInt2) && (m > paramInt2))
      {
        paramSpannableStringBuilder.setSpan(localObject, paramInt2, m, n);
      }
      else if ((k < paramInt1) && (m > paramInt2))
      {
        paramSpannableStringBuilder.setSpan(localObject, k, paramInt1, n);
        paramSpannableStringBuilder.setSpan(localObject, paramInt2, m, n);
      }
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = paramMessageRecord.getExtInfoFromExtStr("sens_msg_ctrl_info");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    Object localObject3 = new bankcode_info.BankcodeCtrlInfo();
    for (;;)
    {
      int i;
      try
      {
        ((bankcode_info.BankcodeCtrlInfo)localObject3).mergeFrom(HexUtil.hexStr2Bytes((String)localObject1));
        if (!((bankcode_info.BankcodeCtrlInfo)localObject3).bankcode_elems.has()) {
          break label253;
        }
        localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject3).bankcode_elems.get();
        if (localObject1 == null) {
          break;
        }
        localObject3 = ((List)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject3).hasNext())
        {
          bankcode_info.BankcodeElem localBankcodeElem = (bankcode_info.BankcodeElem)((Iterator)localObject3).next();
          if (!localBankcodeElem.bankcode_attr.has()) {
            break label248;
          }
          j = localBankcodeElem.bankcode_attr.get();
          if (j <= i) {
            break label243;
          }
          i = j;
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = null;
        continue;
      }
      if (i != 20) {
        break;
      }
      localObject3 = ((List)localObject2).iterator();
      label236:
      label238:
      label241:
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (bankcode_info.BankcodeElem)((Iterator)localObject3).next();
          if (!((bankcode_info.BankcodeElem)localObject2).bankcode_attr.has()) {
            break label238;
          }
        }
        for (i = ((bankcode_info.BankcodeElem)localObject2).bankcode_attr.get();; i = 0)
        {
          if (i != 20) {
            break label241;
          }
          if (((bankcode_info.BankcodeElem)localObject2).clean_bankcode.has()) {}
          for (localObject2 = ((bankcode_info.BankcodeElem)localObject2).clean_bankcode.get();; localObject2 = null)
          {
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label236;
            }
            a().a((String)localObject2);
            break;
            paramMessageRecord.saveExtInfoToExtStr("sens_msg_confirmed", "1");
            return;
          }
          break;
        }
      }
      label243:
      int j = i;
      continue;
      label248:
      j = 0;
      continue;
      label253:
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public static void a(MessageRecord paramMessageRecord, List<MessageRecord> paramList, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 17
    //   6: aconst_null
    //   7: astore 18
    //   9: new 151	com/tencent/ims/bankcode_info$BankcodeCtrlInfo
    //   12: dup
    //   13: invokespecial 152	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:<init>	()V
    //   16: astore 19
    //   18: aload 19
    //   20: aload_3
    //   21: invokevirtual 162	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   24: pop
    //   25: aload 19
    //   27: getfield 230	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:msgtail_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   30: invokevirtual 233	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   33: ifeq +1191 -> 1224
    //   36: aload 19
    //   38: getfield 230	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:msgtail_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   41: invokevirtual 234	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   44: istore 5
    //   46: aload 18
    //   48: astore_3
    //   49: aload 19
    //   51: getfield 166	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:bankcode_elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   54: invokevirtual 171	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   57: ifeq +12 -> 69
    //   60: aload 19
    //   62: getfield 166	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:bankcode_elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   65: invokevirtual 174	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   68: astore_3
    //   69: iload 5
    //   71: istore 9
    //   73: aload_3
    //   74: astore 18
    //   76: aload 19
    //   78: astore_3
    //   79: aload 18
    //   81: ifnonnull +26 -> 107
    //   84: return
    //   85: astore 18
    //   87: aconst_null
    //   88: astore_3
    //   89: iconst_0
    //   90: istore 5
    //   92: aload 18
    //   94: invokevirtual 204	java/lang/Exception:printStackTrace	()V
    //   97: aconst_null
    //   98: astore 18
    //   100: iload 5
    //   102: istore 9
    //   104: goto -25 -> 79
    //   107: aload_0
    //   108: ldc 236
    //   110: invokevirtual 143	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 19
    //   115: aload 19
    //   117: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifne +205 -> 325
    //   123: aload 19
    //   125: invokestatic 242	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   128: istore 5
    //   130: iload 17
    //   132: istore 16
    //   134: iload 5
    //   136: bipush 20
    //   138: if_icmpne +26 -> 164
    //   141: aload_0
    //   142: ldc 244
    //   144: invokevirtual 143	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   147: astore 19
    //   149: aload 19
    //   151: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifne +255 -> 409
    //   157: aload 19
    //   159: invokestatic 250	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   162: istore 16
    //   164: iload_2
    //   165: ifne +1025 -> 1190
    //   168: iload 9
    //   170: iconst_1
    //   171: if_icmpne +1019 -> 1190
    //   174: iload 5
    //   176: bipush 30
    //   178: if_icmpeq +15 -> 193
    //   181: iload 5
    //   183: bipush 20
    //   185: if_icmpne +1005 -> 1190
    //   188: iload 16
    //   190: ifeq +1000 -> 1190
    //   193: iconst_1
    //   194: istore 16
    //   196: aload_0
    //   197: ldc 252
    //   199: iload 16
    //   201: invokestatic 256	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   204: invokevirtual 225	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: iconst_0
    //   208: istore 5
    //   210: aload_1
    //   211: invokeinterface 180 1 0
    //   216: astore 20
    //   218: iconst_0
    //   219: istore 10
    //   221: iconst_0
    //   222: istore 7
    //   224: aload 20
    //   226: invokeinterface 185 1 0
    //   231: ifeq -147 -> 84
    //   234: aload 20
    //   236: invokeinterface 189 1 0
    //   241: checkcast 140	com/tencent/mobileqq/data/MessageRecord
    //   244: astore 21
    //   246: aload 21
    //   248: instanceof 258
    //   251: ifeq +878 -> 1129
    //   254: iload 5
    //   256: istore 11
    //   258: iload 5
    //   260: istore 6
    //   262: iload 11
    //   264: aload 18
    //   266: invokeinterface 261 1 0
    //   271: if_icmpge +916 -> 1187
    //   274: iload 11
    //   276: iconst_1
    //   277: iadd
    //   278: istore 14
    //   280: aload 18
    //   282: iload 11
    //   284: invokeinterface 264 2 0
    //   289: checkcast 191	com/tencent/ims/bankcode_info$BankcodeElem
    //   292: astore 22
    //   294: aload 22
    //   296: ifnonnull +224 -> 520
    //   299: iload 11
    //   301: iconst_1
    //   302: iadd
    //   303: istore 11
    //   305: iload 14
    //   307: istore 6
    //   309: goto -47 -> 262
    //   312: astore 19
    //   314: aload 19
    //   316: invokevirtual 204	java/lang/Exception:printStackTrace	()V
    //   319: iconst_0
    //   320: istore 5
    //   322: goto -192 -> 130
    //   325: aload 18
    //   327: invokeinterface 180 1 0
    //   332: astore 19
    //   334: iload 6
    //   336: istore 5
    //   338: aload 19
    //   340: invokeinterface 185 1 0
    //   345: ifeq +876 -> 1221
    //   348: aload 19
    //   350: invokeinterface 189 1 0
    //   355: checkcast 191	com/tencent/ims/bankcode_info$BankcodeElem
    //   358: astore 20
    //   360: aload 20
    //   362: getfield 195	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   365: invokevirtual 198	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   368: ifeq +847 -> 1215
    //   371: aload 20
    //   373: getfield 195	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   376: invokevirtual 201	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   379: istore 6
    //   381: iload 6
    //   383: iload 5
    //   385: if_icmple +823 -> 1208
    //   388: iload 6
    //   390: istore 5
    //   392: goto -54 -> 338
    //   395: astore 19
    //   397: aload 19
    //   399: invokevirtual 204	java/lang/Exception:printStackTrace	()V
    //   402: iload 17
    //   404: istore 16
    //   406: goto -242 -> 164
    //   409: aload 18
    //   411: invokeinterface 180 1 0
    //   416: astore 20
    //   418: iconst_0
    //   419: istore 16
    //   421: aload 20
    //   423: invokeinterface 185 1 0
    //   428: ifeq +777 -> 1205
    //   431: aload 20
    //   433: invokeinterface 189 1 0
    //   438: checkcast 191	com/tencent/ims/bankcode_info$BankcodeElem
    //   441: astore 19
    //   443: iconst_0
    //   444: istore 6
    //   446: aload 19
    //   448: getfield 195	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   451: invokevirtual 198	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   454: ifeq +13 -> 467
    //   457: aload 19
    //   459: getfield 195	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   462: invokevirtual 201	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   465: istore 6
    //   467: iload 6
    //   469: bipush 20
    //   471: if_icmpne -50 -> 421
    //   474: aload 19
    //   476: getfield 208	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   479: invokevirtual 211	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   482: ifeq +717 -> 1199
    //   485: aload 19
    //   487: getfield 208	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   490: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   493: astore 19
    //   495: aload 19
    //   497: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   500: ifne +696 -> 1196
    //   503: invokestatic 215	bhoa:a	()Lbhoa;
    //   506: aload 19
    //   508: invokevirtual 266	bhoa:a	(Ljava/lang/String;)Z
    //   511: ifne +685 -> 1196
    //   514: iconst_1
    //   515: istore 16
    //   517: goto -96 -> 421
    //   520: iconst_0
    //   521: istore 8
    //   523: iconst_0
    //   524: istore 6
    //   526: aload 22
    //   528: getfield 270	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   531: invokevirtual 273	com/tencent/ims/bankcode_info$ElemPos:has	()Z
    //   534: ifeq +643 -> 1177
    //   537: aload 22
    //   539: getfield 270	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   542: invokevirtual 276	com/tencent/ims/bankcode_info$ElemPos:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   545: checkcast 272	com/tencent/ims/bankcode_info$ElemPos
    //   548: astore_1
    //   549: aload_1
    //   550: getfield 279	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   553: invokevirtual 233	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   556: ifeq +12 -> 568
    //   559: aload_1
    //   560: getfield 279	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   563: invokevirtual 234	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   566: istore 6
    //   568: iload 6
    //   570: istore 8
    //   572: aload_1
    //   573: getfield 282	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   576: invokevirtual 233	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   579: ifeq +598 -> 1177
    //   582: aload_1
    //   583: getfield 282	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   586: invokevirtual 234	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   589: istore 12
    //   591: iload 6
    //   593: istore 13
    //   595: iload 12
    //   597: iload 10
    //   599: if_icmplt -300 -> 299
    //   602: iload 13
    //   604: aload 21
    //   606: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   609: invokevirtual 288	java/lang/String:length	()I
    //   612: iload 10
    //   614: iadd
    //   615: if_icmpgt -316 -> 299
    //   618: iconst_0
    //   619: istore 8
    //   621: iconst_0
    //   622: istore 6
    //   624: aload 22
    //   626: getfield 291	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_hidden_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   629: invokevirtual 273	com/tencent/ims/bankcode_info$ElemPos:has	()Z
    //   632: ifeq +539 -> 1171
    //   635: aload 22
    //   637: getfield 291	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_hidden_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   640: invokevirtual 276	com/tencent/ims/bankcode_info$ElemPos:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   643: checkcast 272	com/tencent/ims/bankcode_info$ElemPos
    //   646: astore_1
    //   647: aload_1
    //   648: getfield 279	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   651: invokevirtual 233	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   654: ifeq +12 -> 666
    //   657: aload_1
    //   658: getfield 279	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   661: invokevirtual 234	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   664: istore 6
    //   666: iload 6
    //   668: istore 8
    //   670: aload_1
    //   671: getfield 282	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   674: invokevirtual 233	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   677: ifeq +494 -> 1171
    //   680: aload_1
    //   681: getfield 282	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   684: invokevirtual 234	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   687: istore 15
    //   689: iload 6
    //   691: istore 8
    //   693: iload 15
    //   695: istore 6
    //   697: aload 21
    //   699: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   702: iload 13
    //   704: iload 7
    //   706: iadd
    //   707: iload 10
    //   709: isub
    //   710: invokestatic 293	bhoa:a	(Ljava/lang/String;I)I
    //   713: istore 13
    //   715: aload 21
    //   717: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   720: iload 12
    //   722: iload 7
    //   724: iadd
    //   725: iload 10
    //   727: isub
    //   728: invokestatic 293	bhoa:a	(Ljava/lang/String;I)I
    //   731: istore 15
    //   733: iload 8
    //   735: iload 13
    //   737: iadd
    //   738: istore 8
    //   740: iload 6
    //   742: iload 13
    //   744: iadd
    //   745: istore 12
    //   747: iload 13
    //   749: aload 21
    //   751: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   754: invokevirtual 288	java/lang/String:length	()I
    //   757: if_icmpge +18 -> 775
    //   760: iload 15
    //   762: iconst_1
    //   763: iadd
    //   764: aload 21
    //   766: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   769: invokevirtual 288	java/lang/String:length	()I
    //   772: if_icmple +106 -> 878
    //   775: iload 14
    //   777: iconst_1
    //   778: isub
    //   779: istore 6
    //   781: aload_0
    //   782: getfield 296	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   785: aload_0
    //   786: getfield 299	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   789: aload_0
    //   790: getfield 303	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   793: iload_2
    //   794: aload_3
    //   795: iload 5
    //   797: iload 6
    //   799: aload 21
    //   801: checkcast 258	com/tencent/mobileqq/data/MessageForText
    //   804: iload 10
    //   806: iload 7
    //   808: isub
    //   809: invokestatic 306	bhoa:a	(Ljava/lang/String;IJZLcom/tencent/ims/bankcode_info$BankcodeCtrlInfo;IILcom/tencent/mobileqq/data/MessageForText;I)V
    //   812: iload 7
    //   814: aload 21
    //   816: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   819: aload 21
    //   821: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   824: invokevirtual 288	java/lang/String:length	()I
    //   827: invokestatic 293	bhoa:a	(Ljava/lang/String;I)I
    //   830: aload 21
    //   832: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   835: invokevirtual 288	java/lang/String:length	()I
    //   838: isub
    //   839: iadd
    //   840: istore 7
    //   842: aload 21
    //   844: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   847: invokevirtual 288	java/lang/String:length	()I
    //   850: iload 10
    //   852: iadd
    //   853: istore 8
    //   855: iload 6
    //   857: istore 5
    //   859: iload 7
    //   861: istore 6
    //   863: iload 8
    //   865: istore 7
    //   867: iload 7
    //   869: istore 10
    //   871: iload 6
    //   873: istore 7
    //   875: goto -651 -> 224
    //   878: aload 21
    //   880: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   883: iload 13
    //   885: iload 15
    //   887: iconst_1
    //   888: iadd
    //   889: invokevirtual 310	java/lang/String:substring	(II)Ljava/lang/String;
    //   892: astore 23
    //   894: ldc_w 312
    //   897: astore_1
    //   898: iconst_0
    //   899: istore 6
    //   901: iload 6
    //   903: aload 23
    //   905: invokevirtual 288	java/lang/String:length	()I
    //   908: if_icmpge +82 -> 990
    //   911: aload 23
    //   913: iload 6
    //   915: invokevirtual 316	java/lang/String:charAt	(I)C
    //   918: istore 4
    //   920: iload 9
    //   922: tableswitch	default:+18 -> 940, 1:+33->955
    //   941: astore 19
    //   943: iload 6
    //   945: iconst_1
    //   946: iadd
    //   947: istore 6
    //   949: aload 19
    //   951: astore_1
    //   952: goto -51 -> 901
    //   955: aload_1
    //   956: astore 19
    //   958: iload 4
    //   960: invokestatic 322	java/lang/Character:isDigit	(C)Z
    //   963: ifeq -20 -> 943
    //   966: new 324	java/lang/StringBuilder
    //   969: dup
    //   970: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   973: aload_1
    //   974: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: iload 4
    //   979: invokevirtual 332	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   982: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: astore 19
    //   987: goto -44 -> 943
    //   990: aload_1
    //   991: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   994: ifeq +8 -> 1002
    //   997: iload 16
    //   999: ifne -700 -> 299
    //   1002: aload 22
    //   1004: getfield 208	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1007: invokevirtual 211	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1010: ifeq +155 -> 1165
    //   1013: aload 22
    //   1015: getfield 208	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1018: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1021: astore 19
    //   1023: iload 16
    //   1025: ifeq -726 -> 299
    //   1028: aload_1
    //   1029: aload 19
    //   1031: invokestatic 338	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1034: ifeq -735 -> 299
    //   1037: ldc_w 312
    //   1040: astore_1
    //   1041: iconst_0
    //   1042: istore 6
    //   1044: iload 6
    //   1046: iload 12
    //   1048: iconst_1
    //   1049: iadd
    //   1050: iload 8
    //   1052: isub
    //   1053: if_icmpge +33 -> 1086
    //   1056: new 324	java/lang/StringBuilder
    //   1059: dup
    //   1060: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   1063: aload_1
    //   1064: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: ldc_w 340
    //   1070: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1076: astore_1
    //   1077: iload 6
    //   1079: iconst_1
    //   1080: iadd
    //   1081: istore 6
    //   1083: goto -39 -> 1044
    //   1086: new 111	android/text/SpannableStringBuilder
    //   1089: dup
    //   1090: aload 21
    //   1092: checkcast 258	com/tencent/mobileqq/data/MessageForText
    //   1095: getfield 344	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   1098: invokespecial 347	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   1101: astore 19
    //   1103: aload 19
    //   1105: iload 8
    //   1107: iload 12
    //   1109: iconst_1
    //   1110: iadd
    //   1111: aload_1
    //   1112: invokevirtual 351	android/text/SpannableStringBuilder:replace	(IILjava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   1115: pop
    //   1116: aload 21
    //   1118: checkcast 258	com/tencent/mobileqq/data/MessageForText
    //   1121: aload 19
    //   1123: putfield 344	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   1126: goto -827 -> 299
    //   1129: iload 10
    //   1131: iconst_1
    //   1132: iadd
    //   1133: istore 8
    //   1135: iload 7
    //   1137: istore 6
    //   1139: iload 8
    //   1141: istore 7
    //   1143: goto -276 -> 867
    //   1146: astore 18
    //   1148: iconst_0
    //   1149: istore 5
    //   1151: aload 19
    //   1153: astore_3
    //   1154: goto -1062 -> 92
    //   1157: astore 18
    //   1159: aload 19
    //   1161: astore_3
    //   1162: goto -1070 -> 92
    //   1165: aconst_null
    //   1166: astore 19
    //   1168: goto -145 -> 1023
    //   1171: iconst_0
    //   1172: istore 6
    //   1174: goto -477 -> 697
    //   1177: iconst_0
    //   1178: istore 12
    //   1180: iload 8
    //   1182: istore 13
    //   1184: goto -589 -> 595
    //   1187: goto -406 -> 781
    //   1190: iconst_0
    //   1191: istore 16
    //   1193: goto -997 -> 196
    //   1196: goto -679 -> 517
    //   1199: aconst_null
    //   1200: astore 19
    //   1202: goto -707 -> 495
    //   1205: goto -1041 -> 164
    //   1208: iload 5
    //   1210: istore 6
    //   1212: goto -824 -> 388
    //   1215: iconst_0
    //   1216: istore 6
    //   1218: goto -837 -> 381
    //   1221: goto -1091 -> 130
    //   1224: iconst_0
    //   1225: istore 5
    //   1227: goto -1181 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1230	0	paramMessageRecord	MessageRecord
    //   0	1230	1	paramList	List<MessageRecord>
    //   0	1230	2	paramBoolean	boolean
    //   0	1230	3	paramArrayOfByte	byte[]
    //   918	60	4	c	char
    //   44	1182	5	i	int
    //   1	1216	6	j	int
    //   222	920	7	k	int
    //   521	660	8	m	int
    //   71	850	9	n	int
    //   219	914	10	i1	int
    //   256	48	11	i2	int
    //   589	590	12	i3	int
    //   593	590	13	i4	int
    //   278	501	14	i5	int
    //   687	202	15	i6	int
    //   132	1060	16	bool1	boolean
    //   4	399	17	bool2	boolean
    //   7	73	18	arrayOfByte	byte[]
    //   85	8	18	localException1	Exception
    //   98	312	18	localObject1	Object
    //   1146	1	18	localException2	Exception
    //   1157	1	18	localException3	Exception
    //   16	142	19	localObject2	Object
    //   312	3	19	localException4	Exception
    //   332	17	19	localIterator	Iterator
    //   395	3	19	localException5	Exception
    //   441	760	19	localObject3	Object
    //   216	216	20	localObject4	Object
    //   244	873	21	localMessageRecord	MessageRecord
    //   292	722	22	localBankcodeElem	bankcode_info.BankcodeElem
    //   892	20	23	str	String
    // Exception table:
    //   from	to	target	type
    //   9	18	85	java/lang/Exception
    //   123	130	312	java/lang/Exception
    //   157	164	395	java/lang/Exception
    //   18	46	1146	java/lang/Exception
    //   49	69	1157	java/lang/Exception
  }
  
  public static void a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (((BaseActivity.sTopActivity instanceof MultiForwardActivity)) || ((BaseActivity.sTopActivity instanceof ChatHistoryActivity))) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        } while (localObject1 == null);
        localObject1 = (QQMessageFacade)((AppRuntime)localObject1).getManager(20);
      } while (localObject1 == null);
      localObject2 = ((QQMessageFacade)localObject1).getMsgItemByUniseq(paramString1, paramInt, paramLong);
    } while (localObject2 == null);
    int i2 = 0;
    int k = 0;
    int j = 0;
    int n = 0;
    int i1 = 0;
    int i = 0;
    Object localObject3 = ((MessageRecord)localObject2).getExtInfoFromExtStr("sens_msg_ctrl_info");
    int m;
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      m = i1;
    }
    for (k = i2;; k = 0) {
      for (;;)
      {
        try
        {
          Object localObject4 = new bankcode_info.BankcodeCtrlInfo();
          m = i1;
          k = i2;
          ((bankcode_info.BankcodeCtrlInfo)localObject4).mergeFrom(HexUtil.hexStr2Bytes((String)localObject3));
          m = i1;
          k = i2;
          if (((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.has())
          {
            m = i1;
            k = i2;
            j = ((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.get();
          }
          m = i1;
          k = j;
          if (((bankcode_info.BankcodeCtrlInfo)localObject4).bankcode_elems.has())
          {
            m = i1;
            k = j;
            localObject3 = ((bankcode_info.BankcodeCtrlInfo)localObject4).bankcode_elems.get().iterator();
            n = i;
            m = i;
            k = j;
            if (((Iterator)localObject3).hasNext())
            {
              m = i;
              k = j;
              localObject4 = (bankcode_info.BankcodeElem)((Iterator)localObject3).next();
              m = i;
              k = j;
              if (!((bankcode_info.BankcodeElem)localObject4).bankcode_attr.has()) {
                break;
              }
              m = i;
              k = j;
              n = ((bankcode_info.BankcodeElem)localObject4).bankcode_attr.get();
              k = n;
              if (k <= i) {
                break label533;
              }
              i = k;
              continue;
            }
          }
          i = n;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          i = m;
          j = k;
          continue;
        }
        localObject2 = ((MessageRecord)localObject2).senderuin;
        localObject3 = bfur.a(BaseActivity.sTopActivity, 230);
        ((QQCustomDialog)localObject3).setTitle(paramString2);
        ((QQCustomDialog)localObject3).setMessage(paramString3);
        if (!TextUtils.isEmpty(paramString4)) {
          ((QQCustomDialog)localObject3).setPositiveButton(paramString4, new bhob((String)localObject2, j, i, (QQMessageFacade)localObject1, paramString1, paramInt, paramLong));
        }
        if (!TextUtils.isEmpty(paramString5)) {
          ((QQCustomDialog)localObject3).setNegativeButton(paramString5, new bhoc((String)localObject2, j, i));
        }
        ((QQCustomDialog)localObject3).show();
        return;
        j = k;
        if ((localObject2 instanceof MessageForSafeGrayTips))
        {
          MessageForSafeGrayTips localMessageForSafeGrayTips = (MessageForSafeGrayTips)localObject2;
          i = 2;
          j = i;
          if (localMessageForSafeGrayTips.safeInfo != null)
          {
            j = i;
            if (localMessageForSafeGrayTips.safeInfo.strMsgTxt.has()) {
              try
              {
                k = Integer.parseInt(localMessageForSafeGrayTips.safeInfo.strMsgTxt.get());
                j = i;
                i = k;
              }
              catch (Exception localException2)
              {
                localException2.printStackTrace();
                j = i;
              }
            }
          }
        }
        i = 0;
        continue;
        label533:
        k = i;
      }
    }
  }
  
  private static void a(String paramString, int paramInt1, long paramLong, boolean paramBoolean, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo, int paramInt2, int paramInt3, MessageForText paramMessageForText, int paramInt4)
  {
    if ((paramBankcodeCtrlInfo == null) || (!paramBankcodeCtrlInfo.bankcode_elems.has())) {}
    for (;;)
    {
      return;
      int j;
      int k;
      if (paramBankcodeCtrlInfo.msgtail_id.has())
      {
        j = paramBankcodeCtrlInfo.msgtail_id.get();
        k = paramInt2;
      }
      while ((k < paramBankcodeCtrlInfo.bankcode_elems.size()) && (k < paramInt3))
      {
        Object localObject = (bankcode_info.BankcodeElem)paramBankcodeCtrlInfo.bankcode_elems.get(k);
        if (localObject == null) {}
        label275:
        label299:
        label315:
        label457:
        for (;;)
        {
          k += 1;
          break;
          int m = 0;
          paramInt2 = 0;
          int i = m;
          if (((bankcode_info.BankcodeElem)localObject).bankcode_pos.has())
          {
            localObject = (bankcode_info.ElemPos)((bankcode_info.BankcodeElem)localObject).bankcode_pos.get();
            i = m;
            if (localObject != null)
            {
              if (((bankcode_info.ElemPos)localObject).start_offset.has()) {
                paramInt2 = ((bankcode_info.ElemPos)localObject).start_offset.get();
              }
              i = paramInt2;
              if (((bankcode_info.ElemPos)localObject).end_offset.has())
              {
                i = ((bankcode_info.ElemPos)localObject).end_offset.get();
                m = paramInt2;
                paramInt2 = i;
              }
            }
          }
          for (;;)
          {
            if ((paramInt2 < paramInt4) || (m > paramMessageForText.sb.length() + paramInt4)) {
              break label457;
            }
            String str = paramMessageForText.getExtInfoFromExtStr("sens_msg_original_text");
            localObject = str;
            if (TextUtils.isEmpty(str)) {
              localObject = paramMessageForText.sb.toString();
            }
            int n = a((String)localObject, m - paramInt4);
            int i1 = a((String)localObject, paramInt2 - paramInt4);
            paramInt2 = n;
            if ((j == 1) && (!Character.isDigit(paramMessageForText.sb.charAt(paramInt2))))
            {
              i = paramInt2;
              if (paramInt2 < 0) {
                i = 0;
              }
              paramInt2 = i1;
              if ((j != 1) || (Character.isDigit(paramMessageForText.sb.charAt(paramInt2)))) {
                break label417;
              }
            }
            for (;;)
            {
              localObject = new SpannableStringBuilder(paramMessageForText.sb);
              a((SpannableStringBuilder)localObject, i, paramInt2);
              ((SpannableStringBuilder)localObject).setSpan(a(paramString, paramInt1, paramLong, paramBoolean, paramBankcodeCtrlInfo), n, i1 + 1, 33);
              paramMessageForText.sb = ((CharSequence)localObject);
              break;
              i = paramInt2 - 1;
              paramInt2 = i;
              if (i >= 0) {
                break label275;
              }
              paramInt2 = i;
              break label299;
              m = paramInt2 + 1;
              paramInt2 = m;
              if (m < paramMessageForText.sb.length()) {
                break label315;
              }
              paramInt2 = m;
            }
            paramInt2 = 0;
            m = i;
          }
        }
        label417:
        j = 0;
        k = paramInt2;
      }
    }
  }
  
  private static void c(String paramString)
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = paramString;
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      jdField_a_of_type_AndroidOsBundle.putBundle(jdField_a_of_type_JavaLangString, null);
      ThreadManager.executeOnFileThread(new MQPSensitiveMsgUtil.5());
    }
  }
  
  public void a(String paramString)
  {
    String str1;
    String str2;
    Bundle localBundle;
    if ((!TextUtils.isEmpty(paramString)) && (!a(paramString)))
    {
      jdField_a_of_type_Int = (jdField_a_of_type_Int + 1) % 10;
      str1 = MD5Utils.encodeHexStr(paramString);
      str2 = Integer.toString(jdField_a_of_type_Int);
      localBundle = jdField_a_of_type_AndroidOsBundle.getBundle(jdField_a_of_type_JavaLangString);
      if (localBundle != null)
      {
        Iterator localIterator = localBundle.keySet().iterator();
        String str3;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          str3 = localBundle.getString(paramString);
        } while ((TextUtils.isEmpty(str3)) || (!str3.equals(str2)));
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString)) {
        localBundle.remove(paramString);
      }
      localBundle.putString(str1, str2);
      ThreadManager.executeOnFileThread(new MQPSensitiveMsgUtil.3(this, str2, str1));
      return;
      paramString = null;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      Bundle localBundle = jdField_a_of_type_AndroidOsBundle.getBundle(jdField_a_of_type_JavaLangString);
      bool1 = bool2;
      if (localBundle != null)
      {
        bool1 = bool2;
        if (localBundle.containsKey(MD5Utils.encodeHexStr(paramString))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhoa
 * JD-Core Version:    0.7.0.1
 */