package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class AnimationParam
  implements Parcelable
{
  public static final Parcelable.Creator<AnimationParam> CREATOR = new AnimationParam.1();
  public int a;
  public int b;
  public int c;
  public int d;
  private String e;
  private Drawable f;
  private boolean g;
  
  protected AnimationParam(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
  }
  
  public AnimationParam(@NonNull View paramView)
  {
    this(paramView, true);
  }
  
  public AnimationParam(@NonNull View paramView, boolean paramBoolean)
  {
    this.g = paramBoolean;
    Object localObject3 = new Rect();
    paramView.getGlobalVisibleRect((Rect)localObject3);
    if ((paramView instanceof ImageView))
    {
      localObject1 = ((ImageView)paramView).getDrawable();
      if (localObject1 != null)
      {
        localObject2 = ((Drawable)localObject1).getConstantState();
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label130;
        }
        this.a = (((Rect)localObject3).left + paramView.getPaddingLeft());
        this.b = (((Rect)localObject3).top + paramView.getPaddingTop());
        this.c = (paramView.getWidth() - paramView.getPaddingLeft() - paramView.getPaddingRight());
        this.d = (paramView.getHeight() - paramView.getPaddingTop() - paramView.getPaddingBottom());
        localObject1 = localObject2;
        break label130;
      }
    }
    Object localObject1 = null;
    label130:
    if (localObject1 == null)
    {
      this.a = ((Rect)localObject3).left;
      this.b = ((Rect)localObject3).top;
      this.c = paramView.getWidth();
      this.d = paramView.getHeight();
    }
    if (((Rect)localObject3).bottom < UIUtils.e(paramView.getContext())) {
      if (localObject1 != null) {
        this.b = (((Rect)localObject3).bottom - paramView.getHeight() + paramView.getPaddingTop());
      } else {
        this.b = (((Rect)localObject3).bottom - this.d);
      }
    }
    if (((Rect)localObject3).right < UIUtils.b(paramView.getContext())) {
      if (localObject1 != null) {
        this.a = (((Rect)localObject3).right - paramView.getWidth() + paramView.getPaddingLeft());
      } else {
        this.a = (((Rect)localObject3).right - this.c);
      }
    }
    Object localObject2 = (QQStoryManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.QQSTORY_MANAGER);
    if (localObject1 != null)
    {
      localObject3 = ((Drawable.ConstantState)localObject1).newDrawable();
      if ((localObject3 instanceof URLDrawable))
      {
        if (((URLDrawable)localObject3).getCurrDrawable() != null)
        {
          ((QQStoryManager)localObject2).m = ((Drawable.ConstantState)localObject1).newDrawable().mutate();
          this.e = String.valueOf(System.identityHashCode(((QQStoryManager)localObject2).m));
          SLog.a("Q.qqstory.playernew.AnimationParam", "getDrawableFromView, imageKey=%s, drawable=%s", this.e, localObject3);
        }
      }
      else
      {
        ((QQStoryManager)localObject2).m = ((Drawable.ConstantState)localObject1).newDrawable().mutate();
        this.e = String.valueOf(System.identityHashCode(((QQStoryManager)localObject2).m));
        SLog.a("Q.qqstory.playernew.AnimationParam", "getDrawableFromView, imageKey=%s, drawable=%s", this.e, localObject3);
      }
    }
    if (this.e == null)
    {
      paramView = BitmapUtils.a(paramView, this.c, this.d, 0, 0);
      if (paramView != null)
      {
        ((QQStoryManager)localObject2).m = new BitmapDrawable(paramView);
        this.e = String.valueOf(System.identityHashCode(((QQStoryManager)localObject2).m));
        SLog.a("Q.qqstory.playernew.AnimationParam", "getBitmapFromView, imageKey=%s, bitmap=%s, byteCount=%d", this.e, paramView, Integer.valueOf(paramView.getByteCount()));
      }
    }
  }
  
  public Drawable a()
  {
    if (!this.g) {
      return null;
    }
    Object localObject = this.f;
    if (localObject != null) {
      return localObject;
    }
    localObject = (QQStoryManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.QQSTORY_MANAGER);
    this.f = ((QQStoryManager)localObject).m;
    if (TextUtils.equals(String.valueOf(System.identityHashCode(this.f)), this.e)) {
      ((QQStoryManager)localObject).m = null;
    } else {
      this.f = null;
    }
    localObject = this.f;
    if (localObject != null) {
      return localObject;
    }
    localObject = new ColorDrawable(-13421773);
    this.f = ((Drawable)localObject);
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AnimationParam{positionX=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", positionY=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", viewWidth=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", viewHeight=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", imageKey='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam
 * JD-Core Version:    0.7.0.1
 */