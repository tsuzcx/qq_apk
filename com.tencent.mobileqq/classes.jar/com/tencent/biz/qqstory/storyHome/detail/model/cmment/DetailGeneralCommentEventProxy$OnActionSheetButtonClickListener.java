package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.lang.ref.WeakReference;

public class DetailGeneralCommentEventProxy$OnActionSheetButtonClickListener
  implements ActionSheet.OnButtonClickListener
{
  private final CommentEntry a;
  private final ActionSheet b;
  private final int c;
  private WeakReference<DetailGeneralCommentEventProxy.ActionSheetEventCallback> d;
  
  public DetailGeneralCommentEventProxy$OnActionSheetButtonClickListener(ActionSheet paramActionSheet, CommentEntry paramCommentEntry, int paramInt, DetailGeneralCommentEventProxy.ActionSheetEventCallback paramActionSheetEventCallback)
  {
    this.b = paramActionSheet;
    this.a = paramCommentEntry;
    this.c = paramInt;
    this.d = new WeakReference(paramActionSheetEventCallback);
  }
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.b.getContent(paramInt);
    SLog.a("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on action sheet item click. item is %s.", paramView);
    if (this.d.get() == null)
    {
      SLog.e("Q.qqstory.detail.DetailGeneralCommentEventProxy", "callback is null when action sheet item click.");
      return;
    }
    DetailGeneralCommentEventProxy.ActionSheetEventCallback localActionSheetEventCallback = (DetailGeneralCommentEventProxy.ActionSheetEventCallback)this.d.get();
    if (DetailGeneralCommentEventProxy.a.equals(paramView)) {
      localActionSheetEventCallback.b(this.c);
    } else if (DetailGeneralCommentEventProxy.b.equals(paramView)) {
      localActionSheetEventCallback.a(this.a, this.c);
    } else if (DetailGeneralCommentEventProxy.c.equals(paramView)) {
      localActionSheetEventCallback.a(this.a);
    } else if (DetailGeneralCommentEventProxy.d.equals(paramView)) {
      localActionSheetEventCallback.b(this.a);
    } else if (DetailGeneralCommentEventProxy.e.equals(paramView)) {
      localActionSheetEventCallback.c(this.a);
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener
 * JD-Core Version:    0.7.0.1
 */