package androidx.core.text;

class TextDirectionHeuristicsCompat$FirstStrong
  implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
{
  static final FirstStrong INSTANCE = new FirstStrong();
  
  public int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int j = 2;
    int i = paramInt1;
    while ((i < paramInt2 + paramInt1) && (j == 2))
    {
      j = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(paramCharSequence.charAt(i)));
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.text.TextDirectionHeuristicsCompat.FirstStrong
 * JD-Core Version:    0.7.0.1
 */