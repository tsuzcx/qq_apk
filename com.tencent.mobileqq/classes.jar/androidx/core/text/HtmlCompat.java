package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.Spanned;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"InlinedApi"})
public final class HtmlCompat
{
  public static final int FROM_HTML_MODE_COMPACT = 63;
  public static final int FROM_HTML_MODE_LEGACY = 0;
  public static final int FROM_HTML_OPTION_USE_CSS_COLORS = 256;
  public static final int FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE = 32;
  public static final int FROM_HTML_SEPARATOR_LINE_BREAK_DIV = 16;
  public static final int FROM_HTML_SEPARATOR_LINE_BREAK_HEADING = 2;
  public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST = 8;
  public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM = 4;
  public static final int FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH = 1;
  public static final int TO_HTML_PARAGRAPH_LINES_CONSECUTIVE = 0;
  public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1;
  
  @NonNull
  public static Spanned fromHtml(@NonNull String paramString, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return Html.fromHtml(paramString, paramInt);
    }
    return Html.fromHtml(paramString);
  }
  
  @NonNull
  public static Spanned fromHtml(@NonNull String paramString, int paramInt, @Nullable Html.ImageGetter paramImageGetter, @Nullable Html.TagHandler paramTagHandler)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return Html.fromHtml(paramString, paramInt, paramImageGetter, paramTagHandler);
    }
    return Html.fromHtml(paramString, paramImageGetter, paramTagHandler);
  }
  
  @NonNull
  public static String toHtml(@NonNull Spanned paramSpanned, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return Html.toHtml(paramSpanned, paramInt);
    }
    return Html.toHtml(paramSpanned);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.text.HtmlCompat
 * JD-Core Version:    0.7.0.1
 */