import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class arqa
{
  public static String a;
  private static final Random a;
  
  static
  {
    jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  public static MessageRecord a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    int i = 1;
    MessageRecord localMessageRecord = awbi.a(paramInt1);
    localMessageRecord.selfuin = jdField_a_of_type_JavaLangString;
    localMessageRecord.frienduin = paramString2;
    localMessageRecord.senderuin = paramString3;
    localMessageRecord.istroop = paramInt2;
    localMessageRecord.isread = true;
    if (paramBoolean) {}
    for (paramInt1 = i;; paramInt1 = 0)
    {
      localMessageRecord.issend = paramInt1;
      localMessageRecord.msgseq = paramLong1;
      localMessageRecord.shmsgseq = paramLong2;
      localMessageRecord.msgUid = paramLong3;
      localMessageRecord.msg = paramString1;
      localMessageRecord.time = ((int)awao.a());
      if ((localMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)localMessageRecord).parse();
      }
      return localMessageRecord;
    }
  }
  
  public static String a(int paramInt)
  {
    return b(paramInt);
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar, Random paramRandom)
  {
    if (paramInt1 == 0) {
      return "";
    }
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Requested random string length " + paramInt1 + " is less than 0.");
    }
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length == 0)) {
      throw new IllegalArgumentException("The chars array must not be empty");
    }
    int k;
    int m;
    char[] arrayOfChar;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (paramArrayOfChar != null)
      {
        k = paramArrayOfChar.length;
        m = paramInt2;
        arrayOfChar = new char[paramInt1];
        paramInt3 = k - m;
        label96:
        paramInt2 = paramInt1 - 1;
        if (paramInt1 == 0) {
          break label401;
        }
        if (paramArrayOfChar != null) {
          break label262;
        }
        int i = (char)(paramRandom.nextInt(paramInt3) + m);
        label121:
        if (((!paramBoolean1) || (!Character.isLetter(i))) && ((!paramBoolean2) || (!Character.isDigit(i))) && ((paramBoolean1) || (paramBoolean2))) {
          break label394;
        }
        if ((i < 56320) || (i > 57343)) {
          break label308;
        }
        if (paramInt2 != 0) {
          break label279;
        }
        paramInt1 = paramInt2 + 1;
      }
    }
    label262:
    label394:
    for (;;)
    {
      break label96;
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        k = 2147483647;
        m = paramInt2;
        break;
      }
      k = 123;
      m = 32;
      break;
      m = paramInt2;
      k = paramInt3;
      if (paramInt3 > paramInt2) {
        break;
      }
      throw new IllegalArgumentException("Parameter end (" + paramInt3 + ") must be greater than start (" + paramInt2 + ")");
      int j = paramArrayOfChar[(paramRandom.nextInt(paramInt3) + m)];
      break label121;
      label279:
      arrayOfChar[paramInt2] = j;
      paramInt1 = paramInt2 - 1;
      arrayOfChar[paramInt1] = ((char)(paramRandom.nextInt(128) + 55296));
      continue;
      label308:
      if ((j >= 55296) && (j <= 56191))
      {
        if (paramInt2 == 0)
        {
          paramInt1 = paramInt2 + 1;
        }
        else
        {
          arrayOfChar[paramInt2] = ((char)(paramRandom.nextInt(128) + 56320));
          paramInt1 = paramInt2 - 1;
          arrayOfChar[paramInt1] = j;
        }
      }
      else if ((j >= 56192) && (j <= 56319))
      {
        paramInt1 = paramInt2 + 1;
      }
      else
      {
        arrayOfChar[paramInt2] = j;
        paramInt1 = paramInt2;
        continue;
        paramInt1 = paramInt2 + 1;
      }
    }
    label401:
    return new String(arrayOfChar);
  }
  
  public static List<MessageRecord> a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    int j;
    String str;
    if (paramString1 == null)
    {
      i = 0;
      j = 0;
      str = "";
      label23:
      if (j >= paramInt1) {
        break label146;
      }
      if (!TextUtils.isEmpty(paramString1)) {
        break label116;
      }
      str = a(100);
    }
    for (;;)
    {
      long l1 = awbk.a(j);
      long l2 = awbk.a(j);
      MessageRecord localMessageRecord = a(str, -1000, paramString2, paramInt2, paramString3, true, l2, l2, l1);
      localMessageRecord.msgData = str.getBytes();
      localArrayList.add(localMessageRecord);
      j += 1;
      break label23;
      i = paramString1.length();
      break;
      label116:
      int k = j * 100;
      if (i >= k) {
        str = paramString1.substring(k, k + 100);
      }
    }
    label146:
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.a().f();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    paramQQAppInterface.a().b(paramList);
  }
  
  public static String b(int paramInt)
  {
    return a(paramInt, 32, 127, false, false, null, jdField_a_of_type_JavaUtilRandom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arqa
 * JD-Core Version:    0.7.0.1
 */