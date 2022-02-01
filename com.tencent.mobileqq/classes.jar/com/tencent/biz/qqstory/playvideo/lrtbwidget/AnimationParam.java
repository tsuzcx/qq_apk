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
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public int c;
  public int d;
  
  protected AnimationParam(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  public AnimationParam(@NonNull View paramView)
  {
    this(paramView, true);
  }
  
  public AnimationParam(@NonNull View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    Object localObject2 = new Rect();
    paramView.getGlobalVisibleRect((Rect)localObject2);
    Object localObject1;
    if ((paramView instanceof ImageView))
    {
      localObject1 = ((ImageView)paramView).getDrawable();
      if (localObject1 != null)
      {
        localObject1 = ((Drawable)localObject1).getConstantState();
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Int = (((Rect)localObject2).left + paramView.getPaddingLeft());
          this.b = (((Rect)localObject2).top + paramView.getPaddingTop());
          this.c = (paramView.getWidth() - paramView.getPaddingLeft() - paramView.getPaddingRight());
          this.d = (paramView.getHeight() - paramView.getPaddingTop() - paramView.getPaddingBottom());
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        this.jdField_a_of_type_Int = ((Rect)localObject2).left;
        this.b = ((Rect)localObject2).top;
        this.c = paramView.getWidth();
        this.d = paramView.getHeight();
      }
      label231:
      Drawable localDrawable;
      if (((Rect)localObject2).bottom < UIUtils.d(paramView.getContext()))
      {
        if (localObject1 != null) {
          this.b = (((Rect)localObject2).bottom - paramView.getHeight() + paramView.getPaddingTop());
        }
      }
      else
      {
        if (((Rect)localObject2).right < UIUtils.a(paramView.getContext()))
        {
          if (localObject1 == null) {
            break label411;
          }
          this.jdField_a_of_type_Int = (((Rect)localObject2).right - paramView.getWidth() + paramView.getPaddingLeft());
        }
        localObject2 = (QQStoryManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.QQSTORY_MANAGER);
        if (localObject1 != null)
        {
          localDrawable = ((Drawable.ConstantState)localObject1).newDrawable();
          if (!(localDrawable instanceof URLDrawable)) {
            break label428;
          }
          if (((URLDrawable)localDrawable).getCurrDrawable() != null)
          {
            ((QQStoryManager)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable.ConstantState)localObject1).newDrawable().mutate();
            this.jdField_a_of_type_JavaLangString = String.valueOf(System.identityHashCode(((QQStoryManager)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable));
            SLog.a("Q.qqstory.playernew.AnimationParam", "getDrawableFromView, imageKey=%s, drawable=%s", this.jdField_a_of_type_JavaLangString, localDrawable);
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          paramView = BitmapUtils.a(paramView, this.c, this.d, 0, 0);
          if (paramView != null)
          {
            ((QQStoryManager)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(paramView);
            this.jdField_a_of_type_JavaLangString = String.valueOf(System.identityHashCode(((QQStoryManager)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable));
            SLog.a("Q.qqstory.playernew.AnimationParam", "getBitmapFromView, imageKey=%s, bitmap=%s, byteCount=%d", this.jdField_a_of_type_JavaLangString, paramView, Integer.valueOf(paramView.getByteCount()));
          }
        }
        return;
        this.b = (((Rect)localObject2).bottom - this.d);
        break;
        label411:
        this.jdField_a_of_type_Int = (((Rect)localObject2).right - this.c);
        break label231;
        label428:
        ((QQStoryManager)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable.ConstantState)localObject1).newDrawable().mutate();
        this.jdField_a_of_type_JavaLangString = String.valueOf(System.identityHashCode(((QQStoryManager)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable));
        SLog.a("Q.qqstory.playernew.AnimationParam", "getDrawableFromView, imageKey=%s, drawable=%s", this.jdField_a_of_type_JavaLangString, localDrawable);
      }
      localObject1 = null;
    }
  }
  
  public Drawable a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    Object localObject = (QQStoryManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.QQSTORY_MANAGER);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((QQStoryManager)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (TextUtils.equals(String.valueOf(System.identityHashCode(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)), this.jdField_a_of_type_JavaLangString)) {
      ((QQStoryManager)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    while (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    localObject = new ColorDrawable(-13421773);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "AnimationParam{positionX=" + this.jdField_a_of_type_Int + ", positionY=" + this.b + ", viewWidth=" + this.c + ", viewHeight=" + this.d + ", imageKey='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam
 * JD-Core Version:    0.7.0.1
 */