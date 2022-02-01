package androidx.core.text;

class BidiFormatter$DirectionalityEstimator
{
  private static final byte[] DIR_TYPE_CACHE = new byte[1792];
  private static final int DIR_TYPE_CACHE_SIZE = 1792;
  private int charIndex;
  private final boolean isHtml;
  private char lastChar;
  private final int length;
  private final CharSequence text;
  
  static
  {
    int i = 0;
    while (i < 1792)
    {
      DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
      i += 1;
    }
  }
  
  BidiFormatter$DirectionalityEstimator(CharSequence paramCharSequence, boolean paramBoolean)
  {
    this.text = paramCharSequence;
    this.isHtml = paramBoolean;
    this.length = paramCharSequence.length();
  }
  
  private static byte getCachedDirectionality(char paramChar)
  {
    if (paramChar < '܀') {
      return DIR_TYPE_CACHE[paramChar];
    }
    return Character.getDirectionality(paramChar);
  }
  
  private byte skipEntityBackward()
  {
    int i = this.charIndex;
    int j;
    do
    {
      j = this.charIndex;
      if (j <= 0) {
        break;
      }
      CharSequence localCharSequence = this.text;
      j -= 1;
      this.charIndex = j;
      this.lastChar = localCharSequence.charAt(j);
      j = this.lastChar;
      if (j == 38) {
        return 12;
      }
    } while (j != 59);
    this.charIndex = i;
    this.lastChar = ';';
    return 13;
  }
  
  private byte skipEntityForward()
  {
    char c;
    do
    {
      int i = this.charIndex;
      if (i >= this.length) {
        break;
      }
      CharSequence localCharSequence = this.text;
      this.charIndex = (i + 1);
      c = localCharSequence.charAt(i);
      this.lastChar = c;
    } while (c != ';');
    return 12;
  }
  
  private byte skipTagBackward()
  {
    int j = this.charIndex;
    CharSequence localCharSequence;
    do
    {
      k = this.charIndex;
      if (k <= 0) {
        break;
      }
      localCharSequence = this.text;
      k -= 1;
      this.charIndex = k;
      this.lastChar = localCharSequence.charAt(k);
      k = this.lastChar;
      if (k == 60) {
        return 12;
      }
      if (k == 62) {
        break;
      }
    } while ((k != 34) && (k != 39));
    int k = this.lastChar;
    for (;;)
    {
      int m = this.charIndex;
      if (m <= 0) {
        break;
      }
      localCharSequence = this.text;
      m -= 1;
      this.charIndex = m;
      int i = localCharSequence.charAt(m);
      this.lastChar = i;
      if (i == k) {
        break;
      }
    }
    this.charIndex = j;
    this.lastChar = '>';
    return 13;
  }
  
  private byte skipTagForward()
  {
    int j = this.charIndex;
    CharSequence localCharSequence;
    do
    {
      k = this.charIndex;
      if (k >= this.length) {
        break;
      }
      localCharSequence = this.text;
      this.charIndex = (k + 1);
      this.lastChar = localCharSequence.charAt(k);
      k = this.lastChar;
      if (k == 62) {
        return 12;
      }
    } while ((k != 34) && (k != 39));
    int k = this.lastChar;
    for (;;)
    {
      int m = this.charIndex;
      if (m >= this.length) {
        break;
      }
      localCharSequence = this.text;
      this.charIndex = (m + 1);
      int i = localCharSequence.charAt(m);
      this.lastChar = i;
      if (i == k) {
        break;
      }
    }
    this.charIndex = j;
    this.lastChar = '<';
    return 13;
  }
  
  byte dirTypeBackward()
  {
    this.lastChar = this.text.charAt(this.charIndex - 1);
    int i;
    if (Character.isLowSurrogate(this.lastChar))
    {
      i = Character.codePointBefore(this.text, this.charIndex);
      this.charIndex -= Character.charCount(i);
      return Character.getDirectionality(i);
    }
    this.charIndex -= 1;
    byte b2 = getCachedDirectionality(this.lastChar);
    byte b1 = b2;
    if (this.isHtml)
    {
      i = this.lastChar;
      if (i == 62) {
        return skipTagBackward();
      }
      b1 = b2;
      if (i == 59) {
        b1 = skipEntityBackward();
      }
    }
    return b1;
  }
  
  byte dirTypeForward()
  {
    this.lastChar = this.text.charAt(this.charIndex);
    int i;
    if (Character.isHighSurrogate(this.lastChar))
    {
      i = Character.codePointAt(this.text, this.charIndex);
      this.charIndex += Character.charCount(i);
      return Character.getDirectionality(i);
    }
    this.charIndex += 1;
    byte b2 = getCachedDirectionality(this.lastChar);
    byte b1 = b2;
    if (this.isHtml)
    {
      i = this.lastChar;
      if (i == 60) {
        return skipTagForward();
      }
      b1 = b2;
      if (i == 38) {
        b1 = skipEntityForward();
      }
    }
    return b1;
  }
  
  int getEntryDir()
  {
    this.charIndex = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    while ((this.charIndex < this.length) && (k == 0))
    {
      int m = dirTypeForward();
      if (m != 0)
      {
        if ((m != 1) && (m != 2))
        {
          if (m == 9) {}
        }
        else {
          switch (m)
          {
          default: 
            break;
          case 18: 
            i -= 1;
            j = 0;
            break;
          case 16: 
          case 17: 
            i += 1;
            j = 1;
            break;
          case 14: 
          case 15: 
            i += 1;
            j = -1;
            continue;
            if (i != 0) {
              break label134;
            }
            return 1;
          }
        }
      }
      else
      {
        if (i == 0) {
          return -1;
        }
        label134:
        k = i;
      }
    }
    if (k == 0) {
      return 0;
    }
    if (j != 0) {
      return j;
    }
    while (this.charIndex > 0) {
      switch (dirTypeBackward())
      {
      default: 
        break;
      case 18: 
        i += 1;
        break;
      case 16: 
      case 17: 
        if (k == i) {
          return 1;
        }
      case 14: 
      case 15: 
        if (k == i) {
          return -1;
        }
        i -= 1;
      }
    }
    return 0;
  }
  
  int getExitDir()
  {
    this.charIndex = this.length;
    int j = 0;
    int i = 0;
    while (this.charIndex > 0)
    {
      int k = dirTypeBackward();
      if (k != 0)
      {
        if ((k != 1) && (k != 2))
        {
          if (k == 9) {}
        }
        else {
          switch (k)
          {
          default: 
            if (j != 0) {
              continue;
            }
            break;
          case 18: 
            i += 1;
            break;
          case 16: 
          case 17: 
            if (j == i) {
              return 1;
            }
          case 14: 
          case 15: 
            if (j == i) {
              return -1;
            }
            i -= 1;
            continue;
            if (i == 0) {
              return 1;
            }
            if (j != 0) {
              continue;
            }
            break;
          }
        }
      }
      else
      {
        if (i == 0) {
          return -1;
        }
        if (j == 0) {
          j = i;
        }
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.text.BidiFormatter.DirectionalityEstimator
 * JD-Core Version:    0.7.0.1
 */