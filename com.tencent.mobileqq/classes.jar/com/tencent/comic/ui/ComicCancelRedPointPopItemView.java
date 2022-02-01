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
  private static int[] jdField_a_of_type_ArrayOfInt = { 1996685314, 1996685315, 1996685316, 1996685317, 1996685318, 1996685319 };
  public int a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public ComicCancelRedPointPopItemData a;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
  private TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
  private TextView b = null;
  
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
    this.jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopItemData = null;
    this.jdField_a_of_type_Int = 0;
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(1996750869));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(1996750870));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(1996750868));
    this.b = ((TextView)findViewById(1996750876));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)findViewById(1996750864));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)findViewById(1996750865));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)findViewById(1996750866));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)findViewById(1996750873));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)findViewById(1996750874));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)findViewById(1996750875));
    paramContext = new Random();
    int i = paramContext.nextInt(jdField_a_of_type_ArrayOfInt.length);
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setImageResource(jdField_a_of_type_ArrayOfInt[i]);
    int j = paramContext.nextInt(2);
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int k = arrayOfInt.length;
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setImageResource(arrayOfInt[((j + 1 + i) % k)]);
    j = paramContext.nextInt(2);
    paramContext = jdField_a_of_type_ArrayOfInt;
    k = paramContext.length;
    int m = paramContext.length;
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setImageResource(paramContext[((i - (j + 1) + k) % m)]);
  }
  
  private void a(Context paramContext, String paramString)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(1996685323);
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localDrawable);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(new ComicCancelRedPointPopItemView.1(this, paramContext));
    paramString.startDownload();
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramString);
  }
  
  public void setData(ComicCancelRedPointPopItemData paramComicCancelRedPointPopItemData)
  {
    this.jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopItemData = paramComicCancelRedPointPopItemData;
    if (paramComicCancelRedPointPopItemData == null) {
      return;
    }
    a(getContext(), paramComicCancelRedPointPopItemData.coverImg);
    this.b.setText(paramComicCancelRedPointPopItemData.title);
    if (paramComicCancelRedPointPopItemData.friendNum <= 0L)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i = 0;
      Object localObject;
      for (;;)
      {
        localObject = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        int j;
        if (i < paramComicCancelRedPointPopItemData.friendNum) {
          j = 0;
        } else {
          j = 8;
        }
        ((ImageView)localObject).setVisibility(j);
        i += 1;
      }
      if (TextUtils.isEmpty(paramComicCancelRedPointPopItemData.text))
      {
        TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramComicCancelRedPointPopItemData.text);
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAndroidWidgetTextView.length)
    {
      if (i >= paramComicCancelRedPointPopItemData.tags.size())
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(0);
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText((CharSequence)paramComicCancelRedPointPopItemData.tags.get(i));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.ComicCancelRedPointPopItemView
 * JD-Core Version:    0.7.0.1
 */