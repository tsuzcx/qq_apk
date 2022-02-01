package androidx.core.text;

import java.nio.CharBuffer;

abstract class TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
  implements TextDirectionHeuristicCompat
{
  private final TextDirectionHeuristicsCompat.TextDirectionAlgorithm mAlgorithm;
  
  TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat.TextDirectionAlgorithm paramTextDirectionAlgorithm)
  {
    this.mAlgorithm = paramTextDirectionAlgorithm;
  }
  
  private boolean doCheck(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramInt1 = this.mAlgorithm.checkRtl(paramCharSequence, paramInt1, paramInt2);
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return defaultIsRtl();
      }
      return false;
    }
    return true;
  }
  
  protected abstract boolean defaultIsRtl();
  
  public boolean isRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramInt2 >= 0) && (paramCharSequence.length() - paramInt2 >= paramInt1))
    {
      if (this.mAlgorithm == null) {
        return defaultIsRtl();
      }
      return doCheck(paramCharSequence, paramInt1, paramInt2);
    }
    throw new IllegalArgumentException();
  }
  
  public boolean isRtl(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return isRtl(CharBuffer.wrap(paramArrayOfChar), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
 * JD-Core Version:    0.7.0.1
 */