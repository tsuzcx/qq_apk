package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import anzj;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import wwh;
import wwl;
import yuk;
import zps;

public class MsgNodeShotView
  extends StoryMsgNodeFrameLayout
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private wwl jdField_a_of_type_Wwl;
  
  public MsgNodeShotView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MsgNodeShotView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setDisplayState(4);
    d();
  }
  
  public String a()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
  }
  
  public wwl a()
  {
    return this.jdField_a_of_type_Wwl;
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130846656);
    }
    zps.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView, paramString, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, "msg_tab_thumb");
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    Object localObject = ((wwh)QQStoryContext.a().getManager(252)).a();
    if ((localObject != null) && (((wwl)localObject).a()))
    {
      this.jdField_a_of_type_Wwl = new wwl();
      this.jdField_a_of_type_Wwl.a((wwl)localObject);
      yuk.c("Q.qqstory.config.takevideo", "bindData config=" + ((wwl)localObject).b + " id=" + ((wwl)localObject).d);
      setNodeName(this.jdField_a_of_type_Wwl.b, false);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130846656);
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (this.jdField_a_of_type_Wwl.a.endsWith(".gif"))
      {
        ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "msg_tab_thumb";
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = zps.a(getContext(), 3.0F);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_b_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_Wwl.a, (URLDrawable.URLDrawableOptions)localObject);
        if ((((URLDrawable)localObject).getStatus() == 1) && (((URLDrawable)localObject).getCurrDrawable() != null))
        {
          yuk.a("Q.qqstory.msgTab.MsgNodeShotView", "setImageByURLDrawable() %s, %s, not start download!", this.jdField_a_of_type_Wwl.a, localObject);
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setImageDrawable((Drawable)localObject);
        }
      }
    }
    for (;;)
    {
      a(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      if ((((URLDrawable)localObject).getStatus() == 3) || (((URLDrawable)localObject).getStatus() == 2))
      {
        ((URLDrawable)localObject).restartDownload();
        break;
      }
      ((URLDrawable)localObject).startDownload();
      break;
      a(this.jdField_a_of_type_Wwl.a);
      continue;
      yuk.b("Q.qqstory.msgTab.MsgNodeShotView", "normal info");
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setImageResource(2130846656);
      setNodeName(anzj.a(2131705837), false);
      this.jdField_a_of_type_Wwl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgNodeShotView
 * JD-Core Version:    0.7.0.1
 */