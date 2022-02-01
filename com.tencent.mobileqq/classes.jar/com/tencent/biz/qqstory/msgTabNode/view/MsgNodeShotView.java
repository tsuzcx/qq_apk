package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import anvx;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import wms;
import wmw;
import ykq;

public class MsgNodeShotView
  extends StoryMsgNodeFrameLayout
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private wmw jdField_a_of_type_Wmw;
  
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
  
  public wmw a()
  {
    return this.jdField_a_of_type_Wmw;
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130846660);
    }
    UIUtils.setImageByURLDrawable(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView, paramString, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, "msg_tab_thumb");
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    Object localObject = ((wms)QQStoryContext.a().getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a();
    if ((localObject != null) && (((wmw)localObject).a()))
    {
      this.jdField_a_of_type_Wmw = new wmw();
      this.jdField_a_of_type_Wmw.a((wmw)localObject);
      ykq.c("Q.qqstory.config.takevideo", "bindData config=" + ((wmw)localObject).b + " id=" + ((wmw)localObject).d);
      setNodeName(this.jdField_a_of_type_Wmw.b, false);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130846660);
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (this.jdField_a_of_type_Wmw.a.endsWith(".gif"))
      {
        ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "msg_tab_thumb";
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = UIUtils.dip2px(getContext(), 3.0F);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_b_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_Wmw.a, (URLDrawable.URLDrawableOptions)localObject);
        if ((((URLDrawable)localObject).getStatus() == 1) && (((URLDrawable)localObject).getCurrDrawable() != null))
        {
          ykq.a("Q.qqstory.msgTab.MsgNodeShotView", "setImageByURLDrawable() %s, %s, not start download!", this.jdField_a_of_type_Wmw.a, localObject);
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
      a(this.jdField_a_of_type_Wmw.a);
      continue;
      ykq.b("Q.qqstory.msgTab.MsgNodeShotView", "normal info");
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setImageResource(2130846660);
      setNodeName(anvx.a(2131706419), false);
      this.jdField_a_of_type_Wmw = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgNodeShotView
 * JD-Core Version:    0.7.0.1
 */