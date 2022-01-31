import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ayqs
{
  public int a;
  public List<String> a;
  
  public ayqs(List<String> paramList, String paramString)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if ((paramString != null) && (!((List)localObject).contains(paramString))) {
      ((List)localObject).add(paramString);
    }
    Collections.sort((List)localObject, new ayqt(this));
    this.jdField_a_of_type_JavaUtilList = ((List)localObject);
  }
  
  public int a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return -1;
    }
    return paramString1.toLowerCase().indexOf(paramString2.toLowerCase(), paramInt);
  }
  
  public SpannableString a(CharSequence paramCharSequence)
  {
    return a(paramCharSequence, false, false);
  }
  
  public SpannableString a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    return a(paramCharSequence, paramBoolean, false);
  }
  
  public SpannableString a(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramCharSequence, paramBoolean1, paramBoolean2, true);
  }
  
  public SpannableString a(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject2;
    if (TextUtils.isEmpty(paramCharSequence))
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = new SpannableString(paramCharSequence);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return localObject1;
    }
    paramCharSequence = paramCharSequence.toString();
    Object[] arrayOfObject = this.jdField_a_of_type_JavaUtilList.toArray();
    this.jdField_a_of_type_Int = 0;
    int i = 0;
    int j = 0;
    int m = 0;
    String str;
    int k;
    for (;;)
    {
      localObject2 = localObject1;
      if (m >= arrayOfObject.length) {
        break;
      }
      str = (String)arrayOfObject[m];
      if (str.length() <= 1)
      {
        localObject2 = localObject1;
        if (j != 0) {
          break;
        }
      }
      k = 0;
      k = a(paramCharSequence, str, k);
      if (k != -1) {
        break label146;
      }
      m += 1;
    }
    label146:
    if ((paramBoolean3) && (k > 10) && (i == 0) && (!paramBoolean1))
    {
      localObject1 = "…" + paramCharSequence.substring(k - 6);
      paramCharSequence = new SpannableString((CharSequence)localObject1);
      i = 1;
      k = 7;
    }
    for (;;)
    {
      int n;
      if (paramBoolean2)
      {
        n = ((String)localObject1).indexOf(" ");
        int i1 = ((String)localObject1).indexOf(" ", n);
        if ((k < n) || (k > i1))
        {
          localObject2 = paramCharSequence;
          k += 1;
          paramCharSequence = (CharSequence)localObject1;
          localObject1 = localObject2;
          break;
        }
      }
      if (str.length() > 1)
      {
        j = 1;
        i = 1;
      }
      for (;;)
      {
        n = Color.parseColor("#00a5e0");
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
          n = Color.parseColor("#004080");
        }
        paramCharSequence.setSpan(new ForegroundColorSpan(n), k, str.length() + k, 34);
        this.jdField_a_of_type_Int += 1;
        localObject2 = paramCharSequence;
        k += 1;
        paramCharSequence = (CharSequence)localObject1;
        localObject1 = localObject2;
        break;
      }
      localObject2 = localObject1;
      localObject1 = paramCharSequence;
      paramCharSequence = (CharSequence)localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqs
 * JD-Core Version:    0.7.0.1
 */