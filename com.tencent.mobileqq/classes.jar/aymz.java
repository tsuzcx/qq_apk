import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.TopicItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.UinItem;

public class aymz
{
  public static aymz a()
  {
    return aynb.a();
  }
  
  private boolean a(List<oidb_0xd9f.UinItem> paramList, oidb_0xd9f.UinItem paramUinItem)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramUinItem == null) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramList == null);
      bool1 = bool2;
    } while (paramList.size() == 0);
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramList.size()) {
        break;
      }
      if (((oidb_0xd9f.UinItem)paramList.get(i)).uint64_uin.get() == paramUinItem.uint64_uin.get()) {
        return true;
      }
      i += 1;
    }
  }
  
  public int a(TextView paramTextView, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return -2147483648;
    }
    float f2 = paramInt1;
    float f1 = f2;
    if (!TextUtils.isEmpty(paramString2)) {
      f1 = f2 + paramTextView.getPaint().measureText(paramString2);
    }
    f2 = f1;
    if (paramString3 != null)
    {
      f2 = f1;
      if (paramInt2 > 0)
      {
        f2 = f1;
        if (paramString3.length() >= paramInt2) {
          f2 = f1 + paramTextView.getPaint().measureText(paramString3.substring(0, paramInt2));
        }
      }
    }
    f1 = paramTextView.getPaint().measureText(paramString1);
    if (f2 >= paramTextView.getWidth()) {
      return -2147483648;
    }
    if (f1 + f2 >= paramTextView.getWidth()) {
      return (int)(f2 / 2.0F);
    }
    return paramTextView.getWidth() / 2 - (int)(f2 + f1 / 2.0F);
  }
  
  public int a(List<oidb_0xd9f.TopicItem> paramList)
  {
    int k;
    if ((paramList == null) || (paramList.size() <= 0))
    {
      k = 0;
      return k;
    }
    int j = 0;
    int i = 0;
    for (;;)
    {
      k = i;
      if (j >= paramList.size()) {
        break;
      }
      i += ((oidb_0xd9f.TopicItem)paramList.get(j)).uint32_frd_num.get();
      j += 1;
    }
  }
  
  public long a(List<oidb_0xd9f.TopicItem> paramList)
  {
    long l2 = -1L;
    long l1 = l2;
    if (paramList != null)
    {
      l1 = l2;
      if (paramList.size() > 0)
      {
        l1 = -1L;
        int i = 0;
        while (i < paramList.size())
        {
          l2 = l1;
          if (paramList.get(i) != null)
          {
            l2 = l1;
            if (((oidb_0xd9f.TopicItem)paramList.get(i)).rpt_frd_item.get() != null)
            {
              List localList = ((oidb_0xd9f.TopicItem)paramList.get(i)).rpt_frd_item.get();
              l2 = l1;
              if (localList != null)
              {
                int j = 0;
                for (;;)
                {
                  l2 = l1;
                  if (j >= localList.size()) {
                    break;
                  }
                  l2 = l1;
                  if (((oidb_0xd9f.UinItem)localList.get(j)).uint64_time.get() > l1) {
                    l2 = ((oidb_0xd9f.UinItem)localList.get(j)).uint64_time.get();
                  }
                  j += 1;
                  l1 = l2;
                }
              }
            }
          }
          i += 1;
          l1 = l2;
        }
      }
    }
    return l1;
  }
  
  public Pair<Integer, String> a(List<oidb_0xd9f.TopicItem> paramList)
  {
    int j = -1;
    String str1 = "";
    int i = j;
    String str2 = str1;
    int k;
    if (paramList != null)
    {
      i = j;
      str2 = str1;
      if (paramList.size() > 0)
      {
        k = 0;
        i = -1;
        if (k < paramList.size())
        {
          if (((oidb_0xd9f.TopicItem)paramList.get(k)).uint32_frd_num.get() < j) {
            break label162;
          }
          j = ((oidb_0xd9f.TopicItem)paramList.get(k)).uint32_topic_id.get();
          str1 = ((oidb_0xd9f.TopicItem)paramList.get(k)).str_topic.get();
          i = ((oidb_0xd9f.TopicItem)paramList.get(k)).uint32_frd_num.get();
        }
      }
    }
    for (;;)
    {
      int m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      str2 = str1;
      return new Pair(Integer.valueOf(i), str2);
      label162:
      m = i;
      i = j;
      j = m;
    }
  }
  
  public CharSequence a(aqje paramaqje)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = paramaqje.a().jdField_a_of_type_JavaUtilArrayList;
    localSpannableStringBuilder.append(paramaqje.a().jdField_a_of_type_JavaLangString);
    int i = 0;
    while (i < ((ArrayList)localObject).size()) {
      if (TextUtils.isEmpty(((aqjg)((ArrayList)localObject).get(i)).jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        int j = localSpannableStringBuilder.length();
        paramaqje = ((aqjg)((ArrayList)localObject).get(i)).jdField_a_of_type_JavaLangString;
        localObject = new ForegroundColorSpan(Color.parseColor("#4D94FF"));
        localSpannableStringBuilder.append(paramaqje);
        localSpannableStringBuilder.setSpan(localObject, j, paramaqje.length() + j, 33);
      }
    }
    return localSpannableStringBuilder;
  }
  
  public List<oidb_0xd9f.UinItem> a(List<oidb_0xd9f.TopicItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        if ((paramList.get(i) != null) && (((oidb_0xd9f.TopicItem)paramList.get(i)).rpt_frd_item.get() != null))
        {
          List localList = ((oidb_0xd9f.TopicItem)paramList.get(i)).rpt_frd_item.get();
          if (localList != null)
          {
            int j = 0;
            while (j < localList.size())
            {
              if (!a(localArrayList, (oidb_0xd9f.UinItem)localList.get(j)))
              {
                localArrayList.add(localList.get(j));
                if (localArrayList.size() >= 3) {
                  return localArrayList;
                }
              }
              j += 1;
            }
          }
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("has_shown_sig_with_topic_bubble", true).apply();
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit().putLong("common_topic_refresh_time", paramLong).apply();
  }
  
  public void a(QQAppInterface paramQQAppInterface, RichStatus paramRichStatus)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    String str = paramQQAppInterface.getString("sig_feed_id", "");
    if ((paramRichStatus == null) || (paramRichStatus.feedsId == null)) {
      if (a().a(str, ""))
      {
        paramQQAppInterface.edit().putString("sig_feed_id", "").apply();
        paramQQAppInterface.edit().putBoolean("common_topic_friend_list_should_show", true).apply();
      }
    }
    while (!a().a(str, paramRichStatus.feedsId)) {
      return;
    }
    paramQQAppInterface.edit().putString("sig_feed_id", paramRichStatus.feedsId).apply();
    paramQQAppInterface.edit().putBoolean("common_topic_friend_list_should_show", true).apply();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("has_shown_sig_with_topic_bubble", false);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    boolean bool = false;
    if (paramLong > paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getLong("common_topic_refresh_time", -1L))
    {
      a(paramQQAppInterface, paramLong);
      bool = true;
    }
    return bool;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (TextUtils.isEmpty(paramString1));
        bool1 = bool2;
      } while (TextUtils.isEmpty(paramString2));
      bool1 = bool2;
    } while (!paramString1.equals(paramString2));
    return false;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("common_topic_friend_list_should_show", false).apply();
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("common_topic_friend_list_should_show", true);
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    long l = apub.a().a(529, paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit().putLong("recommend_topic_version", l).apply();
  }
  
  public boolean c(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (apub.a().a(529, paramQQAppInterface.getCurrentAccountUin()) > paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getLong("recommend_topic_version", -1L)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymz
 * JD-Core Version:    0.7.0.1
 */