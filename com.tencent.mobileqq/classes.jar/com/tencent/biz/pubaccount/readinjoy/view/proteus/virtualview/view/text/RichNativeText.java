package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyle;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.ImgNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.TextNode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class RichNativeText
  extends NativeText
{
  private static final String TAG = "RichNativeText";
  protected final Drawable GRAY_PLACEHOLDER = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private int maxFontSize = -1;
  private int maxLineHeight = -1;
  protected Node nodes;
  private final RichTextParser richTextParser;
  private int spaceHeight = 0;
  protected SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
  
  public RichNativeText(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mTextSize = Utils.dp2px(16.0D);
    this.richTextParser = new RichTextParser(paramVafContext.getContext());
  }
  
  private void dealImgNode(ImgNode paramImgNode, int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    Object localObject1 = paramImgNode.cssStyleSet.getCssStyleMap();
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
        localObject2 = ((CssStyle)((Map.Entry)localObject3).getValue()).styleName;
        localObject3 = ((CssStyle)((Map.Entry)localObject3).getValue()).styleValue;
        int i = -1;
        switch (((String)localObject2).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            break;
          case 0: 
            localRect.left = 0;
            localRect.right = ((Integer)localObject3).intValue();
            break;
            if (((String)localObject2).equals("width"))
            {
              i = 0;
              continue;
              if (((String)localObject2).equals("height"))
              {
                i = 1;
                continue;
                if (((String)localObject2).equals("display")) {
                  i = 2;
                }
              }
            }
            break;
          }
        }
        localRect.top = 0;
        localRect.bottom = ((Integer)localObject3).intValue();
        continue;
        if (("block".equals(localObject3)) && (this.spannableStringBuilder.length() > 0) && (this.spannableStringBuilder.charAt(this.spannableStringBuilder.length() - 1) != '\n')) {
          this.spannableStringBuilder.append('\n');
        }
      }
    }
    Object localObject2 = DrawableUtil.getDrawableFromNet(this.mContext.getContext(), paramImgNode.src, this.GRAY_PLACEHOLDER, this.GRAY_PLACEHOLDER, localRect.right, localRect.bottom, new RichNativeText.DrawableCallBack(this));
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = DrawableUtil.getDrawable(this.mContext.getContext(), paramImgNode.src, this.GRAY_PLACEHOLDER, this.GRAY_PLACEHOLDER);
      localObject1 = localObject2;
      if (localObject2 == null) {
        throw new IllegalArgumentException("请处理未知图片: " + paramImgNode.src);
      }
    }
    ((Drawable)localObject1).setBounds(localRect);
    paramImgNode = new RichNativeText.MyImageSpan(this, (Drawable)localObject1, 1);
    this.spannableStringBuilder.setSpan(paramImgNode, paramInt1, paramInt2, 33);
  }
  
  private void dealNodeItem(Node paramNode)
  {
    int i = this.spannableStringBuilder.length();
    if (i >= 0) {
      switch (paramNode.nodeType)
      {
      }
    }
    for (;;)
    {
      if (paramNode.children == null) {
        return;
      }
      paramNode = paramNode.children.iterator();
      while (paramNode.hasNext()) {
        dealNodeItem((Node)paramNode.next());
      }
      i = 0;
      break;
      this.spannableStringBuilder.append(((TextNode)paramNode).text);
      dealTextStyle(paramNode.cssStyleSet, i, this.spannableStringBuilder.length());
      continue;
      this.spannableStringBuilder.append(',');
      dealImgNode((ImgNode)paramNode, i, this.spannableStringBuilder.length());
    }
  }
  
  private void dealTextStyle(CssStyleSet paramCssStyleSet, int paramInt1, int paramInt2)
  {
    paramCssStyleSet = paramCssStyleSet.getCssStyleMap();
    if (paramCssStyleSet != null)
    {
      paramCssStyleSet = paramCssStyleSet.entrySet().iterator();
      while (paramCssStyleSet.hasNext())
      {
        Object localObject2 = (Map.Entry)paramCssStyleSet.next();
        Object localObject1 = ((CssStyle)((Map.Entry)localObject2).getValue()).styleName;
        localObject2 = ((CssStyle)((Map.Entry)localObject2).getValue()).styleValue;
        int i = -1;
        switch (((String)localObject1).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            break;
          case 0: 
            i = ((Integer)localObject2).intValue();
            if (i <= this.maxLineHeight) {
              break;
            }
            this.maxLineHeight = i;
            break;
            if (((String)localObject1).equals("line-height"))
            {
              i = 0;
              continue;
              if (((String)localObject1).equals("font-size"))
              {
                i = 1;
                continue;
                if (((String)localObject1).equals("color"))
                {
                  i = 2;
                  continue;
                  if (((String)localObject1).equals("font-weight"))
                  {
                    i = 3;
                    continue;
                    if (((String)localObject1).equals("-webkit-line-clamp"))
                    {
                      i = 4;
                      continue;
                      if (((String)localObject1).equals("display")) {
                        i = 5;
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        if (this.maxFontSize > ((Integer)localObject2).intValue()) {}
        for (i = this.maxFontSize;; i = ((Integer)localObject2).intValue())
        {
          this.maxFontSize = i;
          localObject1 = new AbsoluteSizeSpan(((Integer)localObject2).intValue());
          this.spannableStringBuilder.setSpan(localObject1, paramInt1, paramInt2, 33);
          break;
        }
        localObject1 = new ForegroundColorSpan(Color.parseColor((String)localObject2));
        this.spannableStringBuilder.setSpan(localObject1, paramInt1, paramInt2, 33);
        continue;
        if ("bold".equals(localObject2))
        {
          this.spannableStringBuilder.setSpan(new StyleSpan(1), paramInt1, paramInt2, 33);
          continue;
          this.mNative.setMaxLines(((Integer)localObject2).intValue());
        }
      }
    }
  }
  
  private void setRichText()
  {
    if (this.nodes != null)
    {
      this.maxLineHeight = -1;
      this.spaceHeight = 0;
      this.spannableStringBuilder = new SpannableStringBuilder();
      dealNodeItem(this.nodes);
      if ((this.maxLineHeight > 0) && (this.maxLineHeight > this.maxFontSize))
      {
        this.spaceHeight = (this.maxLineHeight - this.maxFontSize);
        this.mNative.setLineSpacing(this.spaceHeight, 1.0F);
      }
      setText(this.spannableStringBuilder);
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    setRichText();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramObject);
    }
    if ((paramObject instanceof JSONArray))
    {
      this.nodes = this.richTextParser.parse((JSONArray)paramObject);
      this.spannableStringBuilder = new SpannableStringBuilder();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.RichNativeText
 * JD-Core Version:    0.7.0.1
 */