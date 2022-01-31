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

public class apur
  extends appw
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
    jdField_a_of_type_JavaLangString = alpo.a(2131715081);
    jdField_b_of_type_JavaLangString = alpo.a(2131715084);
    jdField_c_of_type_JavaLangString = alpo.a(2131715083);
    int j = apps.jdField_b_of_type_Int / 20;
    if (apps.jdField_b_of_type_Int % 20 == 0) {}
    for (int i = 0;; i = 1)
    {
      h = i + j;
      return;
    }
  }
  
  public apur(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
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
  
  public static List<apsj> a(int paramInt, ArrayList<Integer> paramArrayList)
  {
    return a(paramInt, false, paramArrayList);
  }
  
  public static List<apsj> a(int paramInt, boolean paramBoolean, ArrayList<Integer> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new apur(7, 3, -1, jdField_b_of_type_JavaLangString, false));
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
          localArrayList.add(new apur(7, 1, 0, "", false));
        } else {
          localArrayList.add(new apur(7, 1, ((Integer)paramArrayList.get(j)).intValue(), "", false));
        }
      }
    }
    j = (paramArrayList.size() - i) % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        localArrayList.add(new apur(7, 1, -1, "", false));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List<apsj> a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList1 = apog.a();
    ArrayList localArrayList2 = apnz.a();
    ArrayList localArrayList3 = new ArrayList(localArrayList1.size() + localArrayList2.size());
    if (paramBoolean1)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        localArrayList3.addAll(b((QQAppInterface)localAppRuntime, paramInt));
      }
    }
    localArrayList3.addAll(a(paramInt, localArrayList1));
    if (paramBoolean2) {
      localArrayList3.addAll(b(paramInt, localArrayList2));
    }
    return localArrayList3;
  }
  
  public static List<apsj> a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return a(paramQQAppInterface, false, 7, paramInt);
  }
  
  public static List<apsj> a(QQAppInterface paramQQAppInterface, int paramInt, int[] paramArrayOfInt)
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
      paramQQAppInterface = apuw.a();
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
      if (baiy.a(localInteger.intValue())) {}
      for (;;)
      {
        i += 1;
        break;
        if (localInteger.intValue() == -1) {
          paramQQAppInterface.add(new apur(7, 1, 0, "", false));
        } else {
          paramQQAppInterface.add(new apur(7, 1, localInteger.intValue(), "", false));
        }
      }
    }
    j = paramQQAppInterface.size() % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        paramQQAppInterface.add(new apur(7, 1, -1, "", false));
        i += 1;
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<apsj> a(QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt1, int paramInt2)
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
      ArrayList localArrayList3 = apog.a();
      localArrayList2 = apnz.a();
      localArrayList1 = new ArrayList(localArrayList3.size() + localArrayList2.size());
      if ((paramInt2 != 2) && (paramInt2 != 3)) {
        localArrayList1.addAll(b(paramQQAppInterface, paramInt1));
      }
      localArrayList1.addAll(a(paramInt1, paramBoolean, localArrayList3));
      paramQQAppInterface = localArrayList1;
    } while (paramInt2 == 2);
    localArrayList1.addAll(b(paramInt1, localArrayList2));
    return localArrayList1;
  }
  
  public static List<appw> a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length + apps.jdField_b_of_type_Int);
    int j = apps.jdField_b_of_type_Int % 20;
    int i = apps.jdField_b_of_type_Int - 1;
    while (i >= apps.jdField_b_of_type_Int - j)
    {
      localArrayList.add(new apur(7, 2, i, "", false));
      i -= 1;
    }
    i = 0;
    while (i < 20 - j)
    {
      localArrayList.add(new apur(7, 2, -1, "", false));
      i += 1;
    }
    i = apps.jdField_b_of_type_Int - j - 1;
    while (i >= 0)
    {
      localArrayList.add(new apur(7, 2, i, "", false));
      i -= 1;
    }
    j = paramArrayOfInt.length;
    i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      if (apoa.a().a(1).a(k)) {
        if (QLog.isColorLevel()) {
          QLog.d("SystemAndEmojiEmoticonInfo", 2, new Object[] { "getOldEmoticonList hided:", Integer.valueOf(k), " ,type:", Integer.valueOf(1) });
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(new apur(7, 1, k, "", false));
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
        Object localObject = (apsj)paramQQAppInterface.get(i);
        if ((localObject instanceof apur))
        {
          localObject = (apur)localObject;
          if ((((apur)localObject).jdField_c_of_type_Int != 3) && (((apur)localObject).jdField_b_of_type_Int != -1))
          {
            localObject = (URLDrawable)((apur)localObject).a(false);
            if ((localObject != null) && (((URLDrawable)localObject).getStatus() != 1)) {
              ((URLDrawable)localObject).startDownload();
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public static List<apsj> b(int paramInt, ArrayList<Integer> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new apur(7, 3, -1, jdField_c_of_type_JavaLangString, false));
      i += 1;
    }
    i = 0;
    while (i < paramArrayList.size())
    {
      localArrayList.add(new apur(7, 2, ((Integer)paramArrayList.get(i)).intValue(), "", false));
      i += 1;
    }
    int j = paramArrayList.size() % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        localArrayList.add(new apur(7, 2, -1, "", false));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List<apsj> b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramQQAppInterface == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new apur(7, 3, -1, jdField_a_of_type_JavaLangString, false));
      i += 1;
    }
    paramQQAppInterface = ((appp)paramQQAppInterface.getManager(172)).a();
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 1))
    {
      int j = 0;
      i = 0;
      for (;;)
      {
        if ((j >= paramQQAppInterface.size()) || (i >= paramInt * 3))
        {
          if (i >= paramInt * 3) {
            break;
          }
          j = i % paramInt;
          if (j == 0) {
            break;
          }
          i = 0;
          while (i < paramInt - j)
          {
            localArrayList.add(new apur(7, 1, -1, "", false));
            i += 1;
          }
        }
        EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramQQAppInterface.get(j);
        int k = 1;
        if (localSmallYellowItem.type.get() == 2) {
          k = 2;
        }
        localArrayList.add(new apur(7, k, localSmallYellowItem.id.get(), "", true));
        j += 1;
        i += 1;
      }
    }
    QLog.e("SystemAndEmojiEmoticonInfo", 1, "CommonlyUsedSystemEmoji IS NULL");
    return localArrayList;
  }
  
  public Drawable a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((1 == this.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int != -1)) {
      localObject1 = apog.a(paramInt);
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
    return apnz.a(paramInt);
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
    for (paramContext = baiy.c(this.jdField_b_of_type_Int);; paramContext = baiy.a(this.jdField_b_of_type_Int))
    {
      localEditable.replace(i, j, paramContext);
      paramEditText.requestFocus();
      a(paramQQAppInterface, paramSessionInfo);
      if (this.jdField_b_of_type_Boolean) {
        azmj.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800717F", 0, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", "", "");
      }
      if ((paramQQAppInterface != null) && (baiy.a(this.jdField_b_of_type_Int)) && (paramSessionInfo != null)) {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "0X800812C", ApolloUtil.b(paramSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(this.jdField_b_of_type_Int), String.valueOf(akji.a(paramQQAppInterface)) });
      }
      apoa.a().a(this.jdField_a_of_type_Int).a(this.jdField_b_of_type_Int, 1);
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
        paramQQAppInterface = (appp)paramQQAppInterface.getManager(172);
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
      localObject1 = baiy.a(this.jdField_b_of_type_Int, true);
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
 * Qualified Name:     apur
 * JD-Core Version:    0.7.0.1
 */