import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class aocu
  extends anyh
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final int h;
  public int a;
  private Drawable a;
  public int b;
  public boolean b;
  public String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131714709);
    jdField_b_of_type_JavaLangString = ajya.a(2131714712);
    jdField_c_of_type_JavaLangString = ajya.a(2131714711);
    int j = anyf.jdField_b_of_type_Int / 20;
    if (anyf.jdField_b_of_type_Int % 20 == 0) {}
    for (int i = 0;; i = 1)
    {
      h = i + j;
      return;
    }
  }
  
  public aocu(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
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
  
  public static List<aoam> a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return a(paramQQAppInterface, 7, paramInt);
  }
  
  public static List<aoam> a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getEmoticonList app = null");
      return null;
    }
    ArrayList localArrayList1 = anwr.a().a(1).b();
    ArrayList localArrayList2 = anwr.a().a(2).b();
    ArrayList localArrayList3 = new ArrayList(localArrayList1.size() + localArrayList2.size());
    if ((paramInt2 != 2) && (paramInt2 != 3))
    {
      i = 0;
      while (i < paramInt1)
      {
        localArrayList3.add(new aocu(7, 3, -1, jdField_a_of_type_JavaLangString, false));
        i += 1;
      }
      paramQQAppInterface = ((anyc)paramQQAppInterface.getManager(172)).a();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 1))
      {
        j = 0;
        i = 0;
        for (;;)
        {
          if ((j >= paramQQAppInterface.size()) || (i >= paramInt1 * 3))
          {
            if (i >= paramInt1 * 3) {
              break;
            }
            j = i % paramInt1;
            if (j == 0) {
              break;
            }
            i = 0;
            while (i < paramInt1 - j)
            {
              localArrayList3.add(new aocu(7, 1, -1, "", false));
              i += 1;
            }
          }
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramQQAppInterface.get(j);
          int k = 1;
          if (localSmallYellowItem.type.get() == 2) {
            k = 2;
          }
          localArrayList3.add(new aocu(7, k, localSmallYellowItem.id.get(), "", true));
          j += 1;
          i += 1;
        }
      }
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "CommonlyUsedSystemEmoji IS NULL");
    }
    int i = 0;
    while (i < paramInt1)
    {
      localArrayList3.add(new aocu(7, 3, -1, jdField_b_of_type_JavaLangString, false));
      i += 1;
    }
    int j = localArrayList1.size();
    i = 0;
    if (i < j)
    {
      if (((Integer)localArrayList1.get(i)).intValue() == -1) {
        localArrayList3.add(new aocu(7, 1, 0, "", false));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList3.add(new aocu(7, 1, ((Integer)localArrayList1.get(i)).intValue(), "", false));
      }
    }
    j = localArrayList1.size() % paramInt1;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt1 - j)
      {
        localArrayList3.add(new aocu(7, 1, -1, "", false));
        i += 1;
      }
    }
    if (paramInt2 != 2)
    {
      paramInt2 = 0;
      while (paramInt2 < paramInt1)
      {
        localArrayList3.add(new aocu(7, 3, -1, jdField_c_of_type_JavaLangString, false));
        paramInt2 += 1;
      }
      paramInt2 = 0;
      while (paramInt2 < localArrayList2.size())
      {
        localArrayList3.add(new aocu(7, 2, ((Integer)localArrayList2.get(paramInt2)).intValue(), "", false));
        paramInt2 += 1;
      }
      i = localArrayList2.size() % paramInt1;
      if (i > 0)
      {
        paramInt2 = 0;
        while (paramInt2 < paramInt1 - i)
        {
          localArrayList3.add(new aocu(7, 2, -1, "", false));
          paramInt2 += 1;
        }
      }
    }
    return localArrayList3;
  }
  
  public static List<anyh> a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length + anyf.jdField_b_of_type_Int);
    int j = anyf.jdField_b_of_type_Int % 20;
    int i = anyf.jdField_b_of_type_Int - 1;
    while (i >= anyf.jdField_b_of_type_Int - j)
    {
      localArrayList.add(new aocu(7, 2, i, "", false));
      i -= 1;
    }
    i = 0;
    while (i < 20 - j)
    {
      localArrayList.add(new aocu(7, 2, -1, "", false));
      i += 1;
    }
    i = anyf.jdField_b_of_type_Int - j - 1;
    while (i >= 0)
    {
      localArrayList.add(new aocu(7, 2, i, "", false));
      i -= 1;
    }
    j = paramArrayOfInt.length;
    i = 0;
    while (i < j)
    {
      localArrayList.add(new aocu(7, 1, paramArrayOfInt[i], "", false));
      i += 1;
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
        Object localObject = (aoam)paramQQAppInterface.get(i);
        if ((localObject instanceof aocu))
        {
          localObject = (aocu)localObject;
          if ((((aocu)localObject).jdField_c_of_type_Int != 3) && (((aocu)localObject).jdField_b_of_type_Int != -1))
          {
            localObject = (URLDrawable)((aocu)localObject).a(false);
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
    int i;
    if ((1 == this.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int != -1))
    {
      if ((paramInt < 0) || (paramInt >= ayjy.jdField_a_of_type_Int)) {
        throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
      }
      i = ayjy.jdField_b_of_type_ArrayOfInt[paramInt];
    }
    while (i == -1)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getSystemEmojiStaticImg index error 11; index = " + paramInt);
      return null;
      if ((2 == this.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int != -1))
      {
        if (paramInt < 0) {
          throw new IllegalArgumentException("invaid emoji index: " + paramInt);
        }
        if ((paramInt >= 0) && (paramInt < ayjy.jdField_b_of_type_Int)) {
          i = 2130839808 + paramInt;
        } else {
          QLog.e("SystemAndEmojiEmoticonInfo", 1, "getSystemEmojiStaticImg index error; index = " + paramInt);
        }
      }
      else
      {
        i = -1;
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplication.getContext().getResources().getDrawable(2130837718);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          URL localURL = new URL("protocol_vas_extension_image", "RESOURCE_IMG", i + "");
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localURLDrawableOptions.mUseThreadPool = paramBoolean;
          return URLDrawable.getDrawable(localURL, localURLDrawableOptions);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          QLog.e("SystemAndEmojiEmoticonInfo", 1, "getSystemEmojiStaticImg url exception e = " + localMalformedURLException.getMessage());
        }
        localException = localException;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        QLog.e("SystemAndEmojiEmoticonInfo", 1, "SystemAndEmojiEmoticonInfo getdrawable exception e: = " + localException.getMessage());
      }
    }
    return null;
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
    for (paramContext = aylc.c(this.jdField_b_of_type_Int);; paramContext = aylc.a(this.jdField_b_of_type_Int))
    {
      localEditable.replace(i, j, paramContext);
      paramEditText.requestFocus();
      a(paramQQAppInterface, paramSessionInfo);
      if (this.jdField_b_of_type_Boolean) {
        axqy.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800717F", 0, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", "", "");
      }
      if ((paramQQAppInterface != null) && (aylc.a(this.jdField_b_of_type_Int)) && (paramSessionInfo != null)) {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "0X800812C", ApolloUtil.b(paramSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(this.jdField_b_of_type_Int), String.valueOf(airx.a(paramQQAppInterface)) });
      }
      anwr.a().a(this.jdField_a_of_type_Int).a(this.jdField_b_of_type_Int, 1);
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
        paramQQAppInterface = (anyc)paramQQAppInterface.getManager(172);
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
      localObject1 = aylc.a(this.jdField_b_of_type_Int, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aocu
 * JD-Core Version:    0.7.0.1
 */