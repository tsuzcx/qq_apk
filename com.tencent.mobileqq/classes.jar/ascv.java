import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class ascv
  extends arxg
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final int h;
  public int a;
  public int b;
  public boolean b;
  public String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = anni.a(2131713393);
    jdField_b_of_type_JavaLangString = anni.a(2131713396);
    jdField_c_of_type_JavaLangString = anni.a(2131713395);
    int j = arxc.jdField_b_of_type_Int / 20;
    if (arxc.jdField_b_of_type_Int % 20 == 0) {}
    for (int i = 0;; i = 1)
    {
      h = i + j;
      return;
    }
  }
  
  public ascv(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.d = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public static final int a(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt.length + 19) / 20;
  }
  
  public static List<asac> a(int paramInt, ArrayList<Integer> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new ascv(7, 3, -1, jdField_c_of_type_JavaLangString, false));
      i += 1;
    }
    i = 0;
    while (i < paramArrayList.size())
    {
      localArrayList.add(new ascv(7, 2, ((Integer)paramArrayList.get(i)).intValue(), "", false));
      i += 1;
    }
    int j = paramArrayList.size() % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        localArrayList.add(new ascv(7, 2, -1, "", false));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List<asac> a(int paramInt, boolean paramBoolean, ArrayList<Integer> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new ascv(7, 3, -1, jdField_b_of_type_JavaLangString, false));
      i += 1;
    }
    i = 0;
    int k = paramArrayList.size();
    int j = 0;
    if (j < k)
    {
      if ((paramBoolean) && (((Integer)paramArrayList.get(j)).intValue() > 255)) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (((Integer)paramArrayList.get(j)).intValue() == -1) {
          localArrayList.add(new ascv(7, 1, 0, "", false));
        } else {
          localArrayList.add(new ascv(7, 1, ((Integer)paramArrayList.get(j)).intValue(), "", false));
        }
      }
    }
    j = (paramArrayList.size() - i) % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        localArrayList.add(new ascv(7, 1, -1, "", false));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List<asac> a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = arvq.a();
    ArrayList localArrayList2 = arvj.a();
    ArrayList localArrayList3 = new ArrayList(localArrayList1.size() + localArrayList2.size());
    if (paramBoolean1)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        localArrayList3.addAll(a((QQAppInterface)localAppRuntime, paramInt, paramBoolean3));
      }
    }
    localArrayList3.addAll(a(paramInt, paramBoolean3, localArrayList1));
    if (paramBoolean2) {
      localArrayList3.addAll(a(paramInt, localArrayList2));
    }
    return localArrayList3;
  }
  
  public static List<asac> a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return a(paramQQAppInterface, false, 7, paramInt);
  }
  
  public static List<asac> a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramQQAppInterface == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new ascv(7, 3, -1, jdField_a_of_type_JavaLangString, false));
      i += 1;
    }
    paramQQAppInterface = ((arwz)paramQQAppInterface.getManager(172)).a();
    int j;
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 1))
    {
      j = 0;
      i = 0;
      if ((j >= paramQQAppInterface.size()) || (i >= paramInt * 3))
      {
        if (i >= paramInt * 3) {
          break label269;
        }
        j = i % paramInt;
        if (j == 0) {
          break label269;
        }
        i = 0;
      }
    }
    while (i < paramInt - j)
    {
      localArrayList.add(new ascv(7, 1, -1, "", false));
      i += 1;
      continue;
      EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramQQAppInterface.get(j);
      int k = 1;
      if (localSmallYellowItem.type.get() == 2) {
        k = 2;
      }
      if ((paramBoolean) && (k == 1) && (localSmallYellowItem.id.get() > 255)) {}
      for (;;)
      {
        j += 1;
        break;
        localArrayList.add(new ascv(7, k, localSmallYellowItem.id.get(), "", true));
        i += 1;
      }
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "CommonlyUsedSystemEmoji IS NULL");
    }
    label269:
    return localArrayList;
  }
  
  public static List<asac> a(QQAppInterface paramQQAppInterface, int paramInt, int[] paramArrayOfInt)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getEmoticonList app = null");
      return null;
    }
    if (paramArrayOfInt != null)
    {
      paramQQAppInterface = paramArrayOfInt;
      if (paramArrayOfInt.length != 0) {}
    }
    else
    {
      paramQQAppInterface = asdb.a();
    }
    paramArrayOfInt = new ArrayList(paramQQAppInterface.length);
    int i = 0;
    while (i < paramQQAppInterface.length)
    {
      paramArrayOfInt.add(Integer.valueOf(paramQQAppInterface[i]));
      i += 1;
    }
    paramQQAppInterface = new ArrayList(paramArrayOfInt.size());
    int j = paramArrayOfInt.size();
    i = 0;
    if (i < j)
    {
      Integer localInteger = (Integer)paramArrayOfInt.get(i);
      if (bdol.a(localInteger.intValue())) {}
      for (;;)
      {
        i += 1;
        break;
        if (localInteger.intValue() == -1) {
          paramQQAppInterface.add(new ascv(7, 1, 0, "", false));
        } else {
          paramQQAppInterface.add(new ascv(7, 1, localInteger.intValue(), "", false));
        }
      }
    }
    j = paramQQAppInterface.size() % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        paramQQAppInterface.add(new ascv(7, 1, -1, "", false));
        i += 1;
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<asac> a(QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getEmoticonList app = null");
      paramQQAppInterface = null;
    }
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    do
    {
      return paramQQAppInterface;
      ArrayList localArrayList3 = arvq.a();
      localArrayList2 = arvj.a();
      localArrayList1 = new ArrayList(localArrayList3.size() + localArrayList2.size());
      if ((paramInt2 != 2) && (paramInt2 != 3)) {
        localArrayList1.addAll(a(paramQQAppInterface, paramInt1, paramBoolean));
      }
      localArrayList1.addAll(a(paramInt1, paramBoolean, localArrayList3));
      paramQQAppInterface = localArrayList1;
    } while (paramInt2 == 2);
    localArrayList1.addAll(a(paramInt1, localArrayList2));
    return localArrayList1;
  }
  
  public static List<arxg> a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length + arxc.jdField_b_of_type_Int);
    int j = arxc.jdField_b_of_type_Int % 20;
    int i = arxc.jdField_b_of_type_Int - 1;
    while (i >= arxc.jdField_b_of_type_Int - j)
    {
      localArrayList.add(new ascv(7, 2, i, "", false));
      i -= 1;
    }
    i = 0;
    while (i < 20 - j)
    {
      localArrayList.add(new ascv(7, 2, -1, "", false));
      i += 1;
    }
    i = arxc.jdField_b_of_type_Int - j - 1;
    if (i >= 0)
    {
      if (arvk.a().a(2).b(i)) {
        if (QLog.isColorLevel()) {
          QLog.d("SystemAndEmojiEmoticonInfo", 2, new Object[] { "getOldEmoticonList hided:", Integer.valueOf(i), " ,type:", Integer.valueOf(2) });
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        localArrayList.add(new ascv(7, 2, i, "", false));
      }
    }
    j = paramArrayOfInt.length;
    i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      if (arvk.a().a(1).b(k)) {
        if (QLog.isColorLevel()) {
          QLog.d("SystemAndEmojiEmoticonInfo", 2, new Object[] { "getOldEmoticonList hided:", Integer.valueOf(k), " ,type:", Integer.valueOf(1) });
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(new ascv(7, 1, k, "", false));
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface, 0);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      int i = 0;
      while ((i < 84) && (i < paramQQAppInterface.size()))
      {
        Object localObject = (asac)paramQQAppInterface.get(i);
        if ((localObject instanceof ascv))
        {
          localObject = (ascv)localObject;
          if ((((ascv)localObject).jdField_c_of_type_Int != 3) && (((ascv)localObject).jdField_b_of_type_Int != -1))
          {
            localObject = (URLDrawable)((ascv)localObject).a(false);
            if ((localObject != null) && (((URLDrawable)localObject).getStatus() != 1)) {
              ((URLDrawable)localObject).startDownload();
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public Drawable a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((1 == this.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int != -1)) {
      localObject1 = arvq.a(paramInt);
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (2 != this.jdField_a_of_type_Int);
      localObject1 = localObject2;
    } while (this.jdField_b_of_type_Int == -1);
    return arvj.a(paramInt);
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return a(this.jdField_b_of_type_Int, true);
  }
  
  public Drawable a(boolean paramBoolean)
  {
    return a(this.jdField_b_of_type_Int, paramBoolean);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if (this.jdField_b_of_type_Int == -1) {
      return;
    }
    int i = paramEditText.getSelectionStart();
    int j = paramEditText.getSelectionEnd();
    Editable localEditable = paramEditText.getEditableText();
    if (this.jdField_a_of_type_Int == 1) {}
    for (paramContext = bdol.b(this.jdField_b_of_type_Int);; paramContext = bdol.a(this.jdField_b_of_type_Int))
    {
      localEditable.replace(i, j, paramContext);
      paramEditText.requestFocus();
      a(paramQQAppInterface, paramSessionInfo);
      if (this.jdField_b_of_type_Boolean) {
        bcst.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800717F", 0, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", "", "");
      }
      if ((paramQQAppInterface != null) && (bdol.a(this.jdField_b_of_type_Int)) && (paramSessionInfo != null)) {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "0X800812C", ApolloUtil.b(paramSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(this.jdField_b_of_type_Int), String.valueOf(amhd.a(paramQQAppInterface)) });
      }
      arvk.a().a(this.jdField_a_of_type_Int).a(this.jdField_b_of_type_Int, 1);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    EmosmPb.SmallYellowItem localSmallYellowItem = new EmosmPb.SmallYellowItem();
    localSmallYellowItem.id.set(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Int == 1) {}
    for (int i = 1;; i = 2)
    {
      localSmallYellowItem.type.set(i);
      long l = System.currentTimeMillis();
      localSmallYellowItem.ts.set(l);
      String str2 = "";
      String str1 = str2;
      if (paramSessionInfo != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(paramSessionInfo.jdField_b_of_type_JavaLangString)) {
          str1 = paramSessionInfo.jdField_b_of_type_JavaLangString;
        }
      }
      QLog.d("SystemAndEmojiEmoticonInfo", 1, "send saveemoji type = " + i + ";id = " + this.jdField_b_of_type_Int + ";ts = " + l + ";troopUin = " + str1);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (arwz)paramQQAppInterface.getManager(172);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.a(localSmallYellowItem);
        }
      }
      return;
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int != -1)) {
      localObject1 = bdol.a(this.jdField_b_of_type_Int, true);
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.jdField_a_of_type_Int != 2);
      localObject1 = localObject2;
    } while (this.jdField_b_of_type_Int == -1);
    return super.b(paramContext, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascv
 * JD-Core Version:    0.7.0.1
 */