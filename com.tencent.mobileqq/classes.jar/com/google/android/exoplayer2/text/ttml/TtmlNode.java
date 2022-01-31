package com.google.android.exoplayer2.text.ttml;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

final class TtmlNode
{
  public static final String ANONYMOUS_REGION_ID = "";
  public static final String ATTR_ID = "id";
  public static final String ATTR_TTS_BACKGROUND_COLOR = "backgroundColor";
  public static final String ATTR_TTS_COLOR = "color";
  public static final String ATTR_TTS_DISPLAY_ALIGN = "displayAlign";
  public static final String ATTR_TTS_EXTENT = "extent";
  public static final String ATTR_TTS_FONT_FAMILY = "fontFamily";
  public static final String ATTR_TTS_FONT_SIZE = "fontSize";
  public static final String ATTR_TTS_FONT_STYLE = "fontStyle";
  public static final String ATTR_TTS_FONT_WEIGHT = "fontWeight";
  public static final String ATTR_TTS_ORIGIN = "origin";
  public static final String ATTR_TTS_TEXT_ALIGN = "textAlign";
  public static final String ATTR_TTS_TEXT_DECORATION = "textDecoration";
  public static final String BOLD = "bold";
  public static final String CENTER = "center";
  public static final String END = "end";
  public static final String ITALIC = "italic";
  public static final String LEFT = "left";
  public static final String LINETHROUGH = "linethrough";
  public static final String NO_LINETHROUGH = "nolinethrough";
  public static final String NO_UNDERLINE = "nounderline";
  public static final String RIGHT = "right";
  public static final String START = "start";
  public static final String TAG_BODY = "body";
  public static final String TAG_BR = "br";
  public static final String TAG_DIV = "div";
  public static final String TAG_HEAD = "head";
  public static final String TAG_LAYOUT = "layout";
  public static final String TAG_METADATA = "metadata";
  public static final String TAG_P = "p";
  public static final String TAG_REGION = "region";
  public static final String TAG_SMPTE_DATA = "smpte:data";
  public static final String TAG_SMPTE_IMAGE = "smpte:image";
  public static final String TAG_SMPTE_INFORMATION = "smpte:information";
  public static final String TAG_SPAN = "span";
  public static final String TAG_STYLE = "style";
  public static final String TAG_STYLING = "styling";
  public static final String TAG_TT = "tt";
  public static final String UNDERLINE = "underline";
  private List<TtmlNode> children;
  public final long endTimeUs;
  public final boolean isTextNode;
  private final HashMap<String, Integer> nodeEndsByRegion;
  private final HashMap<String, Integer> nodeStartsByRegion;
  public final String regionId;
  public final long startTimeUs;
  public final TtmlStyle style;
  private final String[] styleIds;
  public final String tag;
  public final String text;
  
  private TtmlNode(String paramString1, String paramString2, long paramLong1, long paramLong2, TtmlStyle paramTtmlStyle, String[] paramArrayOfString, String paramString3)
  {
    this.tag = paramString1;
    this.text = paramString2;
    this.style = paramTtmlStyle;
    this.styleIds = paramArrayOfString;
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.isTextNode = bool;
      this.startTimeUs = paramLong1;
      this.endTimeUs = paramLong2;
      this.regionId = ((String)Assertions.checkNotNull(paramString3));
      this.nodeStartsByRegion = new HashMap();
      this.nodeEndsByRegion = new HashMap();
      return;
    }
  }
  
  private void applyStyleToOutput(Map<String, TtmlStyle> paramMap, SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramMap = TtmlRenderUtil.resolveStyle(this.style, this.styleIds, paramMap);
      if (paramMap != null) {
        TtmlRenderUtil.applyStylesToSpan(paramSpannableStringBuilder, paramInt1, paramInt2, paramMap);
      }
    }
  }
  
  public static TtmlNode buildNode(String paramString1, long paramLong1, long paramLong2, TtmlStyle paramTtmlStyle, String[] paramArrayOfString, String paramString2)
  {
    return new TtmlNode(paramString1, null, paramLong1, paramLong2, paramTtmlStyle, paramArrayOfString, paramString2);
  }
  
  public static TtmlNode buildTextNode(String paramString)
  {
    return new TtmlNode(null, TtmlRenderUtil.applyTextElementSpacePolicy(paramString), -9223372036854775807L, -9223372036854775807L, null, null, "");
  }
  
  private SpannableStringBuilder cleanUpText(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length();
    int j = 0;
    int k;
    if (j < i)
    {
      if (paramSpannableStringBuilder.charAt(j) != ' ') {
        break label306;
      }
      k = j + 1;
      while ((k < paramSpannableStringBuilder.length()) && (paramSpannableStringBuilder.charAt(k) == ' ')) {
        k += 1;
      }
      k -= j + 1;
      if (k <= 0) {
        break label306;
      }
      paramSpannableStringBuilder.delete(j, j + k);
      i -= k;
    }
    label306:
    for (;;)
    {
      j += 1;
      break;
      j = i;
      if (i > 0)
      {
        j = i;
        if (paramSpannableStringBuilder.charAt(0) == ' ')
        {
          paramSpannableStringBuilder.delete(0, 1);
          j = i - 1;
        }
      }
      i = j;
      j = 0;
      while (j < i - 1)
      {
        k = i;
        if (paramSpannableStringBuilder.charAt(j) == '\n')
        {
          k = i;
          if (paramSpannableStringBuilder.charAt(j + 1) == ' ')
          {
            paramSpannableStringBuilder.delete(j + 1, j + 2);
            k = i - 1;
          }
        }
        j += 1;
        i = k;
      }
      j = i;
      if (i > 0)
      {
        j = i;
        if (paramSpannableStringBuilder.charAt(i - 1) == ' ')
        {
          paramSpannableStringBuilder.delete(i - 1, i);
          j = i - 1;
        }
      }
      i = 0;
      while (i < j - 1)
      {
        k = j;
        if (paramSpannableStringBuilder.charAt(i) == ' ')
        {
          k = j;
          if (paramSpannableStringBuilder.charAt(i + 1) == '\n')
          {
            paramSpannableStringBuilder.delete(i, i + 1);
            k = j - 1;
          }
        }
        i += 1;
        j = k;
      }
      if ((j > 0) && (paramSpannableStringBuilder.charAt(j - 1) == '\n')) {
        paramSpannableStringBuilder.delete(j - 1, j);
      }
      return paramSpannableStringBuilder;
    }
  }
  
  private void getEventTimes(TreeSet<Long> paramTreeSet, boolean paramBoolean)
  {
    boolean bool2 = "p".equals(this.tag);
    if ((paramBoolean) || (bool2))
    {
      if (this.startTimeUs != -9223372036854775807L) {
        paramTreeSet.add(Long.valueOf(this.startTimeUs));
      }
      if (this.endTimeUs != -9223372036854775807L) {
        paramTreeSet.add(Long.valueOf(this.endTimeUs));
      }
    }
    if (this.children == null) {
      return;
    }
    int i = 0;
    label76:
    TtmlNode localTtmlNode;
    if (i < this.children.size())
    {
      localTtmlNode = (TtmlNode)this.children.get(i);
      if ((!paramBoolean) && (!bool2)) {
        break label131;
      }
    }
    label131:
    for (boolean bool1 = true;; bool1 = false)
    {
      localTtmlNode.getEventTimes(paramTreeSet, bool1);
      i += 1;
      break label76;
      break;
    }
  }
  
  private static SpannableStringBuilder getRegionOutput(String paramString, Map<String, SpannableStringBuilder> paramMap)
  {
    if (!paramMap.containsKey(paramString)) {
      paramMap.put(paramString, new SpannableStringBuilder());
    }
    return (SpannableStringBuilder)paramMap.get(paramString);
  }
  
  private void traverseForStyle(Map<String, TtmlStyle> paramMap, Map<String, SpannableStringBuilder> paramMap1)
  {
    Iterator localIterator = this.nodeEndsByRegion.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (this.nodeStartsByRegion.containsKey(str)) {}
      for (int i = ((Integer)this.nodeStartsByRegion.get(str)).intValue();; i = 0)
      {
        applyStyleToOutput(paramMap, (SpannableStringBuilder)paramMap1.get(str), i, ((Integer)localEntry.getValue()).intValue());
        i = 0;
        while (i < getChildCount())
        {
          getChild(i).traverseForStyle(paramMap, paramMap1);
          i += 1;
        }
        break;
      }
    }
  }
  
  private void traverseForText(long paramLong, boolean paramBoolean, String paramString, Map<String, SpannableStringBuilder> paramMap)
  {
    this.nodeStartsByRegion.clear();
    this.nodeEndsByRegion.clear();
    Object localObject2 = this.regionId;
    Object localObject1 = localObject2;
    if ("".equals(localObject2)) {
      localObject1 = paramString;
    }
    if ((this.isTextNode) && (paramBoolean)) {
      getRegionOutput((String)localObject1, paramMap).append(this.text);
    }
    for (;;)
    {
      return;
      if (("br".equals(this.tag)) && (paramBoolean))
      {
        getRegionOutput((String)localObject1, paramMap).append('\n');
        return;
      }
      if ((!"metadata".equals(this.tag)) && (isActive(paramLong)))
      {
        boolean bool2 = "p".equals(this.tag);
        paramString = paramMap.entrySet().iterator();
        while (paramString.hasNext())
        {
          localObject2 = (Map.Entry)paramString.next();
          this.nodeStartsByRegion.put(((Map.Entry)localObject2).getKey(), Integer.valueOf(((SpannableStringBuilder)((Map.Entry)localObject2).getValue()).length()));
        }
        int i = 0;
        if (i < getChildCount())
        {
          paramString = getChild(i);
          if ((paramBoolean) || (bool2)) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            paramString.traverseForText(paramLong, bool1, (String)localObject1, paramMap);
            i += 1;
            break;
          }
        }
        if (bool2) {
          TtmlRenderUtil.endParagraph(getRegionOutput((String)localObject1, paramMap));
        }
        paramString = paramMap.entrySet().iterator();
        while (paramString.hasNext())
        {
          paramMap = (Map.Entry)paramString.next();
          this.nodeEndsByRegion.put(paramMap.getKey(), Integer.valueOf(((SpannableStringBuilder)paramMap.getValue()).length()));
        }
      }
    }
  }
  
  public void addChild(TtmlNode paramTtmlNode)
  {
    if (this.children == null) {
      this.children = new ArrayList();
    }
    this.children.add(paramTtmlNode);
  }
  
  public TtmlNode getChild(int paramInt)
  {
    if (this.children == null) {
      throw new IndexOutOfBoundsException();
    }
    return (TtmlNode)this.children.get(paramInt);
  }
  
  public int getChildCount()
  {
    if (this.children == null) {
      return 0;
    }
    return this.children.size();
  }
  
  public List<Cue> getCues(long paramLong, Map<String, TtmlStyle> paramMap, Map<String, TtmlRegion> paramMap1)
  {
    Object localObject = new TreeMap();
    traverseForText(paramLong, false, this.regionId, (Map)localObject);
    traverseForStyle(paramMap, (Map)localObject);
    paramMap = new ArrayList();
    localObject = ((TreeMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      TtmlRegion localTtmlRegion = (TtmlRegion)paramMap1.get(localEntry.getKey());
      paramMap.add(new Cue(cleanUpText((SpannableStringBuilder)localEntry.getValue()), null, localTtmlRegion.line, localTtmlRegion.lineType, localTtmlRegion.lineAnchor, localTtmlRegion.position, -2147483648, localTtmlRegion.width));
    }
    return paramMap;
  }
  
  public long[] getEventTimesUs()
  {
    Object localObject = new TreeSet();
    getEventTimes((TreeSet)localObject, false);
    long[] arrayOfLong = new long[((TreeSet)localObject).size()];
    localObject = ((TreeSet)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfLong[i] = ((Long)((Iterator)localObject).next()).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public String[] getStyleIds()
  {
    return this.styleIds;
  }
  
  public boolean isActive(long paramLong)
  {
    return ((this.startTimeUs == -9223372036854775807L) && (this.endTimeUs == -9223372036854775807L)) || ((this.startTimeUs <= paramLong) && (this.endTimeUs == -9223372036854775807L)) || ((this.startTimeUs == -9223372036854775807L) && (paramLong < this.endTimeUs)) || ((this.startTimeUs <= paramLong) && (paramLong < this.endTimeUs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.text.ttml.TtmlNode
 * JD-Core Version:    0.7.0.1
 */