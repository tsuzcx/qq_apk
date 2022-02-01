package com.tencent.biz.qqstory.videoplayer;

import android.app.Dialog;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class StoryPlayerCommentDialog
  extends ReportDialog
{
  public StoryInputBarView a;
  public StoryPlayerCommentDialog.CommentDialogListener a;
  
  public void show()
  {
    this.a.b();
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.videoplayer.StoryPlayerCommentDialog
 * JD-Core Version:    0.7.0.1
 */