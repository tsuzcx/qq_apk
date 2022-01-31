package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.utils.DynamicUnitUtils;
import com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(14)
public class AnimationUtils
{
  public static Intent a(Intent paramIntent, View paramView, String paramString)
  {
    if ((paramIntent != null) && (paramView != null))
    {
      int[] arrayOfInt = new int[4];
      Object localObject = new Rect();
      paramView.getGlobalVisibleRect((Rect)localObject);
      arrayOfInt[0] = ((Rect)localObject).left;
      arrayOfInt[1] = ((Rect)localObject).top;
      arrayOfInt[2] = paramView.getWidth();
      arrayOfInt[3] = paramView.getHeight();
      if (((Rect)localObject).bottom < UIUtils.b(paramView.getContext())) {
        arrayOfInt[1] = (((Rect)localObject).bottom - arrayOfInt[3]);
      }
      if (((Rect)localObject).right < UIUtils.a(paramView.getContext())) {
        arrayOfInt[0] = (((Rect)localObject).right - arrayOfInt[2]);
      }
      paramIntent.putExtra("positionX", arrayOfInt[0]);
      paramIntent.putExtra("positionY", arrayOfInt[1]);
      paramIntent.putExtra("viewWidth", arrayOfInt[2]);
      paramIntent.putExtra("viewHeight", arrayOfInt[3]);
      localObject = (QQStoryManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(180);
      ((QQStoryManager)localObject).jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramView);
      if (!TextUtils.isEmpty(paramString))
      {
        paramView = BitmapUtils.a(paramView, arrayOfInt[2] / 2, arrayOfInt[3] / 2, 0, 0);
        if (paramView != null)
        {
          ((QQStoryManager)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new SoftReference(paramView));
          paramIntent.putExtra("viewImageKey", paramString);
        }
      }
    }
    return paramIntent;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, View paramView)
  {
    if (paramView != null)
    {
      a(paramIntent, paramView, paramView.getClass().getSimpleName());
      paramIntent.putExtra("need_image_animation", true);
      paramActivity.startActivity(paramIntent);
      paramActivity.overridePendingTransition(0, 0);
      return;
    }
    paramActivity.startActivity(paramIntent);
    paramActivity.overridePendingTransition(2131034336, 0);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, View paramView)
  {
    if (MsgTabStoryUtil.a())
    {
      if (paramView != null)
      {
        Rect localRect = new Rect();
        paramView.getGlobalVisibleRect(localRect);
        int i = localRect.left;
        int j = paramView.getWidth() / 2;
        int k = localRect.top;
        int m = paramView.getHeight() / 2;
        paramIntent.putExtra("EXTRA_CIRCULAR_REVEAL_START_RADIUS", paramView.getWidth() / 2);
        paramIntent.putExtra("EXTRA_CIRCULAR_REVEAL_X", i + j);
        paramIntent.putExtra("EXTRA_CIRCULAR_REVEAL_Y", k + m);
        paramIntent.putExtra("extra_transition_mode", 1);
        paramActivity.startActivity(paramIntent);
      }
      return;
    }
    paramIntent.putExtra("need_image_animation", false);
    paramActivity.startActivity(paramIntent);
    paramActivity.overridePendingTransition(2131034336, 2131034167);
  }
  
  public static void c(Activity paramActivity, Intent paramIntent, View paramView)
  {
    if (MsgTabStoryUtil.a())
    {
      Rect localRect;
      Object localObject;
      QQStoryManager localQQStoryManager;
      if (paramView != null)
      {
        localRect = new Rect();
        paramView.getGlobalVisibleRect(localRect);
        if ((paramView instanceof ImageView))
        {
          localObject = (ImageView)paramView;
          if (((ImageView)localObject).getDrawable() != null)
          {
            localObject = ((ImageView)localObject).getDrawable().getConstantState();
            if (localObject != null)
            {
              Drawable localDrawable = ((Drawable.ConstantState)localObject).newDrawable();
              localQQStoryManager = (QQStoryManager)PlayModeUtils.a().getManager(180);
              if (!(localDrawable instanceof URLDrawable)) {
                break label213;
              }
              if (((URLDrawable)localDrawable).getCurrDrawable() == null) {}
            }
          }
        }
      }
      label213:
      for (localQQStoryManager.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable.ConstantState)localObject).newDrawable().mutate();; localQQStoryManager.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable.ConstantState)localObject).newDrawable().mutate())
      {
        paramIntent.putExtra("EXTRA_RECT_REVEAL_LEFT", localRect.left + paramView.getPaddingLeft());
        paramIntent.putExtra("EXTRA_RECT_REVEAL_TOP", localRect.top + paramView.getPaddingTop());
        paramIntent.putExtra("EXTRA_RECT_REVEAL_WIDTH", localRect.width() - paramView.getPaddingLeft() - paramView.getPaddingRight());
        paramIntent.putExtra("EXTRA_RECT_REVEAL_HEIGHT", localRect.height() - paramView.getPaddingTop() - paramView.getPaddingBottom());
        paramIntent.putExtra("EXTRA_RECT_REVEAL_RADIUS", DynamicUnitUtils.a(8.0F));
        paramIntent.putExtra("extra_transition_mode", 2);
        paramActivity.startActivity(paramIntent);
        return;
      }
    }
    paramIntent.putExtra("need_image_animation", false);
    paramActivity.startActivity(paramIntent);
    paramActivity.overridePendingTransition(2131034336, 2131034167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.AnimationUtils
 * JD-Core Version:    0.7.0.1
 */