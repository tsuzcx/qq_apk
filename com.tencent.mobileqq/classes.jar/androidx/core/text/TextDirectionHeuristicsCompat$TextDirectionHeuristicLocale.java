package androidx.core.text;

import java.util.Locale;

class TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale
  extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
{
  static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();
  
  TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale()
  {
    super(null);
  }
  
  protected boolean defaultIsRtl()
  {
    return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale
 * JD-Core Version:    0.7.0.1
 */