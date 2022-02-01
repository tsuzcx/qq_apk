package com.tencent.comic.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.List;
import java.util.Random;

public class ComicCancelRedPointPopItemView
  extends FrameLayout
{
  private static int[] c = { 1996685314, 1996685315, 1996685316, 1996685317, 1996685318, 1996685319 };
  public ComicCancelRedPointPopItemData a = null;
  public int b = 0;
  private ImageView d = null;
  private ImageView[] e = new ImageView[3];
  private LinearLayout f = null;
  private TextView g = null;
  private TextView h = null;
  private TextView[] i = new TextView[3];
  
  public ComicCancelRedPointPopItemView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ComicCancelRedPointPopItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ComicCancelRedPointPopItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private String a(int paramInt, long paramLong)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramLong > 1L) {
          return "在看";
        }
        return "看过";
      }
      return "点赞";
    }
    return "收藏";
  }
  
  private void a(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(1996816385, this, true);
    this.d = ((ImageView)findViewById(1996750869));
    this.f = ((LinearLayout)findViewById(1996750870));
    this.g = ((TextView)findViewById(1996750868));
    this.h = ((TextView)findViewById(1996750876));
    this.e[0] = ((ImageView)findViewById(1996750864));
    this.e[1] = ((ImageView)findViewById(1996750865));
    this.e[2] = ((ImageView)findViewById(1996750866));
    this.i[0] = ((TextView)findViewById(1996750873));
    this.i[1] = ((TextView)findViewById(1996750874));
    this.i[2] = ((TextView)findViewById(1996750875));
    paramContext = new Random();
    int j = paramContext.nextInt(c.length);
    this.e[0].setImageResource(c[j]);
    int k = paramContext.nextInt(2);
    int[] arrayOfInt = c;
    int m = arrayOfInt.length;
    this.e[1].setImageResource(arrayOfInt[((k + 1 + j) % m)]);
    k = paramContext.nextInt(2);
    paramContext = c;
    m = paramContext.length;
    int n = paramContext.length;
    this.e[2].setImageResource(paramContext[((j - (k + 1) + m) % n)]);
  }
  
  private void a(Context paramContext, String paramString)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(1996685323);
    if (TextUtils.isEmpty(paramString))
    {
      this.d.setBackgroundDrawable(localDrawable);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(new ComicCancelRedPointPopItemView.1(this, paramContext));
    paramString.startDownload();
    this.d.setBackgroundDrawable(paramString);
  }
  
  public void setData(ComicCancelRedPointPopItemData paramComicCancelRedPointPopItemData)
  {
    this.a = paramComicCancelRedPointPopItemData;
    if (paramComicCancelRedPointPopItemData == null) {
      return;
    }
    a(getContext(), paramComicCancelRedPointPopItemData.coverImg);
    this.h.setText(paramComicCancelRedPointPopItemData.title);
    if (paramComicCancelRedPointPopItemData.friendNum <= 0L)
    {
      this.f.setVisibility(8);
    }
    else
    {
      this.f.setVisibility(0);
      j = 0;
      Object localObject;
      for (;;)
      {
        localObject = this.e;
        if (j >= localObject.length) {
          break;
        }
        localObject = localObject[j];
        int k;
        if (j < paramComicCancelRedPointPopItemData.friendNum) {
          k = 0;
        } else {
          k = 8;
        }
        ((ImageView)localObject).setVisibility(k);
        j += 1;
      }
      if (TextUtils.isEmpty(paramComicCancelRedPointPopItemData.text))
      {
        TextView localTextView = this.g;
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramComicCancelRedPointPopItemData.friendNum > 1L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramComicCancelRedPointPopItemData.friendNum);
          ((StringBuilder)localObject).append("位好友");
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = "好友刚刚";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(a(paramComicCancelRedPointPopItemData.behavior, paramComicCancelRedPointPopItemData.friendNum));
        localTextView.setText(localStringBuilder.toString());
      }
      else
      {
        this.g.setText(paramComicCancelRedPointPopItemData.text);
      }
    }
    int j = 0;
    while (j < this.i.length)
    {
      if (j >= paramComicCancelRedPointPopItemData.tags.size())
      {
        this.i[j].setVisibility(8);
      }
      else
      {
        this.i[j].setVisibility(0);
        this.i[j].setText((CharSequence)paramComicCancelRedPointPopItemData.tags.get(j));
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.ComicCancelRedPointPopItemView
 * JD-Core Version:    0.7.0.1
 */