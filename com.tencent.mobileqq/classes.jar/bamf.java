import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import com.tencent.qphone.base.util.QLog;

public class bamf
  extends SpannableStringBuilder
{
  public static Editable.Factory a;
  private int a;
  
  static
  {
    jdField_a_of_type_AndroidTextEditable$Factory = new bamg();
  }
  
  public bamf(CharSequence paramCharSequence, int paramInt)
  {
    super(a(paramCharSequence, paramInt));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    if ((paramCharSequence instanceof bamb)) {
      return ((bamb)paramCharSequence).a();
    }
    return new bamb(paramCharSequence, paramInt).a();
  }
  
  public SpannableStringBuilder replace(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, int paramInt4)
  {
    if (paramInt1 < 0) {
      j = 0;
    }
    for (;;)
    {
      try
      {
        k = length();
        if (paramInt2 > k)
        {
          paramInt1 = k;
          paramInt2 = paramInt1;
          if (paramInt1 < 0) {
            i = paramInt1;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        int k;
        Object localObject;
        QLog.e("ColorNick.EmoticonBuilder", 1, "QQTextBuilder.replace caused crash..text:" + toString() + ", replace text:" + paramCharSequence + " , " + j + "-" + paramInt2 + " , " + paramInt3 + "-" + paramInt4, localThrowable1);
        return new SpannableStringBuilder();
      }
      try
      {
        if (!QLog.isColorLevel()) {
          break label255;
        }
        i = paramInt1;
        QLog.w("ColorNick.EmoticonBuilder", 2, "selection error, start = " + j + " end = " + paramInt1 + " length = " + k);
      }
      catch (Throwable localThrowable2)
      {
        paramInt2 = i;
        continue;
        continue;
        paramInt2 = 0;
        continue;
      }
      i = paramInt2;
      if (paramCharSequence.length() <= 0) {
        break label252;
      }
      i = paramInt2;
      localObject = new bamb(paramCharSequence, this.jdField_a_of_type_Int).a();
      paramCharSequence = (CharSequence)localObject;
      try
      {
        localObject = super.replace(j, paramInt2, paramCharSequence, paramInt3, paramInt4);
        return localObject;
      }
      catch (Throwable localThrowable3)
      {
        continue;
      }
      j = paramInt1;
      continue;
      paramInt1 = paramInt2;
    }
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return super.subSequence(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamf
 * JD-Core Version:    0.7.0.1
 */